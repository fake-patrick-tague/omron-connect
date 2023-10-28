package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month
  implements Comparable<Month>, Parcelable
{
  public static final Parcelable.Creator<Month> CREATOR = new a();
  final int a;
  final int b;
  final int c;
  final long d;
  private final Calendar date;
  private String path;
  final int type;
  
  private Month(Calendar paramCalendar)
  {
    paramCalendar.set(5, 1);
    paramCalendar = Log.getTime(paramCalendar);
    date = paramCalendar;
    type = paramCalendar.get(2);
    a = paramCalendar.get(1);
    b = paramCalendar.getMaximum(7);
    c = paramCalendar.getActualMaximum(5);
    d = paramCalendar.getTimeInMillis();
  }
  
  static Month add(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = Log.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    return new Month(localCalendar);
  }
  
  static Month next()
  {
    return new Month(Log.getCalendar());
  }
  
  static Month toString(long paramLong)
  {
    Calendar localCalendar = Log.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return new Month(localCalendar);
  }
  
  public int compareTo(Month paramMonth)
  {
    return date.compareTo(date);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int equals()
  {
    int j = date.get(7) - date.getFirstDayOfWeek();
    int i = j;
    if (j < 0) {
      i = j + b;
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Month)) {
      return false;
    }
    paramObject = (Month)paramObject;
    return (type == type) && (a == a);
  }
  
  long get(int paramInt)
  {
    Calendar localCalendar = Log.getTime(date);
    localCalendar.set(5, paramInt);
    return localCalendar.getTimeInMillis();
  }
  
  int getDate(long paramLong)
  {
    Calendar localCalendar = Log.getTime(date);
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(5);
  }
  
  long getDate()
  {
    return date.getTimeInMillis();
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(type), Integer.valueOf(a) });
  }
  
  int toString(Month paramMonth)
  {
    if ((date instanceof GregorianCalendar)) {
      return (a - a) * 12 + (type - type);
    }
    throw new IllegalArgumentException("Only Gregorian calendars are supported.");
  }
  
  Month toString(int paramInt)
  {
    Calendar localCalendar = Log.getTime(date);
    localCalendar.add(2, paramInt);
    return new Month(localCalendar);
  }
  
  String toString(Context paramContext)
  {
    if (path == null) {
      path = Segment.toString(paramContext, date.getTimeInMillis());
    }
    return path;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
    paramParcel.writeInt(type);
  }
  
  static final class a
    implements Parcelable.Creator<Month>
  {
    a() {}
    
    public Month a(Parcel paramParcel)
    {
      return Month.add(paramParcel.readInt(), paramParcel.readInt());
    }
    
    public Month[] a(int paramInt)
    {
      return new Month[paramInt];
    }
  }
}
