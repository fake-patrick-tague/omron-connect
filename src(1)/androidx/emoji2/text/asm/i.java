package androidx.emoji2.text.asm;

import java.nio.ByteBuffer;

public final class i
  extends f
{
  public i() {}
  
  public int a()
  {
    int i = a(16);
    if (i != 0) {
      return b(i);
    }
    return 0;
  }
  
  public i a(int paramInt, ByteBuffer paramByteBuffer)
  {
    clear(paramInt, paramByteBuffer);
    return this;
  }
  
  public short add()
  {
    int i = a(12);
    if (i != 0) {
      return c.getShort(i + this.i);
    }
    return 0;
  }
  
  public short b()
  {
    int i = a(14);
    if (i != 0) {
      return c.getShort(i + this.i);
    }
    return 0;
  }
  
  public int c(int paramInt)
  {
    int i = a(16);
    if (i != 0) {
      return c.getInt(d(i) + paramInt * 4);
    }
    return 0;
  }
  
  public short c()
  {
    int i = a(8);
    if (i != 0) {
      return c.getShort(i + this.i);
    }
    return 0;
  }
  
  public void clear(int paramInt, ByteBuffer paramByteBuffer)
  {
    d(paramInt, paramByteBuffer);
  }
  
  public int e()
  {
    int i = a(4);
    if (i != 0) {
      return c.getInt(i + this.i);
    }
    return 0;
  }
  
  public boolean f()
  {
    int i = a(6);
    return (i != 0) && (c.get(i + this.i) != 0);
  }
}
