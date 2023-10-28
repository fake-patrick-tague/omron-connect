package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class AccountPicker
{
  private AccountPicker() {}
  
  public static Intent newChooseAccountIntent(Account paramAccount, ArrayList paramArrayList, String[] paramArrayOfString1, boolean paramBoolean, String paramString1, String paramString2, String[] paramArrayOfString2, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
    localIntent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
    localIntent.setPackage("com.google.android.gms");
    localIntent.putExtra("allowableAccounts", paramArrayList);
    localIntent.putExtra("allowableAccountTypes", paramArrayOfString1);
    localIntent.putExtra("addAccountOptions", paramBundle);
    localIntent.putExtra("selectedAccount", paramAccount);
    localIntent.putExtra("alwaysPromptForAccount", paramBoolean);
    localIntent.putExtra("descriptionTextOverride", paramString1);
    localIntent.putExtra("authTokenType", paramString2);
    localIntent.putExtra("addAccountRequiredFeatures", paramArrayOfString2);
    localIntent.putExtra("setGmsCoreAccount", false);
    localIntent.putExtra("overrideTheme", 0);
    localIntent.putExtra("overrideCustomTheme", 0);
    localIntent.putExtra("hostedDomainFilter", null);
    return localIntent;
  }
  
  public static Intent newChooseAccountIntent(AccountChooserOptions paramAccountChooserOptions)
  {
    Intent localIntent = new Intent();
    AccountChooserOptions.onMenuOpened(paramAccountChooserOptions);
    AccountChooserOptions.getResponseHandler(paramAccountChooserOptions);
    Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
    AccountChooserOptions.visitExecutable(paramAccountChooserOptions);
    Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
    AccountChooserOptions.isDescendantOf(paramAccountChooserOptions);
    Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the theme THEME_DAY_NIGHT_GOOGLE_MATERIAL2");
    AccountChooserOptions.onMenuOpened(paramAccountChooserOptions);
    localIntent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
    localIntent.setPackage("com.google.android.gms");
    localIntent.putExtra("allowableAccounts", AccountChooserOptions.i(paramAccountChooserOptions));
    if (AccountChooserOptions.getLevels(paramAccountChooserOptions) != null) {
      localIntent.putExtra("allowableAccountTypes", (String[])AccountChooserOptions.getLevels(paramAccountChooserOptions).toArray(new String[0]));
    }
    localIntent.putExtra("addAccountOptions", AccountChooserOptions.getTitleView(paramAccountChooserOptions));
    localIntent.putExtra("selectedAccount", AccountChooserOptions.access$getMAccount(paramAccountChooserOptions));
    AccountChooserOptions.isDescendantOf(paramAccountChooserOptions);
    localIntent.putExtra("selectedAccountIsNotClickable", false);
    localIntent.putExtra("alwaysPromptForAccount", AccountChooserOptions.isOut(paramAccountChooserOptions));
    localIntent.putExtra("descriptionTextOverride", AccountChooserOptions.toJsonString(paramAccountChooserOptions));
    AccountChooserOptions.createShortcut(paramAccountChooserOptions);
    localIntent.putExtra("setGmsCoreAccount", false);
    AccountChooserOptions.calculate(paramAccountChooserOptions);
    localIntent.putExtra("realClientPackage", null);
    AccountChooserOptions.distance1(paramAccountChooserOptions);
    localIntent.putExtra("overrideTheme", 0);
    AccountChooserOptions.onMenuOpened(paramAccountChooserOptions);
    localIntent.putExtra("overrideCustomTheme", 0);
    AccountChooserOptions.getResponseHandler(paramAccountChooserOptions);
    localIntent.putExtra("hostedDomainFilter", null);
    Bundle localBundle = new Bundle();
    AccountChooserOptions.onMenuOpened(paramAccountChooserOptions);
    AccountChooserOptions.visitExecutable(paramAccountChooserOptions);
    AccountChooserOptions.attachToExistingConstraints(paramAccountChooserOptions);
    AccountChooserOptions.equals(paramAccountChooserOptions);
    if (!localBundle.isEmpty()) {
      localIntent.putExtra("first_party_options_bundle", localBundle);
    }
    return localIntent;
  }
  
  public static class AccountChooserOptions
  {
    private String actionDescription;
    private boolean form;
    private boolean fullScreen;
    private ArrayList k;
    private ArrayList levels;
    private Account mAccount;
    private Boolean mSinglePane;
    private Bundle mTitleView;
    private boolean m_out;
    private String network;
    private String radical;
    private boolean reserved4;
    private boolean value;
    private boolean whiteToMove;
    private int x;
    
    public AccountChooserOptions() {}
    
    public static class Builder
    {
      private Account account;
      private Bundle context;
      private boolean dir = false;
      private ArrayList file;
      private ArrayList path;
      private String service;
      
      public Builder() {}
      
      public AccountPicker.AccountChooserOptions build()
      {
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
        AccountPicker.AccountChooserOptions localAccountChooserOptions = new AccountPicker.AccountChooserOptions();
        AccountPicker.AccountChooserOptions.parse(localAccountChooserOptions, path);
        AccountPicker.AccountChooserOptions.d(localAccountChooserOptions, file);
        AccountPicker.AccountChooserOptions.mkdirs(localAccountChooserOptions, dir);
        AccountPicker.AccountChooserOptions.setSorting(localAccountChooserOptions, null);
        AccountPicker.AccountChooserOptions.closeSafely(localAccountChooserOptions, null);
        AccountPicker.AccountChooserOptions.init(localAccountChooserOptions, context);
        AccountPicker.AccountChooserOptions.setAccount(localAccountChooserOptions, account);
        AccountPicker.AccountChooserOptions.reset(localAccountChooserOptions, false);
        AccountPicker.AccountChooserOptions.clear(localAccountChooserOptions, false);
        AccountPicker.AccountChooserOptions.calculate(localAccountChooserOptions, null);
        AccountPicker.AccountChooserOptions.computeKey(localAccountChooserOptions, 0);
        AccountPicker.AccountChooserOptions.from(localAccountChooserOptions, service);
        AccountPicker.AccountChooserOptions.applyFullscreen(localAccountChooserOptions, false);
        AccountPicker.AccountChooserOptions.inc(localAccountChooserOptions, false);
        AccountPicker.AccountChooserOptions.parse(localAccountChooserOptions, false);
        return localAccountChooserOptions;
      }
      
      public Builder setAllowableAccounts(List paramList)
      {
        if (paramList == null) {
          paramList = null;
        } else {
          paramList = new ArrayList(paramList);
        }
        file = paramList;
        return this;
      }
      
      public Builder setAllowableAccountsTypes(List paramList)
      {
        if (paramList == null) {
          paramList = null;
        } else {
          paramList = new ArrayList(paramList);
        }
        path = paramList;
        return this;
      }
      
      public Builder setAlwaysShowAccountPicker(boolean paramBoolean)
      {
        dir = paramBoolean;
        return this;
      }
      
      public Builder setOptionsForAddingAccount(Bundle paramBundle)
      {
        context = paramBundle;
        return this;
      }
      
      public Builder setSelectedAccount(Account paramAccount)
      {
        account = paramAccount;
        return this;
      }
      
      public Builder setTitleOverrideText(String paramString)
      {
        service = paramString;
        return this;
      }
    }
  }
}
