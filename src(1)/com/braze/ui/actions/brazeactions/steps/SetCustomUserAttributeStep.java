package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.BrazeUser;
import com.braze.support.BrazeLogger;
import kotlin.t;
import kotlin.x.c.l;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class SetCustomUserAttributeStep
  extends BaseBrazeActionStep
{
  public static final SetCustomUserAttributeStep INSTANCE;
  private static final String filter;
  
  static
  {
    SetCustomUserAttributeStep localSetCustomUserAttributeStep = new SetCustomUserAttributeStep();
    INSTANCE = localSetCustomUserAttributeStep;
    filter = BrazeLogger.INSTANCE.brazeLogTag(localSetCustomUserAttributeStep);
  }
  
  private SetCustomUserAttributeStep()
  {
    super(null);
  }
  
  public boolean isValid(StepData paramStepData)
  {
    i.e(paramStepData, "data");
    return (StepData.isArgCountInBounds$default(paramStepData, 2, null, 2, null)) && (paramStepData.isArgString(0)) && (paramStepData.getSecondArg() != null);
  }
  
  public void storeData(Context paramContext, StepData paramStepData)
  {
    i.e(paramContext, "context");
    i.e(paramStepData, "data");
    final Object localObject = paramStepData.getSecondArg();
    if (localObject == null) {
      return;
    }
    BaseBrazeActionStep.Companion.runOnUser$android_sdk_ui_release(Braze.Companion.getInstance(paramContext), new j(paramStepData)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        BrazeUser.setCustomAttribute$default(paramAnonymousBrazeUser, String.valueOf(getFirstArg()), localObject, false, 4, null);
      }
    });
  }
}
