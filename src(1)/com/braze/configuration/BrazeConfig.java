package com.braze.configuration;

import com.braze.enums.BrazeSdkMetadata;
import com.braze.enums.DeviceKey;
import com.braze.enums.LocationProviderName;
import com.braze.enums.SdkFlavor;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import java.util.EnumSet;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class BrazeConfig
{
  public final String apiKey;
  public final Boolean areAutomaticGeofenceRequestsEnabled;
  public final Boolean areGeofencesEnabled;
  public final Integer badNetworkInterval;
  public final EnumSet<BrazeSdkMetadata> brazeSdkMetadata;
  private final Builder builder;
  public final String customEndpoint;
  public final String customHtmlWebViewActivityClassName;
  public final EnumSet<LocationProviderName> customLocationProviderNames;
  public final Integer defaultNotificationAccentColor;
  public final String defaultNotificationChannelDescription;
  public final String defaultNotificationChannelName;
  public final EnumSet<DeviceKey> deviceObjectAllowlist;
  public final Boolean doesPushStoryDismissOnClick;
  public final String firebaseCloudMessagingSenderIdKey;
  public final Integer goodNetworkInterval;
  public final Integer greatNetworkInterval;
  public final Integer inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
  public final Boolean isAdmMessagingRegistrationEnabled;
  public final Boolean isContentCardsUnreadVisualIndicatorEnabled;
  public final Boolean isDeviceObjectAllowlistEnabled;
  public final Boolean isFirebaseCloudMessagingRegistrationEnabled;
  public final Boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
  public final Boolean isHtmlInAppMessageApplyWindowInsetsEnabled;
  public final Boolean isInAppMessageAccessibilityExclusiveModeEnabled;
  public final Boolean isInAppMessageTestPushEagerDisplayEnabled;
  public final Boolean isLocationCollectionEnabled;
  public final Boolean isNewsFeedVisualIndicatorOn;
  public final Boolean isPushDeepLinkBackStackActivityEnabled;
  public final Boolean isPushHtmlRenderingEnabled;
  public final Boolean isPushWakeScreenForNotificationEnabled;
  public final Boolean isSdkAuthEnabled;
  public final Boolean isSessionStartBasedTimeoutEnabled;
  public final Boolean isTouchModeRequiredForHtmlInAppMessages;
  public final String largeNotificationIcon;
  public final String pushDeepLinkBackStackActivityClassName;
  public final SdkFlavor sdkFlavor;
  public final String serverTarget;
  public final Integer sessionTimeout;
  public final String smallNotificationIcon;
  public final Integer triggerActionMinimumTimeIntervalSeconds;
  public final Boolean willHandlePushDeepLinksAutomatically;
  
  private BrazeConfig(Builder paramBuilder)
  {
    builder = paramBuilder;
    apiKey = paramBuilder.getApiKey$android_sdk_base_release();
    serverTarget = paramBuilder.getServerTarget$android_sdk_base_release();
    smallNotificationIcon = paramBuilder.getSmallNotificationIconName$android_sdk_base_release();
    largeNotificationIcon = paramBuilder.getLargeNotificationIconName$android_sdk_base_release();
    customEndpoint = paramBuilder.getCustomEndpoint$android_sdk_base_release();
    defaultNotificationChannelName = paramBuilder.getDefaultNotificationChannelName$android_sdk_base_release();
    defaultNotificationChannelDescription = paramBuilder.getDefaultNotificationChannelDescription$android_sdk_base_release();
    pushDeepLinkBackStackActivityClassName = paramBuilder.getPushDeepLinkBackStackActivityClassName$android_sdk_base_release();
    firebaseCloudMessagingSenderIdKey = paramBuilder.getFirebaseCloudMessagingSenderIdKey$android_sdk_base_release();
    customHtmlWebViewActivityClassName = paramBuilder.getCustomHtmlWebViewActivityClassName$android_sdk_base_release();
    sdkFlavor = paramBuilder.getSdkFlavor$android_sdk_base_release();
    sessionTimeout = paramBuilder.getSessionTimeout$android_sdk_base_release();
    defaultNotificationAccentColor = paramBuilder.getDefaultNotificationAccentColor$android_sdk_base_release();
    triggerActionMinimumTimeIntervalSeconds = paramBuilder.getTriggerActionMinimumTimeIntervalSeconds$android_sdk_base_release();
    badNetworkInterval = paramBuilder.getBadNetworkInterval$android_sdk_base_release();
    goodNetworkInterval = paramBuilder.getGoodNetworkInterval$android_sdk_base_release();
    greatNetworkInterval = paramBuilder.getGreatNetworkInterval$android_sdk_base_release();
    inAppMessageWebViewClientMaxOnPageFinishedWaitMs = paramBuilder.getInAppMessageWebViewClientMaxOnPageFinishedWaitMs$android_sdk_base_release();
    isAdmMessagingRegistrationEnabled = paramBuilder.getAdmMessagingRegistrationEnabled$android_sdk_base_release();
    willHandlePushDeepLinksAutomatically = paramBuilder.getHandlePushDeepLinksAutomatically$android_sdk_base_release();
    isLocationCollectionEnabled = paramBuilder.isLocationCollectionEnabled$android_sdk_base_release();
    isNewsFeedVisualIndicatorOn = paramBuilder.isNewsFeedVisualIndicatorOn$android_sdk_base_release();
    isPushDeepLinkBackStackActivityEnabled = paramBuilder.isPushDeepLinkBackStackActivityEnabled$android_sdk_base_release();
    isSessionStartBasedTimeoutEnabled = paramBuilder.isSessionStartBasedTimeoutEnabled$android_sdk_base_release();
    isFirebaseCloudMessagingRegistrationEnabled = paramBuilder.isFirebaseCloudMessagingRegistrationEnabled$android_sdk_base_release();
    isContentCardsUnreadVisualIndicatorEnabled = paramBuilder.isContentCardsUnreadVisualIndicatorEnabled$android_sdk_base_release();
    isInAppMessageAccessibilityExclusiveModeEnabled = paramBuilder.isInAppMessageAccessibilityExclusiveModeEnabled$android_sdk_base_release();
    isPushWakeScreenForNotificationEnabled = paramBuilder.isPushWakeScreenForNotificationEnabled$android_sdk_base_release();
    isPushHtmlRenderingEnabled = paramBuilder.isPushHtmlRenderingEnabled$android_sdk_base_release();
    areGeofencesEnabled = paramBuilder.isGeofencesEnabled$android_sdk_base_release();
    isInAppMessageTestPushEagerDisplayEnabled = paramBuilder.getInAppMessageTestPushEagerDisplayEnabled$android_sdk_base_release();
    areAutomaticGeofenceRequestsEnabled = paramBuilder.getAutomaticGeofenceRequestsEnabled$android_sdk_base_release();
    isFirebaseMessagingServiceOnNewTokenRegistrationEnabled = paramBuilder.isFirebaseMessagingServiceOnNewTokenRegistrationEnabled$android_sdk_base_release();
    isSdkAuthEnabled = paramBuilder.isSdkAuthEnabled$android_sdk_base_release();
    isTouchModeRequiredForHtmlInAppMessages = paramBuilder.isTouchModeRequiredForHtmlInAppMessages$android_sdk_base_release();
    deviceObjectAllowlist = paramBuilder.getDeviceObjectAllowlist$android_sdk_base_release();
    isDeviceObjectAllowlistEnabled = paramBuilder.isDeviceObjectAllowlistEnabled$android_sdk_base_release();
    customLocationProviderNames = paramBuilder.getCustomLocationProviderNames$android_sdk_base_release();
    brazeSdkMetadata = paramBuilder.getBrazeSdkMetadata$android_sdk_base_release();
    isHtmlInAppMessageApplyWindowInsetsEnabled = paramBuilder.isHtmlInAppMessageApplyWindowInsetsEnabled$android_sdk_base_release();
    doesPushStoryDismissOnClick = paramBuilder.getDoesPushStoryDismissOnClick$android_sdk_base_release();
  }
  
  public String toString()
  {
    return builder.toString();
  }
  
  public static final class Builder
  {
    private Boolean admMessagingRegistrationEnabled;
    private String apiKey;
    private Boolean automaticGeofenceRequestsEnabled;
    private Integer badNetworkInterval;
    private EnumSet<BrazeSdkMetadata> brazeSdkMetadata;
    private String customEndpoint;
    private String customHtmlWebViewActivityClassName;
    private EnumSet<LocationProviderName> customLocationProviderNames;
    private Integer defaultNotificationAccentColor;
    private String defaultNotificationChannelDescription;
    private String defaultNotificationChannelName;
    private EnumSet<DeviceKey> deviceObjectAllowlist;
    private Boolean doesPushStoryDismissOnClick;
    private String firebaseCloudMessagingSenderIdKey;
    private Integer goodNetworkInterval;
    private Integer greatNetworkInterval;
    private Boolean handlePushDeepLinksAutomatically;
    private Boolean inAppMessageTestPushEagerDisplayEnabled;
    private Integer inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
    private Boolean isContentCardsUnreadVisualIndicatorEnabled;
    private Boolean isDeviceObjectAllowlistEnabled;
    private Boolean isFirebaseCloudMessagingRegistrationEnabled;
    private Boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
    private Boolean isGeofencesEnabled;
    private Boolean isHtmlInAppMessageApplyWindowInsetsEnabled;
    private Boolean isInAppMessageAccessibilityExclusiveModeEnabled;
    private Boolean isLocationCollectionEnabled;
    private Boolean isNewsFeedVisualIndicatorOn;
    private Boolean isPushDeepLinkBackStackActivityEnabled;
    private Boolean isPushHtmlRenderingEnabled;
    private Boolean isPushWakeScreenForNotificationEnabled;
    private Boolean isSdkAuthEnabled;
    private Boolean isSessionStartBasedTimeoutEnabled;
    private Boolean isTouchModeRequiredForHtmlInAppMessages;
    private String largeNotificationIconName;
    private String pushDeepLinkBackStackActivityClassName;
    private SdkFlavor sdkFlavor;
    private String serverTarget;
    private Integer sessionTimeout;
    private String smallNotificationIconName;
    private Integer triggerActionMinimumTimeIntervalSeconds;
    
    public Builder()
    {
      this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, 511, null);
    }
    
    private Builder(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, SdkFlavor paramSdkFlavor, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, Integer paramInteger6, Integer paramInteger7, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Boolean paramBoolean4, Boolean paramBoolean5, Boolean paramBoolean6, Boolean paramBoolean7, Boolean paramBoolean8, Boolean paramBoolean9, Boolean paramBoolean10, Boolean paramBoolean11, Boolean paramBoolean12, Boolean paramBoolean13, Boolean paramBoolean14, Boolean paramBoolean15, Boolean paramBoolean16, Boolean paramBoolean17, EnumSet paramEnumSet1, Boolean paramBoolean18, EnumSet paramEnumSet2, EnumSet paramEnumSet3, Boolean paramBoolean19, Boolean paramBoolean20)
    {
      apiKey = paramString1;
      serverTarget = paramString2;
      smallNotificationIconName = paramString3;
      largeNotificationIconName = paramString4;
      customEndpoint = paramString5;
      defaultNotificationChannelName = paramString6;
      defaultNotificationChannelDescription = paramString7;
      pushDeepLinkBackStackActivityClassName = paramString8;
      firebaseCloudMessagingSenderIdKey = paramString9;
      customHtmlWebViewActivityClassName = paramString10;
      sdkFlavor = paramSdkFlavor;
      sessionTimeout = paramInteger1;
      defaultNotificationAccentColor = paramInteger2;
      triggerActionMinimumTimeIntervalSeconds = paramInteger3;
      badNetworkInterval = paramInteger4;
      goodNetworkInterval = paramInteger5;
      greatNetworkInterval = paramInteger6;
      inAppMessageWebViewClientMaxOnPageFinishedWaitMs = paramInteger7;
      admMessagingRegistrationEnabled = paramBoolean1;
      handlePushDeepLinksAutomatically = paramBoolean2;
      isLocationCollectionEnabled = paramBoolean3;
      isNewsFeedVisualIndicatorOn = paramBoolean4;
      isPushDeepLinkBackStackActivityEnabled = paramBoolean5;
      isSessionStartBasedTimeoutEnabled = paramBoolean6;
      isFirebaseCloudMessagingRegistrationEnabled = paramBoolean7;
      isContentCardsUnreadVisualIndicatorEnabled = paramBoolean8;
      isInAppMessageAccessibilityExclusiveModeEnabled = paramBoolean9;
      isPushWakeScreenForNotificationEnabled = paramBoolean10;
      isPushHtmlRenderingEnabled = paramBoolean11;
      isGeofencesEnabled = paramBoolean12;
      inAppMessageTestPushEagerDisplayEnabled = paramBoolean13;
      automaticGeofenceRequestsEnabled = paramBoolean14;
      isFirebaseMessagingServiceOnNewTokenRegistrationEnabled = paramBoolean15;
      isTouchModeRequiredForHtmlInAppMessages = paramBoolean16;
      isSdkAuthEnabled = paramBoolean17;
      deviceObjectAllowlist = paramEnumSet1;
      isDeviceObjectAllowlistEnabled = paramBoolean18;
      brazeSdkMetadata = paramEnumSet2;
      customLocationProviderNames = paramEnumSet3;
      isHtmlInAppMessageApplyWindowInsetsEnabled = paramBoolean19;
      doesPushStoryDismissOnClick = paramBoolean20;
    }
    
    public final BrazeConfig build()
    {
      return new BrazeConfig(this, null);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof Builder)) {
        return false;
      }
      paramObject = (Builder)paramObject;
      if (!i.a(apiKey, apiKey)) {
        return false;
      }
      if (!i.a(serverTarget, serverTarget)) {
        return false;
      }
      if (!i.a(smallNotificationIconName, smallNotificationIconName)) {
        return false;
      }
      if (!i.a(largeNotificationIconName, largeNotificationIconName)) {
        return false;
      }
      if (!i.a(customEndpoint, customEndpoint)) {
        return false;
      }
      if (!i.a(defaultNotificationChannelName, defaultNotificationChannelName)) {
        return false;
      }
      if (!i.a(defaultNotificationChannelDescription, defaultNotificationChannelDescription)) {
        return false;
      }
      if (!i.a(pushDeepLinkBackStackActivityClassName, pushDeepLinkBackStackActivityClassName)) {
        return false;
      }
      if (!i.a(firebaseCloudMessagingSenderIdKey, firebaseCloudMessagingSenderIdKey)) {
        return false;
      }
      if (!i.a(customHtmlWebViewActivityClassName, customHtmlWebViewActivityClassName)) {
        return false;
      }
      if (sdkFlavor != sdkFlavor) {
        return false;
      }
      if (!i.a(sessionTimeout, sessionTimeout)) {
        return false;
      }
      if (!i.a(defaultNotificationAccentColor, defaultNotificationAccentColor)) {
        return false;
      }
      if (!i.a(triggerActionMinimumTimeIntervalSeconds, triggerActionMinimumTimeIntervalSeconds)) {
        return false;
      }
      if (!i.a(badNetworkInterval, badNetworkInterval)) {
        return false;
      }
      if (!i.a(goodNetworkInterval, goodNetworkInterval)) {
        return false;
      }
      if (!i.a(greatNetworkInterval, greatNetworkInterval)) {
        return false;
      }
      if (!i.a(inAppMessageWebViewClientMaxOnPageFinishedWaitMs, inAppMessageWebViewClientMaxOnPageFinishedWaitMs)) {
        return false;
      }
      if (!i.a(admMessagingRegistrationEnabled, admMessagingRegistrationEnabled)) {
        return false;
      }
      if (!i.a(handlePushDeepLinksAutomatically, handlePushDeepLinksAutomatically)) {
        return false;
      }
      if (!i.a(isLocationCollectionEnabled, isLocationCollectionEnabled)) {
        return false;
      }
      if (!i.a(isNewsFeedVisualIndicatorOn, isNewsFeedVisualIndicatorOn)) {
        return false;
      }
      if (!i.a(isPushDeepLinkBackStackActivityEnabled, isPushDeepLinkBackStackActivityEnabled)) {
        return false;
      }
      if (!i.a(isSessionStartBasedTimeoutEnabled, isSessionStartBasedTimeoutEnabled)) {
        return false;
      }
      if (!i.a(isFirebaseCloudMessagingRegistrationEnabled, isFirebaseCloudMessagingRegistrationEnabled)) {
        return false;
      }
      if (!i.a(isContentCardsUnreadVisualIndicatorEnabled, isContentCardsUnreadVisualIndicatorEnabled)) {
        return false;
      }
      if (!i.a(isInAppMessageAccessibilityExclusiveModeEnabled, isInAppMessageAccessibilityExclusiveModeEnabled)) {
        return false;
      }
      if (!i.a(isPushWakeScreenForNotificationEnabled, isPushWakeScreenForNotificationEnabled)) {
        return false;
      }
      if (!i.a(isPushHtmlRenderingEnabled, isPushHtmlRenderingEnabled)) {
        return false;
      }
      if (!i.a(isGeofencesEnabled, isGeofencesEnabled)) {
        return false;
      }
      if (!i.a(inAppMessageTestPushEagerDisplayEnabled, inAppMessageTestPushEagerDisplayEnabled)) {
        return false;
      }
      if (!i.a(automaticGeofenceRequestsEnabled, automaticGeofenceRequestsEnabled)) {
        return false;
      }
      if (!i.a(isFirebaseMessagingServiceOnNewTokenRegistrationEnabled, isFirebaseMessagingServiceOnNewTokenRegistrationEnabled)) {
        return false;
      }
      if (!i.a(isTouchModeRequiredForHtmlInAppMessages, isTouchModeRequiredForHtmlInAppMessages)) {
        return false;
      }
      if (!i.a(isSdkAuthEnabled, isSdkAuthEnabled)) {
        return false;
      }
      if (!i.a(deviceObjectAllowlist, deviceObjectAllowlist)) {
        return false;
      }
      if (!i.a(isDeviceObjectAllowlistEnabled, isDeviceObjectAllowlistEnabled)) {
        return false;
      }
      if (!i.a(brazeSdkMetadata, brazeSdkMetadata)) {
        return false;
      }
      if (!i.a(customLocationProviderNames, customLocationProviderNames)) {
        return false;
      }
      if (!i.a(isHtmlInAppMessageApplyWindowInsetsEnabled, isHtmlInAppMessageApplyWindowInsetsEnabled)) {
        return false;
      }
      return i.a(doesPushStoryDismissOnClick, doesPushStoryDismissOnClick);
    }
    
    public final Boolean getAdmMessagingRegistrationEnabled$android_sdk_base_release()
    {
      return admMessagingRegistrationEnabled;
    }
    
    public final String getApiKey$android_sdk_base_release()
    {
      return apiKey;
    }
    
    public final Boolean getAutomaticGeofenceRequestsEnabled$android_sdk_base_release()
    {
      return automaticGeofenceRequestsEnabled;
    }
    
    public final Integer getBadNetworkInterval$android_sdk_base_release()
    {
      return badNetworkInterval;
    }
    
    public final EnumSet getBrazeSdkMetadata$android_sdk_base_release()
    {
      return brazeSdkMetadata;
    }
    
    public final String getCustomEndpoint$android_sdk_base_release()
    {
      return customEndpoint;
    }
    
    public final String getCustomHtmlWebViewActivityClassName$android_sdk_base_release()
    {
      return customHtmlWebViewActivityClassName;
    }
    
    public final EnumSet getCustomLocationProviderNames$android_sdk_base_release()
    {
      return customLocationProviderNames;
    }
    
    public final Integer getDefaultNotificationAccentColor$android_sdk_base_release()
    {
      return defaultNotificationAccentColor;
    }
    
    public final String getDefaultNotificationChannelDescription$android_sdk_base_release()
    {
      return defaultNotificationChannelDescription;
    }
    
    public final String getDefaultNotificationChannelName$android_sdk_base_release()
    {
      return defaultNotificationChannelName;
    }
    
    public final EnumSet getDeviceObjectAllowlist$android_sdk_base_release()
    {
      return deviceObjectAllowlist;
    }
    
    public final Boolean getDoesPushStoryDismissOnClick$android_sdk_base_release()
    {
      return doesPushStoryDismissOnClick;
    }
    
    public final String getFirebaseCloudMessagingSenderIdKey$android_sdk_base_release()
    {
      return firebaseCloudMessagingSenderIdKey;
    }
    
    public final Integer getGoodNetworkInterval$android_sdk_base_release()
    {
      return goodNetworkInterval;
    }
    
    public final Integer getGreatNetworkInterval$android_sdk_base_release()
    {
      return greatNetworkInterval;
    }
    
    public final Boolean getHandlePushDeepLinksAutomatically$android_sdk_base_release()
    {
      return handlePushDeepLinksAutomatically;
    }
    
    public final Boolean getInAppMessageTestPushEagerDisplayEnabled$android_sdk_base_release()
    {
      return inAppMessageTestPushEagerDisplayEnabled;
    }
    
    public final Integer getInAppMessageWebViewClientMaxOnPageFinishedWaitMs$android_sdk_base_release()
    {
      return inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
    }
    
    public final String getLargeNotificationIconName$android_sdk_base_release()
    {
      return largeNotificationIconName;
    }
    
    public final String getPushDeepLinkBackStackActivityClassName$android_sdk_base_release()
    {
      return pushDeepLinkBackStackActivityClassName;
    }
    
    public final SdkFlavor getSdkFlavor$android_sdk_base_release()
    {
      return sdkFlavor;
    }
    
    public final String getServerTarget$android_sdk_base_release()
    {
      return serverTarget;
    }
    
    public final Integer getSessionTimeout$android_sdk_base_release()
    {
      return sessionTimeout;
    }
    
    public final String getSmallNotificationIconName$android_sdk_base_release()
    {
      return smallNotificationIconName;
    }
    
    public final Integer getTriggerActionMinimumTimeIntervalSeconds$android_sdk_base_release()
    {
      return triggerActionMinimumTimeIntervalSeconds;
    }
    
    public int hashCode()
    {
      Object localObject = apiKey;
      int i36 = 0;
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((String)localObject).hashCode();
      }
      localObject = serverTarget;
      int j;
      if (localObject == null) {
        j = 0;
      } else {
        j = ((String)localObject).hashCode();
      }
      localObject = smallNotificationIconName;
      int k;
      if (localObject == null) {
        k = 0;
      } else {
        k = ((String)localObject).hashCode();
      }
      localObject = largeNotificationIconName;
      int m;
      if (localObject == null) {
        m = 0;
      } else {
        m = ((String)localObject).hashCode();
      }
      localObject = customEndpoint;
      int n;
      if (localObject == null) {
        n = 0;
      } else {
        n = ((String)localObject).hashCode();
      }
      localObject = defaultNotificationChannelName;
      int i1;
      if (localObject == null) {
        i1 = 0;
      } else {
        i1 = ((String)localObject).hashCode();
      }
      localObject = defaultNotificationChannelDescription;
      int i2;
      if (localObject == null) {
        i2 = 0;
      } else {
        i2 = ((String)localObject).hashCode();
      }
      localObject = pushDeepLinkBackStackActivityClassName;
      int i3;
      if (localObject == null) {
        i3 = 0;
      } else {
        i3 = ((String)localObject).hashCode();
      }
      localObject = firebaseCloudMessagingSenderIdKey;
      int i4;
      if (localObject == null) {
        i4 = 0;
      } else {
        i4 = ((String)localObject).hashCode();
      }
      localObject = customHtmlWebViewActivityClassName;
      int i5;
      if (localObject == null) {
        i5 = 0;
      } else {
        i5 = ((String)localObject).hashCode();
      }
      localObject = sdkFlavor;
      int i6;
      if (localObject == null) {
        i6 = 0;
      } else {
        i6 = ((Enum)localObject).hashCode();
      }
      localObject = sessionTimeout;
      int i7;
      if (localObject == null) {
        i7 = 0;
      } else {
        i7 = localObject.hashCode();
      }
      localObject = defaultNotificationAccentColor;
      int i8;
      if (localObject == null) {
        i8 = 0;
      } else {
        i8 = localObject.hashCode();
      }
      localObject = triggerActionMinimumTimeIntervalSeconds;
      int i9;
      if (localObject == null) {
        i9 = 0;
      } else {
        i9 = localObject.hashCode();
      }
      localObject = badNetworkInterval;
      int i10;
      if (localObject == null) {
        i10 = 0;
      } else {
        i10 = localObject.hashCode();
      }
      localObject = goodNetworkInterval;
      int i11;
      if (localObject == null) {
        i11 = 0;
      } else {
        i11 = localObject.hashCode();
      }
      localObject = greatNetworkInterval;
      int i12;
      if (localObject == null) {
        i12 = 0;
      } else {
        i12 = localObject.hashCode();
      }
      localObject = inAppMessageWebViewClientMaxOnPageFinishedWaitMs;
      int i13;
      if (localObject == null) {
        i13 = 0;
      } else {
        i13 = localObject.hashCode();
      }
      localObject = admMessagingRegistrationEnabled;
      int i14;
      if (localObject == null) {
        i14 = 0;
      } else {
        i14 = localObject.hashCode();
      }
      localObject = handlePushDeepLinksAutomatically;
      int i15;
      if (localObject == null) {
        i15 = 0;
      } else {
        i15 = localObject.hashCode();
      }
      localObject = isLocationCollectionEnabled;
      int i16;
      if (localObject == null) {
        i16 = 0;
      } else {
        i16 = localObject.hashCode();
      }
      localObject = isNewsFeedVisualIndicatorOn;
      int i17;
      if (localObject == null) {
        i17 = 0;
      } else {
        i17 = localObject.hashCode();
      }
      localObject = isPushDeepLinkBackStackActivityEnabled;
      int i18;
      if (localObject == null) {
        i18 = 0;
      } else {
        i18 = localObject.hashCode();
      }
      localObject = isSessionStartBasedTimeoutEnabled;
      int i19;
      if (localObject == null) {
        i19 = 0;
      } else {
        i19 = localObject.hashCode();
      }
      localObject = isFirebaseCloudMessagingRegistrationEnabled;
      int i20;
      if (localObject == null) {
        i20 = 0;
      } else {
        i20 = localObject.hashCode();
      }
      localObject = isContentCardsUnreadVisualIndicatorEnabled;
      int i21;
      if (localObject == null) {
        i21 = 0;
      } else {
        i21 = localObject.hashCode();
      }
      localObject = isInAppMessageAccessibilityExclusiveModeEnabled;
      int i22;
      if (localObject == null) {
        i22 = 0;
      } else {
        i22 = localObject.hashCode();
      }
      localObject = isPushWakeScreenForNotificationEnabled;
      int i23;
      if (localObject == null) {
        i23 = 0;
      } else {
        i23 = localObject.hashCode();
      }
      localObject = isPushHtmlRenderingEnabled;
      int i24;
      if (localObject == null) {
        i24 = 0;
      } else {
        i24 = localObject.hashCode();
      }
      localObject = isGeofencesEnabled;
      int i25;
      if (localObject == null) {
        i25 = 0;
      } else {
        i25 = localObject.hashCode();
      }
      localObject = inAppMessageTestPushEagerDisplayEnabled;
      int i26;
      if (localObject == null) {
        i26 = 0;
      } else {
        i26 = localObject.hashCode();
      }
      localObject = automaticGeofenceRequestsEnabled;
      int i27;
      if (localObject == null) {
        i27 = 0;
      } else {
        i27 = localObject.hashCode();
      }
      localObject = isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
      int i28;
      if (localObject == null) {
        i28 = 0;
      } else {
        i28 = localObject.hashCode();
      }
      localObject = isTouchModeRequiredForHtmlInAppMessages;
      int i29;
      if (localObject == null) {
        i29 = 0;
      } else {
        i29 = localObject.hashCode();
      }
      localObject = isSdkAuthEnabled;
      int i30;
      if (localObject == null) {
        i30 = 0;
      } else {
        i30 = localObject.hashCode();
      }
      localObject = deviceObjectAllowlist;
      int i31;
      if (localObject == null) {
        i31 = 0;
      } else {
        i31 = ((EnumSet)localObject).hashCode();
      }
      localObject = isDeviceObjectAllowlistEnabled;
      int i32;
      if (localObject == null) {
        i32 = 0;
      } else {
        i32 = localObject.hashCode();
      }
      localObject = brazeSdkMetadata;
      int i33;
      if (localObject == null) {
        i33 = 0;
      } else {
        i33 = ((EnumSet)localObject).hashCode();
      }
      localObject = customLocationProviderNames;
      int i34;
      if (localObject == null) {
        i34 = 0;
      } else {
        i34 = ((EnumSet)localObject).hashCode();
      }
      localObject = isHtmlInAppMessageApplyWindowInsetsEnabled;
      int i35;
      if (localObject == null) {
        i35 = 0;
      } else {
        i35 = localObject.hashCode();
      }
      localObject = doesPushStoryDismissOnClick;
      if (localObject != null) {
        i36 = localObject.hashCode();
      }
      return (((((((((((((((((((((((((((((((((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i17) * 31 + i18) * 31 + i19) * 31 + i20) * 31 + i21) * 31 + i22) * 31 + i23) * 31 + i24) * 31 + i25) * 31 + i26) * 31 + i27) * 31 + i28) * 31 + i29) * 31 + i30) * 31 + i31) * 31 + i32) * 31 + i33) * 31 + i34) * 31 + i35) * 31 + i36;
    }
    
    public final Boolean isContentCardsUnreadVisualIndicatorEnabled$android_sdk_base_release()
    {
      return isContentCardsUnreadVisualIndicatorEnabled;
    }
    
    public final Boolean isDeviceObjectAllowlistEnabled$android_sdk_base_release()
    {
      return isDeviceObjectAllowlistEnabled;
    }
    
    public final Boolean isFirebaseCloudMessagingRegistrationEnabled$android_sdk_base_release()
    {
      return isFirebaseCloudMessagingRegistrationEnabled;
    }
    
    public final Boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled$android_sdk_base_release()
    {
      return isFirebaseMessagingServiceOnNewTokenRegistrationEnabled;
    }
    
    public final Boolean isGeofencesEnabled$android_sdk_base_release()
    {
      return isGeofencesEnabled;
    }
    
    public final Boolean isHtmlInAppMessageApplyWindowInsetsEnabled$android_sdk_base_release()
    {
      return isHtmlInAppMessageApplyWindowInsetsEnabled;
    }
    
    public final Boolean isInAppMessageAccessibilityExclusiveModeEnabled$android_sdk_base_release()
    {
      return isInAppMessageAccessibilityExclusiveModeEnabled;
    }
    
    public final Boolean isLocationCollectionEnabled$android_sdk_base_release()
    {
      return isLocationCollectionEnabled;
    }
    
    public final Boolean isNewsFeedVisualIndicatorOn$android_sdk_base_release()
    {
      return isNewsFeedVisualIndicatorOn;
    }
    
    public final Boolean isPushDeepLinkBackStackActivityEnabled$android_sdk_base_release()
    {
      return isPushDeepLinkBackStackActivityEnabled;
    }
    
    public final Boolean isPushHtmlRenderingEnabled$android_sdk_base_release()
    {
      return isPushHtmlRenderingEnabled;
    }
    
    public final Boolean isPushWakeScreenForNotificationEnabled$android_sdk_base_release()
    {
      return isPushWakeScreenForNotificationEnabled;
    }
    
    public final Boolean isSdkAuthEnabled$android_sdk_base_release()
    {
      return isSdkAuthEnabled;
    }
    
    public final Boolean isSessionStartBasedTimeoutEnabled$android_sdk_base_release()
    {
      return isSessionStartBasedTimeoutEnabled;
    }
    
    public final Boolean isTouchModeRequiredForHtmlInAppMessages$android_sdk_base_release()
    {
      return isTouchModeRequiredForHtmlInAppMessages;
    }
    
    public final Builder setApiKey(String paramString)
    {
      i.e(paramString, "apiKey");
      if ((g.o(paramString) ^ true))
      {
        apiKey = paramString;
        return this;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, a.STARTED, 2, null);
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Builder(apiKey=");
      localStringBuilder.append(apiKey);
      localStringBuilder.append(", serverTarget=");
      localStringBuilder.append(serverTarget);
      localStringBuilder.append(", smallNotificationIconName=");
      localStringBuilder.append(smallNotificationIconName);
      localStringBuilder.append(", largeNotificationIconName=");
      localStringBuilder.append(largeNotificationIconName);
      localStringBuilder.append(", customEndpoint=");
      localStringBuilder.append(customEndpoint);
      localStringBuilder.append(", defaultNotificationChannelName=");
      localStringBuilder.append(defaultNotificationChannelName);
      localStringBuilder.append(", defaultNotificationChannelDescription=");
      localStringBuilder.append(defaultNotificationChannelDescription);
      localStringBuilder.append(", pushDeepLinkBackStackActivityClassName=");
      localStringBuilder.append(pushDeepLinkBackStackActivityClassName);
      localStringBuilder.append(", firebaseCloudMessagingSenderIdKey=");
      localStringBuilder.append(firebaseCloudMessagingSenderIdKey);
      localStringBuilder.append(", customHtmlWebViewActivityClassName=");
      localStringBuilder.append(customHtmlWebViewActivityClassName);
      localStringBuilder.append(", sdkFlavor=");
      localStringBuilder.append(sdkFlavor);
      localStringBuilder.append(", sessionTimeout=");
      localStringBuilder.append(sessionTimeout);
      localStringBuilder.append(", defaultNotificationAccentColor=");
      localStringBuilder.append(defaultNotificationAccentColor);
      localStringBuilder.append(", triggerActionMinimumTimeIntervalSeconds=");
      localStringBuilder.append(triggerActionMinimumTimeIntervalSeconds);
      localStringBuilder.append(", badNetworkInterval=");
      localStringBuilder.append(badNetworkInterval);
      localStringBuilder.append(", goodNetworkInterval=");
      localStringBuilder.append(goodNetworkInterval);
      localStringBuilder.append(", greatNetworkInterval=");
      localStringBuilder.append(greatNetworkInterval);
      localStringBuilder.append(", inAppMessageWebViewClientMaxOnPageFinishedWaitMs=");
      localStringBuilder.append(inAppMessageWebViewClientMaxOnPageFinishedWaitMs);
      localStringBuilder.append(", admMessagingRegistrationEnabled=");
      localStringBuilder.append(admMessagingRegistrationEnabled);
      localStringBuilder.append(", handlePushDeepLinksAutomatically=");
      localStringBuilder.append(handlePushDeepLinksAutomatically);
      localStringBuilder.append(", isLocationCollectionEnabled=");
      localStringBuilder.append(isLocationCollectionEnabled);
      localStringBuilder.append(", isNewsFeedVisualIndicatorOn=");
      localStringBuilder.append(isNewsFeedVisualIndicatorOn);
      localStringBuilder.append(", isPushDeepLinkBackStackActivityEnabled=");
      localStringBuilder.append(isPushDeepLinkBackStackActivityEnabled);
      localStringBuilder.append(", isSessionStartBasedTimeoutEnabled=");
      localStringBuilder.append(isSessionStartBasedTimeoutEnabled);
      localStringBuilder.append(", isFirebaseCloudMessagingRegistrationEnabled=");
      localStringBuilder.append(isFirebaseCloudMessagingRegistrationEnabled);
      localStringBuilder.append(", isContentCardsUnreadVisualIndicatorEnabled=");
      localStringBuilder.append(isContentCardsUnreadVisualIndicatorEnabled);
      localStringBuilder.append(", isInAppMessageAccessibilityExclusiveModeEnabled=");
      localStringBuilder.append(isInAppMessageAccessibilityExclusiveModeEnabled);
      localStringBuilder.append(", isPushWakeScreenForNotificationEnabled=");
      localStringBuilder.append(isPushWakeScreenForNotificationEnabled);
      localStringBuilder.append(", isPushHtmlRenderingEnabled=");
      localStringBuilder.append(isPushHtmlRenderingEnabled);
      localStringBuilder.append(", isGeofencesEnabled=");
      localStringBuilder.append(isGeofencesEnabled);
      localStringBuilder.append(", inAppMessageTestPushEagerDisplayEnabled=");
      localStringBuilder.append(inAppMessageTestPushEagerDisplayEnabled);
      localStringBuilder.append(", automaticGeofenceRequestsEnabled=");
      localStringBuilder.append(automaticGeofenceRequestsEnabled);
      localStringBuilder.append(", isFirebaseMessagingServiceOnNewTokenRegistrationEnabled=");
      localStringBuilder.append(isFirebaseMessagingServiceOnNewTokenRegistrationEnabled);
      localStringBuilder.append(", isTouchModeRequiredForHtmlInAppMessages=");
      localStringBuilder.append(isTouchModeRequiredForHtmlInAppMessages);
      localStringBuilder.append(", isSdkAuthEnabled=");
      localStringBuilder.append(isSdkAuthEnabled);
      localStringBuilder.append(", deviceObjectAllowlist=");
      localStringBuilder.append(deviceObjectAllowlist);
      localStringBuilder.append(", isDeviceObjectAllowlistEnabled=");
      localStringBuilder.append(isDeviceObjectAllowlistEnabled);
      localStringBuilder.append(", brazeSdkMetadata=");
      localStringBuilder.append(brazeSdkMetadata);
      localStringBuilder.append(", customLocationProviderNames=");
      localStringBuilder.append(customLocationProviderNames);
      localStringBuilder.append(", isHtmlInAppMessageApplyWindowInsetsEnabled=");
      localStringBuilder.append(isHtmlInAppMessageApplyWindowInsetsEnabled);
      localStringBuilder.append(", doesPushStoryDismissOnClick=");
      localStringBuilder.append(doesPushStoryDismissOnClick);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
    
    static final class a
      extends j
      implements a<String>
    {
      public static final a STARTED = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Cannot set Braze API key to blank string. API key field not set";
      }
    }
  }
}
