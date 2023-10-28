package com.google.android.gms.internal.measurement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

public final class zzah
  implements zzap
{
  private final Double value;
  
  public zzah(Double paramDouble)
  {
    if (paramDouble == null)
    {
      value = Double.valueOf(NaN.0D);
      return;
    }
    value = paramDouble;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzah)) {
      return false;
    }
    paramObject = (zzah)paramObject;
    return value.equals(value);
  }
  
  public final Double get()
  {
    return value;
  }
  
  public final String getValue()
  {
    if (Double.isNaN(value.doubleValue())) {
      return "NaN";
    }
    if (Double.isInfinite(value.doubleValue()))
    {
      if (value.doubleValue() > 0.0D) {
        return "Infinity";
      }
      return "-Infinity";
    }
    BigDecimal localBigDecimal = BigDecimal.valueOf(value.doubleValue()).stripTrailingZeros();
    Object localObject = new DecimalFormat("0E0");
    ((NumberFormat)localObject).setRoundingMode(RoundingMode.HALF_UP);
    if (localBigDecimal.scale() > 0) {
      i = localBigDecimal.precision();
    } else {
      i = localBigDecimal.scale();
    }
    ((NumberFormat)localObject).setMinimumFractionDigits(i - 1);
    String str = ((NumberFormat)localObject).format(localBigDecimal);
    int i = str.indexOf("E");
    localObject = str;
    if (i > 0)
    {
      i = Integer.parseInt(str.substring(i + 1));
      if (((i < 0) && (i > -7)) || ((i >= 0) && (i < 21))) {
        return localBigDecimal.toPlainString();
      }
      localObject = str.replace("E-", "e-").replace("E", "e+");
    }
    return localObject;
  }
  
  public final int hashCode()
  {
    return value.hashCode();
  }
  
  public final zzap multiply()
  {
    return new zzah(value);
  }
  
  public final String toString()
  {
    return getValue();
  }
  
  public final Iterator toXml()
  {
    return null;
  }
  
  public final Boolean value()
  {
    boolean bool3 = Double.isNaN(value.doubleValue());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (value.doubleValue() != 0.0D) {
        bool1 = true;
      }
    }
    return Boolean.valueOf(bool1);
  }
  
  public final zzap zzbN(String paramString, Headers paramHeaders, List paramList)
  {
    if ("toString".equals(paramString)) {
      return new zzat(getValue());
    }
    throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[] { getValue(), paramString }));
  }
}
