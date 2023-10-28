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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator="BeginSignInRequestCreator")
public final class BeginSignInRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest> CREATOR = new SpecialListsListNameProperty.1();
  @SafeParcelable.Field(getter="getGoogleIdTokenRequestOptions", id=2)
  private final GoogleIdTokenRequestOptions destination;
  @SafeParcelable.Field(getter="getPasswordRequestOptions", id=1)
  private final PasswordRequestOptions line;
  @SafeParcelable.Field(getter="isAutoSelectEnabled", id=4)
  private final boolean number;
  @SafeParcelable.Field(getter="getSessionId", id=3)
  private final String source;
  
  BeginSignInRequest(PasswordRequestOptions paramPasswordRequestOptions, GoogleIdTokenRequestOptions paramGoogleIdTokenRequestOptions, String paramString, boolean paramBoolean)
  {
    line = ((PasswordRequestOptions)Preconditions.checkNotNull(paramPasswordRequestOptions));
    destination = ((GoogleIdTokenRequestOptions)Preconditions.checkNotNull(paramGoogleIdTokenRequestOptions));
    source = paramString;
    number = paramBoolean;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder where(BeginSignInRequest paramBeginSignInRequest)
  {
    Preconditions.checkNotNull(paramBeginSignInRequest);
    Builder localBuilder = builder();
    localBuilder.setGoogleIdTokenRequestOptions(paramBeginSignInRequest.getGoogleIdTokenRequestOptions());
    localBuilder.setPasswordRequestOptions(paramBeginSignInRequest.getPasswordRequestOptions());
    localBuilder.setAutoSelectEnabled(number);
    paramBeginSignInRequest = source;
    if (paramBeginSignInRequest != null) {
      localBuilder.put(paramBeginSignInRequest);
    }
    return localBuilder;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BeginSignInRequest)) {
      return false;
    }
    paramObject = (BeginSignInRequest)paramObject;
    return (Objects.equal(line, line)) && (Objects.equal(destination, destination)) && (Objects.equal(source, source)) && (number == number);
  }
  
  public GoogleIdTokenRequestOptions getGoogleIdTokenRequestOptions()
  {
    return destination;
  }
  
  public PasswordRequestOptions getPasswordRequestOptions()
  {
    return line;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { line, destination, source, Boolean.valueOf(number) });
  }
  
  public boolean isAutoSelectEnabled()
  {
    return number;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getPasswordRequestOptions(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getGoogleIdTokenRequestOptions(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, source, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, isAutoSelectEnabled());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final class Builder
  {
    private BeginSignInRequest.GoogleIdTokenRequestOptions baseUrl;
    private boolean dataSource;
    private BeginSignInRequest.PasswordRequestOptions httpMethod;
    private String uri;
    
    public Builder()
    {
      this$1 = BeginSignInRequest.PasswordRequestOptions.builder();
      this$1.setSupported(false);
      httpMethod = this$1.build();
      this$1 = BeginSignInRequest.GoogleIdTokenRequestOptions.builder();
      this$1.setSupported(false);
      baseUrl = this$1.build();
    }
    
    public BeginSignInRequest build()
    {
      return new BeginSignInRequest(httpMethod, baseUrl, uri, dataSource);
    }
    
    public final Builder put(String paramString)
    {
      uri = paramString;
      return this;
    }
    
    public Builder setAutoSelectEnabled(boolean paramBoolean)
    {
      dataSource = paramBoolean;
      return this;
    }
    
    public Builder setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions paramGoogleIdTokenRequestOptions)
    {
      baseUrl = ((BeginSignInRequest.GoogleIdTokenRequestOptions)Preconditions.checkNotNull(paramGoogleIdTokenRequestOptions));
      return this;
    }
    
    public Builder setPasswordRequestOptions(BeginSignInRequest.PasswordRequestOptions paramPasswordRequestOptions)
    {
      httpMethod = ((BeginSignInRequest.PasswordRequestOptions)Preconditions.checkNotNull(paramPasswordRequestOptions));
      return this;
    }
  }
  
  @SafeParcelable.Class(creator="GoogleIdTokenRequestOptionsCreator")
  public final class GoogleIdTokenRequestOptions
    extends AbstractSafeParcelable
  {
    @RecentlyNonNull
    public static final Parcelable.Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions> CREATOR = new PaymentIntent.Output.1();
    @SafeParcelable.Field(getter="getServerClientId", id=2)
    private final String id;
    @SafeParcelable.Field(getter="getNonce", id=3)
    private final String line;
    @SafeParcelable.Field(getter="filterByAuthorizedAccounts", id=4)
    private final boolean lower;
    @SafeParcelable.Field(getter="getIdTokenDepositionScopes", id=6)
    private final List<String> protocols;
    @SafeParcelable.Field(getter="getLinkedServiceId", id=5)
    private final String proxy;
    @SafeParcelable.Field(getter="isSupported", id=1)
    private final boolean type;
    
    GoogleIdTokenRequestOptions(String paramString1, String paramString2, boolean paramBoolean, String paramString3, List paramList)
    {
      type = this$1;
      if (this$1 != 0) {
        Preconditions.checkNotNull(paramString1, "serverClientId must be provided if Google ID tokens are requested");
      }
      id = paramString1;
      line = paramString2;
      lower = paramBoolean;
      paramString1 = BeginSignInRequest.CREATOR;
      paramString2 = null;
      paramString1 = paramString2;
      if (paramList != null) {
        if (paramList.isEmpty())
        {
          paramString1 = paramString2;
        }
        else
        {
          paramString1 = new ArrayList(paramList);
          Collections.sort(paramString1);
        }
      }
      protocols = paramString1;
      proxy = paramString3;
    }
    
    public static Builder builder()
    {
      return new Builder();
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof GoogleIdTokenRequestOptions)) {
        return false;
      }
      paramObject = (GoogleIdTokenRequestOptions)paramObject;
      return (type == type) && (Objects.equal(id, id)) && (Objects.equal(line, line)) && (lower == lower) && (Objects.equal(proxy, proxy)) && (Objects.equal(protocols, protocols));
    }
    
    public boolean filterByAuthorizedAccounts()
    {
      return lower;
    }
    
    public List getIdTokenDepositionScopes()
    {
      return protocols;
    }
    
    public String getLinkedServiceId()
    {
      return proxy;
    }
    
    public String getNonce()
    {
      return line;
    }
    
    public String getServerClientId()
    {
      return id;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { Boolean.valueOf(type), id, line, Boolean.valueOf(lower), proxy, protocols });
    }
    
    public boolean isSupported()
    {
      return type;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeBoolean(paramParcel, 1, isSupported());
      SafeParcelWriter.writeString(paramParcel, 2, getServerClientId(), false);
      SafeParcelWriter.writeString(paramParcel, 3, getNonce(), false);
      SafeParcelWriter.writeBoolean(paramParcel, 4, filterByAuthorizedAccounts());
      SafeParcelWriter.writeString(paramParcel, 5, getLinkedServiceId(), false);
      SafeParcelWriter.writeStringList(paramParcel, 6, getIdTokenDepositionScopes(), false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
    
    public final class Builder
    {
      private boolean baseUrl = false;
      private boolean header = true;
      private List<String> parameters = null;
      private String params = null;
      private String restUrl = null;
      private String type = null;
      
      public Builder() {}
      
      public Builder associateLinkedAccounts(String paramString, List paramList)
      {
        type = ((String)Preconditions.checkNotNull(paramString, "linkedServiceId must be provided if you want to associate linked accounts."));
        parameters = paramList;
        return this;
      }
      
      public BeginSignInRequest.GoogleIdTokenRequestOptions build()
      {
        return new BeginSignInRequest.GoogleIdTokenRequestOptions(baseUrl, restUrl, params, header, type, parameters);
      }
      
      public Builder setFilterByAuthorizedAccounts(boolean paramBoolean)
      {
        header = paramBoolean;
        return this;
      }
      
      public Builder setNonce(String paramString)
      {
        params = paramString;
        return this;
      }
      
      public Builder setServerClientId(String paramString)
      {
        restUrl = Preconditions.checkNotEmpty(paramString);
        return this;
      }
      
      public Builder setSupported(boolean paramBoolean)
      {
        baseUrl = paramBoolean;
        return this;
      }
    }
  }
  
  @SafeParcelable.Class(creator="PasswordRequestOptionsCreator")
  public final class PasswordRequestOptions
    extends AbstractSafeParcelable
  {
    @RecentlyNonNull
    public static final Parcelable.Creator<com.google.android.gms.auth.api.identity.BeginSignInRequest.PasswordRequestOptions> CREATOR = new AccountMirakel.2();
    @SafeParcelable.Field(getter="isSupported", id=1)
    private final boolean mStream;
    
    PasswordRequestOptions()
    {
      mStream = this$1;
    }
    
    public static Builder builder()
    {
      return new Builder();
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof PasswordRequestOptions)) {
        return false;
      }
      paramObject = (PasswordRequestOptions)paramObject;
      return mStream == mStream;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { Boolean.valueOf(mStream) });
    }
    
    public boolean isSupported()
    {
      return mStream;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeBoolean(paramParcel, 1, isSupported());
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
    
    public final class Builder
    {
      private boolean safeMode = false;
      
      public Builder() {}
      
      public BeginSignInRequest.PasswordRequestOptions build()
      {
        return new BeginSignInRequest.PasswordRequestOptions(safeMode);
      }
      
      public Builder setSupported(boolean paramBoolean)
      {
        safeMode = paramBoolean;
        return this;
      }
    }
  }
}
