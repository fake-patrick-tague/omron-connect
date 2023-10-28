package androidx.work;

public class Elements
  extends Log
{
  private int contents;
  
  public Elements(int paramInt)
  {
    super(paramInt);
    contents = paramInt;
  }
  
  public void a(String paramString1, String paramString2, Throwable... paramVarArgs)
  {
    if (contents <= 4)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        android.util.Log.i(paramString1, paramString2, paramVarArgs[0]);
        return;
      }
      android.util.Log.i(paramString1, paramString2);
    }
  }
  
  public void add(String paramString1, String paramString2, Throwable... paramVarArgs)
  {
    if (contents <= 5)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        android.util.Log.w(paramString1, paramString2, paramVarArgs[0]);
        return;
      }
      android.util.Log.w(paramString1, paramString2);
    }
  }
  
  public void append(String paramString1, String paramString2, Throwable... paramVarArgs)
  {
    if (contents <= 3)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        android.util.Log.d(paramString1, paramString2, paramVarArgs[0]);
        return;
      }
      android.util.Log.d(paramString1, paramString2);
    }
  }
  
  public void get(String paramString1, String paramString2, Throwable... paramVarArgs)
  {
    if (contents <= 6)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        android.util.Log.e(paramString1, paramString2, paramVarArgs[0]);
        return;
      }
      android.util.Log.e(paramString1, paramString2);
    }
  }
  
  public void set(String paramString1, String paramString2, Throwable... paramVarArgs)
  {
    if (contents <= 2)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
      {
        android.util.Log.v(paramString1, paramString2, paramVarArgs[0]);
        return;
      }
      android.util.Log.v(paramString1, paramString2);
    }
  }
}
