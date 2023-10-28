package androidx.work;

public abstract class Log
{
  private static final int WARN = 20;
  private static Log counter;
  
  public Log(int paramInt) {}
  
  public static Log get()
  {
    try
    {
      if (counter == null) {
        counter = new Elements(3);
      }
      Log localLog = counter;
      return localLog;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static String getInstance(String paramString)
  {
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(23);
    localStringBuilder.append("WM-");
    int j = WARN;
    if (i >= j) {
      localStringBuilder.append(paramString.substring(0, j));
    } else {
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  public static void print(Log paramLog)
  {
    try
    {
      counter = paramLog;
      return;
    }
    catch (Throwable paramLog)
    {
      throw paramLog;
    }
  }
  
  public abstract void a(String paramString1, String paramString2, Throwable... paramVarArgs);
  
  public abstract void add(String paramString1, String paramString2, Throwable... paramVarArgs);
  
  public abstract void append(String paramString1, String paramString2, Throwable... paramVarArgs);
  
  public abstract void get(String paramString1, String paramString2, Throwable... paramVarArgs);
  
  public abstract void set(String paramString1, String paramString2, Throwable... paramVarArgs);
}
