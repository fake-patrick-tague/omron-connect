package com.google.android.gms.fitness.result;

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
import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSet.Builder;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;

@SafeParcelable.Class(creator="DailyTotalResultCreator")
@SafeParcelable.Reserved({1000})
public class DailyTotalResult
  extends AbstractSafeParcelable
  implements Result
{
  @RecentlyNonNull
  public static final Parcelable.Creator<DailyTotalResult> CREATOR = new AddressAndLabel.1();
  @SafeParcelable.Field(getter="getTotal", id=2)
  private final DataSet zzls;
  @SafeParcelable.Field(getter="getStatus", id=1)
  private final Status zzsv;
  
  public DailyTotalResult(Status paramStatus, DataSet paramDataSet)
  {
    zzsv = paramStatus;
    zzls = paramDataSet;
  }
  
  public static DailyTotalResult getInternal(Status paramStatus, DataType paramDataType)
  {
    return new DailyTotalResult(paramStatus, DataSet.builder(new DataSource.Builder().setType(1).setDataType(paramDataType).build()).build());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DailyTotalResult)) {
      return false;
    }
    paramObject = (DailyTotalResult)paramObject;
    return (zzsv.equals(zzsv)) && (Objects.equal(zzls, zzls));
  }
  
  public Status getStatus()
  {
    return zzsv;
  }
  
  public DataSet getTotal()
  {
    return zzls;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzsv, zzls });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("status", zzsv).name("dataPoint", zzls).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getStatus(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getTotal(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
