package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;

class TwilightManager
{
  private static TwilightManager mLocation;
  private final Context mContext;
  private final LocationManager mLocationManager;
  private final TwilightState sTwilightState = new TwilightState();
  
  TwilightManager(Context paramContext, LocationManager paramLocationManager)
  {
    mContext = paramContext;
    mLocationManager = paramLocationManager;
  }
  
  private Location getLastKnownLocation()
  {
    int i = PermissionChecker.checkSelfPermission(mContext, "android.permission.ACCESS_COARSE_LOCATION");
    Location localLocation2 = null;
    Location localLocation1;
    if (i == 0) {
      localLocation1 = getLastKnownLocationForProvider("network");
    } else {
      localLocation1 = null;
    }
    if (PermissionChecker.checkSelfPermission(mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
      localLocation2 = getLastKnownLocationForProvider("gps");
    }
    if ((localLocation2 != null) && (localLocation1 != null))
    {
      if (localLocation2.getTime() > localLocation1.getTime()) {
        return localLocation2;
      }
    }
    else if (localLocation2 != null) {
      return localLocation2;
    }
    return localLocation1;
  }
  
  static TwilightManager getLastKnownLocation(Context paramContext)
  {
    if (mLocation == null)
    {
      paramContext = paramContext.getApplicationContext();
      mLocation = new TwilightManager(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    return mLocation;
  }
  
  private Location getLastKnownLocationForProvider(String paramString)
  {
    LocationManager localLocationManager = mLocationManager;
    try
    {
      boolean bool = localLocationManager.isProviderEnabled(paramString);
      if (bool)
      {
        localLocationManager = mLocationManager;
        paramString = localLocationManager.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.d("TwilightManager", "Failed to get last known location", paramString);
    }
    return null;
  }
  
  private boolean isStateValid()
  {
    return sTwilightState.nextUpdate > System.currentTimeMillis();
  }
  
  private void updateState(Location paramLocation)
  {
    TwilightState localTwilightState = sTwilightState;
    long l1 = System.currentTimeMillis();
    TwilightCalculator localTwilightCalculator = TwilightCalculator.getInstance();
    localTwilightCalculator.calculateTwilight(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    localTwilightCalculator.calculateTwilight(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    int i = state;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    long l2 = sunrise;
    long l3 = sunset;
    localTwilightCalculator.calculateTwilight(l1 + 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l4 = sunrise;
    if ((l2 != -1L) && (l3 != -1L))
    {
      if (l1 > l3) {
        l1 = l4 + 0L;
      } else if (l1 > l2) {
        l1 = l3 + 0L;
      } else {
        l1 = l2 + 0L;
      }
      l1 += 60000L;
    }
    else
    {
      l1 = 43200000L + l1;
    }
    isNight = bool;
    nextUpdate = l1;
  }
  
  boolean isNight()
  {
    TwilightState localTwilightState = sTwilightState;
    if (isStateValid()) {
      return isNight;
    }
    Location localLocation = getLastKnownLocation();
    if (localLocation != null)
    {
      updateState(localLocation);
      return isNight;
    }
    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  class TwilightState
  {
    boolean isNight;
    long nextUpdate;
    
    TwilightState() {}
  }
}
