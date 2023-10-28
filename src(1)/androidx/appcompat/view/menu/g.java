package androidx.appcompat.view.menu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Adapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatDialog;
import v7.internal.R.layout;

class g
  implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, l.a
{
  e a;
  private f b;
  private AlertDialog c;
  private l.a d;
  
  public g(f paramF)
  {
    b = paramF;
  }
  
  public void a()
  {
    AlertDialog localAlertDialog = c;
    if (localAlertDialog != null) {
      localAlertDialog.dismiss();
    }
  }
  
  public void a(IBinder paramIBinder)
  {
    Object localObject1 = b;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(((f)localObject1).getContext());
    Object localObject2 = new e(localBuilder.getContext(), R.layout.abc_list_menu_item_layout);
    a = ((e)localObject2);
    ((e)localObject2).setCallback(this);
    b.addMenuPresenter(a);
    localBuilder.setAdapter(a.a(), this);
    localObject2 = ((f)localObject1).getHeaderView();
    if (localObject2 != null) {
      localBuilder.setCustomTitle((View)localObject2);
    } else {
      localBuilder.setIcon(((f)localObject1).getHeaderIcon()).setTitle(((f)localObject1).getHeaderTitle());
    }
    localBuilder.setOnKeyListener(this);
    localObject1 = localBuilder.create();
    c = ((AlertDialog)localObject1);
    ((Dialog)localObject1).setOnDismissListener(this);
    localObject1 = c.getWindow().getAttributes();
    type = 1003;
    if (paramIBinder != null) {
      token = paramIBinder;
    }
    flags |= 0x20000;
    c.show();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.a((MenuItemImpl)a.a().getItem(paramInt), 0);
  }
  
  public void onCloseMenu(f paramF, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramF == b)) {
      a();
    }
    l.a localA = d;
    if (localA != null) {
      localA.onCloseMenu(paramF, paramBoolean);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    a.a(b, true);
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = c.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = c.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              b.close(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return b.performShortcut(paramInt, paramKeyEvent, 0);
  }
  
  public boolean onOpenSubMenu(f paramF)
  {
    l.a localA = d;
    if (localA != null) {
      return localA.onOpenSubMenu(paramF);
    }
    return false;
  }
}
