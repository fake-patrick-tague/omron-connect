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
import com.google.android.gms.internal.fitness.zzbg;
import com.google.android.gms.internal.fitness.zzbh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator="DataSourcesRequestCreator")
@SafeParcelable.Reserved({5, 1000})
public class DataSourcesRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new PaymentIntent.1();
  @SafeParcelable.Field(getter="getDataTypes", id=1)
  private final List<DataType> zzlf;
  @SafeParcelable.Field(getter="getDataSourceTypes", id=2)
  private final List<Integer> zzrg;
  @SafeParcelable.Field(getter="includeDbOnlySources", id=3)
  private final boolean zzrh;
  @SafeParcelable.Field(getter="getCallbackBinder", id=4, type="android.os.IBinder")
  private final zzbh zzri;
  
  private DataSourcesRequest(Builder paramBuilder)
  {
    this(Builder.getSoundPath(paramBuilder), Builder.getEWAHIterator(paramBuilder), false, null);
  }
  
  public DataSourcesRequest(DataSourcesRequest paramDataSourcesRequest, zzbh paramZzbh)
  {
    this(zzlf, zzrg, zzrh, paramZzbh);
  }
  
  DataSourcesRequest(List paramList1, List paramList2, boolean paramBoolean, IBinder paramIBinder)
  {
    zzlf = paramList1;
    zzrg = paramList2;
    zzrh = paramBoolean;
    if (paramIBinder == null) {
      paramList1 = null;
    } else {
      paramList1 = zzbg.asInterface(paramIBinder);
    }
    zzri = paramList1;
  }
  
  private DataSourcesRequest(List paramList1, List paramList2, boolean paramBoolean, zzbh paramZzbh)
  {
    zzlf = paramList1;
    zzrg = paramList2;
    zzrh = paramBoolean;
    zzri = paramZzbh;
  }
  
  public List getDataTypes()
  {
    return zzlf;
  }
  
  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this).name("dataTypes", zzlf).name("sourceTypes", zzrg);
    if (zzrh) {
      localToStringHelper.name("includeDbOnlySources", "true");
    }
    return localToStringHelper.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getDataTypes(), false);
    SafeParcelWriter.writeIntegerList(paramParcel, 2, zzrg, false);
    SafeParcelWriter.writeBoolean(paramParcel, 3, zzrh);
    Object localObject = zzri;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((IInterface)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private List<DataType> zzlf = new ArrayList();
    private List<Integer> zzrg = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
    private boolean zzrh = false;
    
    public Builder() {}
    
    public DataSourcesRequest build()
    {
      Preconditions.checkState(zzlf.isEmpty() ^ true, "Must add at least one data type");
      Preconditions.checkState(zzrg.isEmpty() ^ true, "Must add at least one data source type");
      return new DataSourcesRequest(this, null);
    }
    
    public Builder setDataSourceTypes(int... paramVarArgs)
    {
      zzrg = new ArrayList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        int k = paramVarArgs[i];
        zzrg.add(Integer.valueOf(k));
        i += 1;
      }
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      zzlf = Arrays.asList(paramVarArgs);
      return this;
    }
  }
}
