package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fitness.zzko;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="DataPointCreator")
@SafeParcelable.Reserved({1000, 8})
public final class DataPoint
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  @ShowFirstParty
  public static final Parcelable.Creator<DataPoint> CREATOR = new Point.1();
  @SafeParcelable.Field(getter="getDataSource", id=1)
  private final DataSource zzkq;
  @SafeParcelable.Field(getter="getTimestampNanos", id=3)
  private long zzlj;
  @SafeParcelable.Field(getter="getStartTimeNanos", id=4)
  private long zzlk;
  @SafeParcelable.Field(getter="getValues", id=5)
  private final Value[] zzll;
  @SafeParcelable.Field(getter="getOriginalDataSourceIfSet", id=6)
  private DataSource zzlm;
  @SafeParcelable.Field(getter="getRawTimestamp", id=7)
  private final long zzln;
  
  private DataPoint(DataSource paramDataSource)
  {
    zzkq = ((DataSource)Preconditions.checkNotNull(paramDataSource, "Data source cannot be null"));
    paramDataSource = paramDataSource.getDataType().getFields();
    zzll = new Value[paramDataSource.size()];
    paramDataSource = paramDataSource.iterator();
    int i = 0;
    while (paramDataSource.hasNext())
    {
      Field localField = (Field)paramDataSource.next();
      zzll[i] = new Value(localField.getFormat());
      i += 1;
    }
    zzln = 0L;
  }
  
  public DataPoint(DataSource paramDataSource1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, DataSource paramDataSource2, long paramLong3)
  {
    zzkq = paramDataSource1;
    zzlm = paramDataSource2;
    zzlj = paramLong1;
    zzlk = paramLong2;
    zzll = paramArrayOfValue;
    zzln = paramLong3;
  }
  
  private DataPoint(DataSource paramDataSource1, DataSource paramDataSource2, RawDataPoint paramRawDataPoint)
  {
    this(paramDataSource1, paramRawDataPoint.getCssPageRect(), paramRawDataPoint.getSoundPath(), paramRawDataPoint.getHttpProxy(), paramDataSource2, paramRawDataPoint.getMessageNumber());
  }
  
  DataPoint(List paramList, RawDataPoint paramRawDataPoint)
  {
    this((DataSource)Preconditions.checkNotNull(create(paramList, paramRawDataPoint.val())), create(paramList, paramRawDataPoint.getMembers()), paramRawDataPoint);
  }
  
  public static Builder builder(DataSource paramDataSource)
  {
    Preconditions.checkNotNull(paramDataSource, "DataSource should be specified");
    return new Builder(paramDataSource, null);
  }
  
  public static DataPoint create(DataSource paramDataSource)
  {
    return new DataPoint(paramDataSource);
  }
  
  private static DataSource create(List paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return (DataSource)paramList.get(paramInt);
    }
    return null;
  }
  
  private final void create(int paramInt)
  {
    List localList = getDataType().getFields();
    int i = localList.size();
    boolean bool;
    if (paramInt == i) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Attempting to insert %s values, but needed %s: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localList });
  }
  
  public static DataPoint extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataPoint)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DataPoint)) {
      return false;
    }
    paramObject = (DataPoint)paramObject;
    return (Objects.equal(zzkq, zzkq)) && (zzlj == zzlj) && (zzlk == zzlk) && (Arrays.equals(zzll, zzll)) && (Objects.equal(getOriginalDataSource(), paramObject.getOriginalDataSource()));
  }
  
  public final DataSource getDataSource()
  {
    return zzkq;
  }
  
  public final DataType getDataType()
  {
    return zzkq.getDataType();
  }
  
  public final long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzlj, TimeUnit.NANOSECONDS);
  }
  
  public final DataSource getOriginalDataSource()
  {
    DataSource localDataSource = zzlm;
    if (localDataSource != null) {
      return localDataSource;
    }
    return zzkq;
  }
  
  public final long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzlk, TimeUnit.NANOSECONDS);
  }
  
  public final long getTimestamp(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(zzlj, TimeUnit.NANOSECONDS);
  }
  
  public final Value getValue(Field paramField)
  {
    int i = getDataType().indexOf(paramField);
    return zzll[i];
  }
  
  public final long getX()
  {
    return zzln;
  }
  
  public final Value[] getY()
  {
    return zzll;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zzkq, Long.valueOf(zzlj), Long.valueOf(zzlk) });
  }
  
  public final void next()
  {
    DataSource localDataSource = getDataSource();
    Preconditions.checkArgument(getDataType().getName().equals(localDataSource.getDataType().getName()), "Conflicting data types found %s vs %s", new Object[] { getDataType(), getDataType() });
    boolean bool;
    if (zzlj > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Data point does not have the timestamp set: %s", new Object[] { this });
    if (zzlk <= zzlj) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Data point with start time greater than end time found: %s", new Object[] { this });
  }
  
  public final Value read(int paramInt)
  {
    DataType localDataType = getDataType();
    boolean bool;
    if ((paramInt >= 0) && (paramInt < localDataType.getFields().size())) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "fieldIndex %s is out of range for %s", new Object[] { Integer.valueOf(paramInt), localDataType });
    return zzll[paramInt];
  }
  
  public final DataPoint setFloatValues(float... paramVarArgs)
  {
    create(paramVarArgs.length);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      zzll[i].setFloat(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public final DataPoint setIntValues(int... paramVarArgs)
  {
    create(paramVarArgs.length);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      zzll[i].setInt(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public final DataPoint setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    zzlk = paramTimeUnit.toNanos(paramLong1);
    zzlj = paramTimeUnit.toNanos(paramLong2);
    return this;
  }
  
  public final DataPoint setTimestamp(long paramLong, TimeUnit paramTimeUnit)
  {
    zzlj = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public final String toString()
  {
    String str1 = Arrays.toString(zzll);
    long l1 = zzlk;
    long l2 = zzlj;
    long l3 = zzln;
    String str2 = zzkq.toDebugString();
    Object localObject = zzlm;
    if (localObject != null) {
      localObject = ((DataSource)localObject).toDebugString();
    } else {
      localObject = "N/A";
    }
    return String.format("DataPoint{%s@[%s, %s,raw=%s](%s %s)}", new Object[] { str1, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), str2, localObject });
  }
  
  public final DataSource value()
  {
    return zzlm;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataSource(), paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 3, zzlj);
    SafeParcelWriter.writeLong(paramParcel, 4, zzlk);
    SafeParcelWriter.writeTypedArray(paramParcel, 5, zzll, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, zzlm, paramInt, false);
    SafeParcelWriter.writeLong(paramParcel, 7, zzln);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static class Builder
  {
    private final DataPoint zzlo;
    private boolean zzlp = false;
    
    private Builder(DataSource paramDataSource)
    {
      zzlo = DataPoint.create(paramDataSource);
    }
    
    public DataPoint build()
    {
      Preconditions.checkState(zzlp ^ true, "DataPoint#build should not be called multiple times.");
      zzlp = true;
      return zzlo;
    }
    
    public Builder setActivityField(Field paramField, String paramString)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzlo.getValue(paramField).setInt(zzko.findPosition(paramString));
      return this;
    }
    
    public Builder setField(Field paramField, float paramFloat)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzlo.getValue(paramField).setFloat(paramFloat);
      return this;
    }
    
    public Builder setField(Field paramField, int paramInt)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzlo.getValue(paramField).setInt(paramInt);
      return this;
    }
    
    public Builder setField(Field paramField, String paramString)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzlo.getValue(paramField).setString(paramString);
      return this;
    }
    
    public Builder setField(Field paramField, Map paramMap)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzlo.getValue(paramField).add(paramMap);
      return this;
    }
    
    public Builder setFloatValues(float... paramVarArgs)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzlo.setFloatValues(paramVarArgs);
      return this;
    }
    
    public Builder setIntValues(int... paramVarArgs)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzlo.setIntValues(paramVarArgs);
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzlo.setTimeInterval(paramLong1, paramLong2, paramTimeUnit);
      return this;
    }
    
    public Builder setTimestamp(long paramLong, TimeUnit paramTimeUnit)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzlo.setTimestamp(paramLong, paramTimeUnit);
      return this;
    }
  }
}
