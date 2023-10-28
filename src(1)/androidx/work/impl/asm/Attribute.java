package androidx.work.impl.asm;

public class Attribute
{
  public final int a;
  public final String b;
  
  public Attribute(String paramString, int paramInt)
  {
    b = paramString;
    a = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Attribute)) {
      return false;
    }
    paramObject = (Attribute)paramObject;
    if (a != a) {
      return false;
    }
    return b.equals(b);
  }
  
  public int hashCode()
  {
    return b.hashCode() * 31 + a;
  }
}
