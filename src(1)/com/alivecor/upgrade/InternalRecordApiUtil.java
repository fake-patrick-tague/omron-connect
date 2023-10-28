package com.alivecor.upgrade;

import android.content.Context;
import com.alivecor.ai.u;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.asm.ClassifierData.b;
import com.alivecor.asm.Label;
import com.alivecor.asm.Plot;
import com.alivecor.asm.Priority;
import com.alivecor.asm.Region;
import com.alivecor.asm.Series;
import com.alivecor.mapsforge.core.asm.b;
import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.mapsforge.core.model.Frame;
import com.alivecor.mapsforge.core.model.Handle;
import com.alivecor.mapsforge.core.model.MainsFilterFrequency;
import com.alivecor.mapsforge.core.model.YAxisScaleTypes;
import com.alivecor.mapsforge.core.model.c;
import com.alivecor.mapsforge.record.RecordResult;
import com.alivecor.mapsforge.record.RecordingConfig;
import com.alivecor.mapsforge.record.RecordingSettings;
import com.alivecor.mapsforge.record.ReportRawPDFType;
import com.alivecor.mapsforge.record.Util;
import com.alivecor.universal_monitor.Filter;

public class InternalRecordApiUtil
{
  private static InternalRecordApiUtil instance;
  private Context appContext;
  private String appName;
  
  protected InternalRecordApiUtil(Context paramContext, String paramString)
  {
    appContext = paramContext;
    appName = paramString;
  }
  
  static InternalRecordApiUtil _()
  {
    return instance;
  }
  
  static void init(Context paramContext, String paramString)
  {
    instance = new InternalRecordApiUtil(paramContext.getApplicationContext(), paramString);
  }
  
  protected String appName()
  {
    return appName;
  }
  
  protected Context context()
  {
    return appContext;
  }
  
  protected AliveCorDetermination determinationFromString(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1840151916: 
      if (paramString.equals("unclassified")) {
        i = 8;
      }
      break;
    case 1085540879: 
      if (paramString.equals("tachycardia")) {
        i = 7;
      }
      break;
    case 963799566: 
      if (paramString.equals("bradycardia")) {
        i = 6;
      }
      break;
    case 659069321: 
      if (paramString.equals("unreadable")) {
        i = 5;
      }
      break;
    case 2991102: 
      if (paramString.equals("afib")) {
        i = 4;
      }
      break;
    case -770025007: 
      if (paramString.equals("too_short")) {
        i = 3;
      }
      break;
    case -994872697: 
      if (paramString.equals("too_long")) {
        i = 2;
      }
      break;
    case -1039745817: 
      if (paramString.equals("normal")) {
        i = 1;
      }
      break;
    case -1368244326: 
      if (paramString.equals("no_analysis")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return null;
    case 8: 
      return AliveCorDetermination.UNCLASSIFIED;
    case 7: 
      return AliveCorDetermination.TACHYCARDIA;
    case 6: 
      return AliveCorDetermination.BRADYCARDIA;
    case 5: 
      return AliveCorDetermination.UNREADABLE;
    case 4: 
      return AliveCorDetermination.AFIB;
    case 3: 
      return AliveCorDetermination.SHORT;
    case 2: 
      return AliveCorDetermination.LONG;
    case 1: 
      return AliveCorDetermination.NORMAL;
    }
    return AliveCorDetermination.NO_ANALYSIS;
  }
  
  protected AliveCorDetermination externalDetermination(Priority paramPriority)
  {
    switch (1.$SwitchMap$com$alivecor$ai$Determination[paramPriority.ordinal()])
    {
    default: 
      return AliveCorDetermination.NO_ANALYSIS;
    case 8: 
      return AliveCorDetermination.TACHYCARDIA;
    case 7: 
      return AliveCorDetermination.UNREADABLE;
    case 6: 
      return AliveCorDetermination.UNCLASSIFIED;
    case 5: 
      return AliveCorDetermination.BRADYCARDIA;
    case 4: 
      return AliveCorDetermination.NORMAL;
    case 3: 
      return AliveCorDetermination.SHORT;
    case 2: 
      return AliveCorDetermination.LONG;
    }
    return AliveCorDetermination.AFIB;
  }
  
