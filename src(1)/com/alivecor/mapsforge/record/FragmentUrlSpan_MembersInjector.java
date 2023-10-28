package com.alivecor.mapsforge.record;

import android.content.Context;
import backup.BackupPreferencesListener;

public final class FragmentUrlSpan_MembersInjector
  implements e.a<com.alivecor.ecg.record.FragmentUrlSpan>
{
  private final g.a.a<Context> contextProvider;
  
  public FragmentUrlSpan_MembersInjector(g.a.a paramA)
  {
    contextProvider = paramA;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA)
  {
    return new FragmentUrlSpan_MembersInjector(paramA);
  }
  
  public static void injectContext(FragmentUrlSpan paramFragmentUrlSpan, Context paramContext)
  {
    context = paramContext;
  }
  
  public void injectMembers(FragmentUrlSpan paramFragmentUrlSpan)
  {
    injectContext(paramFragmentUrlSpan, (Context)contextProvider.get());
  }
}
