package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="DataUpdateRequestCreator")
@SafeParcelable.Reserved({1000})
public class DataUpdateRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<DataUpdateRequest> CREATOR = new zzaa();
  @SafeParcelable.Field(getter="getStartTimeMillis", id=1)
  private final long zzkr;
  @SafeParcelable.Field(getter="getEndTimeMillis", id=2)
  private final long zzks;
  @SafeParcelable.Field(getter="getDataSet", id=3)
  private final DataSet zzls;
  @SafeParcelable.Field(getter="getCallbackBinder", id=4, type="android.os.IBinder")
  private final zzcn zzql;
  
  public DataUpdateRequest(long paramLong1, long paramLong2, DataSet paramDataSet, IBinder paramIBinder)
  {
    zzkr = paramLong1;
    zzks = paramLong2;
    zzls = paramDataSet;
    if (paramIBinder == null) {
      paramDataSet = null;
    } else {
      paramDataSet = zzcm.next(paramIBinder);
    }
    zzql = paramDataSet;
  }
  
  private DataUpdateRequest(Builder paramBuilder)
  {
    this(Builder.getSoundPath(paramBuilder), Builder.getEWAHIterator(paramBuilder), Builder.log1p(paramBuilder), null);
  }
  
  public DataUpdateRequest(DataUpdateRequest paramDataUpdateRequest, IBinder paramIBinder)
  {
    this(zzkr, zzks, paramDataUpdateRequest.getDataSet(), paramIBinder);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DataUpdateRequest)) {
      return false;
    }
    paramObject = (DataUpdateRequest)paramObject;
    return (zzkr == zzkr) && (zzks == zzks) && (Objects.equal(zzls, zzls));
  }
  
  public final long getAsLong()
  {
    return zzkr;
  }
  
  public final long getDataLength()
  {
    return zzks;
  }
  
  public DataSet getDataSet()
  {
    return zzls;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzks, TimeUnit.MILLISECONDS);
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzkr, TimeUnit.MILLISECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(zzkr), Long.valueOf(zzks), zzls });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("startTimeMillis", Long.valueOf(zzkr)).name("endTimeMillis", Long.valueOf(zzks)).name("dataSet", zzls).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, zzkr);
    SafeParcelWriter.writeLong(paramParcel, 2, zzks);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getDataSet(), paramInt, false);
    Object localObject = zzql;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static class Builder
  {
    private long zzkr;
    private long zzks;
    private DataSet zzls;
    
    public Builder() {}
    
    public DataUpdateRequest build()
    {
      Preconditions.checkNotZero(zzkr, "Must set a non-zero value for startTimeMillis/startTime");
      Preconditions.checkNotZero(zzks, "Must set a non-zero value for endTimeMillis/endTime");
      Preconditions.checkNotNull(zzls, "Must set the data set");
      Iterator localIterator = zzls.getDataPoints().iterator();
      while (localIterator.hasNext())
      {
        DataPoint localDataPoint = (DataPoint)localIterator.next();
        TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
        long l1 = localDataPoint.getStartTime(localTimeUnit);
        long l2 = localDataPoint.getEndTime(localTimeUnit);
        if (l1 <= l2)
        {
          bool = l1 < 0L;
          if (((!bool) || (l1 >= zzkr)) && ((!bool) || (l1 <= zzks)) && (l2 <= zzks) && (l2 >= zzkr))
          {
            bool = false;
            break label155;
          }
        }
        boolean bool = true;
        label155:
        Preconditions.checkState(bool ^ true, "Data Point's startTimeMillis %d, endTimeMillis %d should lie between timeRange provided in the request. StartTimeMillis %d, EndTimeMillis: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(zzkr), Long.valueOf(zzks) });
      }
      return new DataUpdateRequest(this, null);
    }
    
    public Builder setDataSet(DataSet paramDataSet)
    {
      Preconditions.checkNotNull(paramDataSet, "Must set the data set");
      zzls = paramDataSet;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramLong1 > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid start time :%d", new Object[] { Long.valueOf(paramLong1) });
      if (paramLong2 >= paramLong1) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid end time :%d", new Object[] { Long.valueOf(paramLong2) });
      zzkr = paramTimeUnit.toMillis(paramLong1);
      zzks = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}
