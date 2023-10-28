package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="ConnectionResultCreator")
public final class ConnectionResult
  extends AbstractSafeParcelable
{
  public static final int API_DISABLED = 23;
  public static final int API_DISABLED_FOR_CONNECTION = 24;
  public static final int API_UNAVAILABLE = 16;
  public static final int CANCELED = 13;
  public static final Parcelable.Creator<ConnectionResult> CREATOR = new DownloadProgressInfo.1();
  public static final int DEVELOPER_ERROR = 10;
  @Deprecated
  public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 15;
  public static final int INVALID_ACCOUNT = 5;
  public static final int LICENSE_CHECK_FAILED = 11;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_ACTIVITY_NOT_FOUND = 22;
  public static final int RESOLUTION_REQUIRED = 6;
  public static final int RESTRICTED_PROFILE = 20;
  @KeepForSdk
  @ShowFirstParty
  public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
  public static final int SERVICE_DISABLED = 3;
  public static final int SERVICE_INVALID = 9;
  public static final int SERVICE_MISSING = 1;
  public static final int SERVICE_MISSING_PERMISSION = 19;
  public static final int SERVICE_UPDATING = 18;
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_FAILED = 17;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int TIMEOUT = 14;
  @KeepForSdk
  public static final int UNKNOWN = -1;
  @SafeParcelable.VersionField(id=1)
  final int alert;
  @SafeParcelable.Field(getter="getErrorCode", id=2)
  private final int error;
  @SafeParcelable.Field(getter="getErrorMessage", id=4)
  private final String scope;
  @SafeParcelable.Field(getter="getResolution", id=3)
  private final PendingIntent type;
  
  public ConnectionResult(int paramInt)
  {
    this(paramInt, null, null);
  }
  
  ConnectionResult(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString)
  {
    alert = paramInt1;
    error = paramInt2;
    type = paramPendingIntent;
    scope = paramString;
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramPendingIntent, null);
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent, String paramString)
  {
    this(1, paramInt, paramPendingIntent, paramString);
  }
  
  static String toString(int paramInt)
  {
    if (paramInt != 99)
    {
      if (paramInt != 1500)
      {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("UNKNOWN_ERROR_CODE(");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
          case 24: 
            return "API_DISABLED_FOR_CONNECTION";
          case 23: 
            return "API_DISABLED";
          case 22: 
            return "RESOLUTION_ACTIVITY_NOT_FOUND";
          case 21: 
            return "API_VERSION_UPDATE_REQUIRED";
          case 20: 
            return "RESTRICTED_PROFILE";
          case 19: 
            return "SERVICE_MISSING_PERMISSION";
          case 18: 
            return "SERVICE_UPDATING";
          case 17: 
            return "SIGN_IN_FAILED";
          case 16: 
            return "API_UNAVAILABLE";
          case 15: 
            return "INTERRUPTED";
          case 14: 
            return "TIMEOUT";
          }
          return "CANCELED";
        case 11: 
          return "LICENSE_CHECK_FAILED";
        case 10: 
          return "DEVELOPER_ERROR";
        case 9: 
          return "SERVICE_INVALID";
        case 8: 
          return "INTERNAL_ERROR";
        case 7: 
          return "NETWORK_ERROR";
        case 6: 
          return "RESOLUTION_REQUIRED";
        case 5: 
          return "INVALID_ACCOUNT";
        case 4: 
          return "SIGN_IN_REQUIRED";
        case 3: 
          return "SERVICE_DISABLED";
        case 2: 
          return "SERVICE_VERSION_UPDATE_REQUIRED";
        case 1: 
          return "SERVICE_MISSING";
        case 0: 
          return "SUCCESS";
        }
        return "UNKNOWN";
      }
      return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    }
    return "UNFINISHED";
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ConnectionResult)) {
      return false;
    }
    paramObject = (ConnectionResult)paramObject;
    return (error == error) && (Objects.equal(type, type)) && (Objects.equal(scope, scope));
  }
  
  public int getErrorCode()
  {
    return error;
  }
  
  public String getErrorMessage()
  {
    return scope;
  }
  
  public PendingIntent getResolution()
  {
    return type;
  }
  
  public boolean hasResolution()
  {
    return (error != 0) && (type != null);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(error), type, scope });
  }
  
  public boolean isSuccess()
  {
    return error == 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    PendingIntent localPendingIntent = type;
    Preconditions.checkNotNull(localPendingIntent);
    paramActivity.startIntentSenderForResult(localPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this);
    localToStringHelper.name("statusCode", toString(error));
    localToStringHelper.name("resolution", type);
    localToStringHelper.name("message", scope);
    return localToStringHelper.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, alert);
    SafeParcelWriter.writeInt(paramParcel, 2, getErrorCode());
    SafeParcelWriter.writeParcelable(paramParcel, 3, getResolution(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, getErrorMessage(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
