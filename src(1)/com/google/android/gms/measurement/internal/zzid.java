package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzoz;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import v7.util.ArrayMap;

public final class zzid
  extends Log
{
  private final AtomicLong count = new AtomicLong(0L);
  private final AtomicReference data = new AtomicReference();
  @VisibleForTesting
  protected boolean dirty = true;
  private long height = -1L;
  private zzgy m;
  @VisibleForTesting
  protected zzic mCallback;
  private zzai path = new zzai(null, null);
  private final Object queue = new Object();
  private boolean result;
  private final Set set = new CopyOnWriteArraySet();
  final Transaction this$0;
  private final zzlg type = new zzhr(this);
  private int width = 100;
  private int y = 100;
  
  protected zzid(zzfy paramZzfy)
  {
    super(paramZzfy);
    this$0 = new Transaction(paramZzfy);
  }
  
  private final void zzaa(Boolean paramBoolean, boolean paramBoolean1)
  {
    append();
    next();
    this$0.zzay().e().append("Setting app measurement enabled (FE)", paramBoolean);
    this$0.put().putBoolean(paramBoolean);
    if (paramBoolean1)
    {
      Object localObject = this$0.put();
      zzfy localZzfy = this$0;
      ((zzgr)localObject).append();
      localObject = ((zzfd)localObject).get().edit();
      if (paramBoolean != null) {
        ((SharedPreferences.Editor)localObject).putBoolean("measurement_enabled_from_api", paramBoolean.booleanValue());
      } else {
        ((SharedPreferences.Editor)localObject).remove("measurement_enabled_from_api");
      }
      ((SharedPreferences.Editor)localObject).apply();
    }
    if (!this$0.onContextMenuSelected()) {
      if (paramBoolean != null)
      {
        if (paramBoolean.booleanValue()) {
          return;
        }
      }
      else {
        return;
      }
    }
    zzab();
  }
  
  private final void zzab()
  {
    append();
    String str = this$0.put().state.getValue();
    if (str != null) {
      if ("unset".equals(str))
      {
        set("app", "_npa", null, this$0.zzav().currentTimeMillis());
      }
      else
      {
        long l;
        if (true != "true".equals(str)) {
          l = 0L;
        } else {
          l = 1L;
        }
        set("app", "_npa", Long.valueOf(l), this$0.zzav().currentTimeMillis());
      }
    }
    if ((this$0.size()) && (dirty))
    {
      this$0.zzay().e().append("Recording app launch after enabling measurement for the first time (FE)");
      save();
      zzoe.showMessageDetails();
      if (this$0.append().get(null, zzeb.zzad)) {
        this$0.getRepository().id.isAlive();
      }
      this$0.zzaz().append(new zzhg(this));
      return;
    }
    this$0.zzay().e().append("Updating Scion state (FE)");
    this$0.getName().autoDownload();
  }
  
  public final String a()
  {
    return (String)data.get();
  }
  
  public final Map a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this$0.zzaz().put())
    {
      this$0.zzay().iterator().append("Cannot get user properties from analytics worker thread");
      return Collections.emptyMap();
    }
    this$0.zzaw();
    if (zzab.remove())
    {
      this$0.zzay().iterator().append("Cannot get user properties from main thread");
      return Collections.emptyMap();
    }
    Object localObject1 = new AtomicReference();
    this$0.zzaz().get((AtomicReference)localObject1, 5000L, "get user properties", new zzhq(this, (AtomicReference)localObject1, null, paramString1, paramString2, paramBoolean));
    paramString2 = (List)((AtomicReference)localObject1).get();
    if (paramString2 == null)
    {
      this$0.zzay().iterator().append("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(paramBoolean));
      return Collections.emptyMap();
    }
    paramString1 = new ArrayMap(paramString2.size());
    paramString2 = paramString2.iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (zzlc)paramString2.next();
      Object localObject2 = ((zzlc)localObject1).get();
      if (localObject2 != null) {
        paramString1.put(type, localObject2);
      }
    }
    return paramString1;
  }
  
  public final void add(Bundle paramBundle, int paramInt, long paramLong)
  {
    next();
    String str = zzai.equals(paramBundle);
    if (str != null)
    {
      this$0.zzay().isEmpty().append("Ignoring invalid consent setting", str);
      this$0.zzay().isEmpty().append("Valid consent values are 'granted', 'denied'");
    }
    add(zzai.getValue(paramBundle), paramInt, paramLong);
  }
  
  public final void add(Bundle paramBundle, long paramLong)
  {
    Preconditions.checkNotNull(paramBundle);
    paramBundle = new Bundle(paramBundle);
    if (!TextUtils.isEmpty(paramBundle.getString("app_id"))) {
      this$0.zzay().hasNext().append("Package name should be null when calling setConditionalUserProperty");
    }
    paramBundle.remove("app_id");
    Preconditions.checkNotNull(paramBundle);
    zzgu.getString(paramBundle, "app_id", String.class, null);
    zzgu.getString(paramBundle, "origin", String.class, null);
    zzgu.getString(paramBundle, "name", String.class, null);
    zzgu.getString(paramBundle, "value", Object.class, null);
    zzgu.getString(paramBundle, "trigger_event_name", String.class, null);
    Object localObject1 = Long.valueOf(0L);
    zzgu.getString(paramBundle, "trigger_timeout", Long.class, localObject1);
    zzgu.getString(paramBundle, "timed_out_event_name", String.class, null);
    zzgu.getString(paramBundle, "timed_out_event_params", Bundle.class, null);
    zzgu.getString(paramBundle, "triggered_event_name", String.class, null);
    zzgu.getString(paramBundle, "triggered_event_params", Bundle.class, null);
    zzgu.getString(paramBundle, "time_to_live", Long.class, localObject1);
    zzgu.getString(paramBundle, "expired_event_name", String.class, null);
    zzgu.getString(paramBundle, "expired_event_params", Bundle.class, null);
    Preconditions.checkNotEmpty(paramBundle.getString("name"));
    Preconditions.checkNotEmpty(paramBundle.getString("origin"));
    Preconditions.checkNotNull(paramBundle.get("value"));
    paramBundle.putLong("creation_timestamp", paramLong);
    localObject1 = paramBundle.getString("name");
    Object localObject2 = paramBundle.get("value");
    if (this$0.get().getType((String)localObject1) == 0)
    {
      if (this$0.get().get((String)localObject1, localObject2) == 0)
      {
        Object localObject3 = this$0.get().save((String)localObject1, localObject2);
        if (localObject3 == null)
        {
          this$0.zzay().iterator().append("Unable to normalize conditional user property value", this$0.next().get((String)localObject1), localObject2);
          return;
        }
        zzgu.put(paramBundle, localObject3);
        paramLong = paramBundle.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(paramBundle.getString("trigger_event_name")))
        {
          this$0.append();
          if ((paramLong > 15552000000L) || (paramLong < 1L))
          {
            this$0.zzay().iterator().append("Invalid conditional user property timeout", this$0.next().get((String)localObject1), Long.valueOf(paramLong));
            return;
          }
        }
        paramLong = paramBundle.getLong("time_to_live");
        this$0.append();
        if ((paramLong <= 15552000000L) && (paramLong >= 1L))
        {
          this$0.zzaz().append(new zzhm(this, paramBundle));
          return;
        }
        this$0.zzay().iterator().append("Invalid conditional user property time to live", this$0.next().get((String)localObject1), Long.valueOf(paramLong));
        return;
      }
      this$0.zzay().iterator().append("Invalid conditional user property value", this$0.next().get((String)localObject1), localObject2);
      return;
    }
    this$0.zzay().iterator().append("Invalid conditional user property name", this$0.next().get((String)localObject1));
  }
  
  public final void add(zzai paramZzai, int paramInt, long paramLong)
  {
    Object localObject1 = paramZzai;
    next();
    if ((paramInt != -10) && (paramZzai.getValue() == null) && (paramZzai.isEmpty() == null))
    {
      this$0.zzay().isEmpty().append("Discarding empty consent settings");
      return;
    }
    Object localObject2 = queue;
    for (;;)
    {
      try
      {
        zzai localZzai = path;
        bool3 = zzai.set(paramInt, width);
        i = 1;
        bool1 = false;
        bool2 = false;
        if (bool3)
        {
          bool3 = paramZzai.get(path);
          localObject1 = zzah.name;
          bool1 = bool2;
          if (paramZzai.get((zzah)localObject1))
          {
            bool1 = bool2;
            if (!path.get((zzah)localObject1)) {
              bool1 = true;
            }
          }
          localObject1 = paramZzai.getString(path);
          paramZzai = (zzai)localObject1;
          path = ((zzai)localObject1);
          width = paramInt;
          bool2 = bool3;
          if (i == 0)
          {
            this$0.zzay().add().append("Ignoring lower-priority consent settings, proposed settings", paramZzai);
            return;
          }
          long l = count.getAndIncrement();
          if (bool2)
          {
            data.set(null);
            this$0.zzaz().synchronize(new zzhx(this, paramZzai, paramLong, paramInt, l, bool1, localZzai));
            return;
          }
          paramZzai = new zzhy(this, paramZzai, paramInt, l, bool1, localZzai);
          if ((paramInt != 30) && (paramInt != -10))
          {
            this$0.zzaz().append(paramZzai);
            return;
          }
          this$0.zzaz().synchronize(paramZzai);
          return;
        }
      }
      catch (Throwable paramZzai)
      {
        throw paramZzai;
      }
      int i = 0;
      boolean bool3 = false;
      paramZzai = (zzai)localObject1;
      boolean bool2 = bool1;
      boolean bool1 = bool3;
    }
  }
  
  final void add(String paramString)
  {
    data.set(paramString);
  }
  
  public final void add(String paramString1, String paramString2, Bundle paramBundle, String paramString3)
  {
    zzfy.i();
    set("auto", paramString2, this$0.zzav().currentTimeMillis(), paramBundle, false, true, true, paramString3);
  }
  
  public final void add(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "app";
    }
    paramString1 = paramBundle;
    if (paramBundle == null) {
      paramString1 = new Bundle();
    }
    if ((paramString2 != "screen_view") && ((paramString2 == null) || (!paramString2.equals("screen_view"))))
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramBoolean2)
      {
        bool1 = bool2;
        if (m != null) {
          if (zzlh.zzah(paramString2)) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
      set(str, paramString2, paramLong, paramString1, paramBoolean2, bool1, paramBoolean1, null);
      return;
    }
    this$0.d().a(paramString1, paramLong);
  }
  
  public final String b()
  {
    zzik localZzik = this$0.d().get();
    if (localZzik != null) {
      return a;
    }
    return null;
  }
  
  public final String c()
  {
    zzik localZzik = this$0.d().get();
    if (localZzik != null) {
      return c;
    }
    return null;
  }
  
  public final void clear(zzgz paramZzgz)
  {
    next();
    Preconditions.checkNotNull(paramZzgz);
    if (!set.remove(paramZzgz)) {
      this$0.zzay().hasNext().append("OnEventListener had not been registered");
    }
  }
  
  public final void d()
  {
    if (((this$0.zzau().getApplicationContext() instanceof Application)) && (mCallback != null)) {
      ((Application)this$0.zzau().getApplicationContext()).unregisterActivityLifecycleCallbacks(mCallback);
    }
  }
  
  final void e(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    append();
    boolean bool;
    if ((m != null) && (!zzlh.zzah(paramString2))) {
      bool = false;
    } else {
      bool = true;
    }
    get(paramString1, paramString2, paramLong, paramBundle, true, bool, true, null);
  }
  
  final void e(String paramString1, String paramString2, long paramLong, Object paramObject)
  {
    this$0.zzaz().append(new zzhj(this, paramString1, paramString2, paramObject, paramLong));
  }
  
  public final void f(Bundle paramBundle)
  {
    add(paramBundle, this$0.zzav().currentTimeMillis());
  }
  
  public final void f(zzgy paramZzgy)
  {
    append();
    next();
    if (paramZzgy != null)
    {
      zzgy localZzgy = m;
      if (paramZzgy != localZzgy)
      {
        boolean bool;
        if (localZzgy == null) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkState(bool, "EventInterceptor already set.");
      }
    }
    m = paramZzgy;
  }
  
  public final ArrayList get(String paramString1, String paramString2)
  {
    if (this$0.zzaz().put())
    {
      this$0.zzay().iterator().append("Cannot get conditional user properties from analytics worker thread");
      return new ArrayList(0);
    }
    this$0.zzaw();
    if (zzab.remove())
    {
      this$0.zzay().iterator().append("Cannot get conditional user properties from main thread");
      return new ArrayList(0);
    }
    AtomicReference localAtomicReference = new AtomicReference();
    this$0.zzaz().get(localAtomicReference, 5000L, "get conditional user properties", new zzho(this, localAtomicReference, null, paramString1, paramString2));
    paramString1 = (List)localAtomicReference.get();
    if (paramString1 == null)
    {
      this$0.zzay().iterator().append("Timed out waiting for get conditional user properties", null);
      return new ArrayList();
    }
    return zzlh.parse(paramString1);
  }
  
  final void get(long paramLong, boolean paramBoolean)
  {
    append();
    next();
    this$0.zzay().e().append("Resetting analytics data (FE)");
    Object localObject = this$0.getRepository();
    ((zzgr)localObject).append();
    this$0.pack();
    zzoz.isEmpty();
    if (this$0.append().get(null, zzeb.zzas)) {
      this$0.getInstance().delete();
    }
    boolean bool = this$0.size();
    localObject = this$0.put();
    items.put(paramLong);
    if (!TextUtils.isEmpty(this$0.put().count.getValue())) {
      count.put(null);
    }
    zzoe.showMessageDetails();
    zzag localZzag = this$0.append();
    zzea localZzea = zzeb.zzad;
    if (localZzag.get(null, localZzea)) {
      index.put(0L);
    }
    if (!this$0.append().equals()) {
      ((zzfd)localObject).putBoolean(bool ^ true);
    }
    resources.put(null);
    this$0.put(0L);
    out.doInBackground(null);
    if (paramBoolean) {
      this$0.getName().trim();
    }
    zzoe.showMessageDetails();
    if (this$0.append().get(null, localZzea)) {
      this$0.getRepository().id.isAlive();
    }
    dirty = (bool ^ true);
  }
  
  protected final void get(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotNull(paramBundle);
    append();
    next();
    Object localObject1;
    int j;
    int k;
    if (this$0.size())
    {
      localObject1 = this$0.getInstance().getInstance();
      if ((localObject1 != null) && (!((List)localObject1).contains(paramString2)))
      {
        this$0.zzay().e().append("Dropping non-safelisted event. event name, origin", paramString2, paramString1);
        return;
      }
      bool1 = result;
      j = 0;
      k = 0;
      if (!bool1)
      {
        result = true;
        localObject1 = this$0;
      }
    }
    for (;;)
    {
      try
      {
        bool1 = ((zzfy)localObject1).getEntry();
        if (!bool1)
        {
          localObject1 = this$0;
          localObject1 = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, ((zzfy)localObject1).zzau().getClassLoader());
        }
        else
        {
          localObject1 = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
        }
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredMethod("initialize", new Class[] { Context.class });
          localObject3 = this$0;
          localObject3 = ((zzfy)localObject3).zzau();
          ((Method)localObject1).invoke(null, new Object[] { localObject3 });
        }
        catch (Exception localException)
        {
          localObject3 = this$0;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        Object localObject3;
        Object localObject2;
        int i;
        boolean bool2;
        long l1;
        long l2;
        Object localObject4;
        continue;
      }
      try
      {
        ((zzfy)localObject3).zzay().hasNext().append("Failed to invoke Tag Manager's initialize() method", localException);
      }
      catch (ClassNotFoundException localClassNotFoundException2) {}
    }
    this$0.zzay().add().append("Tag Manager is not found and thus will not be used");
    if (("_cmp".equals(paramString2)) && (paramBundle.containsKey("gclid")))
    {
      this$0.zzaw();
      set("auto", "_lgclid", paramBundle.getString("gclid"), this$0.zzav().currentTimeMillis());
    }
    this$0.zzaw();
    if ((paramBoolean1) && (zzlh.zzal(paramString2))) {
      this$0.get().set(paramBundle, this$0.put().out.doInBackground());
    }
    if (!paramBoolean3)
    {
      this$0.zzaw();
      if (!"_iap".equals(paramString2))
      {
        localObject2 = this$0.get();
        bool1 = ((zzlh)localObject2).zzac("event", paramString2);
        i = 2;
        if (bool1) {
          if (!((zzlh)localObject2).add("event", zzgv.source, zzgv.message, paramString2))
          {
            i = 13;
          }
          else
          {
            this$0.append();
            if (((zzlh)localObject2).add("event", 40, paramString2)) {
              i = 0;
            }
          }
        }
        if (i != 0)
        {
          this$0.zzay().equals().append("Invalid public event name. Event will not be logged (FE)", this$0.next().toString(paramString2));
          paramString1 = this$0.get();
          this$0.append();
          paramString1 = paramString1.getText(paramString2, 40, true);
          j = k;
          if (paramString2 != null) {
            j = paramString2.length();
          }
          this$0.get().add(type, null, i, "_ev", paramString1, j);
          return;
        }
      }
    }
    this$0.zzaw();
    localObject2 = this$0.d().get(false);
    if ((localObject2 != null) && (!paramBundle.containsKey("_sc"))) {
      result = true;
    }
    if ((paramBoolean1) && (!paramBoolean3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzlh.add((zzik)localObject2, paramBundle, bool1);
    boolean bool1 = "am".equals(paramString1);
    bool2 = zzlh.zzah(paramString2);
    if ((paramBoolean1) && (m != null) && (!bool2))
    {
      if (bool1)
      {
        paramBoolean1 = true;
      }
      else
      {
        this$0.zzay().e().append("Passing event to registered event handler (FE)", this$0.next().toString(paramString2), this$0.next().getValue(paramBundle));
        Preconditions.checkNotNull(m);
        m.interceptEvent(paramString1, paramString2, paramBundle, paramLong);
      }
    }
    else {
      paramBoolean1 = bool1;
    }
    if (this$0.init())
    {
      k = this$0.get().parse(paramString2);
      if (k != 0)
      {
        this$0.zzay().equals().append("Invalid event name. Event will not be logged (FE)", this$0.next().toString(paramString2));
        paramString1 = this$0.get();
        this$0.append();
        paramString1 = paramString1.getText(paramString2, 40, true);
        i = j;
        if (paramString2 != null) {
          i = paramString2.length();
        }
        this$0.get().add(type, paramString3, k, "_ev", paramString1, i);
        return;
      }
      localObject2 = CollectionUtils.listOf(new String[] { "_o", "_sn", "_sc", "_si" });
      localObject3 = this$0.get().get(paramString3, paramString2, paramBundle, (List)localObject2, paramBoolean3);
      Preconditions.checkNotNull(localObject3);
      this$0.zzaw();
      if ((this$0.d().get(false) != null) && ("_ae".equals(paramString2)))
      {
        paramBundle = this$0.getRepository().this$0;
        l1 = this$0.this$0.zzav().elapsedRealtime();
        l2 = l1 - count;
        count = l1;
        if (l2 > 0L) {
          this$0.get().startSession((Bundle)localObject3, l2);
        }
      }
      zznv.play_next();
      if (this$0.append().get(null, zzeb.zzac)) {
        if ((!"auto".equals(paramString1)) && ("_ssr".equals(paramString2)))
        {
          localObject4 = this$0.get();
          localObject2 = ((BaseBundle)localObject3).getString("_ffr");
          paramBundle = (Bundle)localObject2;
          if (Strings.isEmptyOrWhitespace((String)localObject2)) {
            paramBundle = null;
          } else if (localObject2 != null) {
            paramBundle = ((String)localObject2).trim();
          }
          if (!zzlf.put(paramBundle, this$0.put().count.getValue())) {
            this$0.put().count.put(paramBundle);
          } else {
            this$0.zzay().e().append("Not logging duplicate session_start_with_rollout event");
          }
        }
        else if ("_ae".equals(paramString2))
        {
          paramBundle = this$0.get().this$0.put().count.getValue();
          if (!TextUtils.isEmpty(paramBundle)) {
            ((BaseBundle)localObject3).putString("_ffr", paramBundle);
          }
        }
      }
      localObject4 = new ArrayList();
      ((List)localObject4).add(localObject3);
      if ((this$0.put().index.get() > 0L) && (this$0.put().get(paramLong)) && (this$0.put().resource.get()))
      {
        this$0.zzay().next().append("Current session is expired, remove the session number, ID, and engagement time");
        set("auto", "_sid", null, this$0.zzav().currentTimeMillis());
        set("auto", "_sno", null, this$0.zzav().currentTimeMillis());
        set("auto", "_se", null, this$0.zzav().currentTimeMillis());
      }
      if (((BaseBundle)localObject3).getLong("extend_session", 0L) == 1L)
      {
        this$0.zzay().next().append("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
        this$0.getRepository().id.add(paramLong, true);
      }
      localObject2 = new ArrayList(((BaseBundle)localObject3).keySet());
      Collections.sort((List)localObject2);
      j = ((List)localObject2).size();
      i = 0;
      while (i < j)
      {
        String str = (String)((List)localObject2).get(i);
        if (str != null)
        {
          this$0.get();
          Object localObject5 = ((BaseBundle)localObject3).get(str);
          if ((localObject5 instanceof Bundle))
          {
            paramBundle = new Bundle[1];
            paramBundle[0] = ((Bundle)localObject5);
          }
          else if ((localObject5 instanceof Parcelable[]))
          {
            paramBundle = (Parcelable[])localObject5;
            paramBundle = (Bundle[])Arrays.copyOf(paramBundle, paramBundle.length, [Landroid.os.Bundle.class);
          }
          else if ((localObject5 instanceof ArrayList))
          {
            paramBundle = (ArrayList)localObject5;
            paramBundle = (Bundle[])paramBundle.toArray(new Bundle[paramBundle.size()]);
          }
          else
          {
            paramBundle = null;
          }
          if (paramBundle != null) {
            ((Bundle)localObject3).putParcelableArray(str, paramBundle);
          }
        }
        i += 1;
      }
      i = 0;
      while (i < ((List)localObject4).size())
      {
        localObject3 = (Bundle)((List)localObject4).get(i);
        if (i != 0) {
          localObject2 = "_ep";
        } else {
          localObject2 = paramString2;
        }
        ((BaseBundle)localObject3).putString("_o", paramString1);
        paramBundle = (Bundle)localObject3;
        if (paramBoolean2) {
          paramBundle = this$0.get().apply((Bundle)localObject3);
        }
        localObject2 = new zzaw((String)localObject2, new zzau(paramBundle), paramString1, paramLong);
        this$0.getName().trim((zzaw)localObject2, paramString3);
        if (!paramBoolean1)
        {
          localObject2 = set.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((zzgz)((Iterator)localObject2).next()).onEvent(paramString1, paramString2, new Bundle(paramBundle), paramLong);
          }
        }
        i += 1;
      }
      this$0.zzaw();
      if ((this$0.d().get(false) != null) && ("_ae".equals(paramString2)))
      {
        paramString1 = this$0.getRepository();
        paramLong = this$0.zzav().elapsedRealtime();
        this$0.update(true, true, paramLong);
        return;
        this$0.zzay().e().append("Event not sent since app measurement is disabled");
        return;
      }
    }
  }
  
  public final void get(String paramString1, String paramString2, Bundle paramBundle)
  {
    add(paramString1, paramString2, paramBundle, true, true, this$0.zzav().currentTimeMillis());
  }
  
  public final Integer getIdentifier()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Integer)this$0.zzaz().get(localAtomicReference, 15000L, "int test flag value", new zzhu(this, localAtomicReference));
  }
  
  public final String getString()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (String)this$0.zzaz().get(localAtomicReference, 15000L, "String test flag value", new zzhs(this, localAtomicReference));
  }
  
  public final Double getValue()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Double)this$0.zzaz().get(localAtomicReference, 15000L, "double test flag value", new zzhv(this, localAtomicReference));
  }
  
  protected final boolean isMapped()
  {
    return false;
  }
  
  public final int multiply(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    this$0.append();
    return 25;
  }
  
  public final void multiply(zzgz paramZzgz)
  {
    next();
    Preconditions.checkNotNull(paramZzgz);
    if (!set.add(paramZzgz)) {
      this$0.zzay().hasNext().append("OnEventListener already registered");
    }
  }
  
  final void put(String paramString1, String paramString2, Bundle paramBundle)
  {
    append();
    e(paramString1, paramString2, this$0.zzav().currentTimeMillis(), paramBundle);
  }
  
  public final Long read()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Long)this$0.zzaz().get(localAtomicReference, 15000L, "long test flag value", new zzht(this, localAtomicReference));
  }
  
  public final Boolean remove()
  {
    AtomicReference localAtomicReference = new AtomicReference();
    return (Boolean)this$0.zzaz().get(localAtomicReference, 15000L, "boolean test flag value", new zzhp(this, localAtomicReference));
  }
  
  public final List remove(boolean paramBoolean)
  {
    next();
    this$0.zzay().next().append("Getting user properties (FE)");
    if (!this$0.zzaz().put())
    {
      this$0.zzaw();
      if (zzab.remove())
      {
        this$0.zzay().iterator().append("Cannot get all user properties from main thread");
        return Collections.emptyList();
      }
      Object localObject = new AtomicReference();
      this$0.zzaz().get((AtomicReference)localObject, 5000L, "get user properties", new zzhk(this, (AtomicReference)localObject, paramBoolean));
      List localList = (List)((AtomicReference)localObject).get();
      localObject = localList;
      if (localList == null)
      {
        this$0.zzay().iterator().append("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(paramBoolean));
        localObject = Collections.emptyList();
      }
      return localObject;
    }
    this$0.zzay().iterator().append("Cannot get all user properties from analytics worker thread");
    return Collections.emptyList();
  }
  
  public final void save()
  {
    append();
    next();
    if (this$0.init())
    {
      if (this$0.append().get(null, zzeb.name))
      {
        localObject1 = this$0.append();
        this$0.zzaw();
        localObject1 = ((zzag)localObject1).getValue("google_analytics_deferred_deep_link_enabled");
        if ((localObject1 != null) && (((Boolean)localObject1).booleanValue()))
        {
          this$0.zzay().e().append("Deferred Deep Link feature enabled.");
          this$0.zzaz().append(new zzhf(this));
        }
      }
      this$0.getName().toXml();
      dirty = false;
      Object localObject3 = this$0.put();
      ((zzgr)localObject3).append();
      Object localObject1 = ((zzfd)localObject3).get().getString("previous_os_version", null);
      this$0.getProperty().size();
      Object localObject2 = Build.VERSION.RELEASE;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(localObject1)))
      {
        localObject3 = ((zzfd)localObject3).get().edit();
        ((SharedPreferences.Editor)localObject3).putString("previous_os_version", (String)localObject2);
        ((SharedPreferences.Editor)localObject3).apply();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this$0.getProperty().size();
        if (!((String)localObject1).equals(localObject2))
        {
          localObject2 = new Bundle();
          ((BaseBundle)localObject2).putString("_po", (String)localObject1);
          put("auto", "_ou", (Bundle)localObject2);
        }
      }
    }
  }
  
  final void set(zzai paramZzai)
  {
    append();
    boolean bool;
    if (((paramZzai.get(zzah.name)) && (paramZzai.get(zzah.count))) || (this$0.getName().contains())) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool != this$0.onContextMenuSelected())
    {
      this$0.initialize(bool);
      paramZzai = this$0.put();
      zzfy localZzfy = this$0;
      paramZzai.append();
      if (paramZzai.get().contains("measurement_enabled_from_api")) {
        paramZzai = Boolean.valueOf(paramZzai.get().getBoolean("measurement_enabled_from_api", true));
      } else {
        paramZzai = null;
      }
      if ((!bool) || (paramZzai == null) || (paramZzai.booleanValue())) {
        zzaa(Boolean.valueOf(bool), false);
      }
    }
  }
  
  protected final void set(String paramString1, String paramString2, long paramLong, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    paramBundle = new Bundle(paramBundle);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if ((localObject2 instanceof Bundle))
      {
        paramBundle.putBundle((String)localObject1, new Bundle((Bundle)localObject2));
      }
      else
      {
        boolean bool = localObject2 instanceof Parcelable[];
        int j = 0;
        int i = 0;
        if (bool)
        {
          localObject1 = (Parcelable[])localObject2;
          while (i < localObject1.length)
          {
            localObject2 = localObject1[i];
            if ((localObject2 instanceof Bundle)) {
              localObject1[i] = new Bundle((Bundle)localObject2);
            }
            i += 1;
          }
        }
        else if ((localObject2 instanceof List))
        {
          localObject1 = (List)localObject2;
          i = j;
          while (i < ((List)localObject1).size())
          {
            localObject2 = ((List)localObject1).get(i);
            if ((localObject2 instanceof Bundle)) {
              ((List)localObject1).set(i, new Bundle((Bundle)localObject2));
            }
            i += 1;
          }
        }
      }
    }
    this$0.zzaz().append(new zzhi(this, paramString1, paramString2, paramLong, paramBundle, paramBoolean1, paramBoolean2, paramBoolean3, paramString3));
  }
  
  public final void set(String paramString1, String paramString2, Bundle paramBundle)
  {
    long l = this$0.zzav().currentTimeMillis();
    Preconditions.checkNotEmpty(paramString1);
    Bundle localBundle = new Bundle();
    localBundle.putString("name", paramString1);
    localBundle.putLong("creation_timestamp", l);
    if (paramString2 != null)
    {
      localBundle.putString("expired_event_name", paramString2);
      localBundle.putBundle("expired_event_params", paramBundle);
    }
    this$0.zzaz().append(new zzhn(this, localBundle));
  }
  
  final void set(String paramString1, String paramString2, Object paramObject, long paramLong)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    append();
    next();
    Object localObject1 = paramString2;
    Object localObject2 = paramObject;
    if ("allow_personalized_ads".equals(paramString2))
    {
      if ((paramObject instanceof String))
      {
        localObject1 = (String)paramObject;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramObject = ((String)localObject1).toLowerCase(Locale.ENGLISH);
          paramString2 = "false";
          long l;
          if (true != "false".equals(paramObject)) {
            l = 0L;
          } else {
            l = 1L;
          }
          localObject1 = Long.valueOf(l);
          paramObject = localObject1;
          localObject2 = this$0.put().state;
          if (((Long)localObject1).longValue() == 1L) {
            paramString2 = "true";
          }
          ((zzfc)localObject2).put(paramString2);
          break label159;
        }
      }
      localObject1 = paramString2;
      localObject2 = paramObject;
      if (paramObject == null)
      {
        this$0.put().state.put("unset");
        label159:
        localObject1 = "_npa";
        localObject2 = paramObject;
      }
    }
    if (!this$0.size())
    {
      this$0.zzay().next().append("User property not set since app measurement is disabled");
      return;
    }
    if (!this$0.init()) {
      return;
    }
    paramString1 = new zzlc((String)localObject1, paramLong, localObject2, paramString1);
    this$0.getName().trim(paramString1);
  }
  
  public final void set(String paramString1, String paramString2, Object paramObject, boolean paramBoolean, long paramLong)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "app";
    }
    int i = 6;
    int j = 0;
    int k = 0;
    if (paramBoolean) {
      i = this$0.get().getType(paramString2);
    }
    for (;;)
    {
      break;
      paramString1 = this$0.get();
      if (paramString1.zzac("user property", paramString2)) {
        if (!paramString1.add("user property", zzgx.name, null, paramString2))
        {
          i = 15;
        }
        else
        {
          this$0.append();
          if (paramString1.add("user property", 24, paramString2)) {
            i = 0;
          }
        }
      }
    }
    if (i != 0)
    {
      paramString1 = this$0.get();
      this$0.append();
      paramString1 = paramString1.getText(paramString2, 24, true);
      j = k;
      if (paramString2 != null) {
        j = paramString2.length();
      }
      this$0.get().add(type, null, i, "_ev", paramString1, j);
      return;
    }
    if (paramObject != null)
    {
      k = this$0.get().get(paramString2, paramObject);
      if (k != 0)
      {
        paramString1 = this$0.get();
        this$0.append();
        paramString1 = paramString1.getText(paramString2, 24, true);
        if (!(paramObject instanceof String))
        {
          i = j;
          if (!(paramObject instanceof CharSequence)) {}
        }
        else
        {
          i = paramObject.toString().length();
        }
        this$0.get().add(type, null, k, "_ev", paramString1, i);
        return;
      }
      paramString1 = this$0.get().save(paramString2, paramObject);
      if (paramString1 != null) {
        e(str, paramString2, paramLong, paramString1);
      }
    }
    else
    {
      e(str, paramString2, paramLong, null);
    }
  }
  
  public final void setDefaultValue(long paramLong)
  {
    data.set(null);
    this$0.zzaz().append(new zzhl(this, paramLong));
  }
  
  public final void setDefaultValue(Boolean paramBoolean)
  {
    next();
    this$0.zzaz().append(new zzhw(this, paramBoolean));
  }
  
  public final void update(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    set("auto", "_ldl", paramObject, true, this$0.zzav().currentTimeMillis());
  }
}
