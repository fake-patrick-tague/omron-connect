package com.alivecor.mapsforge.record;

import android.content.Context;
import backup.BackupPreferencesListener;

public final class AppPreferences_MembersInjector
  implements e.a<com.alivecor.ecg.record.AppPreferences>
{
  private final g.a.a<Context> contextProvider;
  
  public AppPreferences_MembersInjector(g.a.a paramA)
  {
    contextProvider = paramA;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA)
  {
    return new AppPreferences_MembersInjector(paramA);
  }
  
  public static void injectContext(Object paramObject, Context paramContext)
  {
    context = paramContext;
  }
  
  public void injectMembers(AppPreferences paramAppPreferences)
  {
    injectContext(paramAppPreferences, (Context)contextProvider.get());
  }
}
