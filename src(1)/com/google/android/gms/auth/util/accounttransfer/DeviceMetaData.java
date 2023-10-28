package com.google.android.gms.auth.util.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="DeviceMetaDataCreator")
public class DeviceMetaData
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.accounttransfer.DeviceMetaData> CREATOR = new Point.1();
  @SafeParcelable.VersionField(id=1)
  private final int endHour;
  @SafeParcelable.Field(getter="isLockScreenSolved", id=2)
  private boolean zzbs;
  @SafeParcelable.Field(getter="getMinAgeOfLockScreen", id=3)
  private long zzbt;
  @SafeParcelable.Field(getter="isChallengeAllowed", id=4)
  private final boolean zzbu;
  
  DeviceMetaData(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    endHour = paramInt;
    zzbs = paramBoolean1;
    zzbt = paramLong;
    zzbu = paramBoolean2;
  }
  
  public long getMinAgeOfLockScreen()
  {
    return zzbt;
  }
  
  public boolean isChallengeAllowed()
  {
    return zzbu;
  }
  
  public boolean isLockScreenSolved()
  {
    return zzbs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, endHour);
    SafeParcelWriter.writeBoolean(paramParcel, 2, isLockScreenSolved());
    SafeParcelWriter.writeLong(paramParcel, 3, getMinAgeOfLockScreen());
    SafeParcelWriter.writeBoolean(paramParcel, 4, isChallengeAllowed());
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
