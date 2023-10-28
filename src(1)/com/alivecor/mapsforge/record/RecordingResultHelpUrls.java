package com.alivecor.mapsforge.record;

import com.alivecor.asm.Priority;
import java.io.Serializable;

public class RecordingResultHelpUrls
  implements Serializable
{
  private final String allURLs = "https://alivecor.zendesk.com/hc/en-us/sections/360012449913-Learn-More-about-Kardia-Instant-Analysis-";
  private final String baseURL = "https://alivecor.com/app-redirect";
  public String learnAfib = "https://alivecor.com/app-redirect/learnmore_possafib";
  public String learnBradycardia = "https://alivecor.com/app-redirect/learnmore_bradycardia";
  public String learnLong = null;
  public String learnNoAnalysis = null;
  public String learnNormal = "https://alivecor.com/app-redirect/learnmore_normal";
  public String learnShort = null;
  public String learnTachycardia = "https://alivecor.com/app-redirect/learnmore_tachycardia";
  public String learnUnclassified = "https://alivecor.com/app-redirect/learnmore_unclassified";
  public String learnUnreadable = "https://alivecor.com/app-redirect/learnmore_unreadable";
  
  public RecordingResultHelpUrls() {}
  
  public String getMatchingRule(Priority paramPriority)
  {
    switch (1.$SwitchMap$com$alivecor$ai$Determination[paramPriority.ordinal()])
    {
    default: 
      return null;
    case 9: 
      return learnNoAnalysis;
    case 8: 
      return learnUnreadable;
    case 7: 
      return learnLong;
    case 6: 
      return learnShort;
    case 5: 
      return learnTachycardia;
    case 4: 
      return learnBradycardia;
    case 3: 
      return learnUnclassified;
    case 2: 
      return learnAfib;
    }
    return learnNormal;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordingResultHelpUrls{baseURL='https://alivecor.com/app-redirect', learnNormal='");
    localStringBuilder.append(learnNormal);
    localStringBuilder.append('\'');
    localStringBuilder.append(", learnfib='");
    localStringBuilder.append(learnAfib);
    localStringBuilder.append('\'');
    localStringBuilder.append(", learnUnclassified='");
    localStringBuilder.append(learnUnclassified);
    localStringBuilder.append('\'');
    localStringBuilder.append(", learnBradycardia='");
    localStringBuilder.append(learnBradycardia);
    localStringBuilder.append('\'');
    localStringBuilder.append(", learnTachycardia='");
    localStringBuilder.append(learnTachycardia);
    localStringBuilder.append('\'');
    localStringBuilder.append(", learnUnreadable='");
    localStringBuilder.append(learnUnreadable);
    localStringBuilder.append('\'');
    localStringBuilder.append(", learnNoAnalysis='");
    localStringBuilder.append(learnNoAnalysis);
    localStringBuilder.append('\'');
    localStringBuilder.append(", learnShort='");
    localStringBuilder.append(learnShort);
    localStringBuilder.append('\'');
    localStringBuilder.append(", learnLong='");
    localStringBuilder.append(learnLong);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
