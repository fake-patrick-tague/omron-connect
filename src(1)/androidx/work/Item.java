package androidx.work;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Item
{
  private Map<String, Object> c = new HashMap();
  
  public Item() {}
  
  public Item a(Label paramLabel)
  {
    add(values);
    return this;
  }
  
  public Item a(String paramString1, String paramString2)
  {
    c.put(paramString1, paramString2);
    return this;
  }
  
  public Label a()
  {
    Label localLabel = new Label(c);
    Label.write(localLabel);
    return localLabel;
  }
  
  public Item add(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      get((String)localEntry.getKey(), localEntry.getValue());
    }
    return this;
  }
  
  public Item get(String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      c.put(paramString, null);
      return this;
    }
    Class localClass = paramObject.getClass();
    if ((localClass != Boolean.class) && (localClass != Byte.class) && (localClass != Integer.class) && (localClass != Long.class) && (localClass != Float.class) && (localClass != Double.class) && (localClass != String.class) && (localClass != [Ljava.lang.Boolean.class) && (localClass != [Ljava.lang.Byte.class) && (localClass != [Ljava.lang.Integer.class) && (localClass != [Ljava.lang.Long.class) && (localClass != [Ljava.lang.Float.class) && (localClass != [Ljava.lang.Double.class) && (localClass != [Ljava.lang.String.class))
    {
      if (localClass == [Z.class)
      {
        c.put(paramString, Label.toObject((boolean[])paramObject));
        return this;
      }
      if (localClass == [B.class)
      {
        c.put(paramString, Label.valueOf((byte[])paramObject));
        return this;
      }
      if (localClass == [I.class)
      {
        c.put(paramString, Label.toObject((int[])paramObject));
        return this;
      }
      if (localClass == [J.class)
      {
        c.put(paramString, Label.toObject((long[])paramObject));
        return this;
      }
      if (localClass == [F.class)
      {
        c.put(paramString, Label.toObject((float[])paramObject));
        return this;
      }
      if (localClass == [D.class)
      {
        c.put(paramString, Label.toObject((double[])paramObject));
        return this;
      }
      throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[] { paramString, localClass }));
    }
    c.put(paramString, paramObject);
    return this;
  }
}
