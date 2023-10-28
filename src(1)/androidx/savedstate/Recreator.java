package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.LayoutManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.x.d.i;

public final class Recreator
  implements LayoutManager
{
  public static final a magenta = new a(null);
  private final Label c;
  
  public Recreator(Label paramLabel)
  {
    c = paramLabel;
  }
  
  /* Error */
  private final void create(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: ldc 2
    //   4: invokevirtual 52	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   7: invokestatic 56	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   10: ldc 58
    //   12: invokevirtual 62	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   15: astore_2
    //   16: aload_2
    //   17: ldc 64
    //   19: invokestatic 67	kotlin/x/d/i:d	(Ljava/lang/Object;Ljava/lang/String;)V
    //   22: aload_2
    //   23: iconst_0
    //   24: anewarray 48	java/lang/Class
    //   27: invokevirtual 71	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   30: astore_3
    //   31: aload_3
    //   32: iconst_1
    //   33: invokevirtual 77	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   36: aload_3
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokevirtual 81	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore_2
    //   45: aload_2
    //   46: ldc 83
    //   48: invokestatic 67	kotlin/x/d/i:d	(Ljava/lang/Object;Ljava/lang/String;)V
    //   51: aload_2
    //   52: checkcast 85	androidx/savedstate/Type
    //   55: aload_0
    //   56: getfield 38	androidx/savedstate/Recreator:c	Landroidx/savedstate/Label;
    //   59: invokeinterface 87 2 0
    //   64: return
    //   65: astore_2
    //   66: new 89	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   73: astore_3
    //   74: aload_3
    //   75: ldc 92
    //   77: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_3
    //   82: aload_1
    //   83: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: new 98	java/lang/RuntimeException
    //   90: dup
    //   91: aload_3
    //   92: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: aload_2
    //   96: invokespecial 105	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: athrow
    //   100: astore_1
    //   101: new 89	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   108: astore_3
    //   109: aload_3
    //   110: ldc 107
    //   112: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_3
    //   117: aload_2
    //   118: invokevirtual 110	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   121: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_3
    //   126: ldc 112
    //   128: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: new 114	java/lang/IllegalStateException
    //   135: dup
    //   136: aload_3
    //   137: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: aload_1
    //   141: invokespecial 115	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   144: athrow
    //   145: astore_2
    //   146: new 89	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   153: astore_3
    //   154: aload_3
    //   155: ldc 107
    //   157: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_3
    //   162: aload_1
    //   163: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_3
    //   168: ldc 117
    //   170: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: new 98	java/lang/RuntimeException
    //   177: dup
    //   178: aload_3
    //   179: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: aload_2
    //   183: invokespecial 105	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	Recreator
    //   0	187	1	paramString	String
    //   15	37	2	localObject1	Object
    //   65	53	2	localException	Exception
    //   145	38	2	localClassNotFoundException	ClassNotFoundException
    //   30	149	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	51	65	java/lang/Exception
    //   22	31	100	java/lang/NoSuchMethodException
    //   0	22	145	java/lang/ClassNotFoundException
  }
  
  public void b(d paramD, Lifecycle.Event paramEvent)
  {
    i.e(paramD, "source");
    i.e(paramEvent, "event");
    if (paramEvent == Lifecycle.Event.ON_CREATE)
    {
      paramD.getLifecycle().clear(this);
      paramD = c.getSavedStateRegistry().a("androidx.savedstate.Restarter");
      if (paramD == null) {
        return;
      }
      paramD = paramD.getStringArrayList("classes_to_restore");
      if (paramD != null)
      {
        paramD = paramD.iterator();
        while (paramD.hasNext()) {
          create((String)paramD.next());
        }
        return;
      }
      throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
    }
    throw new AssertionError("Next event must be ON_CREATE");
  }
  
  public static final class a
  {
    private a() {}
  }
  
  public static final class b
    implements MenuItem
  {
    private final Set<String> d = new LinkedHashSet();
    
    public b(ClassWriter paramClassWriter)
    {
      paramClassWriter.a("androidx.savedstate.Restarter", this);
    }
    
    public final void a(String paramString)
    {
      i.e(paramString, "className");
      d.add(paramString);
    }
    
    public Bundle onSaveInstanceState()
    {
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("classes_to_restore", new ArrayList(d));
      return localBundle;
    }
  }
}
