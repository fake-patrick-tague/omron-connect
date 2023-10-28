package androidx.fragment.package_11.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.m;
import androidx.fragment.package_11.Fragment;
import androidx.fragment.package_11.FragmentHostCallback;
import androidx.fragment.package_11.FragmentManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.collections.a0;
import kotlin.collections.g0;

public final class FragmentStrictMode
{
  public static final FragmentStrictMode c = new FragmentStrictMode();
  private static b o = b.SE;
  
  private FragmentStrictMode() {}
  
  private final b a(Fragment paramFragment)
  {
    while (paramFragment != null)
    {
      if (paramFragment.isAdded())
      {
        FragmentManager localFragmentManager = paramFragment.getParentFragmentManager();
        kotlin.x.d.i.d(localFragmentManager, "declaringFragment.parentFragmentManager");
        if (localFragmentManager.e() != null)
        {
          paramFragment = localFragmentManager.e();
          kotlin.x.d.i.b(paramFragment);
          return paramFragment;
        }
      }
      paramFragment = paramFragment.getParentFragment();
    }
    return o;
  }
  
  public static final void a(Fragment paramFragment, ViewGroup paramViewGroup)
  {
    kotlin.x.d.i.e(paramFragment, "fragment");
    paramViewGroup = new Handle(paramFragment, paramViewGroup);
    FragmentStrictMode localFragmentStrictMode = c;
    localFragmentStrictMode.a(paramViewGroup);
    b localB = localFragmentStrictMode.a(paramFragment);
    if ((localB.get().contains(Flag.y)) && (localFragmentStrictMode.add(localB, paramFragment.getClass(), paramViewGroup.getClass()))) {
      localFragmentStrictMode.a(localB, paramViewGroup);
    }
  }
  
  public static final void a(Fragment paramFragment1, Fragment paramFragment2, int paramInt)
  {
    kotlin.x.d.i.e(paramFragment1, "violatingFragment");
    kotlin.x.d.i.e(paramFragment2, "targetFragment");
    paramFragment2 = new j(paramFragment1, paramFragment2, paramInt);
    FragmentStrictMode localFragmentStrictMode = c;
    localFragmentStrictMode.a(paramFragment2);
    b localB = localFragmentStrictMode.a(paramFragment1);
    if ((localB.get().contains(Flag.a)) && (localFragmentStrictMode.add(localB, paramFragment1.getClass(), paramFragment2.getClass()))) {
      localFragmentStrictMode.a(localB, paramFragment2);
    }
  }
  
  public static final void a(Fragment paramFragment, boolean paramBoolean)
  {
    kotlin.x.d.i.e(paramFragment, "fragment");
    LineAndPointFormatter localLineAndPointFormatter = new LineAndPointFormatter(paramFragment, paramBoolean);
    FragmentStrictMode localFragmentStrictMode = c;
    localFragmentStrictMode.a(localLineAndPointFormatter);
    b localB = localFragmentStrictMode.a(paramFragment);
    if ((localB.get().contains(Flag.x)) && (localFragmentStrictMode.add(localB, paramFragment.getClass(), localLineAndPointFormatter.getClass()))) {
      localFragmentStrictMode.a(localB, localLineAndPointFormatter);
    }
  }
  
