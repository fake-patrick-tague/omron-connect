package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.Set;

@RestrictedInheritance(allowedOnPath=".*java.*/com/google/android/gms/common/testing/.*", explanation="Sub classing of GMS Core's APIs are restricted to testing fakes.", link="go/gmscore-restrictedinheritance")
@KeepForSdk
@ShowFirstParty
public class GoogleSignatureVerifier
{
  private static GoogleSignatureVerifier _theInstance;
  private static volatile Set discardSet;
  private final Context mContext;
  private volatile String mResult;
  
  public GoogleSignatureVerifier(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
  }
  
  public static final boolean add(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (paramPackageInfo != null) {
        if (!"com.android.vending".equals(packageName))
        {
          bool = paramBoolean;
          if (!"com.google.android.gms".equals(packageName)) {}
        }
        else
        {
          ApplicationInfo localApplicationInfo = applicationInfo;
          if (localApplicationInfo == null) {}
          while ((flags & 0x81) == 0)
          {
            bool = false;
            break;
          }
          bool = true;
        }
      }
    }
    if ((paramPackageInfo != null) && (signatures != null))
    {
      if (bool) {
        paramPackageInfo = create(paramPackageInfo, i.c);
      } else {
        paramPackageInfo = create(paramPackageInfo, new Type[] { i.c[0] });
      }
      if (paramPackageInfo != null) {
        return true;
      }
    }
    return false;
  }
  
  static final Type create(PackageInfo paramPackageInfo, Type... paramVarArgs)
  {
    Signature[] arrayOfSignature = signatures;
    if (arrayOfSignature == null) {
      return null;
    }
    if (arrayOfSignature.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    paramPackageInfo = signatures;
    int i = 0;
    paramPackageInfo = new OmniPhoneNumber(paramPackageInfo[0].toByteArray());
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals(paramPackageInfo)) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    return null;
  }
  
  private final Headers get(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return Headers.get("null pkg");
    }
    if (!paramString.equals(mResult))
    {
      Object localObject1;
      if (Database.init()) {
        localObject1 = Database.set(paramString, GooglePlayServicesUtilLight.honorsDebugCertificates(mContext), false, false);
      } else {
        localObject1 = mContext;
      }
      try
      {
        localObject2 = ((Context)localObject1).getPackageManager().getPackageInfo(paramString, 64);
        paramBoolean1 = GooglePlayServicesUtilLight.honorsDebugCertificates(mContext);
        if (localObject2 == null)
        {
          localObject1 = Headers.get("null pkg");
        }
        else
        {
          localObject1 = signatures;
          if ((localObject1 != null) && (localObject1.length == 1))
          {
            OmniPhoneNumber localOmniPhoneNumber = new OmniPhoneNumber(signatures[0].toByteArray());
            String str = packageName;
            localObject1 = Database.get(str, localOmniPhoneNumber, paramBoolean1, false);
            if (this$0)
            {
              localObject2 = applicationInfo;
              if ((localObject2 != null) && ((flags & 0x2) != 0) && (getthis$0))
              {
                localObject1 = Headers.get("debuggable release cert app rejected");
                break label211;
              }
            }
          }
          else
          {
            localObject1 = Headers.get("single cert required");
          }
        }
        label211:
        localObject2 = localObject1;
        if (!this$0) {
          break label250;
        }
        mResult = paramString;
        return localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        return Headers.create("no pkg ".concat(paramString), localNameNotFoundException);
      }
    }
    Object localObject2 = Headers.get();
    label250:
    return localObject2;
  }
  
  public static GoogleSignatureVerifier getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    try
    {
      if (_theInstance == null)
      {
        Database.init(paramContext);
        _theInstance = new GoogleSignatureVerifier(paramContext);
      }
      return _theInstance;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public boolean isGooglePublicSignedPackage(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {
      return false;
    }
    if (add(paramPackageInfo, false)) {
      return true;
    }
    if (add(paramPackageInfo, true))
    {
      if (GooglePlayServicesUtilLight.honorsDebugCertificates(mContext)) {
        return true;
      }
      Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    }
    return false;
  }
  
  public boolean isPackageGoogleSigned(String paramString)
  {
    paramString = get(paramString, false, false);
    paramString.clear();
    return this$0;
  }
  
  public boolean isUidGoogleSigned(int paramInt)
  {
    String[] arrayOfString = mContext.getPackageManager().getPackagesForUid(paramInt);
    if (arrayOfString != null)
    {
      int i = arrayOfString.length;
      if (i != 0)
      {
        localObject = null;
        paramInt = 0;
        while (paramInt < i)
        {
          Headers localHeaders = get(arrayOfString[paramInt], false, false);
          localObject = localHeaders;
          if (this$0) {
            break label85;
          }
          paramInt += 1;
        }
        Preconditions.checkNotNull(localObject);
        break label85;
      }
    }
    Object localObject = Headers.get("no pkgs");
    label85:
    ((Headers)localObject).clear();
    return this$0;
  }
}
