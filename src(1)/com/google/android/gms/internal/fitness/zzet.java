package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.DataSource;

@SafeParcelable.Class(creator="FitnessUnregistrationRequestCreator")
@SafeParcelable.Reserved({1000})
public final class zzet
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzet> CREATOR = new zzes();
  @SafeParcelable.Field(getter="getDataSource", id=1)
  private final DataSource zzkq;
  
  public zzet(DataSource paramDataSource)
  {
    zzkq = paramDataSource;
  }
  
  public final DataSource getDataSource()
  {
    return zzkq;
  }
  
  public final String toString()
  {
    return String.format("ApplicationUnregistrationRequest{%s}", new Object[] { zzkq });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, zzkq, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
