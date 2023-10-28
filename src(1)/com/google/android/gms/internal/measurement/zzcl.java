package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="InitializationParamsCreator")
public final class zzcl
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzcl> CREATOR = new zzcm();
  @SafeParcelable.Field(id=3)
  public final boolean data;
  @SafeParcelable.Field(id=8)
  public final String date;
  @SafeParcelable.Field(id=2)
  public final long id;
  @SafeParcelable.Field(id=4)
  public final String offset;
  @SafeParcelable.Field(id=7)
  public final Bundle this$0;
  @SafeParcelable.Field(id=1)
  public final long time;
  @SafeParcelable.Field(id=5)
  public final String type;
  @SafeParcelable.Field(id=6)
  public final String value;
  
  public zzcl(long paramLong1, long paramLong2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, Bundle paramBundle, String paramString4)
  {
    time = paramLong1;
    id = paramLong2;
    data = paramBoolean;
    offset = paramString1;
    type = paramString2;
    value = paramString3;
    this$0 = paramBundle;
    date = paramString4;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, time);
    SafeParcelWriter.writeLong(paramParcel, 2, id);
    SafeParcelWriter.writeBoolean(paramParcel, 3, data);
    SafeParcelWriter.writeString(paramParcel, 4, offset, false);
    SafeParcelWriter.writeString(paramParcel, 5, type, false);
    SafeParcelWriter.writeString(paramParcel, 6, value, false);
    SafeParcelWriter.writeBundle(paramParcel, 7, this$0, false);
    SafeParcelWriter.writeString(paramParcel, 8, date, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
