package androidx.core.content.diff;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;

class a
{
  static boolean addShortcut(PackageManager paramPackageManager, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    return paramPackageManager.hasSigningCertificate(paramString, paramArrayOfByte, paramInt);
  }
  
  static Signature[] available(SigningInfo paramSigningInfo)
  {
    return paramSigningInfo.getSigningCertificateHistory();
  }
  
  static Signature[] getIntent(SigningInfo paramSigningInfo)
  {
    return paramSigningInfo.getApkContentsSigners();
  }
  
  static boolean onKeyShortcut(SigningInfo paramSigningInfo)
  {
    return paramSigningInfo.hasMultipleSigners();
  }
  
  static long read(PackageInfo paramPackageInfo)
  {
    return paramPackageInfo.getLongVersionCode();
  }
}
