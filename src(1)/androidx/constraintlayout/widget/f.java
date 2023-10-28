package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.motion.widget.LayoutManager;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class f
{
  private static SparseIntArray b;
  private static final int[] h = { 0, 4, 8 };
  private HashMap<Integer, b.a> c = new HashMap();
  private HashMap<String, ConstraintAttribute> m = new HashMap();
  private boolean s = true;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    b = localSparseIntArray;
    localSparseIntArray.append(R.styleable.in, 25);
    b.append(R.styleable.W, 26);
    b.append(R.styleable.PORT, 29);
    b.append(R.styleable.op, 30);
    b.append(R.styleable.Theme_colorControlHighlight, 36);
    b.append(R.styleable.X, 35);
    b.append(R.styleable.bufferSize, 4);
    b.append(R.styleable.s, 3);
    b.append(R.styleable.q, 1);
    b.append(R.styleable.c, 6);
    b.append(R.styleable.ADD, 7);
    b.append(R.styleable.t2, 17);
    b.append(R.styleable.right, 18);
    b.append(R.styleable.D, 19);
    b.append(R.styleable.V, 27);
    b.append(R.styleable.mExtras, 32);
    b.append(R.styleable.off, 33);
    b.append(R.styleable.NumberPicker, 10);
    b.append(R.styleable.beta, 9);
    b.append(R.styleable.OTHER, 13);
    b.append(R.styleable.DELETE, 16);
    b.append(R.styleable.I, 14);
    b.append(R.styleable.FROM_CENTER, 11);
    b.append(R.styleable.timeout, 15);
    b.append(R.styleable.H, 12);
    b.append(R.styleable.Theme_alertDialogStyle, 40);
    b.append(R.styleable.J, 39);
    b.append(R.styleable.FROM_BEGINING, 41);
    b.append(R.styleable.Theme_colorSwitchThumbNormal, 42);
    b.append(R.styleable.Theme_panelMenuListTheme, 20);
    b.append(R.styleable.Theme_colorButtonNormal, 37);
    b.append(R.styleable.Theme_listPreferredItemHeight, 5);
    b.append(R.styleable.p, 82);
    b.append(R.styleable.Theme_colorControlNormal, 82);
    b.append(R.styleable.Theme_panelMenuListWidth, 82);
    b.append(R.styleable.ZIP, 82);
    b.append(R.styleable.Theme_dividerHorizontal, 82);
    b.append(R.styleable.G, 24);
    b.append(R.styleable.U, 28);
    b.append(R.styleable.r, 31);
    b.append(R.styleable.M, 8);
    b.append(R.styleable.BottomSheet_bs_listItemTitleTextAppearance, 34);
    b.append(R.styleable.END, 2);
    b.append(R.styleable.numberpicker_maxValue, 23);
    b.append(R.styleable.GROW, 21);
    b.append(R.styleable.K, 22);
    b.append(R.styleable.A, 43);
    b.append(R.styleable.TextView_maxEms, 44);
    b.append(R.styleable.TextView_cursorVisible, 45);
    b.append(R.styleable.FRIDAY, 46);
    b.append(R.styleable.ANY, 60);
    b.append(R.styleable.left, 47);
    b.append(R.styleable.top, 48);
    b.append(R.styleable.FILL, 49);
    b.append(R.styleable.POSTERIZE, 50);
    b.append(R.styleable.S, 51);
    b.append(R.styleable.history, 52);
    b.append(R.styleable.N, 53);
    b.append(R.styleable.OPEN, 54);
    b.append(R.styleable.Theme_listPreferredItemHeightSmall, 55);
    b.append(R.styleable.STROKE, 56);
    b.append(R.styleable.Theme_listPreferredItemHeightLarge, 57);
    b.append(R.styleable.CLOSE, 58);
    b.append(R.styleable.a, 59);
    b.append(R.styleable.MIN, 61);
    b.append(R.styleable.SherlockTheme_windowActionModeOverlay, 62);
    b.append(R.styleable.pad, 63);
    b.append(R.styleable.VERSION, 64);
    b.append(R.styleable.update, 65);
    b.append(R.styleable.F, 66);
    b.append(R.styleable.Theme_spinnerStyle, 67);
    b.append(R.styleable.AppCompatTheme_editTextStyle, 79);
    b.append(R.styleable.ONE, 38);
    b.append(R.styleable.Theme_checkedTextViewStyle, 68);
    b.append(R.styleable.Theme_buttonBarNegativeButtonStyle, 69);
    b.append(R.styleable.tail, 70);
    b.append(R.styleable.C, 71);
    b.append(R.styleable.INCREMENT_BY_PIXELS, 72);
    b.append(R.styleable.View_clickable, 73);
    b.append(R.styleable.Y, 74);
    b.append(R.styleable.SherlockTheme_abSubtitleTextStyle, 75);
    b.append(R.styleable.Theme_radioButtonStyle, 76);
    b.append(R.styleable.second, 77);
    b.append(R.styleable.Theme_switchStyle, 78);
    b.append(R.styleable.Z, 80);
    b.append(R.styleable.Theme_popupMenuStyle, 81);
  }
  
  public f() {}
  
  private h a(int paramInt)
  {
    if (!c.containsKey(Integer.valueOf(paramInt))) {
      c.put(Integer.valueOf(paramInt), new h());
    }
    return (h)c.get(Integer.valueOf(paramInt));
  }
  
  private h a(Context paramContext, AttributeSet paramAttributeSet)
  {
    h localH = new h();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CirclePageIndicator);
    init(paramContext, localH, paramAttributeSet);
    paramAttributeSet.recycle();
    return localH;
  }
  
  private void init(Context paramContext, h paramH, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      if ((k != R.styleable.ONE) && (R.styleable.r != k) && (R.styleable.M != k))
      {
        h.i = true;
        y.k = true;
        c.i = true;
        a.d = true;
      }
      switch (b.get(k))
      {
      default: 
        paramContext = new StringBuilder();
        paramContext.append("Unknown attribute 0x");
        paramContext.append(Integer.toHexString(k));
        paramContext.append("   ");
        paramContext.append(b.get(k));
        Log.w("ConstraintSet", paramContext.toString());
        break;
      case 82: 
        paramContext = new StringBuilder();
        paramContext.append("unused attribute 0x");
        paramContext.append(Integer.toHexString(k));
        paramContext.append("   ");
        paramContext.append(b.get(k));
        Log.w("ConstraintSet", paramContext.toString());
        break;
      case 81: 
        paramContext = y;
        M = paramTypedArray.getBoolean(k, M);
        break;
      case 80: 
        paramContext = y;
        N = paramTypedArray.getBoolean(k, N);
        break;
      case 79: 
        paramContext = h;
        w = paramTypedArray.getFloat(k, w);
        break;
      case 78: 
        paramContext = c;
        e = paramTypedArray.getInt(k, e);
        break;
      case 77: 
        y.c = paramTypedArray.getString(k);
        break;
      case 76: 
        paramContext = h;
        e = paramTypedArray.getInt(k, e);
        break;
      case 75: 
        paramContext = y;
        g = paramTypedArray.getBoolean(k, g);
        break;
      case 74: 
        y.b = paramTypedArray.getString(k);
        break;
      case 73: 
        paramContext = y;
        u = paramTypedArray.getDimensionPixelSize(k, u);
        break;
      case 72: 
        paramContext = y;
        q = paramTypedArray.getInt(k, q);
        break;
      case 71: 
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        break;
      case 70: 
        y.tangentImpulse = paramTypedArray.getFloat(k, 1.0F);
        break;
      case 69: 
        y.normalImpulse = paramTypedArray.getFloat(k, 1.0F);
        break;
      case 68: 
        paramContext = c;
        h = paramTypedArray.getFloat(k, h);
        break;
      case 67: 
        paramContext = h;
        y = paramTypedArray.getFloat(k, y);
        break;
      case 66: 
        h.x = paramTypedArray.getInt(k, 0);
        break;
      case 65: 
        if (peekValuetype == 3) {
          h.d = paramTypedArray.getString(k);
        } else {
          h.d = v7.sufficientlysecure.transition.util.Configuration.w[paramTypedArray.getInteger(k, 0)];
        }
        break;
      case 64: 
        paramContext = h;
        h = valueOf(paramTypedArray, k, h);
        break;
      case 63: 
        paramContext = y;
        m_radius = paramTypedArray.getFloat(k, m_radius);
        break;
      case 62: 
        paramContext = y;
        y = paramTypedArray.getDimensionPixelSize(k, y);
        break;
      case 61: 
        paramContext = y;
        d = valueOf(paramTypedArray, k, d);
        break;
      case 60: 
        paramContext = a;
        r = paramTypedArray.getFloat(k, r);
        break;
      case 59: 
        paramContext = y;
        points = paramTypedArray.getDimensionPixelSize(k, points);
        break;
      case 58: 
        paramContext = y;
        data = paramTypedArray.getDimensionPixelSize(k, data);
        break;
      case 57: 
        paramContext = y;
        mode = paramTypedArray.getDimensionPixelSize(k, mode);
        break;
      case 56: 
        paramContext = y;
        listener = paramTypedArray.getDimensionPixelSize(k, listener);
        break;
      case 55: 
        paramContext = y;
        active = paramTypedArray.getInt(k, active);
        break;
      case 54: 
        paramContext = y;
        id = paramTypedArray.getInt(k, id);
        break;
      case 53: 
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramContext = a;
          k = paramTypedArray.getDimension(k, k);
        }
        break;
      case 52: 
        paramContext = a;
        j = paramTypedArray.getDimension(k, j);
        break;
      case 51: 
        paramContext = a;
        n = paramTypedArray.getDimension(k, n);
        break;
      case 50: 
        paramContext = a;
        m = paramTypedArray.getDimension(k, m);
        break;
      case 49: 
        paramContext = a;
        h = paramTypedArray.getDimension(k, h);
        break;
      case 48: 
        paramContext = a;
        i = paramTypedArray.getFloat(k, i);
        break;
      case 47: 
        paramContext = a;
        s = paramTypedArray.getFloat(k, s);
        break;
      case 46: 
        paramContext = a;
        e = paramTypedArray.getFloat(k, e);
        break;
      case 45: 
        paramContext = a;
        g = paramTypedArray.getFloat(k, g);
        break;
      case 44: 
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramContext = a;
          p = true;
          c = paramTypedArray.getDimension(k, c);
        }
        break;
      case 43: 
        paramContext = c;
        d = paramTypedArray.getFloat(k, d);
        break;
      case 42: 
        paramContext = y;
        index = paramTypedArray.getInt(k, index);
        break;
      case 41: 
        paramContext = y;
        next = paramTypedArray.getInt(k, next);
        break;
      case 40: 
        paramContext = y;
        out = paramTypedArray.getFloat(k, out);
        break;
      case 39: 
        paramContext = y;
        length = paramTypedArray.getFloat(k, length);
        break;
      case 38: 
        i = paramTypedArray.getResourceId(k, i);
        break;
      case 37: 
        paramContext = y;
        w = paramTypedArray.getFloat(k, w);
        break;
      case 36: 
        paramContext = y;
        h = valueOf(paramTypedArray, k, h);
        break;
      case 35: 
        paramContext = y;
        i = valueOf(paramTypedArray, k, i);
        break;
      case 34: 
        paramContext = y;
        dir = paramTypedArray.getDimensionPixelSize(k, dir);
        break;
      case 33: 
        paramContext = y;
        width = valueOf(paramTypedArray, k, width);
        break;
      case 32: 
        paramContext = y;
        name = valueOf(paramTypedArray, k, name);
        break;
      case 31: 
        if (Build.VERSION.SDK_INT >= 17)
        {
          paramContext = y;
          label = paramTypedArray.getDimensionPixelSize(k, label);
        }
        break;
      case 30: 
        paramContext = y;
        e = valueOf(paramTypedArray, k, e);
        break;
      case 29: 
        paramContext = y;
        j = valueOf(paramTypedArray, k, j);
        break;
      case 28: 
        paramContext = y;
        pos = paramTypedArray.getDimensionPixelSize(k, pos);
        break;
      case 27: 
        paramContext = y;
        value = paramTypedArray.getInt(k, value);
        break;
      case 26: 
        paramContext = y;
        n = valueOf(paramTypedArray, k, n);
        break;
      case 25: 
        paramContext = y;
        m = valueOf(paramTypedArray, k, m);
        break;
      case 24: 
        paramContext = y;
        size = paramTypedArray.getDimensionPixelSize(k, size);
        break;
      case 23: 
        paramContext = y;
        K = paramTypedArray.getLayoutDimension(k, K);
        break;
      case 22: 
        paramContext = c;
        a = paramTypedArray.getInt(k, a);
        paramContext = c;
        a = h[a];
        break;
      case 21: 
        paramContext = y;
        entries = paramTypedArray.getLayoutDimension(k, entries);
        break;
      case 20: 
        paramContext = y;
        iv = paramTypedArray.getFloat(k, iv);
        break;
      case 19: 
        paramContext = y;
        key = paramTypedArray.getFloat(k, key);
        break;
      case 18: 
        paramContext = y;
        t = paramTypedArray.getDimensionPixelOffset(k, t);
        break;
      case 17: 
        paramContext = y;
        s = paramTypedArray.getDimensionPixelOffset(k, s);
        break;
      case 16: 
        paramContext = y;
        z = paramTypedArray.getDimensionPixelSize(k, z);
        break;
      case 15: 
        paramContext = y;
        text = paramTypedArray.getDimensionPixelSize(k, text);
        break;
      case 14: 
        paramContext = y;
        color = paramTypedArray.getDimensionPixelSize(k, color);
        break;
      case 13: 
        paramContext = y;
        x = paramTypedArray.getDimensionPixelSize(k, x);
        break;
      case 12: 
        paramContext = y;
        p = paramTypedArray.getDimensionPixelSize(k, p);
        break;
      case 11: 
        paramContext = y;
        r = paramTypedArray.getDimensionPixelSize(k, r);
        break;
      case 10: 
        paramContext = y;
        left = valueOf(paramTypedArray, k, left);
        break;
      case 9: 
        paramContext = y;
        version = valueOf(paramTypedArray, k, version);
        break;
      case 8: 
        if (Build.VERSION.SDK_INT >= 17)
        {
          paramContext = y;
          type = paramTypedArray.getDimensionPixelSize(k, type);
        }
        break;
      case 7: 
        paramContext = y;
        image = paramTypedArray.getDimensionPixelOffset(k, image);
        break;
      case 6: 
        paramContext = y;
        m_count = paramTypedArray.getDimensionPixelOffset(k, m_count);
        break;
      case 5: 
        y.params = paramTypedArray.getString(k);
        break;
      case 4: 
        paramContext = y;
        state = valueOf(paramTypedArray, k, state);
        break;
      case 3: 
        paramContext = y;
        min = valueOf(paramTypedArray, k, min);
        break;
      case 2: 
        paramContext = y;
        count = paramTypedArray.getDimensionPixelSize(k, count);
        break;
      case 1: 
        paramContext = y;
        level = valueOf(paramTypedArray, k, level);
      }
      i += 1;
    }
  }
  
  private int[] parse(View paramView, String paramString)
  {
    paramString = paramString.split(",");
    Context localContext = paramView.getContext();
    int[] arrayOfInt = new int[paramString.length];
    int n = 0;
    int k = 0;
    while (n < paramString.length)
    {
      Object localObject = paramString[n].trim();
      try
      {
        j = d.class.getField((String)localObject).getInt(null);
      }
      catch (Exception localException)
      {
        int j;
        int i;
        for (;;) {}
      }
      j = 0;
      i = j;
      if (j == 0) {
        i = localContext.getResources().getIdentifier((String)localObject, "id", localContext.getPackageName());
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (paramView.isInEditMode())
        {
          j = i;
          if ((paramView.getParent() instanceof ConstraintLayout))
          {
            localObject = ((ConstraintLayout)paramView.getParent()).get(0, localObject);
            j = i;
            if (localObject != null)
            {
              j = i;
              if ((localObject instanceof Integer)) {
                j = ((Integer)localObject).intValue();
              }
            }
          }
        }
      }
      arrayOfInt[k] = j;
      n += 1;
      k += 1;
    }
    if (k != paramString.length) {
      return Arrays.copyOf(arrayOfInt, k);
    }
    return arrayOfInt;
  }
  
  private static int valueOf(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    paramInt2 = paramTypedArray.getResourceId(paramInt1, paramInt2);
    if (paramInt2 == -1) {
      return paramTypedArray.getInt(paramInt1, -1);
    }
    return paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    ClassWriter localClassWriter = ay;
    d = paramInt2;
    y = paramInt3;
    m_radius = paramFloat;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    try
    {
      for (paramInt = localXmlResourceParser.getEventType(); paramInt != 1; paramInt = localXmlResourceParser.next()) {
        if (paramInt != 0)
        {
          if (paramInt == 2)
          {
            Object localObject = localXmlResourceParser.getName();
            h localH = a(paramContext, Xml.asAttributeSet(localXmlResourceParser));
            boolean bool = ((String)localObject).equalsIgnoreCase("Guideline");
            if (bool) {
              y.f = true;
            }
            localObject = c;
            paramInt = i;
            ((HashMap)localObject).put(Integer.valueOf(paramInt), localH);
          }
        }
        else {
          localXmlResourceParser.getName();
        }
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
  
  public void a(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    try
    {
      int i = paramXmlPullParser.getEventType();
      Object localObject1;
      for (Object localObject2 = null; i != 1; localObject2 = localObject1)
      {
        if (i != 0)
        {
          int j = 3;
          boolean bool;
          if (i != 2)
          {
            if (i != 3)
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = paramXmlPullParser.getName();
              bool = "ConstraintSet".equals(localObject1);
              if (bool) {
                return;
              }
              bool = ((String)localObject1).equalsIgnoreCase("Constraint");
              localObject1 = localObject2;
              if (bool)
              {
                localObject1 = c;
                i = i;
                ((HashMap)localObject1).put(Integer.valueOf(i), localObject2);
                localObject1 = null;
              }
            }
          }
          else
          {
            localObject1 = paramXmlPullParser.getName();
            i = ((String)localObject1).hashCode();
            switch (i)
            {
            default: 
              break;
            case 1803088381: 
              bool = ((String)localObject1).equals("Constraint");
              if (bool) {
                i = 0;
              }
              break;
            case 1791837707: 
              bool = ((String)localObject1).equals("CustomAttribute");
              if (bool) {
                i = 7;
              }
              break;
            case 1331510167: 
              bool = ((String)localObject1).equals("Barrier");
              if (bool) {
                i = 2;
              }
              break;
            case -71750448: 
              bool = ((String)localObject1).equals("Guideline");
              if (bool) {
                i = 1;
              }
              break;
            case -1238332596: 
              bool = ((String)localObject1).equals("Transform");
              if (bool) {
                i = 4;
              }
              break;
            case -1269513683: 
              bool = ((String)localObject1).equals("PropertySet");
              if (bool) {
                i = j;
              }
              break;
            case -1984451626: 
              bool = ((String)localObject1).equals("Motion");
              if (bool) {
                i = 6;
              }
              break;
            case -2025855158: 
              bool = ((String)localObject1).equals("Layout");
              if (bool) {
                i = 5;
              }
              break;
            }
            i = -1;
            switch (i)
            {
            default: 
              localObject1 = localObject2;
              break;
            case 7: 
              if (localObject2 != null)
              {
                localObject1 = b;
                ConstraintAttribute.a(paramContext, paramXmlPullParser, (HashMap)localObject1);
                localObject1 = localObject2;
                break;
              }
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              paramContext = new RuntimeException(paramContext.toString());
              throw paramContext;
            case 6: 
              if (localObject2 != null)
              {
                localObject1 = h;
                ((Frame)localObject1).init(paramContext, Xml.asAttributeSet(paramXmlPullParser));
                localObject1 = localObject2;
                break;
              }
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              paramContext = new RuntimeException(paramContext.toString());
              throw paramContext;
            case 5: 
              if (localObject2 != null)
              {
                localObject1 = y;
                ((ClassWriter)localObject1).init(paramContext, Xml.asAttributeSet(paramXmlPullParser));
                localObject1 = localObject2;
                break;
              }
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              paramContext = new RuntimeException(paramContext.toString());
              throw paramContext;
            case 4: 
              if (localObject2 != null)
              {
                localObject1 = a;
                ((Plot)localObject1).a(paramContext, Xml.asAttributeSet(paramXmlPullParser));
                localObject1 = localObject2;
                break;
              }
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              paramContext = new RuntimeException(paramContext.toString());
              throw paramContext;
            case 3: 
              if (localObject2 != null)
              {
                localObject1 = c;
                ((a)localObject1).a(paramContext, Xml.asAttributeSet(paramXmlPullParser));
                localObject1 = localObject2;
                break;
              }
              paramContext = new StringBuilder();
              paramContext.append("XML parser error must be within a Constraint ");
              paramContext.append(paramXmlPullParser.getLineNumber());
              paramContext = new RuntimeException(paramContext.toString());
              throw paramContext;
            case 2: 
              localObject2 = a(paramContext, Xml.asAttributeSet(paramXmlPullParser));
              localObject1 = localObject2;
              y.v = 1;
              break;
            case 1: 
              localObject2 = a(paramContext, Xml.asAttributeSet(paramXmlPullParser));
              localObject1 = localObject2;
              localObject2 = y;
              f = true;
              k = true;
              break;
            case 0: 
              localObject1 = a(paramContext, Xml.asAttributeSet(paramXmlPullParser));
            }
          }
        }
        else
        {
          paramXmlPullParser.getName();
          localObject1 = localObject2;
        }
        i = paramXmlPullParser.next();
      }
      return;
    }
    catch (IOException paramContext)
    {
      ((IOException)paramContext).printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    c.clear();
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramConstraintLayout.getChildAt(i);
      Object localObject2 = (ConstraintLayout.LayoutParams)((View)localObject1).getLayoutParams();
      int k = ((View)localObject1).getId();
      if ((s) && (k == -1)) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (!c.containsKey(Integer.valueOf(k))) {
        c.put(Integer.valueOf(k), new h());
      }
      h localH = (h)c.get(Integer.valueOf(k));
      b = ConstraintAttribute.a(m, (View)localObject1);
      h.a(localH, k, (ConstraintLayout.LayoutParams)localObject2);
      c.a = ((View)localObject1).getVisibility();
      k = Build.VERSION.SDK_INT;
      if (k >= 17)
      {
        c.d = ((View)localObject1).getAlpha();
        a.r = ((View)localObject1).getRotation();
        a.g = ((View)localObject1).getRotationX();
        a.e = ((View)localObject1).getRotationY();
        a.s = ((View)localObject1).getScaleX();
        a.i = ((View)localObject1).getScaleY();
        float f1 = ((View)localObject1).getPivotX();
        float f2 = ((View)localObject1).getPivotY();
        if ((f1 != 0.0D) || (f2 != 0.0D))
        {
          localObject2 = a;
          h = f1;
          m = f2;
        }
        a.n = ((View)localObject1).getTranslationX();
        a.j = ((View)localObject1).getTranslationY();
        if (k >= 21)
        {
          a.k = ((View)localObject1).getTranslationZ();
          localObject2 = a;
          if (p) {
            c = ((View)localObject1).getElevation();
          }
        }
      }
      if ((localObject1 instanceof Barrier))
      {
        localObject1 = (Barrier)localObject1;
        y.g = ((Barrier)localObject1).b();
        y.o = ((ConstraintHelper)localObject1).getReferencedIds();
        y.q = ((Barrier)localObject1).getType();
        y.u = ((Barrier)localObject1).getMargin();
      }
      i += 1;
    }
  }
  
  void a(ConstraintLayout paramConstraintLayout, boolean paramBoolean)
  {
    int j = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(c.keySet());
    int i = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    while (i < j)
    {
      localObject2 = paramConstraintLayout.getChildAt(i);
      int k = ((View)localObject2).getId();
      if (!c.containsKey(Integer.valueOf(k)))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("id unknown ");
        ((StringBuilder)localObject3).append(LayoutManager.a((View)localObject2));
        Log.w("ConstraintSet", ((StringBuilder)localObject3).toString());
      }
      else
      {
        if ((s) && (k == -1)) {
          throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
        }
        if (k != -1) {
          if (c.containsKey(Integer.valueOf(k)))
          {
            ((HashSet)localObject1).remove(Integer.valueOf(k));
            localObject3 = (h)c.get(Integer.valueOf(k));
            if ((localObject2 instanceof Barrier)) {
              y.v = 1;
            }
            int n = y.v;
            if ((n != -1) && (n == 1))
            {
              localObject4 = (Barrier)localObject2;
              ((View)localObject4).setId(k);
              ((Barrier)localObject4).setType(y.q);
              ((Barrier)localObject4).setMargin(y.u);
              ((Barrier)localObject4).setAllowsGoneWidget(y.g);
              localObject5 = y;
              localObject6 = o;
              if (localObject6 != null)
              {
                ((ConstraintHelper)localObject4).setReferencedIds((int[])localObject6);
              }
              else
              {
                localObject6 = b;
                if (localObject6 != null)
                {
                  o = parse((View)localObject4, (String)localObject6);
                  ((ConstraintHelper)localObject4).setReferencedIds(y.o);
                }
              }
            }
            localObject4 = (ConstraintLayout.LayoutParams)((View)localObject2).getLayoutParams();
            ((ConstraintLayout.LayoutParams)localObject4).add();
            ((h)localObject3).init((ConstraintLayout.LayoutParams)localObject4);
            if (paramBoolean) {
              ConstraintAttribute.a((View)localObject2, b);
            }
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            localObject4 = c;
            if (e == 0) {
              ((View)localObject2).setVisibility(a);
            }
            k = Build.VERSION.SDK_INT;
            if (k >= 17)
            {
              ((View)localObject2).setAlpha(c.d);
              ((View)localObject2).setRotation(a.r);
              ((View)localObject2).setRotationX(a.g);
              ((View)localObject2).setRotationY(a.e);
              ((View)localObject2).setScaleX(a.s);
              ((View)localObject2).setScaleY(a.i);
              if (!Float.isNaN(a.h)) {
                ((View)localObject2).setPivotX(a.h);
              }
              if (!Float.isNaN(a.m)) {
                ((View)localObject2).setPivotY(a.m);
              }
              ((View)localObject2).setTranslationX(a.n);
              ((View)localObject2).setTranslationY(a.j);
              if (k >= 21)
              {
                ((View)localObject2).setTranslationZ(a.k);
                localObject3 = a;
                if (p) {
                  ((View)localObject2).setElevation(c);
                }
              }
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("WARNING NO CONSTRAINTS for view ");
            ((StringBuilder)localObject2).append(k);
            Log.v("ConstraintSet", ((StringBuilder)localObject2).toString());
          }
        }
      }
      i += 1;
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject1).next();
      localObject2 = (h)c.get(localObject3);
      i = y.v;
      if ((i != -1) && (i == 1))
      {
        localObject4 = new Barrier(paramConstraintLayout.getContext());
        ((View)localObject4).setId(((Integer)localObject3).intValue());
        localObject5 = y;
        localObject6 = o;
        if (localObject6 != null)
        {
          ((ConstraintHelper)localObject4).setReferencedIds((int[])localObject6);
        }
        else
        {
          localObject6 = b;
          if (localObject6 != null)
          {
            o = parse((View)localObject4, (String)localObject6);
            ((ConstraintHelper)localObject4).setReferencedIds(y.o);
          }
        }
        ((Barrier)localObject4).setType(y.q);
        ((Barrier)localObject4).setMargin(y.u);
        localObject5 = paramConstraintLayout.putShort();
        ((ConstraintHelper)localObject4).f();
        ((h)localObject2).init((ConstraintLayout.LayoutParams)localObject5);
        paramConstraintLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      }
      if (y.f)
      {
        localObject4 = new Guideline(paramConstraintLayout.getContext());
        ((View)localObject4).setId(((Integer)localObject3).intValue());
        localObject3 = paramConstraintLayout.putShort();
        ((h)localObject2).init((ConstraintLayout.LayoutParams)localObject3);
        paramConstraintLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject3);
      }
    }
  }
  
  public void a(Constraints paramConstraints)
  {
    int j = paramConstraints.getChildCount();
    c.clear();
    int i = 0;
    while (i < j)
    {
      View localView = paramConstraints.getChildAt(i);
      Constraints.LayoutParams localLayoutParams = (Constraints.LayoutParams)localView.getLayoutParams();
      int k = localView.getId();
      if ((s) && (k == -1)) {
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
      }
      if (!c.containsKey(Integer.valueOf(k))) {
        c.put(Integer.valueOf(k), new h());
      }
      h localH = (h)c.get(Integer.valueOf(k));
      if ((localView instanceof ConstraintHelper)) {
        h.c(localH, (ConstraintHelper)localView, k, localLayoutParams);
      }
      h.c(localH, k, localLayoutParams);
      i += 1;
    }
  }
  
  public void b(Context paramContext, int paramInt)
  {
    a((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void c(ConstraintLayout paramConstraintLayout)
  {
    a(paramConstraintLayout, true);
    paramConstraintLayout.setConstraintSet(null);
    paramConstraintLayout.requestLayout();
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    if (c.containsKey(Integer.valueOf(paramInt1)))
    {
      Object localObject = (h)c.get(Integer.valueOf(paramInt1));
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("unknown constraint");
      case 7: 
        localObject = y;
        left = -1;
        version = -1;
        type = -1;
        p = -1;
        return;
      case 6: 
        localObject = y;
        name = -1;
        width = -1;
        label = -1;
        text = -1;
        return;
      case 5: 
        y.level = -1;
        return;
      case 4: 
        localObject = y;
        state = -1;
        min = -1;
        count = -1;
        r = -1;
        return;
      case 3: 
        localObject = y;
        i = -1;
        h = -1;
        dir = -1;
        z = -1;
        return;
      case 2: 
        localObject = y;
        e = -1;
        j = -1;
        pos = -1;
        color = -1;
        return;
      }
      localObject = y;
      n = -1;
      m = -1;
      size = -1;
      x = -1;
    }
  }
}
