package com.google.android.gms.common.package_12.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.zac;
import com.google.android.gms.common.package_12.ApiException;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class DataMap<T>
  extends zac
{
  protected final TaskCompletionSource<T> this$0;
  
  public DataMap(int paramInt, TaskCompletionSource paramTaskCompletionSource)
  {
    super(paramInt);
    this$0 = paramTaskCompletionSource;
  }
  
  public void get(zaad paramZaad, boolean paramBoolean) {}
  
  public final void get(Exception paramException)
  {
    this$0.trySetException(paramException);
  }
  
  public final void put(Status paramStatus)
  {
    this$0.trySetException(new ApiException(paramStatus));
  }
  
  public final void put(zabq paramZabq)
    throws DeadObjectException
  {
    try
    {
      setValue(paramZabq);
      return;
    }
    catch (RuntimeException paramZabq)
    {
      this$0.trySetException(paramZabq);
      return;
    }
    catch (RemoteException paramZabq)
    {
      put(Resource.newInstance(paramZabq));
      return;
    }
    catch (DeadObjectException paramZabq)
    {
      put(Resource.newInstance(paramZabq));
      throw paramZabq;
    }
  }
  
  protected abstract void setValue(zabq paramZabq)
    throws RemoteException;
}
