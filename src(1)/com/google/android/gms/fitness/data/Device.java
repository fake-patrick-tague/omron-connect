package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="DeviceCreator")
@SafeParcelable.Reserved({3, 1000})
public final class Device
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<Device> CREATOR = new SpecialList.4();
  public static final int TYPE_CHEST_STRAP = 4;
  public static final int TYPE_HEAD_MOUNTED = 6;
  public static final int TYPE_PHONE = 1;
  public static final int TYPE_SCALE = 5;
  public static final int TYPE_TABLET = 2;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_WATCH = 3;
  @SafeParcelable.Field(getter="getType", id=5)
  private final int type;
  @SafeParcelable.Field(getter="getManufacturer", id=1)
  private final String zzms;
  @SafeParcelable.Field(getter="getModel", id=2)
  private final String zzmt;
  @SafeParcelable.Field(getter="getUid", id=4)
  private final String zzmu;
  @SafeParcelable.Field(getter="getPlatformType", id=6)
  private final int zzmv;
  
  public Device(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramInt, 0);
  }
  
  public Device(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    zzms = ((String)Preconditions.checkNotNull(paramString1));
    zzmt = ((String)Preconditions.checkNotNull(paramString2));
    if (paramString3 != null)
    {
      zzmu = paramString3;
      type = paramInt1;
      zzmv = paramInt2;
      return;
    }
    throw new IllegalStateException("Device UID is null.");
  }
  
  public static Device getLocalDevice(Context paramContext)
  {
    int i = RingBuffer.add(paramContext);
    paramContext = RingBuffer.get(paramContext);
    return new Device(Build.MANUFACTURER, Build.MODEL, paramContext, i, 2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Device)) {
      return false;
    }
    paramObject = (Device)paramObject;
    return (Objects.equal(zzms, zzms)) && (Objects.equal(zzmt, zzmt)) && (Objects.equal(zzmu, zzmu)) && (type == type) && (zzmv == zzmv);
  }
  
  public final String getManufacturer()
  {
    return zzms;
  }
  
  public final String getModel()
  {
    return zzmt;
  }
  
  final String getStreamIdentifier()
  {
    return String.format("%s:%s:%s", new Object[] { zzms, zzmt, zzmu });
  }
  
  public final int getType()
  {
    return type;
  }
  
  public final String getUid()
  {
    return zzmu;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zzms, zzmt, zzmu, Integer.valueOf(type) });
  }
  
  public final String toString()
  {
    return String.format("Device{%s:%s:%s}", new Object[] { getStreamIdentifier(), Integer.valueOf(type), Integer.valueOf(zzmv) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getManufacturer(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getModel(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getUid(), false);
    SafeParcelWriter.writeInt(paramParcel, 5, getType());
    SafeParcelWriter.writeInt(paramParcel, 6, zzmv);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
