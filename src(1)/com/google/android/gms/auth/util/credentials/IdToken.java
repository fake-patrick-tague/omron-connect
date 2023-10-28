package com.google.android.gms.auth.util.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="IdTokenCreator")
@SafeParcelable.Reserved({1000})
public final class IdToken
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.IdToken> CREATOR = new PaymentIntent.Output.1();
  @SafeParcelable.Field(getter="getAccountType", id=1)
  private final String plot;
  @SafeParcelable.Field(getter="getIdToken", id=2)
  private final String units;
  
  public IdToken(String paramString1, String paramString2)
  {
    Preconditions.checkArgument(TextUtils.isEmpty(paramString1) ^ true, "account type string cannot be null or empty");
    Preconditions.checkArgument(TextUtils.isEmpty(paramString2) ^ true, "id token string cannot be null or empty");
    plot = paramString1;
    units = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof IdToken)) {
      return false;
    }
    paramObject = (IdToken)paramObject;
    return (Objects.equal(plot, plot)) && (Objects.equal(units, units));
  }
  
  public String getAccountType()
  {
    return plot;
  }
  
  public String getIdToken()
  {
    return units;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getAccountType(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getIdToken(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
