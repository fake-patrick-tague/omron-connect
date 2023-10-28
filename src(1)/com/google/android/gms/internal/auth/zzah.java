package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="UserChallengeRequestCreator")
public final class zzah
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzah> CREATOR = new zzai();
  @SafeParcelable.Field(id=2)
  private final String accountType;
  @SafeParcelable.VersionField(id=1)
  private final int type = 1;
  @SafeParcelable.Field(id=3)
  private final PendingIntent zzbx;
  
  zzah(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    accountType = ((String)Preconditions.checkNotNull(paramString));
    zzbx = ((PendingIntent)Preconditions.checkNotNull(paramPendingIntent));
  }
  
  public zzah(String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramString, paramPendingIntent);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, type);
    SafeParcelWriter.writeString(paramParcel, 2, accountType, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, zzbx, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
