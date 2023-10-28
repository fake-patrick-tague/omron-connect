package com.alivecor.mapsforge.record;

import com.alivecor.asm.Plot;
import com.alivecor.asm.Priority;
import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.mapsforge.core.model.Frame;
import com.alivecor.mapsforge.core.model.Handle;
import com.alivecor.mapsforge.core.model.c;
import com.alivecor.upgrade.AliveCorDetermination;
import com.alivecor.upgrade.AliveCorDevice;
import com.alivecor.upgrade.AliveCorEcg;
import com.alivecor.upgrade.EcgEvaluation;
import com.alivecor.upgrade.InternalRecordApiUtil;
import com.alivecor.upgrade.LeadConfiguration;
import com.alivecor.upgrade.RecordingConfiguration;
import com.alivecor.upgrade.RecordingDeviceInfo;

class RecordSdkHelper
  extends InternalRecordApiUtil
{
  RecordSdkHelper(RecordEkgConfig paramRecordEkgConfig)
  {
    super(paramRecordEkgConfig.appContext(), paramRecordEkgConfig.getAppName());
  }
  
  protected AliveCorDetermination externalDetermination(Priority paramPriority)
  {
    return super.externalDetermination(paramPriority);
  }
  
  protected AliveCorDevice externalDevice(Handle paramHandle)
  {
    return super.externalDevice(paramHandle);
  }
  
  protected RecordingDeviceInfo externalDeviceInfo(Frame paramFrame, Direction paramDirection, String paramString)
  {
    return super.externalDeviceInfo(paramFrame, paramDirection, paramString);
  }
  
  protected AliveCorEcg externalEcg(RecordResult paramRecordResult, Plot paramPlot, RecordingSettings paramRecordingSettings, RecordingConfig paramRecordingConfig)
  {
    return super.externalEcg(paramRecordResult, paramPlot, paramRecordingSettings, paramRecordingConfig);
  }
  
  protected LeadConfiguration externalLeads(Direction paramDirection)
  {
    return super.externalLeads(paramDirection);
  }
  
  protected Priority internalDetermination(AliveCorDetermination paramAliveCorDetermination)
  {
    return super.internalDetermination(paramAliveCorDetermination);
  }
  
  protected Handle internalDevice(AliveCorDevice paramAliveCorDevice)
  {
    return super.internalDevice(paramAliveCorDevice);
  }
  
  protected Direction internalLeads(LeadConfiguration paramLeadConfiguration)
  {
    return super.internalLeads(paramLeadConfiguration);
  }
  
  protected c internalRecordingDevice(AliveCorDevice paramAliveCorDevice)
  {
    return super.internalRecordingDevice(paramAliveCorDevice);
  }
  
  public AliveCorEcg mapFromRecordResult(RecordResult paramRecordResult, Plot paramPlot, RecordingSettings paramRecordingSettings, RecordingConfig paramRecordingConfig)
  {
    return externalEcg(paramRecordResult, paramPlot, paramRecordingSettings, paramRecordingConfig);
  }
  
  public ResultDetail resultDetailFromEcg(AliveCorEcg paramAliveCorEcg)
  {
    ResultDetail localResultDetail = new ResultDetail();
    if (paramAliveCorEcg.getEcgEvaluation() != null)
    {
      if (paramAliveCorEcg.getEcgEvaluation().getAverageHeartRate() != null) {
        localResultDetail.setBpm(paramAliveCorEcg.getEcgEvaluation().getAverageHeartRate().floatValue());
      }
      kaiResult = internalDetermination(paramAliveCorEcg.getEcgEvaluation().getDetermination());
      localResultDetail.setInverted(paramAliveCorEcg.getEcgEvaluation().isInverted());
    }
    if (paramAliveCorEcg.getRecordingConfiguration() != null)
    {
      localResultDetail.setHardwareType(internalDevice(paramAliveCorEcg.getRecordingConfiguration().getDevice()));
      if (paramAliveCorEcg.getRecordingConfiguration().getLeads() != null) {
        localResultDetail.setLeadsConfig(internalLeads(paramAliveCorEcg.getRecordingConfiguration().getLeads()));
      }
    }
    localResultDetail.setLocalRecordingID(paramAliveCorEcg.getUuid());
    return localResultDetail;
  }
}
