package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IPostMessageService
  extends IInterface
{
  public abstract void onMessageChannelReady(ICustomTabsCallback paramICustomTabsCallback, Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onPostMessage(ICustomTabsCallback paramICustomTabsCallback, String paramString, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IPostMessageService
  {
    private static final String DESCRIPTOR = "android.support.customtabs.IPostMessageService";
    static final int TRANSACTION_onMessageChannelReady = 2;
    static final int TRANSACTION_onPostMessage = 3;
    
    public Stub()
    {
      attachInterface(this, "android.support.customtabs.IPostMessageService");
    }
    
    public static IPostMessageService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.customtabs.IPostMessageService");
      if ((localIInterface != null) && ((localIInterface instanceof IPostMessageService))) {
        return (IPostMessageService)localIInterface;
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
      ICustomTabsCallback localICustomTabsCallback = null;
      Object localObject1 = null;
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 1598968902) {
            return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
          }
          paramParcel2.writeString("android.support.customtabs.IPostMessageService");
          return true;
        }
        paramParcel1.enforceInterface("android.support.customtabs.IPostMessageService");
        localICustomTabsCallback = ICustomTabsCallback.Stub.asInterface(paramParcel1.readStrongBinder());
        localObject2 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        onPostMessage(localICustomTabsCallback, (String)localObject2, (Bundle)localObject1);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("android.support.customtabs.IPostMessageService");
      Object localObject2 = ICustomTabsCallback.Stub.asInterface(paramParcel1.readStrongBinder());
      localObject1 = localICustomTabsCallback;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      onMessageChannelReady((ICustomTabsCallback)localObject2, (Bundle)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements IPostMessageService
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
        return "android.support.customtabs.IPostMessageService";
      }
      
      public void onMessageChannelReady(ICustomTabsCallback paramICustomTabsCallback, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("android.support.customtabs.IPostMessageService");
          if (paramICustomTabsCallback != null) {
            paramICustomTabsCallback = paramICustomTabsCallback.asBinder();
          } else {
            paramICustomTabsCallback = null;
          }
          localParcel1.writeStrongBinder(paramICustomTabsCallback);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
          mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          localParcel2.recycle();
          localParcel1.recycle();
          return;
        }
        catch (Throwable paramICustomTabsCallback)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          throw paramICustomTabsCallback;
        }
      }
      
      public void onPostMessage(ICustomTabsCallback paramICustomTabsCallback, String paramString, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("android.support.customtabs.IPostMessageService");
          if (paramICustomTabsCallback != null) {
            paramICustomTabsCallback = paramICustomTabsCallback.asBinder();
          } else {
            paramICustomTabsCallback = null;
          }
          localParcel1.writeStrongBinder(paramICustomTabsCallback);
          localParcel1.writeString(paramString);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
          mRemote.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          localParcel2.recycle();
          localParcel1.recycle();
          return;
        }
        catch (Throwable paramICustomTabsCallback)
        {
          localParcel2.recycle();
          localParcel1.recycle();
          throw paramICustomTabsCallback;
        }
      }
    }
  }
}
