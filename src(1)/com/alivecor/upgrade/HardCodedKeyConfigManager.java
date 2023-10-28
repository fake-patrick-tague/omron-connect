package com.alivecor.upgrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HardCodedKeyConfigManager
  extends KeyConfigManager
{
  public static final Map<String, com.alivecor.api.KardiaKitConfiguration> HARDCODED_KEYS;
  
  static
  {
    HashMap localHashMap = new HashMap();
    HARDCODED_KEYS = localHashMap;
    localHashMap.put("1234-RLLL-ABCD-EF123", KardiaKitConfigurations.RESTRICT_ALL);
    localHashMap.put("1234-PLLL-ABCD-EF123", KardiaKitConfigurations.PERMIT_ALL);
    localHashMap.put("1234-COMP-ABCD-EF123", KardiaKitConfigurations.PERMIT_OWN_COMPATIBLE);
    localHashMap.put("1234-EXPI-ABCD-EF123", KardiaKitConfigurations.EXPIRED);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AliveCorDevice.TRIANGLE);
    localHashMap.put("HUAMI-TEST-NEED-REAL-VALUE", new KardiaKitConfiguration(localArrayList, KardiaKitConfigurations.GLOBAL_EXPIRATION));
  }
  
  public HardCodedKeyConfigManager(String paramString)
  {
    super(paramString);
  }
  
  protected KardiaKitConfiguration createConfiguration()
  {
    return (KardiaKitConfiguration)HARDCODED_KEYS.get(apiKey);
  }
  
  public boolean validateKey()
  {
    return HARDCODED_KEYS.containsKey(apiKey);
  }
}
