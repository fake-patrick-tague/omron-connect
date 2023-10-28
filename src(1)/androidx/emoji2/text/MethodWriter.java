package androidx.emoji2.text;

import java.io.IOException;

abstract interface MethodWriter
{
  public abstract long getPosition();
  
  public abstract void put(int paramInt)
    throws IOException;
  
  public abstract long read()
    throws IOException;
  
  public abstract int readInt()
    throws IOException;
  
  public abstract int readUnsignedShort()
    throws IOException;
}
