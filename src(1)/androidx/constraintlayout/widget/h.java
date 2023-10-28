package androidx.constraintlayout.widget;

import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.HashMap;

public class h
{
  public final Plot a = new Plot();
  public HashMap<String, ConstraintAttribute> b = new HashMap();
  public final a c = new a();
  public final Frame h = new Frame();
  int i;
  public final ClassWriter y = new ClassWriter();
  
  public h() {}
  
  private void a(int paramInt, Constraints.LayoutParams paramLayoutParams)
  {
    init(paramInt, paramLayoutParams);
    c.d = d;
    Plot localPlot = a;
    r = r;
    g = n;
    e = x;
    s = w;
    i = l;
    h = s;
    m = i;
    n = h;
    j = j;
    k = k;
    c = a;
    p = c;
  }
  
  private void a(ConstraintHelper paramConstraintHelper, int paramInt, Constraints.LayoutParams paramLayoutParams)
  {
    a(paramInt, paramLayoutParams);
    if ((paramConstraintHelper instanceof Barrier))
    {
      paramLayoutParams = y;
      v = 1;
      paramConstraintHelper = (Barrier)paramConstraintHelper;
      q = paramConstraintHelper.getType();
      y.o = paramConstraintHelper.getReferencedIds();
      y.u = paramConstraintHelper.getMargin();
    }
  }
  
  private void init(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
  {
    i = paramInt;
    ClassWriter localClassWriter = y;
    m = width;
    n = y;
    j = l;
    e = c;
    h = h;
    i = i;
    state = k;
    min = j;
    level = o;
    name = p;
    width = s;
    left = x;
    version = height;
    iv = z;
    w = w;
    params = buf;
    d = A;
    y = B;
    m_radius = d;
    m_count = count;
    image = text;
    value = name;
    key = color;
    s = a;
    t = b;
    localClassWriter = y;
    K = width;
    entries = height;
    size = leftMargin;
    pos = rightMargin;
    dir = topMargin;
    count = bottomMargin;
    out = position;
    length = buffer;
    index = index;
    next = next;
    N = min;
    M = flags;
    id = id;
    active = status;
    listener = type;
    mode = mode;
    data = data;
    points = header;
    normalImpulse = length;
    tangentImpulse = file;
    c = title;
    z = v;
    r = r;
    x = t;
    color = u;
    localClassWriter = y;
    text = m;
    p = n;
    if (Build.VERSION.SDK_INT >= 17)
    {
      type = paramLayoutParams.getMarginEnd();
      y.label = paramLayoutParams.getMarginStart();
    }
  }
  
  public h a()
  {
    h localH = new h();
    y.init(y);
    h.a(h);
    c.a(c);
    a.a(a);
    i = i;
    return localH;
  }
  
  public void init(ConstraintLayout.LayoutParams paramLayoutParams)
  {
    Object localObject = y;
    width = m;
    y = n;
    l = j;
    c = e;
    h = h;
    i = i;
    k = state;
    j = min;
    o = level;
    p = name;
    s = width;
    x = left;
    height = version;
    leftMargin = size;
    rightMargin = pos;
    topMargin = dir;
    bottomMargin = count;
    m = text;
    n = p;
    v = z;
    r = r;
    z = iv;
    w = w;
    A = d;
    B = y;
    localObject = y;
    d = m_radius;
    buf = params;
    count = m_count;
    text = image;
    position = out;
    buffer = length;
    index = index;
    next = next;
    min = N;
    flags = M;
    id = id;
    status = active;
    type = listener;
    mode = mode;
    data = data;
    header = points;
    length = normalImpulse;
    file = tangentImpulse;
    name = value;
    color = key;
    a = s;
    b = t;
    width = K;
    height = entries;
    localObject = c;
    if (localObject != null) {
      title = ((String)localObject);
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutParams.setMarginStart(y.label);
      paramLayoutParams.setMarginEnd(y.type);
    }
    paramLayoutParams.add();
  }
}
