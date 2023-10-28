package com.google.android.gms.auth.util.identity;

import com.google.android.gms.auth.api.identity.zbc;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

public abstract interface CredentialSavingClient
  extends HasApiKey<zbc>
{
  public abstract Task saveAccountLinkingToken(SaveAccountLinkingTokenRequest paramSaveAccountLinkingTokenRequest);
  
  public abstract Task savePassword(SavePasswordRequest paramSavePasswordRequest);
}
