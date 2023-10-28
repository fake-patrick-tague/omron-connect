package com.google.android.gms.auth.util.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@SafeParcelable.Class(creator="HintRequestCreator")
public final class HintRequest
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.HintRequest> CREATOR = new DownloadProgressInfo.1();
  @SafeParcelable.Field(getter="getAccountTypes", id=4)
  private final String[] accountNames;
  @SafeParcelable.Field(getter="isIdTokenRequested", id=5)
  private final boolean dynamic;
  @SafeParcelable.Field(getter="getIdTokenNonce", id=7)
  private final String header;
  @SafeParcelable.Field(getter="isPhoneNumberIdentifierSupported", id=3)
  private final boolean isVisible;
  @SafeParcelable.Field(getter="isEmailAddressIdentifierSupported", id=2)
  private final boolean keepUpdated;
  @SafeParcelable.Field(getter="getServerClientId", id=6)
  private final String rawData;
  @SafeParcelable.Field(getter="getHintPickerConfig", id=1)
  private final CredentialPickerConfig rssi;
  @SafeParcelable.Field(id=1000)
  final int txPower;
  
  HintRequest(int paramInt, CredentialPickerConfig paramCredentialPickerConfig, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, boolean paramBoolean3, String paramString1, String paramString2)
  {
    txPower = paramInt;
    rssi = ((CredentialPickerConfig)Preconditions.checkNotNull(paramCredentialPickerConfig));
    keepUpdated = paramBoolean1;
    isVisible = paramBoolean2;
    accountNames = ((String[])Preconditions.checkNotNull(paramArrayOfString));
    if (paramInt < 2)
    {
      dynamic = true;
      rawData = null;
      header = null;
      return;
    }
    dynamic = paramBoolean3;
    rawData = paramString1;
    header = paramString2;
  }
  
  public String[] getAccountTypes()
  {
    return accountNames;
  }
  
  public CredentialPickerConfig getHintPickerConfig()
  {
    return rssi;
  }
  
  public String getIdTokenNonce()
  {
    return header;
  }
  
  public String getServerClientId()
  {
    return rawData;
  }
  
  public boolean isEmailAddressIdentifierSupported()
  {
    return keepUpdated;
  }
  
  public boolean isIdTokenRequested()
  {
    return dynamic;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getHintPickerConfig(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, isEmailAddressIdentifierSupported());
    SafeParcelWriter.writeBoolean(paramParcel, 3, isVisible);
    SafeParcelWriter.writeStringArray(paramParcel, 4, getAccountTypes(), false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, isIdTokenRequested());
    SafeParcelWriter.writeString(paramParcel, 6, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 7, getIdTokenNonce(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, txPower);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final class Builder
  {
    private boolean list;
    private String[] name;
    private CredentialPickerConfig port = new CredentialPickerConfig.Builder().build();
    private boolean priority;
    private String requestMethod;
    private boolean service = false;
    private String url;
    
    public Builder() {}
    
    public HintRequest build()
    {
      if (name == null) {
        name = new String[0];
      }
      boolean bool = list;
      if ((!bool) && (!priority) && (name.length == 0)) {
        throw new IllegalStateException("At least one authentication method must be specified");
      }
      return new HintRequest(2, port, bool, priority, name, service, url, requestMethod);
    }
    
    public Builder setAccountTypes(String... paramVarArgs)
    {
      String[] arrayOfString = paramVarArgs;
      if (paramVarArgs == null) {
        arrayOfString = new String[0];
      }
      name = arrayOfString;
      return this;
    }
    
    public Builder setEmailAddressIdentifierSupported(boolean paramBoolean)
    {
      list = paramBoolean;
      return this;
    }
    
    public Builder setHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      port = ((CredentialPickerConfig)Preconditions.checkNotNull(paramCredentialPickerConfig));
      return this;
    }
    
    public Builder setIdTokenNonce(String paramString)
    {
      requestMethod = paramString;
      return this;
    }
    
    public Builder setIdTokenRequested(boolean paramBoolean)
    {
      service = paramBoolean;
      return this;
    }
    
    public Builder setPhoneNumberIdentifierSupported(boolean paramBoolean)
    {
      priority = paramBoolean;
      return this;
    }
    
    public Builder setServerClientId(String paramString)
    {
      url = paramString;
      return this;
    }
  }
}
