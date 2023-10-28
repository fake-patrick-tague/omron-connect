package androidx.emoji2.text.asm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Attribute
  extends f
{
  public Attribute() {}
  
  public static Attribute read(ByteBuffer paramByteBuffer)
  {
    return read(paramByteBuffer, new Attribute());
  }
  
  public static Attribute read(ByteBuffer paramByteBuffer, Attribute paramAttribute)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return paramAttribute.decode(paramByteBuffer.getInt(paramByteBuffer.position()) + paramByteBuffer.position(), paramByteBuffer);
  }
  
  public int a()
  {
    int i = a(6);
    if (i != 0) {
      return b(i);
    }
    return 0;
  }
  
  public i a(i paramI, int paramInt)
  {
    int i = a(6);
    if (i != 0) {
      return paramI.a(add(d(i) + paramInt * 4), c);
    }
    return null;
  }
  
  public int b()
  {
    int i = a(4);
    if (i != 0) {
      return c.getInt(i + this.i);
    }
    return 0;
  }
  
  public void clear(int paramInt, ByteBuffer paramByteBuffer)
  {
    d(paramInt, paramByteBuffer);
  }
  
  public Attribute decode(int paramInt, ByteBuffer paramByteBuffer)
  {
    clear(paramInt, paramByteBuffer);
    return this;
  }
}
