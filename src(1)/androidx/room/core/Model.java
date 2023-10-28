package androidx.room.core;

import android.database.Cursor;
import androidx.room.q.f;
import androidx.room.q.f.a;
import androidx.room.q.f.b;
import androidx.room.q.f.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import v7.td.data.Context;

public class Model
{
  public final String id;
  public final Set<f.b> name;
  public final Map<String, f.a> parameters;
  public final Set<f.d> set;
  
  public Model(String paramString, Map paramMap, Set paramSet1, Set paramSet2)
  {
    id = paramString;
    parameters = Collections.unmodifiableMap(paramMap);
    name = Collections.unmodifiableSet(paramSet1);
    if (paramSet2 == null) {
      paramString = null;
    } else {
      paramString = Collections.unmodifiableSet(paramSet2);
    }
    set = paramString;
  }
  
  private static Map fromCursor(Context paramContext, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PRAGMA table_info(`");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("`)");
    paramContext = paramContext.query(((StringBuilder)localObject).toString());
    paramString = new HashMap();
    try
    {
      int i = paramContext.getColumnCount();
      if (i > 0)
      {
        i = paramContext.getColumnIndex("name");
        int j = paramContext.getColumnIndex("type");
        int k = paramContext.getColumnIndex("notnull");
        int m = paramContext.getColumnIndex("pk");
        int n = paramContext.getColumnIndex("dflt_value");
        for (;;)
        {
          boolean bool = paramContext.moveToNext();
          if (!bool) {
            break;
          }
          localObject = paramContext.getString(i);
          String str = paramContext.getString(j);
          int i1 = paramContext.getInt(k);
          if (i1 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          paramString.put(localObject, new Label((String)localObject, str, bool, paramContext.getInt(m), paramContext.getString(n), 2));
        }
      }
      paramContext.close();
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramContext.close();
      throw paramString;
    }
  }
  
  public static Model get(Context paramContext, String paramString)
  {
    return new Model(paramString, fromCursor(paramContext, paramString), getAll(paramContext, paramString), load(paramContext, paramString));
  }
  
  private static List getAll(Cursor paramCursor)
  {
    int j = paramCursor.getColumnIndex("id");
    int k = paramCursor.getColumnIndex("seq");
    int m = paramCursor.getColumnIndex("from");
    int n = paramCursor.getColumnIndex("to");
    int i1 = paramCursor.getCount();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < i1)
    {
      paramCursor.moveToPosition(i);
      localArrayList.add(new Target(paramCursor.getInt(j), paramCursor.getInt(k), paramCursor.getString(m), paramCursor.getString(n)));
      i += 1;
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  private static Set getAll(Context paramContext, String paramString)
  {
    HashSet localHashSet = new HashSet();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PRAGMA foreign_key_list(`");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("`)");
    paramContext = paramContext.query(((StringBuilder)localObject).toString());
    try
    {
      int j = paramContext.getColumnIndex("id");
      int k = paramContext.getColumnIndex("seq");
      int m = paramContext.getColumnIndex("table");
      int n = paramContext.getColumnIndex("on_delete");
      int i1 = paramContext.getColumnIndex("on_update");
      paramString = getAll(paramContext);
      int i2 = paramContext.getCount();
      int i = 0;
      while (i < i2)
      {
        paramContext.moveToPosition(i);
        int i3 = paramContext.getInt(k);
        if (i3 == 0)
        {
          i3 = paramContext.getInt(j);
          localObject = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = paramString.iterator();
          for (;;)
          {
            boolean bool = localIterator.hasNext();
            if (!bool) {
              break;
            }
            Target localTarget = (Target)localIterator.next();
            int i4 = length;
            if (i4 == i3)
            {
              ((List)localObject).add(name);
              localArrayList.add(values);
            }
          }
          localHashSet.add(new Segment(paramContext.getString(m), paramContext.getString(n), paramContext.getString(i1), (List)localObject, localArrayList));
        }
        i += 1;
      }
      paramContext.close();
      return localHashSet;
    }
    catch (Throwable paramString)
    {
      paramContext.close();
      throw paramString;
    }
  }
  
  private static Filter load(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PRAGMA index_xinfo(`");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("`)");
    paramContext = paramContext.query(((StringBuilder)localObject).toString());
    try
    {
      int i = paramContext.getColumnIndex("seqno");
      int j = paramContext.getColumnIndex("cid");
      int k = paramContext.getColumnIndex("name");
      if ((i != -1) && (j != -1) && (k != -1))
      {
        localObject = new TreeMap();
        for (;;)
        {
          boolean bool = paramContext.moveToNext();
          if (!bool) {
            break;
          }
          int m = paramContext.getInt(j);
          if (m >= 0) {
            ((TreeMap)localObject).put(Integer.valueOf(paramContext.getInt(i)), paramContext.getString(k));
          }
        }
        ArrayList localArrayList = new ArrayList(((TreeMap)localObject).size());
        localArrayList.addAll(((TreeMap)localObject).values());
        paramString = new Filter(paramString, paramBoolean, localArrayList);
        paramContext.close();
        return paramString;
      }
      paramContext.close();
      return null;
    }
    catch (Throwable paramString)
    {
      paramContext.close();
      throw paramString;
    }
  }
  
  private static Set load(Context paramContext, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("PRAGMA index_list(`");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("`)");
    paramString = paramContext.query(((StringBuilder)localObject1).toString());
    try
    {
      int i = paramString.getColumnIndex("name");
      int j = paramString.getColumnIndex("origin");
      int k = paramString.getColumnIndex("unique");
      if ((i != -1) && (j != -1) && (k != -1))
      {
        localObject1 = new HashSet();
        for (;;)
        {
          boolean bool = paramString.moveToNext();
          if (!bool) {
            break;
          }
          Object localObject2 = paramString.getString(j);
          bool = "c".equals(localObject2);
          if (bool)
          {
            localObject2 = paramString.getString(i);
            int m = paramString.getInt(k);
            bool = true;
            if (m != 1) {
              bool = false;
            }
            localObject2 = load(paramContext, (String)localObject2, bool);
            if (localObject2 == null)
            {
              paramString.close();
              return null;
            }
            ((HashSet)localObject1).add(localObject2);
          }
        }
        paramString.close();
        return localObject1;
      }
      paramString.close();
      return null;
    }
    catch (Throwable paramContext)
    {
      paramString.close();
      throw paramContext;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (f.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (Model)paramObject;
      Object localObject = id;
      if (localObject != null)
      {
        if (!((String)localObject).equals(id)) {
          return false;
        }
      }
      else if (id != null) {
        return false;
      }
      localObject = parameters;
      if (localObject != null)
      {
        if (!((Map)localObject).equals(parameters)) {
          return false;
        }
      }
      else if (parameters != null) {
        return false;
      }
      localObject = name;
      if (localObject != null)
      {
        if (!((Set)localObject).equals(name)) {
          return false;
        }
      }
      else if (name != null) {
        return false;
      }
      localObject = set;
      if (localObject != null)
      {
        paramObject = set;
        if (paramObject == null) {
          return true;
        }
        return ((Set)localObject).equals(paramObject);
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = id;
    int k = 0;
    int i;
    if (localObject != null) {
      i = ((String)localObject).hashCode();
    } else {
      i = 0;
    }
    localObject = parameters;
    int j;
    if (localObject != null) {
      j = ((Map)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = name;
    if (localObject != null) {
      k = ((Set)localObject).hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TableInfo{name='");
    localStringBuilder.append(id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", columns=");
    localStringBuilder.append(parameters);
    localStringBuilder.append(", foreignKeys=");
    localStringBuilder.append(name);
    localStringBuilder.append(", indices=");
    localStringBuilder.append(set);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
