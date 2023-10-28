package com.google.android.gms.common.package_12.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zaj;
import com.google.android.gms.common.api.internal.zak;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicReference;

public final class MainActivity
  extends FragmentActivity
{
  private final SparseArray<zaj> this$0 = new SparseArray();
  
  private MainActivity(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment, GoogleApiAvailability.getInstance());
    mLifecycleFragment.addCallback("AutoManageHelper", this);
  }
  
  private final Event get(int paramInt)
  {
    if (this$0.size() <= paramInt) {
      return null;
    }
    SparseArray localSparseArray = this$0;
    return (Event)localSparseArray.get(localSparseArray.keyAt(paramInt));
  }
  
  public static MainActivity removeTab(LifecycleActivity paramLifecycleActivity)
  {
    paramLifecycleActivity = LifecycleCallback.getFragment(paramLifecycleActivity);
    MainActivity localMainActivity = (MainActivity)paramLifecycleActivity.getCallbackOrNull("AutoManageHelper", zak.class);
    if (localMainActivity != null) {
      return localMainActivity;
    }
    return new MainActivity(paramLifecycleActivity);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < this$0.size())
    {
      Event localEvent = get(i);
      if (localEvent != null)
      {
        paramPrintWriter.append(paramString).append("GoogleApiClient #").print(err);
        paramPrintWriter.println(":");
        name.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      i += 1;
    }
  }
  
  public final void get(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this$0.indexOfKey(paramInt) < 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder(54);
    ((StringBuilder)localObject).append("Already managing a GoogleApiClient with id ");
    ((StringBuilder)localObject).append(paramInt);
    Preconditions.checkState(bool, ((StringBuilder)localObject).toString());
    localObject = (User)state.get();
    boolean bool = active;
    String str = String.valueOf(localObject);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 49);
    localStringBuilder.append("starting AutoManage for client ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    Log.d("AutoManageHelper", localStringBuilder.toString());
    paramOnConnectionFailedListener = new Event(this, paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
    paramGoogleApiClient.registerConnectionFailedListener(paramOnConnectionFailedListener);
    this$0.put(paramInt, paramOnConnectionFailedListener);
    if ((active) && (localObject == null))
    {
      Log.d("AutoManageHelper", "connecting ".concat(paramGoogleApiClient.toString()));
      paramGoogleApiClient.connect();
    }
  }
  
  public final void onCreate(int paramInt)
  {
    Event localEvent = (Event)this$0.get(paramInt);
    this$0.remove(paramInt);
    if (localEvent != null)
    {
      name.unregisterConnectionFailedListener(localEvent);
      name.disconnect();
    }
  }
  
  protected final void onCreate(ConnectionResult paramConnectionResult, int paramInt)
  {
    Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
    if (paramInt < 0)
    {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
      return;
    }
    Object localObject = (Event)this$0.get(paramInt);
    if (localObject != null)
    {
      onCreate(paramInt);
      localObject = code;
      if (localObject != null) {
        ((OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
      }
    }
  }
  
  protected final void onPostExecute()
  {
    int i = 0;
    while (i < this$0.size())
    {
      Event localEvent = get(i);
      if (localEvent != null) {
        name.connect();
      }
      i += 1;
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    boolean bool = active;
    Object localObject = String.valueOf(this$0);
    StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 14);
    localStringBuilder.append("onStart ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" ");
    localStringBuilder.append((String)localObject);
    Log.d("AutoManageHelper", localStringBuilder.toString());
    if (state.get() == null)
    {
      int i = 0;
      while (i < this$0.size())
      {
        localObject = get(i);
        if (localObject != null) {
          name.connect();
        }
        i += 1;
      }
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    int i = 0;
    while (i < this$0.size())
    {
      Event localEvent = get(i);
      if (localEvent != null) {
        name.disconnect();
      }
      i += 1;
    }
  }
}
