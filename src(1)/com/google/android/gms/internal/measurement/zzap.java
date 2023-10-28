package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public abstract interface zzap
{
  public static final zzap FALSE = new zzaf(Boolean.FALSE);
  public static final zzap NaN;
  public static final zzap TRUE;
  public static final zzap items;
  public static final zzap list = new zzat("");
  public static final zzap menu;
  public static final zzap this$0 = new zzau();
  public static final zzap uri;
  
  static
  {
    items = new zzan();
    uri = new zzag("continue");
    NaN = new zzag("break");
    menu = new zzag("return");
    TRUE = new zzaf(Boolean.TRUE);
  }
  
  public abstract Double get();
  
  public abstract String getValue();
  
  public abstract zzap multiply();
  
  public abstract Iterator toXml();
  
  public abstract Boolean value();
  
  public abstract zzap zzbN(String paramString, Headers paramHeaders, List paramList);
}
