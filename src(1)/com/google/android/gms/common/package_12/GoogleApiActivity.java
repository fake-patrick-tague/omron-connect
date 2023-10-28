package com.google.android.gms.common.package_12;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.BaseBundle;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.internal.GoogleApiManager;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepName
public class GoogleApiActivity
  extends Activity
  implements DialogInterface.OnCancelListener
{
  @VisibleForTesting
  protected int a = 0;
  
  public GoogleApiActivity() {}
  
  private final void init()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      Log.e("GoogleApiActivity", "Activity started without extras");
      finish();
      return;
    }
    Object localObject2 = (PendingIntent)localBundle.get("pending_intent");
    Integer localInteger = (Integer)localBundle.get("error_code");
    if ((localObject2 == null) && (localInteger == null))
    {
      Log.e("GoogleApiActivity", "Activity started without resolution");
      finish();
      return;
    }
    if (localObject2 != null) {
      try
      {
        startIntentSenderForResult(((PendingIntent)localObject2).getIntentSender(), 1, null, 0, 0, 0);
        a = 1;
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        Log.e("GoogleApiActivity", "Failed to launch pendingIntent", localSendIntentException);
        finish();
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        if (localSendIntentException.getBoolean("notify_manager", true))
        {
          GoogleApiManager.open(this).close(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
        }
        else
        {
          Object localObject1 = localObject2.toString();
          localObject2 = new StringBuilder(((String)localObject1).length() + 36);
          ((StringBuilder)localObject2).append("Activity not found while launching ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(".");
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject1 = localObject2;
          if (Build.FINGERPRINT.contains("generic")) {
            localObject1 = ((String)localObject2).concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
          }
          Log.e("GoogleApiActivity", (String)localObject1, localActivityNotFoundException);
        }
        a = 1;
        finish();
        return;
      }
    }
    int i = ((Integer)Preconditions.checkNotNull(localActivityNotFoundException)).intValue();
    GoogleApiAvailability.getInstance().showErrorDialogFragment(this, i, 2, this);
    a = 1;
  }
  
  public static Intent start(Context paramContext, PendingIntent paramPendingIntent, int paramInt, boolean paramBoolean)
  {
    paramContext = new Intent(paramContext, com.google.android.gms.common.api.GoogleApiActivity.class);
    paramContext.putExtra("pending_intent", paramPendingIntent);
    paramContext.putExtra("failing_client_id", paramInt);
    paramContext.putExtra("notify_manager", paramBoolean);
    return paramContext;
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      a = 0;
      setResult(paramInt2, paramIntent);
      if (bool)
      {
        paramIntent = GoogleApiManager.open(this);
        if (paramInt2 != -1)
        {
          if (paramInt2 == 0) {
            paramIntent.close(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
          }
        }
        else {
          paramIntent.close();
        }
      }
    }
    else if (paramInt1 == 2)
    {
      a = 0;
      setResult(paramInt2, paramIntent);
    }
    finish();
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a = 0;
    setResult(0);
    finish();
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      a = paramBundle.getInt("resolution");
    }
    if (a != 1) {
      init();
    }
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("resolution", a);
    super.onSaveInstanceState(paramBundle);
  }
}
