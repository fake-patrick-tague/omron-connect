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
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSet.Builder;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator="DataReadResultCreator")
@SafeParcelable.Reserved({7, 1000})
public class DataReadResult
  extends AbstractSafeParcelable
  implements Result
{
  @RecentlyNonNull
  public static final Parcelable.Creator<DataReadResult> CREATOR = new SpecialListsDueExistsProperty.1();
  @SafeParcelable.Field(getter="getRawDataSets", id=1, type="java.util.List")
  private final List<DataSet> zzlh;
  @SafeParcelable.Field(getter="getUniqueDataSources", id=6)
  private final List<DataSource> zzlr;
  @SafeParcelable.Field(getter="getStatus", id=2)
  private final Status zzsv;
  @SafeParcelable.Field(getter="getRawBuckets", id=3, type="java.util.List")
  private final List<Bucket> zzsw;
  @SafeParcelable.Field(getter="getBatchCount", id=5)
  private int zzsx;
  
  DataReadResult(List paramList1, Status paramStatus, List paramList2, int paramInt, List paramList3)
  {
    zzsv = paramStatus;
    zzsx = paramInt;
    zzlr = paramList3;
    zzlh = new ArrayList(paramList1.size());
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramStatus = (RawDataSet)paramList1.next();
      zzlh.add(new DataSet(paramStatus, paramList3));
    }
    zzsw = new ArrayList(paramList2.size());
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramStatus = (RawBucket)paramList1.next();
      zzsw.add(new Bucket(paramStatus, paramList3));
    }
  }
  
  private DataReadResult(List paramList1, List paramList2, Status paramStatus)
  {
    zzlh = paramList1;
    zzsv = paramStatus;
    zzsw = paramList2;
    zzsx = 1;
    zzlr = new ArrayList();
  }
  
  private static void add(DataSet paramDataSet, List paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataSource().equals(paramDataSet.getDataSource()))
      {
        localDataSet.putAll(paramDataSet.getDataPoints());
        return;
      }
    }
    paramList.add(paramDataSet);
  }
  
  public static DataReadResult onSuccess(Status paramStatus, List paramList1, List paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext()) {
      localArrayList.add(DataSet.builder((DataSource)paramList2.next()).build());
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (DataType)paramList1.next();
      localArrayList.add(DataSet.builder(new DataSource.Builder().setType(1).setDataType(paramList2).setStreamName("Default").build()).build());
    }
    return new DataReadResult(localArrayList, Collections.emptyList(), paramStatus);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DataReadResult)) {
      return false;
    }
    paramObject = (DataReadResult)paramObject;
    return (zzsv.equals(zzsv)) && (Objects.equal(zzlh, zzlh)) && (Objects.equal(zzsw, zzsw));
  }
  
  public List getBuckets()
  {
    return zzsw;
  }
  
  public DataSet getDataSet(DataSource paramDataSource)
  {
    Iterator localIterator = zzlh.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataSource.equals(localDataSet.getDataSource())) {
        return localDataSet;
      }
    }
    return DataSet.builder(paramDataSource).build();
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = zzlh.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataType.equals(localDataSet.getDataType())) {
        return localDataSet;
      }
    }
    return DataSet.builder(new DataSource.Builder().setType(1).setDataType(paramDataType).build()).build();
  }
  
  public List getDataSets()
  {
    return zzlh;
  }
  
  public Status getStatus()
  {
    return zzsv;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzsv, zzlh, zzsw });
  }
  
  public final void setData(DataReadResult paramDataReadResult)
  {
    Object localObject1 = paramDataReadResult.getDataSets().iterator();
    while (((Iterator)localObject1).hasNext()) {
      add((DataSet)((Iterator)localObject1).next(), zzlh);
    }
    paramDataReadResult = paramDataReadResult.getBuckets().iterator();
    while (paramDataReadResult.hasNext())
    {
      Object localObject2 = (Bucket)paramDataReadResult.next();
      Iterator localIterator = zzsw.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject1 = (Bucket)localIterator.next();
          if (((Bucket)localObject1).get((Bucket)localObject2))
          {
            localObject2 = ((Bucket)localObject2).getDataSets().iterator();
            while (((Iterator)localObject2).hasNext()) {
              add((DataSet)((Iterator)localObject2).next(), ((Bucket)localObject1).getDataSets());
            }
            break;
          }
        }
      }
      zzsw.add(localObject2);
    }
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this).name("status", zzsv);
    int i;
    Object localObject;
    if (zzlh.size() > 5)
    {
      i = zzlh.size();
      localObject = new StringBuilder(21);
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" data sets");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = zzlh;
    }
    localToStringHelper = localToStringHelper.name("dataSets", localObject);
    if (zzsw.size() > 5)
    {
      i = zzsw.size();
      localObject = new StringBuilder(19);
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" buckets");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = zzsw;
    }
    return localToStringHelper.name("buckets", localObject).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    ArrayList localArrayList = new ArrayList(zzlh.size());
    Iterator localIterator = zzlh.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataSet((DataSet)localIterator.next(), zzlr));
    }
    SafeParcelWriter.writeList(paramParcel, 1, localArrayList, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStatus(), paramInt, false);
    localArrayList = new ArrayList(zzsw.size());
    localIterator = zzsw.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawBucket((Bucket)localIterator.next(), zzlr));
    }
    SafeParcelWriter.writeList(paramParcel, 3, localArrayList, false);
    SafeParcelWriter.writeInt(paramParcel, 5, zzsx);
    SafeParcelWriter.writeTypedList(paramParcel, 6, zzlr, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final int zzab()
  {
    return zzsx;
  }
}
