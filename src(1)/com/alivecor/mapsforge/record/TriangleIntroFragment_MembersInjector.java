package com.alivecor.mapsforge.record;

import backup.BackupPreferencesListener;

public final class TriangleIntroFragment_MembersInjector
  implements e.a<com.alivecor.ecg.record.TriangleIntroFragment>
{
  private final g.a.a<com.alivecor.ecg.record.AppPreferences> appPreferencesProvider;
  
  public TriangleIntroFragment_MembersInjector(g.a.a paramA)
  {
    appPreferencesProvider = paramA;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA)
  {
    return new TriangleIntroFragment_MembersInjector(paramA);
  }
  
  public static void injectAppPreferences(TriangleIntroFragment paramTriangleIntroFragment, Object paramObject)
  {
    appPreferences = ((AppPreferences)paramObject);
  }
  
  public void injectMembers(TriangleIntroFragment paramTriangleIntroFragment)
  {
    injectAppPreferences(paramTriangleIntroFragment, appPreferencesProvider.get());
  }
}
