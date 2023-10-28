package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler.Companion;
import kotlin.x.d.i;

public final class OpenLinkInWebViewStep
  extends BaseBrazeActionStep
{
  public static final OpenLinkInWebViewStep INSTANCE = new OpenLinkInWebViewStep();
  
  private OpenLinkInWebViewStep()
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
    String str = String.valueOf(paramStepData.getFirstArg());
    IBrazeDeeplinkHandler localIBrazeDeeplinkHandler = BrazeDeeplinkHandler.Companion.getInstance();
    paramStepData = localIBrazeDeeplinkHandler.createUriActionFromUrlString(str, null, true, paramStepData.getChannel());
    if (paramStepData != null) {
      localIBrazeDeeplinkHandler.gotoUri(paramContext, paramStepData);
    }
  }
}
