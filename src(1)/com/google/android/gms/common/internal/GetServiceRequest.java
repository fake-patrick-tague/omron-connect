package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.package_12.Scope;

@KeepForSdk
@SafeParcelable.Class(creator="GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
public class GetServiceRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new PaymentIntent.Output.1();
  static final Scope[] PAUSED = new Scope[0];
  static final Feature[] UNKNOWN = new Feature[0];
  @SafeParcelable.Field(id=8)
  Account account;
  @SafeParcelable.Field(getter="getAttributionTag", id=15)
  private String conditionText;
  @SafeParcelable.VersionField(id=1)
  final int day;
  @SafeParcelable.Field(defaultValueUnchecked="GetServiceRequest.EMPTY_FEATURES", id=10)
  Feature[] jid;
  @SafeParcelable.Field(id=3)
  int level;
  @SafeParcelable.Field(defaultValueUnchecked="new android.os.Bundle()", id=7)
  Bundle mBundle;
  @SafeParcelable.Field(defaultValueUnchecked="GetServiceRequest.EMPTY_SCOPES", id=6)
  Scope[] mRoutes;
  @SafeParcelable.Field(id=5)
  IBinder service;
  @SafeParcelable.Field(id=12)
  boolean target;
  @SafeParcelable.Field(defaultValue="0", id=13)
  int text;
  @SafeParcelable.Field(id=2)
  final int time;
  @SafeParcelable.Field(defaultValueUnchecked="GetServiceRequest.EMPTY_FEATURES", id=11)
  Feature[] type;
  @SafeParcelable.Field(id=4)
  String user;
  @SafeParcelable.Field(getter="isRequestingTelemetryConfiguration", id=14)
  boolean visible;
  
  GetServiceRequest(int paramInt1, int paramInt2, int paramInt3, String paramString1, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, Feature[] paramArrayOfFeature1, Feature[] paramArrayOfFeature2, boolean paramBoolean1, int paramInt4, boolean paramBoolean2, String paramString2)
  {
    Scope[] arrayOfScope = paramArrayOfScope;
    if (paramArrayOfScope == null) {
      arrayOfScope = PAUSED;
    }
    paramArrayOfScope = paramBundle;
    if (paramBundle == null) {
      paramArrayOfScope = new Bundle();
    }
    paramBundle = paramArrayOfFeature1;
    if (paramArrayOfFeature1 == null) {
      paramBundle = UNKNOWN;
    }
    paramArrayOfFeature1 = paramArrayOfFeature2;
    if (paramArrayOfFeature2 == null) {
      paramArrayOfFeature1 = UNKNOWN;
    }
    day = paramInt1;
    time = paramInt2;
    level = paramInt3;
    if ("com.google.android.gms".equals(paramString1)) {
      user = "com.google.android.gms";
    } else {
      user = paramString1;
    }
    if (paramInt1 < 2)
    {
      if (paramIBinder != null) {
        paramString1 = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(paramIBinder));
      } else {
        paramString1 = null;
      }
      account = paramString1;
    }
    else
    {
      service = paramIBinder;
      account = paramAccount;
    }
    mRoutes = arrayOfScope;
    mBundle = paramArrayOfScope;
    jid = paramBundle;
    type = paramArrayOfFeature1;
    target = paramBoolean1;
    text = paramInt4;
    visible = paramBoolean2;
    conditionText = paramString2;
  }
  
  public final String getConditionText()
  {
    return conditionText;
  }
  
  public Bundle getExtraArgs()
  {
    return mBundle;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PaymentIntent.Output.1.toString(this, paramParcel, paramInt);
  }
}
