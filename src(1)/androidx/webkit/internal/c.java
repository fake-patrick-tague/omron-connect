package androidx.webkit.internal;

import android.webkit.WebSettings;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.a.a;

public class c
{
  private final WebkitToCompatConverterBoundaryInterface h;
  
  public c(WebkitToCompatConverterBoundaryInterface paramWebkitToCompatConverterBoundaryInterface)
  {
    h = paramWebkitToCompatConverterBoundaryInterface;
  }
  
  public ByteVector a(WebSettings paramWebSettings)
  {
    return new ByteVector((WebSettingsBoundaryInterface)a.a(WebSettingsBoundaryInterface.class, h.convertSettings(paramWebSettings)));
  }
}
