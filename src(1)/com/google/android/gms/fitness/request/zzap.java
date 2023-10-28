package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.IDeathCallback_0_8;
import com.google.android.gms.fitness.data.IDeathCallback_0_8.Stub;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@ShowFirstParty
@SafeParcelable.Class(creator="SensorRegistrationRequestCreator")
@SafeParcelable.Reserved({4, 5, 11, 14, 1000})
public final class zzap
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzap> CREATOR = new zzao();
  @SafeParcelable.Field(getter="getDataType", id=2)
  private DataType zzkp;
  @SafeParcelable.Field(getter="getDataSource", id=1)
  private DataSource zzkq;
  @SafeParcelable.Field(getter="getSamplingRateMicros", id=6)
  private final long zzof;
  @SafeParcelable.Field(getter="getAccuracyMode", id=10)
  private final int zzog;
  @SafeParcelable.Field(getter="getCallbackBinder", id=13, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="getIntent", id=8)
  private final PendingIntent zzrk;
  @SafeParcelable.Field(getter="getListenerBinder", id=3, type="android.os.IBinder")
  private final IDeathCallback_0_8 zzrt;
  @SafeParcelable.Field(getter="getMaxDeliveryLatencyMicros", id=7)
  private final long zzru;
  @SafeParcelable.Field(getter="getFastestRateMicros", id=9)
  private final long zzrv;
  @SafeParcelable.Field(getter="getRegistrationTimeOutMicros", id=12)
  private final long zzrw;
  private final List<ClientIdentity> zzrx;
  
  zzap(DataSource paramDataSource, DataType paramDataType, IBinder paramIBinder1, long paramLong1, long paramLong2, PendingIntent paramPendingIntent, long paramLong3, int paramInt, long paramLong4, IBinder paramIBinder2)
  {
    zzkq = paramDataSource;
    zzkp = paramDataType;
    paramDataType = null;
    if (paramIBinder1 == null) {
      paramDataSource = null;
    } else {
      paramDataSource = IDeathCallback_0_8.Stub.asInterface(paramIBinder1);
    }
    zzrt = paramDataSource;
    zzof = paramLong1;
    zzrv = paramLong3;
    zzru = paramLong2;
    zzrk = paramPendingIntent;
    zzog = paramInt;
    zzrx = Collections.emptyList();
    zzrw = paramLong4;
    if (paramIBinder2 == null) {
      paramDataSource = paramDataType;
    } else {
      paramDataSource = zzcm.next(paramIBinder2);
    }
    zzql = paramDataSource;
  }
  
  private zzap(DataSource paramDataSource, DataType paramDataType, IDeathCallback_0_8 paramIDeathCallback_0_8, PendingIntent paramPendingIntent, long paramLong1, long paramLong2, long paramLong3, int paramInt, List paramList, long paramLong4, zzcn paramZzcn)
  {
    zzkq = paramDataSource;
    zzkp = paramDataType;
    zzrt = paramIDeathCallback_0_8;
    zzrk = paramPendingIntent;
    zzof = paramLong1;
    zzrv = paramLong2;
    zzru = paramLong3;
    zzog = paramInt;
    zzrx = paramList;
    zzrw = paramLong4;
    zzql = paramZzcn;
  }
  
  public zzap(SensorRequest paramSensorRequest, IDeathCallback_0_8 paramIDeathCallback_0_8, PendingIntent paramPendingIntent, zzcn paramZzcn)
  {
    this(localDataSource, localDataType, paramIDeathCallback_0_8, paramPendingIntent, paramSensorRequest.getSamplingRate(localTimeUnit), paramSensorRequest.getFastestRate(localTimeUnit), paramSensorRequest.getMaxDeliveryLatency(localTimeUnit), paramSensorRequest.getAccuracyMode(), Collections.emptyList(), paramSensorRequest.getMessageNumber(), paramZzcn);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzap)) {
      return false;
    }
    paramObject = (zzap)paramObject;
    return (Objects.equal(zzkq, zzkq)) && (Objects.equal(zzkp, zzkp)) && (Objects.equal(zzrt, zzrt)) && (zzof == zzof) && (zzrv == zzrv) && (zzru == zzru) && (zzog == zzog);
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zzkq, zzkp, zzrt, Long.valueOf(zzof), Long.valueOf(zzrv), Long.valueOf(zzru), Integer.valueOf(zzog) });
  }
  
  public final String toString()
  {
    return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[] { zzkp, zzkq, Long.valueOf(zzof), Long.valueOf(zzrv), Long.valueOf(zzru) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, zzkq, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, zzkp, paramInt, false);
    Object localObject1 = zzrt;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject1, false);
    SafeParcelWriter.writeLong(paramParcel, 6, zzof);
    SafeParcelWriter.writeLong(paramParcel, 7, zzru);
    SafeParcelWriter.writeParcelable(paramParcel, 8, zzrk, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 9, zzrv);
    SafeParcelWriter.writeInt(paramParcel, 10, zzog);
    SafeParcelWriter.writeLong(paramParcel, 12, zzrw);
    localObject1 = zzql;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 13, (IBinder)localObject1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
