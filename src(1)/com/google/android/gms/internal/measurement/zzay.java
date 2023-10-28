package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzay
  extends zzaw
{
  public zzay()
  {
    this$0.add(zzbl.lon);
    this$0.add(zzbl.SMS_MT);
    this$0.add(zzbl.END);
    this$0.add(zzbl.ERROR);
    this$0.add(zzbl.WARNING);
    this$0.add(zzbl.UNKNOWN);
    this$0.add(zzbl.NULL);
    this$0.add(zzbl.d);
  }
  
  private static boolean add(zzap paramZzap1, zzap paramZzap2)
  {
    boolean bool2 = paramZzap1 instanceof zzal;
    Object localObject = paramZzap1;
    if (bool2) {
      localObject = new zzat(paramZzap1.getValue());
    }
    bool2 = paramZzap2 instanceof zzal;
    paramZzap1 = paramZzap2;
    if (bool2) {
      paramZzap1 = new zzat(paramZzap2.getValue());
    }
    paramZzap2 = paramZzap1;
    if ((localObject instanceof zzat))
    {
      bool2 = paramZzap1 instanceof zzat;
      if (!bool2) {
        paramZzap2 = paramZzap1;
      } else {
        return ((zzap)localObject).getValue().compareTo(paramZzap1.getValue()) < 0;
      }
    }
    double d1 = ((zzap)localObject).get().doubleValue();
    double d2 = paramZzap2.get().doubleValue();
    if (!Double.isNaN(d1))
    {
      if (Double.isNaN(d2)) {
        return false;
      }
      boolean bool1 = d1 < 0.0D;
      if ((bool1) || (d2 != 0.0D))
      {
        if (!bool1) {
          if (d2 == 0.0D) {
            break label189;
          }
        }
      }
      else {
        return false;
      }
      if (Double.compare(d1, d2) < 0) {
        return true;
      }
    }
    label189:
    return false;
  }
  
  private static boolean subtract(zzap paramZzap1, zzap paramZzap2)
  {
    Object localObject = paramZzap1;
    if ((paramZzap1 instanceof zzal)) {
      localObject = new zzat(paramZzap1.getValue());
    }
    paramZzap1 = paramZzap2;
    if ((paramZzap2 instanceof zzal)) {
      paramZzap1 = new zzat(paramZzap2.getValue());
    }
    return (((localObject instanceof zzat)) && ((paramZzap1 instanceof zzat))) || ((!Double.isNaN(((zzap)localObject).get().doubleValue())) && (!Double.isNaN(paramZzap1.get().doubleValue())) && (!add(paramZzap1, (zzap)localObject)));
  }
  
  private static boolean write(zzap paramZzap1, zzap paramZzap2)
  {
    if (paramZzap1.getClass().equals(paramZzap2.getClass()))
    {
      if (!(paramZzap1 instanceof zzau))
      {
        if ((paramZzap1 instanceof zzan)) {
          return true;
        }
        if ((paramZzap1 instanceof zzah))
        {
          if (!Double.isNaN(paramZzap1.get().doubleValue()))
          {
            if (Double.isNaN(paramZzap2.get().doubleValue())) {
              return false;
            }
            if (paramZzap1.get().doubleValue() == paramZzap2.get().doubleValue()) {
              return true;
            }
          }
          else
          {
            return false;
          }
        }
        else
        {
          if ((paramZzap1 instanceof zzat)) {
            return paramZzap1.getValue().equals(paramZzap2.getValue());
          }
          if ((paramZzap1 instanceof zzaf)) {
            return paramZzap1.value().equals(paramZzap2.value());
          }
          return paramZzap1 == paramZzap2;
        }
      }
      else
      {
        return true;
      }
    }
    else
    {
      boolean bool1;
      if (((paramZzap1 instanceof zzau)) || ((paramZzap1 instanceof zzan)))
      {
        if (!(paramZzap2 instanceof zzau)) {
          if ((paramZzap2 instanceof zzan)) {
            break label389;
          }
        }
      }
      else
      {
        bool1 = paramZzap1 instanceof zzah;
        if ((bool1) && ((paramZzap2 instanceof zzat))) {
          return write(paramZzap1, new zzah(paramZzap2.get()));
        }
        boolean bool2 = paramZzap1 instanceof zzat;
        if ((bool2) && ((paramZzap2 instanceof zzah))) {
          return write(new zzah(paramZzap1.get()), paramZzap2);
        }
        if ((paramZzap1 instanceof zzaf)) {
          return write(new zzah(paramZzap1.get()), paramZzap2);
        }
        if ((paramZzap2 instanceof zzaf)) {
          return write(paramZzap1, new zzah(paramZzap2.get()));
        }
        if (((!bool2) && (!bool1)) || (!(paramZzap2 instanceof zzal)))
        {
          if ((paramZzap1 instanceof zzal))
          {
            if ((!(paramZzap2 instanceof zzat)) && (!(paramZzap2 instanceof zzah))) {
              break label391;
            }
            return write(new zzat(paramZzap1.getValue()), paramZzap2);
          }
          return false;
        }
        paramZzap2 = new zzat(paramZzap2.getValue());
      }
      try
      {
        bool1 = write(paramZzap1, paramZzap2);
        return bool1;
      }
      catch (Throwable paramZzap1)
      {
        throw paramZzap1;
      }
      return true;
    }
    return false;
    label389:
    return true;
    label391:
    return false;
  }
  
  public final zzap add(String paramString, Headers paramHeaders, List paramList)
  {
    ByteVector.set(ByteVector.get(paramString).name(), 2, paramList);
    zzap localZzap = paramHeaders.get((zzap)paramList.get(0));
    paramHeaders = paramHeaders.get((zzap)paramList.get(1));
    int i = ByteVector.get(paramString).ordinal();
    if (i != 23)
    {
      if (i != 48) {
        if (i != 42) {
          if (i != 43) {
            switch (i)
            {
            default: 
              return super.add(paramString);
            }
          }
        }
      }
      for (bool = ByteVector.add(localZzap, paramHeaders);; bool = write(localZzap, paramHeaders))
      {
        bool ^= true;
        break;
        bool = ByteVector.add(localZzap, paramHeaders);
        break;
        bool = subtract(paramHeaders, localZzap);
        break;
        bool = add(paramHeaders, localZzap);
        break;
        bool = subtract(localZzap, paramHeaders);
        break;
        bool = add(localZzap, paramHeaders);
        break;
      }
    }
    boolean bool = write(localZzap, paramHeaders);
    if (bool) {
      return zzap.TRUE;
    }
    return zzap.FALSE;
  }
}
