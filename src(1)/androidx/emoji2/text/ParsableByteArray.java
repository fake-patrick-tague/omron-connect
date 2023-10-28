package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class ParsableByteArray
  implements MethodWriter
{
  private final ByteBuffer data;
  
  ParsableByteArray(ByteBuffer paramByteBuffer)
  {
    data = paramByteBuffer;
    paramByteBuffer.order(ByteOrder.BIG_ENDIAN);
  }
  
  public long getPosition()
  {
    return data.position();
  }
  
  public void put(int paramInt)
    throws IOException
  {
    ByteBuffer localByteBuffer = data;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
  }
  
  public long read()
    throws IOException
  {
    return Type.get(data.getInt());
  }
  
  public int readInt()
    throws IOException
  {
    return data.getInt();
  }
  
  public int readUnsignedShort()
    throws IOException
  {
    return Type.toUnsignedShort(data.getShort());
  }
}
