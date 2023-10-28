package com.google.android.gms.internal.measurement;

import android.net.Uri;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;

public final class zzhp
{
  private static final ArrayMap refs = new ArrayMap();
  
  public static Uri create(String paramString)
  {
    try
    {
      paramString = refs;
      Uri localUri = (Uri)paramString.get("com.google.android.gms.measurement");
      if (localUri == null)
      {
        localUri = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
        paramString.put("com.google.android.gms.measurement", localUri);
        return localUri;
      }
      return localUri;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
}
