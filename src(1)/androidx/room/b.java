package androidx.room;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface b
  extends IInterface
{
  public abstract int a(c paramC, String paramString)
    throws RemoteException;
  
  public abstract void a(int paramInt, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void a(c paramC, int paramInt)
    throws RemoteException;
}
