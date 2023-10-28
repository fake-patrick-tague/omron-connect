package com.alivecor.mapsforge.record;

import com.alivecor.asm.Priority;
import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.mapsforge.core.model.Frame;
import com.alivecor.mapsforge.core.model.Handle;
import java.io.Serializable;

public class ResultDetail
  implements Serializable
{
  float Text;
  private Handle hardwareType;
  private boolean inverted;
  Priority kaiResult;
  private Direction leadsConfig;
  private String localRecordingID;
  
  public ResultDetail() {}
  
  ResultDetail(RecordResult paramRecordResult, Priority paramPriority, float paramFloat)
  {
    kaiResult = paramPriority;
    Text = paramFloat;
    if (paramRecordResult.getRecordingDeviceData() != null) {
      hardwareType = paramRecordResult.getRecordingDeviceData().init();
    }
    leadsConfig = paramRecordResult.getLeadsConfig();
    inverted = inverted;
    localRecordingID = localRecordingID;
  }
  
  public float getBpm()
  {
    return Text;
  }
  
  public Handle getHardwareType()
  {
    return hardwareType;
  }
  
  public Priority getKaiResult()
  {
    return kaiResult;
  }
  
  public Direction getLeadsConfig()
  {
    return leadsConfig;
  }
  
  public String getLocalRecordingID()
  {
    return localRecordingID;
  }
  
  public boolean isInverted()
  {
    return inverted;
  }
  
  public void setBpm(float paramFloat)
  {
    Text = paramFloat;
  }
  
  public void setHardwareType(Handle paramHandle)
  {
    hardwareType = paramHandle;
  }
  
  public void setInverted(boolean paramBoolean)
  {
    inverted = paramBoolean;
  }
  
  public void setKaiResult(Priority paramPriority)
  {
    kaiResult = paramPriority;
  }
  
  public void setLeadsConfig(Direction paramDirection)
  {
    leadsConfig = paramDirection;
  }
  
  public void setLocalRecordingID(String paramString)
  {
    localRecordingID = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResultDetail{bpm=");
    localStringBuilder.append(Text);
    localStringBuilder.append(", kaiResult='");
    localStringBuilder.append(kaiResult);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hardwareType=");
    localStringBuilder.append(hardwareType);
    localStringBuilder.append(", leadsConfig=");
    localStringBuilder.append(leadsConfig);
    localStringBuilder.append(", inverted=");
    localStringBuilder.append(inverted);
    localStringBuilder.append(", localRecordingID='");
    localStringBuilder.append(localRecordingID);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
