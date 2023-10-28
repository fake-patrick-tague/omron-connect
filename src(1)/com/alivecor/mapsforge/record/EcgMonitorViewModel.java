package com.alivecor.mapsforge.record;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.StatusPreference;
import androidx.lifecycle.s;
import com.alivecor.ai.u;
import com.alivecor.asm.Attribute;
import com.alivecor.asm.ClassifierData.b;
import com.alivecor.asm.Plot;
import com.alivecor.asm.Priority;
import com.alivecor.asm.Region;
import com.alivecor.asm.Series;
import com.alivecor.ecg.record.TriangleBluetoothWrapperClass.BLEConnectionState;
import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.mapsforge.core.model.Frame;
import com.alivecor.mapsforge.core.model.Handle;
import com.alivecor.mapsforge.core.model.MainsFilterFrequency;
import com.alivecor.universal_monitor.ECGMonitor;
import com.alivecor.universal_monitor.ECGMonitorCallback;
import com.alivecor.universal_monitor.LeadState;
import com.alivecor.universal_monitor.LeadValues;
import com.alivecor.universal_monitor.RecordingStatus;
import com.alivecor.universal_monitor.bluetooth.BluetoothDeviceProperties;
import com.alivecor.universal_monitor.bluetooth.configurations.BleUtil;
import com.alivecor.universal_monitor.devices.Device;
import com.alivecor.universal_monitor.devices.KardiaMobileDevice;
import com.alivecor.universal_monitor.devices.SakuraOneDevice;
import com.alivecor.universal_monitor.devices.TripodDevice;
import io.reactivex.i;
import io.reactivex.n;
import io.reactivex.r;
import java.io.File;
import java.util.Objects;
import k.a.a.f;

