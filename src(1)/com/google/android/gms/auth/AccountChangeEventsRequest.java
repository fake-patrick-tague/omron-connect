package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="AccountChangeEventsRequestCreator")
public class AccountChangeEventsRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new Point.1();
  @SafeParcelable.Field(id=4)
  private Account mAccount;
  @SafeParcelable.Field(id=2)
  private int mHeight;
  @SafeParcelable.VersionField(id=1)
  private final int mWidth;
  @Deprecated
  @SafeParcelable.Field(id=3)
  private String name;
  
  public AccountChangeEventsRequest()
  {
    mWidth = 1;
  }
  
  AccountChangeEventsRequest(int paramInt1, int paramInt2, String paramString, Account paramAccount)
  {
    mWidth = paramInt1;
    mHeight = paramInt2;
    name = paramString;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString)))
    {
      mAccount = new Account(paramString, "com.google");
      return;
    }
    mAccount = paramAccount;
  }
  
  public Account getAccount()
  {
    return mAccount;
  }
  
  public String getAccountName()
  {
    return name;
  }
  
  public int getEventIndex()
  {
    return mHeight;
  }
  
  public AccountChangeEventsRequest setAccount(Account paramAccount)
  {
    mAccount = paramAccount;
    return this;
  }
  
  public AccountChangeEventsRequest setAccountName(String paramString)
  {
    name = paramString;
    return this;
  }
  
  public AccountChangeEventsRequest setEventIndex(int paramInt)
  {
    mHeight = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, mWidth);
    SafeParcelWriter.writeInt(paramParcel, 2, mHeight);
    SafeParcelWriter.writeString(paramParcel, 3, name, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, mAccount, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
