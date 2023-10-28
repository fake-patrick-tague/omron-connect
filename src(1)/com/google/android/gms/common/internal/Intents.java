package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;

public final class Intents
{
  private static final Uri CONTENT_URI;
  private static final Uri THREAD_ID_CONTENT_URI;
  
  static
  {
    Uri localUri = Uri.parse("https://plus.google.com/");
    THREAD_ID_CONTENT_URI = localUri;
    CONTENT_URI = localUri.buildUpon().appendPath("circles").appendPath("find").build();
  }
  
  public static Intent createIntent()
  {
    Intent localIntent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
    localIntent.setPackage("com.google.android.wearable.app");
    return localIntent;
  }
  
  public static Intent execute(String paramString1, String paramString2)
  {
    paramString1 = new Intent("android.intent.action.VIEW");
    Uri.Builder localBuilder = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
    if (!TextUtils.isEmpty(paramString2)) {
      localBuilder.appendQueryParameter("pcampaignid", paramString2);
    }
    paramString1.setData(localBuilder.build());
    paramString1.setPackage("com.android.vending");
    paramString1.addFlags(524288);
    return paramString1;
  }
  
  public static Intent showInstalledAppDetails(String paramString)
  {
    paramString = Uri.fromParts("package", "com.google.android.gms", null);
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(paramString);
    return localIntent;
  }
}
