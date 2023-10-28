package com.alivecor.mapsforge.core;

import android.content.Context;
import com.alivecor.ecg.core.model.a;

public abstract class EcgBackend<Ecg extends a>
{
  private Context mAppContext;
  
  public EcgBackend(Context paramContext)
  {
    mAppContext = paramContext.getApplicationContext();
  }
  
  final Context getAppContext()
  {
    return mAppContext;
  }
  
  public abstract EcgRepository getRepository();
}
