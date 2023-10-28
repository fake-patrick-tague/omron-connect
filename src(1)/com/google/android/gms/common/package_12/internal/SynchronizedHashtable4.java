package com.google.android.gms.common.package_12.internal;

import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Status;

public final class SynchronizedHashtable4<A extends com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>>
  extends zai
{
  protected final A mData;
  
  public SynchronizedHashtable4(int paramInt, BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    super(paramInt);
    mData = ((BaseImplementation.ApiMethodImpl)Preconditions.checkNotNull(paramApiMethodImpl, "Null methods are not runnable."));
  }
  
  public final void get(zaad paramZaad, boolean paramBoolean)
  {
    paramZaad.addAll(mData, paramBoolean);
  }
  
  public final void get(Exception paramException)
  {
    Object localObject = paramException.getClass().getSimpleName();
    paramException = paramException.getLocalizedMessage();
    StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 2 + String.valueOf(paramException).length());
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramException);
    paramException = new Status(10, localStringBuilder.toString());
    localObject = mData;
    try
    {
      ((BaseImplementation.ApiMethodImpl)localObject).setFailedResult(paramException);
      return;
    }
    catch (IllegalStateException paramException)
    {
      Log.w("ApiCallRunner", "Exception reporting failure", paramException);
    }
  }
  
  public final void put(Status paramStatus)
  {
    BaseImplementation.ApiMethodImpl localApiMethodImpl = mData;
    try
    {
      localApiMethodImpl.setFailedResult(paramStatus);
      return;
    }
    catch (IllegalStateException paramStatus)
    {
      Log.w("ApiCallRunner", "Exception reporting failure", paramStatus);
    }
  }
  
  public final void put(zabq paramZabq)
    throws DeadObjectException
  {
    try
    {
      mData.setData(paramZabq.getContext());
      return;
    }
    catch (RuntimeException paramZabq)
    {
      get(paramZabq);
    }
  }
}
