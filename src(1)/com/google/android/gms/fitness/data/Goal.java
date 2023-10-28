package com.google.android.gms.fitness.data;

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
import com.google.android.gms.internal.fitness.zzko;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="GoalCreator")
@SafeParcelable.Reserved({1000})
public class Goal
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<Goal> CREATOR = new PaymentIntent.Output.1();
  public static final int OBJECTIVE_TYPE_DURATION = 2;
  public static final int OBJECTIVE_TYPE_FREQUENCY = 3;
  public static final int OBJECTIVE_TYPE_METRIC = 1;
  @SafeParcelable.Field(getter="getCreateTimeNanos", id=1)
  private final long zznm;
  @SafeParcelable.Field(getter="getExpireTimeNanos", id=2)
  private final long zznn;
  @SafeParcelable.Field(getter="getActivities", id=3, type="java.util.List")
  private final List<Integer> zzno;
  @SafeParcelable.Field(getter="getRecurrence", id=4)
  private final Recurrence zznp;
  @SafeParcelable.Field(getter="getObjectiveType", id=5)
  private final int zznq;
  @SafeParcelable.Field(getter="getMetricObjectiveWithOutChecking", id=6)
  private final MetricObjective zznr;
  @SafeParcelable.Field(getter="getDurationObjectiveWithOutChecking", id=7)
  private final DurationObjective zzns;
  @SafeParcelable.Field(getter="getFrequencyObjectiveWithOutChecking", id=8)
  private final FrequencyObjective zznt;
  
  Goal(long paramLong1, long paramLong2, List paramList, Recurrence paramRecurrence, int paramInt, MetricObjective paramMetricObjective, DurationObjective paramDurationObjective, FrequencyObjective paramFrequencyObjective)
  {
    zznm = paramLong1;
    zznn = paramLong2;
    zzno = paramList;
    zznp = paramRecurrence;
    zznq = paramInt;
    zznr = paramMetricObjective;
    zzns = paramDurationObjective;
    zznt = paramFrequencyObjective;
  }
  
  private static String getType(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            return "frequency";
          }
          throw new IllegalArgumentException("invalid objective type value");
        }
        return "duration";
      }
      return "metric";
    }
    return "unknown";
  }
  
  private final void testDate(int paramInt)
  {
    if (paramInt == zznq) {
      return;
    }
    throw new MismatchedGoalException(String.format("%s goal does not have %s objective", new Object[] { getType(zznq), getType(paramInt) }));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Goal)) {
      return false;
    }
    paramObject = (Goal)paramObject;
    return (zznm == zznm) && (zznn == zznn) && (Objects.equal(zzno, zzno)) && (Objects.equal(zznp, zznp)) && (zznq == zznq) && (Objects.equal(zznr, zznr)) && (Objects.equal(zzns, zzns)) && (Objects.equal(zznt, zznt));
  }
  
  public String getActivityName()
  {
    if ((!zzno.isEmpty()) && (zzno.size() <= 1)) {
      return zzko.getName(((Integer)zzno.get(0)).intValue());
    }
    return null;
  }
  
  public long getCreateTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zznm, TimeUnit.NANOSECONDS);
  }
  
  public DurationObjective getDurationObjective()
  {
    testDate(2);
    return zzns;
  }
  
  public long getEndTime(Calendar paramCalendar, TimeUnit paramTimeUnit)
  {
    if (zznp != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramCalendar.getTime());
      int i = Recurrence.elementAt(zznp);
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localCalendar.add(2, 1);
            localCalendar.set(5, 1);
            localCalendar.set(11, 0);
            return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
          }
          i = Recurrence.elementAt(zznp);
          paramCalendar = new StringBuilder(24);
          paramCalendar.append("Invalid unit ");
          paramCalendar.append(i);
          throw new IllegalArgumentException(paramCalendar.toString());
        }
        localCalendar.add(4, 1);
        localCalendar.set(7, 2);
        localCalendar.set(11, 0);
        return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
      }
      localCalendar.add(5, 1);
      localCalendar.set(11, 0);
      return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
    }
    return paramTimeUnit.convert(zznn, TimeUnit.NANOSECONDS);
  }
  
  public FrequencyObjective getFrequencyObjective()
  {
    testDate(3);
    return zznt;
  }
  
  public MetricObjective getMetricObjective()
  {
    testDate(1);
    return zznr;
  }
  
  public int getObjectiveType()
  {
    return zznq;
  }
  
  public Recurrence getRecurrence()
  {
    return zznp;
  }
  
  public long getStartTime(Calendar paramCalendar, TimeUnit paramTimeUnit)
  {
    if (zznp != null)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(paramCalendar.getTime());
      int i = Recurrence.elementAt(zznp);
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            localCalendar.set(5, 1);
            localCalendar.set(11, 0);
            return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
          }
          i = Recurrence.elementAt(zznp);
          paramCalendar = new StringBuilder(24);
          paramCalendar.append("Invalid unit ");
          paramCalendar.append(i);
          throw new IllegalArgumentException(paramCalendar.toString());
        }
        localCalendar.set(7, 2);
        localCalendar.set(11, 0);
        return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
      }
      localCalendar.set(11, 0);
      return paramTimeUnit.convert(localCalendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
    }
    return paramTimeUnit.convert(zznm, TimeUnit.NANOSECONDS);
  }
  
  public int hashCode()
  {
    return zznq;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("activity", getActivityName()).name("recurrence", zznp).name("metricObjective", zznr).name("durationObjective", zzns).name("frequencyObjective", zznt).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeLong(paramParcel, 1, zznm);
    SafeParcelWriter.writeLong(paramParcel, 2, zznn);
    SafeParcelWriter.writeList(paramParcel, 3, zzno, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, getRecurrence(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 5, getObjectiveType());
    SafeParcelWriter.writeParcelable(paramParcel, 6, zznr, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 7, zzns, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 8, zznt, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  @SafeParcelable.Class(creator="DurationObjectiveCreator")
  @SafeParcelable.Reserved({1000})
  public static class DurationObjective
    extends AbstractSafeParcelable
  {
    @RecentlyNonNull
    public static final Parcelable.Creator<DurationObjective> CREATOR = new SpecialListsPriorityProperty.1();
    @SafeParcelable.Field(getter="getDuration", id=1)
    private final long zznu;
    
    DurationObjective(long paramLong)
    {
      zznu = paramLong;
    }
    
    public DurationObjective(long paramLong, TimeUnit paramTimeUnit)
    {
      this(paramTimeUnit.toNanos(paramLong));
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof DurationObjective)) {
        return false;
      }
      paramObject = (DurationObjective)paramObject;
      return zznu == zznu;
    }
    
    public long getDuration(TimeUnit paramTimeUnit)
    {
      return paramTimeUnit.convert(zznu, TimeUnit.NANOSECONDS);
    }
    
    public int hashCode()
    {
      return (int)zznu;
    }
    
    public String toString()
    {
      return Objects.toStringHelper(this).name("duration", Long.valueOf(zznu)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeLong(paramParcel, 1, zznu);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="FrequencyObjectiveCreator")
  @SafeParcelable.Reserved({1000})
  public static class FrequencyObjective
    extends AbstractSafeParcelable
  {
    @RecentlyNonNull
    public static final Parcelable.Creator<FrequencyObjective> CREATOR = new PaymentIntent.1();
    @SafeParcelable.Field(getter="getFrequency", id=1)
    private final int frequency;
    
    public FrequencyObjective(int paramInt)
    {
      frequency = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof FrequencyObjective)) {
        return false;
      }
      paramObject = (FrequencyObjective)paramObject;
      return frequency == frequency;
    }
    
    public int getFrequency()
    {
      return frequency;
    }
    
    public int hashCode()
    {
      return frequency;
    }
    
    public String toString()
    {
      return Objects.toStringHelper(this).name("frequency", Integer.valueOf(frequency)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, getFrequency());
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  @SafeParcelable.Class(creator="MetricObjectiveCreator")
  @SafeParcelable.Reserved({1000})
  public static class MetricObjective
    extends AbstractSafeParcelable
  {
    @RecentlyNonNull
    public static final Parcelable.Creator<MetricObjective> CREATOR = new SpecialListsListNameProperty.1();
    @SafeParcelable.Field(getter="getValue", id=2)
    private final double value;
    @SafeParcelable.Field(getter="getDataTypeName", id=1)
    private final String zznv;
    @SafeParcelable.Field(getter="getInitialValue", id=3)
    private final double zznw;
    
    public MetricObjective(String paramString, double paramDouble)
    {
      this(paramString, paramDouble, 0.0D);
    }
    
    public MetricObjective(String paramString, double paramDouble1, double paramDouble2)
    {
      zznv = paramString;
      value = paramDouble1;
      zznw = paramDouble2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof MetricObjective)) {
        return false;
      }
      paramObject = (MetricObjective)paramObject;
      return (Objects.equal(zznv, zznv)) && (value == value) && (zznw == zznw);
    }
    
    public String getDataTypeName()
    {
      return zznv;
    }
    
    public double getValue()
    {
      return value;
    }
    
    public int hashCode()
    {
      return zznv.hashCode();
    }
    
    public String toString()
    {
      return Objects.toStringHelper(this).name("dataTypeName", zznv).name("value", Double.valueOf(value)).name("initialValue", Double.valueOf(zznw)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeString(paramParcel, 1, getDataTypeName(), false);
      SafeParcelWriter.writeDouble(paramParcel, 2, getValue());
      SafeParcelWriter.writeDouble(paramParcel, 3, zznw);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
  
  public static class MismatchedGoalException
    extends IllegalStateException
  {
    public MismatchedGoalException(String paramString)
    {
      super();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ObjectiveType {}
  
  @SafeParcelable.Class(creator="RecurrenceCreator")
  @SafeParcelable.Reserved({1000})
  public static class Recurrence
    extends AbstractSafeParcelable
  {
    @RecentlyNonNull
    public static final Parcelable.Creator<Recurrence> CREATOR = new zzac();
    public static final int UNIT_DAY = 1;
    public static final int UNIT_MONTH = 3;
    public static final int UNIT_WEEK = 2;
    @SafeParcelable.Field(getter="getCount", id=1)
    private final int count;
    @SafeParcelable.Field(getter="getUnit", id=2)
    private final int zznx;
    
    public Recurrence(int paramInt1, int paramInt2)
    {
      count = paramInt1;
      boolean bool;
      if ((paramInt2 > 0) && (paramInt2 <= 3)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool);
      zznx = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof Recurrence)) {
        return false;
      }
      paramObject = (Recurrence)paramObject;
      return (count == count) && (zznx == zznx);
    }
    
    public int getCount()
    {
      return count;
    }
    
    public int getUnit()
    {
      return zznx;
    }
    
    public int hashCode()
    {
      return zznx;
    }
    
    public String toString()
    {
      Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this).name("count", Integer.valueOf(count));
      int i = zznx;
      String str;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            str = "month";
          } else {
            throw new IllegalArgumentException("invalid unit value");
          }
        }
        else {
          str = "week";
        }
      }
      else {
        str = "day";
      }
      return localToStringHelper.name("unit", str).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, getCount());
      SafeParcelWriter.writeInt(paramParcel, 2, getUnit());
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface RecurrenceUnit {}
  }
}
