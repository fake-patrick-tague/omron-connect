package com.alivecor.mapsforge.record;

import com.alivecor.ecg.record.AppPreferences;
import g.a.a;

public final class Util_Factory
{
  private final a<AppPreferences> appPreferencesProvider;
  
  public Util_Factory(a paramA)
  {
    appPreferencesProvider = paramA;
  }
  
  public static Util_Factory create(a paramA)
  {
    return new Util_Factory(paramA);
  }
  
  public static Util newInstance()
  {
    return new Util();
  }
  
  public Util get()
  {
    Util localUtil = newInstance();
    Util_MembersInjector.injectAppPreferences(localUtil, appPreferencesProvider.get());
    return localUtil;
  }
}
