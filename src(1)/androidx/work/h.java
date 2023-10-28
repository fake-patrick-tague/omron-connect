package androidx.work;

import java.util.Set;
import java.util.UUID;

public abstract class h
{
  private androidx.work.impl.asm.h c;
  private UUID d;
  private Set<String> s;
  
  protected h(UUID paramUUID, androidx.work.impl.asm.h paramH, Set paramSet)
  {
    d = paramUUID;
    c = paramH;
    s = paramSet;
  }
  
  public String a()
  {
    return d.toString();
  }
  
  public androidx.work.impl.asm.h c()
  {
    return c;
  }
  
  public Set d()
  {
    return s;
  }
}
