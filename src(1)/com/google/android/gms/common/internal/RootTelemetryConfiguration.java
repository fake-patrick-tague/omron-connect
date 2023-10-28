package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@KeepForSdk
@SafeParcelable.Class(creator="RootTelemetryConfigurationCreator")
public class RootTelemetryConfiguration
  extends AbstractSafeParcelable
{
  @KeepForSdk
  public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzai();
  @SafeParcelable.Field(getter="getBatchPeriodMillis", id=4)
  private final int disabled;
  @SafeParcelable.Field(getter="getMaxMethodInvocationsInBatch", id=5)
  private final int offline;
  @SafeParcelable.Field(getter="getMethodInvocationTelemetryEnabled", id=2)
  private final boolean read;
  @SafeParcelable.Field(getter="getMethodTimingTelemetryEnabled", id=3)
  private final boolean starred;
  @SafeParcelable.Field(getter="getVersion", id=1)
  private final int version_;
  
  public RootTelemetryConfiguration(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    version_ = paramInt1;
    read = paramBoolean1;
    starred = paramBoolean2;
    disabled = paramInt2;
    offline = paramInt3;
  }
  
  public int getBatchPeriodMillis()
  {
    return disabled;
  }
  
  public int getMaxMethodInvocationsInBatch()
  {
    return offline;
  }
  
  public boolean getMethodInvocationTelemetryEnabled()
  {
    return read;
  }
  
  public boolean getMethodTimingTelemetryEnabled()
  {
    return starred;
  }
  
  public int getVersion()
  {
    return version_;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getVersion());
    SafeParcelWriter.writeBoolean(paramParcel, 2, getMethodInvocationTelemetryEnabled());
    SafeParcelWriter.writeBoolean(paramParcel, 3, getMethodTimingTelemetryEnabled());
    SafeParcelWriter.writeInt(paramParcel, 4, getBatchPeriodMillis());
    SafeParcelWriter.writeInt(paramParcel, 5, getMaxMethodInvocationsInBatch());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
