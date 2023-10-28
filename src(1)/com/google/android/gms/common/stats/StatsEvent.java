package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
@KeepForSdk
public abstract class StatsEvent
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public StatsEvent() {}
  
  public abstract int getPath();
  
  public abstract String getString();
  
  public abstract long getTokenIndex();
  
  public abstract long path();
  
  public final String toString()
  {
    long l1 = path();
    int i = getPath();
    long l2 = getTokenIndex();
    String str = getString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1);
    localStringBuilder.append("\t");
    localStringBuilder.append(i);
    localStringBuilder.append("\t");
    localStringBuilder.append(l2);
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  @KeepForSdk
  public static abstract interface Types
  {
    @KeepForSdk
    public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
    @KeepForSdk
    public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
  }
}
