package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzka<MessageType extends zzke<MessageType, BuilderType>, BuilderType extends zzka<MessageType, BuilderType>>
  extends zzim<MessageType, BuilderType>
{
  private final zzke roomJid;
  protected zzke this$0;
  protected boolean value;
  
  protected zzka(zzke paramZzke)
  {
    roomJid = paramZzke;
    this$0 = ((zzke)paramZzke.Decode(4, null, null));
    value = false;
  }
  
  private static final void set(zzke paramZzke1, zzke paramZzke2)
  {
    zzlt.decorated().get(paramZzke1.getClass()).a(paramZzke1, paramZzke2);
  }
  
  public final zzka zzaB()
  {
    zzka localZzka = (zzka)roomJid.Decode(5, null, null);
    localZzka.zzaC(zzaF());
    return localZzka;
  }
  
  public final zzka zzaC(zzke paramZzke)
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    set(this$0, paramZzke);
    return this;
  }
  
  public final zzka zzaD(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzjq paramZzjq)
    throws zzko
  {
    if (value)
    {
      zzaI();
      value = false;
    }
    try
    {
      Object localObject = zzlt.decorated();
      zzke localZzke = this$0;
      localObject = ((zzlt)localObject).get(localZzke.getClass());
      localZzke = this$0;
      ((zzlw)localObject).b(localZzke, paramArrayOfByte, 0, paramInt2, new zziq(paramZzjq));
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException("Reading from byte array should not throw IOException.", paramArrayOfByte);
      throw zzko.visitParameterAnnotation();
    }
    catch (zzko paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
    catch (IndexOutOfBoundsException paramArrayOfByte)
    {
      for (;;) {}
    }
  }
  
  public final zzke zzaE()
  {
    zzke localZzke2 = zzaF();
    int i = ((Byte)localZzke2.Decode(1, null, null)).byteValue();
    if (i == 1) {
      return localZzke2;
    }
    if (i != 0)
    {
      boolean bool = zzlt.decorated().get(localZzke2.getClass()).parse(localZzke2);
      zzke localZzke1;
      if (true != bool) {
        localZzke1 = null;
      } else {
        localZzke1 = localZzke2;
      }
      localZzke2.Decode(2, localZzke1, null);
      if (bool) {
        return localZzke2;
      }
    }
    throw new zzmm(localZzke2);
  }
  
  public zzke zzaF()
  {
    if (value) {
      return this$0;
    }
    zzke localZzke = this$0;
    zzlt.decorated().get(localZzke.getClass()).add(localZzke);
    value = true;
    return this$0;
  }
  
  protected void zzaI()
  {
    zzke localZzke = (zzke)this$0.Decode(4, null, null);
    set(localZzke, this$0);
    this$0 = localZzke;
  }
}
