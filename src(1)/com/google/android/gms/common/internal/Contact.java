package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.package_12.Scope;

@SafeParcelable.Class(creator="SignInButtonConfigCreator")
public final class Contact
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zax> CREATOR = new DownloadProgressInfo.1();
  @SafeParcelable.Field(getter="getButtonSize", id=2)
  private final int mNumber;
  @SafeParcelable.Field(getter="getColorScheme", id=3)
  private final int mNumberType;
  @Deprecated
  @SafeParcelable.Field(getter="getScopes", id=4)
  private final Scope[] mSuperPrimary;
  @SafeParcelable.VersionField(id=1)
  final int value;
  
  Contact(int paramInt1, int paramInt2, int paramInt3, Scope[] paramArrayOfScope)
  {
    value = paramInt1;
    mNumber = paramInt2;
    mNumberType = paramInt3;
    mSuperPrimary = paramArrayOfScope;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, value);
    SafeParcelWriter.writeInt(paramParcel, 2, mNumber);
    SafeParcelWriter.writeInt(paramParcel, 3, mNumberType);
    SafeParcelWriter.writeTypedArray(paramParcel, 4, mSuperPrimary, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
