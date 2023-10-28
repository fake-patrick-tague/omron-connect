package com.google.android.gms.auth.util.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="SignInCredentialCreator")
public final class SignInCredential
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.identity.SignInCredential> CREATOR = new Point.1();
  @SafeParcelable.Field(getter="getPassword", id=6)
  private final String data;
  @SafeParcelable.Field(getter="getGivenName", id=3)
  private final String defaultValue;
  @SafeParcelable.Field(getter="getId", id=1)
  private final String id;
  @SafeParcelable.Field(getter="getFamilyName", id=4)
  private final String key;
  @SafeParcelable.Field(getter="getDisplayName", id=2)
  private final String name;
  @SafeParcelable.Field(getter="getGoogleIdToken", id=7)
  private final String shown;
  @SafeParcelable.Field(getter="getProfilePictureUri", id=5)
  private final Uri source;
  
  public SignInCredential(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, String paramString6)
  {
    id = Preconditions.checkNotEmpty(paramString1);
    name = paramString2;
    defaultValue = paramString3;
    key = paramString4;
    source = paramUri;
    data = paramString5;
    shown = paramString6;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SignInCredential)) {
      return false;
    }
    paramObject = (SignInCredential)paramObject;
    return (Objects.equal(id, id)) && (Objects.equal(name, name)) && (Objects.equal(defaultValue, defaultValue)) && (Objects.equal(key, key)) && (Objects.equal(source, source)) && (Objects.equal(data, data)) && (Objects.equal(shown, shown));
  }
  
  public String getDisplayName()
  {
    return name;
  }
  
  public String getFamilyName()
  {
    return key;
  }
  
  public String getGivenName()
  {
    return defaultValue;
  }
  
  public String getGoogleIdToken()
  {
    return shown;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getPassword()
  {
    return data;
  }
  
  public Uri getProfilePictureUri()
  {
    return source;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { id, name, defaultValue, key, source, data, shown });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getDisplayName(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getGivenName(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getFamilyName(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, getProfilePictureUri(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 6, getPassword(), false);
    SafeParcelWriter.writeString(paramParcel, 7, getGoogleIdToken(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
