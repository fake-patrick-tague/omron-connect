package androidx.constraintlayout.solver;

class b<T>
  implements f<T>
{
  private final Object[] a;
  private int b;
  
  b(int paramInt)
  {
    if (paramInt > 0)
    {
      a = new Object[paramInt];
      return;
    }
    throw new IllegalArgumentException("The max pool size must be > 0");
  }
  
  public Object a()
  {
    int i = b;
    if (i > 0)
    {
      int j = i - 1;
      Object[] arrayOfObject = a;
      Object localObject = arrayOfObject[j];
      arrayOfObject[j] = null;
      b = (i - 1);
      return localObject;
    }
    return null;
  }
  
  public void a(Object[] paramArrayOfObject, int paramInt)
  {
    int i = paramInt;
    if (paramInt > paramArrayOfObject.length) {
      i = paramArrayOfObject.length;
    }
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = paramArrayOfObject[paramInt];
      int j = b;
      Object[] arrayOfObject = a;
      if (j < arrayOfObject.length)
      {
        arrayOfObject[j] = localObject;
        b = (j + 1);
      }
      paramInt += 1;
    }
  }
  
  public boolean a(Object paramObject)
  {
    int i = b;
    Object[] arrayOfObject = a;
    if (i < arrayOfObject.length)
    {
      arrayOfObject[i] = paramObject;
      b = (i + 1);
      return true;
    }
    return false;
  }
}
