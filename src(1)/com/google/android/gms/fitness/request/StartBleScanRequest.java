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
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcn;
import java.util.Collections;
import java.util.List;

@Deprecated
@SafeParcelable.Class(creator="StartBleScanRequestCreator")
@SafeParcelable.Reserved({5, 1000})
public class StartBleScanRequest
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new zzbh();
  @SafeParcelable.Field(getter="getDataTypes", id=1)
  private final List<DataType> zzlf;
  @SafeParcelable.Field(getter="getCallbackBinder", id=4, type="android.os.IBinder")
  private final zzcn zzql;
  @SafeParcelable.Field(getter="getBleScanCallbackBinder", id=2, type="android.os.IBinder")
  private final zzad zzsn;
  @SafeParcelable.Field(getter="getTimeoutSecs", id=3)
  private final int zzso;
  private final BleScanCallback zzsp;
  
  StartBleScanRequest(List paramList, IBinder paramIBinder1, int paramInt, IBinder paramIBinder2) {}
  
  private StartBleScanRequest(List paramList, BleScanCallback paramBleScanCallback, int paramInt)
  {
    zzlf = paramList;
    zzsn = null;
    zzso = paramInt;
    zzql = null;
    zzsp = paramBleScanCallback;
  }
  
  public StartBleScanRequest(List paramList, zzad paramZzad, int paramInt, zzcn paramZzcn)
  {
    zzlf = paramList;
    zzsn = paramZzad;
    zzso = paramInt;
    zzql = paramZzcn;
    zzsp = null;
  }
  
  public List getDataTypes()
  {
    return Collections.unmodifiableList(zzlf);
  }
  
  public int getTimeoutSecs()
  {
    return zzso;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).name("dataTypes", zzlf).name("timeoutSecs", Integer.valueOf(zzso)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getDataTypes(), false);
    Object localObject1 = zzsn;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject1, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getTimeoutSecs());
    localObject1 = zzql;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((IInterface)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)localObject1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final BleScanCallback zzaa()
  {
    return zzsp;
  }
  
  public static class Builder
  {
    private int zzso = 10;
    private DataType[] zzsq = new DataType[0];
    private BleScanCallback zzsr;
    
    public Builder() {}
    
    public StartBleScanRequest build()
    {
      boolean bool;
      if (zzsr != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Must set BleScanCallback");
      return new StartBleScanRequest(ArrayUtils.toArrayList(zzsq), zzsr, zzso, null);
    }
    
    public Builder setBleScanCallback(BleScanCallback paramBleScanCallback)
    {
      zzsr = paramBleScanCallback;
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      zzsq = paramVarArgs;
      return this;
    }
    
    public Builder setTimeoutSecs(int paramInt)
    {
      boolean bool2 = true;
      boolean bool1;
      if (paramInt > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Stop time must be greater than zero");
      if (paramInt <= 60) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Stop time must be less than 1 minute");
      zzso = paramInt;
      return this;
    }
  }
}
