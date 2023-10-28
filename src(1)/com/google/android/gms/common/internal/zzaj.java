package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Deprecated
@SafeParcelable.Class(creator="ValidateAccountRequestCreator")
public final class zzaj
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaj> CREATOR = new zzak();
  @SafeParcelable.VersionField(id=1)
  final int endHour;
  
  zzaj(int paramInt)
  {
    endHour = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, endHour);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
