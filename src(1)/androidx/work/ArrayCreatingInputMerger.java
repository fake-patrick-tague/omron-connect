package androidx.work;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ArrayCreatingInputMerger
  extends Attribute
{
  public ArrayCreatingInputMerger() {}
  
  private Object coerce(Object paramObject1, Object paramObject2)
  {
    Object localObject = Array.newInstance(paramObject1.getClass(), 2);
    Array.set(localObject, 0, paramObject1);
    Array.set(localObject, 1, paramObject2);
    return localObject;
  }
  
  private Object eval(Object paramObject1, Object paramObject2)
  {
    int i = Array.getLength(paramObject1);
    Object localObject = Array.newInstance(paramObject2.getClass(), i + 1);
    System.arraycopy(paramObject1, 0, localObject, 0, i);
    Array.set(localObject, i, paramObject2);
    return localObject;
  }
  
  private Object growIndexedProperty(Object paramObject1, Object paramObject2)
  {
    int i = Array.getLength(paramObject1);
    int j = Array.getLength(paramObject2);
    Object localObject = Array.newInstance(paramObject1.getClass().getComponentType(), i + j);
    System.arraycopy(paramObject1, 0, localObject, 0, i);
    System.arraycopy(paramObject2, 0, localObject, i, j);
    return localObject;
  }
  
  private Object unmarshal(Object paramObject)
  {
    Object localObject = Array.newInstance(paramObject.getClass(), 1);
    Array.set(localObject, 0, paramObject);
    return localObject;
  }
  
  public Label a(List paramList)
  {
    Item localItem = new Item();
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Label)localIterator1.next()).build().entrySet().iterator();
      while (localIterator2.hasNext())
      {
        paramList = (Map.Entry)localIterator2.next();
        String str = (String)paramList.getKey();
        Object localObject1 = paramList.getValue();
        paramList = localObject1;
        Class localClass = localObject1.getClass();
        Object localObject2 = localHashMap.get(str);
        if (localObject2 == null)
        {
          if (!localClass.isArray()) {
            paramList = unmarshal(localObject1);
          }
        }
        else
        {
          paramList = localObject2.getClass();
          if (paramList.equals(localClass))
          {
            if (paramList.isArray()) {
              paramList = growIndexedProperty(localObject2, localObject1);
            } else {
              paramList = coerce(localObject2, localObject1);
            }
          }
          else if ((paramList.isArray()) && (paramList.getComponentType().equals(localClass)))
          {
            paramList = eval(localObject2, localObject1);
          }
          else
          {
            if ((!localClass.isArray()) || (!localClass.getComponentType().equals(paramList))) {
              break label259;
            }
            paramList = eval(localObject1, localObject2);
          }
        }
        localHashMap.put(str, paramList);
      }
      continue;
      label259:
      throw new IllegalArgumentException();
    }
    localItem.add(localHashMap);
    return localItem.a();
  }
}
