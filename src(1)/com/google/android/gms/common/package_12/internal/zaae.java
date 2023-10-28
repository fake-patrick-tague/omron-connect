package com.google.android.gms.common.package_12.internal;

import android.app.Activity;
import c.e.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Preconditions;
import v7.util.TLongArrayList;

public final class zaae
  extends FragmentActivity
{
  private final b<com.google.android.gms.common.api.internal.ApiKey<?>> added = new TLongArrayList();
  private final GoogleApiManager handler;
  
  zaae(LifecycleFragment paramLifecycleFragment, GoogleApiManager paramGoogleApiManager, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramLifecycleFragment, paramGoogleApiAvailability);
    handler = paramGoogleApiManager;
    mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
  }
  
  private final void clear()
  {
    if (!added.isEmpty()) {
      handler.start(this);
    }
  }
  
  public static void toString(Activity paramActivity, GoogleApiManager paramGoogleApiManager, ApiKey paramApiKey)
  {
    LifecycleFragment localLifecycleFragment = LifecycleCallback.getFragment(paramActivity);
    zaae localZaae = (zaae)localLifecycleFragment.getCallbackOrNull("ConnectionlessLifecycleHelper", com.google.android.gms.common.api.internal.zaae.class);
    paramActivity = localZaae;
    if (localZaae == null) {
      paramActivity = new zaae(localLifecycleFragment, paramGoogleApiManager, GoogleApiAvailability.getInstance());
    }
    Preconditions.checkNotNull(paramApiKey, "ApiKey cannot be null");
    added.add(paramApiKey);
    paramGoogleApiManager.start(paramActivity);
  }
  
  final TLongArrayList getAdded()
  {
    return added;
  }
  
  protected final void onCreate(ConnectionResult paramConnectionResult, int paramInt)
  {
    handler.close(paramConnectionResult, paramInt);
  }
  
  protected final void onPostExecute()
  {
    handler.close();
  }
  
  public final void onResume()
  {
    super.onResume();
    clear();
  }
  
  public final void onStart()
  {
    super.onStart();
    clear();
  }
  
  public final void onStop()
  {
    super.onStop();
    handler.release(this);
  }
}