  private final void a(b paramB, d paramD)
  {
    Fragment localFragment = paramD.a();
    String str = localFragment.getClass().getName();
    if (paramB.get().contains(Flag.m))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Policy violation in ");
      localStringBuilder.append(str);
      Log.d("FragmentStrictMode", localStringBuilder.toString(), paramD);
    }
    if (paramB.b() != null) {
      init(localFragment, new AndroidCallableWrapper.2(paramB, paramD));
    }
    if (paramB.get().contains(Flag.b)) {
      init(localFragment, new b(str, paramD));
    }
  }
  
  private final void a(d paramD)
  {
    if (FragmentManager.get(3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StrictMode violation in ");
      localStringBuilder.append(paramD.a().getClass().getName());
      Log.d("FragmentManager", localStringBuilder.toString(), paramD);
    }
  }
  
  public static final void add(Fragment paramFragment, ViewGroup paramViewGroup)
  {
    kotlin.x.d.i.e(paramFragment, "fragment");
    kotlin.x.d.i.e(paramViewGroup, "container");
    paramViewGroup = new c(paramFragment, paramViewGroup);
    FragmentStrictMode localFragmentStrictMode = c;
    localFragmentStrictMode.a(paramViewGroup);
    b localB = localFragmentStrictMode.a(paramFragment);
    if ((localB.get().contains(Flag.q)) && (localFragmentStrictMode.add(localB, paramFragment.getClass(), paramViewGroup.getClass()))) {
      localFragmentStrictMode.a(localB, paramViewGroup);
    }
  }
  
  public static final void add(Fragment paramFragment, String paramString)
  {
    kotlin.x.d.i.e(paramFragment, "fragment");
    kotlin.x.d.i.e(paramString, "previousFragmentId");
    paramString = new Type(paramFragment, paramString);
    FragmentStrictMode localFragmentStrictMode = c;
    localFragmentStrictMode.a(paramString);
    b localB = localFragmentStrictMode.a(paramFragment);
    if ((localB.get().contains(Flag.l)) && (localFragmentStrictMode.add(localB, paramFragment.getClass(), paramString.getClass()))) {
      localFragmentStrictMode.a(localB, paramString);
    }
  }
  
  private final boolean add(b paramB, Class paramClass1, Class paramClass2)
  {
    paramClass1 = paramClass1.getName();
    paramB = (Set)paramB.value().get(paramClass1);
    if (paramB == null) {
      return true;
    }
    if ((!kotlin.x.d.i.a(paramClass2.getSuperclass(), m.class)) && (kotlin.collections.i.o(paramB, paramClass2.getSuperclass()))) {
      return false;
    }
    return paramB.contains(paramClass2) ^ true;
  }
  
  public static final void b(Fragment paramFragment)
  {
    kotlin.x.d.i.e(paramFragment, "fragment");
    Welcome localWelcome = new Welcome(paramFragment);
    FragmentStrictMode localFragmentStrictMode = c;
    localFragmentStrictMode.a(localWelcome);
    b localB = localFragmentStrictMode.a(paramFragment);
    if ((localB.get().contains(Flag.h)) && (localFragmentStrictMode.add(localB, paramFragment.getClass(), localWelcome.getClass()))) {
      localFragmentStrictMode.a(localB, localWelcome);
    }
  }
  
  private static final void b(b paramB, d paramD)
  {
    kotlin.x.d.i.e(paramB, "$policy");
    kotlin.x.d.i.e(paramD, "$violation");
    paramB.b().c(paramD);
  }
  
  private static final void c(String paramString, d paramD)
  {
    kotlin.x.d.i.e(paramD, "$violation");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Policy violation with PENALTY_DEATH in ");
    localStringBuilder.append(paramString);
    Log.e("FragmentStrictMode", localStringBuilder.toString(), paramD);
    throw paramD;
  }
  
  public static final void close(Fragment paramFragment)
  {
    kotlin.x.d.i.e(paramFragment, "fragment");
    MyActivity localMyActivity = new MyActivity(paramFragment);
    FragmentStrictMode localFragmentStrictMode = c;
    localFragmentStrictMode.a(localMyActivity);
    b localB = localFragmentStrictMode.a(paramFragment);
    if ((localB.get().contains(Flag.a)) && (localFragmentStrictMode.add(localB, paramFragment.getClass(), localMyActivity.getClass()))) {
      localFragmentStrictMode.a(localB, localMyActivity);
    }
  }
  
  public static final void e(Fragment paramFragment)
  {
    kotlin.x.d.i.e(paramFragment, "fragment");
    Settings localSettings = new Settings(paramFragment);
    FragmentStrictMode localFragmentStrictMode = c;
    localFragmentStrictMode.a(localSettings);
    b localB = localFragmentStrictMode.a(paramFragment);
    if ((localB.get().contains(Flag.h)) && (localFragmentStrictMode.add(localB, paramFragment.getClass(), localSettings.getClass()))) {
      localFragmentStrictMode.a(localB, localSettings);
    }
  }
  
  private final void init(Fragment paramFragment, Runnable paramRunnable)
  {
    if (paramFragment.isAdded())
    {
      paramFragment = paramFragment.getParentFragmentManager().getContext().getHandler();
      kotlin.x.d.i.d(paramFragment, "fragment.parentFragmentManager.host.handler");
      if (kotlin.x.d.i.a(paramFragment.getLooper(), Looper.myLooper()))
      {
        paramRunnable.run();
        return;
      }
      paramFragment.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  public static final void setEnabled(Fragment paramFragment)
  {
    kotlin.x.d.i.e(paramFragment, "fragment");
    Analytics localAnalytics = new Analytics(paramFragment);
    FragmentStrictMode localFragmentStrictMode = c;
    localFragmentStrictMode.a(localAnalytics);
    b localB = localFragmentStrictMode.a(paramFragment);
    if ((localB.get().contains(Flag.a)) && (localFragmentStrictMode.add(localB, paramFragment.getClass(), localAnalytics.getClass()))) {
      localFragmentStrictMode.a(localB, localAnalytics);
    }
  }
  
  public enum Flag
  {
    static
    {
      b = new Flag("PENALTY_DEATH", 1);
      l = new Flag("DETECT_FRAGMENT_REUSE", 2);
      y = new Flag("DETECT_FRAGMENT_TAG_USAGE", 3);
      h = new Flag("DETECT_RETAIN_INSTANCE_USAGE", 4);
      x = new Flag("DETECT_SET_USER_VISIBLE_HINT", 5);
      a = new Flag("DETECT_TARGET_FRAGMENT_USAGE", 6);
      q = new Flag("DETECT_WRONG_FRAGMENT_CONTAINER", 7);
    }
  }
  
  public abstract interface a
  {
    public abstract void c(d paramD);
  }
  
  public final class b
  {
    public static final a DSB = new a(null);
    public static final b SE = new b(g0.b(), null, a0.d());
    private final Map<String, Set<Class<? extends m>>> c;
    private final FragmentStrictMode.a j;
    
    public b(FragmentStrictMode.a paramA, Map paramMap)
    {
      j = paramA;
      this$1 = new LinkedHashMap();
      paramA = paramMap.entrySet().iterator();
      while (paramA.hasNext())
      {
        paramMap = (Map.Entry)paramA.next();
        put((String)paramMap.getKey(), (Set)paramMap.getValue());
      }
      c = FragmentStrictMode.this;
    }
    
    public final FragmentStrictMode.a b()
    {
      return j;
    }
    
    public final Set get()
    {
      return FragmentStrictMode.this;
    }
    
    public final Map value()
    {
      return c;
    }
    
    public final class a
    {
      private a() {}
    }
  }
}
