package com.google.android.gms.auth.util.proxy;

import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@KeepForSdkWithMembers
@SafeParcelable.Class(creator="ProxyRequestCreator")
public class ProxyRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.proxy.ProxyRequest> CREATOR = new VerticalProgressBar.SavedState.1();
  public static final int HTTP_METHOD_DELETE;
  public static final int HTTP_METHOD_GET = 0;
  public static final int HTTP_METHOD_HEAD;
  public static final int HTTP_METHOD_OPTIONS;
  public static final int HTTP_METHOD_PATCH = 7;
  public static final int HTTP_METHOD_POST = 1;
  public static final int HTTP_METHOD_PUT = 2;
  public static final int HTTP_METHOD_TRACE;
  public static final int LAST_CODE = 7;
  public static final int VERSION_CODE = 2;
  @SafeParcelable.Field(id=4)
  public final byte[] body;
  @SafeParcelable.Field(id=2)
  public final int httpMethod;
  @SafeParcelable.Field(id=1)
  public final String method;
  @SafeParcelable.Field(id=3)
  public final long timeoutMillis;
  @SafeParcelable.VersionField(id=1000)
  private final int versionCode;
  @SafeParcelable.Field(id=5)
  private Bundle zzby;
  
  static
  {
    HTTP_METHOD_DELETE = 3;
    HTTP_METHOD_HEAD = 4;
    HTTP_METHOD_OPTIONS = 5;
    HTTP_METHOD_TRACE = 6;
  }
  
  ProxyRequest(int paramInt1, String paramString, int paramInt2, long paramLong, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    versionCode = paramInt1;
    method = paramString;
    httpMethod = paramInt2;
    timeoutMillis = paramLong;
    body = paramArrayOfByte;
    zzby = paramBundle;
  }
  
  public Map getHeaderMap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(zzby.size());
    Iterator localIterator = zzby.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedHashMap.put(str, zzby.getString(str));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  public String toString()
  {
    String str = method;
    int i = httpMethod;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 42);
    localStringBuilder.append("ProxyRequest[ url: ");
    localStringBuilder.append(str);
    localStringBuilder.append(", method: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" ]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, method, false);
    SafeParcelWriter.writeInt(paramParcel, 2, httpMethod);
    SafeParcelWriter.writeLong(paramParcel, 3, timeoutMillis);
    SafeParcelWriter.writeByteArray(paramParcel, 4, body, false);
    SafeParcelWriter.writeBundle(paramParcel, 5, zzby, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, versionCode);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  @KeepForSdkWithMembers
  public class Builder
  {
    private int zzca = ProxyRequest.HTTP_METHOD_GET;
    private long zzcb = 3000L;
    private byte[] zzcc = null;
    private Bundle zzcd = new Bundle();
    
    public Builder()
    {
      Preconditions.checkNotEmpty(ProxyRequest.this);
      if (Patterns.WEB_URL.matcher(ProxyRequest.this).matches()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(ProxyRequest.this).length() + 51);
      localStringBuilder.append("The supplied url [ ");
      localStringBuilder.append(ProxyRequest.this);
      localStringBuilder.append("] is not match Patterns.WEB_URL!");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public ProxyRequest build()
    {
      if (zzcc == null) {
        zzcc = new byte[0];
      }
      return new ProxyRequest(2, ProxyRequest.this, zzca, zzcb, zzcc, zzcd);
    }
    
    public Builder putHeader(String paramString1, String paramString2)
    {
      Preconditions.checkNotEmpty(paramString1, "Header name cannot be null or empty!");
      Bundle localBundle = zzcd;
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localBundle.putString(paramString1, str);
      return this;
    }
    
    public Builder setBody(byte[] paramArrayOfByte)
    {
      zzcc = paramArrayOfByte;
      return this;
    }
    
    public Builder setHttpMethod(int paramInt)
    {
      boolean bool;
      if ((paramInt >= 0) && (paramInt <= ProxyRequest.LAST_CODE)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Unrecognized http method code.");
      zzca = paramInt;
      return this;
    }
    
    public Builder setTimeoutMillis(long paramLong)
    {
      boolean bool;
      if (paramLong >= 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "The specified timeout must be non-negative.");
      zzcb = paramLong;
      return this;
    }
  }
}
