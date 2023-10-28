package com.braze.location;

import android.app.PendingIntent;
import android.content.Context;
import java.util.List;

public abstract interface IBrazeGeofenceApi
{
  public abstract PendingIntent getGeofenceTransitionPendingIntent(Context paramContext);
  
  public abstract void registerGeofences(Context paramContext, List paramList, PendingIntent paramPendingIntent);
  
  public abstract void teardownGeofences(Context paramContext, PendingIntent paramPendingIntent);
}
