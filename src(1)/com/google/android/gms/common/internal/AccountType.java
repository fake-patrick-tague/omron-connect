package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class AccountType
{
  @KeepForSdk
  public static final String GOOGLE = "com.google";
  public static final String[] supported = { "com.google", "com.google.work", "cn.google" };
  
  private AccountType() {}
}
