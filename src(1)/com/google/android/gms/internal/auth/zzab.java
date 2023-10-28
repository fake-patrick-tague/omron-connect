package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="NotifyCompletionRequestCreator")
public final class zzab
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzab> CREATOR = new zzac();
  @SafeParcelable.Field(id=2)
  private final String accountType;
  @SafeParcelable.VersionField(id=1)
  private final int type = 1;
  @SafeParcelable.Field(id=3)
  private final int zzbw;
  
  zzab(int paramInt1, String paramString, int paramInt2)
  {
    accountType = ((String)Preconditions.checkNotNull(paramString));
    zzbw = paramInt2;
  }
  
  public zzab(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, type);
    SafeParcelWriter.writeString(paramParcel, 2, accountType, false);
    SafeParcelWriter.writeInt(paramParcel, 3, zzbw);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
