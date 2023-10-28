package com.google.android.gms.internal.auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.util.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="SaveRequestCreator")
@SafeParcelable.Reserved({1000})
public final class Element
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zbu> CREATOR = new Server.1();
  @SafeParcelable.Field(getter="getCredential", id=1)
  private final Credential mHumanReadableName;
  
  public Element(Credential paramCredential)
  {
    mHumanReadableName = paramCredential;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, mHumanReadableName, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
