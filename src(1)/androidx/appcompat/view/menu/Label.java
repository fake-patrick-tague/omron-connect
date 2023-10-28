package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import v7.v7.package_13.GravityCompat;
import v7.v7.package_13.ViewCompat;

public class Label
{
  private final Context a;
  private d b;
  private final f c;
  private PopupWindow.OnDismissListener d;
  private int e = 8388611;
  private View f;
  private final PopupWindow.OnDismissListener g = new v(this);
  private final int h;
  private boolean i;
  private l.a k;
  private final boolean r;
  private final int t;
  
  public Label(Context paramContext, f paramF, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramF, paramView, paramBoolean, paramInt, 0);
  }
  
  public Label(Context paramContext, f paramF, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    a = paramContext;
    c = paramF;
    f = paramView;
    r = paramBoolean;
    t = paramInt1;
    h = paramInt2;
  }
  
  private d a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    d localD = b();
    localD.setCallback(paramBoolean2);
    if (paramBoolean1)
    {
      int j = paramInt1;
      if ((GravityCompat.getAbsoluteGravity(e, ViewCompat.getLayoutDirection(f)) & 0x7) == 5) {
        j = paramInt1 - f.getWidth();
      }
      localD.show(j);
      localD.dismiss(paramInt2);
      paramInt1 = (int)(a.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localD.c(new Rect(j - paramInt1, paramInt2 - paramInt1, j + paramInt1, paramInt2 + paramInt1));
    }
    localD.show();
  }
  
  public void a(View paramView)
  {
    f = paramView;
  }
  
  public void a(l.a paramA)
  {
    k = paramA;
    d localD = b;
    if (localD != null) {
      localD.setCallback(paramA);
    }
  }
  
  public d b()
  {
    if (b == null) {
      b = a();
    }
    return b;
  }
  
  public void b(int paramInt)
  {
    e = paramInt;
  }
  
  public void b(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    d = paramOnDismissListener;
  }
  
  public void b(boolean paramBoolean)
  {
    i = paramBoolean;
    d localD = b;
    if (localD != null) {
      localD.a(paramBoolean);
    }
  }
  
  public boolean b(int paramInt1, int paramInt2)
  {
    if (equals()) {
      return true;
    }
    if (f == null) {
      return false;
    }
    a(paramInt1, paramInt2, true, true);
    return true;
  }
  
  public void dismiss()
  {
    if (equals()) {
      b.dismiss();
    }
  }
  
  public boolean draw()
  {
    if (equals()) {
      return true;
    }
    if (f == null) {
      return false;
    }
    a(0, 0, false, false);
    return true;
  }
  
  public boolean equals()
  {
    d localD = b;
    return (localD != null) && (localD.isShowing());
  }
  
  protected void onCloseMenu()
  {
    b = null;
    PopupWindow.OnDismissListener localOnDismissListener = d;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss();
    }
  }
  
  public void show()
  {
    if (draw()) {
      return;
    }
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
}
