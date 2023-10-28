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

@SafeParcelable.Class(creator="GetSignInIntentRequestCreator")
public class GetSignInIntentRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.identity.GetSignInIntentRequest> CREATOR = new SpecialListsProgressProperty.1();
  @SafeParcelable.Field(getter="getSessionId", id=3)
  private String key;
  @SafeParcelable.Field(getter="getHostedDomainFilter", id=2)
  private final String scope;
  @SafeParcelable.Field(getter="getServerClientId", id=1)
  private final String type;
  @SafeParcelable.Field(getter="getNonce", id=4)
  private final String value;
  
  GetSignInIntentRequest(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Preconditions.checkNotNull(paramString1);
    type = paramString1;
    scope = paramString2;
    key = paramString3;
    value = paramString4;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder where(GetSignInIntentRequest paramGetSignInIntentRequest)
  {
    Preconditions.checkNotNull(paramGetSignInIntentRequest);
    Builder localBuilder = builder();
    localBuilder.setServerClientId(paramGetSignInIntentRequest.getServerClientId());
    localBuilder.setNonce(paramGetSignInIntentRequest.getNonce());
    localBuilder.filterByHostedDomain(paramGetSignInIntentRequest.getHostedDomainFilter());
    paramGetSignInIntentRequest = key;
    if (paramGetSignInIntentRequest != null) {
      localBuilder.put(paramGetSignInIntentRequest);
    }
    return localBuilder;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GetSignInIntentRequest)) {
      return false;
    }
    paramObject = (GetSignInIntentRequest)paramObject;
    return (Objects.equal(type, type)) && (Objects.equal(value, value)) && (Objects.equal(scope, scope));
  }
  
  public String getHostedDomainFilter()
  {
    return scope;
  }
  
  public String getNonce()
  {
    return value;
  }
  
  public String getServerClientId()
  {
    return type;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { type, scope });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getHostedDomainFilter(), false);
    SafeParcelWriter.writeString(paramParcel, 3, key, false);
    SafeParcelWriter.writeString(paramParcel, 4, getNonce(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private String band;
    private String extensions;
    private String nonce;
    private String ordering;
    
    public Builder() {}
    
    public GetSignInIntentRequest build()
    {
      return new GetSignInIntentRequest(band, extensions, ordering, nonce);
    }
    
    public Builder filterByHostedDomain(String paramString)
    {
      extensions = paramString;
      return this;
    }
    
    public final Builder put(String paramString)
    {
      ordering = paramString;
      return this;
    }
    
    public Builder setNonce(String paramString)
    {
      nonce = paramString;
      return this;
    }
    
    public Builder setServerClientId(String paramString)
    {
      Preconditions.checkNotNull(paramString);
      band = paramString;
      return this;
    }
  }
}
