package com.google.android.gms.internal.oss_licenses;

import android.os.Parcel;
import java.util.ArrayList;

public class GameController
{
  private static final ClassLoader defaultLoader = zzb.class.getClassLoader();
  
  private GameController() {}
  
  public static ArrayList get(Parcel paramParcel)
  {
    return paramParcel.readArrayList(defaultLoader);
  }
}
