package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.w;
import v7.internal.R.dimen;
import v7.internal.R.layout;
import v7.v7.package_13.ViewCompat;

final class k
  extends d
  implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, l, View.OnKeyListener
{
  private static final int directory = R.layout.none;
  private final View.OnAttachStateChangeListener P = new MenuPopupHelper(this);
  final ViewTreeObserver.OnGlobalLayoutListener W = new ActivityChooserView.2(this);
  View a;
  private final f b;
  private final Context c;
  private boolean e;
  private final boolean f;
  private PopupWindow.OnDismissListener h;
  private View i;
  private final int j;
  private l.a k;
  private final x mAdapter;
  private int mContentWidth;
  private boolean mHasContentWidth;
  final w mPopup;
  ViewTreeObserver mTreeObserver;
  private final int n;
  private final int r;
  private int s = 0;
  private boolean top;
  
  public k(Context paramContext, f paramF, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    c = paramContext;
    b = paramF;
    f = paramBoolean;
    mAdapter = new x(paramF, LayoutInflater.from(paramContext), paramBoolean, directory);
    r = paramInt1;
    n = paramInt2;
    Resources localResources = paramContext.getResources();
    j = Math.max(getDisplayMetricswidthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    i = paramView;
    mPopup = new w(paramContext, null, paramInt1, paramInt2);
    paramF.addMenuPresenter(this, paramContext);
  }
  
  private boolean a()
  {
    if (isShowing()) {
      return true;
    }
    if (!top)
    {
      Object localObject1 = i;
      if (localObject1 == null) {
        return false;
      }
      a = ((View)localObject1);
      mPopup.setOnDismissListener(this);
      mPopup.setOnItemClickListener(this);
      mPopup.setModal(true);
      localObject1 = a;
      int m;
      if (mTreeObserver == null) {
        m = 1;
      } else {
        m = 0;
      }
      Object localObject2 = ((View)localObject1).getViewTreeObserver();
      mTreeObserver = ((ViewTreeObserver)localObject2);
      if (m != 0) {
        ((ViewTreeObserver)localObject2).addOnGlobalLayoutListener(W);
      }
      ((View)localObject1).addOnAttachStateChangeListener(P);
      mPopup.setAdapter((View)localObject1);
      mPopup.dismiss(s);
      if (!mHasContentWidth)
      {
        mContentWidth = d.measureContentWidth(mAdapter, null, c, j);
        mHasContentWidth = true;
      }
      mPopup.setContentWidth(mContentWidth);
      mPopup.show(2);
      mPopup.show(b());
      mPopup.show();
      localObject1 = mPopup.getListView();
      ((View)localObject1).setOnKeyListener(this);
      if ((e) && (b.getHeaderTitle() != null))
      {
        localObject2 = (FrameLayout)LayoutInflater.from(c).inflate(R.layout.d, (ViewGroup)localObject1, false);
        TextView localTextView = (TextView)((View)localObject2).findViewById(16908310);
        if (localTextView != null) {
          localTextView.setText(b.getHeaderTitle());
        }
        ((View)localObject2).setEnabled(false);
        ((ListView)localObject1).addHeaderView((View)localObject2, null, false);
      }
      mPopup.setAdapter(mAdapter);
      mPopup.show();
      return true;
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    s = paramInt;
  }
  
  public void a(View paramView)
  {
    i = paramView;
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    h = paramOnDismissListener;
  }
  
  public void a(f paramF, boolean paramBoolean)
  {
    if (paramF != b) {
      return;
    }
    dismiss();
    l.a localA = k;
    if (localA != null) {
      localA.onCloseMenu(paramF, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    mAdapter.a(paramBoolean);
  }
  
  public boolean a(p paramP)
  {
    if (paramP.hasVisibleItems())
    {
      Object localObject = new Label(c, paramP, a, f, r, n);
      ((Label)localObject).a(k);
      ((Label)localObject).b(d.onSubMenuSelected(paramP));
      ((Label)localObject).b(h);
      h = null;
      b.close(false);
      int i1 = mPopup.getHorizontalOffset();
      int m = i1;
      int i2 = mPopup.getVerticalOffset();
      if ((Gravity.getAbsoluteGravity(s, ViewCompat.getLayoutDirection(i)) & 0x7) == 5) {
        m = i1 + i.getWidth();
      }
      if (((Label)localObject).b(m, i2))
      {
        localObject = k;
        if (localObject != null) {
          ((l.a)localObject).onOpenSubMenu(paramP);
        }
        return true;
      }
    }
    return false;
  }
  
  public void dismiss()
  {
    if (isShowing()) {
      mPopup.dismiss();
    }
  }
  
  public void dismiss(int paramInt)
  {
    mPopup.setVerticalOffset(paramInt);
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public ListView getListView()
  {
    return mPopup.getListView();
  }
  
  public boolean isShowing()
  {
    return (!top) && (mPopup.isShowing());
  }
  
  public void onDismiss()
  {
    top = true;
    b.close();
    Object localObject = mTreeObserver;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        mTreeObserver = a.getViewTreeObserver();
      }
      mTreeObserver.removeGlobalOnLayoutListener(W);
      mTreeObserver = null;
    }
    a.removeOnAttachStateChangeListener(P);
    localObject = h;
    if (localObject != null) {
      ((PopupWindow.OnDismissListener)localObject).onDismiss();
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
    if (a()) {
      return;
    }
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }
  
  public void show(int paramInt)
  {
    mPopup.setHorizontalOffset(paramInt);
  }
  
  public void show(f paramF) {}
  
  public void updateMenuView(boolean paramBoolean)
  {
    mHasContentWidth = false;
    x localX = mAdapter;
    if (localX != null) {
      localX.notifyDataSetChanged();
    }
  }
}
