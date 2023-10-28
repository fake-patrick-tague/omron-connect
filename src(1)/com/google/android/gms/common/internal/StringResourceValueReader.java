package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R.string;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class StringResourceValueReader
{
  private final Resources mRes;
  private final String mResId;
  
  public StringResourceValueReader(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    paramContext = paramContext.getResources();
    mRes = paramContext;
    mResId = paramContext.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  public String getString(String paramString)
  {
    int i = mRes.getIdentifier(paramString, "string", mResId);
    if (i == 0) {
      return null;
    }
    return mRes.getString(i);
  }
}
