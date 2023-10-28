package androidx.work;

import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker
{
  private WorkerParameters b;
  private boolean d;
  private volatile boolean initialized;
  private android.content.Context l;
  private boolean result;
  
  public ListenableWorker(android.content.Context paramContext, WorkerParameters paramWorkerParameters)
  {
    if (paramContext != null)
    {
      if (paramWorkerParameters != null)
      {
        l = paramContext;
        b = paramWorkerParameters;
        return;
      }
      throw new IllegalArgumentException("WorkerParameters is null");
    }
    throw new IllegalArgumentException("Application Context is null");
  }
  
  public boolean a()
  {
    return d;
  }
  
  public final android.content.Context b()
  {
    return l;
  }
  
  public Executor build()
  {
    return b.build();
  }
  
  public final Label d()
  {
    return b.a();
  }
  
  public void d(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public final UUID e()
  {
    return b.e();
  }
  
  public final boolean equals()
  {
    return initialized;
  }
  
  public abstract com.google.common.util.concurrent.Object get();
  
  public com.google.common.util.concurrent.Object getContext()
  {
    androidx.work.impl.utils.futures.Context localContext = androidx.work.impl.utils.futures.Context.getInstance();
    localContext.get(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
    return localContext;
  }
  
  public final void onPostInit()
  {
    initialized = true;
    pack();
  }
  
  public void pack() {}
  
  public final boolean post()
  {
    return result;
  }
  
  public final void put()
  {
    result = true;
  }
  
  public Pair remove()
  {
    return b.get();
  }
  
  public static abstract class a
  {
    a() {}
    
    public static a createFactory()
    {
      return new c();
    }
    
    public static a crossProduct()
    {
      return new a();
    }
    
    public static a d()
    {
      return new b();
    }
    
    public static a get(Label paramLabel)
    {
      return new c(paramLabel);
    }
    
    public static final class a
      extends ListenableWorker.a
    {
      private final Label c;
      
      public a()
      {
        this(Label.c);
      }
      
      public a(Label paramLabel)
      {
        c = paramLabel;
      }
      
      public Label a()
      {
        return c;
      }
      
      public boolean equals(Object paramObject)
      {
        if (this == paramObject) {
          return true;
        }
        if ((paramObject != null) && (a.class == paramObject.getClass()))
        {
          paramObject = (a)paramObject;
          return c.equals(c);
        }
        return false;
      }
      
      public int hashCode()
      {
        return a.class.getName().hashCode() * 31 + c.hashCode();
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failure {mOutputData=");
        localStringBuilder.append(c);
        localStringBuilder.append('}');
        return localStringBuilder.toString();
      }
    }
    
    public static final class b
      extends ListenableWorker.a
    {
      public b() {}
      
      public boolean equals(Object paramObject)
      {
        if (this == paramObject) {
          return true;
        }
        return (paramObject != null) && (b.class == paramObject.getClass());
      }
      
      public int hashCode()
      {
        return b.class.getName().hashCode();
      }
      
      public String toString()
      {
        return "Retry";
      }
    }
    
    public static final class c
      extends ListenableWorker.a
    {
      private final Label c;
      
      public c()
      {
        this(Label.c);
      }
      
      public c(Label paramLabel)
      {
        c = paramLabel;
      }
      
      public Label a()
      {
        return c;
      }
      
      public boolean equals(Object paramObject)
      {
        if (this == paramObject) {
          return true;
        }
        if ((paramObject != null) && (c.class == paramObject.getClass()))
        {
          paramObject = (c)paramObject;
          return c.equals(c);
        }
        return false;
      }
      
      public int hashCode()
      {
        return c.class.getName().hashCode() * 31 + c.hashCode();
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Success {mOutputData=");
        localStringBuilder.append(c);
        localStringBuilder.append('}');
        return localStringBuilder.toString();
      }
    }
  }
}
