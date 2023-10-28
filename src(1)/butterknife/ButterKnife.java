package butterknife;

import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife
{
  static final Map<Class<?>, Constructor<? extends Unbinder>> RESETTERS = new LinkedHashMap();
  
  private ButterKnife()
  {
    throw new AssertionError("No instances.");
  }
}
