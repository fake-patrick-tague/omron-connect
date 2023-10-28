package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface INotificationSideChannel
  extends IInterface
{
  public static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
  
  public abstract void cancel(String paramString1, int paramInt, String paramString2)
    throws RemoteException;
  
  public abstract void cancelAll(String paramString)
    throws RemoteException;
  
  public abstract void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
    throws RemoteException;
  
  public static class Default
    implements INotificationSideChannel
  {
    public Default() {}
    
    public IBinder asBinder()
    {
      return null;
    }
    
    public void cancel(String paramString1, int paramInt, String paramString2)
      throws RemoteException
    {}
    
    public void cancelAll(String paramString)
      throws RemoteException
    {}
    
    public void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
      throws RemoteException
    {}
  }
  
  public static abstract class Stub
    extends Binder
    implements INotificationSideChannel
  {
    static final int TRANSACTION_cancel = 2;
    static final int TRANSACTION_cancelAll = 3;
    static final int TRANSACTION_notify = 1;
    
    public Stub()
    {
      attachInterface(this, "android.support.v4.app.INotificationSideChannel");
    }
    
    public static INotificationSideChannel asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
      if ((localIInterface != null) && ((localIInterface instanceof INotificationSideChannel))) {
        return (INotificationSideChannel)localIInterface;
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
        paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
      }
      if (paramInt1 != 1598968902)
      {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3) {
              return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            }
            cancelAll(paramParcel1.readString());
            return true;
          }
          cancel(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
          return true;
        }
        notify(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString(), (Notification)INotificationSideChannel._Parcel.access$000(paramParcel1, Notification.CREATOR));
        return true;
      }
      paramParcel2.writeString("android.support.v4.app.INotificationSideChannel");
      return true;
    }
    
    private static class Proxy
      implements INotificationSideChannel
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
      
      public void cancel(String paramString1, int paramInt, String paramString2)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString1);
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString2);
          mRemote.transact(2, localParcel, null, 1);
          localParcel.recycle();
          return;
        }
        catch (Throwable paramString1)
        {
          localParcel.recycle();
          throw paramString1;
        }
      }
      
      public void cancelAll(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString);
          mRemote.transact(3, localParcel, null, 1);
          localParcel.recycle();
          return;
        }
        catch (Throwable paramString)
        {
          localParcel.recycle();
          throw paramString;
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "android.support.v4.app.INotificationSideChannel";
      }
      
      public void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
          localParcel.writeString(paramString1);
          localParcel.writeInt(paramInt);
          localParcel.writeString(paramString2);
          INotificationSideChannel._Parcel.access$100(localParcel, paramNotification, 0);
          mRemote.transact(1, localParcel, null, 1);
          localParcel.recycle();
          return;
        }
        catch (Throwable paramString1)
        {
          localParcel.recycle();
          throw paramString1;
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
