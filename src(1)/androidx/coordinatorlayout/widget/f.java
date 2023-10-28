package androidx.coordinatorlayout.widget;

import c.e.g;
import c.h.p.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import v7.util.SimpleArrayMap;
import v7.v7.util.Pools.Pool;
import v7.v7.util.Pools.SimplePool;

public final class f<T>
{
  private final HashSet<T> a = new HashSet();
  private final ArrayList<T> k = new ArrayList();
  private final g<T, ArrayList<T>> m = new SimpleArrayMap();
  private final e<ArrayList<T>> w = new Pools.SimplePool(10);
  
  public f() {}
  
  private void add(Object paramObject, ArrayList paramArrayList, HashSet paramHashSet)
  {
    if (paramArrayList.contains(paramObject)) {
      return;
    }
    if (!paramHashSet.contains(paramObject))
    {
      paramHashSet.add(paramObject);
      ArrayList localArrayList = (ArrayList)m.get(paramObject);
      if (localArrayList != null)
      {
        int i = 0;
        int j = localArrayList.size();
        while (i < j)
        {
          add(localArrayList.get(i), paramArrayList, paramHashSet);
          i += 1;
        }
      }
      paramHashSet.remove(paramObject);
      paramArrayList.add(paramObject);
      return;
    }
    throw new RuntimeException("This graph contains cyclic dependencies");
  }
  
  private void clear(ArrayList paramArrayList)
  {
    paramArrayList.clear();
    w.release(paramArrayList);
  }
  
  private ArrayList size()
  {
    ArrayList localArrayList2 = (ArrayList)w.acquire();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    return localArrayList1;
  }
  
  public ArrayList a()
  {
    k.clear();
    a.clear();
    int j = m.size();
    int i = 0;
    while (i < j)
    {
      add(m.size(i), k, a);
      i += 1;
    }
    return k;
  }
  
  public boolean a(Object paramObject)
  {
    int j = m.size();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)m.get(i);
      if ((localArrayList != null) && (localArrayList.contains(paramObject))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void add(Object paramObject1, Object paramObject2)
  {
    if ((m.containsKey(paramObject1)) && (m.containsKey(paramObject2)))
    {
      ArrayList localArrayList2 = (ArrayList)m.get(paramObject1);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList2 = size();
        localArrayList1 = localArrayList2;
        m.put(paramObject1, localArrayList2);
      }
      localArrayList1.add(paramObject2);
      return;
    }
    throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
  }
  
  public boolean add(Object paramObject)
  {
    return m.containsKey(paramObject);
  }
  
  public void clear()
  {
    int j = m.size();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)m.get(i);
      if (localArrayList != null) {
        clear(localArrayList);
      }
      i += 1;
    }
    m.clear();
  }
  
  public List get(Object paramObject)
  {
    int j = m.size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)m.get(i);
      Object localObject2 = localObject1;
      if (localArrayList != null)
      {
        localObject2 = localObject1;
        if (localArrayList.contains(paramObject))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(m.size(i));
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public void put(Object paramObject)
  {
    if (!m.containsKey(paramObject)) {
      m.put(paramObject, null);
    }
  }
  
  public List removeAll(Object paramObject)
  {
    return (List)m.get(paramObject);
  }
}
