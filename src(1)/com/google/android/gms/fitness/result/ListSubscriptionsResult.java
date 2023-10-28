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
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Deprecated
@SafeParcelable.Class(creator="ListSubscriptionsResultCreator")
@SafeParcelable.Reserved({3, 1000})
public class ListSubscriptionsResult
  extends AbstractSafeParcelable
  implements Result
{
  @RecentlyNonNull
  public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new DownloadProgressInfo.1();
  @SafeParcelable.Field(getter="getStatus", id=2)
  private final Status zzsv;
  @SafeParcelable.Field(getter="getSubscriptions", id=1)
  private final List<Subscription> zzsz;
  
  public ListSubscriptionsResult(List paramList, Status paramStatus)
  {
    zzsz = paramList;
    zzsv = paramStatus;
  }
  
  public static ListSubscriptionsResult getCalendars(Status paramStatus)
  {
    return new ListSubscriptionsResult(Collections.emptyList(), paramStatus);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ListSubscriptionsResult)) {
      return false;
    }
    paramObject = (ListSubscriptionsResult)paramObject;
    return (zzsv.equals(zzsv)) && (Objects.equal(zzsz, zzsz));
  }
  
  public Status getStatus()
  {
    return zzsv;
  }
  
  public List getSubscriptions()
  {
    return zzsz;
  }
  
  public List getSubscriptions(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzsz.iterator();
    while (localIterator.hasNext())
    {
      Subscription localSubscription = (Subscription)localIterator.next();
      if (paramDataType.equals(localSubscription.getSubscription())) {
        localArrayList.add(localSubscription);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzsv, zzsz });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("status", zzsv).name("subscriptions", zzsz).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getSubscriptions(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
