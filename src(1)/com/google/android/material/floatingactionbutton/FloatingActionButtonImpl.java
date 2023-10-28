package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.internal.VisibilityAwareImageButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.org.org.ui.asm.ByteVector;
import org.org.org.ui.asm.GeoPoint;
import org.org.org.ui.asm.f;
import org.org.org.ui.asm.m;
import org.org.org.ui.compound.DrawableWrapperDonut;
import org.org.org.ui.d;
import org.org.org.ui.utils.AnimationUtils;
import org.org.org.ui.utils.Attribute;
import org.org.org.ui.utils.Quaternion;
import org.org.org.ui.utils.RemoteItems;
import org.org.org.ui.utils.Transaction;
import org.org.org.ui.widget.ShadowViewDelegate;
import v7.v7.package_13.ViewCompat;

class FloatingActionButtonImpl
{
  static final int[] b = { 16842910 };
  static final int[] base = new int[0];
  static final int[] c;
  static final int[] e;
  static final int[] f;
  static final TimeInterpolator handler = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
  static final int[] params = { 16842919, 16842910 };
  CircularBorderDrawable a;
  private Animator animator;
  f d;
  private float duration = 1.0F;
  private ArrayList<b.i> flags;
  boolean h = true;
  Drawable j;
  int left;
  private ArrayList<Animator.AnimatorListener> list;
  private final RectF mBounds = new RectF();
  float mElevation;
  private final Matrix mMatrix = new Matrix();
  private int mPaint;
  private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
  float mPressedTranslationZ;
  private final RectF mRect = new RectF();
  Drawable mRippleDrawable;
  float mShadowDrawable;
  final ShadowViewDelegate mShadowViewDelegate;
  private final StateListAnimator mStateListAnimator;
  private final Rect mTmpRect = new Rect();
  private Attribute mView;
  private Attribute position;
  boolean r;
  private int size = 0;
  private ArrayList<Animator.AnimatorListener> state;
  private Attribute target;
  final FloatingActionButton this$0;
  private float width;
  m x;
  private Attribute y;
  
  static
  {
    f = new int[] { 16843623, 16842908, 16842910 };
    e = new int[] { 16842908, 16842910 };
    c = new int[] { 16843623, 16842910 };
  }
  
  FloatingActionButtonImpl(FloatingActionButton paramFloatingActionButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    this$0 = paramFloatingActionButton;
    mShadowViewDelegate = paramShadowViewDelegate;
    paramShadowViewDelegate = new StateListAnimator();
    mStateListAnimator = paramShadowViewDelegate;
    paramShadowViewDelegate.append(params, hide(new GeoLocation(this)));
    paramShadowViewDelegate.append(f, hide(new WindowDecorActionBar(this)));
    paramShadowViewDelegate.append(e, hide(new WindowDecorActionBar(this)));
    paramShadowViewDelegate.append(c, hide(new WindowDecorActionBar(this)));
    paramShadowViewDelegate.append(b, hide(new Destination(this)));
    paramShadowViewDelegate.append(base, hide(new ScrollerCompat(this)));
    width = paramFloatingActionButton.getRotation();
  }
  
  private AnimatorSet add(Attribute paramAttribute, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this$0, View.ALPHA, new float[] { paramFloat1 });
    paramAttribute.get("opacity").add(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this$0, View.SCALE_X, new float[] { paramFloat2 });
    paramAttribute.get("scale").add(localObjectAnimator);
    show(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this$0, View.SCALE_Y, new float[] { paramFloat2 });
    paramAttribute.get("scale").add(localObjectAnimator);
    show(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    draw(paramFloat3, mMatrix);
    localObjectAnimator = ObjectAnimator.ofObject(this$0, new Quaternion(), new QCandidates.3(this), new Matrix[] { new Matrix(mMatrix) });
    paramAttribute.get("iconScale").add(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramAttribute = new AnimatorSet();
    RemoteItems.start(paramAttribute, localArrayList);
    return paramAttribute;
  }
  
  private void draw(float paramFloat, Matrix paramMatrix)
  {
    paramMatrix.reset();
    Drawable localDrawable = this$0.getDrawable();
    if ((localDrawable != null) && (mPaint != 0))
    {
      RectF localRectF1 = mBounds;
      RectF localRectF2 = mRect;
      localRectF1.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      int i = mPaint;
      localRectF2.set(0.0F, 0.0F, i, i);
      paramMatrix.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
      i = mPaint;
      paramMatrix.postScale(paramFloat, paramFloat, i / 2.0F, i / 2.0F);
    }
  }
  
  private ViewTreeObserver.OnPreDrawListener ensurePreDrawListener()
  {
    if (mPreDrawListener == null) {
      mPreDrawListener = new FloatingActionButtonImpl.1(this);
    }
    return mPreDrawListener;
  }
  
  private ValueAnimator hide(ViewPropertyAnimatorPreHC.AnimatorEventListener paramAnimatorEventListener)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(handler);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramAnimatorEventListener);
    localValueAnimator.addUpdateListener(paramAnimatorEventListener);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  private boolean init()
  {
    return (ViewCompat.set(this$0)) && (!this$0.isInEditMode());
  }
  
