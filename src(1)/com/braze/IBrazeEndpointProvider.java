package com.braze;

import android.net.Uri;

public abstract interface IBrazeEndpointProvider
{
  public abstract Uri getApiEndpoint(Uri paramUri);
}
