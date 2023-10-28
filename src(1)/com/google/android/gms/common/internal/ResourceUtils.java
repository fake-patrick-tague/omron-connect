package com.google.android.gms.common.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class ResourceUtils
{
  private static final Uri CONTENT_URI = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();
  
  private ResourceUtils() {}
}
