package androidx.room;

import java.util.Arrays;
import java.util.Set;

public abstract class d
{
  final String[] m;
  
  public d(String[] paramArrayOfString)
  {
    m = ((String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length));
  }
  
  public abstract void a(Set paramSet);
  
  boolean b()
  {
    return false;
  }
}
