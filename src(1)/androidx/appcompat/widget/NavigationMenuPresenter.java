package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import v7.internal.R.styleable;
import v7.objectweb.asm.a;

class NavigationMenuPresenter
{
  private final EditText c;
  private final a j;
  
  NavigationMenuPresenter(EditText paramEditText)
  {
    c = paramEditText;
    j = new a(paramEditText, false);
  }
  
  KeyListener a(KeyListener paramKeyListener)
  {
    KeyListener localKeyListener = paramKeyListener;
    if (f(paramKeyListener)) {
      localKeyListener = j.b(paramKeyListener);
    }
    return localKeyListener;
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
      b(bool1);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramAttributeSet.recycle();
      throw localThrowable;
    }
  }
  
  InputConnection b(InputConnection paramInputConnection, EditorInfo paramEditorInfo)
  {
    return j.a(paramInputConnection, paramEditorInfo);
  }
  
  void b(boolean paramBoolean)
  {
    j.b(paramBoolean);
  }
  
  boolean f(KeyListener paramKeyListener)
  {
    return paramKeyListener instanceof NumberKeyListener ^ true;
  }
}
