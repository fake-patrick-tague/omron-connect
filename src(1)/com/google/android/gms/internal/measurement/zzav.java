package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzav
  extends zzaw
{
  public zzav()
  {
    this$0.add(zzbl.start);
    this$0.add(zzbl.content);
    this$0.add(zzbl.message);
    this$0.add(zzbl.code);
    this$0.add(zzbl.map);
    this$0.add(zzbl.name);
    this$0.add(zzbl.owner);
  }
  
  public final zzap add(String paramString, Headers paramHeaders, List paramList)
  {
    zzbl localZzbl = zzbl.list;
    switch (ByteVector.get(paramString).ordinal())
    {
    default: 
      return super.add(paramString);
    case 10: 
      ByteVector.set(zzbl.owner.name(), 2, paramList);
      return new zzah(Double.valueOf(ByteVector.add(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue()) ^ ByteVector.add(paramHeaders.get((zzap)paramList.get(1)).get().doubleValue())));
    case 9: 
      ByteVector.set(zzbl.name.name(), 2, paramList);
      return new zzah(Double.valueOf(ByteVector.write(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue()) >>> (int)(ByteVector.write(paramHeaders.get((zzap)paramList.get(1)).get().doubleValue()) & 0x1F)));
    case 8: 
      ByteVector.set(zzbl.map.name(), 2, paramList);
      return new zzah(Double.valueOf(ByteVector.add(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue()) >> (int)(ByteVector.write(paramHeaders.get((zzap)paramList.get(1)).get().doubleValue()) & 0x1F)));
    case 7: 
      ByteVector.set(zzbl.code.name(), 2, paramList);
      return new zzah(Double.valueOf(ByteVector.add(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue()) | ByteVector.add(paramHeaders.get((zzap)paramList.get(1)).get().doubleValue())));
    case 6: 
      ByteVector.set(zzbl.message.name(), 1, paramList);
      return new zzah(Double.valueOf(ByteVector.add(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue())));
    case 5: 
      ByteVector.set(zzbl.content.name(), 2, paramList);
      return new zzah(Double.valueOf(ByteVector.add(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue()) << (int)(ByteVector.write(paramHeaders.get((zzap)paramList.get(1)).get().doubleValue()) & 0x1F)));
    }
    ByteVector.set(zzbl.start.name(), 2, paramList);
    return new zzah(Double.valueOf(ByteVector.add(paramHeaders.get((zzap)paramList.get(0)).get().doubleValue()) & ByteVector.add(paramHeaders.get((zzap)paramList.get(1)).get().doubleValue())));
  }
}
