package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i
{
  private SparseArray<a.a> a = new SparseArray();
  private SparseArray<b> b = new SparseArray();
  private final ConstraintLayout i;
  int k = -1;
  int l = -1;
  
  i(Context paramContext, ConstraintLayout paramConstraintLayout, int paramInt)
  {
    i = paramConstraintLayout;
    a(paramContext, paramInt);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    Object localObject1 = null;
    try
    {
      paramInt = localXmlResourceParser.getEventType();
      while (paramInt != 1)
      {
        Object localObject2;
        if (paramInt != 0)
        {
          if (paramInt != 2)
          {
            localObject2 = localObject1;
          }
          else
          {
            Object localObject3 = localXmlResourceParser.getName();
            paramInt = -1;
            int j = ((String)localObject3).hashCode();
            boolean bool;
            switch (j)
            {
            default: 
              break;
            case 1901439077: 
              bool = ((String)localObject3).equals("Variant");
              if (bool) {
                paramInt = 3;
              }
              break;
            case 1657696882: 
              bool = ((String)localObject3).equals("layoutDescription");
              if (bool) {
                paramInt = 0;
              }
              break;
            case 1382829617: 
              bool = ((String)localObject3).equals("StateSet");
              if (bool) {
                paramInt = 1;
              }
              break;
            case 80204913: 
              bool = ((String)localObject3).equals("State");
              if (bool) {
                paramInt = 2;
              }
              break;
            case -1349929691: 
              bool = ((String)localObject3).equals("ConstraintSet");
              if (bool) {
                paramInt = 4;
              }
              break;
            }
            localObject2 = localObject1;
            if (paramInt != 0)
            {
              localObject2 = localObject1;
              if (paramInt != 1) {
                if (paramInt != 2)
                {
                  if (paramInt != 3)
                  {
                    if (paramInt != 4)
                    {
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append("unknown tag ");
                      ((StringBuilder)localObject2).append((String)localObject3);
                      Log.v("ConstraintLayoutStates", ((StringBuilder)localObject2).toString());
                      localObject2 = localObject1;
                    }
                    else
                    {
                      a(paramContext, localXmlResourceParser);
                      localObject2 = localObject1;
                    }
                  }
                  else
                  {
                    localObject3 = new l(paramContext, localXmlResourceParser);
                    localObject2 = localObject1;
                    if (localObject1 != null)
                    {
                      ((e)localObject1).a((l)localObject3);
                      localObject2 = localObject1;
                    }
                  }
                }
                else
                {
                  localObject2 = new e(paramContext, localXmlResourceParser);
                  localObject1 = a;
                  paramInt = i;
                  ((SparseArray)localObject1).put(paramInt, localObject2);
                }
              }
            }
          }
        }
        else
        {
          localXmlResourceParser.getName();
          localObject2 = localObject1;
        }
        paramInt = localXmlResourceParser.next();
        localObject1 = localObject2;
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    f localF = new f();
    int m = paramXmlPullParser.getAttributeCount();
    int j = 0;
    while (j < m)
    {
      if ("id".equals(paramXmlPullParser.getAttributeName(j)))
      {
        String str1 = paramXmlPullParser.getAttributeValue(j);
        if (str1.contains("/"))
        {
          String str2 = str1.substring(str1.indexOf('/') + 1);
          j = paramContext.getResources().getIdentifier(str2, "id", paramContext.getPackageName());
        }
        else
        {
          j = -1;
        }
        m = j;
        if (j == -1) {
          if (str1.length() > 1)
          {
            m = Integer.parseInt(str1.substring(1));
          }
          else
          {
            Log.e("ConstraintLayoutStates", "error in parsing id");
            m = j;
          }
        }
        localF.a(paramContext, paramXmlPullParser);
        b.put(m, localF);
        return;
      }
      j += 1;
    }
  }
  
  public void c(NavigationMenuPresenter paramNavigationMenuPresenter) {}
}
