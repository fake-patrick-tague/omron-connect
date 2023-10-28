package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import v7.internal.R.attr;

public class AlertDialog
  extends AppCompatDialog
  implements DialogInterface
{
  final AlertController mAlert = new AlertController(getContext(), this, getWindow());
  
  protected AlertDialog(Context paramContext, int paramInt)
  {
    super(paramContext, a(paramContext, paramInt));
  }
  
  static int a(Context paramContext, int paramInt)
  {
    if ((paramInt >>> 24 & 0xFF) >= 1) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogTheme, localTypedValue, true);
    return resourceId;
  }
  
  public Button getButton(int paramInt)
  {
    return mAlert.getButton(paramInt);
  }
  
  public ListView getListView()
  {
    return mAlert.getListView();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mAlert.installContent();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (mAlert.onKeyDown(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (mAlert.onKeyUp(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    mAlert.setTitle(paramCharSequence);
  }
  
  public class Builder
  {
    private final AlertController.f P;
    private final int mTheme;
    
    public Builder()
    {
      this(AlertDialog.a(this$1, 0));
    }
    
    public Builder(int paramInt)
    {
      P = new AlertController.f(new ContextThemeWrapper(this$1, AlertDialog.a(this$1, paramInt)));
      mTheme = paramInt;
    }
    
    public AlertDialog create()
    {
      AlertDialog localAlertDialog = new AlertDialog(P.mContext, mTheme);
      P.apply(mAlert);
      localAlertDialog.setCancelable(P.mCancelable);
      if (P.mCancelable) {
        localAlertDialog.setCanceledOnTouchOutside(true);
      }
      localAlertDialog.setOnCancelListener(P.mOnCancelListener);
      localAlertDialog.setOnDismissListener(P.mOnDismissListener);
      DialogInterface.OnKeyListener localOnKeyListener = P.mOnKeyListener;
      if (localOnKeyListener != null) {
        localAlertDialog.setOnKeyListener(localOnKeyListener);
      }
      return localAlertDialog;
    }
    
    public Context getContext()
    {
      return P.mContext;
    }
    
    public Builder setAdapter(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener)
    {
      AlertController.f localF = P;
      mAdapter = paramListAdapter;
      mOnClickListener = paramOnClickListener;
      return this;
    }
    
    public Builder setCustomTitle(View paramView)
    {
      P.mCustomTitleView = paramView;
      return this;
    }
    
    public Builder setIcon(Drawable paramDrawable)
    {
      P.mIcon = paramDrawable;
      return this;
    }
    
    public Builder setNegativeButton(int paramInt)
    {
      AlertController.f localF = P;
      mMessage = mContext.getText(paramInt);
      return this;
    }
    
    public Builder setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      AlertController.f localF = P;
      mNegativeButtonText = mContext.getText(paramInt);
      P.mNegativeButtonListener = paramOnClickListener;
      return this;
    }
    
    public Builder setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      P.mOnCancelListener = paramOnCancelListener;
      return this;
    }
    
    public Builder setOnKeyListener(DialogInterface.OnKeyListener paramOnKeyListener)
    {
      P.mOnKeyListener = paramOnKeyListener;
      return this;
    }
    
    public Builder setPositiveButton(int paramInt)
    {
      AlertController.f localF = P;
      mTitle = mContext.getText(paramInt);
      return this;
    }
    
    public Builder setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      AlertController.f localF = P;
      mPositiveButtonText = mContext.getText(paramInt);
      P.mNeutralButtonListener = paramOnClickListener;
      return this;
    }
    
    public Builder setSingleChoiceItems(ListAdapter paramListAdapter, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      AlertController.f localF = P;
      mAdapter = paramListAdapter;
      mOnClickListener = paramOnClickListener;
      mCheckedItem = paramInt;
      mIsSingleChoice = true;
      return this;
    }
    
    public Builder setTitle(CharSequence paramCharSequence)
    {
      P.mTitle = paramCharSequence;
      return this;
    }
    
    public Builder setView(View paramView)
    {
      AlertController.f localF = P;
      mView = paramView;
      mViewLayoutResId = 0;
      mViewSpacingSpecified = false;
      return this;
    }
  }
}
