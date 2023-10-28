package com.alivecor.mapsforge.record;

import backup.BackupPreferencesListener;

public final class MicPermissionErrorFragment_MembersInjector
  implements e.a<com.alivecor.ecg.record.MicPermissionErrorFragment>
{
  private final g.a.a<com.alivecor.ecg.record.AppPreferences> appPreferencesProvider;
  
  public MicPermissionErrorFragment_MembersInjector(g.a.a paramA)
  {
    appPreferencesProvider = paramA;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA)
  {
    return new MicPermissionErrorFragment_MembersInjector(paramA);
  }
  
  public static void injectAppPreferences(MicPermissionErrorFragment paramMicPermissionErrorFragment, Object paramObject)
  {
    appPreferences = ((AppPreferences)paramObject);
  }
  
  public void injectMembers(MicPermissionErrorFragment paramMicPermissionErrorFragment)
  {
    injectAppPreferences(paramMicPermissionErrorFragment, appPreferencesProvider.get());
  }
}
