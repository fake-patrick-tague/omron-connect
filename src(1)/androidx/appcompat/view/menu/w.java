package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.widget.ListPopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v7.internal.R.dimen;
import v7.internal.R.layout;
import v7.v7.package_13.GravityCompat;
import v7.v7.package_13.ViewCompat;

final class w
  extends d
  implements l, View.OnKeyListener, PopupWindow.OnDismissListener
{
  private static final int H = R.layout.Default;
  private PopupWindow.OnDismissListener Q;
  final List<d.d> a = new ArrayList();
  private final int b;
  private int c;
  private final View.OnAttachStateChangeListener data = new PopupMenuHelper(this);
  private boolean e;
  final Handler f;
  private final boolean h;
  boolean i;
  private final int id;
  private final int index;
  private l.a k;
  private boolean l;
  private boolean m;
  private final Context mContext;
  ViewTreeObserver mTreeObserver;
  private final androidx.appcompat.widget.Item n = new Item(this);
  private final List<g> queue = new ArrayList();
  private View r;
  private int s = 0;
  private int t = 0;
  final ViewTreeObserver.OnGlobalLayoutListener this$0 = new a(this);
  View view;
  private int x;
  private int y;
  private boolean z;
  
  public w(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    mContext = paramContext;
    r = paramView;
    id = paramInt1;
    index = paramInt2;
    h = paramBoolean;
    m = false;
    c = a();
    paramContext = paramContext.getResources();
    b = Math.max(getDisplayMetricswidthPixels / 2, paramContext.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    f = new Handler();
  }
  
  private int a()
  {
    if (ViewCompat.getLayoutDirection(r) == 1) {
      return 0;
    }
    return 1;
  }
  
  private MenuItem a(f paramF1, f paramF2)
  {
    int i1 = paramF1.size();
    int j = 0;
    while (j < i1)
    {
      MenuItem localMenuItem = paramF1.getItem(j);
      if ((localMenuItem.hasSubMenu()) && (paramF2 == localMenuItem.getSubMenu())) {
        return localMenuItem;
      }
      j += 1;
    }
    return null;
  }
  
  private View a(h paramH, f paramF)
  {
    paramF = a(c, paramF);
    if (paramF == null) {
      return null;
    }
    ListView localListView = paramH.getListView();
    paramH = localListView.getAdapter();
    boolean bool = paramH instanceof HeaderViewListAdapter;
    int j = 0;
    int i1;
    if (bool)
    {
      paramH = (HeaderViewListAdapter)paramH;
      i1 = paramH.getHeadersCount();
      paramH = (x)paramH.getWrappedAdapter();
    }
    else
    {
      paramH = (x)paramH;
      i1 = 0;
    }
    int i2 = paramH.getCount();
    while (j < i2)
    {
      if (paramF == paramH.a(j)) {
        break label104;
      }
      j += 1;
    }
    j = -1;
    label104:
    if (j == -1) {
      return null;
    }
    j = j + i1 - localListView.getFirstVisiblePosition();
    if (j >= 0)
    {
      if (j >= localListView.getChildCount()) {
        return null;
      }
      return localListView.getChildAt(j);
    }
    return null;
  }
  
  private void a(f paramF)
  {
    Object localObject3 = LayoutInflater.from(mContext);
    Object localObject1 = new x(paramF, (LayoutInflater)localObject3, h, H);
    if ((!isShowing()) && (m)) {
      ((x)localObject1).a(true);
    } else if (isShowing()) {
      ((x)localObject1).a(d.onSubMenuSelected(paramF));
    }
    int i1 = d.measureContentWidth((ListAdapter)localObject1, null, mContext, b);
    int j = i1;
    androidx.appcompat.widget.w localW = run();
    localW.setAdapter((ListAdapter)localObject1);
    localW.setContentWidth(i1);
    localW.dismiss(t);
    if (a.size() > 0)
    {
      localObject1 = a;
      localObject1 = (h)((List)localObject1).get(((List)localObject1).size() - 1);
      localObject2 = a((h)localObject1, paramF);
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
    }
    if (localObject2 != null)
    {
      localW.a(false);
      localW.init(null);
      i1 = add(i1);
      int i2;
      if (i1 == 1) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      c = i1;
      int i3;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localW.setAdapter((View)localObject2);
        i1 = 0;
        i3 = 0;
      }
      else
      {
        int[] arrayOfInt1 = new int[2];
        r.getLocationOnScreen(arrayOfInt1);
        int[] arrayOfInt2 = new int[2];
        ((View)localObject2).getLocationOnScreen(arrayOfInt2);
        if ((t & 0x7) == 5)
        {
          arrayOfInt1[0] += r.getWidth();
          arrayOfInt2[0] += ((View)localObject2).getWidth();
        }
        i3 = arrayOfInt2[0] - arrayOfInt1[0];
        i1 = arrayOfInt2[1] - arrayOfInt1[1];
      }
      if ((t & 0x5) == 5)
      {
        if (i2 == 0)
        {
          j = ((View)localObject2).getWidth();
          break label368;
        }
      }
      else
      {
        if (i2 == 0) {
          break label368;
        }
        j = ((View)localObject2).getWidth();
      }
      j = i3 + j;
      break label373;
      label368:
      j = i3 - j;
      label373:
      localW.setHorizontalOffset(j);
      localW.show(true);
      localW.setVerticalOffset(i1);
    }
    else
    {
      if (l) {
        localW.setHorizontalOffset(x);
      }
      if (z) {
        localW.setVerticalOffset(y);
      }
      localW.show(b());
    }
    Object localObject2 = new h(localW, paramF, c);
    a.add(localObject2);
    localW.show();
    localObject2 = localW.getListView();
    ((View)localObject2).setOnKeyListener(this);
    if ((localObject1 == null) && (e) && (paramF.getHeaderTitle() != null))
    {
      localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(R.layout.d, (ViewGroup)localObject2, false);
      localObject3 = (TextView)((View)localObject1).findViewById(16908310);
      ((View)localObject1).setEnabled(false);
      ((TextView)localObject3).setText(paramF.getHeaderTitle());
      ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
      localW.show();
    }
  }
  
  private int add(int paramInt)
  {
    Object localObject = a;
    localObject = ((h)((List)localObject).get(((List)localObject).size() - 1)).getListView();
    int[] arrayOfInt = new int[2];
    ((View)localObject).getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    view.getWindowVisibleDisplayFrame(localRect);
    if (c == 1)
    {
      if (arrayOfInt[0] + ((View)localObject).getWidth() + paramInt > right) {
        return 0;
      }
      return 1;
    }
    if (arrayOfInt[0] - paramInt < 0) {
      return 1;
    }
    return 0;
  }
  
  private int c(f paramF)
  {
    int i1 = a.size();
    int j = 0;
    while (j < i1)
    {
      if (paramF == a.get(j)).c) {
        return j;
      }
      j += 1;
    }
    return -1;
  }
  
  private androidx.appcompat.widget.w run()
  {
    androidx.appcompat.widget.w localW = new androidx.appcompat.widget.w(mContext, null, id, index);
    localW.a(n);
    localW.setOnItemClickListener(this);
    localW.setOnDismissListener(this);
    localW.setAdapter(r);
    localW.dismiss(t);
    localW.setModal(true);
    localW.show(2);
    return localW;
  }
  
  public void a(int paramInt)
  {
    if (s != paramInt)
    {
      s = paramInt;
      t = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(r));
    }
  }
  
  public void a(View paramView)
  {
    if (r != paramView)
    {
      r = paramView;
      t = GravityCompat.getAbsoluteGravity(s, ViewCompat.getLayoutDirection(paramView));
    }
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    Q = paramOnDismissListener;
  }
  
  public void a(f paramF, boolean paramBoolean)
  {
    int j = c(paramF);
    if (j < 0) {
      return;
    }
    int i1 = j + 1;
    if (i1 < a.size()) {
      a.get(i1)).c.close(false);
    }
    Object localObject = (h)a.remove(j);
    c.b(this);
    if (i)
    {
      this$0.show(null);
      this$0.setAnimationStyle(0);
    }
    this$0.dismiss();
    j = a.size();
    if (j > 0) {
      c = a.get(j - 1)).j;
    } else {
      c = a();
    }
    if (j == 0)
    {
      dismiss();
      localObject = k;
      if (localObject != null) {
        ((l.a)localObject).onCloseMenu(paramF, true);
      }
      paramF = mTreeObserver;
      if (paramF != null)
      {
        if (paramF.isAlive()) {
          mTreeObserver.removeGlobalOnLayoutListener(this$0);
        }
        mTreeObserver = null;
      }
      view.removeOnAttachStateChangeListener(data);
      Q.onDismiss();
      return;
    }
    if (paramBoolean) {
      a.get(0)).c.close(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    m = paramBoolean;
  }
  
  public boolean a(p paramP)
  {
    Object localObject = a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      h localH = (h)((Iterator)localObject).next();
      if (paramP == c)
      {
        localH.getListView().requestFocus();
        return true;
      }
    }
    if (paramP.hasVisibleItems())
    {
      show(paramP);
      localObject = k;
      if (localObject != null)
      {
        ((l.a)localObject).onOpenSubMenu(paramP);
        return true;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public void dismiss()
  {
    int j = a.size();
    if (j > 0)
    {
      h[] arrayOfH = (h[])a.toArray(new h[j]);
      j -= 1;
      while (j >= 0)
      {
        h localH = arrayOfH[j];
        if (this$0.isShowing()) {
          this$0.dismiss();
        }
        j -= 1;
      }
    }
  }
  
  public void dismiss(int paramInt)
  {
    z = true;
    y = paramInt;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  protected boolean g()
  {
    return false;
  }
  
  public ListView getListView()
  {
    if (a.isEmpty()) {
      return null;
    }
    List localList = a;
    return ((h)localList.get(localList.size() - 1)).getListView();
  }
  
  public boolean isShowing()
  {
    return (a.size() > 0) && (a.get(0)).this$0.isShowing());
  }
  
  public void onDismiss()
  {
    int i1 = a.size();
    int j = 0;
    while (j < i1)
    {
      localH = (h)a.get(j);
      if (!this$0.isShowing()) {
        break label53;
      }
      j += 1;
    }
    h localH = null;
    label53:
    if (localH != null) {
      c.close(false);
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public void setCallback(l.a paramA)
  {
    k = paramA;
  }
  
  public void setCallback(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public void show()
  {
    if (isShowing()) {
      return;
    }
    Object localObject = queue.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((f)((Iterator)localObject).next());
    }
    queue.clear();
    localObject = r;
    view = ((View)localObject);
    if (localObject != null)
    {
      int j;
      if (mTreeObserver == null) {
        j = 1;
      } else {
        j = 0;
      }
      localObject = ((View)localObject).getViewTreeObserver();
      mTreeObserver = ((ViewTreeObserver)localObject);
      if (j != 0) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this$0);
      }
      view.addOnAttachStateChangeListener(data);
    }
  }
  
  public void show(int paramInt)
  {
    l = true;
    x = paramInt;
  }
  
  public void show(f paramF)
  {
    paramF.addMenuPresenter(this, mContext);
    if (isShowing())
    {
      a(paramF);
      return;
    }
    queue.add(paramF);
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      d.a(((h)localIterator.next()).getListView().getAdapter()).notifyDataSetChanged();
    }
  }
}
