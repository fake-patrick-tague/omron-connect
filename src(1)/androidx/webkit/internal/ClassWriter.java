package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

public class ClassWriter
  implements e
{
  private static final String[] pool = new String[0];
  
  public ClassWriter() {}
  
  public String[] get()
  {
    return pool;
  }
  
  public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter()
  {
    throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
  }
}
