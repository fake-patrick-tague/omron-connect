package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public class AccountAccessor
  extends IAccountAccessor.Stub
{
  public static Account getAccountBinderSafe(IAccountAccessor paramIAccountAccessor)
  {
    Object localObject = null;
    if (paramIAccountAccessor != null)
    {
      long l = Binder.clearCallingIdentity();
      try
      {
        paramIAccountAccessor = paramIAccountAccessor.get();
        Binder.restoreCallingIdentity(l);
        return paramIAccountAccessor;
      }
      catch (Throwable paramIAccountAccessor)
      {
        for (;;)
        {
          break;
          Log.w("AccountAccessor", "Remote account accessor probably died");
          paramIAccountAccessor = localObject;
        }
        Binder.restoreCallingIdentity(l);
        throw paramIAccountAccessor;
      }
      catch (RemoteException paramIAccountAccessor)
      {
        for (;;) {}
      }
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final Account get()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
}
