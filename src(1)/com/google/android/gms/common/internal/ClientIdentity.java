package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@KeepForSdk
@SafeParcelable.Class(creator="ClientIdentityCreator")
@SafeParcelable.Reserved({1000})
public class ClientIdentity
  extends AbstractSafeParcelable
{
  @KeepForSdk
  public static final Parcelable.Creator<ClientIdentity> CREATOR = new AddressAndLabel.1();
  @KeepForSdk
  @SafeParcelable.Field(defaultValueUnchecked="null", id=2)
  public final String packageName;
  @KeepForSdk
  @SafeParcelable.Field(defaultValueUnchecked="0", id=1)
  public final int pid;
  
  public ClientIdentity(int paramInt, String paramString)
  {
    pid = paramInt;
    packageName = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ClientIdentity)) {
      return false;
    }
    paramObject = (ClientIdentity)paramObject;
    return (pid == pid) && (Objects.equal(packageName, packageName));
  }
  
  public final int hashCode()
  {
    return pid;
  }
  
  public final String toString()
  {
    int i = pid;
    String str = packageName;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 12);
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, pid);
    SafeParcelWriter.writeString(paramParcel, 2, packageName, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
