package androidx.lifecycle.xy;

import java.util.Map;
import kotlin.x.d.i;

public final class PositionMetric
  extends a
{
  public PositionMetric()
  {
    this(null, 1, null);
  }
  
  public PositionMetric(a paramA)
  {
    getValue().putAll(paramA.getValue());
  }
  
  public Object a(Paint paramPaint)
  {
    i.e(paramPaint, "key");
    return getValue().get(paramPaint);
  }
  
  public final void a(Paint paramPaint, Object paramObject)
  {
    i.e(paramPaint, "key");
    getValue().put(paramPaint, paramObject);
  }
}
