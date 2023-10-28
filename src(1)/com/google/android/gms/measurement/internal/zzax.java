package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzax
  implements Parcelable.Creator
{
  public zzax() {}
  
  static void writeValue(zzaw paramZzaw, Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, type, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this$0, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, name, false);
    SafeParcelWriter.writeLong(paramParcel, 5, size);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
