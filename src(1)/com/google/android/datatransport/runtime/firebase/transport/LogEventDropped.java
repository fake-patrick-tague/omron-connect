package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.e;

public final class LogEventDropped
{
  private static final LogEventDropped magenta = new a().a();
  private final long b;
  private final Reason d;
  
  LogEventDropped(long paramLong, Reason paramReason)
  {
    b = paramLong;
    d = paramReason;
  }
  
  public static a getShape()
  {
    return new a();
  }
  
  public Reason a()
  {
    return d;
  }
  
  public long b()
  {
    return b;
  }
  
  public static enum Reason
    implements e
  {
    private final int j;
    
    static
    {
      Reason localReason1 = new Reason("REASON_UNKNOWN", 0, 0);
      o = localReason1;
      Reason localReason2 = new Reason("MESSAGE_TOO_OLD", 1, 1);
      l = localReason2;
      Reason localReason3 = new Reason("CACHE_FULL", 2, 2);
      b = localReason3;
      Reason localReason4 = new Reason("PAYLOAD_TOO_BIG", 3, 3);
      d = localReason4;
      Reason localReason5 = new Reason("MAX_RETRIES_REACHED", 4, 4);
      p = localReason5;
      Reason localReason6 = new Reason("INVALID_PAYLOD", 5, 5);
      g = localReason6;
      Reason localReason7 = new Reason("SERVER_ERROR", 6, 6);
      y = localReason7;
      a = new Reason[] { localReason1, localReason2, localReason3, localReason4, localReason5, localReason6, localReason7 };
    }
    
    private Reason(int paramInt)
    {
      j = paramInt;
    }
    
    public int a()
    {
      return j;
    }
  }
  
  public static final class a
  {
    private long d = 0L;
    private LogEventDropped.Reason j = LogEventDropped.Reason.o;
    
    a() {}
    
    public a a(long paramLong)
    {
      d = paramLong;
      return this;
    }
    
    public a a(LogEventDropped.Reason paramReason)
    {
      j = paramReason;
      return this;
    }
    
    public LogEventDropped a()
    {
      return new LogEventDropped(d, j);
    }
  }
}
