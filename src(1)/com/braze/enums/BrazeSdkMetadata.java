package com.braze.enums;

import com.braze.models.IPutIntoJson;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import org.json.JSONArray;

public enum BrazeSdkMetadata
  implements IPutIntoJson<String>
{
  public static final a Companion = new a(null);
  private final String jsonKey;
  
  static
  {
    FLUTTER = new BrazeSdkMetadata("FLUTTER", 9, "ft");
    GRADLE = new BrazeSdkMetadata("GRADLE", 10, "gd");
    GOOGLE = new BrazeSdkMetadata("GOOGLE", 11, "gg");
    GIMBAL = new BrazeSdkMetadata("GIMBAL", 12, "gmb");
    IONIC = new BrazeSdkMetadata("IONIC", 13, "ionc");
    KOCHAVA = new BrazeSdkMetadata("KOCHAVA", 14, "kch");
    MANUAL = new BrazeSdkMetadata("MANUAL", 15, "manu");
    MPARTICLE = new BrazeSdkMetadata("MPARTICLE", 16, "mp");
    picture_thumbnail = new BrazeSdkMetadata("NPM", 17, "npm");
    NATIVESCRIPT = new BrazeSdkMetadata("NATIVESCRIPT", 18, "ns");
    NUGET = new BrazeSdkMetadata("NUGET", 19, "nugt");
    Uploaded = new BrazeSdkMetadata("PUB", 20, "pub");
    RADAR = new BrazeSdkMetadata("RADAR", 21, "rdr");
    REACTNATIVE = new BrazeSdkMetadata("REACTNATIVE", 22, "rn");
    SEGMENT = new BrazeSdkMetadata("SEGMENT", 23, "sg");
    SINGULAR = new BrazeSdkMetadata("SINGULAR", 24, "sng");
    IOERR = new BrazeSdkMetadata("SPM", 25, "spm");
    TEALIUM = new BrazeSdkMetadata("TEALIUM", 26, "tl");
    UNREAL = new BrazeSdkMetadata("UNREAL", 27, "un");
    UNITY_PACKAGE_MANAGER = new BrazeSdkMetadata("UNITY_PACKAGE_MANAGER", 28, "unpm");
    UNITY = new BrazeSdkMetadata("UNITY", 29, "ut");
    VIZBEE = new BrazeSdkMetadata("VIZBEE", 30, "vzb");
    WEBCDN = new BrazeSdkMetadata("WEBCDN", 31, "wcd");
    XAMARIN = new BrazeSdkMetadata("XAMARIN", 32, "xam");
  }
  
  private BrazeSdkMetadata(String paramString)
  {
    jsonKey = paramString;
  }
  
  public String forJsonPut()
  {
    return jsonKey;
  }
  
  public static final class a
  {
    private a() {}
    
    public final JSONArray a(EnumSet paramEnumSet)
    {
      kotlin.x.d.i.e(paramEnumSet, "set");
      ArrayList localArrayList = new ArrayList(kotlin.collections.i.i(paramEnumSet, 10));
      paramEnumSet = paramEnumSet.iterator();
      while (paramEnumSet.hasNext())
      {
        BrazeSdkMetadata localBrazeSdkMetadata = (BrazeSdkMetadata)paramEnumSet.next();
        kotlin.x.d.i.d(localBrazeSdkMetadata, "it");
        localArrayList.add(BrazeSdkMetadata.access$getJsonKey$p(localBrazeSdkMetadata));
      }
      return new JSONArray(kotlin.collections.i.C(localArrayList));
    }
  }
}
