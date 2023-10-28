package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;

public final class Effect
{
  private static final ClassLoader thisClassLoader = zzc.class.getClassLoader();
  
  private Effect() {}
  
  public static boolean stop(Parcel paramParcel)
  {
    return paramParcel.readInt() != 0;
  }
  
  public static void writeValue(Parcel paramParcel, boolean paramBoolean)
  {
    paramParcel.writeInt(1);
  }
}
