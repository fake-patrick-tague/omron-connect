package com.alivecor.mapsforge.record;

import android.content.Context;
import backup.BackupPreferencesListener;
import com.alivecor.ai.p;
import com.alivecor.asm.Attribute;

public final class EcgMonitorViewModel_MembersInjector
  implements e.a<com.alivecor.ecg.record.EcgMonitorViewModel>
{
  private final g.a.a<com.alivecor.ecg.record.AppPreferences> appPreferencesProvider;
  private final g.a.a<Context> applicationContextProvider;
  private final g.a.a<p> ecgEvaluatorProvider;
  
  public EcgMonitorViewModel_MembersInjector(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3)
  {
    applicationContextProvider = paramA1;
    appPreferencesProvider = paramA2;
    ecgEvaluatorProvider = paramA3;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA1, g.a.a paramA2, g.a.a paramA3)
  {
    return new EcgMonitorViewModel_MembersInjector(paramA1, paramA2, paramA3);
  }
  
  public static void injectAppPreferences(EcgMonitorViewModel paramEcgMonitorViewModel, Object paramObject)
  {
    appPreferences = ((AppPreferences)paramObject);
  }
  
  public static void injectApplicationContext(EcgMonitorViewModel paramEcgMonitorViewModel, Context paramContext)
  {
    applicationContext = paramContext;
  }
  
  public static void injectEcgEvaluator(EcgMonitorViewModel paramEcgMonitorViewModel, Attribute paramAttribute)
  {
    ecgEvaluator = paramAttribute;
  }
  
  public void injectMembers(EcgMonitorViewModel paramEcgMonitorViewModel)
  {
    injectApplicationContext(paramEcgMonitorViewModel, (Context)applicationContextProvider.get());
    injectAppPreferences(paramEcgMonitorViewModel, appPreferencesProvider.get());
    injectEcgEvaluator(paramEcgMonitorViewModel, (Attribute)ecgEvaluatorProvider.get());
  }
}
