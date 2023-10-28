package com.google.android.gms.auth.util.proxy;

import android.app.PendingIntent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdkWithMembers
@SafeParcelable.Class(creator="ProxyResponseCreator")
public class ProxyResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.proxy.ProxyResponse> CREATOR = new DiscreteSeekBar.CustomState.1();
  public static final int STATUS_CODE_NO_CONNECTION = -1;
  @SafeParcelable.Field(id=5)
  public final byte[] body;
  @SafeParcelable.Field(id=1)
  public final int googlePlayServicesStatusCode;
  @SafeParcelable.Field(id=2)
  public final PendingIntent recoveryAction;
  @SafeParcelable.Field(id=3)
  public final int statusCode;
  @SafeParcelable.VersionField(id=1000)
  private final int versionCode;
  @SafeParcelable.Field(id=4)
  private final Bundle zzby;
  
  ProxyResponse(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, int paramInt3, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    versionCode = paramInt1;
    googlePlayServicesStatusCode = paramInt2;
    statusCode = paramInt3;
    zzby = paramBundle;
    body = paramArrayOfByte;
    recoveryAction = paramPendingIntent;
  }
  
  public ProxyResponse(int paramInt1, PendingIntent paramPendingIntent, int paramInt2, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this(1, paramInt1, paramPendingIntent, paramInt2, paramBundle, paramArrayOfByte);
  }
  
  private ProxyResponse(int paramInt, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    this(1, 0, null, paramInt, paramBundle, paramArrayOfByte);
  }
  
  public ProxyResponse(int paramInt, Map paramMap, byte[] paramArrayOfByte)
  {
    this(paramInt, add(paramMap), paramArrayOfByte);
  }
  
  private static Bundle add(Map paramMap)
  {
    Bundle localBundle = new Bundle();
    if (paramMap == null) {
      return localBundle;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localBundle.putString((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localBundle;
  }
  
  public static ProxyResponse createErrorProxyResponse(int paramInt1, PendingIntent paramPendingIntent, int paramInt2, Map paramMap, byte[] paramArrayOfByte)
  {
    return new ProxyResponse(1, paramInt1, paramPendingIntent, paramInt2, add(paramMap), paramArrayOfByte);
  }
  
  public Map getHeaders()
  {
    if (zzby == null) {
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzby.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, zzby.getString(str));
    }
    return localHashMap;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, googlePlayServicesStatusCode);
    SafeParcelWriter.writeParcelable(paramParcel, 2, recoveryAction, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, statusCode);
    SafeParcelWriter.writeBundle(paramParcel, 4, zzby, false);
    SafeParcelWriter.writeByteArray(paramParcel, 5, body, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, versionCode);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
