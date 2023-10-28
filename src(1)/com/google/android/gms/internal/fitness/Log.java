package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Log
{
  private static final ClassLoader thisClassLoader = zzd.class.getClassLoader();
  
  private Log() {}
  
  public static void close(Parcel paramParcel, Parcelable paramParcelable)
  {
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
  }
  
  public static Parcelable unmarshall(Parcel paramParcel, Parcelable.Creator paramCreator)
  {
    if (paramParcel.readInt() == 0) {
      return null;
    }
    return (Parcelable)paramCreator.createFromParcel(paramParcel);
  }
}
