package androidx.work.impl.ui;

public class Handle
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public Handle(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    a = paramBoolean1;
    b = paramBoolean2;
    c = paramBoolean3;
    d = paramBoolean4;
  }
  
  public boolean a()
  {
    return d;
  }
  
  public boolean equals()
  {
    return a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Handle)) {
      return false;
    }
    paramObject = (Handle)paramObject;
    return (a == a) && (b == b) && (c == c) && (d == d);
  }
  
  public boolean getName()
  {
    return c;
  }
  
  public boolean getOwner()
  {
    return b;
  }
  
  public int hashCode()
  {
    if (a) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (b) {
      i = j + 16;
    }
    int j = i;
    if (c) {
      j = i + 256;
    }
    i = j;
    if (d) {
      i = j + 4096;
    }
    return i;
  }
  
  public String toString()
  {
    return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[] { Boolean.valueOf(a), Boolean.valueOf(b), Boolean.valueOf(c), Boolean.valueOf(d) });
  }
}
