package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import java.util.concurrent.TimeUnit;

public final class zzeb
  implements SessionsApi
{
  public zzeb() {}
  
  public final PendingResult insertSession(GoogleApiClient paramGoogleApiClient, SessionInsertRequest paramSessionInsertRequest)
  {
    return paramGoogleApiClient.enqueue(new zzec(this, paramGoogleApiClient, paramSessionInsertRequest));
  }
  
  public final PendingResult readSession(GoogleApiClient paramGoogleApiClient, SessionReadRequest paramSessionReadRequest)
  {
    return paramGoogleApiClient.enqueue(new zzef(this, paramGoogleApiClient, paramSessionReadRequest));
  }
  
  public final PendingResult registerForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzee(this, paramGoogleApiClient, paramPendingIntent));
  }
  
  public final PendingResult startSession(GoogleApiClient paramGoogleApiClient, Session paramSession)
  {
    Preconditions.checkNotNull(paramSession, "Session cannot be null");
    boolean bool;
    if (paramSession.getEndTime(TimeUnit.MILLISECONDS) == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Cannot start a session which has already ended");
    return paramGoogleApiClient.execute(new zzea(this, paramGoogleApiClient, paramSession));
  }
  
  public final PendingResult stopSession(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.execute(new zzed(this, paramGoogleApiClient, null, paramString));
  }
  
  public final PendingResult unregisterForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzeh(this, paramGoogleApiClient, paramPendingIntent));
  }
}
