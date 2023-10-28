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
import com.google.android.gms.internal.fitness.zzci;
import com.google.android.gms.internal.fitness.zzcl;

@ShowFirstParty
@SafeParcelable.Class(creator="SessionStopRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class zzba
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzba> CREATOR = new zzbd();
  @SafeParcelable.Field(getter="getName", id=1)
  private final String name;
  @SafeParcelable.Field(getter="getIdentifier", id=2)
  private final String zzod;
  @SafeParcelable.Field(getter="getCallbackBinder", id=3, type="android.os.IBinder")
  private final zzci zzsm;
  
  zzba(String paramString1, String paramString2, IBinder paramIBinder)
  {
    name = paramString1;
    zzod = paramString2;
    if (paramIBinder == null) {
      paramString1 = null;
    } else {
      paramString1 = zzcl.asInterface(paramIBinder);
    }
    zzsm = paramString1;
  }
  
  public zzba(String paramString1, String paramString2, zzci paramZzci)
  {
    name = paramString1;
    zzod = paramString2;
    zzsm = paramZzci;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzba)) {
      return false;
    }
    paramObject = (zzba)paramObject;
    return (Objects.equal(name, name)) && (Objects.equal(zzod, zzod));
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { name, zzod });
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).name("name", name).name("identifier", zzod).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, name, false);
    SafeParcelWriter.writeString(paramParcel, 2, zzod, false);
    Object localObject = zzsm;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