  protected AliveCorDevice externalDevice(Handle paramHandle)
  {
    int i = 1.$SwitchMap$com$alivecor$ecg$core$model$RecordingDeviceData$Hardware[paramHandle.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return AliveCorDevice.UNSPECIFIED;
          }
          return AliveCorDevice.KARDIA_BAND;
        }
        return AliveCorDevice.OMRON_COMPLETE;
      }
      return AliveCorDevice.KARDIA_MOBILE;
    }
    return AliveCorDevice.TRIANGLE;
  }
  
  protected AliveCorDevice externalDevice(c paramC)
  {
    int i = 1.$SwitchMap$com$alivecor$ecg$core$model$RecordingDevice[paramC.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return AliveCorDevice.UNSPECIFIED;
        }
        return AliveCorDevice.OMRON_COMPLETE;
      }
      return AliveCorDevice.KARDIA_MOBILE;
    }
    return AliveCorDevice.TRIANGLE;
  }
  
  protected RecordingDeviceInfo externalDeviceInfo(Frame paramFrame, Direction paramDirection, String paramString)
  {
    RecordingDeviceInfo localRecordingDeviceInfo = new RecordingDeviceInfo();
    if (paramFrame.init() != null) {
      localRecordingDeviceInfo.setDevice(externalDevice(paramFrame.init()));
    }
    localRecordingDeviceInfo.setDeviceUuid(paramString);
    localRecordingDeviceInfo.setHardwareVersion(paramFrame.c());
    localRecordingDeviceInfo.setFirmwareVersion(paramFrame.a());
    localRecordingDeviceInfo.setBatteryLevel(paramFrame.b());
    if (paramDirection == Direction.W) {
      paramFrame = LeadConfiguration.DOUBLE;
    } else {
      paramFrame = LeadConfiguration.SINGLE;
    }
    localRecordingDeviceInfo.setLeadConfiguration(paramFrame);
    return localRecordingDeviceInfo;
  }
  
  protected AliveCorEcg externalEcg(RecordResult paramRecordResult, Plot paramPlot, RecordingSettings paramRecordingSettings, RecordingConfig paramRecordingConfig)
  {
    AliveCorEcg localAliveCorEcg = new AliveCorEcg();
    localAliveCorEcg.setRawAtcPath(paramRecordResult.getOriginalPath());
    localAliveCorEcg.setUuid(paramRecordResult.getLocalRecordingID());
    localAliveCorEcg.setEnhancedAtcPath(paramRecordResult.getEnhancedPath());
    localAliveCorEcg.setFilesDirectory(b.write());
    localAliveCorEcg.setRecordedAtMs(paramRecordResult.getDateTimeUtcMillis());
    localAliveCorEcg.setTimezoneOffset(paramRecordResult.getTimezoneOffset());
    localAliveCorEcg.setDeviceInfo(externalDeviceInfo(paramRecordResult.getRecordingDeviceData(), paramRecordResult.getLeadsConfig(), paramRecordResult.getDeviceBluetoothAddress()));
    localAliveCorEcg.setRecordingConfiguration(externalRecordConfig(paramRecordingConfig, paramRecordingSettings));
    localAliveCorEcg.setEcgEvaluation(externalEvaluation(paramPlot));
    localAliveCorEcg.setDurationMs(s * 1000 / 300 / 2);
    return localAliveCorEcg;
  }
  
  protected EcgEvaluation externalEvaluation(Plot paramPlot)
  {
    EcgEvaluation localEcgEvaluation = new EcgEvaluation();
    if (paramPlot.a(com.alivecor.ai.ClassifierData.class) != null)
    {
      com.alivecor.asm.ClassifierData localClassifierData = (com.alivecor.asm.ClassifierData)paramPlot.a(com.alivecor.ai.ClassifierData.class);
      localEcgEvaluation.setDetermination(externalDetermination(((ClassifierData.b)localClassifierData.newUTF8()).getDetermination()));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localClassifierData.b());
      localStringBuilder.append(".");
      localStringBuilder.append(localClassifierData.a());
      localStringBuilder.append(".");
      localStringBuilder.append(localClassifierData.c());
      localEcgEvaluation.setKardiaAiVersion(localStringBuilder.toString());
      float f = k;
      if (f != 0.0F) {
        localEcgEvaluation.setAverageHeartRate(Float.valueOf(f));
      }
    }
    if ((paramPlot.a(u.class) != null) && (n == Direction.S))
    {
      int i = ((Region)((Series)paramPlot.a(u.class)).newUTF8()).getHeight();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localEcgEvaluation.setInverted(bool);
    }
    return localEcgEvaluation;
  }
  
  protected LeadConfiguration externalLeads(Direction paramDirection)
  {
    if (1.$SwitchMap$com$alivecor$ecg$core$model$LeadsConfig[paramDirection.ordinal()] != 1) {
      return LeadConfiguration.SINGLE;
    }
    return LeadConfiguration.DOUBLE;
  }
  
  protected RecordingConfiguration externalRecordConfig(RecordingConfig paramRecordingConfig, RecordingSettings paramRecordingSettings)
  {
    RecordingConfiguration localRecordingConfiguration = new RecordingConfiguration(externalDevice(selectedDevice), externalLeads(deviceLeads));
    if (previewFilter == Filter.ENHANCED) {
      paramRecordingConfig = FilterType.ENHANCED;
    } else {
      paramRecordingConfig = FilterType.ORIGINAL;
    }
    localRecordingConfiguration.setFilterType(paramRecordingConfig);
    localRecordingConfiguration.setMaxDurationSeconds(maxRecDurationMs / 1000);
    localRecordingConfiguration.setResetDurationSeconds(minRecDurationMs / 1000);
    localRecordingConfiguration.setMainsFrequency(mainsFreq.languageIndex);
    if (isPreviewRawPDF) {
      paramRecordingConfig = ReportRawPDFType.FULL;
    } else {
      paramRecordingConfig = ReportRawPDFType.ORIGINAL;
    }
    localRecordingConfiguration.setReportRawPDF(paramRecordingConfig);
    localRecordingConfiguration.setyAxisScaleTypes(YAxisScaleTypes.getYAxisScaleTypes(yAxisScale));
    return localRecordingConfiguration;
  }
  
  protected int getAnalysisColor(AliveCorDetermination paramAliveCorDetermination)
  {
    return Util.getEcgAnalysisColor(internalDetermination(paramAliveCorDetermination));
  }
  
  protected int getAnalysisMessage(AliveCorDetermination paramAliveCorDetermination)
  {
    if (paramAliveCorDetermination == AliveCorDetermination.SHORT) {
      return R.string.short_detected_short_text;
    }
    if (paramAliveCorDetermination == AliveCorDetermination.LONG) {
      return R.string.long_detected_result_text;
    }
    if (paramAliveCorDetermination == AliveCorDetermination.UNREADABLE) {
      return R.string.noise_detected_short_text;
    }
    if (paramAliveCorDetermination == AliveCorDetermination.AFIB) {
      return R.string.af_detected_text;
    }
    if (paramAliveCorDetermination == AliveCorDetermination.NORMAL) {
      return R.string.nsr_detected_text;
    }
    if (paramAliveCorDetermination == AliveCorDetermination.BRADYCARDIA) {
      return R.string.bradycardia_detected_text;
    }
    if (paramAliveCorDetermination == AliveCorDetermination.TACHYCARDIA) {
      return R.string.tachycardia_detected_text;
    }
    if (paramAliveCorDetermination == AliveCorDetermination.UNCLASSIFIED) {
      return R.string.undetermined_text_kardia_ai;
    }
    return 0;
  }
  
  protected String getAnalysisString(AliveCorDetermination paramAliveCorDetermination)
  {
    if (paramAliveCorDetermination == AliveCorDetermination.SHORT) {
      return "too_short";
    }
    if (paramAliveCorDetermination == AliveCorDetermination.LONG) {
      return "too_long";
    }
    if (paramAliveCorDetermination == AliveCorDetermination.UNREADABLE) {
      return "unreadable";
    }
    if (paramAliveCorDetermination == AliveCorDetermination.AFIB) {
      return "afib";
    }
    if (paramAliveCorDetermination == AliveCorDetermination.NORMAL) {
      return "normal";
    }
    if (paramAliveCorDetermination == AliveCorDetermination.BRADYCARDIA) {
      return "bradycardia";
    }
    if (paramAliveCorDetermination == AliveCorDetermination.TACHYCARDIA) {
      return "tachycardia";
    }
    if (paramAliveCorDetermination == AliveCorDetermination.UNCLASSIFIED) {
      return "unclassified";
    }
    return "no_analysis";
  }
  
  protected int getAnalysisText(AliveCorDetermination paramAliveCorDetermination)
  {
    return Util.getEcgAnalysisTag(internalDetermination(paramAliveCorDetermination));
  }
  
  protected Priority internalDetermination(AliveCorDetermination paramAliveCorDetermination)
  {
    switch (1.$SwitchMap$com$alivecor$api$AliveCorDetermination[paramAliveCorDetermination.ordinal()])
    {
    default: 
      return Priority.Off;
    case 8: 
      return Priority.ERRORED;
    case 7: 
      return Priority.Low;
    case 6: 
      return Priority.PURCHASED;
    case 5: 
      return Priority.CANCELLED;
    case 4: 
      return Priority.E;
    case 3: 
      return Priority.Normal;
    case 2: 
      return Priority.High;
    }
    return Priority.W;
  }
  
  protected Handle internalDevice(AliveCorDevice paramAliveCorDevice)
  {
    int i = 1.$SwitchMap$com$alivecor$api$AliveCorDevice[paramAliveCorDevice.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return Handle.RIGHT;
          }
          return Handle.TOP_LEFT;
        }
        return Handle.TOP_RIGHT;
      }
      return Handle.BOTTOM_RIGHT;
    }
    return Handle.TOP;
  }
  
  protected Direction internalLeads(LeadConfiguration paramLeadConfiguration)
  {
    if (1.$SwitchMap$com$alivecor$api$LeadConfiguration[paramLeadConfiguration.ordinal()] != 1) {
      return Direction.S;
    }
    return Direction.W;
  }
  
  protected c internalRecordingDevice(AliveCorDevice paramAliveCorDevice)
  {
    int i = 1.$SwitchMap$com$alivecor$api$AliveCorDevice[paramAliveCorDevice.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return c.b;
        }
        return c.J;
      }
      return c.t1;
    }
    return c.deviceList;
  }
  
  protected com.alivecor.ecgcore.SampleRate internalSampleRate(SampleRate paramSampleRate)
  {
    int i = 1.$SwitchMap$com$alivecor$api$SampleRate[paramSampleRate.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              return com.alivecor.ecgcore.SampleRate.RATE_600_HZ;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Sample rate ");
            localStringBuilder.append(paramSampleRate);
            localStringBuilder.append(" not supported");
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
          return com.alivecor.ecgcore.SampleRate.RATE_500_HZ;
        }
        return com.alivecor.ecgcore.SampleRate.RATE_300_HZ;
      }
      return com.alivecor.ecgcore.SampleRate.RATE_250_HZ;
    }
    return com.alivecor.ecgcore.SampleRate.RATE_125_HZ;
  }
}
