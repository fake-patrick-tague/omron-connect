package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import v7.nonstiff.Mirrors;
import v7.nonstiff.R.id;
import v7.nonstiff.R.styleable;
import v7.nonstiff.b;

public class CardView
  extends FrameLayout
{
  private static final CardViewImpl IMPL;
  private static final int[] TEXT_ATTRS = { 16842801 };
  private boolean mCompatPadding;
  final Rect mContentPadding;
  private boolean mPreventCornerOverlap;
  private final CardViewDelegate mRadius;
  final Rect mShadowBounds;
  int mUserSetMinHeight;
  int mUserSetMinWidth;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      IMPL = new CardViewApi21();
    } else if (i >= 17) {
      IMPL = new CardViewJellybeanMr1();
    } else {
      IMPL = new CardViewEclairMr1();
    }
    IMPL.initStatic();
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.id.progress);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Rect localRect = new Rect();
    mContentPadding = localRect;
    mShadowBounds = new Rect();
    a localA = new a();
    mRadius = localA;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CameraPreference, paramInt, Mirrors.mTabTextAppearance);
    paramInt = R.styleable.TabLayout_tabTextColor;
    if (localTypedArray.hasValue(paramInt)) {}
    for (paramAttributeSet = localTypedArray.getColorStateList(paramInt);; paramAttributeSet = ColorStateList.valueOf(paramInt))
    {
      break;
      paramAttributeSet = getContext().obtainStyledAttributes(TEXT_ATTRS);
      paramInt = paramAttributeSet.getColor(0, 0);
      paramAttributeSet.recycle();
      paramAttributeSet = new float[3];
      Color.colorToHSV(paramInt, paramAttributeSet);
      if (paramAttributeSet[2] > 0.5F) {
        paramInt = getResources().getColor(b.b);
      } else {
        paramInt = getResources().getColor(b.m);
      }
    }
    float f4 = localTypedArray.getDimension(R.styleable.SlidingMenu_behindOffset, 0.0F);
    float f2 = localTypedArray.getDimension(R.styleable.SlidingMenu_behindWidth, 0.0F);
    float f3 = localTypedArray.getDimension(R.styleable.CirclePageIndicator_radius, 0.0F);
    mCompatPadding = localTypedArray.getBoolean(R.styleable.CirclePageIndicator_snap, false);
    mPreventCornerOverlap = localTypedArray.getBoolean(R.styleable.SlidingDrawer_animateOnClick, true);
    paramInt = localTypedArray.getDimensionPixelSize(R.styleable.Switch_bpSwitchMinWidth, 0);
    left = localTypedArray.getDimensionPixelSize(R.styleable.Switch_bpSwitchPadding, paramInt);
    top = localTypedArray.getDimensionPixelSize(R.styleable.Switch_bpSwitchTextAppearance, paramInt);
    right = localTypedArray.getDimensionPixelSize(R.styleable.Iconics_ico_offset_y, paramInt);
    bottom = localTypedArray.getDimensionPixelSize(R.styleable.Iconics_ico_padding, paramInt);
    float f1 = f3;
    if (f2 > f3) {
      f1 = f2;
    }
    mUserSetMinWidth = localTypedArray.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
    mUserSetMinHeight = localTypedArray.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
    localTypedArray.recycle();
    IMPL.initialize(localA, paramContext, paramAttributeSet, f4, f2, f1);
  }
  
  public ColorStateList getCardBackgroundColor()
  {
    return IMPL.setRadius(mRadius);
  }
  
  public float getCardElevation()
  {
    return IMPL.getElevation(mRadius);
  }
  
  public int getContentPaddingBottom()
  {
    return mContentPadding.bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return mContentPadding.left;
  }
  
  public int getContentPaddingRight()
  {
    return mContentPadding.right;
  }
  
  public int getContentPaddingTop()
  {
    return mContentPadding.top;
  }
  
  public float getMaxCardElevation()
  {
    return IMPL.getMaxElevation(mRadius);
  }
  
  public boolean getPreventCornerOverlap()
  {
    return mPreventCornerOverlap;
  }
  
  public float getRadius()
  {
    return IMPL.getRadius(mRadius);
  }
  
  public boolean getUseCompatPadding()
  {
    return mCompatPadding;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    CardViewImpl localCardViewImpl = IMPL;
    if (!(localCardViewImpl instanceof CardViewApi21))
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      if ((i == Integer.MIN_VALUE) || (i == 1073741824)) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(localCardViewImpl.getMinWidth(mRadius)), View.MeasureSpec.getSize(paramInt1)), i);
      }
      i = View.MeasureSpec.getMode(paramInt2);
      if ((i == Integer.MIN_VALUE) || (i == 1073741824)) {
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(localCardViewImpl.getMinHeight(mRadius)), View.MeasureSpec.getSize(paramInt2)), i);
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    IMPL.setBackgroundColor(mRadius, ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    IMPL.setBackgroundColor(mRadius, paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    IMPL.setElevation(mRadius, paramFloat);
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    IMPL.setMaxElevation(mRadius, paramFloat);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    mUserSetMinHeight = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    mUserSetMinWidth = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    if (paramBoolean != mPreventCornerOverlap)
    {
      mPreventCornerOverlap = paramBoolean;
      IMPL.onPreventCornerOverlapChanged(mRadius);
    }
  }
  
  public void setRadius(float paramFloat)
  {
    IMPL.setRadius(mRadius, paramFloat);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (mCompatPadding != paramBoolean)
    {
      mCompatPadding = paramBoolean;
      IMPL.onCompatPaddingChanged(mRadius);
    }
  }
  
  class a
    implements CardViewDelegate
  {
    private Drawable mBackground;
    
    a() {}
    
    public View get()
    {
      return CardView.this;
    }
    
    public Drawable getBackground()
    {
      return mBackground;
    }
    
    public boolean getPreventCornerOverlap()
    {
      return CardView.this.getPreventCornerOverlap();
    }
    
    public boolean getUseCompatPadding()
    {
      return CardView.this.getUseCompatPadding();
    }
    
    public void setBackgroundDrawable(Drawable paramDrawable)
    {
      mBackground = paramDrawable;
      CardView.this.setBackgroundDrawable(paramDrawable);
    }
    
    public void setMinWidthHeightInternal(int paramInt1, int paramInt2)
    {
      CardView localCardView = CardView.this;
      if (paramInt1 > mUserSetMinWidth) {
        CardView.setMinimumWidth(localCardView, paramInt1);
      }
      localCardView = CardView.this;
      if (paramInt2 > mUserSetMinHeight) {
        CardView.initialize(localCardView, paramInt2);
      }
    }
    
    public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      mShadowBounds.set(paramInt1, paramInt2, paramInt3, paramInt4);
      CardView localCardView = CardView.this;
      Rect localRect = mContentPadding;
      CardView.setShadowPadding(localCardView, paramInt1 + left, paramInt2 + top, paramInt3 + right, paramInt4 + bottom);
    }
  }
}
