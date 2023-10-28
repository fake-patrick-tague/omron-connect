package com.alivecor.mapsforge.record;

import backup.BackupPreferencesListener;

public final class Util_MembersInjector
  implements e.a<com.alivecor.ecg.record.Util>
{
  private final g.a.a<com.alivecor.ecg.record.AppPreferences> appPreferencesProvider;
  
  public Util_MembersInjector(g.a.a paramA)
  {
    appPreferencesProvider = paramA;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA)
  {
    return new Util_MembersInjector(paramA);
  }
  
  public static void injectAppPreferences(Util paramUtil, Object paramObject)
  {
    appPreferences = ((AppPreferences)paramObject);
  }
  
  public void injectMembers(Util paramUtil)
  {
    injectAppPreferences(paramUtil, appPreferencesProvider.get());
  }
}
