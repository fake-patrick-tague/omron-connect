package com.google.android.material.floatingactionbutton;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.i;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.PlotListener;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.Label;
import com.google.android.material.internal.ViewGroupUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.stateful.ExtendableSavedState;
import com.google.android.material.theme.utils.Effect;
import d.c.a.a.m.k;
import java.util.List;
import org.org.org.ui.R.raw;
import org.org.org.ui.R.string;
import org.org.org.ui.R.styleable;
import org.org.org.ui.activity.b;
import org.org.org.ui.asm.GeoPoint;
import org.org.org.ui.asm.Item;
import org.org.org.ui.asm.m;
import org.org.org.ui.utils.Attribute;
import org.org.org.ui.utils.ByteVector;
import org.org.org.ui.widget.ShadowViewDelegate;
import v7.util.SimpleArrayMap;
import v7.v7.package_13.TintableBackgroundView;

public class FloatingActionButton
  extends VisibilityAwareImageButton
  implements TintableBackgroundView, PlotListener, org.org.org.ui.activity.FloatingActionButton, GeoPoint, CoordinatorLayout.b
{
  private static final int c = R.string.SQUARE;
  private final b a;
  private int j;
  private final i l;
  private ColorStateList mBackgroundTint;
  private PorterDuff.Mode mBackgroundTintMode;
  private int mBorderWidth;
  boolean mCompatPadding;
  private int mContentPadding;
  private int mCount;
  private FloatingActionButtonImpl mImpl;
  private ColorStateList mRippleColor;
  private int mSize;
  private ColorStateList mTextColor;
  private PorterDuff.Mode mType;
  private final Rect message = new Rect();
  final Rect this$0 = new Rect();
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, org.org.org.ui.ClassWriter.s);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(Effect.a(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    Object localObject2 = getContext();
    Object localObject1 = Label.obtainStyledAttributes((Context)localObject2, paramAttributeSet, R.styleable.FloatingActionButton, paramInt, i, new int[0]);
    mBackgroundTint = org.org.org.ui.menu.ClassWriter.getString((Context)localObject2, (TypedArray)localObject1, R.styleable.FloatingActionButton_fab_colorNormal);
    mBackgroundTintMode = com.google.android.material.internal.ViewCompat.parseTintMode(((TypedArray)localObject1).getInt(R.styleable.StickyListHeadersListView_android_overScrollMode, -1), null);
    mRippleColor = org.org.org.ui.menu.ClassWriter.getString((Context)localObject2, (TypedArray)localObject1, R.styleable.BottomSheet_bs_listItemLayout);
    mSize = ((TypedArray)localObject1).getInt(R.styleable.StickyListHeadersListView_android_requiresFadingEdge, -1);
    mCount = ((TypedArray)localObject1).getDimensionPixelSize(R.styleable.Switch_bpSwitchMinWidth, 0);
    mBorderWidth = ((TypedArray)localObject1).getDimensionPixelSize(R.styleable.StickyListHeadersListView_android_paddingTop, 0);
    float f1 = ((TypedArray)localObject1).getDimension(R.styleable.TitlePageIndicator_footerIndicatorHeight, 0.0F);
    float f2 = ((TypedArray)localObject1).getDimension(R.styleable.TitlePageIndicator_footerIndicatorUnderlinePadding, 0.0F);
    float f3 = ((TypedArray)localObject1).getDimension(R.styleable.TitlePageIndicator_footerPadding, 0.0F);
    mCompatPadding = ((TypedArray)localObject1).getBoolean(R.styleable.StickyListHeadersListView_android_fastScrollEnabled, false);
    int k = getResources().getDimensionPixelSize(R.raw.dividerPadding);
    j = ((TypedArray)localObject1).getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsTabPaddingLeftRight, 0);
    paramContext = Attribute.a((Context)localObject2, (TypedArray)localObject1, R.styleable.B);
    Attribute localAttribute = Attribute.a((Context)localObject2, (TypedArray)localObject1, R.styleable.s);
    localObject2 = m.a((Context)localObject2, paramAttributeSet, paramInt, i, m.c).a();
    boolean bool = ((TypedArray)localObject1).getBoolean(R.styleable.ROW_ORDER_PRESERVED, false);
    setEnabled(((TypedArray)localObject1).getBoolean(R.styleable.COLUMN_ORDER_PRESERVED, true));
    ((TypedArray)localObject1).recycle();
    localObject1 = new i(this);
    l = ((i)localObject1);
    ((i)localObject1).a(paramAttributeSet, paramInt);
    a = new b(this);
    getImpl().a((m)localObject2);
    getImpl().setBackgroundDrawable(mBackgroundTint, mBackgroundTintMode, mRippleColor, mBorderWidth);
    getImpl().setBackgroundDrawable(k);
    getImpl().setElevation(f1);
    getImpl().setPressedTranslationZ(f2);
    getImpl().setBackgroundDrawable(f3);
    getImpl().setPressedTranslationZ(j);
    getImpl().setBackgroundDrawable(paramContext);
    getImpl().setElevation(localAttribute);
    getImpl().hide(bool);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private FloatingActionButtonImpl createImpl()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new FloatingActionButtonEclairMr1(this, new c());
    }
    return new FloatingActionButtonImpl(this, new c());
  }
  
  private FloatingActionButtonImpl getImpl()
  {
    if (mImpl == null) {
      mImpl = createImpl();
    }
    return mImpl;
  }
  
  private static int getLength(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE)
    {
      if (i != 0)
      {
        if (i == 1073741824) {
          return paramInt2;
        }
        throw new IllegalArgumentException();
      }
    }
    else {
      paramInt1 = Math.min(paramInt1, paramInt2);
    }
    return paramInt1;
  }
  
  private int init(int paramInt)
  {
    int i = mCount;
    if (i != 0) {
      return i;
    }
    Resources localResources = getResources();
    if (paramInt != -1)
    {
      if (paramInt != 1) {
        return localResources.getDimensionPixelSize(R.raw.key);
      }
      return localResources.getDimensionPixelSize(R.raw.t);
    }
    if (Math.max(getConfigurationscreenWidthDp, getConfigurationscreenHeightDp) < 470) {
      return init(1);
    }
    return init(0);
  }
  
  private void init()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    Object localObject = mTextColor;
    if (localObject == null)
    {
      DrawableCompat.a(localDrawable);
      return;
    }
    int i = ((ColorStateList)localObject).getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode = mType;
    localObject = localMode;
    if (localMode == null) {
      localObject = PorterDuff.Mode.SRC_IN;
    }
    localDrawable.mutate().setColorFilter(androidx.appcompat.widget.ViewCompat.get(i, (PorterDuff.Mode)localObject));
  }
  
  private void setBounds(Rect paramRect)
  {
    int i = left;
    Rect localRect = this$0;
    left = (i + left);
    top += top;
    right -= right;
    bottom -= bottom;
  }
  
  private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(final b paramB)
  {
    if (paramB == null) {
      return null;
    }
    return new a(paramB);
  }
  
  public boolean add(Rect paramRect)
  {
    if (v7.v7.package_13.ViewCompat.set(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      setBounds(paramRect);
      return true;
    }
    return false;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().show(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return mBackgroundTint;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return mBackgroundTintMode;
  }
  
  public CoordinatorLayout.Behavior getBehavior()
  {
    return new Behavior();
  }
  
  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    return getImpl().setElevation();
  }
  
  public float getCompatPressedTranslationZ()
  {
    return getImpl().getPadding();
  }
  
  public Drawable getContentBackground()
  {
    return getImpl().getContentBackground();
  }
  
  public int getCustomSize()
  {
    return mCount;
  }
  
  public int getExpandedComponentIdHint()
  {
    return a.b();
  }
  
  public Attribute getHideMotionSpec()
  {
    return getImpl().hide();
  }
  
  public int getRippleColor()
  {
    ColorStateList localColorStateList = mRippleColor;
    if (localColorStateList != null) {
      return localColorStateList.getDefaultColor();
    }
    return 0;
  }
  
  public ColorStateList getRippleColorStateList()
  {
    return mRippleColor;
  }
  
  public m getShapeAppearanceModel()
  {
    return (m)v7.v7.util.Log.valueOf(getImpl().getSolution());
  }
  
  public Attribute getShowMotionSpec()
  {
    return getImpl().show();
  }
  
  public int getSize()
  {
    return mSize;
  }
  
  int getSizeDimension()
  {
    return init(mSize);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    return getBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return getBackgroundTintMode();
  }
  
  public ColorStateList getSupportImageTintList()
  {
    return mTextColor;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return mType;
  }
  
  public boolean getType()
  {
    return a.a();
  }
  
  public boolean getUseCompatPadding()
  {
    return mCompatPadding;
  }
  
  public void hide(Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().hide(paramAnimatorListener);
  }
  
  void hide(b paramB, boolean paramBoolean)
  {
    getImpl().start(wrapOnVisibilityChangedListener(paramB), paramBoolean);
  }
  
  public void hide(ByteVector paramByteVector)
  {
    getImpl().hide(new d(paramByteVector));
  }
  
  public boolean hide()
  {
    return getImpl().play();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().jumpDrawableToCurrentState();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getImpl().onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getImpl().onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    mContentPadding = ((i - j) / 2);
    getImpl().updatePadding();
    paramInt1 = Math.min(getLength(i, paramInt1), getLength(i, paramInt2));
    Rect localRect = this$0;
    setMeasuredDimension(left + paramInt1 + right, paramInt1 + top + bottom);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExtendableSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ExtendableSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    a.onCreate((Bundle)v7.v7.util.Log.valueOf(c.get("expandableWidgetHelper")));
  }
  
  protected Parcelable onSaveInstanceState()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (add(message)) && (!message.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    android.util.Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    android.util.Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundResource(int paramInt)
  {
    android.util.Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (mBackgroundTint != paramColorStateList)
    {
      mBackgroundTint = paramColorStateList;
      getImpl().setBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (mBackgroundTintMode != paramMode)
    {
      mBackgroundTintMode = paramMode;
      getImpl().setBackgroundTintMode(paramMode);
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    getImpl().setElevation(paramFloat);
  }
  
  public void setCompatElevationResource(int paramInt)
  {
    setCompatElevation(getResources().getDimension(paramInt));
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    getImpl().setPressedTranslationZ(paramFloat);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    getImpl().setBackgroundDrawable(paramFloat);
  }
  
  public void setCompatPressedTranslationZResource(int paramInt)
  {
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCustomSize(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt != mCount)
      {
        mCount = paramInt;
        requestLayout();
      }
    }
    else {
      throw new IllegalArgumentException("Custom size must be non-negative");
    }
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    getImpl().hide(paramFloat);
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean)
  {
    if (paramBoolean != getImpl().m())
    {
      getImpl().hide(paramBoolean);
      requestLayout();
    }
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    a.a(paramInt);
  }
  
  public void setHideMotionSpec(Attribute paramAttribute)
  {
    getImpl().setElevation(paramAttribute);
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(Attribute.a(getContext(), paramInt));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (getDrawable() != paramDrawable)
    {
      super.setImageDrawable(paramDrawable);
      getImpl().onTranslationZChanged();
      if (mTextColor != null) {
        init();
      }
    }
  }
  
  public void setImageResource(int paramInt)
  {
    l.a(paramInt);
    init();
  }
  
  public void setRippleColor(int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (mRippleColor != paramColorStateList)
    {
      mRippleColor = paramColorStateList;
      getImpl().setRippleColor(mRippleColor);
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    super.setScaleX(paramFloat);
    getImpl().accept();
  }
  
  public void setScaleY(float paramFloat)
  {
    super.setScaleY(paramFloat);
    getImpl().accept();
  }
  
  public void setShadowPaddingEnabled(boolean paramBoolean)
  {
    getImpl().setElevation(paramBoolean);
  }
  
  public void setShapeAppearanceModel(m paramM)
  {
    getImpl().a(paramM);
  }
  
  public void setShowMotionSpec(Attribute paramAttribute)
  {
    getImpl().setBackgroundDrawable(paramAttribute);
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(Attribute.a(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    mCount = 0;
    if (paramInt != mSize)
    {
      mSize = paramInt;
      requestLayout();
    }
  }
  
  public void setSize(Rect paramRect)
  {
    paramRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    setBounds(paramRect);
  }
  
  public void setSize(b paramB)
  {
    hide(paramB, true);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    setBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setBackgroundTintMode(paramMode);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (mTextColor != paramColorStateList)
    {
      mTextColor = paramColorStateList;
      init();
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (mType != paramMode)
    {
      mType = paramMode;
      init();
    }
  }
  
  public void setTranslationX(float paramFloat)
  {
    super.setTranslationX(paramFloat);
    getImpl().create();
  }
  
  public void setTranslationY(float paramFloat)
  {
    super.setTranslationY(paramFloat);
    getImpl().create();
  }
  
  public void setTranslationZ(float paramFloat)
  {
    super.setTranslationZ(paramFloat);
    getImpl().create();
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (mCompatPadding != paramBoolean)
    {
      mCompatPadding = paramBoolean;
      getImpl().onCompatShadowChanged();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
  
  public void show(Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().show(paramAnimatorListener);
  }
  
  void show(b paramB, boolean paramBoolean)
  {
    getImpl().show(wrapOnVisibilityChangedListener(paramB), paramBoolean);
  }
  
  public boolean show()
  {
    return getImpl().equals();
  }
  
  public void toggle(b paramB)
  {
    show(paramB, true);
  }
  
  protected static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private FloatingActionButton.b listView;
    private boolean mNotificationsEnabled;
    private Rect mTmpRect;
    
    public BaseBehavior()
    {
      mNotificationsEnabled = true;
    }
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FlowLayout);
      mNotificationsEnabled = paramContext.getBoolean(R.styleable.FlowLayout_android_gravity, true);
      paramContext.recycle();
    }
    
    private void offsetIfNeeded(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      Rect localRect = this$0;
      if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
      {
        CoordinatorLayout.e localE = (CoordinatorLayout.e)paramFloatingActionButton.getLayoutParams();
        int i = paramFloatingActionButton.getRight();
        int k = paramCoordinatorLayout.getWidth();
        int m = rightMargin;
        int j = 0;
        if (i >= k - m) {
          i = right;
        } else if (paramFloatingActionButton.getLeft() <= leftMargin) {
          i = -left;
        } else {
          i = 0;
        }
        if (paramFloatingActionButton.getBottom() >= paramCoordinatorLayout.getHeight() - bottomMargin) {
          j = bottom;
        } else if (paramFloatingActionButton.getTop() <= topMargin) {
          j = -top;
        }
        if (j != 0) {
          v7.v7.package_13.ViewCompat.offsetTopAndBottom(paramFloatingActionButton, j);
        }
        if (i != 0) {
          v7.v7.package_13.ViewCompat.offsetLeftAndRight(paramFloatingActionButton, i);
        }
      }
    }
    
    private boolean onLayoutChild(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      if (!updateFabVisibility(paramView, paramFloatingActionButton)) {
        return false;
      }
      CoordinatorLayout.e localE = (CoordinatorLayout.e)paramFloatingActionButton.getLayoutParams();
      if (paramView.getTop() < paramFloatingActionButton.getHeight() / 2 + topMargin) {
        paramFloatingActionButton.hide(listView, false);
      } else {
        paramFloatingActionButton.show(listView, false);
      }
      return true;
    }
    
    private boolean updateFabVisibility(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      CoordinatorLayout.e localE = (CoordinatorLayout.e)paramFloatingActionButton.getLayoutParams();
      if (!mNotificationsEnabled) {
        return false;
      }
      if (localE.getAnchorId() != paramView.getId()) {
        return false;
      }
      return paramFloatingActionButton.getUserSetVisibility() == 0;
    }
    
    private boolean updateFabVisibility(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (!updateFabVisibility(paramAppBarLayout, paramFloatingActionButton)) {
        return false;
      }
      if (mTmpRect == null) {
        mTmpRect = new Rect();
      }
      Rect localRect = mTmpRect;
      ViewGroupUtils.getDescendantRect(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.hide(listView, false);
      } else {
        paramFloatingActionButton.show(listView, false);
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
    
    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      } else if (updateOffset(paramView)) {
        onLayoutChild(paramView, paramFloatingActionButton);
      }
      return false;
    }
    
    public void onLayoutChild(CoordinatorLayout.e paramE)
    {
      if (left == 0) {
        left = 80;
      }
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)localList.get(i);
        if ((localView instanceof AppBarLayout) ? !updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton) : (updateOffset(localView)) && (onLayoutChild(localView, paramFloatingActionButton))) {
          break;
        }
        i += 1;
      }
      paramCoordinatorLayout.onLayoutChild(paramFloatingActionButton, paramInt);
      offsetIfNeeded(paramCoordinatorLayout, paramFloatingActionButton);
      return true;
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, Rect paramRect)
    {
      paramCoordinatorLayout = this$0;
      paramRect.set(paramFloatingActionButton.getLeft() + left, paramFloatingActionButton.getTop() + top, paramFloatingActionButton.getRight() - right, paramFloatingActionButton.getBottom() - bottom);
      return true;
    }
  }
  
  public static class Behavior
    extends FloatingActionButton.BaseBehavior<FloatingActionButton>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  class a
    implements FloatingActionButtonImpl.InternalVisibilityChangedListener
  {
    a(FloatingActionButton.b paramB) {}
    
    public void onHidden()
    {
      paramB.show(FloatingActionButton.this);
    }
    
    public void onShown()
    {
      paramB.onShown(FloatingActionButton.this);
    }
  }
  
  public static abstract class b
  {
    public b() {}
    
    public void onShown(FloatingActionButton paramFloatingActionButton) {}
    
    public void show(FloatingActionButton paramFloatingActionButton) {}
  }
  
  private class c
    implements ShadowViewDelegate
  {
    c() {}
    
    public void setBackgroundDrawable(Drawable paramDrawable)
    {
      if (paramDrawable != null) {
        FloatingActionButton.access$getSetBackgroundDrawable(FloatingActionButton.this, paramDrawable);
      }
    }
    
    public boolean setBackgroundDrawable()
    {
      return mCompatPadding;
    }
    
    public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this$0.set(paramInt1, paramInt2, paramInt3, paramInt4);
      FloatingActionButton localFloatingActionButton = FloatingActionButton.this;
      localFloatingActionButton.setPadding(paramInt1 + FloatingActionButton.access$getMContentPadding(localFloatingActionButton), paramInt2 + FloatingActionButton.access$getMContentPadding(FloatingActionButton.this), paramInt3 + FloatingActionButton.access$getMContentPadding(FloatingActionButton.this), paramInt4 + FloatingActionButton.access$getMContentPadding(FloatingActionButton.this));
    }
  }
  
  class d<T extends FloatingActionButton>
    implements b.i
  {
    private final k<T> d;
    
    d(ByteVector paramByteVector)
    {
      d = paramByteVector;
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof d)) && (d.equals(d));
    }
    
    public int hashCode()
    {
      return d.hashCode();
    }
    
    public void visit()
    {
      d.put(FloatingActionButton.this);
    }
    
    public void visitEnum()
    {
      d.b(FloatingActionButton.this);
    }
  }
}
