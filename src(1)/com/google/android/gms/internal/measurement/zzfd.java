package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzfd
  extends zzka
  implements zzlm
{
  private zzfd()
  {
    super(zzfe.getApplication());
  }
  
  public final zzfc add(int paramInt)
  {
    return ((zzfe)this$0).createEntry(paramInt);
  }
  
  public final List getAllCommands()
  {
    return Collections.unmodifiableList(((zzfe)this$0).getAllItems());
  }
  
  public final String getString()
  {
    return ((zzfe)this$0).getString();
  }
  
  public final List getTerms()
  {
    return Collections.unmodifiableList(((zzfe)this$0).get());
  }
  
  public final zzfd inc()
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfe.goNext((zzfe)this$0);
    return this;
  }
  
  public final zzfd inc(int paramInt, zzfb paramZzfb)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    zzfe.complete((zzfe)this$0, paramInt, (zzfc)paramZzfb.zzaE());
    return this;
  }
  
  public final int removeLast()
  {
    return ((zzfe)this$0).remove();
  }
}
