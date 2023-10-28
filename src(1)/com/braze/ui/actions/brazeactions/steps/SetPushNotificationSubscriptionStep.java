package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.BrazeUser;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.enums.NotificationSubscriptionType.Companion;
import com.braze.support.BrazeLogger;
import kotlin.t;
import kotlin.x.c.a;
import kotlin.x.c.l;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class SetPushNotificationSubscriptionStep
  extends BaseBrazeActionStep
{
  public static final SetPushNotificationSubscriptionStep INSTANCE;
  private static final String filter;
  
  static
  {
    SetPushNotificationSubscriptionStep localSetPushNotificationSubscriptionStep = new SetPushNotificationSubscriptionStep();
    INSTANCE = localSetPushNotificationSubscriptionStep;
    filter = BrazeLogger.INSTANCE.brazeLogTag(localSetPushNotificationSubscriptionStep);
  }
  
  private SetPushNotificationSubscriptionStep()
  {
    super(null);
  }
  
  public boolean isValid(StepData paramStepData)
  {
    i.e(paramStepData, "data");
    return (StepData.isArgCountInBounds$default(paramStepData, 1, null, 2, null)) && (paramStepData.isArgString(0));
  }
  
  public void storeData(Context paramContext, StepData paramStepData)
  {
    i.e(paramContext, "context");
    i.e(paramStepData, "data");
    NotificationSubscriptionType localNotificationSubscriptionType = NotificationSubscriptionType.Companion.fromValue(String.valueOf(paramStepData.getFirstArg()));
    if (localNotificationSubscriptionType == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new j(paramStepData)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Could not parse subscription type from data ");
          localStringBuilder.append(SetPushNotificationSubscriptionStep.this);
          return localStringBuilder.toString();
        }
      }, 3, null);
      return;
    }
    BaseBrazeActionStep.Companion.runOnUser$android_sdk_ui_release(Braze.Companion.getInstance(paramContext), new j(localNotificationSubscriptionType)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setPushNotificationSubscriptionType(SetPushNotificationSubscriptionStep.this);
      }
    });
  }
}
