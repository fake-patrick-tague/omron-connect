package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IResultReceiver
  extends IInterface
{
  public static final String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
  
  public abstract void send(int paramInt, Bundle paramBundle)
    throws RemoteException;
  
  public static class Default
    implements IResultReceiver
  {
    public Default() {}
    
    public IBinder asBinder()
    {
      return null;
    }
    
    public void send(int paramInt, Bundle paramBundle)
      throws RemoteException
    {}
  }
  
  public static abstract class Stub
    extends Binder
    implements IResultReceiver
  {
    static final int TRANSACTION_send = 1;
    
    public Stub()
    {
      attachInterface(this, "android.support.v4.os.IResultReceiver");
    }
    
    public static IResultReceiver asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
      if ((localIInterface != null) && ((localIInterface instanceof IResultReceiver))) {
        return (IResultReceiver)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      if ((paramInt1 >= 1) && (paramInt1 <= 16777215)) {
        paramParcel1.enforceInterface("android.support.v4.os.IResultReceiver");
      }
      if (paramInt1 != 1598968902)
      {
        if (paramInt1 != 1) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        send(paramParcel1.readInt(), (Bundle)IResultReceiver._Parcel.access$000(paramParcel1, Bundle.CREATOR));
        return true;
      }
      paramParcel2.writeString("android.support.v4.os.IResultReceiver");
      return true;
    }
    
    private static class Proxy
      implements IResultReceiver
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "android.support.v4.os.IResultReceiver";
      }
      
      public void send(int paramInt, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.os.IResultReceiver");
          localParcel.writeInt(paramInt);
          IResultReceiver._Parcel.access$100(localParcel, paramBundle, 0);
          mRemote.transact(1, localParcel, null, 1);
          localParcel.recycle();
          return;
        }
        catch (Throwable paramBundle)
        {
          localParcel.recycle();
          throw paramBundle;
        }
      }
    }
  }
  
  public static class _Parcel
  {
    public _Parcel() {}
    
    private static Object readTypedObject(Parcel paramParcel, Parcelable.Creator paramCreator)
    {
      if (paramParcel.readInt() != 0) {
        return paramCreator.createFromParcel(paramParcel);
      }
      return null;
    }
    
    private static void writeTypedObject(Parcel paramParcel, Parcelable paramParcelable, int paramInt)
    {
      if (paramParcelable != null)
      {
        paramParcel.writeInt(1);
        paramParcelable.writeToParcel(paramParcel, paramInt);
        return;
      }
      paramParcel.writeInt(0);
    }
  }
}
