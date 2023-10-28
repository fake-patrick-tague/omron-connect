package androidx.emoji2.text;

import androidx.emoji2.text.asm.Attribute;
import java.io.IOException;
import java.nio.ByteBuffer;

class Type
{
  private static Subsequence a(MethodWriter paramMethodWriter)
    throws IOException
  {
    paramMethodWriter.put(4);
    int k = paramMethodWriter.readUnsignedShort();
    if (k <= 100)
    {
      paramMethodWriter.put(6);
      int j = 0;
      int i = 0;
      while (i < k)
      {
        int m = paramMethodWriter.readInt();
        paramMethodWriter.put(4);
        l1 = paramMethodWriter.read();
        paramMethodWriter.put(4);
        if (1835365473 == m) {
          break label89;
        }
        i += 1;
      }
      long l1 = -1L;
      label89:
      if (l1 != -1L)
      {
        paramMethodWriter.put((int)(l1 - paramMethodWriter.getPosition()));
        paramMethodWriter.put(12);
        long l2 = paramMethodWriter.read();
        i = j;
        while (i < l2)
        {
          j = paramMethodWriter.readInt();
          long l3 = paramMethodWriter.read();
          long l4 = paramMethodWriter.read();
          if ((1164798569 != j) && (1701669481 != j)) {
            i += 1;
          } else {
            return new Subsequence(l3 + l1, l4);
          }
        }
      }
      throw new IOException("Cannot read metadata.");
    }
    throw new IOException("Cannot read metadata.");
  }
  
  static Attribute a(ByteBuffer paramByteBuffer)
    throws IOException
  {
    paramByteBuffer = paramByteBuffer.duplicate();
    paramByteBuffer.position((int)a(new ParsableByteArray(paramByteBuffer)).size());
    return Attribute.read(paramByteBuffer);
  }
  
  static long get(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  static int toUnsignedShort(short paramShort)
  {
    return paramShort & 0xFFFF;
  }
}
