package androidx.fragment.package_11;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.x.d.i;
import v7.app.R.styleable;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.f;

public final class FragmentContainerView
  extends FrameLayout
{
  private final List<View> a = new ArrayList();
  private View.OnApplyWindowInsetsListener k;
  private final List<View> q = new ArrayList();
  private boolean visible = true;
  
  public FragmentContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public FragmentContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet != null)
    {
      String str2 = paramAttributeSet.getClassAttribute();
      String str1 = str2;
      int[] arrayOfInt = R.styleable.CameraPreference;
      i.d(arrayOfInt, "FragmentContainerView");
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, 0, 0);
      if (str2 == null)
      {
        str1 = paramAttributeSet.getString(R.styleable.BottomSheet_bs_moreText);
        paramContext = "android:name";
      }
      else
      {
        paramContext = "class";
      }
      paramAttributeSet.recycle();
      if (str1 != null)
      {
        if (isInEditMode()) {
          return;
        }
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append("FragmentContainerView must be within a FragmentActivity to use ");
        paramAttributeSet.append(paramContext);
        paramAttributeSet.append("=\"");
        paramAttributeSet.append(str1);
        paramAttributeSet.append('"');
        throw new UnsupportedOperationException(paramAttributeSet.toString());
      }
    }
  }
  
  public FragmentContainerView(Context paramContext, AttributeSet paramAttributeSet, FragmentManager paramFragmentManager)
  {
    super(paramContext, paramAttributeSet);
    String str = paramAttributeSet.getClassAttribute();
    Object localObject1 = str;
    Object localObject2 = R.styleable.CameraPreference;
    i.d(localObject2, "FragmentContainerView");
    localObject2 = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject2, 0, 0);
    if (str == null) {
      localObject1 = ((TypedArray)localObject2).getString(R.styleable.BottomSheet_bs_moreText);
    }
    str = ((TypedArray)localObject2).getString(R.styleable.ColorPickerView_alphaChannelText);
    ((TypedArray)localObject2).recycle();
    int i = getId();
    localObject2 = paramFragmentManager.findFragmentById(i);
    if ((localObject1 != null) && (localObject2 == null))
    {
      if (i == -1)
      {
        if (str != null)
        {
          paramContext = new StringBuilder();
          paramContext.append(" with tag ");
          paramContext.append(str);
          paramContext = paramContext.toString();
        }
        else
        {
          paramContext = "";
        }
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append("FragmentContainerView must have an android:id to add Fragment ");
        paramAttributeSet.append((String)localObject1);
        paramAttributeSet.append(paramContext);
        throw new IllegalStateException(paramAttributeSet.toString());
      }
      localObject1 = paramFragmentManager.getView().instantiate(paramContext.getClassLoader(), (String)localObject1);
      i.d(localObject1, "fm.fragmentFactory.insta?ontext.classLoader, name)");
      ((Fragment)localObject1).onInflate(paramContext, paramAttributeSet, null);
      paramFragmentManager.beginTransaction().a(true).a(this, (Fragment)localObject1, str).show();
    }
    paramFragmentManager.dump(this);
  }
  
  private final void remove(View paramView)
  {
    if (q.contains(paramView)) {
      a.add(paramView);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    i.e(paramView, "child");
    if (FragmentManager.add(paramView) != null)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
    paramLayoutParams.append(paramView);
    paramLayoutParams.append(" is not associated with a Fragment.");
    throw new IllegalStateException(paramLayoutParams.toString().toString());
  }
  
  public WindowInsets dispatchApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    i.e(paramWindowInsets, "insets");
    Object localObject2 = f.a(paramWindowInsets);
    i.d(localObject2, "toWindowInsetsCompat(insets)");
    Object localObject1 = k;
    if (localObject1 != null)
    {
      localObject2 = a.o;
      i.b(localObject1);
      localObject1 = f.a(((a)localObject2).b((View.OnApplyWindowInsetsListener)localObject1, this, paramWindowInsets));
    }
    else
    {
      localObject1 = ViewCompat.a(this, (f)localObject2);
    }
    i.d(localObject1, "if (applyWindowInsetsLis?, insetsCompat)\n        }");
    if (!((f)localObject1).isConsumed())
    {
      int i = 0;
      int j = getChildCount();
      while (i < j)
      {
        ViewCompat.b(getChildAt(i), (f)localObject1);
        i += 1;
      }
    }
    return paramWindowInsets;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    i.e(paramCanvas, "canvas");
    if (visible)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        super.drawChild(paramCanvas, (View)localIterator.next(), getDrawingTime());
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    i.e(paramCanvas, "canvas");
    i.e(paramView, "child");
    if ((visible) && ((a.isEmpty() ^ true)) && (a.contains(paramView))) {
      return false;
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void endViewTransition(View paramView)
  {
    i.e(paramView, "view");
    q.remove(paramView);
    if (a.remove(paramView)) {
      visible = true;
    }
    super.endViewTransition(paramView);
  }
  
  public final Fragment getFragment()
  {
    return FragmentManager.get(this).findFragmentById(getId());
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    i.e(paramWindowInsets, "insets");
    return paramWindowInsets;
  }
  
  public void removeAllViewsInLayout()
  {
    int i = getChildCount() - 1;
    while (-1 < i)
    {
      View localView = getChildAt(i);
      i.d(localView, "view");
      remove(localView);
      i -= 1;
    }
    super.removeAllViewsInLayout();
  }
  
  public void removeView(View paramView)
  {
    i.e(paramView, "view");
    remove(paramView);
    super.removeView(paramView);
  }
  
  public void removeViewAt(int paramInt)
  {
    View localView = getChildAt(paramInt);
    i.d(localView, "view");
    remove(localView);
    super.removeViewAt(paramInt);
  }
  
  public void removeViewInLayout(View paramView)
  {
    i.e(paramView, "view");
    remove(paramView);
    super.removeViewInLayout(paramView);
  }
  
  public void removeViews(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      View localView = getChildAt(i);
      i.d(localView, "view");
      remove(localView);
      i += 1;
    }
    super.removeViews(paramInt1, paramInt2);
  }
  
  public void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      View localView = getChildAt(i);
      i.d(localView, "view");
      remove(localView);
      i += 1;
    }
    super.removeViewsInLayout(paramInt1, paramInt2);
  }
  
  public final void setDrawDisappearingViewsLast(boolean paramBoolean)
  {
    visible = paramBoolean;
  }
  
  public void setLayoutTransition(LayoutTransition paramLayoutTransition)
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      super.setLayoutTransition(paramLayoutTransition);
      return;
    }
    throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
  }
  
  public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    i.e(paramOnApplyWindowInsetsListener, "listener");
    k = paramOnApplyWindowInsetsListener;
  }
  
  public void startViewTransition(View paramView)
  {
    i.e(paramView, "view");
    if (paramView.getParent() == this) {
      q.add(paramView);
    }
    super.startViewTransition(paramView);
  }
  
  public final class a
  {
    public static final a o = new a();
    
    private a() {}
    
    public final WindowInsets b(View.OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener, View paramView, WindowInsets paramWindowInsets)
    {
      i.e(paramOnApplyWindowInsetsListener, "onApplyWindowInsetsListener");
      i.e(paramView, "v");
      i.e(paramWindowInsets, "insets");
      paramOnApplyWindowInsetsListener = paramOnApplyWindowInsetsListener.onApplyWindowInsets(paramView, paramWindowInsets);
      i.d(paramOnApplyWindowInsetsListener, "onApplyWindowInsetsListe?lyWindowInsets(v, insets)");
      return paramOnApplyWindowInsetsListener;
    }
  }
}
