package com.braze.enums.inappmessage;

import com.braze.models.IPutIntoJson;
import kotlin.k;

public enum InAppMessageFailureType
  implements IPutIntoJson<String>
{
  static
  {
    DISPLAY_VIEW_GENERATION = new InAppMessageFailureType("DISPLAY_VIEW_GENERATION", 3);
    INTERNAL_TIMEOUT_EXCEEDED = new InAppMessageFailureType("INTERNAL_TIMEOUT_EXCEEDED", 4);
    UNKNOWN_MESSAGE_TYPE = new InAppMessageFailureType("UNKNOWN_MESSAGE_TYPE", 5);
  }
  
  public String forJsonPut()
  {
    switch (a.DIGITS_POWER[ordinal()])
    {
    default: 
      throw ((Throwable)new k());
    case 6: 
      return "umt";
    case 5: 
      return "te";
    case 4: 
      return "vf";
    case 3: 
      return "zf";
    case 2: 
      return "tf";
    }
    return "if";
  }
}
