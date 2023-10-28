package com.google.android.gms.auth.util.accounttransfer;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.accounttransfer.zzn;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.internal.auth.HttpClientAndroidLog;
import com.google.android.gms.internal.auth.zzu;

public final class AccountTransfer
{
  public static final String ACTION_ACCOUNT_EXPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_EXPORT_DATA_AVAILABLE";
  public static final String ACTION_ACCOUNT_IMPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_IMPORT_DATA_AVAILABLE";
  public static final String ACTION_START_ACCOUNT_EXPORT = "com.google.android.gms.auth.START_ACCOUNT_EXPORT";
  public static final String KEY_EXTRA_ACCOUNT_TYPE = "key_extra_account_type";
  private static final com.google.android.gms.common.api.Api.ClientKey<zzu> zzaj;
  private static final Api.AbstractClientBuilder<zzu, zzn> zzak;
  private static final Api<zzn> zzal;
  @Deprecated
  private static final DiskBasedCache zzam = (DiskBasedCache)new HttpClientAndroidLog();
  private static final DecoderFactory zzan = (DecoderFactory)new HttpClientAndroidLog();
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey = new com.google.android.gms.common.package_12.Api.ClientKey();
    zzaj = localClientKey;
    SettingsActivity.2 local2 = new SettingsActivity.2();
    zzak = local2;
    zzal = new Attribute("AccountTransfer.ACCOUNT_TRANSFER_API", local2, localClientKey);
  }
  
  private AccountTransfer() {}
  
  public static AccountTransferClient getAccountTransferClient(Activity paramActivity)
  {
    return new AccountTransferClient(paramActivity);
  }
  
  public static AccountTransferClient getAccountTransferClient(Context paramContext)
  {
    return new AccountTransferClient(paramContext);
  }
}
