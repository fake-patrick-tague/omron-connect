package androidx.room;

import android.database.sqlite.SQLiteException;
import c.b.a.b.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import v7.support.v7.asm.f;
import v7.td.data.Item;

public class i
{
  private static final String[] m = { "UPDATE", "DELETE", "INSERT" };
  final RoomDatabase a;
  final b<f.c, f.d> b;
  AtomicBoolean c;
  Runnable d;
  final String[] data;
  volatile Item g;
  final HashMap<String, Integer> h;
  private final FavoritesService i;
  private volatile boolean l;
  private Label p;
  private NumberPicker r;
  private Map<String, Set<String>> this$0;
  
  public i(RoomDatabase paramRoomDatabase, Map paramMap1, Map paramMap2, String... paramVarArgs)
  {
    int j = 0;
    c = new AtomicBoolean(false);
    l = false;
    b = new f();
    d = new Connection(this);
    a = paramRoomDatabase;
    p = new Label(paramVarArgs.length);
    h = new HashMap();
    this$0 = paramMap2;
    i = new FavoritesService(paramRoomDatabase);
    int k = paramVarArgs.length;
    data = new String[k];
    while (j < k)
    {
      paramMap2 = paramVarArgs[j];
      paramRoomDatabase = Locale.US;
      paramMap2 = paramMap2.toLowerCase(paramRoomDatabase);
      h.put(paramMap2, Integer.valueOf(j));
      String str = (String)paramMap1.get(paramVarArgs[j]);
      if (str != null) {
        data[j] = str.toLowerCase(paramRoomDatabase);
      } else {
        data[j] = paramMap2;
      }
      j += 1;
    }
    paramRoomDatabase = paramMap1.entrySet().iterator();
    while (paramRoomDatabase.hasNext())
    {
      paramMap2 = (Map.Entry)paramRoomDatabase.next();
      paramMap1 = (String)paramMap2.getValue();
      paramVarArgs = Locale.US;
      paramMap1 = paramMap1.toLowerCase(paramVarArgs);
      if (h.containsKey(paramMap1))
      {
        paramMap2 = ((String)paramMap2.getKey()).toLowerCase(paramVarArgs);
        paramVarArgs = h;
        paramVarArgs.put(paramMap2, paramVarArgs.get(paramMap1));
      }
    }
  }
  
  private String[] add(String[] paramArrayOfString)
  {
    HashSet localHashSet = new HashSet();
    int k = paramArrayOfString.length;
    int j = 0;
    while (j < k)
    {
      String str1 = paramArrayOfString[j];
      String str2 = str1.toLowerCase(Locale.US);
      if (this$0.containsKey(str2)) {
        localHashSet.addAll((Collection)this$0.get(str2));
      } else {
        localHashSet.add(str1);
      }
      j += 1;
    }
    return (String[])localHashSet.toArray(new String[localHashSet.size()]);
  }
  
  private static void append(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("`");
    paramStringBuilder.append("room_table_modification_trigger_");
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append("_");
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append("`");
  }
  
  private void clear(v7.td.data.Context paramContext, int paramInt)
  {
    String str1 = data[paramInt];
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = m;
    int j = arrayOfString.length;
    paramInt = 0;
    while (paramInt < j)
    {
      String str2 = arrayOfString[paramInt];
      localStringBuilder.setLength(0);
      localStringBuilder.append("DROP TRIGGER IF EXISTS ");
      append(localStringBuilder, str1, str2);
      paramContext.execSQL(localStringBuilder.toString());
      paramInt += 1;
    }
  }
  
  private void print(v7.td.data.Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("INSERT OR IGNORE INTO room_table_modification_log VALUES(");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", 0)");
    paramContext.execSQL(((StringBuilder)localObject).toString());
    localObject = data[paramInt];
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = m;
    int k = arrayOfString.length;
    int j = 0;
    while (j < k)
    {
      String str = arrayOfString[j];
      localStringBuilder.setLength(0);
      localStringBuilder.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
      append(localStringBuilder, (String)localObject, str);
      localStringBuilder.append(" AFTER ");
      localStringBuilder.append(str);
      localStringBuilder.append(" ON `");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("` BEGIN UPDATE ");
      localStringBuilder.append("room_table_modification_log");
      localStringBuilder.append(" SET ");
      localStringBuilder.append("invalidated");
      localStringBuilder.append(" = 1");
      localStringBuilder.append(" WHERE ");
      localStringBuilder.append("table_id");
      localStringBuilder.append(" = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" AND ");
      localStringBuilder.append("invalidated");
      localStringBuilder.append(" = 0");
      localStringBuilder.append("; END");
      paramContext.execSQL(localStringBuilder.toString());
      j += 1;
    }
  }
  
