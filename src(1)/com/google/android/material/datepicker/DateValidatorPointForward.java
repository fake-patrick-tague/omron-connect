package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class DateValidatorPointForward
  implements CalendarConstraints.DateValidator
{
  public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new a();
  private final long mId;
  
  private DateValidatorPointForward(long paramLong)
  {
    mId = paramLong;
  }
  
  public static DateValidatorPointForward getText(long paramLong)
  {
    return new DateValidatorPointForward(paramLong);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong >= mId;
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
    if (!(paramObject instanceof DateValidatorPointForward)) {
      return false;
    }
    paramObject = (DateValidatorPointForward)paramObject;
    return mId == mId;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(mId) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(mId);
  }
  
  static final class a
    implements Parcelable.Creator<DateValidatorPointForward>
  {
    a() {}
    
    public DateValidatorPointForward[] a(int paramInt)
    {
      return new DateValidatorPointForward[paramInt];
    }
    
    public DateValidatorPointForward readDate(Parcel paramParcel)
    {
      return new DateValidatorPointForward(paramParcel.readLong(), null);
    }
  }
}
