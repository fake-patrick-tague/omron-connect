package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzld
  implements Parcelable.Creator
{
  public zzld() {}
  
  static void writeValue(zzlc paramZzlc, Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, date);
    SafeParcelWriter.writeString(paramParcel, 2, type, false);
    SafeParcelWriter.writeLong(paramParcel, 3, size);
    SafeParcelWriter.writeLongObject(paramParcel, 4, data, false);
    SafeParcelWriter.writeFloatObject(paramParcel, 5, null, false);
    SafeParcelWriter.writeString(paramParcel, 6, key, false);
    SafeParcelWriter.writeString(paramParcel, 7, name, false);
    SafeParcelWriter.writeDoubleObject(paramParcel, 8, value, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
