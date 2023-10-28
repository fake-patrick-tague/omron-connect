package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Message;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="SignInRequestCreator")
public final class Entry
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zai> CREATOR = new VerticalProgressBar.SavedState.1();
  @SafeParcelable.Field(getter="getResolveAccountRequest", id=2)
  final Message mData;
  @SafeParcelable.VersionField(id=1)
  final int mXIndex;
  
  Entry(int paramInt, Message paramMessage)
  {
    mXIndex = paramInt;
    mData = paramMessage;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, mXIndex);
    SafeParcelWriter.writeParcelable(paramParcel, 2, mData, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
