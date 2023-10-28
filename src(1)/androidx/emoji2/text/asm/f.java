package androidx.emoji2.text.asm;

import java.nio.ByteBuffer;

public class f
{
  ClassWriter a = ClassWriter.newUTF8();
  private int b;
  protected ByteBuffer c;
  private int e;
  protected int i;
  
  public f() {}
  
  protected int a(int paramInt)
  {
    if (paramInt < b) {
      return c.getShort(e + paramInt);
    }
    return 0;
  }
  
  protected int add(int paramInt)
  {
    return paramInt + c.getInt(paramInt);
  }
  
  protected int b(int paramInt)
  {
    paramInt += i;
    int j = c.getInt(paramInt);
    return c.getInt(paramInt + j);
  }
  
  protected int d(int paramInt)
  {
    paramInt += i;
    return paramInt + c.getInt(paramInt) + 4;
  }
  
  protected void d(int paramInt, ByteBuffer paramByteBuffer)
  {
    c = paramByteBuffer;
    if (paramByteBuffer != null)
    {
      i = paramInt;
      paramInt -= paramByteBuffer.getInt(paramInt);
      e = paramInt;
      b = c.getShort(paramInt);
      return;
    }
    i = 0;
    e = 0;
    b = 0;
  }
}
