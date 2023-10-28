package com.google.android.gms.fitness.result;

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
import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator="SessionReadResultCreator")
@SafeParcelable.Reserved({4, 1000})
public class SessionReadResult
  extends AbstractSafeParcelable
  implements Result
{
  @RecentlyNonNull
  public static final Parcelable.Creator<SessionReadResult> CREATOR = new Point.1();
  @SafeParcelable.Field(getter="getSessions", id=1)
  private final List<Session> zzqr;
  @SafeParcelable.Field(getter="getStatus", id=3)
  private final Status zzsv;
  @SafeParcelable.Field(getter="getSessionDataSets", id=2)
  private final List<zzae> zzta;
  
  public SessionReadResult(List paramList1, List paramList2, Status paramStatus)
  {
    zzqr = paramList1;
    zzta = Collections.unmodifiableList(paramList2);
    zzsv = paramStatus;
  }
  
  public static SessionReadResult getScreen(Status paramStatus)
  {
    return new SessionReadResult(new ArrayList(), new ArrayList(), paramStatus);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof SessionReadResult)) {
      return false;
    }
    paramObject = (SessionReadResult)paramObject;
    return (zzsv.equals(zzsv)) && (Objects.equal(zzqr, zzqr)) && (Objects.equal(zzta, zzta));
  }
  
  public List getDataSet(Session paramSession)
  {
    Preconditions.checkArgument(zzqr.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzta.iterator();
    while (localIterator.hasNext())
    {
      zzae localZzae = (zzae)localIterator.next();
      if (Objects.equal(paramSession, localZzae.getSession())) {
        localArrayList.add(localZzae.getDataSet());
      }
    }
    return localArrayList;
  }
  
  public List getDataSet(Session paramSession, DataType paramDataType)
  {
    Preconditions.checkArgument(zzqr.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzta.iterator();
    while (localIterator.hasNext())
    {
      zzae localZzae = (zzae)localIterator.next();
      if ((Objects.equal(paramSession, localZzae.getSession())) && (paramDataType.equals(localZzae.getDataSet().getDataType()))) {
        localArrayList.add(localZzae.getDataSet());
      }
    }
    return localArrayList;
  }
  
  public List getSessions()
  {
    return zzqr;
  }
  
  public Status getStatus()
  {
    return zzsv;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzsv, zzqr, zzta });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("status", zzsv).name("sessions", zzqr).name("sessionDataSets", zzta).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getSessions(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, zzta, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
