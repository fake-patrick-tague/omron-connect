package com.braze.models.push;

import android.content.Context;
import android.os.BaseBundle;
import android.os.Bundle;
import androidx.core.package_10.e;
import androidx.core.package_10.h;
import com.braze.Constants;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.BundleUtils;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class BrazeNotificationPayload
{
  public static final Companion Companion = new Companion(null);
  private Integer accentColor;
  private List<ActionButton> actionButtonsInternal;
  private String bigImageUrl;
  private String bigSummaryText;
  private String bigTitleText;
  private Bundle brazeExtras;
  private BrazeConfigurationProvider configurationProvider;
  private String contentCardSyncData;
  private String contentCardSyncUserId;
  private String contentText;
  private Context context;
  private final List<ConversationMessage> conversationMessagesInternal;
  private final Map<String, ConversationPerson> conversationPersonMapInternal;
  private String conversationReplyPersonId;
  private String conversationShortcutId;
  private Integer customNotificationId;
  private String deeplink;
  private Map<String, String> extras;
  private boolean isConversationalPush;
  private boolean isInlineImagePush;
  private boolean isNewlyReceivedPushStory;
  private boolean isPushStory;
  private boolean isUninstallTrackingPush;
  private String largeIcon;
  private Integer notificationBadgeNumber;
  private String notificationCategory;
  private String notificationChannelId;
  private final Bundle notificationExtras;
  private Integer notificationPriorityInt;
  private Long notificationReceivedTimestampMillis;
  private String notificationSound;
  private Integer notificationVisibility;
  private String publicNotificationExtras;
  private Integer pushDuration;
  private int pushStoryPageIndex;
  private List<PushStoryPage> pushStoryPagesInternal;
  private boolean shouldFetchTestTriggers;
  private boolean shouldRefreshFeatureFlags;
  private boolean shouldSyncGeofences;
  private String summaryText;
  private String titleText;
  
  public BrazeNotificationPayload(Bundle paramBundle1, Bundle paramBundle2, Context paramContext, BrazeConfigurationProvider paramBrazeConfigurationProvider)
  {
    configurationProvider = paramBrazeConfigurationProvider;
    paramBrazeConfigurationProvider = paramBundle1;
    if (paramBundle1 == null) {
      paramBrazeConfigurationProvider = new Bundle();
    }
    notificationExtras = paramBrazeConfigurationProvider;
    if (paramBundle2 == null) {
      paramBundle1 = new Bundle();
    } else {
      paramBundle1 = paramBundle2;
    }
    brazeExtras = paramBundle1;
    extras = BundleUtils.toStringMap(paramBundle2);
    if (paramContext != null) {
      paramBundle1 = paramContext.getApplicationContext();
    } else {
      paramBundle1 = null;
    }
    context = paramBundle1;
    actionButtonsInternal = new ArrayList();
    pushStoryPagesInternal = new ArrayList();
    conversationMessagesInternal = new ArrayList();
    conversationPersonMapInternal = new HashMap();
    parsePayloadFieldsFromBundle();
  }
  
  private final void parsePayloadFieldsFromBundle()
  {
    parsePayloadFieldsFromBundle$parseNotificationMetadata(this);
    parsePayloadFieldsFromBundle$parseContentCardData(this);
    parsePayloadFieldsFromBundle$parseVisibleContent(this);
    parsePayloadFieldsFromBundle$parseBigTextStyle(this);
    parsePayloadFieldsFromBundle$parseBigImageStyle(this);
    parsePayloadFieldsFromBundle$parseActionButtons(this);
    parsePayloadFieldsFromBundle$parsePushStoryData(this);
    parsePayloadFieldsFromBundle$parseConversationPushData(this);
  }
  
  private static final void parsePayloadFieldsFromBundle$parseActionButtons(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    actionButtonsInternal.clear();
    int i = 0;
    for (;;)
    {
      Object localObject = Companion.getTemplateFieldAtIndex(i, notificationExtras, "ab_a*_a");
      int j;
      if ((localObject != null) && (!g.o((CharSequence)localObject))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0) {
        break;
      }
      localObject = new ActionButton(notificationExtras, i);
      actionButtonsInternal.add(localObject);
      i += 1;
    }
  }
  
  private static final void parsePayloadFieldsFromBundle$parseBigImageStyle(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    String str = Companion.parseNonBlankString(notificationExtras, "ab_iu");
    bigImageUrl = str;
    int j = 0;
    int i;
    if ((str != null) && (!g.o(str))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      str = (String)extras.get("appboy_image_url");
      if (str != null)
      {
        i = j;
        if (!g.o(str)) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0) {
        bigImageUrl = str;
      }
    }
  }
  
  private static final void parsePayloadFieldsFromBundle$parseBigTextStyle(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    Companion localCompanion = Companion;
    bigSummaryText = localCompanion.parseString(notificationExtras, "ab_bs");
    bigTitleText = localCompanion.parseString(notificationExtras, "ab_bt");
  }
  
  private static final void parsePayloadFieldsFromBundle$parseContentCardData(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    Companion localCompanion = Companion;
    contentCardSyncData = localCompanion.parseString(notificationExtras, "ab_cd");
    contentCardSyncUserId = localCompanion.parseString(notificationExtras, "ab_cd_uid");
  }
  
  private static final void parsePayloadFieldsFromBundle$parseConversationPushData(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    Object localObject = Companion;
    conversationShortcutId = ((Companion)localObject).parseString(notificationExtras, "ab_c_si");
    conversationReplyPersonId = ((Companion)localObject).parseString(notificationExtras, "ab_c_rpi");
    conversationMessagesInternal.clear();
    conversationPersonMapInternal.clear();
    int i = 0;
    int j;
    for (;;)
    {
      localObject = Companion.getTemplateFieldAtIndex(i, notificationExtras, "ab_c_mt*");
      if ((localObject != null) && (!g.o((CharSequence)localObject))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0) {
        break;
      }
      localObject = new ConversationMessage(notificationExtras, i);
      conversationMessagesInternal.add(localObject);
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = Companion.getTemplateFieldAtIndex(i, notificationExtras, "ab_c_pi*");
      if ((localObject != null) && (!g.o((CharSequence)localObject))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0) {
        break;
      }
      localObject = new ConversationPerson(notificationExtras, i);
      conversationPersonMapInternal.put(((ConversationPerson)localObject).getPersonId(), localObject);
      i += 1;
    }
  }
  
  private static final void parsePayloadFieldsFromBundle$parseNotificationMetadata(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    Companion localCompanion = Companion;
    pushDuration = localCompanion.parseStringAsInteger(notificationExtras, "nd");
    isPushStory = notificationExtras.containsKey("ab_c");
    notificationCategory = localCompanion.parseString(notificationExtras, "ab_ct");
    notificationVisibility = localCompanion.parseStringAsInteger(notificationExtras, "ab_vs");
    notificationBadgeNumber = localCompanion.parseStringAsInteger(notificationExtras, "ab_bc");
    publicNotificationExtras = localCompanion.parseString(notificationExtras, "ab_pn");
    customNotificationId = localCompanion.parseStringAsInteger(notificationExtras, "n");
    notificationReceivedTimestampMillis = localCompanion.parseLong(notificationExtras, "braze_push_received_timestamp");
    isInlineImagePush = notificationExtras.containsKey("ab_iip");
    isConversationalPush = notificationExtras.containsKey("ab_cp");
    notificationPriorityInt = localCompanion.parseStringAsInteger(notificationExtras, "p");
    shouldFetchTestTriggers = localCompanion.parseStringAsBoolean(notificationExtras, "ab_push_fetch_test_triggers_key");
    shouldSyncGeofences = localCompanion.parseStringAsBoolean(notificationExtras, "ab_sync_geos");
    shouldRefreshFeatureFlags = localCompanion.parseStringAsBoolean(notificationExtras, "br_ffr");
    boolean bool;
    if ((!notificationExtras.containsKey("appboy_uninstall_tracking")) && (!brazeExtras.containsKey("appboy_uninstall_tracking"))) {
      bool = false;
    } else {
      bool = true;
    }
    isUninstallTrackingPush = bool;
    deeplink = localCompanion.parseString(notificationExtras, "uri");
  }
  
  private static final void parsePayloadFieldsFromBundle$parsePushStoryData(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    pushStoryPageIndex = Companion.parseObjectAsInteger(notificationExtras, "braze_story_index", 0);
    int i = 0;
    for (;;)
    {
      Object localObject = Companion.getTemplateFieldAtIndex(i, notificationExtras, "ab_c*_i");
      int j;
      if ((localObject != null) && (!g.o((CharSequence)localObject))) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0) {
        break;
      }
      localObject = new PushStoryPage(notificationExtras, i);
      pushStoryPagesInternal.add(localObject);
      i += 1;
    }
    isNewlyReceivedPushStory = notificationExtras.getBoolean("braze_story_newly_received", false);
  }
  
  private static final void parsePayloadFieldsFromBundle$parseVisibleContent(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    Companion localCompanion = Companion;
    notificationChannelId = localCompanion.parseNonBlankString(notificationExtras, "ab_nc");
    titleText = localCompanion.parseString(notificationExtras, "t");
    contentText = localCompanion.parseString(notificationExtras, "a");
    largeIcon = localCompanion.parseString(notificationExtras, "ab_li");
    notificationSound = localCompanion.parseString(notificationExtras, "sd");
    summaryText = localCompanion.parseString(notificationExtras, "s");
    accentColor = localCompanion.parseStringAsColorInt(notificationExtras, "ac");
  }
  
  public final Integer getAccentColor()
  {
    return accentColor;
  }
  
  public final List getActionButtons()
  {
    return actionButtonsInternal;
  }
  
  public final String getBigImageUrl()
  {
    return bigImageUrl;
  }
  
  public final String getBigSummaryText()
  {
    return bigSummaryText;
  }
  
  public final String getBigTitleText()
  {
    return bigTitleText;
  }
  
  public final Bundle getBrazeExtras()
  {
    return brazeExtras;
  }
  
  public final BrazeConfigurationProvider getConfigurationProvider()
  {
    return configurationProvider;
  }
  
  public final String getContentCardSyncData()
  {
    return contentCardSyncData;
  }
  
  public final String getContentCardSyncUserId()
  {
    return contentCardSyncUserId;
  }
  
  public final String getContentText()
  {
    return contentText;
  }
  
  public final Context getContext()
  {
    return context;
  }
  
  public final List getConversationMessages()
  {
    return conversationMessagesInternal;
  }
  
  public final Map getConversationPersonMap()
  {
    return conversationPersonMapInternal;
  }
  
  public final String getConversationReplyPersonId()
  {
    return conversationReplyPersonId;
  }
  
  public final String getConversationShortcutId()
  {
    return conversationShortcutId;
  }
  
  public final Integer getCustomNotificationId()
  {
    return customNotificationId;
  }
  
  public final String getLargeIcon()
  {
    return largeIcon;
  }
  
  public final Integer getNotificationBadgeNumber()
  {
    return notificationBadgeNumber;
  }
  
  public final String getNotificationCategory()
  {
    return notificationCategory;
  }
  
  public final String getNotificationChannelId()
  {
    return notificationChannelId;
  }
  
  public final Bundle getNotificationExtras()
  {
    return notificationExtras;
  }
  
  public final Integer getNotificationPriorityInt()
  {
    return notificationPriorityInt;
  }
  
  public final String getNotificationSound()
  {
    return notificationSound;
  }
  
  public final Integer getNotificationVisibility()
  {
    return notificationVisibility;
  }
  
  public final String getPublicNotificationExtras()
  {
    return publicNotificationExtras;
  }
  
  public final Integer getPushDuration()
  {
    return pushDuration;
  }
  
  public final int getPushStoryPageIndex()
  {
    return pushStoryPageIndex;
  }
  
  public final List getPushStoryPages()
  {
    return pushStoryPagesInternal;
  }
  
  public final boolean getShouldFetchTestTriggers()
  {
    return shouldFetchTestTriggers;
  }
  
  public final boolean getShouldRefreshFeatureFlags()
  {
    return shouldRefreshFeatureFlags;
  }
  
  public final boolean getShouldSyncGeofences()
  {
    return shouldSyncGeofences;
  }
  
  public final String getSummaryText()
  {
    return summaryText;
  }
  
  public final String getTitleText()
  {
    return titleText;
  }
  
  public final boolean isConversationalPush()
  {
    return isConversationalPush;
  }
  
  public final boolean isInlineImagePush()
  {
    return isInlineImagePush;
  }
  
  public final boolean isNewlyReceivedPushStory()
  {
    return isNewlyReceivedPushStory;
  }
  
  public final boolean isPushStory()
  {
    return isPushStory;
  }
  
  public final boolean isUninstallTrackingPush()
  {
    return isUninstallTrackingPush;
  }
  
  public final void setNewlyReceivedPushStory(boolean paramBoolean)
  {
    isNewlyReceivedPushStory = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Companion localCompanion = Companion;
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "PushDuration", pushDuration));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "IsPushStory", Boolean.valueOf(isPushStory)));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "IsInlineImagePush", Boolean.valueOf(isInlineImagePush)));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "IsConversationalPush", Boolean.valueOf(isConversationalPush)));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "PublicNotificationExtras", publicNotificationExtras));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "NotificationChannelId", notificationChannelId));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "NotificationCategory", notificationCategory));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "NotificationVisibility", notificationVisibility));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "NotificationBadgeNumber", notificationBadgeNumber));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "CustomNotificationId", customNotificationId));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "NotificationReceivedTimestampMillis", notificationReceivedTimestampMillis));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "ContentCardSyncData", contentCardSyncData));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "ContentCardSyncUserId", contentCardSyncUserId));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "TitleText", titleText));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "ContentText", contentText));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "LargeIcon", largeIcon));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "NotificationSound", notificationSound));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "SummaryText", summaryText));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "AccentColor", accentColor));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "BigSummaryText", bigSummaryText));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "BigTitleText", bigTitleText));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "BigImageUrl", bigImageUrl));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "ActionButtons", getActionButtons()));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "PushStoryPageIndex", Integer.valueOf(pushStoryPageIndex)));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "PushStoryPages", pushStoryPagesInternal));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "ConversationMessages", conversationMessagesInternal));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "ConversationPersonMap", conversationPersonMapInternal));
    localStringBuilder.append(Companion.access$stringAndKey(localCompanion, "ConversationShortcutId", conversationShortcutId));
    return localStringBuilder.toString();
  }
  
  public static final class ActionButton
  {
    private String actionId;
    private int actionIndex;
    private String serverVersion;
    private String text;
    private String type;
    private String useWebview;
    
    public ActionButton(Bundle paramBundle, int paramInt)
    {
      actionIndex = paramInt;
      BrazeNotificationPayload.Companion localCompanion = BrazeNotificationPayload.Companion;
      type = localCompanion.getTemplateFieldAtIndex(paramInt, paramBundle, "ab_a*_a");
      actionId = localCompanion.getTemplateFieldAtIndex(actionIndex, paramBundle, "ab_a*_id");
      serverVersion = localCompanion.getTemplateFieldAtIndex(actionIndex, paramBundle, "ab_a*_uri");
      useWebview = localCompanion.getTemplateFieldAtIndex(actionIndex, paramBundle, "ab_a*_use_webview");
      text = localCompanion.getTemplateFieldAtIndex(actionIndex, paramBundle, "ab_a*_t");
    }
    
    public final String getText()
    {
      return text;
    }
    
    public final String getType()
    {
      return type;
    }
    
    public final void putIntoBundle(Bundle paramBundle)
    {
      i.e(paramBundle, "destination");
      paramBundle.putInt("braze_action_index", actionIndex);
      paramBundle.putString("braze_action_type", type);
      paramBundle.putString("braze_action_id", actionId);
      paramBundle.putString("braze_action_uri", serverVersion);
      paramBundle.putString("braze_action_use_webview", useWebview);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      BrazeNotificationPayload.Companion localCompanion = BrazeNotificationPayload.Companion;
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "ActionIndex", Integer.valueOf(actionIndex)));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Type", type));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Id", actionId));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Uri", serverVersion));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "UseWebview", useWebview));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Text", text));
      return localStringBuilder.toString();
    }
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    private final String stringAndKey(String paramString, Object paramObject)
    {
      if (paramObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append('\n');
        localStringBuilder.append(paramString);
        localStringBuilder.append(" = ");
        localStringBuilder.append(paramObject);
        return localStringBuilder.toString();
      }
      return "";
    }
    
    public final Bundle getAttachedBrazeExtras(Bundle paramBundle)
    {
      if (paramBundle == null) {
        return new Bundle();
      }
      if ((paramBundle.containsKey("braze_story_newly_received")) && (!paramBundle.getBoolean("braze_story_newly_received")))
      {
        Bundle localBundle = paramBundle.getBundle("extra");
        paramBundle = localBundle;
        if (localBundle == null) {
          return new Bundle();
        }
      }
      else
      {
        if (Constants.isAmazonDevice()) {
          return new Bundle(paramBundle);
        }
        paramBundle = paramBundle.get("extra");
        if ((paramBundle instanceof String)) {
          return JsonUtils.parseJsonObjectIntoBundle((String)paramBundle);
        }
        if ((paramBundle instanceof Bundle)) {
          return (Bundle)paramBundle;
        }
        paramBundle = new Bundle();
      }
      return paramBundle;
    }
    
    public final int getPushStoryGravityAtIndex(int paramInt, Bundle paramBundle, String paramString)
    {
      i.e(paramBundle, "notificationExtras");
      i.e(paramString, "actionFieldKeyTemplate");
      paramBundle = paramBundle.getString(g.r(paramString, "*", String.valueOf(paramInt), false, 4, null));
      if ((paramBundle != null) && (!g.o(paramBundle))) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      if (paramInt == 0)
      {
        paramInt = paramBundle.hashCode();
        if (paramInt != -1364013995)
        {
          if (paramInt != 100571)
          {
            if ((paramInt == 109757538) && (paramBundle.equals("start"))) {
              return 8388611;
            }
          }
          else if (paramBundle.equals("end")) {
            return 8388613;
          }
        }
        else {
          paramBundle.equals("center");
        }
      }
      return 17;
    }
    
    public final long getTemplateFieldAtIndex(int paramInt, Bundle paramBundle, String paramString, long paramLong)
    {
      i.e(paramBundle, "notificationExtras");
      i.e(paramString, "actionFieldKeyTemplate");
      paramBundle = paramBundle.getString(g.r(paramString, "*", String.valueOf(paramInt), false, 4, null));
      if (paramBundle == null) {
        return paramLong;
      }
      try
      {
        long l = Long.parseLong(paramBundle);
        return l;
      }
      catch (Exception paramBundle)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramBundle, b.SingleTap);
      }
      return paramLong;
    }
    
    public final String getTemplateFieldAtIndex(int paramInt, Bundle paramBundle, String paramString)
    {
      i.e(paramBundle, "notificationExtras");
      i.e(paramString, "actionFieldKeyTemplate");
      return getTemplateFieldAtIndex(paramInt, paramBundle, paramString, "");
    }
    
    public final String getTemplateFieldAtIndex(int paramInt, Bundle paramBundle, String paramString1, String paramString2)
    {
      i.e(paramBundle, "notificationExtras");
      i.e(paramString1, "actionFieldKeyTemplate");
      paramBundle = paramBundle.getString(g.r(paramString1, "*", String.valueOf(paramInt), false, 4, null));
      if (paramBundle == null) {
        return paramString2;
      }
      return paramBundle;
    }
    
    public final boolean getTemplateFieldAtIndex(int paramInt, Bundle paramBundle, String paramString, boolean paramBoolean)
    {
      i.e(paramBundle, "notificationExtras");
      i.e(paramString, "actionFieldKeyTemplate");
      paramBundle = paramBundle.getString(g.r(paramString, "*", String.valueOf(paramInt), false, 4, null));
      if (paramBundle == null) {
        return paramBoolean;
      }
      try
      {
        boolean bool = Boolean.parseBoolean(paramBundle);
        return bool;
      }
      catch (Exception paramBundle)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramBundle, a.SingleTap);
      }
      return paramBoolean;
    }
    
    public final Long parseLong(final Bundle paramBundle, String paramString)
    {
      i.e(paramBundle, "bundle");
      i.e(paramString, "key");
      try
      {
        boolean bool = paramBundle.containsKey(paramString);
        if (!bool) {
          break label55;
        }
        long l = paramBundle.getLong(paramString);
        return Long.valueOf(l);
      }
      catch (Exception localException)
      {
        label55:
        for (;;) {}
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new c(paramString, paramBundle), 3, null);
      return null;
    }
    
    public final String parseNonBlankString(final Bundle paramBundle, String paramString)
    {
      i.e(paramBundle, "bundle");
      i.e(paramString, "key");
      try
      {
        String str = parseString(paramBundle, paramString);
        if (str != null)
        {
          boolean bool = g.o(str);
          if (!bool)
          {
            i = 0;
            break label47;
          }
        }
        int i = 1;
        label47:
        if (i != 0) {
          break label74;
        }
        return str;
      }
      catch (Exception localException)
      {
        label74:
        for (;;) {}
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new d(paramString, paramBundle), 3, null);
      return null;
    }
    
    public final int parseObjectAsInteger(final Bundle paramBundle, String paramString, int paramInt)
    {
      i.e(paramBundle, "bundle");
      i.e(paramString, "key");
      try
      {
        boolean bool = paramBundle.containsKey(paramString);
        if (!bool) {
          return paramInt;
        }
        Object localObject = paramBundle.get(paramString);
        if (localObject == null) {
          return paramInt;
        }
        int i = Integer.parseInt(localObject.toString());
        return i;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new e(paramString, paramBundle), 3, null);
      return paramInt;
      return paramInt;
    }
    
    public final String parseString(final Bundle paramBundle, String paramString)
    {
      i.e(paramBundle, "bundle");
      i.e(paramString, "key");
      try
      {
        boolean bool = paramBundle.containsKey(paramString);
        if (!bool) {
          break label52;
        }
        String str = paramBundle.getString(paramString);
        return str;
      }
      catch (Exception localException)
      {
        label52:
        for (;;) {}
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new f(paramString, paramBundle), 3, null);
      return null;
    }
    
    public final boolean parseStringAsBoolean(final Bundle paramBundle, String paramString)
    {
      i.e(paramBundle, "bundle");
      i.e(paramString, "key");
      try
      {
        boolean bool = paramBundle.containsKey(paramString);
        if (!bool) {
          break label62;
        }
        String str = paramBundle.getString(paramString);
        if (str == null) {
          break label62;
        }
        bool = Boolean.parseBoolean(str);
        return bool;
      }
      catch (Exception localException)
      {
        label62:
        for (;;) {}
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new g(paramString, paramBundle), 3, null);
      return false;
    }
    
    public final Integer parseStringAsColorInt(final Bundle paramBundle, String paramString)
    {
      i.e(paramBundle, "bundle");
      i.e(paramString, "key");
      try
      {
        boolean bool = paramBundle.containsKey(paramString);
        if (!bool) {
          break label72;
        }
        String str = paramBundle.getString(paramString);
        if (str == null) {
          break label72;
        }
        long l = Long.parseLong(str);
        int i = (int)l;
        return Integer.valueOf(i);
      }
      catch (Exception localException)
      {
        label72:
        for (;;) {}
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new h(paramString, paramBundle), 3, null);
      return null;
    }
    
    public final Integer parseStringAsInteger(final Bundle paramBundle, String paramString)
    {
      i.e(paramBundle, "bundle");
      i.e(paramString, "key");
      try
      {
        boolean bool = paramBundle.containsKey(paramString);
        if (!bool) {
          break label67;
        }
        String str = paramBundle.getString(paramString);
        if (str == null) {
          break label67;
        }
        int i = Integer.parseInt(str);
        return Integer.valueOf(i);
      }
      catch (Exception localException)
      {
        label67:
        for (;;) {}
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new i(paramString, paramBundle), 3, null);
      return null;
    }
    
    static final class a
      extends j
      implements a<String>
    {
      public static final a SingleTap = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Failed to parse action field boolean. Returning default.";
      }
    }
    
    static final class b
      extends j
      implements a<String>
    {
      public static final b SingleTap = new b();
      
      b()
      {
        super();
      }
      
      public final String getText()
      {
        return "Failed to parse action field long. Returning default.";
      }
    }
    
    static final class c
      extends j
      implements a<String>
    {
      c(String paramString, Bundle paramBundle)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to parse long with key ");
        localStringBuilder.append(target);
        localStringBuilder.append(" and bundle: ");
        localStringBuilder.append(paramBundle);
        return localStringBuilder.toString();
      }
    }
    
    static final class d
      extends j
      implements a<String>
    {
      d(String paramString, Bundle paramBundle)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to parse non blank string with key ");
        localStringBuilder.append(target);
        localStringBuilder.append(" and bundle: ");
        localStringBuilder.append(paramBundle);
        return localStringBuilder.toString();
      }
    }
    
    static final class e
      extends j
      implements a<String>
    {
      e(String paramString, Bundle paramBundle)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to parse string as int with key ");
        localStringBuilder.append(target);
        localStringBuilder.append(" and bundle: ");
        localStringBuilder.append(paramBundle);
        return localStringBuilder.toString();
      }
    }
    
    static final class f
      extends j
      implements a<String>
    {
      f(String paramString, Bundle paramBundle)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to parse string with key ");
        localStringBuilder.append(target);
        localStringBuilder.append(" and bundle: ");
        localStringBuilder.append(paramBundle);
        return localStringBuilder.toString();
      }
    }
    
    static final class g
      extends j
      implements a<String>
    {
      g(String paramString, Bundle paramBundle)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to parse string as boolean with key ");
        localStringBuilder.append(target);
        localStringBuilder.append(" and bundle: ");
        localStringBuilder.append(paramBundle);
        return localStringBuilder.toString();
      }
    }
    
    static final class h
      extends j
      implements a<String>
    {
      h(String paramString, Bundle paramBundle)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to parse string as color int with key ");
        localStringBuilder.append(target);
        localStringBuilder.append(" and bundle: ");
        localStringBuilder.append(paramBundle);
        return localStringBuilder.toString();
      }
    }
    
    static final class i
      extends j
      implements a<String>
    {
      i(String paramString, Bundle paramBundle)
      {
        super();
      }
      
      public final String get()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to parse string as int with key ");
        localStringBuilder.append(target);
        localStringBuilder.append(" and bundle: ");
        localStringBuilder.append(paramBundle);
        return localStringBuilder.toString();
      }
    }
  }
  
  public static final class ConversationMessage
  {
    private final String message;
    private final String personId;
    private final long timestamp;
    
    public ConversationMessage(Bundle paramBundle, int paramInt)
    {
      BrazeNotificationPayload.Companion localCompanion = BrazeNotificationPayload.Companion;
      message = localCompanion.getTemplateFieldAtIndex(paramInt, paramBundle, "ab_c_mt*");
      timestamp = localCompanion.getTemplateFieldAtIndex(paramInt, paramBundle, "ab_c_mw*", 0L);
      personId = localCompanion.getTemplateFieldAtIndex(paramInt, paramBundle, "ab_c_mp*");
    }
    
    public final String getMessage()
    {
      return message;
    }
    
    public final String getPersonId()
    {
      return personId;
    }
    
    public final long getTimestamp()
    {
      return timestamp;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      BrazeNotificationPayload.Companion localCompanion = BrazeNotificationPayload.Companion;
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Message", message));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Timestamp", Long.valueOf(timestamp)));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "PersonId", personId));
      return localStringBuilder.toString();
    }
  }
  
  public static final class ConversationPerson
  {
    private final boolean isBot;
    private final boolean isImportant;
    private final String name;
    private final String personId;
    private final String uri;
    
    public ConversationPerson(Bundle paramBundle, int paramInt)
    {
      BrazeNotificationPayload.Companion localCompanion = BrazeNotificationPayload.Companion;
      personId = localCompanion.getTemplateFieldAtIndex(paramInt, paramBundle, "ab_c_pi*");
      name = localCompanion.getTemplateFieldAtIndex(paramInt, paramBundle, "ab_c_pn*");
      uri = localCompanion.getTemplateFieldAtIndex(paramInt, paramBundle, "ab_c_pu*", null);
      isImportant = localCompanion.getTemplateFieldAtIndex(paramInt, paramBundle, "ab_c_pt*", false);
      isBot = localCompanion.getTemplateFieldAtIndex(paramInt, paramBundle, "ab_c_pb*", false);
    }
    
    public final h getPerson()
    {
      h localH = new e().b(personId).a(name).a(uri).a(isBot).b(isImportant).a();
      i.d(localH, "Builder()\n              ?\n                .build()");
      return localH;
    }
    
    public final String getPersonId()
    {
      return personId;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      BrazeNotificationPayload.Companion localCompanion = BrazeNotificationPayload.Companion;
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "PersonId", personId));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Name", name));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Uri", uri));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "IsImportant", Boolean.valueOf(isImportant)));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "IsBot", Boolean.valueOf(isBot)));
      return localStringBuilder.toString();
    }
  }
  
  public static final class PushStoryPage
  {
    private int actionIndex;
    private String bitmapUrl;
    private final String campaignId;
    private String deeplink;
    private String storyPageId;
    private String subtitle;
    private int subtitleGravity;
    private String title;
    private int titleGravity;
    private String useWebview;
    
    public PushStoryPage(Bundle paramBundle, int paramInt)
    {
      actionIndex = paramInt;
      BrazeNotificationPayload.Companion localCompanion = BrazeNotificationPayload.Companion;
      campaignId = localCompanion.parseString(paramBundle, "cid");
      title = localCompanion.getTemplateFieldAtIndex(actionIndex, paramBundle, "ab_c*_t");
      titleGravity = localCompanion.getPushStoryGravityAtIndex(actionIndex, paramBundle, "ab_c*_t_j");
      subtitle = localCompanion.getTemplateFieldAtIndex(actionIndex, paramBundle, "ab_c*_st");
      subtitleGravity = localCompanion.getPushStoryGravityAtIndex(actionIndex, paramBundle, "ab_c*_st_j");
      bitmapUrl = localCompanion.getTemplateFieldAtIndex(actionIndex, paramBundle, "ab_c*_i");
      storyPageId = localCompanion.getTemplateFieldAtIndex(actionIndex, paramBundle, "ab_c*_id", "");
      deeplink = localCompanion.getTemplateFieldAtIndex(actionIndex, paramBundle, "ab_c*_uri");
      useWebview = localCompanion.getTemplateFieldAtIndex(actionIndex, paramBundle, "ab_c*_use_webview");
    }
    
    public final String getBitmapUrl()
    {
      return bitmapUrl;
    }
    
    public final String getCampaignId()
    {
      return campaignId;
    }
    
    public final String getDeeplink()
    {
      return deeplink;
    }
    
    public final String getStoryPageId()
    {
      return storyPageId;
    }
    
    public final String getSubtitle()
    {
      return subtitle;
    }
    
    public final int getSubtitleGravity()
    {
      return subtitleGravity;
    }
    
    public final String getTitle()
    {
      return title;
    }
    
    public final int getTitleGravity()
    {
      return titleGravity;
    }
    
    public final String getUseWebview()
    {
      return useWebview;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      BrazeNotificationPayload.Companion localCompanion = BrazeNotificationPayload.Companion;
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "ActionIndex", Integer.valueOf(actionIndex)));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "CampaignId", campaignId));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Title", title));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "TitleGravity", Integer.valueOf(titleGravity)));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Subtitle", subtitle));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "SubtitleGravity=", Integer.valueOf(subtitleGravity)));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "BitmapUrl", bitmapUrl));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "StoryPageId", storyPageId));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "Deeplink", deeplink));
      localStringBuilder.append(BrazeNotificationPayload.Companion.access$stringAndKey(localCompanion, "UseWebview", useWebview));
      return localStringBuilder.toString();
    }
  }
}
