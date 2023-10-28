package com.google.android.gms.auth.util.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.util.signin.internal.HashAccumulator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.package_12.Api.ApiOptions.Optional;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator="GoogleSignInOptionsCreator")
public class GoogleSignInOptions
  extends AbstractSafeParcelable
  implements Api.ApiOptions.Optional, ReflectedParcelable
{
  @VisibleForTesting
  public static final com.google.android.gms.common.package_12.Scope Blob;
  public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.GoogleSignInOptions> CREATOR = new DownloadProgressInfo.1();
  public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  @VisibleForTesting
  public static final com.google.android.gms.common.package_12.Scope Int;
  @VisibleForTesting
  public static final com.google.android.gms.common.package_12.Scope NEED_SYNC = new com.google.android.gms.common.package_12.Scope("profile");
  @VisibleForTesting
  public static final com.google.android.gms.common.package_12.Scope Real;
  @VisibleForTesting
  public static final com.google.android.gms.common.package_12.Scope Str = new com.google.android.gms.common.package_12.Scope("email");
  private static Comparator<com.google.android.gms.common.api.Scope> byName = new HeapElement.1();
  @SafeParcelable.Field(getter="getAccount", id=3)
  private Account account;
  private Map<Integer, com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> commandResult;
  @SafeParcelable.Field(getter="isForceCodeForRefreshToken", id=6)
  private final boolean data;
  @SafeParcelable.Field(getter="isIdTokenRequested", id=4)
  private boolean id;
  @SafeParcelable.Field(getter="getLogSessionId", id=10)
  private String mArtistName;
  @SafeParcelable.Field(getter="getServerClientId", id=7)
  private String name;
  @SafeParcelable.Field(getter="getExtensions", id=9)
  private ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> result;
  @SafeParcelable.VersionField(id=1)
  final int sequence;
  @SafeParcelable.Field(getter="getHostedDomain", id=8)
  private String state;
  @SafeParcelable.Field(getter="isServerAuthCodeRequested", id=5)
  private final boolean status;
  @SafeParcelable.Field(getter="getScopes", id=2)
  private final ArrayList<com.google.android.gms.common.api.Scope> this$0;
  
  static
  {
    Int = new com.google.android.gms.common.package_12.Scope("openid");
    com.google.android.gms.common.package_12.Scope localScope = new com.google.android.gms.common.package_12.Scope("https://www.googleapis.com/auth/games_lite");
    Real = localScope;
    Blob = new com.google.android.gms.common.package_12.Scope("https://www.googleapis.com/auth/games");
    Builder localBuilder = new Builder();
    localBuilder.requestId();
    localBuilder.requestProfile();
    DEFAULT_SIGN_IN = localBuilder.build();
    localBuilder = new Builder();
    localBuilder.requestScopes(localScope, new com.google.android.gms.common.package_12.Scope[0]);
    DEFAULT_GAMES_SIGN_IN = localBuilder.build();
  }
  
  GoogleSignInOptions(int paramInt, ArrayList paramArrayList1, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, ArrayList paramArrayList2, String paramString3)
  {
    this(paramInt, paramArrayList1, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2, apply(paramArrayList2), paramString3);
  }
  
  private GoogleSignInOptions(int paramInt, ArrayList paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, Map paramMap, String paramString3)
  {
    sequence = paramInt;
    this$0 = paramArrayList;
    account = paramAccount;
    id = paramBoolean1;
    status = paramBoolean2;
    data = paramBoolean3;
    name = paramString1;
    state = paramString2;
    result = new ArrayList(paramMap.values());
    commandResult = paramMap;
    mArtistName = paramString3;
  }
  
  private static Map apply(List paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.google.android.gms.auth.util.signin.internal.GoogleSignInOptionsExtensionParcelable localGoogleSignInOptionsExtensionParcelable = (com.google.android.gms.auth.util.signin.internal.GoogleSignInOptionsExtensionParcelable)paramList.next();
      localHashMap.put(Integer.valueOf(localGoogleSignInOptionsExtensionParcelable.getType()), localGoogleSignInOptionsExtensionParcelable);
    }
    return localHashMap;
  }
  
  public static GoogleSignInOptions doInBackground(String paramString)
    throws JSONException
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    String str = null;
    if (bool1) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    Object localObject = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      ((Set)localObject).add(new com.google.android.gms.common.package_12.Scope(paramString.getString(i)));
      i += 1;
    }
    if (localJSONObject.has("accountName")) {
      paramString = localJSONObject.optString("accountName");
    } else {
      paramString = null;
    }
    if (!TextUtils.isEmpty(paramString)) {
      paramString = new Account(paramString, "com.google");
    } else {
      paramString = null;
    }
    ArrayList localArrayList = new ArrayList((Collection)localObject);
    bool1 = localJSONObject.getBoolean("idTokenRequested");
    boolean bool2 = localJSONObject.getBoolean("serverAuthRequested");
    boolean bool3 = localJSONObject.getBoolean("forceCodeForRefreshToken");
    if (localJSONObject.has("serverClientId")) {
      localObject = localJSONObject.optString("serverClientId");
    } else {
      localObject = null;
    }
    if (localJSONObject.has("hostedDomain")) {
      str = localJSONObject.optString("hostedDomain");
    }
    return new GoogleSignInOptions(3, localArrayList, paramString, bool1, bool2, bool3, (String)localObject, str, new HashMap(), null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      paramObject = (GoogleSignInOptions)paramObject;
      Object localObject = result;
      int i = ((ArrayList)localObject).size();
      if (i <= 0)
      {
        localObject = result;
        i = ((ArrayList)localObject).size();
        if (i > 0) {
          return false;
        }
        localObject = this$0;
        i = ((ArrayList)localObject).size();
        int j = paramObject.getScopes().size();
        if (i == j)
        {
          localObject = this$0;
          boolean bool1 = ((ArrayList)localObject).containsAll(paramObject.getScopes());
          if (!bool1) {
            return false;
          }
          localObject = account;
          if (localObject == null)
          {
            localObject = paramObject.getAccount();
            if (localObject != null) {
              break label278;
            }
          }
          else
          {
            bool1 = ((Account)localObject).equals(paramObject.getAccount());
            if (!bool1) {
              break label278;
            }
          }
          localObject = name;
          bool1 = TextUtils.isEmpty((CharSequence)localObject);
          if (bool1)
          {
            bool1 = TextUtils.isEmpty(paramObject.getServerClientId());
            if (!bool1) {
              break label278;
            }
          }
          else
          {
            localObject = name;
            bool1 = ((String)localObject).equals(paramObject.getServerClientId());
            if (!bool1) {
              return false;
            }
          }
          bool1 = data;
          boolean bool2 = paramObject.isForceCodeForRefreshToken();
          if (bool1 == bool2)
          {
            bool1 = id;
            bool2 = paramObject.isIdTokenRequested();
            if (bool1 == bool2)
            {
              bool1 = status;
              bool2 = paramObject.isServerAuthCodeRequested();
              if (bool1 == bool2)
              {
                localObject = mArtistName;
                bool1 = TextUtils.equals((CharSequence)localObject, paramObject.getLogSessionId());
                if (bool1) {
                  return true;
                }
              }
            }
          }
        }
      }
      else
      {
        return false;
      }
    }
    catch (ClassCastException paramObject) {}
    label278:
    return false;
  }
  
  public Account getAccount()
  {
    return account;
  }
  
  public ArrayList getExtensions()
  {
    return result;
  }
  
  public String getLogSessionId()
  {
    return mArtistName;
  }
  
  public com.google.android.gms.common.package_12.Scope[] getScopeArray()
  {
    ArrayList localArrayList = this$0;
    return (com.google.android.gms.common.package_12.Scope[])localArrayList.toArray(new com.google.android.gms.common.package_12.Scope[localArrayList.size()]);
  }
  
  public ArrayList getScopes()
  {
    return new ArrayList(this$0);
  }
  
  public String getServerClientId()
  {
    return name;
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this$0;
    int j = ((List)localObject).size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(((com.google.android.gms.common.package_12.Scope)((List)localObject).get(i)).getScopeUri());
      i += 1;
    }
    Collections.sort(localArrayList);
    localObject = new HashAccumulator();
    ((HashAccumulator)localObject).addObject(localArrayList);
    ((HashAccumulator)localObject).addObject(account);
    ((HashAccumulator)localObject).addObject(name);
    ((HashAccumulator)localObject).append(data);
    ((HashAccumulator)localObject).append(id);
    ((HashAccumulator)localObject).append(status);
    ((HashAccumulator)localObject).addObject(mArtistName);
    return ((HashAccumulator)localObject).hash();
  }
  
  public boolean isForceCodeForRefreshToken()
  {
    return data;
  }
  
  public boolean isIdTokenRequested()
  {
    return id;
  }
  
  public boolean isServerAuthCodeRequested()
  {
    return status;
  }
  
  public final String save()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject1 = new JSONArray();
      Object localObject2 = this$0;
      Object localObject3 = byName;
      Collections.sort((List)localObject2, (Comparator)localObject3);
      localObject2 = this$0;
      localObject2 = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        bool = ((Iterator)localObject2).hasNext();
        if (!bool) {
          break;
        }
        localObject3 = ((Iterator)localObject2).next();
        localObject3 = (com.google.android.gms.common.package_12.Scope)localObject3;
        ((JSONArray)localObject1).put(((com.google.android.gms.common.package_12.Scope)localObject3).getScopeUri());
      }
      localJSONObject.put("scopes", localObject1);
      localObject1 = account;
      if (localObject1 != null)
      {
        localObject1 = name;
        localJSONObject.put("accountName", localObject1);
      }
      boolean bool = id;
      localJSONObject.put("idTokenRequested", bool);
      bool = data;
      localJSONObject.put("forceCodeForRefreshToken", bool);
      bool = status;
      localJSONObject.put("serverAuthRequested", bool);
      localObject1 = name;
      bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool)
      {
        localObject1 = name;
        localJSONObject.put("serverClientId", localObject1);
      }
      localObject1 = state;
      bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool)
      {
        localObject1 = state;
        localJSONObject.put("hostedDomain", localObject1);
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, sequence);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getScopes(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getAccount(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, isIdTokenRequested());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isServerAuthCodeRequested());
    SafeParcelWriter.writeBoolean(paramParcel, 6, isForceCodeForRefreshToken());
    SafeParcelWriter.writeString(paramParcel, 7, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 8, state, false);
    SafeParcelWriter.writeTypedList(paramParcel, 9, getExtensions(), false);
    SafeParcelWriter.writeString(paramParcel, 10, getLogSessionId(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final class Builder
  {
    private boolean caption;
    private Map<Integer, com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> context = new HashMap();
    private String date;
    private Set<com.google.android.gms.common.api.Scope> flags = new HashSet();
    private boolean id;
    private boolean message;
    private String source;
    private Account type;
    private String uri;
    
    public Builder() {}
    
    public Builder()
    {
      Preconditions.checkNotNull(this$1);
      flags = new HashSet(GoogleSignInOptions.access$getThis$0(this$1));
      caption = GoogleSignInOptions.join(this$1);
      id = GoogleSignInOptions.readByte(this$1);
      message = GoogleSignInOptions.id(this$1);
      date = GoogleSignInOptions.getAttributeName(this$1);
      type = GoogleSignInOptions.getAccount(this$1);
      source = GoogleSignInOptions.getCurrentState(this$1);
      context = GoogleSignInOptions.get(GoogleSignInOptions.access$getResult(this$1));
      uri = GoogleSignInOptions.getString(this$1);
    }
    
    private final String validate(String paramString)
    {
      Preconditions.checkNotEmpty(paramString);
      String str = date;
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (str != null) {
        if (str.equals(paramString)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      Preconditions.checkArgument(bool1, "two different server client ids provided");
      return paramString;
    }
    
    public Builder addExtension(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
    {
      if (!context.containsKey(Integer.valueOf(paramGoogleSignInOptionsExtension.getExtensionType())))
      {
        List localList = paramGoogleSignInOptionsExtension.getImpliedScopes();
        if (localList != null) {
          flags.addAll(localList);
        }
        context.put(Integer.valueOf(paramGoogleSignInOptionsExtension.getExtensionType()), new com.google.android.gms.auth.util.signin.internal.GoogleSignInOptionsExtensionParcelable(paramGoogleSignInOptionsExtension));
        return this;
      }
      throw new IllegalStateException("Only one extension per type may be added");
    }
    
    public GoogleSignInOptions build()
    {
      if (flags.contains(GoogleSignInOptions.Blob))
      {
        Set localSet = flags;
        com.google.android.gms.common.package_12.Scope localScope = GoogleSignInOptions.Real;
        if (localSet.contains(localScope)) {
          flags.remove(localScope);
        }
      }
      if ((message) && ((type == null) || (!flags.isEmpty()))) {
        requestId();
      }
      return new GoogleSignInOptions(3, new ArrayList(flags), type, message, caption, id, date, source, context, uri, null);
    }
    
    public Builder requestEmail()
    {
      flags.add(GoogleSignInOptions.Str);
      return this;
    }
    
    public Builder requestId()
    {
      flags.add(GoogleSignInOptions.Int);
      return this;
    }
    
    public Builder requestIdToken(String paramString)
    {
      message = true;
      validate(paramString);
      date = paramString;
      return this;
    }
    
    public Builder requestProfile()
    {
      flags.add(GoogleSignInOptions.NEED_SYNC);
      return this;
    }
    
    public Builder requestScopes(com.google.android.gms.common.package_12.Scope paramScope, com.google.android.gms.common.package_12.Scope... paramVarArgs)
    {
      flags.add(paramScope);
      flags.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public Builder requestServerAuthCode(String paramString)
    {
      requestServerAuthCode(paramString, false);
      return this;
    }
    
    public Builder requestServerAuthCode(String paramString, boolean paramBoolean)
    {
      caption = true;
      validate(paramString);
      date = paramString;
      id = paramBoolean;
      return this;
    }
    
    public Builder setAccountName(String paramString)
    {
      type = new Account(Preconditions.checkNotEmpty(paramString), "com.google");
      return this;
    }
    
    public Builder setHostedDomain(String paramString)
    {
      source = Preconditions.checkNotEmpty(paramString);
      return this;
    }
    
    public Builder setLogSessionId(String paramString)
    {
      uri = paramString;
      return this;
    }
  }
}
