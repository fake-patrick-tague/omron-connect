package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="SendDataRequestCreator")
public final class zzaf
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaf> CREATOR = new zzag();
  @SafeParcelable.Field(id=2)
  private final String accountType;
  @SafeParcelable.VersionField(id=1)
  private final int type = 1;
  @SafeParcelable.Field(id=3)
  private final byte[] zzbp;
  
  zzaf(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    accountType = ((String)Preconditions.checkNotNull(paramString));
    zzbp = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
  }
  
  public zzaf(String paramString, byte[] paramArrayOfByte)
  {
    this(1, paramString, paramArrayOfByte);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, type);
    SafeParcelWriter.writeString(paramParcel, 2, accountType, false);
    SafeParcelWriter.writeByteArray(paramParcel, 3, zzbp, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