  private Attribute next()
  {
    if (position == null) {
      position = Attribute.a(this$0.getContext(), d.p);
    }
    return (Attribute)v7.v7.util.Log.valueOf(position);
  }
  
  private Attribute set()
  {
    if (y == null) {
      y = Attribute.a(this$0.getContext(), d.x);
    }
    return (Attribute)v7.v7.util.Log.valueOf(y);
  }
  
  private void show(ObjectAnimator paramObjectAnimator)
  {
    if (Build.VERSION.SDK_INT != 26) {
      return;
    }
    paramObjectAnimator.setEvaluator(new AbstractXPathCompiled(this));
  }
  
  f a()
  {
    return new f((m)v7.v7.util.Log.valueOf(x));
  }
  
  final void a(m paramM)
  {
    x = paramM;
    Object localObject = d;
    if (localObject != null) {
      ((f)localObject).setShapeAppearanceModel(paramM);
    }
    localObject = j;
    if ((localObject instanceof GeoPoint)) {
      ((GeoPoint)localObject).setShapeAppearanceModel(paramM);
    }
    localObject = a;
    if (localObject != null) {
      ((CircularBorderDrawable)localObject).draw(paramM);
    }
  }
  
  void accept()
  {
    Object localObject = flags;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AnnotationNode)((Iterator)localObject).next()).visit();
      }
    }
  }
  
  void create()
  {
    Object localObject = flags;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AnnotationNode)((Iterator)localObject).next()).visitEnum();
      }
    }
  }
  
  void draw()
  {
    if (Build.VERSION.SDK_INT == 19) {
      if (width % 90.0F != 0.0F)
      {
        if (this$0.getLayerType() != 1) {
          this$0.setLayerType(1, null);
        }
      }
      else if (this$0.getLayerType() != 0) {
        this$0.setLayerType(0, null);
      }
    }
    f localF = d;
    if (localF != null) {
      localF.a((int)width);
    }
  }
  
  boolean equals()
  {
    if (this$0.getVisibility() != 0)
    {
      if (size == 2) {
        return true;
      }
    }
    else if (size != 1) {
      return true;
    }
    return false;
  }
  
  final Drawable getContentBackground()
  {
    return mRippleDrawable;
  }
  
  float getElevation()
  {
    return mElevation;
  }
  
  float getPadding()
  {
    return mShadowDrawable;
  }
  
  final m getSolution()
  {
    return x;
  }
  
  final Attribute hide()
  {
    return target;
  }
  
  void hide(float paramFloat)
  {
    f localF = d;
    if (localF != null) {
      localF.add(paramFloat);
    }
  }
  
  public void hide(Animator.AnimatorListener paramAnimatorListener)
  {
    if (state == null) {
      state = new ArrayList();
    }
    state.add(paramAnimatorListener);
  }
  
  void hide(AnnotationNode paramAnnotationNode)
  {
    if (flags == null) {
      flags = new ArrayList();
    }
    flags.add(paramAnnotationNode);
  }
  
  void hide(boolean paramBoolean)
  {
    r = paramBoolean;
  }
  
  void jumpDrawableToCurrentState()
  {
    mStateListAnimator.start();
  }
  
  final boolean load()
  {
    return (!r) || (this$0.getSizeDimension() >= left);
  }
  
  boolean m()
  {
    return r;
  }
  
  void onAttachedToWindow()
  {
    f localF = d;
    if (localF != null) {
      ByteVector.a(this$0, localF);
    }
    if (requirePreDrawListener()) {
      this$0.getViewTreeObserver().addOnPreDrawListener(ensurePreDrawListener());
    }
  }
  
  void onCompatShadowChanged() {}
  
  void onDetachedFromWindow()
  {
    ViewTreeObserver localViewTreeObserver = this$0.getViewTreeObserver();
    ViewTreeObserver.OnPreDrawListener localOnPreDrawListener = mPreDrawListener;
    if (localOnPreDrawListener != null)
    {
      localViewTreeObserver.removeOnPreDrawListener(localOnPreDrawListener);
      mPreDrawListener = null;
    }
  }
  
  void onPaddingUpdated(Rect paramRect)
  {
    v7.v7.util.Log.get(mRippleDrawable, "Didn't initialize content background");
    if (setBackgroundDrawable())
    {
      paramRect = new InsetDrawable(mRippleDrawable, left, top, right, bottom);
      mShadowViewDelegate.setBackgroundDrawable(paramRect);
      return;
    }
    mShadowViewDelegate.setBackgroundDrawable(mRippleDrawable);
  }
  
  void onPostExecute(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    updatePadding();
    hide(paramFloat1);
  }
  
  void onPreDraw()
  {
    float f1 = this$0.getRotation();
    if (width != f1)
    {
      width = f1;
      draw();
    }
  }
  
  final void onTranslationZChanged()
  {
    setup(duration);
  }
  
  boolean play()
  {
    if (this$0.getVisibility() == 0)
    {
      if (size == 1) {
        return true;
      }
    }
    else if (size != 2) {
      return true;
    }
    return false;
  }
  
  boolean requirePreDrawListener()
  {
    return true;
  }
  
  final void setBackgroundDrawable(float paramFloat)
  {
    if (mShadowDrawable != paramFloat)
    {
      mShadowDrawable = paramFloat;
      onPostExecute(mElevation, mPressedTranslationZ, paramFloat);
    }
  }
  
  void setBackgroundDrawable(int paramInt)
  {
    left = paramInt;
  }
  
  void setBackgroundDrawable(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    f localF = a();
    d = localF;
    localF.setTintList(paramColorStateList1);
    if (paramMode != null) {
      d.setTintMode(paramMode);
    }
    d.b(-12303292);
    d.d(this$0.getContext());
    paramColorStateList1 = new DrawableWrapperDonut(d.c());
    paramColorStateList1.setTintList(org.org.org.ui.compound.Log.getColor(paramColorStateList2));
    j = paramColorStateList1;
    mRippleDrawable = new LayerDrawable(new Drawable[] { (Drawable)v7.v7.util.Log.valueOf(d), paramColorStateList1 });
  }
  
  final void setBackgroundDrawable(Attribute paramAttribute)
  {
    mView = paramAttribute;
  }
  
  boolean setBackgroundDrawable()
  {
    return true;
  }
  
  void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    Object localObject = d;
    if (localObject != null) {
      ((f)localObject).setTintList(paramColorStateList);
    }
    localObject = a;
    if (localObject != null) {
      ((CircularBorderDrawable)localObject).setBorderTint(paramColorStateList);
    }
  }
  
  void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    f localF = d;
    if (localF != null) {
      localF.setTintMode(paramMode);
    }
  }
  
  float setElevation()
  {
    return mPressedTranslationZ;
  }
  
  final void setElevation(float paramFloat)
  {
    if (mElevation != paramFloat)
    {
      mElevation = paramFloat;
      onPostExecute(paramFloat, mPressedTranslationZ, mShadowDrawable);
    }
  }
  
  final void setElevation(Attribute paramAttribute)
  {
    target = paramAttribute;
  }
  
  void setElevation(boolean paramBoolean)
  {
    h = paramBoolean;
    updatePadding();
  }
  
  final void setPressedTranslationZ(float paramFloat)
  {
    if (mPressedTranslationZ != paramFloat)
    {
      mPressedTranslationZ = paramFloat;
      onPostExecute(mElevation, paramFloat, mShadowDrawable);
    }
  }
  
  final void setPressedTranslationZ(int paramInt)
  {
    if (mPaint != paramInt)
    {
      mPaint = paramInt;
      onTranslationZChanged();
    }
  }
  
  void setRippleColor(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = j;
    if (localDrawable != null) {
      DrawableCompat.append(localDrawable, org.org.org.ui.compound.Log.getColor(paramColorStateList));
    }
  }
  
  final void setup(float paramFloat)
  {
    duration = paramFloat;
    Matrix localMatrix = mMatrix;
    draw(paramFloat, localMatrix);
    this$0.setImageMatrix(localMatrix);
  }
  
  final Attribute show()
  {
    return mView;
  }
  
  void show(Animator.AnimatorListener paramAnimatorListener)
  {
    if (list == null) {
      list = new ArrayList();
    }
    list.add(paramAnimatorListener);
  }
  
  void show(Rect paramRect)
  {
    if (r) {
      i = (left - this$0.getSizeDimension()) / 2;
    } else {
      i = 0;
    }
    float f1;
    if (h) {
      f1 = getElevation() + mShadowDrawable;
    } else {
      f1 = 0.0F;
    }
    int k = Math.max(i, (int)Math.ceil(f1));
    int i = Math.max(i, (int)Math.ceil(f1 * 1.5F));
    paramRect.set(k, i, k, i);
  }
  
  void show(InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean)
  {
    if (equals()) {
      return;
    }
    Object localObject = animator;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (init())
    {
      if (this$0.getVisibility() != 0)
      {
        this$0.setAlpha(0.0F);
        this$0.setScaleY(0.0F);
        this$0.setScaleX(0.0F);
        setup(0.0F);
      }
      localObject = mView;
      if (localObject == null) {
        localObject = next();
      }
      localObject = add((Attribute)localObject, 1.0F, 1.0F, 1.0F);
      ((Animator)localObject).addListener(new FloatingActionButtonIcs.2(this, paramBoolean, paramInternalVisibilityChangedListener));
      paramInternalVisibilityChangedListener = list;
      if (paramInternalVisibilityChangedListener != null)
      {
        paramInternalVisibilityChangedListener = paramInternalVisibilityChangedListener.iterator();
        while (paramInternalVisibilityChangedListener.hasNext()) {
          ((Animator)localObject).addListener((Animator.AnimatorListener)paramInternalVisibilityChangedListener.next());
        }
      }
      ((AnimatorSet)localObject).start();
      return;
    }
    this$0.internalSetVisibility(0, paramBoolean);
    this$0.setAlpha(1.0F);
    this$0.setScaleY(1.0F);
    this$0.setScaleX(1.0F);
    setup(1.0F);
    if (paramInternalVisibilityChangedListener != null) {
      paramInternalVisibilityChangedListener.onShown();
    }
  }
  
  void show(int[] paramArrayOfInt)
  {
    mStateListAnimator.setState(paramArrayOfInt);
  }
  
  void start(InternalVisibilityChangedListener paramInternalVisibilityChangedListener, boolean paramBoolean)
  {
    if (play()) {
      return;
    }
    Object localObject = animator;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    if (init())
    {
      localObject = target;
      if (localObject == null) {
        localObject = set();
      }
      localObject = add((Attribute)localObject, 0.0F, 0.0F, 0.0F);
      ((Animator)localObject).addListener(new FloatingActionButtonIcs.1(this, paramBoolean, paramInternalVisibilityChangedListener));
      paramInternalVisibilityChangedListener = state;
      if (paramInternalVisibilityChangedListener != null)
      {
        paramInternalVisibilityChangedListener = paramInternalVisibilityChangedListener.iterator();
        while (paramInternalVisibilityChangedListener.hasNext()) {
          ((Animator)localObject).addListener((Animator.AnimatorListener)paramInternalVisibilityChangedListener.next());
        }
      }
      ((AnimatorSet)localObject).start();
      return;
    }
    localObject = this$0;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 4;
    }
    ((VisibilityAwareImageButton)localObject).internalSetVisibility(i, paramBoolean);
    if (paramInternalVisibilityChangedListener != null) {
      paramInternalVisibilityChangedListener.onHidden();
    }
  }
  
  final void updatePadding()
  {
    Rect localRect = mTmpRect;
    show(localRect);
    onPaddingUpdated(localRect);
    mShadowViewDelegate.setShadowPadding(left, top, right, bottom);
  }
  
  abstract interface InternalVisibilityChangedListener
  {
    public abstract void onHidden();
    
    public abstract void onShown();
  }
}
