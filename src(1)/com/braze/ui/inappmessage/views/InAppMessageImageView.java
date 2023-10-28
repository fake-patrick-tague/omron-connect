package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.braze.enums.inappmessage.CropType;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import java.util.Objects;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;

public class InAppMessageImageView
  extends ImageView
  implements IInAppMessageImageView
{
  private float aspectRatio = -1.0F;
  private Path clipPath = new Path();
  private float[] inAppRadii;
  private RectF rectf = new RectF();
  private boolean setToHalfParentHeight;
  
  public InAppMessageImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setAdjustViewBounds(true);
  }
  
  public final boolean clipCanvasToPath(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    i.e(paramCanvas, "canvas");
    if (inAppRadii == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, clipCanvasToPath.2.INSTANCE, 3, null);
      return false;
    }
    Object localObject = clipPath;
    try
    {
      ((Path)localObject).reset();
      localObject = rectf;
      float f1 = paramInt1;
      float f2 = paramInt2;
      ((RectF)localObject).set(0.0F, 0.0F, f1, f2);
      localObject = clipPath;
      RectF localRectF = rectf;
      float[] arrayOfFloat = getInAppRadii();
      Path.Direction localDirection = Path.Direction.CW;
      ((Path)localObject).addRoundRect(localRectF, arrayOfFloat, localDirection);
      localObject = clipPath;
      paramCanvas.clipPath((Path)localObject);
      return true;
    }
    catch (Exception paramCanvas)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramCanvas, clipCanvasToPath.3.INSTANCE);
    }
    return false;
  }
  
  public final Path getClipPath()
  {
    return clipPath;
  }
  
  public final float[] getInAppRadii()
  {
    float[] arrayOfFloat = inAppRadii;
    if (arrayOfFloat != null) {
      return arrayOfFloat;
    }
    i.o("inAppRadii");
    return null;
  }
  
  public final RectF getRectf()
  {
    return rectf;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    i.e(paramCanvas, "canvas");
    clipCanvasToPath(paramCanvas, getWidth(), getHeight());
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (aspectRatio == -1.0F) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 == 0) && (getMeasuredHeight() > 0) && (getMeasuredWidth() > 0))
    {
      paramInt1 = getMeasuredWidth();
      paramInt2 = (int)(paramInt1 / aspectRatio);
      setMeasuredDimension(paramInt1, Math.min(getMeasuredHeight(), paramInt2) + 1);
    }
    else
    {
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }
    if (setToHalfParentHeight)
    {
      ViewParent localViewParent = getParent();
      Objects.requireNonNull(localViewParent, "null cannot be cast to non-null type android.view.View");
      paramInt1 = ((View)localViewParent).getHeight();
      setMeasuredDimension(getMeasuredWidth(), (int)(paramInt1 * 0.5D));
    }
  }
  
  public void setAspectRatio(float paramFloat)
  {
    aspectRatio = paramFloat;
    requestLayout();
  }
  
  public final void setClipPath(Path paramPath)
  {
    i.e(paramPath, "<set-?>");
    clipPath = paramPath;
  }
  
  public void setCornersRadiiPx(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    inAppRadii = new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 };
  }
  
  public void setCornersRadiusPx(float paramFloat)
  {
    setCornersRadiiPx(paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setInAppMessageImageCropType(CropType paramCropType)
  {
    if (paramCropType == CropType.FIT_CENTER)
    {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
      return;
    }
    if (paramCropType == CropType.CENTER_CROP) {
      setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public final void setRectf(RectF paramRectF)
  {
    i.e(paramRectF, "<set-?>");
    rectf = paramRectF;
  }
  
  public void setToHalfParentHeight(boolean paramBoolean)
  {
    setToHalfParentHeight = paramBoolean;
    requestLayout();
  }
}
