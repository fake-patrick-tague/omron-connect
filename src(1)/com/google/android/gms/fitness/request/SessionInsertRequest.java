package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.Chronology;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="SessionInsertRequestCreator")
@SafeParcelable.Reserved({5, 1000})
public class SessionInsertRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new zzau();
  private static final TimeUnit zzsa = TimeUnit.MILLISECONDS;
  @SafeParcelable.Field(getter="getSession", id=1)
  private final Session zzky;
  @SafeParcelable.Field(getter="getDataSets", id=2)
  private final List<DataSet> zzlh;
  @SafeParcelable.Field(getter="getCallbackBinder", id=4, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="getAggregateDataPoints", id=3)
  private final List<DataPoint> zzsb;
  
  SessionInsertRequest(Session paramSession, List paramList1, List paramList2, IBinder paramIBinder)
  {
    zzky = paramSession;
    zzlh = Collections.unmodifiableList(paramList1);
    zzsb = Collections.unmodifiableList(paramList2);
    if (paramIBinder == null) {
      paramSession = null;
    } else {
      paramSession = zzcm.next(paramIBinder);
    }
    zzql = paramSession;
  }
  
  private SessionInsertRequest(Session paramSession, List paramList1, List paramList2, zzcn paramZzcn)
  {
    zzky = paramSession;
    zzlh = Collections.unmodifiableList(paramList1);
    zzsb = Collections.unmodifiableList(paramList2);
    zzql = paramZzcn;
  }
  
  private SessionInsertRequest(Builder paramBuilder)
  {
    this(Builder.access$getMSession(paramBuilder), Builder.getSoundPath(paramBuilder), Builder.getArticleUrl(paramBuilder), null);
  }
  
  public SessionInsertRequest(SessionInsertRequest paramSessionInsertRequest, zzcn paramZzcn)
  {
    this(zzky, zzlh, zzsb, paramZzcn);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof SessionInsertRequest))
      {
        paramObject = (SessionInsertRequest)paramObject;
        int i;
        if ((Objects.equal(zzky, zzky)) && (Objects.equal(zzlh, zzlh)) && (Objects.equal(zzsb, zzsb))) {
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
  
  public List getAggregateDataPoints()
  {
    return zzsb;
  }
  
  public List getDataSets()
  {
    return zzlh;
  }
  
  public Session getSession()
  {
    return zzky;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzky, zzlh, zzsb });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("session", zzky).name("dataSets", zzlh).name("aggregateDataPoints", zzsb).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getSession(), paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getDataSets(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, getAggregateDataPoints(), false);
    Object localObject = zzql;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static class Builder
  {
    private Session zzky;
    private final List<DataSet> zzlh = new ArrayList();
    private final List<DataPoint> zzsb = new ArrayList();
    private final List<DataSource> zzsc = new ArrayList();
    
    public Builder() {}
    
    private final void toString(DataPoint paramDataPoint)
    {
      Session localSession = zzky;
      TimeUnit localTimeUnit = TimeUnit.NANOSECONDS;
      long l3 = localSession.getStartTime(localTimeUnit);
      long l4 = zzky.getEndTime(localTimeUnit);
      long l2 = paramDataPoint.getTimestamp(localTimeUnit);
      long l1 = l2;
      boolean bool;
      if (l2 != 0L)
      {
        if ((l2 < l3) || (l2 > l4)) {
          l1 = Chronology.get(l2, localTimeUnit, SessionInsertRequest.valueString());
        }
        if ((l1 >= l3) && (l1 <= l4)) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkState(bool, "Data point %s has time stamp outside session interval [%d, %d]", new Object[] { paramDataPoint, Long.valueOf(l3), Long.valueOf(l4) });
        if (paramDataPoint.getTimestamp(localTimeUnit) != l1)
        {
          Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[] { Long.valueOf(paramDataPoint.getTimestamp(localTimeUnit)), Long.valueOf(l1), SessionInsertRequest.valueString() }));
          paramDataPoint.setTimestamp(l1, localTimeUnit);
        }
      }
      l3 = zzky.getStartTime(localTimeUnit);
      l4 = zzky.getEndTime(localTimeUnit);
      long l5 = paramDataPoint.getStartTime(localTimeUnit);
      l2 = paramDataPoint.getEndTime(localTimeUnit);
      l1 = l2;
      if ((l5 != 0L) && (l2 != 0L))
      {
        if (l2 > l4) {
          l1 = Chronology.get(l2, localTimeUnit, SessionInsertRequest.valueString());
        }
        if ((l5 >= l3) && (l1 <= l4)) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkState(bool, "Data point %s has start and end times outside session interval [%d, %d]", new Object[] { paramDataPoint, Long.valueOf(l3), Long.valueOf(l4) });
        if (l1 != paramDataPoint.getEndTime(localTimeUnit))
        {
          Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[] { Long.valueOf(paramDataPoint.getEndTime(localTimeUnit)), Long.valueOf(l1), SessionInsertRequest.valueString() }));
          paramDataPoint.setTimeInterval(l5, l1, localTimeUnit);
        }
      }
    }
    
    public Builder addAggregateDataPoint(DataPoint paramDataPoint)
    {
      boolean bool;
      if (paramDataPoint != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid aggregate data point.");
      DataSource localDataSource = paramDataPoint.getDataSource();
      Preconditions.checkState(zzsc.contains(localDataSource) ^ true, "Data set/Aggregate data point for this data source %s is already added.", new Object[] { localDataSource });
      DataSet.doInBackground(paramDataPoint);
      zzsc.add(localDataSource);
      zzsb.add(paramDataPoint);
      return this;
    }
    
    public Builder addDataSet(DataSet paramDataSet)
    {
      boolean bool;
      if (paramDataSet != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid data set.");
      DataSource localDataSource = paramDataSet.getDataSource();
      Preconditions.checkState(zzsc.contains(localDataSource) ^ true, "Data set for this data source %s is already added.", new Object[] { localDataSource });
      Preconditions.checkArgument(paramDataSet.getDataPoints().isEmpty() ^ true, "No data points specified in the input data set.");
      zzsc.add(localDataSource);
      zzlh.add(paramDataSet);
      return this;
    }
    
    public SessionInsertRequest build()
    {
      Object localObject = zzky;
      boolean bool2 = true;
      boolean bool1;
      if (localObject != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Must specify a valid session.");
      if (zzky.getEndTime(TimeUnit.MILLISECONDS) != 0L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Must specify a valid end time, cannot insert a continuing session.");
      localObject = zzlh.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Iterator localIterator = ((DataSet)((Iterator)localObject).next()).getDataPoints().iterator();
        while (localIterator.hasNext()) {
          toString((DataPoint)localIterator.next());
        }
      }
      localObject = zzsb.iterator();
      while (((Iterator)localObject).hasNext()) {
        toString((DataPoint)((Iterator)localObject).next());
      }
      return new SessionInsertRequest(this, null);
    }
    
    public Builder setSession(Session paramSession)
    {
      zzky = paramSession;
      return this;
    }
  }
}
