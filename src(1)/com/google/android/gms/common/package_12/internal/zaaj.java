package com.google.android.gms.common.package_12.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Api.AnyClient;
import com.google.android.gms.common.package_12.Api.Client;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.Status;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zaaj
  implements zabf
{
  private boolean enabled = false;
  private final zabi this$0;
  
  public zaaj(zabi paramZabi)
  {
    this$0 = paramZabi;
  }
  
  public final BaseImplementation.ApiMethodImpl add(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    Object localObject1 = this$0.context.log;
    try
    {
      ((zadc)localObject1).close(paramApiMethodImpl);
      Object localObject2 = this$0.context;
      localObject1 = paramApiMethodImpl.getClientKey();
      localObject2 = data;
      localObject1 = ((Map)localObject2).get(localObject1);
      localObject1 = (Api.Client)localObject1;
      Preconditions.checkNotNull(localObject1, "Appropriate Api was not requested.");
      boolean bool = ((Api.Client)localObject1).isConnected();
      if (!bool)
      {
        localObject2 = this$0.items;
        bool = ((Map)localObject2).containsKey(paramApiMethodImpl.getClientKey());
        if (bool)
        {
          paramApiMethodImpl.setFailedResult(new Status(17));
          return paramApiMethodImpl;
        }
      }
      paramApiMethodImpl.setData((Api.AnyClient)localObject1);
      return paramApiMethodImpl;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      for (;;) {}
    }
    this$0.clear(new zaah(this, this));
    return paramApiMethodImpl;
  }
  
  public final void add(int paramInt)
  {
    this$0.clear(null);
    this$0.r.run(paramInt, enabled);
  }
  
  public final boolean add()
  {
    if (enabled) {
      return false;
    }
    Object localObject = this$0.context.active;
    if ((localObject != null) && (!((Set)localObject).isEmpty()))
    {
      enabled = true;
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((zada)((Iterator)localObject).next()).execute();
      }
      return false;
    }
    this$0.clear(null);
    return true;
  }
  
  final void enable()
  {
    if (enabled)
    {
      enabled = false;
      this$0.context.log.write();
      add();
    }
  }
  
  public final void execute() {}
  
  public final BaseImplementation.ApiMethodImpl pollQueue(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    add(paramApiMethodImpl);
    return paramApiMethodImpl;
  }
  
  public final void refreshAdapter()
  {
    if (enabled)
    {
      enabled = false;
      this$0.clear(new zaai(this, this));
    }
  }
  
  public final void update(Bundle paramBundle) {}
  
  public final void write(ConnectionResult paramConnectionResult, Attribute paramAttribute, boolean paramBoolean) {}
}
