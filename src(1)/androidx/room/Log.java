package androidx.room;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.TreeMap;
import v7.td.data.Transaction;

public class Log
  implements Transaction, v7.td.data.Object
{
  static final TreeMap<Integer, k> this$0 = new TreeMap();
  final String[] data;
  private final int[] id;
  final double[] name;
  final long[] namespace;
  final byte[][] out;
  private volatile String t;
  final int timestamp;
  int y;
  
  private Log(int paramInt)
  {
    timestamp = paramInt;
    paramInt += 1;
    id = new int[paramInt];
    namespace = new long[paramInt];
    name = new double[paramInt];
    data = new String[paramInt];
    out = new byte[paramInt][];
  }
  
  public static Log get(String paramString, int paramInt)
  {
    Object localObject1 = this$0;
    try
    {
      Object localObject2 = ((TreeMap)localObject1).ceilingEntry(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        ((TreeMap)localObject1).remove(((Map.Entry)localObject2).getKey());
        localObject2 = (Log)((Map.Entry)localObject2).getValue();
        ((Log)localObject2).init(paramString, paramInt);
        return localObject2;
      }
      localObject1 = new Log(paramInt);
      ((Log)localObject1).init(paramString, paramInt);
      return localObject1;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  private static void log()
  {
    Object localObject = this$0;
    if (((TreeMap)localObject).size() > 15)
    {
      int i = ((TreeMap)localObject).size() - 10;
      localObject = ((TreeMap)localObject).descendingKeySet().iterator();
      while (i > 0)
      {
        ((Iterator)localObject).next();
        ((Iterator)localObject).remove();
        i -= 1;
      }
    }
  }
  
  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    id[paramInt] = 5;
    out[paramInt] = paramArrayOfByte;
  }
  
  public void bindDouble(int paramInt, double paramDouble)
  {
    id[paramInt] = 3;
    name[paramInt] = paramDouble;
  }
  
  public void bindLong(int paramInt, long paramLong)
  {
    id[paramInt] = 2;
    namespace[paramInt] = paramLong;
  }
  
  public void bindNull(int paramInt)
  {
    id[paramInt] = 1;
  }
  
  public void bindString(int paramInt, String paramString)
  {
    id[paramInt] = 4;
    data[paramInt] = paramString;
  }
  
  public void close() {}
  
  public int d()
  {
    return y;
  }
  
  public String e()
  {
    return t;
  }
  
  void init(String paramString, int paramInt)
  {
    t = paramString;
    y = paramInt;
  }
  
  public void insert(v7.td.data.Object paramObject)
  {
    int i = 1;
    while (i <= y)
    {
      int j = id[i];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5) {
                paramObject.bindBlob(i, out[i]);
              }
            }
            else {
              paramObject.bindString(i, data[i]);
            }
          }
          else {
            paramObject.bindDouble(i, name[i]);
          }
        }
        else {
          paramObject.bindLong(i, namespace[i]);
        }
      }
      else {
        paramObject.bindNull(i);
      }
      i += 1;
    }
  }
  
  public void release()
  {
    TreeMap localTreeMap = this$0;
    try
    {
      localTreeMap.put(Integer.valueOf(timestamp), this);
      log();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
