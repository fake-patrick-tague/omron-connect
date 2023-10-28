package com.alivecor.mapsforge.record;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.mapsforge.core.model.c;
import l.a.a;

class AppPreferences
{
  private static final String OPTION_DEVICE_LEAD_CONFIG = "device_lead_config";
  private static final String OPTION_EKG_DEBUG_CLASSIFIER = "recording_classifier";
  private static final String OPTION_SELECTED_EKG_DEVICE = "selected_ekg_device";
  private static final String OPTION_SELECTED_TRIANGLE_DEVICE = "selected_triangle_device_address";
  static final String VALUE_CLASSIFIER_ALGSUITE = "AlgSuite";
  private static final String VALUE_CLASSIFIER_DEFAULT = "Default";
  private static final String VALUE_SELECTED_EKG_DEVICE_UNSPECIFIED = c.b.name();
  Context context;
  
  public AppPreferences()
  {
    RecordEkgConfig.getDB().getRecordDependencyComponent().inject(this);
  }
  
  private SharedPreferences getSharedPreferences()
  {
    return PreferenceManager.getDefaultSharedPreferences(context);
  }
  
  void clearSelectedEkgDevice()
  {
    getSharedPreferences().edit().remove("selected_ekg_device").apply();
    getSharedPreferences().edit().remove("selected_triangle_device_address").apply();
  }
  
  Direction getDeviceLead(c paramC)
  {
    int i = 1.$SwitchMap$com$alivecor$ecg$core$model$RecordingDevice[paramC.ordinal()];
    SharedPreferences localSharedPreferences;
    Object localObject;
    if (i != 1)
    {
      if ((i != 2) && (i != 3) && (i != 4) && (i != 5)) {
        return Direction.S;
      }
      localSharedPreferences = getSharedPreferences();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("device_lead_config");
      ((StringBuilder)localObject).append(paramC.name());
      localObject = ((StringBuilder)localObject).toString();
    }
    for (paramC = Direction.S;; paramC = Direction.W)
    {
      return Direction.getRandom(localSharedPreferences.getInt((String)localObject, paramC.ordinal()));
      localSharedPreferences = getSharedPreferences();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("device_lead_config");
      ((StringBuilder)localObject).append(paramC.name());
      localObject = ((StringBuilder)localObject).toString();
    }
  }
  
  String getEKGClassifier()
  {
    return getSharedPreferences().getString("Default", "recording_classifier");
  }
  
  String getOptionSelectedTriangleDevice()
  {
    return getSharedPreferences().getString("selected_triangle_device_address", null);
  }
  
  c getSelectedEkgDeviceDebug()
  {
    String str = getSharedPreferences().getString("selected_ekg_device", VALUE_SELECTED_EKG_DEVICE_UNSPECIFIED);
    a.a("leads device %s", new Object[] { str });
    try
    {
      c localC = c.a(str);
      return localC;
    }
    catch (Exception localException)
    {
      a.i(localException, "Unrecognized selected device: %s.  Returning UNSPECIFIED", new Object[] { str });
    }
    return c.b;
  }
  
  boolean isSixLeadSupported(c paramC, Direction paramDirection)
  {
    if (paramDirection == Direction.W)
    {
      int i = 1.$SwitchMap$com$alivecor$ecg$core$model$RecordingDevice[paramC.ordinal()];
      if ((i != 1) && (i != 3)) {
        return false;
      }
    }
    return true;
  }
  
  void setDeviceLead(c paramC, Direction paramDirection)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("device_lead_config");
    localStringBuilder.append(paramC.name());
    localEditor.putInt(localStringBuilder.toString(), paramDirection.ordinal()).apply();
  }
  
  void setOptionSelectedTriangleDevice(String paramString)
  {
    getSharedPreferences().edit().putString("selected_triangle_device_address", paramString).apply();
  }
  
  void setSelectedEkgDeviceDebug(c paramC)
  {
    getSharedPreferences().edit().putString("selected_ekg_device", paramC.a()).apply();
  }
}
