package com.google.android.gms.dynamite;

import android.content.Context;

final class Configurator
  implements DynamiteModule.VersionPolicy.IVersions
{
  Configurator() {}
  
  public final int b(Context paramContext, String paramString)
  {
    return DynamiteModule.getLocalVersion(paramContext, paramString);
  }
  
  public final int b(Context paramContext, String paramString, boolean paramBoolean)
    throws DynamiteModule.LoadingException
  {
    return DynamiteModule.get(paramContext, paramString, paramBoolean);
  }
}
