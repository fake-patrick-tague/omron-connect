package com.alivecor.upgrade;

abstract class KeyConfigManager
{
  protected final String apiKey;
  
  public KeyConfigManager(String paramString)
  {
    apiKey = paramString;
  }
  
  public final KardiaKitConfiguration configuration()
  {
    if (validateKey()) {
      return createConfiguration();
    }
    throw ApiKeyException.invalidKey(apiKey);
  }
  
  protected abstract KardiaKitConfiguration createConfiguration();
  
  public final boolean isExpired()
  {
    if (configurationexpirationDate != null) {
      return k.a.a.b.H().e(configurationexpirationDate);
    }
    return false;
  }
  
  public abstract boolean validateKey();
  
  public class Permissive
    extends KeyConfigManager
  {
    public Permissive()
    {
      super();
    }
    
    protected KardiaKitConfiguration createConfiguration()
    {
      return KardiaKitConfigurations.PERMIT_OWN_COMPATIBLE;
    }
    
    public boolean validateKey()
    {
      return true;
    }
  }
  
  public class Restrictive
    extends KeyConfigManager
  {
    public Restrictive()
    {
      super();
    }
    
    protected KardiaKitConfiguration createConfiguration()
    {
      return KardiaKitConfigurations.RESTRICT_ALL;
    }
    
    public boolean validateKey()
    {
      return false;
    }
  }
}
