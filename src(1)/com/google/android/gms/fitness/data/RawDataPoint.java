package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.fitness.Stack;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@KeepName
@ShowFirstParty
@SafeParcelable.Class(creator="RawDataPointCreator")
@SafeParcelable.Reserved({1000, 7})
public final class RawDataPoint
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzaa();
  @SafeParcelable.Field(getter="getStartTimeNanos", id=2)
  private final long zzlk;
  @SafeParcelable.Field(getter="getValues", id=3)
  private final Value[] zzll;
  @SafeParcelable.Field(getter="getRawTimestamp", id=6)
  private final long zzln;
  @SafeParcelable.Field(getter="getEndTimeNanos", id=1)
  private final long zznz;
  @SafeParcelable.Field(getter="getDataSourceIndex", id=4)
  private final int zzoa;
  @SafeParcelable.Field(getter="getOriginalDataSourceIndex", id=5)
  private final int zzob;
  
  public RawDataPoint(long paramLong1, long paramLong2, Value[] paramArrayOfValue, int paramInt1, int paramInt2, long paramLong3)
  {
    zznz = paramLong1;
    zzlk = paramLong2;
    zzoa = paramInt1;
    zzob = paramInt2;
    zzln = paramLong3;
    zzll = paramArrayOfValue;
  }
  
  RawDataPoint(DataPoint paramDataPoint, List paramList)
  {
    TimeUnit localTimeUnit = TimeUnit.NANOSECONDS;
    zznz = paramDataPoint.getTimestamp(localTimeUnit);
    zzlk = paramDataPoint.getStartTime(localTimeUnit);
    zzll = paramDataPoint.getY();
    zzoa = Stack.add(paramDataPoint.getDataSource(), paramList);
    zzob = Stack.add(paramDataPoint.value(), paramList);
    zzln = paramDataPoint.getX();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RawDataPoint)) {
      return false;
    }
    paramObject = (RawDataPoint)paramObject;
    return (zznz == zznz) && (zzlk == zzlk) && (Arrays.equals(zzll, zzll)) && (zzoa == zzoa) && (zzob == zzob) && (zzln == zzln);
  }
  
  public final long getCssPageRect()
  {
    return zznz;
  }
  
  public final Value[] getHttpProxy()
  {
    return zzll;
  }
  
  public final int getMembers()
  {
    return zzob;
  }
  
  public final long getMessageNumber()
  {
    return zzln;
  }
  
  public final long getSoundPath()
  {
    return zzlk;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(zznz), Long.valueOf(zzlk) });
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[] { Arrays.toString(zzll), Long.valueOf(zzlk), Long.valueOf(zznz), Integer.valueOf(zzoa), Integer.valueOf(zzob) });
  }
  
  public final int val()
  {
    return zzoa;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, zznz);
    SafeParcelWriter.writeLong(paramParcel, 2, zzlk);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, zzll, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 4, zzoa);
    SafeParcelWriter.writeInt(paramParcel, 5, zzob);
    SafeParcelWriter.writeLong(paramParcel, 6, zzln);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
