package com.braze;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import com.braze.configuration.BrazeConfig;
import com.braze.configuration.BrazeConfig.Builder;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.IValueCallback;
import com.braze.events.InAppMessageEvent;
import com.braze.events.SdkDataWipeEvent;
import com.braze.images.DefaultBrazeImageLoader;
import com.braze.images.DefaultBrazeImageLoader.b;
import com.braze.images.IBrazeImageLoader;
import com.braze.managers.BrazeGeofenceManager;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.DateTimeUtils;
import com.braze.support.PermissionUtils;
import com.braze.support.StringUtils;
import com.braze.support.ValidationUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.g0;
import kotlin.n;
import kotlin.t;
import kotlin.text.g;
import kotlin.w.d;
import kotlin.x.d.i;
import kotlin.x.d.j;
import kotlin.x.d.s;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.t0;
import protect.package_9.Action;
import protect.package_9.AppCompatDelegateImplV7;
import protect.package_9.AppPreferences;
import protect.package_9.BitmapLoader;
import protect.package_9.ByteVector;
import protect.package_9.Card;
import protect.package_9.ClassReader;
import protect.package_9.ClassWriter;
import protect.package_9.Config;
import protect.package_9.CopyOnWriteArrayList;
import protect.package_9.Device;
import protect.package_9.Edge;
import protect.package_9.ExtensionData;
import protect.package_9.HttpURLConnection;
import protect.package_9.Injector;
import protect.package_9.Item;
import protect.package_9.JSONObject;
import protect.package_9.LayoutManager;
import protect.package_9.MainActivity;
import protect.package_9.MethodWriter;
import protect.package_9.Plot;
import protect.package_9.PriorityQueue;
import protect.package_9.RecurrencePickerDialogFragment;
import protect.package_9.Scope;
import protect.package_9.SubjectSubscriptionManager;
import protect.package_9.ThemeManager;
import protect.package_9.TimeInterval;
import protect.package_9.TintTypedArray;
import protect.package_9.Tools;
import protect.package_9.ValueMarker;
import protect.package_9.e4.a;
import protect.package_9.h4.a;
import protect.package_9.i.a;
import protect.package_9.k;
import protect.package_9.o;
import protect.package_9.x3.a;
import protect.package_9.z5.a;

public final class Braze
{
  public static final Companion Companion = new Companion(null);
  private static final Set<String> KNOWN_APP_CRAWLER_DEVICE_MODELS;
  private static final Set<String> NECESSARY_BRAZE_SDK_PERMISSIONS;
  private static boolean areOutboundNetworkRequestsOffline;
  private static final ReentrantLock brazeClassLock = new ReentrantLock();
  private static final BrazeConfig clearConfigSentinel = new BrazeConfig.Builder().build();
  private static IBrazeNotificationFactory customBrazeNotificationFactory;
  private static IBrazeEndpointProvider endpointProvider;
  private static final ReentrantLock endpointProviderLock;
  private static volatile Braze instance;
  private static final List<BrazeConfig> pendingConfigurations;
  private static Edge sdkEnablementProvider;
  private static boolean shouldMockNetworkRequestsAndDropEvents;
  private Context applicationContext;
  private BrazeUser brazeUser;
  public BrazeConfigurationProvider configurationProvider;
  public AppPreferences deviceIdReader;
  private Item externalIEventMessenger;
  public IBrazeImageLoader imageLoader;
  private Boolean isApiKeyPresent;
  private boolean isInstanceStopped;
  private Card offlineUserStorageProvider;
  public CopyOnWriteArrayList packetWriter;
  private Injector registrationDataProvider;
  
  static
  {
    KNOWN_APP_CRAWLER_DEVICE_MODELS = g0.a("calypso appcrawler");
    NECESSARY_BRAZE_SDK_PERMISSIONS = g0.d(new String[] { "android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET" });
    endpointProviderLock = new ReentrantLock();
    pendingConfigurations = new ArrayList();
  }
  
