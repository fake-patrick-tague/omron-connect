package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BaseBundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzia;
import com.google.android.gms.internal.measurement.zznv;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfy
  implements zzgt
{
  private static volatile zzfy _loader;
  private volatile Boolean a;
  private final zzki activity;
  @VisibleForTesting
  protected Boolean b;
  @VisibleForTesting
  protected Boolean base;
  private final zzfv board;
  private final zzid cache;
  private final Context context;
  private boolean count;
  private final zzab currPos;
  private final zzlh current;
  private final zzag data;
  private volatile boolean history;
  @VisibleForTesting
  final long id;
  private final zzfd index;
  private final zzis l;
  private zzaq name;
  private zzef next;
  private final Frame o;
  private zzeh obj;
  private final String offset;
  private long out;
  private final String overview;
  private int path;
  private final AtomicInteger progress;
  private Boolean ready;
  private final zzeo request;
  private final String serieid;
  private final Clock socket;
  private final zzej state;
  private zzjs this$0;
  private final boolean type;
  private final zzih url;
  private final String value;
  
  zzfy(zzhb paramZzhb)
  {
    int i = 0;
    count = false;
    progress = new AtomicInteger(0);
    Preconditions.checkNotNull(paramZzhb);
    Object localObject1 = context;
    Object localObject2 = new zzab((Context)localObject1);
    currPos = ((zzab)localObject2);
    zzdy.this$0 = (zzab)localObject2;
    context = ((Context)localObject1);
    value = queue;
    serieid = limit;
    offset = offset;
    type = data;
    a = version;
    overview = date;
    history = true;
    localObject2 = this$0;
    if (localObject2 != null)
    {
      localObject3 = this$0;
      if (localObject3 != null)
      {
        localObject3 = ((BaseBundle)localObject3).get("measurementEnabled");
        if ((localObject3 instanceof Boolean)) {
          b = ((Boolean)localObject3);
        }
        localObject2 = this$0.get("measurementDeactivated");
        if ((localObject2 instanceof Boolean)) {
          base = ((Boolean)localObject2);
        }
      }
    }
    zzia.clear((Context)localObject1);
    localObject2 = DefaultClock.getInstance();
    socket = ((Clock)localObject2);
    Object localObject3 = mDate;
    long l1;
    if (localObject3 != null) {
      l1 = ((Long)localObject3).longValue();
    } else {
      l1 = ((Clock)localObject2).currentTimeMillis();
    }
    id = l1;
    data = new zzag(this);
    localObject2 = new zzfd(this);
    ((zzgs)localObject2).clear();
    index = ((zzfd)localObject2);
    localObject2 = new zzeo(this);
    ((zzgs)localObject2).clear();
    request = ((zzeo)localObject2);
    localObject2 = new zzlh(this);
    ((zzgs)localObject2).clear();
    current = ((zzlh)localObject2);
    state = new zzej(new zzha(paramZzhb, this));
    o = new Frame(this);
    localObject2 = new zzis(this);
    ((Log)localObject2).set();
    l = ((zzis)localObject2);
    localObject2 = new zzid(this);
    ((Log)localObject2).set();
    cache = ((zzid)localObject2);
    localObject2 = new zzki(this);
    ((Log)localObject2).set();
    activity = ((zzki)localObject2);
    localObject2 = new zzih(this);
    ((zzgs)localObject2).clear();
    url = ((zzih)localObject2);
    localObject2 = new zzfv(this);
    ((zzgs)localObject2).clear();
    board = ((zzfv)localObject2);
    localObject3 = this$0;
    if ((localObject3 == null) || (id == 0L)) {
      i = 1;
    }
    if ((((Context)localObject1).getApplicationContext() instanceof Application))
    {
      localObject1 = add();
      if ((this$0.context.getApplicationContext() instanceof Application))
      {
        localObject3 = (Application)this$0.context.getApplicationContext();
        if (mCallback == null) {
          mCallback = new zzic((zzid)localObject1, null);
        }
        if (i != 0)
        {
          ((Application)localObject3).unregisterActivityLifecycleCallbacks(mCallback);
          ((Application)localObject3).registerActivityLifecycleCallbacks(mCallback);
          this$0.zzay().next().append("Registered activity lifecycle callback");
        }
      }
    }
    else
    {
      zzay().hasNext().append("Application context is not an Application");
    }
    ((zzfv)localObject2).append(new zzfx(this, paramZzhb));
  }
  
  private static final void append(Log paramLog)
  {
    if (paramLog != null)
    {
      if (paramLog.i()) {
        return;
      }
      throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(paramLog.getClass())));
    }
    throw new IllegalStateException("Component not created");
  }
  
  private static final void append(zzgr paramZzgr)
  {
    if (paramZzgr != null) {
      return;
    }
    throw new IllegalStateException("Component not created");
  }
  
  private static final void append(zzgs paramZzgs)
  {
    if (paramZzgs != null)
    {
      if (paramZzgs.write()) {
        return;
      }
      throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(paramZzgs.getClass())));
    }
    throw new IllegalStateException("Component not created");
  }
  
  public static zzfy getInstance(Context paramContext, zzcl paramZzcl, Long paramLong)
  {
    zzcl localZzcl = paramZzcl;
    if (paramZzcl != null) {
      if (type != null)
      {
        localZzcl = paramZzcl;
        if (value != null) {}
      }
      else
      {
        localZzcl = new zzcl(time, id, data, offset, null, null, this$0, null);
      }
    }
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramContext.getApplicationContext());
    if (_loader == null)
    {
      try
      {
        if (_loader == null) {
          _loader = new zzfy(new zzhb(paramContext, localZzcl, paramLong));
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    else if (localZzcl != null)
    {
      paramContext = this$0;
      if ((paramContext != null) && (paramContext.containsKey("dataCollectionDefaultEnabled")))
      {
        Preconditions.checkNotNull(_loader);
        _loadera = Boolean.valueOf(this$0.getBoolean("dataCollectionDefaultEnabled"));
      }
    }
    Preconditions.checkNotNull(_loader);
    return _loader;
  }
  
  static final void i()
  {
    throw new IllegalStateException("Unexpected call on client side");
  }
  
  public final Frame a()
  {
    Frame localFrame = o;
    if (localFrame != null) {
      return localFrame;
    }
    throw new IllegalStateException("Component not created");
  }
  
  public final zzid add()
  {
    append(cache);
    return cache;
  }
  
  public final zzag append()
  {
    return data;
  }
  
  public final zzis d()
  {
    append(l);
    return l;
  }
  
  public final void doInBackground()
  {
    zzaz().append();
    append(url());
    String str = getInstance().read();
    Object localObject3 = put().update(str);
    Object localObject1;
    ConnectivityManager localConnectivityManager;
    zzih localZzih;
    if ((data.addAll()) && (!((Boolean)second).booleanValue()) && (!TextUtils.isEmpty((CharSequence)first)))
    {
      localObject1 = url();
      ((zzgs)localObject1).size();
      localConnectivityManager = (ConnectivityManager)this$0.context.getSystemService("connectivity");
      localZzih = null;
      localObject1 = localZzih;
      if (localConnectivityManager == null) {}
    }
    try
    {
      localObject1 = localConnectivityManager.getActiveNetworkInfo();
      if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
      {
        localObject1 = get();
        getInstancethis$0.data.length();
        localObject1 = ((zzlh)localObject1).get(73000L, str, (String)first, putcache.get() - 1L);
        if (localObject1 != null)
        {
          localZzih = url();
          localObject3 = new zzfw(this);
          localZzih.append();
          localZzih.size();
          Preconditions.checkNotNull(localObject1);
          Preconditions.checkNotNull(localObject3);
          this$0.zzaz().run(new zzig(localZzih, str, (URL)localObject1, null, null, (zzfw)localObject3, null));
        }
      }
      else
      {
        zzay().hasNext().append("Network is not available for Deferred Deep Link request. Skipping");
        return;
        zzay().e().append("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        return;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject2 = localZzih;
      }
    }
  }
  
  protected final void doInBackground(zzcl paramZzcl)
  {
    zzaz().append();
    Object localObject1 = put().url();
    Object localObject2 = put();
    Object localObject3 = this$0;
    ((zzgr)localObject2).append();
    localObject2 = ((zzfd)localObject2).get();
    int i = 100;
    int j = ((SharedPreferences)localObject2).getInt("consent_source", 100);
    localObject2 = data;
    localObject3 = this$0;
    localObject2 = ((zzag)localObject2).getValue("google_analytics_default_allow_ad_storage");
    localObject3 = data;
    Object localObject4 = this$0;
    localObject3 = ((zzag)localObject3).getValue("google_analytics_default_allow_analytics_storage");
    if (((localObject2 != null) || (localObject3 != null)) && (put().put(-10)))
    {
      paramZzcl = new zzai((Boolean)localObject2, (Boolean)localObject3);
      i = -10;
    }
    else
    {
      if ((!TextUtils.isEmpty(getInstance().get())) && ((j == 0) || (j == 30) || (j == 10) || (j == 30) || (j == 30) || (j == 40)))
      {
        add().add(zzai.values, -10, id);
      }
      else if ((TextUtils.isEmpty(getInstance().get())) && (paramZzcl != null) && (this$0 != null) && (put().put(30)))
      {
        localObject2 = zzai.getValue(this$0);
        paramZzcl = (zzcl)localObject2;
        if (!((zzai)localObject2).equals(zzai.values))
        {
          i = 30;
          break label276;
        }
      }
      paramZzcl = null;
    }
    label276:
    if (paramZzcl != null)
    {
      add().add(paramZzcl, i, id);
      localObject1 = paramZzcl;
    }
    add().set((zzai)localObject1);
    if (putitems.get() == 0L)
    {
      zzay().next().append("Persisting first open", Long.valueOf(id));
      putitems.put(id);
    }
    addthis$0.parse();
    if (!init())
    {
      if (size())
      {
        if (!get().zzad("android.permission.INTERNET")) {
          zzay().iterator().append("App is missing INTERNET permission");
        }
        if (!get().zzad("android.permission.ACCESS_NETWORK_STATE")) {
          zzay().iterator().append("App is missing ACCESS_NETWORK_STATE permission");
        }
        if ((!Wrappers.packageManager(context).isCallerInstantApp()) && (!data.add()))
        {
          if (!zzlh.zzaj(context)) {
            zzay().iterator().append("AppMeasurementReceiver not registered/enabled");
          }
          if (!zzlh.zzak(context, false)) {
            zzay().iterator().append("AppMeasurementService not registered/enabled");
          }
        }
        zzay().iterator().append("Uploading is not possible. App measurement disabled");
      }
    }
    else
    {
      if ((!TextUtils.isEmpty(getInstance().get())) || (!TextUtils.isEmpty(getInstance().getType())))
      {
        paramZzcl = get();
        localObject1 = getInstance().get();
        localObject2 = put();
        ((zzgr)localObject2).append();
        localObject2 = ((zzfd)localObject2).get().getString("gmp_app_id", null);
        localObject3 = getInstance().getType();
        localObject4 = put();
        ((zzgr)localObject4).append();
        if (paramZzcl.zzam((String)localObject1, (String)localObject2, (String)localObject3, ((zzfd)localObject4).get().getString("admob_app_id", null)))
        {
          zzay().add().append("Rechecking which service to use due to a GMP App Id change");
          paramZzcl = put();
          paramZzcl.append();
          localObject1 = paramZzcl.isEnabled();
          localObject2 = paramZzcl.get().edit();
          ((SharedPreferences.Editor)localObject2).clear();
          ((SharedPreferences.Editor)localObject2).apply();
          if (localObject1 != null) {
            paramZzcl.putBoolean((Boolean)localObject1);
          }
          getValue().trim();
          this$0.clear();
          this$0.scan();
          putitems.put(id);
          puttype.put(null);
        }
        localObject1 = put();
        paramZzcl = getInstance().get();
        ((zzgr)localObject1).append();
        localObject1 = ((zzfd)localObject1).get().edit();
        ((SharedPreferences.Editor)localObject1).putString("gmp_app_id", paramZzcl);
        ((SharedPreferences.Editor)localObject1).apply();
        localObject1 = put();
        paramZzcl = getInstance().getType();
        ((zzgr)localObject1).append();
        localObject1 = ((zzfd)localObject1).get().edit();
        ((SharedPreferences.Editor)localObject1).putString("admob_app_id", paramZzcl);
        ((SharedPreferences.Editor)localObject1).apply();
      }
      if (!put().url().get(zzah.name)) {
        puttype.put(null);
      }
      add().add(puttype.getValue());
      zznv.play_next();
      if (data.get(null, zzeb.zzac)) {
        paramZzcl = getthis$0.context;
      }
    }
    try
    {
      paramZzcl.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
    }
    catch (ClassNotFoundException paramZzcl)
    {
      boolean bool;
      for (;;) {}
    }
    if (!TextUtils.isEmpty(putcount.getValue()))
    {
      zzay().hasNext().append("Remote config removed with active feature rollouts");
      putcount.put(null);
    }
    if ((!TextUtils.isEmpty(getInstance().get())) || (!TextUtils.isEmpty(getInstance().getType())))
    {
      bool = size();
      if ((!put().put()) && (!data.equals())) {
        put().putBoolean(bool ^ true);
      }
      if (bool) {
        add().save();
      }
      getRepositoryid.isAlive();
      getName().trim(new AtomicReference());
      getName().trim(putout.doInBackground());
    }
    putservices.put(true);
  }
  
  final zzfv elementAt()
  {
    return board;
  }
  
  public final zzlh get()
  {
    append(current);
    return current;
  }
  
  public final int getCount()
  {
    zzaz().append();
    if (data.equals()) {
      return 1;
    }
    Object localObject = base;
    if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
      return 2;
    }
    zzaz().append();
    if (!history) {
      return 8;
    }
    localObject = put().isEnabled();
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        return 0;
      }
      return 3;
    }
    localObject = data;
    zzab localZzab = this$0.currPos;
    localObject = ((zzag)localObject).getValue("firebase_analytics_collection_enabled");
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        return 0;
      }
      return 4;
    }
    localObject = b;
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        return 0;
      }
      return 5;
    }
    if (a != null)
    {
      if (a.booleanValue()) {
        return 0;
      }
      return 7;
    }
    return 0;
  }
  
  public final boolean getEntry()
  {
    return type;
  }
  
  public final zzef getInstance()
  {
    append(next);
    return next;
  }
  
  public final zzjs getName()
  {
    append(this$0);
    return this$0;
  }
  
  public final String getOverview()
  {
    return overview;
  }
  
  public final zzaq getProperty()
  {
    append(name);
    return name;
  }
  
  public final zzki getRepository()
  {
    append(activity);
    return activity;
  }
  
  public final String getSerieId()
  {
    return serieid;
  }
  
  public final String getString()
  {
    return value;
  }
  
  public final zzeh getValue()
  {
    append(obj);
    return obj;
  }
  
  final void goTo(boolean paramBoolean)
  {
    a = Boolean.valueOf(paramBoolean);
  }
  
  protected final boolean init()
  {
    if (count)
    {
      zzaz().append();
      Boolean localBoolean = ready;
      if ((localBoolean == null) || (out == 0L) || ((!localBoolean.booleanValue()) && (Math.abs(socket.elapsedRealtime() - out) > 1000L)))
      {
        out = socket.elapsedRealtime();
        boolean bool1 = get().zzad("android.permission.INTERNET");
        boolean bool2 = true;
        if ((bool1) && (get().zzad("android.permission.ACCESS_NETWORK_STATE")) && ((Wrappers.packageManager(context).isCallerInstantApp()) || (data.add()) || ((zzlh.zzaj(context)) && (zzlh.zzak(context, false))))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localBoolean = Boolean.valueOf(bool1);
        ready = localBoolean;
        if (localBoolean.booleanValue())
        {
          bool1 = bool2;
          if (!get().get(getInstance().get(), getInstance().getType())) {
            if (!TextUtils.isEmpty(getInstance().getType())) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          ready = Boolean.valueOf(bool1);
        }
      }
      return ready.booleanValue();
    }
    throw new IllegalStateException("AppMeasurement is not initialized");
  }
  
  public final void initialize(boolean paramBoolean)
  {
    zzaz().append();
    history = paramBoolean;
  }
  
  public final boolean isEmpty()
  {
    return TextUtils.isEmpty(value);
  }
  
  public final zzej next()
  {
    return state;
  }
  
  public final boolean onContextMenuSelected()
  {
    zzaz().append();
    return history;
  }
  
  final void openDatabase()
  {
    path += 1;
  }
  
  public final zzfd put()
  {
    append(index);
    return index;
  }
  
  public final boolean save()
  {
    return (a != null) && (a.booleanValue());
  }
  
  public final boolean size()
  {
    return getCount() == 0;
  }
  
  public final String slice()
  {
    return offset;
  }
  
  public final zzeo unwrap()
  {
    zzeo localZzeo = request;
    if ((localZzeo != null) && (localZzeo.write())) {
      return localZzeo;
    }
    return null;
  }
  
  final void update()
  {
    progress.incrementAndGet();
  }
  
  public final zzih url()
  {
    append(url);
    return url;
  }
  
  public final Context zzau()
  {
    return context;
  }
  
  public final Clock zzav()
  {
    return socket;
  }
  
  public final zzab zzaw()
  {
    return currPos;
  }
  
  public final zzeo zzay()
  {
    append(request);
    return request;
  }
  
  public final zzfv zzaz()
  {
    append(board);
    return board;
  }
}
