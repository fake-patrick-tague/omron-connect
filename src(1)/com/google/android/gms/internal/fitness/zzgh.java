package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class zzgh
  extends zzge
{
  protected final byte[] zzui;
  
  zzgh(byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramArrayOfByte);
    zzui = paramArrayOfByte;
  }
  
  public byte byteAt(int paramInt)
  {
    return zzui[paramInt];
  }
  
  protected final int computeHashCode(int paramInt1, int paramInt2, int paramInt3)
  {
    return zzhc.hashCode(paramInt1, zzui, zzay(), paramInt3);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzfx)) {
      return false;
    }
    if (size() != ((zzfx)paramObject).size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((paramObject instanceof zzgh))
    {
      paramObject = (zzgh)paramObject;
      int i = zzax();
      int j = paramObject.zzax();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      return matches(paramObject, 0, size());
    }
    return paramObject.equals(this);
  }
  
  public final zzfx getPath(int paramInt1, int paramInt2)
  {
    paramInt1 = zzfx.add(0, paramInt2, size());
    if (paramInt1 == 0) {
      return zzfx.zzub;
    }
    return new zzga(zzui, zzay(), paramInt1);
  }
  
  final void markAllAsRead(zzfu paramZzfu)
    throws IOException
  {
    paramZzfu.put(zzui, zzay(), size());
  }
  
  final boolean matches(zzfx paramZzfx, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramZzfx.size())
    {
      if (paramInt2 <= paramZzfx.size())
      {
        if ((paramZzfx instanceof zzgh))
        {
          paramZzfx = (zzgh)paramZzfx;
          byte[] arrayOfByte1 = zzui;
          byte[] arrayOfByte2 = zzui;
          int j = zzay();
          int i = zzay();
          paramInt1 = paramZzfx.zzay();
          while (i < j + paramInt2)
          {
            if (arrayOfByte1[i] != arrayOfByte2[paramInt1]) {
              return false;
            }
            i += 1;
            paramInt1 += 1;
          }
          return true;
        }
        return paramZzfx.getPath(0, paramInt2).equals(getPath(0, paramInt2));
      }
      paramInt1 = paramZzfx.size();
      paramZzfx = new StringBuilder(59);
      paramZzfx.append("Ran off end of other: 0, ");
      paramZzfx.append(paramInt2);
      paramZzfx.append(", ");
      paramZzfx.append(paramInt1);
      throw new IllegalArgumentException(paramZzfx.toString());
    }
    paramInt1 = size();
    paramZzfx = new StringBuilder(40);
    paramZzfx.append("Length too large: ");
    paramZzfx.append(paramInt2);
    paramZzfx.append(paramInt1);
    throw new IllegalArgumentException(paramZzfx.toString());
  }
  
  byte nextValue(int paramInt)
  {
    return zzui[paramInt];
  }
  
  public int size()
  {
    return zzui.length;
  }
  
  protected final String writeText(Charset paramCharset)
  {
    return new String(zzui, zzay(), size(), paramCharset);
  }
  
  public final boolean zzaw()
  {
    int i = zzay();
    return zzka.processBytes(zzui, i, size() + i);
  }
  
  protected int zzay()
  {
    return 0;
  }
}
