package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class l
{
  private final Deque<WeakReference<XmlPullParser>> e = new ArrayDeque();
  
  l() {}
  
  private static XmlPullParser a(Deque paramDeque)
  {
    while (!paramDeque.isEmpty())
    {
      XmlPullParser localXmlPullParser = (XmlPullParser)((WeakReference)paramDeque.peek()).get();
      if (b(localXmlPullParser)) {
        paramDeque.pop();
      } else {
        return localXmlPullParser;
      }
    }
    return null;
  }
  
  private static boolean a(XmlPullParser paramXmlPullParser1, XmlPullParser paramXmlPullParser2)
  {
    if ((paramXmlPullParser2 != null) && (paramXmlPullParser1 != paramXmlPullParser2)) {}
    try
    {
      int i = paramXmlPullParser2.getEventType();
      if (i == 2)
      {
        boolean bool = "include".equals(paramXmlPullParser2.getName());
        return bool;
      }
    }
    catch (XmlPullParserException paramXmlPullParser1)
    {
      for (;;) {}
    }
    return false;
  }
  
  private static boolean b(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser != null) {
      try
      {
        int i = paramXmlPullParser.getEventType();
        if (i != 3)
        {
          i = paramXmlPullParser.getEventType();
          return i == 1;
        }
      }
      catch (XmlPullParserException paramXmlPullParser) {}
    }
    return true;
  }
  
  boolean a(AttributeSet paramAttributeSet)
  {
    if ((paramAttributeSet instanceof XmlPullParser))
    {
      paramAttributeSet = (XmlPullParser)paramAttributeSet;
      if (paramAttributeSet.getDepth() == 1)
      {
        XmlPullParser localXmlPullParser = a(e);
        e.push(new WeakReference(paramAttributeSet));
        if (a(paramAttributeSet, localXmlPullParser)) {
          return true;
        }
      }
    }
    return false;
  }
}
