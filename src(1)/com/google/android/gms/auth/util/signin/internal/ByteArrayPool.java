package com.google.android.gms.auth.util.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.util.signin.GoogleSignInAccount;
import com.google.android.gms.auth.util.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class ByteArrayPool
{
  private static ByteArrayPool dialog;
  @VisibleForTesting
  GoogleSignInAccount buffer;
  @VisibleForTesting
  GoogleSignInOptions bytes;
  @VisibleForTesting
  final Storage data;
  
  private ByteArrayPool(Context paramContext)
  {
    paramContext = Storage.getInstance(paramContext);
    data = paramContext;
    buffer = paramContext.getSavedDefaultGoogleSignInAccount();
    bytes = paramContext.getSavedDefaultGoogleSignInOptions();
  }
  
  private static ByteArrayPool create(Context paramContext)
  {
    try
    {
      ByteArrayPool localByteArrayPool = dialog;
      if (localByteArrayPool != null) {
        return localByteArrayPool;
      }
      paramContext = new ByteArrayPool(paramContext);
      dialog = paramContext;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static ByteArrayPool get(Context paramContext)
  {
    try
    {
      paramContext = create(paramContext.getApplicationContext());
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public final void clear()
  {
    try
    {
      data.clear();
      buffer = null;
      bytes = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final GoogleSignInAccount get()
  {
    try
    {
      GoogleSignInAccount localGoogleSignInAccount = buffer;
      return localGoogleSignInAccount;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final GoogleSignInOptions getBytes()
  {
    try
    {
      GoogleSignInOptions localGoogleSignInOptions = bytes;
      return localGoogleSignInOptions;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void trim(GoogleSignInOptions paramGoogleSignInOptions, GoogleSignInAccount paramGoogleSignInAccount)
  {
    try
    {
      data.saveDefaultGoogleSignInAccount(paramGoogleSignInAccount, paramGoogleSignInOptions);
      buffer = paramGoogleSignInAccount;
      bytes = paramGoogleSignInOptions;
      return;
    }
    catch (Throwable paramGoogleSignInOptions)
    {
      throw paramGoogleSignInOptions;
    }
  }
}
