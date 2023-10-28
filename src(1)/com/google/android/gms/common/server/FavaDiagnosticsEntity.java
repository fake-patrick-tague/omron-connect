package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@KeepForSdk
@SafeParcelable.Class(creator="FavaDiagnosticsEntityCreator")
public class FavaDiagnosticsEntity
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @KeepForSdk
  public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new VerticalProgressBar.SavedState.1();
  @SafeParcelable.VersionField(id=1)
  final int major;
  @SafeParcelable.Field(id=2)
  public final String minor;
  @SafeParcelable.Field(id=3)
  public final int txPower;
  
  public FavaDiagnosticsEntity(int paramInt1, String paramString, int paramInt2)
  {
    major = paramInt1;
    minor = paramString;
    txPower = paramInt2;
  }
  
  public FavaDiagnosticsEntity(String paramString, int paramInt)
  {
    major = 1;
    minor = paramString;
    txPower = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, major);
    SafeParcelWriter.writeString(paramParcel, 2, minor, false);
    SafeParcelWriter.writeInt(paramParcel, 3, txPower);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
