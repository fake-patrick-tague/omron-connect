package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton.b;
import d.c.a.a.m.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.org.org.ui.R.raw;
import org.org.org.ui.R.string;
import org.org.org.ui.asm.ByteVector;
import org.org.org.ui.asm.f;
import org.org.org.ui.asm.m;

public class BottomAppBar
  extends Toolbar
  implements CoordinatorLayout.b
{
  private static final int DAY_HEADER_ONE_DAY_LEFT_MARGIN = R.string.condition_clouds_overcast;
  private int INT_TYPE;
  k<FloatingActionButton> ProgressFragment;
  private int ServerError;
  private int TYPE;
  private final int _offset;
  private Animator animation;
  private int animator;
  private int circleRadius;
  private boolean isIgnorable;
  private boolean linearProgress;
  private Animator mAnimator;
  private Behavior mBehavior;
  private int mDuration;
  private ArrayList<g> mFiles;
  private boolean mReverse;
  private final f o;
  private int offset;
  AnimatorListenerAdapter this$0;
  
  private float a(int paramInt)
  {
    boolean bool = com.google.android.material.internal.ViewCompat.a(this);
    int i = 1;
    if (paramInt == 1)
    {
      if (bool) {
        paramInt = TYPE;
      } else {
        paramInt = INT_TYPE;
      }
      int j = _offset;
      int k = getMeasuredWidth() / 2;
      if (bool) {
        i = -1;
      }
      return (k - (j + paramInt)) * i;
    }
    return 0.0F;
  }
  
  private void animateOpen()
  {
    ActionMenuView localActionMenuView = getActionMenuView();
    if ((localActionMenuView != null) && (mAnimator == null))
    {
      localActionMenuView.setAlpha(1.0F);
      if (!stop())
      {
        setAlpha(localActionMenuView, 0, false);
        return;
      }
      setAlpha(localActionMenuView, circleRadius, linearProgress);
    }
  }
  
  private View b()
  {
    if (!(getParent() instanceof CoordinatorLayout)) {
      return null;
    }
    Iterator localIterator = ((CoordinatorLayout)getParent()).get(this).iterator();
    View localView;
    while (localIterator.hasNext())
    {
      localView = (View)localIterator.next();
      if ((localView instanceof FloatingActionButton)) {
        return localView;
      }
      if ((localView instanceof ExtendedFloatingActionButton)) {
        return localView;
      }
    }
    return null;
    return localView;
  }
  
  private void cancel()
  {
    Animator localAnimator = mAnimator;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    localAnimator = animation;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  private void clear()
  {
    getTopEdgeTreatment().b(getFabTranslationX());
    View localView = b();
    f localF = o;
    float f;
    if ((linearProgress) && (stop())) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    localF.a(f);
    if (localView != null)
    {
      localView.setTranslationY(getFabTranslationY());
      localView.setTranslationX(getFabTranslationX());
    }
  }
  
  private ActionMenuView getActionMenuView()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof ActionMenuView)) {
        return (ActionMenuView)localView;
      }
      i += 1;
    }
    return null;
  }
  
  private int getBottomInset()
  {
    return ServerError;
  }
  
  private float getFabTranslationX()
  {
    return a(circleRadius);
  }
  
  private float getFabTranslationY()
  {
    return -getTopEdgeTreatment().c();
  }
  
  private FloatingActionButton getInstance()
  {
    View localView = b();
    if ((localView instanceof FloatingActionButton)) {
      return (FloatingActionButton)localView;
    }
    return null;
  }
  
  private int getLeftInset()
  {
    return TYPE;
  }
  
  private int getRightInset()
  {
    return INT_TYPE;
  }
  
  private MethodWriter getTopEdgeTreatment()
  {
    return (MethodWriter)o.c().a();
  }
  
  private void invoke(final ActionMenuView paramActionMenuView, final int paramInt, final boolean paramBoolean1, boolean paramBoolean2)
  {
    e localE = new e(paramActionMenuView, paramInt, paramBoolean1);
    if (paramBoolean2)
    {
      paramActionMenuView.post(localE);
      return;
    }
    localE.run();
  }
  
  private void onCreate(FloatingActionButton paramFloatingActionButton)
  {
    paramFloatingActionButton.hide(this$0);
    paramFloatingActionButton.show(new f());
    paramFloatingActionButton.hide(ProgressFragment);
  }
  
  private void onResult()
  {
    int i = offset - 1;
    offset = i;
    if (i == 0)
    {
      Object localObject = mFiles;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((g)((Iterator)localObject).next()).w(this);
        }
      }
    }
  }
  
  private void readHeader()
  {
    int i = offset;
    offset = (i + 1);
    if (i == 0)
    {
      Object localObject = mFiles;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((g)((Iterator)localObject).next()).inflate(this);
        }
      }
    }
  }
  
  private void setAlpha(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    invoke(paramActionMenuView, paramInt, paramBoolean, false);
  }
  
  private void show(int paramInt, List paramList)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(getInstance(), "translationX", new float[] { a(paramInt) });
    localObjectAnimator.setDuration(300L);
    paramList.add(localObjectAnimator);
  }
  
  private void show(final int paramInt, final boolean paramBoolean, List paramList)
  {
    Object localObject = getActionMenuView();
    if (localObject == null) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.06535322E9F });
    if (Math.abs(((View)localObject).getTranslationX() - a((ActionMenuView)localObject, paramInt, paramBoolean)) > 1.0F)
    {
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F });
      localObjectAnimator2.addListener(new d((ActionMenuView)localObject, paramInt, paramBoolean));
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).setDuration(150L);
      ((AnimatorSet)localObject).playSequentially(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      paramList.add(localObject);
      return;
    }
    if (((View)localObject).getAlpha() < 1.0F) {
      paramList.add(localObjectAnimator1);
    }
  }
  
  private void start(int paramInt)
  {
    if (circleRadius != paramInt)
    {
      if (!v7.v7.package_13.ViewCompat.set(this)) {
        return;
      }
      Object localObject = animation;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      localObject = new ArrayList();
      if (animator == 1) {
        show(paramInt, (List)localObject);
      } else {
        open(paramInt, (List)localObject);
      }
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether((Collection)localObject);
      animation = localAnimatorSet;
      localAnimatorSet.addListener(new a());
      animation.start();
    }
  }
  
  private void start(int paramInt, boolean paramBoolean)
  {
    if (!v7.v7.package_13.ViewCompat.set(this))
    {
      mReverse = false;
      onPrepareOptionsMenu(mDuration);
      return;
    }
    Object localObject = mAnimator;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = new ArrayList();
    if (!stop())
    {
      paramInt = 0;
      paramBoolean = false;
    }
    show(paramInt, paramBoolean, (List)localObject);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether((Collection)localObject);
    mAnimator = localAnimatorSet;
    localAnimatorSet.addListener(new c());
    mAnimator.start();
  }
  
  private boolean stop()
  {
    FloatingActionButton localFloatingActionButton = getInstance();
    return (localFloatingActionButton != null) && (localFloatingActionButton.show());
  }
  
  protected int a(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      if (!paramBoolean) {
        return 0;
      }
      paramBoolean = com.google.android.material.internal.ViewCompat.a(this);
      if (paramBoolean) {
        paramInt = getMeasuredWidth();
      } else {
        paramInt = 0;
      }
      int j = 0;
      for (int i = paramInt; j < getChildCount(); i = paramInt)
      {
        View localView = getChildAt(j);
        int k;
        if (((localView.getLayoutParams() instanceof Toolbar.LayoutParams)) && ((getLayoutParamsgravity & 0x800007) == 8388611)) {
          k = 1;
        } else {
          k = 0;
        }
        paramInt = i;
        if (k != 0) {
          if (paramBoolean) {
            paramInt = Math.min(i, localView.getLeft());
          } else {
            paramInt = Math.max(i, localView.getRight());
          }
        }
        j += 1;
      }
      if (paramBoolean) {
        paramInt = paramActionMenuView.getRight();
      } else {
        paramInt = paramActionMenuView.getLeft();
      }
      if (paramBoolean) {
        j = INT_TYPE;
      } else {
        j = -TYPE;
      }
      return i - (paramInt + j);
    }
    return 0;
  }
  
  boolean b(int paramInt)
  {
    float f = paramInt;
    if (f != getTopEdgeTreatment().b())
    {
      getTopEdgeTreatment().e(f);
      o.invalidateSelf();
      return true;
    }
    return false;
  }
  
  public ColorStateList getBackgroundTint()
  {
    return o.performShortcut();
  }
  
  public Behavior getBehavior()
  {
    if (mBehavior == null) {
      mBehavior = new Behavior();
    }
    return mBehavior;
  }
  
  public float getCradleVerticalOffset()
  {
    return getTopEdgeTreatment().c();
  }
  
  public int getFabAlignmentMode()
  {
    return circleRadius;
  }
  
  public int getFabAnimationMode()
  {
    return animator;
  }
  
  public float getFabCradleMargin()
  {
    return getTopEdgeTreatment().e();
  }
  
  public float getFabCradleRoundedCornerRadius()
  {
    return getTopEdgeTreatment().f();
  }
  
  public boolean getHideOnScroll()
  {
    return isIgnorable;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ByteVector.a(this, o);
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).setClipChildren(false);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      cancel();
      clear();
    }
    animateOpen();
  }
  
  public void onPrepareOptionsMenu(int paramInt)
  {
    if (paramInt != 0)
    {
      mDuration = 0;
      getMenu().clear();
      inflateMenu(paramInt);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    circleRadius = circleRadius;
    linearProgress = linearProgress;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    circleRadius = circleRadius;
    linearProgress = linearProgress;
    return localSavedState;
  }
  
  protected void open(final int paramInt, List paramList)
  {
    paramList = getInstance();
    if (paramList != null)
    {
      if (paramList.hide()) {
        return;
      }
      readHeader();
      paramList.setSize(new b(paramInt));
    }
  }
  
  public void setBackgroundTint(ColorStateList paramColorStateList)
  {
    DrawableCompat.append(o, paramColorStateList);
  }
  
  public void setCradleVerticalOffset(float paramFloat)
  {
    if (paramFloat != getCradleVerticalOffset())
    {
      getTopEdgeTreatment().a(paramFloat);
      o.invalidateSelf();
      clear();
    }
  }
  
  public void setElevation(float paramFloat)
  {
    o.add(paramFloat);
    int i = o.f();
    int j = o.clear();
    getBehavior().show(this, i - j);
  }
  
  public void setFabAlignmentMode(int paramInt)
  {
    startTransition(paramInt, 0);
  }
  
  public void setFabAnimationMode(int paramInt)
  {
    animator = paramInt;
  }
  
  public void setFabCradleMargin(float paramFloat)
  {
    if (paramFloat != getFabCradleMargin())
    {
      getTopEdgeTreatment().visitMaxs(paramFloat);
      o.invalidateSelf();
    }
  }
  
  public void setFabCradleRoundedCornerRadius(float paramFloat)
  {
    if (paramFloat != getFabCradleRoundedCornerRadius())
    {
      getTopEdgeTreatment().visitVarInsn(paramFloat);
      o.invalidateSelf();
    }
  }
  
  public void setHideOnScroll(boolean paramBoolean)
  {
    isIgnorable = paramBoolean;
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public void startTransition(int paramInt1, int paramInt2)
  {
    mDuration = paramInt2;
    mReverse = true;
    start(paramInt1, linearProgress);
    start(paramInt1);
    circleRadius = paramInt1;
  }
  
  public static class Behavior
    extends HideBottomViewOnScrollBehavior<BottomAppBar>
  {
    private WeakReference<BottomAppBar> mImageView;
    private final View.OnLayoutChangeListener mTmpRect = new a();
    private final Rect mView = new Rect();
    private int n;
    
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, BottomAppBar paramBottomAppBar, int paramInt)
    {
      mImageView = new WeakReference(paramBottomAppBar);
      Object localObject = BottomAppBar.b(paramBottomAppBar);
      if ((localObject != null) && (!v7.v7.package_13.ViewCompat.set((View)localObject)))
      {
        CoordinatorLayout.e localE = (CoordinatorLayout.e)((View)localObject).getLayoutParams();
        anchorGravity = 49;
        n = bottomMargin;
        if ((localObject instanceof FloatingActionButton))
        {
          localObject = (FloatingActionButton)localObject;
          ((View)localObject).addOnLayoutChangeListener(mTmpRect);
          BottomAppBar.access$getSetBackgroundDrawable(paramBottomAppBar, (FloatingActionButton)localObject);
        }
        BottomAppBar.getDependencies(paramBottomAppBar);
      }
      paramCoordinatorLayout.onLayoutChild(paramBottomAppBar, paramInt);
      return super.onLayoutChild(paramCoordinatorLayout, paramBottomAppBar, paramInt);
    }
    
    public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, BottomAppBar paramBottomAppBar, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      return (paramBottomAppBar.getHideOnScroll()) && (super.onStartNestedScroll(paramCoordinatorLayout, paramBottomAppBar, paramView1, paramView2, paramInt1, paramInt2));
    }
    
    class a
      implements View.OnLayoutChangeListener
    {
      a() {}
      
      public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
      {
        BottomAppBar localBottomAppBar = (BottomAppBar)BottomAppBar.Behavior.access$getMImageView(BottomAppBar.Behavior.this).get();
        if ((localBottomAppBar != null) && ((paramView instanceof FloatingActionButton)))
        {
          FloatingActionButton localFloatingActionButton = (FloatingActionButton)paramView;
          localFloatingActionButton.setSize(BottomAppBar.Behavior.access$getMView(BottomAppBar.Behavior.this));
          paramInt1 = BottomAppBar.Behavior.access$getMView(BottomAppBar.Behavior.this).height();
          localBottomAppBar.b(paramInt1);
          paramView = (CoordinatorLayout.e)paramView.getLayoutParams();
          if (BottomAppBar.Behavior.access$getN(BottomAppBar.Behavior.this) == 0)
          {
            paramInt1 = (localFloatingActionButton.getMeasuredHeight() - paramInt1) / 2;
            paramInt2 = localBottomAppBar.getResources().getDimensionPixelOffset(R.raw.this$0);
            bottomMargin = (BottomAppBar.post(localBottomAppBar) + (paramInt2 - paramInt1));
            leftMargin = BottomAppBar.getHeight(localBottomAppBar);
            rightMargin = BottomAppBar.getFileIcon(localBottomAppBar);
            if (com.google.android.material.internal.ViewCompat.a(localFloatingActionButton))
            {
              leftMargin += BottomAppBar.offset(localBottomAppBar);
              return;
            }
            rightMargin += BottomAppBar.offset(localBottomAppBar);
          }
        }
        else
        {
          paramView.removeOnLayoutChangeListener(this);
        }
      }
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int circleRadius;
    boolean linearProgress;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      circleRadius = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      linearProgress = bool;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }
    
    static final class a
      implements Parcelable.ClassLoaderCreator<BottomAppBar.SavedState>
    {
      a() {}
      
      public BottomAppBar.SavedState[] a(int paramInt)
      {
        return new BottomAppBar.SavedState[paramInt];
      }
      
      public BottomAppBar.SavedState readDate(Parcel paramParcel)
      {
        return new BottomAppBar.SavedState(paramParcel, null);
      }
      
      public BottomAppBar.SavedState readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new BottomAppBar.SavedState(paramParcel, paramClassLoader);
      }
    }
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      BottomAppBar.onShown(BottomAppBar.this);
      BottomAppBar.access$setMCurrentAnimator(BottomAppBar.this, null);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      BottomAppBar.access$getSetVisibility(BottomAppBar.this);
    }
  }
  
  class b
    extends FloatingActionButton.b
  {
    b(int paramInt) {}
    
    public void show(FloatingActionButton paramFloatingActionButton)
    {
      paramFloatingActionButton.setTranslationX(BottomAppBar.d(BottomAppBar.this, paramInt));
      paramFloatingActionButton.toggle(new a());
    }
    
    class a
      extends FloatingActionButton.b
    {
      a() {}
      
      public void onShown(FloatingActionButton paramFloatingActionButton)
      {
        BottomAppBar.onShown(BottomAppBar.this);
      }
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      BottomAppBar.onShown(BottomAppBar.this);
      BottomAppBar.access$setMDirty(BottomAppBar.this, false);
      BottomAppBar.access$setMCurrentShowAnim(BottomAppBar.this, null);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      BottomAppBar.access$getSetVisibility(BottomAppBar.this);
    }
  }
  
  class d
    extends AnimatorListenerAdapter
  {
    public boolean mCancelled;
    
    d(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      mCancelled = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!mCancelled)
      {
        boolean bool;
        if (mDuration != 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramAnimator = BottomAppBar.this;
        paramAnimator.onPrepareOptionsMenu(mDuration);
        BottomAppBar.create(BottomAppBar.this, val$card, paramInt, paramBoolean, bool);
      }
    }
  }
  
  class e
    implements Runnable
  {
    e(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean) {}
    
    public void run()
    {
      ActionMenuView localActionMenuView = paramActionMenuView;
      localActionMenuView.setTranslationX(a(localActionMenuView, paramInt, paramBoolean1));
    }
  }
  
  class f
    extends AnimatorListenerAdapter
  {
    f() {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      this$0.onAnimationStart(paramAnimator);
      paramAnimator = BottomAppBar.create(BottomAppBar.this);
      if (paramAnimator != null) {
        paramAnimator.setTranslationX(BottomAppBar.access$getMView(BottomAppBar.this));
      }
    }
  }
  
  static abstract interface g
  {
    public abstract void inflate(BottomAppBar paramBottomAppBar);
    
    public abstract void w(BottomAppBar paramBottomAppBar);
  }
}
