package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.Converters;
import com.google.android.gms.internal.measurement.Field;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import v7.util.LruCache;

public final class zzgq
  extends zzed
{
  private Boolean a;
  private String c;
  private final zzkz this$0;
  
  public zzgq(zzkz paramZzkz, String paramString)
  {
    Preconditions.checkNotNull(paramZzkz);
    this$0 = paramZzkz;
    c = null;
  }
  
  private final void add(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject;
      if (paramBoolean) {
        if (a == null) {
          localObject = c;
        }
      }
      try
      {
        paramBoolean = "com.google.android.gms".equals(localObject);
        if (!paramBoolean)
        {
          localObject = this$0;
          paramBoolean = UidVerifier.isGooglePlayServicesUid(((zzkz)localObject).zzau(), Binder.getCallingUid());
          if (!paramBoolean)
          {
            localObject = this$0;
            paramBoolean = GoogleSignatureVerifier.getInstance(((zzkz)localObject).zzau()).isUidGoogleSigned(Binder.getCallingUid());
            if (!paramBoolean)
            {
              paramBoolean = false;
              break label87;
            }
          }
        }
        paramBoolean = true;
        label87:
        a = Boolean.valueOf(paramBoolean);
        localObject = a;
        paramBoolean = ((Boolean)localObject).booleanValue();
        if (paramBoolean) {
          return;
        }
        if (c == null)
        {
          localObject = this$0;
          paramBoolean = GooglePlayServicesUtilLight.uidHasPackageName(((zzkz)localObject).zzau(), Binder.getCallingUid(), paramString);
          if (paramBoolean) {
            c = paramString;
          }
        }
        localObject = c;
        paramBoolean = paramString.equals(localObject);
        if (paramBoolean) {
          return;
        }
        throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[] { paramString }));
      }
      catch (SecurityException localSecurityException)
      {
        this$0.zzay().iterator().append("Measurement Service called with invalid calling package. appId", zzeo.get(paramString));
        throw localSecurityException;
      }
    }
    this$0.zzay().iterator().append("Measurement Service called without app package");
    throw new SecurityException("Measurement Service called without app package");
  }
  
  private final void put(Item paramItem, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramItem);
    Preconditions.checkNotEmpty(name);
    add(name, false);
    this$0.get().get(key, id);
  }
  
  private final void put(zzaw paramZzaw, Item paramItem)
  {
    this$0.write();
    this$0.read(paramZzaw, paramItem);
  }
  
  public final void add(Bundle paramBundle, Item paramItem)
  {
    put(paramItem, false);
    paramItem = name;
    Preconditions.checkNotNull(paramItem);
    put(new zzfz(this, paramItem, paramBundle));
  }
  
  public final void add(Item paramItem)
  {
    put(paramItem, false);
    put(new zzgh(this, paramItem));
  }
  
  public final void add(zzaw paramZzaw, String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramZzaw);
    Preconditions.checkNotEmpty(paramString1);
    add(paramString1, true);
    put(new zzgk(this, paramZzaw, paramString1));
  }
  
  public final void add(zzlc paramZzlc, Item paramItem)
  {
    Preconditions.checkNotNull(paramZzlc);
    put(paramItem, false);
    put(new zzgm(this, paramZzlc, paramItem));
  }
  
  public final void append(zzac paramZzac)
  {
    Preconditions.checkNotNull(paramZzac);
    Preconditions.checkNotNull(context);
    Preconditions.checkNotEmpty(name);
    add(name, true);
    put(new zzgb(this, new zzac(paramZzac)));
  }
  
  public final void execute(Item paramItem)
  {
    Preconditions.checkNotEmpty(name);
    Preconditions.checkNotNull(url);
    paramItem = new zzgi(this, paramItem);
    Preconditions.checkNotNull(paramItem);
    if (this$0.zzaz().put())
    {
      paramItem.run();
      return;
    }
    this$0.zzaz().synchronize(paramItem);
  }
  
  public final String get(Item paramItem)
  {
    put(paramItem, false);
    return this$0.execute(paramItem);
  }
  
  public final List get(Item paramItem, boolean paramBoolean)
  {
    put(paramItem, false);
    Object localObject1 = name;
    Preconditions.checkNotNull(localObject1);
    localObject1 = this$0.zzaz().submit(new zzgn(this, (String)localObject1));
    try
    {
      localObject1 = ((Future)localObject1).get();
      Object localObject2 = (List)localObject1;
      localObject1 = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject2).hasNext();
        if (!bool) {
          break;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        localObject3 = (zzle)localObject3;
        if (!paramBoolean)
        {
          String str = size;
          bool = zzlh.zzah(str);
          if (bool) {}
        }
        else
        {
          ((List)localObject1).add(new zzlc((zzle)localObject3));
        }
      }
      return localObject1;
    }
    catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}
    this$0.zzay().iterator().append("Failed to get user properties. appId", zzeo.get(name), localInterruptedException);
    return null;
  }
  
  public final List get(String paramString1, String paramString2, Item paramItem)
  {
    put(paramItem, false);
    paramItem = name;
    Preconditions.checkNotNull(paramItem);
    paramString1 = this$0.zzaz().submit(new zzge(this, paramItem, paramString1, paramString2));
    try
    {
      paramString1 = paramString1.get();
      return (List)paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    this$0.zzay().iterator().append("Failed to get conditional user properties", paramString1);
    return Collections.emptyList();
  }
  
  public final List get(String paramString1, String paramString2, String paramString3)
  {
    add(paramString1, true);
    paramString1 = this$0.zzaz().submit(new zzgf(this, paramString1, paramString2, paramString3));
    try
    {
      paramString1 = paramString1.get();
      return (List)paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    this$0.zzay().iterator().append("Failed to get conditional user properties as", paramString1);
    return Collections.emptyList();
  }
  
  public final List get(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    add(paramString1, true);
    paramString2 = this$0.zzaz().submit(new zzgd(this, paramString1, paramString2, paramString3));
    try
    {
      paramString2 = paramString2.get();
      paramString3 = (List)paramString2;
      paramString2 = new ArrayList(paramString3.size());
      paramString3 = paramString3.iterator();
      for (;;)
      {
        boolean bool = paramString3.hasNext();
        if (!bool) {
          break;
        }
        Object localObject = paramString3.next();
        localObject = (zzle)localObject;
        if (!paramBoolean)
        {
          String str = size;
          bool = zzlh.zzah(str);
          if (bool) {}
        }
        else
        {
          paramString2.add(new zzlc((zzle)localObject));
        }
      }
      return paramString2;
    }
    catch (ExecutionException paramString2) {}catch (InterruptedException paramString2) {}
    this$0.zzay().iterator().append("Failed to get user properties as. appId", zzeo.get(paramString1), paramString2);
    return Collections.emptyList();
  }
  
  public final List get(String paramString1, String paramString2, boolean paramBoolean, Item paramItem)
  {
    put(paramItem, false);
    Object localObject = name;
    Preconditions.checkNotNull(localObject);
    paramString1 = this$0.zzaz().submit(new zzgc(this, (String)localObject, paramString1, paramString2));
    try
    {
      paramString1 = paramString1.get();
      paramString2 = (List)paramString1;
      paramString1 = new ArrayList(paramString2.size());
      paramString2 = paramString2.iterator();
      for (;;)
      {
        boolean bool = paramString2.hasNext();
        if (!bool) {
          break;
        }
        localObject = paramString2.next();
        localObject = (zzle)localObject;
        if (!paramBoolean)
        {
          String str = size;
          bool = zzlh.zzah(str);
          if (bool) {}
        }
        else
        {
          paramString1.add(new zzlc((zzle)localObject));
        }
      }
      return paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    this$0.zzay().iterator().append("Failed to query user properties. appId", zzeo.get(name), paramString1);
    return Collections.emptyList();
  }
  
  public final void get(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    put(new zzgp(this, paramString2, paramString3, paramString1, paramLong));
  }
  
  public final byte[] get(zzaw paramZzaw, String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramZzaw);
    add(paramString, true);
    this$0.zzay().e().append("Log and bundle. event", this$0.getUrl().toString(type));
    long l1 = this$0.zzav().nanoTime() / 1000000L;
    Object localObject1 = this$0.zzaz().get(new zzgl(this, paramZzaw, paramString));
    try
    {
      localObject1 = ((Future)localObject1).get();
      Object localObject2 = (byte[])localObject1;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this$0;
        ((zzkz)localObject1).zzay().iterator().append("Log and bundle returned null. appId", zzeo.get(paramString));
        localObject1 = new byte[0];
      }
      localObject2 = this$0;
      long l2 = ((zzkz)localObject2).zzav().nanoTime();
      localObject2 = this$0;
      localObject2 = ((zzkz)localObject2).zzay().e();
      Object localObject3 = this$0;
      localObject3 = ((zzkz)localObject3).getUrl();
      String str = type;
      localObject3 = ((zzej)localObject3).toString(str);
      int i = localObject1.length;
      l2 /= 1000000L;
      ((zzem)localObject2).append("Log and bundle processed. event, size, time_ms", localObject3, Integer.valueOf(i), Long.valueOf(l2 - l1));
      return localObject1;
    }
    catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}
    this$0.zzay().iterator().append("Failed to log and bundle. appId, event, error", zzeo.get(paramString), this$0.getUrl().toString(type), localInterruptedException);
    return null;
  }
  
  public final void insertItem(Item paramItem)
  {
    put(paramItem, false);
    put(new zzgo(this, paramItem));
  }
  
  final void parse(zzaw paramZzaw, Item paramItem)
  {
    if (!this$0.getURI().getBytes(name))
    {
      put(paramZzaw, paramItem);
      return;
    }
    this$0.zzay().next().append("EES config found for", name);
    Object localObject1 = this$0.getURI();
    Object localObject2 = name;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = null;
    } else {
      localObject1 = (Field)list.get(localObject2);
    }
    if (localObject1 != null) {
      localObject2 = this$0;
    }
    try
    {
      localObject2 = ((zzkz)localObject2).next();
      Object localObject3 = this$0;
      Map localMap = ((zzlb)localObject2).set(((zzau)localObject3).get(), true);
      localObject2 = type;
      localObject3 = zzgv.getContent((String)localObject2);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = type;
      }
      long l = size;
      boolean bool = ((Field)localObject1).add(new zzaa((String)localObject2, l, localMap));
      if (!bool) {
        break label353;
      }
      if (((Field)localObject1).equals())
      {
        this$0.zzay().next().append("EES edited event", type);
        put(this$0.next().getValue(((Field)localObject1).get().get()), paramItem);
      }
      else
      {
        put(paramZzaw, paramItem);
      }
      if (((Field)localObject1).isEmpty())
      {
        paramZzaw = ((Field)localObject1).get().getText().iterator();
        while (paramZzaw.hasNext())
        {
          localObject1 = (zzaa)paramZzaw.next();
          this$0.zzay().next().append("EES logging created event", ((zzaa)localObject1).getName());
          put(this$0.next().getValue((zzaa)localObject1), paramItem);
        }
      }
      return;
    }
    catch (Converters localConverters)
    {
      for (;;) {}
    }
    this$0.zzay().iterator().append("EES error. appId, eventName", key, type);
    label353:
    this$0.zzay().next().append("EES was not applied to event", type);
    put(paramZzaw, paramItem);
    return;
    this$0.zzay().next().append("EES not loaded for", name);
    put(paramZzaw, paramItem);
    return;
  }
  
  public final void put(Item paramItem)
  {
    Preconditions.checkNotEmpty(name);
    add(name, false);
    put(new zzgg(this, paramItem));
  }
  
  public final void put(zzac paramZzac, Item paramItem)
  {
    Preconditions.checkNotNull(paramZzac);
    Preconditions.checkNotNull(context);
    put(paramItem, false);
    paramZzac = new zzac(paramZzac);
    name = name;
    put(new zzga(this, paramZzac, paramItem));
  }
  
  final void put(Runnable paramRunnable)
  {
    Preconditions.checkNotNull(paramRunnable);
    if (this$0.zzaz().put())
    {
      paramRunnable.run();
      return;
    }
    this$0.zzaz().append(paramRunnable);
  }
  
  final zzaw toString(zzaw paramZzaw, Item paramItem)
  {
    if ("_cmp".equals(type))
    {
      paramItem = this$0;
      if (paramItem != null)
      {
        if (paramItem.getSectionCount() == 0) {
          return paramZzaw;
        }
        paramItem = this$0.getString("_cis");
        if (("referrer broadcast".equals(paramItem)) || ("referrer API".equals(paramItem)))
        {
          this$0.zzay().add().append("Event has been filtered ", paramZzaw.toString());
          return new zzaw("_cmpx", this$0, name, size);
        }
      }
    }
    return paramZzaw;
  }
  
  public final void url(zzaw paramZzaw, Item paramItem)
  {
    Preconditions.checkNotNull(paramZzaw);
    put(paramItem, false);
    put(new zzgj(this, paramZzaw, paramItem));
  }
}
