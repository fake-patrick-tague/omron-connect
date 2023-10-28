package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import androidx.work.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class Collection
{
  private static final String id = Log.getInstance("WakeLocks");
  private static final WeakHashMap<PowerManager.WakeLock, String> values = new WeakHashMap();
  
  public static PowerManager.WakeLock add(Context paramContext, String paramString)
  {
    paramContext = (PowerManager)paramContext.getApplicationContext().getSystemService("power");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WorkManager: ");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = paramContext.newWakeLock(1, paramString);
    paramContext = values;
    try
    {
      paramContext.put(localObject, paramString);
      return localObject;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public static void save()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = values;
    try
    {
      localHashMap.putAll((Map)localObject1);
      localObject1 = localHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (PowerManager.WakeLock)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((PowerManager.WakeLock)localObject2).isHeld()))
        {
          localObject2 = String.format("WakeLock held for %s", new Object[] { localHashMap.get(localObject2) });
          Log.get().add(id, (String)localObject2, new Throwable[0]);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
