package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.MultiMap;
import com.google.android.gms.signin.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zaao
  extends zaav
{
  private final Map<com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.api.internal.zaal> props;
  
  public zaao(zaaw paramZaaw, Map paramMap)
  {
    super(paramZaaw, null);
    props = paramMap;
  }
  
  public final void parse()
  {
    Object localObject1 = new MultiMap(zaaw.access$getUpdater(this$0));
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    Object localObject4 = props.keySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      com.google.android.gms.common.package_12.Api.Client localClient = (com.google.android.gms.common.package_12.Api.Client)((Iterator)localObject4).next();
      if ((localClient.requiresGooglePlayServices()) && (!zaal.getPodcastPath((zaal)props.get(localClient)))) {
        ((List)localObject2).add(localClient);
      } else {
        ((List)localObject3).add(localClient);
      }
    }
    boolean bool = ((List)localObject2).isEmpty();
    int i = -1;
    int j = 0;
    int k = 0;
    int n;
    int m;
    if (bool)
    {
      n = ((List)localObject3).size();
      do
      {
        if (k >= n) {
          break;
        }
        localObject2 = (com.google.android.gms.common.package_12.Api.Client)((List)localObject3).get(k);
        m = ((MultiMap)localObject1).add(zaaw.getInstance(this$0), (com.google.android.gms.common.package_12.Api.Client)localObject2);
        j = m;
        k += 1;
        i = j;
      } while (m != 0);
      i = j;
    }
    else
    {
      n = ((List)localObject2).size();
      k = j;
      while (k < n)
      {
        localObject3 = (com.google.android.gms.common.package_12.Api.Client)((List)localObject2).get(k);
        m = ((MultiMap)localObject1).add(zaaw.getInstance(this$0), (com.google.android.gms.common.package_12.Api.Client)localObject3);
        j = m;
        k += 1;
        i = j;
        if (m != 0) {
          i = j;
        }
      }
    }
    if (i != 0)
    {
      localObject1 = new ConnectionResult(i, null);
      localObject2 = this$0;
      zaaw.append((zaaw)localObject2).clear(new zaam(this, (zabf)localObject2, (ConnectionResult)localObject1));
      return;
    }
    localObject2 = this$0;
    if ((zaaw.id((zaaw)localObject2)) && (zaaw.access$getConnection((zaaw)localObject2) != null)) {
      zaaw.access$getConnection((zaaw)localObject2).connect();
    }
    localObject2 = props.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (com.google.android.gms.common.package_12.Api.Client)((Iterator)localObject2).next();
      localObject3 = (BaseGmsClient.ConnectionProgressReportCallbacks)props.get(localObject4);
      if ((((com.google.android.gms.common.package_12.Api.Client)localObject4).requiresGooglePlayServices()) && (((MultiMap)localObject1).add(zaaw.getInstance(this$0), (com.google.android.gms.common.package_12.Api.Client)localObject4) != 0))
      {
        localObject4 = this$0;
        zaaw.append((zaaw)localObject4).clear(new zaan(this, (zabf)localObject4, (BaseGmsClient.ConnectionProgressReportCallbacks)localObject3));
      }
      else
      {
        ((com.google.android.gms.common.package_12.Api.Client)localObject4).connect((BaseGmsClient.ConnectionProgressReportCallbacks)localObject3);
      }
    }
  }
}
