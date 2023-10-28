package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzfr
  extends zzka
  implements zzlm
{
  private zzfr()
  {
    super(zzfs.getTimeStamp());
  }
  
  public final zzfr append(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfs.set((zzfs)this$0, paramLong);
    return this;
  }
  
  public final zzfr descend()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfs.readFromParcel((zzfs)this$0);
    return this;
  }
  
  public final zzfr descend(zzfw paramZzfw)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfs.readFromParcel((zzfs)this$0, paramZzfw);
    return this;
  }
  
  public final zzfr descend(Iterable paramIterable)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfs.readFromParcel((zzfs)this$0, paramIterable);
    return this;
  }
  
  public final List getCells()
  {
    return Collections.unmodifiableList(((zzfs)this$0).get());
  }
  
  public final zzfw getEdge(int paramInt)
  {
    return ((zzfs)this$0).getEdge(paramInt);
  }
  
  public final long getKey()
  {
    return ((zzfs)this$0).read();
  }
  
  public final zzfr getKey(zzfv paramZzfv)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfs.readFromParcel((zzfs)this$0, (zzfw)paramZzfv.zzaE());
    return this;
  }
  
  public final long getLast()
  {
    return ((zzfs)this$0).next();
  }
  
  public final String getValue()
  {
    return ((zzfs)this$0).getValue();
  }
  
  public final boolean isEmpty()
  {
    return ((zzfs)this$0).equals();
  }
  
  public final zzfr put(String paramString)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfs.visit((zzfs)this$0, paramString);
    return this;
  }
  
  public final zzfr readFrom(int paramInt)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfs.readValue((zzfs)this$0, paramInt);
    return this;
  }
  
  public final zzfr setTime(int paramInt, zzfv paramZzfv)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfs.readFromParcel((zzfs)this$0, paramInt, (zzfw)paramZzfv.zzaE());
    return this;
  }
  
  public final zzfr setTime(int paramInt, zzfw paramZzfw)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfs.readFromParcel((zzfs)this$0, paramInt, paramZzfw);
    return this;
  }
  
  public final int sizeOf()
  {
    return ((zzfs)this$0).length();
  }
  
  public final zzfr truncate(long paramLong)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfs.append((zzfs)this$0, paramLong);
    return this;
  }
}
