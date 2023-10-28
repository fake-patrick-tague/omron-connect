package com.braze.location;

import android.content.Context;
import com.braze.configuration.BrazeConfigurationProvider;
import java.util.EnumSet;
import kotlin.x.c.l;

public abstract interface IBrazeLocationApi
{
  public abstract void initWithContext(Context paramContext, EnumSet paramEnumSet, BrazeConfigurationProvider paramBrazeConfigurationProvider);
  
  public abstract boolean requestSingleLocationUpdate(l paramL);
}
