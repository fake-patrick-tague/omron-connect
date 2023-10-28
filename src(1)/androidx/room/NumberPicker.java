package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class NumberPicker
{
  final AtomicBoolean a = new AtomicBoolean(false);
  final c b = new o(this);
  b c;
  final d e;
  final Runnable handler;
  final i l;
  final ServiceConnection mConnection;
  final Context mContext;
  final Runnable mListener;
  private final Runnable r;
  int t;
  final Executor this$0;
  final String w;
  
  NumberPicker(Context paramContext, String paramString, i paramI, Executor paramExecutor)
  {
    OpenPgpServiceConnection.1 local1 = new OpenPgpServiceConnection.1(this);
    mConnection = local1;
    mListener = new MonthByWeekFragment.2(this);
    handler = new DayFragment.1(this);
    r = new EventInfoFragment.1(this);
    paramContext = paramContext.getApplicationContext();
    mContext = paramContext;
    w = paramString;
    l = paramI;
    this$0 = paramExecutor;
    e = new e.a(this, (String[])h.keySet().toArray(new String[0]));
    paramContext.bindService(new Intent(paramContext, MultiInstanceInvalidationService.class), local1, 1);
  }
}
