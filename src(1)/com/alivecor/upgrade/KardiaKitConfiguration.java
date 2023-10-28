package com.alivecor.upgrade;

import com.alivecor.api.AliveCorDevice;
import com.google.gson.v.c;
import java.util.Collections;
import java.util.List;
import k.a.a.b;

class KardiaKitConfiguration
{
  @c("devices")
  public final List<AliveCorDevice> enabledDevices;
  public final b expirationDate;
  
  public KardiaKitConfiguration(List paramList, b paramB)
  {
    enabledDevices = Collections.unmodifiableList(paramList);
    expirationDate = paramB;
  }
}
