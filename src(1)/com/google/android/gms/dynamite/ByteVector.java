package com.google.android.gms.dynamite;

import android.content.Context;

final class ByteVector
  implements DynamiteModule.VersionPolicy.IVersions
{
  private final int b;
  
  public ByteVector(int paramInt1, int paramInt2)
  {
    b = paramInt1;
  }
  
  public final int b(Context paramContext, String paramString)
  {
    return b;
  }
  
  public final int b(Context paramContext, String paramString, boolean paramBoolean)
  {
    return 0;
  }
}
