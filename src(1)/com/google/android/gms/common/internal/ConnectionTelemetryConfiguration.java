package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@KeepForSdk
@SafeParcelable.Class(creator="ConnectionTelemetryConfigurationCreator")
public class ConnectionTelemetryConfiguration
  extends AbstractSafeParcelable
{
  @KeepForSdk
  public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new Point.1();
  @SafeParcelable.Field(getter="getRootTelemetryConfiguration", id=1)
  private final RootTelemetryConfiguration added;
  @SafeParcelable.Field(getter="getMethodInvocationTelemetryEnabled", id=2)
  private final boolean changed;
  @SafeParcelable.Field(getter="getMethodInvocationMethodKeyDisallowlist", id=6)
  private final int[] codepoints;
  @SafeParcelable.Field(getter="getMethodInvocationMethodKeyAllowlist", id=4)
  private final int[] path;
  @SafeParcelable.Field(getter="getMethodTimingTelemetryEnabled", id=3)
  private final boolean set;
  @SafeParcelable.Field(getter="getMaxMethodInvocationsLogged", id=5)
  private final int taskID;
  
  public ConnectionTelemetryConfiguration(RootTelemetryConfiguration paramRootTelemetryConfiguration, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    added = paramRootTelemetryConfiguration;
    changed = paramBoolean1;
    set = paramBoolean2;
    path = paramArrayOfInt1;
    taskID = paramInt;
    codepoints = paramArrayOfInt2;
  }
  
  public int getMaxMethodInvocationsLogged()
  {
    return taskID;
  }
  
  public int[] getMethodInvocationMethodKeyAllowlist()
  {
    return path;
  }
  
  public int[] getMethodInvocationMethodKeyDisallowlist()
  {
    return codepoints;
  }
  
  public boolean getMethodInvocationTelemetryEnabled()
  {
    return changed;
  }
  
  public boolean getMethodTimingTelemetryEnabled()
  {
    return set;
  }
  
  public final RootTelemetryConfiguration isAdded()
  {
    return added;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, added, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, getMethodInvocationTelemetryEnabled());
    SafeParcelWriter.writeBoolean(paramParcel, 3, getMethodTimingTelemetryEnabled());
    SafeParcelWriter.writeIntArray(paramParcel, 4, getMethodInvocationMethodKeyAllowlist(), false);
    SafeParcelWriter.writeInt(paramParcel, 5, getMaxMethodInvocationsLogged());
    SafeParcelWriter.writeIntArray(paramParcel, 6, getMethodInvocationMethodKeyDisallowlist(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
