package com.google.android.gms.dynamite.descriptors.io.google.android.internal.measurement.dynamite;

import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.RetainForClient;

@DynamiteApi
@RetainForClient
public class ModuleDescriptor
{
  @RetainForClient
  public static final String MODULE_ID = "com.google.android.gms.measurement.dynamite";
  @RetainForClient
  public static final int MODULE_VERSION = 83;
  
  public ModuleDescriptor() {}
}
