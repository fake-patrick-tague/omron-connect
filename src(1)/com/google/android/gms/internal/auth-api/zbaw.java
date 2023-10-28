package com.google.android.gms.internal.auth-api;

import com.google.android.gms.common.Feature;

public final class zbaw
{
  public static final Feature CONSTRAINT;
  public static final Feature[] JSON_EXCEPTION;
  public static final Feature MISMATCH;
  public static final Feature OUT_OF_MEMORY;
  public static final Feature SATURATION;
  public static final Feature SCHEMA;
  public static final Feature TOOBIG;
  public static final Feature macro;
  
  static
  {
    Feature localFeature1 = new Feature("auth_api_credentials_begin_sign_in", 4L);
    SATURATION = localFeature1;
    Feature localFeature2 = new Feature("auth_api_credentials_sign_out", 2L);
    SCHEMA = localFeature2;
    Feature localFeature3 = new Feature("auth_api_credentials_authorize", 1L);
    TOOBIG = localFeature3;
    Feature localFeature4 = new Feature("auth_api_credentials_revoke_access", 1L);
    CONSTRAINT = localFeature4;
    Feature localFeature5 = new Feature("auth_api_credentials_save_password", 3L);
    MISMATCH = localFeature5;
    Feature localFeature6 = new Feature("auth_api_credentials_get_sign_in_intent", 4L);
    OUT_OF_MEMORY = localFeature6;
    Feature localFeature7 = new Feature("auth_api_credentials_save_account_linking_token", 2L);
    macro = localFeature7;
    JSON_EXCEPTION = new Feature[] { localFeature1, localFeature2, localFeature3, localFeature4, localFeature5, localFeature6, localFeature7 };
  }
}
