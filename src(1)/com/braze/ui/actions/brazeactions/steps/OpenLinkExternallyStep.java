package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler.Companion;
import kotlin.x.d.i;
import kotlin.z.c;

public final class OpenLinkExternallyStep
  extends BaseBrazeActionStep
{
  public static final OpenLinkExternallyStep INSTANCE = new OpenLinkExternallyStep();
  
  private OpenLinkExternallyStep()
  {
    super(null);
  }
  
  public boolean isValid(StepData paramStepData)
  {
    i.e(paramStepData, "data");
    return (StepData.isArgCountInBounds$default(paramStepData, 0, new c(1, 2), 1, null)) && (paramStepData.isArgString(0));
  }
  
  public void storeData(Context paramContext, StepData paramStepData)
  {
    i.e(paramContext, "context");
    i.e(paramStepData, "data");
    String str = String.valueOf(paramStepData.getFirstArg());
    IBrazeDeeplinkHandler localIBrazeDeeplinkHandler = BrazeDeeplinkHandler.Companion.getInstance();
    paramStepData = localIBrazeDeeplinkHandler.createUriActionFromUrlString(str, null, false, paramStepData.getChannel());
    if (paramStepData != null) {
      localIBrazeDeeplinkHandler.gotoUri(paramContext, paramStepData);
    }
  }
}
