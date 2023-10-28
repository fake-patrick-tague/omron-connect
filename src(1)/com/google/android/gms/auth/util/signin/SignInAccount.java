package com.google.android.gms.auth.util.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="SignInAccountCreator")
@SafeParcelable.Reserved({1})
public class SignInAccount
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.SignInAccount> CREATOR = new DiscreteSeekBar.CustomState.1();
  @Deprecated
  @SafeParcelable.Field(defaultValue="", id=4)
  String description;
  @SafeParcelable.Field(getter="getGoogleSignInAccount", id=7)
  private GoogleSignInAccount language;
  @Deprecated
  @SafeParcelable.Field(defaultValue="", id=8)
  String mimeType;
  
  SignInAccount(String paramString1, GoogleSignInAccount paramGoogleSignInAccount, String paramString2)
  {
    language = paramGoogleSignInAccount;
    description = Preconditions.checkNotEmpty(paramString1, "8.3 and 8.4 SDKs require non-null email");
    mimeType = Preconditions.checkNotEmpty(paramString2, "8.3 and 8.4 SDKs require non-null userId");
  }
  
  public final GoogleSignInAccount getLanguage()
  {
    return language;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 4, description, false);
    SafeParcelWriter.writeParcelable(paramParcel, 7, language, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 8, mimeType, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
