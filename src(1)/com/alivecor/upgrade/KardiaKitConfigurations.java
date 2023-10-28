package com.alivecor.upgrade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k.a.a.b;

class KardiaKitConfigurations
{
  public static final KardiaKitConfiguration EXPIRED;
  public static final b GLOBAL_EXPIRATION;
  public static final KardiaKitConfiguration ONLY_TRIANGLE;
  public static final KardiaKitConfiguration PERMIT_ALL;
  public static final KardiaKitConfiguration PERMIT_ALL_COMPATIBLE;
  public static final KardiaKitConfiguration PERMIT_OWN_COMPATIBLE;
  public static final KardiaKitConfiguration RESTRICT_ALL;
  
  static
  {
    b localB = b.H().O().P(2020).N(10).L(31).I(1);
    GLOBAL_EXPIRATION = localB;
    RESTRICT_ALL = new KardiaKitConfiguration(new ArrayList(), localB);
    PERMIT_ALL = new KardiaKitConfiguration(new ArrayList(Arrays.asList(AliveCorDevice.values())), localB);
    ArrayList localArrayList1 = new ArrayList();
    AliveCorDevice localAliveCorDevice1 = AliveCorDevice.TRIANGLE;
    localArrayList1.add(localAliveCorDevice1);
    AliveCorDevice localAliveCorDevice2 = AliveCorDevice.KARDIA_MOBILE;
    localArrayList1.add(localAliveCorDevice2);
    PERMIT_OWN_COMPATIBLE = new KardiaKitConfiguration(localArrayList1, localB);
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(localAliveCorDevice1);
    localArrayList2.add(localAliveCorDevice2);
    localArrayList2.add(AliveCorDevice.OMRON_COMPLETE);
    PERMIT_ALL_COMPATIBLE = new KardiaKitConfiguration(localArrayList2, localB);
    EXPIRED = new KardiaKitConfiguration(localArrayList1, b.H().O().P(1990));
    localArrayList1 = new ArrayList();
    localArrayList1.add(localAliveCorDevice1);
    ONLY_TRIANGLE = new KardiaKitConfiguration(localArrayList1, localB);
  }
  
  private KardiaKitConfigurations()
  {
    throw new UnsupportedOperationException("No Instances Allowed");
  }
  
  static KardiaKitConfiguration createForApplication(String paramString)
  {
    if (paramString.startsWith("com.alivecor.")) {
      return new KardiaKitConfiguration(PERMIT_ALL_COMPATIBLEenabledDevices, null);
    }
    if ((!paramString.startsWith("jp.co.omron")) && (!paramString.startsWith("com.omronhealthcare")) && (!paramString.startsWith("com.zhizhong")) && (!paramString.startsWith("cn.com.omronhealthcare"))) {
      return ONLY_TRIANGLE;
    }
    return new KardiaKitConfiguration(PERMIT_ALL_COMPATIBLEenabledDevices, null);
  }
}
