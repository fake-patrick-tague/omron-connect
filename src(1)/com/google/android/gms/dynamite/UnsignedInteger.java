package com.google.android.gms.dynamite;

import android.content.Context;

final class UnsignedInteger
  implements DynamiteModule.VersionPolicy
{
  UnsignedInteger() {}
  
  public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context paramContext, String paramString, DynamiteModule.VersionPolicy.IVersions paramIVersions)
    throws DynamiteModule.LoadingException
  {
    DynamiteModule.VersionPolicy.SelectionResult localSelectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
    int i = paramIVersions.b(paramContext, paramString);
    localVersion = i;
    int j = 0;
    if (i != 0)
    {
      k = paramIVersions.b(paramContext, paramString, false);
      i = k;
      remoteVersion = k;
    }
    else
    {
      k = paramIVersions.b(paramContext, paramString, true);
      i = k;
      remoteVersion = k;
    }
    int k = localVersion;
    if (k == 0)
    {
      if (i == 0)
      {
        selection = 0;
        return localSelectionResult;
      }
    }
    else {
      j = k;
    }
    if (i >= j)
    {
      selection = 1;
      return localSelectionResult;
    }
    selection = -1;
    return localSelectionResult;
  }
}
