package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;

public class MultiInstanceInvalidationService
  extends Service
{
  final HashMap<Integer, String> c = new HashMap();
  int d = 0;
  private final IPlayMedia_0_8.Stub mBinder = new b();
  final RemoteCallbackList<c> r = new a();
  
  public MultiInstanceInvalidationService() {}
  
  public IBinder onBind(Intent paramIntent)
  {
    return mBinder;
  }
  
  class a
    extends RemoteCallbackList<c>
  {
    a() {}
    
    public void a(c paramC, Object paramObject)
    {
      c.remove(Integer.valueOf(((Integer)paramObject).intValue()));
    }
  }
  
  class b
    extends IPlayMedia_0_8.Stub
  {
    b() {}
    
    public int a(c paramC, String paramString)
    {
      if (paramString == null) {
        return 0;
      }
      RemoteCallbackList localRemoteCallbackList = r;
      try
      {
        MultiInstanceInvalidationService localMultiInstanceInvalidationService = MultiInstanceInvalidationService.this;
        int i = d + 1;
        d = i;
        if (r.register(paramC, Integer.valueOf(i)))
        {
          c.put(Integer.valueOf(i), paramString);
          return i;
        }
        paramC = MultiInstanceInvalidationService.this;
        d -= 1;
        return 0;
      }
      catch (Throwable paramC)
      {
        throw paramC;
      }
    }
    
    public void a(int paramInt, String[] paramArrayOfString)
    {
      RemoteCallbackList localRemoteCallbackList = r;
      try
      {
        String str = (String)c.get(Integer.valueOf(paramInt));
        if (str == null)
        {
          Log.w("ROOM", "Remote invalidation client ID not registered");
          return;
        }
        int j = r.beginBroadcast();
        int i = 0;
        while (i < j) {
          try
          {
            int k = ((Integer)r.getBroadcastCookie(i)).intValue();
            Object localObject = (String)c.get(Integer.valueOf(k));
            if (paramInt != k)
            {
              boolean bool = str.equals(localObject);
              if (bool)
              {
                localObject = r;
                try
                {
                  localObject = ((RemoteCallbackList)localObject).getBroadcastItem(i);
                  localObject = (c)localObject;
                  ((c)localObject).a(paramArrayOfString);
                }
                catch (RemoteException localRemoteException)
                {
                  Log.w("ROOM", "Error invoking a remote callback", localRemoteException);
                }
              }
            }
            i += 1;
          }
          catch (Throwable paramArrayOfString)
          {
            r.finishBroadcast();
            throw paramArrayOfString;
          }
        }
        r.finishBroadcast();
        return;
      }
      catch (Throwable paramArrayOfString)
      {
        throw paramArrayOfString;
      }
    }
    
    public void a(c paramC, int paramInt)
    {
      RemoteCallbackList localRemoteCallbackList = r;
      try
      {
        r.unregister(paramC);
        c.remove(Integer.valueOf(paramInt));
        return;
      }
      catch (Throwable paramC)
      {
        throw paramC;
      }
    }
  }
}
