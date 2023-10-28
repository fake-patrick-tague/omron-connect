package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.BaseBundle;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzis
  extends Log
{
  private volatile zzik a;
  private volatile boolean b;
  private Activity c;
  private final Object d = new Object();
  @VisibleForTesting
  protected zzik data;
  private boolean e;
  private volatile zzik f;
  private volatile zzik i;
  private zzik state;
  private final Map this$0 = new ConcurrentHashMap();
  
  public zzis(zzfy paramZzfy)
  {
    super(paramZzfy);
  }
  
  private final void d(Activity paramActivity, zzik paramZzik, boolean paramBoolean)
  {
    zzik localZzik1;
    if (a == null) {
      localZzik1 = i;
    } else {
      localZzik1 = a;
    }
    zzik localZzik2 = paramZzik;
    if (c == null)
    {
      if (paramActivity != null) {
        paramActivity = getName(paramActivity.getClass(), "Activity");
      } else {
        paramActivity = null;
      }
      localZzik2 = new zzik(a, paramActivity, g, x, d);
    }
    i = a;
    a = localZzik2;
    long l = this$0.zzav().elapsedRealtime();
    this$0.zzaz().append(new zzin(this, localZzik2, localZzik1, l, paramBoolean));
  }
  
  private final void execute(zzik paramZzik, boolean paramBoolean, long paramLong)
  {
    this$0.a().execute(this$0.zzav().elapsedRealtime());
    boolean bool;
    if ((paramZzik != null) && (result)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((this$0.getRepository().this$0.update(bool, paramBoolean, paramLong)) && (paramZzik != null)) {
      result = false;
    }
  }
  
  private final void init(zzik paramZzik1, zzik paramZzik2, long paramLong, boolean paramBoolean, Bundle paramBundle)
  {
    append();
    int m = 0;
    int j;
    if ((paramZzik2 != null) && (g == g) && (zzil.put(c, c)) && (zzil.put(a, a))) {
      j = 0;
    } else {
      j = 1;
    }
    int k = m;
    if (paramBoolean)
    {
      k = m;
      if (data != null) {
        k = 1;
      }
    }
    if (j != 0)
    {
      if (paramBundle != null) {
        paramBundle = new Bundle(paramBundle);
      } else {
        paramBundle = new Bundle();
      }
      zzlh.add(paramZzik1, paramBundle, true);
      if (paramZzik2 != null)
      {
        String str = a;
        if (str != null) {
          paramBundle.putString("_pn", str);
        }
        str = c;
        if (str != null) {
          paramBundle.putString("_pc", str);
        }
        paramBundle.putLong("_pi", g);
      }
      if (k != 0)
      {
        paramZzik2 = this$0.getRepository().this$0;
        l1 = paramLong - count;
        count = paramLong;
        if (l1 > 0L) {
          this$0.get().startSession(paramBundle, l1);
        }
      }
      if (!this$0.append().d()) {
        paramBundle.putLong("_mst", 1L);
      }
      if (true != x) {
        paramZzik2 = "auto";
      } else {
        paramZzik2 = "app";
      }
      long l2 = this$0.zzav().currentTimeMillis();
      long l1 = l2;
      if (x)
      {
        l1 = d;
        if (l1 == 0L) {
          l1 = l2;
        } else {}
      }
      this$0.add().e(paramZzik2, "_vs", l1, paramBundle);
    }
    if (k != 0) {
      execute(data, true, paramLong);
    }
    data = paramZzik1;
    if (x) {
      state = paramZzik1;
    }
    this$0.getName().setText(paramZzik1);
  }
  
  private final zzik toString(Activity paramActivity)
  {
    Preconditions.checkNotNull(paramActivity);
    zzik localZzik2 = (zzik)this$0.get(paramActivity);
    zzik localZzik1 = localZzik2;
    if (localZzik2 == null)
    {
      localZzik1 = new zzik(null, getName(paramActivity.getClass(), "Activity"), this$0.get().next());
      this$0.put(paramActivity, localZzik1);
    }
    if (f != null) {
      localZzik1 = f;
    }
    return localZzik1;
  }
  
  public final void a(Bundle paramBundle, long paramLong)
  {
    Object localObject3 = d;
    label465:
    for (;;)
    {
      try
      {
        if (!e)
        {
          this$0.zzay().isEmpty().append("Cannot log screen view event when the app is in the background.");
          return;
        }
        String str = paramBundle.getString("screen_name");
        int j;
        if (str != null) {
          if (str.length() > 0)
          {
            j = str.length();
            this$0.append();
            if (j <= 100) {}
          }
          else
          {
            this$0.zzay().isEmpty().append("Invalid screen name length for screen view. Length", Integer.valueOf(str.length()));
            return;
          }
        }
        Object localObject2 = paramBundle.getString("screen_class");
        if (localObject2 != null) {
          if (((String)localObject2).length() > 0)
          {
            j = ((String)localObject2).length();
            this$0.append();
            if (j <= 100) {}
          }
          else
          {
            this$0.zzay().isEmpty().append("Invalid screen class length for screen view. Length", Integer.valueOf(((String)localObject2).length()));
            return;
          }
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = c;
          if (localObject1 != null)
          {
            localObject1 = getName(localObject1.getClass(), "Activity");
            break label465;
          }
        }
        else
        {
          localObject2 = a;
          if ((b) && (localObject2 != null))
          {
            b = false;
            boolean bool1 = zzil.put(c, localObject1);
            boolean bool2 = zzil.put(a, str);
            if ((bool1) && (bool2))
            {
              this$0.zzay().isEmpty().append("Ignoring call to log screen view event with duplicate parameters.");
              return;
            }
          }
          zzem localZzem = this$0.zzay().next();
          if (str == null) {
            localObject2 = "null";
          } else {
            localObject2 = str;
          }
          if (localObject1 == null) {
            localObject3 = "null";
          } else {
            localObject3 = localObject1;
          }
          localZzem.append("Logging screen view with name, class", localObject2, localObject3);
          if (a == null) {
            localObject2 = i;
          } else {
            localObject2 = a;
          }
          localObject1 = new zzik(str, (String)localObject1, this$0.get().next(), true, paramLong);
          a = ((zzik)localObject1);
          i = ((zzik)localObject2);
          f = ((zzik)localObject1);
          paramLong = this$0.zzav().elapsedRealtime();
          this$0.zzaz().append(new zzim(this, paramBundle, (zzik)localObject1, (zzik)localObject2, paramLong));
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        throw paramBundle;
      }
      Object localObject1 = "Activity";
    }
  }
  
  public final void d(Activity paramActivity)
  {
    Object localObject = d;
    try
    {
      e = false;
      b = true;
      long l = this$0.zzav().elapsedRealtime();
      if (!this$0.append().d())
      {
        a = null;
        this$0.zzaz().append(new zzip(this, l));
        return;
      }
      paramActivity = toString(paramActivity);
      i = a;
      a = null;
      this$0.zzaz().append(new zziq(this, paramActivity, l));
      return;
    }
    catch (Throwable paramActivity)
    {
      throw paramActivity;
    }
  }
  
  public final zzik get()
  {
    return a;
  }
  
  public final zzik get(boolean paramBoolean)
  {
    next();
    append();
    if (!paramBoolean) {
      return data;
    }
    zzik localZzik = data;
    if (localZzik != null) {
      return localZzik;
    }
    return state;
  }
  
  public final void get(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!this$0.append().d())
    {
      this$0.zzay().isEmpty().append("setCurrentScreen cannot be called while screen reporting is disabled.");
      return;
    }
    Object localObject = a;
    if (localObject == null)
    {
      this$0.zzay().isEmpty().append("setCurrentScreen cannot be called while no activity active");
      return;
    }
    if (this$0.get(paramActivity) == null)
    {
      this$0.zzay().isEmpty().append("setCurrentScreen must be called with an activity in the activity lifecycle");
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = getName(paramActivity.getClass(), "Activity");
    }
    boolean bool1 = zzil.put(c, str);
    boolean bool2 = zzil.put(a, paramString1);
    if ((bool1) && (bool2))
    {
      this$0.zzay().isEmpty().append("setCurrentScreen cannot be called with the same class and name");
      return;
    }
    if (paramString1 != null) {
      if (paramString1.length() > 0)
      {
        this$0.append();
        if (paramString1.length() <= 100) {}
      }
      else
      {
        this$0.zzay().isEmpty().append("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(paramString1.length()));
        return;
      }
    }
    if (str != null) {
      if (str.length() > 0)
      {
        this$0.append();
        if (str.length() <= 100) {}
      }
      else
      {
        this$0.zzay().isEmpty().append("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
        return;
      }
    }
    localObject = this$0.zzay().next();
    if (paramString1 == null) {
      paramString2 = "null";
    } else {
      paramString2 = paramString1;
    }
    ((zzem)localObject).append("Setting current screen to name, class", paramString2, str);
    paramString1 = new zzik(paramString1, str, this$0.get().next());
    this$0.put(paramActivity, paramString1);
    d(paramActivity, paramString1, true);
  }
  
  final String getName(Class paramClass, String paramString)
  {
    paramClass = paramClass.getCanonicalName();
    if (paramClass == null) {
      return "Activity";
    }
    paramClass = paramClass.split("\\.");
    int j = paramClass.length;
    if (j > 0) {
      paramClass = paramClass[(j - 1)];
    } else {
      paramClass = "";
    }
    j = paramClass.length();
    this$0.append();
    paramString = paramClass;
    if (j > 100)
    {
      this$0.append();
      paramString = paramClass.substring(0, 100);
    }
    return paramString;
  }
  
  protected final boolean isMapped()
  {
    return false;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (!this$0.append().d()) {
      return;
    }
    if (paramBundle == null) {
      return;
    }
    paramBundle = paramBundle.getBundle("com.google.app_measurement.screen_service");
    if (paramBundle == null) {
      return;
    }
    paramBundle = new zzik(paramBundle.getString("name"), paramBundle.getString("referrer_name"), paramBundle.getLong("id"));
    this$0.put(paramActivity, paramBundle);
  }
  
  public final void save(Activity paramActivity, Bundle paramBundle)
  {
    if (!this$0.append().d()) {
      return;
    }
    if (paramBundle == null) {
      return;
    }
    paramActivity = (zzik)this$0.get(paramActivity);
    if (paramActivity == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("id", g);
    localBundle.putString("name", a);
    localBundle.putString("referrer_name", c);
    paramBundle.putBundle("com.google.app_measurement.screen_service", localBundle);
  }
  
  public final void send(Activity paramActivity)
  {
    Object localObject = d;
    try
    {
      if (paramActivity == c) {
        c = null;
      }
      if (!this$0.append().d()) {
        return;
      }
      this$0.remove(paramActivity);
      return;
    }
    catch (Throwable paramActivity)
    {
      throw paramActivity;
    }
  }
  
  public final void visitMaxs(Activity paramActivity)
  {
    Object localObject1 = d;
    try
    {
      e = true;
      if (paramActivity != c)
      {
        Object localObject2 = d;
        try
        {
          c = paramActivity;
          b = false;
          boolean bool = this$0.append().d();
          if (bool)
          {
            f = null;
            this$0.zzaz().append(new zzir(this));
          }
        }
        catch (Throwable paramActivity)
        {
          throw paramActivity;
        }
      }
      if (!this$0.append().d())
      {
        a = f;
        this$0.zzaz().append(new zzio(this));
        return;
      }
      d(paramActivity, toString(paramActivity), false);
      paramActivity = this$0.a();
      long l = this$0.zzav().elapsedRealtime();
      this$0.zzaz().append(new Plugin.1(paramActivity, l));
      return;
    }
    catch (Throwable paramActivity)
    {
      throw paramActivity;
    }
  }
}
