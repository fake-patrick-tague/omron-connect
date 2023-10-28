package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.ListenableWorker.a;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class CombineContinuationsWorker
  extends Worker
{
  public CombineContinuationsWorker(Context paramContext, WorkerParameters paramWorkerParameters)
  {
    super(paramContext, paramWorkerParameters);
  }
  
  public ListenableWorker.a run()
  {
    return ListenableWorker.a.get(d());
  }
}
