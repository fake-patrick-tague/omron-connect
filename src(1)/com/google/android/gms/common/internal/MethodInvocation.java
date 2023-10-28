package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@KeepForSdk
@SafeParcelable.Class(creator="MethodInvocationCreator")
public class MethodInvocation
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<MethodInvocation> CREATOR = new PaymentIntent.1();
  @SafeParcelable.Field(defaultValue="0", getter="getServiceId", id=8)
  private final int mArgString;
  @SafeParcelable.Field(getter="getResultStatusCode", id=2)
  private final int mFlags;
  @SafeParcelable.Field(defaultValue="-1", getter="getLatencyMillis", id=9)
  private final int mHelp;
  @SafeParcelable.Field(getter="getConnectionResultStatusCode", id=3)
  private final int mPermissions;
  @SafeParcelable.Field(getter="getStartTimeMillis", id=4)
  private final long mRemoteId;
  @SafeParcelable.Field(getter="getEndTimeMillis", id=5)
  private final long mSize;
  @SafeParcelable.Field(getter="getCallingModuleId", id=6)
  private final String mStatusKey;
  @SafeParcelable.Field(getter="getCallingEntryPoint", id=7)
  private final String mStatusValue;
  @SafeParcelable.Field(getter="getMethodKey", id=1)
  private final int mType;
  
  public MethodInvocation(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramString1, paramString2, paramInt4, -1);
  }
  
  public MethodInvocation(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt4, int paramInt5)
  {
    mType = paramInt1;
    mFlags = paramInt2;
    mPermissions = paramInt3;
    mRemoteId = paramLong1;
    mSize = paramLong2;
    mStatusKey = paramString1;
    mStatusValue = paramString2;
    mArgString = paramInt4;
    mHelp = paramInt5;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, mType);
    SafeParcelWriter.writeInt(paramParcel, 2, mFlags);
    SafeParcelWriter.writeInt(paramParcel, 3, mPermissions);
    SafeParcelWriter.writeLong(paramParcel, 4, mRemoteId);
    SafeParcelWriter.writeLong(paramParcel, 5, mSize);
    SafeParcelWriter.writeString(paramParcel, 6, mStatusKey, false);
    SafeParcelWriter.writeString(paramParcel, 7, mStatusValue, false);
    SafeParcelWriter.writeInt(paramParcel, 8, mArgString);
    SafeParcelWriter.writeInt(paramParcel, 9, mHelp);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
