package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;

@ShowFirstParty
@SafeParcelable.Class(creator="UnsubscribeRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class zzbm
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbm> CREATOR = new zzbo();
  @SafeParcelable.Field(getter="getDataType", id=1)
  private final DataType zzkp;
  @SafeParcelable.Field(getter="getDataSource", id=2)
  private final DataSource zzkq;
  @SafeParcelable.Field(getter="getCallbackBinder", id=3, type="android.os.IBinder")
  private final zzcn zzql;
  
  zzbm(DataType paramDataType, DataSource paramDataSource, IBinder paramIBinder)
  {
    this(paramDataType, paramDataSource, zzcm.next(paramIBinder));
  }
  
  public zzbm(DataType paramDataType, DataSource paramDataSource, zzcn paramZzcn)
  {
    boolean bool = true;
    int i;
    if (paramDataType == null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramDataSource == null) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == j) {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Must specify exactly one of dataType and dataSource.");
    zzkp = paramDataType;
    zzkq = paramDataSource;
    zzql = paramZzcn;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzbm)) {
      return false;
    }
    paramObject = (zzbm)paramObject;
    return (Objects.equal(zzkq, zzkq)) && (Objects.equal(zzkp, zzkp));
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zzkq, zzkp });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, zzkp, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, zzkq, paramInt, false);
    Object localObject = zzql;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
