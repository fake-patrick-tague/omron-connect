package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.IDeathCallback_0_8;
import java.util.Iterator;
import java.util.List;

final class Collector
  implements SensorEventDispatcher
{
  private final IDeathCallback_0_8 zzrt;
  
  Collector(IDeathCallback_0_8 paramIDeathCallback_0_8)
  {
    zzrt = ((IDeathCallback_0_8)Preconditions.checkNotNull(paramIDeathCallback_0_8));
  }
  
  public final void publish(DataPoint paramDataPoint)
    throws RemoteException
  {
    paramDataPoint.next();
    zzrt.openDB(paramDataPoint);
  }
  
  public final void publish(List paramList)
    throws RemoteException
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      publish((DataPoint)paramList.next());
    }
  }
}
