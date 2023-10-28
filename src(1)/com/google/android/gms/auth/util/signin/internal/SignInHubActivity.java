package com.google.android.gms.auth.util.signin.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.activity.ComponentActivity;
import androidx.fragment.package_11.FragmentActivity;
import com.google.android.gms.auth.util.signin.GoogleSignInAccount;
import com.google.android.gms.auth.util.signin.GoogleSignInOptions;
import com.google.android.gms.auth.util.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.package_12.Status;
import java.util.Objects;
import v7.v13.app.LoaderManager;

@KeepName
public class SignInHubActivity
  extends FragmentActivity
{
  private static boolean gesture;
  private boolean a = false;
  private int color;
  private Intent data;
  private SignInConfiguration fragment;
  private boolean mAutoplay;
  
  public SignInHubActivity() {}
  
  private final void add(int paramInt)
  {
    Status localStatus = new Status(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("googleSignInStatus", localStatus);
    setResult(0, localIntent);
    finish();
    gesture = false;
  }
  
  private final void connect(String paramString)
  {
    Intent localIntent = new Intent(paramString);
    if (paramString.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
      localIntent.setPackage("com.google.android.gms");
    } else {
      localIntent.setPackage(getPackageName());
    }
    localIntent.putExtra("config", fragment);
    try
    {
      startActivityForResult(localIntent, 40962);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      for (;;) {}
    }
    a = true;
    Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
    add(17);
  }
  
  private final void onCreate()
  {
    getSupportLoaderManager().initLoader(0, null, new ArenaQuestDetailFragment.ArenaQuestLoaderCallbacks(this, null));
    gesture = false;
  }
  
  public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return true;
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (a) {
      return;
    }
    setResult(0);
    if (paramInt1 != 40962) {
      return;
    }
    if (paramIntent != null)
    {
      Object localObject = (SignInAccount)paramIntent.getParcelableExtra("signInAccount");
      if ((localObject != null) && (((SignInAccount)localObject).getLanguage() != null))
      {
        localObject = ((SignInAccount)localObject).getLanguage();
        ByteArrayPool localByteArrayPool = ByteArrayPool.get(this);
        GoogleSignInOptions localGoogleSignInOptions = fragment.isAdded();
        Objects.requireNonNull(localObject);
        localByteArrayPool.trim(localGoogleSignInOptions, (GoogleSignInAccount)localObject);
        paramIntent.removeExtra("signInAccount");
        paramIntent.putExtra("googleSignInAccount", (Parcelable)localObject);
        mAutoplay = true;
        color = paramInt2;
        data = paramIntent;
        onCreate();
        return;
      }
      if (paramIntent.hasExtra("errorCode"))
      {
        paramInt2 = paramIntent.getIntExtra("errorCode", 8);
        paramInt1 = paramInt2;
        if (paramInt2 == 13) {
          paramInt1 = 12501;
        }
        add(paramInt1);
        return;
      }
    }
    add(8);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getIntent();
    String str = ((Intent)localObject).getAction();
    Objects.requireNonNull(str);
    if ("com.google.android.gms.auth.NO_IMPL".equals(str))
    {
      add(12500);
      return;
    }
    if ((!str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) && (!str.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")))
    {
      paramBundle = String.valueOf(((Intent)localObject).getAction());
      if (paramBundle.length() != 0) {
        paramBundle = "Unknown action: ".concat(paramBundle);
      } else {
        paramBundle = new String("Unknown action: ");
      }
      Log.e("AuthSignInClient", paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getBundleExtra("config");
    Objects.requireNonNull(localObject);
    localObject = (SignInConfiguration)((Bundle)localObject).getParcelable("config");
    if (localObject == null)
    {
      Log.e("AuthSignInClient", "Activity started with invalid configuration.");
      setResult(0);
      finish();
      return;
    }
    fragment = ((SignInConfiguration)localObject);
    if (paramBundle == null)
    {
      if (gesture)
      {
        setResult(0);
        add(12502);
        return;
      }
      gesture = true;
      connect(str);
      return;
    }
    boolean bool = paramBundle.getBoolean("signingInGoogleApiClients");
    mAutoplay = bool;
    if (bool)
    {
      color = paramBundle.getInt("signInResultCode");
      paramBundle = (Intent)paramBundle.getParcelable("signInResultData");
      Objects.requireNonNull(paramBundle);
      data = paramBundle;
      onCreate();
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    gesture = false;
  }
  
  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("signingInGoogleApiClients", mAutoplay);
    if (mAutoplay)
    {
      paramBundle.putInt("signInResultCode", color);
      paramBundle.putParcelable("signInResultData", data);
    }
  }
}
