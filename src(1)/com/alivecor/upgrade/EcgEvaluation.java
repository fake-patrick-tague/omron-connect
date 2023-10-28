package com.alivecor.upgrade;

import android.content.Context;
import com.alivecor.alivecorkitlite.R.string;
import java.io.Serializable;

public class EcgEvaluation
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Float averageHeartRate;
  private AliveCorDetermination determination;
  private boolean isInverted;
  private String kardiaAiVersion;
  
  public EcgEvaluation() {}
  
  EcgEvaluation(AliveCorDetermination paramAliveCorDetermination, String paramString, Float paramFloat, boolean paramBoolean)
  {
    determination = paramAliveCorDetermination;
    kardiaAiVersion = paramString;
    averageHeartRate = paramFloat;
    isInverted = paramBoolean;
  }
  
  public CharSequence getAlgorithmResultDescription()
  {
    if (determination != null) {
      return InternalRecordApiUtil._().context().getString(InternalRecordApiUtil._().getAnalysisMessage(determination));
    }
    return null;
  }
  
  public CharSequence getAlgorithmResultText()
  {
    if (determination != null) {
      return InternalRecordApiUtil._().context().getString(InternalRecordApiUtil._().getAnalysisText(determination));
    }
    return null;
  }
  
  public Float getAverageHeartRate()
  {
    return averageHeartRate;
  }
  
  public AliveCorDetermination getDetermination()
  {
    return determination;
  }
  
  public String getKaiResult()
  {
    if (determination != null) {
      return InternalRecordApiUtil._().getAnalysisString(determination);
    }
    return null;
  }
  
  public String getKardiaAiVersion()
  {
    return kardiaAiVersion;
  }
  
  public int getResultColor()
  {
    if (determination != null) {
      return InternalRecordApiUtil._().getAnalysisColor(determination);
    }
    return 0;
  }
  
  public CharSequence getResultDisclaimerText()
  {
    switch (1.$SwitchMap$com$alivecor$api$AliveCorDetermination[determination.ordinal()])
    {
    default: 
      return null;
    }
    InternalRecordApiUtil localInternalRecordApiUtil = InternalRecordApiUtil._();
    return localInternalRecordApiUtil.context().getString(R.string.nsr_disclaimer, new Object[] { localInternalRecordApiUtil.appName() });
  }
  
  public boolean isInverted()
  {
    return isInverted;
  }
  
  public void setAverageHeartRate(Float paramFloat)
  {
    averageHeartRate = paramFloat;
  }
  
  public void setDetermination(AliveCorDetermination paramAliveCorDetermination)
  {
    determination = paramAliveCorDetermination;
  }
  
  public void setInverted(boolean paramBoolean)
  {
    isInverted = paramBoolean;
  }
  
  public void setKaiResult(String paramString)
  {
    determination = InternalRecordApiUtil._().determinationFromString(paramString);
  }
  
  public void setKardiaAiVersion(String paramString)
  {
    kardiaAiVersion = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EcgEvaluation{determination=");
    localStringBuilder.append(determination);
    localStringBuilder.append(", kaiResult=");
    localStringBuilder.append(getKaiResult());
    localStringBuilder.append(", kardiaAiVersion='");
    localStringBuilder.append(kardiaAiVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append(", averageHeartRate=");
    localStringBuilder.append(averageHeartRate);
    localStringBuilder.append(", isInverted=");
    localStringBuilder.append(isInverted);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
