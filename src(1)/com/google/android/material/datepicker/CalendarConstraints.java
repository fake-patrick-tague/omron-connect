package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import v7.v7.util.Context;

public final class CalendarConstraints
  implements Parcelable
{
  public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
  private Month added;
  private final DateValidator d;
  private final Month end;
  private final int itemCount;
  private final int p;
  private final Month values;
  
  private CalendarConstraints(Month paramMonth1, Month paramMonth2, DateValidator paramDateValidator, Month paramMonth3)
  {
    end = paramMonth1;
    values = paramMonth2;
    added = paramMonth3;
    d = paramDateValidator;
    if ((paramMonth3 != null) && (paramMonth1.compareTo(paramMonth3) > 0)) {
      throw new IllegalArgumentException("start Month cannot be after current Month");
    }
    if ((paramMonth3 != null) && (paramMonth3.compareTo(paramMonth2) > 0)) {
      throw new IllegalArgumentException("current Month cannot be after end Month");
    }
    p = (paramMonth1.toString(paramMonth2) + 1);
    itemCount = (a - a + 1);
  }
  
  public DateValidator a()
  {
    return d;
  }
  
  Month add()
  {
    return added;
  }
  
  Month add(Month paramMonth)
  {
    if (paramMonth.compareTo(end) < 0) {
      return end;
    }
    Month localMonth = paramMonth;
    if (paramMonth.compareTo(values) > 0) {
      localMonth = values;
    }
    return localMonth;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CalendarConstraints)) {
      return false;
    }
    paramObject = (CalendarConstraints)paramObject;
    return (end.equals(end)) && (values.equals(values)) && (Context.equals(added, added)) && (d.equals(d));
  }
  
  int getItemCount()
  {
    return itemCount;
  }
  
  Month getValue()
  {
    return values;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { end, values, added, d });
  }
  
  Month length()
  {
    return end;
  }
  
  int size()
  {
    return p;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(end, 0);
    paramParcel.writeParcelable(values, 0);
    paramParcel.writeParcelable(added, 0);
    paramParcel.writeParcelable(d, 0);
  }
  
  public static abstract interface DateValidator
    extends Parcelable
  {
    public abstract boolean a(long paramLong);
  }
  
  static final class a
    implements Parcelable.Creator<CalendarConstraints>
  {
    a() {}
    
    public CalendarConstraints[] a(int paramInt)
    {
      return new CalendarConstraints[paramInt];
    }
    
    public CalendarConstraints readFromParcel(Parcel paramParcel)
    {
      Month localMonth1 = (Month)paramParcel.readParcelable(Month.class.getClassLoader());
      Month localMonth2 = (Month)paramParcel.readParcelable(Month.class.getClassLoader());
      Month localMonth3 = (Month)paramParcel.readParcelable(Month.class.getClassLoader());
      return new CalendarConstraints(localMonth1, localMonth2, (CalendarConstraints.DateValidator)paramParcel.readParcelable(CalendarConstraints.DateValidator.class.getClassLoader()), localMonth3, null);
    }
  }
  
  public static final class b
  {
    static final long M = Log.add(add210011d);
    static final long a = Log.add(add19000d);
    private Long b;
    private long c = a;
    private long d = M;
    private CalendarConstraints.DateValidator f = DateValidatorPointForward.getText(Long.MIN_VALUE);
    
    b(CalendarConstraints paramCalendarConstraints)
    {
      c = access$getEndd;
      d = nextd;
      b = Long.valueOf(addedd);
      f = CalendarConstraints.b(paramCalendarConstraints);
    }
    
    public b a(long paramLong)
    {
      b = Long.valueOf(paramLong);
      return this;
    }
    
    public CalendarConstraints a()
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putParcelable("DEEP_COPY_VALIDATOR_KEY", f);
      Month localMonth1 = Month.toString(c);
      Month localMonth2 = Month.toString(d);
      CalendarConstraints.DateValidator localDateValidator = (CalendarConstraints.DateValidator)((Bundle)localObject).getParcelable("DEEP_COPY_VALIDATOR_KEY");
      localObject = b;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Month.toString(((Long)localObject).longValue());
      }
      return new CalendarConstraints(localMonth1, localMonth2, localDateValidator, (Month)localObject, null);
    }
  }
}
