package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import com.braze.Braze.Companion;
import kotlin.x.d.i;
import kotlin.z.c;

public final class LogCustomEventStep
  extends BaseBrazeActionStep
{
  public static final LogCustomEventStep INSTANCE = new LogCustomEventStep();
  
  private LogCustomEventStep()
  {
    super(null);
  }
  
  public boolean isValid(StepData paramStepData)
  {
    i.e(paramStepData, "data");
    return (StepData.isArgCountInBounds$default(paramStepData, 0, new c(1, 2), 1, null)) && (paramStepData.isArgString(0)) && (paramStepData.isArgOptionalJsonObject(1));
  }
  
  public void storeData(Context paramContext, StepData paramStepData)
  {
    i.e(paramContext, "context");
    i.e(paramStepData, "data");
    Braze.Companion.getInstance(paramContext).logCustomEvent(String.valueOf(paramStepData.getFirstArg()), paramStepData.coerceArgToPropertiesOrNull(1));
  }
}
