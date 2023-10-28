package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.concurrent.TimeUnit;

public class SensorRequest
{
  public static final int ACCURACY_MODE_DEFAULT = 2;
  public static final int ACCURACY_MODE_HIGH = 3;
  public static final int ACCURACY_MODE_LOW = 1;
  private final DataType zzkp;
  private final DataSource zzkq;
  private final long zzof;
  private final int zzog;
  private final long zzru;
  private final long zzrv;
  private final long zzry;
  
  private SensorRequest(Builder paramBuilder)
  {
    zzkq = Builder.newFromParcel(paramBuilder);
    zzkp = Builder.getAttributeValue(paramBuilder);
    zzof = Builder.getSoundPath(paramBuilder);
    zzrv = Builder.getArticleUrl(paramBuilder);
    zzru = Builder.getTransfer(paramBuilder);
    zzog = Builder.getUnreadMessagesCount(paramBuilder);
    zzry = Builder.getStart(paramBuilder);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof SensorRequest)) {
      return false;
    }
    paramObject = (SensorRequest)paramObject;
    return (Objects.equal(zzkq, zzkq)) && (Objects.equal(zzkp, zzkp)) && (zzof == zzof) && (zzrv == zzrv) && (zzru == zzru) && (zzog == zzog) && (zzry == zzry);
  }
  
  public int getAccuracyMode()
  {
    return zzog;
  }
  
  public DataSource getDataSource()
  {
    return zzkq;
  }
  
  public DataType getDataType()
  {
    return zzkp;
  }
  
  public long getFastestRate(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzrv, TimeUnit.MICROSECONDS);
  }
  
  public long getMaxDeliveryLatency(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzru, TimeUnit.MICROSECONDS);
  }
  
  public final long getMessageNumber()
  {
    return zzry;
  }
  
  public long getSamplingRate(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzof, TimeUnit.MICROSECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzkq, zzkp, Long.valueOf(zzof), Long.valueOf(zzrv), Long.valueOf(zzru), Integer.valueOf(zzog), Long.valueOf(zzry) });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("dataSource", zzkq).name("dataType", zzkp).name("samplingRateMicros", Long.valueOf(zzof)).name("deliveryLatencyMicros", Long.valueOf(zzru)).name("timeOutMicros", Long.valueOf(zzry)).toString();
  }
  
  public static class Builder
  {
    private DataType zzkp;
    private DataSource zzkq;
    private long zzof = -1L;
    private int zzog = 2;
    private long zzru = 0L;
    private long zzrv = 0L;
    private long zzry = Long.MAX_VALUE;
    private boolean zzrz = false;
    
    public Builder() {}
    
    public SensorRequest build()
    {
      Object localObject = zzkq;
      boolean bool2 = false;
      if ((localObject == null) && (zzkp == null)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      Preconditions.checkState(bool1, "Must call setDataSource() or setDataType()");
      localObject = zzkp;
      if (localObject != null)
      {
        DataSource localDataSource = zzkq;
        if (localDataSource != null)
        {
          bool1 = bool2;
          if (!((DataType)localObject).equals(localDataSource.getDataType())) {
            break label70;
          }
        }
      }
      boolean bool1 = true;
      label70:
      Preconditions.checkState(bool1, "Specified data type is incompatible with specified data source");
      return new SensorRequest(this, null);
    }
    
    public Builder setAccuracyMode(int paramInt)
    {
      int i = paramInt;
      if (paramInt != 1)
      {
        i = paramInt;
        if (paramInt != 3) {
          i = 2;
        }
      }
      zzog = i;
      return this;
    }
    
    public Builder setDataSource(DataSource paramDataSource)
    {
      zzkq = paramDataSource;
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      zzkp = paramDataType;
      return this;
    }
    
    public Builder setFastestRate(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Cannot use a negative interval");
      zzrz = true;
      zzrv = paramTimeUnit.toMicros(paramInt);
      return this;
    }
    
    public Builder setMaxDeliveryLatency(int paramInt, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Cannot use a negative delivery interval");
      zzru = paramTimeUnit.toMicros(paramInt);
      return this;
    }
    
    public Builder setSamplingRate(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramLong >= 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Cannot use a negative sampling interval");
      paramLong = paramTimeUnit.toMicros(paramLong);
      zzof = paramLong;
      if (!zzrz) {
        zzrv = (paramLong / 2L);
      }
      return this;
    }
    
    public Builder setTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool2 = true;
      boolean bool1;
      if (paramLong > 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Invalid time out value specified: %d", new Object[] { Long.valueOf(paramLong) });
      if (paramTimeUnit != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Invalid time unit specified");
      zzry = paramTimeUnit.toMicros(paramLong);
      return this;
    }
  }
}
