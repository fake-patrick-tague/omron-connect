package androidx.work.impl.asm;

public class Type
{
  public String a;
  public Long b;
  
  public Type(String paramString, long paramLong)
  {
    a = paramString;
    b = Long.valueOf(paramLong);
  }
  
  public Type(String paramString, boolean paramBoolean)
  {
    this(paramString, l);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Type)) {
      return false;
    }
    Object localObject = (Type)paramObject;
    if (!a.equals(a)) {
      return false;
    }
    paramObject = b;
    localObject = b;
    if (paramObject != null) {
      return paramObject.equals(localObject);
    }
    return localObject == null;
  }
  
  public int hashCode()
  {
    int j = a.hashCode();
    Long localLong = b;
    int i;
    if (localLong != null) {
      i = localLong.hashCode();
    } else {
      i = 0;
    }
    return j * 31 + i;
  }
}
