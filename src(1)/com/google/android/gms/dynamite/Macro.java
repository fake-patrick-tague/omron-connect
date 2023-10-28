package com.google.android.gms.dynamite;

import android.content.Context;

final class Macro
  implements DynamiteModule.VersionPolicy
{
  Macro() {}
  
  public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context paramContext, String paramString, DynamiteModule.VersionPolicy.IVersions paramIVersions)
    throws DynamiteModule.LoadingException
  {
    DynamiteModule.VersionPolicy.SelectionResult localSelectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
    int i = paramIVersions.b(paramContext, paramString, true);
    remoteVersion = i;
    if (i != 0)
    {
      selection = 1;
      return localSelectionResult;
    }
    i = paramIVersions.b(paramContext, paramString);
    localVersion = i;
    if (i != 0) {
      selection = -1;
    }
    return localSelectionResult;
  }
}
