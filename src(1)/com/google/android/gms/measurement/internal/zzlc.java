package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="UserAttributeParcelCreator")
public final class zzlc
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzlc> CREATOR = new zzld();
  @SafeParcelable.Field(id=4)
  public final Long data;
  @SafeParcelable.Field(id=1)
  public final int date;
  @SafeParcelable.Field(id=6)
  public final String key;
  @SafeParcelable.Field(id=7)
  public final String name;
  @SafeParcelable.Field(id=3)
  public final long size;
  @SafeParcelable.Field(id=2)
  public final String type;
  @SafeParcelable.Field(id=8)
  public final Double value;
  
  zzlc(int paramInt, String paramString1, long paramLong, Long paramLong1, Float paramFloat, String paramString2, String paramString3, Double paramDouble)
  {
    date = paramInt;
    type = paramString1;
    size = paramLong;
    data = paramLong1;
    if (paramInt == 1)
    {
      if (paramFloat != null) {
        paramString1 = Double.valueOf(paramFloat.doubleValue());
      } else {
        paramString1 = null;
      }
      value = paramString1;
    }
    else
    {
      value = paramDouble;
    }
    key = paramString2;
    name = paramString3;
  }
  
  zzlc(zzle paramZzle)
  {
    this(size, offset, data, type);
  }
  
  zzlc(String paramString1, long paramLong, Object paramObject, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    date = 2;
    type = paramString1;
    size = paramLong;
    name = paramString2;
    if (paramObject == null)
    {
      data = null;
      value = null;
      key = null;
      return;
    }
    if ((paramObject instanceof Long))
    {
      data = ((Long)paramObject);
      value = null;
      key = null;
      return;
    }
    if ((paramObject instanceof String))
    {
      data = null;
      value = null;
      key = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      data = null;
      value = ((Double)paramObject);
      key = null;
      return;
    }
    throw new IllegalArgumentException("User attribute given of un-supported type");
  }
  
  public final Object get()
  {
    Object localObject = data;
    if (localObject != null) {
      return localObject;
    }
    localObject = value;
    if (localObject != null) {
      return localObject;
    }
    localObject = key;
    if (localObject != null) {
      return localObject;
    }
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzld.writeValue(this, paramParcel, paramInt);
  }
}
