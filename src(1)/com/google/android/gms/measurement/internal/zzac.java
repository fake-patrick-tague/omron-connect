package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="ConditionalUserPropertyParcelCreator")
public final class zzac
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzac> CREATOR = new zzad();
  @SafeParcelable.Field(id=4)
  public zzlc context;
  @SafeParcelable.Field(id=10)
  public zzaw count;
  @SafeParcelable.Field(id=12)
  public final zzaw data;
  @SafeParcelable.Field(id=9)
  public long id;
  @SafeParcelable.Field(id=2)
  public String name;
  @SafeParcelable.Field(id=11)
  public final long size;
  @SafeParcelable.Field(id=8)
  public final zzaw source;
  @SafeParcelable.Field(id=6)
  public boolean status;
  @SafeParcelable.Field(id=7)
  public String text;
  @SafeParcelable.Field(id=3)
  public String type;
  @SafeParcelable.Field(id=5)
  public long value;
  
  zzac(zzac paramZzac)
  {
    Preconditions.checkNotNull(paramZzac);
    name = name;
    type = type;
    context = context;
    value = value;
    status = status;
    text = text;
    source = source;
    id = id;
    count = count;
    size = size;
    data = data;
  }
  
  zzac(String paramString1, String paramString2, zzlc paramZzlc, long paramLong1, boolean paramBoolean, String paramString3, zzaw paramZzaw1, long paramLong2, zzaw paramZzaw2, long paramLong3, zzaw paramZzaw3)
  {
    name = paramString1;
    type = paramString2;
    context = paramZzlc;
    value = paramLong1;
    status = paramBoolean;
    text = paramString3;
    source = paramZzaw1;
    id = paramLong2;
    count = paramZzaw2;
    size = paramLong3;
    data = paramZzaw3;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, name, false);
    SafeParcelWriter.writeString(paramParcel, 3, type, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, context, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 5, value);
    SafeParcelWriter.writeBoolean(paramParcel, 6, status);
    SafeParcelWriter.writeString(paramParcel, 7, text, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, source, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 9, id);
    SafeParcelWriter.writeParcelable(paramParcel, 10, count, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 11, size);
    SafeParcelWriter.writeParcelable(paramParcel, 12, data, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
