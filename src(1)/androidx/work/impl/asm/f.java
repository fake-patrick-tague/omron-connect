package androidx.work.impl.asm;

import android.database.Cursor;
import androidx.room.Attribute;
import androidx.room.ByteVector;
import androidx.room.RoomDatabase;
import androidx.room.b;
import androidx.room.core.Util;
import androidx.work.Label;
import androidx.work.WorkInfo.State;
import androidx.work.impl.n.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v7.td.data.Item;
import v7.td.data.Transaction;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;

public final class f
  implements i
{
  private final ByteVector A;
  private final b<p> a;
  private final ByteVector b;
  private final RoomDatabase c;
  private final ByteVector d;
  private final ByteVector j;
  private final ByteVector l;
  private final ByteVector n;
  private final ByteVector r;
  private final ByteVector v;
  
  public f(RoomDatabase paramRoomDatabase)
  {
    c = paramRoomDatabase;
    a = new ClassReader(this, paramRoomDatabase);
    v = new ECCurve(this, paramRoomDatabase);
    d = new Evaluator.CssNthEvaluator(this, paramRoomDatabase);
    j = new FieldWriter(this, paramRoomDatabase);
    l = new NTRUSigningKeyGenerationParameters(this, paramRoomDatabase);
    b = new NumberPicker(this, paramRoomDatabase);
    r = new PieRenderer(this, paramRoomDatabase);
    n = new k.a(this, paramRoomDatabase);
    A = new TigerDigest(this, paramRoomDatabase);
  }
  
  private void get(ArrayMap paramArrayMap)
  {
    java.lang.Object localObject2 = paramArrayMap.keySet();
    if (((java.util.Set)localObject2).isEmpty()) {
      return;
    }
    java.lang.Object localObject1;
    int i;
    if (paramArrayMap.size() > 999)
    {
      localObject1 = new ArrayMap(999);
      int i2 = paramArrayMap.size();
      int k = 0;
      i = 0;
      while (k < i2)
      {
        ((SimpleArrayMap)localObject1).put((String)paramArrayMap.size(k), (ArrayList)paramArrayMap.get(k));
        int m = k + 1;
        int i1 = i + 1;
        k = m;
        i = i1;
        if (i1 == 999)
        {
          get((ArrayMap)localObject1);
          localObject1 = new ArrayMap(999);
          i = 0;
          k = m;
        }
      }
      if (i > 0) {
        get((ArrayMap)localObject1);
      }
    }
    else
    {
      localObject1 = Util.split();
      ((StringBuilder)localObject1).append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
      i = ((java.util.Set)localObject2).size();
      Util.format((StringBuilder)localObject1, i);
      ((StringBuilder)localObject1).append(")");
      localObject1 = androidx.room.Log.get(((StringBuilder)localObject1).toString(), i + 0);
      localObject2 = ((java.util.Set)localObject2).iterator();
      i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (str == null) {
          ((androidx.room.Log)localObject1).bindNull(i);
        } else {
          ((androidx.room.Log)localObject1).bindString(i, str);
        }
        i += 1;
      }
      localObject1 = androidx.room.core.Log.get(c, (Transaction)localObject1, false, null);
      try
      {
        i = androidx.room.core.Set.getCount((Cursor)localObject1, "work_spec_id");
        if (i == -1)
        {
          ((Cursor)localObject1).close();
          return;
        }
        for (;;)
        {
          boolean bool = ((Cursor)localObject1).moveToNext();
          if (!bool) {
            break;
          }
          bool = ((Cursor)localObject1).isNull(i);
          if (!bool)
          {
            localObject2 = (ArrayList)paramArrayMap.get(((Cursor)localObject1).getString(i));
            if (localObject2 != null) {
              ((ArrayList)localObject2).add(Label.read(((Cursor)localObject1).getBlob(0)));
            }
          }
        }
        ((Cursor)localObject1).close();
        return;
      }
      catch (Throwable paramArrayMap)
      {
        ((Cursor)localObject1).close();
        throw paramArrayMap;
      }
    }
  }
  
  private void getData(ArrayMap paramArrayMap)
  {
    java.lang.Object localObject2 = paramArrayMap.keySet();
    if (((java.util.Set)localObject2).isEmpty()) {
      return;
    }
    java.lang.Object localObject1;
    int i;
    if (paramArrayMap.size() > 999)
    {
      localObject1 = new ArrayMap(999);
      int i2 = paramArrayMap.size();
      int k = 0;
      i = 0;
      while (k < i2)
      {
        ((SimpleArrayMap)localObject1).put((String)paramArrayMap.size(k), (ArrayList)paramArrayMap.get(k));
        int m = k + 1;
        int i1 = i + 1;
        k = m;
        i = i1;
        if (i1 == 999)
        {
          getData((ArrayMap)localObject1);
          localObject1 = new ArrayMap(999);
          i = 0;
          k = m;
        }
      }
      if (i > 0) {
        getData((ArrayMap)localObject1);
      }
    }
    else
    {
      localObject1 = Util.split();
      ((StringBuilder)localObject1).append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
      i = ((java.util.Set)localObject2).size();
      Util.format((StringBuilder)localObject1, i);
      ((StringBuilder)localObject1).append(")");
      localObject1 = androidx.room.Log.get(((StringBuilder)localObject1).toString(), i + 0);
      localObject2 = ((java.util.Set)localObject2).iterator();
      i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (str == null) {
          ((androidx.room.Log)localObject1).bindNull(i);
        } else {
          ((androidx.room.Log)localObject1).bindString(i, str);
        }
        i += 1;
      }
      localObject1 = androidx.room.core.Log.get(c, (Transaction)localObject1, false, null);
      try
      {
        i = androidx.room.core.Set.getCount((Cursor)localObject1, "work_spec_id");
        if (i == -1)
        {
          ((Cursor)localObject1).close();
          return;
        }
        for (;;)
        {
          boolean bool = ((Cursor)localObject1).moveToNext();
          if (!bool) {
            break;
          }
          bool = ((Cursor)localObject1).isNull(i);
          if (!bool)
          {
            localObject2 = (ArrayList)paramArrayMap.get(((Cursor)localObject1).getString(i));
            if (localObject2 != null) {
              ((ArrayList)localObject2).add(((Cursor)localObject1).getString(0));
            }
          }
        }
        ((Cursor)localObject1).close();
        return;
      }
      catch (Throwable paramArrayMap)
      {
        ((Cursor)localObject1).close();
        throw paramArrayMap;
      }
    }
  }
  
  public int a(WorkInfo.State paramState, String... paramVarArgs)
  {
    c.size();
    java.lang.Object localObject = Util.split();
    ((StringBuilder)localObject).append("UPDATE workspec SET state=");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(" WHERE id IN (");
    Util.format((StringBuilder)localObject, paramVarArgs.length);
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    localObject = c.get((String)localObject);
    ((v7.td.data.Object)localObject).bindLong(1, Handler.a(paramState));
    int m = paramVarArgs.length;
    int k = 2;
    int i = 0;
    while (i < m)
    {
      paramState = paramVarArgs[i];
      if (paramState == null) {
        ((v7.td.data.Object)localObject).bindNull(k);
      } else {
        ((v7.td.data.Object)localObject).bindString(k, paramState);
      }
      k += 1;
      i += 1;
    }
    c.add();
    try
    {
      i = ((Item)localObject).executeUpdateDelete();
      c.remove();
      c.clear();
      return i;
    }
    catch (Throwable paramState)
    {
      c.clear();
      throw paramState;
    }
  }
  
  public h a(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    c.size();
    Cursor localCursor = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      int i19 = androidx.room.core.Set.getValue(localCursor, "required_network_type");
      int i20 = androidx.room.core.Set.getValue(localCursor, "requires_charging");
      int i18 = androidx.room.core.Set.getValue(localCursor, "requires_device_idle");
      int i17 = androidx.room.core.Set.getValue(localCursor, "requires_battery_not_low");
      int i16 = androidx.room.core.Set.getValue(localCursor, "requires_storage_not_low");
      int k = androidx.room.core.Set.getValue(localCursor, "trigger_content_update_delay");
      int m = androidx.room.core.Set.getValue(localCursor, "trigger_max_content_delay");
      int i1 = androidx.room.core.Set.getValue(localCursor, "content_uri_triggers");
      int i21 = androidx.room.core.Set.getValue(localCursor, "id");
      int i2 = androidx.room.core.Set.getValue(localCursor, "state");
      int i22 = androidx.room.core.Set.getValue(localCursor, "worker_class_name");
      int i3 = androidx.room.core.Set.getValue(localCursor, "input_merger_class_name");
      int i4 = androidx.room.core.Set.getValue(localCursor, "input");
      int i5 = androidx.room.core.Set.getValue(localCursor, "output");
      try
      {
        int i6 = androidx.room.core.Set.getValue(localCursor, "initial_delay");
        int i7 = androidx.room.core.Set.getValue(localCursor, "interval_duration");
        int i8 = androidx.room.core.Set.getValue(localCursor, "flex_duration");
        int i9 = androidx.room.core.Set.getValue(localCursor, "run_attempt_count");
        int i10 = androidx.room.core.Set.getValue(localCursor, "backoff_policy");
        int i11 = androidx.room.core.Set.getValue(localCursor, "backoff_delay_duration");
        int i12 = androidx.room.core.Set.getValue(localCursor, "period_start_time");
        int i13 = androidx.room.core.Set.getValue(localCursor, "minimum_retention_duration");
        int i14 = androidx.room.core.Set.getValue(localCursor, "schedule_requested_at");
        int i15 = androidx.room.core.Set.getValue(localCursor, "run_in_foreground");
        int i = androidx.room.core.Set.getValue(localCursor, "out_of_quota_policy");
        boolean bool = localCursor.moveToFirst();
        if (bool)
        {
          paramString = localCursor.getString(i21);
          String str = localCursor.getString(i22);
          androidx.work.i localI = new androidx.work.i();
          localI.b(Handler.a(localCursor.getInt(i19)));
          i19 = localCursor.getInt(i20);
          if (i19 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.b(bool);
          i18 = localCursor.getInt(i18);
          if (i18 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.a(bool);
          i17 = localCursor.getInt(i17);
          if (i17 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.g(bool);
          i16 = localCursor.getInt(i16);
          if (i16 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.e(bool);
          localI.a(localCursor.getLong(k));
          localI.b(localCursor.getLong(m));
          localI.add(Handler.read(localCursor.getBlob(i1)));
          paramString = new h(paramString, str);
          p = Handler.b(localCursor.getInt(i2));
          m = localCursor.getString(i3);
          c = Label.read(localCursor.getBlob(i4));
          s = Label.read(localCursor.getBlob(i5));
          n = localCursor.getLong(i6);
          j = localCursor.getLong(i7);
          i = localCursor.getLong(i8);
          e = localCursor.getInt(i9);
          d = Handler.c(localCursor.getInt(i10));
          f = localCursor.getLong(i11);
          w = localCursor.getLong(i12);
          l = localCursor.getLong(i13);
          g = localCursor.getLong(i14);
          k = localCursor.getInt(i15);
          if (k != 0) {
            bool = true;
          } else {
            bool = false;
          }
          h = bool;
          y = Handler.getValue(localCursor.getInt(i));
          b = localI;
        }
        else
        {
          paramString = null;
        }
        localCursor.close();
        localLog.release();
        return paramString;
      }
      catch (Throwable paramString) {}
      localCursor.close();
    }
    catch (Throwable paramString) {}
    localLog.release();
    throw paramString;
  }
  
  public List a()
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
    c.size();
    Cursor localCursor = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      int i1 = androidx.room.core.Set.getValue(localCursor, "required_network_type");
      int i2 = androidx.room.core.Set.getValue(localCursor, "requires_charging");
      int i3 = androidx.room.core.Set.getValue(localCursor, "requires_device_idle");
      int i4 = androidx.room.core.Set.getValue(localCursor, "requires_battery_not_low");
      int i5 = androidx.room.core.Set.getValue(localCursor, "requires_storage_not_low");
      int i6 = androidx.room.core.Set.getValue(localCursor, "trigger_content_update_delay");
      int i7 = androidx.room.core.Set.getValue(localCursor, "trigger_max_content_delay");
      int i8 = androidx.room.core.Set.getValue(localCursor, "content_uri_triggers");
      int i9 = androidx.room.core.Set.getValue(localCursor, "id");
      int i10 = androidx.room.core.Set.getValue(localCursor, "state");
      int i11 = androidx.room.core.Set.getValue(localCursor, "worker_class_name");
      int i12 = androidx.room.core.Set.getValue(localCursor, "input_merger_class_name");
      int i13 = androidx.room.core.Set.getValue(localCursor, "input");
      int i14 = androidx.room.core.Set.getValue(localCursor, "output");
      try
      {
        int i15 = androidx.room.core.Set.getValue(localCursor, "initial_delay");
        int i16 = androidx.room.core.Set.getValue(localCursor, "interval_duration");
        int i17 = androidx.room.core.Set.getValue(localCursor, "flex_duration");
        int i18 = androidx.room.core.Set.getValue(localCursor, "run_attempt_count");
        int i19 = androidx.room.core.Set.getValue(localCursor, "backoff_policy");
        int i20 = androidx.room.core.Set.getValue(localCursor, "backoff_delay_duration");
        int i21 = androidx.room.core.Set.getValue(localCursor, "period_start_time");
        int i = androidx.room.core.Set.getValue(localCursor, "minimum_retention_duration");
        int m = androidx.room.core.Set.getValue(localCursor, "schedule_requested_at");
        int k = androidx.room.core.Set.getValue(localCursor, "run_in_foreground");
        int i22 = androidx.room.core.Set.getValue(localCursor, "out_of_quota_policy");
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        for (;;)
        {
          boolean bool = localCursor.moveToNext();
          if (!bool) {
            break;
          }
          java.lang.Object localObject = localCursor.getString(i9);
          String str = localCursor.getString(i11);
          androidx.work.i localI = new androidx.work.i();
          localI.b(Handler.a(localCursor.getInt(i1)));
          int i23 = localCursor.getInt(i2);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.b(bool);
          i23 = localCursor.getInt(i3);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.a(bool);
          i23 = localCursor.getInt(i4);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.g(bool);
          i23 = localCursor.getInt(i5);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.e(bool);
          localI.a(localCursor.getLong(i6));
          localI.b(localCursor.getLong(i7));
          localI.add(Handler.read(localCursor.getBlob(i8)));
          localObject = new h((String)localObject, str);
          p = Handler.b(localCursor.getInt(i10));
          m = localCursor.getString(i12);
          c = Label.read(localCursor.getBlob(i13));
          s = Label.read(localCursor.getBlob(i14));
          n = localCursor.getLong(i15);
          j = localCursor.getLong(i16);
          i = localCursor.getLong(i17);
          e = localCursor.getInt(i18);
          d = Handler.c(localCursor.getInt(i19));
          f = localCursor.getLong(i20);
          w = localCursor.getLong(i21);
          l = localCursor.getLong(i);
          g = localCursor.getLong(m);
          i23 = localCursor.getInt(k);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          h = bool;
          y = Handler.getValue(localCursor.getInt(i22));
          b = localI;
          localArrayList.add(localObject);
        }
        localCursor.close();
        localLog.release();
        return localArrayList;
      }
      catch (Throwable localThrowable1) {}
      localCursor.close();
    }
    catch (Throwable localThrowable2) {}
    localLog.release();
    throw localThrowable2;
  }
  
  public List a(int paramInt)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
    localLog.bindLong(1, paramInt);
    c.size();
    Cursor localCursor = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      int m = androidx.room.core.Set.getValue(localCursor, "required_network_type");
      int i1 = androidx.room.core.Set.getValue(localCursor, "requires_charging");
      int i2 = androidx.room.core.Set.getValue(localCursor, "requires_device_idle");
      int i3 = androidx.room.core.Set.getValue(localCursor, "requires_battery_not_low");
      int i4 = androidx.room.core.Set.getValue(localCursor, "requires_storage_not_low");
      int i5 = androidx.room.core.Set.getValue(localCursor, "trigger_content_update_delay");
      int i6 = androidx.room.core.Set.getValue(localCursor, "trigger_max_content_delay");
      int i7 = androidx.room.core.Set.getValue(localCursor, "content_uri_triggers");
      int i8 = androidx.room.core.Set.getValue(localCursor, "id");
      int i9 = androidx.room.core.Set.getValue(localCursor, "state");
      int i10 = androidx.room.core.Set.getValue(localCursor, "worker_class_name");
      int i11 = androidx.room.core.Set.getValue(localCursor, "input_merger_class_name");
      int i12 = androidx.room.core.Set.getValue(localCursor, "input");
      int i13 = androidx.room.core.Set.getValue(localCursor, "output");
      try
      {
        int i14 = androidx.room.core.Set.getValue(localCursor, "initial_delay");
        int i15 = androidx.room.core.Set.getValue(localCursor, "interval_duration");
        int i16 = androidx.room.core.Set.getValue(localCursor, "flex_duration");
        int i17 = androidx.room.core.Set.getValue(localCursor, "run_attempt_count");
        int i18 = androidx.room.core.Set.getValue(localCursor, "backoff_policy");
        int i19 = androidx.room.core.Set.getValue(localCursor, "backoff_delay_duration");
        int i20 = androidx.room.core.Set.getValue(localCursor, "period_start_time");
        paramInt = androidx.room.core.Set.getValue(localCursor, "minimum_retention_duration");
        int k = androidx.room.core.Set.getValue(localCursor, "schedule_requested_at");
        int i = androidx.room.core.Set.getValue(localCursor, "run_in_foreground");
        int i21 = androidx.room.core.Set.getValue(localCursor, "out_of_quota_policy");
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        for (;;)
        {
          boolean bool = localCursor.moveToNext();
          if (!bool) {
            break;
          }
          java.lang.Object localObject = localCursor.getString(i8);
          String str = localCursor.getString(i10);
          androidx.work.i localI = new androidx.work.i();
          localI.b(Handler.a(localCursor.getInt(m)));
          int i22 = localCursor.getInt(i1);
          if (i22 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.b(bool);
          i22 = localCursor.getInt(i2);
          if (i22 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.a(bool);
          i22 = localCursor.getInt(i3);
          if (i22 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.g(bool);
          i22 = localCursor.getInt(i4);
          if (i22 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.e(bool);
          localI.a(localCursor.getLong(i5));
          localI.b(localCursor.getLong(i6));
          localI.add(Handler.read(localCursor.getBlob(i7)));
          localObject = new h((String)localObject, str);
          p = Handler.b(localCursor.getInt(i9));
          m = localCursor.getString(i11);
          c = Label.read(localCursor.getBlob(i12));
          s = Label.read(localCursor.getBlob(i13));
          n = localCursor.getLong(i14);
          j = localCursor.getLong(i15);
          i = localCursor.getLong(i16);
          e = localCursor.getInt(i17);
          d = Handler.c(localCursor.getInt(i18));
          f = localCursor.getLong(i19);
          w = localCursor.getLong(i20);
          l = localCursor.getLong(paramInt);
          g = localCursor.getLong(k);
          i22 = localCursor.getInt(i);
          if (i22 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          h = bool;
          y = Handler.getValue(localCursor.getInt(i21));
          b = localI;
          localArrayList.add(localObject);
        }
        localCursor.close();
        localLog.release();
        return localArrayList;
      }
      catch (Throwable localThrowable1) {}
      localCursor.close();
    }
    catch (Throwable localThrowable2) {}
    localLog.release();
    throw localThrowable2;
  }
  
  public List a(long paramLong)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
    localLog.bindLong(1, paramLong);
    c.size();
    Cursor localCursor = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      int i1 = androidx.room.core.Set.getValue(localCursor, "required_network_type");
      int i2 = androidx.room.core.Set.getValue(localCursor, "requires_charging");
      int i3 = androidx.room.core.Set.getValue(localCursor, "requires_device_idle");
      int i4 = androidx.room.core.Set.getValue(localCursor, "requires_battery_not_low");
      int i5 = androidx.room.core.Set.getValue(localCursor, "requires_storage_not_low");
      int i6 = androidx.room.core.Set.getValue(localCursor, "trigger_content_update_delay");
      int i7 = androidx.room.core.Set.getValue(localCursor, "trigger_max_content_delay");
      int i8 = androidx.room.core.Set.getValue(localCursor, "content_uri_triggers");
      int i9 = androidx.room.core.Set.getValue(localCursor, "id");
      int i10 = androidx.room.core.Set.getValue(localCursor, "state");
      int i11 = androidx.room.core.Set.getValue(localCursor, "worker_class_name");
      int i12 = androidx.room.core.Set.getValue(localCursor, "input_merger_class_name");
      int i13 = androidx.room.core.Set.getValue(localCursor, "input");
      int i14 = androidx.room.core.Set.getValue(localCursor, "output");
      try
      {
        int i15 = androidx.room.core.Set.getValue(localCursor, "initial_delay");
        int i16 = androidx.room.core.Set.getValue(localCursor, "interval_duration");
        int i17 = androidx.room.core.Set.getValue(localCursor, "flex_duration");
        int i18 = androidx.room.core.Set.getValue(localCursor, "run_attempt_count");
        int i19 = androidx.room.core.Set.getValue(localCursor, "backoff_policy");
        int i20 = androidx.room.core.Set.getValue(localCursor, "backoff_delay_duration");
        int i21 = androidx.room.core.Set.getValue(localCursor, "period_start_time");
        int i = androidx.room.core.Set.getValue(localCursor, "minimum_retention_duration");
        int m = androidx.room.core.Set.getValue(localCursor, "schedule_requested_at");
        int k = androidx.room.core.Set.getValue(localCursor, "run_in_foreground");
        int i22 = androidx.room.core.Set.getValue(localCursor, "out_of_quota_policy");
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        for (;;)
        {
          boolean bool = localCursor.moveToNext();
          if (!bool) {
            break;
          }
          java.lang.Object localObject = localCursor.getString(i9);
          String str = localCursor.getString(i11);
          androidx.work.i localI = new androidx.work.i();
          localI.b(Handler.a(localCursor.getInt(i1)));
          int i23 = localCursor.getInt(i2);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.b(bool);
          i23 = localCursor.getInt(i3);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.a(bool);
          i23 = localCursor.getInt(i4);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.g(bool);
          i23 = localCursor.getInt(i5);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.e(bool);
          localI.a(localCursor.getLong(i6));
          localI.b(localCursor.getLong(i7));
          localI.add(Handler.read(localCursor.getBlob(i8)));
          localObject = new h((String)localObject, str);
          p = Handler.b(localCursor.getInt(i10));
          m = localCursor.getString(i12);
          c = Label.read(localCursor.getBlob(i13));
          s = Label.read(localCursor.getBlob(i14));
          n = localCursor.getLong(i15);
          j = localCursor.getLong(i16);
          i = localCursor.getLong(i17);
          e = localCursor.getInt(i18);
          d = Handler.c(localCursor.getInt(i19));
          f = localCursor.getLong(i20);
          w = localCursor.getLong(i21);
          l = localCursor.getLong(i);
          g = localCursor.getLong(m);
          i23 = localCursor.getInt(k);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          h = bool;
          y = Handler.getValue(localCursor.getInt(i22));
          b = localI;
          localArrayList.add(localObject);
        }
        localCursor.close();
        localLog.release();
        return localArrayList;
      }
      catch (Throwable localThrowable1) {}
      localCursor.close();
    }
    catch (Throwable localThrowable2) {}
    localLog.release();
    throw localThrowable2;
  }
  
  public void a(h paramH)
  {
    c.size();
    c.add();
    try
    {
      a.a(paramH);
      c.remove();
      c.clear();
      return;
    }
    catch (Throwable paramH)
    {
      c.clear();
      throw paramH;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    c.size();
    Item localItem = j.get();
    localItem.bindLong(1, paramLong);
    if (paramString == null) {
      localItem.bindNull(2);
    } else {
      localItem.bindString(2, paramString);
    }
    c.add();
    try
    {
      localItem.executeUpdateDelete();
      c.remove();
      c.clear();
      j.a(localItem);
      return;
    }
    catch (Throwable paramString)
    {
      c.clear();
      j.a(localItem);
      throw paramString;
    }
  }
  
  public void a(String paramString, Label paramLabel)
  {
    c.size();
    Item localItem = d.get();
    paramLabel = Label.write(paramLabel);
    if (paramLabel == null) {
      localItem.bindNull(1);
    } else {
      localItem.bindBlob(1, paramLabel);
    }
    if (paramString == null) {
      localItem.bindNull(2);
    } else {
      localItem.bindString(2, paramString);
    }
    c.add();
    try
    {
      localItem.executeUpdateDelete();
      c.remove();
      c.clear();
      d.a(localItem);
      return;
    }
    catch (Throwable paramString)
    {
      c.clear();
      d.a(localItem);
      throw paramString;
    }
  }
  
  public int add(String paramString)
  {
    c.size();
    Item localItem = l.get();
    if (paramString == null) {
      localItem.bindNull(1);
    } else {
      localItem.bindString(1, paramString);
    }
    c.add();
    try
    {
      int i = localItem.executeUpdateDelete();
      c.remove();
      c.clear();
      l.a(localItem);
      return i;
    }
    catch (Throwable paramString)
    {
      c.clear();
      l.a(localItem);
      throw paramString;
    }
  }
  
  public int add(String paramString, long paramLong)
  {
    c.size();
    Item localItem = r.get();
    localItem.bindLong(1, paramLong);
    if (paramString == null) {
      localItem.bindNull(2);
    } else {
      localItem.bindString(2, paramString);
    }
    c.add();
    try
    {
      int i = localItem.executeUpdateDelete();
      c.remove();
      c.clear();
      r.a(localItem);
      return i;
    }
    catch (Throwable paramString)
    {
      c.clear();
      r.a(localItem);
      throw paramString;
    }
  }
  
  public void b(String paramString)
  {
    c.size();
    Item localItem = v.get();
    if (paramString == null) {
      localItem.bindNull(1);
    } else {
      localItem.bindString(1, paramString);
    }
    c.add();
    try
    {
      localItem.executeUpdateDelete();
      c.remove();
      c.clear();
      v.a(localItem);
      return;
    }
    catch (Throwable paramString)
    {
      c.clear();
      v.a(localItem);
      throw paramString;
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    androidx.room.Log localLog = androidx.room.Log.get("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
    c.size();
    Cursor localCursor = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      boolean bool3 = localCursor.moveToFirst();
      boolean bool1 = bool2;
      if (bool3)
      {
        int i = localCursor.getInt(0);
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
      localCursor.close();
      localLog.release();
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      localCursor.close();
      localLog.release();
      throw localThrowable;
    }
  }
  
  public int c()
  {
    c.size();
    Item localItem = n.get();
    c.add();
    try
    {
      int i = localItem.executeUpdateDelete();
      c.remove();
      c.clear();
      n.a(localItem);
      return i;
    }
    catch (Throwable localThrowable)
    {
      c.clear();
      n.a(localItem);
      throw localThrowable;
    }
  }
  
  public int clear(String paramString)
  {
    c.size();
    Item localItem = b.get();
    if (paramString == null) {
      localItem.bindNull(1);
    } else {
      localItem.bindString(1, paramString);
    }
    c.add();
    try
    {
      int i = localItem.executeUpdateDelete();
      c.remove();
      c.clear();
      b.a(localItem);
      return i;
    }
    catch (Throwable paramString)
    {
      c.clear();
      b.a(localItem);
      throw paramString;
    }
  }
  
  public List doInBackground(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    c.size();
    paramString = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      int i = androidx.room.core.Set.getValue(paramString, "id");
      int k = androidx.room.core.Set.getValue(paramString, "state");
      ArrayList localArrayList = new ArrayList(paramString.getCount());
      for (;;)
      {
        boolean bool = paramString.moveToNext();
        if (!bool) {
          break;
        }
        Handle localHandle = new Handle();
        b = paramString.getString(i);
        a = Handler.b(paramString.getInt(k));
        localArrayList.add(localHandle);
      }
      paramString.close();
      localLog.release();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      paramString.close();
      localLog.release();
      throw localThrowable;
    }
  }
  
  public WorkInfo.State get(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT state FROM workspec WHERE id=?", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    c.size();
    java.lang.Object localObject = c;
    paramString = null;
    localObject = androidx.room.core.Log.get((RoomDatabase)localObject, localLog, false, null);
    try
    {
      boolean bool = ((Cursor)localObject).moveToFirst();
      if (bool) {
        paramString = Handler.b(((Cursor)localObject).getInt(0));
      }
      ((Cursor)localObject).close();
      localLog.release();
      return paramString;
    }
    catch (Throwable paramString)
    {
      ((Cursor)localObject).close();
      localLog.release();
      throw paramString;
    }
  }
  
  public List getAll(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    c.size();
    paramString = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      ArrayList localArrayList = new ArrayList(paramString.getCount());
      for (;;)
      {
        boolean bool = paramString.moveToNext();
        if (!bool) {
          break;
        }
        localArrayList.add(Label.read(paramString.getBlob(0)));
      }
      paramString.close();
      localLog.release();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      paramString.close();
      localLog.release();
      throw localThrowable;
    }
  }
  
  public List getSeasons(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    c.size();
    paramString = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      ArrayList localArrayList = new ArrayList(paramString.getCount());
      for (;;)
      {
        boolean bool = paramString.moveToNext();
        if (!bool) {
          break;
        }
        localArrayList.add(paramString.getString(0));
      }
      paramString.close();
      localLog.release();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      paramString.close();
      localLog.release();
      throw localThrowable;
    }
  }
  
  public List run()
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
    c.size();
    Cursor localCursor = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      int i1 = androidx.room.core.Set.getValue(localCursor, "required_network_type");
      int i2 = androidx.room.core.Set.getValue(localCursor, "requires_charging");
      int i3 = androidx.room.core.Set.getValue(localCursor, "requires_device_idle");
      int i4 = androidx.room.core.Set.getValue(localCursor, "requires_battery_not_low");
      int i5 = androidx.room.core.Set.getValue(localCursor, "requires_storage_not_low");
      int i6 = androidx.room.core.Set.getValue(localCursor, "trigger_content_update_delay");
      int i7 = androidx.room.core.Set.getValue(localCursor, "trigger_max_content_delay");
      int i8 = androidx.room.core.Set.getValue(localCursor, "content_uri_triggers");
      int i9 = androidx.room.core.Set.getValue(localCursor, "id");
      int i10 = androidx.room.core.Set.getValue(localCursor, "state");
      int i11 = androidx.room.core.Set.getValue(localCursor, "worker_class_name");
      int i12 = androidx.room.core.Set.getValue(localCursor, "input_merger_class_name");
      int i13 = androidx.room.core.Set.getValue(localCursor, "input");
      int i14 = androidx.room.core.Set.getValue(localCursor, "output");
      try
      {
        int i15 = androidx.room.core.Set.getValue(localCursor, "initial_delay");
        int i16 = androidx.room.core.Set.getValue(localCursor, "interval_duration");
        int i17 = androidx.room.core.Set.getValue(localCursor, "flex_duration");
        int i18 = androidx.room.core.Set.getValue(localCursor, "run_attempt_count");
        int i19 = androidx.room.core.Set.getValue(localCursor, "backoff_policy");
        int i20 = androidx.room.core.Set.getValue(localCursor, "backoff_delay_duration");
        int i21 = androidx.room.core.Set.getValue(localCursor, "period_start_time");
        int i = androidx.room.core.Set.getValue(localCursor, "minimum_retention_duration");
        int m = androidx.room.core.Set.getValue(localCursor, "schedule_requested_at");
        int k = androidx.room.core.Set.getValue(localCursor, "run_in_foreground");
        int i22 = androidx.room.core.Set.getValue(localCursor, "out_of_quota_policy");
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        for (;;)
        {
          boolean bool = localCursor.moveToNext();
          if (!bool) {
            break;
          }
          java.lang.Object localObject = localCursor.getString(i9);
          String str = localCursor.getString(i11);
          androidx.work.i localI = new androidx.work.i();
          localI.b(Handler.a(localCursor.getInt(i1)));
          int i23 = localCursor.getInt(i2);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.b(bool);
          i23 = localCursor.getInt(i3);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.a(bool);
          i23 = localCursor.getInt(i4);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.g(bool);
          i23 = localCursor.getInt(i5);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.e(bool);
          localI.a(localCursor.getLong(i6));
          localI.b(localCursor.getLong(i7));
          localI.add(Handler.read(localCursor.getBlob(i8)));
          localObject = new h((String)localObject, str);
          p = Handler.b(localCursor.getInt(i10));
          m = localCursor.getString(i12);
          c = Label.read(localCursor.getBlob(i13));
          s = Label.read(localCursor.getBlob(i14));
          n = localCursor.getLong(i15);
          j = localCursor.getLong(i16);
          i = localCursor.getLong(i17);
          e = localCursor.getInt(i18);
          d = Handler.c(localCursor.getInt(i19));
          f = localCursor.getLong(i20);
          w = localCursor.getLong(i21);
          l = localCursor.getLong(i);
          g = localCursor.getLong(m);
          i23 = localCursor.getInt(k);
          if (i23 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          h = bool;
          y = Handler.getValue(localCursor.getInt(i22));
          b = localI;
          localArrayList.add(localObject);
        }
        localCursor.close();
        localLog.release();
        return localArrayList;
      }
      catch (Throwable localThrowable1) {}
      localCursor.close();
    }
    catch (Throwable localThrowable2) {}
    localLog.release();
    throw localThrowable2;
  }
  
  public List run(int paramInt)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
    localLog.bindLong(1, paramInt);
    c.size();
    Cursor localCursor = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      int m = androidx.room.core.Set.getValue(localCursor, "required_network_type");
      int i1 = androidx.room.core.Set.getValue(localCursor, "requires_charging");
      int i2 = androidx.room.core.Set.getValue(localCursor, "requires_device_idle");
      int i3 = androidx.room.core.Set.getValue(localCursor, "requires_battery_not_low");
      int i4 = androidx.room.core.Set.getValue(localCursor, "requires_storage_not_low");
      int i5 = androidx.room.core.Set.getValue(localCursor, "trigger_content_update_delay");
      int i6 = androidx.room.core.Set.getValue(localCursor, "trigger_max_content_delay");
      int i7 = androidx.room.core.Set.getValue(localCursor, "content_uri_triggers");
      int i8 = androidx.room.core.Set.getValue(localCursor, "id");
      int i9 = androidx.room.core.Set.getValue(localCursor, "state");
      int i10 = androidx.room.core.Set.getValue(localCursor, "worker_class_name");
      int i11 = androidx.room.core.Set.getValue(localCursor, "input_merger_class_name");
      int i12 = androidx.room.core.Set.getValue(localCursor, "input");
      int i13 = androidx.room.core.Set.getValue(localCursor, "output");
      try
      {
        int i14 = androidx.room.core.Set.getValue(localCursor, "initial_delay");
        int i15 = androidx.room.core.Set.getValue(localCursor, "interval_duration");
        int i16 = androidx.room.core.Set.getValue(localCursor, "flex_duration");
        int i17 = androidx.room.core.Set.getValue(localCursor, "run_attempt_count");
        int i18 = androidx.room.core.Set.getValue(localCursor, "backoff_policy");
        int i19 = androidx.room.core.Set.getValue(localCursor, "backoff_delay_duration");
        int i20 = androidx.room.core.Set.getValue(localCursor, "period_start_time");
        paramInt = androidx.room.core.Set.getValue(localCursor, "minimum_retention_duration");
        int k = androidx.room.core.Set.getValue(localCursor, "schedule_requested_at");
        int i = androidx.room.core.Set.getValue(localCursor, "run_in_foreground");
        int i21 = androidx.room.core.Set.getValue(localCursor, "out_of_quota_policy");
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        for (;;)
        {
          boolean bool = localCursor.moveToNext();
          if (!bool) {
            break;
          }
          java.lang.Object localObject = localCursor.getString(i8);
          String str = localCursor.getString(i10);
          androidx.work.i localI = new androidx.work.i();
          localI.b(Handler.a(localCursor.getInt(m)));
          int i22 = localCursor.getInt(i1);
          if (i22 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.b(bool);
          i22 = localCursor.getInt(i2);
          if (i22 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.a(bool);
          i22 = localCursor.getInt(i3);
          if (i22 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.g(bool);
          i22 = localCursor.getInt(i4);
          if (i22 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localI.e(bool);
          localI.a(localCursor.getLong(i5));
          localI.b(localCursor.getLong(i6));
          localI.add(Handler.read(localCursor.getBlob(i7)));
          localObject = new h((String)localObject, str);
          p = Handler.b(localCursor.getInt(i9));
          m = localCursor.getString(i11);
          c = Label.read(localCursor.getBlob(i12));
          s = Label.read(localCursor.getBlob(i13));
          n = localCursor.getLong(i14);
          j = localCursor.getLong(i15);
          i = localCursor.getLong(i16);
          e = localCursor.getInt(i17);
          d = Handler.c(localCursor.getInt(i18));
          f = localCursor.getLong(i19);
          w = localCursor.getLong(i20);
          l = localCursor.getLong(paramInt);
          g = localCursor.getLong(k);
          i22 = localCursor.getInt(i);
          if (i22 != 0) {
            bool = true;
          } else {
            bool = false;
          }
          h = bool;
          y = Handler.getValue(localCursor.getInt(i21));
          b = localI;
          localArrayList.add(localObject);
        }
        localCursor.close();
        localLog.release();
        return localArrayList;
      }
      catch (Throwable localThrowable1) {}
      localCursor.close();
    }
    catch (Throwable localThrowable2) {}
    localLog.release();
    throw localThrowable2;
  }
  
  /* Error */
  public List run(String paramString)
  {
    // Byte code:
    //   0: ldc_w 492
    //   3: iconst_1
    //   4: invokestatic 145	androidx/room/Log:get	(Ljava/lang/String;I)Landroidx/room/Log;
    //   7: astore 9
    //   9: aload_1
    //   10: ifnonnull +12 -> 22
    //   13: aload 9
    //   15: iconst_1
    //   16: invokevirtual 161	androidx/room/Log:bindNull	(I)V
    //   19: goto +10 -> 29
    //   22: aload 9
    //   24: iconst_1
    //   25: aload_1
    //   26: invokevirtual 165	androidx/room/Log:bindString	(ILjava/lang/String;)V
    //   29: aload_0
    //   30: getfield 27	androidx/work/impl/asm/f:c	Landroidx/room/RoomDatabase;
    //   33: invokevirtual 221	androidx/room/RoomDatabase:size	()V
    //   36: aload_0
    //   37: getfield 27	androidx/work/impl/asm/f:c	Landroidx/room/RoomDatabase;
    //   40: invokevirtual 245	androidx/room/RoomDatabase:add	()V
    //   43: aload_0
    //   44: getfield 27	androidx/work/impl/asm/f:c	Landroidx/room/RoomDatabase;
    //   47: aload 9
    //   49: iconst_1
    //   50: aconst_null
    //   51: invokestatic 170	androidx/room/core/Log:get	(Landroidx/room/RoomDatabase;Lv7/td/data/Transaction;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   54: astore 10
    //   56: aload 10
    //   58: ldc_w 280
    //   61: invokestatic 264	androidx/room/core/Set:getValue	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   64: istore_2
    //   65: aload 10
    //   67: ldc_w 282
    //   70: invokestatic 264	androidx/room/core/Set:getValue	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   73: istore_3
    //   74: aload 10
    //   76: ldc_w 290
    //   79: invokestatic 264	androidx/room/core/Set:getValue	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   82: istore 4
    //   84: aload 10
    //   86: ldc_w 298
    //   89: invokestatic 264	androidx/room/core/Set:getValue	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   92: istore 5
    //   94: new 81	v7/util/ArrayMap
    //   97: dup
    //   98: invokespecial 493	v7/util/ArrayMap:<init>	()V
    //   101: astore 11
    //   103: new 81	v7/util/ArrayMap
    //   106: dup
    //   107: invokespecial 493	v7/util/ArrayMap:<init>	()V
    //   110: astore 12
    //   112: aload 10
    //   114: invokeinterface 186 1 0
    //   119: istore 6
    //   121: iload 6
    //   123: ifeq +114 -> 237
    //   126: aload 10
    //   128: iload_2
    //   129: invokeinterface 190 2 0
    //   134: istore 6
    //   136: iload 6
    //   138: ifne +42 -> 180
    //   141: aload 10
    //   143: iload_2
    //   144: invokeinterface 194 2 0
    //   149: astore_1
    //   150: aload 11
    //   152: aload_1
    //   153: invokevirtual 197	v7/util/SimpleArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 109	java/util/ArrayList
    //   159: astore 7
    //   161: aload 7
    //   163: ifnonnull +17 -> 180
    //   166: aload 11
    //   168: aload_1
    //   169: new 109	java/util/ArrayList
    //   172: dup
    //   173: invokespecial 494	java/util/ArrayList:<init>	()V
    //   176: invokevirtual 113	v7/util/SimpleArrayMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: pop
    //   180: aload 10
    //   182: iload_2
    //   183: invokeinterface 190 2 0
    //   188: istore 6
    //   190: iload 6
    //   192: ifne -80 -> 112
    //   195: aload 10
    //   197: iload_2
    //   198: invokeinterface 194 2 0
    //   203: astore_1
    //   204: aload 12
    //   206: aload_1
    //   207: invokevirtual 197	v7/util/SimpleArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 109	java/util/ArrayList
    //   213: astore 7
    //   215: aload 7
    //   217: ifnonnull -105 -> 112
    //   220: aload 12
    //   222: aload_1
    //   223: new 109	java/util/ArrayList
    //   226: dup
    //   227: invokespecial 494	java/util/ArrayList:<init>	()V
    //   230: invokevirtual 113	v7/util/SimpleArrayMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: pop
    //   234: goto -122 -> 112
    //   237: aload 10
    //   239: iconst_m1
    //   240: invokeinterface 497 2 0
    //   245: pop
    //   246: aload_0
    //   247: aload 11
    //   249: invokespecial 214	androidx/work/impl/asm/f:getData	(Lv7/util/ArrayMap;)V
    //   252: aload_0
    //   253: aload 12
    //   255: invokespecial 115	androidx/work/impl/asm/f:get	(Lv7/util/ArrayMap;)V
    //   258: new 109	java/util/ArrayList
    //   261: dup
    //   262: aload 10
    //   264: invokeinterface 425 1 0
    //   269: invokespecial 426	java/util/ArrayList:<init>	(I)V
    //   272: astore 13
    //   274: aload 10
    //   276: invokeinterface 186 1 0
    //   281: istore 6
    //   283: iload 6
    //   285: ifeq +197 -> 482
    //   288: aload 10
    //   290: iload_2
    //   291: invokeinterface 190 2 0
    //   296: istore 6
    //   298: iload 6
    //   300: ifne +23 -> 323
    //   303: aload 11
    //   305: aload 10
    //   307: iload_2
    //   308: invokeinterface 194 2 0
    //   313: invokevirtual 197	v7/util/SimpleArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   316: checkcast 109	java/util/ArrayList
    //   319: astore_1
    //   320: goto +5 -> 325
    //   323: aconst_null
    //   324: astore_1
    //   325: aload_1
    //   326: astore 7
    //   328: aload_1
    //   329: ifnonnull +12 -> 341
    //   332: new 109	java/util/ArrayList
    //   335: dup
    //   336: invokespecial 494	java/util/ArrayList:<init>	()V
    //   339: astore 7
    //   341: aload 10
    //   343: iload_2
    //   344: invokeinterface 190 2 0
    //   349: istore 6
    //   351: iload 6
    //   353: ifne +23 -> 376
    //   356: aload 12
    //   358: aload 10
    //   360: iload_2
    //   361: invokeinterface 194 2 0
    //   366: invokevirtual 197	v7/util/SimpleArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   369: checkcast 109	java/util/ArrayList
    //   372: astore_1
    //   373: goto +5 -> 378
    //   376: aconst_null
    //   377: astore_1
    //   378: aload_1
    //   379: astore 8
    //   381: aload_1
    //   382: ifnonnull +12 -> 394
    //   385: new 109	java/util/ArrayList
    //   388: dup
    //   389: invokespecial 494	java/util/ArrayList:<init>	()V
    //   392: astore 8
    //   394: new 499	androidx/work/impl/asm/Label
    //   397: dup
    //   398: invokespecial 500	androidx/work/impl/asm/Label:<init>	()V
    //   401: astore_1
    //   402: aload_1
    //   403: aload 10
    //   405: iload_2
    //   406: invokeinterface 194 2 0
    //   411: putfield 502	androidx/work/impl/asm/Label:h	Ljava/lang/String;
    //   414: aload_1
    //   415: aload 10
    //   417: iload_3
    //   418: invokeinterface 322 2 0
    //   423: invokestatic 362	androidx/work/impl/asm/Handler:b	(I)Landroidx/work/WorkInfo$State;
    //   426: putfield 504	androidx/work/impl/asm/Label:j	Landroidx/work/WorkInfo$State;
    //   429: aload_1
    //   430: aload 10
    //   432: iload 4
    //   434: invokeinterface 201 2 0
    //   439: invokestatic 207	androidx/work/Label:read	([B)Landroidx/work/Label;
    //   442: putfield 505	androidx/work/impl/asm/Label:c	Landroidx/work/Label;
    //   445: aload_1
    //   446: aload 10
    //   448: iload 5
    //   450: invokeinterface 322 2 0
    //   455: putfield 507	androidx/work/impl/asm/Label:b	I
    //   458: aload_1
    //   459: aload 7
    //   461: putfield 510	androidx/work/impl/asm/Label:f	Ljava/util/List;
    //   464: aload_1
    //   465: aload 8
    //   467: putfield 512	androidx/work/impl/asm/Label:a	Ljava/util/List;
    //   470: aload 13
    //   472: aload_1
    //   473: invokeinterface 429 2 0
    //   478: pop
    //   479: goto -205 -> 274
    //   482: aload_0
    //   483: getfield 27	androidx/work/impl/asm/f:c	Landroidx/room/RoomDatabase;
    //   486: invokevirtual 253	androidx/room/RoomDatabase:remove	()V
    //   489: aload 10
    //   491: invokeinterface 183 1 0
    //   496: aload 9
    //   498: invokevirtual 420	androidx/room/Log:release	()V
    //   501: aload_0
    //   502: getfield 27	androidx/work/impl/asm/f:c	Landroidx/room/RoomDatabase;
    //   505: invokevirtual 256	androidx/room/RoomDatabase:clear	()V
    //   508: aload 13
    //   510: areturn
    //   511: astore_1
    //   512: aload 10
    //   514: invokeinterface 183 1 0
    //   519: aload 9
    //   521: invokevirtual 420	androidx/room/Log:release	()V
    //   524: aload_1
    //   525: athrow
    //   526: astore_1
    //   527: aload_0
    //   528: getfield 27	androidx/work/impl/asm/f:c	Landroidx/room/RoomDatabase;
    //   531: invokevirtual 256	androidx/room/RoomDatabase:clear	()V
    //   534: aload_1
    //   535: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	this	f
    //   0	536	1	paramString	String
    //   64	342	2	i	int
    //   73	345	3	k	int
    //   82	351	4	m	int
    //   92	357	5	i1	int
    //   119	233	6	bool	boolean
    //   159	301	7	localObject1	java.lang.Object
    //   379	87	8	localObject2	java.lang.Object
    //   7	513	9	localLog	androidx.room.Log
    //   54	459	10	localCursor	Cursor
    //   101	203	11	localArrayMap1	ArrayMap
    //   110	247	12	localArrayMap2	ArrayMap
    //   272	237	13	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   56	112	511	java/lang/Throwable
    //   112	121	511	java/lang/Throwable
    //   126	136	511	java/lang/Throwable
    //   141	161	511	java/lang/Throwable
    //   166	180	511	java/lang/Throwable
    //   180	190	511	java/lang/Throwable
    //   195	215	511	java/lang/Throwable
    //   220	234	511	java/lang/Throwable
    //   237	274	511	java/lang/Throwable
    //   274	283	511	java/lang/Throwable
    //   288	298	511	java/lang/Throwable
    //   303	320	511	java/lang/Throwable
    //   332	341	511	java/lang/Throwable
    //   341	351	511	java/lang/Throwable
    //   356	373	511	java/lang/Throwable
    //   385	394	511	java/lang/Throwable
    //   394	479	511	java/lang/Throwable
    //   482	489	511	java/lang/Throwable
    //   43	56	526	java/lang/Throwable
    //   489	501	526	java/lang/Throwable
    //   512	526	526	java/lang/Throwable
  }
  
  public List write(String paramString)
  {
    androidx.room.Log localLog = androidx.room.Log.get("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
    if (paramString == null) {
      localLog.bindNull(1);
    } else {
      localLog.bindString(1, paramString);
    }
    c.size();
    paramString = androidx.room.core.Log.get(c, localLog, false, null);
    try
    {
      ArrayList localArrayList = new ArrayList(paramString.getCount());
      for (;;)
      {
        boolean bool = paramString.moveToNext();
        if (!bool) {
          break;
        }
        localArrayList.add(paramString.getString(0));
      }
      paramString.close();
      localLog.release();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      paramString.close();
      localLog.release();
      throw localThrowable;
    }
  }
}
