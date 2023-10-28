package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class zzag
  implements zzap
{
  private final String data;
  private final zzap field;
  
  public zzag()
  {
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public zzag(String paramString)
  {
    field = zzap.this$0;
    data = paramString;
  }
  
  public zzag(String paramString, zzap paramZzap)
  {
    field = paramZzap;
    data = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzag)) {
      return false;
    }
    String str = data;
    paramObject = (zzag)paramObject;
    return (str.equals(data)) && (field.equals(field));
  }
  
  public final Double get()
  {
    throw new IllegalStateException("Control is not a double");
  }
  
  public final String getEntry()
  {
    return data;
  }
  
  public final zzap getPolicy()
  {
    return field;
  }
  
  public final String getValue()
  {
    throw new IllegalStateException("Control is not a String");
  }
  
  public final int hashCode()
  {
    return data.hashCode() * 31 + field.hashCode();
  }
  
  public final zzap multiply()
  {
    return new zzag(data, field.multiply());
  }
  
  public final Iterator toXml()
  {
    return null;
  }
  
  public final Boolean value()
  {
    throw new IllegalStateException("Control is not a boolean");
  }
  
  public final zzap zzbN(String paramString, Headers paramHeaders, List paramList)
  {
    throw new IllegalStateException("Control does not have functions");
  }
}
