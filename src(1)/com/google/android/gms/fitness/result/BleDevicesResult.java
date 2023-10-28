package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Deprecated
@SafeParcelable.Class(creator="BleDevicesResultCreator")
@SafeParcelable.Reserved({1000})
public class BleDevicesResult
  extends AbstractSafeParcelable
  implements Result
{
  @RecentlyNonNull
  public static final Parcelable.Creator<BleDevicesResult> CREATOR = new PaymentIntent.1();
  @SafeParcelable.Field(getter="getClaimedBleDevices", id=1)
  private final List<BleDevice> zzsu;
  @SafeParcelable.Field(getter="getStatus", id=2)
  private final Status zzsv;
  
  public BleDevicesResult(List paramList, Status paramStatus)
  {
    zzsu = Collections.unmodifiableList(paramList);
    zzsv = paramStatus;
  }
  
  public static BleDevicesResult parseComments(Status paramStatus)
  {
    return new BleDevicesResult(Collections.emptyList(), paramStatus);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof BleDevicesResult)) {
      return false;
    }
    paramObject = (BleDevicesResult)paramObject;
    return (zzsv.equals(zzsv)) && (Objects.equal(zzsu, zzsu));
  }
  
  public List getClaimedBleDevices()
  {
    return zzsu;
  }
  
  public List getClaimedBleDevices(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzsu.iterator();
    while (localIterator.hasNext())
    {
      BleDevice localBleDevice = (BleDevice)localIterator.next();
      if (localBleDevice.getDataTypes().contains(paramDataType)) {
        localArrayList.add(localBleDevice);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Status getStatus()
  {
    return zzsv;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzsv, zzsu });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("status", zzsv).name("bleDevices", zzsu).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getClaimedBleDevices(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
