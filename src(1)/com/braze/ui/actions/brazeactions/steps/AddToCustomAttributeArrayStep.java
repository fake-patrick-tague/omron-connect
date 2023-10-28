package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.BrazeUser;
import kotlin.t;
import kotlin.x.c.l;
import kotlin.x.d.i;
import kotlin.x.d.j;

public final class AddToCustomAttributeArrayStep
  extends BaseBrazeActionStep
{
  public static final AddToCustomAttributeArrayStep INSTANCE = new AddToCustomAttributeArrayStep();
  
  private AddToCustomAttributeArrayStep()
  {
    super(null);
  }
  
  public boolean isValid(StepData paramStepData)
  {
    i.e(paramStepData, "data");
    return (StepData.isArgCountInBounds$default(paramStepData, 2, null, 2, null)) && (paramStepData.isArgString(0)) && (paramStepData.isArgString(1));
  }
  
  public void storeData(Context paramContext, final StepData paramStepData)
  {
    i.e(paramContext, "context");
    i.e(paramStepData, "data");
    String str = String.valueOf(paramStepData.getFirstArg());
    paramStepData = String.valueOf(paramStepData.getSecondArg());
    BaseBrazeActionStep.Companion.runOnUser$android_sdk_ui_release(Braze.Companion.getInstance(paramContext), new j(str)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.addToCustomAttributeArray(AddToCustomAttributeArrayStep.this, paramStepData);
      }
    });
  }
}
