package androidx.room;

import android.app.ActivityManager;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Looper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import v7.support.v7.util.f;
import v7.td.data.Paint;
import v7.td.data.Transaction;
import v7.td.data.service.Type;

public abstract class RoomDatabase
{
  private final i a = getInstance();
  private boolean b;
  private final Map<String, Object> books = new ConcurrentHashMap();
  @Deprecated
  protected List<b> c;
  boolean d;
  private Executor g;
  private Executor l;
  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  @Deprecated
  protected volatile v7.td.data.Context parent;
  private final ThreadLocal<Integer> random = new ThreadLocal();
  private v7.td.data.Log this$0;
  
  public RoomDatabase() {}
  
  private static boolean get()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public void a(a paramA)
  {
    v7.td.data.Log localLog = b(paramA);
    this$0 = localLog;
    if ((localLog instanceof SQLiteAssetHelper)) {
      ((SQLiteAssetHelper)localLog).close(paramA);
    }
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = false;
    if (i >= 16)
    {
      bool1 = bool2;
      if (h == JournalMode.h) {
        bool1 = true;
      }
      this$0.setWriteAheadLoggingEnabled(bool1);
    }
    c = e;
    g = g;
    l = new SerializingExecutor(p);
    b = a;
    d = bool1;
    if (i) {
      a.a(r, s);
    }
  }
  
  public void add()
  {
    removeFirst();
    v7.td.data.Context localContext = this$0.getWritableDatabase();
    a.add(localContext);
    localContext.beginTransaction();
  }
  
  protected abstract v7.td.data.Log b(a paramA);
  
  protected void b(v7.td.data.Context paramContext)
  {
    a.a(paramContext);
  }
  
  public void clear()
  {
    this$0.getWritableDatabase().endTransaction();
    if (!close()) {
      a.clear();
    }
  }
  
  public boolean close()
  {
    return this$0.getWritableDatabase().inTransaction();
  }
  
  Lock containsKey()
  {
    return lock.readLock();
  }
  
  public Executor e()
  {
    return g;
  }
  
  public v7.td.data.Item get(String paramString)
  {
    removeFirst();
    size();
    return this$0.getWritableDatabase().compileStatement(paramString);
  }
  
  protected abstract i getInstance();
  
  public v7.td.data.Log getParent()
  {
    return this$0;
  }
  
  public Cursor query(Transaction paramTransaction)
  {
    return query(paramTransaction, null);
  }
  
  public Cursor query(Transaction paramTransaction, CancellationSignal paramCancellationSignal)
  {
    removeFirst();
    size();
    if ((paramCancellationSignal != null) && (Build.VERSION.SDK_INT >= 16)) {
      return this$0.getWritableDatabase().query(paramTransaction, paramCancellationSignal);
    }
    return this$0.getWritableDatabase().query(paramTransaction);
  }
  
  public void remove()
  {
    this$0.getWritableDatabase().setTransactionSuccessful();
  }
  
  public void removeFirst()
  {
    if (b) {
      return;
    }
    if (!get()) {
      return;
    }
    throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
  }
  
  public void size()
  {
    if (!close())
    {
      if (random.get() == null) {
        return;
      }
      throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }
  }
  
  public boolean write()
  {
    v7.td.data.Context localContext = parent;
    return (localContext != null) && (localContext.isOpen());
  }
  
  public static enum JournalMode
  {
    static
    {
      JournalMode localJournalMode1 = new JournalMode("AUTOMATIC", 0);
      b = localJournalMode1;
      JournalMode localJournalMode2 = new JournalMode("TRUNCATE", 1);
      d = localJournalMode2;
      JournalMode localJournalMode3 = new JournalMode("WRITE_AHEAD_LOGGING", 2);
      h = localJournalMode3;
      a = new JournalMode[] { localJournalMode1, localJournalMode2, localJournalMode3 };
    }
    
