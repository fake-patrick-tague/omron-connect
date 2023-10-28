package com.braze.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.ApplicationInfoFlags;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.package_10.ByteVector;
import androidx.core.package_10.ClassReader;
import androidx.core.package_10.ClassWriter;
import androidx.core.package_10.ExtensionData;
import androidx.core.package_10.Frame;
import androidx.core.package_10.Label;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.IBrazeDeeplinkHandler.IntentFlagPurpose;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazeDateFormat;
import com.braze.enums.BrazeViewBounds;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.models.push.BrazeNotificationPayload.ConversationMessage;
import com.braze.models.push.BrazeNotificationPayload.ConversationPerson;
import com.braze.models.push.BrazeNotificationPayload.PushStoryPage;
import com.braze.push.support.HtmlUtils;
import com.braze.support.BrazeImageUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.DateTimeUtils;
import com.braze.support.IntentUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler.Companion;
import com.braze.ui.R.id;
import com.braze.ui.R.layout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public class BrazeNotificationStyleFactory
{
  public static final Companion Companion = new Companion(null);
  
  public static final class Companion
  {
    private Companion() {}
    
    private final PendingIntent createStoryPageClickedPendingIntent(Context paramContext, BrazeNotificationPayload paramBrazeNotificationPayload, BrazeNotificationPayload.PushStoryPage paramPushStoryPage)
    {
      Intent localIntent = new Intent("com.braze.action.BRAZE_STORY_CLICKED").setClass(paramContext, NotificationTrampolineActivity.class);
      i.d(localIntent, "Intent(Constants.BRAZE_S?lineActivity::class.java)");
      localIntent.setFlags(localIntent.getFlags() | BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_PUSH_STORY_PAGE_CLICK));
      localIntent.putExtras(paramBrazeNotificationPayload.getNotificationExtras());
      localIntent.putExtra("braze_action_uri", paramPushStoryPage.getDeeplink());
      localIntent.putExtra("braze_action_use_webview", paramPushStoryPage.getUseWebview());
      localIntent.putExtra("braze_story_page_id", paramPushStoryPage.getStoryPageId());
      localIntent.putExtra("braze_campaign_id", paramPushStoryPage.getCampaignId());
      localIntent.putExtra("nid", BrazeNotificationUtils.getNotificationId(paramBrazeNotificationPayload));
      paramContext = PendingIntent.getActivity(paramContext, IntentUtils.getRequestCode(), localIntent, IntentUtils.getImmutablePendingIntentFlags());
      i.d(paramContext, "getActivity(\n           ?tentFlags()\n            )");
      return paramContext;
    }
    
    private final PendingIntent createStoryTraversedPendingIntent(Context paramContext, Bundle paramBundle, int paramInt)
    {
      Intent localIntent = new Intent("com.braze.action.STORY_TRAVERSE").setClass(paramContext, BrazeNotificationUtils.getNotificationReceiverClass());
      i.d(localIntent, "Intent(Constants.BRAZE_S?otificationReceiverClass)");
      if (paramBundle != null)
      {
        paramBundle.putInt("braze_story_index", paramInt);
        localIntent.putExtras(paramBundle);
      }
      paramInt = IntentUtils.getImmutablePendingIntentFlags();
      paramContext = PendingIntent.getBroadcast(paramContext, IntentUtils.getRequestCode(), localIntent, 0x40000000 | paramInt);
      i.d(paramContext, "getBroadcast(\n          ?      flags\n            )");
      return paramContext;
    }
    
    private final boolean isRemoteViewNotificationAvailableSpaceConstrained(Context paramContext)
    {
      return (Build.VERSION.SDK_INT >= 31) && (getApplicationContextgetApplicationInfotargetSdkVersion >= 31);
    }
    
    private final boolean populatePushStoryPage(RemoteViews paramRemoteViews, BrazeNotificationPayload paramBrazeNotificationPayload, BrazeNotificationPayload.PushStoryPage paramPushStoryPage)
    {
      Context localContext = paramBrazeNotificationPayload.getContext();
      int j = 0;
      if (localContext == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, populatePushStoryPage.1.INSTANCE, 3, null);
        return false;
      }
      Object localObject1 = paramBrazeNotificationPayload.getConfigurationProvider();
      if (localObject1 == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, populatePushStoryPage.2.INSTANCE, 3, null);
        return false;
      }
      Object localObject2 = paramPushStoryPage.getBitmapUrl();
      int i;
      if ((localObject2 != null) && (!g.o((CharSequence)localObject2))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, populatePushStoryPage.3.INSTANCE, 3, null);
        return false;
      }
      Bundle localBundle = paramBrazeNotificationPayload.getNotificationExtras();
      localObject2 = Braze.Companion.getInstance(localContext).getImageLoader().getPushBitmapFromUrl(localContext, localBundle, (String)localObject2, BrazeViewBounds.NOTIFICATION_ONE_IMAGE_STORY);
      if (localObject2 == null) {
        return false;
      }
      paramRemoteViews.setImageViewBitmap(R.id.com_braze_story_image_view, (Bitmap)localObject2);
      localObject2 = paramPushStoryPage.getTitle();
      if ((localObject2 != null) && (!g.o((CharSequence)localObject2))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localObject2 = HtmlUtils.getHtmlSpannedTextIfEnabled((String)localObject2, (BrazeConfigurationProvider)localObject1);
        paramRemoteViews.setTextViewText(R.id.com_braze_story_text_view, (CharSequence)localObject2);
        i = paramPushStoryPage.getTitleGravity();
        paramRemoteViews.setInt(R.id.com_braze_story_text_view_container, "setGravity", i);
      }
      else
      {
        paramRemoteViews.setInt(R.id.com_braze_story_text_view_container, "setVisibility", 8);
      }
      localObject2 = paramPushStoryPage.getSubtitle();
      if (localObject2 != null)
      {
        i = j;
        if (!g.o((CharSequence)localObject2)) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0)
      {
        localObject1 = HtmlUtils.getHtmlSpannedTextIfEnabled((String)localObject2, (BrazeConfigurationProvider)localObject1);
        paramRemoteViews.setTextViewText(R.id.com_braze_story_text_view_small, (CharSequence)localObject1);
        i = paramPushStoryPage.getSubtitleGravity();
        paramRemoteViews.setInt(R.id.com_braze_story_text_view_small_container, "setGravity", i);
      }
      else
      {
        paramRemoteViews.setInt(R.id.com_braze_story_text_view_small_container, "setVisibility", 8);
      }
      paramBrazeNotificationPayload = createStoryPageClickedPendingIntent(localContext, paramBrazeNotificationPayload, paramPushStoryPage);
      paramRemoteViews.setOnClickPendingIntent(R.id.com_braze_story_relative_layout, paramBrazeNotificationPayload);
      return true;
    }
    
    public final ExtensionData getBigPictureNotificationStyle(BrazeNotificationPayload paramBrazeNotificationPayload)
    {
      i.e(paramBrazeNotificationPayload, "payload");
      Object localObject5 = paramBrazeNotificationPayload.getContext();
      if (localObject5 == null) {
        return null;
      }
      Object localObject2 = paramBrazeNotificationPayload.getBigImageUrl();
      int i;
      if ((localObject2 != null) && (!g.o((CharSequence)localObject2))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return null;
      }
      Object localObject1 = paramBrazeNotificationPayload.getNotificationExtras();
      Object localObject4 = Braze.Companion.getInstance((Context)localObject5).getImageLoader().getPushBitmapFromUrl((Context)localObject5, (Bundle)localObject1, (String)localObject2, BrazeViewBounds.NOTIFICATION_EXPANDED_IMAGE);
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new j((String)localObject2)
        {
          public final String invoke()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Failed to download image bitmap for big picture notification style. Url: ");
            localStringBuilder.append(BrazeNotificationStyleFactory.Companion.this);
            return localStringBuilder.toString();
          }
        }, 3, null);
        return null;
      }
      try
      {
        i = ((Bitmap)localObject4).getWidth();
        int j = ((Bitmap)localObject4).getHeight();
        localObject2 = localObject1;
        Object localObject3;
        if (i > j)
        {
          int m = BrazeImageUtils.getPixelsFromDensityAndDp(BrazeImageUtils.getDensityDpi((Context)localObject5), 192);
          j = m * 2;
          int k = BrazeImageUtils.getDisplayWidthPixels((Context)localObject5);
          i = j;
          if (j > k) {
            i = k;
          }
          try
          {
            localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject4, i, m, true);
          }
          catch (Exception localException)
          {
            localObject4 = BrazeLogger.INSTANCE;
            localObject5 = BrazeLogger.Priority.this$0;
            j local2 = getBigPictureNotificationStyle.2.INSTANCE;
            ((BrazeLogger)localObject4).brazelog(this, (BrazeLogger.Priority)localObject5, localException, local2);
            localObject3 = localObject1;
          }
        }
        if (localObject3 == null)
        {
          paramBrazeNotificationPayload = BrazeLogger.INSTANCE;
          localObject1 = BrazeLogger.Priority.g;
          localObject3 = getBigPictureNotificationStyle.3.INSTANCE;
          BrazeLogger.brazelog$default(paramBrazeNotificationPayload, this, (BrazeLogger.Priority)localObject1, null, (a)localObject3, 2, null);
          return null;
        }
        localObject1 = new ExtensionData();
        ((ExtensionData)localObject1).a((Bitmap)localObject3);
        setBigPictureSummaryAndTitle((ExtensionData)localObject1, paramBrazeNotificationPayload);
        return localObject1;
      }
      catch (Exception paramBrazeNotificationPayload)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramBrazeNotificationPayload, getBigPictureNotificationStyle.4.INSTANCE);
      }
      return null;
    }
    
    public final Frame getBigTextNotificationStyle(BrazeNotificationPayload paramBrazeNotificationPayload)
    {
      i.e(paramBrazeNotificationPayload, "payload");
      Frame localFrame = new Frame();
      BrazeConfigurationProvider localBrazeConfigurationProvider = paramBrazeNotificationPayload.getConfigurationProvider();
      if (localBrazeConfigurationProvider == null) {
        return localFrame;
      }
      Object localObject = paramBrazeNotificationPayload.getContentText();
      if (localObject != null)
      {
        localObject = HtmlUtils.getHtmlSpannedTextIfEnabled((String)localObject, localBrazeConfigurationProvider);
        if (localObject != null) {
          localFrame.a((CharSequence)localObject);
        }
      }
      localObject = paramBrazeNotificationPayload.getBigSummaryText();
      if (localObject != null) {
        localFrame.init(HtmlUtils.getHtmlSpannedTextIfEnabled((String)localObject, localBrazeConfigurationProvider));
      }
      paramBrazeNotificationPayload = paramBrazeNotificationPayload.getBigTitleText();
      if (paramBrazeNotificationPayload != null) {
        localFrame.b(HtmlUtils.getHtmlSpannedTextIfEnabled(paramBrazeNotificationPayload, localBrazeConfigurationProvider));
      }
      return localFrame;
    }
    
    public final Label getConversationalPushStyle(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
    {
      i.e(paramClassWriter, "notificationBuilder");
      i.e(paramBrazeNotificationPayload, "payload");
      try
      {
        Map localMap = paramBrazeNotificationPayload.getConversationPersonMap();
        Object localObject1 = localMap.get(paramBrazeNotificationPayload.getConversationReplyPersonId());
        localObject1 = (BrazeNotificationPayload.ConversationPerson)localObject1;
        if (localObject1 == null)
        {
          paramClassWriter = BrazeLogger.INSTANCE;
          paramBrazeNotificationPayload = getConversationalPushStyle.1.INSTANCE;
          BrazeLogger.brazelog$default(paramClassWriter, this, null, null, paramBrazeNotificationPayload, 3, null);
          return null;
        }
        localObject1 = new Label(((BrazeNotificationPayload.ConversationPerson)localObject1).getPerson());
        Iterator localIterator = paramBrazeNotificationPayload.getConversationMessages().iterator();
        for (;;)
        {
          bool = localIterator.hasNext();
          if (!bool) {
            break;
          }
          Object localObject2 = localIterator.next();
          localObject2 = (BrazeNotificationPayload.ConversationMessage)localObject2;
          Object localObject3 = localMap.get(((BrazeNotificationPayload.ConversationMessage)localObject2).getPersonId());
          localObject3 = (BrazeNotificationPayload.ConversationPerson)localObject3;
          if (localObject3 == null)
          {
            paramClassWriter = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(paramClassWriter, this, null, null, new j((BrazeNotificationPayload.ConversationMessage)localObject2)
            {
              public final String invoke()
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Message person does not exist in mapping. Not rendering a style. ");
                localStringBuilder.append(BrazeNotificationStyleFactory.Companion.this);
                return localStringBuilder.toString();
              }
            }, 3, null);
            return null;
          }
          ((Label)localObject1).a(((BrazeNotificationPayload.ConversationMessage)localObject2).getMessage(), ((BrazeNotificationPayload.ConversationMessage)localObject2).getTimestamp(), ((BrazeNotificationPayload.ConversationPerson)localObject3).getPerson());
        }
        int i = localMap.size();
        boolean bool = true;
        if (i <= 1) {
          bool = false;
        }
        ((Label)localObject1).a(bool);
        paramClassWriter.visitAnnotation(paramBrazeNotificationPayload.getConversationShortcutId());
        return localObject1;
      }
      catch (Exception paramClassWriter)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramClassWriter, getConversationalPushStyle.3.INSTANCE);
      }
      return null;
    }
    
    public final ByteVector getInlineImageStyle(BrazeNotificationPayload paramBrazeNotificationPayload, ClassWriter paramClassWriter)
    {
      i.e(paramBrazeNotificationPayload, "payload");
      i.e(paramClassWriter, "notificationBuilder");
      Context localContext = paramBrazeNotificationPayload.getContext();
      if (localContext == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, getInlineImageStyle.1.INSTANCE, 3, null);
        return null;
      }
      Object localObject1 = paramBrazeNotificationPayload.getBigImageUrl();
      int i;
      if ((localObject1 != null) && (!g.o((CharSequence)localObject1))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, getInlineImageStyle.2.INSTANCE, 3, null);
        return null;
      }
      Bundle localBundle = paramBrazeNotificationPayload.getNotificationExtras();
      localObject1 = Braze.Companion.getInstance(localContext).getImageLoader().getPushBitmapFromUrl(localContext, localBundle, (String)localObject1, BrazeViewBounds.NOTIFICATION_INLINE_PUSH_IMAGE);
      if (localObject1 == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, getInlineImageStyle.3.INSTANCE, 3, null);
        return null;
      }
      boolean bool = isRemoteViewNotificationAvailableSpaceConstrained(localContext);
      Object localObject2 = localContext.getPackageName();
      if (bool) {
        i = R.layout.com_braze_push_inline_image_constrained;
      } else {
        i = R.layout.com_braze_notification_inline_image;
      }
      localObject2 = new RemoteViews((String)localObject2, i);
      BrazeConfigurationProvider localBrazeConfigurationProvider = new BrazeConfigurationProvider(localContext);
      Object localObject3 = Icon.createWithResource(localContext, localBrazeConfigurationProvider.getSmallNotificationIconResourceId());
      i.d(localObject3, "createWithResource(\n    ?nResourceId\n            )");
      paramBrazeNotificationPayload = paramBrazeNotificationPayload.getAccentColor();
      if (paramBrazeNotificationPayload != null) {
        ((Icon)localObject3).setTint(paramBrazeNotificationPayload.intValue());
      }
      ((RemoteViews)localObject2).setImageViewIcon(R.id.com_braze_inline_image_push_app_icon, (Icon)localObject3);
      localObject3 = localContext.getPackageManager();
      if (Build.VERSION.SDK_INT >= 33) {}
      try
      {
        paramBrazeNotificationPayload = ((PackageManager)localObject3).getApplicationInfo(localContext.getPackageName(), PackageManager.ApplicationInfoFlags.of(0L));
        break label292;
        paramBrazeNotificationPayload = ((PackageManager)localObject3).getApplicationInfo(localContext.getPackageName(), 0);
        label292:
        i.d(paramBrazeNotificationPayload, "{\n                if (Bu?          }\n            }");
        paramBrazeNotificationPayload = HtmlUtils.getHtmlSpannedTextIfEnabled((String)((PackageManager)localObject3).getApplicationLabel(paramBrazeNotificationPayload), localBrazeConfigurationProvider);
        ((RemoteViews)localObject2).setTextViewText(R.id.com_braze_inline_image_push_app_name_text, paramBrazeNotificationPayload);
        ((RemoteViews)localObject2).setTextViewText(R.id.com_braze_inline_image_push_time_text, DateTimeUtils.formatDateNow(BrazeDateFormat.CLOCK_12_HOUR));
        paramBrazeNotificationPayload = localBundle.getString("t");
        if (paramBrazeNotificationPayload != null) {
          ((RemoteViews)localObject2).setTextViewText(R.id.com_braze_inline_image_push_title_text, HtmlUtils.getHtmlSpannedTextIfEnabled(paramBrazeNotificationPayload, localBrazeConfigurationProvider));
        }
        paramBrazeNotificationPayload = localBundle.getString("a");
        if (paramBrazeNotificationPayload != null) {
          ((RemoteViews)localObject2).setTextViewText(R.id.com_braze_inline_image_push_content_text, HtmlUtils.getHtmlSpannedTextIfEnabled(paramBrazeNotificationPayload, localBrazeConfigurationProvider));
        }
        paramClassWriter.visitAnnotation((RemoteViews)localObject2);
        if (bool)
        {
          paramClassWriter.put((Bitmap)localObject1);
          return new ClassReader();
        }
        ((RemoteViews)localObject2).setImageViewBitmap(R.id.com_braze_inline_image_push_side_image, (Bitmap)localObject1);
        return new BrazeNotificationStyleFactory.NoOpSentinelStyle();
      }
      catch (PackageManager.NameNotFoundException paramBrazeNotificationPayload)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramBrazeNotificationPayload, getInlineImageStyle.applicationInfo.1.INSTANCE);
      }
      return null;
    }
    
    public final ByteVector getNotificationStyle(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
    {
      i.e(paramClassWriter, "notificationBuilder");
      i.e(paramBrazeNotificationPayload, "payload");
      if ((paramBrazeNotificationPayload.isPushStory()) && (paramBrazeNotificationPayload.getContext() != null))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, getNotificationStyle.1.INSTANCE, 3, null);
        paramClassWriter = getStoryStyle(paramClassWriter, paramBrazeNotificationPayload);
      }
      else if ((paramBrazeNotificationPayload.isConversationalPush()) && (Build.VERSION.SDK_INT >= 25))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, getNotificationStyle.2.INSTANCE, 3, null);
        paramClassWriter = getConversationalPushStyle(paramClassWriter, paramBrazeNotificationPayload);
      }
      else if (paramBrazeNotificationPayload.getBigImageUrl() != null)
      {
        if ((Build.VERSION.SDK_INT >= 23) && (paramBrazeNotificationPayload.isInlineImagePush()))
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, getNotificationStyle.3.INSTANCE, 3, null);
          paramClassWriter = getInlineImageStyle(paramBrazeNotificationPayload, paramClassWriter);
        }
        else
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, getNotificationStyle.4.INSTANCE, 3, null);
          paramClassWriter = getBigPictureNotificationStyle(paramBrazeNotificationPayload);
        }
      }
      else
      {
        paramClassWriter = null;
      }
      if (paramClassWriter == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, getNotificationStyle.5.INSTANCE, 3, null);
        return getBigTextNotificationStyle(paramBrazeNotificationPayload);
      }
      return paramClassWriter;
    }
    
    public final ClassReader getStoryStyle(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
    {
      i.e(paramClassWriter, "notificationBuilder");
      i.e(paramBrazeNotificationPayload, "payload");
      Object localObject1 = paramBrazeNotificationPayload.getContext();
      if (localObject1 == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, getStoryStyle.1.INSTANCE, 3, null);
        return null;
      }
      Object localObject2 = paramBrazeNotificationPayload.getPushStoryPages();
      int i = paramBrazeNotificationPayload.getPushStoryPageIndex();
      Object localObject3 = (BrazeNotificationPayload.PushStoryPage)((List)localObject2).get(i);
      RemoteViews localRemoteViews = new RemoteViews(((Context)localObject1).getPackageName(), R.layout.com_braze_push_story_one_image);
      if (!populatePushStoryPage(localRemoteViews, paramBrazeNotificationPayload, (BrazeNotificationPayload.PushStoryPage)localObject3))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, getStoryStyle.2.INSTANCE, 2, null);
        return null;
      }
      localObject3 = paramBrazeNotificationPayload.getNotificationExtras();
      paramBrazeNotificationPayload = new ClassReader();
      int j = ((List)localObject2).size();
      localObject2 = createStoryTraversedPendingIntent((Context)localObject1, (Bundle)localObject3, (i - 1 + j) % j);
      localRemoteViews.setOnClickPendingIntent(R.id.com_braze_story_button_previous, (PendingIntent)localObject2);
      localObject1 = createStoryTraversedPendingIntent((Context)localObject1, (Bundle)localObject3, (i + 1) % j);
      localRemoteViews.setOnClickPendingIntent(R.id.com_braze_story_button_next, (PendingIntent)localObject1);
      paramClassWriter.a(localRemoteViews);
      paramClassWriter.put(true);
      return paramBrazeNotificationPayload;
    }
    
    public final void setBigPictureSummaryAndTitle(ExtensionData paramExtensionData, BrazeNotificationPayload paramBrazeNotificationPayload)
    {
      i.e(paramExtensionData, "bigPictureNotificationStyle");
      i.e(paramBrazeNotificationPayload, "payload");
      BrazeConfigurationProvider localBrazeConfigurationProvider = paramBrazeNotificationPayload.getConfigurationProvider();
      if (localBrazeConfigurationProvider == null) {
        return;
      }
      String str1 = paramBrazeNotificationPayload.getBigSummaryText();
      String str2 = paramBrazeNotificationPayload.getBigTitleText();
      String str3 = paramBrazeNotificationPayload.getSummaryText();
      if (str1 != null) {
        paramExtensionData.b(HtmlUtils.getHtmlSpannedTextIfEnabled(str1, localBrazeConfigurationProvider));
      }
      if (str2 != null) {
        paramExtensionData.a(HtmlUtils.getHtmlSpannedTextIfEnabled(str2, localBrazeConfigurationProvider));
      }
      if ((str3 == null) && (str1 == null))
      {
        paramBrazeNotificationPayload = paramBrazeNotificationPayload.getContentText();
        if (paramBrazeNotificationPayload != null) {
          paramExtensionData.b(HtmlUtils.getHtmlSpannedTextIfEnabled(paramBrazeNotificationPayload, localBrazeConfigurationProvider));
        }
      }
    }
    
    public final void setStyleIfSupported(ClassWriter paramClassWriter, BrazeNotificationPayload paramBrazeNotificationPayload)
    {
      i.e(paramClassWriter, "notificationBuilder");
      i.e(paramBrazeNotificationPayload, "payload");
      paramBrazeNotificationPayload = getNotificationStyle(paramClassWriter, paramBrazeNotificationPayload);
      if (!(paramBrazeNotificationPayload instanceof BrazeNotificationStyleFactory.NoOpSentinelStyle))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, setStyleIfSupported.1.INSTANCE, 3, null);
        paramClassWriter.a(paramBrazeNotificationPayload);
      }
    }
  }
  
  private static final class NoOpSentinelStyle
    extends ByteVector
  {
    public NoOpSentinelStyle() {}
  }
}
