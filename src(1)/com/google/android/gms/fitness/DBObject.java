package com.google.android.gms.fitness;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.auth.util.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions;
import com.google.android.gms.common.util.PlatformVersion;

@ShowFirstParty
public final class DBObject
  implements Api.ApiOptions.HasGoogleSignInAccountOptions
{
  private final GoogleSignInAccount zzkm;
  
  public DBObject(Context paramContext, GoogleSignInAccount paramGoogleSignInAccount)
  {
    if ("<<default account>>".equals(paramGoogleSignInAccount.getEmail()))
    {
      int i;
      if ((PlatformVersion.isAtLeastLollipop()) && (paramContext.getPackageManager().hasSystemFeature("cn.google"))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        zzkm = null;
        return;
      }
    }
    zzkm = paramGoogleSignInAccount;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DBObject)) && (Objects.equal(zzkm, zzkm)));
  }
  
  public final GoogleSignInAccount getGoogleSignInAccount()
  {
    return zzkm;
  }
  
  public final int hashCode()
  {
    GoogleSignInAccount localGoogleSignInAccount = zzkm;
    if (localGoogleSignInAccount != null) {
      return localGoogleSignInAccount.hashCode();
    }
    return 0;
  }
}
