package com.alivecor.mapsforge.record;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.package_11.Fragment;
import androidx.fragment.package_11.FragmentActivity;
import androidx.fragment.package_11.FragmentManager;
import androidx.fragment.package_11.Item;
import androidx.lifecycle.ClassReader;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.StatusPreference;
import com.alivecor.alivecorkitlite.R.color;
import com.alivecor.alivecorkitlite.R.drawable;
import com.alivecor.alivecorkitlite.R.id;
import com.alivecor.alivecorkitlite.R.layout;
import com.alivecor.alivecorkitlite.R.menu;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.asm.ClassifierData.b;
import com.alivecor.asm.Label;
import com.alivecor.asm.Plot;
import com.alivecor.asm.Priority;
import com.alivecor.ecg.core.model.d;
import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.mapsforge.core.model.MainsFilterFrequency;
import com.alivecor.mapsforge.core.model.YAxisScaleTypes;
import com.alivecor.mapsforge.core.model.c;
import com.alivecor.universal_monitor.Filter;
import com.alivecor.universal_monitor.LeadState;
import com.alivecor.universal_monitor.LeadValues;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest.Builder;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.Task;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import l.a.a;
import v7.v7.util.Position;

abstract class FragEcgRealtime
  extends Fragment
{
  private static final String ARG_DEVICE = "recording_device";
  private static final String ARG_NEED_DEVICE_PROMPT = "need_device_prompt";
  private static final String ARG_RECORDING_TYPE = "recording_type";
  private static final String ARG_RESTRICT_SCAN_TRIANGLE = "restrict_scan_triangle";
  protected static final String ARG_UI_CONFIG = "ui_config";
  private static final float SIX_LEAD_GRID_SCALE = 0.6F;
  private final int REQ_LOC_ENABLE = 300;
  private View actionBar;
  AppPreferences appPreferences;
  int battery = 0;
  LiveData<com.alivecor.ecg.record.TriangleBluetoothWrapperClass.BLEConnectionState> bleConnectionState;
  private BroadcastReceiver bluetoothStateReciever;
  private View btnNeedHelp;
  TextView debugView;
  private Direction deviceLeads;
  EcgRealTimeView ecgAvfView;
  EcgRealTimeView ecgAvlView;
  EcgRealTimeView ecgAvrView;
  View ecgContainer;
  EcgGridView ecgGridView;
  EcgRealTimeView ecgLead1View;
  EcgRealTimeView ecgLead2View;
  EcgRealTimeView ecgLead3View;
  EcgRealTimeView ecgSingleLeadView;
  ViewGroup ecgSixLeadView;
  View header;
  RecordingHelpUrls helpUrls;
  private View hudFragmentContainer;
  View imgBeats;
  View imgTimerCheckmark;
  private boolean isReportRawPDF;
  private RadioGroup leadSelection;
  private View leadSelectionContainer;
  protected Context mContext;
  private int mainRecFrequency;
  ImageView meterImg;
  TextView meterLabel;
  private View panelFirstEcg;
  private View panelFirstEcgError;
  private View panelFirstEcgHelp;
  ProgressDialog progress;
  Util.ProgressDrawableCircle progressDrawable;
  RecordDependencyComponent recordDependencyComponent;
  LiveData<d> recordingDeviceData;
  private int recordingMaxDurations;
  private int recordingMinDurations;
  private RecordingType recordingType;
  private boolean restrictScanTriangle;
  private c selectedDevice;
  private Filter selectedFilter;
  private boolean syncHeldForRecording;
  View timerProgress;
  TextView title;
  LiveData<Integer> triangleBattery;
  private boolean triangleScanFailed;
  TextView txtBeatsCount;
  TextView txtTimer;
  private final Handler unbindHandler = new Handler();
  private EcgMonitorViewModel viewModel;
  private boolean voiceEnabled;
  private int yAxisScale;
  
  FragEcgRealtime() {}
  
  private void annotationUpdated(Integer paramInteger)
  {
    if (paramInteger != null) {
      ecgSingleLeadView.addAnnotation(paramInteger.intValue());
    }
  }
  
  protected static Bundle argumentsToBundle(c paramC, Direction paramDirection, Filter paramFilter, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString, RecordingHelpUrls paramRecordingHelpUrls)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", paramString);
    localBundle.putSerializable("com.alivecor.ecg.record.device", paramC);
    localBundle.putSerializable("com.alivecor.ecg.record.EXTRA_LEADS_CONFIG", paramDirection);
    localBundle.putSerializable("com.alivecor.ecg.record.EXTRA_RECORDING_FILTER_TYPE", paramFilter);
    localBundle.putInt("com.alivecor.ecg.record.EXTRA_RECORDING_MAX_DURATIONS", paramInt1);
    localBundle.putInt("com.alivecor.ecg.record.EXTRA_RECORDING_MIN_DURATIONS", paramInt2);
    localBundle.putInt("com.alivecor.ecg.record.EXTRA_RECORDING_FREQUENCY", paramInt3);
    localBundle.putBoolean("com.alivecor.ecg.record.EXTRA_VOICE_ENABLED", paramBoolean);
    localBundle.putSerializable("com.alivecor.ecg.record.HELP_URLS", paramRecordingHelpUrls);
    return localBundle;
  }
  
  private void clearEcgStrips()
  {
    a.g("clearEcgStrips()", new Object[0]);
    ecgSingleLeadView.resetECG();
    ecgLead1View.resetECG();
    ecgLead2View.resetECG();
    ecgLead3View.resetECG();
    ecgAvfView.resetECG();
    ecgAvrView.resetECG();
    ecgAvlView.resetECG();
  }
  
  private void confirmAnalysisResult(Plot paramPlot)
  {
    a.d("handleAnalysisResult: %s", new Object[] { paramPlot });
    Object localObject;
    int i;
    if (q)
    {
      localObject = progress;
      if (localObject != null) {
        ((Dialog)localObject).dismiss();
      }
      hudFragmentContainer.setVisibility(0);
      hudFragmentContainer.animate().alpha(1.0F).start();
      localObject = helpUrls;
      if ((localObject != null) && (!TextUtils.isEmpty(mainsNoise))) {
        localObject = helpUrls.mainsNoise;
      } else {
        localObject = Urls.getFullUrl("app-redirect/i-need-help-electrical-interference");
      }
      i = R.string.recording_error_mains_title;
    }
    for (int j = R.string.recording_error_mains_message;; j = R.string.recording_error_noise_message)
    {
      for (paramPlot = PostRecordingErrorFragment.create(paramPlot, i, j, (String)localObject);; paramPlot = PostRecordingErrorFragment.create(paramPlot, R.string.recording_error_short_title, i, (String)localObject))
      {
        replaceHudFragment(paramPlot);
        return;
        if (paramPlot.a(com.alivecor.ai.ClassifierData.class) == null) {
          return;
        }
        localObject = ((ClassifierData.b)((com.alivecor.asm.ClassifierData)paramPlot.a(com.alivecor.ai.ClassifierData.class)).newUTF8()).getDetermination();
        if (localObject != Priority.Normal) {
          break;
        }
        localObject = progress;
        if (localObject != null) {
          ((Dialog)localObject).dismiss();
        }
        enableGearButton(false);
        hudFragmentContainer.setVisibility(0);
        hudFragmentContainer.animate().alpha(1.0F).start();
        i = R.string.recording_error_short_message;
        localObject = helpUrls;
        if ((localObject != null) && (!TextUtils.isEmpty(shortRecording))) {
          localObject = helpUrls.shortRecording;
        } else {
          localObject = Urls.getFullUrl("app-redirect/i-need-help-too-short");
        }
      }
      if (localObject != Priority.Low) {
        break;
      }
      localObject = progress;
      if (localObject != null) {
        ((Dialog)localObject).dismiss();
      }
      enableGearButton(false);
      hudFragmentContainer.setVisibility(0);
      hudFragmentContainer.animate().alpha(1.0F).start();
      localObject = helpUrls;
      if ((localObject != null) && (!TextUtils.isEmpty(unreadableRecording))) {
        localObject = helpUrls.unreadableRecording;
      } else {
        localObject = Urls.getFullUrl("app-redirect/i-need-help-unreadable");
      }
      i = R.string.recording_error_noise_title;
    }
    a.b("confirmAnalysisResult: CALLED FOR VALID RESULT %s", new Object[] { paramPlot });
  }
  
  private BroadcastReceiver createBluetoothStateReceiver()
  {
    return new FragEcgRealtime.3(this);
  }
  
  private String createDebugString(String paramString, int paramInt, TriangleBluetoothWrapperClass.BLEConnectionState paramBLEConnectionState)
  {
    return String.format(Locale.ROOT, "BLE State for %s: %s Battery: %d", new Object[] { paramString, paramBLEConnectionState, Integer.valueOf(paramInt) });
  }
  
  private Fragment createIntroHudFragment(c paramC)
  {
    int i = 4.$SwitchMap$com$alivecor$ecg$core$model$RecordingDevice[paramC.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return new KardiaMobileIntroFragment();
      }
      paramC = (RecordUiConfig)requireArguments().getSerializable("ui_config");
      return SakuraOneIntroFragment.create(requireArguments().getString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", null), paramC);
    }
    paramC = new TriangleIntroFragment();
    RecordUiConfig localRecordUiConfig = (RecordUiConfig)requireArguments().getSerializable("ui_config");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("ui_config", localRecordUiConfig);
    localBundle.putSerializable("com.alivecor.ecg.record.HELP_URLS", helpUrls);
    paramC.setArguments(localBundle);
    paramC.leadConfigUpdated(deviceLeads);
    return paramC;
  }
  
  private void dismissProgressDialog()
  {
    ProgressDialog localProgressDialog = progress;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing()))
    {
      progress.dismiss();
      progress = null;
    }
  }
  
  private void enableGearButton(boolean paramBoolean)
  {
    Object localObject = actionBar.findViewById(R.id.convert_actionbar_right_btn);
    if (localObject != null) {
      ((View)localObject).setEnabled(paramBoolean);
    }
    localObject = (ImageView)actionBar.findViewById(R.id.convert_actionbar_right_img);
    if (localObject != null) {
      ((View)localObject).setEnabled(paramBoolean);
    }
  }
  
  private void enterCapturing()
  {
    showEcgTrace();
    if (!requireArguments().getBoolean("com.alivecor.ecg.record.EXTRA_HIDE_TRACE")) {
      hudFragmentContainer.animate().alpha(0.0F).setInterpolator(new AccelerateInterpolator());
    }
    progressDrawable.setColor(getResources().getColor(R.color.kardia_gray_light));
    progressDrawable.animate(1.0F, 2500L);
    txtTimer.setText(formatTimerString(getRecordViewModelrecordingSettingsgetValuemaxRecDurationMs / 1000));
    Integer localInteger = (Integer)viewModel.signalPercent().getValue();
    a.a("enterCapturing(): Setting Signal Percent %d", new Object[] { localInteger });
    if (localInteger != null) {
      updateSignalStrength(localInteger);
    }
  }
  
  private void enterPreCapturing()
  {
    clearEcgStrips();
    showEcgTrace();
    if (!requireArguments().getBoolean("com.alivecor.ecg.record.EXTRA_HIDE_TRACE")) {
      hudFragmentContainer.animate().alpha(0.0F).setInterpolator(new AccelerateInterpolator());
    }
    progressDrawable.setColor(getResources().getColor(R.color.kardia_gray_light));
    progressDrawable.animate(1.0F, 2500L);
    txtTimer.setText(formatTimerString(getRecordViewModelrecordingSettingsgetValuemaxRecDurationMs / 1000));
  }
  
  private void enterRecordState(EcgMonitorViewModel.State paramState)
  {
    a.a("entered record state %s", new Object[] { paramState });
    setLeadSelectionEnabled(true);
    switch (4.$SwitchMap$com$alivecor$ecg$record$EcgMonitorViewModel$State[paramState.ordinal()])
    {
    default: 
      return;
    case 2: 
      return;
    case 10: 
      handleRecordError(getRecordViewModel().error());
      return;
    case 9: 
      dismissProgressDialog();
      return;
    case 8: 
      dismissProgressDialog();
      confirmAnalysisResult(viewModel.getSavedEvaluationResult());
      return;
    case 6: 
    case 7: 
      playCompletedAnimation(null);
      showSaveEcgProgress();
      return;
    case 5: 
      enterCapturing();
      return;
    case 4: 
      enterPreCapturing();
      return;
    case 3: 
      clearEcgStrips();
      progressDrawable.animate(0.0F, 800L);
      hudFragmentContainer.animate().alpha(1.0F).start();
      break;
    case 1: 
      resetRecordingUi();
    }
    replaceHudFragment(createIntroHudFragment(selectedDevice));
  }
  
  private Fragment findHudFragment()
  {
    return getChildFragmentManager().findFragmentById(R.id.frag_ecg_realtime_hud_container);
  }
  
  private static String formatTimerString(int paramInt)
  {
    if (paramInt >= 60) {
      return String.format(Locale.US, "%d:%02d", new Object[] { Integer.valueOf(paramInt / 60), Integer.valueOf(paramInt % 60) });
    }
    return String.format(Locale.US, "%d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private String getTitleString()
  {
    int i;
    if (deviceLeads == Direction.S) {
      i = R.string.record_ekg_title_single_lead;
    } else {
      i = R.string.record_ekg_title_six_lead;
    }
    return getString(i);
  }
  
  private void handleRecordError(RecordingError paramRecordingError)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a3 = a2\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  private void hideEcgTrace()
  {
    Direction localDirection = deviceLeads;
    if (localDirection == null)
    {
      a.a("showEcgTrace: Called before leads config updated.  Skipping", new Object[0]);
      return;
    }
    if (localDirection == Direction.W)
    {
      ecgSixLeadView.setVisibility(8);
      return;
    }
    ecgSingleLeadView.setVisibility(8);
  }
  
  private boolean isMonitorIdle()
  {
    return getRecordViewModel().state().getValue() == EcgMonitorViewModel.State.IDLE;
  }
  
  private void leadValuesUpdated(LeadValues paramLeadValues)
  {
    if (paramLeadValues == null) {
      return;
    }
    ecgSingleLeadView.pushEcgSample(leadI);
    ecgLead1View.pushEcgSample(leadI);
    ecgLead2View.pushEcgSample(leadII);
    ecgLead3View.pushEcgSample(leadIII);
    ecgAvfView.pushEcgSample(myBufferOffset);
    ecgAvlView.pushEcgSample(tempo);
    ecgAvrView.pushEcgSample(storevar);
  }
  
  private void observeMonitor()
  {
    a.d("observeMonitor()", new Object[0]);
    EcgMonitorViewModel localEcgMonitorViewModel = getRecordViewModel();
    LiveData localLiveData = localEcgMonitorViewModel.triangleBatteryLevel();
    triangleBattery = localLiveData;
    localLiveData.observe(getViewLifecycleOwner(), new Statistics.1(this));
    localLiveData = localEcgMonitorViewModel.bleConnectionState();
    bleConnectionState = localLiveData;
    localLiveData.observe(getViewLifecycleOwner(), new SearchResultsActivity.1(this));
    recordingDeviceData = localEcgMonitorViewModel.deviceData();
    localEcgMonitorViewModel.state().observe(getViewLifecycleOwner(), new NoteEditor.4(this));
    localEcgMonitorViewModel.elapsedRecTimeMs().observe(getViewLifecycleOwner(), new ElevationTile(this));
    localEcgMonitorViewModel.leadState().observe(getViewLifecycleOwner(), new Dialogs.9(this));
    localEcgMonitorViewModel.previewValues().observe(getViewLifecycleOwner(), new Stats.1(this));
    localEcgMonitorViewModel.beatOffsets().observe(getViewLifecycleOwner(), new FileChooserActivity.1(this));
    localEcgMonitorViewModel.currentHr().observe(getViewLifecycleOwner(), new KeyboardSwitcher.1(this));
    localEcgMonitorViewModel.signalPercent().observe(getViewLifecycleOwner(), new AbstractTreeIterator(this));
    localEcgMonitorViewModel.recordingSettings().observe(getViewLifecycleOwner(), new StandardShowcaseDrawer(this));
  }
  
  private void onBeatDetected()
  {
    imgBeats.animate().scaleX(1.3F).scaleY(1.3F).setDuration(50L).withEndAction(new FileBrowser.11(this)).start();
  }
  
  private void onBluetoothLoss()
  {
    handleRecordError(RecordingError.BLUETOOTH_OFF);
  }
  
  private void onHrUpdated(Integer paramInteger)
  {
    int i = Util.unboxOr(paramInteger, 0);
    txtBeatsCount.setText(Util.formatHeartRateString(Integer.valueOf(i).intValue()));
    onBeatDetected();
  }
  
  private void onLeadsStateUpdated(LeadState paramLeadState1, LeadState paramLeadState2)
  {
    LeadState localLeadState = LeadState.SUBSCRIBED;
    if ((paramLeadState1 == localLeadState) && (paramLeadState2 == localLeadState))
    {
      a.g("Leads both OFF.  Clearing ECG Grid", new Object[0]);
      clearEcgStrips();
    }
  }
  
  private void onLeadsStateUpdated(Position paramPosition)
  {
    a.g("onLeadsStateUpdated: %s", new Object[] { paramPosition });
    Object localObject = paramPosition;
    if (paramPosition == null)
    {
      a.h("onLeadsStateUpdated: No data.  Defaulting to OFF", new Object[0]);
      paramPosition = LeadState.SUBSCRIBED;
      localObject = new Position(paramPosition, paramPosition);
    }
    paramPosition = (LeadState)a;
    Objects.requireNonNull(paramPosition);
    paramPosition = (LeadState)paramPosition;
    localObject = (LeadState)x;
    Objects.requireNonNull(localObject);
    onLeadsStateUpdated(paramPosition, (LeadState)localObject);
  }
  
  private void onTimeElapsed(Integer paramInteger)
  {
    paramInteger = Integer.valueOf(Util.unboxOr(paramInteger, 0));
    RecordingSettings localRecordingSettings = (RecordingSettings)getRecordViewModel().recordingSettings().getValue();
    if (localRecordingSettings == null)
    {
      a.a("onTimeElapsed: Recording settings not available yet", new Object[0]);
      return;
    }
    int i = maxRecDurationMs;
    int j = paramInteger.intValue();
    txtTimer.setText(formatTimerString((i - j) / 1000));
    progressDrawable.setColor(mContext.getResources().getColor(R.color.kardia_teal));
    progressDrawable.setProgress(paramInteger.intValue(), maxRecDurationMs);
  }
  
  private void removeHudFragment()
  {
    a.a("removeHudFragment", new Object[0]);
    Fragment localFragment = getChildFragmentManager().findFragmentById(R.id.frag_ecg_realtime_hud_container);
    if (localFragment != null) {
      getChildFragmentManager().beginTransaction().add(localFragment).commit();
    }
  }
  
  private void replaceHudFragment(Fragment paramFragment)
  {
    a.a("replaceHudFragment: %s", new Object[] { paramFragment });
    getChildFragmentManager().beginTransaction().add(R.id.frag_ecg_realtime_hud_container, paramFragment).commitAllowingStateLoss();
    hideEcgTrace();
  }
  
  private void resetFromBeginning()
  {
    a.d("Resetting from state: %s", new Object[] { getRecordViewModel().state().getValue() });
    resetRecordingUi();
    restartMonitor();
  }
  
  private void resetRecordingUi()
  {
    a.g("resetRecordingUi: selectedDevice: %s", new Object[] { selectedDevice });
    Object localObject1 = progress;
    if (localObject1 != null)
    {
      ((Dialog)localObject1).dismiss();
      progress = null;
    }
    title.setText(getTitleString());
    removeHudFragment();
    enableGearButton(true);
    Object localObject2 = selectedDevice;
    localObject1 = c.J;
    if (localObject2 == localObject1)
    {
      ((TextView)getView().findViewById(R.id.frag_ecg_realtime_first_ecg_keep_fingers)).setText(R.string.ecg_realtime_first_ecg_keep_fingers_sakura);
      ((TextView)getView().findViewById(R.id.frag_ecg_realtime_first_ecg_rec_instructions_howto_start)).setText(R.string.ecg_realtime_help_sakura_3);
      getView().findViewById(R.id.frag_ecg_realtime_first_ecg_rec_instructions_info).setVisibility(8);
      getView().findViewById(R.id.frag_ecg_realtime_first_ecg_rec_instructions_upsell).setVisibility(8);
      getView().findViewById(R.id.frag_ecg_realtime_first_ecg_help_get_kardia).setVisibility(8);
      getView().findViewById(R.id.frag_ecg_realtime_first_ecg_help_need_help).setVisibility(8);
    }
    txtTimer.setVisibility(0);
    imgTimerCheckmark.setVisibility(8);
    localObject2 = (RecordingSettings)getRecordViewModel().recordingSettings().getValue();
    if (localObject2 != null) {
      txtTimer.setText(formatTimerString(maxRecDurationMs / 1000));
    }
    progressDrawable.setProgress(0.0F);
    txtBeatsCount.setText(Util.formatHeartRateString(0.0F));
    hudFragmentContainer.setVisibility(0);
    hudFragmentContainer.animate().alpha(1.0F).setInterpolator(new AccelerateInterpolator()).start();
    panelFirstEcgError.setVisibility(8);
    c localC = selectedDevice;
    localObject2 = c.deviceList;
    if (localC == localObject2)
    {
      leadSelectionContainer.setVisibility(0);
      leadSelection.setVisibility(0);
      int i;
      if (deviceLeads == Direction.W)
      {
        localObject1 = leadSelection;
        i = R.id.frag_ecg_realtime_six_lead;
      }
      else
      {
        localObject1 = leadSelection;
        i = R.id.frag_ecg_realtime_single_lead;
      }
      ((CompoundButton)((View)localObject1).findViewById(i)).setChecked(true);
      localObject1 = bleConnectionState;
      if (localObject1 != null) {
        triangleConnectionUpdated((TriangleBluetoothWrapperClass.BLEConnectionState)((LiveData)localObject1).getValue());
      }
    }
    else if ((localC == c.t1) || (localC == c.t2) || (localC == localObject1))
    {
      leadSelectionContainer.setVisibility(8);
      leadSelection.setVisibility(8);
    }
    if (selectedDevice == localObject2)
    {
      meterLabel.setText(R.string.record_ekg_battery);
      meterImg.setImageResource(R.drawable.battery_indicator_unknown);
      localObject1 = triangleBattery;
      if (localObject1 != null) {
        updateBatterylevel(((Integer)((LiveData)localObject1).getValue()).intValue());
      }
    }
    else
    {
      meterLabel.setText(R.string.record_ekg_signal);
      updateSignalStrength(Integer.valueOf(0));
    }
    if (deviceLeads == Direction.W)
    {
      ecgSixLeadView.setVisibility(0);
      ecgSingleLeadView.setVisibility(8);
      ecgGridView.setScale(0.6F);
    }
    else
    {
      ecgSixLeadView.setVisibility(8);
      ecgSingleLeadView.setVisibility(0);
      ecgGridView.setScale(1.0F);
    }
    ecgSingleLeadView.resetECG();
    ecgLead1View.resetECG();
    ecgLead2View.resetECG();
    ecgLead3View.resetECG();
    ecgAvfView.resetECG();
    ecgAvlView.resetECG();
    ecgAvrView.resetECG();
  }
  
  private void restartMonitor()
  {
    a.d("restartMonitor for device %s / leads %s", new Object[] { selectedDevice, deviceLeads });
    Object localObject = selectedDevice;
    if ((localObject != null) && (deviceLeads != null))
    {
      getRecordViewModel().stop();
      int i = recordingMaxDurations;
      int j = recordingMinDurations;
      localObject = new RecordingSettings(MainsFilterFrequency.fromFrequency(mainRecFrequency), selectedFilter, j * 1000, i * 1000, true, voiceEnabled, isReportRawPDF, yAxisScale);
      RecordingConfig localRecordingConfig = new RecordingConfig(selectedDevice, deviceLeads, shouldRestrictScanTriangle());
      getRecordViewModel().start(localRecordingConfig, (RecordingSettings)localObject);
      return;
    }
    a.h("restartMonitorAndUi called without enough data. Device:%s/Leads:%s", new Object[] { localObject, deviceLeads });
  }
  
  private void setLeadSelectionEnabled(boolean paramBoolean)
  {
    RadioGroup localRadioGroup = leadSelection;
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.3F;
    }
    localRadioGroup.setAlpha(f);
    int i = 0;
    while (i < leadSelection.getChildCount())
    {
      leadSelection.getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
  }
  
  private boolean shouldRestrictScanTriangle()
  {
    return appPreferences.getOptionSelectedTriangleDevice() != null;
  }
  
  private void showEcgTrace()
  {
    Direction localDirection = deviceLeads;
    if (localDirection == null)
    {
      a.a("showEcgTrace: Called before leads config updated.  Skipping", new Object[0]);
      return;
    }
    if (localDirection == Direction.W)
    {
      ecgSixLeadView.setVisibility(0);
      return;
    }
    ecgSingleLeadView.setVisibility(0);
  }
  
  private void showTriangleProgress()
  {
    Object localObject = selectedDevice;
    if (localObject != null)
    {
      if (localObject != c.deviceList) {
        return;
      }
      localObject = progress;
      if ((localObject == null) || (!((Dialog)localObject).isShowing())) {
        progress = Util.showProgress(getActivity(), R.string.connecting_triangle, true);
      }
    }
  }
  
  private void triangleConnectionUpdated(TriangleBluetoothWrapperClass.BLEConnectionState paramBLEConnectionState)
  {
    a.g("triangleConnectionUpdated: %s for Monitor State %s", new Object[] { paramBLEConnectionState, getRecordViewModel().state().getValue() });
    Object localObject = selectedDevice;
    if (localObject != c.deviceList)
    {
      a.h("triangleConnectionUpdated(): state %s for non-triangle device %s", new Object[] { paramBLEConnectionState, localObject });
      return;
    }
    if (paramBLEConnectionState == null)
    {
      a.h("triangleConnectionStateUpdated: Value was null", new Object[0]);
      return;
    }
    if ((paramBLEConnectionState != TriangleBluetoothWrapperClass.BLEConnectionState.CONNECTING) && (paramBLEConnectionState != TriangleBluetoothWrapperClass.BLEConnectionState.CONNECTED))
    {
      if (((paramBLEConnectionState == TriangleBluetoothWrapperClass.BLEConnectionState.CAPTURE_ENABLED) || (paramBLEConnectionState == TriangleBluetoothWrapperClass.BLEConnectionState.DISCONNECTED)) && (getRecordViewModel().state().getValue() != EcgMonitorViewModel.State.EVALUATING))
      {
        dismissProgressDialog();
        return;
      }
      if (paramBLEConnectionState == TriangleBluetoothWrapperClass.BLEConnectionState.ERROR)
      {
        dismissProgressDialog();
        triangleScanFailed = true;
        return;
      }
      if (paramBLEConnectionState == TriangleBluetoothWrapperClass.BLEConnectionState.SCANNING)
      {
        paramBLEConnectionState = new TriangleIntroFragment();
        localObject = (RecordUiConfig)requireArguments().getSerializable("ui_config");
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("ui_config", (Serializable)localObject);
        if (getArguments().getSerializable("com.alivecor.ecg.record.HELP_URLS") != null) {
          localBundle.putSerializable("com.alivecor.ecg.record.HELP_URLS", (RecordingHelpUrls)getArguments().getSerializable("com.alivecor.ecg.record.HELP_URLS"));
        }
        paramBLEConnectionState.setArguments(localBundle);
        paramBLEConnectionState.leadConfigUpdated(deviceLeads);
        replaceHudFragment(paramBLEConnectionState);
      }
    }
    else
    {
      showTriangleProgress();
    }
  }
  
  private void updateBatterylevel(int paramInt)
  {
    if (selectedDevice != c.deviceList) {
      return;
    }
    battery = paramInt;
    ImageView localImageView;
    if (paramInt == -1)
    {
      localImageView = meterImg;
      paramInt = R.drawable.battery_indicator_unknown;
    }
    for (;;)
    {
      localImageView.setImageResource(paramInt);
      return;
      if (paramInt > 66)
      {
        localImageView = meterImg;
        paramInt = R.drawable.battery_indicator_100;
      }
      else if (paramInt > 33)
      {
        localImageView = meterImg;
        paramInt = R.drawable.battery_indicator_66;
      }
      else if (paramInt > 5)
      {
        localImageView = meterImg;
        paramInt = R.drawable.battery_indicator_33;
      }
      else
      {
        localImageView = meterImg;
        paramInt = R.drawable.battery_indicator_5;
      }
    }
  }
  
  protected RecordDependencyComponent getRecordDependencyComponent()
  {
    return recordDependencyComponent;
  }
  
  protected EcgMonitorViewModel getRecordViewModel()
  {
    return (EcgMonitorViewModel)new ClassReader(requireActivity()).a(com.alivecor.ecg.record.EcgMonitorViewModel.class);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    try
    {
      Object localObject1 = getArguments().getString("recording_type");
      if (localObject1 != null) {
        localObject1 = RecordingType.valueOf(getArguments().getString("recording_type"));
      } else {
        localObject1 = RecordingType.NORMAL;
      }
      recordingType = ((RecordingType)localObject1);
      localObject1 = getArguments().getSerializable("com.alivecor.ecg.record.device");
      if (localObject1 != null)
      {
        localObject1 = getArguments().getSerializable("com.alivecor.ecg.record.device");
        localObject1 = (c)localObject1;
      }
      else
      {
        localObject1 = c.t1;
      }
      selectedDevice = ((c)localObject1);
      if (paramBundle == null)
      {
        paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_LEADS_CONFIG");
        if (paramBundle != null)
        {
          paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_LEADS_CONFIG");
          paramBundle = (Direction)paramBundle;
        }
        else
        {
          localObject1 = appPreferences;
        }
      }
      else
      {
        for (paramBundle = selectedDevice;; paramBundle = selectedDevice)
        {
          paramBundle = ((AppPreferences)localObject1).getDeviceLead(paramBundle);
          break;
          paramBundle = paramBundle.getSerializable("com.alivecor.ecg.record.EXTRA_LEADS_CONFIG");
          paramBundle = (Direction)paramBundle;
          deviceLeads = paramBundle;
          if (paramBundle != null) {
            break label194;
          }
          localObject1 = appPreferences;
        }
      }
      deviceLeads = paramBundle;
      label194:
      paramBundle = appPreferences;
      localObject1 = selectedDevice;
      Object localObject2 = deviceLeads;
      boolean bool = paramBundle.isSixLeadSupported((c)localObject1, (Direction)localObject2);
      if (bool)
      {
        localObject2 = appPreferences;
        paramBundle = selectedDevice;
      }
      for (localObject1 = deviceLeads;; localObject1 = Direction.S)
      {
        ((AppPreferences)localObject2).setDeviceLead(paramBundle, (Direction)localObject1);
        break;
        localObject2 = appPreferences;
        paramBundle = selectedDevice;
      }
      paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_RECORDING_FILTER_TYPE");
      if (paramBundle != null)
      {
        paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_RECORDING_FILTER_TYPE");
        paramBundle = (Filter)paramBundle;
      }
      else
      {
        paramBundle = Filter.ORIGINAL;
      }
      selectedFilter = paramBundle;
      paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_PDF_REPORT_RAW");
      if (paramBundle != null)
      {
        paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_PDF_REPORT_RAW");
        if ((ReportRawPDFType)paramBundle == ReportRawPDFType.FULL) {
          bool = true;
        } else {
          bool = false;
        }
        isReportRawPDF = bool;
      }
      else
      {
        isReportRawPDF = false;
      }
      paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_Y_AXIS_SCALE");
      if (paramBundle != null) {
        paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_Y_AXIS_SCALE");
      }
      int i;
      for (paramBundle = (YAxisScaleTypes)paramBundle;; paramBundle = YAxisScaleTypes.Y_AXIS_SCALE_10)
      {
        i = YAxisScaleTypes.getYAxisScale(paramBundle);
        break;
      }
      yAxisScale = i;
      paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_RECORDING_MAX_DURATIONS");
      if (paramBundle != null) {
        i = getArguments().getInt("com.alivecor.ecg.record.EXTRA_RECORDING_MAX_DURATIONS");
      } else {
        i = Integer.valueOf("30").intValue();
      }
      recordingMaxDurations = i;
      paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_RECORDING_MIN_DURATIONS");
      if (paramBundle != null) {
        i = getArguments().getInt("com.alivecor.ecg.record.EXTRA_RECORDING_MIN_DURATIONS");
      } else {
        i = Integer.valueOf("10").intValue();
      }
      recordingMinDurations = i;
      paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.EXTRA_RECORDING_FREQUENCY");
      if (paramBundle != null) {
        i = getArguments().getInt("com.alivecor.ecg.record.EXTRA_RECORDING_FREQUENCY");
      } else {
        i = Integer.valueOf(50).intValue();
      }
      mainRecFrequency = i;
      bool = getArguments().getBoolean("com.alivecor.ecg.record.EXTRA_VOICE_ENABLED", false);
      voiceEnabled = bool;
      helpUrls = null;
      paramBundle = getArguments();
      if (paramBundle != null)
      {
        paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.HELP_URLS");
        if (paramBundle != null)
        {
          paramBundle = getArguments().getSerializable("com.alivecor.ecg.record.HELP_URLS");
          helpUrls = ((RecordingHelpUrls)paramBundle);
        }
      }
      paramBundle = appPreferences;
      localObject1 = selectedDevice;
      paramBundle.setSelectedEkgDeviceDebug((c)localObject1);
      resetRecordingUi();
      observeMonitor();
      return;
    }
    catch (NullPointerException paramBundle) {}catch (IllegalArgumentException paramBundle) {}
    a.c((Throwable)paramBundle, "Missing some required arguments", new Object[0]);
    throw new IllegalArgumentException((Throwable)paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 300)
    {
      a.d("onActivityResult(): Back from Enabling Location", new Object[0]);
      if (paramInt2 == -1)
      {
        restartMonitor();
        return;
      }
      if (paramInt2 == 0)
      {
        a.h("onActivityResult(): User did not enable location services.", new Object[0]);
        requireActivity().finish();
      }
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.change_device)
    {
      appPreferences.clearSelectedEkgDevice();
      viewModel.task.setValue(EcgMonitorViewModel.Tasks.ON_CHANGE_DEVICE);
      return true;
    }
    if (paramMenuItem.getItemId() == R.id.record_settings)
    {
      onNavigateToRecordSettings();
      return true;
    }
    return false;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    requireActivity().getMenuInflater().inflate(R.menu.settings_menu, paramContextMenu);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a.d("onCreateView", new Object[0]);
    mContext = getActivity();
    paramBundle = RecordEkgConfig.getDB().getRecordDependencyComponent();
    recordDependencyComponent = paramBundle;
    paramBundle.inject(this);
    paramBundle = getRecordViewModel();
    viewModel = paramBundle;
    task.observe(requireActivity(), new SearchFragment.1(this));
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.frag_record_ekg_realtime, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(R.id.ecg_realtime_actionbar);
    actionBar = paramViewGroup;
    title = ((TextView)paramViewGroup.findViewById(R.id.convert_actionbar_title));
    paramViewGroup = actionBar.findViewById(R.id.convert_actionbar_back);
    ((ImageView)actionBar.findViewById(R.id.convert_actionbar_right_img)).setImageResource(R.drawable.ic_gear_settings_selector);
    paramBundle = actionBar.findViewById(R.id.convert_actionbar_right_btn);
    registerForContextMenu(paramBundle);
    paramBundle.setOnClickListener(new DashboardFragment.1(paramBundle));
    paramBundle.setVisibility(0);
    debugView = ((TextView)paramLayoutInflater.findViewById(R.id.debug_view));
    restrictScanTriangle = getArguments().getBoolean("restrict_scan_triangle", true);
    leadSelectionContainer = paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_lead_selection);
    hudFragmentContainer = paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_hud_container);
    panelFirstEcg = paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_first_ecg_panel);
    panelFirstEcgHelp = paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_first_ecg_help);
    panelFirstEcgError = paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_first_ecg_error_scrim);
    btnNeedHelp = paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_first_ecg_help_need_help);
    ecgSingleLeadView = ((EcgRealTimeView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_ecgview_single_lead));
    ecgContainer = paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_ecg_panel);
    if ((getArguments() != null) && (getArguments().getBoolean("com.alivecor.ecg.record.EXTRA_HIDE_TRACE", false))) {
      ecgContainer.setVisibility(4);
    }
    ecgSixLeadView = ((ViewGroup)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_ecgview_six_lead));
    paramBundle = (EcgRealTimeView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_ecgview_lead_i);
    ecgLead1View = paramBundle;
    paramBundle.setSignalScale(0.6F);
    paramBundle = (EcgRealTimeView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_ecgview_lead_ii);
    ecgLead2View = paramBundle;
    paramBundle.setSignalScale(0.6F);
    paramBundle = (EcgRealTimeView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_ecgview_lead_iii);
    ecgLead3View = paramBundle;
    paramBundle.setSignalScale(0.6F);
    paramBundle = (EcgRealTimeView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_ecgview_lead_avl);
    ecgAvlView = paramBundle;
    paramBundle.setSignalScale(0.6F);
    paramBundle = (EcgRealTimeView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_ecgview_lead_avr);
    ecgAvrView = paramBundle;
    paramBundle.setSignalScale(0.6F);
    paramBundle = (EcgRealTimeView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_ecgview_lead_avf);
    ecgAvfView = paramBundle;
    paramBundle.setSignalScale(0.6F);
    paramBundle = (EcgGridView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_grid);
    ecgGridView = paramBundle;
    paramBundle.setScale(1.0F);
    header = paramLayoutInflater.findViewById(R.id.ecg_realtime_header);
    timerProgress = paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_timer_progress);
    txtTimer = ((TextView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_timer_text));
    imgTimerCheckmark = paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_timer_checkmark);
    imgBeats = paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_beats_img);
    txtBeatsCount = ((TextView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_beats_count));
    meterImg = ((ImageView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_meter_img));
    meterLabel = ((TextView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_meter_lbl));
    timerProgress.setBackground(progressDrawable);
    paramBundle = (RadioGroup)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_leads);
    leadSelection = paramBundle;
    paramBundle.setOnCheckedChangeListener(new SettingsActivity.1(this));
    paramBundle = new Util.ProgressDrawableCircle(mContext.getResources().getColor(R.color.kardia_gray_light), 100.0F).setProgress(0.0F);
    progressDrawable = paramBundle;
    timerProgress.setBackgroundDrawable(paramBundle);
    title.setText(getTitleString());
    paramViewGroup.setOnClickListener(new DashboardFragment.5(this));
    btnNeedHelp.setOnClickListener(new TaskEditFragment.1(this));
    paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_first_ecg_progress).setBackground(new FragEcgRealtime.1(this));
    paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_first_ecg_help_get_kardia).setOnClickListener(new DashboardFragment.2(this));
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(R.id.frag_ecg_realtime_audio_stats);
    paramViewGroup.setVisibility(8);
    paramViewGroup.setEnabled(false);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  protected void onLeadConfigUpdated(Direction paramDirection) {}
  
  protected void onNavigateToRecordSettings() {}
  
  public void onPause()
  {
    getActivity().getWindow().clearFlags(128);
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    unbindHandler.removeCallbacksAndMessages(null);
    FragmentActivity localFragmentActivity = getActivity();
    Util.setStatusBarColor(localFragmentActivity.getWindow(), mContext.getResources().getColor(R.color.gray_teal_statusbar));
    localFragmentActivity.getWindow().addFlags(128);
    if (isMonitorIdle())
    {
      a.g("onResume(): Monitor idle.  Starting.", new Object[0]);
      restartMonitor();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("com.alivecor.ecg.record.EXTRA_LEADS_CONFIG", deviceLeads);
  }
  
  public void onStart()
  {
    super.onStart();
    getActivity();
    a.d("onStart(): Ready to record", new Object[0]);
    panelFirstEcg.setVisibility(8);
    panelFirstEcgHelp.setVisibility(8);
    hudFragmentContainer.setVisibility(0);
    hudFragmentContainer.setAlpha(1.0F);
    bluetoothStateReciever = createBluetoothStateReceiver();
    getContext().registerReceiver(bluetoothStateReciever, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
  }
  
  public void onStop()
  {
    if (bluetoothStateReciever != null) {
      getContext().unregisterReceiver(bluetoothStateReciever);
    }
    super.onStop();
  }
  
  protected void playCompletedAnimation(Runnable paramRunnable)
  {
    txtTimer.setVisibility(4);
    imgTimerCheckmark.setVisibility(0);
    imgTimerCheckmark.setScaleX(0.33F);
    imgTimerCheckmark.setScaleY(0.33F);
    imgTimerCheckmark.animate().scaleX(1.0F).scaleY(1.0F).setDuration(999L).setListener(new FragEcgRealtime.2(this, paramRunnable)).setInterpolator(new DecelerateInterpolator()).start();
  }
  
  protected void recordSettingsUpdated(RecordingSettings paramRecordingSettings)
  {
    if ((paramRecordingSettings != null) && (getRecordViewModel().state().getValue() != EcgMonitorViewModel.State.CAPTURING)) {
      txtTimer.setText(formatTimerString(maxRecDurationMs / 1000));
    }
  }
  
  void requestEnableLocation()
  {
    Object localObject = LocationRequest.create();
    ((LocationRequest)localObject).setInterval(10000L);
    ((LocationRequest)localObject).setFastestInterval(5000L);
    ((LocationRequest)localObject).setPriority(100);
    localObject = new LocationSettingsRequest.Builder().addLocationRequest((LocationRequest)localObject);
    ((LocationSettingsRequest.Builder)localObject).setAlwaysShow(true);
    new SettingsClient(requireActivity()).checkLocationSettings(((LocationSettingsRequest.Builder)localObject).build()).addOnCompleteListener(new Rule(this));
  }
  
  protected void showSaveEcgProgress()
  {
    ProgressDialog localProgressDialog = progress;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing()))
    {
      a.g("showSaveEcgProgress: Already showing.  Skipping", new Object[0]);
      return;
    }
    progress = Util.showProgress(mContext, R.string.process_dialog_text);
    hudFragmentContainer.animate().alpha(0.0F).start();
  }
  
  protected void updateSignalStrength(Integer paramInteger)
  {
    if (selectedDevice == c.deviceList) {
      return;
    }
    paramInteger = Integer.valueOf(Util.unboxOr(paramInteger, 0));
    int i;
    if (paramInteger.intValue() > 50)
    {
      meterImg.setImageResource(R.drawable.signal_strength_full);
      paramInteger = meterLabel;
      i = R.string.ecg_realtime_signal_strong;
    }
    for (;;)
    {
      paramInteger.setText(i);
      return;
      if (paramInteger.intValue() > 20)
      {
        meterImg.setImageResource(R.drawable.signal_strength_medium);
        paramInteger = meterLabel;
        i = R.string.ecg_realtime_signal_medium;
      }
      else if (paramInteger.intValue() > 0)
      {
        meterImg.setImageResource(R.drawable.signal_strength_low);
        paramInteger = meterLabel;
        i = R.string.ecg_realtime_signal_weak;
      }
      else
      {
        meterImg.setImageResource(R.drawable.signal_strength_none);
        paramInteger = meterLabel;
        i = R.string.ecg_realtime_signal_no;
      }
    }
  }
}
