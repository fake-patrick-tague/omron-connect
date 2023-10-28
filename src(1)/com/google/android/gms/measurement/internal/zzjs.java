package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzjs
  extends Log
{
  private zzee instance;
  private volatile Boolean isRunning;
  private final zzjr mConnection;
  private final zzkj mHandler;
  private final zzap queue;
  private final List stack = new ArrayList();
  private final zzap this$0;
  
  protected zzjs(zzfy paramZzfy)
  {
    super(paramZzfy);
    mHandler = new zzkj(paramZzfy.zzav());
    mConnection = new zzjr(this);
    this$0 = new zzjc(this, paramZzfy);
    queue = new zzje(this, paramZzfy);
  }
  
  private final void cleanup()
  {
    append();
    mHandler.onCreate();
    zzap localZzap = this$0;
    this$0.append();
    localZzap.close(((Long)zzeb.albums.get(null)).longValue());
  }
  
  private final void flush()
  {
    append();
    this$0.zzay().next().append("Processing queued up service tasks", Integer.valueOf(stack.size()));
    Iterator localIterator = stack.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      try
      {
        localRunnable.run();
      }
      catch (RuntimeException localRuntimeException)
      {
        this$0.zzay().iterator().append("Task exception while flushing queue", localRuntimeException);
      }
    }
    stack.clear();
    queue.close();
  }
  
  private final boolean moveToNext()
  {
    this$0.zzaw();
    return true;
  }
  
  private final Item next(boolean paramBoolean)
  {
    this$0.zzaw();
    zzef localZzef = this$0.getInstance();
    String str = null;
    Object localObject1 = str;
    if (paramBoolean)
    {
      localObject1 = this$0.zzay();
      if (this$0.put().last == null)
      {
        localObject1 = str;
      }
      else
      {
        Object localObject2 = this$0.put().last.update();
        localObject1 = str;
        if (localObject2 != null) {
          if (localObject2 == zzfd.text)
          {
            localObject1 = str;
          }
          else
          {
            localObject1 = String.valueOf(second);
            str = (String)first;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(":");
            ((StringBuilder)localObject2).append(str);
            localObject1 = ((StringBuilder)localObject2).toString();
          }
        }
      }
    }
    return localZzef.run((String)localObject1);
  }
  
  private final void next(Runnable paramRunnable)
    throws IllegalStateException
  {
    append();
    if (add())
    {
      paramRunnable.run();
      return;
    }
    int i = stack.size();
    this$0.append();
    if (i >= 1000L)
    {
      this$0.zzay().iterator().append("Discarding data. Max runnable queue size reached");
      return;
    }
    stack.add(paramRunnable);
    queue.close(60000L);
    scan();
  }
  
  public final boolean add()
  {
    append();
    next();
    return instance != null;
  }
  
  public final void addValue(zzcf paramZzcf, zzaw paramZzaw, String paramString)
  {
    append();
    next();
    if (this$0.get().getTime(12451000) != 0)
    {
      this$0.zzay().hasNext().append("Not bundling data. Service unavailable or out of date");
      this$0.get().add(paramZzcf, new byte[0]);
      return;
    }
    next(new zzjd(this, paramZzaw, paramString, paramZzcf));
  }
  
  protected final void autoDownload()
  {
    append();
    next();
    next(new zzjf(this, next(true)));
  }
  
  public final void clear()
  {
    append();
    next();
    mConnection.close();
    try
    {
      ConnectionTracker localConnectionTracker = ConnectionTracker.getInstance();
      Object localObject = this$0;
      localObject = ((zzfy)localObject).zzau();
      zzjr localZzjr = mConnection;
      localConnectionTracker.unbindService((Context)localObject, localZzjr);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    instance = null;
  }
  
  protected final void clear(zzee paramZzee)
  {
    append();
    Preconditions.checkNotNull(paramZzee);
    instance = paramZzee;
    cleanup();
    flush();
  }
  
  final boolean contains()
  {
    append();
    next();
    if (start()) {
      return this$0.get().d() >= ((Integer)zzeb.zzaf.get(null)).intValue();
    }
    return true;
  }
  
  protected final void download(AtomicReference paramAtomicReference, String paramString1, String paramString2, String paramString3)
  {
    append();
    next();
    next(new zzjj(this, paramAtomicReference, null, paramString2, paramString3, next(false)));
  }
  
  protected final void download(AtomicReference paramAtomicReference, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    append();
    next();
    next(new zzjl(this, paramAtomicReference, null, paramString2, paramString3, next(false), paramBoolean));
  }
  
  protected final boolean isMapped()
  {
    return false;
  }
  
  final Boolean isRunning()
  {
    return isRunning;
  }
  
  final void loadData(zzee paramZzee, AbstractSafeParcelable paramAbstractSafeParcelable, Item paramItem)
  {
    append();
    next();
    moveToNext();
    this$0.append();
    int j = 0;
    int i = 100;
    while ((j < 1001) && (i == 100))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = this$0.getValue().doInBackground(100);
      if (localObject != null)
      {
        localArrayList.addAll((Collection)localObject);
        i = ((List)localObject).size();
      }
      else
      {
        i = 0;
      }
      if ((paramAbstractSafeParcelable != null) && (i < 100)) {
        localArrayList.add(paramAbstractSafeParcelable);
      }
      int m = localArrayList.size();
      int k = 0;
      while (k < m)
      {
        localObject = (AbstractSafeParcelable)localArrayList.get(k);
        if ((localObject instanceof zzaw))
        {
          localObject = (zzaw)localObject;
          try
          {
            paramZzee.url((zzaw)localObject, paramItem);
          }
          catch (RemoteException localRemoteException1)
          {
            this$0.zzay().iterator().append("Failed to send event to the service", localRemoteException1);
          }
        }
        else if ((localRemoteException1 instanceof zzlc))
        {
          zzlc localZzlc = (zzlc)localRemoteException1;
          try
          {
            paramZzee.add(localZzlc, paramItem);
          }
          catch (RemoteException localRemoteException2)
          {
            this$0.zzay().iterator().append("Failed to send user property to the service", localRemoteException2);
          }
        }
        else if ((localRemoteException2 instanceof zzac))
        {
          zzac localZzac = (zzac)localRemoteException2;
          try
          {
            paramZzee.put(localZzac, paramItem);
          }
          catch (RemoteException localRemoteException3)
          {
            this$0.zzay().iterator().append("Failed to send conditional user property to the service", localRemoteException3);
          }
        }
        else
        {
          this$0.zzay().iterator().append("Discarding data. Unrecognized parcel type.");
        }
        k += 1;
      }
      j += 1;
    }
  }
  
  protected final void put(zzcf paramZzcf, String paramString1, String paramString2)
  {
    append();
    next();
    next(new zzjk(this, paramString1, paramString2, next(false), paramZzcf));
  }
  
  protected final void put(zzcf paramZzcf, String paramString1, String paramString2, boolean paramBoolean)
  {
    append();
    next();
    next(new zzit(this, paramString1, paramString2, next(false), paramBoolean, paramZzcf));
  }
  
  final void scan()
  {
    append();
    next();
    if (add()) {
      return;
    }
    if (!start())
    {
      if (!this$0.append().add())
      {
        this$0.zzaw();
        Object localObject = this$0.zzau().getPackageManager().queryIntentServices(new Intent().setClassName(this$0.zzau(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = new Intent("com.google.android.gms.measurement.START");
          Context localContext = this$0.zzau();
          this$0.zzaw();
          ((Intent)localObject).setComponent(new ComponentName(localContext, "com.google.android.gms.measurement.AppMeasurementService"));
          mConnection.sendUpdate((Intent)localObject);
          return;
        }
        this$0.zzay().iterator().append("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
      }
    }
    else {
      mConnection.connect();
    }
  }
  
  protected final void setText(zzik paramZzik)
  {
    append();
    next();
    next(new zzja(this, paramZzik));
  }
  
  final boolean start()
  {
    append();
    next();
    if (isRunning == null)
    {
      append();
      next();
      Object localObject = this$0.put();
      ((zzgr)localObject).append();
      boolean bool2 = ((zzfd)localObject).get().contains("use_service");
      boolean bool1 = false;
      if (!bool2) {
        localObject = null;
      } else {
        localObject = Boolean.valueOf(((zzfd)localObject).get().getBoolean("use_service", false));
      }
      int i = 1;
      boolean bool3 = true;
      bool2 = true;
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        bool1 = bool3;
      }
      else
      {
        this$0.zzaw();
        if (this$0.getInstance().getValue() == 1) {}
        for (;;)
        {
          bool1 = true;
          break;
          this$0.zzay().next().append("Checking service availability");
          int j = this$0.get().getTime(12451000);
          if (j != 0)
          {
            if (j != 1)
            {
              if (j != 2)
              {
                if (j != 3)
                {
                  if (j != 9)
                  {
                    if (j != 18) {
                      this$0.zzay().hasNext().append("Unexpected service status", Integer.valueOf(j));
                    } else {
                      this$0.zzay().hasNext().append("Service updating");
                    }
                  }
                  else {
                    this$0.zzay().hasNext().append("Service invalid");
                  }
                }
                else {
                  this$0.zzay().hasNext().append("Service disabled");
                }
                i = 0;
                break;
              }
              else
              {
                this$0.zzay().e().append("Service container out of date");
                if (this$0.get().d() < 17443) {
                  break;
                }
                if (localObject == null) {
                  bool1 = bool2;
                } else {
                  bool1 = false;
                }
                i = 0;
                break;
              }
            }
            else
            {
              this$0.zzay().next().append("Service missing");
              break;
            }
          }
          else {
            this$0.zzay().next().append("Service available");
          }
        }
        if ((!bool1) && (this$0.append().add()))
        {
          this$0.zzay().iterator().append("No way to upload. Consider using the full version of Analytics");
        }
        else if (i != 0)
        {
          localObject = this$0.put();
          ((zzgr)localObject).append();
          localObject = ((zzfd)localObject).get().edit();
          ((SharedPreferences.Editor)localObject).putBoolean("use_service", bool1);
          ((SharedPreferences.Editor)localObject).apply();
        }
      }
      isRunning = Boolean.valueOf(bool1);
    }
    return isRunning.booleanValue();
  }
  
  protected final void toXml()
  {
    append();
    next();
    Item localItem = next(true);
    this$0.getValue().updateMetadata();
    next(new zziz(this, localItem));
  }
  
  protected final void trim()
  {
    append();
    next();
    Item localItem = next(false);
    moveToNext();
    this$0.getValue().trim();
    next(new zziw(this, localItem));
  }
  
  public final void trim(Bundle paramBundle)
  {
    append();
    next();
    next(new zzjb(this, next(false), paramBundle));
  }
  
  protected final void trim(zzac paramZzac)
  {
    Preconditions.checkNotNull(paramZzac);
    append();
    next();
    this$0.zzaw();
    boolean bool = this$0.getValue().setTime(paramZzac);
    zzac localZzac = new zzac(paramZzac);
    next(new zzji(this, true, next(true), bool, localZzac, paramZzac));
  }
  
  protected final void trim(zzaw paramZzaw, String paramString)
  {
    Preconditions.checkNotNull(paramZzaw);
    append();
    next();
    moveToNext();
    boolean bool = this$0.getValue().next(paramZzaw);
    next(new zzjh(this, true, next(true), bool, paramZzaw, paramString));
  }
  
  protected final void trim(zzlc paramZzlc)
  {
    append();
    next();
    moveToNext();
    boolean bool = this$0.getValue().next(paramZzlc);
    next(new zziu(this, next(true), bool, paramZzlc));
  }
  
  public final void trim(AtomicReference paramAtomicReference)
  {
    append();
    next();
    next(new zzix(this, paramAtomicReference, next(false)));
  }
  
  protected final void trim(boolean paramBoolean)
  {
    append();
    next();
    if (paramBoolean)
    {
      moveToNext();
      this$0.getValue().trim();
    }
    if (contains()) {
      next(new zzjg(this, next(false)));
    }
  }
  
  protected final void updateUI(AtomicReference paramAtomicReference, boolean paramBoolean)
  {
    append();
    next();
    next(new zziv(this, paramAtomicReference, next(false), paramBoolean));
  }
  
  public final void updateWidget(zzcf paramZzcf)
  {
    append();
    next();
    next(new zziy(this, next(false), paramZzcf));
  }
}
