package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.Stack;
import com.google.android.gms.internal.fitness.zzbm;
import com.google.android.gms.internal.fitness.zzbn;
import com.google.android.gms.internal.fitness.zzko;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator="GoalsReadRequestCreator")
@SafeParcelable.Reserved({1000})
public class GoalsReadRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<GoalsReadRequest> CREATOR = new zzae();
  @SafeParcelable.Field(getter="getDataTypes", id=2, type="java.util.List")
  private final List<DataType> zzlf;
  @SafeParcelable.Field(getter="getActivities", id=4, type="java.util.List")
  private final List<Integer> zzno;
  @SafeParcelable.Field(getter="getCallbackBinder", id=1, type="android.os.IBinder")
  private final zzbn zzrl;
  @SafeParcelable.Field(getter="getObjectiveTypeList", id=3, type="java.util.List")
  private final List<Integer> zzrm;
  
  GoalsReadRequest(IBinder paramIBinder, List paramList1, List paramList2, List paramList3)
  {
    if (paramIBinder == null) {
      paramIBinder = null;
    } else {
      paramIBinder = zzbm.asInterface(paramIBinder);
    }
    zzrl = paramIBinder;
    zzlf = paramList1;
    zzrm = paramList2;
    zzno = paramList3;
  }
  
  private GoalsReadRequest(Builder paramBuilder)
  {
    this(null, Builder.getEWAHIterator(paramBuilder), Builder.getSoundPath(paramBuilder), Builder.onTabOpened(paramBuilder));
  }
  
  public GoalsReadRequest(GoalsReadRequest paramGoalsReadRequest, zzbn paramZzbn)
  {
    this(paramZzbn, paramGoalsReadRequest.getDataTypes(), zzrm, zzno);
  }
  
  private GoalsReadRequest(zzbn paramZzbn, List paramList1, List paramList2, List paramList3)
  {
    this(paramZzbn, paramList1, paramList2, paramList3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof GoalsReadRequest)) {
      return false;
    }
    paramObject = (GoalsReadRequest)paramObject;
    return (Objects.equal(zzlf, zzlf)) && (Objects.equal(zzrm, zzrm)) && (Objects.equal(zzno, zzno));
  }
  
  public List getActivityNames()
  {
    if (zzno.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzno.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(zzko.getName(((Integer)localIterator.next()).intValue()));
    }
    return localArrayList;
  }
  
  public List getDataTypes()
  {
    return zzlf;
  }
  
  public List getObjectiveTypes()
  {
    if (zzrm.isEmpty()) {
      return null;
    }
    return zzrm;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { zzlf, zzrm, getActivityNames() });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("dataTypes", zzlf).name("objectiveTypes", zzrm).name("activities", getActivityNames()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    Object localObject = zzrl;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 1, (IBinder)localObject, false);
    SafeParcelWriter.writeList(paramParcel, 2, getDataTypes(), false);
    SafeParcelWriter.writeList(paramParcel, 3, zzrm, false);
    SafeParcelWriter.writeList(paramParcel, 4, zzno, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private final List<DataType> zzlf = new ArrayList();
    private final List<Integer> zzno = new ArrayList();
    private final List<Integer> zzrm = new ArrayList();
    
    public Builder() {}
    
    public Builder addActivity(String paramString)
    {
      int i = zzko.findPosition(paramString);
      boolean bool;
      if (i != 4) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Attempting to add an unknown activity");
      Stack.add(Integer.valueOf(i), zzno);
      return this;
    }
    
    public Builder addDataType(DataType paramDataType)
    {
      Preconditions.checkNotNull(paramDataType, "Attempting to use a null data type");
      if (!zzlf.contains(paramDataType)) {
        zzlf.add(paramDataType);
      }
      return this;
    }
    
    public Builder addObjectiveType(int paramInt)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 2) {
          if (paramInt == 3) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
      Preconditions.checkState(bool1, "Attempting to add an invalid objective type");
      if (!zzrm.contains(Integer.valueOf(paramInt))) {
        zzrm.add(Integer.valueOf(paramInt));
      }
      return this;
    }
    
    public GoalsReadRequest build()
    {
      Preconditions.checkState(zzlf.isEmpty() ^ true, "At least one data type should be specified.");
      return new GoalsReadRequest(this, null);
    }
  }
}
