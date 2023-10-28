package com.alivecor.universal_monitor.bluetooth.configurations;

class HexString
{
  private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
  
  private HexString() {}
  
  static String bytesToHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar2 = HEX_ARRAY;
      arrayOfChar1[k] = arrayOfChar2[(j >>> 4)];
      arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
  
  static byte[] hexToBytes(String paramString)
  {
    if (paramString.length() % 2 != 1)
    {
      int j = paramString.length();
      byte[] arrayOfByte = new byte[j / 2];
      int i = 0;
      while (i < j)
      {
        arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
        i += 2;
      }
      return arrayOfByte;
    }
    throw new IllegalArgumentException("hexToBytes requires an even-length String parameter");
  }
}
