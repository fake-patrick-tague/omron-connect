package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@KeepName
@SafeParcelable.Class(creator="RawBucketCreator")
@SafeParcelable.Reserved({7, 1000})
public final class RawBucket
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<RawBucket> CREATOR = new SpecialListsProgressProperty.1();
  @SafeParcelable.Field(id=1)
  public final long zzkr;
  @SafeParcelable.Field(id=2)
  public final long zzks;
  @RecentlyNullable
  @SafeParcelable.Field(id=3)
  public final Session zzky;
  @RecentlyNonNull
  @SafeParcelable.Field(id=5)
  public final List<RawDataSet> zzlh;
  @SafeParcelable.Field(id=6)
  public final int zzli;
  @SafeParcelable.Field(id=4)
  public final int zzny;
  
  public RawBucket(long paramLong1, long paramLong2, Session paramSession, int paramInt1, List paramList, int paramInt2)
  {
    zzkr = paramLong1;
    zzks = paramLong2;
    zzky = paramSession;
    zzny = paramInt1;
    zzlh = paramList;
    zzli = paramInt2;
  }
  
  public RawBucket(Bucket paramBucket, List paramList)
  {
    Object localObject = TimeUnit.MILLISECONDS;
    zzkr = paramBucket.getStartTime((TimeUnit)localObject);
    zzks = paramBucket.getEndTime((TimeUnit)localObject);
    zzky = paramBucket.getSession();
    zzny = paramBucket.get();
    zzli = paramBucket.getBucketType();
    paramBucket = paramBucket.getDataSets();
    zzlh = new ArrayList(paramBucket.size());
    paramBucket = paramBucket.iterator();
    while (paramBucket.hasNext())
    {
      localObject = (DataSet)paramBucket.next();
      zzlh.add(new RawDataSet((DataSet)localObject, paramList));
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RawBucket)) {
      return false;
    }
    paramObject = (RawBucket)paramObject;
    return (zzkr == zzkr) && (zzks == zzks) && (zzny == zzny) && (Objects.equal(zzlh, zzlh)) && (zzli == zzli);
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(zzkr), Long.valueOf(zzks), Integer.valueOf(zzli) });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).name("startTime", Long.valueOf(zzkr)).name("endTime", Long.valueOf(zzks)).name("activity", Integer.valueOf(zzny)).name("dataSets", zzlh).name("bucketType", Integer.valueOf(zzli)).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, zzkr);
    SafeParcelWriter.writeLong(paramParcel, 2, zzks);
    SafeParcelWriter.writeParcelable(paramParcel, 3, zzky, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 4, zzny);
    SafeParcelWriter.writeTypedList(paramParcel, 5, zzlh, false);
    SafeParcelWriter.writeInt(paramParcel, 6, zzli);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
