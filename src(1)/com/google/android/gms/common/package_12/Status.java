package com.google.android.gms.common.package_12;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.VisibleForTesting;

@SafeParcelable.Class(creator="StatusCreator")
public final class Status
  extends AbstractSafeParcelable
  implements Result, ReflectedParcelable
{
  public static final Parcelable.Creator<com.google.android.gms.common.api.Status> CREATOR = new DiscreteSeekBar.CustomState.1();
  @ShowFirstParty
  public static final Status INVALID_DATA;
  @KeepForSdk
  @ShowFirstParty
  public static final Status RESULT_CANCELED;
  @KeepForSdk
  public static final Status RESULT_DEAD_CLIENT;
  @KeepForSdk
  @ShowFirstParty
  public static final Status RESULT_INTERNAL_ERROR;
  @KeepForSdk
  @ShowFirstParty
  public static final Status RESULT_INTERRUPTED;
  @KeepForSdk
  @ShowFirstParty
  @VisibleForTesting
  public static final Status RESULT_SUCCESS;
  @KeepForSdk
  @ShowFirstParty
  @VisibleForTesting
  public static final Status RESULT_SUCCESS_CACHE = new Status(-1);
  @KeepForSdk
  @ShowFirstParty
  public static final Status RESULT_TIMEOUT;
  @SafeParcelable.Field(getter="getStatusCode", id=1)
  private final int code;
  @SafeParcelable.Field(getter="getStatusMessage", id=2)
  private final String message;
  @SafeParcelable.Field(getter="getPendingIntent", id=3)
  private final PendingIntent name;
  @SafeParcelable.Field(getter="getConnectionResult", id=4)
  private final ConnectionResult section;
  @SafeParcelable.VersionField(id=1000)
  final int value;
  
  static
  {
    RESULT_SUCCESS = new Status(0);
    RESULT_INTERRUPTED = new Status(14);
    RESULT_INTERNAL_ERROR = new Status(8);
    RESULT_TIMEOUT = new Status(15);
    RESULT_CANCELED = new Status(16);
    INVALID_DATA = new Status(17);
    RESULT_DEAD_CLIENT = new Status(18);
  }
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent, ConnectionResult paramConnectionResult)
  {
    value = paramInt1;
    code = paramInt2;
    message = paramString;
    name = paramPendingIntent;
    section = paramConnectionResult;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent, null);
  }
  
  public Status(ConnectionResult paramConnectionResult, String paramString)
  {
    this(paramConnectionResult, paramString, 17);
  }
  
  public Status(ConnectionResult paramConnectionResult, String paramString, int paramInt)
  {
    this(1, paramInt, paramString, paramConnectionResult.getResolution(), paramConnectionResult);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {
      return false;
    }
    paramObject = (Status)paramObject;
    return (value == value) && (code == code) && (Objects.equal(message, message)) && (Objects.equal(name, name)) && (Objects.equal(section, section));
  }
  
  public ConnectionResult getConnectionResult()
  {
    return section;
  }
  
  public final String getMessage()
  {
    String str = message;
    if (str != null) {
      return str;
    }
    return CommonStatusCodes.getStatusCodeString(code);
  }
  
  public PendingIntent getResolution()
  {
    return name;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return code;
  }
  
  public String getStatusMessage()
  {
    return message;
  }
  
  public boolean hasResolution()
  {
    return name != null;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(value), Integer.valueOf(code), message, name, section });
  }
  
  public boolean isCanceled()
  {
    return code == 16;
  }
  
  public boolean isInterrupted()
  {
    return code == 14;
  }
  
  public boolean isSuccess()
  {
    return code <= 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    PendingIntent localPendingIntent = name;
    Preconditions.checkNotNull(localPendingIntent);
    paramActivity.startIntentSenderForResult(localPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this);
    localToStringHelper.name("statusCode", getMessage());
    localToStringHelper.name("resolution", name);
    return localToStringHelper.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, getStatusCode());
    SafeParcelWriter.writeString(paramParcel, 2, getStatusMessage(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, name, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 4, getConnectionResult(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 1000, value);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
