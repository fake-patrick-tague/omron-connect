package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;

public abstract interface IBrazeActionStep
{
  public abstract boolean isValid(StepData paramStepData);
  
  public abstract void storeData(Context paramContext, StepData paramStepData);
}
