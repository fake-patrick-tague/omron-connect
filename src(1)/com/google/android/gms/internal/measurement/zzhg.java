package com.google.android.gms.internal.measurement;

import android.net.Uri;
import v7.util.SimpleArrayMap;

public final class zzhg
{
  private final SimpleArrayMap cache;
  
  zzhg(SimpleArrayMap paramSimpleArrayMap)
  {
    cache = paramSimpleArrayMap;
  }
  
  public final String toString(Uri paramUri, String paramString1, String paramString2, String paramString3)
  {
    if (paramUri != null)
    {
      paramUri = paramUri.toString();
      paramUri = (SimpleArrayMap)cache.get(paramUri);
      if (paramUri == null) {
        return null;
      }
      return (String)paramUri.get("".concat(String.valueOf(paramString3)));
    }
    return null;
  }
}
