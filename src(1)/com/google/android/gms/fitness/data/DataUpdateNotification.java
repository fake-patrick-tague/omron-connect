package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="DataUpdateNotificationCreator")
@SafeParcelable.Reserved({1000})
public class DataUpdateNotification
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final String ACTION = "com.google.android.gms.fitness.DATA_UPDATE_NOTIFICATION";
  @RecentlyNonNull
  public static final Parcelable.Creator<DataUpdateNotification> CREATOR = new OpenPgpKeyPreference.SavedState.1();
  @RecentlyNonNull
  public static final String EXTRA_DATA_UPDATE_NOTIFICATION = "vnd.google.fitness.data_udpate_notification";
  public static final int OPERATION_DELETE = 2;
  public static final int OPERATION_INSERT = 1;
  public static final int OPERATION_UPDATE = 3;
  @SafeParcelable.Field(getter="getDataType", id=5)
  private final DataType zzkp;
  @SafeParcelable.Field(getter="getDataSource", id=4)
  private final DataSource zzkq;
  @SafeParcelable.Field(getter="getUpdateStartTimeNanos", id=1)
  private final long zzmp;
  @SafeParcelable.Field(getter="getUpdateEndTimeNanos", id=2)
  private final long zzmq;
  @SafeParcelable.Field(getter="getOperationType", id=3)
  private final int zzmr;
  
  public DataUpdateNotification(long paramLong1, long paramLong2, int paramInt, DataSource paramDataSource, DataType paramDataType)
  {
    zzmp = paramLong1;
    zzmq = paramLong2;
    zzmr = paramInt;
    zzkq = paramDataSource;
    zzkp = paramDataType;
  }
  
  public static DataUpdateNotification getDataUpdateNotification(Intent paramIntent)
  {
    return (DataUpdateNotification)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "vnd.google.fitness.data_udpate_notification", CREATOR);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DataUpdateNotification)) {
      return false;
    }
    paramObject = (DataUpdateNotification)paramObject;
    return (zzmp == zzmp) && (zzmq == zzmq) && (zzmr == zzmr) && (Objects.equal(zzkq, zzkq)) && (Objects.equal(zzkp, zzkp));
  }
  
  public DataSource getDataSource()
  {
    return zzkq;
  }
  
  public DataType getDataType()
  {
    return zzkp;
  }
  
  public int getOperationType()
  {
    return zzmr;
  }
  
  public long getUpdateEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzmq, TimeUnit.NANOSECONDS);
  }
  
  public long getUpdateStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzmp, TimeUnit.NANOSECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(zzmp), Long.valueOf(zzmq), Integer.valueOf(zzmr), zzkq, zzkp });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("updateStartTimeNanos", Long.valueOf(zzmp)).name("updateEndTimeNanos", Long.valueOf(zzmq)).name("operationType", Integer.valueOf(zzmr)).name("dataSource", zzkq).name("dataType", zzkp).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, zzmp);
    SafeParcelWriter.writeLong(paramParcel, 2, zzmq);
    SafeParcelWriter.writeInt(paramParcel, 3, getOperationType());
    SafeParcelWriter.writeParcelable(paramParcel, 4, getDataSource(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, getDataType(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
