package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle
{
  AtomicReference<Object> val$_exception = new AtomicReference();
  
  public Lifecycle() {}
  
  public abstract void a(MenuItem paramMenuItem);
  
  public abstract State c();
  
  public abstract void clear(MenuItem paramMenuItem);
  
  public static enum Event
  {
    static
    {
      Event localEvent1 = new Event("ON_CREATE", 0);
      ON_CREATE = localEvent1;
      Event localEvent2 = new Event("ON_START", 1);
      ON_START = localEvent2;
      Event localEvent3 = new Event("ON_RESUME", 2);
      ON_RESUME = localEvent3;
      Event localEvent4 = new Event("ON_PAUSE", 3);
      ON_PAUSE = localEvent4;
      Event localEvent5 = new Event("ON_STOP", 4);
      ON_STOP = localEvent5;
      Event localEvent6 = new Event("ON_DESTROY", 5);
      ON_DESTROY = localEvent6;
      Event localEvent7 = new Event("ON_ANY", 6);
      ON_ANY = localEvent7;
      $VALUES = new Event[] { localEvent1, localEvent2, localEvent3, localEvent4, localEvent5, localEvent6, localEvent7 };
    }
    
    public static Event a(Lifecycle.State paramState)
    {
      int i = Lifecycle.a.d[paramState.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 5) {
            return null;
          }
          return ON_CREATE;
        }
        return ON_RESUME;
      }
      return ON_START;
    }
    
    public static Event b(Lifecycle.State paramState)
    {
      int i = Lifecycle.a.d[paramState.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          return ON_PAUSE;
        }
        return ON_STOP;
      }
      return ON_DESTROY;
    }
    
    public static Event pack(Lifecycle.State paramState)
    {
      int i = Lifecycle.a.d[paramState.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          return ON_RESUME;
        }
        return ON_START;
      }
      return ON_CREATE;
    }
    
    public Lifecycle.State a()
    {
      switch (Lifecycle.a.o[ordinal()])
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this);
        localStringBuilder.append(" has no target state");
        throw new IllegalArgumentException(localStringBuilder.toString());
      case 6: 
        return Lifecycle.State.c;
      case 5: 
        return Lifecycle.State.y;
      case 3: 
      case 4: 
        return Lifecycle.State.g;
      }
      return Lifecycle.State.d;
    }
  }
  
  public static enum State
  {
    static
    {
      State localState1 = new State("DESTROYED", 0);
      c = localState1;
      State localState2 = new State("INITIALIZED", 1);
      i = localState2;
      State localState3 = new State("CREATED", 2);
      d = localState3;
      State localState4 = new State("STARTED", 3);
      g = localState4;
      State localState5 = new State("RESUMED", 4);
      y = localState5;
      a = new State[] { localState1, localState2, localState3, localState4, localState5 };
    }
    
    public boolean a(State paramState)
    {
      return compareTo(paramState) >= 0;
    }
  }
}
