package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="StringToIntConverterEntryCreator")
public final class Album
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zac> CREATOR = new DiscreteSeekBar.CustomState.1();
  @SafeParcelable.Field(id=3)
  final int mIcon;
  @SafeParcelable.VersionField(id=1)
  final int mId;
  @SafeParcelable.Field(id=2)
  final String mName;
  
  Album(int paramInt1, String paramString, int paramInt2)
  {
    mId = paramInt1;
    mName = paramString;
    mIcon = paramInt2;
  }
  
  Album(String paramString, int paramInt)
  {
    mId = 1;
    mName = paramString;
    mIcon = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, mId);
    SafeParcelWriter.writeString(paramParcel, 2, mName, false);
    SafeParcelWriter.writeInt(paramParcel, 3, mIcon);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
