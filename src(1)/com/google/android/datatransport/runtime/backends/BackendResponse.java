package com.google.android.datatransport.runtime.backends;

public abstract class BackendResponse
{
  public BackendResponse() {}
  
  public static BackendResponse a()
  {
    return new m(Status.d, -1L);
  }
  
  public static BackendResponse b()
  {
    return new m(Status.i, -1L);
  }
  
  public static BackendResponse b(long paramLong)
  {
    return new m(Status.l, paramLong);
  }
  
  public static BackendResponse e()
  {
    return new m(Status.b, -1L);
  }
  
  public abstract Status c();
  
  public abstract long f();
  
  public static enum Status
  {
    static
    {
      Status localStatus1 = new Status("OK", 0);
      l = localStatus1;
      Status localStatus2 = new Status("TRANSIENT_ERROR", 1);
      b = localStatus2;
      Status localStatus3 = new Status("FATAL_ERROR", 2);
      i = localStatus3;
      Status localStatus4 = new Status("INVALID_PAYLOAD", 3);
      d = localStatus4;
      a = new Status[] { localStatus1, localStatus2, localStatus3, localStatus4 };
    }
  }
}
