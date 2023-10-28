package androidx.emoji2.text;

import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import v7.v7.util.Log;

public final class StrBuilder
  extends SpannableStringBuilder
{
  private final List<n.a> buffer = new ArrayList();
  private final Class<?> size;
  
  StrBuilder(Class paramClass, CharSequence paramCharSequence)
  {
    super(paramCharSequence);
    Log.get(paramClass, "watcherClass cannot be null");
    size = paramClass;
  }
  
  StrBuilder(Class paramClass, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super(paramCharSequence, paramInt1, paramInt2);
    Log.get(paramClass, "watcherClass cannot be null");
    size = paramClass;
  }
  
  private SearchFragment.2 append(Object paramObject)
  {
    int i = 0;
    while (i < buffer.size())
    {
      SearchFragment.2 local2 = (SearchFragment.2)buffer.get(i);
      if (this$0 == paramObject) {
        return local2;
      }
      i += 1;
    }
    return null;
  }
  
  private void append()
  {
    int i = 0;
    while (i < buffer.size())
    {
      ((SearchFragment.2)buffer.get(i)).onTextChanged(this, 0, length(), length());
      i += 1;
    }
  }
  
  private void clear()
  {
    int i = 0;
    while (i < buffer.size())
    {
      ((SearchFragment.2)buffer.get(i)).set();
      i += 1;
    }
  }
  
  private void contains()
  {
    int i = 0;
    while (i < buffer.size())
    {
      ((SearchFragment.2)buffer.get(i)).next();
      i += 1;
    }
  }
  
  private boolean contains(Class paramClass)
  {
    return size == paramClass;
  }
  
  private boolean delete(Object paramObject)
  {
    return (paramObject != null) && (contains(paramObject.getClass()));
  }
  
  public static StrBuilder replace(Class paramClass, CharSequence paramCharSequence)
  {
    return new StrBuilder(paramClass, paramCharSequence);
  }
  
  public SpannableStringBuilder append(char paramChar)
  {
    super.append(paramChar);
    return this;
  }
  
  public SpannableStringBuilder append(CharSequence paramCharSequence)
  {
    super.append(paramCharSequence);
    return this;
  }
  
  public SpannableStringBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    super.append(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
  
  public SpannableStringBuilder append(CharSequence paramCharSequence, Object paramObject, int paramInt)
  {
    super.append(paramCharSequence, paramObject, paramInt);
    return this;
  }
  
  public SpannableStringBuilder delete(int paramInt1, int paramInt2)
  {
    super.delete(paramInt1, paramInt2);
    return this;
  }
  
  public void delete()
  {
    clear();
  }
  
  public int getSpanEnd(Object paramObject)
  {
    Object localObject = paramObject;
    if (delete(paramObject))
    {
      SearchFragment.2 local2 = append(paramObject);
      localObject = paramObject;
      if (local2 != null) {
        localObject = local2;
      }
    }
    return super.getSpanEnd(localObject);
  }
  
  public int getSpanFlags(Object paramObject)
  {
    Object localObject = paramObject;
    if (delete(paramObject))
    {
      SearchFragment.2 local2 = append(paramObject);
      localObject = paramObject;
      if (local2 != null) {
        localObject = local2;
      }
    }
    return super.getSpanFlags(localObject);
  }
  
  public int getSpanStart(Object paramObject)
  {
    Object localObject = paramObject;
    if (delete(paramObject))
    {
      SearchFragment.2 local2 = append(paramObject);
      localObject = paramObject;
      if (local2 != null) {
        localObject = local2;
      }
    }
    return super.getSpanStart(localObject);
  }
  
  public Object[] getSpans(int paramInt1, int paramInt2, Class paramClass)
  {
    if (contains(paramClass))
    {
      SearchFragment.2[] arrayOf2 = (SearchFragment.2[])super.getSpans(paramInt1, paramInt2, n.a.class);
      paramClass = (Object[])Array.newInstance(paramClass, arrayOf2.length);
      paramInt1 = 0;
      while (paramInt1 < arrayOf2.length)
      {
        paramClass[paramInt1] = this$0;
        paramInt1 += 1;
      }
      return paramClass;
    }
    return super.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public SpannableStringBuilder insert(int paramInt, CharSequence paramCharSequence)
  {
    super.insert(paramInt, paramCharSequence);
    return this;
  }
  
  public SpannableStringBuilder insert(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    super.insert(paramInt1, paramCharSequence, paramInt2, paramInt3);
    return this;
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    Object localObject;
    if (paramClass != null)
    {
      localObject = paramClass;
      if (!contains(paramClass)) {}
    }
    else
    {
      localObject = n.a.class;
    }
    return super.nextSpanTransition(paramInt1, paramInt2, (Class)localObject);
  }
  
  public void removeSpan(Object paramObject)
  {
    SearchFragment.2 local22;
    if (delete(paramObject))
    {
      SearchFragment.2 local23 = append(paramObject);
      SearchFragment.2 local21 = local23;
      local22 = local21;
      if (local23 != null)
      {
        paramObject = local23;
        local22 = local21;
      }
    }
    else
    {
      local22 = null;
    }
    super.removeSpan(paramObject);
    if (local22 != null) {
      buffer.remove(local22);
    }
  }
  
  public SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    clear();
    super.replace(paramInt1, paramInt2, paramCharSequence);
    contains();
    return this;
  }
  
  public SpannableStringBuilder replace(int paramInt1, int paramInt2, CharSequence paramCharSequence, int paramInt3, int paramInt4)
  {
    clear();
    super.replace(paramInt1, paramInt2, paramCharSequence, paramInt3, paramInt4);
    contains();
    return this;
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = paramObject;
    if (delete(paramObject))
    {
      localObject = new SearchFragment.2(paramObject);
      buffer.add(localObject);
    }
    super.setSpan(localObject, paramInt1, paramInt2, paramInt3);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return new StrBuilder(size, this, paramInt1, paramInt2);
  }
  
  public void trim()
  {
    contains();
    append();
  }
}
