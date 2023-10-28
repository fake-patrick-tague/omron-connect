package com.google.android.gms.internal.fitness;

import java.io.IOException;

public abstract class zzfo<MessageType extends zzfo<MessageType, BuilderType>, BuilderType extends zzfr<MessageType, BuilderType>>
  implements zzik
{
  protected int zztu = 0;
  
  public zzfo() {}
  
  void append(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public final zzfx zzam()
  {
    try
    {
      Object localObject = zzfx.readError(zzbp());
      f(((zzgf)localObject).zzba());
      localObject = ((zzgf)localObject).zzaz();
      return localObject;
    }
    catch (IOException localIOException)
    {
      String str = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 62 + "ByteString".length());
      localStringBuilder.append("Serializing ");
      localStringBuilder.append(str);
      localStringBuilder.append(" to a ");
      localStringBuilder.append("ByteString");
      localStringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
  
  int zzan()
  {
    throw new UnsupportedOperationException();
  }
}
