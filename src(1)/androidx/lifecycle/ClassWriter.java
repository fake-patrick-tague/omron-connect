package androidx.lifecycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClassWriter
{
  private final HashMap<String, e0> m = new HashMap();
  
  public ClassWriter() {}
  
  final Label a(String paramString)
  {
    return (Label)m.get(paramString);
  }
  
  public final void a()
  {
    Iterator localIterator = m.values().iterator();
    while (localIterator.hasNext()) {
      ((Label)localIterator.next()).clear();
    }
    m.clear();
  }
  
  final void a(String paramString, Label paramLabel)
  {
    paramString = (Label)m.put(paramString, paramLabel);
    if (paramString != null) {
      paramString.onCleared();
    }
  }
  
  Set get()
  {
    return new HashSet(m.keySet());
  }
}