  void a()
  {
    if (!a.write()) {
      return;
    }
    add(a.getParent().getWritableDatabase());
  }
  
  void a(android.content.Context paramContext, String paramString)
  {
    r = new NumberPicker(paramContext, paramString, this, a.e());
  }
  
  public void a(d paramD)
  {
    Object localObject1 = add(m);
    int[] arrayOfInt = new int[localObject1.length];
    int k = localObject1.length;
    int j = 0;
    while (j < k)
    {
      localObject2 = (Integer)h.get(localObject1[j].toLowerCase(Locale.US));
      if (localObject2 != null)
      {
        arrayOfInt[j] = ((Integer)localObject2).intValue();
        j += 1;
      }
      else
      {
        paramD = new StringBuilder();
        paramD.append("There is no table with name ");
        paramD.append(localObject1[j]);
        throw new IllegalArgumentException(paramD.toString());
      }
    }
    Object localObject2 = new h(paramD, arrayOfInt, (String[])localObject1);
    localObject1 = b;
    try
    {
      paramD = (h)b.b(paramD, localObject2);
      if ((paramD == null) && (p.draw(arrayOfInt)))
      {
        a();
        return;
      }
    }
    catch (Throwable paramD)
    {
      throw paramD;
    }
  }
  
  void a(v7.td.data.Context paramContext)
  {
    try
    {
      if (l)
      {
        android.util.Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
        return;
      }
      paramContext.execSQL("PRAGMA temp_store = MEMORY;");
      paramContext.execSQL("PRAGMA recursive_triggers='ON';");
      paramContext.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
      add(paramContext);
      g = paramContext.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
      l = true;
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public void a(String... paramVarArgs)
  {
    f localF = b;
    try
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!((d)localEntry.getKey()).b()) {
          ((h)localEntry.getValue()).a(paramVarArgs);
        }
      }
      return;
    }
    catch (Throwable paramVarArgs)
    {
      throw paramVarArgs;
    }
  }
  
  void add(v7.td.data.Context paramContext)
  {
    if (paramContext.inTransaction()) {
      return;
    }
    for (;;)
    {
      Object localObject = a;
      try
      {
        localObject = ((RoomDatabase)localObject).containsKey();
        ((Lock)localObject).lock();
        try
        {
          int[] arrayOfInt = p.a();
          if (arrayOfInt == null)
          {
            ((Lock)localObject).unlock();
            return;
          }
          int k = arrayOfInt.length;
          paramContext.beginTransaction();
          int j = 0;
          for (;;)
          {
            if (j < k)
            {
              int n = arrayOfInt[j];
              if ((n != 1) && (n != 2)) {}
            }
            try
            {
              clear(paramContext, j);
              break label105;
              print(paramContext, j);
              label105:
              j += 1;
            }
            catch (Throwable localThrowable)
            {
              paramContext.endTransaction();
              throw localThrowable;
            }
          }
          paramContext.setTransactionSuccessful();
          paramContext.endTransaction();
          p.next();
          ((Lock)localObject).unlock();
        }
        catch (Throwable paramContext)
        {
          ((Lock)localObject).unlock();
          throw paramContext;
        }
        android.util.Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", (Throwable)paramContext);
      }
      catch (SQLiteException paramContext) {}catch (IllegalStateException paramContext) {}
    }
  }
  
  boolean add()
  {
    if (!a.write()) {
      return false;
    }
    if (!l) {
      a.getParent().getWritableDatabase();
    }
    if (!l)
    {
      android.util.Log.e("ROOM", "database is not initialized even though it is open");
      return false;
    }
    return true;
  }
  
  public void b(d paramD)
  {
    f localF = b;
    try
    {
      paramD = (h)b.a(paramD);
      if ((paramD != null) && (p.a(a)))
      {
        a();
        return;
      }
    }
    catch (Throwable paramD)
    {
      throw paramD;
    }
  }
  
  public void clear()
  {
    if (c.compareAndSet(false, true)) {
      a.e().execute(d);
    }
  }
}
