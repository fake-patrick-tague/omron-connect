package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class Element
{
  private final boolean list;
  private final Buffer parent;
  private final Splitter.2 this$0;
  
  private Element(Splitter.2 param2, boolean paramBoolean, Buffer paramBuffer, int paramInt, byte[] paramArrayOfByte)
  {
    this$0 = param2;
    list = paramBoolean;
    parent = paramBuffer;
  }
  
  private final Iterator iterator(CharSequence paramCharSequence)
  {
    return new Splitter.1.1(this$0, this, paramCharSequence);
  }
  
  public static Element process(Buffer paramBuffer)
  {
    return new Element(new Splitter.2(paramBuffer), false, Token.next, java.lang.Integer.MAX_VALUE, null);
  }
  
  public final Element createElement()
  {
    return new Element(this$0, true, parent, java.lang.Integer.MAX_VALUE, null);
  }
  
  public final List get(CharSequence paramCharSequence)
  {
    Objects.requireNonNull(paramCharSequence);
    paramCharSequence = iterator(paramCharSequence);
    ArrayList localArrayList = new ArrayList();
    while (paramCharSequence.hasNext()) {
      localArrayList.add((String)paramCharSequence.next());
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public final Iterable parse(CharSequence paramCharSequence)
  {
    return new PhoneNumberUtil.1(this, paramCharSequence);
  }
}
