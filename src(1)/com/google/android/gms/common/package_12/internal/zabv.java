package com.google.android.gms.common.package_12.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabv<O extends Api.ApiOptions>
  extends com.google.android.gms.common.api.internal.zaag
{
  @NotOnlyInitialized
  private final com.google.android.gms.common.api.GoogleApi<O> this$0;
  
  public zabv(com.google.android.gms.common.package_12.GoogleApi paramGoogleApi)
  {
    super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    this$0 = paramGoogleApi;
  }
  
  public final BaseImplementation.ApiMethodImpl enqueue(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    return this$0.doRead(paramApiMethodImpl);
  }
  
  public final BaseImplementation.ApiMethodImpl execute(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    return this$0.doWrite(paramApiMethodImpl);
  }
  
  public final void get(zada paramZada) {}
  
  public final Context getContext()
  {
    return this$0.getApplicationContext();
  }
  
  public final Looper getLooper()
  {
    return this$0.getLooper();
  }
  
  public final void shutdown(zada paramZada) {}
}
