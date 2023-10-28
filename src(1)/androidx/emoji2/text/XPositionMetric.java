package androidx.emoji2.text;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;

public class XPositionMetric
  extends PositionMetric
{
  public XPositionMetric() {}
  
  public Signature[] getIcon(PackageManager paramPackageManager, String paramString)
    throws PackageManager.NameNotFoundException
  {
    return getPackageInfo64signatures;
  }
}
