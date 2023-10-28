package androidx.lifecycle;

abstract interface Context
{
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void setOptimizationLevel();
}
