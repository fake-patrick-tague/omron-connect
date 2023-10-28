package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.fitness.zzbi;
import com.google.android.gms.internal.fitness.zzbl;

@Deprecated
@ShowFirstParty
@SafeParcelable.Class(creator="DataTypeReadRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class Artist
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzr> CREATOR = new DownloadProgressInfo.1();
  @SafeParcelable.Field(getter="getName", id=1)
  private final String name;
  @SafeParcelable.Field(getter="getCallbackBinder", id=3, type="android.os.IBinder")
  private final zzbi zzrj;
  
  Artist(String paramString, IBinder paramIBinder)
  {
    name = paramString;
    zzrj = zzbl.asInterface(paramIBinder);
  }
  
  public Artist(String paramString, zzbi paramZzbi)
  {
    name = paramString;
    zzrj = paramZzbi;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof Artist)) && (Objects.equal(name, name)));
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { name });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).name("name", name).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, name, false);
    SafeParcelWriter.writeIBinder(paramParcel, 3, zzrj.asBinder(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
