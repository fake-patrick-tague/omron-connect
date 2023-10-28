package com.android.volley;

public abstract class RequestTask<T>
  implements Runnable
{
  final Request<T> mRequest;
  
  public RequestTask(Request paramRequest)
  {
    mRequest = paramRequest;
  }
  
  public int compareTo(RequestTask paramRequestTask)
  {
    return mRequest.compareTo(mRequest);
  }
}
