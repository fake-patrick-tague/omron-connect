package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import v7.internal.R.styleable;
import v7.objectweb.asm.h;

class MethodWriter
{
  private final h b;
  private final TextView c;
  
  MethodWriter(TextView paramTextView)
  {
    c = paramTextView;
    b = new h(paramTextView, false);
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = c.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.a, paramInt, 0);
    try
    {
      paramInt = R.styleable.FALSE;
      boolean bool2 = paramAttributeSet.hasValue(paramInt);
      boolean bool1 = true;
      if (bool2) {
        bool1 = paramAttributeSet.getBoolean(paramInt, true);
      }
      paramAttributeSet.recycle();
      f(bool1);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramAttributeSet.recycle();
      throw localThrowable;
    }
  }
  
  void e(boolean paramBoolean)
  {
    b.e(paramBoolean);
  }
  
  void f(boolean paramBoolean)
  {
    b.a(paramBoolean);
  }
  
  InputFilter[] f(InputFilter[] paramArrayOfInputFilter)
  {
    return b.a(paramArrayOfInputFilter);
  }
}
