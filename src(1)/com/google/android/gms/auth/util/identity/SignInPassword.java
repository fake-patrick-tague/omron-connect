package com.google.android.gms.auth.util.identity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="SignInPasswordCreator")
public class SignInPassword
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.identity.SignInPassword> CREATOR = new AddressAndLabel.1();
  @SafeParcelable.Field(getter="getPassword", id=2)
  private final String data;
  @SafeParcelable.Field(getter="getId", id=1)
  private final String id;
  
  public SignInPassword(String paramString1, String paramString2)
  {
    id = Preconditions.checkNotEmpty(((String)Preconditions.checkNotNull(paramString1, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
    data = Preconditions.checkNotEmpty(paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SignInPassword)) {
      return false;
    }
    paramObject = (SignInPassword)paramObject;
    return (Objects.equal(id, id)) && (Objects.equal(data, data));
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getPassword()
  {
    return data;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { id, data });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getPassword(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
