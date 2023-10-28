package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsSeekBar;
import android.widget.SeekBar;
import v7.internal.R.attr;

public class AppCompatSeekBar
  extends SeekBar
{
  private final AppCompatTextHelper mThumbDrawable;
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.borderColor);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.a(this, getContext());
    paramContext = new AppCompatTextHelper(this);
    mThumbDrawable = paramContext;
    paramContext.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    mThumbDrawable.setState();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    mThumbDrawable.jumpToCurrentState();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      mThumbDrawable.draw(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas)
    {
      throw paramCanvas;
    }
  }
}
