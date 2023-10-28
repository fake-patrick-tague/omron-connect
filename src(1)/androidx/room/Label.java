package androidx.room;

import java.util.Arrays;

class Label
{
  final long[] a;
  final boolean[] c;
  final int[] d;
  boolean e;
  boolean f;
  
  Label(int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    a = arrayOfLong;
    boolean[] arrayOfBoolean = new boolean[paramInt];
    c = arrayOfBoolean;
    d = new int[paramInt];
    Arrays.fill(arrayOfLong, 0L);
    Arrays.fill(arrayOfBoolean, false);
  }
  
  boolean a(int... paramVarArgs)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = paramVarArgs.length;
        i = 0;
        boolean bool = false;
        if (i < j)
        {
          int k = paramVarArgs[i];
          long[] arrayOfLong = a;
          long l = arrayOfLong[k];
          arrayOfLong[k] = (l - 1L);
          if (l == 1L)
          {
            f = true;
            bool = true;
          }
        }
        else
        {
          return bool;
        }
      }
      catch (Throwable paramVarArgs)
      {
        throw paramVarArgs;
      }
      i += 1;
    }
  }
  
  int[] a()
  {
    Object localObject1 = this;
    for (;;)
    {
      int i;
      Object localObject2;
      int[] arrayOfInt;
      try
      {
        int m = f;
        Label localLabel = this;
        if (m != 0)
        {
          localObject1 = localLabel;
          m = e;
          if (m == 0)
          {
            localObject1 = localLabel;
            int k = a.length;
            i = 0;
            j = 1;
            if (i < k)
            {
              localObject1 = localLabel;
              if (a[i] <= 0L) {
                break label195;
              }
              m = 1;
              localObject1 = localLabel;
              localObject2 = c;
              if (m != localObject2[i])
              {
                localObject1 = localLabel;
                arrayOfInt = d;
                if (m == 0) {
                  break label201;
                }
                break label203;
              }
              localObject1 = localLabel;
              d[i] = 0;
              break label208;
            }
            localObject1 = localLabel;
            e = true;
            localObject1 = localLabel;
            f = false;
            localObject1 = localLabel;
            localObject2 = d;
            localObject1 = localLabel;
            return localObject2;
          }
        }
        localLabel = this;
        localObject1 = localLabel;
        return null;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      label195:
      int n = 0;
      continue;
      label201:
      int j = 2;
      label203:
      arrayOfInt[i] = j;
      label208:
      localObject2[i] = n;
      i += 1;
    }
  }
  
  boolean draw(int... paramVarArgs)
  {
    for (;;)
    {
      int i;
      try
      {
        int j = paramVarArgs.length;
        i = 0;
        boolean bool = false;
        if (i < j)
        {
          int k = paramVarArgs[i];
          long[] arrayOfLong = a;
          long l = arrayOfLong[k];
          arrayOfLong[k] = (1L + l);
          if (l == 0L)
          {
            f = true;
            bool = true;
          }
        }
        else
        {
          return bool;
        }
      }
      catch (Throwable paramVarArgs)
      {
        throw paramVarArgs;
      }
      i += 1;
    }
  }
  
  void next()
  {
    try
    {
      e = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
