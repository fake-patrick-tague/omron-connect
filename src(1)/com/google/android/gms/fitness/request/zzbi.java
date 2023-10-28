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
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;

@ShowFirstParty
@SafeParcelable.Class(creator="SubscribeRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public final class zzbi
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbi> CREATOR = new zzbl();
  @SafeParcelable.Field(getter="getCallbackBinder", id=3, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="getSubscription", id=1)
  private Subscription zzss;
  @SafeParcelable.Field(getter="isServerOnly", id=2)
  private final boolean zzst;
  
  zzbi(Subscription paramSubscription, boolean paramBoolean, IBinder paramIBinder)
  {
    zzss = paramSubscription;
    zzst = paramBoolean;
    if (paramIBinder == null) {
      paramSubscription = null;
    } else {
      paramSubscription = zzcm.next(paramIBinder);
    }
    zzql = paramSubscription;
  }
  
  public zzbi(Subscription paramSubscription, boolean paramBoolean, zzcn paramZzcn)
  {
    zzss = paramSubscription;
    zzst = false;
    zzql = paramZzcn;
  }
  
  public final String toString()
  {
    return Objects.toStringHelper(this).name("subscription", zzss).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, zzss, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, zzst);
    Object localObject = zzql;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
