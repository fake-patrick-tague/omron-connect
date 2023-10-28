package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class Value
  extends Type
{
  private static final WeakReference NEW = new WeakReference(null);
  private WeakReference state = NEW;
  
  Value(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  protected abstract byte[] encode();
  
  final byte[] getValue()
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])state.get();
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte2 = encode();
        arrayOfByte1 = arrayOfByte2;
        state = new WeakReference(arrayOfByte2);
      }
      return arrayOfByte1;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
