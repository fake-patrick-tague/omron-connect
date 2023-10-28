package androidx.work.impl.asm;

import androidx.work.WorkInfo.State;

public class Handle
{
  public WorkInfo.State a;
  public String b;
  
  public Handle() {}
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Handle)) {
      return false;
    }
    paramObject = (Handle)paramObject;
    if (a != a) {
      return false;
    }
    return b.equals(b);
  }
  
  public int hashCode()
  {
    return b.hashCode() * 31 + a.hashCode();
  }
}
