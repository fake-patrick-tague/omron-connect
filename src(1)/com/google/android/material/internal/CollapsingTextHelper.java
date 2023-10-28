package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import org.org.org.ui.menu.f;
import org.org.org.ui.utils.AnimationUtils;
import v7.v7.package_13.ViewCompat;
import v7.v7.text.TextDirectionHeuristicCompat;
import v7.v7.text.TextDirectionHeuristicsCompat;
import v7.v7.widget.MathUtils;

public final class CollapsingTextHelper
{
  private static final Paint DEBUG_DRAW_PAINT = null;
  private static final boolean USE_SCALING_TEXTURE;
  private float a;
  private f b;
  private f c;
  private int left = 1;
  private boolean mBoundsChanged;
  private final Rect mCollapsedBounds;
  private float mCollapsedDrawX;
  private float mCollapsedDrawY;
  private ColorStateList mCollapsedShadowColor;
  private float mCollapsedShadowDx;
  private float mCollapsedShadowDy;
  private float mCollapsedShadowRadius;
  private ColorStateList mCollapsedTextColor;
  private int mCollapsedTextGravity = 16;
  private float mCollapsedTextSize = 15.0F;
  private Typeface mCollapsedTypeface;
  private final RectF mCurrentBounds;
  private float mCurrentDrawX;
  private float mCurrentDrawY;
  private float mCurrentLeft;
  private float mCurrentTextSize;
  private Typeface mCurrentTypeface;
  private int[] mData;
  private boolean mDrawTitle;
  private final Rect mExpandedBounds;
  private float mExpandedDrawX;
  private float mExpandedDrawY;
  private float mExpandedFraction;
  private ColorStateList mExpandedShadowColor;
  private float mExpandedShadowDx;
  private float mExpandedShadowDy;
  private float mExpandedShadowRadius;
  private ColorStateList mExpandedTextColor;
  private int mExpandedTextGravity = 16;
  private float mExpandedTextSize = 15.0F;
  private Bitmap mExpandedTitleTexture;
  private Typeface mExpandedTypeface;
  private boolean mIsRtl;
  private final TextPaint mPaint;
  private TimeInterpolator mPositionInterpolator;
  private float mScale;
  private CharSequence mText;
  private StaticLayout mTextLayout;
  private final TextPaint mTextPaint;
  private TimeInterpolator mTextSizeInterpolator;
  private CharSequence mTextToDraw;
  private Paint mTexturePaint;
  private float mTriggerPercentage;
  private boolean mUseTexture;
  private float mWidth;
  private final View right;
  private CharSequence title;
  private float y;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    }
    USE_SCALING_TEXTURE = bool;
  }
  
  public CollapsingTextHelper(View paramView)
  {
    right = paramView;
    paramView = new TextPaint(129);
    mTextPaint = paramView;
    mPaint = new TextPaint(paramView);
    mCollapsedBounds = new Rect();
    mExpandedBounds = new Rect();
    mCurrentBounds = new RectF();
  }
  
  private boolean a()
  {
    return ViewCompat.getLayoutDirection(right) == 1;
  }
  
  private static int blendColors(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f8 * f1 + f9 * paramFloat));
  }
  
  private void calculateBaseOffsets()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  private void calculateCurrentOffsets()
  {
    calculateOffsets(mExpandedFraction);
  }
  
  private boolean calculateIsRtl(CharSequence paramCharSequence)
  {
    TextDirectionHeuristicCompat localTextDirectionHeuristicCompat;
    if (a()) {
      localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    } else {
      localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    }
    return localTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void calculateOffsets(float paramFloat)
  {
    interpolateBounds(paramFloat);
    mCurrentDrawX = lerp(mExpandedDrawX, mCollapsedDrawX, paramFloat, mPositionInterpolator);
    mCurrentDrawY = lerp(mExpandedDrawY, mCollapsedDrawY, paramFloat, mPositionInterpolator);
    setInterpolatedTextSize(lerp(mExpandedTextSize, mCollapsedTextSize, paramFloat, mTextSizeInterpolator));
    TimeInterpolator localTimeInterpolator = AnimationUtils.x;
    setTriggerPercentage(1.0F - lerp(0.0F, 1.0F, 1.0F - paramFloat, localTimeInterpolator));
    draw(lerp(1.0F, 0.0F, paramFloat, localTimeInterpolator));
    if (mCollapsedTextColor != mExpandedTextColor) {
      mTextPaint.setColor(blendColors(getExpandedTextColor(), getCollapsedTextColor(), paramFloat));
    } else {
      mTextPaint.setColor(getCollapsedTextColor());
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      float f1 = a;
      float f2 = y;
      if (f1 != f2) {
        mTextPaint.setLetterSpacing(lerp(f2, f1, paramFloat, localTimeInterpolator));
      } else {
        mTextPaint.setLetterSpacing(f1);
      }
    }
    mTextPaint.setShadowLayer(lerp(mExpandedShadowRadius, mCollapsedShadowRadius, paramFloat, null), lerp(mExpandedShadowDx, mCollapsedShadowDx, paramFloat, null), lerp(mExpandedShadowDy, mCollapsedShadowDy, paramFloat, null), blendColors(getInt(mExpandedShadowColor), getInt(mCollapsedShadowColor), paramFloat));
    ViewCompat.postInvalidateOnAnimation(right);
  }
  
  private void calculateUsingTextSize(float paramFloat)
  {
    if (mText == null) {
      return;
    }
    float f2 = mCollapsedBounds.width();
    float f3 = mExpandedBounds.width();
    boolean bool2 = isClose(paramFloat, mCollapsedTextSize);
    boolean bool1 = false;
    int k = 1;
    float f1;
    Object localObject;
    Typeface localTypeface;
    int i;
    if (bool2)
    {
      f1 = mCollapsedTextSize;
      mScale = 1.0F;
      localObject = mCurrentTypeface;
      localTypeface = mCollapsedTypeface;
      if (localObject != localTypeface)
      {
        mCurrentTypeface = localTypeface;
        i = 1;
        paramFloat = f2;
      }
      else
      {
        i = 0;
        paramFloat = f2;
      }
    }
    else
    {
      f1 = mExpandedTextSize;
      localObject = mCurrentTypeface;
      localTypeface = mExpandedTypeface;
      if (localObject != localTypeface)
      {
        mCurrentTypeface = localTypeface;
        i = 1;
      }
      else
      {
        i = 0;
      }
      if (isClose(paramFloat, f1)) {
        mScale = 1.0F;
      } else {
        mScale = (paramFloat / mExpandedTextSize);
      }
      paramFloat = mCollapsedTextSize / mExpandedTextSize;
      if (f3 * paramFloat > f2) {
        paramFloat = Math.min(f2 / paramFloat, f3);
      } else {
        paramFloat = f3;
      }
    }
    int j = i;
    if (paramFloat > 0.0F)
    {
      if ((mCurrentTextSize == f1) && (!mBoundsChanged) && (i == 0)) {
        i = 0;
      } else {
        i = 1;
      }
      mCurrentTextSize = f1;
      mBoundsChanged = false;
      j = i;
    }
    if ((mTextToDraw == null) || (j != 0))
    {
      mTextPaint.setTextSize(mCurrentTextSize);
      mTextPaint.setTypeface(mCurrentTypeface);
      localObject = mTextPaint;
      if (mScale != 1.0F) {
        bool1 = true;
      }
      ((Paint)localObject).setLinearText(bool1);
      mIsRtl = calculateIsRtl(mText);
      i = k;
      if (draw()) {
        i = left;
      }
      localObject = draw(i, paramFloat, mIsRtl);
      mTextLayout = ((StaticLayout)localObject);
      mTextToDraw = ((Layout)localObject).getText();
    }
  }
  
  private void clearTexture()
  {
    Bitmap localBitmap = mExpandedTitleTexture;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      mExpandedTitleTexture = null;
    }
  }
  
  private float draw(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 17) && ((paramInt2 & 0x7) != 1))
    {
      if (((paramInt2 & 0x800005) != 8388613) && ((paramInt2 & 0x5) != 5))
      {
        if (mIsRtl) {
          return mCollapsedBounds.right - drawText();
        }
        return mCollapsedBounds.left;
      }
      if (mIsRtl) {
        return mCollapsedBounds.left;
      }
      return mCollapsedBounds.right - drawText();
    }
    return paramInt1 / 2.0F - drawText() / 2.0F;
  }
  
  private float draw(RectF paramRectF, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 17) && ((paramInt2 & 0x7) != 1))
    {
      if (((paramInt2 & 0x800005) != 8388613) && ((paramInt2 & 0x5) != 5))
      {
        if (mIsRtl) {
          return mCollapsedBounds.right;
        }
        return left + drawText();
      }
      if (mIsRtl) {
        return left + drawText();
      }
      return mCollapsedBounds.right;
    }
    return paramInt1 / 2.0F + drawText() / 2.0F;
  }
  
  private StaticLayout draw(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Object localObject1 = mText;
    Object localObject3 = mTextPaint;
    int i = (int)paramFloat;
    Object localObject2;
    try
    {
      localObject1 = e.a((CharSequence)localObject1, (TextPaint)localObject3, i);
      localObject3 = TextUtils.TruncateAt.END;
      localObject1 = ((e)localObject1).a((TextUtils.TruncateAt)localObject3).b(paramBoolean);
      localObject3 = Layout.Alignment.ALIGN_NORMAL;
      localObject1 = ((e)localObject1).a((Layout.Alignment)localObject3).a(false).a(paramInt).a();
    }
    catch (AtomicBoolean localAtomicBoolean)
    {
      android.util.Log.e("CollapsingTextHelper", localAtomicBoolean.getCause().getMessage(), localAtomicBoolean);
      localObject2 = null;
    }
    return (StaticLayout)v7.v7.util.Log.valueOf(localObject2);
  }
  
  private void draw(float paramFloat)
  {
    mWidth = paramFloat;
    ViewCompat.postInvalidateOnAnimation(right);
  }
  
  private void draw(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    int i = mTextPaint.getAlpha();
    paramCanvas.translate(paramFloat1, paramFloat2);
    Object localObject = mTextPaint;
    paramFloat1 = mWidth;
    paramFloat2 = i;
    ((Paint)localObject).setAlpha((int)(paramFloat1 * paramFloat2));
    mTextLayout.draw(paramCanvas);
    mTextPaint.setAlpha((int)(mTriggerPercentage * paramFloat2));
    int j = mTextLayout.getLineBaseline(0);
    localObject = title;
    int k = ((CharSequence)localObject).length();
    paramFloat1 = j;
    paramCanvas.drawText((CharSequence)localObject, 0, k, 0.0F, paramFloat1, mTextPaint);
    String str = title.toString().trim();
    localObject = str;
    if (str.endsWith("?")) {
      localObject = str.substring(0, str.length() - 1);
    }
    mTextPaint.setAlpha(i);
    paramCanvas.drawText((String)localObject, 0, Math.min(mTextLayout.getLineEnd(0), ((String)localObject).length()), 0.0F, paramFloat1, mTextPaint);
  }
  
  private void draw(TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(mCollapsedTextSize);
    paramTextPaint.setTypeface(mCollapsedTypeface);
    if (Build.VERSION.SDK_INT >= 21) {
      paramTextPaint.setLetterSpacing(a);
    }
  }
  
  private boolean draw()
  {
    return (left > 1) && (!mIsRtl) && (!mUseTexture);
  }
  
  private boolean draw(Typeface paramTypeface)
  {
    f localF = b;
    if (localF != null) {
      localF.a();
    }
    if (mExpandedTypeface != paramTypeface)
    {
      mExpandedTypeface = paramTypeface;
      return true;
    }
    return false;
  }
  
  private void ensureExpandedTexture()
  {
    if ((mExpandedTitleTexture == null) && (!mExpandedBounds.isEmpty()))
    {
      if (TextUtils.isEmpty(mTextToDraw)) {
        return;
      }
      calculateOffsets(0.0F);
      int i = mTextLayout.getWidth();
      int j = mTextLayout.getHeight();
      if (i > 0)
      {
        if (j <= 0) {
          return;
        }
        mExpandedTitleTexture = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(mExpandedTitleTexture);
        mTextLayout.draw(localCanvas);
        if (mTexturePaint == null) {
          mTexturePaint = new Paint(3);
        }
      }
    }
  }
  
  private int getExpandedTextColor()
  {
    return getInt(mExpandedTextColor);
  }
  
  private int getInt(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      return 0;
    }
    int[] arrayOfInt = mData;
    if (arrayOfInt != null) {
      return paramColorStateList.getColorForState(arrayOfInt, 0);
    }
    return paramColorStateList.getDefaultColor();
  }
  
  private void interpolateBounds(float paramFloat)
  {
    mCurrentBounds.left = lerp(mExpandedBounds.left, mCollapsedBounds.left, paramFloat, mPositionInterpolator);
    mCurrentBounds.top = lerp(mExpandedDrawY, mCollapsedDrawY, paramFloat, mPositionInterpolator);
    mCurrentBounds.right = lerp(mExpandedBounds.right, mCollapsedBounds.right, paramFloat, mPositionInterpolator);
    mCurrentBounds.bottom = lerp(mExpandedBounds.bottom, mCollapsedBounds.bottom, paramFloat, mPositionInterpolator);
  }
  
  private static boolean isClose(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }
  
  private static float lerp(float paramFloat1, float paramFloat2, float paramFloat3, TimeInterpolator paramTimeInterpolator)
  {
    float f = paramFloat3;
    if (paramTimeInterpolator != null) {
      f = paramTimeInterpolator.getInterpolation(paramFloat3);
    }
    return AnimationUtils.lerp(paramFloat1, paramFloat2, f);
  }
  
  private static boolean rectEquals(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (left == paramInt1) && (top == paramInt2) && (right == paramInt3) && (bottom == paramInt4);
  }
  
  private void setInterpolatedTextSize(float paramFloat)
  {
    calculateUsingTextSize(paramFloat);
    boolean bool;
    if ((USE_SCALING_TEXTURE) && (mScale != 1.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    mUseTexture = bool;
    if (bool) {
      ensureExpandedTexture();
    }
    ViewCompat.postInvalidateOnAnimation(right);
  }
  
  private void setText(TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(mExpandedTextSize);
    paramTextPaint.setTypeface(mExpandedTypeface);
    if (Build.VERSION.SDK_INT >= 21) {
      paramTextPaint.setLetterSpacing(y);
    }
  }
  
  private boolean setText(Typeface paramTypeface)
  {
    f localF = c;
    if (localF != null) {
      localF.a();
    }
    if (mCollapsedTypeface != paramTypeface)
    {
      mCollapsedTypeface = paramTypeface;
      return true;
    }
    return false;
  }
  
  private void setTriggerPercentage(float paramFloat)
  {
    mTriggerPercentage = paramFloat;
    ViewCompat.postInvalidateOnAnimation(right);
  }
  
  public void a(int paramInt)
  {
    org.org.org.ui.menu.h localH = new org.org.org.ui.menu.h(right.getContext(), paramInt);
    Object localObject = u;
    if (localObject != null) {
      mExpandedTextColor = ((ColorStateList)localObject);
    }
    float f = a;
    if (f != 0.0F) {
      mExpandedTextSize = f;
    }
    localObject = w;
    if (localObject != null) {
      mExpandedShadowColor = ((ColorStateList)localObject);
    }
    mExpandedShadowDx = l;
    mExpandedShadowDy = j;
    mExpandedShadowRadius = k;
    y = i;
    localObject = b;
    if (localObject != null) {
      ((f)localObject).a();
    }
    b = new f(new h(this), localH.a());
    localH.a(right.getContext(), b);
    recalculate();
  }
  
  public final boolean apply()
  {
    ColorStateList localColorStateList = mCollapsedTextColor;
    if ((localColorStateList == null) || (!localColorStateList.isStateful())) {
      localColorStateList = mExpandedTextColor;
    }
    return (localColorStateList != null) && (localColorStateList.isStateful());
  }
  
  public void b(int paramInt)
  {
    org.org.org.ui.menu.h localH = new org.org.org.ui.menu.h(right.getContext(), paramInt);
    Object localObject = u;
    if (localObject != null) {
      mCollapsedTextColor = ((ColorStateList)localObject);
    }
    float f = a;
    if (f != 0.0F) {
      mCollapsedTextSize = f;
    }
    localObject = w;
    if (localObject != null) {
      mCollapsedShadowColor = ((ColorStateList)localObject);
    }
    mCollapsedShadowDx = l;
    mCollapsedShadowDy = j;
    mCollapsedShadowRadius = k;
    a = i;
    localObject = c;
    if (localObject != null) {
      ((f)localObject).a();
    }
    c = new f(new a(this), localH.a());
    localH.a(right.getContext(), c);
    recalculate();
  }
  
  public void calculateOffsets(RectF paramRectF, int paramInt1, int paramInt2)
  {
    mIsRtl = calculateIsRtl(mText);
    left = draw(paramInt1, paramInt2);
    top = mCollapsedBounds.top;
    right = draw(paramRectF, paramInt1, paramInt2);
    bottom = (mCollapsedBounds.top + setText());
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = paramCanvas.save();
    if ((mTextToDraw != null) && (mDrawTitle))
    {
      float f1 = mCurrentDrawX;
      StaticLayout localStaticLayout = mTextLayout;
      int j = 0;
      float f2 = localStaticLayout.getLineLeft(0);
      float f3 = mCurrentLeft;
      mTextPaint.setTextSize(mCurrentTextSize);
      float f4 = mCurrentDrawX;
      float f5 = mCurrentDrawY;
      int i = j;
      if (mUseTexture)
      {
        i = j;
        if (mExpandedTitleTexture != null) {
          i = 1;
        }
      }
      float f6 = mScale;
      if (f6 != 1.0F) {
        paramCanvas.scale(f6, f6, f4, f5);
      }
      if (i != 0)
      {
        paramCanvas.drawBitmap(mExpandedTitleTexture, f4, f5, mTexturePaint);
        paramCanvas.restoreToCount(k);
        return;
      }
      if (draw())
      {
        draw(paramCanvas, f1 + f2 - f3 * 2.0F, f5);
      }
      else
      {
        paramCanvas.translate(f4, f5);
        mTextLayout.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(k);
    }
  }
  
  public void draw(Rect paramRect)
  {
    setCollapsedBounds(left, top, right, bottom);
  }
  
  public float drawText()
  {
    if (mText == null) {
      return 0.0F;
    }
    draw(mPaint);
    TextPaint localTextPaint = mPaint;
    CharSequence localCharSequence = mText;
    return localTextPaint.measureText(localCharSequence, 0, localCharSequence.length());
  }
  
  public int getCollapsedTextColor()
  {
    return getInt(mCollapsedTextColor);
  }
  
  public int getCollapsedTextGravity()
  {
    return mCollapsedTextGravity;
  }
  
  public Typeface getCollapsedTypeface()
  {
    Typeface localTypeface = mCollapsedTypeface;
    if (localTypeface != null) {
      return localTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  public int getExpandedTextGravity()
  {
    return mExpandedTextGravity;
  }
  
  public Typeface getExpandedTypeface()
  {
    Typeface localTypeface = mExpandedTypeface;
    if (localTypeface != null) {
      return localTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  public float getExpansionFraction()
  {
    return mExpandedFraction;
  }
  
  public CharSequence getText()
  {
    return mText;
  }
  
  public int getTypeface()
  {
    return left;
  }
  
  public float initialize()
  {
    setText(mPaint);
    return -mPaint.ascent();
  }
  
  void onBoundsChanged()
  {
    boolean bool;
    if ((mCollapsedBounds.width() > 0) && (mCollapsedBounds.height() > 0) && (mExpandedBounds.width() > 0) && (mExpandedBounds.height() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    mDrawTitle = bool;
  }
  
  public void onLayout(Rect paramRect)
  {
    setExpandedBounds(left, top, right, bottom);
  }
  
  public void recalculate()
  {
    if ((right.getHeight() > 0) && (right.getWidth() > 0))
    {
      calculateBaseOffsets();
      calculateCurrentOffsets();
    }
  }
  
  public void setCollapsedBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!rectEquals(mCollapsedBounds, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      mCollapsedBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      mBoundsChanged = true;
      onBoundsChanged();
    }
  }
  
  public ColorStateList setCollapsedTextAppearance()
  {
    return mCollapsedTextColor;
  }
  
  public void setCollapsedTextColor(ColorStateList paramColorStateList)
  {
    if (mCollapsedTextColor != paramColorStateList)
    {
      mCollapsedTextColor = paramColorStateList;
      recalculate();
    }
  }
  
  public void setCollapsedTextGravity(int paramInt)
  {
    if (mCollapsedTextGravity != paramInt)
    {
      mCollapsedTextGravity = paramInt;
      recalculate();
    }
  }
  
  public void setCollapsedTypeface(Typeface paramTypeface)
  {
    if (setText(paramTypeface)) {
      recalculate();
    }
  }
  
  public void setExpandedBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!rectEquals(mExpandedBounds, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      mExpandedBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      mBoundsChanged = true;
      onBoundsChanged();
    }
  }
  
  public void setExpandedTextColor(ColorStateList paramColorStateList)
  {
    if (mExpandedTextColor != paramColorStateList)
    {
      mExpandedTextColor = paramColorStateList;
      recalculate();
    }
  }
  
  public void setExpandedTextGravity(int paramInt)
  {
    if (mExpandedTextGravity != paramInt)
    {
      mExpandedTextGravity = paramInt;
      recalculate();
    }
  }
  
  public void setExpandedTextSize(float paramFloat)
  {
    if (mExpandedTextSize != paramFloat)
    {
      mExpandedTextSize = paramFloat;
      recalculate();
    }
  }
  
  public void setExpandedTypeface(Typeface paramTypeface)
  {
    if (draw(paramTypeface)) {
      recalculate();
    }
  }
  
  public void setExpansionFraction(float paramFloat)
  {
    paramFloat = MathUtils.constrain(paramFloat, 0.0F, 1.0F);
    if (paramFloat != mExpandedFraction)
    {
      mExpandedFraction = paramFloat;
      calculateCurrentOffsets();
    }
  }
  
  public void setPositionInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    mPositionInterpolator = paramTimeInterpolator;
    recalculate();
  }
  
  public float setText()
  {
    draw(mPaint);
    return -mPaint.ascent();
  }
  
  public void setText(int paramInt)
  {
    if (paramInt != left)
    {
      left = paramInt;
      clearTexture();
      recalculate();
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!TextUtils.equals(mText, paramCharSequence)))
    {
      mText = paramCharSequence;
      mTextToDraw = null;
      clearTexture();
      recalculate();
    }
  }
  
  public final boolean setText(int[] paramArrayOfInt)
  {
    mData = paramArrayOfInt;
    if (apply())
    {
      recalculate();
      return true;
    }
    return false;
  }
  
  public void setTextSizeInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    mTextSizeInterpolator = paramTimeInterpolator;
    recalculate();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    boolean bool1 = setText(paramTypeface);
    boolean bool2 = draw(paramTypeface);
    if ((bool1) || (bool2)) {
      recalculate();
    }
  }
}
