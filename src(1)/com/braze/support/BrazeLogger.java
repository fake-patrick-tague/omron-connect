package com.braze.support;

import android.util.Log;
import kotlin.h;
import kotlin.t;
import kotlin.x.c.a;
import kotlin.x.c.q;
import kotlin.x.d.i;
import kotlin.x.d.j;
import protect.package_9.SystemReader;

public final class BrazeLogger
{
  public static final BrazeLogger INSTANCE = new BrazeLogger();
  private static boolean hasLogLevelBeenSetForAppRun;
  private static boolean isSystemPropLogLevelSet;
  private static int logLevel = 4;
  private static q<? super Priority, ? super String, ? super Throwable, t> onLoggedCallback;
  
  private BrazeLogger() {}
  
  public static final void a(String paramString1, String paramString2)
  {
    i.e(paramString1, "tag");
    i.e(paramString2, "msg");
    w$default(paramString1, paramString2, null, 4, null);
  }
  
  public static final void add(String paramString1, String paramString2)
  {
    i.e(paramString1, "tag");
    i.e(paramString2, "msg");
    i$default(paramString1, paramString2, null, 4, null);
  }
  
  public static final void add(String paramString1, String paramString2, Throwable paramThrowable)
  {
    i.e(paramString1, "tag");
    i.e(paramString2, "msg");
    i.e(paramThrowable, "tr");
    INSTANCE.brazelog(paramString1, Priority.BEGIN, paramThrowable, new e(paramString2));
  }
  
  public static final void call(String paramString1, String paramString2, Throwable paramThrowable)
  {
    i.e(paramString1, "tag");
    i.e(paramString2, "msg");
    INSTANCE.brazelog(paramString1, Priority.$EnumSwitchMapping$0, paramThrowable, new h(paramString2));
  }
  
