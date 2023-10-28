package com.alivecor.asm;

import android.content.Context;

public class PackageManagerUtil
{
  private Context a;
  private h b;
  private MethodVisitor mPackageManager;
  private o mPackageName;
  
  public PackageManagerUtil(Context paramContext)
  {
    a = paramContext.getApplicationContext();
    b = new p(this);
    mPackageManager = new MethodAdapter(this);
    mPackageName = Quaternion.IDENTITY;
  }
  
  public PackageManagerUtil getInstance(MethodVisitor paramMethodVisitor)
  {
    mPackageManager = paramMethodVisitor;
    return this;
  }
  
  public PackageManagerUtil getInstance(h paramH)
  {
    b = paramH;
    return this;
  }
  
  public PackageManagerUtil getInstance(o paramO)
  {
    mPackageName = paramO;
    return this;
  }
  
  public void initialize()
  {
    b.c(this);
  }
}
