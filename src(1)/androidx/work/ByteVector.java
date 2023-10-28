package androidx.work;

public abstract class ByteVector
{
  public ByteVector() {}
  
  public static ByteVector putByte()
  {
    return new Buffer();
  }
  
  public final Attribute a(String paramString)
  {
    Attribute localAttribute2 = read(paramString);
    Attribute localAttribute1 = localAttribute2;
    if (localAttribute2 == null) {
      localAttribute1 = Attribute.getValue(paramString);
    }
    return localAttribute1;
  }
  
  public abstract Attribute read(String paramString);
}
