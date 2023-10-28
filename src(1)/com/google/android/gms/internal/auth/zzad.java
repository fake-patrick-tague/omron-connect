package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="RetrieveDataRequestCreator")
public final class zzad
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzad> CREATOR = new zzae();
  @SafeParcelable.Field(id=2)
  private final String accountType;
  @SafeParcelable.VersionField(id=1)
  private final int type = 1;
  
  zzad(int paramInt, String paramString)
  {
    accountType = ((String)Preconditions.checkNotNull(paramString));
  }
  
  public zzad(String paramString)
  {
    this(1, paramString);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, type);
    SafeParcelWriter.writeString(paramParcel, 2, accountType, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
