package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.room.RoomDatabase.a;
import androidx.room.RoomDatabase.b;
import androidx.work.impl.asm.i;
import androidx.work.impl.asm.k;
import androidx.work.impl.asm.l;
import androidx.work.impl.asm.n;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import v7.td.data.Log;
import v7.td.data.Paint;
import v7.td.data.c.b.a;
import v7.td.data.h;

public abstract class WorkDatabase
  extends RoomDatabase
{
  private static final long FIFTEEN_MINUTES = TimeUnit.DAYS.toMillis(1L);
  
  public WorkDatabase() {}
  
  public static WorkDatabase a(android.content.Context paramContext, Executor paramExecutor, boolean paramBoolean)
  {
    java.lang.Object localObject;
    if (paramBoolean)
    {
      localObject = androidx.room.Frame.a(paramContext, WorkDatabase.class).c();
    }
    else
    {
      RoomDatabase.a localA = androidx.room.Frame.a(paramContext, WorkDatabase.class, Type.getDescriptor());
      localObject = localA;
      localA.a(new a());
    }
    return (WorkDatabase)((RoomDatabase.a)localObject).a(paramExecutor).a(visitParameterAnnotation()).a(new androidx.room.asm.Item[] { Switch.d }).a(new androidx.room.asm.Item[] { new ConcatFilter(paramContext, 2, 3) }).a(new androidx.room.asm.Item[] { Switch.c }).a(new androidx.room.asm.Item[] { Switch.o }).a(new androidx.room.asm.Item[] { new ConcatFilter(paramContext, 5, 6) }).a(new androidx.room.asm.Item[] { Switch.k }).a(new androidx.room.asm.Item[] { Switch.i }).a(new androidx.room.asm.Item[] { Switch.g }).a(new androidx.room.asm.Item[] { new EmulatorView(paramContext) }).a(new androidx.room.asm.Item[] { new ConcatFilter(paramContext, 10, 11) }).a(new androidx.room.asm.Item[] { Switch.h }).b().a();
  }
  
  static long length()
  {
    return System.currentTimeMillis() - FIFTEEN_MINUTES;
  }
  
  static String substring()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ");
    localStringBuilder.append(length());
    localStringBuilder.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
    return localStringBuilder.toString();
  }
  
  static RoomDatabase.b visitParameterAnnotation()
  {
    return new b();
  }
  
  public abstract i a();
  
  public abstract androidx.work.impl.asm.Item b();
  
  public abstract n c();
  
  public abstract l d();
  
  public abstract k get();
  
  public abstract androidx.work.impl.asm.Object getValue();
  
  public abstract androidx.work.impl.asm.Frame read();
  
  class a
    implements Paint
  {
    a() {}
    
    public Log create(h paramH)
    {
      c.b.a localA = h.a(WorkDatabase.this);
      localA.a(c).a(y).e(true);
      return new v7.td.data.service.Type().create(localA.a());
    }
  }
  
  class b
    extends RoomDatabase.b
  {
    b() {}
    
    public void playLog(v7.td.data.Context paramContext)
    {
      super.playLog(paramContext);
      paramContext.beginTransaction();
      try
      {
        paramContext.execSQL(WorkDatabase.substring());
        paramContext.setTransactionSuccessful();
        paramContext.endTransaction();
        return;
      }
      catch (Throwable localThrowable)
      {
        paramContext.endTransaction();
        throw localThrowable;
      }
    }
  }
}
