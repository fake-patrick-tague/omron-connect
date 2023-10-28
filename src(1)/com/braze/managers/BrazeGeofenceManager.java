package com.braze.managers;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.BrazeGeofence;
import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.DateTimeUtils;
import com.braze.support.PermissionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.t;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.c.l;
import kotlin.x.d.j;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.Actor;
import protect.package_9.Buffer;
import protect.package_9.DateConverter;
import protect.package_9.Frame;
import protect.package_9.Item;
import protect.package_9.LatinStringIO;
import protect.package_9.PaperSize;
import protect.package_9.c;
import protect.package_9.e.a;
import protect.package_9.k;
import protect.package_9.w;

public final class BrazeGeofenceManager
{
  public static final Companion Companion = new Companion(null);
  private final Context applicationContext;
  private final e.a brazeGeofenceApi;
  private Frame brazeGeofenceReEligibilityManager;
  private final List<BrazeGeofence> brazeGeofences;
  private final Actor brazeLocationApi;
  private final c brazeManager;
  private final BrazeConfigurationProvider configurationProvider;
  private final ReentrantLock geofenceListLock;
  private IBrazeLocation geofenceRequestLocation;
  private final SharedPreferences geofenceStorageSharedPreferences;
  private final PendingIntent geofenceTransitionPendingIntent;
  private boolean isGeofencesEnabled;
  private int maxNumToRegister;
  private final k serverConfigStorageProvider;
  
