package com.google.android.datatransport.asm.util.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.asm.ByteBufferList;
import com.google.android.datatransport.asm.Context;
import com.google.android.datatransport.asm.Item;
import com.google.android.datatransport.asm.params.c;
import com.google.android.datatransport.runtime.firebase.transport.ClassWriter;
import com.google.android.datatransport.runtime.firebase.transport.HttpMediaType;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped.Reason;
import com.google.android.datatransport.runtime.firebase.transport.Marker;
import com.google.android.datatransport.runtime.firebase.transport.NumberPicker.TwoDigitFormatter;
import com.google.android.datatransport.runtime.firebase.transport.b;
import com.google.android.datatransport.runtime.firebase.transport.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class Log
  implements m, c, e
{
  private static final com.google.android.datatransport.Type BOOLEAN_TYPE = com.google.android.datatransport.Type.valueOf("proto");
  private final com.google.android.datatransport.asm.asm.Label a;
  private final f b;
  private final g.a.a<String> c;
  private final com.google.android.datatransport.asm.asm.Label n;
  private final DatabaseHelper this$0;
  
  Log(com.google.android.datatransport.asm.asm.Label paramLabel1, com.google.android.datatransport.asm.asm.Label paramLabel2, f paramF, DatabaseHelper paramDatabaseHelper, g.a.a paramA)
  {
    this$0 = paramDatabaseHelper;
    n = paramLabel1;
    a = paramLabel2;
    b = paramF;
    c = paramA;
  }
  
  private LogEventDropped.Reason a(int paramInt)
  {
    LogEventDropped.Reason localReason1 = LogEventDropped.Reason.o;
    if (paramInt == localReason1.a()) {
      return localReason1;
    }
    LogEventDropped.Reason localReason2 = LogEventDropped.Reason.l;
    if (paramInt == localReason2.a()) {
      return localReason2;
    }
    localReason2 = LogEventDropped.Reason.b;
    if (paramInt == localReason2.a()) {
      return localReason2;
    }
    localReason2 = LogEventDropped.Reason.d;
    if (paramInt == localReason2.a()) {
      return localReason2;
    }
    localReason2 = LogEventDropped.Reason.p;
    if (paramInt == localReason2.a()) {
      return localReason2;
    }
    localReason2 = LogEventDropped.Reason.g;
    if (paramInt == localReason2.a()) {
      return localReason2;
    }
    localReason2 = LogEventDropped.Reason.y;
    if (paramInt == localReason2.a()) {
      return localReason2;
    }
    com.google.android.datatransport.asm.store.f.d("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(paramInt));
    return localReason1;
  }
  
  private b a()
  {
    return b.create().init(ClassWriter.a().b(getValue()).a(f.o.f()).b()).format();
  }
  
  private Object a(r0.d paramD, r0.b paramB)
  {
    long l = a.a();
    for (;;)
    {
      try
      {
        Object localObject = paramD.open();
        return localObject;
      }
      catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
      {
        if (a.a() >= b.n() + l) {
          return paramB.apply(localSQLiteDatabaseLockedException);
        }
        SystemClock.sleep(50L);
      }
    }
  }
  
  private long count()
  {
    return get().compileStatement("PRAGMA page_size").simpleQueryForLong();
  }
  
  private Marker d()
  {
    return (Marker)remove(new BTree.2(n.a()));
  }
  
  private void execute(com.google.android.datatransport.runtime.firebase.transport.Frame paramFrame, Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramFrame.init(com.google.android.datatransport.runtime.firebase.transport.Label.getType().setType((String)localEntry.getKey()).setType((List)localEntry.getValue()).build());
    }
  }
  
  static Object get(Cursor paramCursor, r0.b paramB)
  {
    try
    {
      paramB = paramB.apply(paramCursor);
      paramCursor.close();
      return paramB;
    }
    catch (Throwable paramB)
    {
      paramCursor.close();
      throw paramB;
    }
  }
  
  private List get(SQLiteDatabase paramSQLiteDatabase, Context paramContext, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = initialize(paramSQLiteDatabase, paramContext);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((Long)localObject).toString();
    get(paramSQLiteDatabase.query("events", new String[] { "_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline" }, "context_id = ?", new String[] { localObject }, null, null, null, String.valueOf(paramInt)), new ClassMarshaller.3(this, localArrayList, paramContext));
    return localArrayList;
  }
  
  private Map get(SQLiteDatabase paramSQLiteDatabase, List paramList)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder("event_id IN (");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(((Type)paramList.get(i)).getFirst());
      if (i < paramList.size() - 1) {
        localStringBuilder.append(',');
      }
      i += 1;
    }
    localStringBuilder.append(')');
    paramList = localStringBuilder.toString();
    get(paramSQLiteDatabase.query("event_metadata", new String[] { "event_id", "name", "value" }, paramList, null, null, null, null), new FunctionExtensions.10(localHashMap));
    return localHashMap;
  }
  
  private static byte[] getKey(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Base64.decode(paramString, 0);
  }
  
  private static com.google.android.datatransport.Type getType(String paramString)
  {
    if (paramString == null) {
      return BOOLEAN_TYPE;
    }
    return com.google.android.datatransport.Type.valueOf(paramString);
  }
  
  private Long initialize(SQLiteDatabase paramSQLiteDatabase, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder("backend_name = ? and priority = ?");
    Object localObject = new ArrayList(Arrays.asList(new String[] { paramContext.getName(), String.valueOf(com.google.android.datatransport.asm.drm.Frame.get(paramContext.getValue())) }));
    if (paramContext.get() != null)
    {
      localStringBuilder.append(" and extras = ?");
      ((ArrayList)localObject).add(Base64.encodeToString(paramContext.get(), 0));
    }
    else
    {
      localStringBuilder.append(" and extras is null");
    }
    paramContext = localStringBuilder.toString();
    localObject = (String[])((ArrayList)localObject).toArray(new String[0]);
    return (Long)get(paramSQLiteDatabase.query("transport_contexts", new String[] { "_id" }, paramContext, (String[])localObject, null, null, null), Node.to);
  }
  
  private boolean next()
  {
    return update() * count() >= b.f();
  }
  
  private List read(List paramList, Map paramMap)
  {
    ListIterator localListIterator = paramList.listIterator();
    while (localListIterator.hasNext())
    {
      Type localType = (Type)localListIterator.next();
      if (paramMap.containsKey(Long.valueOf(localType.getFirst())))
      {
        ByteBufferList localByteBufferList = localType.get().add();
        Iterator localIterator = ((Set)paramMap.get(Long.valueOf(localType.getFirst()))).iterator();
        while (localIterator.hasNext())
        {
          r0.c localC = (r0.c)localIterator.next();
          localByteBufferList.append(s, z);
        }
        localListIterator.set(Type.get(localType.getFirst(), localType.getName(), localByteBufferList.add()));
      }
    }
    return paramList;
  }
  
  private static String toString(Iterable paramIterable)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      localStringBuilder.append(((Type)paramIterable.next()).getFirst());
      if (paramIterable.hasNext()) {
        localStringBuilder.append(',');
      }
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  private byte[] toString(long paramLong)
  {
    return (byte[])get(get().query("event_payloads", new String[] { "bytes" }, "event_id = ?", new String[] { String.valueOf(paramLong) }, null, null, "sequence_num"), Subscription.pending);
  }
  
  private long update()
  {
    return get().compileStatement("PRAGMA page_count").simpleQueryForLong();
  }
  
  private long write(SQLiteDatabase paramSQLiteDatabase, Context paramContext)
  {
    Object localObject = initialize(paramSQLiteDatabase, paramContext);
    if (localObject != null) {
      return ((Long)localObject).longValue();
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("backend_name", paramContext.getName());
    ((ContentValues)localObject).put("priority", Integer.valueOf(com.google.android.datatransport.asm.drm.Frame.get(paramContext.getValue())));
    ((ContentValues)localObject).put("next_request_ms", Integer.valueOf(0));
    if (paramContext.get() != null) {
      ((ContentValues)localObject).put("extras", Base64.encodeToString(paramContext.get(), 0));
    }
    return paramSQLiteDatabase.insert("transport_contexts", null, (ContentValues)localObject);
  }
  
  private void write(SQLiteDatabase paramSQLiteDatabase)
  {
    a(new DatabaseManager(paramSQLiteDatabase), Settings.s);
  }
  
  public Type a(Context paramContext, Item paramItem)
  {
    com.google.android.datatransport.asm.store.f.d("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", new Object[] { paramContext.getValue(), paramItem.getId(), paramContext.getName() });
    long l = ((Long)remove(new ClientInfo(this, paramItem, paramContext))).longValue();
    if (l < 1L) {
      return null;
    }
    return Type.get(l, paramContext, paramItem);
  }
  
  public boolean a(Context paramContext)
  {
    return ((Boolean)remove(new d(this, paramContext))).booleanValue();
  }
  
  public Object add(com.google.android.datatransport.asm.params.Object paramObject)
  {
    SQLiteDatabase localSQLiteDatabase = get();
    write(localSQLiteDatabase);
    try
    {
      paramObject = paramObject.a();
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      localSQLiteDatabase.endTransaction();
      throw paramObject;
    }
  }
  
  public void add(long paramLong, LogEventDropped.Reason paramReason, String paramString)
  {
    remove(new Font(paramString, paramReason, paramLong));
  }
  
  public void add(Iterable paramIterable)
  {
    if (!paramIterable.iterator().hasNext()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DELETE FROM events WHERE _id in ");
    localStringBuilder.append(toString(paramIterable));
    paramIterable = localStringBuilder.toString();
    get().compileStatement(paramIterable).execute();
  }
  
  public void apply()
  {
    remove(new BTree.3(this));
  }
  
  public h b()
  {
    com.google.android.datatransport.runtime.firebase.transport.Frame localFrame = h.e();
    return (h)remove(new PlaybackStateCompat(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new HashMap(), localFrame));
  }
  
  public void close()
  {
    this$0.close();
  }
  
  public int e()
  {
    return ((Integer)remove(new ObjectContainerBase.3(this, n.a() - b.size()))).intValue();
  }
  
  public Iterable e(Context paramContext)
  {
    return (Iterable)remove(new Logger(this, paramContext));
  }
  
  public void e(Context paramContext, long paramLong)
  {
    remove(new Functions.FunctionComposition(paramLong, paramContext));
  }
  
  public void e(Iterable paramIterable)
  {
    if (!paramIterable.iterator().hasNext()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
    localStringBuilder.append(toString(paramIterable));
    remove(new a(this, localStringBuilder.toString(), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
  }
  
  public Iterable f()
  {
    return (Iterable)remove(Token.next);
  }
  
  SQLiteDatabase get()
  {
    DatabaseHelper localDatabaseHelper = this$0;
    Objects.requireNonNull(localDatabaseHelper);
    return (SQLiteDatabase)a(new Database(localDatabaseHelper), Format.TAG);
  }
  
  long getValue()
  {
    return update() * count();
  }
  
  public long getValue(Context paramContext)
  {
    return ((Long)get(get().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[] { paramContext.getName(), String.valueOf(com.google.android.datatransport.asm.drm.Frame.get(paramContext.getValue())) }), Identifier.id)).longValue();
  }
  
  Object remove(r0.b paramB)
  {
    SQLiteDatabase localSQLiteDatabase = get();
    localSQLiteDatabase.beginTransaction();
    try
    {
      paramB = paramB.apply(localSQLiteDatabase);
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      return paramB;
    }
    catch (Throwable paramB)
    {
      localSQLiteDatabase.endTransaction();
      throw paramB;
    }
  }
}
