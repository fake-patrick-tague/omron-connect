package com.google.android.gms.internal.auth-api;

import android.util.Base64;
import java.util.Random;

public final class zbax
{
  private static final Random rnd = new Random();
  
  public static String encrypt()
  {
    byte[] arrayOfByte = new byte[16];
    rnd.nextBytes(arrayOfByte);
    return Base64.encodeToString(arrayOfByte, 11);
  }
}
