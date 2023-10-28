package com.alivecor.mapsforge.record;

import com.alivecor.asm.c;

public abstract interface RecordDependencyComponent
{
  public abstract c classifyRunner();
  
  public abstract void inject(AppPreferences paramAppPreferences);
  
  public abstract void inject(EcgMonitorViewModel paramEcgMonitorViewModel);
  
  public abstract void inject(FragEcgRealtime paramFragEcgRealtime);
  
  public abstract void inject(FragEcgResults paramFragEcgResults);
  
  public abstract void inject(MicPermissionErrorFragment paramMicPermissionErrorFragment);
  
  public abstract void inject(TriangleBluetoothWrapperClass paramTriangleBluetoothWrapperClass);
  
  public abstract void inject(TriangleIntroFragment paramTriangleIntroFragment);
  
  public abstract void inject(Util paramUtil);
}
