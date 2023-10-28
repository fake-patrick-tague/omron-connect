package com.braze.models;

import kotlin.x.d.i;
import org.json.JSONObject;

public final class BrazeGeofence
  implements IPutIntoJson<JSONObject>, Comparable<BrazeGeofence>
{
  public static final a Companion = new a(null);
  private final boolean analyticsEnabledEnter;
  private final boolean analyticsEnabledExit;
  private final int cooldownEnterSeconds;
  private final int cooldownExitSeconds;
  private double distanceFromGeofenceRefresh;
  private final boolean enterEvents;
  private final boolean exitEvents;
  private final String id;
  private final JSONObject jsonObject;
  private final double latitude;
  private final double longitude;
  private final int notificationResponsivenessMs;
  private final int radiusMeter;
  
  public BrazeGeofence(JSONObject paramJSONObject)
  {
    this(paramJSONObject, str, paramJSONObject.getDouble("latitude"), paramJSONObject.getDouble("longitude"), paramJSONObject.getInt("radius"), paramJSONObject.getInt("cooldown_enter"), paramJSONObject.getInt("cooldown_exit"), paramJSONObject.getBoolean("analytics_enabled_enter"), paramJSONObject.getBoolean("analytics_enabled_exit"), paramJSONObject.optBoolean("enter_events", true), paramJSONObject.optBoolean("exit_events", true), paramJSONObject.optInt("notification_responsiveness", 30000));
  }
  
  public BrazeGeofence(JSONObject paramJSONObject, String paramString, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt4)
  {
    jsonObject = paramJSONObject;
    id = paramString;
    latitude = paramDouble1;
    longitude = paramDouble2;
    radiusMeter = paramInt1;
    cooldownEnterSeconds = paramInt2;
    cooldownExitSeconds = paramInt3;
    analyticsEnabledEnter = paramBoolean1;
    analyticsEnabledExit = paramBoolean2;
    enterEvents = paramBoolean3;
    exitEvents = paramBoolean4;
    notificationResponsivenessMs = paramInt4;
    distanceFromGeofenceRefresh = -1.0D;
  }
  
  public int compareTo(BrazeGeofence paramBrazeGeofence)
  {
    i.e(paramBrazeGeofence, "other");
    double d = distanceFromGeofenceRefresh;
    int i;
    if (d == -1.0D) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return 1;
    }
    if (d < distanceFromGeofenceRefresh) {
      return -1;
    }
    return 1;
  }
  
  public JSONObject forJsonPut()
  {
    return jsonObject;
  }
  
  public final String getId()
  {
    return id;
  }
  
  public final double getLatitude()
  {
    return latitude;
  }
  
  public final double getLongitude()
  {
    return longitude;
  }
  
  public final void setDistanceFromGeofenceRefresh(double paramDouble)
  {
    distanceFromGeofenceRefresh = paramDouble;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BrazeGeofence{id=");
    localStringBuilder.append(id);
    localStringBuilder.append(", latitude=");
    localStringBuilder.append(latitude);
    localStringBuilder.append(", longitude=");
    localStringBuilder.append(longitude);
    localStringBuilder.append(", radiusMeters=");
    localStringBuilder.append(radiusMeter);
    localStringBuilder.append(", cooldownEnterSeconds=");
    localStringBuilder.append(cooldownEnterSeconds);
    localStringBuilder.append(", cooldownExitSeconds=");
    localStringBuilder.append(cooldownExitSeconds);
    localStringBuilder.append(", analyticsEnabledEnter=");
    localStringBuilder.append(analyticsEnabledEnter);
    localStringBuilder.append(", analyticsEnabledExit=");
    localStringBuilder.append(analyticsEnabledExit);
    localStringBuilder.append(", enterEvents=");
    localStringBuilder.append(enterEvents);
    localStringBuilder.append(", exitEvents=");
    localStringBuilder.append(exitEvents);
    localStringBuilder.append(", notificationResponsivenessMs=");
    localStringBuilder.append(notificationResponsivenessMs);
    localStringBuilder.append(", distanceFromGeofenceRefresh=");
    localStringBuilder.append(distanceFromGeofenceRefresh);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    private a() {}
  }
}
