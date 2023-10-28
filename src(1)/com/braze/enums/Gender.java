package com.braze.enums;

import com.braze.models.IPutIntoJson;

public enum Gender
  implements IPutIntoJson<String>
{
  public static final Companion Companion = new Companion(null);
  private final String value;
  
  static
  {
    FEMALE = new Gender("FEMALE", 1, "f");
    OTHER = new Gender("OTHER", 2, "o");
    UNKNOWN = new Gender("UNKNOWN", 3, "u");
    NOT_APPLICABLE = new Gender("NOT_APPLICABLE", 4, "n");
    PREFER_NOT_TO_SAY = new Gender("PREFER_NOT_TO_SAY", 5, "p");
  }
  
  private Gender(String paramString)
  {
    value = paramString;
  }
  
  public String forJsonPut()
  {
    return value;
  }
  
  public static final class Companion
  {
    private Companion() {}
  }
}
