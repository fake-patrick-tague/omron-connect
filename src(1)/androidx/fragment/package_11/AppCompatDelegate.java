package androidx.fragment.package_11;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class AppCompatDelegate
{
  public AppCompatDelegate() {}
  
  public abstract View findViewById(int paramInt);
  
  public Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    return Fragment.instantiate(paramContext, paramString, paramBundle);
  }
  
  public abstract boolean onHasView();
}
