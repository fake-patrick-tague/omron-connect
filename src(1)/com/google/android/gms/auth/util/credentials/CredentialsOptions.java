package com.google.android.gms.auth.util.credentials;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.util.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.util.Auth.AuthCredentialsOptions.Builder;

public final class CredentialsOptions
  extends Auth.AuthCredentialsOptions
{
  @RecentlyNonNull
  public static final CredentialsOptions DEFAULT = new Builder().build();
  
  public final class Builder
    extends Auth.AuthCredentialsOptions.Builder
  {
    public Builder() {}
    
    public CredentialsOptions build()
    {
      return new CredentialsOptions(this, null);
    }
    
    public Builder forceEnableSaveDialog()
    {
      value = Boolean.TRUE;
      return this;
    }
  }
}
