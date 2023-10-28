package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import c.e.b;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.package_12.GoogleApiClient.Builder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import v7.util.TLongArrayList;

@KeepForSdk
@VisibleForTesting
public final class ClientSettings
{
  private final Account account;
  private final SignInOptions entrySet;
  private final Set<Scope> excludedCerts;
  private final String fullName;
  private final View i;
  private final int j;
  private final String more;
  private final Set<Scope> set;
  private final Map<Api<?>, zab> table;
  private Integer val;
  
  public ClientSettings(Account paramAccount, Set paramSet, Map paramMap, int paramInt, View paramView, String paramString1, String paramString2, SignInOptions paramSignInOptions)
  {
    this(paramAccount, paramSet, paramMap, paramInt, paramView, paramString1, paramString2, paramSignInOptions, false);
  }
  
  public ClientSettings(Account paramAccount, Set paramSet, Map paramMap, int paramInt, View paramView, String paramString1, String paramString2, SignInOptions paramSignInOptions, boolean paramBoolean)
  {
    account = paramAccount;
    if (paramSet == null) {
      paramAccount = Collections.emptySet();
    } else {
      paramAccount = Collections.unmodifiableSet(paramSet);
    }
    set = paramAccount;
    paramSet = paramMap;
    if (paramMap == null) {
      paramSet = Collections.emptyMap();
    }
    table = paramSet;
    i = paramView;
    j = paramInt;
    more = paramString1;
    fullName = paramString2;
    paramMap = paramSignInOptions;
    if (paramSignInOptions == null) {
      paramMap = SignInOptions.SET;
    }
    entrySet = paramMap;
    paramAccount = new HashSet(paramAccount);
    paramSet = paramSet.values().iterator();
    while (paramSet.hasNext()) {
      paramAccount.addAll(nextname);
    }
    excludedCerts = Collections.unmodifiableSet(paramAccount);
  }
  
  public static ClientSettings createDefault(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).remove();
  }
  
  public final SignInOptions entrySet()
  {
    return entrySet;
  }
  
  public final Map get()
  {
    return table;
  }
  
  public Account getAccount()
  {
    return account;
  }
  
  public String getAccountName()
  {
    Account localAccount = account;
    if (localAccount != null) {
      return name;
    }
    return null;
  }
  
  public Account getAccountOrDefault()
  {
    Account localAccount = account;
    if (localAccount != null) {
      return localAccount;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public Set getAllRequestedScopes()
  {
    return excludedCerts;
  }
  
  public Set getApplicableScopes(com.google.android.gms.common.package_12.Attribute paramAttribute)
  {
    paramAttribute = (Attribute)table.get(paramAttribute);
    if ((paramAttribute != null) && (!name.isEmpty()))
    {
      HashSet localHashSet = new HashSet(set);
      localHashSet.addAll(name);
      return localHashSet;
    }
    return set;
  }
  
  public final String getFullName()
  {
    return fullName;
  }
  
  public int getGravityForPopups()
  {
    return j;
  }
  
  public String getRealClientPackageName()
  {
    return more;
  }
  
  public Set getRequiredScopes()
  {
    return set;
  }
  
  public View getViewForPopups()
  {
    return i;
  }
  
  public final void set(Integer paramInteger)
  {
    val = paramInteger;
  }
  
  public final Integer val()
  {
    return val;
  }
  
  @KeepForSdk
  public static final class Builder
  {
    private String date;
    private Account mAccount;
    private String path;
    private SignInOptions strokePaint = SignInOptions.SET;
    private b<Scope> this$0;
    
    public Builder() {}
    
    public final Builder addAll(Collection paramCollection)
    {
      if (this$0 == null) {
        this$0 = new TLongArrayList();
      }
      this$0.addAll(paramCollection);
      return this;
    }
    
    public final Builder addModules(String paramString)
    {
      path = paramString;
      return this;
    }
    
    public ClientSettings build()
    {
      return new ClientSettings(mAccount, this$0, null, 0, null, date, path, strokePaint, false);
    }
    
    public final Builder setAccount(Account paramAccount)
    {
      mAccount = paramAccount;
      return this;
    }
    
    public Builder setRealClientPackageName(String paramString)
    {
      date = paramString;
      return this;
    }
  }
}
