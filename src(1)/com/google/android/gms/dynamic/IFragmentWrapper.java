package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.IExtensionHost.Stub;
import com.google.android.gms.internal.common.JSONObject;

public abstract interface IFragmentWrapper
  extends IInterface
{
  public abstract IFragmentWrapper call()
    throws RemoteException;
  
  public abstract IObjectWrapper exec()
    throws RemoteException;
  
  public abstract IFragmentWrapper get()
    throws RemoteException;
  
  public abstract Bundle getArguments()
    throws RemoteException;
  
  public abstract boolean getBoolean()
    throws RemoteException;
  
  public abstract int getId()
    throws RemoteException;
  
  public abstract String getTag()
    throws RemoteException;
  
  public abstract int getType()
    throws RemoteException;
  
  public abstract boolean goTo()
    throws RemoteException;
  
  public abstract void init(boolean paramBoolean)
    throws RemoteException;
  
  public abstract IObjectWrapper invoke()
    throws RemoteException;
  
  public abstract void invoke(Intent paramIntent)
    throws RemoteException;
  
  public abstract void invoke(Intent paramIntent, int paramInt)
    throws RemoteException;
  
  public abstract void invoke(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
  
  public abstract void invoke(boolean paramBoolean)
    throws RemoteException;
  
  public abstract boolean isAdded()
    throws RemoteException;
  
  public abstract boolean isAlive()
    throws RemoteException;
  
  public abstract boolean isEnabled()
    throws RemoteException;
  
  public abstract boolean isVisible()
    throws RemoteException;
  
  public abstract IObjectWrapper loadData()
    throws RemoteException;
  
  public abstract void register(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
  
  public abstract void setFragment(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setTitle(boolean paramBoolean)
    throws RemoteException;
  
  public abstract boolean setTitle()
    throws RemoteException;
  
  public abstract boolean showLoadingDialog()
    throws RemoteException;
  
  public abstract boolean update()
    throws RemoteException;
  
  public static abstract class Stub
    extends IExtensionHost.Stub
    implements IFragmentWrapper
  {
    public Stub()
    {
      super();
    }
    
    public static IFragmentWrapper asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      if ((localIInterface instanceof IFragmentWrapper)) {
        return (IFragmentWrapper)localIInterface;
      }
      return new ActionMenuItem(paramIBinder);
    }
    
    protected final boolean execute(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return false;
      case 27: 
        localObject = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
        JSONObject.writeValue(paramParcel1);
        invoke((IObjectWrapper)localObject);
        paramParcel2.writeNoException();
        break;
      case 26: 
        localObject = (Intent)JSONObject.get(paramParcel1, Intent.CREATOR);
        paramInt1 = paramParcel1.readInt();
        JSONObject.writeValue(paramParcel1);
        invoke((Intent)localObject, paramInt1);
        paramParcel2.writeNoException();
        break;
      case 25: 
        localObject = (Intent)JSONObject.get(paramParcel1, Intent.CREATOR);
        JSONObject.writeValue(paramParcel1);
        invoke((Intent)localObject);
        paramParcel2.writeNoException();
        break;
      case 24: 
        bool = JSONObject.get(paramParcel1);
        JSONObject.writeValue(paramParcel1);
        setTitle(bool);
        paramParcel2.writeNoException();
        break;
      case 23: 
        bool = JSONObject.get(paramParcel1);
        JSONObject.writeValue(paramParcel1);
        invoke(bool);
        paramParcel2.writeNoException();
        break;
      case 22: 
        bool = JSONObject.get(paramParcel1);
        JSONObject.writeValue(paramParcel1);
        setFragment(bool);
        paramParcel2.writeNoException();
        break;
      case 21: 
        bool = JSONObject.get(paramParcel1);
        JSONObject.writeValue(paramParcel1);
        init(bool);
        paramParcel2.writeNoException();
        break;
      case 20: 
        localObject = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
        JSONObject.writeValue(paramParcel1);
        register((IObjectWrapper)localObject);
        paramParcel2.writeNoException();
        break;
      case 19: 
        bool = isVisible();
        paramParcel2.writeNoException();
        JSONObject.append(paramParcel2, bool);
        break;
      case 18: 
        bool = goTo();
        paramParcel2.writeNoException();
        JSONObject.append(paramParcel2, bool);
        break;
      case 17: 
        bool = showLoadingDialog();
        paramParcel2.writeNoException();
        JSONObject.append(paramParcel2, bool);
        break;
      case 16: 
        bool = isEnabled();
        paramParcel2.writeNoException();
        JSONObject.append(paramParcel2, bool);
        break;
      case 15: 
        bool = getBoolean();
        paramParcel2.writeNoException();
        JSONObject.append(paramParcel2, bool);
        break;
      case 14: 
        bool = isAlive();
        paramParcel2.writeNoException();
        JSONObject.append(paramParcel2, bool);
        break;
      case 13: 
        bool = isAdded();
        paramParcel2.writeNoException();
        JSONObject.append(paramParcel2, bool);
        break;
      case 12: 
        paramParcel1 = invoke();
        paramParcel2.writeNoException();
        JSONObject.get(paramParcel2, paramParcel1);
        break;
      case 11: 
        bool = update();
        paramParcel2.writeNoException();
        JSONObject.append(paramParcel2, bool);
        break;
      case 10: 
        paramInt1 = getType();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        break;
      case 9: 
        paramParcel1 = get();
        paramParcel2.writeNoException();
        JSONObject.get(paramParcel2, paramParcel1);
        break;
      case 8: 
        paramParcel1 = getTag();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        break;
      case 7: 
        bool = setTitle();
        paramParcel2.writeNoException();
        JSONObject.append(paramParcel2, bool);
        break;
      case 6: 
        paramParcel1 = loadData();
        paramParcel2.writeNoException();
        JSONObject.get(paramParcel2, paramParcel1);
        break;
      case 5: 
        paramParcel1 = call();
        paramParcel2.writeNoException();
        JSONObject.get(paramParcel2, paramParcel1);
        break;
      case 4: 
        paramInt1 = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        break;
      case 3: 
        paramParcel1 = getArguments();
        paramParcel2.writeNoException();
        JSONObject.writeValue(paramParcel2, paramParcel1);
        break;
      case 2: 
        paramParcel1 = exec();
        paramParcel2.writeNoException();
        JSONObject.get(paramParcel2, paramParcel1);
      }
      return true;
    }
  }
}
