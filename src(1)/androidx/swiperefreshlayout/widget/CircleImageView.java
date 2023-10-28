package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import v7.android.Preset;
import v7.v7.package_13.ViewCompat;

class CircleImageView
  extends ImageView
{
  private int mBackgroundColor;
  private Animation.AnimationListener mListener;
  private int mShadowRadius;
  
  CircleImageView(Context paramContext)
  {
    super(paramContext);
    float f = getContextgetResourcesgetDisplayMetricsdensity;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    mShadowRadius = ((int)(3.5F * f));
    paramContext = getContext().obtainStyledAttributes(Preset.a);
    mBackgroundColor = paramContext.getColor(Preset.k, -328966);
    paramContext.recycle();
    if (elevationSupported())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      ViewCompat.setElevation(this, f * 4.0F);
    }
    else
    {
      paramContext = new ShapeDrawable(new OvalShadow(mShadowRadius));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(mShadowRadius, j, i, 503316480);
      i = mShadowRadius;
      setPadding(i, i, i, i);
    }
    paramContext.getPaint().setColor(mBackgroundColor);
    ViewCompat.setBackgroundDrawable(this, paramContext);
  }
  
  private boolean elevationSupported()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public void onAnimationEnd()
  {
    super.onAnimationEnd();
    Animation.AnimationListener localAnimationListener = mListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationEnd(getAnimation());
    }
  }
  
  public void onAnimationStart()
  {
    super.onAnimationStart();
    Animation.AnimationListener localAnimationListener = mListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(getAnimation());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!elevationSupported()) {
      setMeasuredDimension(getMeasuredWidth() + mShadowRadius * 2, getMeasuredHeight() + mShadowRadius * 2);
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    mListener = paramAnimationListener;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable))
    {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
      mBackgroundColor = paramInt;
    }
  }
  
  class OvalShadow
    extends OvalShape
  {
    private int mCircleDiameter;
    private Paint mShadowPaint = new Paint();
    
    OvalShadow(int paramInt)
    {
      mCircleDiameter = paramInt;
      draw((int)rect().width());
    }
    
    private void draw(int paramInt)
    {
      Paint localPaint = mShadowPaint;
      float f1 = paramInt / 2;
      float f2 = mCircleDiameter;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      localPaint.setShader(new RadialGradient(f1, f1, f2, new int[] { 1023410176, 0 }, null, localTileMode));
    }
    
    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int i = getWidth() / 2;
      int j = getHeight() / 2;
      float f1 = i;
      float f2 = j;
      paramCanvas.drawCircle(f1, f2, f1, mShadowPaint);
      paramCanvas.drawCircle(f1, f2, i - mCircleDiameter, paramPaint);
    }
    
    protected void onResize(float paramFloat1, float paramFloat2)
    {
      super.onResize(paramFloat1, paramFloat2);
      draw((int)paramFloat1);
    }
  }
}
