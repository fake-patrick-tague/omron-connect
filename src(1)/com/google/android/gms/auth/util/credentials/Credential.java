package com.google.android.gms.auth.util.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.credentials.IdToken;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator="CredentialCreator")
@SafeParcelable.Reserved({1000})
public class Credential
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.Credential> CREATOR = new VerticalProgressBar.SavedState.1();
  @RecentlyNonNull
  public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
  @SafeParcelable.Field(getter="getName", id=2)
  private final String c;
  @SafeParcelable.Field(getter="getProfilePictureUri", id=3)
  private final Uri first;
  @SafeParcelable.Field(getter="getId", id=1)
  private final String id;
  @SafeParcelable.Field(getter="getAccountType", id=6)
  private final String name;
  @SafeParcelable.Field(getter="getIdTokens", id=4)
  private final List<IdToken> parameters;
  @SafeParcelable.Field(getter="getGivenName", id=9)
  private final String password;
  @SafeParcelable.Field(getter="getPassword", id=5)
  private final String selected;
  @SafeParcelable.Field(getter="getFamilyName", id=10)
  private final String username;
  
  Credential(String paramString1, String paramString2, Uri paramUri, List paramList, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    String str = ((String)Preconditions.checkNotNull(paramString1, "credential identifier cannot be null")).trim();
    Preconditions.checkNotEmpty(str, "credential identifier cannot be empty");
    if ((paramString3 != null) && (TextUtils.isEmpty(paramString3))) {
      throw new IllegalArgumentException("Password must not be empty if set");
    }
    if (paramString4 != null)
    {
      if (TextUtils.isEmpty(paramString4))
      {
        paramString1 = Boolean.FALSE;
      }
      else
      {
        paramString1 = Uri.parse(paramString4);
        if ((paramString1.isAbsolute()) && (paramString1.isHierarchical()) && (!TextUtils.isEmpty(paramString1.getScheme())) && (!TextUtils.isEmpty(paramString1.getAuthority())))
        {
          boolean bool3 = "http".equalsIgnoreCase(paramString1.getScheme());
          boolean bool2 = true;
          boolean bool1 = bool2;
          if (!bool3) {
            if ("https".equalsIgnoreCase(paramString1.getScheme())) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          paramString1 = Boolean.valueOf(bool1);
        }
        else
        {
          paramString1 = Boolean.FALSE;
        }
      }
      if (!paramString1.booleanValue()) {
        throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
      }
    }
    if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString3))) {
      throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
    }
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2.trim())) {
        paramString1 = null;
      }
    }
    c = paramString1;
    first = paramUri;
    if (paramList == null) {
      paramString1 = Collections.emptyList();
    } else {
      paramString1 = Collections.unmodifiableList(paramList);
    }
    parameters = paramString1;
    id = str;
    selected = paramString3;
    name = paramString4;
    password = paramString5;
    username = paramString6;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Credential)) {
      return false;
    }
    paramObject = (Credential)paramObject;
    return (TextUtils.equals(id, id)) && (TextUtils.equals(c, c)) && (Objects.equal(first, first)) && (TextUtils.equals(selected, selected)) && (TextUtils.equals(name, name));
  }
  
  public String getAccountType()
  {
    return name;
  }
  
  public String getFamilyName()
  {
    return username;
  }
  
  public String getGivenName()
  {
    return password;
  }
  
  public String getId()
  {
    return id;
  }
  
  public List getIdTokens()
  {
    return parameters;
  }
  
  public String getName()
  {
    return c;
  }
  
  public String getPassword()
  {
    return selected;
  }
  
  public Uri getProfilePictureUri()
  {
    return first;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { id, c, first, selected, name });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getName(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getProfilePictureUri(), paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 4, getIdTokens(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getPassword(), false);
    SafeParcelWriter.writeString(paramParcel, 6, getAccountType(), false);
    SafeParcelWriter.writeString(paramParcel, 9, getGivenName(), false);
    SafeParcelWriter.writeString(paramParcel, 10, getFamilyName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public class Builder
  {
    private String mPassword;
    private String mPermissions;
    private String mRemoteId;
    private String mSize;
    private String name;
    private List<IdToken> params;
    private Uri url;
    
    public Builder()
    {
      name = Credential.getName(Credential.this);
      url = Credential.getFirst(Credential.this);
      params = Credential.getParameters(Credential.this);
      mPassword = Credential.access$getSelected(Credential.this);
      mPermissions = Credential.toString(Credential.this);
      mRemoteId = Credential.getPassword(Credential.this);
      mSize = Credential.getUsername(Credential.this);
    }
    
    public Builder() {}
    
    public Credential build()
    {
      return new Credential(Credential.this, name, url, params, mPassword, mPermissions, mRemoteId, mSize);
    }
    
    public Builder setAccountType(String paramString)
    {
      mPermissions = paramString;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      name = paramString;
      return this;
    }
    
    public Builder setPassword(String paramString)
    {
      mPassword = paramString;
      return this;
    }
    
    public Builder setProfilePictureUri(Uri paramUri)
    {
      url = paramUri;
      return this;
    }
  }
}
