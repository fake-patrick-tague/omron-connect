package com.google.android.gms.fitness;

import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.request.GoalsReadRequest;

@Deprecated
public abstract interface GoalsApi
{
  public abstract PendingResult readCurrentGoals(GoogleApiClient paramGoogleApiClient, GoalsReadRequest paramGoalsReadRequest);
}
