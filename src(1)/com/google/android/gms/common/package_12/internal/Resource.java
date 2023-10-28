package com.google.android.gms.common.package_12.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.package_12.Status;

public abstract class Resource
{
  public final int size;
  
  public Resource(int paramInt)
  {
    size = paramInt;
  }
  
  public abstract void get(zaad paramZaad, boolean paramBoolean);
  
  public abstract void get(Exception paramException);
  
  public abstract void put(Status paramStatus);
  
  public abstract void put(zabq paramZabq)
    throws DeadObjectException;
}
