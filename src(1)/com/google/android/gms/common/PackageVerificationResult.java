package com.google.android.gms.common;

public class PackageVerificationResult
{
  private final String boardName;
  private final boolean context;
  private final String data;
  private final Throwable status;
  
  private PackageVerificationResult(String paramString1, int paramInt, boolean paramBoolean, String paramString2, Throwable paramThrowable)
  {
    boardName = paramString1;
    context = paramBoolean;
    data = paramString2;
    status = paramThrowable;
  }
  
  public static PackageVerificationResult addProperty(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return new PackageVerificationResult(paramString1, 1, false, paramString2, paramThrowable);
  }
  
  public static PackageVerificationResult readResource(String paramString, int paramInt)
  {
    return new PackageVerificationResult(paramString, paramInt, true, null, null);
  }
  
  public final boolean context()
  {
    return context;
  }
  
  public final void decode()
  {
    if (!context)
    {
      String str = "PackageVerificationRslt: ".concat(String.valueOf(data));
      Throwable localThrowable = status;
      if (localThrowable != null) {
        throw new SecurityException(str, localThrowable);
      }
      throw new SecurityException(str);
    }
  }
}
