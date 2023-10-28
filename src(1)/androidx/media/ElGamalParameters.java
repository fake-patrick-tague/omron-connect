package androidx.media;

import android.text.TextUtils;
import v7.v7.util.Context;

class ElGamalParameters
  implements CipherParameters
{
  private int b;
  private int g;
  private String l;
  
  ElGamalParameters(String paramString, int paramInt1, int paramInt2)
  {
    l = paramString;
    g = paramInt1;
    b = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ElGamalParameters)) {
      return false;
    }
    paramObject = (ElGamalParameters)paramObject;
    return (TextUtils.equals(l, l)) && (g == g) && (b == b);
  }
  
  public int hashCode()
  {
    return Context.getType(new Object[] { l, Integer.valueOf(g), Integer.valueOf(b) });
  }
}
