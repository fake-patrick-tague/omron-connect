package com.google.android.gms.common.package_12.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.package_12.Api.Client;
import com.google.android.gms.common.package_12.Attribute;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zaax
  implements zabf
{
  @NotOnlyInitialized
  private final zabi this$0;
  
  public zaax(zabi paramZabi)
  {
    this$0 = paramZabi;
  }
  
  public final BaseImplementation.ApiMethodImpl add(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final void add(int paramInt) {}
  
  public final boolean add()
  {
    return true;
  }
  
  public final void execute()
  {
    Iterator localIterator = this$0.delegate.values().iterator();
    while (localIterator.hasNext()) {
      ((Api.Client)localIterator.next()).disconnect();
    }
    this$0.context.tag = Collections.emptySet();
  }
  
  public final BaseImplementation.ApiMethodImpl pollQueue(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    this$0.context.queue.add(paramApiMethodImpl);
    return paramApiMethodImpl;
  }
  
  public final void refreshAdapter()
  {
    this$0.clear();
  }
  
  public final void update(Bundle paramBundle) {}
  
  public final void write(ConnectionResult paramConnectionResult, Attribute paramAttribute, boolean paramBoolean) {}
}
