package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFuture<T>
  implements Future<T>, Response.Listener<T>, Response.ErrorListener
{
  private VolleyError mException;
  private Request<?> mRequest;
  private T mResult;
  private boolean mResultReceived = false;
  
  private RequestFuture() {}
  
  private Object doGet(Long paramLong)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    Object localObject = this;
    try
    {
      VolleyError localVolleyError = mException;
      RequestFuture localRequestFuture = this;
      if (localVolleyError == null)
      {
        localObject = localRequestFuture;
        if (mResultReceived)
        {
          localObject = localRequestFuture;
          paramLong = mResult;
          return paramLong;
        }
        if (paramLong == null) {
          for (;;)
          {
            localObject = localRequestFuture;
            if (localRequestFuture.isDone()) {
              break;
            }
            localObject = localRequestFuture;
            localRequestFuture.wait(0L);
          }
        }
        localObject = localRequestFuture;
        if (paramLong.longValue() > 0L)
        {
          localObject = localRequestFuture;
          long l2 = SystemClock.uptimeMillis();
          long l1 = l2;
          localObject = localRequestFuture;
          l2 = paramLong.longValue() + l2;
          for (;;)
          {
            localObject = localRequestFuture;
            if ((localRequestFuture.isDone()) || (l1 >= l2)) {
              break;
            }
            localObject = localRequestFuture;
            localRequestFuture.wait(l2 - l1);
            localObject = localRequestFuture;
            l1 = SystemClock.uptimeMillis();
          }
        }
        localObject = localRequestFuture;
        paramLong = mException;
        if (paramLong == null)
        {
          localObject = localRequestFuture;
          if (mResultReceived)
          {
            localObject = localRequestFuture;
            paramLong = mResult;
            return paramLong;
          }
          localObject = localRequestFuture;
          throw new TimeoutException();
        }
        localObject = localRequestFuture;
        paramLong = mException;
        localObject = localRequestFuture;
        throw new ExecutionException(paramLong);
      }
      localObject = localRequestFuture;
      paramLong = mException;
      localObject = localRequestFuture;
      throw new ExecutionException(paramLong);
    }
    catch (Throwable paramLong)
    {
      throw paramLong;
    }
  }
  
  public static RequestFuture newFuture()
  {
    return new RequestFuture();
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    try
    {
      Request localRequest = mRequest;
      if (localRequest == null) {
        return false;
      }
      if (!isDone())
      {
        mRequest.cancel();
        return true;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Object get()
    throws InterruptedException, ExecutionException
  {
    try
    {
      Object localObject = doGet(null);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new AssertionError(localTimeoutException);
    }
  }
  
  public Object get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit)));
  }
  
  public boolean isCancelled()
  {
    Request localRequest = mRequest;
    if (localRequest == null) {
      return false;
    }
    return localRequest.isCanceled();
  }
  
  public boolean isDone()
  {
    try
    {
      if ((!mResultReceived) && (mException == null))
      {
        bool = isCancelled();
        if (!bool)
        {
          bool = false;
          break label35;
        }
      }
      boolean bool = true;
      label35:
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void onErrorResponse(VolleyError paramVolleyError)
  {
    try
    {
      mException = paramVolleyError;
      notifyAll();
      return;
    }
    catch (Throwable paramVolleyError)
    {
      throw paramVolleyError;
    }
  }
  
  public void onResponse(Object paramObject)
  {
    try
    {
      mResultReceived = true;
      mResult = paramObject;
      notifyAll();
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
  
  public void setRequest(Request paramRequest)
  {
    mRequest = paramRequest;
  }
}
