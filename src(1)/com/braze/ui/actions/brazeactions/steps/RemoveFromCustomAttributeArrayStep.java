package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.BrazeUser;
import kotlin.t;
import kotlin.x.c.l;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class RemoveFromCustomAttributeArrayStep
  extends BaseBrazeActionStep
{
  public static final RemoveFromCustomAttributeArrayStep INSTANCE = new RemoveFromCustomAttributeArrayStep();
  
  private RemoveFromCustomAttributeArrayStep()
  {
    super(null);
  }
  
  public boolean isValid(StepData paramStepData)
  {
    i.e(paramStepData, "data");
    return (StepData.isArgCountInBounds$default(paramStepData, 2, null, 2, null)) && (paramStepData.isArgString(0)) && (paramStepData.isArgString(1));
  }
  
  public void storeData(Context paramContext, StepData paramStepData)
  {
    i.e(paramContext, "context");
    i.e(paramStepData, "data");
    BaseBrazeActionStep.Companion.runOnUser$android_sdk_ui_release(Braze.Companion.getInstance(paramContext), new j(paramStepData)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.removeFromCustomAttributeArray(String.valueOf(getFirstArg()), String.valueOf(getSecondArg()));
      }
    });
  }
}
