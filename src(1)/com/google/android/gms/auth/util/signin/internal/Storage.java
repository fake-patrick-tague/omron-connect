package com.google.android.gms.auth.util.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.util.signin.GoogleSignInAccount;
import com.google.android.gms.auth.util.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

@KeepForSdk
public class Storage
{
  private static Storage instance;
  private static final Lock lock = new ReentrantLock();
  private final SharedPreferences preferences;
  private final Lock this$0 = new ReentrantLock();
  
  Storage(Context paramContext)
  {
    preferences = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  public static Storage getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    Lock localLock = lock;
    localLock.lock();
    try
    {
      Storage localStorage = instance;
      if (localStorage == null) {
        instance = new Storage(paramContext.getApplicationContext());
      }
      paramContext = instance;
      localLock.unlock();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      lock.unlock();
      throw paramContext;
    }
  }
  
  private static final String readString(String paramString1, String paramString2)
  {
    int i = String.valueOf(paramString2).length();
    StringBuilder localStringBuilder = new StringBuilder(paramString1.length() + 1 + i);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public void clear()
  {
    this$0.lock();
    try
    {
      preferences.edit().clear().apply();
      this$0.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public final void execute()
  {
    String str = get("defaultGoogleSignInAccount");
    put("defaultGoogleSignInAccount");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    put(readString("googleSignInAccount", str));
    put(readString("googleSignInOptions", str));
  }
  
  protected final String get(String paramString)
  {
    this$0.lock();
    try
    {
      paramString = preferences.getString(paramString, null);
      this$0.unlock();
      return paramString;
    }
    catch (Throwable paramString)
    {
      this$0.unlock();
      throw paramString;
    }
  }
  
  public GoogleSignInAccount getSavedDefaultGoogleSignInAccount()
  {
    Object localObject = get("defaultGoogleSignInAccount");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = get(readString("googleSignInAccount", (String)localObject));
    if (localObject != null) {
      try
      {
        localObject = GoogleSignInAccount.doInBackground((String)localObject);
        return localObject;
      }
      catch (JSONException localJSONException) {}
    }
    return null;
  }
  
  public GoogleSignInOptions getSavedDefaultGoogleSignInOptions()
  {
    Object localObject = get("defaultGoogleSignInAccount");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = get(readString("googleSignInOptions", (String)localObject));
    if (localObject != null) {
      try
      {
        localObject = GoogleSignInOptions.doInBackground((String)localObject);
        return localObject;
      }
      catch (JSONException localJSONException) {}
    }
    return null;
  }
  
  public String getSavedRefreshToken()
  {
    return get("refreshToken");
  }
  
  protected final void put(String paramString)
  {
    this$0.lock();
    try
    {
      preferences.edit().remove(paramString).apply();
      this$0.unlock();
      return;
    }
    catch (Throwable paramString)
    {
      this$0.unlock();
      throw paramString;
    }
  }
  
  protected final void put(String paramString1, String paramString2)
  {
    this$0.lock();
    try
    {
      preferences.edit().putString(paramString1, paramString2).apply();
      this$0.unlock();
      return;
    }
    catch (Throwable paramString1)
    {
      this$0.unlock();
      throw paramString1;
    }
  }
  
  public void saveDefaultGoogleSignInAccount(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    put("defaultGoogleSignInAccount", paramGoogleSignInAccount.getArtistName());
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.getArtistName();
    put(readString("googleSignInAccount", str), paramGoogleSignInAccount.doInBackground());
    put(readString("googleSignInOptions", str), paramGoogleSignInOptions.save());
  }
}
