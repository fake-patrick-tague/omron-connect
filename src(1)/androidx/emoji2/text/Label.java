package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;

final class Label
{
  private final int[] a;
  private final h b;
  private final boolean c;
  private g d;
  private final SizeMetrics g;
  
  Label(h paramH, SizeMetrics paramSizeMetrics, g paramG, boolean paramBoolean, int[] paramArrayOfInt)
  {
    g = paramSizeMetrics;
    b = paramH;
    d = paramG;
    c = paramBoolean;
    a = paramArrayOfInt;
  }
  
  private void a(Spannable paramSpannable, i paramI, int paramInt1, int paramInt2)
  {
    paramSpannable.setSpan(g.getRectF(paramI), paramInt1, paramInt2, 33);
  }
  
  private static boolean a(KeyEvent paramKeyEvent)
  {
    return KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState()) ^ true;
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, i paramI)
  {
    if (paramI.d() == 0) {
      paramI.b(d.a(paramCharSequence, paramInt1, paramInt2, paramI.b()));
    }
    return paramI.d() == 2;
  }
  
  static boolean action(InputConnection paramInputConnection, Editable paramEditable, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramEditable != null)
    {
      if (paramInputConnection == null) {
        return false;
      }
      if (paramInt1 >= 0)
      {
        if (paramInt2 < 0) {
          return false;
        }
        int i = Selection.getSelectionStart(paramEditable);
        int j = Selection.getSelectionEnd(paramEditable);
        if (put(i, j)) {
          return false;
        }
        if (paramBoolean)
        {
          i = Rectangle.translate(paramEditable, i, Math.max(paramInt1, 0));
          paramInt1 = i;
          j = Rectangle.write(paramEditable, j, Math.max(paramInt2, 0));
          paramInt2 = j;
          if (i == -1) {
            break label256;
          }
          if (j == -1) {
            return false;
          }
        }
        else
        {
          paramInt1 = Math.max(i - paramInt1, 0);
          paramInt2 = Math.min(j + paramInt2, paramEditable.length());
        }
        x[] arrayOfX = (x[])paramEditable.getSpans(paramInt1, paramInt2, j.class);
        if ((arrayOfX != null) && (arrayOfX.length > 0))
        {
          int k = arrayOfX.length;
          j = 0;
          i = paramInt1;
          paramInt1 = j;
          while (paramInt1 < k)
          {
            x localX = arrayOfX[paramInt1];
            int m = paramEditable.getSpanStart(localX);
            j = paramEditable.getSpanEnd(localX);
            i = Math.min(m, i);
            paramInt2 = Math.max(j, paramInt2);
            paramInt1 += 1;
          }
          paramInt1 = Math.max(i, 0);
          paramInt2 = Math.min(paramInt2, paramEditable.length());
          paramInputConnection.beginBatchEdit();
          paramEditable.delete(paramInt1, paramInt2);
          paramInputConnection.endBatchEdit();
          return true;
        }
      }
    }
    label256:
    return false;
  }
  
  static boolean processKey(Editable paramEditable, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt != 67)
    {
      if (paramInt != 112) {
        bool = false;
      } else {
        bool = replace(paramEditable, paramKeyEvent, true);
      }
    }
    else {
      bool = replace(paramEditable, paramKeyEvent, false);
    }
    if (bool)
    {
      MetaKeyKeyListener.adjustMetaAfterKeypress(paramEditable);
      return true;
    }
    return false;
  }
  
  private static boolean put(int paramInt1, int paramInt2)
  {
    return (paramInt1 == -1) || (paramInt2 == -1) || (paramInt1 != paramInt2);
  }
  
  private static boolean replace(Editable paramEditable, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (a(paramKeyEvent)) {
      return false;
    }
    int j = Selection.getSelectionStart(paramEditable);
    int i = Selection.getSelectionEnd(paramEditable);
    if (put(j, i)) {
      return false;
    }
    paramKeyEvent = (x[])paramEditable.getSpans(j, i, j.class);
    if ((paramKeyEvent != null) && (paramKeyEvent.length > 0))
    {
      int k = paramKeyEvent.length;
      i = 0;
      while (i < k)
      {
        Object localObject = paramKeyEvent[i];
        int m = paramEditable.getSpanStart(localObject);
        int n = paramEditable.getSpanEnd(localObject);
        if (((paramBoolean) && (m == j)) || ((!paramBoolean) && (n == j)) || ((j > m) && (j < n)))
        {
          paramEditable.delete(m, n);
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool1 = paramCharSequence instanceof StrBuilder;
    if (bool1) {
      ((StrBuilder)paramCharSequence).delete();
    }
    Object localObject2 = null;
    if (!bool1) {}
    try
    {
      boolean bool2 = paramCharSequence instanceof Spannable;
      Object localObject1;
      if (!bool2)
      {
        bool2 = paramCharSequence instanceof Spanned;
        localObject1 = localObject2;
        if (bool2)
        {
          localObject1 = (Spanned)paramCharSequence;
          i = ((Spanned)localObject1).nextSpanTransition(paramInt1 - 1, paramInt2 + 1, j.class);
          localObject1 = localObject2;
          if (i <= paramInt2) {
            localObject1 = new CharArrayBuffer(paramCharSequence);
          }
        }
      }
      else
      {
        localObject1 = new CharArrayBuffer((Spannable)paramCharSequence);
      }
      int i = paramInt1;
      int j = paramInt2;
      int k;
      int m;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = (x[])((CharArrayBuffer)localObject1).getSpans(paramInt1, paramInt2, j.class);
        i = paramInt1;
        j = paramInt2;
        if (localObject2 != null)
        {
          k = localObject2.length;
          i = paramInt1;
          j = paramInt2;
          if (k > 0)
          {
            m = localObject2.length;
            k = 0;
            for (;;)
            {
              i = paramInt1;
              j = paramInt2;
              if (k >= m) {
                break;
              }
              localObject3 = localObject2[k];
              j = ((CharArrayBuffer)localObject1).getSpanStart(localObject3);
              i = ((CharArrayBuffer)localObject1).getSpanEnd(localObject3);
              if (j != paramInt2) {
                ((CharArrayBuffer)localObject1).removeSpan(localObject3);
              }
              paramInt1 = Math.min(j, paramInt1);
              paramInt2 = Math.max(i, paramInt2);
              k += 1;
            }
          }
        }
      }
      if (i != j)
      {
        paramInt1 = paramCharSequence.length();
        if (i < paramInt1)
        {
          k = paramInt3;
          if (paramInt3 != Integer.MAX_VALUE)
          {
            k = paramInt3;
            if (localObject1 != null)
            {
              paramInt1 = ((x[])((CharArrayBuffer)localObject1).getSpans(0, ((CharArrayBuffer)localObject1).length(), j.class)).length;
              k = paramInt3 - paramInt1;
            }
          }
          localObject3 = new m(b.f(), c, a);
          int n = Character.codePointAt(paramCharSequence, i);
          paramInt3 = 0;
          m = i;
          paramInt2 = i;
          paramInt1 = n;
          for (;;)
          {
            if ((paramInt2 >= j) || (paramInt3 >= k)) {
              break label567;
            }
            i = ((m)localObject3).a(paramInt1);
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3) {
                  continue;
                }
                if (!paramBoolean)
                {
                  bool2 = a(paramCharSequence, m, paramInt2, ((m)localObject3).c());
                  n = paramInt1;
                  i = paramInt2;
                  if (bool2) {
                    break;
                  }
                }
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = new CharArrayBuffer(new SpannableString(paramCharSequence));
                }
                a((Spannable)localObject2, ((m)localObject3).c(), m, paramInt2);
                paramInt3 += 1;
                localObject1 = localObject2;
                n = paramInt1;
                i = paramInt2;
                break;
              }
              i = Character.charCount(paramInt1);
              n = paramInt2 + i;
              i = n;
              paramInt2 = i;
              if (n >= j) {
                continue;
              }
              paramInt1 = Character.codePointAt(paramCharSequence, i);
              paramInt2 = i;
              continue;
            }
            paramInt2 = Character.charCount(Character.codePointAt(paramCharSequence, m));
            m += paramInt2;
            if (m < j) {
              paramInt1 = Character.codePointAt(paramCharSequence, m);
            }
            paramInt2 = m;
          }
          label567:
          bool2 = ((m)localObject3).a();
          localObject2 = localObject1;
          if (bool2)
          {
            localObject2 = localObject1;
            if (paramInt3 < k) {
              if (!paramBoolean)
              {
                paramBoolean = a(paramCharSequence, m, paramInt2, ((m)localObject3).d());
                localObject2 = localObject1;
                if (paramBoolean) {}
              }
              else
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = new CharArrayBuffer(paramCharSequence);
                }
                a((Spannable)localObject2, ((m)localObject3).d(), m, paramInt2);
              }
            }
          }
          if (localObject2 != null)
          {
            localObject1 = ((CharArrayBuffer)localObject2).charAt();
            if (!bool1) {
              break label728;
            }
            ((StrBuilder)paramCharSequence).trim();
            return localObject1;
          }
          if (!bool1) {
            return paramCharSequence;
          }
          ((StrBuilder)paramCharSequence).trim();
          return paramCharSequence;
        }
      }
      if (!bool1) {
        return paramCharSequence;
      }
      ((StrBuilder)paramCharSequence).trim();
      return paramCharSequence;
    }
    catch (Throwable localThrowable)
    {
      if (bool1) {
        ((StrBuilder)paramCharSequence).trim();
      }
      throw localThrowable;
    }
    label728:
    return localThrowable;
    return paramCharSequence;
  }
}
