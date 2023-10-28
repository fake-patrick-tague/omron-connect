package androidx.core.package_10;

import android.content.res.Configuration;

public final class Fragment
{
  private final boolean mFragmentManager;
  private final Configuration mTag;
  
  public Fragment(boolean paramBoolean)
  {
    mFragmentManager = paramBoolean;
    mTag = null;
  }
  
  public Fragment(boolean paramBoolean, Configuration paramConfiguration)
  {
    mFragmentManager = paramBoolean;
    mTag = paramConfiguration;
  }
  
  public boolean getFragmentManager()
  {
    return mFragmentManager;
  }
}
