package androidx.room;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import v7.td.data.Paint;

public class a
{
  public final boolean a;
  public final RoomDatabase.c b;
  public final String c;
  public final File d;
  public final List<RoomDatabase.b> e;
  public final Executor g;
  public final RoomDatabase.JournalMode h;
  public final boolean i;
  public final boolean k;
  public final boolean l;
  private final Set<Integer> m;
  public final Executor p;
  public final Paint q;
  public final Context r;
  public final String s;
  
  public a(Context paramContext, String paramString1, Paint paramPaint, RoomDatabase.c paramC, List paramList, boolean paramBoolean1, RoomDatabase.JournalMode paramJournalMode, Executor paramExecutor1, Executor paramExecutor2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Set paramSet, String paramString2, File paramFile)
  {
    q = paramPaint;
    r = paramContext;
    s = paramString1;
    b = paramC;
    e = paramList;
    a = paramBoolean1;
    h = paramJournalMode;
    g = paramExecutor1;
    p = paramExecutor2;
    i = paramBoolean2;
    k = paramBoolean3;
    l = paramBoolean4;
    m = paramSet;
    c = paramString2;
    d = paramFile;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if ((paramInt2 != 0) && (l)) {
      return false;
    }
    if (k)
    {
      Set localSet = m;
      if (localSet == null) {
        break label58;
      }
      if (!localSet.contains(Integer.valueOf(paramInt1))) {
        return true;
      }
    }
    return false;
    label58:
    return true;
  }
}
