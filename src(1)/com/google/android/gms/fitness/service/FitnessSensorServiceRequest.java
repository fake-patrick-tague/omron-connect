package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.IDeathCallback_0_8;
import com.google.android.gms.fitness.data.IDeathCallback_0_8.Stub;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="FitnessSensorServiceRequestCreator")
@SafeParcelable.Reserved({1000})
public class FitnessSensorServiceRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new VerticalProgressBar.SavedState.1();
  public static final int UNSPECIFIED = -1;
  @SafeParcelable.Field(getter="getDataSource", id=1)
  private final DataSource zzkq;
  @SafeParcelable.Field(getter="getListenerBinder", id=2, type="android.os.IBinder")
  private final IDeathCallback_0_8 zzrt;
  @SafeParcelable.Field(getter="getSamplingRateMicros", id=3)
  private final long zztd;
  @SafeParcelable.Field(getter="getBatchIntervalMicros", id=4)
  private final long zzte;
  
  FitnessSensorServiceRequest(DataSource paramDataSource, IBinder paramIBinder, long paramLong1, long paramLong2)
  {
    zzkq = paramDataSource;
    zzrt = IDeathCallback_0_8.Stub.asInterface(paramIBinder);
    zztd = paramLong1;
    zzte = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FitnessSensorServiceRequest)) {
      return false;
    }
    paramObject = (FitnessSensorServiceRequest)paramObject;
    return (Objects.equal(zzkq, zzkq)) && (zztd == zztd) && (zzte == zzte);
  }
  
  public long getBatchInterval(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzte, TimeUnit.MICROSECONDS);
  }
  
  public DataSource getDataSource()
  {
    return zzkq;
  }
  
  public SensorEventDispatcher getDispatcher()
  {
    return new Collector(zzrt);
  }
  
  public long getSamplingRate(TimeUnit paramTimeUnit)
  {
    long l = zztd;
    if (l == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(l, TimeUnit.MICROSECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzkq, Long.valueOf(zztd), Long.valueOf(zzte) });
  }
  
  public String toString()
  {
    return String.format("FitnessSensorServiceRequest{%s}", new Object[] { zzkq });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataSource(), paramInt, false);
    SafeParcelWriter.writeIBinder(paramParcel, 2, zzrt.asBinder(), false);
    SafeParcelWriter.writeLong(paramParcel, 3, zztd);
    SafeParcelWriter.writeLong(paramParcel, 4, zzte);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
