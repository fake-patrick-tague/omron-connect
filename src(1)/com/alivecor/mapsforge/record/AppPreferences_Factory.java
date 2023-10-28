package com.alivecor.mapsforge.record;

import android.content.Context;
import g.a.a;

public final class AppPreferences_Factory
{
  private final a<Context> contextProvider;
  
  public AppPreferences_Factory(a paramA)
  {
    contextProvider = paramA;
  }
  
  public static AppPreferences_Factory create(a paramA)
  {
    return new AppPreferences_Factory(paramA);
  }
  
  public static AppPreferences newInstance()
  {
    return new AppPreferences();
  }
  
  public AppPreferences get()
  {
    AppPreferences localAppPreferences = newInstance();
    AppPreferences_MembersInjector.injectContext(localAppPreferences, (Context)contextProvider.get());
    return localAppPreferences;
  }
}
