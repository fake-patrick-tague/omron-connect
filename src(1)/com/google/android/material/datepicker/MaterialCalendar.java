package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import androidx.fragment.package_11.Fragment;
import androidx.recyclerview.widget.ClassReader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.y;
import androidx.recyclerview.widget.b;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.org.org.ui.R.id;
import org.org.org.ui.R.layout;
import org.org.org.ui.R.raw;
import org.org.org.ui.Switch;
import org.org.org.ui.h;
import v7.v7.package_13.ActionMenuItemView;
import v7.v7.package_13.ViewCompat;
import v7.v7.package_13.asm.AccessibilityNodeInfoCompat;
import v7.v7.util.Position;

public final class MaterialCalendar<S>
  extends k<S>
{
  static final Object M = "SELECTOR_TOGGLE_TAG";
  static final Object a;
  static final Object c;
  static final Object y = "MONTHS_VIEW_GROUP_TAG";
  private CalendarConstraints b;
  private Month d;
  private View g;
  private CalendarSelector j;
  private a l;
  private RecyclerView mListView;
  private RecyclerView mRecyclerView;
  private DateSelector<S> mode;
  private int type;
  private View u;
  
  static
  {
    a = "NAVIGATION_PREV_TAG";
    c = "NAVIGATION_NEXT_TAG";
  }
  
  public MaterialCalendar() {}
  
  public static MaterialCalendar a(DateSelector paramDateSelector, int paramInt, CalendarConstraints paramCalendarConstraints)
  {
    MaterialCalendar localMaterialCalendar = new MaterialCalendar();
    Bundle localBundle = new Bundle();
    localBundle.putInt("THEME_RES_ID_KEY", paramInt);
    localBundle.putParcelable("GRID_SELECTOR_KEY", paramDateSelector);
    localBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    localBundle.putParcelable("CURRENT_MONTH_KEY", paramCalendarConstraints.add());
    localMaterialCalendar.setArguments(localBundle);
    return localMaterialCalendar;
  }
  
  private void a(View paramView, final t paramT)
  {
    final MaterialButton localMaterialButton1 = (MaterialButton)paramView.findViewById(R.id.message);
    localMaterialButton1.setTag(M);
    ViewCompat.a(localMaterialButton1, new f());
    MaterialButton localMaterialButton2 = (MaterialButton)paramView.findViewById(R.id.A);
    localMaterialButton2.setTag(a);
    MaterialButton localMaterialButton3 = (MaterialButton)paramView.findViewById(R.id.bottom);
    localMaterialButton3.setTag(c);
    u = paramView.findViewById(R.id.info);
    g = paramView.findViewById(R.id.t);
    a(CalendarSelector.b);
    localMaterialButton1.setText(d.toString(paramView.getContext()));
    mListView.setAdapter(new g(paramT, localMaterialButton1));
    localMaterialButton1.setOnClickListener(new h());
    localMaterialButton3.setOnClickListener(new i(paramT));
    localMaterialButton2.setOnClickListener(new j(paramT));
  }
  
  private void b(final int paramInt)
  {
    mListView.post(new a(paramInt));
  }
  
  static int getNavigationBarHeight(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(R.raw.a);
  }
  
  private RecyclerView.n setLyrics()
  {
    return new e();
  }
  
  Month a()
  {
    return d;
  }
  
  void a(CalendarSelector paramCalendarSelector)
  {
    j = paramCalendarSelector;
    if (paramCalendarSelector == CalendarSelector.i)
    {
      mRecyclerView.getLayoutManager().scrollToPosition(((o)mRecyclerView.getAdapter()).a(d.a));
      u.setVisibility(0);
      g.setVisibility(8);
      return;
    }
    if (paramCalendarSelector == CalendarSelector.b)
    {
      u.setVisibility(8);
      g.setVisibility(0);
      a(d);
    }
  }
  
  void a(Month paramMonth)
  {
    t localT = (t)mListView.getAdapter();
    int m = localT.b(paramMonth);
    int n = m - localT.b(d);
    int i = Math.abs(n);
    int k = 1;
    if (i > 3) {
      i = 1;
    } else {
      i = 0;
    }
    if (n <= 0) {
      k = 0;
    }
    d = paramMonth;
    if ((i != 0) && (k != 0))
    {
      mListView.scrollToPosition(m - 3);
      b(m);
      return;
    }
    if (i != 0)
    {
      mListView.scrollToPosition(m + 3);
      b(m);
      return;
    }
    b(m);
  }
  
  public boolean a(p paramP)
  {
    return super.a(paramP);
  }
  
  public DateSelector append()
  {
    return mode;
  }
  
  CalendarConstraints getValue()
  {
    return b;
  }
  
  a i()
  {
    return l;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    type = localBundle.getInt("THEME_RES_ID_KEY");
    mode = ((DateSelector)localBundle.getParcelable("GRID_SELECTOR_KEY"));
    b = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
    d = ((Month)localBundle.getParcelable("CURRENT_MONTH_KEY"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = new ContextThemeWrapper(getContext(), type);
    l = new a(paramBundle);
    paramLayoutInflater = paramLayoutInflater.cloneInContext(paramBundle);
    Object localObject = b.length();
    final int k;
    if (d.a(paramBundle))
    {
      i = h.h;
      k = 1;
    }
    else
    {
      i = h.b;
      k = 0;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(i, paramViewGroup, false);
    paramViewGroup = (GridView)paramLayoutInflater.findViewById(R.id.second);
    ViewCompat.a(paramViewGroup, new b());
    paramViewGroup.setAdapter(new w());
    paramViewGroup.setNumColumns(b);
    paramViewGroup.setEnabled(false);
    mListView = ((RecyclerView)paramLayoutInflater.findViewById(R.id.empty));
    paramViewGroup = new c(getContext(), k, false, k);
    mListView.setLayoutManager(paramViewGroup);
    mListView.setTag(y);
    paramViewGroup = new t(paramBundle, mode, b, new d());
    mListView.setAdapter(paramViewGroup);
    int i = paramBundle.getResources().getInteger(R.layout.image);
    localObject = (RecyclerView)paramLayoutInflater.findViewById(R.id.info);
    mRecyclerView = ((RecyclerView)localObject);
    if (localObject != null)
    {
      ((RecyclerView)localObject).setHasFixedSize(true);
      mRecyclerView.setLayoutManager(new GridLayoutManager(paramBundle, i, 1, false));
      mRecyclerView.setAdapter(new o(this));
      mRecyclerView.addItemDecoration(setLyrics());
    }
    if (paramLayoutInflater.findViewById(R.id.message) != null) {
      a(paramLayoutInflater, paramViewGroup);
    }
    if (!d.a(paramBundle)) {
      new ClassReader().a(mListView);
    }
    mListView.scrollToPosition(paramViewGroup.b(d));
    return paramLayoutInflater;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("THEME_RES_ID_KEY", type);
    paramBundle.putParcelable("GRID_SELECTOR_KEY", mode);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", b);
    paramBundle.putParcelable("CURRENT_MONTH_KEY", d);
  }
  
  androidx.recyclerview.widget.LinearLayoutManager values()
  {
    return (androidx.recyclerview.widget.LinearLayoutManager)mListView.getLayoutManager();
  }
  
  void visitMaxs()
  {
    CalendarSelector localCalendarSelector1 = j;
    CalendarSelector localCalendarSelector2 = CalendarSelector.i;
    if (localCalendarSelector1 == localCalendarSelector2)
    {
      a(CalendarSelector.b);
      return;
    }
    if (localCalendarSelector1 == CalendarSelector.b) {
      a(localCalendarSelector2);
    }
  }
  
  static enum CalendarSelector
  {
    static
    {
      CalendarSelector localCalendarSelector1 = new CalendarSelector("DAY", 0);
      b = localCalendarSelector1;
      CalendarSelector localCalendarSelector2 = new CalendarSelector("YEAR", 1);
      i = localCalendarSelector2;
      d = new CalendarSelector[] { localCalendarSelector1, localCalendarSelector2 };
    }
  }
  
  class a
    implements Runnable
  {
    a(int paramInt) {}
    
    public void run()
    {
      MaterialCalendar.getListView(MaterialCalendar.this).smoothScrollToPosition(paramInt);
    }
  }
  
  class b
    extends ActionMenuItemView
  {
    b() {}
    
    public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.a(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setParent(null);
    }
  }
  
  class c
    extends LinearLayoutManager
  {
    c(Context paramContext, int paramInt1, boolean paramBoolean, int paramInt2)
    {
      super(paramInt1, paramBoolean);
    }
    
    protected void onLayoutChildren(RecyclerView.y paramY, int[] paramArrayOfInt)
    {
      if (k == 0)
      {
        paramArrayOfInt[0] = MaterialCalendar.getListView(MaterialCalendar.this).getWidth();
        paramArrayOfInt[1] = MaterialCalendar.getListView(MaterialCalendar.this).getWidth();
        return;
      }
      paramArrayOfInt[0] = MaterialCalendar.getListView(MaterialCalendar.this).getHeight();
      paramArrayOfInt[1] = MaterialCalendar.getListView(MaterialCalendar.this).getHeight();
    }
  }
  
  class d
    implements MaterialCalendar.k
  {
    d() {}
    
    public void a(long paramLong)
    {
      if (MaterialCalendar.c(MaterialCalendar.this).a().a(paramLong))
      {
        MaterialCalendar.toString(MaterialCalendar.this).trim(paramLong);
        Iterator localIterator = f.iterator();
        while (localIterator.hasNext()) {
          ((p)localIterator.next()).a(MaterialCalendar.toString(MaterialCalendar.this).a());
        }
        MaterialCalendar.getListView(MaterialCalendar.this).getAdapter().notifyDataSetChanged();
        if (MaterialCalendar.access$getMRecyclerView(MaterialCalendar.this) != null) {
          MaterialCalendar.access$getMRecyclerView(MaterialCalendar.this).getAdapter().notifyDataSetChanged();
        }
      }
    }
  }
  
  class e
    extends RecyclerView.n
  {
    private final Calendar a = Log.getInstance();
    private final Calendar v = Log.getInstance();
    
    e() {}
    
    public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.y paramY)
    {
      if ((paramRecyclerView.getAdapter() instanceof o))
      {
        if (!(paramRecyclerView.getLayoutManager() instanceof GridLayoutManager)) {
          return;
        }
        paramY = (o)paramRecyclerView.getAdapter();
        GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramRecyclerView.getLayoutManager();
        Iterator localIterator = MaterialCalendar.toString(MaterialCalendar.this).equals().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (Position)localIterator.next();
          Object localObject2 = a;
          if ((localObject2 != null) && (x != null))
          {
            a.setTimeInMillis(((Long)localObject2).longValue());
            v.setTimeInMillis(((Long)x).longValue());
            int k = paramY.a(a.get(1));
            int j = paramY.a(v.get(1));
            localObject1 = localGridLayoutManager.findViewByPosition(k);
            localObject2 = localGridLayoutManager.findViewByPosition(j);
            int n = k / localGridLayoutManager.getTag();
            int i1 = j / localGridLayoutManager.getTag();
            j = n;
            while (j <= i1)
            {
              View localView = localGridLayoutManager.findViewByPosition(localGridLayoutManager.getTag() * j);
              if (localView != null)
              {
                int i2 = localView.getTop();
                int i3 = al.size();
                int i4 = localView.getBottom();
                int i5 = al.a();
                if (j == n) {
                  k = ((View)localObject1).getLeft() + ((View)localObject1).getWidth() / 2;
                } else {
                  k = 0;
                }
                int m;
                if (j == i1) {
                  m = ((View)localObject2).getLeft() + ((View)localObject2).getWidth() / 2;
                } else {
                  m = paramRecyclerView.getWidth();
                }
                paramCanvas.drawRect(k, i2 + i3, m, i4 - i5, ak);
              }
              j += 1;
            }
          }
        }
      }
    }
  }
  
  class f
    extends ActionMenuItemView
  {
    f() {}
    
    public void a(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.a(paramView, paramAccessibilityNodeInfoCompat);
      if (MaterialCalendar.b(MaterialCalendar.this).getVisibility() == 0) {
        paramView = getString(Switch.m);
      } else {
        paramView = getString(Switch.p);
      }
      paramAccessibilityNodeInfoCompat.add(paramView);
    }
  }
  
  class g
    extends RecyclerView.s
  {
    g(t paramT, MaterialButton paramMaterialButton) {}
    
    public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      if (paramInt1 < 0) {
        paramInt1 = values().getValue();
      } else {
        paramInt1 = values().getPosition();
      }
      MaterialCalendar.a(MaterialCalendar.this, paramT.add(paramInt1));
      localMaterialButton1.setText(paramT.a(paramInt1));
    }
    
    public void b(RecyclerView paramRecyclerView, int paramInt)
    {
      if (paramInt == 0)
      {
        CharSequence localCharSequence = localMaterialButton1.getText();
        if (Build.VERSION.SDK_INT >= 16)
        {
          paramRecyclerView.announceForAccessibility(localCharSequence);
          return;
        }
        paramRecyclerView.sendAccessibilityEvent(2048);
      }
    }
  }
  
  class h
    implements View.OnClickListener
  {
    h() {}
    
    public void onClick(View paramView)
    {
      visitMaxs();
    }
  }
  
  class i
    implements View.OnClickListener
  {
    i(t paramT) {}
    
    public void onClick(View paramView)
    {
      int i = values().getValue() + 1;
      if (i < MaterialCalendar.getListView(MaterialCalendar.this).getAdapter().getItemCount()) {
        a(paramT.add(i));
      }
    }
  }
  
  class j
    implements View.OnClickListener
  {
    j(t paramT) {}
    
    public void onClick(View paramView)
    {
      int i = values().getPosition() - 1;
      if (i >= 0) {
        a(paramT.add(i));
      }
    }
  }
  
  static abstract interface k
  {
    public abstract void a(long paramLong);
  }
}
