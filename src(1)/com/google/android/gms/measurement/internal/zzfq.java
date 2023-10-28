package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.common.R.string;

public final class zzfq
{
  public static String build(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getResources();
      int i = R.string.common_google_play_services_unknown_issue;
      localObject = ((Resources)localObject).getResourcePackageName(i);
      return localObject;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;) {}
    }
    return paramContext.getPackageName();
  }
  
  public static final String get(String paramString1, Resources paramResources, String paramString2)
  {
    int i = paramResources.getIdentifier(paramString1, "string", paramString2);
    if (i == 0) {
      return null;
    }
    try
    {
      paramString1 = paramResources.getString(i);
      return paramString1;
    }
    catch (Resources.NotFoundException paramString1) {}
    return null;
  }
}
