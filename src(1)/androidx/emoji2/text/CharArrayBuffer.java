package androidx.emoji2.text;

import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import java.util.stream.IntStream;

class CharArrayBuffer
  implements Spannable
{
  private Spannable editable;
  private boolean index = false;
  
  CharArrayBuffer(Spannable paramSpannable)
  {
    editable = paramSpannable;
  }
  
  CharArrayBuffer(CharSequence paramCharSequence)
  {
    editable = new SpannableString(paramCharSequence);
  }
  
  static e a()
  {
    if (Build.VERSION.SDK_INT < 28) {
      return new e();
    }
    return new o();
  }
  
  private void append()
  {
    Spannable localSpannable = editable;
    if ((!index) && (a().b(localSpannable))) {
      editable = new SpannableString(localSpannable);
    }
    index = true;
  }
  
  public char charAt(int paramInt)
  {
    return editable.charAt(paramInt);
  }
  
  Spannable charAt()
  {
    return editable;
  }
  
  public IntStream chars()
  {
    return Frame.b(editable);
  }
  
  public IntStream codePoints()
  {
    return Frame.d(editable);
  }
  
  public int getSpanEnd(Object paramObject)
  {
    return editable.getSpanEnd(paramObject);
  }
  
  public int getSpanFlags(Object paramObject)
  {
    return editable.getSpanFlags(paramObject);
  }
  
  public int getSpanStart(Object paramObject)
  {
    return editable.getSpanStart(paramObject);
  }
  
  public Object[] getSpans(int paramInt1, int paramInt2, Class paramClass)
  {
    return editable.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public int length()
  {
    return editable.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return editable.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public void removeSpan(Object paramObject)
  {
    append();
    editable.removeSpan(paramObject);
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    append();
    editable.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return editable.subSequence(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return editable.toString();
  }
}
