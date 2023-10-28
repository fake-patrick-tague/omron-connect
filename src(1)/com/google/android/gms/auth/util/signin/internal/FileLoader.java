package com.google.android.gms.auth.util.signin.internal;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import androidx.loader.content.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Set;
import java.util.concurrent.Semaphore;

public final class FileLoader
  extends a<Void>
  implements SignInConnectionListener
{
  private final Set<GoogleApiClient> path;
  private final Semaphore this$0 = new Semaphore(0);
  
  public FileLoader(Context paramContext, Set paramSet)
  {
    super(paramContext);
    path = paramSet;
  }
  
  public final void onComplete()
  {
    this$0.release();
  }
  
  protected final void onStartLoading()
  {
    this$0.drainPermits();
    forceLoad();
  }
}
