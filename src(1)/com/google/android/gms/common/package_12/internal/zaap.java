package com.google.android.gms.common.package_12.internal;

import java.util.ArrayList;
import java.util.List;

final class zaap
  extends zaav
{
  private final ArrayList<com.google.android.gms.common.api.Api.Client> tags;
  
  public zaap(zaaw paramZaaw, ArrayList paramArrayList)
  {
    super(paramZaaw, null);
    tags = paramArrayList;
  }
  
  public final void parse()
  {
    Object localObject = url;
    appendcontext.tag = zaaw.get((zaaw)localObject);
    localObject = tags;
    int j = ((List)localObject).size();
    int i = 0;
    while (i < j)
    {
      com.google.android.gms.common.package_12.Api.Client localClient = (com.google.android.gms.common.package_12.Api.Client)((List)localObject).get(i);
      zaaw localZaaw = url;
      localClient.getRemoteService(zaaw.host(localZaaw), appendcontext.tag);
      i += 1;
    }
  }
}
