package com.google.android.gms.common.package_12.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zam;
import com.google.android.gms.internal.base.Logger;
import java.util.concurrent.atomic.AtomicReference;

public abstract class FragmentActivity
  extends LifecycleCallback
  implements DialogInterface.OnCancelListener
{
  protected volatile boolean active;
  private final Handler eventHandler = new Logger(Looper.getMainLooper());
  protected final GoogleApiAvailability index;
  protected final AtomicReference<zam> state = new AtomicReference(null);
  
  FragmentActivity(LifecycleFragment paramLifecycleFragment, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramLifecycleFragment);
    index = paramGoogleApiAvailability;
  }
  
  private static final int getId(User paramUser)
  {
    if (paramUser == null) {
      return -1;
    }
    return paramUser.getId();
  }
  
  private final void onSaveInstanceState()
  {
    state.set(null);
    onPostExecute();
  }
  
  private final void setTitle(ConnectionResult paramConnectionResult, int paramInt)
  {
    state.set(null);
    onCreate(paramConnectionResult, paramInt);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    User localUser = (User)state.get();
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2)
      {
        paramInt1 = index.isGooglePlayServicesAvailable(getActivity());
        if (paramInt1 == 0)
        {
          onSaveInstanceState();
          return;
        }
        if (localUser == null) {
          return;
        }
        if ((localUser.getName().getErrorCode() != 18) || (paramInt1 != 18)) {}
      }
    }
    else
    {
      if (paramInt2 == -1)
      {
        onSaveInstanceState();
        return;
      }
      if (paramInt2 == 0)
      {
        if (localUser == null) {
          return;
        }
        paramInt1 = 13;
        if (paramIntent != null) {
          paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
        }
        setTitle(new ConnectionResult(paramInt1, null, localUser.getName().toString()), getId(localUser));
        return;
      }
    }
    if (localUser != null) {
      setTitle(localUser.getName(), localUser.getId());
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    setTitle(new ConnectionResult(13, null), getId((User)state.get()));
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      AtomicReference localAtomicReference = state;
      if (paramBundle.getBoolean("resolving_error", false)) {
        paramBundle = new User(new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution")), paramBundle.getInt("failed_client_id", -1));
      } else {
        paramBundle = null;
      }
      localAtomicReference.set(paramBundle);
    }
  }
  
  protected abstract void onCreate(ConnectionResult paramConnectionResult, int paramInt);
  
  public final void onError(ConnectionResult paramConnectionResult, int paramInt)
  {
    paramConnectionResult = new User(paramConnectionResult, paramInt);
    if (state.compareAndSet(null, paramConnectionResult)) {
      eventHandler.post(new InstallerGUI.11(this, paramConnectionResult));
    }
  }
  
  protected abstract void onPostExecute();
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    User localUser = (User)state.get();
    if (localUser == null) {
      return;
    }
    paramBundle.putBoolean("resolving_error", true);
    paramBundle.putInt("failed_client_id", localUser.getId());
    paramBundle.putInt("failed_status", localUser.getName().getErrorCode());
    paramBundle.putParcelable("failed_resolution", localUser.getName().getResolution());
  }
  
  public void onStart()
  {
    super.onStart();
    active = true;
  }
  
  public void onStop()
  {
    super.onStop();
    active = false;
  }
}
