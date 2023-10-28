package com.google.android.gms.auth.util.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.package_11.Fragment;
import com.google.android.gms.auth.util.signin.internal.ByteArrayPool;
import com.google.android.gms.auth.util.signin.internal.DefaultServiceManager;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.package_12.Scope;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GoogleSignIn
{
  private GoogleSignIn() {}
  
  private static Intent create(Activity paramActivity, GoogleSignInAccount paramGoogleSignInAccount, Scope... paramVarArgs)
  {
    GoogleSignInOptions.Builder localBuilder = new GoogleSignInOptions.Builder();
    if (paramVarArgs.length > 0) {
      localBuilder.requestScopes(paramVarArgs[0], paramVarArgs);
    }
    if ((paramGoogleSignInAccount != null) && (!TextUtils.isEmpty(paramGoogleSignInAccount.getEmail()))) {
      localBuilder.setAccountName((String)Preconditions.checkNotNull(paramGoogleSignInAccount.getEmail()));
    }
    return new GoogleSignInClient(paramActivity, localBuilder.build()).getSignInIntent();
  }
  
  public static GoogleSignInAccount getAccountForExtension(Context paramContext, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    Preconditions.checkNotNull(paramContext, "please provide a valid Context object");
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "please provide valid GoogleSignInOptionsExtension");
    GoogleSignInAccount localGoogleSignInAccount = getLastSignedInAccount(paramContext);
    paramContext = localGoogleSignInAccount;
    if (localGoogleSignInAccount == null) {
      paramContext = GoogleSignInAccount.createDefault();
    }
    return paramContext.requestExtraScopes(show(paramGoogleSignInOptionsExtension.getImpliedScopes()));
  }
  
  public static GoogleSignInAccount getAccountForScopes(Context paramContext, Scope paramScope, Scope... paramVarArgs)
  {
    Preconditions.checkNotNull(paramContext, "please provide a valid Context object");
    Preconditions.checkNotNull(paramScope, "please provide at least one valid scope");
    GoogleSignInAccount localGoogleSignInAccount = getLastSignedInAccount(paramContext);
    paramContext = localGoogleSignInAccount;
    if (localGoogleSignInAccount == null) {
      paramContext = GoogleSignInAccount.createDefault();
    }
    paramContext.requestExtraScopes(new Scope[] { paramScope });
    paramContext.requestExtraScopes(paramVarArgs);
    return paramContext;
  }
  
  public static GoogleSignInClient getClient(Activity paramActivity, GoogleSignInOptions paramGoogleSignInOptions)
  {
    return new GoogleSignInClient(paramActivity, (GoogleSignInOptions)Preconditions.checkNotNull(paramGoogleSignInOptions));
  }
  
  public static GoogleSignInClient getClient(Context paramContext, GoogleSignInOptions paramGoogleSignInOptions)
  {
    return new GoogleSignInClient(paramContext, (GoogleSignInOptions)Preconditions.checkNotNull(paramGoogleSignInOptions));
  }
  
  public static GoogleSignInAccount getLastSignedInAccount(Context paramContext)
  {
    return ByteArrayPool.get(paramContext).get();
  }
  
  public static Task getSignedInAccountFromIntent(Intent paramIntent)
  {
    paramIntent = DefaultServiceManager.infoFromShortcutIntent(paramIntent);
    GoogleSignInAccount localGoogleSignInAccount = paramIntent.getSignInAccount();
    if ((paramIntent.getStatus().isSuccess()) && (localGoogleSignInAccount != null)) {
      return Tasks.forResult(localGoogleSignInAccount);
    }
    return Tasks.forException(ApiExceptionUtil.fromStatus(paramIntent.getStatus()));
  }
  
  public static boolean hasPermissions(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
    return hasPermissions(paramGoogleSignInAccount, show(paramGoogleSignInOptionsExtension.getImpliedScopes()));
  }
  
  public static boolean hasPermissions(GoogleSignInAccount paramGoogleSignInAccount, Scope... paramVarArgs)
  {
    if (paramGoogleSignInAccount == null) {
      return false;
    }
    HashSet localHashSet = new HashSet();
    Collections.addAll(localHashSet, paramVarArgs);
    return paramGoogleSignInAccount.getGrantedScopes().containsAll(localHashSet);
  }
  
  public static void requestPermissions(Activity paramActivity, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    Preconditions.checkNotNull(paramActivity, "Please provide a non-null Activity");
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
    requestPermissions(paramActivity, paramInt, paramGoogleSignInAccount, show(paramGoogleSignInOptionsExtension.getImpliedScopes()));
  }
  
  public static void requestPermissions(Activity paramActivity, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, Scope... paramVarArgs)
  {
    Preconditions.checkNotNull(paramActivity, "Please provide a non-null Activity");
    Preconditions.checkNotNull(paramVarArgs, "Please provide at least one scope");
    paramActivity.startActivityForResult(create(paramActivity, paramGoogleSignInAccount, paramVarArgs), paramInt);
  }
  
  public static void requestPermissions(Fragment paramFragment, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    Preconditions.checkNotNull(paramFragment, "Please provide a non-null Fragment");
    Preconditions.checkNotNull(paramGoogleSignInOptionsExtension, "Please provide a non-null GoogleSignInOptionsExtension");
    requestPermissions(paramFragment, paramInt, paramGoogleSignInAccount, show(paramGoogleSignInOptionsExtension.getImpliedScopes()));
  }
  
  public static void requestPermissions(Fragment paramFragment, int paramInt, GoogleSignInAccount paramGoogleSignInAccount, Scope... paramVarArgs)
  {
    Preconditions.checkNotNull(paramFragment, "Please provide a non-null Fragment");
    Preconditions.checkNotNull(paramVarArgs, "Please provide at least one scope");
    paramFragment.startActivityForResult(create(paramFragment.getActivity(), paramGoogleSignInAccount, paramVarArgs), paramInt);
  }
  
  private static Scope[] show(List paramList)
  {
    if (paramList == null) {
      return new Scope[0];
    }
    return (Scope[])paramList.toArray(new Scope[paramList.size()]);
  }
}
