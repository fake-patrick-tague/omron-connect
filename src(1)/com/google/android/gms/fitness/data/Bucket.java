package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.fitness.zzko;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="BucketCreator")
@SafeParcelable.Reserved({7, 1000})
public class Bucket
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<Bucket> CREATOR = new SpecialListsListProperty.5();
  public static final int TYPE_ACTIVITY_SEGMENT = 4;
  public static final int TYPE_ACTIVITY_TYPE = 3;
  public static final int TYPE_SESSION = 2;
  public static final int TYPE_TIME = 1;
  @SafeParcelable.Field(getter="getStartTimeMillis", id=1)
  private final long zzkr;
  @SafeParcelable.Field(getter="getEndTimeMillis", id=2)
  private final long zzks;
  @SafeParcelable.Field(getter="getSession", id=3)
  private final Session zzky;
  @SafeParcelable.Field(getter="getActivityType", id=4)
  private final int zzlg;
  @SafeParcelable.Field(getter="getDataSets", id=5)
  private final List<DataSet> zzlh;
  @SafeParcelable.Field(getter="getBucketType", id=6)
  private final int zzli;
  
  Bucket(long paramLong1, long paramLong2, Session paramSession, int paramInt1, List paramList, int paramInt2)
  {
    zzkr = paramLong1;
    zzks = paramLong2;
    zzky = paramSession;
    zzlg = paramInt1;
    zzlh = paramList;
    zzli = paramInt2;
  }
  
  public Bucket(RawBucket paramRawBucket, List paramList)
  {
    this(l1, l2, localSession, i, localArrayList, zzli);
  }
  
  public static String getName(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return "bug";
              }
              return "intervals";
            }
            return "segment";
          }
          return "type";
        }
        return "session";
      }
      return "time";
    }
    return "none";
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Bucket)) {
      return false;
    }
    paramObject = (Bucket)paramObject;
    return (zzkr == zzkr) && (zzks == zzks) && (zzlg == zzlg) && (Objects.equal(zzlh, zzlh)) && (zzli == zzli);
  }
  
  public final int get()
  {
    return zzlg;
  }
  
  public final boolean get(Bucket paramBucket)
  {
    return (zzkr == zzkr) && (zzks == zzks) && (zzlg == zzlg) && (zzli == zzli);
  }
  
  public String getActivity()
  {
    return zzko.getName(zzlg);
  }
  
  public int getBucketType()
  {
    return zzli;
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = zzlh.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataType().equals(paramDataType)) {
        return localDataSet;
      }
    }
    return null;
  }
  
  public List getDataSets()
  {
    return zzlh;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzks, TimeUnit.MILLISECONDS);
  }
  
  public Session getSession()
  {
    return zzky;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzkr, TimeUnit.MILLISECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(zzkr), Long.valueOf(zzks), Integer.valueOf(zzlg), Integer.valueOf(zzli) });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("startTime", Long.valueOf(zzkr)).name("endTime", Long.valueOf(zzks)).name("activity", Integer.valueOf(zzlg)).name("dataSets", zzlh).name("bucketType", getName(zzli)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, zzkr);
    SafeParcelWriter.writeLong(paramParcel, 2, zzks);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getSession(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 4, zzlg);
    SafeParcelWriter.writeTypedList(paramParcel, 5, getDataSets(), false);
    SafeParcelWriter.writeInt(paramParcel, 6, getBucketType());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
