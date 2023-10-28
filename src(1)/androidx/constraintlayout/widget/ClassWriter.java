package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import java.util.Arrays;

public class ClassWriter
{
  private static SparseIntArray a;
  public int K;
  public boolean M = false;
  public boolean N = false;
  public int active = 0;
  public String b;
  public String c;
  public int color = -1;
  public int count = -1;
  public int d = -1;
  public int data = -1;
  public int dir = -1;
  public int e = -1;
  public int entries;
  public boolean f = false;
  public boolean g = true;
  public int h = -1;
  public int i = -1;
  public int id = 0;
  public int image = -1;
  public int index = 0;
  public float iv = 0.5F;
  public int j = -1;
  public boolean k = false;
  public float key = -1.0F;
  public int label = -1;
  public int left = -1;
  public float length = -1.0F;
  public int level = -1;
  public int listener = -1;
  public int m = -1;
  public int m_count = -1;
  public float m_radius = 0.0F;
  public int min = -1;
  public int mode = -1;
  public int n = -1;
  public int name = -1;
  public int next = 0;
  public float normalImpulse = 1.0F;
  public int[] o;
  public float out = -1.0F;
  public int p = -1;
  public String params = null;
  public int points = -1;
  public int pos = -1;
  public int q = -1;
  public int r = -1;
  public int s = -1;
  public int size = -1;
  public int state = -1;
  public int t = -1;
  public float tangentImpulse = 1.0F;
  public int text = -1;
  public int type = -1;
  public int u = 0;
  public int v = -1;
  public int value = -1;
  public int version = -1;
  public float w = 0.5F;
  public int width = -1;
  public int x = -1;
  public int y = 0;
  public int z = -1;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    a = localSparseIntArray;
    localSparseIntArray.append(R.styleable.NAME, 24);
    a.append(R.styleable.NEW, 25);
    a.append(R.styleable.type, 28);
    a.append(R.styleable.O, 29);
    a.append(R.styleable.ZERO, 35);
    a.append(R.styleable.KEY, 34);
    a.append(R.styleable.SSH_MSG_NEWKEYS, 4);
    a.append(R.styleable.header, 3);
    a.append(R.styleable.shift, 1);
    a.append(R.styleable.locale, 6);
    a.append(R.styleable.ABSOLUTE, 7);
    a.append(R.styleable.ID, 17);
    a.append(R.styleable.space, 18);
    a.append(R.styleable.SSH_MSG_KEXDH_INIT, 19);
    a.append(R.styleable.L, 26);
    a.append(R.styleable.P, 31);
    a.append(R.styleable.Q, 32);
    a.append(R.styleable.TODAY, 10);
    a.append(R.styleable.FALSE, 9);
    a.append(R.styleable.step, 13);
    a.append(R.styleable.radius, 16);
    a.append(R.styleable.table, 14);
    a.append(R.styleable.points, 11);
    a.append(R.styleable.bottom, 15);
    a.append(R.styleable.SEPARATOR, 12);
    a.append(R.styleable.y, 38);
    a.append(R.styleable.PERCENT, 37);
    a.append(R.styleable.TABLE, 39);
    a.append(R.styleable.SSH_MSG_USERAUTH_REQUEST, 40);
    a.append(R.styleable.DESCRIPTION, 20);
    a.append(R.styleable.NEGATIVE, 36);
    a.append(R.styleable.MAX, 5);
    a.append(R.styleable.MULTIPLY, 76);
    a.append(R.styleable.R, 76);
    a.append(R.styleable.AnySoftKeyboardTheme_hintOverflowLabel, 76);
    a.append(R.styleable.DPAD_UP, 76);
    a.append(R.styleable.CENTER, 76);
    a.append(R.styleable.SeekBarPreference_valueFormat, 23);
    a.append(R.styleable.ORIGIN, 27);
    a.append(R.styleable.ProgressBar_android_minHeight, 30);
    a.append(R.styleable.EDGE, 8);
    a.append(R.styleable.l, 33);
    a.append(R.styleable.i, 2);
    a.append(R.styleable.numberpicker_endRange, 22);
    a.append(R.styleable.RippleView_rv_rippleDuration, 21);
    a.append(R.styleable.BACKSLASH, 61);
    a.append(R.styleable.TextView_height, 62);
    a.append(R.styleable.MONTHS, 63);
    a.append(R.styleable.TRUE, 69);
    a.append(R.styleable.AnyKeyboardBaseView_suggestionStripHeight, 70);
    a.append(R.styleable.CalendarView_weekSeparatorLineColor, 71);
    a.append(R.styleable.COVER, 72);
    a.append(R.styleable.CalendarView_weekNumberColor, 73);
    a.append(R.styleable.DonutProgress_donut_inner_bottom_text_color, 74);
    a.append(R.styleable.BottomSheet_bs_moreText, 75);
  }
  
  public ClassWriter() {}
  
  void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SVGImageView);
    k = true;
    int i2 = paramContext.getIndexCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramContext.getIndex(i1);
      int i4 = a.get(i3);
      if (i4 != 80)
      {
        if (i4 != 81) {
          switch (i4)
          {
          default: 
            switch (i4)
            {
            default: 
              switch (i4)
              {
              default: 
                switch (i4)
                {
                default: 
                  paramAttributeSet = new StringBuilder();
                  paramAttributeSet.append("Unknown attribute 0x");
                  paramAttributeSet.append(Integer.toHexString(i3));
                  paramAttributeSet.append("   ");
                  paramAttributeSet.append(a.get(i3));
                  Log.w("ConstraintSet", paramAttributeSet.toString());
                  break;
                case 77: 
                  c = paramContext.getString(i3);
                  break;
                case 76: 
                  paramAttributeSet = new StringBuilder();
                  paramAttributeSet.append("unused attribute 0x");
                  paramAttributeSet.append(Integer.toHexString(i3));
                  paramAttributeSet.append("   ");
                  paramAttributeSet.append(a.get(i3));
                  Log.w("ConstraintSet", paramAttributeSet.toString());
                  break;
                case 75: 
                  g = paramContext.getBoolean(i3, g);
                  break;
                case 74: 
                  b = paramContext.getString(i3);
                  break;
                case 73: 
                  u = paramContext.getDimensionPixelSize(i3, u);
                  break;
                case 72: 
                  q = paramContext.getInt(i3, q);
                  break;
                case 71: 
                  Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                  break;
                case 70: 
                  tangentImpulse = paramContext.getFloat(i3, 1.0F);
                  break;
                case 69: 
                  normalImpulse = paramContext.getFloat(i3, 1.0F);
                }
                break;
              case 63: 
                m_radius = paramContext.getFloat(i3, m_radius);
                break;
              case 62: 
                y = paramContext.getDimensionPixelSize(i3, y);
                break;
              case 61: 
                d = f.min(paramContext, i3, d);
              }
              break;
            case 59: 
              points = paramContext.getDimensionPixelSize(i3, points);
              break;
            case 58: 
              data = paramContext.getDimensionPixelSize(i3, data);
              break;
            case 57: 
              mode = paramContext.getDimensionPixelSize(i3, mode);
              break;
            case 56: 
              listener = paramContext.getDimensionPixelSize(i3, listener);
              break;
            case 55: 
              active = paramContext.getInt(i3, active);
              break;
            case 54: 
              id = paramContext.getInt(i3, id);
            }
            break;
          case 40: 
            index = paramContext.getInt(i3, index);
            break;
          case 39: 
            next = paramContext.getInt(i3, next);
            break;
          case 38: 
            out = paramContext.getFloat(i3, out);
            break;
          case 37: 
            length = paramContext.getFloat(i3, length);
            break;
          case 36: 
            w = paramContext.getFloat(i3, w);
            break;
          case 35: 
            h = f.min(paramContext, i3, h);
            break;
          case 34: 
            i = f.min(paramContext, i3, i);
            break;
          case 33: 
            dir = paramContext.getDimensionPixelSize(i3, dir);
            break;
          case 32: 
            width = f.min(paramContext, i3, width);
            break;
          case 31: 
            name = f.min(paramContext, i3, name);
            break;
          case 30: 
            if (Build.VERSION.SDK_INT < 17) {
              break;
            }
            label = paramContext.getDimensionPixelSize(i3, label);
            break;
          case 29: 
            e = f.min(paramContext, i3, e);
            break;
          case 28: 
            j = f.min(paramContext, i3, j);
            break;
          case 27: 
            pos = paramContext.getDimensionPixelSize(i3, pos);
            break;
          case 26: 
            value = paramContext.getInt(i3, value);
            break;
          case 25: 
            n = f.min(paramContext, i3, n);
            break;
          case 24: 
            m = f.min(paramContext, i3, m);
            break;
          case 23: 
            size = paramContext.getDimensionPixelSize(i3, size);
            break;
          case 22: 
            K = paramContext.getLayoutDimension(i3, K);
            break;
          case 21: 
            entries = paramContext.getLayoutDimension(i3, entries);
            break;
          case 20: 
            iv = paramContext.getFloat(i3, iv);
            break;
          case 19: 
            key = paramContext.getFloat(i3, key);
            break;
          case 18: 
            t = paramContext.getDimensionPixelOffset(i3, t);
            break;
          case 17: 
            s = paramContext.getDimensionPixelOffset(i3, s);
            break;
          case 16: 
            z = paramContext.getDimensionPixelSize(i3, z);
            break;
          case 15: 
            text = paramContext.getDimensionPixelSize(i3, text);
            break;
          case 14: 
            color = paramContext.getDimensionPixelSize(i3, color);
            break;
          case 13: 
            x = paramContext.getDimensionPixelSize(i3, x);
            break;
          case 12: 
            p = paramContext.getDimensionPixelSize(i3, p);
            break;
          case 11: 
            r = paramContext.getDimensionPixelSize(i3, r);
            break;
          case 10: 
            left = f.min(paramContext, i3, left);
            break;
          case 9: 
            version = f.min(paramContext, i3, version);
            break;
          case 8: 
            if (Build.VERSION.SDK_INT < 17) {
              break;
            }
            type = paramContext.getDimensionPixelSize(i3, type);
            break;
          case 7: 
            image = paramContext.getDimensionPixelOffset(i3, image);
            break;
          case 6: 
            m_count = paramContext.getDimensionPixelOffset(i3, m_count);
            break;
          case 5: 
            params = paramContext.getString(i3);
            break;
          case 4: 
            state = f.min(paramContext, i3, state);
            break;
          case 3: 
            min = f.min(paramContext, i3, min);
            break;
          case 2: 
            count = paramContext.getDimensionPixelSize(i3, count);
            break;
          case 1: 
            level = f.min(paramContext, i3, level);
            break;
          }
        } else {
          M = paramContext.getBoolean(i3, M);
        }
      }
      else {
        N = paramContext.getBoolean(i3, N);
      }
      i1 += 1;
    }
    paramContext.recycle();
  }
  
  public void init(ClassWriter paramClassWriter)
  {
    f = f;
    K = K;
    k = k;
    entries = entries;
    s = s;
    t = t;
    key = key;
    m = m;
    n = n;
    j = j;
    e = e;
    h = h;
    i = i;
    state = state;
    min = min;
    level = level;
    name = name;
    width = width;
    left = left;
    version = version;
    iv = iv;
    w = w;
    params = params;
    d = d;
    y = y;
    m_radius = m_radius;
    m_count = m_count;
    image = image;
    value = value;
    size = size;
    pos = pos;
    dir = dir;
    count = count;
    type = type;
    label = label;
    x = x;
    z = z;
    color = color;
    r = r;
    p = p;
    text = text;
    out = out;
    length = length;
    next = next;
    index = index;
    id = id;
    active = active;
    listener = listener;
    mode = mode;
    data = data;
    points = points;
    normalImpulse = normalImpulse;
    tangentImpulse = tangentImpulse;
    q = q;
    u = u;
    v = v;
    c = c;
    int[] arrayOfInt = o;
    if (arrayOfInt != null) {
      o = Arrays.copyOf(arrayOfInt, arrayOfInt.length);
    } else {
      o = null;
    }
    b = b;
    N = N;
    M = M;
    g = g;
  }
}
