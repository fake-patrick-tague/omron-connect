package com.google.android.gms.auth.util.identity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth-api.zbam;
import com.google.android.gms.internal.auth-api.zbau;

public final class Identity
{
  private Identity() {}
  
  public static CredentialSavingClient getCredentialSavingClient(Activity paramActivity)
  {
    paramActivity = (Activity)Preconditions.checkNotNull(paramActivity);
    int i = DBObject.alias;
    return new zbam(paramActivity, new DBObject());
  }
  
  public static CredentialSavingClient getCredentialSavingClient(Context paramContext)
  {
    paramContext = (Context)Preconditions.checkNotNull(paramContext);
    int i = DBObject.alias;
    return new zbam(paramContext, new DBObject());
  }
  
  public static SignInClient getSignInClient(Activity paramActivity)
  {
    paramActivity = (Activity)Preconditions.checkNotNull(paramActivity);
    int i = Topic.mLastFetchedPage;
    return new zbau(paramActivity, new Topic());
  }
  
  public static SignInClient getSignInClient(Context paramContext)
  {
    paramContext = (Context)Preconditions.checkNotNull(paramContext);
    int i = Topic.mLastFetchedPage;
    return new zbau(paramContext, new Topic());
  }
}
