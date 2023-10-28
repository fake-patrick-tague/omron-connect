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
import com.google.android.gms.fitness.data.DataType;

@Deprecated
@SafeParcelable.Class(creator="DataTypeResultCreator")
@SafeParcelable.Reserved({1000})
public class DataTypeResult
  extends AbstractSafeParcelable
  implements Result
{
  @RecentlyNonNull
  public static final Parcelable.Creator<DataTypeResult> CREATOR = new VerticalProgressBar.SavedState.1();
  @SafeParcelable.Field(getter="getDataType", id=3)
  private final DataType zzkp;
  @SafeParcelable.Field(getter="getStatus", id=1)
  private final Status zzsv;
  
  public DataTypeResult(Status paramStatus, DataType paramDataType)
  {
    zzsv = paramStatus;
    zzkp = paramDataType;
  }
  
  public static DataTypeResult remove0(Status paramStatus)
  {
    return new DataTypeResult(paramStatus, null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DataTypeResult)) {
      return false;
    }
    paramObject = (DataTypeResult)paramObject;
    return (zzsv.equals(zzsv)) && (Objects.equal(zzkp, zzkp));
  }
  
  public DataType getDataType()
  {
    return zzkp;
  }
  
  public Status getStatus()
  {
    return zzsv;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzsv, zzkp });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("status", zzsv).name("dataType", zzkp).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getStatus(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getDataType(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