  public BrazeGeofenceManager(Context paramContext, String paramString, c paramC, BrazeConfigurationProvider paramBrazeConfigurationProvider, k paramK, Item paramItem)
  {
    brazeManager = paramC;
    configurationProvider = paramBrazeConfigurationProvider;
    serverConfigStorageProvider = paramK;
    paramC = new e.a();
    brazeGeofenceApi = paramC;
    brazeLocationApi = new Actor(paramContext, w.TAG.read(paramBrazeConfigurationProvider), paramBrazeConfigurationProvider);
    applicationContext = paramContext.getApplicationContext();
    geofenceListLock = new ReentrantLock();
    paramBrazeConfigurationProvider = Companion;
    Object localObject = paramBrazeConfigurationProvider.getGeofenceSharedPreferencesName(paramString);
    boolean bool2 = false;
    localObject = paramContext.getSharedPreferences((String)localObject, 0);
    kotlin.x.d.i.d(localObject, "context.getSharedPrefere?ontext.MODE_PRIVATE\n    )");
    geofenceStorageSharedPreferences = ((SharedPreferences)localObject);
    brazeGeofences = kotlin.collections.i.I(paramBrazeConfigurationProvider.retrieveBrazeGeofencesFromLocalStorage((SharedPreferences)localObject));
    geofenceTransitionPendingIntent = paramC.b(paramContext);
    brazeGeofenceReEligibilityManager = new Frame(paramContext, paramString, paramK, paramItem);
    boolean bool1 = bool2;
    if (paramBrazeConfigurationProvider.getGeofencesEnabledFromServerConfig(paramK))
    {
      bool1 = bool2;
      if (isGeofencesEnabledFromEnvironment(paramContext))
      {
        bool1 = bool2;
        if (paramC.a()) {
          bool1 = true;
        }
      }
    }
    isGeofencesEnabled = bool1;
    maxNumToRegister = paramBrazeConfigurationProvider.getMaxNumToRegister(paramK);
    if (!paramC.a()) {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, a.components, 2, null);
    }
    setUpGeofences(true);
  }
  
  public void configureFromServerConfig(Buffer paramBuffer)
  {
    kotlin.x.d.i.e(paramBuffer, "serverConfig");
    boolean bool = paramBuffer.add();
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, new b(bool), 3, null);
    if (bool)
    {
      Context localContext = applicationContext;
      kotlin.x.d.i.d(localContext, "applicationContext");
      if ((isGeofencesEnabledFromEnvironment(localContext)) && (brazeGeofenceApi.a()))
      {
        bool = true;
        break label79;
      }
    }
    bool = false;
    label79:
    if (bool != isGeofencesEnabled)
    {
      isGeofencesEnabled = bool;
      BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.g, null, new c(this), 2, null);
      if (isGeofencesEnabled)
      {
        setUpGeofences(false);
        if (configurationProvider.isAutomaticGeofenceRequestsEnabled()) {
          requestGeofenceRefresh(true);
        }
      }
      else
      {
        tearDownGeofences(geofenceTransitionPendingIntent);
      }
    }
    else
    {
      BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, new d(bool), 3, null);
    }
    int i = paramBuffer.read();
    if (i >= 0)
    {
      maxNumToRegister = i;
      BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.g, null, new e(this), 2, null);
    }
    brazeGeofenceReEligibilityManager.a(paramBuffer);
  }
  
  public final List getBrazeGeofences()
  {
    return brazeGeofences;
  }
  
  public final int getMaxNumToRegister()
  {
    return maxNumToRegister;
  }
  
  public final boolean isGeofencesEnabled()
  {
    return isGeofencesEnabled;
  }
  
  public final boolean isGeofencesEnabledFromEnvironment(Context paramContext)
  {
    kotlin.x.d.i.e(paramContext, "context");
    if (!Companion.getGeofencesEnabledFromConfiguration(configurationProvider))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, h.PLAYING, 3, null);
      return false;
    }
    if (!PermissionUtils.hasPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION"))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, i.components, 2, null);
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 29) && (!PermissionUtils.hasPermission(paramContext, "android.permission.ACCESS_BACKGROUND_LOCATION")))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, j.components, 2, null);
      return false;
    }
    if (!DateConverter.c(paramContext))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, k.PLAYING, 3, null);
      return false;
    }
    if (!brazeGeofenceApi.a())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, l.PLAYING, 3, null);
      return false;
    }
    try
    {
      Class.forName("com.google.android.gms.location.LocationServices", false, BrazeGeofenceManager.class.getClassLoader());
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, n.PLAYING, 3, null);
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, m.PLAYING, 3, null);
    return false;
  }
  
  public void onLocationRequestComplete(IBrazeLocation paramIBrazeLocation)
  {
    if (paramIBrazeLocation != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new o(paramIBrazeLocation), 3, null);
      requestGeofenceRefresh(paramIBrazeLocation);
      brazeGeofenceReEligibilityManager.init(DateTimeUtils.nowInSeconds());
      return;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, p.PLAYING, 3, null);
  }
  
  public void registerGeofences(List paramList)
  {
    kotlin.x.d.i.e(paramList, "geofenceList");
    paramList = kotlin.collections.i.I(paramList);
    if (!isGeofencesEnabled)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, s.PLAYING, 2, null);
      return;
    }
    Object localObject2;
    Object localObject3;
    if (geofenceRequestLocation != null)
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BrazeGeofence)((Iterator)localObject1).next();
        localObject3 = geofenceRequestLocation;
        if (localObject3 != null) {
          ((BrazeGeofence)localObject2).setDistanceFromGeofenceRefresh(PaperSize.distance(((IBrazeLocation)localObject3).getLatitude(), ((IBrazeLocation)localObject3).getLongitude(), ((BrazeGeofence)localObject2).getLatitude(), ((BrazeGeofence)localObject2).getLongitude()));
        }
      }
      kotlin.collections.i.k(paramList);
    }
    Object localObject1 = geofenceListLock;
    ((Lock)localObject1).lock();
    try
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new t(paramList), 3, null);
      localObject2 = geofenceStorageSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject2).clear();
      brazeGeofences.clear();
      int i = 0;
      localObject3 = paramList.iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject3).hasNext();
        if (!bool) {
          break;
        }
        BrazeGeofence localBrazeGeofence = (BrazeGeofence)((Iterator)localObject3).next();
        int j = maxNumToRegister;
        if (i == j)
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new u(this), 3, null);
          break;
        }
        brazeGeofences.add(localBrazeGeofence);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new v(localBrazeGeofence), 3, null);
        ((SharedPreferences.Editor)localObject2).putString(localBrazeGeofence.getId(), localBrazeGeofence.forJsonPut().toString());
        i += 1;
      }
      ((SharedPreferences.Editor)localObject2).apply();
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new w(this), 3, null);
      localObject2 = t.a;
      ((Lock)localObject1).unlock();
      brazeGeofenceReEligibilityManager.a(paramList);
      setUpGeofences(true);
      return;
    }
    catch (Throwable paramList)
    {
      ((Lock)localObject1).unlock();
      throw paramList;
    }
  }
  
  public final void registerGeofencesWithGooglePlay(List paramList, PendingIntent paramPendingIntent)
  {
    kotlin.x.d.i.e(paramList, "geofenceList");
    kotlin.x.d.i.e(paramPendingIntent, "geofenceRequestIntent");
    e.a localA = brazeGeofenceApi;
    Context localContext = applicationContext;
    kotlin.x.d.i.d(localContext, "applicationContext");
    localA.a(localContext, paramList, paramPendingIntent);
  }
  
  public void requestGeofenceRefresh(IBrazeLocation paramIBrazeLocation)
  {
    kotlin.x.d.i.e(paramIBrazeLocation, "location");
    if (!isGeofencesEnabled)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, x.PLAYING, 3, null);
      return;
    }
    geofenceRequestLocation = paramIBrazeLocation;
    if (paramIBrazeLocation != null) {
      brazeManager.b(paramIBrazeLocation);
    }
  }
  
  public void requestGeofenceRefresh(boolean paramBoolean)
  {
    if (!isGeofencesEnabled)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, y.PLAYING, 3, null);
      return;
    }
    if (brazeGeofenceReEligibilityManager.get(paramBoolean, DateTimeUtils.nowInSeconds())) {
      requestSingleLocationUpdateFromGooglePlay();
    }
  }
  
  public final void requestSingleLocationUpdateFromGooglePlay()
  {
    brazeLocationApi.b(new z(this));
  }
  
  public final void setUpGeofences(boolean paramBoolean)
  {
    if (!isGeofencesEnabled)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, a0.PLAYING, 3, null);
      return;
    }
    Object localObject = geofenceTransitionPendingIntent;
    if (localObject == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, b0.PLAYING, 3, null);
      return;
    }
    if (paramBoolean)
    {
      ReentrantLock localReentrantLock = geofenceListLock;
      localReentrantLock.lock();
      try
      {
        registerGeofencesWithGooglePlay(brazeGeofences, (PendingIntent)localObject);
        localObject = t.a;
        localReentrantLock.unlock();
        return;
      }
      catch (Throwable localThrowable)
      {
        localReentrantLock.unlock();
        throw localThrowable;
      }
    }
  }
  
  public final void tearDownGeofences(PendingIntent paramPendingIntent)
  {
    Object localObject = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default((BrazeLogger)localObject, this, null, null, c0.Real, 3, null);
    if (paramPendingIntent != null)
    {
      BrazeLogger.brazelog$default((BrazeLogger)localObject, this, null, null, d0.Blob, 3, null);
      e.a localA = brazeGeofenceApi;
      Context localContext = applicationContext;
      kotlin.x.d.i.d(localContext, "applicationContext");
      localA.b(localContext, paramPendingIntent);
    }
    paramPendingIntent = geofenceListLock;
    paramPendingIntent.lock();
    try
    {
      BrazeLogger.brazelog$default((BrazeLogger)localObject, this, null, null, e0.KATAKANA, 3, null);
      geofenceStorageSharedPreferences.edit().clear().apply();
      brazeGeofences.clear();
      localObject = t.a;
      paramPendingIntent.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramPendingIntent.unlock();
      throw localThrowable;
    }
  }
  
  public void unregisterGeofences()
  {
    if (!isGeofencesEnabled)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, f0.PLAYING, 3, null);
      return;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, g0.PLAYING, 3, null);
    tearDownGeofences(geofenceTransitionPendingIntent);
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    public final String getGeofenceSharedPreferencesName(String paramString)
    {
      kotlin.x.d.i.e(paramString, "apiKey");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("com.appboy.managers.geofences.storage.");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    
    public final boolean getGeofencesEnabledFromConfiguration(BrazeConfigurationProvider paramBrazeConfigurationProvider)
    {
      kotlin.x.d.i.e(paramBrazeConfigurationProvider, "configurationProvider");
      return paramBrazeConfigurationProvider.isGeofencesEnabled();
    }
    
    public final boolean getGeofencesEnabledFromServerConfig(k paramK)
    {
      kotlin.x.d.i.e(paramK, "serverConfigStorageProvider");
      if (paramK.next())
      {
        if (paramK.calculate())
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, a.components, 2, null);
          return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, b.components, 2, null);
        return false;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, c.components, 2, null);
      return false;
    }
    
    public final int getMaxNumToRegister(k paramK)
    {
      kotlin.x.d.i.e(paramK, "serverConfigStorageProvider");
      if (paramK.clear() > 0) {
        return paramK.clear();
      }
      return 20;
    }
    
    public final List retrieveBrazeGeofencesFromLocalStorage(SharedPreferences paramSharedPreferences)
    {
      kotlin.x.d.i.e(paramSharedPreferences, "sharedPreferences");
      ArrayList localArrayList = new ArrayList();
      Object localObject = paramSharedPreferences.getAll();
      int i;
      if ((localObject != null) && (!((Map)localObject).isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, d.PLAYING, 3, null);
        return localArrayList;
      }
      localObject = ((Map)localObject).keySet();
      if (((Set)localObject).isEmpty())
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, e.PLAYING, 2, null);
        return localArrayList;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        String str1 = paramSharedPreferences.getString(str2, null);
        if (str1 != null) {
          try
          {
            boolean bool = g.o(str1);
            if (!bool) {
              i = 0;
            }
          }
          catch (Exception localException)
          {
            break label252;
          }
          catch (JSONException localJSONException)
          {
            break label276;
          }
        }
        i = 1;
        if (i != 0)
        {
          BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
          BrazeLogger.Priority localPriority = BrazeLogger.Priority.PREPARED;
          BrazeLogger.brazelog$default(localBrazeLogger, this, localPriority, null, new f(localJSONException), 2, null);
        }
        else
        {
          JSONObject localJSONObject = new JSONObject(str1);
          localArrayList.add(new BrazeGeofence(localJSONObject));
          continue;
          label252:
          BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localJSONObject, new h(str1));
          continue;
          label276:
          BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localJSONObject, new g(str1));
        }
      }
      return localArrayList;
    }
    
    static final class a
      extends j
      implements a<String>
    {
      public static final a components = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Geofences enabled in server configuration.";
      }
    }
    
    static final class b
      extends j
      implements a<String>
    {
      public static final b components = new b();
      
      b()
      {
        super();
      }
      
      public final String getText()
      {
        return "Geofences explicitly disabled via server configuration.";
      }
    }
    
    static final class c
      extends j
      implements a<String>
    {
      public static final c components = new c();
      
      c()
      {
        super();
      }
      
      public final String getText()
      {
        return "Geofences implicitly disabled via server configuration.";
      }
    }
    
    static final class d
      extends j
      implements a<String>
    {
      public static final d PLAYING = new d();
      
      d()
      {
        super();
      }
      
      public final String getText()
      {
        return "Did not find stored geofences.";
      }
    }
    
    static final class e
      extends j
      implements a<String>
    {
      public static final e PLAYING = new e();
      
      e()
      {
        super();
      }
      
      public final String getText()
      {
        return "Failed to find stored geofence keys.";
      }
    }
    
    static final class f
      extends j
      implements a<String>
    {
      f(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Received null or blank serialized geofence string for geofence id ");
        localStringBuilder.append(src);
        localStringBuilder.append(" from shared preferences. Not parsing.");
        return localStringBuilder.toString();
      }
    }
    
    static final class g
      extends j
      implements a<String>
    {
      g(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Encountered Json exception while parsing stored geofence: ");
        localStringBuilder.append(src);
        return localStringBuilder.toString();
      }
    }
    
    static final class h
      extends j
      implements a<String>
    {
      h(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Encountered unexpected exception while parsing stored geofence: ");
        localStringBuilder.append(src);
        return localStringBuilder.toString();
      }
    }
  }
  
  static final class a
    extends j
    implements a<String>
  {
    public static final a components = new a();
    
    a()
    {
      super();
    }
    
    public final String getText()
    {
      return "***Geofence API not found. Please include the android-sdk-location module***";
    }
  }
  
  static final class a0
    extends j
    implements a<String>
  {
    public static final a0 PLAYING = new a0();
    
    a0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Braze geofences not enabled. Geofences not set up.";
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    b(boolean paramBoolean)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Geofences enabled server config value ");
      localStringBuilder.append(start);
      localStringBuilder.append(" received.");
      return localStringBuilder.toString();
    }
  }
  
  static final class b0
    extends j
    implements a<String>
  {
    public static final b0 PLAYING = new b0();
    
    b0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Could not get pending intent to setup geofences";
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    c(BrazeGeofenceManager paramBrazeGeofenceManager)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Geofences enabled status newly set to ");
      localStringBuilder.append(src.isGeofencesEnabled());
      localStringBuilder.append(" during server config update.");
      return localStringBuilder.toString();
    }
  }
  
  static final class c0
    extends j
    implements a<String>
  {
    public static final c0 Real = new c0();
    
    c0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Tearing down geofences.";
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    d(boolean paramBoolean)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Geofences enabled status of `");
      localStringBuilder.append(start);
      localStringBuilder.append("` was unchanged during server config update.");
      return localStringBuilder.toString();
    }
  }
  
  static final class d0
    extends j
    implements a<String>
  {
    public static final d0 Blob = new d0();
    
    d0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Unregistering any Braze geofences from Google Play Services.";
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    e(BrazeGeofenceManager paramBrazeGeofenceManager)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Max number to register newly set to ");
      localStringBuilder.append(src.getMaxNumToRegister());
      localStringBuilder.append(" via server config.");
      return localStringBuilder.toString();
    }
  }
  
  static final class e0
    extends j
    implements a<String>
  {
    public static final e0 KATAKANA = new e0();
    
    e0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Deleting locally stored geofences.";
    }
  }
  
  static final class f0
    extends j
    implements a<String>
  {
    public static final f0 PLAYING = new f0();
    
    f0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Braze geofences not enabled. Not un-registering geofences.";
    }
  }
  
  static final class g0
    extends j
    implements a<String>
  {
    public static final g0 PLAYING = new g0();
    
    g0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Tearing down all geofences.";
    }
  }
  
  static final class h
    extends j
    implements a<String>
  {
    public static final h PLAYING = new h();
    
    h()
    {
      super();
    }
    
    public final String getText()
    {
      return "Braze Geofences disabled or Braze location collection disabled in local configuration. Geofences not enabled.";
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    public static final i components = new i();
    
    i()
    {
      super();
    }
    
    public final String getText()
    {
      return "Fine grained location permissions not found. Geofences not enabled.";
    }
  }
  
  static final class j
    extends j
    implements a<String>
  {
    public static final j components = new j();
    
    j()
    {
      super();
    }
    
    public final String getText()
    {
      return "Background location access permission not found. Geofences not enabled.";
    }
  }
  
  static final class k
    extends j
    implements a<String>
  {
    public static final k PLAYING = new k();
    
    k()
    {
      super();
    }
    
    public final String getText()
    {
      return "Google Play Services not available. Geofences not enabled.";
    }
  }
  
  static final class l
    extends j
    implements a<String>
  {
    public static final l PLAYING = new l();
    
    l()
    {
      super();
    }
    
    public final String getText()
    {
      return "Braze Geofence API is not available";
    }
  }
  
  static final class m
    extends j
    implements a<String>
  {
    public static final m PLAYING = new m();
    
    m()
    {
      super();
    }
    
    public final String getText()
    {
      return "Google Play Services Location API not found. Geofences not enabled.";
    }
  }
  
  static final class n
    extends j
    implements a<String>
  {
    public static final n PLAYING = new n();
    
    n()
    {
      super();
    }
    
    public final String getText()
    {
      return "Location permissions granted and Google Play Services available. Braze Geofencing enabled via config.";
    }
  }
  
  static final class o
    extends j
    implements a<String>
  {
    o(IBrazeLocation paramIBrazeLocation)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Single location request was successful, requesting Geofence refresh. Location:\n ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class p
    extends j
    implements a<String>
  {
    public static final p PLAYING = new p();
    
    p()
    {
      super();
    }
    
    public final String getText()
    {
      return "Single location request was unsuccessful, not storing last updated time.";
    }
  }
  
  static final class s
    extends j
    implements a<String>
  {
    public static final s PLAYING = new s();
    
    s()
    {
      super();
    }
    
    public final String getText()
    {
      return "Braze geofences not enabled. Not adding new geofences to local storage.";
    }
  }
  
  static final class t
    extends j
    implements a<String>
  {
    t(List paramList)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Received new geofence list of size: ");
      localStringBuilder.append(backups.size());
      return localStringBuilder.toString();
    }
  }
  
  static final class u
    extends j
    implements a<String>
  {
    u(BrazeGeofenceManager paramBrazeGeofenceManager)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Reached maximum number of new geofences: ");
      localStringBuilder.append(src.getMaxNumToRegister());
      return localStringBuilder.toString();
    }
  }
  
  static final class v
    extends j
    implements a<String>
  {
    v(BrazeGeofence paramBrazeGeofence)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Adding new geofence to local storage: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class w
    extends j
    implements a<String>
  {
    w(BrazeGeofenceManager paramBrazeGeofenceManager)
    {
      super();
    }
    
    public final String extract()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Added ");
      localStringBuilder.append(internal.getBrazeGeofences().size());
      localStringBuilder.append(" new geofences to local storage.");
      return localStringBuilder.toString();
    }
  }
  
  static final class x
    extends j
    implements a<String>
  {
    public static final x PLAYING = new x();
    
    x()
    {
      super();
    }
    
    public final String getText()
    {
      return "Braze geofences not enabled. Not requesting geofences.";
    }
  }
  
  static final class y
    extends j
    implements a<String>
  {
    public static final y PLAYING = new y();
    
    y()
    {
      super();
    }
    
    public final String getText()
    {
      return "Braze geofences not enabled. Not requesting geofences.";
    }
  }
  
  static final class z
    extends j
    implements l<IBrazeLocation, t>
  {
    z(BrazeGeofenceManager paramBrazeGeofenceManager)
    {
      super();
    }
    
    public final void e(IBrazeLocation paramIBrazeLocation)
    {
      kotlin.x.d.i.e(paramIBrazeLocation, "location");
      o.onLocationRequestComplete(paramIBrazeLocation);
    }
  }
}
