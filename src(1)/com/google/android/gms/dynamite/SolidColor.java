package com.google.android.gms.dynamite;

import android.content.Context;

final class SolidColor
  implements DynamiteModule.VersionPolicy
{
  SolidColor() {}
  
  public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context paramContext, String paramString, DynamiteModule.VersionPolicy.IVersions paramIVersions)
    throws DynamiteModule.LoadingException
  {
    DynamiteModule.VersionPolicy.SelectionResult localSelectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
    localVersion = paramIVersions.b(paramContext, paramString);
    int k = paramIVersions.b(paramContext, paramString, true);
    remoteVersion = k;
    int j = localVersion;
    int i = j;
    if (j == 0)
    {
      if (k == 0)
      {
        selection = 0;
        return localSelectionResult;
      }
      i = 0;
    }
    if (k >= i)
    {
      selection = 1;
      return localSelectionResult;
    }
    selection = -1;
    return localSelectionResult;
  }
}