    private static boolean isLowRamDevice(ActivityManager paramActivityManager)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        return paramActivityManager.isLowRamDevice();
      }
      return false;
    }
    
    JournalMode a(android.content.Context paramContext)
    {
      if (this != b) {
        return this;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramContext = (ActivityManager)paramContext.getSystemService("activity");
        if ((paramContext != null) && (!isLowRamDevice(paramContext))) {
          return h;
        }
      }
      return d;
    }
  }
  
  public static class a<T extends RoomDatabase>
  {
    private Executor a;
    private RoomDatabase.JournalMode b;
    private final Class<T> c;
    private File d;
    private boolean f;
    private final String g;
    private boolean h;
    private Executor i;
    private final android.content.Context j;
    private ArrayList<RoomDatabase.b> k;
    private boolean l;
    private final RoomDatabase.c m;
    private boolean o;
    private Set<Integer> p;
    private String q;
    private Set<Integer> s;
    private Paint x;
    
    a(android.content.Context paramContext, Class paramClass, String paramString)
    {
      j = paramContext;
      c = paramClass;
      g = paramString;
      b = RoomDatabase.JournalMode.b;
      l = true;
      m = new RoomDatabase.c();
    }
    
    public a a(RoomDatabase.b paramB)
    {
      if (k == null) {
        k = new ArrayList();
      }
      k.add(paramB);
      return this;
    }
    
    public a a(Executor paramExecutor)
    {
      a = paramExecutor;
      return this;
    }
    
    public a a(Paint paramPaint)
    {
      x = paramPaint;
      return this;
    }
    
    public a a(androidx.room.asm.Item... paramVarArgs)
    {
      if (s == null) {
        s = new HashSet();
      }
      int i1 = paramVarArgs.length;
      int n = 0;
      while (n < i1)
      {
        androidx.room.asm.Item localItem = paramVarArgs[n];
        s.add(Integer.valueOf(c));
        s.add(Integer.valueOf(b));
        n += 1;
      }
      m.a(paramVarArgs);
      return this;
    }
    
    public RoomDatabase a()
    {
      if (j != null)
      {
        if (c != null)
        {
          Object localObject1 = a;
          if ((localObject1 == null) && (i == null))
          {
            localObject1 = f.c();
            i = ((Executor)localObject1);
            a = ((Executor)localObject1);
          }
          else if ((localObject1 != null) && (i == null))
          {
            i = ((Executor)localObject1);
          }
          else if (localObject1 == null)
          {
            localObject1 = i;
            if (localObject1 != null) {
              a = ((Executor)localObject1);
            }
          }
          localObject1 = s;
          Object localObject2;
          if ((localObject1 != null) && (p != null))
          {
            localObject2 = ((Set)localObject1).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject1 = (Integer)((Iterator)localObject2).next();
              if (p.contains(localObject1))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ");
                ((StringBuilder)localObject2).append(localObject1);
                throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
              }
            }
          }
          if (x == null) {
            x = new Type();
          }
          localObject1 = q;
          if ((localObject1 != null) || (d != null))
          {
            if (g != null)
            {
              if ((localObject1 != null) && (d != null)) {
                throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
              }
              x = new StatementExecutor((String)localObject1, d, x);
            }
          }
          else
          {
            localObject1 = j;
            localObject1 = new a((android.content.Context)localObject1, g, x, m, k, f, b.a((android.content.Context)localObject1), a, i, h, l, o, p, q, d);
            localObject2 = (RoomDatabase)Frame.get(c, "_Impl");
            ((RoomDatabase)localObject2).a((a)localObject1);
            return localObject2;
          }
          throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
        }
        throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
      }
      throw new IllegalArgumentException("Cannot provide null context for the database.");
    }
    
    public a b()
    {
      l = false;
      o = true;
      return this;
    }
    
    public a c()
    {
      f = true;
      return this;
    }
  }
  
  public static abstract class b
  {
    public b() {}
    
    public void b(v7.td.data.Context paramContext) {}
    
    public void f(v7.td.data.Context paramContext) {}
    
    public void playLog(v7.td.data.Context paramContext) {}
  }
  
  public static class c
  {
    private HashMap<Integer, TreeMap<Integer, androidx.room.p.a>> b = new HashMap();
    
    public c() {}
    
    private void a(androidx.room.asm.Item paramItem)
    {
      int i = c;
      int j = b;
      Object localObject2 = (TreeMap)b.get(Integer.valueOf(i));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TreeMap();
        b.put(Integer.valueOf(i), localObject1);
      }
      localObject2 = (androidx.room.asm.Item)((TreeMap)localObject1).get(Integer.valueOf(j));
      if (localObject2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Overriding migration ");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(" with ");
        localStringBuilder.append(paramItem);
        android.util.Log.w("ROOM", localStringBuilder.toString());
      }
      ((TreeMap)localObject1).put(Integer.valueOf(j), paramItem);
    }
    
    private List write(List paramList, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      while (paramBoolean ? paramInt1 < paramInt2 : paramInt1 > paramInt2)
      {
        TreeMap localTreeMap = (TreeMap)b.get(Integer.valueOf(paramInt1));
        if (localTreeMap == null) {
          return null;
        }
        if (paramBoolean) {
          localObject = localTreeMap.descendingKeySet();
        } else {
          localObject = localTreeMap.keySet();
        }
        Object localObject = ((Set)localObject).iterator();
        int j;
        int k;
        do
        {
          boolean bool = ((Iterator)localObject).hasNext();
          j = 1;
          int m = 0;
          if (!bool) {
            break;
          }
          k = ((Integer)((Iterator)localObject).next()).intValue();
          if (paramBoolean)
          {
            i = m;
            if (k <= paramInt2)
            {
              i = m;
              if (k <= paramInt1) {}
            }
          }
          else
          {
            do
            {
              i = 1;
              break;
              i = m;
              if (k < paramInt2) {
                break;
              }
              i = m;
            } while (k < paramInt1);
          }
        } while (i == 0);
        paramList.add(localTreeMap.get(Integer.valueOf(k)));
        paramInt1 = k;
        int i = j;
        break label200;
        i = 0;
        label200:
        if (i == 0) {
          return null;
        }
      }
      return paramList;
    }
    
    public void a(androidx.room.asm.Item... paramVarArgs)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        a(paramVarArgs[i]);
        i += 1;
      }
    }
    
    public List getText(int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      boolean bool;
      if (paramInt2 > paramInt1) {
        bool = true;
      } else {
        bool = false;
      }
      return write(new ArrayList(), bool, paramInt1, paramInt2);
    }
  }
}
