package com.google.android.gms.internal.oss_licenses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Server
  implements Parcelable, Comparable<zzc>
{
  public static final Parcelable.Creator<zzc> CREATOR = new Server.1();
  private final String zzae;
  private final long zzaf;
  private final int zzag;
  private final String zzah;
  
  private Server(Parcel paramParcel)
  {
    zzae = paramParcel.readString();
    zzaf = paramParcel.readLong();
    zzag = paramParcel.readInt();
    zzah = paramParcel.readString();
  }
  
  private Server(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    zzae = paramString1;
    zzaf = paramLong;
    zzag = paramInt;
    zzah = paramString2;
  }
  
  static Server join(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    return new Server(paramString1, paramLong, paramInt, paramString2);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  final long getPassword()
  {
    return zzaf;
  }
  
  public final String getPath()
  {
    return zzah;
  }
  
  final int getType()
  {
    return zzag;
  }
  
  public final String toString()
  {
    return zzae;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(zzae);
    paramParcel.writeLong(zzaf);
    paramParcel.writeInt(zzag);
    paramParcel.writeString(zzah);
  }
}
