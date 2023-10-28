package com.google.android.gms.auth.util.identity;

import android.app.PendingIntent;
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
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator="SaveAccountLinkingTokenRequestCreator")
public class SaveAccountLinkingTokenRequest
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest> CREATOR = new VerticalProgressBar.SavedState.1();
  @RecentlyNonNull
  public static final String EXTRA_TOKEN = "extra_token";
  @RecentlyNonNull
  public static final String TOKEN_TYPE_AUTH_CODE = "auth_code";
  @SafeParcelable.Field(getter="getScopes", id=4)
  private final List<String> delegate;
  @SafeParcelable.Field(getter="getServiceId", id=3)
  private final String id;
  @SafeParcelable.Field(getter="getSessionId", id=5)
  private final String key;
  @SafeParcelable.Field(getter="getConsentPendingIntent", id=1)
  private final PendingIntent scope;
  @SafeParcelable.Field(getter="getTokenType", id=2)
  private final String type;
  
  SaveAccountLinkingTokenRequest(PendingIntent paramPendingIntent, String paramString1, String paramString2, List paramList, String paramString3)
  {
    scope = paramPendingIntent;
    type = paramString1;
    id = paramString2;
    delegate = paramList;
    key = paramString3;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder where(SaveAccountLinkingTokenRequest paramSaveAccountLinkingTokenRequest)
  {
    Preconditions.checkNotNull(paramSaveAccountLinkingTokenRequest);
    Builder localBuilder = builder();
    localBuilder.setScopes(paramSaveAccountLinkingTokenRequest.getScopes());
    localBuilder.setServiceId(paramSaveAccountLinkingTokenRequest.getServiceId());
    localBuilder.setConsentPendingIntent(paramSaveAccountLinkingTokenRequest.getConsentPendingIntent());
    localBuilder.setTokenType(paramSaveAccountLinkingTokenRequest.getTokenType());
    paramSaveAccountLinkingTokenRequest = key;
    if (!TextUtils.isEmpty(paramSaveAccountLinkingTokenRequest)) {
      localBuilder.add(paramSaveAccountLinkingTokenRequest);
    }
    return localBuilder;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SaveAccountLinkingTokenRequest)) {
      return false;
    }
    paramObject = (SaveAccountLinkingTokenRequest)paramObject;
    if (delegate.size() == delegate.size())
    {
      if (!delegate.containsAll(delegate)) {
        return false;
      }
      if ((Objects.equal(scope, scope)) && (Objects.equal(type, type)) && (Objects.equal(id, id)) && (Objects.equal(key, key))) {
        return true;
      }
    }
    return false;
  }
  
  public PendingIntent getConsentPendingIntent()
  {
    return scope;
  }
  
  public List getScopes()
  {
    return delegate;
  }
  
  public String getServiceId()
  {
    return id;
  }
  
  public String getTokenType()
  {
    return type;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { scope, type, id, delegate, key });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getConsentPendingIntent(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 2, getTokenType(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getServiceId(), false);
    SafeParcelWriter.writeStringList(paramParcel, 4, getScopes(), false);
    SafeParcelWriter.writeString(paramParcel, 5, key, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final class Builder
  {
    private String parent;
    private PendingIntent result;
    private List<String> source = new ArrayList();
    private String title;
    private String userName;
    
    public Builder() {}
    
    public final Builder add(String paramString)
    {
      parent = paramString;
      return this;
    }
    
    public SaveAccountLinkingTokenRequest build()
    {
      PendingIntent localPendingIntent = result;
      boolean bool2 = false;
      if (localPendingIntent != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Consent PendingIntent cannot be null");
      Preconditions.checkArgument("auth_code".equals(title), "Invalid tokenType");
      Preconditions.checkArgument(TextUtils.isEmpty(userName) ^ true, "serviceId cannot be null or empty");
      boolean bool1 = bool2;
      if (source != null) {
        bool1 = true;
      }
      Preconditions.checkArgument(bool1, "scopes cannot be null");
      return new SaveAccountLinkingTokenRequest(result, title, userName, source, parent);
    }
    
    public Builder setConsentPendingIntent(PendingIntent paramPendingIntent)
    {
      result = paramPendingIntent;
      return this;
    }
    
    public Builder setScopes(List paramList)
    {
      source = paramList;
      return this;
    }
    
    public Builder setServiceId(String paramString)
    {
      userName = paramString;
      return this;
    }
    
    public Builder setTokenType(String paramString)
    {
      title = paramString;
      return this;
    }
  }
}
