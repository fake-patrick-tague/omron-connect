package com.alivecor.mapsforge.record;

import backup.BackupPreferencesListener;

public final class FragEcgResults_MembersInjector
  implements e.a<com.alivecor.ecg.record.FragEcgResults>
{
  private final g.a.a<com.alivecor.ecg.record.AppPreferences> appPreferencesProvider;
  
  public FragEcgResults_MembersInjector(g.a.a paramA)
  {
    appPreferencesProvider = paramA;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA)
  {
    return new FragEcgResults_MembersInjector(paramA);
  }
  
  public static void injectAppPreferences(Object paramObject1, Object paramObject2)
  {
    appPreferences = ((AppPreferences)paramObject2);
  }
  
  public void injectMembers(FragEcgResults paramFragEcgResults)
  {
    injectAppPreferences(paramFragEcgResults, appPreferencesProvider.get());
  }
}
