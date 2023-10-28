package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.util.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="ResolveAccountRequestCreator")
public final class Message
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zat> CREATOR = new VerticalProgressBar.SavedState.1();
  @SafeParcelable.Field(getter="getSignInAccountHint", id=4)
  private final GoogleSignInAccount mData;
  @SafeParcelable.Field(getter="getSessionId", id=3)
  private final int mFlags;
  @SafeParcelable.VersionField(id=1)
  final int mId;
  @SafeParcelable.Field(getter="getAccount", id=2)
  private final Account mType;
  
  Message(int paramInt1, Account paramAccount, int paramInt2, GoogleSignInAccount paramGoogleSignInAccount)
  {
    mId = paramInt1;
    mType = paramAccount;
    mFlags = paramInt2;
    mData = paramGoogleSignInAccount;
  }
  
  public Message(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, mId);
    SafeParcelWriter.writeParcelable(paramParcel, 2, mType, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, mFlags);
    SafeParcelWriter.writeParcelable(paramParcel, 4, mData, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
