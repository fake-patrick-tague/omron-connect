package androidx.transition;

public class AutoTransition
  extends TransitionSet
{
  public AutoTransition()
  {
    onCreate();
  }
  
  private void onCreate()
  {
    close(1);
    init(new Fade(2)).init(new ChangeBounds()).init(new Fade(1));
  }
}
