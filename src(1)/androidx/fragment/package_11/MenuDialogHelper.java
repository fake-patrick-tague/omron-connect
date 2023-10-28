package androidx.fragment.package_11;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class MenuDialogHelper
  implements DialogInterface.OnDismissListener
{
  MenuDialogHelper(DialogFragment paramDialogFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (DialogFragment.access$000(mDialog) != null)
    {
      paramDialogInterface = mDialog;
      paramDialogInterface.onDismiss(DialogFragment.access$000(paramDialogInterface));
    }
  }
}
