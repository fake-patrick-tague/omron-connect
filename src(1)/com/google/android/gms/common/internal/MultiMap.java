package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.package_12.Api.Client;

public final class MultiMap
{
  private final SparseIntArray data = new SparseIntArray();
  private GoogleApiAvailabilityLight storage;
  
  public MultiMap()
  {
    this(GoogleApiAvailability.getInstance());
  }
  
  public MultiMap(GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight)
  {
    Preconditions.checkNotNull(paramGoogleApiAvailabilityLight);
    storage = paramGoogleApiAvailabilityLight;
  }
  
  public final int add(Context paramContext, int paramInt)
  {
    return data.get(paramInt, -1);
  }
  
  public final int add(Context paramContext, Api.Client paramClient)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramClient);
    boolean bool = paramClient.requiresGooglePlayServices();
    int j = 0;
    if (!bool) {
      return 0;
    }
    int k = paramClient.getMinApkVersion();
    int i = add(paramContext, k);
    if (i != -1) {
      return i;
    }
    i = 0;
    while (i < data.size())
    {
      int m = data.keyAt(i);
      if ((m > k) && (data.get(m) == 0))
      {
        i = j;
        break label108;
      }
      i += 1;
    }
    i = -1;
    label108:
    if (i == -1) {
      i = storage.isGooglePlayServicesAvailable(paramContext, k);
    }
    data.put(k, i);
    return i;
  }
  
  public final void add()
  {
    data.clear();
  }
}
