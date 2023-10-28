package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class Board
{
  private final Messenger selection;
  private final Element selectionArgs;
  
  Board(IBinder paramIBinder)
    throws RemoteException
  {
    String str = paramIBinder.getInterfaceDescriptor();
    if ("android.os.IMessenger".equals(str))
    {
      selection = new Messenger(paramIBinder);
      selectionArgs = null;
      return;
    }
    if ("com.google.android.gms.iid.IMessengerCompat".equals(str))
    {
      selectionArgs = new Element(paramIBinder);
      selection = null;
      return;
    }
    paramIBinder = String.valueOf(str);
    if (paramIBinder.length() != 0) {
      paramIBinder = "Invalid interface descriptor: ".concat(paramIBinder);
    } else {
      paramIBinder = new String("Invalid interface descriptor: ");
    }
    Log.w("MessengerIpcClient", paramIBinder);
    throw new RemoteException();
  }
  
  final void next(Message paramMessage)
    throws RemoteException
  {
    Object localObject = selection;
    if (localObject != null)
    {
      ((Messenger)localObject).send(paramMessage);
      return;
    }
    localObject = selectionArgs;
    if (localObject != null)
    {
      ((Element)localObject).add(paramMessage);
      return;
    }
    throw new IllegalStateException("Both messengers are null");
  }
}
