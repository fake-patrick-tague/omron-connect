package androidx.room;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface c
  extends IInterface
{
  public abstract void a(String[] paramArrayOfString)
    throws RemoteException;
  
  private static class a$a
    implements c
  {
    private IBinder mRemote;
    
    a$a(IBinder paramIBinder)
    {
      mRemote = paramIBinder;
    }
    
    public void a(String[] paramArrayOfString)
      throws RemoteException
    {
      Parcel localParcel = Parcel.obtain();
      try
      {
        localParcel.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
        localParcel.writeStringArray(paramArrayOfString);
        mRemote.transact(1, localParcel, null, 1);
        localParcel.recycle();
        return;
      }
      catch (Throwable paramArrayOfString)
      {
        localParcel.recycle();
        throw paramArrayOfString;
      }
    }
    
    public IBinder asBinder()
    {
      return mRemote;
    }
  }
}
