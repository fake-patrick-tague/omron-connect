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
import com.google.android.gms.internal.fitness.zzcg;
import com.google.android.gms.internal.fitness.zzch;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="SessionReadRequestCreator")
@SafeParcelable.Reserved({11, 1000})
public class SessionReadRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<SessionReadRequest> CREATOR = new zzax();
  @SafeParcelable.Field(getter="getStartTimeMillis", id=3)
  private final long zzkr;
  @SafeParcelable.Field(getter="getEndTimeMillis", id=4)
  private final long zzks;
  @SafeParcelable.Field(getter="getDataTypes", id=5)
  private final List<DataType> zzlf;
  @SafeParcelable.Field(getter="getDataSources", id=6)
  private final List<DataSource> zzqq;
  @SafeParcelable.Field(getter="areServerQueriesEnabled", id=8)
  private final boolean zzrc;
  @SafeParcelable.Field(getter="getSessionName", id=1)
  private final String zzsd;
  @SafeParcelable.Field(getter="getSessionId", id=2)
  private final String zzse;
  @SafeParcelable.Field(getter="includeSessionsFromAllApps", id=7)
  private final boolean zzsf;
  @SafeParcelable.Field(getter="getExcludedPackages", id=9)
  private final List<String> zzsg;
  @SafeParcelable.Field(getter="getCallbackBinder", id=10, type="android.os.IBinder")
  private final zzch zzsh;
  @SafeParcelable.Field(defaultValue="true", getter="areActivitySessionsIncluded", id=12)
  private final boolean zzsi;
  @SafeParcelable.Field(defaultValue="false", getter="areSleepSessionsIncluded", id=13)
  private final boolean zzsj;
  
  private SessionReadRequest(Builder paramBuilder)
  {
    this(Builder.getDbFilename(paramBuilder), Builder.getSoundPath(paramBuilder), Builder.getEWAHIterator(paramBuilder), Builder.addPosition(paramBuilder), Builder.fromField(paramBuilder), Builder.log1p(paramBuilder), Builder.isInheritable(paramBuilder), Builder.getPicture(paramBuilder), Builder.getArticleUrl(paramBuilder), null, Builder.get0(paramBuilder), Builder.goToPage(paramBuilder));
  }
  
  public SessionReadRequest(SessionReadRequest paramSessionReadRequest, zzch paramZzch)
  {
    this(zzsd, zzse, zzkr, zzks, zzlf, zzqq, zzsf, zzrc, zzsg, paramZzch.asBinder(), zzsi, zzsj);
  }
  
  SessionReadRequest(String paramString1, String paramString2, long paramLong1, long paramLong2, List paramList1, List paramList2, boolean paramBoolean1, boolean paramBoolean2, List paramList3, IBinder paramIBinder, boolean paramBoolean3, boolean paramBoolean4)
  {
    zzsd = paramString1;
    zzse = paramString2;
    zzkr = paramLong1;
    zzks = paramLong2;
    zzlf = paramList1;
    zzqq = paramList2;
    zzsf = paramBoolean1;
    zzrc = paramBoolean2;
    zzsg = paramList3;
    if (paramIBinder == null) {
      paramString1 = null;
    } else {
      paramString1 = zzcg.asInterface(paramIBinder);
    }
    zzsh = paramString1;
    zzsi = paramBoolean3;
    zzsj = paramBoolean4;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof SessionReadRequest)) {
      return false;
    }
    paramObject = (SessionReadRequest)paramObject;
    return (Objects.equal(zzsd, zzsd)) && (zzse.equals(zzse)) && (zzkr == zzkr) && (zzks == zzks) && (Objects.equal(zzlf, zzlf)) && (Objects.equal(zzqq, zzqq)) && (zzsf == zzsf) && (zzsg.equals(zzsg)) && (zzrc == zzrc) && (zzsi == zzsi) && (zzsj == zzsj);
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
  
  public List getExcludedPackages()
  {
    return zzsg;
  }
  
  public String getSessionId()
  {
    return zzse;
  }
  
  public String getSessionName()
  {
    return zzsd;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzkr, TimeUnit.MILLISECONDS);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzsd, zzse, Long.valueOf(zzkr), Long.valueOf(zzks) });
  }
  
  public boolean includeSessionsFromAllApps()
  {
    return zzsf;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("sessionName", zzsd).name("sessionId", zzse).name("startTimeMillis", Long.valueOf(zzkr)).name("endTimeMillis", Long.valueOf(zzks)).name("dataTypes", zzlf).name("dataSources", zzqq).name("sessionsFromAllApps", Boolean.valueOf(zzsf)).name("excludedPackages", zzsg).name("useServer", Boolean.valueOf(zzrc)).name("activitySessionsIncluded", Boolean.valueOf(zzsi)).name("sleepSessionsIncluded", Boolean.valueOf(zzsj)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getSessionName(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getSessionId(), false);
    SafeParcelWriter.writeLong(paramParcel, 3, zzkr);
    SafeParcelWriter.writeLong(paramParcel, 4, zzks);
    SafeParcelWriter.writeTypedList(paramParcel, 5, getDataTypes(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 6, getDataSources(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, includeSessionsFromAllApps());
    SafeParcelWriter.writeBoolean(paramParcel, 8, zzrc);
    SafeParcelWriter.writeStringList(paramParcel, 9, getExcludedPackages(), false);
    Object localObject = zzsh;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 10, (IBinder)localObject, false);
    SafeParcelWriter.writeBoolean(paramParcel, 12, zzsi);
    SafeParcelWriter.writeBoolean(paramParcel, 13, zzsj);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private long zzkr = 0L;
    private long zzks = 0L;
    private final List<DataType> zzlf = new ArrayList();
    private final List<DataSource> zzqq = new ArrayList();
    private boolean zzrc = false;
    private String zzsd;
    private String zzse;
    private final List<String> zzsg = new ArrayList();
    private boolean zzsi = false;
    private boolean zzsj = false;
    private boolean zzsk = false;
    private boolean zzsl = false;
    
    public Builder() {}
    
    public SessionReadRequest build()
    {
      long l = zzkr;
      boolean bool;
      if (l > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid start time: %s", new Object[] { Long.valueOf(l) });
      l = zzks;
      if ((l > 0L) && (l > zzkr)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid end time: %s", new Object[] { Long.valueOf(l) });
      if (!zzsl) {
        zzsi = true;
      }
      return new SessionReadRequest(this, null);
    }
    
    public Builder enableServerQueries()
    {
      zzrc = true;
      return this;
    }
    
    public Builder excludePackage(String paramString)
    {
      Preconditions.checkNotNull(paramString, "Attempting to use a null package name");
      if (!zzsg.contains(paramString)) {
        zzsg.add(paramString);
      }
      return this;
    }
    
    public Builder includeActivitySessions()
    {
      zzsi = true;
      zzsl = true;
      return this;
    }
    
    public Builder includeSleepSessions()
    {
      zzsj = true;
      zzsl = true;
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      Preconditions.checkNotNull(paramDataSource, "Attempting to add a null data source");
      if (!zzqq.contains(paramDataSource)) {
        zzqq.add(paramDataSource);
      }
      return this;
    }
    
    public Builder read(DataType paramDataType)
    {
      Preconditions.checkNotNull(paramDataType, "Attempting to use a null data type");
      if (!zzlf.contains(paramDataType)) {
        zzlf.add(paramDataType);
      }
      return this;
    }
    
    public Builder readSessionsFromAllApps()
    {
      zzsk = true;
      return this;
    }
    
    public Builder setSessionId(String paramString)
    {
      zzse = paramString;
      return this;
    }
    
    public Builder setSessionName(String paramString)
    {
      zzsd = paramString;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      zzkr = paramTimeUnit.toMillis(paramLong1);
      zzks = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}
