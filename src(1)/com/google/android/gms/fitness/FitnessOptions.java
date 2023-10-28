package com.google.android.gms.fitness;

import android.os.Bundle;
import com.google.android.gms.auth.util.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class FitnessOptions
  implements GoogleSignInOptionsExtension
{
  public static final int ACCESS_READ = 0;
  public static final int ACCESS_WRITE = 1;
  private final Set<com.google.android.gms.common.api.Scope> zzkl;
  
  private FitnessOptions(Builder paramBuilder)
  {
    zzkl = Builder.getSoundPath(paramBuilder);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FitnessOptions)) {
      return false;
    }
    paramObject = (FitnessOptions)paramObject;
    return zzkl.equals(zzkl);
  }
  
  public final int getExtensionType()
  {
    return 3;
  }
  
  public final List getImpliedScopes()
  {
    return new ArrayList(zzkl);
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { zzkl });
  }
  
  public final Bundle toBundle()
  {
    return new Bundle();
  }
  
  public static final class Builder
  {
    private final Set<com.google.android.gms.common.api.Scope> zzkl = new HashSet();
    
    private Builder() {}
    
    public final Builder accessActivitySessions(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          zzkl.add(new com.google.android.gms.common.package_12.Scope("https://www.googleapis.com/auth/fitness.activity.write"));
          return this;
        }
        throw new IllegalArgumentException("valid access types are FitnessOptions.ACCESS_READ or FitnessOptions.ACCESS_WRITE");
      }
      zzkl.add(new com.google.android.gms.common.package_12.Scope("https://www.googleapis.com/auth/fitness.activity.read"));
      return this;
    }
    
    public final Builder accessSleepSessions(int paramInt)
    {
      boolean bool;
      if ((paramInt != 0) && (paramInt != 1)) {
        bool = false;
      } else {
        bool = true;
      }
      Preconditions.checkArgument(bool, "valid access types are FitnessOptions.ACCESS_READ or FitnessOptions.ACCESS_WRITE");
      if (paramInt == 0)
      {
        zzkl.add(new com.google.android.gms.common.package_12.Scope("https://www.googleapis.com/auth/fitness.sleep.read"));
        return this;
      }
      if (paramInt == 1) {
        zzkl.add(new com.google.android.gms.common.package_12.Scope("https://www.googleapis.com/auth/fitness.sleep.write"));
      }
      return this;
    }
    
    public final Builder addDataType(DataType paramDataType)
    {
      return addDataType(paramDataType, 0);
    }
    
    public final Builder addDataType(DataType paramDataType, int paramInt)
    {
      boolean bool;
      if ((paramInt != 0) && (paramInt != 1)) {
        bool = false;
      } else {
        bool = true;
      }
      Preconditions.checkArgument(bool, "valid access types are FitnessOptions.ACCESS_READ or FitnessOptions.ACCESS_WRITE");
      String str = paramDataType.getFolder();
      paramDataType = paramDataType.getDataType();
      if ((paramInt == 0) && (str != null))
      {
        zzkl.add(new com.google.android.gms.common.package_12.Scope(str));
        return this;
      }
      if ((paramInt == 1) && (paramDataType != null)) {
        zzkl.add(new com.google.android.gms.common.package_12.Scope(paramDataType));
      }
      return this;
    }
    
    public final FitnessOptions build()
    {
      return new FitnessOptions(this, null);
    }
  }
}
