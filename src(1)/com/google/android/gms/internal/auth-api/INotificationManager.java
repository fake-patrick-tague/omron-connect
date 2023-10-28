package com.google.android.gms.internal.auth-api;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.auth.util.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.util.credentials.HintRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

public final class INotificationManager
{
  public static PendingIntent notify(Context paramContext, Auth.AuthCredentialsOptions paramAuthCredentialsOptions, HintRequest paramHintRequest, String paramString)
  {
    Preconditions.checkNotNull(paramContext, "context must not be null");
    Preconditions.checkNotNull(paramHintRequest, "request must not be null");
    if (TextUtils.isEmpty(paramString)) {
      paramAuthCredentialsOptions = zbax.encrypt();
    } else {
      paramAuthCredentialsOptions = (String)Preconditions.checkNotNull(paramString);
    }
    paramString = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("claimedCallingPackage", null);
    paramString.putExtra("logSessionId", paramAuthCredentialsOptions);
    SafeParcelableSerializer.serializeToIntentExtra(paramHintRequest, paramString, "com.google.android.gms.credentials.HintRequest");
    return zbay.notify(paramContext, 2000, paramString, zbay.sound | 0x8000000);
  }
}
