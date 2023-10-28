package com.braze.coroutine;

import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import kotlin.n;
import kotlin.t;
import kotlin.w.d;
import kotlin.w.g;
import kotlin.w.i.a.f;
import kotlin.x.c.p;
import kotlin.x.d.i;
import kotlin.x.d.j;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.h0.a;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.r2;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.z1;

public final class BrazeCoroutineScope
  implements m0
{
  public static final BrazeCoroutineScope INSTANCE = new BrazeCoroutineScope();
  private static final g coroutineContext;
  private static final h0 exceptionHandler;
  
  static
  {
    d localD = new d(h0.N);
    exceptionHandler = localD;
    coroutineContext = b1.b().plus((g)localD).plus(r2.b(null, 1, null));
  }
  
  private BrazeCoroutineScope() {}
  
  public static final void cancelChildren()
  {
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeCoroutineScope localBrazeCoroutineScope = INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, localBrazeCoroutineScope, BrazeLogger.Priority.g, null, a.components, 2, null);
    z1.e(localBrazeCoroutineScope.getCoroutineContext(), null, 1, null);
  }
  
  public g getCoroutineContext()
  {
    return coroutineContext;
  }
  
  public final v1 launchDelayed(Number paramNumber, g paramG, final kotlin.x.c.l paramL)
  {
    i.e(paramNumber, "startDelayInMs");
    i.e(paramG, "specificContext");
    i.e(paramL, "block");
    return h.d(this, paramG, null, new c(paramNumber, paramL, null), 2, null);
  }
  
  static final class a
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final a components = new a();
    
    a()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cancelling children of BrazeCoroutineScope";
    }
  }
  
  static final class b
    extends j
    implements kotlin.x.c.a<String>
  {
    b(Throwable paramThrowable)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Child job of BrazeCoroutineScope got exception: ");
      localStringBuilder.append(val$t);
      return localStringBuilder.toString();
    }
  }
  
  @f(c="com.braze.coroutine.BrazeCoroutineScope$launchDelayed$1", f="BrazeCoroutineScope.kt", l={52, 55}, m="invokeSuspend")
  static final class c
    extends kotlin.w.i.a.l
    implements p<m0, d<? super t>, Object>
  {
    int k;
    
    c(Number paramNumber, kotlin.x.c.l paramL, d paramD)
    {
      super(paramD);
    }
    
    public final Object b(m0 paramM0, d paramD)
    {
      return ((c)create(paramM0, paramD)).invokeSuspend(t.a);
    }
    
    public final d create(Object paramObject, d paramD)
    {
      paramD = new c(b, paramL, paramD);
      o = paramObject;
      return (d)paramD;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject = kotlin.coroutines.intrinsics.a.c();
      int i = k;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            n.b(paramObject);
            break label143;
          }
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m0 localM0 = (m0)o;
        n.b(paramObject);
        paramObject = localM0;
      }
      else
      {
        n.b(paramObject);
        paramObject = (m0)o;
        long l = b.longValue();
        o = paramObject;
        k = 1;
        if (w0.a(l, (d)this) == localObject) {
          return localObject;
        }
      }
      if (n0.a(paramObject))
      {
        paramObject = paramL;
        o = null;
        k = 2;
        if (paramObject.invoke(this) == localObject) {
          return localObject;
        }
      }
      label143:
      return t.a;
    }
  }
  
  public static final class d
    extends kotlin.w.a
    implements h0
  {
    public d(h0.a paramA)
    {
      super();
    }
    
    public void handleException(g paramG, Throwable paramThrowable)
    {
      BrazeLogger.INSTANCE.brazelog(BrazeCoroutineScope.INSTANCE, BrazeLogger.Priority.this$0, paramThrowable, new BrazeCoroutineScope.b(paramThrowable));
    }
  }
}
