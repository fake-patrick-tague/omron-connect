package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public final class zzgz
{
  public static final Pattern COMMENT;
  public static final Uri CONTENT_ID_URI_BASE;
  public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  public static final Pattern HEX_PATTERN;
  private static final AtomicBoolean a;
  static final HashMap b;
  static final HashMap c;
  static final String[] context = new String[0];
  static HashMap data;
  static final HashMap entries;
  private static boolean isBack;
  static final HashMap listeners;
  private static Object state;
  
  static
  {
    CONTENT_ID_URI_BASE = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    HEX_PATTERN = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    COMMENT = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    a = new AtomicBoolean();
    b = new HashMap();
    c = new HashMap();
    entries = new HashMap();
    listeners = new HashMap();
  }
  
  public zzgz() {}
  
  public static String read(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    try
    {
      Object localObject2 = data;
      Object localObject1 = null;
      paramString2 = null;
      if (localObject2 == null)
      {
        a.set(false);
        data = new HashMap();
        state = new Object();
        isBack = false;
        paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzgy(null));
      }
      else if (a.getAndSet(false))
      {
        data.clear();
        b.clear();
        c.clear();
        entries.clear();
        listeners.clear();
        state = new Object();
        isBack = false;
      }
      Object localObject3 = state;
      if (data.containsKey(paramString1))
      {
        paramContentResolver = (String)data.get(paramString1);
        if (paramContentResolver != null) {
          break label301;
        }
        paramContentResolver = paramString2;
      }
      for (;;)
      {
        return paramContentResolver;
        paramString2 = context;
        Cursor localCursor = paramContentResolver.query(CONTENT_URI, null, null, new String[] { paramString1 }, null);
        if (localCursor == null) {
          return null;
        }
        try
        {
          boolean bool = localCursor.moveToFirst();
          if (!bool)
          {
            update(localObject3, paramString1, null);
            localCursor.close();
            return null;
          }
          localObject2 = localCursor.getString(1);
          paramString2 = (String)localObject2;
          paramContentResolver = paramString2;
          if (localObject2 != null)
          {
            bool = ((String)localObject2).equals(null);
            paramContentResolver = paramString2;
            if (bool) {
              paramContentResolver = null;
            }
          }
          update(localObject3, paramString1, paramContentResolver);
          if (paramContentResolver == null) {
            paramContentResolver = localObject1;
          }
          localCursor.close();
          return paramContentResolver;
        }
        catch (Throwable paramContentResolver)
        {
          localCursor.close();
          throw paramContentResolver;
        }
      }
    }
    catch (Throwable paramContentResolver)
    {
      throw paramContentResolver;
    }
  }
  
  private static void update(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == state) {
        data.put(paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
}
