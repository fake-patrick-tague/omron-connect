package com.alivecor.mapsforge.record;

import com.alivecor.upgrade.AliveCorEcg;
import com.alivecor.upgrade.LeadConfiguration;

public abstract interface RecordEkgListener
{
  public abstract void onBPMUpdated(String paramString);
  
  public abstract void onChangeDevice();
  
  public abstract void onLeadConfigUpdated(LeadConfiguration paramLeadConfiguration);
  
  public abstract void onRecordCompleted(AliveCorEcg paramAliveCorEcg);
  
  public abstract void onRecordError(RecordingError paramRecordingError);
  
  public abstract void onRecordSettings();
  
  public abstract void onUserCancel();
}
