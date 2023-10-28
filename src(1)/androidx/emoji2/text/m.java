package androidx.emoji2.text;

import java.util.Arrays;

final class m
{
  private int a;
  private f b;
  private f c;
  private final int[] d;
  private final boolean e;
  private int h = 1;
  private final f j;
  private int l;
  
  m(f paramF, boolean paramBoolean, int[] paramArrayOfInt)
  {
    j = paramF;
    c = paramF;
    e = paramBoolean;
    d = paramArrayOfInt;
  }
  
  private int b()
  {
    h = 1;
    c = j;
    l = 0;
    return 1;
  }
  
  private static boolean f(int paramInt)
  {
    return paramInt == 65039;
  }
  
  private static boolean l(int paramInt)
  {
    return paramInt == 65038;
  }
  
  private boolean setTitle()
  {
    if (c.a().c()) {
      return true;
    }
    if (f(a)) {
      return true;
    }
    if (e)
    {
      if (d == null) {
        return true;
      }
      int i = c.a().e(0);
      if (Arrays.binarySearch(d, i) < 0) {
        return true;
      }
    }
    return false;
  }
  
  int a(int paramInt)
  {
    f localF = c.a(paramInt);
    int k = h;
    int i = 3;
    if (k != 2)
    {
      if (localF == null)
      {
        i = b();
      }
      else
      {
        h = 2;
        c = localF;
        l = 1;
      }
    }
    else
    {
      do
      {
        for (;;)
        {
          i = 2;
          break label175;
          if (localF == null) {
            break;
          }
          c = localF;
          l += 1;
        }
        if (l(paramInt))
        {
          i = b();
          break;
        }
      } while (f(paramInt));
      if (c.a() != null)
      {
        if (l == 1)
        {
          if (setTitle())
          {
            b = c;
            b();
          }
          else
          {
            i = b();
          }
        }
        else
        {
          b = c;
          b();
        }
      }
      else {
        i = b();
      }
    }
    label175:
    a = paramInt;
    return i;
  }
  
  boolean a()
  {
    if ((h == 2) && (c.a() != null))
    {
      if (l > 1) {
        break label37;
      }
      if (setTitle()) {
        return true;
      }
    }
    return false;
    label37:
    return true;
  }
  
  i c()
  {
    return b.a();
  }
  
  i d()
  {
    return c.a();
  }
}
