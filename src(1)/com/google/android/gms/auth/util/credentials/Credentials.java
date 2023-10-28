package com.google.android.gms.auth.util.credentials;

import android.app.Activity;
import android.content.Context;

public class Credentials
{
  public Credentials() {}
  
  public static CredentialsClient getClient(Activity paramActivity)
  {
    return new CredentialsClient(paramActivity, CredentialsOptions.DEFAULT);
  }
  
  public static CredentialsClient getClient(Activity paramActivity, CredentialsOptions paramCredentialsOptions)
  {
    return new CredentialsClient(paramActivity, paramCredentialsOptions);
  }
  
  public static CredentialsClient getClient(Context paramContext)
  {
    return new CredentialsClient(paramContext, CredentialsOptions.DEFAULT);
  }
  
  public static CredentialsClient getClient(Context paramContext, CredentialsOptions paramCredentialsOptions)
  {
    return new CredentialsClient(paramContext, paramCredentialsOptions);
  }
}
