package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;

final class zzhm
  implements zzhj
{
  private static zzhm mCursor;
  private final ContentObserver mContentObserver;
  private final Context mContext;
  
  private zzhm()
  {
    mContext = null;
    mContentObserver = null;
  }
  
  private zzhm(Context paramContext)
  {
    mContext = paramContext;
    zzhl localZzhl = new zzhl(this, null);
    mContentObserver = localZzhl;
    paramContext.getContentResolver().registerContentObserver(zzgz.CONTENT_URI, true, localZzhl);
  }
  
  static zzhm get(Context paramContext)
  {
    try
    {
      if (mCursor == null)
      {
        if (PermissionChecker.checkSelfPermission(paramContext, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
          paramContext = new zzhm(paramContext);
        } else {
          paramContext = new zzhm();
        }
        mCursor = paramContext;
      }
      paramContext = mCursor;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  static void stop()
  {
    try
    {
      zzhm localZzhm = mCursor;
      if (localZzhm != null)
      {
        Context localContext = mContext;
        if ((localContext != null) && (mContentObserver != null)) {
          localContext.getContentResolver().unregisterContentObserver(mCursormContentObserver);
        }
      }
      mCursor = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final String toString(String paramString)
  {
    Object localObject = mContext;
    if (localObject != null)
    {
      if (zzha.send((Context)localObject)) {
        return null;
      }
      try
      {
        localObject = zzhh.size(new zzhk(this, paramString));
        return (String)localObject;
      }
      catch (NullPointerException localNullPointerException) {}catch (SecurityException localSecurityException) {}catch (IllegalStateException localIllegalStateException) {}
      Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(paramString)), localIllegalStateException);
    }
    return null;
  }
}
