package com.alivecor.upgrade;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

class HmacKeyConfigManager
  extends KeyConfigManager
{
  private final String appPackageName;
  private final boolean isValid;
  
  public HmacKeyConfigManager(String paramString1, String paramString2)
  {
    super(paramString1);
    appPackageName = paramString2;
    isValid = doValidate(digest());
  }
  
  private byte[] dataBytes()
  {
    return appPackageName.getBytes(StandardCharsets.US_ASCII);
  }
  
  private byte[] digest()
  {
    try
    {
      Object localObject = Mac.getInstance("HmacSHA1");
      ((Mac)localObject).init(new SecretKeySpec(secretBytes("djJkX3FMckpnWkpOaVwhSDNtRQo="), "HmacSHA1"));
      localObject = ((Mac)localObject).doFinal(dataBytes());
      return localObject;
    }
    catch (InvalidKeyException localInvalidKeyException) {}catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    throw new RuntimeException(localNoSuchAlgorithmException);
  }
  
  private boolean doValidate(byte[] paramArrayOfByte)
  {
    return Arrays.equals(Base64.decode(keyBytes(), 0), paramArrayOfByte);
  }
  
  private byte[] keyBytes()
  {
    return apiKey.getBytes(StandardCharsets.US_ASCII);
  }
  
  private byte[] secretBytes(String paramString)
  {
    return Base64.decode(paramString.getBytes(StandardCharsets.US_ASCII), 0);
  }
  
  protected KardiaKitConfiguration createConfiguration()
  {
    return KardiaKitConfigurations.createForApplication(appPackageName);
  }
  
  public boolean validateKey()
  {
    return isValid;
  }
}
