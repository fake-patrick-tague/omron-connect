package com.google.android.gms.common.package_12;

import android.text.TextUtils;
import c.e.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;

public class AvailabilityException
  extends Exception
{
  private final a<com.google.android.gms.common.api.internal.ApiKey<?>, ConnectionResult> CACHE;
  
  public AvailabilityException(ArrayMap paramArrayMap)
  {
    CACHE = paramArrayMap;
  }
  
  public ConnectionResult getConnectionResult(GoogleApi paramGoogleApi)
  {
    paramGoogleApi = paramGoogleApi.getApiKey();
    boolean bool;
    if (CACHE.get(paramGoogleApi) != null) {
      bool = true;
    } else {
      bool = false;
    }
    String str = paramGoogleApi.get();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 58);
    localStringBuilder.append("The given API (");
    localStringBuilder.append(str);
    localStringBuilder.append(") was not part of the availability request.");
    Preconditions.checkArgument(bool, localStringBuilder.toString());
    return (ConnectionResult)Preconditions.checkNotNull((ConnectionResult)CACHE.get(paramGoogleApi));
  }
  
  public ConnectionResult getConnectionResult(HasApiKey paramHasApiKey)
  {
    paramHasApiKey = paramHasApiKey.getApiKey();
    boolean bool;
    if (CACHE.get(paramHasApiKey) != null) {
      bool = true;
    } else {
      bool = false;
    }
    String str = paramHasApiKey.get();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 58);
    localStringBuilder.append("The given API (");
    localStringBuilder.append(str);
    localStringBuilder.append(") was not part of the availability request.");
    Preconditions.checkArgument(bool, localStringBuilder.toString());
    return (ConnectionResult)Preconditions.checkNotNull((ConnectionResult)CACHE.get(paramHasApiKey));
  }
  
  public String getMessage()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = CACHE.keySet().iterator();
    boolean bool = true;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (com.google.android.gms.common.package_12.internal.ApiKey)((Iterator)localObject1).next();
      Object localObject3 = (ConnectionResult)Preconditions.checkNotNull((ConnectionResult)CACHE.get(localObject2));
      bool &= (((ConnectionResult)localObject3).isSuccess() ^ true);
      localObject2 = ((com.google.android.gms.common.package_12.internal.ApiKey)localObject2).get();
      localObject3 = String.valueOf(localObject3);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject2).length() + 2 + ((String)localObject3).length());
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(": ");
      localStringBuilder.append((String)localObject3);
      localArrayList.add(localStringBuilder.toString());
    }
    localObject1 = new StringBuilder();
    if (bool) {
      ((StringBuilder)localObject1).append("None of the queried APIs are available. ");
    } else {
      ((StringBuilder)localObject1).append("Some of the queried APIs are unavailable. ");
    }
    ((StringBuilder)localObject1).append(TextUtils.join("; ", localArrayList));
    return ((StringBuilder)localObject1).toString();
  }
}
