package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Locale;

@SafeParcelable.Class(creator="SubscriptionCreator")
@SafeParcelable.Reserved({1000})
public class Subscription
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<Subscription> CREATOR = new zzai();
  @SafeParcelable.Field(getter="getDataType", id=2)
  private final DataType zzkp;
  @SafeParcelable.Field(getter="getDataSource", id=1)
  private final DataSource zzkq;
  @SafeParcelable.Field(getter="getSamplingRateMicros", id=3)
  private final long zzof;
  @SafeParcelable.Field(getter="getAccuracyMode", id=4)
  private final int zzog;
  @SafeParcelable.Field(getter="getSubscriptionType", id=5)
  private final int zzoh;
  
  Subscription(DataSource paramDataSource, DataType paramDataType, long paramLong, int paramInt1, int paramInt2)
  {
    zzkq = paramDataSource;
    zzkp = paramDataType;
    zzof = paramLong;
    zzog = paramInt1;
    zzoh = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Subscription)) {
      return false;
    }
    paramObject = (Subscription)paramObject;
    return (Objects.equal(zzkq, zzkq)) && (Objects.equal(zzkp, zzkp)) && (zzof == zzof) && (zzog == zzog) && (zzoh == zzoh);
  }
  
  public DataSource getDataSource()
  {
    return zzkq;
  }
  
  public DataType getDataType()
  {
    return zzkp;
  }
  
  public final DataType getSubscription()
  {
    DataType localDataType2 = zzkp;
    DataType localDataType1 = localDataType2;
    if (localDataType2 == null) {
      localDataType1 = zzkq.getDataType();
    }
    return localDataType1;
  }
  
  public int hashCode()
  {
    DataSource localDataSource = zzkq;
    return Objects.hashCode(new Object[] { localDataSource, localDataSource, Long.valueOf(zzof), Integer.valueOf(zzog), Integer.valueOf(zzoh) });
  }
  
  public String toDebugString()
  {
    Locale localLocale = Locale.US;
    Object localObject = zzkq;
    if (localObject == null) {
      localObject = zzkp.getName();
    } else {
      localObject = ((DataSource)localObject).toDebugString();
    }
    return String.format(localLocale, "Subscription{%s}, subscriptionType{%d}", new Object[] { localObject, Integer.valueOf(zzoh) });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("dataSource", zzkq).name("dataType", zzkp).name("samplingIntervalMicros", Long.valueOf(zzof)).name("accuracyMode", Integer.valueOf(zzog)).name("subscriptionType", Integer.valueOf(zzoh)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataSource(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getDataType(), paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 3, zzof);
    SafeParcelWriter.writeInt(paramParcel, 4, zzog);
    SafeParcelWriter.writeInt(paramParcel, 5, zzoh);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  @ShowFirstParty
  public static final class zza
  {
    private DataType zzkp;
    private DataSource zzkq;
    private long zzof = -1L;
    private int zzog = 2;
    private int zzoh = 0;
    
    public zza() {}
    
    public final Subscription create()
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
      return new Subscription(zzkq, zzkp, zzof, zzog, 0);
    }
    
    public final zza setNegativeButton(DataSource paramDataSource)
    {
      zzkq = paramDataSource;
      return this;
    }
    
    public final zza setNegativeButton(DataType paramDataType)
    {
      zzkp = paramDataType;
      return this;
    }
  }
}
