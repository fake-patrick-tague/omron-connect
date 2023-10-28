package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewGroupUtils;
import java.util.Iterator;
import java.util.List;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.utils.Attribute;
import v7.v7.package_13.ViewCompat;

public class ExtendedFloatingActionButton
  extends MaterialButton
  implements CoordinatorLayout.b
{
  static final Property<View, Float> Archive = new b(Float.class, "width");
  static final Property<View, Float> Sync = new c(Float.class, "height");
  static final Property<View, Float> TRANSLATION_X = new d(Float.class, "paddingStart");
  static final Property<View, Float> TRANSLATION_Y = new e(Float.class, "paddingEnd");
  private static final int u = R.string.u;
  private boolean SDK_INT;
  private final int ServerError;
  protected ColorStateList defaultColor;
  private final Slider field_5;
  private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> mBehavior;
  private int mInterval;
  private boolean mIsRtl;
  private int mPaddingLeft;
  private int mPaddingRight;
  private final Slider runner;
  private boolean skipInterval;
  private final Slider this$0;
  private final Slider threads;
  
  private boolean next()
  {
    return ((ViewCompat.set(this)) || ((!reset()) && (skipInterval))) && (!isInEditMode());
  }
  
  private boolean reset()
  {
    if (getVisibility() != 0)
    {
      if (mInterval == 2) {
        return true;
      }
    }
    else if (mInterval != 1) {
      return true;
    }
    return false;
  }
  
  private void setColor()
  {
    defaultColor = getTextColors();
  }
  
  private void start(final Slider paramSlider, f paramF)
  {
    if (paramSlider.setPriority()) {
      return;
    }
    if (!next())
    {
      paramSlider.start();
      paramSlider.resume(paramF);
      return;
    }
    measure(0, 0);
    AnimatorSet localAnimatorSet = paramSlider.setDuration();
    localAnimatorSet.addListener(new a(paramSlider, paramF));
    paramSlider = paramSlider.create().iterator();
    while (paramSlider.hasNext()) {
      localAnimatorSet.addListener((Animator.AnimatorListener)paramSlider.next());
    }
    localAnimatorSet.start();
  }
  
  public CoordinatorLayout.Behavior getBehavior()
  {
    return mBehavior;
  }
  
  int getCollapsedPadding()
  {
    return (getCollapsedSize() - getIconSize()) / 2;
  }
  
  int getCollapsedSize()
  {
    int j = ServerError;
    int i = j;
    if (j < 0) {
      i = Math.min(ViewCompat.add(this), ViewCompat.format(this)) * 2 + getIconSize();
    }
    return i;
  }
  
  public Attribute getExtendMotionSpec()
  {
    return threads.isDragging();
  }
  
  public Attribute getHideMotionSpec()
  {
    return field_5.isDragging();
  }
  
  public Attribute getShowMotionSpec()
  {
    return this$0.isDragging();
  }
  
  public Attribute getShrinkMotionSpec()
  {
    return runner.isDragging();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((mIsRtl) && (TextUtils.isEmpty(getText())) && (getIcon() != null))
    {
      mIsRtl = false;
      runner.start();
    }
  }
  
  public void setAnimateShowBeforeLayout(boolean paramBoolean)
  {
    skipInterval = paramBoolean;
  }
  
  public void setExtendMotionSpec(Attribute paramAttribute)
  {
    threads.setPriority(paramAttribute);
  }
  
  public void setExtendMotionSpecResource(int paramInt)
  {
    setExtendMotionSpec(Attribute.a(getContext(), paramInt));
  }
  
  public void setExtended(boolean paramBoolean)
  {
    if (mIsRtl == paramBoolean) {
      return;
    }
    Slider localSlider;
    if (paramBoolean) {
      localSlider = threads;
    } else {
      localSlider = runner;
    }
    if (localSlider.setPriority()) {
      return;
    }
    localSlider.start();
  }
  
  public void setHideMotionSpec(Attribute paramAttribute)
  {
    field_5.setPriority(paramAttribute);
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(Attribute.a(getContext(), paramInt));
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((mIsRtl) && (!SDK_INT))
    {
      mPaddingLeft = ViewCompat.add(this);
      mPaddingRight = ViewCompat.format(this);
    }
  }
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((mIsRtl) && (!SDK_INT))
    {
      mPaddingLeft = paramInt1;
      mPaddingRight = paramInt3;
    }
  }
  
  public void setShowMotionSpec(Attribute paramAttribute)
  {
    this$0.setPriority(paramAttribute);
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(Attribute.a(getContext(), paramInt));
  }
  
  public void setShrinkMotionSpec(Attribute paramAttribute)
  {
    runner.setPriority(paramAttribute);
  }
  
  public void setShrinkMotionSpecResource(int paramInt)
  {
    setShrinkMotionSpec(Attribute.a(getContext(), paramInt));
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    setColor();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
    setColor();
  }
  
  protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private boolean g;
    private boolean h;
    private ExtendedFloatingActionButton.f j;
    private Rect mTmpRect;
    private ExtendedFloatingActionButton.f o;
    
    public ExtendedFloatingActionButtonBehavior()
    {
      g = false;
      h = true;
    }
    
    public ExtendedFloatingActionButtonBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GraphViewXML);
      g = paramContext.getBoolean(R.styleable.GraphViewXML_seriesData, false);
      h = paramContext.getBoolean(R.styleable.CirclePageIndicator_centered, true);
      paramContext.recycle();
    }
    
    private boolean a(View paramView, ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      if (!c(paramView, paramExtendedFloatingActionButton)) {
        return false;
      }
      CoordinatorLayout.e localE = (CoordinatorLayout.e)paramExtendedFloatingActionButton.getLayoutParams();
      if (paramView.getTop() < paramExtendedFloatingActionButton.getHeight() / 2 + topMargin) {
        e(paramExtendedFloatingActionButton);
      } else {
        b(paramExtendedFloatingActionButton);
      }
      return true;
    }
    
    private boolean c(View paramView, ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      paramExtendedFloatingActionButton = (CoordinatorLayout.e)paramExtendedFloatingActionButton.getLayoutParams();
      if ((!g) && (!h)) {
        return false;
      }
      return paramExtendedFloatingActionButton.getAnchorId() == paramView.getId();
    }
    
    private boolean updateFabVisibility(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      if (!c(paramAppBarLayout, paramExtendedFloatingActionButton)) {
        return false;
      }
      if (mTmpRect == null) {
        mTmpRect = new Rect();
      }
      Rect localRect = mTmpRect;
      ViewGroupUtils.getDescendantRect(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        e(paramExtendedFloatingActionButton);
      } else {
        b(paramExtendedFloatingActionButton);
      }
      return true;
    }
    
    private static boolean updateOffset(View paramView)
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.e)) {
        return ((CoordinatorLayout.e)paramView).getBehavior() instanceof BottomSheetBehavior;
      }
      return false;
    }
    
    protected void b(ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      boolean bool = h;
      ExtendedFloatingActionButton.f localF;
      if (bool) {
        localF = j;
      } else {
        localF = o;
      }
      Slider localSlider;
      if (bool) {
        localSlider = ExtendedFloatingActionButton.toString(paramExtendedFloatingActionButton);
      } else {
        localSlider = ExtendedFloatingActionButton.p(paramExtendedFloatingActionButton);
      }
      ExtendedFloatingActionButton.a(paramExtendedFloatingActionButton, localSlider, localF);
    }
    
    protected void e(ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      boolean bool = h;
      ExtendedFloatingActionButton.f localF;
      if (bool) {
        localF = j;
      } else {
        localF = o;
      }
      Slider localSlider;
      if (bool) {
        localSlider = ExtendedFloatingActionButton.c(paramExtendedFloatingActionButton);
      } else {
        localSlider = ExtendedFloatingActionButton.formatString(paramExtendedFloatingActionButton);
      }
      ExtendedFloatingActionButton.a(paramExtendedFloatingActionButton, localSlider, localF);
    }
    
    public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, ExtendedFloatingActionButton paramExtendedFloatingActionButton, Rect paramRect)
    {
      return super.layoutDependsOn(paramCoordinatorLayout, paramExtendedFloatingActionButton, paramRect);
    }
    
    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, ExtendedFloatingActionButton paramExtendedFloatingActionButton, View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)paramView, paramExtendedFloatingActionButton);
      } else if (updateOffset(paramView)) {
        a(paramView, paramExtendedFloatingActionButton);
      }
      return false;
    }
    
    public void onLayoutChild(CoordinatorLayout.e paramE)
    {
      if (left == 0) {
        left = 80;
      }
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, ExtendedFloatingActionButton paramExtendedFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.getDependencies(paramExtendedFloatingActionButton);
      int k = localList.size();
      int i = 0;
      while (i < k)
      {
        View localView = (View)localList.get(i);
        if ((localView instanceof AppBarLayout) ? !updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)localView, paramExtendedFloatingActionButton) : (updateOffset(localView)) && (a(localView, paramExtendedFloatingActionButton))) {
          break;
        }
        i += 1;
      }
      paramCoordinatorLayout.onLayoutChild(paramExtendedFloatingActionButton, paramInt);
      return true;
    }
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    private boolean mCancelled;
    
    a(Slider paramSlider, ExtendedFloatingActionButton.f paramF) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      mCancelled = true;
      paramSlider.clear();
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramSlider.setBackgroundColor();
      if (!mCancelled) {
        paramSlider.resume(val$dummyView);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      paramSlider.onAnimationStart(paramAnimator);
      mCancelled = false;
    }
  }
  
  static final class b
    extends Property<View, Float>
  {
    b(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public void apply(View paramView, Float paramFloat)
    {
      getLayoutParamswidth = paramFloat.intValue();
      paramView.requestLayout();
    }
    
    public Float get(View paramView)
    {
      return Float.valueOf(getLayoutParamswidth);
    }
  }
  
  static final class c
    extends Property<View, Float>
  {
    c(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public void apply(View paramView, Float paramFloat)
    {
      getLayoutParamsheight = paramFloat.intValue();
      paramView.requestLayout();
    }
    
    public Float get(View paramView)
    {
      return Float.valueOf(getLayoutParamsheight);
    }
  }
  
  static final class d
    extends Property<View, Float>
  {
    d(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public void b(View paramView, Float paramFloat)
    {
      ViewCompat.get(paramView, paramFloat.intValue(), paramView.getPaddingTop(), ViewCompat.format(paramView), paramView.getPaddingBottom());
    }
    
    public Float getData(View paramView)
    {
      return Float.valueOf(ViewCompat.add(paramView));
    }
  }
  
  static final class e
    extends Property<View, Float>
  {
    e(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public void call(View paramView, Float paramFloat)
    {
      ViewCompat.get(paramView, ViewCompat.add(paramView), paramView.getPaddingTop(), paramFloat.intValue(), paramView.getPaddingBottom());
    }
    
    public Float getData(View paramView)
    {
      return Float.valueOf(ViewCompat.format(paramView));
    }
  }
  
  public static abstract class f {}
}
