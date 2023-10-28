package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.package_12.Result;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.fitness.data.Goal;
import java.util.List;

@Deprecated
@SafeParcelable.Class(creator="GoalsResultCreator")
@SafeParcelable.Reserved({1000})
public class GoalsResult
  extends AbstractSafeParcelable
  implements Result
{
  @RecentlyNonNull
  public static final Parcelable.Creator<GoalsResult> CREATOR = new PaymentIntent.Output.1();
  @SafeParcelable.Field(getter="getStatus", id=1)
  private final Status zzsv;
  @SafeParcelable.Field(getter="getGoals", id=2)
  private final List<Goal> zzsy;
  
  public GoalsResult(Status paramStatus, List paramList)
  {
    zzsv = paramStatus;
    zzsy = paramList;
  }
  
  public List getGoals()
  {
    return zzsy;
  }
  
  public Status getStatus()
  {
    return zzsv;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getStatus(), paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getGoals(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
