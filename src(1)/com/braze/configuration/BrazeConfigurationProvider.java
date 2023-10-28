package com.braze.configuration;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.ApplicationInfoFlags;
import android.os.Build.VERSION;
import com.braze.enums.BrazeSdkMetadata;
import com.braze.enums.DeviceKey;
import com.braze.enums.LocationProviderName;
import com.braze.enums.SdkFlavor;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.PackageUtils;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.g0;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.j;
import kotlin.x.d.w;
import protect.package_9.Level;
import protect.package_9.StatusInformation;
import protect.package_9.TimeInterval;

public class BrazeConfigurationProvider
  extends CachedConfigurationProvider
{
  public static final a Companion = new a(null);
  public static final int DEFAULT_IN_APP_MESSAGE_WEBVIEW_ONPAGEFINISHED_WAIT_MS = (int)TimeUnit.SECONDS.toMillis(15L);
  private final Context context;
  
  public BrazeConfigurationProvider(Context paramContext)
  {
    super(paramContext, false, null, 6, null);
    paramContext = paramContext.getApplicationContext();
    kotlin.x.d.i.d(paramContext, "context.applicationContext");
    context = paramContext;
  }
  
  private final EnumSet getGenericEnumSetFromStringSet(Class paramClass, b paramB)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a8 = a7\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  private final String getServerTarget()
  {
    String str = getStringValue(b.K.a(), "PROD");
    if (str == null) {
      return "PROD";
    }
    return str;
  }
  
  public final int getApplicationIconResourceId()
  {
    Object localObject;
    if (getConfigurationCache().containsKey("application_icon"))
    {
      localObject = getConfigurationCache().get("application_icon");
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.Int");
      return ((Integer)localObject).intValue();
    }
    String str = context.getPackageName();
    if (Build.VERSION.SDK_INT >= 33) {
      localObject = context;
    }
    label93:
    int i;
    try
    {
      localObject = ((Context)localObject).getPackageManager().getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(0L));
      break label93;
      localObject = context;
      localObject = ((Context)localObject).getPackageManager().getApplicationInfo(str, 0);
      kotlin.x.d.i.d(localObject, "if (Build.VERSION.SDK_IN? 0)\n                    }");
      i = icon;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localException, new c(str));
      i = 0;
    }
    getConfigurationCache().put("application_icon", Integer.valueOf(i));
    return i;
  }
  
  public final String getBaseUrlForRequests()
  {
    String str = getServerTarget();
    Locale localLocale = Locale.US;
    kotlin.x.d.i.d(localLocale, "US");
    str = str.toUpperCase(localLocale);
    kotlin.x.d.i.d(str, "this as java.lang.String).toUpperCase(locale)");
    if (kotlin.x.d.i.a("STAGING", str)) {
      return "https://sondheim.braze.com/api/v3/";
    }
    return "https://sdk.iad-01.braze.com/api/v3/";
  }
  
  public final TimeInterval getBrazeApiKey()
  {
    String str = b.y.a();
    Object localObject1 = (String)getConfigurationCache().get(str);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = getRuntimeAppConfigurationProvider().getStringValue(str, null);
      localObject1 = localObject2;
      if (localObject2 != null) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, e.components, 2, null);
      } else {
        localObject1 = getStringValue(str, null);
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        getConfigurationCache().put(str, localObject1);
        localObject2 = localObject1;
      }
    }
    if (localObject2 != null) {
      return new TimeInterval((String)localObject2);
    }
    localObject1 = BrazeLogger.INSTANCE;
    localObject2 = BrazeLogger.Priority.PREPARED;
    BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, f.SP2, 2, null);
    BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, g.SP3, 2, null);
    BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, h.SP1, 2, null);
    BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, i.SP2, 2, null);
    BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, j.SP3, 2, null);
    BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, k.SP1, 2, null);
    BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, l.SP2, 2, null);
    BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, m.SP3, 2, null);
    BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, d.SP1, 2, null);
    throw new RuntimeException("Unable to read the Braze API key from the res/values/braze.xml file or from runtime configuration via BrazeConfig. See log for more details.");
  }
  
  public final Context getContext$android_sdk_base_release()
  {
    return context;
  }
  
  public final String getCustomEndpoint()
  {
    return getStringValue(b.TURN_RIGHT.a(), null);
  }
  
  public final String getCustomHtmlWebViewActivityClassName()
  {
    return getStringValue(b.S.a(), "");
  }
  
  public final EnumSet getCustomLocationProviderNames()
  {
    return getGenericEnumSetFromStringSet(LocationProviderName.class, b.d);
  }
  
  public final int getDefaultNotificationAccentColor()
  {
    Integer localInteger = getColorValue(b.u.a());
    if (localInteger != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, n.PLAYING, 3, null);
      return localInteger.intValue();
    }
    return 0;
  }
  
  public final String getDefaultNotificationChannelDescription()
  {
    String str = getStringValue(b.TURN_LEFT.a(), "");
    if (str == null) {
      return "";
    }
    return str;
  }
  
  public final String getDefaultNotificationChannelName()
  {
    String str = getStringValue(b.STRAIGHT.a(), "General");
    if (str == null) {
      return "General";
    }
    return str;
  }
  
  public final EnumSet getDeviceObjectAllowlist()
  {
    return getGenericEnumSetFromStringSet(DeviceKey.class, b.ri);
  }
  
  public final boolean getDoesHandlePushDeepLinksAutomatically()
  {
    return getBooleanValue(b.param.a(), false);
  }
  
  public final boolean getDoesPushStoryDismissOnClick()
  {
    return getBooleanValue(b.Eb.a(), true);
  }
  
  public final Set getEphemeralEventKeys()
  {
    Set localSet2 = getStringSetValue(b.g.a(), g0.b());
    Set localSet1 = localSet2;
    if (localSet2 == null) {
      localSet1 = g0.b();
    }
    if (localSet1.size() > 12) {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, o.STARTED, 2, null);
    }
    return kotlin.collections.i.K(kotlin.collections.i.E(localSet1, 12));
  }
  
  public final String getFirebaseCloudMessagingSenderIdKey()
  {
    return getStringValue(b.random.a(), null);
  }
  
  public final int getInAppMessageWebViewClientOnPageFinishedMaxWaitMs()
  {
    return getIntValue(b.H.a(), DEFAULT_IN_APP_MESSAGE_WEBVIEW_ONPAGEFINISHED_WAIT_MS);
  }
  
  public final int getLargeNotificationIconResourceId()
  {
    return getDrawableValue(b.j.a(), 0);
  }
  
  public final int getLoggerInitialLogLevel()
  {
    return getIntValue(b.X.a(), 4);
  }
  
  public final String getPushDeepLinkBackStackActivityClassName()
  {
    return getStringValue(b.current.a(), "");
  }
  
  public final SdkFlavor getSdkFlavor()
  {
    Object localObject = getStringValue(b.ext.a(), null);
    int i;
    if ((localObject != null) && (!g.o((CharSequence)localObject))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return null;
    }
    Locale localLocale = Locale.US;
    try
    {
      kotlin.x.d.i.d(localLocale, "US");
      localObject = ((String)localObject).toUpperCase(localLocale);
      kotlin.x.d.i.d(localObject, "this as java.lang.String).toUpperCase(locale)");
      localObject = SdkFlavor.valueOf((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localException, p.SingleTap);
    }
    return null;
  }
  
  public final EnumSet getSdkMetadata()
  {
    Object localObject2 = b.b.a();
    Object localObject1 = CachedConfigurationProvider.b.style;
    localObject2 = getResourceConfigurationValue((CachedConfigurationProvider.b)localObject1, (String)localObject2, new HashSet());
    Objects.requireNonNull(localObject2, "null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
    localObject2 = w.a(localObject2);
    Object localObject4 = b.q.a();
    Object localObject3 = getResourceConfigurationValue((CachedConfigurationProvider.b)localObject1, (String)localObject4, new HashSet());
    Objects.requireNonNull(localObject3, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
    localObject3 = (Set)localObject3;
    localObject1 = getRuntimeConfigurationValue((CachedConfigurationProvider.b)localObject1, (String)localObject4, new HashSet());
    Objects.requireNonNull(localObject1, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
    localObject1 = (Set)localObject1;
    ((Set)localObject2).addAll((Collection)localObject3);
    ((Set)localObject2).addAll((Collection)localObject1);
    localObject1 = Level.this$0;
    localObject1 = EnumSet.noneOf(BrazeSdkMetadata.class);
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = Level.this$0;
      localObject4 = Locale.US;
      try
      {
        kotlin.x.d.i.d(localObject4, "US");
        localObject4 = ((String)localObject3).toUpperCase((Locale)localObject4);
        kotlin.x.d.i.d(localObject4, "this as java.lang.String).toUpperCase(locale)");
        BrazeSdkMetadata[] arrayOfBrazeSdkMetadata = BrazeSdkMetadata.values();
        int i = 0;
        int j = arrayOfBrazeSdkMetadata.length;
        for (;;)
        {
          if (i < j)
          {
            BrazeSdkMetadata localBrazeSdkMetadata = arrayOfBrazeSdkMetadata[i];
            i += 1;
            boolean bool = kotlin.x.d.i.a(localBrazeSdkMetadata.name(), localObject4);
            if (bool)
            {
              ((EnumSet)localObject1).add(localBrazeSdkMetadata);
              break;
            }
          }
        }
        localObject4 = new NoSuchElementException("Array contains no element matching the predicate.");
        throw ((Throwable)localObject4);
      }
      catch (Exception localException)
      {
        BrazeLogger.INSTANCE.brazelog(Level.this$0, BrazeLogger.Priority.this$0, localException, new StatusInformation((String)localObject3));
      }
    }
    kotlin.x.d.i.d(localObject1, "result");
    return localObject1;
  }
  
  public final int getSessionTimeoutSeconds()
  {
    return getIntValue(b.i.a(), 10);
  }
  
  public final int getSmallNotificationIconResourceId()
  {
    return getDrawableValue(b.a.a(), 0);
  }
  
  public final long getTriggerActionMinimumTimeIntervalInSeconds()
  {
    return getIntValue(b.p.a(), 30);
  }
  
  public final int getVersionCode()
  {
    if (getConfigurationCache().containsKey("version_code"))
    {
      localObject = getConfigurationCache().get("version_code");
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.Int");
      return ((Integer)localObject).intValue();
    }
    Object localObject = context;
    int i;
    try
    {
      localObject = PackageUtils.getResourcePackageName((Context)localObject);
      Context localContext = context;
      localObject = localContext.getPackageManager().getPackageInfo((String)localObject, 0);
      i = versionCode;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, localException, q.APP_VERSION);
      i = -1;
    }
    getConfigurationCache().put("version_code", Integer.valueOf(i));
    return i;
  }
  
  public final boolean isAdmMessagingRegistrationEnabled()
  {
    return getBooleanValue(b.J.a(), false);
  }
  
  public final boolean isAutomaticGeofenceRequestsEnabled()
  {
    return getBooleanValue(b.V.a(), true);
  }
  
  public final boolean isContentCardsUnreadVisualIndicatorEnabled()
  {
    return getBooleanValue(b.block.a(), true);
  }
  
  public final boolean isDeviceObjectAllowlistEnabled()
  {
    return getBooleanValue(b.padding.a(), false);
  }
  
  public final boolean isEphemeralEventsEnabled()
  {
    return getBooleanValue(b.r.a(), false);
  }
  
  public final boolean isFirebaseCloudMessagingRegistrationEnabled()
  {
    return getBooleanValue(b.tmp.a(), false);
  }
  
  public final boolean isGeofencesEnabled()
  {
    return getBooleanValue(b.E.a(), isLocationCollectionEnabled());
  }
  
  public final boolean isHtmlInAppMessageApplyWindowInsetsEnabled()
  {
    return getBooleanValue(b.df.a(), false);
  }
  
  public final boolean isInAppMessageAccessibilityExclusiveModeEnabled()
  {
    return getBooleanValue(b.A.a(), false);
  }
  
  public final boolean isInAppMessageTestPushEagerDisplayEnabled()
  {
    return getBooleanValue(b.W.a(), true);
  }
  
  public final boolean isLocationCollectionEnabled()
  {
    return getBooleanValue(b.o.a(), false);
  }
  
  public final boolean isNewsfeedVisualIndicatorOn()
  {
    return getBooleanValue(b.path.a(), true);
  }
  
  public final boolean isPushDeepLinkBackStackActivityEnabled()
  {
    return getBooleanValue(b.all.a(), true);
  }
  
  public final boolean isPushNotificationHtmlRenderingEnabled()
  {
    return getBooleanValue(b.D.a(), false);
  }
  
  public final boolean isPushWakeScreenForNotificationEnabled()
  {
    return getBooleanValue(b.B.a(), true);
  }
  
  public final boolean isSdkAuthenticationEnabled()
  {
    return getBooleanValue(b.N.a(), false);
  }
  
  public final boolean isSessionStartBasedTimeoutEnabled()
  {
    return getBooleanValue(b.previous.a(), false);
  }
  
  public final boolean isTouchModeRequiredForHtmlInAppMessages()
  {
    return getBooleanValue(b.M.a(), true);
  }
  
  public static final class a
  {
    private a() {}
  }
  
  public static enum b
  {
    private final String l;
    
    static
    {
      g = new b("EPHEMERAL_EVENTS_KEYS", 1, "com_braze_ephemeral_events_keys");
      y = new b("API_KEY", 2, "com_braze_api_key");
      K = new b("SERVER_TARGET_KEY", 3, "com_braze_server_target");
      J = new b("ADM_MESSAGING_REGISTRATION_ENABLED_KEY", 4, "com_braze_push_adm_messaging_registration_enabled");
      a = new b("SMALL_NOTIFICATION_ICON_KEY", 5, "com_braze_push_small_notification_icon");
      j = new b("LARGE_NOTIFICATION_ICON_KEY", 6, "com_braze_push_large_notification_icon");
      i = new b("SESSION_TIMEOUT_KEY", 7, "com_braze_session_timeout");
      o = new b("ENABLE_LOCATION_COLLECTION_KEY", 8, "com_braze_enable_location_collection");
      u = new b("DEFAULT_NOTIFICATION_ACCENT_COLOR_KEY", 9, "com_braze_default_notification_accent_color");
      p = new b("TRIGGER_ACTION_MINIMUM_TIME_INTERVAL_KEY_SECONDS", 10, "com_braze_trigger_action_minimum_time_interval_seconds");
      param = new b("HANDLE_PUSH_DEEP_LINKS_AUTOMATICALLY", 11, "com_braze_handle_push_deep_links_automatically");
      path = new b("NEWSFEED_UNREAD_VISUAL_INDICATOR_ON", 12, "com_braze_newsfeed_unread_visual_indicator_on");
      ext = new b("SDK_FLAVOR", 13, "com_braze_sdk_flavor");
      TURN_RIGHT = new b("CUSTOM_ENDPOINT", 14, "com_braze_custom_endpoint");
      STRAIGHT = new b("DEFAULT_NOTIFICATION_CHANNEL_NAME", 15, "com_braze_default_notification_channel_name");
      TURN_LEFT = new b("DEFAULT_NOTIFICATION_CHANNEL_DESCRIPTION", 16, "com_braze_default_notification_channel_description");
      all = new b("PUSH_DEEP_LINK_BACK_STACK_ACTIVITY_ENABLED_KEY", 17, "com_braze_push_deep_link_back_stack_activity_enabled");
      current = new b("PUSH_DEEP_LINK_BACK_STACK_ACTIVITY_CLASS_NAME_KEY", 18, "com_braze_push_deep_link_back_stack_activity_class_name");
      previous = new b("SESSION_START_BASED_TIMEOUT_ENABLED_KEY", 19, "com_braze_session_start_based_timeout_enabled");
      tmp = new b("FIREBASE_CLOUD_MESSAGING_REGISTRATION_ENABLED_KEY", 20, "com_braze_firebase_cloud_messaging_registration_enabled");
      random = new b("FIREBASE_CLOUD_MESSAGING_SENDER_ID_KEY", 21, "com_braze_firebase_cloud_messaging_sender_id");
      block = new b("CONTENT_CARDS_UNREAD_VISUAL_INDICATOR_ENABLED", 22, "com_braze_content_cards_unread_visual_indicator_enabled");
      padding = new b("DEVICE_OBJECT_ALLOWLISTING_ENABLED_KEY", 23, "com_braze_device_object_whitelisting_enabled");
      ri = new b("DEVICE_OBJECT_ALLOWLIST_VALUE", 24, "com_braze_device_object_whitelist");
      A = new b("IN_APP_MESSAGE_ACCESSIBILITY_EXCLUSIVE_MODE_ENABLED", 25, "com_braze_device_in_app_message_accessibility_exclusive_mode_enabled");
      B = new b("PUSH_WAKE_SCREEN_FOR_NOTIFICATION_ENABLED", 26, "com_braze_push_wake_screen_for_notification_enabled");
      D = new b("PUSH_NOTIFICATION_HTML_RENDERING_ENABLED", 27, "com_braze_push_notification_html_rendering_enabled");
      Eb = new b("DOES_PUSH_STORY_DISMISS_ON_CLICK", 28, "com_braze_does_push_story_dismiss_on_click");
      E = new b("GEOFENCES_ENABLED", 29, "com_braze_geofences_enabled");
      W = new b("IN_APP_MESSAGE_PUSH_TEST_EAGER_DISPLAY", 30, "com_braze_in_app_message_push_test_eager_display_enabled");
      X = new b("LOGGER_INITIAL_LOG_LEVEL", 31, "com_braze_logger_initial_log_level");
      S = new b("CUSTOM_HTML_WEBVIEW_ACTIVITY_CLASS_NAME_KEY", 32, "com_braze_custom_html_webview_activity_class_name");
      V = new b("GEOFENCES_AUTOMATIC_REQUESTS_ENABLED_KEY", 33, "com_braze_automatic_geofence_requests_enabled");
      d = new b("CUSTOM_LOCATION_PROVIDERS_LIST_KEY", 34, "com_braze_custom_location_providers_list");
      H = new b("IN_APP_MESSAGE_WEBVIEW_CLIENT_MAX_ONPAGEFINISHED_WAIT_KEY", 35, "com_braze_in_app_message_webview_client_max_onpagefinished_wait_ms");
      L = new b("FIREBASE_MESSAGING_SERVICE_AUTOMATICALLY_REGISTER_ON_NEW_TOKEN_KEY", 36, "com_braze_firebase_messaging_service_automatically_register_on_new_token");
      N = new b("SDK_AUTH_ENABLED", 37, "com_braze_sdk_authentication_enabled");
      M = new b("REQUIRE_TOUCH_MODE_FOR_HTML_IAMS_KEY", 38, "com_braze_require_touch_mode_for_html_in_app_messages");
      t = new b("DATA_SYNC_BAD_NETWORK_INTERVAL_KEY", 39, "com_braze_data_flush_interval_bad_network");
      h = new b("DATA_SYNC_GOOD_NETWORK_INTERVAL_KEY", 40, "com_braze_data_flush_interval_good_network");
      m = new b("DATA_SYNC_GREAT_NETWORK_INTERVAL_KEY", 41, "com_braze_data_flush_interval_great_network");
      b = new b("SDK_METADATA_INTERNAL_KEY", 42, "com_braze_internal_sdk_metadata");
      q = new b("SDK_METADATA_PUBLIC_KEY", 43, "com_braze_sdk_metadata");
      df = new b("HTML_IN_APP_MESSAGE_APPLY_WINDOW_INSETS", 44, "com_braze_html_in_app_message_apply_insets");
    }
    
    private b(String paramString)
    {
      l = paramString;
    }
    
    public final String a()
    {
      return l;
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    c(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Couldn't find application icon for package: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    public static final d SP1 = new d();
    
    d()
    {
      super();
    }
    
    public final String getText()
    {
      return "****************************************************";
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    public static final e components = new e();
    
    e()
    {
      super();
    }
    
    public final String getText()
    {
      return "Found an override api key. Using it to configure the Braze SDK";
    }
  }
  
  static final class f
    extends j
    implements a<String>
  {
    public static final f SP2 = new f();
    
    f()
    {
      super();
    }
    
    public final String getText()
    {
      return "****************************************************";
    }
  }
  
  static final class g
    extends j
    implements a<String>
  {
    public static final g SP3 = new g();
    
    g()
    {
      super();
    }
    
    public final String getText()
    {
      return "**                                                **";
    }
  }
  
  static final class h
    extends j
    implements a<String>
  {
    public static final h SP1 = new h();
    
    h()
    {
      super();
    }
    
    public final String getText()
    {
      return "**                 !! WARNING !!                  **";
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    public static final i SP2 = new i();
    
    i()
    {
      super();
    }
    
    public final String getText()
    {
      return "**                                                **";
    }
  }
  
  static final class j
    extends j
    implements a<String>
  {
    public static final j SP3 = new j();
    
    j()
    {
      super();
    }
    
    public final String getText()
    {
      return "**     No API key set in res/values/braze.xml     **";
    }
  }
  
  static final class k
    extends j
    implements a<String>
  {
    public static final k SP1 = new k();
    
    k()
    {
      super();
    }
    
    public final String getText()
    {
      return "** No cached API Key found from Braze.configure   **";
    }
  }
  
  static final class l
    extends j
    implements a<String>
  {
    public static final l SP2 = new l();
    
    l()
    {
      super();
    }
    
    public final String getText()
    {
      return "**          Braze functionality disabled          **";
    }
  }
  
  static final class m
    extends j
    implements a<String>
  {
    public static final m SP3 = new m();
    
    m()
    {
      super();
    }
    
    public final String getText()
    {
      return "**                                                **";
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
      return "Using default notification accent color found in resources";
    }
  }
  
  static final class o
    extends j
    implements a<String>
  {
    public static final o STARTED = new o();
    
    o()
    {
      super();
    }
    
    public final String getText()
    {
      return "More than 12 ephemeral/graylisted events detected. Only using first 12 events. Please truncate this list!";
    }
  }
  
  static final class p
    extends j
    implements a<String>
  {
    public static final p SingleTap = new p();
    
    p()
    {
      super();
    }
    
    public final String getText()
    {
      return "Exception while parsing stored SDK flavor. Returning null.";
    }
  }
  
  static final class q
    extends j
    implements a<String>
  {
    public static final q APP_VERSION = new q();
    
    q()
    {
      super();
    }
    
    public final String getText()
    {
      return "Unable to read the version code.";
    }
  }
}
