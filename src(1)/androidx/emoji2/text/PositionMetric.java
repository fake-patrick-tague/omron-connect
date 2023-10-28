package androidx.emoji2.text;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import java.util.List;

public class PositionMetric
  extends a
{
  public PositionMetric() {}
  
  public ProviderInfo getValue(ResolveInfo paramResolveInfo)
  {
    return providerInfo;
  }
  
  public List getValue(PackageManager paramPackageManager, Intent paramIntent, int paramInt)
  {
    return paramPackageManager.queryIntentContentProviders(paramIntent, paramInt);
  }
}
