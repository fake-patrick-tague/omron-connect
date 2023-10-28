package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.lifecycle.ExtensionData;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.d;
import androidx.lifecycle.f;
import kotlin.x.d.i;

public class FragmentActivity
  extends Dialog
  implements d, Point
{
  private f d;
  private final OnBackPressedDispatcher menu = new OnBackPressedDispatcher(new MonthByWeekFragment.2(this));
  
  public FragmentActivity(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private final void a()
  {
    Object localObject = getWindow();
    i.b(localObject);
    ExtensionData.b(((Window)localObject).getDecorView(), this);
    localObject = getWindow();
    i.b(localObject);
    localObject = ((Window)localObject).getDecorView();
    i.d(localObject, "window!!.decorView");
    k.a((View)localObject, this);
  }
  
  private final f e()
  {
    f localF2 = d;
    f localF1 = localF2;
    if (localF2 == null)
    {
      localF1 = new f(this);
      d = localF1;
    }
    return localF1;
  }
  
  private static final void onSaveInstanceState(FragmentActivity paramFragmentActivity)
  {
    i.e(paramFragmentActivity, "this$0");
    paramFragmentActivity.onBackPressed();
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    i.e(paramView, "view");
    a();
    super.addContentView(paramView, paramLayoutParams);
  }
  
  public final Lifecycle getLifecycle()
  {
    return e();
  }
  
  public final OnBackPressedDispatcher getOnBackPressedDispatcher()
  {
    return menu;
  }
  
  public void onBackPressed()
  {
    menu.update();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 33) {
      menu.b(getOnBackInvokedDispatcher());
    }
    e().append(Lifecycle.Event.ON_CREATE);
  }
  
  protected void onStart()
  {
    super.onStart();
    e().append(Lifecycle.Event.ON_RESUME);
  }
  
  protected void onStop()
  {
    e().append(Lifecycle.Event.ON_DESTROY);
    d = null;
    super.onStop();
  }
  
  public void setContentView(int paramInt)
  {
    a();
    super.setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    i.e(paramView, "view");
    a();
    super.setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    i.e(paramView, "view");
    a();
    super.setContentView(paramView, paramLayoutParams);
  }
}
