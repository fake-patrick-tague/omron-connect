package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

public class ByteVector
{
  private WebSettingsBoundaryInterface b;
  
  public ByteVector(WebSettingsBoundaryInterface paramWebSettingsBoundaryInterface)
  {
    b = paramWebSettingsBoundaryInterface;
  }
  
  public void b(int paramInt)
  {
    b.setForceDark(paramInt);
  }
  
  public void putShort(int paramInt)
  {
    b.setForceDarkBehavior(paramInt);
  }
}
