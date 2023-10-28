package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.BaseBundle;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.Toolbar;
import c.e.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import v7.internal.view.ActionMode;
import v7.internal.view.ActionMode.Callback;
import v7.util.TLongArrayList;
import v7.v7.menu.Label;

public abstract class f
{
  private static Label a;
  private static Label b;
  private static final b<WeakReference<i>> c;
  private static Boolean d;
  private static final Object m = new Object();
  private static final Object p;
  private static int q;
  private static boolean r;
  static SerializingExecutor t = new SerializingExecutor(new Threading.2());
  
  static
  {
    q = -100;
    a = null;
    b = null;
    d = null;
    r = false;
    c = new TLongArrayList();
    p = new Object();
  }
  
  f() {}
  
  static Object a()
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (f)((WeakReference)localIterator.next()).get();
      if (localObject != null)
      {
        localObject = ((f)localObject).getContext();
        if (localObject != null) {
          return ((android.content.Context)localObject).getSystemService("locale");
        }
      }
    }
    return null;
  }
  
  private static void a(f paramF)
  {
    Object localObject = p;
    try
    {
      Iterator localIterator = c.iterator();
      while (localIterator.hasNext())
      {
        f localF = (f)((WeakReference)localIterator.next()).get();
        if ((localF == paramF) || (localF == null)) {
          localIterator.remove();
        }
      }
      return;
    }
    catch (Throwable paramF)
    {
      throw paramF;
    }
  }
  
  static void add(android.content.Context paramContext)
  {
    if (!d(paramContext)) {
      return;
    }
    if (v7.v7.menu.Context.get())
    {
      if (!r) {
        t.execute(new FileTransfer.5(paramContext));
      }
    }
    else
    {
      Object localObject = m;
      try
      {
        Label localLabel = a;
        if (localLabel == null)
        {
          if (b == null) {
            b = Label.a(Item.parse(paramContext));
          }
          if (b.a()) {
            return;
          }
          a = b;
        }
        else if (!localLabel.equals(b))
        {
          localLabel = a;
          b = localLabel;
          Item.save(paramContext, localLabel.put());
        }
        return;
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
  }
  
  static void add(f paramF)
  {
    Object localObject = p;
    try
    {
      a(paramF);
      c.add(new WeakReference(paramF));
      return;
    }
    catch (Throwable paramF)
    {
      throw paramF;
    }
  }
  
  public static Label b()
  {
    Object localObject;
    if (v7.v7.menu.Context.get())
    {
      localObject = a();
      if (localObject != null) {
        return Label.a(m.d(localObject));
      }
    }
    else
    {
      localObject = a;
      if (localObject != null) {
        return localObject;
      }
    }
    return Label.b();
  }
  
  static Label c()
  {
    return a;
  }
  
  static void close(f paramF)
  {
    Object localObject = p;
    try
    {
      a(paramF);
      return;
    }
    catch (Throwable paramF)
    {
      throw paramF;
    }
  }
  
  public static f create(Activity paramActivity, AppCompatCallback paramAppCompatCallback)
  {
    return new AppCompatDelegateImplV7(paramActivity, paramAppCompatCallback);
  }
  
  public static f create(Dialog paramDialog, AppCompatCallback paramAppCompatCallback)
  {
    return new AppCompatDelegateImplV7(paramDialog, paramAppCompatCallback);
  }
  
  static boolean d(android.content.Context paramContext)
  {
    if (d == null) {}
    try
    {
      paramContext = CustomTileListenerService.evaluate(paramContext);
      paramContext = metaData;
      if (paramContext == null) {
        break label51;
      }
      boolean bool = paramContext.getBoolean("autoStoreLocales");
      d = Boolean.valueOf(bool);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
    d = Boolean.FALSE;
    label51:
    return d.booleanValue();
  }
  
  public static int l()
  {
    return q;
  }
  
  public android.content.Context a(android.content.Context paramContext)
  {
    p(paramContext);
    return paramContext;
  }
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void e();
  
  public abstract View findViewById(int paramInt);
  
  public android.content.Context getContext()
  {
    return null;
  }
  
  public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  
  public abstract MenuInflater getMenuInflater();
  
  public abstract ActionBar getSupportActionBar();
  
  public abstract void installViewFactory();
  
  public abstract void invalidateOptionsMenu();
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onCreate();
  
  public void onCreate(int paramInt) {}
  
  public abstract void onCreate(Bundle paramBundle);
  
  public void onCreate(OnBackInvokedDispatcher paramOnBackInvokedDispatcher) {}
  
  public abstract void onPostCreate(Bundle paramBundle);
  
  public abstract void onPostResume();
  
  public abstract void onStop();
  
  public abstract void onTitleChanged(CharSequence paramCharSequence);
  
  public void p(android.content.Context paramContext) {}
  
  public abstract boolean requestWindowFeature(int paramInt);
  
  public abstract void setContentView(int paramInt);
  
  public abstract void setContentView(View paramView);
  
  public abstract void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void setSupportActionBar(Toolbar paramToolbar);
  
  public int size()
  {
    return -100;
  }
  
  public abstract ActionMode startSupportActionMode(ActionMode.Callback paramCallback);
}
