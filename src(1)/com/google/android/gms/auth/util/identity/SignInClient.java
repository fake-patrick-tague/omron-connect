package com.google.android.gms.auth.util.identity;

import android.content.Intent;
import com.google.android.gms.auth.api.identity.zbl;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.package_12.ApiException;
import com.google.android.gms.tasks.Task;

public abstract interface SignInClient
  extends HasApiKey<zbl>
{
  public abstract Task beginSignIn(BeginSignInRequest paramBeginSignInRequest);
  
  public abstract SignInCredential getSignInCredentialFromIntent(Intent paramIntent)
    throws ApiException;
  
  public abstract Task getSignInIntent(GetSignInIntentRequest paramGetSignInIntentRequest);
  
  public abstract Task signOut();
}
