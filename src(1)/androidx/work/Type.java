package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class Type
{
  private final Set<c.a> value = new HashSet();
  
  public Type() {}
  
  public void create(Uri paramUri, boolean paramBoolean)
  {
    paramUri = new Segment(paramUri, paramBoolean);
    value.add(paramUri);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (c.class == paramObject.getClass()))
    {
      paramObject = (Type)paramObject;
      return value.equals(value);
    }
    return false;
  }
  
  public int get()
  {
    return value.size();
  }
  
  public Set getValue()
  {
    return value;
  }
  
  public int hashCode()
  {
    return value.hashCode();
  }
}
