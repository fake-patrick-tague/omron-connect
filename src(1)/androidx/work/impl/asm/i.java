package androidx.work.impl.asm;

import androidx.work.Label;
import androidx.work.WorkInfo.State;
import java.util.List;

public abstract interface i
{
  public abstract int a(WorkInfo.State paramState, String... paramVarArgs);
  
  public abstract h a(String paramString);
  
  public abstract List a();
  
  public abstract List a(int paramInt);
  
  public abstract List a(long paramLong);
  
  public abstract void a(h paramH);
  
  public abstract void a(String paramString, long paramLong);
  
  public abstract void a(String paramString, Label paramLabel);
  
  public abstract int add(String paramString);
  
  public abstract int add(String paramString, long paramLong);
  
  public abstract void b(String paramString);
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract int clear(String paramString);
  
  public abstract List doInBackground(String paramString);
  
  public abstract WorkInfo.State get(String paramString);
  
  public abstract List getAll(String paramString);
  
  public abstract List getSeasons(String paramString);
  
  public abstract List run();
  
  public abstract List run(int paramInt);
  
  public abstract List run(String paramString);
  
  public abstract List write(String paramString);
}