public class EcgMonitorViewModel
  extends androidx.lifecycle.Label
{
  private static final long IDLE_TIMEOUT_MS = 1000L;
  private static final String LOG_TAG = "EcgMonitorViewModel";
  private static final long TRIANGLE_MIN_BATTERY_PERCENT = 1L;
  AppPreferences appPreferences;
  Context applicationContext;
  private final s<Integer> beatOffsetsLiveData;
  private RecordResult completedRecordResult;
  private final s<Integer> currentHr;
  private final s<com.alivecor.ecg.core.model.d> deviceData;
  private Device ecgDevice;
  Attribute ecgEvaluator;
  private ECGMonitor ecgMonitor;
  private final s<Integer> elapsedRecTimeMs;
  private androidx.lifecycle.t<TriangleBluetoothWrapperClass.BLEConnectionState> errorOnTriangleError;
  private final s<c.h.p.d<LeadState, LeadState>> leadState;
  private String pairedTriangleAddress;
  private io.reactivex.v.b postRecordingProcess;
  private io.reactivex.v.b prepareToStart;
  private final s<LeadValues> previewValuesLiveData;
  private RecordingConfig recordingConfig;
  private RecordingError recordingError;
  private RecordingSettings recordingSettings;
  private final s<com.alivecor.ecg.record.EcgMonitorViewModel.State> recordingState;
  private Plot savedEvaluationResult;
  private final s<com.alivecor.ecg.record.RecordingSettings> settingsLiveData;
  private final s<Integer> signalPercent;
  s<com.alivecor.ecg.record.EcgMonitorViewModel.Tasks> task;
  private final s<String> triangleAddress;
  private final LiveData<Integer> triangleBattery;
  private androidx.lifecycle.t<Integer> triangleBatteryError;
  private final LiveData<TriangleBluetoothWrapperClass.BLEConnectionState> triangleConnectionState;
  private androidx.lifecycle.t<BluetoothDeviceProperties> trianglePropertiesObserver;
  private final TriangleBluetoothWrapperClass triangleWrapper;
  
  public EcgMonitorViewModel()
  {
    TriangleBluetoothWrapperClass localTriangleBluetoothWrapperClass = TriangleBluetoothWrapperClass.getInstance();
    triangleWrapper = localTriangleBluetoothWrapperClass;
    triangleConnectionState = localTriangleBluetoothWrapperClass.connectionState();
    triangleAddress = new StatusPreference();
    deviceData = new StatusPreference();
    recordingState = new StateLiveData(null);
    elapsedRecTimeMs = new StatusPreference();
    leadState = new StatusPreference();
    previewValuesLiveData = new StatusPreference();
    beatOffsetsLiveData = new StatusPreference();
    currentHr = new StatusPreference();
    signalPercent = new StatusPreference();
    settingsLiveData = new StatusPreference();
    triangleBattery = localTriangleBluetoothWrapperClass.triangleBattery();
    task = new StatusPreference();
    trianglePropertiesObserver = new androidx.lifecycle.Object()
    {
      public void onChanged(BluetoothDeviceProperties paramAnonymousBluetoothDeviceProperties)
      {
        if ((paramAnonymousBluetoothDeviceProperties != null) && (ecgMonitor != null))
        {
          ecgMonitor.setDeviceData(paramAnonymousBluetoothDeviceProperties.deviceData());
          ecgMonitor.setRecorderHardware(paramAnonymousBluetoothDeviceProperties.recorderHardware());
        }
        if (recordingConfig.selectedDevice == com.alivecor.mapsforge.core.model.c.deviceList)
        {
          deviceData.setValue(EcgMonitorViewModel.this.createTriangleData(paramAnonymousBluetoothDeviceProperties));
          return;
        }
        deviceData.setValue(EcgMonitorViewModel.this.createNonTriangleDeviceData());
      }
    };
    errorOnTriangleError = new PagerTitleStrip.PageListener(this);
    triangleBatteryError = new RecyclerView.1(this);
    RecordEkgConfig.getDB().getRecordDependencyComponent().inject(this);
    resetRecordingState();
  }
  
  private RecordingError checkRecordingPreconditions(RecordingConfig paramRecordingConfig, RecordingSettings paramRecordingSettings)
  {
    if (!PermissionsUtil.hasRecordAudio(applicationContext))
    {
      if (selectedDevice != com.alivecor.mapsforge.core.model.c.deviceList)
      {
        l.a.a.d("checkRecordingPreconditions: Non-Triangle Device Needs Audio", new Object[0]);
        return RecordingError.MIC_PERMISSION_EKG;
      }
      if (voiceEnabled) {
        return RecordingError.MIC_PERMISSION_VOICE;
      }
    }
    if (selectedDevice == com.alivecor.mapsforge.core.model.c.deviceList)
    {
      if (Build.VERSION.SDK_INT >= 31)
      {
        if (!PermissionsUtil.isBleEnabled(applicationContext).booleanValue())
        {
          l.a.a.d("checkRecordingPreconditions: Triangle Device Needs NEARBY_DEVICES_PERMISSION (BLUETOOTH_CONNECT, BLUETOOTH_SCAN).", new Object[0]);
          return RecordingError.NEARBY_DEVICES_PERMISSION;
        }
      }
      else if (!PermissionsUtil.hasFineLocation(applicationContext))
      {
        l.a.a.d("checkRecordingPreconditions: Triangle Device Needs Location Permission", new Object[0]);
        return RecordingError.LOCATION_PERMISSION;
      }
      if (!Util.isNetworkLocationEnabled((LocationManager)applicationContext.getSystemService("location")))
      {
        l.a.a.d("checkRecordingPreconditions: Triangle Device Needs Location Services ON", new Object[0]);
        return RecordingError.LOCATION_OFF;
      }
      if (!BleUtil.isBluetoothEnabled(applicationContext))
      {
        l.a.a.d("checkRecordingPreconditions: Triangle Device Needs Bluetooth ON", new Object[0]);
        return RecordingError.BLUETOOTH_OFF;
      }
    }
    if (Util.isNFCEnabled(applicationContext))
    {
      l.a.a.d("checkRecordingPreconditions: Recording Needs NFC OFF", new Object[0]);
      return RecordingError.NFC_ON;
    }
    return null;
  }
  
  private void clearRecordingPreviewState()
  {
    l.a.a.d("clearRecordingPreviewState: Nulling samples/record state stuff", new Object[0]);
    previewValuesLiveData.setValue(null);
    beatOffsetsLiveData.setValue(null);
    elapsedRecTimeMs.setValue(null);
    leadState.setValue(null);
    setCurrentHrValue(null);
  }
  
  private RecordResult convertToRecordResult(Plot paramPlot, String paramString1, String paramString2)
  {
    l.a.a.g("convertToRecordResult(): Evaluation Result: %s", new Object[] { paramPlot });
    l.a.a.a("convertToRecordResult(): Device Data: %s", new Object[] { deviceData });
    Direction localDirection = recordingConfig.deviceLeads;
    Object localObject = e;
    long l = ((k.a.a.r.d)localObject).y();
    int i = ((k.a.a.r.b)localObject).c().A(l);
    localObject = new RecordResult(g);
    ((RecordResult)localObject).setDateTimeUtcMillis(l);
    ((RecordResult)localObject).setLeadsConfig(localDirection);
    ((RecordResult)localObject).setOriginalPath(paramString1);
    ((RecordResult)localObject).setEnhancedPath(paramString2);
    ((RecordResult)localObject).setVoiceEnabled(recordingSettings.voiceEnabled);
    ((RecordResult)localObject).setTimezoneOffset(i);
    ((RecordResult)localObject).setAverageHeartRate(k);
    if (deviceData.getValue() != null)
    {
      ((RecordResult)localObject).setRecordingDeviceData((Frame)deviceData.getValue());
      ((RecordResult)localObject).setDeviceBluetoothAddress((String)triangleAddress.getValue());
    }
    paramString1 = (Series)paramPlot.a(u.class);
    if (paramString1 != null)
    {
      boolean bool;
      if (((Region)paramString1.newUTF8()).getHeight() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((RecordResult)localObject).setInverted(bool);
    }
    else
    {
      l.a.a.h("convertToRecordResult(): No inversion result", new Object[0]);
    }
    if (paramPlot.a(com.alivecor.ai.ClassifierData.class) == null)
    {
      l.a.a.g("convertToRecordResult(): Recording had mains noise and no classifier data.  Saving with 0 HR", new Object[0]);
    }
    else
    {
      l.a.a.g("convertToRecordResult(): Saving determination and HR", new Object[0]);
      paramPlot = (com.alivecor.asm.ClassifierData)paramPlot.a(com.alivecor.ai.ClassifierData.class);
      l.a.a.g("convertToRecordResult(): Classify Result %s", new Object[] { paramPlot });
      if ((paramPlot != null) && (paramPlot.newUTF8() != null))
      {
        paramPlot = ((ClassifierData.b)paramPlot.newUTF8()).getDetermination();
      }
      else
      {
        l.a.a.h("convertToRecordResult(): No/Bad Classify Result: %s", new Object[] { paramPlot });
        paramPlot = Priority.Off;
      }
      if (Util.oneOf(paramPlot, new Object[] { Priority.Low, Priority.Normal, Priority.High, Priority.Off })) {
        l.a.a.g("convertToRecordResult(): Skipping HR for determination %s", new Object[] { paramPlot });
      }
    }
    l.a.a.d(LOG_TAG, new Object[] { "convertToRecordResult() saved EcgRecord %s", localObject });
    return localObject;
  }
  
  private Device createAcousticDevice()
  {
    Object localObject = recordingConfig;
    l.a.a.d("createAcousticDevice: Creating %s with leads %s", new Object[] { selectedDevice, deviceLeads });
    int i = 3.$SwitchMap$com$alivecor$ecg$core$model$RecordingDevice[recordingConfig.selectedDevice.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return new TripodDevice();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Selected Device ");
        ((StringBuilder)localObject).append(recordingConfig.selectedDevice);
        ((StringBuilder)localObject).append(" not supported or is bluetooth");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      return new SakuraOneDevice();
    }
    return new KardiaMobileDevice();
  }
  
  private ECGMonitor createEcgMonitor(Device paramDevice, int paramInt, boolean paramBoolean)
  {
    l.a.a.d("createEcgMonitor: Device %s, Audio: %b", new Object[] { paramDevice, Boolean.valueOf(paramBoolean) });
    String str = applicationContext.getPackageName();
    Object localObject1 = applicationContext.getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(str, 0);
      str = versionName;
      localObject1 = LOG_TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Ecg file path : ");
      ((StringBuilder)localObject2).append(com.alivecor.mapsforge.core.asm.b.write().getPath());
      Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = com.alivecor.mapsforge.core.asm.b.write().getPath();
      localObject2 = Build.MODEL;
      RecordingSettings localRecordingSettings = recordingSettings;
      return new ECGMonitor(paramDevice, (String)localObject1, "", (String)localObject2, str, paramInt, paramBoolean, previewFilter, minRecDurationMs, maxRecDurationMs, createMonitorCallback());
    }
    catch (PackageManager.NameNotFoundException paramDevice)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Couldn't find own package: ");
      ((StringBuilder)localObject1).append(str);
      throw new RuntimeException(((StringBuilder)localObject1).toString(), paramDevice);
    }
  }
  
  private ECGMonitorCallback createMonitorCallback()
  {
    return new EcgMonitorViewModel.2(this);
  }
  
  private Frame createNonTriangleDeviceData()
  {
    Frame localFrame = new Frame();
    int i = 3.$SwitchMap$com$alivecor$ecg$core$model$RecordingDevice[recordingConfig.selectedDevice.ordinal()];
    Handle localHandle;
    if (i != 1)
    {
      if (i != 2) {
        localHandle = Handle.RIGHT;
      } else {
        localHandle = Handle.TOP_RIGHT;
      }
    }
    else {
      localHandle = Handle.BOTTOM_RIGHT;
    }
    localFrame.a(localHandle);
    l.a.a.d("createNonTriangleDeviceData(): Created Non-Triangle Device data: %s", new Object[] { localFrame });
    return localFrame;
  }
  
  private Frame createTriangleData(BluetoothDeviceProperties paramBluetoothDeviceProperties)
  {
    Frame localFrame = new Frame();
    localFrame.a(Handle.TOP);
    if (paramBluetoothDeviceProperties != null)
    {
      localFrame.b(hardwareRevision);
      localFrame.c(firmwareRevision);
      localFrame.a(serialNumber);
      int i = ((Integer)triangleBattery.getValue()).intValue();
      if (i != -1) {
        localFrame.set(Float.valueOf(i));
      }
    }
    l.a.a.d("createTriangleData(): Created Triangle Device data: %s", new Object[] { localFrame });
    return localFrame;
  }
  
  private r initAndCheck(RecordingConfig paramRecordingConfig, RecordingSettings paramRecordingSettings)
  {
    return r.o(paramRecordingSettings).v(io.reactivex.b0.a.b()).q(io.reactivex.u.b.a.a()).i(new Salsa20Engine(this, paramRecordingSettings)).m(new ClassMarshaller.1(this, paramRecordingConfig));
  }
  
  private void initNewMonitor(Device paramDevice)
  {
    l.a.a.a("initMonitor()", new Object[0]);
    ecgDevice = paramDevice;
    ecgMonitor = createEcgMonitor(paramDevice, recordingSettings.mainsFreq.languageIndex, isRecordAudio());
  }
  
  private void onError(RecordingError paramRecordingError)
  {
    l.a.a.b("onError: %s", new Object[] { paramRecordingError });
    shutdownMonitor();
    recordingError = paramRecordingError;
    recordingState.setValue(State.ERROR);
    task.setValue(Tasks.ON_RECORDING_ERROR);
  }
  
  private r prepareTriangleRecording(RecordingConfig paramRecordingConfig, RecordingSettings paramRecordingSettings)
  {
    Object localObject = getPairedTriangleAddress();
    Objects.requireNonNull(paramRecordingConfig);
    l.a.a.a("prepareTriangleRecording: Called for %s.  Restrict? %b", new Object[] { localObject, Boolean.FALSE });
    localObject = triangleWrapper.scanForDevices().m(new k(paramRecordingConfig, (String)localObject)).n();
    TriangleBluetoothWrapperClass localTriangleBluetoothWrapperClass = triangleWrapper;
    Objects.requireNonNull(localTriangleBluetoothWrapperClass);
    localObject = ((i)localObject).l(new ObjectContainerBase.3(localTriangleBluetoothWrapperClass)).i(new c(this)).m(new Predicates.AndPredicate(this, paramRecordingConfig));
    return initAndCheck(paramRecordingConfig, paramRecordingSettings).w().c((io.reactivex.t)localObject);
  }
  
  private r processRecording(RecordingStatus paramRecordingStatus, String paramString1, String paramString2, String paramString3)
  {
    return r.n(new Preferences.1(this, paramString1, paramString2)).p(new Functions.FunctionComposition(paramRecordingStatus, paramString1, paramString2)).i(RevFilter.MERGE_BASE).v(io.reactivex.b0.a.a());
  }
  
  private void setCurrentHrValue(Integer paramInteger)
  {
    currentHr.setValue(paramInteger);
    task.setValue(Tasks.ON_CURRENT_BPM_UPDATED);
  }
  
  private void shutdownMonitor()
  {
    l.a.a.a("shutdownMonitor()", new Object[0]);
    triangleWrapper.deviceProperties().removeObserver(trianglePropertiesObserver);
    triangleWrapper.connectionState().removeObserver(errorOnTriangleError);
    triangleWrapper.triangleBattery().removeObserver(triangleBatteryError);
    Object localObject = prepareToStart;
    if (localObject != null) {
      ((io.reactivex.v.b)localObject).e();
    }
    if (postRecordingProcess != null)
    {
      l.a.a.a("Stopping a post-recording process", new Object[0]);
      postRecordingProcess.e();
    }
    localObject = ecgDevice;
    if (localObject != null) {
      ((Device)localObject).stopCapturing();
    }
    localObject = ecgMonitor;
    if (localObject != null) {
      ((ECGMonitor)localObject).stop();
    }
    triangleWrapper.dispose();
    localObject = ecgDevice;
    if (localObject != null)
    {
      ((Device)localObject).dispose();
      ecgDevice = null;
    }
    localObject = ecgMonitor;
    if (localObject != null)
    {
      ((ECGMonitor)localObject).dispose();
      ecgMonitor = null;
    }
  }
  
  private void validateRecordingConfigOrThrow(RecordingConfig paramRecordingConfig)
  {
    if (paramRecordingConfig != null)
    {
      com.alivecor.mapsforge.core.model.c localC = selectedDevice;
      if ((localC != null) && (localC != com.alivecor.mapsforge.core.model.c.b))
      {
        Direction localDirection = deviceLeads;
        if (localDirection != null)
        {
          if (localDirection != Direction.W) {
            return;
          }
          if (localC == com.alivecor.mapsforge.core.model.c.deviceList) {
            return;
          }
        }
        throw new IllegalArgumentException(String.format("Invalid RecordingConfig: Device %s cannot have leads config %s", new Object[] { selectedDevice, deviceLeads }));
      }
      else
      {
        throw new IllegalArgumentException(String.format("Invalid RecordingConfig: selectedDevice must not be %s", new Object[] { selectedDevice }));
      }
    }
    else
    {
      throw new IllegalArgumentException("Recording config can not be null.");
    }
  }
  
  public LiveData beatOffsets()
  {
    return beatOffsetsLiveData;
  }
  
  public LiveData bleConnectionState()
  {
    return triangleConnectionState;
  }
  
  public void confirmRecording()
  {
    recordingState.setValue(State.EVALUATION_READY);
    task.setValue(Tasks.POST_EVALUATION_RESULT);
  }
  
  public LiveData currentHr()
  {
    return currentHr;
  }
  
  public LiveData deviceData()
  {
    return deviceData;
  }
  
  public LiveData elapsedRecTimeMs()
  {
    return elapsedRecTimeMs;
  }
  
  public RecordingError error()
  {
    return recordingError;
  }
  
  protected String getPairedTriangleAddress()
  {
    if (pairedTriangleAddress == null) {
      pairedTriangleAddress = appPreferences.getOptionSelectedTriangleDevice();
    }
    return pairedTriangleAddress;
  }
  
  public RecordResult getRecordResult()
  {
    return completedRecordResult;
  }
  
  public RecordingConfig getRecordingConfig()
  {
    return recordingConfig;
  }
  
  protected Plot getSavedEvaluationResult()
  {
    return savedEvaluationResult;
  }
  
  protected boolean isRecordAudio()
  {
    return recordingSettings.voiceEnabled;
  }
  
  public LiveData leadState()
  {
    return leadState;
  }
  
  public void onCleared()
  {
    l.a.a.d("onCleared()", new Object[0]);
    stop();
    super.onCleared();
  }
  
  public LiveData previewValues()
  {
    return previewValuesLiveData;
  }
  
  public LiveData recordingSettings()
  {
    return settingsLiveData;
  }
  
  public void resetRecordingState()
  {
    l.a.a.a("resetRecordingState()", new Object[0]);
    task.setValue(Tasks.RECORDING_INITIALIZED);
    recordingConfig = null;
    recordingSettings = null;
    recordingState.setValue(State.IDLE);
    recordingError = null;
    savedEvaluationResult = null;
    beatOffsetsLiveData.setValue(null);
    previewValuesLiveData.setValue(null);
    triangleAddress.setValue(null);
    elapsedRecTimeMs.setValue(null);
    leadState.setValue(null);
    setCurrentHrValue(null);
  }
  
  public void restart()
  {
    RecordingConfig localRecordingConfig = recordingConfig;
    if (localRecordingConfig == null)
    {
      l.a.a.h("restart(): Called without recording config.  Call start() first", new Object[0]);
      return;
    }
    RecordingSettings localRecordingSettings = recordingSettings;
    stop();
    start(localRecordingConfig, localRecordingSettings);
  }
  
  protected void setPairedTriangleAddress(String paramString)
  {
    pairedTriangleAddress = paramString;
  }
  
  public LiveData signalPercent()
  {
    return signalPercent;
  }
  
  protected void start(RecordingConfig paramRecordingConfig, RecordingSettings paramRecordingSettings)
  {
    l.a.a.a("start(): Recording Config: %s", new Object[] { paramRecordingConfig });
    l.a.a.a("start(): Recording Settings: %s", new Object[] { paramRecordingSettings });
    validateRecordingConfigOrThrow(paramRecordingConfig);
    recordingConfig = paramRecordingConfig;
    recordingSettings = paramRecordingSettings;
    io.reactivex.v.b localB;
    if (selectedDevice == com.alivecor.mapsforge.core.model.c.deviceList)
    {
      localB = prepareToStart;
      if ((localB != null) && (!localB.h()))
      {
        l.a.a.d("start(): called while preparing.  Abandoning old prep and starting from Scan", new Object[0]);
        prepareToStart.e();
        shutdownMonitor();
      }
      l.a.a.d("start(): Starting scan for Triangle", new Object[0]);
      triangleWrapper.deviceProperties().observeForever(trianglePropertiesObserver);
      triangleWrapper.connectionState().observeForever(errorOnTriangleError);
      triangleWrapper.triangleBattery().observeForever(triangleBatteryError);
      task.setValue(Tasks.RECORDING_INITIALIZED);
      recordingState.setValue(State.STARTING);
      paramRecordingConfig = prepareTriangleRecording(paramRecordingConfig, paramRecordingSettings).q(io.reactivex.u.b.a.a()).g(new BaseMenuPresenter(this)).t(new ServerSettingsActivity_.IntentBuilder_(this), new ByteVector(this));
    }
    else
    {
      task.setValue(Tasks.RECORDING_INITIALIZED);
      recordingState.setValue(State.STARTING);
      localB = prepareToStart;
      if ((localB != null) && (!localB.h()))
      {
        l.a.a.d("start(): Called while starting.  Abandoning old prep task", new Object[0]);
        prepareToStart.e();
      }
      paramRecordingConfig = initAndCheck(paramRecordingConfig, paramRecordingSettings).q(io.reactivex.u.b.a.a()).g(new Server(this)).t(new Point(this), new Item(this, paramRecordingConfig));
    }
    prepareToStart = paramRecordingConfig;
  }
  
  public LiveData state()
  {
    return recordingState;
  }
  
  void stop()
  {
    State localState = (State)state().getValue();
    l.a.a.a("stop(): called in state %s", new Object[] { localState });
    if (localState != State.IDLE)
    {
      shutdownMonitor();
      resetRecordingState();
      return;
    }
    l.a.a.h("stop(): Already IDLE.  Skipping.", new Object[0]);
  }
  
  public LiveData triangleAddress()
  {
    return triangleAddress;
  }
  
  public LiveData triangleBatteryLevel()
  {
    return triangleBattery;
  }
  
  class RecordPreconditionException
    extends Exception
  {
    public RecordPreconditionException()
    {
      super();
    }
  }
  
  public enum State
  {
    static
    {
      State localState1 = new State("IDLE", 0);
      IDLE = localState1;
      State localState2 = new State("STARTING", 1);
      STARTING = localState2;
      State localState3 = new State("LISTENING", 2);
      LISTENING = localState3;
      State localState4 = new State("PRE_CAPTURING", 3);
      PRE_CAPTURING = localState4;
      State localState5 = new State("CAPTURING", 4);
      CAPTURING = localState5;
      State localState6 = new State("EVALUATING", 5);
      EVALUATING = localState6;
      State localState7 = new State("SAVING_DISK", 6);
      SAVING_DISK = localState7;
      State localState8 = new State("EVALUATION_NEED_CONFIRM", 7);
      EVALUATION_NEED_CONFIRM = localState8;
      State localState9 = new State("EVALUATION_READY", 8);
      EVALUATION_READY = localState9;
      State localState10 = new State("ERROR", 9);
      ERROR = localState10;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5, localState6, localState7, localState8, localState9, localState10 };
    }
  }
  
  class StateLiveData
    extends s<com.alivecor.ecg.record.EcgMonitorViewModel.State>
  {
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    
    private StateLiveData() {}
    
    protected void onActive()
    {
      l.a.a.a("Active Observer on State", new Object[0]);
      mainHandler.removeCallbacksAndMessages(null);
    }
    
    protected void onInactive()
    {
      l.a.a.a("No active observers on State.  Timing out in %d ms", new Object[] { Long.valueOf(1000L) });
      mainHandler.postDelayed(new FileBrowser.10(this), 1000L);
    }
  }
  
  public enum Tasks
  {
    static
    {
      Tasks localTasks1 = new Tasks("RECORDING_INITIALIZED", 0);
      RECORDING_INITIALIZED = localTasks1;
      Tasks localTasks2 = new Tasks("POST_EVALUATION_RESULT", 1);
      POST_EVALUATION_RESULT = localTasks2;
      Tasks localTasks3 = new Tasks("ON_RECORDING_ERROR", 2);
      ON_RECORDING_ERROR = localTasks3;
      Tasks localTasks4 = new Tasks("ON_USER_CANCELLED", 3);
      ON_USER_CANCELLED = localTasks4;
      Tasks localTasks5 = new Tasks("ON_CHANGE_DEVICE", 4);
      ON_CHANGE_DEVICE = localTasks5;
      Tasks localTasks6 = new Tasks("ON_CURRENT_BPM_UPDATED", 5);
      ON_CURRENT_BPM_UPDATED = localTasks6;
      $VALUES = new Tasks[] { localTasks1, localTasks2, localTasks3, localTasks4, localTasks5, localTasks6 };
    }
  }
}
