package com.google.android.gms.internal.measurement;

final class zzlc
  implements zzlj
{
  private final zzlj[] axes;
  
  zzlc(zzlj... paramVarArgs)
  {
    axes = paramVarArgs;
  }
  
  public final boolean contains(Class paramClass)
  {
    zzlj[] arrayOfZzlj = axes;
    int i = 0;
    while (i < 2)
    {
      if (arrayOfZzlj[i].contains(paramClass)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final zzli get(Class paramClass)
  {
    zzlj[] arrayOfZzlj = axes;
    int i = 0;
    while (i < 2)
    {
      zzlj localZzlj = arrayOfZzlj[i];
      if (localZzlj.contains(paramClass)) {
        return localZzlj.get(paramClass);
      }
      i += 1;
    }
    throw new UnsupportedOperationException("No factory is available for message type: ".concat(paramClass.getName()));
  }
}
