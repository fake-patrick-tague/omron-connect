package com.alivecor.mapsforge.record;

import backup.BackupPreferencesListener;

public final class NfcErrorFragment_MembersInjector
  implements e.a<com.alivecor.ecg.record.NfcErrorFragment>
{
  private final g.a.a<com.alivecor.ecg.record.AppPreferences> appPreferencesProvider;
  
  public NfcErrorFragment_MembersInjector(g.a.a paramA)
  {
    appPreferencesProvider = paramA;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA)
  {
    return new NfcErrorFragment_MembersInjector(paramA);
  }
  
  public static void injectAppPreferences(NfcErrorFragment paramNfcErrorFragment, Object paramObject)
  {
    appPreferences = ((AppPreferences)paramObject);
  }
  
  public void injectMembers(NfcErrorFragment paramNfcErrorFragment)
  {
    injectAppPreferences(paramNfcErrorFragment, appPreferencesProvider.get());
  }
}
