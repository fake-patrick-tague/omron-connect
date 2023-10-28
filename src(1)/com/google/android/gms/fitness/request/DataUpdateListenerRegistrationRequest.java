package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
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
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;

@SafeParcelable.Class(creator="DataUpdateListenerRegistrationRequestCreator")
@SafeParcelable.Reserved({1000})
public class DataUpdateListenerRegistrationRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<DataUpdateListenerRegistrationRequest> CREATOR = new VerticalProgressBar.SavedState.1();
  @SafeParcelable.Field(getter="getDataType", id=2)
  private final DataType zzkp;
  @SafeParcelable.Field(getter="getDataSource", id=1)
  private final DataSource zzkq;
  @SafeParcelable.Field(getter="getCallbackBinder", id=4, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="getIntent", id=3)
  private final PendingIntent zzrk;
  
  public DataUpdateListenerRegistrationRequest(DataSource paramDataSource, DataType paramDataType, PendingIntent paramPendingIntent, IBinder paramIBinder)
  {
    zzkq = paramDataSource;
    zzkp = paramDataType;
    zzrk = paramPendingIntent;
    if (paramIBinder == null) {
      paramDataSource = null;
    } else {
      paramDataSource = zzcm.next(paramIBinder);
    }
    zzql = paramDataSource;
  }
  
  private DataUpdateListenerRegistrationRequest(Builder paramBuilder)
  {
    this(Builder.getSoundPath(paramBuilder), Builder.getAttributeValue(paramBuilder), Builder.createIntent(paramBuilder), null);
  }
  
  public DataUpdateListenerRegistrationRequest(DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest, IBinder paramIBinder)
  {
    this(zzkq, zzkp, zzrk, paramIBinder);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DataUpdateListenerRegistrationRequest)) {
      return false;
    }
    paramObject = (DataUpdateListenerRegistrationRequest)paramObject;
    return (Objects.equal(zzkq, zzkq)) && (Objects.equal(zzkp, zzkp)) && (Objects.equal(zzrk, zzrk));
  }
  
  public DataSource getDataSource()
  {
    return zzkq;
  }
  
  public DataType getDataType()
  {
    return zzkp;
  }
  
  public PendingIntent getIntent()
  {
    return zzrk;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzkq, zzkp, zzrk });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("dataSource", zzkq).name("dataType", zzkp).name("pendingIntent", zzrk).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataSource(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getDataType(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getIntent(), paramInt, false);
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
    private DataType zzkp;
    private DataSource zzkq;
    private PendingIntent zzrk;
    
    public Builder() {}
    
    public DataUpdateListenerRegistrationRequest build()
    {
      boolean bool;
      if ((zzkq == null) && (zzkp == null)) {
        bool = false;
      } else {
        bool = true;
      }
      Preconditions.checkState(bool, "Set either dataSource or dataTYpe");
      Preconditions.checkNotNull(zzrk, "pendingIntent must be set");
      return new DataUpdateListenerRegistrationRequest(this, null);
    }
    
    public Builder setDataSource(DataSource paramDataSource)
    {
      Preconditions.checkNotNull(paramDataSource);
      zzkq = paramDataSource;
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      Preconditions.checkNotNull(paramDataType);
      zzkp = paramDataType;
      return this;
    }
    
    public Builder setPendingIntent(PendingIntent paramPendingIntent)
    {
      Preconditions.checkNotNull(paramPendingIntent);
      zzrk = paramPendingIntent;
      return this;
    }
  }
}
