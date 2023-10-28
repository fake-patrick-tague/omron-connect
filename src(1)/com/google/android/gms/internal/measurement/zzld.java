package com.google.android.gms.internal.measurement;

final class zzld
  implements zzlx
{
  private static final zzlj CurrentItem = new zzlb();
  private final zzlj mRow;
  
  public zzld()
  {
    zzkm.get(localObject, "messageInfoFactory");
    mRow = ((zzlj)localObject);
  }
  
  private static boolean removeFromCache(zzli paramZzli)
  {
    return paramZzli.get() == 1;
  }
  
  public final zzlw get(Class paramClass)
  {
    zzly.injectMembers(paramClass);
    zzli localZzli = mRow.get(paramClass);
    if (localZzli.add())
    {
      if (zzke.class.isAssignableFrom(paramClass)) {
        return zzlp.construct(zzly.forName(), zzjt.forName(), localZzli.getSimpleName());
      }
      return zzlp.construct(zzly.get(), zzjt.get(), localZzli.getSimpleName());
    }
    if (zzke.class.isAssignableFrom(paramClass))
    {
      if (removeFromCache(localZzli)) {
        return zzlo.invoke(paramClass, localZzli, zzlr.getType(), zzkz.forName(), zzly.forName(), zzjt.forName(), zzlh.forName());
      }
      return zzlo.invoke(paramClass, localZzli, zzlr.getType(), zzkz.forName(), zzly.forName(), null, zzlh.forName());
    }
    if (removeFromCache(localZzli)) {
      return zzlo.invoke(paramClass, localZzli, zzlr.valueOf(), zzkz.getLocalClassName(), zzly.get(), zzjt.get(), zzlh.valueOf());
    }
    return zzlo.invoke(paramClass, localZzli, zzlr.valueOf(), zzkz.getLocalClassName(), zzly.getTime(), null, zzlh.valueOf());
  }
}
