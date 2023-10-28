package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class zzja
  extends zziz
{
  protected final byte[] data;
  
  zzja(byte[] paramArrayOfByte)
  {
    Objects.requireNonNull(paramArrayOfByte);
    data = paramArrayOfByte;
  }
  
  protected final int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return zzkm.inflate(paramInt1, data, 0, paramInt3);
  }
  
  public final boolean b()
  {
    return zznc.b(data, 0, size());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzjd)) {
      return false;
    }
    if (size() != ((zzjd)paramObject).size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((paramObject instanceof zzja))
    {
      paramObject = (zzja)paramObject;
      int i = getResponse();
      int j = paramObject.getResponse();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      int k = size();
      if (k <= paramObject.size())
      {
        if (k <= paramObject.size())
        {
          byte[] arrayOfByte1 = data;
          byte[] arrayOfByte2 = data;
          paramObject.getCharIndex();
          j = 0;
          i = 0;
          while (j < k)
          {
            if (arrayOfByte1[j] != arrayOfByte2[i]) {
              return false;
            }
            j += 1;
            i += 1;
          }
          return true;
        }
        i = paramObject.size();
        paramObject = new StringBuilder();
        paramObject.append("Ran off end of other: 0, ");
        paramObject.append(k);
        paramObject.append(", ");
        paramObject.append(i);
        throw new IllegalArgumentException(paramObject.toString());
      }
      i = size();
      paramObject = new StringBuilder();
      paramObject.append("Length too large: ");
      paramObject.append(k);
      paramObject.append(i);
      throw new IllegalArgumentException(paramObject.toString());
    }
    return paramObject.equals(this);
  }
  
  byte get(int paramInt)
  {
    return data[paramInt];
  }
  
  protected int getCharIndex()
  {
    return 0;
  }
  
  public final zzjd getValue(int paramInt1, int paramInt2)
  {
    paramInt1 = zzjd.add(0, paramInt2, size());
    if (paramInt1 == 0) {
      return zzjd.a;
    }
    return new zzix(data, 0, paramInt1);
  }
  
  public byte next(int paramInt)
  {
    return data[paramInt];
  }
  
  final void remainder(zzit paramZzit)
    throws IOException
  {
    byte[] arrayOfByte = data;
    int i = size();
    ((zzji)paramZzit).add(arrayOfByte, 0, i);
  }
  
  public int size()
  {
    return data.length;
  }
  
  protected final String toString(Charset paramCharset)
  {
    return new String(data, 0, size(), paramCharset);
  }
}
