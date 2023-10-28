package androidx.work.impl;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Type
{
  private static final String b = Log.getInstance("WrkDbPathHelper");
  private static final String[] c = { "-journal", "-shm", "-wal" };
  
  private static File a(Context paramContext, String paramString)
  {
    return new File(paramContext.getNoBackupFilesDir(), paramString);
  }
  
  public static void a(Context paramContext)
  {
    Object localObject = get(paramContext);
    if ((Build.VERSION.SDK_INT >= 23) && (((File)localObject).exists()))
    {
      Log.get().append(b, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
      localObject = create(paramContext);
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        paramContext = (File)localIterator.next();
        File localFile = (File)((Map)localObject).get(paramContext);
        if ((paramContext.exists()) && (localFile != null))
        {
          if (localFile.exists())
          {
            String str = String.format("Over-writing contents of %s", new Object[] { localFile });
            Log.get().add(b, str, new Throwable[0]);
          }
          if (paramContext.renameTo(localFile)) {
            paramContext = String.format("Migrated %s to %s", new Object[] { paramContext, localFile });
          } else {
            paramContext = String.format("Renaming %s to %s failed", new Object[] { paramContext, localFile });
          }
          Log.get().append(b, paramContext, new Throwable[0]);
        }
      }
    }
  }
  
  public static Map create(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    if (Build.VERSION.SDK_INT >= 23)
    {
      File localFile = get(paramContext);
      paramContext = getType(paramContext);
      localHashMap.put(localFile, paramContext);
      String[] arrayOfString = c;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localFile.getPath());
        ((StringBuilder)localObject).append(str);
        localObject = new File(((StringBuilder)localObject).toString());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getPath());
        localStringBuilder.append(str);
        localHashMap.put(localObject, new File(localStringBuilder.toString()));
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static File get(Context paramContext)
  {
    return paramContext.getDatabasePath("androidx.work.workdb");
  }
  
  public static String getDescriptor()
  {
    return "androidx.work.workdb";
  }
  
  public static File getType(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return get(paramContext);
    }
    return a(paramContext, "androidx.work.workdb");
  }
}
