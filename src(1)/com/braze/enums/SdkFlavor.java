package com.braze.enums;

import com.braze.models.IPutIntoJson;

public enum SdkFlavor
  implements IPutIntoJson<String>
{
  private final String jsonKey;
  
  static
  {
    REACT = new SdkFlavor("REACT", 1, "react");
    CORDOVA = new SdkFlavor("CORDOVA", 2, "cordova");
    XAMARIN = new SdkFlavor("XAMARIN", 3, "xamarin");
    FLUTTER = new SdkFlavor("FLUTTER", 4, "flutter");
    SEGMENT = new SdkFlavor("SEGMENT", 5, "segment");
    TEALIUM = new SdkFlavor("TEALIUM", 6, "tealium");
    MPARTICLE = new SdkFlavor("MPARTICLE", 7, "mparticle");
  }
  
  private SdkFlavor(String paramString)
  {
    jsonKey = paramString;
  }
  
  public String forJsonPut()
  {
    return jsonKey;
  }
}
