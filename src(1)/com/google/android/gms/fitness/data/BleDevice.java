package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Deprecated
@SafeParcelable.Class(creator="BleDeviceCreator")
@SafeParcelable.Reserved({1000})
public class BleDevice
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<BleDevice> CREATOR = new UndoBarStyle.1();
  @SafeParcelable.Field(getter="getName", id=2)
  private final String name;
  @SafeParcelable.Field(getter="getAddress", id=1)
  private final String zzld;
  @SafeParcelable.Field(getter="getSupportedProfiles", id=3)
  private final List<String> zzle;
  @SafeParcelable.Field(getter="getDataTypes", id=4)
  private final List<DataType> zzlf;
  
  BleDevice(String paramString1, String paramString2, List paramList1, List paramList2)
  {
    zzld = paramString1;
    name = paramString2;
    zzle = Collections.unmodifiableList(paramList1);
    zzlf = Collections.unmodifiableList(paramList2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof BleDevice)) {
      return false;
    }
    paramObject = (BleDevice)paramObject;
    return (name.equals(name)) && (zzld.equals(zzld)) && (new HashSet(zzle).equals(new HashSet(zzle))) && (new HashSet(zzlf).equals(new HashSet(zzlf)));
  }
  
  public String getAddress()
  {
    return zzld;
  }
  
  public List getDataTypes()
  {
    return zzlf;
  }
  
  public String getName()
  {
    return name;
  }
  
  public List getSupportedProfiles()
  {
    return zzle;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { name, zzld, zzle, zzlf });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("name", name).name("address", zzld).name("dataTypes", zzlf).name("supportedProfiles", zzle).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getAddress(), false);
    SafeParcelWriter.writeString(paramParcel, 2, getName(), false);
    SafeParcelWriter.writeStringList(paramParcel, 3, getSupportedProfiles(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 4, getDataTypes(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
