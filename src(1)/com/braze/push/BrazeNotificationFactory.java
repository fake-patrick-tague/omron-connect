package com.braze.push;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import androidx.core.package_10.ClassWriter;
import com.braze.IBrazeNotificationFactory;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public class BrazeNotificationFactory
  implements IBrazeNotificationFactory
{
  public static final Companion Companion = new Companion(null);
  private static final BrazeNotificationFactory internalInstance = new BrazeNotificationFactory();
  
  public BrazeNotificationFactory() {}
  
  public Notification createNotification(BrazeNotificationPayload paramBrazeNotificationPayload)
  {
    i.e(paramBrazeNotificationPayload, "payload");
    paramBrazeNotificationPayload = Companion.populateNotificationBuilder(paramBrazeNotificationPayload);
    if (paramBrazeNotificationPayload != null) {
      return paramBrazeNotificationPayload.get();
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, createNotification.1.INSTANCE, 2, null);
    return null;
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    public final BrazeNotificationFactory getInstance()
    {
      return BrazeNotificationFactory.access$getInternalInstance$cp();
    }
    
    public final ClassWriter populateNotificationBuilder(BrazeNotificationPayload paramBrazeNotificationPayload)
    {
      i.e(paramBrazeNotificationPayload, "payload");
      Object localObject = BrazeLogger.INSTANCE;
      BrazeLogger.brazelog$default((BrazeLogger)localObject, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new j(paramBrazeNotificationPayload)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Using BrazeNotificationPayload: ");
          localStringBuilder.append(BrazeNotificationFactory.Companion.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      Context localContext = paramBrazeNotificationPayload.getContext();
      if (localContext == null)
      {
        BrazeLogger.brazelog$default((BrazeLogger)localObject, this, null, null, populateNotificationBuilder.2.INSTANCE, 3, null);
        return null;
      }
      BrazeConfigurationProvider localBrazeConfigurationProvider = paramBrazeNotificationPayload.getConfigurationProvider();
      if (localBrazeConfigurationProvider == null)
      {
        BrazeLogger.brazelog$default((BrazeLogger)localObject, this, null, null, populateNotificationBuilder.3.INSTANCE, 3, null);
        return null;
      }
      localObject = paramBrazeNotificationPayload.getNotificationExtras();
      BrazeNotificationUtils.prefetchBitmapsIfNewlyReceivedStoryPush(paramBrazeNotificationPayload);
      ClassWriter localClassWriter = new ClassWriter(localContext, BrazeNotificationUtils.getOrCreateNotificationChannelId(paramBrazeNotificationPayload)).a(true);
      i.d(localClassWriter, "Builder(context, notific?     .setAutoCancel(true)");
      BrazeNotificationUtils.setTitleIfPresent(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setContentIfPresent(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setTickerIfPresent(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setSetShowWhen(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setContentIntentIfPresent(localContext, localClassWriter, (Bundle)localObject);
      BrazeNotificationUtils.setDeleteIntent(localContext, localClassWriter, (Bundle)localObject);
      BrazeNotificationUtils.setSmallIcon(localBrazeConfigurationProvider, localClassWriter);
      BrazeNotificationUtils.setLargeIconIfPresentAndSupported(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setSoundIfPresentAndSupported(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setSummaryTextIfPresentAndSupported(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setPriorityIfPresentAndSupported(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationStyleFactory.Companion.setStyleIfSupported(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationActionUtils.addNotificationActions(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setAccentColorIfPresentAndSupported(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setCategoryIfPresentAndSupported(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setVisibilityIfPresentAndSupported(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setPublicVersionIfPresentAndSupported(localClassWriter, paramBrazeNotificationPayload);
      BrazeNotificationUtils.setNotificationBadgeNumberIfPresent(localClassWriter, paramBrazeNotificationPayload);
      return localClassWriter;
    }
  }
}
