package com.google.android.gms.common;

import java.util.Arrays;

final class OmniPhoneNumber
  extends Type
{
  private final byte[] value;
  
  OmniPhoneNumber(byte[] paramArrayOfByte)
  {
    super(Arrays.copyOfRange(paramArrayOfByte, 0, 25));
    value = paramArrayOfByte;
  }
  
  final byte[] getValue()
  {
    return value;
  }
}
