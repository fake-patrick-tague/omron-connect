package com.google.android.gms.auth.util.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v7.util.TLongArrayList;

@SafeParcelable.Class(creator="GoogleSignInAccountCreator")
public class GoogleSignInAccount
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.GoogleSignInAccount> CREATOR = new VerticalProgressBar.SavedState.1();
  @VisibleForTesting
  public static Clock log = DefaultClock.getInstance();
  @SafeParcelable.Field(id=10)
  List<com.google.android.gms.common.api.Scope> categories;
  @SafeParcelable.Field(getter="getGivenName", id=11)
  private String givenName;
  @SafeParcelable.Field(getter="getObfuscatedIdentifier", id=9)
  private String id;
  @SafeParcelable.Field(getter="getId", id=2)
  private String identifier;
  private Set<com.google.android.gms.common.api.Scope> keys = new HashSet();
  @SafeParcelable.Field(getter="getDisplayName", id=5)
  private String mDisplayName;
  @SafeParcelable.Field(getter="getEmail", id=4)
  private String mEmail;
  @SafeParcelable.Field(getter="getIdToken", id=3)
  private String mFullName;
  @SafeParcelable.Field(getter="getFamilyName", id=12)
  private String middleName;
  @SafeParcelable.Field(getter="getServerAuthCode", id=7)
  private String path;
  @SafeParcelable.Field(getter="getPhotoUrl", id=6)
  private Uri rootMode;
  @SafeParcelable.VersionField(id=1)
  final int size;
  @SafeParcelable.Field(getter="getExpirationTimeSecs", id=8)
  private long version;
  
  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List paramList, String paramString7, String paramString8)
  {
    size = paramInt;
    identifier = paramString1;
    mFullName = paramString2;
    mEmail = paramString3;
    mDisplayName = paramString4;
    rootMode = paramUri;
    path = paramString5;
    version = paramLong;
    id = paramString6;
    categories = paramList;
    givenName = paramString7;
    middleName = paramString8;
  }
  
  private static GoogleSignInAccount create(Account paramAccount, Set paramSet)
  {
    return get(null, null, name, null, null, null, null, Long.valueOf(0L), name, paramSet);
  }
  
  public static GoogleSignInAccount createDefault()
  {
    return create(new Account("<<default account>>", "com.google"), new HashSet());
  }
  
  public static GoogleSignInAccount doInBackground(String paramString)
    throws JSONException
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = localJSONObject.optString("photoUrl");
    if (!TextUtils.isEmpty(paramString)) {
      paramString = Uri.parse(paramString);
    } else {
      paramString = null;
    }
    long l = Long.parseLong(localJSONObject.getString("expirationTime"));
    HashSet localHashSet = new HashSet();
    Object localObject1 = localJSONObject.getJSONArray("grantedScopes");
    int j = ((JSONArray)localObject1).length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new com.google.android.gms.common.package_12.Scope(((JSONArray)localObject1).getString(i)));
      i += 1;
    }
    String str5 = localJSONObject.optString("id");
    if (localJSONObject.has("tokenId")) {
      localObject1 = localJSONObject.optString("tokenId");
    } else {
      localObject1 = null;
    }
    String str1;
    if (localJSONObject.has("email")) {
      str1 = localJSONObject.optString("email");
    } else {
      str1 = null;
    }
    String str2;
    if (localJSONObject.has("displayName")) {
      str2 = localJSONObject.optString("displayName");
    } else {
      str2 = null;
    }
    String str3;
    if (localJSONObject.has("givenName")) {
      str3 = localJSONObject.optString("givenName");
    } else {
      str3 = null;
    }
    String str4;
    if (localJSONObject.has("familyName")) {
      str4 = localJSONObject.optString("familyName");
    } else {
      str4 = null;
    }
    localObject1 = get(str5, (String)localObject1, str1, str2, str3, str4, paramString, Long.valueOf(l), localJSONObject.getString("obfuscatedIdentifier"), localHashSet);
    paramString = localObject2;
    if (localJSONObject.has("serverAuthCode")) {
      paramString = localJSONObject.optString("serverAuthCode");
    }
    path = paramString;
    return localObject1;
  }
  
  public static GoogleSignInAccount fromAccount(Account paramAccount)
  {
    return create(paramAccount, new TLongArrayList());
  }
  
  public static GoogleSignInAccount get(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri, Long paramLong, String paramString7, Set paramSet)
  {
    return new GoogleSignInAccount(3, paramString1, paramString2, paramString3, paramString4, paramUri, null, paramLong.longValue(), Preconditions.checkNotEmpty(paramString7), new ArrayList((Collection)Preconditions.checkNotNull(paramSet)), paramString5, paramString6);
  }
  
  public final String doInBackground()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject1 = getId();
      if (localObject1 != null) {
        localJSONObject.put("id", getId());
      }
      localObject1 = getIdToken();
      if (localObject1 != null) {
        localJSONObject.put("tokenId", getIdToken());
      }
      localObject1 = getEmail();
      if (localObject1 != null) {
        localJSONObject.put("email", getEmail());
      }
      localObject1 = getDisplayName();
      if (localObject1 != null) {
        localJSONObject.put("displayName", getDisplayName());
      }
      localObject1 = getGivenName();
      if (localObject1 != null) {
        localJSONObject.put("givenName", getGivenName());
      }
      localObject1 = getFamilyName();
      if (localObject1 != null) {
        localJSONObject.put("familyName", getFamilyName());
      }
      localObject1 = getPhotoUrl();
      if (localObject1 != null) {
        localJSONObject.put("photoUrl", ((Uri)localObject1).toString());
      }
      localObject1 = getServerAuthCode();
      if (localObject1 != null) {
        localJSONObject.put("serverAuthCode", getServerAuthCode());
      }
      long l = version;
      localJSONObject.put("expirationTime", l);
      localObject1 = id;
      localJSONObject.put("obfuscatedIdentifier", localObject1);
      localObject1 = new JSONArray();
      Object localObject2 = categories;
      int i = ((List)localObject2).size();
      Object localObject3 = new com.google.android.gms.common.package_12.Scope[i];
      localObject2 = ((List)localObject2).toArray((Object[])localObject3);
      localObject2 = (com.google.android.gms.common.package_12.Scope[])localObject2;
      localObject3 = Settings.context;
      Arrays.sort((Object[])localObject2, (Comparator)localObject3);
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        ((JSONArray)localObject1).put(((com.google.android.gms.common.package_12.Scope)localObject3).getScopeUri());
        i += 1;
      }
      localJSONObject.put("grantedScopes", localObject1);
      localJSONObject.remove("serverAuthCode");
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof GoogleSignInAccount)) {
      return false;
    }
    paramObject = (GoogleSignInAccount)paramObject;
    return (id.equals(id)) && (paramObject.getRequestedScopes().equals(getRequestedScopes()));
  }
  
  public Account getAccount()
  {
    String str = mEmail;
    if (str == null) {
      return null;
    }
    return new Account(str, "com.google");
  }
  
  public final String getArtistName()
  {
    return id;
  }
  
  public String getDisplayName()
  {
    return mDisplayName;
  }
  
  public String getEmail()
  {
    return mEmail;
  }
  
  public String getFamilyName()
  {
    return middleName;
  }
  
  public String getGivenName()
  {
    return givenName;
  }
  
  public Set getGrantedScopes()
  {
    return new HashSet(categories);
  }
  
  public String getId()
  {
    return identifier;
  }
  
  public String getIdToken()
  {
    return mFullName;
  }
  
  public Uri getPhotoUrl()
  {
    return rootMode;
  }
  
  public Set getRequestedScopes()
  {
    HashSet localHashSet = new HashSet(categories);
    localHashSet.addAll(keys);
    return localHashSet;
  }
  
  public String getServerAuthCode()
  {
    return path;
  }
  
  public int hashCode()
  {
    return (id.hashCode() + 527) * 31 + getRequestedScopes().hashCode();
  }
  
  public boolean isExpired()
  {
    return log.currentTimeMillis() / 1000L >= version - 300L;
  }
  
  public GoogleSignInAccount requestExtraScopes(com.google.android.gms.common.package_12.Scope... paramVarArgs)
  {
    if (paramVarArgs != null) {
      Collections.addAll(keys, paramVarArgs);
    }
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, size);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getIdToken(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getEmail(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getDisplayName(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, getPhotoUrl(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 7, getServerAuthCode(), false);
    SafeParcelWriter.writeLong(paramParcel, 8, version);
    SafeParcelWriter.writeString(paramParcel, 9, id, false);
    SafeParcelWriter.writeTypedList(paramParcel, 10, categories, false);
    SafeParcelWriter.writeString(paramParcel, 11, getGivenName(), false);
    SafeParcelWriter.writeString(paramParcel, 12, getFamilyName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
