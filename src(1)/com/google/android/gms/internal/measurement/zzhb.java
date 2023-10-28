package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Objects;

final class zzhb
  extends zzhy
{
  private final Context c;
  private final zzih name;
  
  zzhb(Context paramContext, zzih paramZzih)
  {
    Objects.requireNonNull(paramContext, "Null context");
    c = paramContext;
    name = paramZzih;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzhy))
    {
      paramObject = (zzhy)paramObject;
      if (c.equals(paramObject.get()))
      {
        zzih localZzih = name;
        if (localZzih == null)
        {
          if (paramObject.getName() == null) {
            return true;
          }
        }
        else {
          return localZzih.equals(paramObject.getName());
        }
      }
    }
    return false;
  }
  
  final Context get()
  {
    return c;
  }
  
  final zzih getName()
  {
    return name;
  }
  
  public final int hashCode()
  {
    int j = c.hashCode();
    zzih localZzih = name;
    int i;
    if (localZzih == null) {
      i = 0;
    } else {
      i = localZzih.hashCode();
    }
    return (j ^ 0xF4243) * 1000003 ^ i;
  }
  
  public final String toString()
  {
    String str1 = c.toString();
    String str2 = String.valueOf(name);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlagsContext{context=");
    localStringBuilder.append(str1);
    localStringBuilder.append(", hermeticFileOverrides=");
    localStringBuilder.append(str2);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
