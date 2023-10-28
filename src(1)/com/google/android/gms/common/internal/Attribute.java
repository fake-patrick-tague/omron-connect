package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;

public final class Attribute
{
  public final Set<Scope> name;
  
  public Attribute(Set paramSet)
  {
    Preconditions.checkNotNull(paramSet);
    name = Collections.unmodifiableSet(paramSet);
  }
}
