package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fitness.zzkn;
import com.google.android.gms.internal.fitness.zzko;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="SessionCreator")
@SafeParcelable.Reserved({1000})
public class Session
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<Session> CREATOR = new zzaf();
  @RecentlyNonNull
  public static final String EXTRA_SESSION = "vnd.google.fitness.session";
  @RecentlyNonNull
  public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
  @SafeParcelable.Field(getter="getDescription", id=5)
  private final String description;
  @SafeParcelable.Field(getter="getName", id=3)
  private final String name;
  @SafeParcelable.Field(getter="getStartTimeMillis", id=1)
  private final long zzkr;
  @SafeParcelable.Field(getter="getEndTimeMillis", id=2)
  private final long zzks;
  @SafeParcelable.Field(getter="getActivityType", id=7)
  private final int zzlg;
  @SafeParcelable.Field(getter="getApplication", id=8)
  private final Entry zzlw;
  @SafeParcelable.Field(getter="getIdentifier", id=4)
  private final String zzod;
  @SafeParcelable.Field(getter="getActiveTimeMillis", id=9)
  private final Long zzoe;
  
  public Session(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt, Entry paramEntry, Long paramLong)
  {
    zzkr = paramLong1;
    zzks = paramLong2;
    name = paramString1;
    zzod = paramString2;
    description = paramString3;
    zzlg = paramInt;
    zzlw = paramEntry;
    zzoe = paramLong;
  }
  
  private Session(Builder paramBuilder)
  {
    this(Builder.getEWAHIterator(paramBuilder), Builder.log1p(paramBuilder), Builder.getAttributeName(paramBuilder), Builder.getSoundPath(paramBuilder), Builder.getDescription(paramBuilder), Builder.access$getMinimum(paramBuilder), null, Builder.getLabelId(paramBuilder));
  }
  
  public static Session extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (Session)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "vnd.google.fitness.session", CREATOR);
  }
  
  public static String getMimeType(String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return "vnd.google.fitness.session/".concat(paramString);
    }
    return new String("vnd.google.fitness.session/");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Session)) {
      return false;
    }
    paramObject = (Session)paramObject;
    return (zzkr == zzkr) && (zzks == zzks) && (Objects.equal(name, name)) && (Objects.equal(zzod, zzod)) && (Objects.equal(description, description)) && (Objects.equal(zzlw, zzlw)) && (zzlg == zzlg);
  }
  
  public long getActiveTime(TimeUnit paramTimeUnit)
  {
    Long localLong = zzoe;
    if (localLong != null) {
      return paramTimeUnit.convert(localLong.longValue(), TimeUnit.MILLISECONDS);
    }
    throw new IllegalStateException("Active time is not set");
  }
  
  public String getActivity()
  {
    return zzko.getName(zzlg);
  }
  
  public String getAppPackageName()
  {
    Entry localEntry = zzlw;
    if (localEntry == null) {
      return null;
    }
    return localEntry.getPackageName();
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzks, TimeUnit.MILLISECONDS);
  }
  
  public String getIdentifier()
  {
    return zzod;
  }
  
  public String getName()
  {
    return name;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzkr, TimeUnit.MILLISECONDS);
  }
  
  public boolean hasActiveTime()
  {
    return zzoe != null;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(zzkr), Long.valueOf(zzks), zzod });
  }
  
  public boolean isOngoing()
  {
    return zzks == 0L;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("startTime", Long.valueOf(zzkr)).name("endTime", Long.valueOf(zzks)).name("name", name).name("identifier", zzod).name("description", description).name("activity", Integer.valueOf(zzlg)).name("application", zzlw).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, zzkr);
    SafeParcelWriter.writeLong(paramParcel, 2, zzks);
    SafeParcelWriter.writeString(paramParcel, 3, getName(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getIdentifier(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getDescription(), false);
    SafeParcelWriter.writeInt(paramParcel, 7, zzlg);
    SafeParcelWriter.writeParcelable(paramParcel, 8, zzlw, paramInt, false);
    SafeParcelWriter.writeLongObject(paramParcel, 9, zzoe, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static class Builder
  {
    private String description = "";
    private String name = null;
    private long zzkr = 0L;
    private long zzks = 0L;
    private int zzlg = 4;
    private String zzod;
    private Long zzoe;
    
    public Builder() {}
    
    public Session build()
    {
      long l = zzkr;
      boolean bool2 = true;
      if (l > 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Start time should be specified.");
      l = zzks;
      boolean bool1 = bool2;
      if (l != 0L) {
        if (l > zzkr) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      Preconditions.checkState(bool1, "End time should be later than start time.");
      if (zzod == null)
      {
        Object localObject2 = name;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        l = zzkr;
        localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 20);
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(l);
        zzod = ((StringBuilder)localObject2).toString();
      }
      return new Session(this, null);
    }
    
    public Builder setActiveTime(long paramLong, TimeUnit paramTimeUnit)
    {
      zzoe = Long.valueOf(paramTimeUnit.toMillis(paramLong));
      return this;
    }
    
    public Builder setActivity(String paramString)
    {
      int j = zzko.findPosition(paramString);
      paramString = zzkn.getKey(j, zzkn.zzaig);
      int i;
      if ((paramString.zzdz()) && (!paramString.equals(zzkn.zzahi))) {
        i = 1;
      } else {
        i = 0;
      }
      Preconditions.checkArgument(i ^ 0x1, "Unsupported session activity type %s.", new Object[] { Integer.valueOf(j) });
      zzlg = j;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      boolean bool;
      if (paramString.length() <= 1000) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Session description cannot exceed %d characters", new Object[] { Integer.valueOf(1000) });
      description = paramString;
      return this;
    }
    
    public Builder setEndTime(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramLong >= 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "End time should be positive.");
      zzks = paramTimeUnit.toMillis(paramLong);
      return this;
    }
    
    public Builder setIdentifier(String paramString)
    {
      boolean bool;
      if ((paramString != null) && (TextUtils.getTrimmedLength(paramString) > 0)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      zzod = paramString;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      boolean bool;
      if (paramString.length() <= 100) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Session name cannot exceed %d characters", new Object[] { Integer.valueOf(100) });
      name = paramString;
      return this;
    }
    
    public Builder setStartTime(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool;
      if (paramLong > 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Start time should be positive.");
      zzkr = paramTimeUnit.toMillis(paramLong);
      return this;
    }
  }
}
