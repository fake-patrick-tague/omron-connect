package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.fitness.Stack;
import java.util.List;

@KeepName
@SafeParcelable.Class(creator="RawDataSetCreator")
@SafeParcelable.Reserved({2, 4, 1000})
public final class RawDataSet
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<RawDataSet> CREATOR = new zzab();
  @SafeParcelable.Field(id=1)
  public final int zzoa;
  @RecentlyNonNull
  @SafeParcelable.Field(id=3)
  public final List<RawDataPoint> zzoc;
  
  public RawDataSet(int paramInt, List paramList)
  {
    zzoa = paramInt;
    zzoc = paramList;
  }
  
  public RawDataSet(DataSet paramDataSet, List paramList)
  {
    zzoc = paramDataSet.copy(paramList);
    zzoa = Stack.add(paramDataSet.getDataSource(), paramList);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RawDataSet)) {
      return false;
    }
    paramObject = (RawDataSet)paramObject;
    return (zzoa == zzoa) && (Objects.equal(zzoc, zzoc));
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(zzoa) });
  }
  
  public final String toString()
  {
    return String.format("RawDataSet{%s@[%s]}", new Object[] { Integer.valueOf(zzoa), zzoc });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, zzoa);
    SafeParcelWriter.writeTypedList(paramParcel, 3, zzoc, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
