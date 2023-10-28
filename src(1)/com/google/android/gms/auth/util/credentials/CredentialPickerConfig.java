package com.google.android.gms.auth.util.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator="CredentialPickerConfigCreator")
public final class CredentialPickerConfig
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<com.google.android.gms.auth.api.credentials.CredentialPickerConfig> CREATOR = new Point.1();
  @SafeParcelable.Field(getter="shouldShowCancelButton", id=2)
  private final boolean defaultFormat;
  @SafeParcelable.Field(getter="shouldShowAddAccountButton", id=1)
  private final boolean keepUpdated;
  @SafeParcelable.Field(getter="getPromptInternalId", id=4)
  private final int style;
  @SafeParcelable.Field(id=1000)
  final int titleRes;
  
  CredentialPickerConfig(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    titleRes = paramInt1;
    keepUpdated = paramBoolean1;
    defaultFormat = paramBoolean2;
    if (paramInt1 < 2)
    {
      paramInt1 = 1;
      if (true == paramBoolean3) {
        paramInt1 = 3;
      }
      style = paramInt1;
      return;
    }
    style = paramInt2;
  }
  
  public boolean isForNewAccount()
  {
    return style == 3;
  }
  
  public boolean shouldShowAddAccountButton()
  {
    return keepUpdated;
  }
  
  public boolean shouldShowCancelButton()
  {
    return defaultFormat;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, shouldShowAddAccountButton());
    SafeParcelWriter.writeBoolean(paramParcel, 2, shouldShowCancelButton());
    SafeParcelWriter.writeBoolean(paramParcel, 3, isForNewAccount());
    SafeParcelWriter.writeInt(paramParcel, 4, style);
    SafeParcelWriter.writeInt(paramParcel, 1000, titleRes);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public class Builder
  {
    private int op = 1;
    private boolean priority = false;
    private boolean value = true;
    
    public Builder() {}
    
    public CredentialPickerConfig build()
    {
      return new CredentialPickerConfig(2, priority, value, false, op);
    }
    
    public Builder setForNewAccount(boolean paramBoolean)
    {
      int i = 1;
      if (true == paramBoolean) {
        i = 3;
      }
      op = i;
      return this;
    }
    
    public Builder setPrompt(int paramInt)
    {
      op = paramInt;
      return this;
    }
    
    public Builder setShowAddAccountButton(boolean paramBoolean)
    {
      priority = paramBoolean;
      return this;
    }
    
    public Builder setShowCancelButton(boolean paramBoolean)
    {
      value = paramBoolean;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public @interface Prompt
  {
    public static final int CONTINUE = 1;
    public static final int SIGN_IN = 2;
    public static final int SIGN_UP = 3;
  }
}
