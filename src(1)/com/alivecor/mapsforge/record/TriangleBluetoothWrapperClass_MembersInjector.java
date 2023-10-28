package com.alivecor.mapsforge.record;

import android.content.Context;
import backup.BackupPreferencesListener;

public final class TriangleBluetoothWrapperClass_MembersInjector
  implements e.a<com.alivecor.ecg.record.TriangleBluetoothWrapperClass>
{
  private final g.a.a<Context> applicationContextProvider;
  
  public TriangleBluetoothWrapperClass_MembersInjector(g.a.a paramA)
  {
    applicationContextProvider = paramA;
  }
  
  public static BackupPreferencesListener create(g.a.a paramA)
  {
    return new TriangleBluetoothWrapperClass_MembersInjector(paramA);
  }
  
  public static void injectApplicationContext(TriangleBluetoothWrapperClass paramTriangleBluetoothWrapperClass, Context paramContext)
  {
    applicationContext = paramContext;
  }
  
  public void injectMembers(TriangleBluetoothWrapperClass paramTriangleBluetoothWrapperClass)
  {
    injectApplicationContext(paramTriangleBluetoothWrapperClass, (Context)applicationContextProvider.get());
  }
}
