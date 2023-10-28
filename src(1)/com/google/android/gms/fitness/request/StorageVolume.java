package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;

@ShowFirstParty
@SafeParcelable.Class(creator="DataInsertRequestCreator")
@SafeParcelable.Reserved({3, 1000})
public final class StorageVolume
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzj> CREATOR = new PaymentIntent.Output.1();
  @SafeParcelable.Field(getter="getDataSet", id=1)
  private final DataSet zzls;
  @SafeParcelable.Field(getter="getCallbackBinder", id=2, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="shouldSkipSync", id=4)
  private final boolean zzqw;
  
  StorageVolume(DataSet paramDataSet, IBinder paramIBinder, boolean paramBoolean)
  {
    zzls = paramDataSet;
    if (paramIBinder == null) {
      paramDataSet = null;
    } else {
      paramDataSet = zzcm.next(paramIBinder);
    }
    zzql = paramDataSet;
    zzqw = paramBoolean;
  }
  
  public StorageVolume(DataSet paramDataSet, zzcn paramZzcn, boolean paramBoolean)
  {
    zzls = paramDataSet;
    zzql = paramZzcn;
    zzqw = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof StorageVolume)) && (Objects.equal(zzls, zzls)));
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zzls });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).name("dataSet", zzls).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, zzls, paramInt, false);
    Object localObject = zzql;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, zzqw);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
