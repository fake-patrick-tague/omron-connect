package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.internal.fitness.zzkn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SafeParcelable.Class(creator="DataSetCreator")
@SafeParcelable.Reserved({2, 5})
public final class DataSet
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<DataSet> CREATOR = new VerticalProgressBar.SavedState.1();
  @SafeParcelable.VersionField(getter="getVersionCode", id=1000)
  private final int versionCode;
  @SafeParcelable.Field(getter="getDataSource", id=1)
  private final DataSource zzkq;
  @SafeParcelable.Field(getter="getRawDataPoints", id=3, type="java.util.List")
  private final List<DataPoint> zzlq;
  @SafeParcelable.Field(getter="getUniqueDataSources", id=4)
  private final List<DataSource> zzlr;
  
  DataSet(int paramInt, DataSource paramDataSource, List paramList1, List paramList2)
  {
    versionCode = paramInt;
    zzkq = paramDataSource;
    zzlq = new ArrayList(paramList1.size());
    if (paramInt < 2) {
      paramList2 = Collections.singletonList(paramDataSource);
    }
    zzlr = paramList2;
    paramDataSource = paramList1.iterator();
    while (paramDataSource.hasNext())
    {
      paramList1 = (RawDataPoint)paramDataSource.next();
      zzlq.add(new DataPoint(zzlr, paramList1));
    }
  }
  
  private DataSet(DataSource paramDataSource)
  {
    versionCode = 3;
    paramDataSource = (DataSource)Preconditions.checkNotNull(paramDataSource);
    zzkq = paramDataSource;
    zzlq = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    zzlr = localArrayList;
    localArrayList.add(paramDataSource);
  }
  
  public DataSet(RawDataSet paramRawDataSet, List paramList)
  {
    versionCode = 3;
    zzkq = ((DataSource)paramList.get(zzoa));
    zzlr = paramList;
    paramRawDataSet = zzoc;
    zzlq = new ArrayList(paramRawDataSet.size());
    paramRawDataSet = paramRawDataSet.iterator();
    while (paramRawDataSet.hasNext())
    {
      paramList = (RawDataPoint)paramRawDataSet.next();
      zzlq.add(new DataPoint(zzlr, paramList));
    }
  }
  
  private final void addEntry(DataPoint paramDataPoint)
  {
    zzlq.add(paramDataPoint);
    paramDataPoint = paramDataPoint.getOriginalDataSource();
    if ((paramDataPoint != null) && (!zzlr.contains(paramDataPoint))) {
      zzlr.add(paramDataPoint);
    }
  }
  
  public static Builder builder(DataSource paramDataSource)
  {
    Preconditions.checkNotNull(paramDataSource, "DataSource should be specified");
    return new Builder(paramDataSource, null);
  }
  
  private final List copy()
  {
    return copy(zzlr);
  }
  
  public static DataSet create(DataSource paramDataSource)
  {
    Preconditions.checkNotNull(paramDataSource, "DataSource should be specified");
    return new DataSet(paramDataSource);
  }
  
  public static void doInBackground(DataPoint paramDataPoint)
  {
    Object localObject2 = Locations.getInstalledApps(paramDataPoint.getDataType().getName());
    Object localObject1 = "DataPoint out of range";
    if (localObject2 != null)
    {
      localObject2 = paramDataPoint.getDataType();
      int i = 0;
      while (i < ((DataType)localObject2).getFields().size())
      {
        Object localObject3 = ((Field)((DataType)localObject2).getFields().get(i)).getName();
        if (!paramDataPoint.read(i).isSet())
        {
          if ((!Boolean.TRUE.equals(((Field)((DataType)localObject2).getFields().get(i)).isOptional())) && (!zzah.zzom.contains(localObject3)))
          {
            localObject1 = String.valueOf(localObject3).concat(" not set");
            break label366;
          }
        }
        else
        {
          double d = ((Field)((DataType)localObject2).getFields().get(i)).getFormat();
          if (d == 1.0D)
          {
            d = paramDataPoint.read(i).asInt();
          }
          else
          {
            if (d != 2.0D) {
              break label290;
            }
            d = paramDataPoint.read(i).asFloat();
          }
          Object localObject4 = zzah.getSecond().getClass((String)localObject3);
          if ((localObject4 != null) && (!((zzaj)localObject4).equals(d)))
          {
            localObject1 = "Field out of range";
          }
          else
          {
            localObject4 = ((DataType)localObject2).getName();
            localObject3 = zzah.getSecond().format((String)localObject4, (String)localObject3);
            if (localObject3 != null)
            {
              localObject4 = TimeUnit.NANOSECONDS;
              long l = paramDataPoint.getEndTime((TimeUnit)localObject4) - paramDataPoint.getStartTime((TimeUnit)localObject4);
              if (l == 0L)
              {
                if (d == 0.0D) {
                  break label363;
                }
                break label366;
              }
              if (!((zzaj)localObject3).equals(d / l)) {
                break label366;
              }
            }
          }
        }
        label290:
        i += 1;
      }
      if ("com.google.activity.segment".equals(paramDataPoint.getDataSource().getDataType().getName()))
      {
        localObject1 = paramDataPoint.getValue(Field.FIELD_ACTIVITY);
        if (localObject1 == null)
        {
          localObject1 = "activity is not set";
          break label366;
        }
        if (zzkn.getKey(((Value)localObject1).asInt(), zzkn.zzaig).zzdz())
        {
          localObject1 = "Sleep types are not a valid activity for com.google.activity.segment";
          break label366;
        }
      }
    }
    label363:
    localObject1 = null;
    label366:
    if (localObject1 == null) {
      return;
    }
    paramDataPoint = String.valueOf(paramDataPoint);
    localObject2 = new StringBuilder(paramDataPoint.length() + 20);
    ((StringBuilder)localObject2).append("Invalid data point: ");
    ((StringBuilder)localObject2).append(paramDataPoint);
    Log.w("Fitness", ((StringBuilder)localObject2).toString());
    throw new IllegalArgumentException((String)localObject1);
  }
  
  public final void addAll(Iterable paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      toString((DataPoint)paramIterable.next());
    }
  }
  
  final List copy(List paramList)
  {
    ArrayList localArrayList = new ArrayList(zzlq.size());
    Iterator localIterator = zzlq.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataPoint((DataPoint)localIterator.next(), paramList));
    }
    return localArrayList;
  }
  
  public final DataPoint createDataPoint()
  {
    return DataPoint.create(zzkq);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DataSet)) {
      return false;
    }
    paramObject = (DataSet)paramObject;
    return (Objects.equal(zzkq, zzkq)) && (Objects.equal(zzlq, zzlq));
  }
  
  public final List getDataPoints()
  {
    return Collections.unmodifiableList(zzlq);
  }
  
  public final DataSource getDataSource()
  {
    return zzkq;
  }
  
  public final DataType getDataType()
  {
    return zzkq.getDataType();
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zzkq });
  }
  
  public final boolean isEmpty()
  {
    return zzlq.isEmpty();
  }
  
  public final void putAll(Iterable paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      addEntry((DataPoint)paramIterable.next());
    }
  }
  
  public final String toString()
  {
    List localList = copy();
    Object localObject = localList;
    Locale localLocale = Locale.US;
    String str = zzkq.toDebugString();
    if (zzlq.size() >= 10) {
      localObject = String.format(localLocale, "%d data points, first 5: %s", new Object[] { Integer.valueOf(zzlq.size()), localList.subList(0, 5) });
    }
    return String.format(localLocale, "DataSet{%s %s}", new Object[] { str, localObject });
  }
  
  public final void toString(DataPoint paramDataPoint)
  {
    DataSource localDataSource = paramDataPoint.getDataSource();
    Preconditions.checkArgument(localDataSource.getStreamIdentifier().equals(zzkq.getStreamIdentifier()), "Conflicting data sources found %s vs %s", new Object[] { localDataSource, zzkq });
    paramDataPoint.next();
    doInBackground(paramDataPoint);
    addEntry(paramDataPoint);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataSource(), paramInt, false);
    SafeParcelWriter.writeList(paramParcel, 3, copy(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 4, zzlr, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, versionCode);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static class Builder
  {
    private boolean zzlp = false;
    private final DataSet zzls;
    
    private Builder(DataSource paramDataSource)
    {
      zzls = DataSet.create(paramDataSource);
    }
    
    public Builder addAll(Iterable paramIterable)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzls.addAll(paramIterable);
      return this;
    }
    
    public DataSet build()
    {
      Preconditions.checkState(zzlp ^ true, "DataSet#build() should only be called once.");
      zzlp = true;
      return zzls;
    }
    
    public Builder doCopy(DataPoint paramDataPoint)
    {
      Preconditions.checkState(zzlp ^ true, "Builder should not be mutated after calling #build.");
      zzls.toString(paramDataPoint);
      return this;
    }
  }
}
