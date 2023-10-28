package androidx.emoji2.text;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.NavigationMenuPresenter;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.d;
import androidx.startup.b;
import androidx.startup.f;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import v7.v7.menu.TraceCompat;

public class EmojiCompatInitializer
  implements b<Boolean>
{
  public EmojiCompatInitializer() {}
  
  public Boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      ClassWriter.a(new a(paramContext));
      c(paramContext);
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  void c(final Context paramContext)
  {
    paramContext = ((d)f.a(paramContext).b(ProcessLifecycleInitializer.class)).getLifecycle();
    paramContext.a(new NavigationMenuPresenter()
    {
      public void b(d paramAnonymousD)
      {
        clear();
        paramContext.clear(this);
      }
    });
  }
  
  void clear()
  {
    Handler.init().postDelayed(new c(), 500L);
  }
  
  public List getCandidates()
  {
    return Collections.singletonList(ProcessLifecycleInitializer.class);
  }
  
  static class a
    extends Item
  {
    protected a(Context paramContext)
    {
      super();
      a(1);
    }
  }
  
  static class b
    implements Attribute
  {
    private final Context a;
    
    b(Context paramContext)
    {
      a = paramContext.getApplicationContext();
    }
    
    public void a(Paint paramPaint)
    {
      ThreadPoolExecutor localThreadPoolExecutor = Handler.create("EmojiCompatInitializer");
      localThreadPoolExecutor.execute(new InAppBrowser.1(this, paramPaint, localThreadPoolExecutor));
    }
    
    void a(final Paint paramPaint, final ThreadPoolExecutor paramThreadPoolExecutor)
    {
      try
      {
        ExtensionData localExtensionData = ClassReader.b(a);
        if (localExtensionData != null)
        {
          localExtensionData.a(paramThreadPoolExecutor);
          localExtensionData.a().a(new a(paramPaint, paramThreadPoolExecutor));
          return;
        }
        throw new RuntimeException("EmojiCompat font provider not available on this device.");
      }
      catch (Throwable localThrowable)
      {
        paramPaint.b(localThrowable);
        paramThreadPoolExecutor.shutdown();
      }
    }
    
    class a
      extends Paint
    {
      a(Paint paramPaint, ThreadPoolExecutor paramThreadPoolExecutor) {}
      
      public void b(h paramH)
      {
        try
        {
          paramPaint.b(paramH);
          paramThreadPoolExecutor.shutdown();
          return;
        }
        catch (Throwable paramH)
        {
          paramThreadPoolExecutor.shutdown();
          throw paramH;
        }
      }
      
      public void b(Throwable paramThrowable)
      {
        try
        {
          paramPaint.b(paramThrowable);
          paramThreadPoolExecutor.shutdown();
          return;
        }
        catch (Throwable paramThrowable)
        {
          paramThreadPoolExecutor.shutdown();
          throw paramThrowable;
        }
      }
    }
  }
  
  static class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      try
      {
        TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
        boolean bool = ClassWriter.c();
        if (bool) {
          ClassWriter.get().init();
        }
        TraceCompat.beginSection();
        return;
      }
      catch (Throwable localThrowable)
      {
        TraceCompat.beginSection();
        throw localThrowable;
      }
    }
  }
}
