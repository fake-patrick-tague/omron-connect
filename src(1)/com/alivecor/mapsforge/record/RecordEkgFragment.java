package com.alivecor.mapsforge.record;

import android.os.BaseBundle;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.package_11.Fragment;
import androidx.lifecycle.ClassReader;
import androidx.lifecycle.LiveData;
import com.alivecor.alivecorkitlite.R.id;
import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.mapsforge.core.model.YAxisScaleTypes;
import com.alivecor.mapsforge.core.model.c;
import com.alivecor.universal_monitor.Filter;
import com.alivecor.upgrade.AliveCorEcg;
import com.alivecor.upgrade.FilterType;
import com.alivecor.upgrade.LeadConfiguration;
import com.alivecor.upgrade.RecordingConfiguration;
import java.io.Serializable;
import java.util.List;
import l.a.a;

public final class RecordEkgFragment
  extends FragEcgRealtime
{
  private static String ARG_SINGLE_DEVICE;
  private static final String PAGE_KEY = "com.alivecor.ecg.record.RecordEKGFragment";
  private RecordEkgListener recordCallback;
  private EcgMonitorViewModel viewModel;
  
  public RecordEkgFragment() {}
  
  private void callbackCanceled()
  {
    RecordEkgListener localRecordEkgListener = recordCallback;
    if (localRecordEkgListener != null) {
      localRecordEkgListener.onUserCancel();
    }
  }
  
  private void callbackCompleted(AliveCorEcg paramAliveCorEcg)
  {
    RecordEkgListener localRecordEkgListener = recordCallback;
    if (localRecordEkgListener != null) {
      localRecordEkgListener.onRecordCompleted(paramAliveCorEcg);
    }
  }
  
  private void callbackDeviceChanged()
  {
    RecordEkgListener localRecordEkgListener = recordCallback;
    if (localRecordEkgListener != null) {
      localRecordEkgListener.onChangeDevice();
    }
  }
  
  private void callbackError(RecordingError paramRecordingError)
  {
    RecordEkgListener localRecordEkgListener = recordCallback;
    if (localRecordEkgListener != null) {
      localRecordEkgListener.onRecordError(paramRecordingError);
    }
  }
  
  private void callbackLeadsConfig(Direction paramDirection)
  {
    RecordSdkHelper localRecordSdkHelper = new RecordSdkHelper(RecordEkgConfig.getDB());
    RecordEkgListener localRecordEkgListener = recordCallback;
    if (localRecordEkgListener != null) {
      localRecordEkgListener.onLeadConfigUpdated(localRecordSdkHelper.externalLeads(paramDirection));
    }
  }
  
  public static RecordEkgFragment newInstance(RecordingConfiguration paramRecordingConfiguration)
    throws InvalidArgumentException
  {
    return newInstance(paramRecordingConfiguration, null, false, null);
  }
  
  public static RecordEkgFragment newInstance(RecordingConfiguration paramRecordingConfiguration, RecordingHelpUrls paramRecordingHelpUrls)
    throws InvalidArgumentException
  {
    return newInstance(paramRecordingConfiguration, paramRecordingHelpUrls, false, null);
  }
  
  public static RecordEkgFragment newInstance(RecordingConfiguration paramRecordingConfiguration, RecordingHelpUrls paramRecordingHelpUrls, boolean paramBoolean, RecordUiConfig paramRecordUiConfig)
    throws InvalidArgumentException
  {
    for (;;)
    {
      try
      {
        localRecordEkgConfig = RecordEkgConfig.getDB();
        localRecordEkgFragment = new RecordEkgFragment();
        localBundle = new Bundle();
        localBundle.putBoolean(ARG_SINGLE_DEVICE, paramBoolean);
        localBundle.putSerializable("ui_config", paramRecordUiConfig);
        localRecordSdkHelper = new RecordSdkHelper(RecordEkgConfig.getDB());
      }
      catch (IllegalStateException paramRecordingConfiguration)
      {
        RecordEkgConfig localRecordEkgConfig;
        RecordEkgFragment localRecordEkgFragment;
        Bundle localBundle;
        RecordSdkHelper localRecordSdkHelper;
        c localC;
        ReportRawPDFType localReportRawPDFType;
        YAxisScaleTypes localYAxisScaleTypes;
        Object localObject2;
        LeadConfiguration localLeadConfiguration;
        Object localObject1;
        label178:
        continue;
      }
      try
      {
        localC = localRecordSdkHelper.internalRecordingDevice(paramRecordingConfiguration.getDevice());
      }
      catch (IllegalArgumentException paramRecordingConfiguration)
      {
        continue;
      }
      try
      {
        paramRecordUiConfig = paramRecordingConfiguration.getFilterType();
        if (paramRecordUiConfig == FilterType.ORIGINAL) {
          paramRecordUiConfig = Filter.ORIGINAL;
        } else {
          paramRecordUiConfig = Filter.ENHANCED;
        }
      }
      catch (IllegalArgumentException paramRecordingConfiguration)
      {
        continue;
      }
      try
      {
        localReportRawPDFType = paramRecordingConfiguration.isReportRawPDF();
      }
      catch (IllegalArgumentException localIllegalArgumentException1) {}
    }
    a.b("ReportRawPDFType is not of valid type reset to DEFAULT value", new Object[0]);
    localReportRawPDFType = ReportRawPDFType.ORIGINAL;
    try
    {
      localYAxisScaleTypes = paramRecordingConfiguration.getyAxisScaleTypes();
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      for (;;) {}
    }
    a.b("YAxisScaleTypes is not of valid type reset to DEFAULT value", new Object[0]);
    localYAxisScaleTypes = YAxisScaleTypes.Y_AXIS_SCALE_10;
    localObject2 = null;
    try
    {
      localLeadConfiguration = paramRecordingConfiguration.getLeads();
      localObject1 = localObject2;
      if (localLeadConfiguration == null) {
        break label178;
      }
      localObject1 = localRecordSdkHelper.internalLeads(paramRecordingConfiguration.getLeads());
    }
    catch (IllegalArgumentException localIllegalArgumentException3)
    {
      for (;;) {}
    }
    a.a(" RecordingConfiguration LeadConfig is null", new Object[0]);
    localObject1 = localObject2;
    if (localRecordEkgConfig.getEnabledDevices().contains(localC))
    {
      localBundle.putString("com.alivecor.ecg.record.ARG_OVERRIDE_DEVICE_NAME", paramRecordingConfiguration.getOverrideDeviceName());
      localBundle.putSerializable("com.alivecor.ecg.record.device", localC);
      localBundle.putSerializable("com.alivecor.ecg.record.EXTRA_LEADS_CONFIG", (Serializable)localObject1);
      localBundle.putSerializable("com.alivecor.ecg.record.EXTRA_RECORDING_FILTER_TYPE", paramRecordUiConfig);
      localBundle.putSerializable("com.alivecor.ecg.record.EXTRA_PDF_REPORT_RAW", localReportRawPDFType);
      localBundle.putSerializable("com.alivecor.ecg.record.EXTRA_Y_AXIS_SCALE", localYAxisScaleTypes);
      localBundle.putInt("com.alivecor.ecg.record.EXTRA_RECORDING_MAX_DURATIONS", paramRecordingConfiguration.getMaxDurationSeconds());
      localBundle.putInt("com.alivecor.ecg.record.EXTRA_RECORDING_MIN_DURATIONS", paramRecordingConfiguration.getResetDurationSeconds());
      localBundle.putInt("com.alivecor.ecg.record.EXTRA_RECORDING_FREQUENCY", paramRecordingConfiguration.getMainsFrequency());
      localBundle.putBoolean("com.alivecor.ecg.record.EXTRA_HIDE_TRACE", paramRecordingConfiguration.isHideTrace());
      localBundle.putSerializable("com.alivecor.ecg.record.HELP_URLS", paramRecordingHelpUrls);
      localRecordEkgFragment.setArguments(localBundle);
      return localRecordEkgFragment;
    }
    throw new InvalidArgumentException(String.format("RecordingDevice %s is disabled", new Object[] { localC }));
    throw new InvalidArgumentException("FilterType is not of valid type");
    throw new InvalidArgumentException("RecordngDevice is not of valid type");
    throw new InvalidArgumentException("Global Recording Config was not initialized.  KardiaKit users must call KardiaKit.initialize() before using this Fragment.");
  }
  
  public void addListener(RecordEkgListener paramRecordEkgListener)
  {
    recordCallback = paramRecordEkgListener;
  }
  
  protected void callbackBPMUpdated(String paramString)
  {
    RecordEkgListener localRecordEkgListener = recordCallback;
    if (localRecordEkgListener != null) {
      localRecordEkgListener.onBPMUpdated(paramString);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    if (requireArguments().getBoolean(ARG_SINGLE_DEVICE, false)) {
      paramContextMenu.removeItem(R.id.change_device);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    viewModel = ((EcgMonitorViewModel)new ClassReader(requireActivity()).a(com.alivecor.ecg.record.EcgMonitorViewModel.class));
    paramViewGroup = new RecordSdkHelper(RecordEkgConfig.getDB());
    viewModel.task.observe(getViewLifecycleOwner(), new MainActivity.1(this, paramViewGroup));
    return paramLayoutInflater;
  }
  
  protected void onLeadConfigUpdated(Direction paramDirection)
  {
    callbackLeadsConfig(paramDirection);
  }
  
  protected void onNavigateToRecordSettings()
  {
    RecordEkgListener localRecordEkgListener = recordCallback;
    if (localRecordEkgListener != null) {
      localRecordEkgListener.onRecordSettings();
    }
  }
  
  public void removeListener(RecordEkgListener paramRecordEkgListener)
  {
    recordCallback = null;
  }
}
