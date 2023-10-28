package com.google.android.gms.internal.measurement;

public final class zzgf
  extends zzke
  implements zzlm
{
  private static final zzgf bookId;
  private int TYPE_DIALOG;
  private zzkl date = zzke.zzbD();
  private int week = 1;
  
  static
  {
    zzgf localZzgf = new zzgf();
    bookId = localZzgf;
    zzke.zzbJ(zzgf.class, localZzgf);
  }
  
  private zzgf() {}
  
  public static zzgd getBookId()
  {
    return (zzgd)bookId.zzbx();
  }
  
  protected final Object Decode(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramInt -= 1;
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            return bookId;
          }
          return new zzgd(null);
        }
        return new zzgf();
      }
      paramObject1 = zzge.bookId;
      return zzke.zzbI(bookId, "\001\002\000\001\001\002\002\000\001\000\001?\000\002\033", new Object[] { "zze", "zzf", paramObject1, "zzg", zzfu.class });
    }
    return Byte.valueOf((byte)1);
  }
}
