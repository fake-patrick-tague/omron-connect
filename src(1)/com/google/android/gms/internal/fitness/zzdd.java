package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.GoalsApi;
import com.google.android.gms.fitness.request.GoalsReadRequest;

public final class zzdd
  implements GoalsApi
{
  public zzdd() {}
  
  public final PendingResult readCurrentGoals(GoogleApiClient paramGoogleApiClient, GoalsReadRequest paramGoalsReadRequest)
  {
    return paramGoogleApiClient.enqueue(new zzdc(this, paramGoogleApiClient, paramGoalsReadRequest));
  }
}
