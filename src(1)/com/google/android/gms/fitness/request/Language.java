package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzcn;

@ShowFirstParty
@SafeParcelable.Class(creator="DisableFitRequestCreator")
@SafeParcelable.Reserved({2, 1000})
public final class Language
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzz> CREATOR = new zzab();
  @SafeParcelable.Field(getter="getCallbackBinder", id=1, type="android.os.IBinder")
  private final zzcn zzql;
  
  Language(IBinder paramIBinder)
  {
    zzql = zzcm.next(paramIBinder);
  }
  
  public Language(zzcn paramZzcn)
  {
    zzql = paramZzcn;
  }
  
  public final String toString()
  {
    return String.format("DisableFitRequest", new Object[0]);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeIBinder(paramParcel, 1, zzql.asBinder(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
