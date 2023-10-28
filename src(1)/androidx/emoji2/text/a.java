package androidx.emoji2.text;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import java.util.Collections;
import java.util.List;

public class a
{
  public a() {}
  
  public Signature[] getIcon(PackageManager paramPackageManager, String paramString)
    throws PackageManager.NameNotFoundException
  {
    return getPackageInfo64signatures;
  }
  
  public ProviderInfo getValue(ResolveInfo paramResolveInfo)
  {
    throw new IllegalStateException("Unable to get provider info prior to API 19");
  }
  
  public List getValue(PackageManager paramPackageManager, Intent paramIntent, int paramInt)
  {
    return Collections.emptyList();
  }
}
