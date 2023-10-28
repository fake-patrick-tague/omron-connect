package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath=".*javatests.*/com/google/android/gms/common/.*", explanation="Sub classing of GMS Core's APIs are restricted to testing fakes.", link="go/gmscore-restrictedinheritance")
@KeepForSdk
@ShowFirstParty
public class PackageSignatureVerifier
{
  private static zzad sHandler;
  private volatile zzac this$0;
  
  public PackageSignatureVerifier() {}
  
  private static zzad getHandler()
  {
    try
    {
      if (sHandler == null) {
        sHandler = new zzad();
      }
      zzad localZzad = sHandler;
      return localZzad;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public PackageVerificationResult queryPackageSignatureVerified(Context paramContext, String paramString)
  {
    boolean bool = GooglePlayServicesUtilLight.honorsDebugCertificates(paramContext);
    getHandler();
    if (Database.run())
    {
      if (true != bool) {
        paramContext = "-0";
      } else {
        paramContext = "-1";
      }
      paramContext = String.valueOf(paramString).concat(paramContext);
      if ((this$0 != null) && (zzac.access$getFragment(this$0).equals(paramContext))) {
        return zzac.access$getUpdater(this$0);
      }
      getHandler();
      Headers localHeaders = Database.getAll(paramString, bool, false, false);
      if (this$0)
      {
        this$0 = new zzac(paramContext, PackageVerificationResult.readResource(paramString, mContext));
        return zzac.access$getUpdater(this$0);
      }
      Preconditions.checkNotNull(mId);
      return PackageVerificationResult.addProperty(paramString, mId, mName);
    }
    throw new zzae();
  }
  
  public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context paramContext, String paramString)
  {
    try
    {
      PackageVerificationResult localPackageVerificationResult = queryPackageSignatureVerified(paramContext, paramString);
      localPackageVerificationResult.decode();
      return localPackageVerificationResult;
    }
    catch (SecurityException localSecurityException)
    {
      paramContext = queryPackageSignatureVerified(paramContext, paramString);
      if (paramContext.context()) {
        Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", localSecurityException);
      }
    }
    return paramContext;
  }
}