  public Braze(final Context paramContext)
  {
    long l = System.nanoTime();
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, a.LINE_SEPARATOR, 3, null);
    Object localObject = paramContext.getApplicationContext();
    i.d(localObject, "context.applicationContext");
    applicationContext = ((Context)localObject);
    localObject = Build.MODEL;
    if (localObject != null)
    {
      Set localSet = KNOWN_APP_CRAWLER_DEVICE_MODELS;
      String str = ((String)localObject).toLowerCase(Locale.ROOT);
      i.d(str, "this as java.lang.String).toLowerCase(Locale.ROOT)");
      if (localSet.contains(str))
      {
        BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.g, null, new b((String)localObject), 2, null);
        Companion.enableMockNetworkRequestsAndDropEventsMode();
      }
    }
    setImageLoader(new DefaultBrazeImageLoader(applicationContext));
    externalIEventMessenger = new PriorityQueue(Companion.access$getSdkEnablementProvider(Companion, applicationContext));
    run$android_sdk_base_release(c.READ_ONLY, false, new d(this, paramContext));
    BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, new e(System.nanoTime(), l), 3, null);
  }
  
  public static final boolean configure(Context paramContext, BrazeConfig paramBrazeConfig)
  {
    return Companion.configure(paramContext, paramBrazeConfig);
  }
  
  private final ContentCardsUpdatedEvent getCachedContentCardsUpdatedEvent()
  {
    return (ContentCardsUpdatedEvent)runForResult$default(this, null, l.CurrentItem, false, new m(this, null), 4, null);
  }
  
  public static final Braze getInstance(Context paramContext)
  {
    return Companion.getInstance(paramContext);
  }
  
  private final boolean isEphemeralEventKey(String paramString)
  {
    if (!getConfigurationProvider$android_sdk_base_release().isEphemeralEventsEnabled()) {
      return false;
    }
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.Priority localPriority = BrazeLogger.Priority.$EnumSwitchMapping$0;
    BrazeLogger.brazelog$default(localBrazeLogger, this, localPriority, null, p0.SINGLE_FILE, 2, null);
    final Set localSet = getConfigurationProvider$android_sdk_base_release().getEphemeralEventKeys();
    final boolean bool = localSet.contains(paramString);
    BrazeLogger.brazelog$default(localBrazeLogger, this, localPriority, null, new q0(paramString, localSet, bool), 2, null);
    return bool;
  }
  
  private final void publishError(Throwable paramThrowable)
  {
    if (packetWriter == null)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.$EnumSwitchMapping$0, paramThrowable, n1.PREPARED);
      return;
    }
    try
    {
      getUdm$android_sdk_base_release().getDescriptor().add(paramThrowable, Throwable.class);
      return;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localException, new o1(paramThrowable));
    }
  }
  
  private final Object runForResult(Object paramObject, kotlin.x.c.a paramA, boolean paramBoolean, kotlin.x.c.p paramP)
  {
    if ((paramBoolean) && (Companion.isDisabled())) {
      return paramObject;
    }
    try
    {
      paramP = kotlinx.coroutines.h.f(null, new v2(paramP, null), 1, null);
      return paramP;
    }
    catch (Exception paramP)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramP, paramA);
      publishError(paramP);
    }
    return paramObject;
  }
  
  private final void setSyncPolicyOfflineStatus(final boolean paramBoolean)
  {
    run$android_sdk_base_release$default(this, new a3(paramBoolean), false, new b3(this, paramBoolean), 2, null);
  }
  
  private final void setUserSpecificMemberVariablesAndStartDispatch(MainActivity paramMainActivity)
  {
    setUdm$android_sdk_base_release(paramMainActivity);
    RecurrencePickerDialogFragment.this$0.doToast(getUdm$android_sdk_base_release().getDescriptor());
    JSONObject localJSONObject = getUdm$android_sdk_base_release().getCallback();
    protect.package_9.c localC = getUdm$android_sdk_base_release().a();
    Card localCard = offlineUserStorageProvider;
    paramMainActivity = localCard;
    if (localCard == null)
    {
      i.o("offlineUserStorageProvider");
      paramMainActivity = null;
    }
    brazeUser = new BrazeUser(localJSONObject, localC, paramMainActivity.getValue(), getUdm$android_sdk_base_release().getDB(), getUdm$android_sdk_base_release().remove());
    getUdm$android_sdk_base_release().setFragment().a(getUdm$android_sdk_base_release().getDescriptor());
    getUdm$android_sdk_base_release().q().b();
    getUdm$android_sdk_base_release().getContentLength().a(getUdm$android_sdk_base_release().q());
  }
  
  private final void verifyProperSdkSetup()
  {
    Iterator localIterator = NECESSARY_BRAZE_SDK_PERMISSIONS.iterator();
    int j = 0;
    int i = 1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!PermissionUtils.hasPermission(applicationContext, str))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, new n3(str), 2, null);
        i = 0;
      }
    }
    if (g.o(getConfigurationProvider$android_sdk_base_release().getBrazeApiKey().toString()))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, o3.PLAYING, 2, null);
      i = j;
    }
    if (i == 0) {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, p3.STARTED, 2, null);
    }
  }
  
  public static final void wipeData(Context paramContext)
  {
    Companion.wipeData(paramContext);
  }
  
  public void addSingleSynchronousSubscription(IEventSubscriber paramIEventSubscriber, Class paramClass)
  {
    i.e(paramIEventSubscriber, "subscriber");
    i.e(paramClass, "eventClass");
    Item localItem = externalIEventMessenger;
    try
    {
      localItem.a(paramClass, paramIEventSubscriber);
      return;
    }
    catch (Exception paramIEventSubscriber)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramIEventSubscriber, new h(paramClass));
      publishError(paramIEventSubscriber);
    }
  }
  
  public void changeUser(String paramString)
  {
    changeUser(paramString, null);
  }
  
  public void changeUser(String paramString1, final String paramString2)
  {
    run$android_sdk_base_release$default(this, new n(paramString1), false, new o(paramString1, this, paramString2), 2, null);
  }
  
  public void closeSession(Activity paramActivity)
  {
    run$android_sdk_base_release$default(this, p.ANDROID_VERSION, false, new q(paramActivity, this), 2, null);
  }
  
  public List getCachedContentCards()
  {
    if (Companion.isDisabled()) {
      return null;
    }
    ContentCardsUpdatedEvent localContentCardsUpdatedEvent = getCachedContentCardsUpdatedEvent();
    if (localContentCardsUpdatedEvent != null) {
      return localContentCardsUpdatedEvent.getAllCards();
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, d0.SINGLE_FILE, 2, null);
    return null;
  }
  
  public final BrazeConfigurationProvider getConfigurationProvider$android_sdk_base_release()
  {
    BrazeConfigurationProvider localBrazeConfigurationProvider = configurationProvider;
    if (localBrazeConfigurationProvider != null) {
      return localBrazeConfigurationProvider;
    }
    i.o("configurationProvider");
    return null;
  }
  
  public BrazeUser getCurrentUser()
  {
    return (BrazeUser)runForResult(null, r.sync, false, new s(this, null));
  }
  
  public void getCurrentUser(IValueCallback paramIValueCallback)
  {
    i.e(paramIValueCallback, "completionCallback");
    if (Companion.isDisabled())
    {
      paramIValueCallback.onError();
      return;
    }
    RecurrencePickerDialogFragment localRecurrencePickerDialogFragment = RecurrencePickerDialogFragment.this$0;
    try
    {
      kotlinx.coroutines.h.d(localRecurrencePickerDialogFragment, null, null, new h0(paramIValueCallback, this, null), 3, null);
      return;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, i0.STARTED);
      paramIValueCallback.onError();
      publishError(localException);
    }
  }
  
  public final AppPreferences getDeviceIdReader$android_sdk_base_release()
  {
    AppPreferences localAppPreferences = deviceIdReader;
    if (localAppPreferences != null) {
      return localAppPreferences;
    }
    i.o("deviceIdReader");
    return null;
  }
  
  public final Item getExternalIEventMessenger$android_sdk_base_release()
  {
    return externalIEventMessenger;
  }
  
  public IBrazeImageLoader getImageLoader()
  {
    IBrazeImageLoader localIBrazeImageLoader = imageLoader;
    if (localIBrazeImageLoader != null) {
      return localIBrazeImageLoader;
    }
    i.o("imageLoader");
    return null;
  }
  
  public final CopyOnWriteArrayList getUdm$android_sdk_base_release()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = packetWriter;
    if (localCopyOnWriteArrayList != null) {
      return localCopyOnWriteArrayList;
    }
    i.o("udm");
    return null;
  }
  
  public final Boolean isApiKeyPresent$android_sdk_base_release()
  {
    return isApiKeyPresent;
  }
  
  public void logCustomEvent(String paramString)
  {
    logCustomEvent(paramString, null);
  }
  
  public void logCustomEvent(String paramString, final BrazeProperties paramBrazeProperties)
  {
    if (paramBrazeProperties != null) {
      paramBrazeProperties = paramBrazeProperties.clone();
    } else {
      paramBrazeProperties = null;
    }
    run$android_sdk_base_release$default(this, new r0(paramString), false, new s0(paramString, this, paramBrazeProperties), 2, null);
  }
  
  public void logFeedDisplayed()
  {
    run$android_sdk_base_release$default(this, x0.CurrentItem, false, new y0(this), 2, null);
  }
  
  public void logPurchase(String paramString1, final String paramString2, final BigDecimal paramBigDecimal, final int paramInt, final BrazeProperties paramBrazeProperties)
  {
    if (paramBrazeProperties != null) {
      paramBrazeProperties = paramBrazeProperties.clone();
    } else {
      paramBrazeProperties = null;
    }
    run$android_sdk_base_release$default(this, new b1(paramString1), false, new c1(paramString1, paramString2, paramBigDecimal, paramInt, this, paramBrazeProperties), 2, null);
  }
  
  public void logPushNotificationActionClicked(String paramString1, final String paramString2, final String paramString3)
  {
    run$android_sdk_base_release$default(this, d1.CurrentItem, false, new e1(paramString1, this, paramString2, paramString3), 2, null);
  }
  
  public void logPushNotificationOpened(Intent paramIntent)
  {
    run$android_sdk_base_release$default(this, new h1(paramIntent), false, new i1(paramIntent, this), 2, null);
  }
  
  public void logPushStoryPageClicked(final String paramString1, final String paramString2)
  {
    run$android_sdk_base_release$default(this, new j1(paramString2, paramString1), false, new k1(paramString1, paramString2, this), 2, null);
  }
  
  public void openSession(Activity paramActivity)
  {
    run$android_sdk_base_release$default(this, l1.NETWORK, false, new m1(paramActivity, this), 2, null);
  }
  
  public void refreshFeatureFlags()
  {
    run$android_sdk_base_release$default(this, r1.CurrentItem, false, new s1(this), 2, null);
  }
  
  public void removeSingleSubscription(IEventSubscriber paramIEventSubscriber, Class paramClass)
  {
    i.e(paramClass, "eventClass");
    if (paramIEventSubscriber != null)
    {
      Item localItem = externalIEventMessenger;
      try
      {
        localItem.remove(paramClass, paramIEventSubscriber);
        return;
      }
      catch (Exception paramIEventSubscriber)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramIEventSubscriber, new x1(paramClass));
        publishError(paramIEventSubscriber);
      }
    }
  }
  
  public void requestContentCardsRefresh(boolean paramBoolean)
  {
    run$android_sdk_base_release$default(this, new y1(paramBoolean), false, new z1(paramBoolean, this), 2, null);
  }
  
  public void requestFeedRefresh()
  {
    run$android_sdk_base_release$default(this, a2.CurrentItem, false, new b2(this), 2, null);
  }
  
  public void requestFeedRefreshFromCache()
  {
    run$android_sdk_base_release$default(this, c2.CurrentItem, false, new d2(this), 2, null);
  }
  
  public void requestImmediateDataFlush()
  {
    run$android_sdk_base_release$default(this, m2.CurrentItem, false, new n2(this), 2, null);
  }
  
  public final void setApiKeyPresent$android_sdk_base_release(Boolean paramBoolean)
  {
    isApiKeyPresent = paramBoolean;
  }
  
  public final void setConfigurationProvider$android_sdk_base_release(BrazeConfigurationProvider paramBrazeConfigurationProvider)
  {
    i.e(paramBrazeConfigurationProvider, "<set-?>");
    configurationProvider = paramBrazeConfigurationProvider;
  }
  
  public final void setDeviceIdReader$android_sdk_base_release(AppPreferences paramAppPreferences)
  {
    i.e(paramAppPreferences, "<set-?>");
    deviceIdReader = paramAppPreferences;
  }
  
  public void setImageLoader(IBrazeImageLoader paramIBrazeImageLoader)
  {
    i.e(paramIBrazeImageLoader, "<set-?>");
    imageLoader = paramIBrazeImageLoader;
  }
  
  public void setRegisteredPushToken(final String paramString)
  {
    run$android_sdk_base_release$default(this, new v1(paramString), false, new w1(this, paramString), 2, null);
  }
  
  public final void setUdm$android_sdk_base_release(CopyOnWriteArrayList paramCopyOnWriteArrayList)
  {
    i.e(paramCopyOnWriteArrayList, "<set-?>");
    packetWriter = paramCopyOnWriteArrayList;
  }
  
  public void subscribeToContentCardsUpdates(IEventSubscriber paramIEventSubscriber)
  {
    i.e(paramIEventSubscriber, "subscriber");
    Item localItem = externalIEventMessenger;
    try
    {
      localItem.clear(ContentCardsUpdatedEvent.class, paramIEventSubscriber);
      return;
    }
    catch (Exception paramIEventSubscriber)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramIEventSubscriber, c3.STARTED);
      publishError(paramIEventSubscriber);
    }
  }
  
  public void subscribeToFeedUpdates(IEventSubscriber paramIEventSubscriber)
  {
    i.e(paramIEventSubscriber, "subscriber");
    Item localItem = externalIEventMessenger;
    try
    {
      localItem.clear(FeedUpdatedEvent.class, paramIEventSubscriber);
      return;
    }
    catch (Exception paramIEventSubscriber)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramIEventSubscriber, g3.STARTED);
      publishError(paramIEventSubscriber);
    }
  }
  
  public void subscribeToNewInAppMessages(IEventSubscriber paramIEventSubscriber)
  {
    i.e(paramIEventSubscriber, "subscriber");
    Item localItem = externalIEventMessenger;
    try
    {
      localItem.clear(InAppMessageEvent.class, paramIEventSubscriber);
      return;
    }
    catch (Exception paramIEventSubscriber)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramIEventSubscriber, i3.STARTED);
      publishError(paramIEventSubscriber);
    }
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    private final Edge getSdkEnablementProvider(Context paramContext)
    {
      Edge localEdge2 = getSdkEnablementProvider$android_sdk_base_release();
      Edge localEdge1 = localEdge2;
      if (localEdge2 == null)
      {
        localEdge1 = new Edge(paramContext);
        setSdkEnablementProvider$android_sdk_base_release(localEdge1);
      }
      return localEdge1;
    }
    
    private static final Uri setConfiguredCustomEndpoint$lambda-12$lambda-11(String paramString, Uri paramUri)
    {
      i.e(paramUri, "brazeEndpoint");
      Object localObject = Uri.parse(paramString);
      String str = ((Uri)localObject).getScheme();
      localObject = ((Uri)localObject).getEncodedAuthority();
      paramUri = paramUri.buildUpon();
      int j = 0;
      int i;
      if ((str != null) && (!g.o(str))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        if (localObject != null)
        {
          i = j;
          if (!g.o((CharSequence)localObject)) {}
        }
        else
        {
          i = 1;
        }
        if (i == 0)
        {
          paramUri.encodedAuthority((String)localObject);
          paramUri.scheme(str);
          return paramUri.build();
        }
      }
      return paramUri.encodedAuthority(paramString).build();
    }
    
    private final boolean shouldAllowSingletonInitialization()
    {
      Braze localBraze = Braze.access$getInstance$cp();
      if (localBraze == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, t.PREPARED, 2, null);
        return true;
      }
      if (Braze.access$isInstanceStopped$p(localBraze))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, u.ZERO, 3, null);
        return true;
      }
      if (i.a(Boolean.FALSE, localBraze.isApiKeyPresent$android_sdk_base_release()))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, v.PLAYING, 3, null);
        return true;
      }
      return false;
    }
    
    private static final boolean wipeData$lambda-9(File paramFile, String paramString)
    {
      i.e(paramString, "name");
      return ((g.v(paramString, "com.appboy", false, 2, null)) && (!i.a(paramString, "com.appboy.override.configuration.cache"))) || ((g.v(paramString, "com.braze", false, 2, null)) && (!i.a(paramString, "com.braze.override.configuration.cache")));
    }
    
    public final boolean configure(Context paramContext, BrazeConfig paramBrazeConfig)
    {
      i.e(paramContext, "context");
      BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
      BrazeLogger.Priority localPriority = BrazeLogger.Priority.g;
      BrazeLogger.brazelog$default(localBrazeLogger, this, localPriority, null, new c(paramBrazeConfig), 2, null);
      paramContext = Braze.access$getBrazeClassLock$cp();
      paramContext.lock();
      try
      {
        Braze localBraze = Braze.access$getInstance$cp();
        if (localBraze != null)
        {
          boolean bool = Braze.access$isInstanceStopped$p(localBraze);
          if (!bool)
          {
            bool = i.a(Boolean.TRUE, localBraze.isApiKeyPresent$android_sdk_base_release());
            if (bool)
            {
              BrazeLogger.brazelog$default(localBrazeLogger, Braze.Companion, localPriority, null, d.TAG, 2, null);
              paramContext.unlock();
              return false;
            }
          }
        }
        if (paramBrazeConfig != null)
        {
          Braze.access$getPendingConfigurations$cp().add(paramBrazeConfig);
        }
        else
        {
          BrazeLogger.brazelog$default(localBrazeLogger, Braze.Companion, localPriority, null, e.TAG, 2, null);
          Braze.access$getPendingConfigurations$cp().add(Braze.access$getClearConfigSentinel$cp());
        }
        paramContext.unlock();
        return true;
      }
      catch (Throwable paramBrazeConfig)
      {
        paramContext.unlock();
        throw paramBrazeConfig;
      }
    }
    
    public final boolean enableMockNetworkRequestsAndDropEventsMode()
    {
      if (Braze.access$getInstance$cp() == null)
      {
        ReentrantLock localReentrantLock = Braze.access$getBrazeClassLock$cp();
        localReentrantLock.lock();
        try
        {
          Object localObject = Braze.access$getInstance$cp();
          if (localObject == null)
          {
            boolean bool = Braze.access$getShouldMockNetworkRequestsAndDropEvents$cp();
            if (bool)
            {
              BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, Braze.Companion, BrazeLogger.Priority.g, null, h.components, 2, null);
            }
            else
            {
              BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, Braze.Companion, BrazeLogger.Priority.g, null, i.E, 2, null);
              Braze.access$setShouldMockNetworkRequestsAndDropEvents$cp(true);
            }
            localReentrantLock.unlock();
            return true;
          }
          localObject = t.a;
          localReentrantLock.unlock();
        }
        catch (Throwable localThrowable)
        {
          localReentrantLock.unlock();
          throw localThrowable;
        }
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, j.STARTED, 2, null);
      return false;
    }
    
    public final Uri getApiEndpoint(Uri paramUri)
    {
      i.e(paramUri, "brazeEndpoint");
      ReentrantLock localReentrantLock = Braze.access$getEndpointProviderLock$cp();
      localReentrantLock.lock();
      try
      {
        Object localObject = Braze.access$getEndpointProvider$cp();
        if (localObject != null) {
          try
          {
            localObject = ((IBrazeEndpointProvider)localObject).getApiEndpoint(paramUri);
            if (localObject != null)
            {
              localReentrantLock.unlock();
              return localObject;
            }
          }
          catch (Exception localException)
          {
            BrazeLogger.INSTANCE.brazelog(Braze.Companion, BrazeLogger.Priority.PREPARED, localException, m.STARTED);
          }
        }
        localReentrantLock.unlock();
        return paramUri;
      }
      catch (Throwable paramUri)
      {
        localReentrantLock.unlock();
        throw paramUri;
      }
    }
    
    public final String getConfiguredApiKey(BrazeConfigurationProvider paramBrazeConfigurationProvider)
    {
      i.e(paramBrazeConfigurationProvider, "configurationProvider");
      try
      {
        paramBrazeConfigurationProvider = paramBrazeConfigurationProvider.getBrazeApiKey().toString();
        return paramBrazeConfigurationProvider;
      }
      catch (Exception paramBrazeConfigurationProvider)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramBrazeConfigurationProvider, n.SingleTap);
      }
      return null;
    }
    
    public final IBrazeNotificationFactory getCustomBrazeNotificationFactory()
    {
      return Braze.access$getCustomBrazeNotificationFactory$cp();
    }
    
    public final Braze getInstance(Context paramContext)
    {
      i.e(paramContext, "context");
      if (shouldAllowSingletonInitialization())
      {
        ReentrantLock localReentrantLock = Braze.access$getBrazeClassLock$cp();
        localReentrantLock.lock();
        try
        {
          boolean bool = Braze.Companion.shouldAllowSingletonInitialization();
          if (bool)
          {
            paramContext = new Braze(paramContext);
            Braze.access$setInstanceStopped$p(paramContext, false);
            Braze.access$setInstance$cp(paramContext);
            localReentrantLock.unlock();
            return paramContext;
          }
          paramContext = t.a;
          localReentrantLock.unlock();
        }
        catch (Throwable paramContext)
        {
          localReentrantLock.unlock();
          throw paramContext;
        }
      }
      paramContext = Braze.access$getInstance$cp();
      Objects.requireNonNull(paramContext, "null cannot be cast to non-null type com.braze.Braze");
      return paramContext;
    }
    
    public final boolean getOutboundNetworkRequestsOffline()
    {
      return Braze.access$getAreOutboundNetworkRequestsOffline$cp();
    }
    
    public final Edge getSdkEnablementProvider$android_sdk_base_release()
    {
      return Braze.access$getSdkEnablementProvider$cp();
    }
    
    public final boolean isDisabled()
    {
      Edge localEdge = getSdkEnablementProvider$android_sdk_base_release();
      if (localEdge == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, o.ZERO, 3, null);
        return false;
      }
      Braze localBraze = Braze.access$getInstance$cp();
      if ((localBraze != null) && (i.a(Boolean.FALSE, localBraze.isApiKeyPresent$android_sdk_base_release())))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, p.PLAYING, 2, null);
        return true;
      }
      boolean bool = localEdge.get();
      if (bool) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, q.STARTED, 2, null);
      }
      return bool;
    }
    
    public final void requestTriggersIfInAppMessageTestPush$android_sdk_base_release(Intent paramIntent, protect.package_9.c paramC)
    {
      i.e(paramIntent, "intent");
      i.e(paramC, "brazeManager");
      paramIntent = paramIntent.getStringExtra("ab_push_fetch_test_triggers_key");
      if ((paramIntent != null) && (i.a(paramIntent, "true")))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, s.components, 2, null);
        paramC.a(new x3.a(null, null, null, null, 15, null).a());
      }
    }
    
    public final void setConfiguredCustomEndpoint$android_sdk_base_release(String paramString)
    {
      ReentrantLock localReentrantLock = Braze.access$getEndpointProviderLock$cp();
      localReentrantLock.lock();
      try
      {
        Braze.Companion.setEndpointProvider(new MainActivity.8(paramString));
        paramString = t.a;
        localReentrantLock.unlock();
        return;
      }
      catch (Throwable paramString)
      {
        localReentrantLock.unlock();
        throw paramString;
      }
    }
    
    public final void setEndpointProvider(IBrazeEndpointProvider paramIBrazeEndpointProvider)
    {
      ReentrantLock localReentrantLock = Braze.access$getEndpointProviderLock$cp();
      localReentrantLock.lock();
      try
      {
        Braze.access$setEndpointProvider$cp(paramIBrazeEndpointProvider);
        paramIBrazeEndpointProvider = t.a;
        localReentrantLock.unlock();
        return;
      }
      catch (Throwable paramIBrazeEndpointProvider)
      {
        localReentrantLock.unlock();
        throw paramIBrazeEndpointProvider;
      }
    }
    
    public final void setOutboundNetworkRequestsOffline(boolean paramBoolean)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, new r(paramBoolean), 2, null);
      ReentrantLock localReentrantLock = Braze.access$getBrazeClassLock$cp();
      localReentrantLock.lock();
      try
      {
        Object localObject = Braze.Companion;
        Braze.access$setAreOutboundNetworkRequestsOffline$cp(paramBoolean);
        localObject = Braze.access$getInstance$cp();
        if (localObject != null)
        {
          Braze.access$setSyncPolicyOfflineStatus((Braze)localObject, paramBoolean);
          localObject = t.a;
        }
        localReentrantLock.unlock();
        return;
      }
      catch (Throwable localThrowable)
      {
        localReentrantLock.unlock();
        throw localThrowable;
      }
    }
    
    public final void setSdkEnablementProvider$android_sdk_base_release(Edge paramEdge)
    {
      Braze.access$setSdkEnablementProvider$cp(paramEdge);
    }
    
    public final void stopInstance$android_sdk_base_release()
    {
      Object localObject2 = BrazeLogger.INSTANCE;
      Object localObject1 = BrazeLogger.Priority.g;
      Object localObject3 = w.storage;
      try
      {
        BrazeLogger.brazelog$default((BrazeLogger)localObject2, this, (BrazeLogger.Priority)localObject1, null, (kotlin.x.c.a)localObject3, 2, null);
        localObject1 = Braze.access$getBrazeClassLock$cp();
        ((Lock)localObject1).lock();
        try
        {
          BrazeCoroutineScope.cancelChildren();
          localObject3 = Braze.access$getInstance$cp();
          if (localObject3 != null)
          {
            Companion localCompanion = Braze.Companion;
            BrazeLogger.brazelog$default((BrazeLogger)localObject2, localCompanion, BrazeLogger.Priority.$EnumSwitchMapping$0, null, x.PREPARED, 2, null);
            ((Braze)localObject3).getExternalIEventMessenger$android_sdk_base_release().add(new SdkDataWipeEvent(), SdkDataWipeEvent.class);
            BrazeLogger.brazelog$default((BrazeLogger)localObject2, localCompanion, null, null, y.STARTED, 3, null);
            RecurrencePickerDialogFragment.this$0.onClick();
            localObject2 = packetWriter;
            if (localObject2 != null)
            {
              ((Braze)localObject3).getUdm$android_sdk_base_release().isEmpty().b(true);
              ((Braze)localObject3).getUdm$android_sdk_base_release().getContentLength().init();
              ((Braze)localObject3).getUdm$android_sdk_base_release().download().unregisterGeofences();
            }
            Braze.access$setInstanceStopped$p((Braze)localObject3, true);
          }
          localObject2 = t.a;
          ((Lock)localObject1).unlock();
          return;
        }
        catch (Throwable localThrowable)
        {
          ((Lock)localObject1).unlock();
          throw localThrowable;
        }
        return;
      }
      catch (Exception localException)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, z.STARTED);
      }
    }
    
    public final void wipeData(Context paramContext)
    {
      i.e(paramContext, "context");
      stopInstance$android_sdk_base_release();
      Object localObject1 = protect.package_9.l.d;
      try
      {
        ((z5.a)localObject1).c(paramContext);
        localObject1 = DefaultBrazeImageLoader.Companion;
        ((DefaultBrazeImageLoader.b)localObject1).handleResult(paramContext);
      }
      catch (Exception localException)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, a0.STARTED);
      }
      try
      {
        Object localObject2 = paramContext.getApplicationInfo();
        localObject2 = dataDir;
        localObject2 = new File((String)localObject2, "shared_prefs");
        boolean bool = ((File)localObject2).exists();
        if (bool)
        {
          bool = ((File)localObject2).isDirectory();
          if (!bool) {
            return;
          }
          Object localObject3 = FalseFileFilter.INSTANCE;
          localObject2 = ((File)localObject2).listFiles((FilenameFilter)localObject3);
          if (localObject2 != null)
          {
            localObject2 = kotlin.collections.c.a((Object[])localObject2);
            if (localObject2 != null)
            {
              localObject2 = ((Iterable)localObject2).iterator();
              for (;;)
              {
                bool = ((Iterator)localObject2).hasNext();
                if (!bool) {
                  break;
                }
                localObject3 = ((Iterator)localObject2).next();
                localObject3 = (File)localObject3;
                BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
                Companion localCompanion = Braze.Companion;
                BrazeLogger.Priority localPriority = BrazeLogger.Priority.$EnumSwitchMapping$0;
                BrazeLogger.brazelog$default(localBrazeLogger, localCompanion, localPriority, null, new b0((File)localObject3), 2, null);
                i.d(localObject3, "file");
                BrazeFileUtils.deleteSharedPreferencesFile(paramContext, (File)localObject3);
              }
            }
          }
        }
        else {}
      }
      catch (Exception paramContext)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramContext, c0.STARTED);
      }
    }
    
    static final class a0
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a0 STARTED = new a0();
      
      a0()
      {
        super();
      }
      
      public final String getText()
      {
        return "Failed to delete data from the internal storage cache.";
      }
    }
    
    static final class b0
      extends j
      implements kotlin.x.c.a<String>
    {
      b0(File paramFile)
      {
        super();
      }
      
      public final String extract()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Deleting shared prefs file at: ");
        localStringBuilder.append(dest.getAbsolutePath());
        return localStringBuilder.toString();
      }
    }
    
    static final class c
      extends j
      implements kotlin.x.c.a<String>
    {
      c(BrazeConfig paramBrazeConfig)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Braze.configure() called with configuration: ");
        localStringBuilder.append(src);
        return localStringBuilder.toString();
      }
    }
    
    static final class c0
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final c0 STARTED = new c0();
      
      c0()
      {
        super();
      }
      
      public final String getText()
      {
        return "Failed to delete shared preference data for the Braze SDK.";
      }
    }
    
    static final class d
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final d TAG = new d();
      
      d()
      {
        super();
      }
      
      public final String getText()
      {
        return "Braze.configure() cannot be called while the singleton is still live.";
      }
    }
    
    static final class e
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final e TAG = new e();
      
      e()
      {
        super();
      }
      
      public final String getText()
      {
        return "Braze.configure() called with a null config; Clearing all configuration values.";
      }
    }
    
    static final class h
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final h components = new h();
      
      h()
      {
        super();
      }
      
      public final String getText()
      {
        return "Braze network requests already being mocked. Note that events dispatched in this mode are dropped.";
      }
    }
    
    static final class i
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final i E = new i();
      
      i()
      {
        super();
      }
      
      public final String getText()
      {
        return "Braze network requests will be mocked. Events dispatchedin this mode will be dropped.";
      }
    }
    
    static final class j
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final j STARTED = new j();
      
      j()
      {
        super();
      }
      
      public final String getText()
      {
        return "Attempt to enable mocking Braze network requests had no effect since getInstance() has already been called.";
      }
    }
    
    static final class m
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final m STARTED = new m();
      
      m()
      {
        super();
      }
      
      public final String getText()
      {
        return "Caught exception trying to get a Braze API endpoint from the BrazeEndpointProvider. Using the original URI";
      }
    }
    
    static final class n
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final n SingleTap = new n();
      
      n()
      {
        super();
      }
      
      public final String getText()
      {
        return "Caught exception while retrieving API key.";
      }
    }
    
    static final class o
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final o ZERO = new o();
      
      o()
      {
        super();
      }
      
      public final String getText()
      {
        return "SDK enablement provider was null. Returning SDK as enabled.";
      }
    }
    
    static final class p
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final p PLAYING = new p();
      
      p()
      {
        super();
      }
      
      public final String getText()
      {
        return "API key not present. Actions will not be performed on the SDK.";
      }
    }
    
    static final class q
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final q STARTED = new q();
      
      q()
      {
        super();
      }
      
      public final String getText()
      {
        return "SDK is disabled. Actions will not be performed on the SDK.";
      }
    }
    
    static final class r
      extends j
      implements kotlin.x.c.a<String>
    {
      r(boolean paramBoolean)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Braze SDK outbound network requests are now ");
        String str;
        if (internal) {
          str = "disabled";
        } else {
          str = "enabled";
        }
        localStringBuilder.append(str);
        return localStringBuilder.toString();
      }
    }
    
    static final class s
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final s components = new s();
      
      s()
      {
        super();
      }
      
      public final String getText()
      {
        return "Push contained key for fetching test triggers, fetching triggers.";
      }
    }
    
    static final class t
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final t PREPARED = new t();
      
      t()
      {
        super();
      }
      
      public final String getText()
      {
        return "The instance is null. Allowing instance initialization";
      }
    }
    
    static final class u
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final u ZERO = new u();
      
      u()
      {
        super();
      }
      
      public final String getText()
      {
        return "The instance was stopped. Allowing instance initialization";
      }
    }
    
    static final class v
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final v PLAYING = new v();
      
      v()
      {
        super();
      }
      
      public final String getText()
      {
        return "No API key was found previously. Allowing instance initialization";
      }
    }
    
    static final class w
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final w storage = new w();
      
      w()
      {
        super();
      }
      
      public final String getText()
      {
        return "Shutting down all queued work on the Braze SDK";
      }
    }
    
    static final class x
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final x PREPARED = new x();
      
      x()
      {
        super();
      }
      
      public final String getText()
      {
        return "Sending sdk data wipe event to external subscribers";
      }
    }
    
    static final class y
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final y STARTED = new y();
      
      y()
      {
        super();
      }
      
      public final String getText()
      {
        return "Shutting down the singleton work queue";
      }
    }
    
    static final class z
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final z STARTED = new z();
      
      z()
      {
        super();
      }
      
      public final String getText()
      {
        return "Failed to shutdown queued work on the Braze SDK.";
      }
    }
  }
  
  static final class a
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final a LINE_SEPARATOR = new a();
    
    a()
    {
      super();
    }
    
    public final String getText()
    {
      return "Braze SDK Initializing";
    }
  }
  
  static final class a2
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final a2 CurrentItem = new a2();
    
    a2()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to request refresh of feed.";
    }
  }
  
  static final class a3
    extends j
    implements kotlin.x.c.a<String>
  {
    a3(boolean paramBoolean)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set sync policy offline to ");
      localStringBuilder.append(start);
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    extends j
    implements kotlin.x.c.a<String>
  {
    b(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Device build model matches a known crawler. Enabling mock network request mode. Device it: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class b1
    extends j
    implements kotlin.x.c.a<String>
  {
    b1(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to log purchase event of: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class b2
    extends j
    implements kotlin.x.c.a<t>
  {
    b2(Braze paramBraze)
    {
      super();
    }
    
    public final void add()
    {
      b.getUdm$android_sdk_base_release().a().a(new x3.a(null, null, null, null, 15, null).add());
    }
  }
  
  static final class b3
    extends j
    implements kotlin.x.c.a<t>
  {
    b3(Braze paramBraze, boolean paramBoolean)
    {
      super();
    }
    
    public final void c()
    {
      i.getUdm$android_sdk_base_release().a().b(paramBoolean);
      i.getUdm$android_sdk_base_release().isEmpty().b(paramBoolean);
      Braze localBraze = i;
      if (imageLoader != null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, localBraze, null, null, new a(paramBoolean), 3, null);
        i.getImageLoader().setOffline(paramBoolean);
      }
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      a(boolean paramBoolean)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Setting the image loader deny network downloads to ");
        localStringBuilder.append(start);
        return localStringBuilder.toString();
      }
    }
  }
  
  static final class c
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final c READ_ONLY = new c();
    
    c()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to perform initial Braze singleton setup.";
    }
  }
  
  static final class c1
    extends j
    implements kotlin.x.c.a<t>
  {
    c1(String paramString1, String paramString2, BigDecimal paramBigDecimal, int paramInt, Braze paramBraze, BrazeProperties paramBrazeProperties)
    {
      super();
    }
    
    public final void c()
    {
      String str1 = d;
      if (!ValidationUtils.isValidLogPurchaseInput(str1, paramString2, paramBigDecimal, paramInt, jdField_this.getUdm$android_sdk_base_release().remove()))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, a.o, 2, null);
        return;
      }
      Object localObject = paramBrazeProperties;
      int i = 1;
      if ((localObject == null) || (((BrazeProperties)localObject).isInvalid() != true)) {
        i = 0;
      }
      if (i != 0)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, b.o, 2, null);
        return;
      }
      str1 = ValidationUtils.ensureBrazeFieldLength(str1);
      localObject = ClassWriter.o;
      String str2 = paramString2;
      i.b(str2);
      BigDecimal localBigDecimal = paramBigDecimal;
      i.b(localBigDecimal);
      localObject = ((MethodWriter)localObject).a(str1, str2, localBigDecimal, paramInt, paramBrazeProperties);
      if (localObject == null) {
        return;
      }
      if (jdField_this.getUdm$android_sdk_base_release().a().a((protect.package_9.p)localObject)) {
        jdField_this.getUdm$android_sdk_base_release().b().a(new TintTypedArray(str1, paramBrazeProperties, (protect.package_9.p)localObject));
      }
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a o = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Log purchase input was invalid. Not logging in-app purchase to Braze.";
      }
    }
    
    static final class b
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final b o = new b();
      
      b()
      {
        super();
      }
      
      public final String getText()
      {
        return "Purchase logged with invalid properties. Not logging custom event to Braze.";
      }
    }
  }
  
  static final class c2
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final c2 CurrentItem = new c2();
    
    c2()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to retrieve and publish feed from offline cache.";
    }
  }
  
  static final class c3
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final c3 STARTED = new c3();
    
    c3()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to add subscriber for Content Cards updates.";
    }
  }
  
  static final class d
    extends j
    implements kotlin.x.c.a<t>
  {
    d(Braze paramBraze, Context paramContext)
    {
      super();
    }
    
    public final void changePosition()
    {
      book.applyPendingRuntimeConfiguration$android_sdk_base_release();
      book.setConfigurationProvider$android_sdk_base_release(new BrazeConfigurationProvider(Braze.access$getApplicationContext$p(book)));
      Object localObject3 = book;
      Object localObject1 = Braze.Companion;
      Object localObject4 = ((Braze.Companion)localObject1).getConfiguredApiKey(((Braze)localObject3).getConfigurationProvider$android_sdk_base_release());
      int j = 0;
      int i;
      if ((localObject4 != null) && (!g.o((CharSequence)localObject4))) {
        i = 0;
      } else {
        i = 1;
      }
      ((Braze)localObject3).setApiKeyPresent$android_sdk_base_release(Boolean.valueOf(i ^ 0x1));
      BrazeLogger.setInitialLogLevelFromConfiguration(book.getConfigurationProvider$android_sdk_base_release().getLoggerInitialLogLevel());
      BrazeLogger.checkForSystemLogLevelProperty$default(false, 1, null);
      if (Braze.Companion.access$getSdkEnablementProvider((Braze.Companion)localObject1, paramContext).get()) {
        ((Braze.Companion)localObject1).setOutboundNetworkRequestsOffline(true);
      }
      book.setDeviceIdReader$android_sdk_base_release(new Device(Braze.access$getApplicationContext$p(book)));
      Braze.access$setOfflineUserStorageProvider$p(book, new Card(Braze.access$getApplicationContext$p(book)));
      Braze.access$setRegistrationDataProvider$p(book, new Tools(Braze.access$getApplicationContext$p(book), book.getConfigurationProvider$android_sdk_base_release()));
      localObject3 = book.getConfigurationProvider$android_sdk_base_release().getCustomEndpoint();
      if (localObject3 != null)
      {
        i = j;
        if (!g.o((CharSequence)localObject3)) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0) {
        ((Braze.Companion)localObject1).setConfiguredCustomEndpoint$android_sdk_base_release(book.getConfigurationProvider$android_sdk_base_release().getCustomEndpoint());
      }
      localObject1 = book;
      Object localObject6;
      try
      {
        boolean bool = ((Braze)localObject1).getConfigurationProvider$android_sdk_base_release().isFirebaseCloudMessagingRegistrationEnabled();
        if (bool)
        {
          localObject4 = paramContext;
          localObject1 = book;
          localObject3 = Braze.access$getRegistrationDataProvider$p((Braze)localObject1);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            i.o("registrationDataProvider");
            localObject1 = null;
          }
          localObject1 = new SubjectSubscriptionManager((Context)localObject4, (Injector)localObject1);
          bool = ((SubjectSubscriptionManager)localObject1).remove();
          if (bool)
          {
            localObject3 = BrazeLogger.INSTANCE;
            localObject4 = book;
            localObject5 = BrazeLogger.Priority.g;
            localObject6 = b.STARTED;
            BrazeLogger.brazelog$default((BrazeLogger)localObject3, localObject4, (BrazeLogger.Priority)localObject5, null, (kotlin.x.c.a)localObject6, 2, null);
            localObject3 = book;
            localObject3 = ((Braze)localObject3).getConfigurationProvider$android_sdk_base_release().getFirebaseCloudMessagingSenderIdKey();
            if (localObject3 != null) {
              ((SubjectSubscriptionManager)localObject1).add((String)localObject3);
            }
          }
          else
          {
            localObject1 = BrazeLogger.INSTANCE;
            localObject3 = book;
            localObject4 = BrazeLogger.Priority.PREPARED;
            localObject5 = c.PLAYING;
            BrazeLogger.brazelog$default((BrazeLogger)localObject1, localObject3, (BrazeLogger.Priority)localObject4, null, (kotlin.x.c.a)localObject5, 2, null);
          }
        }
        else
        {
          localObject1 = BrazeLogger.INSTANCE;
          localObject3 = book;
          localObject4 = BrazeLogger.Priority.g;
          localObject5 = d.STARTED;
          BrazeLogger.brazelog$default((BrazeLogger)localObject1, localObject3, (BrazeLogger.Priority)localObject4, null, (kotlin.x.c.a)localObject5, 2, null);
        }
        localObject1 = book;
        bool = ((Braze)localObject1).getConfigurationProvider$android_sdk_base_release().isAdmMessagingRegistrationEnabled();
        if (bool)
        {
          localObject1 = Scope.INSTANCE;
          localObject3 = book;
          bool = ((i.a)localObject1).a(Braze.access$getApplicationContext$p((Braze)localObject3));
          if (bool)
          {
            localObject1 = BrazeLogger.INSTANCE;
            localObject3 = book;
            localObject4 = BrazeLogger.Priority.g;
            localObject5 = e.STARTED;
            BrazeLogger.brazelog$default((BrazeLogger)localObject1, localObject3, (BrazeLogger.Priority)localObject4, null, (kotlin.x.c.a)localObject5, 2, null);
            localObject1 = book;
            localObject4 = Braze.access$getApplicationContext$p((Braze)localObject1);
            localObject1 = book;
            localObject3 = Braze.access$getRegistrationDataProvider$p((Braze)localObject1);
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              i.o("registrationDataProvider");
              localObject1 = null;
            }
            new Scope((Context)localObject4, (Injector)localObject1).onCreate();
          }
          else
          {
            localObject1 = BrazeLogger.INSTANCE;
            localObject3 = book;
            localObject4 = BrazeLogger.Priority.PREPARED;
            localObject5 = f.PLAYING;
            BrazeLogger.brazelog$default((BrazeLogger)localObject1, localObject3, (BrazeLogger.Priority)localObject4, null, (kotlin.x.c.a)localObject5, 2, null);
          }
        }
        else
        {
          localObject1 = BrazeLogger.INSTANCE;
          localObject3 = book;
          localObject4 = BrazeLogger.Priority.g;
          localObject5 = g.STARTED;
          BrazeLogger.brazelog$default((BrazeLogger)localObject1, localObject3, (BrazeLogger.Priority)localObject4, null, (kotlin.x.c.a)localObject5, 2, null);
        }
        localObject1 = book;
        Braze.access$verifyProperSdkSetup((Braze)localObject1);
      }
      catch (Exception localException1)
      {
        BrazeLogger.INSTANCE.brazelog(book, BrazeLogger.Priority.this$0, localException1, h.PLAYING);
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, book, BrazeLogger.Priority.$EnumSwitchMapping$0, null, i.STARTED, 2, null);
      Object localObject5 = book;
      try
      {
        localObject6 = Braze.access$getApplicationContext$p((Braze)localObject5);
        Object localObject2 = book;
        localObject3 = Braze.access$getOfflineUserStorageProvider$p((Braze)localObject2);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          i.o("offlineUserStorageProvider");
          localObject2 = null;
        }
        localObject3 = book;
        BrazeConfigurationProvider localBrazeConfigurationProvider = ((Braze)localObject3).getConfigurationProvider$android_sdk_base_release();
        localObject3 = book;
        Item localItem = ((Braze)localObject3).getExternalIEventMessenger$android_sdk_base_release();
        localObject3 = book;
        AppPreferences localAppPreferences = ((Braze)localObject3).getDeviceIdReader$android_sdk_base_release();
        localObject3 = book;
        localObject4 = Braze.access$getRegistrationDataProvider$p((Braze)localObject3);
        localObject3 = localObject4;
        if (localObject4 == null)
        {
          i.o("registrationDataProvider");
          localObject3 = null;
        }
        Braze.access$setUserSpecificMemberVariablesAndStartDispatch((Braze)localObject5, new MainActivity((Context)localObject6, (Card)localObject2, localBrazeConfigurationProvider, localItem, localAppPreferences, (Injector)localObject3, Braze.access$getShouldMockNetworkRequestsAndDropEvents$cp(), Braze.access$getAreOutboundNetworkRequestsOffline$cp()));
        return;
      }
      catch (Exception localException2)
      {
        BrazeLogger.INSTANCE.brazelog(book, BrazeLogger.Priority.this$0, localException2, a.STARTED);
        Braze.access$publishError(book, localException2);
      }
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a STARTED = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Failed to startup user dependency manager.";
      }
    }
    
    static final class b
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final b STARTED = new b();
      
      b()
      {
        super();
      }
      
      public final String getText()
      {
        return "Firebase Cloud Messaging found. Setting up Firebase Cloud Messaging.";
      }
    }
    
    static final class c
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final c PLAYING = new c();
      
      c()
      {
        super();
      }
      
      public final String getText()
      {
        return "Firebase Cloud Messaging requirements not met. Braze will not register for Firebase Cloud Messaging.";
      }
    }
    
    static final class d
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final d STARTED = new d();
      
      d()
      {
        super();
      }
      
      public final String getText()
      {
        return "Automatic Firebase Cloud Messaging registration not enabled in configuration. Braze will not register for Firebase Cloud Messaging.";
      }
    }
    
    static final class e
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final e STARTED = new e();
      
      e()
      {
        super();
      }
      
      public final String getText()
      {
        return "Amazon Device Messaging found. Setting up Amazon Device Messaging";
      }
    }
    
    static final class f
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final f PLAYING = new f();
      
      f()
      {
        super();
      }
      
      public final String getText()
      {
        return "ADM manifest requirements not met. Braze will not register for ADM.";
      }
    }
    
    static final class g
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final g STARTED = new g();
      
      g()
      {
        super();
      }
      
      public final String getText()
      {
        return "Automatic ADM registration not enabled in configuration. Braze will not register for ADM.";
      }
    }
    
    static final class h
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final h PLAYING = new h();
      
      h()
      {
        super();
      }
      
      public final String getText()
      {
        return "Failed to setup pre SDK tasks";
      }
    }
    
    static final class i
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final i STARTED = new i();
      
      i()
      {
        super();
      }
      
      public final String getText()
      {
        return "Starting up a new user dependency manager";
      }
    }
  }
  
  static final class d0
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final d0 SINGLE_FILE = new d0();
    
    d0()
    {
      super();
    }
    
    public final String getText()
    {
      return "The ContentCardsUpdatedEvent was null. Returning null for the list of cached cards.";
    }
  }
  
  static final class d1
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final d1 CurrentItem = new d1();
    
    d1()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to log push notification action clicked.";
    }
  }
  
  static final class d2
    extends j
    implements kotlin.x.c.a<t>
  {
    d2(Braze paramBraze)
    {
      super();
    }
    
    public final void add()
    {
      x.getExternalIEventMessenger$android_sdk_base_release().add(x.getUdm$android_sdk_base_release().set().get(), FeedUpdatedEvent.class);
    }
  }
  
  static final class e
    extends j
    implements kotlin.x.c.a<String>
  {
    e(long paramLong1, long paramLong2)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Braze SDK loaded in ");
      localStringBuilder.append(TimeUnit.MILLISECONDS.convert(timestamp - state, TimeUnit.NANOSECONDS));
      localStringBuilder.append(" ms.");
      return localStringBuilder.toString();
    }
  }
  
  static final class e1
    extends j
    implements kotlin.x.c.a<t>
  {
    e1(String paramString1, Braze paramBraze, String paramString2, String paramString3)
    {
      super();
    }
    
    public final void b()
    {
      String str = d;
      int j = 0;
      int i;
      if ((str != null) && (!g.o(str))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, a.d, 2, null);
        return;
      }
      str = paramString2;
      if ((str != null) && (!g.o(str))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, b.o, 2, null);
        return;
      }
      str = paramString3;
      if (str != null)
      {
        i = j;
        if (!g.o(str)) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, c.o, 2, null);
        return;
      }
      jdField_this.getUdm$android_sdk_base_release().a().a(ExtensionData.b.a(d, paramString2, paramString3));
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a d = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "No campaign Id associated with this notification (this is expected for test sends). Not logging push notification action clicked.";
      }
    }
    
    static final class b
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final b o = new b();
      
      b()
      {
        super();
      }
      
      public final String getText()
      {
        return "Action ID cannot be null or blank.";
      }
    }
    
    static final class c
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final c o = new c();
      
      c()
      {
        super();
      }
      
      public final String getText()
      {
        return "Action Type cannot be null or blank.";
      }
    }
  }
  
  static final class f
    extends j
    implements kotlin.x.c.a<String>
  {
    f(String paramString1, String paramString2)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to update ContentCard storage provider with single card update. User id: ");
      localStringBuilder.append(mOrderBy);
      localStringBuilder.append(" Serialized json: ");
      localStringBuilder.append(mLimit);
      return localStringBuilder.toString();
    }
  }
  
  static final class g
    extends j
    implements kotlin.x.c.a<t>
  {
    g(String paramString1, Braze paramBraze, String paramString2)
    {
      super();
    }
    
    public final void a()
    {
      if (g.o(g))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, e, BrazeLogger.Priority.PREPARED, null, new a(d, g), 2, null);
        return;
      }
      ValueMarker localValueMarker = new ValueMarker(g);
      e.getUdm$android_sdk_base_release().c().a(localValueMarker, d);
      e.getExternalIEventMessenger$android_sdk_base_release().add(e.getUdm$android_sdk_base_release().c().a(), ContentCardsUpdatedEvent.class);
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      a(String paramString1, String paramString2)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot add null or blank card json to storage. Returning. User id: ");
        localStringBuilder.append(mOrderBy);
        localStringBuilder.append(" Serialized json: ");
        localStringBuilder.append(mLimit);
        return localStringBuilder.toString();
      }
    }
  }
  
  static final class g2
    extends j
    implements kotlin.x.c.a<String>
  {
    g2(boolean paramBoolean)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to request geofence refresh with rate limit ignore: ");
      localStringBuilder.append(start);
      return localStringBuilder.toString();
    }
  }
  
  static final class g3
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final g3 STARTED = new g3();
    
    g3()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to add subscriber for feed updates.";
    }
  }
  
  static final class h
    extends j
    implements kotlin.x.c.a<String>
  {
    h(Class paramClass)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to add synchronous subscriber for class: ");
      localStringBuilder.append(mArgType);
      return localStringBuilder.toString();
    }
  }
  
  @kotlin.w.i.a.f(c="com.braze.Braze$getCurrentUser$1", f="Braze.kt", l={768}, m="invokeSuspend")
  static final class h0
    extends kotlin.w.i.a.l
    implements kotlin.x.c.p<m0, d<? super t>, Object>
  {
    int displayMode;
    
    h0(IValueCallback paramIValueCallback, Braze paramBraze, d paramD)
    {
      super(paramD);
    }
    
    public final Object b(m0 paramM0, d paramD)
    {
      return ((h0)create(paramM0, paramD)).invokeSuspend(t.a);
    }
    
    public final d create(Object paramObject, d paramD)
    {
      return (d)new h0(this$0, jdField_this, paramD);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject = kotlin.coroutines.intrinsics.a.c();
      int i = displayMode;
      if (i != 0)
      {
        if (i == 1) {
          n.b(paramObject);
        } else {
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
      }
      else
      {
        n.b(paramObject);
        paramObject = BrazeCoroutineScope.INSTANCE.getCoroutineContext();
        a localA = new a(this$0, jdField_this, null);
        displayMode = 1;
        if (kotlinx.coroutines.h.g(paramObject, localA, (d)this) == localObject) {
          return localObject;
        }
      }
      return t.a;
    }
    
    @kotlin.w.i.a.f(c="com.braze.Braze$getCurrentUser$1$1", f="Braze.kt", l={}, m="invokeSuspend")
    static final class a
      extends kotlin.w.i.a.l
      implements kotlin.x.c.p<m0, d<? super t>, Object>
    {
      int tableLayout;
      
      a(IValueCallback paramIValueCallback, Braze paramBraze, d paramD)
      {
        super(paramD);
      }
      
      public final Object b(m0 paramM0, d paramD)
      {
        return ((a)create(paramM0, paramD)).invokeSuspend(t.a);
      }
      
      public final d create(Object paramObject, d paramD)
      {
        return (d)new a(this$0, h, paramD);
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        kotlin.coroutines.intrinsics.a.c();
        if (tableLayout == 0)
        {
          n.b(paramObject);
          IValueCallback localIValueCallback = this$0;
          BrazeUser localBrazeUser = Braze.access$getBrazeUser$p(h);
          paramObject = localBrazeUser;
          if (localBrazeUser == null)
          {
            i.o("brazeUser");
            paramObject = null;
          }
          localIValueCallback.onSuccess(paramObject);
          return t.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
  }
  
  static final class h1
    extends j
    implements kotlin.x.c.a<String>
  {
    h1(Intent paramIntent)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error logging push notification with intent: ");
      localStringBuilder.append(data);
      return localStringBuilder.toString();
    }
  }
  
  static final class h2
    extends j
    implements kotlin.x.c.a<t>
  {
    h2(Braze paramBraze, boolean paramBoolean)
    {
      super();
    }
    
    public final void playAll()
    {
      id.getUdm$android_sdk_base_release().download().requestGeofenceRefresh(blipId);
    }
  }
  
  static final class i
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final i PLAYING = new i();
    
    i()
    {
      super();
    }
    
    public final String getText()
    {
      return "Applying any pending runtime configuration values";
    }
  }
  
  static final class i0
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final i0 STARTED = new i0();
    
    i0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to retrieve the current user.";
    }
  }
  
  static final class i1
    extends j
    implements kotlin.x.c.a<t>
  {
    i1(Intent paramIntent, Braze paramBraze)
    {
      super();
    }
    
    public final void c()
    {
      Object localObject = i;
      if (localObject == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.g, null, a.g, 2, null);
        return;
      }
      localObject = ((Intent)localObject).getStringExtra("cid");
      int j;
      if ((localObject != null) && (!g.o((CharSequence)localObject))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j == 0)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.g, null, new b((String)localObject), 2, null);
        jdField_this.getUdm$android_sdk_base_release().a().a(o.b.a((String)localObject));
      }
      else
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.g, null, c.d, 2, null);
      }
      Braze.Companion.requestTriggersIfInAppMessageTestPush$android_sdk_base_release(i, jdField_this.getUdm$android_sdk_base_release().a());
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a g = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Cannot logPushNotificationOpened with null intent. Not logging push click.";
      }
    }
    
    static final class b
      extends j
      implements kotlin.x.c.a<String>
    {
      b(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Logging push click. Campaign Id: ");
        localStringBuilder.append(src);
        return localStringBuilder.toString();
      }
    }
    
    static final class c
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final c d = new c();
      
      c()
      {
        super();
      }
      
      public final String getText()
      {
        return "No campaign Id associated with this notification (this is expected for test sends). Not logging push click.";
      }
    }
  }
  
  static final class i3
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final i3 STARTED = new i3();
    
    i3()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to add subscriber to new in-app messages.";
    }
  }
  
  static final class j
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final j PAUSED = new j();
    
    j()
    {
      super();
    }
    
    public final String getText()
    {
      return "Clearing config values";
    }
  }
  
  static final class j1
    extends j
    implements kotlin.x.c.a<String>
  {
    j1(String paramString1, String paramString2)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to log push story page clicked for pageId: ");
      localStringBuilder.append(mOrderBy);
      localStringBuilder.append(" campaignId: ");
      localStringBuilder.append(paramString1);
      return localStringBuilder.toString();
    }
  }
  
  static final class k
    extends j
    implements kotlin.x.c.a<String>
  {
    k(BrazeConfig paramBrazeConfig)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Setting pending config object: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class k1
    extends j
    implements kotlin.x.c.a<t>
  {
    k1(String paramString1, String paramString2, Braze paramBraze)
    {
      super();
    }
    
    public final void d()
    {
      if (!ValidationUtils.isValidPushStoryClickInput(s, paramString2))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, a.o, 2, null);
        return;
      }
      Object localObject = ClassWriter.o;
      String str1 = s;
      i.b(str1);
      String str2 = paramString2;
      i.b(str2);
      localObject = ((MethodWriter)localObject).a(str1, str2);
      if (localObject != null) {
        jdField_this.getUdm$android_sdk_base_release().a().a((protect.package_9.p)localObject);
      }
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a o = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Push story page click input was invalid. Not logging in-app purchase to Braze.";
      }
    }
  }
  
  static final class l
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final l CurrentItem = new l();
    
    l()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to retrieve the cached ContentCardsUpdatedEvent.";
    }
  }
  
  static final class l1
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final l1 NETWORK = new l1();
    
    l1()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to open session.";
    }
  }
  
  @kotlin.w.i.a.f(c="com.braze.Braze$cachedContentCardsUpdatedEvent$2", f="Braze.kt", l={}, m="invokeSuspend")
  static final class m
    extends kotlin.w.i.a.l
    implements kotlin.x.c.p<m0, d<? super ContentCardsUpdatedEvent>, Object>
  {
    int tableLayout;
    
    m(Braze paramBraze, d paramD)
    {
      super(paramD);
    }
    
    public final Object b(m0 paramM0, d paramD)
    {
      return ((m)create(paramM0, paramD)).invokeSuspend(t.a);
    }
    
    public final d create(Object paramObject, d paramD)
    {
      return (d)new m(c, paramD);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      kotlin.coroutines.intrinsics.a.c();
      if (tableLayout == 0)
      {
        n.b(paramObject);
        return c.getUdm$android_sdk_base_release().c().a();
      }
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
  }
  
  static final class m1
    extends j
    implements kotlin.x.c.a<t>
  {
    m1(Activity paramActivity, Braze paramBraze)
    {
      super();
    }
    
    public final void add()
    {
      if (start == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.g, null, a.storage, 2, null);
        return;
      }
      jdField_this.getUdm$android_sdk_base_release().a().openSession(start);
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a storage = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Cannot open session with null activity.";
      }
    }
  }
  
  static final class m2
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final m2 CurrentItem = new m2();
    
    m2()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to request data flush.";
    }
  }
  
  static final class n
    extends j
    implements kotlin.x.c.a<String>
  {
    n(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set external id to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class n0
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final n0 CurrentItem = new n0();
    
    n0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Error handling test in-app message push";
    }
  }
  
  static final class n1
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final n1 PREPARED = new n1();
    
    n1()
    {
      super();
    }
    
    public final String getText()
    {
      return "User dependency manager is uninitialized. Not publishing error.";
    }
  }
  
  static final class n2
    extends j
    implements kotlin.x.c.a<t>
  {
    n2(Braze paramBraze)
    {
      super();
    }
    
    public final void d()
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, out, BrazeLogger.Priority.$EnumSwitchMapping$0, null, a.o, 2, null);
      out.getUdm$android_sdk_base_release().a().c();
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a o = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "requestImmediateDataFlush() called";
      }
    }
  }
  
  static final class n3
    extends j
    implements kotlin.x.c.a<String>
  {
    n3(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The Braze SDK requires the permission ");
      localStringBuilder.append(src);
      localStringBuilder.append(". Check your AndroidManifest.");
      return localStringBuilder.toString();
    }
  }
  
  static final class o
    extends j
    implements kotlin.x.c.a<t>
  {
    o(String paramString1, Braze paramBraze, String paramString2)
    {
      super();
    }
    
    public final void a()
    {
      Object localObject1 = b;
      int k = 1;
      int j = 1;
      int i;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, a.d, 2, null);
        return;
      }
      if (StringUtils.getByteSize(b) > 997L)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, new b(b), 2, null);
        return;
      }
      Object localObject2 = Braze.access$getBrazeUser$p(jdField_this);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        i.o("brazeUser");
        localObject1 = null;
      }
      localObject1 = ((BrazeUser)localObject1).getUserId();
      if (i.a(localObject1, b))
      {
        localObject1 = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default((BrazeLogger)localObject1, jdField_this, BrazeLogger.Priority.g, null, new c(b), 2, null);
        localObject2 = paramString2;
        i = j;
        if (localObject2 != null) {
          if (g.o((CharSequence)localObject2)) {
            i = j;
          } else {
            i = 0;
          }
        }
        if (i == 0)
        {
          BrazeLogger.brazelog$default((BrazeLogger)localObject1, jdField_this, null, null, new d(paramString2), 3, null);
          jdField_this.getUdm$android_sdk_base_release().getPos().setInt(paramString2);
        }
      }
      else
      {
        jdField_this.getUdm$android_sdk_base_release().getDescriptor().remove();
        if (i.a(localObject1, ""))
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.g, null, new e(b), 2, null);
          localObject2 = Braze.access$getOfflineUserStorageProvider$p(jdField_this);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            i.o("offlineUserStorageProvider");
            localObject1 = null;
          }
          ((Card)localObject1).read(b);
          localObject2 = Braze.access$getBrazeUser$p(jdField_this);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            i.o("brazeUser");
            localObject1 = null;
          }
          ((BrazeUser)localObject1).setUserId(b);
        }
        else
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.g, null, new f((String)localObject1, b), 2, null);
          localObject1 = new FeedUpdatedEvent(new ArrayList(), b, false, DateTimeUtils.nowInSeconds());
          jdField_this.getExternalIEventMessenger$android_sdk_base_release().add(localObject1, FeedUpdatedEvent.class);
        }
        jdField_this.getUdm$android_sdk_base_release().a().d();
        localObject2 = Braze.access$getOfflineUserStorageProvider$p(jdField_this);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          i.o("offlineUserStorageProvider");
          localObject1 = null;
        }
        ((Card)localObject1).read(b);
        CopyOnWriteArrayList localCopyOnWriteArrayList = jdField_this.getUdm$android_sdk_base_release();
        Context localContext = Braze.access$getApplicationContext$p(jdField_this);
        localObject2 = Braze.access$getOfflineUserStorageProvider$p(jdField_this);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          i.o("offlineUserStorageProvider");
          localObject1 = null;
        }
        BrazeConfigurationProvider localBrazeConfigurationProvider = jdField_this.getConfigurationProvider$android_sdk_base_release();
        Item localItem = jdField_this.getExternalIEventMessenger$android_sdk_base_release();
        AppPreferences localAppPreferences = jdField_this.getDeviceIdReader$android_sdk_base_release();
        Injector localInjector = Braze.access$getRegistrationDataProvider$p(jdField_this);
        localObject2 = localInjector;
        if (localInjector == null)
        {
          i.o("registrationDataProvider");
          localObject2 = null;
        }
        localObject1 = new MainActivity(localContext, (Card)localObject1, localBrazeConfigurationProvider, localItem, localAppPreferences, (Injector)localObject2, Braze.access$getShouldMockNetworkRequestsAndDropEvents$cp(), Braze.access$getAreOutboundNetworkRequestsOffline$cp());
        Braze.access$setUserSpecificMemberVariablesAndStartDispatch(jdField_this, (MainActivity)localObject1);
        localObject1 = paramString2;
        i = k;
        if (localObject1 != null) {
          if (g.o((CharSequence)localObject1)) {
            i = k;
          } else {
            i = 0;
          }
        }
        if (i == 0)
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, null, null, new g(paramString2), 3, null);
          jdField_this.getUdm$android_sdk_base_release().getPos().setInt(paramString2);
        }
        jdField_this.getUdm$android_sdk_base_release().getCallback().remove();
        jdField_this.getUdm$android_sdk_base_release().a().b();
        jdField_this.getUdm$android_sdk_base_release().a().a(new x3.a(null, null, null, null, 15, null).add());
        jdField_this.requestContentCardsRefresh(false);
        localCopyOnWriteArrayList.f();
      }
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a d = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "userId passed to changeUser was null or empty. The current user will remain the active user.";
      }
    }
    
    static final class b
      extends j
      implements kotlin.x.c.a<String>
    {
      b(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Rejected user id with byte length longer than 997. Not changing user. Input user id: ");
        localStringBuilder.append(src);
        return localStringBuilder.toString();
      }
    }
    
    static final class c
      extends j
      implements kotlin.x.c.a<String>
    {
      c(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Received request to change current user ");
        localStringBuilder.append(src);
        localStringBuilder.append(" to the same user id. Not changing user.");
        return localStringBuilder.toString();
      }
    }
    
    static final class d
      extends j
      implements kotlin.x.c.a<String>
    {
      d(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Set sdk auth signature on changeUser call: ");
        localStringBuilder.append(src);
        return localStringBuilder.toString();
      }
    }
    
    static final class e
      extends j
      implements kotlin.x.c.a<String>
    {
      e(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Changing anonymous user to ");
        localStringBuilder.append(src);
        return localStringBuilder.toString();
      }
    }
    
    static final class f
      extends j
      implements kotlin.x.c.a<String>
    {
      f(String paramString1, String paramString2)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Changing current user ");
        localStringBuilder.append(a);
        localStringBuilder.append(" to new user ");
        localStringBuilder.append(Q);
        localStringBuilder.append('.');
        return localStringBuilder.toString();
      }
    }
    
    static final class g
      extends j
      implements kotlin.x.c.a<String>
    {
      g(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Set sdk auth signature on changeUser call: ");
        localStringBuilder.append(src);
        return localStringBuilder.toString();
      }
    }
  }
  
  static final class o0
    extends j
    implements kotlin.x.c.a<t>
  {
    o0(Intent paramIntent, Braze paramBraze)
    {
      super();
    }
    
    public final void getBookId()
    {
      Braze.Companion.requestTriggersIfInAppMessageTestPush$android_sdk_base_release(intent, id.getUdm$android_sdk_base_release().a());
    }
  }
  
  static final class o1
    extends j
    implements kotlin.x.c.a<String>
  {
    o1(Throwable paramThrowable)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to log throwable: ");
      localStringBuilder.append(val$t);
      return localStringBuilder.toString();
    }
  }
  
  static final class o3
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final o3 PLAYING = new o3();
    
    o3()
    {
      super();
    }
    
    public final String getText()
    {
      return "The Braze SDK requires a non-empty API key. Check your braze.xml or BrazeConfig.";
    }
  }
  
  static final class p
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final p ANDROID_VERSION = new p();
    
    p()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to close session.";
    }
  }
  
  static final class p0
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final p0 SINGLE_FILE = new p0();
    
    p0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Ephemeral events enabled";
    }
  }
  
  static final class p3
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final p3 STARTED = new p3();
    
    p3()
    {
      super();
    }
    
    public final String getText()
    {
      return "The Braze SDK is not integrated correctly. Please visit https://www.braze.com/docs/developer_guide/platform_integration_guides/android/initial_sdk_setup/android_sdk_integration/";
    }
  }
  
  static final class q
    extends j
    implements kotlin.x.c.a<t>
  {
    q(Activity paramActivity, Braze paramBraze)
    {
      super();
    }
    
    public final void close()
    {
      if (content == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, a.stream, 2, null);
        return;
      }
      jdField_this.getUdm$android_sdk_base_release().a().closeSession(content);
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a stream = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Cannot close session with null activity.";
      }
    }
  }
  
  static final class q0
    extends j
    implements kotlin.x.c.a<String>
  {
    q0(String paramString, Set paramSet, boolean paramBoolean)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Checking event key [");
      localStringBuilder.append(proxyHost);
      localStringBuilder.append("] against ephemeral event list ");
      localStringBuilder.append(localSet);
      localStringBuilder.append(" and got match?: ");
      localStringBuilder.append(bool);
      return localStringBuilder.toString();
    }
  }
  
  static final class r
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final r sync = new r();
    
    r()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to retrieve the current user.";
    }
  }
  
  static final class r0
    extends j
    implements kotlin.x.c.a<String>
  {
    r0(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to log custom event: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class r1
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final r1 CurrentItem = new r1();
    
    r1()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to refresh feature flags.";
    }
  }
  
  static final class r2
    extends j
    implements kotlin.x.c.a<String>
  {
    r2(InAppMessageEvent paramInAppMessageEvent)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error retrying In-App Message from event ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  @kotlin.w.i.a.f(c="com.braze.Braze$currentUser$2", f="Braze.kt", l={}, m="invokeSuspend")
  static final class s
    extends kotlin.w.i.a.l
    implements kotlin.x.c.p<m0, d<? super BrazeUser>, Object>
  {
    int tableLayout;
    
    s(Braze paramBraze, d paramD)
    {
      super(paramD);
    }
    
    public final Object b(m0 paramM0, d paramD)
    {
      return ((s)create(paramM0, paramD)).invokeSuspend(t.a);
    }
    
    public final d create(Object paramObject, d paramD)
    {
      return (d)new s(c, paramD);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      kotlin.coroutines.intrinsics.a.c();
      if (tableLayout == 0)
      {
        n.b(paramObject);
        paramObject = Braze.access$getBrazeUser$p(c);
        if (paramObject == null)
        {
          i.o("brazeUser");
          return null;
        }
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      return paramObject;
    }
  }
  
  static final class s0
    extends j
    implements kotlin.x.c.a<t>
  {
    s0(String paramString, Braze paramBraze, BrazeProperties paramBrazeProperties)
    {
      super();
    }
    
    public final void a()
    {
      s localS = new s();
      Object localObject = e;
      b = localObject;
      if (!ValidationUtils.isValidLogCustomEventInput((String)localObject, jdField_this.getUdm$android_sdk_base_release().remove()))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, new a(localS), 2, null);
        return;
      }
      localObject = paramBrazeProperties;
      int i = 1;
      if ((localObject == null) || (((BrazeProperties)localObject).isInvalid() != true)) {
        i = 0;
      }
      if (i != 0)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, BrazeLogger.Priority.PREPARED, null, new b(localS), 2, null);
        return;
      }
      localObject = ValidationUtils.ensureBrazeFieldLength((String)b);
      b = localObject;
      localObject = ClassWriter.o.a((String)localObject, paramBrazeProperties);
      if (localObject == null) {
        return;
      }
      boolean bool;
      if (Braze.access$isEphemeralEventKey(jdField_this, (String)b)) {
        bool = jdField_this.getUdm$android_sdk_base_release().remove().remove();
      } else {
        bool = jdField_this.getUdm$android_sdk_base_release().a().a((protect.package_9.p)localObject);
      }
      if (bool) {
        jdField_this.getUdm$android_sdk_base_release().b().a(new HttpURLConnection((String)b, paramBrazeProperties, (protect.package_9.p)localObject));
      }
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      a(s paramS)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Logged custom event with name ");
        localStringBuilder.append((String)second.b);
        localStringBuilder.append(" was invalid. Not logging custom event to Braze.");
        return localStringBuilder.toString();
      }
    }
    
    static final class b
      extends j
      implements kotlin.x.c.a<String>
    {
      b(s paramS)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Custom event with name ");
        localStringBuilder.append((String)second.b);
        localStringBuilder.append(" logged with invalid properties. Not logging custom event to Braze.");
        return localStringBuilder.toString();
      }
    }
  }
  
  static final class s1
    extends j
    implements kotlin.x.c.a<t>
  {
    s1(Braze paramBraze)
    {
      super();
    }
    
    public final void execute()
    {
      if (out.getUdm$android_sdk_base_release().remove().isEnabled())
      {
        out.getUdm$android_sdk_base_release().getAction().execute();
        return;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, out, BrazeLogger.Priority.g, null, a.style, 2, null);
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a style = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Feature flags not enabled. Not refreshing feature flags.";
      }
    }
  }
  
  static final class s2
    extends j
    implements kotlin.x.c.a<t>
  {
    s2(Braze paramBraze, InAppMessageEvent paramInAppMessageEvent)
    {
      super();
    }
    
    public final void c()
    {
      o.getUdm$android_sdk_base_release().b().a(d.getTriggerEvent(), d.getTriggerAction());
    }
  }
  
  @kotlin.w.i.a.f(c="com.braze.Braze$run$1", f="Braze.kt", l={}, m="invokeSuspend")
  static final class t2
    extends kotlin.w.i.a.l
    implements kotlin.x.c.p<m0, d<? super t>, Object>
  {
    int tableLayout;
    
    t2(kotlin.x.c.a paramA, d paramD)
    {
      super(paramD);
    }
    
    public final Object b(m0 paramM0, d paramD)
    {
      return ((t2)create(paramM0, paramD)).invokeSuspend(t.a);
    }
    
    public final d create(Object paramObject, d paramD)
    {
      return (d)new t2(c, paramD);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      kotlin.coroutines.intrinsics.a.c();
      if (tableLayout == 0)
      {
        n.b(paramObject);
        kotlinx.coroutines.h.f(null, new a(c, null), 1, null);
        return t.a;
      }
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
    
    @kotlin.w.i.a.f(c="com.braze.Braze$run$1$1", f="Braze.kt", l={}, m="invokeSuspend")
    static final class a
      extends kotlin.w.i.a.l
      implements kotlin.x.c.p<m0, d<? super t>, Object>
    {
      int tableLayout;
      
      a(kotlin.x.c.a paramA, d paramD)
      {
        super(paramD);
      }
      
      public final Object b(m0 paramM0, d paramD)
      {
        return ((a)create(paramM0, paramD)).invokeSuspend(t.a);
      }
      
      public final d create(Object paramObject, d paramD)
      {
        return (d)new a(c, paramD);
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        kotlin.coroutines.intrinsics.a.c();
        if (tableLayout == 0)
        {
          n.b(paramObject);
          c.invoke();
          return t.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
  }
  
  static final class u2
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final u2 PLAYING = new u2();
    
    u2()
    {
      super();
    }
    
    public final String getText()
    {
      return "Got error in singleton run without result";
    }
  }
  
  static final class v1
    extends j
    implements kotlin.x.c.a<String>
  {
    v1(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set the push token ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  @kotlin.w.i.a.f(c="com.braze.Braze$runForResult$1", f="Braze.kt", l={1247}, m="invokeSuspend")
  static final class v2
    extends kotlin.w.i.a.l
    implements kotlin.x.c.p<m0, d<? super T>, Object>
  {
    int untitled;
    
    v2(kotlin.x.c.p paramP, d paramD)
    {
      super(paramD);
    }
    
    public final Object b(m0 paramM0, d paramD)
    {
      return ((v2)create(paramM0, paramD)).invokeSuspend(t.a);
    }
    
    public final d create(Object paramObject, d paramD)
    {
      return (d)new v2(identityId, paramD);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject = kotlin.coroutines.intrinsics.a.c();
      int i = untitled;
      if (i != 0)
      {
        if (i == 1)
        {
          n.b(paramObject);
          return paramObject;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      n.b(paramObject);
      paramObject = kotlinx.coroutines.h.b(RecurrencePickerDialogFragment.this$0, null, null, new a(identityId, null), 3, null);
      untitled = 1;
      paramObject = paramObject.C((d)this);
      if (paramObject == localObject) {
        return localObject;
      }
      return paramObject;
    }
    
    @kotlin.w.i.a.f(c="com.braze.Braze$runForResult$1$1", f="Braze.kt", l={}, m="invokeSuspend")
    static final class a
      extends kotlin.w.i.a.l
      implements kotlin.x.c.p<m0, d<? super T>, Object>
    {
      int consume;
      
      a(kotlin.x.c.p paramP, d paramD)
      {
        super(paramD);
      }
      
      public final Object b(m0 paramM0, d paramD)
      {
        return ((a)create(paramM0, paramD)).invokeSuspend(t.a);
      }
      
      public final d create(Object paramObject, d paramD)
      {
        return (d)new a(p, paramD);
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        kotlin.coroutines.intrinsics.a.c();
        if (consume == 0)
        {
          n.b(paramObject);
          return kotlinx.coroutines.h.f(null, new a(p, null), 1, null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
      
      @kotlin.w.i.a.f(c="com.braze.Braze$runForResult$1$1$1", f="Braze.kt", l={1245}, m="invokeSuspend")
      static final class a
        extends kotlin.w.i.a.l
        implements kotlin.x.c.p<m0, d<? super T>, Object>
      {
        int ready;
        
        a(kotlin.x.c.p paramP, d paramD)
        {
          super(paramD);
        }
        
        public final Object b(m0 paramM0, d paramD)
        {
          return ((a)create(paramM0, paramD)).invokeSuspend(t.a);
        }
        
        public final d create(Object paramObject, d paramD)
        {
          paramD = new a(c, paramD);
          e = paramObject;
          return (d)paramD;
        }
        
        public final Object invokeSuspend(Object paramObject)
        {
          Object localObject = kotlin.coroutines.intrinsics.a.c();
          int i = ready;
          if (i != 0)
          {
            if (i == 1)
            {
              n.b(paramObject);
              return paramObject;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
          n.b(paramObject);
          paramObject = (m0)e;
          kotlin.x.c.p localP = c;
          ready = 1;
          paramObject = localP.invoke(paramObject, this);
          if (paramObject == localObject) {
            return localObject;
          }
          return paramObject;
        }
      }
    }
  }
  
  static final class w1
    extends j
    implements kotlin.x.c.a<t>
  {
    w1(Braze paramBraze, String paramString)
    {
      super();
    }
    
    public final void b()
    {
      Object localObject1 = BrazeLogger.INSTANCE;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, i, BrazeLogger.Priority.g, null, new a(paramString), 2, null);
      Object localObject2 = paramString;
      int j;
      if ((localObject2 != null) && (!g.o((CharSequence)localObject2))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0)
      {
        BrazeLogger.brazelog$default((BrazeLogger)localObject1, i, BrazeLogger.Priority.PREPARED, null, b.HORIZONTAL, 2, null);
        return;
      }
      localObject2 = Braze.access$getRegistrationDataProvider$p(i);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        i.o("registrationDataProvider");
        localObject1 = null;
      }
      ((Injector)localObject1).init(paramString);
      i.getUdm$android_sdk_base_release().get().setColor();
      i.requestImmediateDataFlush();
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      a(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Push token ");
        localStringBuilder.append(src);
        localStringBuilder.append(" registered and immediately being flushed.");
        return localStringBuilder.toString();
      }
    }
    
    static final class b
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final b HORIZONTAL = new b();
      
      b()
      {
        super();
      }
      
      public final String getText()
      {
        return "Push token must not be null or blank. Not registering for push with Braze.";
      }
    }
  }
  
  static final class x0
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final x0 CurrentItem = new x0();
    
    x0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Failed to log that the feed was displayed.";
    }
  }
  
  static final class x1
    extends j
    implements kotlin.x.c.a<String>
  {
    x1(Class paramClass)
    {
      super();
    }
    
    public final String getName()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to remove ");
      localStringBuilder.append(iType.getName());
      localStringBuilder.append(" subscriber.");
      return localStringBuilder.toString();
    }
  }
  
  static final class y0
    extends j
    implements kotlin.x.c.a<t>
  {
    y0(Braze paramBraze)
    {
      super();
    }
    
    public final void d()
    {
      protect.package_9.p localP = ClassWriter.o.a();
      if (localP != null) {
        o.getUdm$android_sdk_base_release().a().a(localP);
      }
    }
  }
  
  static final class y1
    extends j
    implements kotlin.x.c.a<String>
  {
    y1(boolean paramBoolean)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to request Content Cards refresh. Requesting from cache: ");
      localStringBuilder.append(start);
      return localStringBuilder.toString();
    }
  }
  
  static final class z1
    extends j
    implements kotlin.x.c.a<t>
  {
    z1(boolean paramBoolean, Braze paramBraze)
    {
      super();
    }
    
    public final void a()
    {
      if (o)
      {
        jdField_this.getExternalIEventMessenger$android_sdk_base_release().add(jdField_this.getUdm$android_sdk_base_release().c().a(), ContentCardsUpdatedEvent.class);
        return;
      }
      if (jdField_this.getUdm$android_sdk_base_release().remove().get())
      {
        BitmapLoader.a(jdField_this.getUdm$android_sdk_base_release().a(), jdField_this.getUdm$android_sdk_base_release().c().b(), jdField_this.getUdm$android_sdk_base_release().c().getItem(), 0, true, 4, null);
        return;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, jdField_this, null, null, a.ABSOLUTE, 3, null);
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a ABSOLUTE = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Content Cards is not enabled, skipping API call to refresh";
      }
    }
  }
}
