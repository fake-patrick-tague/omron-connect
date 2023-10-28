package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Task;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="SignInResponseCreator")
public final class TransportInformation
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zak> CREATOR = new Point.1();
  @SafeParcelable.Field(getter="getResolveAccountResponse", id=3)
  private final Task mSupportsStatus;
  @SafeParcelable.Field(getter="getConnectionResult", id=2)
  private final ConnectionResult mTransportName;
  @SafeParcelable.VersionField(id=1)
  final int mTransportPackage;
  
  TransportInformation(int paramInt, ConnectionResult paramConnectionResult, Task paramTask)
  {
    mTransportPackage = paramInt;
    mTransportName = paramConnectionResult;
    mSupportsStatus = paramTask;
  }
  
  public final Task create()
  {
    return mSupportsStatus;
  }
  
  public final ConnectionResult getTransportPackage()
  {
    return mTransportName;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, mTransportPackage);
    SafeParcelWriter.writeParcelable(paramParcel, 2, mTransportName, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, mSupportsStatus, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
