package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="ResolveAccountResponseCreator")
public final class Task
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zav> CREATOR = new AccountMirakel.2();
  @SafeParcelable.Field(getter="isFromCrossClientAuth", id=5)
  private final boolean active;
  @SafeParcelable.Field(getter="getConnectionResult", id=3)
  private final ConnectionResult added;
  @SafeParcelable.VersionField(id=1)
  final int due;
  @SafeParcelable.Field(id=2)
  final IBinder hasDueTime;
  @SafeParcelable.Field(getter="getSaveDefaultAccount", id=4)
  private final boolean running;
  
  Task(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    due = paramInt;
    hasDueTime = paramIBinder;
    added = paramConnectionResult;
    running = paramBoolean1;
    active = paramBoolean2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Task)) {
      return false;
    }
    paramObject = (Task)paramObject;
    return (added.equals(added)) && (Objects.equal(get(), paramObject.get()));
  }
  
  public final IAccountAccessor get()
  {
    IBinder localIBinder = hasDueTime;
    if (localIBinder == null) {
      return null;
    }
    return IAccountAccessor.Stub.asInterface(localIBinder);
  }
  
  public final ConnectionResult getLongitude()
  {
    return added;
  }
  
  public final boolean isActive()
  {
    return active;
  }
  
  public final boolean isRunning()
  {
    return running;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, due);
    SafeParcelWriter.writeIBinder(paramParcel, 2, hasDueTime, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, added, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, running);
    SafeParcelWriter.writeBoolean(paramParcel, 5, active);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}
