package androidx.work.impl;

import androidx.room.MethodWriter;
import androidx.room.RoomDatabase.b;
import androidx.room.a;
import androidx.room.core.Filter;
import androidx.room.core.Label;
import androidx.room.core.Model;
import androidx.room.core.Segment;
import androidx.work.impl.asm.ClassWriter;
import androidx.work.impl.asm.DocumentBody;
import androidx.work.impl.asm.Frame;
import androidx.work.impl.asm.b;
import androidx.work.impl.asm.e;
import androidx.work.impl.asm.g;
import androidx.work.impl.asm.k;
import androidx.work.impl.asm.l;
import androidx.work.impl.asm.n;
import androidx.work.impl.asm.o;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v7.td.data.Context;
import v7.td.data.Database;
import v7.td.data.Paint;
import v7.td.data.c.b.a;
import v7.td.data.h;

public final class WorkDatabase_Impl
  extends WorkDatabase
{
  private volatile androidx.work.impl.asm.Object _value;
  private volatile androidx.work.impl.asm.i d;
  private volatile androidx.work.impl.asm.Item j;
  private volatile n k;
  private volatile k ms;
  private volatile l o;
  private volatile Frame tot;
  
  public WorkDatabase_Impl() {}
  
  public androidx.work.impl.asm.i a()
  {
    if (d != null) {
      return d;
    }
    try
    {
      if (d == null) {
        d = new androidx.work.impl.asm.f(this);
      }
      androidx.work.impl.asm.i localI = d;
      return localI;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public androidx.work.impl.asm.Item b()
  {
    if (j != null) {
      return j;
    }
    try
    {
      if (j == null) {
        j = new g(this);
      }
      androidx.work.impl.asm.Item localItem = j;
      return localItem;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected v7.td.data.Log b(a paramA)
  {
    java.lang.Object localObject = new MethodWriter(paramA, new a(12), "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6");
    localObject = h.a(r).a(s).a((Database)localObject).a();
    return q.create((h)localObject);
  }
  
  public n c()
  {
    if (k != null) {
      return k;
    }
    try
    {
      if (k == null) {
        k = new o(this);
      }
      n localN = k;
      return localN;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public l d()
  {
    if (o != null) {
      return o;
    }
    try
    {
      if (o == null) {
        o = new b(this);
      }
      l localL = o;
      return localL;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public k get()
  {
    if (ms != null) {
      return ms;
    }
    try
    {
      if (ms == null) {
        ms = new e(this);
      }
      k localK = ms;
      return localK;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  protected androidx.room.i getInstance()
  {
    return new androidx.room.i(this, new HashMap(0), new HashMap(0), new String[] { "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference" });
  }
  
  public androidx.work.impl.asm.Object getValue()
  {
    if (_value != null) {
      return _value;
    }
    try
    {
      if (_value == null) {
        _value = new DocumentBody(this);
      }
      androidx.work.impl.asm.Object localObject = _value;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Frame read()
  {
    if (tot != null) {
      return tot;
    }
    try
    {
      if (tot == null) {
        tot = new ClassWriter(this);
      }
      Frame localFrame = tot;
      return localFrame;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  class a
    extends androidx.room.f
  {
    a(int paramInt)
    {
      super();
    }
    
    protected androidx.room.Item add(Context paramContext)
    {
      java.lang.Object localObject1 = new HashMap(2);
      ((HashMap)localObject1).put("work_spec_id", new Label("work_spec_id", "TEXT", true, 1, null, 1));
      ((HashMap)localObject1).put("prerequisite_id", new Label("prerequisite_id", "TEXT", true, 2, null, 1));
      java.lang.Object localObject2 = new HashSet(2);
      ((HashSet)localObject2).add(new Segment("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "work_spec_id" }), Arrays.asList(new String[] { "id" })));
      ((HashSet)localObject2).add(new Segment("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "prerequisite_id" }), Arrays.asList(new String[] { "id" })));
      HashSet localHashSet = new HashSet(2);
      localHashSet.add(new Filter("index_Dependency_work_spec_id", false, Arrays.asList(new String[] { "work_spec_id" })));
      localHashSet.add(new Filter("index_Dependency_prerequisite_id", false, Arrays.asList(new String[] { "prerequisite_id" })));
      localObject1 = new Model("Dependency", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = Model.get(paramContext, "Dependency");
      if (!((Model)localObject1).equals(localObject2))
      {
        paramContext = new StringBuilder();
        paramContext.append("Dependency(androidx.work.impl.model.Dependency).\n Expected:\n");
        paramContext.append(localObject1);
        paramContext.append("\n Found:\n");
        paramContext.append(localObject2);
        return new androidx.room.Item(false, paramContext.toString());
      }
      localObject1 = new HashMap(25);
      ((HashMap)localObject1).put("id", new Label("id", "TEXT", true, 1, null, 1));
      ((HashMap)localObject1).put("state", new Label("state", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("worker_class_name", new Label("worker_class_name", "TEXT", true, 0, null, 1));
      ((HashMap)localObject1).put("input_merger_class_name", new Label("input_merger_class_name", "TEXT", false, 0, null, 1));
      ((HashMap)localObject1).put("input", new Label("input", "BLOB", true, 0, null, 1));
      ((HashMap)localObject1).put("output", new Label("output", "BLOB", true, 0, null, 1));
      ((HashMap)localObject1).put("initial_delay", new Label("initial_delay", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("interval_duration", new Label("interval_duration", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("flex_duration", new Label("flex_duration", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("run_attempt_count", new Label("run_attempt_count", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("backoff_policy", new Label("backoff_policy", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("backoff_delay_duration", new Label("backoff_delay_duration", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("period_start_time", new Label("period_start_time", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("minimum_retention_duration", new Label("minimum_retention_duration", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("schedule_requested_at", new Label("schedule_requested_at", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("run_in_foreground", new Label("run_in_foreground", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("out_of_quota_policy", new Label("out_of_quota_policy", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("required_network_type", new Label("required_network_type", "INTEGER", false, 0, null, 1));
      ((HashMap)localObject1).put("requires_charging", new Label("requires_charging", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("requires_device_idle", new Label("requires_device_idle", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("requires_battery_not_low", new Label("requires_battery_not_low", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("requires_storage_not_low", new Label("requires_storage_not_low", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("trigger_content_update_delay", new Label("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("trigger_max_content_delay", new Label("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
      ((HashMap)localObject1).put("content_uri_triggers", new Label("content_uri_triggers", "BLOB", false, 0, null, 1));
      localObject2 = new HashSet(0);
      localHashSet = new HashSet(2);
      localHashSet.add(new Filter("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[] { "schedule_requested_at" })));
      localHashSet.add(new Filter("index_WorkSpec_period_start_time", false, Arrays.asList(new String[] { "period_start_time" })));
      localObject1 = new Model("WorkSpec", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = Model.get(paramContext, "WorkSpec");
      if (!((Model)localObject1).equals(localObject2))
      {
        paramContext = new StringBuilder();
        paramContext.append("WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n");
        paramContext.append(localObject1);
        paramContext.append("\n Found:\n");
        paramContext.append(localObject2);
        return new androidx.room.Item(false, paramContext.toString());
      }
      localObject1 = new HashMap(2);
      ((HashMap)localObject1).put("tag", new Label("tag", "TEXT", true, 1, null, 1));
      ((HashMap)localObject1).put("work_spec_id", new Label("work_spec_id", "TEXT", true, 2, null, 1));
      localObject2 = new HashSet(1);
      ((HashSet)localObject2).add(new Segment("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "work_spec_id" }), Arrays.asList(new String[] { "id" })));
      localHashSet = new HashSet(1);
      localHashSet.add(new Filter("index_WorkTag_work_spec_id", false, Arrays.asList(new String[] { "work_spec_id" })));
      localObject1 = new Model("WorkTag", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = Model.get(paramContext, "WorkTag");
      if (!((Model)localObject1).equals(localObject2))
      {
        paramContext = new StringBuilder();
        paramContext.append("WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n");
        paramContext.append(localObject1);
        paramContext.append("\n Found:\n");
        paramContext.append(localObject2);
        return new androidx.room.Item(false, paramContext.toString());
      }
      localObject1 = new HashMap(2);
      ((HashMap)localObject1).put("work_spec_id", new Label("work_spec_id", "TEXT", true, 1, null, 1));
      ((HashMap)localObject1).put("system_id", new Label("system_id", "INTEGER", true, 0, null, 1));
      localObject2 = new HashSet(1);
      ((HashSet)localObject2).add(new Segment("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "work_spec_id" }), Arrays.asList(new String[] { "id" })));
      localObject1 = new Model("SystemIdInfo", (Map)localObject1, (Set)localObject2, new HashSet(0));
      localObject2 = Model.get(paramContext, "SystemIdInfo");
      if (!((Model)localObject1).equals(localObject2))
      {
        paramContext = new StringBuilder();
        paramContext.append("SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n");
        paramContext.append(localObject1);
        paramContext.append("\n Found:\n");
        paramContext.append(localObject2);
        return new androidx.room.Item(false, paramContext.toString());
      }
      localObject1 = new HashMap(2);
      ((HashMap)localObject1).put("name", new Label("name", "TEXT", true, 1, null, 1));
      ((HashMap)localObject1).put("work_spec_id", new Label("work_spec_id", "TEXT", true, 2, null, 1));
      localObject2 = new HashSet(1);
      ((HashSet)localObject2).add(new Segment("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "work_spec_id" }), Arrays.asList(new String[] { "id" })));
      localHashSet = new HashSet(1);
      localHashSet.add(new Filter("index_WorkName_work_spec_id", false, Arrays.asList(new String[] { "work_spec_id" })));
      localObject1 = new Model("WorkName", (Map)localObject1, (Set)localObject2, localHashSet);
      localObject2 = Model.get(paramContext, "WorkName");
      if (!((Model)localObject1).equals(localObject2))
      {
        paramContext = new StringBuilder();
        paramContext.append("WorkName(androidx.work.impl.model.WorkName).\n Expected:\n");
        paramContext.append(localObject1);
        paramContext.append("\n Found:\n");
        paramContext.append(localObject2);
        return new androidx.room.Item(false, paramContext.toString());
      }
      localObject1 = new HashMap(2);
      ((HashMap)localObject1).put("work_spec_id", new Label("work_spec_id", "TEXT", true, 1, null, 1));
      ((HashMap)localObject1).put("progress", new Label("progress", "BLOB", true, 0, null, 1));
      localObject2 = new HashSet(1);
      ((HashSet)localObject2).add(new Segment("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "work_spec_id" }), Arrays.asList(new String[] { "id" })));
      localObject1 = new Model("WorkProgress", (Map)localObject1, (Set)localObject2, new HashSet(0));
      localObject2 = Model.get(paramContext, "WorkProgress");
      if (!((Model)localObject1).equals(localObject2))
      {
        paramContext = new StringBuilder();
        paramContext.append("WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n");
        paramContext.append(localObject1);
        paramContext.append("\n Found:\n");
        paramContext.append(localObject2);
        return new androidx.room.Item(false, paramContext.toString());
      }
      localObject1 = new HashMap(2);
      ((HashMap)localObject1).put("key", new Label("key", "TEXT", true, 1, null, 1));
      ((HashMap)localObject1).put("long_value", new Label("long_value", "INTEGER", false, 0, null, 1));
      localObject1 = new Model("Preference", (Map)localObject1, new HashSet(0), new HashSet(0));
      paramContext = Model.get(paramContext, "Preference");
      if (!((Model)localObject1).equals(paramContext))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Preference(androidx.work.impl.model.Preference).\n Expected:\n");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("\n Found:\n");
        ((StringBuilder)localObject2).append(paramContext);
        return new androidx.room.Item(false, ((StringBuilder)localObject2).toString());
      }
      return new androidx.room.Item(true, null);
    }
    
    public void b(Context paramContext)
    {
      paramContext.execSQL("DROP TABLE IF EXISTS `Dependency`");
      paramContext.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
      paramContext.execSQL("DROP TABLE IF EXISTS `WorkTag`");
      paramContext.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
      paramContext.execSQL("DROP TABLE IF EXISTS `WorkName`");
      paramContext.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
      paramContext.execSQL("DROP TABLE IF EXISTS `Preference`");
      if (WorkDatabase_Impl.c(WorkDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = WorkDatabase_Impl.a(WorkDatabase_Impl.this).size();
        while (i < j)
        {
          ((RoomDatabase.b)WorkDatabase_Impl.f(WorkDatabase_Impl.this).get(i)).f(paramContext);
          i += 1;
        }
      }
    }
    
    protected void c(Context paramContext)
    {
      if (WorkDatabase_Impl.access$getC(WorkDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = WorkDatabase_Impl.b(WorkDatabase_Impl.this).size();
        while (i < j)
        {
          ((RoomDatabase.b)WorkDatabase_Impl.d(WorkDatabase_Impl.this).get(i)).b(paramContext);
          i += 1;
        }
      }
    }
    
    public void clear(Context paramContext)
    {
      paramContext.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
      paramContext.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
      paramContext.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
      paramContext.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
      paramContext.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
      paramContext.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
      paramContext.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
      paramContext.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
      paramContext.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
      paramContext.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
      paramContext.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
      paramContext.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
      paramContext.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
      paramContext.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
      paramContext.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
    }
    
    public void d(Context paramContext)
    {
      WorkDatabase_Impl.b(WorkDatabase_Impl.this, paramContext);
      paramContext.execSQL("PRAGMA foreign_keys = ON");
      WorkDatabase_Impl.c(WorkDatabase_Impl.this, paramContext);
      if (WorkDatabase_Impl.getMode(WorkDatabase_Impl.this) != null)
      {
        int i = 0;
        int j = WorkDatabase_Impl.split(WorkDatabase_Impl.this).size();
        while (i < j)
        {
          ((RoomDatabase.b)WorkDatabase_Impl.get(WorkDatabase_Impl.this).get(i)).playLog(paramContext);
          i += 1;
        }
      }
    }
    
    public void i(Context paramContext)
    {
      androidx.room.core.Log.initialize(paramContext);
    }
    
    public void p(Context paramContext) {}
  }
}
