package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="DataDeleteRequestCreator")
@SafeParcelable.Reserved({9, 1000})
public class DataDeleteRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new SpecialListsDueExistsProperty.1();
  @SafeParcelable.Field(getter="getStartTimeMillis", id=1)
  private final long zzkr;
  @SafeParcelable.Field(getter="getEndTimeMillis", id=2)
  private final long zzks;
  @SafeParcelable.Field(getter="getDataTypes", id=4)
  private final List<DataType> zzlf;
  @SafeParcelable.Field(getter="getCallbackBinder", id=8, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="getDataSources", id=3)
  private final List<DataSource> zzqq;
  @SafeParcelable.Field(getter="getSessions", id=5)
  private final List<Session> zzqr;
  @SafeParcelable.Field(getter="deleteAllData", id=6)
  private final boolean zzqs;
  @SafeParcelable.Field(getter="deleteAllSessions", id=7)
  private final boolean zzqt;
  @SafeParcelable.Field(getter="deleteByTimeRange", id=10)
  private final boolean zzqu;
  @SafeParcelable.Field(getter="enableLocationCleanup", id=11)
  private final boolean zzqv;
  
  DataDeleteRequest(long paramLong1, long paramLong2, List paramList1, List paramList2, List paramList3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, IBinder paramIBinder)
  {
    zzkr = paramLong1;
    zzks = paramLong2;
    zzqq = Collections.unmodifiableList(paramList1);
    zzlf = Collections.unmodifiableList(paramList2);
    zzqr = paramList3;
    zzqs = paramBoolean1;
    zzqt = paramBoolean2;
    zzqu = paramBoolean3;
    zzqv = paramBoolean4;
    if (paramIBinder == null) {
      paramList1 = null;
    } else {
      paramList1 = zzcm.next(paramIBinder);
    }
    zzql = paramList1;
  }
  
  private DataDeleteRequest(long paramLong1, long paramLong2, List paramList1, List paramList2, List paramList3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, zzcn paramZzcn)
  {
    zzkr = paramLong1;
    zzks = paramLong2;
    zzqq = Collections.unmodifiableList(paramList1);
    zzlf = Collections.unmodifiableList(paramList2);
    zzqr = paramList3;
    zzqs = paramBoolean1;
    zzqt = paramBoolean2;
    zzqu = paramBoolean3;
    zzqv = paramBoolean4;
    zzql = paramZzcn;
  }
  
  private DataDeleteRequest(Builder paramBuilder)
  {
    this(Builder.getEWAHIterator(paramBuilder), Builder.fromField(paramBuilder), Builder.getDbFilename(paramBuilder), Builder.getSoundPath(paramBuilder), Builder.log1p(paramBuilder), Builder.isInheritable(paramBuilder), Builder.getArticleUrl(paramBuilder), false, false, null);
  }
  
  public DataDeleteRequest(DataDeleteRequest paramDataDeleteRequest, zzcn paramZzcn)
  {
    this(zzkr, zzks, zzqq, zzlf, zzqr, zzqs, zzqt, zzqu, zzqv, paramZzcn);
  }
  
  public boolean deleteAllData()
  {
    return zzqs;
  }
  
  public boolean deleteAllSessions()
  {
    return zzqt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DataDeleteRequest)) {
      return false;
    }
    paramObject = (DataDeleteRequest)paramObject;
    return (zzkr == zzkr) && (zzks == zzks) && (Objects.equal(zzqq, zzqq)) && (Objects.equal(zzlf, zzlf)) && (Objects.equal(zzqr, zzqr)) && (zzqs == zzqs) && (zzqt == zzqt) && (zzqu == zzqu) && (zzqv == zzqv);
  }
  
  public List getDataSources()
  {
    return zzqq;
  }
  
  public List getDataTypes()
  {
    return zzlf;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzks, TimeUnit.MILLISECONDS);
  }
  
  public List getSessions()
  {
    return zzqr;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzkr, TimeUnit.MILLISECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(zzkr), Long.valueOf(zzks) });
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this).name("startTimeMillis", Long.valueOf(zzkr)).name("endTimeMillis", Long.valueOf(zzks)).name("dataSources", zzqq).name("dateTypes", zzlf).name("sessions", zzqr).name("deleteAllData", Boolean.valueOf(zzqs)).name("deleteAllSessions", Boolean.valueOf(zzqt));
    boolean bool = zzqu;
    if (bool) {
      localToStringHelper.name("deleteByTimeRange", Boolean.valueOf(bool));
    }
    return localToStringHelper.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, zzkr);
    SafeParcelWriter.writeLong(paramParcel, 2, zzks);
    SafeParcelWriter.writeTypedList(paramParcel, 3, getDataSources(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 4, getDataTypes(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 5, getSessions(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 6, deleteAllData());
    SafeParcelWriter.writeBoolean(paramParcel, 7, deleteAllSessions());
    Object localObject = zzql;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 8, (IBinder)localObject, false);
    SafeParcelWriter.writeBoolean(paramParcel, 10, zzqu);
    SafeParcelWriter.writeBoolean(paramParcel, 11, zzqv);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private long zzkr;
    private long zzks;
    private final List<DataType> zzlf = new ArrayList();
    private final List<DataSource> zzqq = new ArrayList();
    private final List<Session> zzqr = new ArrayList();
    private boolean zzqs = false;
    private boolean zzqt = false;
    private boolean zzqu = false;
    private boolean zzqv = false;
    
    public Builder() {}
    
    public Builder addDataSource(DataSource paramDataSource)
    {
      boolean bool2 = zzqs;
      boolean bool1 = true;
      Preconditions.checkArgument(bool2 ^ true, "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
      if (paramDataSource == null) {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must specify a valid data source");
      if (!zzqq.contains(paramDataSource)) {
        zzqq.add(paramDataSource);
      }
      return this;
    }
    
    public Builder addDataType(DataType paramDataType)
    {
      boolean bool2 = zzqs;
      boolean bool1 = true;
      Preconditions.checkArgument(bool2 ^ true, "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
      if (paramDataType == null) {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must specify a valid data type");
      if (!zzlf.contains(paramDataType)) {
        zzlf.add(paramDataType);
      }
      return this;
    }
    
    public Builder addSession(Session paramSession)
    {
      boolean bool1 = zzqt;
      boolean bool2 = true;
      Preconditions.checkArgument(bool1 ^ true, "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
      if (paramSession != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Must specify a valid session");
      if (paramSession.getEndTime(TimeUnit.MILLISECONDS) > 0L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Cannot delete an ongoing session. Please stop the session prior to deleting it");
      zzqr.add(paramSession);
      return this;
    }
    
    public DataDeleteRequest build()
    {
      long l = zzkr;
      boolean bool;
      if ((l > 0L) && (zzks > l)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Must specify a valid time interval");
      int i;
      if ((!zzqs) && (zzqq.isEmpty()) && (zzlf.isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      int j;
      if ((!zzqt) && (zzqr.isEmpty())) {
        j = 0;
      } else {
        j = 1;
      }
      if ((i == 0) && (j == 0)) {
        bool = false;
      } else {
        bool = true;
      }
      Preconditions.checkState(bool, "No data or session marked for deletion");
      if (!zzqr.isEmpty())
      {
        Iterator localIterator = zzqr.iterator();
        while (localIterator.hasNext())
        {
          Session localSession = (Session)localIterator.next();
          TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
          if ((localSession.getStartTime(localTimeUnit) >= zzkr) && (localSession.getEndTime(localTimeUnit) <= zzks)) {
            bool = true;
          } else {
            bool = false;
          }
          Preconditions.checkState(bool, "Session %s is outside the time interval [%d, %d]", new Object[] { localSession, Long.valueOf(zzkr), Long.valueOf(zzks) });
        }
      }
      return new DataDeleteRequest(this, null);
    }
    
    public Builder deleteAllData()
    {
      Preconditions.checkArgument(zzlf.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
      Preconditions.checkArgument(zzqq.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
      zzqs = true;
      return this;
    }
    
    public Builder deleteAllSessions()
    {
      Preconditions.checkArgument(zzqr.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
      zzqt = true;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramLong1 > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid start time: %d", new Object[] { Long.valueOf(paramLong1) });
      if (paramLong2 > paramLong1) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid end time: %d", new Object[] { Long.valueOf(paramLong2) });
      zzkr = paramTimeUnit.toMillis(paramLong1);
      zzks = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}
