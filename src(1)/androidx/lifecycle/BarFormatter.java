package androidx.lifecycle;

import java.util.LinkedHashMap;
import java.util.Map;

public final class BarFormatter
  extends Label
{
  private final Map<String, x> a = new LinkedHashMap();
  
  public BarFormatter() {}
  
  public final Map getFillPaint()
  {
    return a;
  }
}
