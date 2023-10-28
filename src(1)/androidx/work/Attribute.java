package androidx.work;

import java.util.List;

public abstract class Attribute
{
  private static final String a = Log.getInstance("InputMerger");
  
  public Attribute() {}
  
  public static Attribute getValue(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return (Attribute)localObject;
    }
    catch (Exception localException)
    {
      Log localLog = Log.get();
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Trouble instantiating + ");
      localStringBuilder.append(paramString);
      localLog.get(str, localStringBuilder.toString(), (Throwable[])new Throwable[] { localException });
    }
    return null;
  }
  
  public abstract Label a(List paramList);
}
