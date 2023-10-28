package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.ui.actions.brazeactions.BrazeActionParser;
import java.util.Iterator;
import java.util.Objects;
import kotlin.x.c.l;
import kotlin.x.d.i;
import kotlin.x.d.j;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ContainerStep
  extends BaseBrazeActionStep
{
  public static final ContainerStep INSTANCE = new ContainerStep();
  
  private ContainerStep()
  {
    super(null);
  }
  
  public boolean isValid(StepData paramStepData)
  {
    i.e(paramStepData, "data");
    return paramStepData.getSrcJson().has("steps");
  }
  
  public void storeData(Context paramContext, StepData paramStepData)
  {
    i.e(paramContext, "context");
    i.e(paramStepData, "data");
    Iterator localIterator = getChildStepIterator$android_sdk_ui_release(paramStepData);
    while (localIterator.hasNext())
    {
      JSONObject localJSONObject = (JSONObject)localIterator.next();
      BrazeActionParser.INSTANCE.parse$android_sdk_ui_release(paramContext, StepData.copy$default(paramStepData, localJSONObject, null, 2, null));
    }
  }
}
