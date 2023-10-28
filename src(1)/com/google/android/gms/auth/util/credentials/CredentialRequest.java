package com.google.android.gms.auth.util.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SafeParcelable.Class(creator="CredentialRequestCreator")
public final class CredentialRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.CredentialRequest> CREATOR = new DiscreteSeekBar.CustomState.1();
  @SafeParcelable.Field(getter="isIdTokenRequested", id=5)
  private final boolean distinct;
  @SafeParcelable.Field(getter="isPasswordLoginSupported", id=1)
  private final boolean isError;
  @SafeParcelable.Field(getter="getRequireUserMediation", id=8)
  private final boolean isVisible;
  @SafeParcelable.Field(getter="getCredentialHintPickerConfig", id=4)
  private final CredentialPickerConfig limits;
  @SafeParcelable.Field(getter="getIdTokenNonce", id=7)
  private final String mArgString;
  @SafeParcelable.Field(getter="getServerClientId", id=6)
  private final String mHelp;
  @SafeParcelable.Field(getter="getAccountTypes", id=2)
  private final String[] mPackages;
  @SafeParcelable.Field(id=1000)
  final int position;
  @SafeParcelable.Field(getter="getCredentialPickerConfig", id=3)
  private final CredentialPickerConfig services;
  
  CredentialRequest(int paramInt, boolean paramBoolean1, String[] paramArrayOfString, CredentialPickerConfig paramCredentialPickerConfig1, CredentialPickerConfig paramCredentialPickerConfig2, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3)
  {
    position = paramInt;
    isError = paramBoolean1;
    mPackages = ((String[])Preconditions.checkNotNull(paramArrayOfString));
    paramArrayOfString = paramCredentialPickerConfig1;
    if (paramCredentialPickerConfig1 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    services = paramArrayOfString;
    paramArrayOfString = paramCredentialPickerConfig2;
    if (paramCredentialPickerConfig2 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    limits = paramArrayOfString;
    if (paramInt < 3)
    {
      distinct = true;
      mHelp = null;
      mArgString = null;
    }
    else
    {
      distinct = paramBoolean2;
      mHelp = paramString1;
      mArgString = paramString2;
    }
    isVisible = paramBoolean3;
  }
  
  public String[] getAccountTypes()
  {
    return mPackages;
  }
  
  public Set getAccountTypesSet()
  {
    return new HashSet(Arrays.asList(mPackages));
  }
  
  public CredentialPickerConfig getCredentialHintPickerConfig()
  {
    return limits;
  }
  
  public CredentialPickerConfig getCredentialPickerConfig()
  {
    return services;
  }
  
  public String getIdTokenNonce()
  {
    return mArgString;
  }
  
  public String getServerClientId()
  {
    return mHelp;
  }
  
  public boolean getSupportsPasswordLogin()
  {
    return isPasswordLoginSupported();
  }
  
  public boolean isIdTokenRequested()
  {
    return distinct;
  }
  
  public boolean isPasswordLoginSupported()
  {
    return isError;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, isPasswordLoginSupported());
    SafeParcelWriter.writeStringArray(paramParcel, 2, getAccountTypes(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getCredentialPickerConfig(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, getCredentialHintPickerConfig(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, isIdTokenRequested());
    SafeParcelWriter.writeString(paramParcel, 6, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 7, getIdTokenNonce(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 8, isVisible);
    SafeParcelWriter.writeInt(paramParcel, 1000, position);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final class Builder
  {
    private boolean checked = false;
    private CredentialPickerConfig choice;
    private CredentialPickerConfig low;
    private boolean mEmptyItem;
    private String[] pageSize;
    private String template;
    private String text = null;
    
    public Builder() {}
    
    public CredentialRequest build()
    {
      if (pageSize == null) {
        pageSize = new String[0];
      }
      boolean bool = mEmptyItem;
      if ((!bool) && (pageSize.length == 0)) {
        throw new IllegalStateException("At least one authentication method must be specified");
      }
      return new CredentialRequest(4, bool, pageSize, low, choice, checked, text, template, false);
    }
    
    public Builder setAccountTypes(String... paramVarArgs)
    {
      String[] arrayOfString = paramVarArgs;
      if (paramVarArgs == null) {
        arrayOfString = new String[0];
      }
      pageSize = arrayOfString;
      return this;
    }
    
    public Builder setCredentialHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      choice = paramCredentialPickerConfig;
      return this;
    }
    
    public Builder setCredentialPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      low = paramCredentialPickerConfig;
      return this;
    }
    
    public Builder setIdTokenNonce(String paramString)
    {
      template = paramString;
      return this;
    }
    
    public Builder setIdTokenRequested(boolean paramBoolean)
    {
      checked = paramBoolean;
      return this;
    }
    
    public Builder setPasswordLoginSupported(boolean paramBoolean)
    {
      mEmptyItem = paramBoolean;
      return this;
    }
    
    public Builder setServerClientId(String paramString)
    {
      text = paramString;
      return this;
    }
    
    public Builder setSupportsPasswordLogin(boolean paramBoolean)
    {
      setPasswordLoginSupported(paramBoolean);
      return this;
    }
  }
}
