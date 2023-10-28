package androidx.lifecycle;

class Main
  implements Context
{
  Main(Tracker paramTracker) {}
  
  public void onResume()
  {
    tracker.a();
  }
  
  public void onStart()
  {
    tracker.close();
  }
  
  public void setOptimizationLevel() {}
}
