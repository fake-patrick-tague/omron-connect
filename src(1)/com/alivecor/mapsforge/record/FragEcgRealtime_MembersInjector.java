package com.alivecor.mapsforge.record;

import backup.BackupPreferencesListener;

public final class FragEcgRealtime_MembersInjector
  implements e.a<com.alivecor.ecg.record.FragEcgRealtime>
{
  private final g.a.a<com.alivecor.ecg.record.AppPreferences> appPreferencesProvider;
  
  public FragEcgRealtime_MembersInjector(g.a.a paramA)
  {
    appPreferencesProvider = paramA;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA)
  {
    return new FragEcgRealtime_MembersInjector(paramA);
  }
  
  public static void injectAppPreferences(Object paramObject1, Object paramObject2)
  {
    appPreferences = ((AppPreferences)paramObject2);
  }
  
  public void injectMembers(FragEcgRealtime paramFragEcgRealtime)
  {
    injectAppPreferences(paramFragEcgRealtime, appPreferencesProvider.get());
  }
}
