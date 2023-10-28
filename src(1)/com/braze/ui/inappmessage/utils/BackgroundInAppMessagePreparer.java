package com.braze.ui.inappmessage.utils;

import android.content.Context;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazeViewBounds;
import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.enums.inappmessage.MessageType;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.inappmessage.IInAppMessageWithImage;
import com.braze.models.inappmessage.IInAppMessageZippedAssetHtml;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.WebContentUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.BrazeInAppMessageManager.Companion;
import com.braze.ui.inappmessage.InAppMessageManagerBase;
import java.io.File;
import java.util.Map;
import kotlin.n;
import kotlin.t;
import kotlin.text.g;
import kotlin.w.d;
import kotlin.w.i.a.f;
import kotlin.w.i.a.l;
import kotlin.x.c.p;
import kotlin.x.d.i;
import kotlin.x.d.j;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;

public final class BackgroundInAppMessagePreparer
{
  public static final BackgroundInAppMessagePreparer INSTANCE = new BackgroundInAppMessagePreparer();
  
  private BackgroundInAppMessagePreparer() {}
  
  private final Object displayPreparedInAppMessage(final IInAppMessage paramIInAppMessage, d paramD)
  {
    paramIInAppMessage = h.g(b1.c(), new l(paramIInAppMessage, null)
    {
      int label;
      
      public final d create(Object paramAnonymousObject, d paramAnonymousD)
      {
        return (d)new 2(BackgroundInAppMessagePreparer.this, paramIInAppMessage, paramAnonymousD);
      }
      
      public final Object invoke(m0 paramAnonymousM0, d paramAnonymousD)
      {
        return ((2)create(paramAnonymousM0, paramAnonymousD)).invokeSuspend(t.a);
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        kotlin.coroutines.intrinsics.a.c();
        if (label == 0)
        {
          n.b(paramAnonymousObject);
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, BackgroundInAppMessagePreparer.this, null, null, 1.INSTANCE, 3, null);
          BrazeInAppMessageManager.Companion.getInstance().displayInAppMessage(paramIInAppMessage, false);
          return t.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }, paramD);
    if (paramIInAppMessage == kotlin.coroutines.intrinsics.a.c()) {
      return paramIInAppMessage;
    }
    return t.a;
  }
  
  private final BrazeViewBounds getViewBoundsByType(IInAppMessage paramIInAppMessage)
  {
    paramIInAppMessage = paramIInAppMessage.getMessageType();
    int i = WhenMappings.$EnumSwitchMapping$0[paramIInAppMessage.ordinal()];
    if (i != 3)
    {
      if (i != 4) {
        return BrazeViewBounds.NO_BOUNDS;
      }
      return BrazeViewBounds.IN_APP_MESSAGE_MODAL;
    }
    return BrazeViewBounds.IN_APP_MESSAGE_SLIDEUP;
  }
  
  private final boolean handleLocalImage(String paramString, IInAppMessageWithImage paramIInAppMessageWithImage, IBrazeImageLoader paramIBrazeImageLoader, Context paramContext, IInAppMessage paramIInAppMessage, BrazeViewBounds paramBrazeViewBounds)
  {
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.g, null, new j(paramString)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Passing in-app message local image url to image loader: ");
        localStringBuilder.append(BackgroundInAppMessagePreparer.this);
        return localStringBuilder.toString();
      }
    }, 2, null);
    paramIInAppMessageWithImage.setBitmap(paramIBrazeImageLoader.getInAppMessageBitmapFromUrl(paramContext, paramIInAppMessage, paramString, paramBrazeViewBounds));
    if (paramIInAppMessageWithImage.getBitmap() != null)
    {
      paramIInAppMessageWithImage.setImageDownloadSuccessful(true);
      return true;
    }
    BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, new j(paramString)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Removing local image url from IAM since it could not be loaded. URL: ");
        localStringBuilder.append(BackgroundInAppMessagePreparer.this);
        return localStringBuilder.toString();
      }
    }, 3, null);
    paramIInAppMessageWithImage.setLocalImageUrl(null);
    return false;
  }
  
  private final IInAppMessage prepareInAppMessage(IInAppMessage paramIInAppMessage)
  {
    if (paramIInAppMessage.isControl())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, prepareInAppMessage.1.INSTANCE, 3, null);
      return paramIInAppMessage;
    }
    BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
    BrazeLogger.brazelog$default(localBrazeLogger, this, null, null, prepareInAppMessage.2.INSTANCE, 3, null);
    MessageType localMessageType = paramIInAppMessage.getMessageType();
    int i = WhenMappings.$EnumSwitchMapping$0[localMessageType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (!prepareInAppMessageWithBitmapDownload(paramIInAppMessage))
        {
          BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.PREPARED, null, prepareInAppMessage.4.INSTANCE, 2, null);
          paramIInAppMessage.logDisplayFailure(InAppMessageFailureType.IMAGE_DOWNLOAD);
          return null;
        }
        return paramIInAppMessage;
      }
      prepareInAppMessageWithHtml((InAppMessageHtml)paramIInAppMessage);
      return paramIInAppMessage;
    }
    if (!prepareInAppMessageWithZippedAssetHtml((IInAppMessageZippedAssetHtml)paramIInAppMessage))
    {
      BrazeLogger.brazelog$default(localBrazeLogger, this, BrazeLogger.Priority.PREPARED, null, prepareInAppMessage.3.INSTANCE, 2, null);
      paramIInAppMessage.logDisplayFailure(InAppMessageFailureType.ZIP_ASSET_DOWNLOAD);
      return null;
    }
    return paramIInAppMessage;
  }
  
  public static final void prepareInAppMessageForDisplay(IInAppMessage paramIInAppMessage)
  {
    i.e(paramIInAppMessage, "inAppMessageToPrepare");
    h.d(BrazeCoroutineScope.INSTANCE, null, null, new l(paramIInAppMessage, null)
    {
      int label;
      
      public final d create(Object paramAnonymousObject, d paramAnonymousD)
      {
        paramAnonymousD = new 1(BackgroundInAppMessagePreparer.this, paramAnonymousD);
        activity = paramAnonymousObject;
        return (d)paramAnonymousD;
      }
      
      public final Object invoke(m0 paramAnonymousM0, d paramAnonymousD)
      {
        return ((1)create(paramAnonymousM0, paramAnonymousD)).invokeSuspend(t.a);
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        Object localObject1 = kotlin.coroutines.intrinsics.a.c();
        int i = label;
        if (i != 0)
        {
          if (i == 1)
          {
            localObject1 = (m0)activity;
            try
            {
              n.b(paramAnonymousObject);
            }
            catch (Exception localException2)
            {
              paramAnonymousObject = localObject1;
              localObject1 = localException2;
              break label155;
            }
          }
          else
          {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          }
        }
        else
        {
          n.b(paramAnonymousObject);
          paramAnonymousObject = (m0)activity;
          Object localObject2 = BackgroundInAppMessagePreparer.INSTANCE;
          Object localObject3 = BackgroundInAppMessagePreparer.this;
          try
          {
            localObject3 = BackgroundInAppMessagePreparer.access$prepareInAppMessage((BackgroundInAppMessagePreparer)localObject2, (IInAppMessage)localObject3);
            if (localObject3 == null)
            {
              localObject1 = BrazeLogger.INSTANCE;
              localObject2 = BrazeLogger.Priority.PREPARED;
              localObject3 = 1.INSTANCE;
              BrazeLogger.brazelog$default((BrazeLogger)localObject1, paramAnonymousObject, (BrazeLogger.Priority)localObject2, null, (kotlin.x.c.a)localObject3, 2, null);
              break label169;
            }
            activity = paramAnonymousObject;
            label = 1;
            d localD = (d)this;
            localObject2 = BackgroundInAppMessagePreparer.access$displayPreparedInAppMessage((BackgroundInAppMessagePreparer)localObject2, (IInAppMessage)localObject3, localD);
            if (localObject2 != localObject1) {
              break label169;
            }
            return localObject1;
          }
          catch (Exception localException1) {}
        }
        label155:
        BrazeLogger.INSTANCE.brazelog(paramAnonymousObject, BrazeLogger.Priority.this$0, localException1, 2.INSTANCE);
        label169:
        return t.a;
      }
    }, 3, null);
  }
  
  public static final boolean prepareInAppMessageWithBitmapDownload(IInAppMessage paramIInAppMessage)
  {
    if (!(paramIInAppMessage instanceof IInAppMessageWithImage))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, prepareInAppMessageWithBitmapDownload.1.INSTANCE, 3, null);
      return false;
    }
    IInAppMessageWithImage localIInAppMessageWithImage = (IInAppMessageWithImage)paramIInAppMessage;
    if (localIInAppMessageWithImage.getBitmap() != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.g, null, prepareInAppMessageWithBitmapDownload.2.INSTANCE, 2, null);
      localIInAppMessageWithImage.setImageDownloadSuccessful(true);
      return true;
    }
    BackgroundInAppMessagePreparer localBackgroundInAppMessagePreparer = INSTANCE;
    Object localObject = localBackgroundInAppMessagePreparer.getViewBoundsByType(paramIInAppMessage);
    Context localContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext();
    if (localContext == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, localBackgroundInAppMessagePreparer, BrazeLogger.Priority.PREPARED, null, prepareInAppMessageWithBitmapDownload.3.INSTANCE, 2, null);
      return false;
    }
    IBrazeImageLoader localIBrazeImageLoader = Braze.Companion.getInstance(localContext).getImageLoader();
    String str = localIInAppMessageWithImage.getLocalImageUrl();
    int i;
    if ((str != null) && (!g.o(str))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (localBackgroundInAppMessagePreparer.handleLocalImage(str, localIInAppMessageWithImage, localIBrazeImageLoader, localContext, paramIInAppMessage, (BrazeViewBounds)localObject))) {
      return true;
    }
    str = localIInAppMessageWithImage.getRemoteImageUrl();
    if ((str != null) && (!g.o(str))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, localBackgroundInAppMessagePreparer, BrazeLogger.Priority.g, null, new j(str)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("In-app message has remote image url. Downloading image at url: ");
          localStringBuilder.append(BackgroundInAppMessagePreparer.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      localIInAppMessageWithImage.setBitmap(localIBrazeImageLoader.getInAppMessageBitmapFromUrl(localContext, paramIInAppMessage, str, (BrazeViewBounds)localObject));
      if (localIInAppMessageWithImage.getBitmap() != null)
      {
        localIInAppMessageWithImage.setImageDownloadSuccessful(true);
        return true;
      }
      return false;
    }
    paramIInAppMessage = BrazeLogger.INSTANCE;
    localObject = BrazeLogger.Priority.PREPARED;
    BrazeLogger.brazelog$default(paramIInAppMessage, localBackgroundInAppMessagePreparer, (BrazeLogger.Priority)localObject, null, prepareInAppMessageWithBitmapDownload.5.INSTANCE, 2, null);
    if ((localIInAppMessageWithImage instanceof InAppMessageFull))
    {
      BrazeLogger.brazelog$default(paramIInAppMessage, localBackgroundInAppMessagePreparer, (BrazeLogger.Priority)localObject, null, prepareInAppMessageWithBitmapDownload.6.INSTANCE, 2, null);
      return false;
    }
    return true;
  }
  
  public static final boolean prepareInAppMessageWithZippedAssetHtml(IInAppMessageZippedAssetHtml paramIInAppMessageZippedAssetHtml)
  {
    i.e(paramIInAppMessageZippedAssetHtml, "inAppMessageHtml");
    final String str = paramIInAppMessageZippedAssetHtml.getLocalAssetsDirectoryUrl();
    int i;
    if ((str != null) && (!g.o(str))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (new File(str).exists()))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.g, null, new j(str)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Local assets for html in-app message are already populated. Not downloading assets. Location = ");
          localStringBuilder.append(BackgroundInAppMessagePreparer.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return true;
    }
    str = paramIInAppMessageZippedAssetHtml.getAssetsZipRemoteUrl();
    if ((str != null) && (!g.o(str))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.g, null, prepareInAppMessageWithZippedAssetHtml.2.INSTANCE, 2, null);
      return true;
    }
    Context localContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext();
    if (localContext == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, prepareInAppMessageWithZippedAssetHtml.3.INSTANCE, 2, null);
      return false;
    }
    str = WebContentUtils.getLocalHtmlUrlFromRemoteUrl(WebContentUtils.getHtmlInAppMessageAssetCacheDirectory(localContext), str);
    if ((str != null) && (!g.o(str))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, null, null, new j(str)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Local url for html in-app message assets is ");
          localStringBuilder.append(BackgroundInAppMessagePreparer.this);
          return localStringBuilder.toString();
        }
      }, 3, null);
      paramIInAppMessageZippedAssetHtml.setLocalAssetsDirectoryUrl(str);
      return true;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, new j(paramIInAppMessageZippedAssetHtml)
    {
      public final String invoke()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Download of html content to local directory failed for remote url: ");
        localStringBuilder.append(getAssetsZipRemoteUrl());
        localStringBuilder.append(" . Returned local url is: ");
        localStringBuilder.append(str);
        return localStringBuilder.toString();
      }
    }, 2, null);
    return false;
  }
  
  public final void prepareInAppMessageWithHtml(InAppMessageHtml paramInAppMessageHtml)
  {
    i.e(paramInAppMessageHtml, "inAppMessage");
    if (paramInAppMessageHtml.getLocalPrefetchedAssetPaths().isEmpty())
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, prepareInAppMessageWithHtml.1.INSTANCE, 3, null);
      return;
    }
    String str = paramInAppMessageHtml.getMessage();
    if (str == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, prepareInAppMessageWithHtml.2.INSTANCE, 3, null);
      return;
    }
    paramInAppMessageHtml.setMessage(WebContentUtils.replacePrefetchedUrlsWithLocalAssets(str, paramInAppMessageHtml.getLocalPrefetchedAssetPaths()));
  }
}
