package androidx.work.impl;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters.a;
import androidx.work.impl.foreground.Item;
import java.util.List;

public class e
{
  Context a;
  String c;
  androidx.work.f d;
  List<e> e;
  androidx.work.impl.utils.asm.f f;
  ListenableWorker h;
  WorkerParameters.a i = new WorkerParameters.a();
  Item j;
  WorkDatabase n;
  
  public e(Context paramContext, androidx.work.f paramF, androidx.work.impl.utils.asm.f paramF1, Item paramItem, WorkDatabase paramWorkDatabase, String paramString)
  {
    a = paramContext.getApplicationContext();
    f = paramF1;
    j = paramItem;
    d = paramF;
    n = paramWorkDatabase;
    c = paramString;
  }
  
  public e a(WorkerParameters.a paramA)
  {
    if (paramA != null) {
      i = paramA;
    }
    return this;
  }
  
  public e a(List paramList)
  {
    e = paramList;
    return this;
  }
  
  public i a()
  {
    return new i(this);
  }
}
