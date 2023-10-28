package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.asm.ByteBufferList;
import com.google.android.datatransport.asm.Edge;
import com.google.android.datatransport.asm.util.util.m;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendResponse.Status;
import com.google.android.datatransport.runtime.backends.ExtensionData;
import com.google.android.datatransport.runtime.backends.d;
import com.google.android.datatransport.runtime.firebase.transport.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

public class f
{
  private final m a;
  private final c b;
  private final com.google.android.datatransport.asm.params.c c;
  private final Executor e;
  private final com.google.android.datatransport.asm.util.util.e f;
  private final com.google.android.datatransport.asm.asm.Label i;
  private final com.google.android.datatransport.asm.asm.Label j;
  private final com.google.android.datatransport.runtime.backends.Label k;
  private final android.content.Context mContext;
  
  public f(android.content.Context paramContext, com.google.android.datatransport.runtime.backends.Label paramLabel, m paramM, c paramC, Executor paramExecutor, com.google.android.datatransport.asm.params.c paramC1, com.google.android.datatransport.asm.asm.Label paramLabel1, com.google.android.datatransport.asm.asm.Label paramLabel2, com.google.android.datatransport.asm.util.util.e paramE)
  {
    mContext = paramContext;
    k = paramLabel;
    a = paramM;
    b = paramC;
    e = paramExecutor;
    c = paramC1;
    j = paramLabel1;
    i = paramLabel2;
    f = paramE;
  }
  
  public com.google.android.datatransport.asm.Item a(com.google.android.datatransport.runtime.backends.e paramE)
  {
    Object localObject = c;
    com.google.android.datatransport.asm.util.util.e localE = f;
    Objects.requireNonNull(localE);
    localObject = (h)((com.google.android.datatransport.asm.params.c)localObject).add(new j(localE));
    return paramE.get(com.google.android.datatransport.asm.Item.get().add(j.a()).get(i.a()).get("GDT_CLIENT_METRICS").add(new Edge(com.google.android.datatransport.Type.valueOf("proto"), ((h)localObject).d())).add());
  }
  
  public BackendResponse a(com.google.android.datatransport.asm.Context paramContext, int paramInt)
  {
    com.google.android.datatransport.runtime.backends.e localE = k.a(paramContext.getName());
    long l1 = 0L;
    Object localObject3 = BackendResponse.b(0L);
    while (((Boolean)c.add(new l(this, paramContext))).booleanValue())
    {
      Object localObject4 = (Iterable)c.add(new g(this, paramContext));
      if (!((Iterable)localObject4).iterator().hasNext()) {
        return localObject3;
      }
      if (localE == null) {
        com.google.android.datatransport.asm.store.f.d("Uploader", "Unknown backend for %s, deleting event batch for it...", paramContext);
      }
      Object localObject2;
      for (Object localObject1 = BackendResponse.b();; localObject1 = localE.b(d.b().a((Iterable)localObject1).b(paramContext.get()).a()))
      {
        localObject2 = localObject1;
        break;
        localObject1 = new ArrayList();
        localObject2 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(((com.google.android.datatransport.asm.util.util.Type)((Iterator)localObject2).next()).get());
        }
        if (paramContext.isPrimitive()) {
          ((List)localObject1).add(a(localE));
        }
      }
      if (((BackendResponse)localObject1).c() == BackendResponse.Status.b)
      {
        c.add(new a(this, (Iterable)localObject4, paramContext, l1));
        b.a(paramContext, paramInt + 1, true);
        return localObject1;
      }
      c.add(new Type(this, (Iterable)localObject4));
      if (((BackendResponse)localObject1).c() == BackendResponse.Status.l)
      {
        long l2 = Math.max(l1, ((BackendResponse)localObject1).f());
        l1 = l2;
        localObject3 = localObject2;
        if (paramContext.isPrimitive())
        {
          c.add(new MethodWriter(this));
          l1 = l2;
          localObject3 = localObject2;
        }
      }
      else
      {
        localObject3 = localObject2;
        if (((BackendResponse)localObject1).c() == BackendResponse.Status.d)
        {
          localObject1 = new HashMap();
          localObject3 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = ((com.google.android.datatransport.asm.util.util.Type)((Iterator)localObject3).next()).get().getId();
            if (!((Map)localObject1).containsKey(localObject4)) {
              ((Map)localObject1).put(localObject4, Integer.valueOf(1));
            } else {
              ((Map)localObject1).put(localObject4, Integer.valueOf(((Integer)((Map)localObject1).get(localObject4)).intValue() + 1));
            }
          }
          c.add(new Item(this, (Map)localObject1));
          localObject3 = localObject2;
        }
      }
    }
    c.add(new AnnotationWriter(this, paramContext, l1));
    return localObject3;
  }
  
  public void init(com.google.android.datatransport.asm.Context paramContext, int paramInt, Runnable paramRunnable)
  {
    e.execute(new NumberPicker.PressedStateHelper(this, paramContext, paramInt, paramRunnable));
  }
  
  boolean send()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
}