  public static final void checkForSystemLogLevelProperty(boolean paramBoolean)
  {
    try
    {
      BrazeLogger localBrazeLogger = INSTANCE;
      String str = SystemReader.doInBackground("log.tag.APPBOY");
      if (kotlin.text.g.n("verbose", kotlin.text.g.l0(str).toString(), true))
      {
        setLogLevel(2);
        isSystemPropLogLevelSet = true;
        brazelog$default(localBrazeLogger, localBrazeLogger, Priority.g, null, new c(str), 2, null);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static final void d(String paramString1, String paramString2)
  {
    i.e(paramString1, "tag");
    i.e(paramString2, "msg");
    d$default(paramString1, paramString2, null, 4, null);
  }
  
  public static final void e(String paramString1, String paramString2)
  {
    i.e(paramString1, "tag");
    i.e(paramString2, "msg");
    v$default(paramString1, paramString2, null, 4, null);
  }
  
  public static final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    i.e(paramString1, "tag");
    i.e(paramString2, "msg");
    INSTANCE.brazelog(paramString1, Priority.g, paramThrowable, new f(paramString2));
  }
  
  public static final String getBrazeLogTag(Class paramClass)
  {
    i.e(paramClass, "classForTag");
    Object localObject = paramClass.getName();
    paramClass = (Class)localObject;
    int i = ((String)localObject).length();
    if (i <= 65)
    {
      i.d(localObject, "{\n            // No need?  fullClassName\n        }");
    }
    else
    {
      i.d(localObject, "fullClassName");
      localObject = ((String)localObject).substring(i - 65);
      paramClass = (Class)localObject;
      i.d(localObject, "this as java.lang.String).substring(startIndex)");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Braze v25.0.0 .");
    ((StringBuilder)localObject).append(paramClass);
    return ((StringBuilder)localObject).toString();
  }
  
  public static final void setInitialLogLevelFromConfiguration(int paramInt)
  {
    try
    {
      if (!hasLogLevelBeenSetForAppRun) {
        setLogLevel(paramInt);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static final void setLogLevel(int paramInt)
  {
    try
    {
      if (!isSystemPropLogLevelSet)
      {
        hasLogLevelBeenSetForAppRun = true;
        logLevel = paramInt;
      }
      else
      {
        BrazeLogger localBrazeLogger = INSTANCE;
        brazelog$default(localBrazeLogger, localBrazeLogger, Priority.PREPARED, null, new g(paramInt), 2, null);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static final void showMessage(String paramString1, String paramString2, Throwable paramThrowable)
  {
    i.e(paramString1, "tag");
    i.e(paramString2, "msg");
    INSTANCE.brazelog(paramString1, Priority.BEGIN, paramThrowable, new d(paramString2));
  }
  
  private final String toStringSafe(a paramA)
  {
    try
    {
      paramA = String.valueOf(paramA.invoke());
      return paramA;
    }
    catch (Exception paramA)
    {
      for (;;) {}
    }
    return "";
  }
  
  public static final void warn(String paramString1, String paramString2, Throwable paramThrowable)
  {
    i.e(paramString1, "tag");
    i.e(paramString2, "msg");
    INSTANCE.brazelog(paramString1, Priority.PREPARED, paramThrowable, new i(paramString2));
  }
  
  public final String brazeLogTag(Object paramObject)
  {
    i.e(paramObject, "<this>");
    paramObject = paramObject.getClass().getName();
    i.d(paramObject, "fullClassName");
    String str = kotlin.text.g.g0(kotlin.text.g.j0(paramObject, '$', null, 2, null), '.', null, 2, null);
    int i;
    if (str.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return getBrazeLogTag(paramObject);
    }
    return getBrazeLogTag(str);
  }
  
  public final void brazelog(Object paramObject, Priority paramPriority, Throwable paramThrowable, a paramA)
  {
    i.e(paramObject, "<this>");
    i.e(paramPriority, "priority");
    i.e(paramA, "message");
    if (logLevel <= paramPriority.getLogLevel()) {
      brazelog(brazeLogTag(paramObject), paramPriority, paramThrowable, paramA);
    }
  }
  
  public final void brazelog(String paramString, Priority paramPriority, Throwable paramThrowable, a paramA)
  {
    i.e(paramString, "tag");
    i.e(paramPriority, "priority");
    i.e(paramA, "message");
    paramA = h.b(new b(paramA));
    q localQ = onLoggedCallback;
    if (localQ != null) {
      localQ.a(paramPriority, paramA.getValue(), paramThrowable);
    }
    if (logLevel <= paramPriority.getLogLevel())
    {
      int i = a.DIGITS_POWER[paramPriority.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              if (paramThrowable == null)
              {
                Log.v(paramString, (String)paramA.getValue());
                return;
              }
              Log.v(paramString, (String)paramA.getValue(), paramThrowable);
              return;
            }
            if (paramThrowable == null)
            {
              Log.w(paramString, (String)paramA.getValue());
              return;
            }
            Log.w(paramString, (String)paramA.getValue(), paramThrowable);
            return;
          }
          if (paramThrowable == null)
          {
            Log.w(paramString, (String)paramA.getValue());
            return;
          }
          Log.e(paramString, (String)paramA.getValue(), paramThrowable);
          return;
        }
        if (paramThrowable == null)
        {
          Log.i(paramString, (String)paramA.getValue());
          return;
        }
        Log.i(paramString, (String)paramA.getValue(), paramThrowable);
        return;
      }
      if (paramThrowable == null)
      {
        Log.d(paramString, (String)paramA.getValue());
        return;
      }
      Log.d(paramString, (String)paramA.getValue(), paramThrowable);
    }
  }
  
  public final String getBrazeLogTag(String paramString)
  {
    i.e(paramString, "<this>");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Braze v25.0.0 .");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static enum Priority
  {
    private final int logLevel;
    
    static
    {
      $EnumSwitchMapping$0 = new Priority("V", 3, 2);
      PREPARED = new Priority("W", 4, 5);
    }
    
    private Priority(int paramInt)
    {
      logLevel = paramInt;
    }
    
    public final int getLogLevel()
    {
      return logLevel;
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    b(a paramA)
    {
      super();
    }
    
    public final String getLocal()
    {
      return BrazeLogger.access$toStringSafe(BrazeLogger.INSTANCE, context);
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    c(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BrazeLogger log level set to ");
      localStringBuilder.append(src);
      localStringBuilder.append(" via device system property. Note that subsequent calls to BrazeLogger.setLogLevel() will have no effect.");
      return localStringBuilder.toString();
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    d(String paramString)
    {
      super();
    }
    
    public final String getLocal()
    {
      return locals;
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    e(String paramString)
    {
      super();
    }
    
    public final String getLocal()
    {
      return locals;
    }
  }
  
  static final class f
    extends j
    implements a<String>
  {
    f(String paramString)
    {
      super();
    }
    
    public final String getLocal()
    {
      return locals;
    }
  }
  
  static final class g
    extends j
    implements a<String>
  {
    g(int paramInt)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Log level already set via system property. BrazeLogger.setLogLevel() ignored for level: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class h
    extends j
    implements a<String>
  {
    h(String paramString)
    {
      super();
    }
    
    public final String getLocal()
    {
      return locals;
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    i(String paramString)
    {
      super();
    }
    
    public final String getLocal()
    {
      return locals;
    }
  }
}
