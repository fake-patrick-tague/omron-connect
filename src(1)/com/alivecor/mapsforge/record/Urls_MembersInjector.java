package com.alivecor.mapsforge.record;

import backup.BackupPreferencesListener;

public final class Urls_MembersInjector
  implements e.a<com.alivecor.ecg.record.Urls>
{
  private final g.a.a<com.alivecor.ecg.record.Util> utilProvider;
  
  public Urls_MembersInjector(g.a.a paramA)
  {
    utilProvider = paramA;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA)
  {
    return new Urls_MembersInjector(paramA);
  }
  
  public static void injectUtil(Urls paramUrls, Util paramUtil)
  {
    util = paramUtil;
  }
  
  public void injectMembers(Urls paramUrls)
  {
    injectUtil(paramUrls, (Util)utilProvider.get());
  }
}
