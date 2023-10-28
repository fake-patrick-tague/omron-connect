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
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator="DataSourcesResultCreator")
@SafeParcelable.Reserved({1000})
public class DataSourcesResult
  extends AbstractSafeParcelable
  implements Result
{
  @RecentlyNonNull
  public static final Parcelable.Creator<DataSourcesResult> CREATOR = new DiscreteSeekBar.CustomState.1();
  @SafeParcelable.Field(getter="getDataSources", id=1)
  private final List<DataSource> zzqq;
  @SafeParcelable.Field(getter="getStatus", id=2)
  private final Status zzsv;
  
  public DataSourcesResult(List paramList, Status paramStatus)
  {
    zzqq = Collections.unmodifiableList(paramList);
    zzsv = paramStatus;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DataSourcesResult))
      {
        paramObject = (DataSourcesResult)paramObject;
        int i;
        if ((zzsv.equals(zzsv)) && (Objects.equal(zzqq, zzqq))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public List getDataSources()
  {
    return zzqq;
  }
  
  public List getDataSources(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzqq.iterator();
    while (localIterator.hasNext())
    {
      DataSource localDataSource = (DataSource)localIterator.next();
      if (localDataSource.getDataType().equals(paramDataType)) {
        localArrayList.add(localDataSource);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Status getStatus()
  {
    return zzsv;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzsv, zzqq });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("status", zzsv).name("dataSources", zzqq).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getDataSources(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
