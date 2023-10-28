package androidx.work.impl.asm;

import java.util.List;

public abstract interface Frame
{
  public abstract void a(Attribute paramAttribute);
  
  public abstract void a(String paramString);
  
  public abstract Attribute get(String paramString);
  
  public abstract List get();
}
