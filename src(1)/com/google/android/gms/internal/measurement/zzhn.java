package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import v7.util.SimpleArrayMap;

public final class zzhn
{
  private static volatile zzif data;
  
  private zzhn() {}
  
  public static zzif doInBackground(Context paramContext)
  {
    try
    {
      Object localObject2 = data;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = Build.TYPE;
        localObject2 = Build.TAGS;
        if (((!((String)localObject1).equals("eng")) && (!((String)localObject1).equals("userdebug"))) || ((!((String)localObject2).contains("dev-keys")) && (!((String)localObject2).contains("test-keys"))))
        {
          paramContext = zzif.decode();
          break label584;
        }
        localObject1 = paramContext;
        if (zzha.hasExternalCacheDir())
        {
          localObject1 = paramContext;
          if (!paramContext.isDeviceProtectedStorage()) {
            localObject1 = paramContext.createDeviceProtectedStorageContext();
          }
        }
        StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
        try
        {
          StrictMode.allowThreadDiskWrites();
          try
          {
            paramContext = new File(((Context)localObject1).getDir("phenotype_hermetic", 0), "overrides.txt");
            if (paramContext.exists()) {
              paramContext = zzif.decode(paramContext);
            } else {
              paramContext = zzif.decode();
            }
          }
          catch (RuntimeException paramContext)
          {
            Log.e("HermeticFileOverrides", "no data dir", paramContext);
            paramContext = zzif.decode();
          }
          if (paramContext.isEmpty())
          {
            File localFile = (File)paramContext.get();
            try
            {
              BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(localFile)));
              try
              {
                SimpleArrayMap localSimpleArrayMap = new SimpleArrayMap();
                HashMap localHashMap = new HashMap();
                for (;;)
                {
                  paramContext = localBufferedReader.readLine();
                  if (paramContext == null) {
                    break;
                  }
                  Object localObject3 = paramContext.split(" ", 3);
                  if (localObject3.length != 3)
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("Invalid: ");
                    ((StringBuilder)localObject2).append(paramContext);
                    Log.e("HermeticFileOverrides", ((StringBuilder)localObject2).toString());
                  }
                  else
                  {
                    String str1 = new String(localObject3[0]);
                    String str2 = Uri.decode(new String(localObject3[1]));
                    localObject2 = (String)localHashMap.get(localObject3[2]);
                    paramContext = (Context)localObject2;
                    if (localObject2 == null)
                    {
                      String str3 = new String(localObject3[2]);
                      localObject3 = Uri.decode(str3);
                      localObject2 = localObject3;
                      if (((String)localObject3).length() >= 1024)
                      {
                        paramContext = (Context)localObject2;
                        if (localObject3 != str3) {}
                      }
                      else
                      {
                        localHashMap.put(str3, localObject3);
                        paramContext = (Context)localObject2;
                      }
                    }
                    if (!localSimpleArrayMap.containsKey(str1)) {
                      localSimpleArrayMap.put(str1, new SimpleArrayMap());
                    }
                    ((SimpleArrayMap)localSimpleArrayMap.get(str1)).put(str2, paramContext);
                  }
                }
                paramContext = localFile.toString();
                localObject1 = ((Context)localObject1).getPackageName();
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Parsed ");
                ((StringBuilder)localObject2).append(paramContext);
                ((StringBuilder)localObject2).append(" for Android package ");
                ((StringBuilder)localObject2).append((String)localObject1);
                Log.w("HermeticFileOverrides", ((StringBuilder)localObject2).toString());
                paramContext = new zzhg(localSimpleArrayMap);
                localBufferedReader.close();
                paramContext = zzif.decode(paramContext);
              }
              catch (Throwable paramContext)
              {
                try
                {
                  localBufferedReader.close();
                }
                catch (Throwable localThrowable) {}
              }
            }
            catch (IOException paramContext)
            {
              label530:
              throw new RuntimeException(paramContext);
            }
          }
        }
        catch (Throwable paramContext)
        {
          StrictMode.setThreadPolicy(localThreadPolicy);
          throw paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
    try
    {
      localObject2 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      ((Method)localObject2).invoke(paramContext, new Object[] { localThrowable });
    }
    catch (Exception localException)
    {
      break label530;
    }
    throw paramContext;
    paramContext = zzif.decode();
    StrictMode.setThreadPolicy(localThreadPolicy);
    for (;;)
    {
      data = paramContext;
      return localThrowable;
      label584:
      Context localContext = paramContext;
    }
  }
}
