package com.google.android.gms.auth.util;

import android.os.BaseBundle;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.AuthProxyOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zbe;
import com.google.android.gms.auth.util.credentials.CredentialsApi;
import com.google.android.gms.auth.util.proxy.ProxyApi;
import com.google.android.gms.auth.util.signin.GoogleSignInApi;
import com.google.android.gms.auth.util.signin.internal.Function;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.package_12.Api.ApiOptions.Optional;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.internal.auth-api.HttpConnection;
import com.google.android.gms.internal.auth-api.zbo;

public final class Auth
{
  @RecentlyNonNull
  public static final Api<com.google.android.gms.auth.api.Auth.AuthCredentialsOptions> CREDENTIALS_API;
  @RecentlyNonNull
  public static final CredentialsApi CredentialsApi = new HttpConnection();
  private static final Api.AbstractClientBuilder<zbo, com.google.android.gms.auth.api.Auth.AuthCredentialsOptions> DIVIDE;
  @RecentlyNonNull
  public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API;
  @RecentlyNonNull
  public static final GoogleSignInApi GoogleSignInApi = new Function();
  @RecentlyNonNull
  public static final com.google.android.gms.common.api.Api.ClientKey<zbo> MINUS;
  private static final Api.AbstractClientBuilder<zbe, GoogleSignInOptions> MODULO;
  @RecentlyNonNull
  public static final com.google.android.gms.common.api.Api.ClientKey<zbe> MULT;
  @Deprecated
  @RecentlyNonNull
  @KeepForSdk
  @ShowFirstParty
  public static final Api<AuthProxyOptions> PROXY_API;
  @Deprecated
  @RecentlyNonNull
  @KeepForSdk
  @ShowFirstParty
  public static final ProxyApi ProxyApi;
  
  static
  {
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey1 = new com.google.android.gms.common.package_12.Api.ClientKey();
    MINUS = localClientKey1;
    com.google.android.gms.common.package_12.Api.ClientKey localClientKey2 = new com.google.android.gms.common.package_12.Api.ClientKey();
    MULT = localClientKey2;
    ASN1OctetString localASN1OctetString = new ASN1OctetString();
    DIVIDE = localASN1OctetString;
    ASN1Null localASN1Null = new ASN1Null();
    MODULO = localASN1Null;
    PROXY_API = AuthProxy.FIXED;
    CREDENTIALS_API = new Attribute("Auth.CREDENTIALS_API", localASN1OctetString, localClientKey1);
    GOOGLE_SIGN_IN_API = new Attribute("Auth.GOOGLE_SIGN_IN_API", localASN1Null, localClientKey2);
    ProxyApi = AuthProxy.ProxyApi;
  }
  
  private Auth() {}
  
  @Deprecated
  public class AuthCredentialsOptions
    implements Api.ApiOptions.Optional
  {
    @RecentlyNonNull
    public static final AuthCredentialsOptions PARAM_ERROR = new AuthCredentialsOptions(new Builder());
    private final String iv = null;
    private final boolean key;
    private final String source;
    
    public AuthCredentialsOptions()
    {
      key = value.booleanValue();
      source = status;
    }
    
    public final Bundle doInBackground()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("consumer_package", null);
      localBundle.putBoolean("force_save_dialog", key);
      localBundle.putString("log_session_id", source);
      return localBundle;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof AuthCredentialsOptions)) {
        return false;
      }
      paramObject = (AuthCredentialsOptions)paramObject;
      String str = iv;
      return (Objects.equal(null, null)) && (key == key) && (Objects.equal(source, source));
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { null, Boolean.valueOf(key), source });
    }
    
    public final String json()
    {
      return source;
    }
    
    @Deprecated
    public class Builder
    {
      @RecentlyNullable
      protected String status;
      @RecentlyNonNull
      protected Boolean value = Boolean.FALSE;
      
      public Builder() {}
      
      public Builder()
      {
        Auth.AuthCredentialsOptions.decrypt(this$1);
        value = Boolean.valueOf(Auth.AuthCredentialsOptions.key(this$1));
        status = Auth.AuthCredentialsOptions.access$getSource(this$1);
      }
      
      public final Builder encrypt(String paramString)
      {
        status = paramString;
        return this;
      }
      
      public Builder forceEnableSaveDialog()
      {
        value = Boolean.TRUE;
        return this;
      }
    }
  }
}
