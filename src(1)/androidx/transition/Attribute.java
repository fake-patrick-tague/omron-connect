package androidx.transition;

import android.os.IBinder;

class Attribute
  implements Node
{
  private final IBinder a;
  
  Attribute(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Attribute)) && (a.equals(a));
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
}
