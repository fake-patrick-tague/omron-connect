package com.braze.configuration;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import protect.package_9.Level;

public final class RuntimeAppConfigurationProvider
{
  public static final a Companion = new a(null);
  private SharedPreferences.Editor editor;
  private final SharedPreferences storageMap;
  
  public RuntimeAppConfigurationProvider(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("com.appboy.override.configuration.cache", 0);
    i.d(paramContext, "context.getSharedPrefere?ME, Context.MODE_PRIVATE)");
    storageMap = paramContext;
  }
  
  private final void putBoolean(String paramString, Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      boolean bool = paramBoolean.booleanValue();
      paramBoolean = editor;
      if (paramBoolean != null) {
        paramBoolean.putBoolean(paramString, bool);
      }
    }
  }
  
  private final void putEnumSet(EnumSet paramEnumSet, String paramString)
  {
    if (paramEnumSet == null) {
      return;
    }
    paramEnumSet = Level.get(paramEnumSet);
    SharedPreferences.Editor localEditor = editor;
    if (localEditor != null) {
      localEditor.putStringSet(paramString, paramEnumSet);
    }
  }
  
  private final void putInt(String paramString, Integer paramInteger)
  {
    if (paramInteger != null)
    {
      int i = paramInteger.intValue();
      paramInteger = editor;
      if (paramInteger != null) {
        paramInteger.putInt(paramString, i);
      }
    }
  }
  
  public final void applyEdit()
  {
    SharedPreferences.Editor localEditor = editor;
    if (localEditor != null) {
      localEditor.apply();
    }
  }
  
  public final void clearAllConfigurationValues()
  {
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, b.PLAYING, 3, null);
    storageMap.edit().clear().apply();
  }
  
  public final boolean containsKey(String paramString)
  {
    i.e(paramString, "key");
    return storageMap.contains(paramString);
  }
  
  public final boolean getBooleanValue(String paramString, boolean paramBoolean)
  {
    i.e(paramString, "key");
    return storageMap.getBoolean(paramString, paramBoolean);
  }
  
  public final int getIntValue(String paramString, int paramInt)
  {
    i.e(paramString, "key");
    return storageMap.getInt(paramString, paramInt);
  }
  
  public final Set getStringSetValue(String paramString, Set paramSet)
  {
    i.e(paramString, "key");
    return storageMap.getStringSet(paramString, paramSet);
  }
  
  public final String getStringValue(String paramString1, String paramString2)
  {
    i.e(paramString1, "key");
    return storageMap.getString(paramString1, paramString2);
  }
  
  public final void putEnumAsString(String paramString, Enum paramEnum)
  {
    i.e(paramString, "key");
    if (paramEnum != null) {
      putString(paramString, paramEnum.toString());
    }
  }
  
  public final void putString(String paramString1, String paramString2)
  {
    i.e(paramString1, "key");
    if (paramString2 != null)
    {
      SharedPreferences.Editor localEditor = editor;
      if (localEditor != null) {
        localEditor.putString(paramString1, paramString2);
      }
    }
  }
  
  public final void setConfiguration(BrazeConfig paramBrazeConfig)
  {
    i.e(paramBrazeConfig, "config");
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, new c(paramBrazeConfig), 2, null);
    startEdit();
    putString(BrazeConfigurationProvider.b.y.a(), apiKey);
    putString(BrazeConfigurationProvider.b.K.a(), serverTarget);
    putEnumAsString(BrazeConfigurationProvider.b.ext.a(), sdkFlavor);
    putBoolean(BrazeConfigurationProvider.b.path.a(), isNewsFeedVisualIndicatorOn);
    putString(BrazeConfigurationProvider.b.TURN_RIGHT.a(), customEndpoint);
    putString(BrazeConfigurationProvider.b.a.a(), smallNotificationIcon);
    putString(BrazeConfigurationProvider.b.j.a(), largeNotificationIcon);
    putInt(BrazeConfigurationProvider.b.i.a(), sessionTimeout);
    putInt(BrazeConfigurationProvider.b.u.a(), defaultNotificationAccentColor);
    putInt(BrazeConfigurationProvider.b.p.a(), triggerActionMinimumTimeIntervalSeconds);
    putBoolean(BrazeConfigurationProvider.b.J.a(), isAdmMessagingRegistrationEnabled);
    putBoolean(BrazeConfigurationProvider.b.param.a(), willHandlePushDeepLinksAutomatically);
    putBoolean(BrazeConfigurationProvider.b.o.a(), isLocationCollectionEnabled);
    putInt(BrazeConfigurationProvider.b.t.a(), badNetworkInterval);
    putInt(BrazeConfigurationProvider.b.h.a(), goodNetworkInterval);
    putInt(BrazeConfigurationProvider.b.m.a(), greatNetworkInterval);
    putString(BrazeConfigurationProvider.b.STRAIGHT.a(), defaultNotificationChannelName);
    putString(BrazeConfigurationProvider.b.TURN_LEFT.a(), defaultNotificationChannelDescription);
    putBoolean(BrazeConfigurationProvider.b.all.a(), isPushDeepLinkBackStackActivityEnabled);
    putString(BrazeConfigurationProvider.b.current.a(), pushDeepLinkBackStackActivityClassName);
    putBoolean(BrazeConfigurationProvider.b.previous.a(), isSessionStartBasedTimeoutEnabled);
    putBoolean(BrazeConfigurationProvider.b.tmp.a(), isFirebaseCloudMessagingRegistrationEnabled);
    putString(BrazeConfigurationProvider.b.random.a(), firebaseCloudMessagingSenderIdKey);
    putBoolean(BrazeConfigurationProvider.b.block.a(), isContentCardsUnreadVisualIndicatorEnabled);
    putBoolean(BrazeConfigurationProvider.b.padding.a(), isDeviceObjectAllowlistEnabled);
    putBoolean(BrazeConfigurationProvider.b.A.a(), isInAppMessageAccessibilityExclusiveModeEnabled);
    putBoolean(BrazeConfigurationProvider.b.B.a(), isPushWakeScreenForNotificationEnabled);
    putBoolean(BrazeConfigurationProvider.b.D.a(), isPushHtmlRenderingEnabled);
    putBoolean(BrazeConfigurationProvider.b.Eb.a(), doesPushStoryDismissOnClick);
    putBoolean(BrazeConfigurationProvider.b.E.a(), areGeofencesEnabled);
    putBoolean(BrazeConfigurationProvider.b.W.a(), isInAppMessageTestPushEagerDisplayEnabled);
    putString(BrazeConfigurationProvider.b.S.a(), customHtmlWebViewActivityClassName);
    putBoolean(BrazeConfigurationProvider.b.V.a(), areAutomaticGeofenceRequestsEnabled);
    putInt(BrazeConfigurationProvider.b.H.a(), inAppMessageWebViewClientMaxOnPageFinishedWaitMs);
    putBoolean(BrazeConfigurationProvider.b.L.a(), isFirebaseMessagingServiceOnNewTokenRegistrationEnabled);
    putBoolean(BrazeConfigurationProvider.b.N.a(), isSdkAuthEnabled);
    putBoolean(BrazeConfigurationProvider.b.M.a(), isTouchModeRequiredForHtmlInAppMessages);
    putBoolean(BrazeConfigurationProvider.b.df.a(), isHtmlInAppMessageApplyWindowInsetsEnabled);
    putEnumSet(deviceObjectAllowlist, BrazeConfigurationProvider.b.ri.a());
    putEnumSet(customLocationProviderNames, BrazeConfigurationProvider.b.d.a());
    paramBrazeConfig = brazeSdkMetadata;
    if (paramBrazeConfig != null) {
      updateEnumSetData(BrazeConfigurationProvider.b.q.a(), paramBrazeConfig);
    }
    applyEdit();
  }
  
  public final void startEdit()
  {
    editor = storageMap.edit();
  }
  
  public final void updateEnumSetData(String paramString, EnumSet paramEnumSet)
  {
    i.e(paramString, "key");
    i.e(paramEnumSet, "updateValue");
    Set localSet = getStringSetValue(paramString, new HashSet());
    if (localSet != null) {
      localSet.addAll(Level.get(paramEnumSet));
    }
    storageMap.edit().putStringSet(paramString, localSet).apply();
  }
  
  public static final class a
  {
    private a() {}
  }
  
  static final class b
    extends j
    implements a<String>
  {
    public static final b PLAYING = new b();
    
    b()
    {
      super();
    }
    
    public final String getText()
    {
      return "Clearing Braze Override configuration cache";
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    c(BrazeConfig paramBrazeConfig)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Setting Braze Override configuration with config: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
}
