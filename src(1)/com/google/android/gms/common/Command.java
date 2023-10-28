package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.INotificationSideChannel.Stub;
import com.google.android.gms.common.internal.Network;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator="GoogleCertificatesQueryCreator")
public final class Command
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzs> CREATOR = new PaymentIntent.Output.1();
  @SafeParcelable.Field(getter="getCallingCertificateBinder", id=2, type="android.os.IBinder")
  private final Type mArgString;
  @SafeParcelable.Field(getter="getAllowTestKeys", id=3)
  private final boolean mArgs;
  @SafeParcelable.Field(getter="getCallingPackage", id=1)
  private final String mHelp;
  @SafeParcelable.Field(defaultValue="false", getter="getIgnoreTestKeysOverride", id=4)
  private final boolean mId;
  
  Command(String paramString, IBinder paramIBinder, boolean paramBoolean1, boolean paramBoolean2)
  {
    mHelp = paramString;
    Object localObject = null;
    if (paramIBinder == null) {
      paramString = localObject;
    } else {
      try
      {
        paramString = INotificationSideChannel.Stub.asInterface(paramIBinder).get();
        if (paramString == null) {
          paramString = null;
        } else {
          paramString = (byte[])ObjectWrapper.unwrap(paramString);
        }
        if (paramString != null)
        {
          paramString = new OmniPhoneNumber(paramString);
        }
        else
        {
          Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
          paramString = localObject;
        }
      }
      catch (RemoteException paramString)
      {
        Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", paramString);
        paramString = localObject;
      }
    }
    mArgString = paramString;
    mArgs = paramBoolean1;
    mId = paramBoolean2;
  }
  
  Command(String paramString, Type paramType, boolean paramBoolean1, boolean paramBoolean2)
  {
    mHelp = paramString;
    mArgString = paramType;
    mArgs = paramBoolean1;
    mId = paramBoolean2;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, mHelp, false);
    Type localType2 = mArgString;
    Type localType1 = localType2;
    if (localType2 == null)
    {
      Log.w("GoogleCertificatesQuery", "certificate binder is null");
      localType1 = null;
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, localType1, false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, mArgs);
    SafeParcelWriter.writeBoolean(paramParcel, 4, mId);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
