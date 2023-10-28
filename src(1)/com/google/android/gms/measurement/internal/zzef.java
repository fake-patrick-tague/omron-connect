package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzoz;
import com.google.android.gms.internal.measurement.zzpf;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;

public final class zzef
  extends Log
{
  private String content;
  private String data;
  private long date = 0L;
  private String description;
  private String filename;
  private long id;
  private List instance;
  private String key;
  private final long length;
  private String message = null;
  private int size;
  private int state;
  private String url;
  private String value;
  private String version;
  
  zzef(zzfy paramZzfy, long paramLong)
  {
    super(paramZzfy);
    length = paramLong;
  }
  
  final boolean decrypt(String paramString)
  {
    String str = message;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (!str.equals(paramString)) {
        bool1 = true;
      }
    }
    message = paramString;
    return bool1;
  }
  
  final void delete()
  {
    append();
    Object localObject;
    if (!this$0.put().url().get(zzah.name))
    {
      this$0.zzay().e().append("Analytics Storage consent is not granted");
      localObject = null;
    }
    else
    {
      localObject = new byte[16];
      this$0.get().iterator().nextBytes((byte[])localObject);
      localObject = String.format(Locale.US, "%032x", new Object[] { new BigInteger(1, (byte[])localObject) });
    }
    zzem localZzem = this$0.zzay().e();
    String str;
    if (localObject == null) {
      str = "null";
    } else {
      str = "not null";
    }
    localZzem.append(String.format("Resetting session stitching token to %s", new Object[] { str }));
    content = ((String)localObject);
    date = this$0.zzav().currentTimeMillis();
  }
  
  final String get()
  {
    append();
    next();
    Preconditions.checkNotNull(key);
    return key;
  }
  
  final List getInstance()
  {
    return instance;
  }
  
  final int getSize()
  {
    next();
    return size;
  }
  
  final String getType()
  {
    next();
    return value;
  }
  
  final int getValue()
  {
    next();
    return state;
  }
  
  protected final void init()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  protected final boolean isMapped()
  {
    return true;
  }
  
  final String read()
  {
    next();
    Preconditions.checkNotNull(data);
    return data;
  }
  
  final Item run(String paramString)
  {
    append();
    String str1 = read();
    String str2 = get();
    next();
    String str3 = version;
    next();
    long l3 = size;
    next();
    Preconditions.checkNotNull(url);
    String str4 = url;
    this$0.append().length();
    next();
    append();
    long l2 = id;
    long l1 = l2;
    Object localObject4;
    if (l2 == 0L)
    {
      localObject1 = this$0.get();
      localObject4 = this$0.zzau();
      localObject5 = this$0.zzau().getPackageName();
      ((zzgr)localObject1).append();
      Preconditions.checkNotNull(localObject4);
      Preconditions.checkNotEmpty((String)localObject5);
      localObject6 = ((Context)localObject4).getPackageManager();
      Object localObject2 = zzlh.getInstance();
      l1 = -1L;
      if (localObject2 == null) {
        this$0.zzay().iterator().append("Could not get MD5 instance");
      }
      for (;;)
      {
        break label322;
        if (localObject6 != null) {
          try
          {
            bool1 = ((zzlh)localObject1).zzag((Context)localObject4, (String)localObject5);
            if (!bool1)
            {
              localObject4 = Wrappers.packageManager((Context)localObject4);
              localObject5 = this$0;
              localObject4 = ((PackageManagerWrapper)localObject4).getPackageInfo(((zzfy)localObject5).zzau().getPackageName(), 64);
              localObject4 = signatures;
              if ((localObject4 != null) && (localObject4.length > 0))
              {
                localObject4 = localObject4[0];
                l1 = zzlh.read(((MessageDigest)localObject2).digest(((Signature)localObject4).toByteArray()));
              }
              else
              {
                localObject2 = this$0;
                ((zzfy)localObject2).zzay().hasNext().append("Could not get signatures");
              }
            }
            else
            {
              l1 = 0L;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            this$0.zzay().iterator().append("Package name not found", localNameNotFoundException);
          }
        }
      }
      l1 = 0L;
      label322:
      id = l1;
    }
    boolean bool1 = this$0.size();
    boolean bool2 = this$0.put().first;
    append();
    if (!this$0.size()) {}
    for (;;)
    {
      localObject1 = null;
      break label570;
      zzpf.zoomIn();
      if (!this$0.append().get(null, zzeb.zzaa)) {
        break;
      }
      this$0.zzay().next().append("Disabled IID for tests.");
    }
    Object localObject1 = this$0;
    for (;;)
    {
      try
      {
        localObject1 = ((zzfy)localObject1).zzau().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
        if (localObject1 != null) {}
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject3;
        int i;
        boolean bool3;
        boolean bool4;
        long l4;
        String str5;
        String str6;
        long l5;
        long l6;
        continue;
      }
      try
      {
        localObject3 = ((Class)localObject1).getDeclaredMethod("getInstance", new Class[] { Context.class });
        localObject4 = this$0;
        localObject4 = ((zzfy)localObject4).zzau();
        localObject3 = ((Method)localObject3).invoke(null, new Object[] { localObject4 });
        if (localObject3 != null) {}
      }
      catch (Exception localException1)
      {
        continue;
      }
      try
      {
        localObject1 = ((Class)localObject1).getDeclaredMethod("getFirebaseInstanceId", new Class[0]);
        localObject1 = ((Method)localObject1).invoke(localObject3, new Object[0]);
        localObject1 = (String)localObject1;
      }
      catch (Exception localException2) {}
    }
    this$0.zzay().isEmpty().append("Failed to retrieve Firebase Instance Id");
    break label567;
    this$0.zzay().getHtml().append("Failed to obtain Firebase Analytics instance");
    label567:
    localObject1 = null;
    label570:
    localObject3 = this$0;
    l2 = putitems.get();
    if (l2 == 0L) {
      l2 = id;
    } else {
      l2 = Math.min(id, l2);
    }
    next();
    i = state;
    bool3 = this$0.append().addAll();
    localObject3 = this$0.put();
    ((zzgr)localObject3).append();
    bool4 = ((zzfd)localObject3).get().getBoolean("deferred_analytics_collection", false);
    next();
    Object localObject5 = value;
    localObject3 = this$0.append().getValue("google_analytics_default_allow_ad_personalization_signals");
    if (localObject3 == null) {
      localObject3 = null;
    } else {
      localObject3 = Boolean.valueOf(((Boolean)localObject3).booleanValue() ^ true);
    }
    l4 = length;
    Object localObject6 = instance;
    str5 = this$0.put().url().encode();
    if (description == null) {
      if (this$0.append().get(null, zzeb.zzax)) {
        description = this$0.get().encrypt();
      } else {
        description = "";
      }
    }
    str6 = description;
    zzoz.isEmpty();
    if (this$0.append().get(null, zzeb.zzas))
    {
      append();
      if (date != 0L)
      {
        l5 = this$0.zzav().currentTimeMillis();
        l6 = date;
        if ((content != null) && (l5 - l6 > 86400000L) && (message == null)) {
          delete();
        }
      }
      if (content == null) {
        delete();
      }
      localObject4 = content;
    }
    else
    {
      localObject4 = null;
    }
    return new Item(str1, str2, str3, l3, str4, 73000L, l1, paramString, bool1, bool2 ^ true, (String)localObject1, 0L, l2, i, bool3, bool4, (String)localObject5, (Boolean)localObject3, l4, (List)localObject6, null, str5, str6, (String)localObject4);
  }
}
