package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.a.a;

public class Scope
  implements e
{
  WebViewProviderFactoryBoundaryInterface owner;
  
  public Scope(WebViewProviderFactoryBoundaryInterface paramWebViewProviderFactoryBoundaryInterface)
  {
    owner = paramWebViewProviderFactoryBoundaryInterface;
  }
  
  public String[] get()
  {
    return owner.getSupportedFeatures();
  }
  
  public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter()
  {
    return (WebkitToCompatConverterBoundaryInterface)a.a(WebkitToCompatConverterBoundaryInterface.class, owner.getWebkitToCompatConverter());
  }
}
