package com.google.android.gms.analytics.licenses;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import androidx.loader.content.a;
import com.google.android.gms.internal.oss_licenses.zzc;
import java.util.List;

final class CursorLoader
  extends a<List<zzc>>
{
  private List<zzc> mCursor;
  private final Repository source;
  
  CursorLoader(Context paramContext, Repository paramRepository)
  {
    super(paramContext.getApplicationContext());
    source = paramRepository;
  }
  
  private final void deliverResult(List paramList)
  {
    mCursor = paramList;
    super.deliverResult(paramList);
  }
  
  private final List doInBackground()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a12 = a11\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  protected final void onStartLoading()
  {
    List localList = mCursor;
    if (localList != null)
    {
      deliverResult(localList);
      return;
    }
    forceLoad();
  }
  
  protected final void onStopLoading()
  {
    cancelLoad();
  }
}
