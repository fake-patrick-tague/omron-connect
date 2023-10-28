package com.google.android.datatransport.asm.io;

public final class m
{
  public static Object a(int paramInt, Object paramObject, Procedure4 paramProcedure4, x paramX)
    throws Throwable
  {
    int i = paramInt;
    Object localObject1 = paramObject;
    if (paramInt < 1) {
      return paramProcedure4.apply(paramObject);
    }
    Object localObject2;
    do
    {
      localObject2 = paramProcedure4.apply(localObject1);
      paramObject = paramX.a(localObject1, localObject2);
      localObject1 = paramObject;
      if (paramObject == null) {
        break;
      }
      paramInt = i - 1;
      i = paramInt;
    } while (paramInt >= 1);
    return localObject2;
  }
}
