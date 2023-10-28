package androidx.fragment.package_11;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.FragmentActivity;
import androidx.lifecycle.ExtensionData;
import androidx.lifecycle.HttpManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.m;
import androidx.lifecycle.t;
import androidx.savedstate.Feedback;

public class DialogFragment
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  private static final String SAVED_BACK_STACK_ID = "android:backStackId";
  private static final String SAVED_CANCELABLE = "android:cancelable";
  private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
  private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
  private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
  private static final String SAVED_STYLE = "android:style";
  private static final String SAVED_THEME = "android:theme";
  public static final int STYLE_NORMAL = 0;
  public static final int STYLE_NO_FRAME = 2;
  public static final int STYLE_NO_INPUT = 3;
  public static final int STYLE_NO_TITLE = 1;
  private int mBackStackId = -1;
  private boolean mCancelable = true;
  private boolean mCreatingDialog;
  private Dialog mDialog;
  private boolean mDialogCreated = false;
  private Runnable mDismissRunnable = new MonthByWeekFragment.2(this);
  private boolean mDismissed;
  private Handler mHandler;
  private t<m> mObserver = new ErrorReporter.2(this);
  private DialogInterface.OnCancelListener mOnCancelListener = new TileProviderTAR.2(this);
  private DialogInterface.OnDismissListener mOnDismissListener = new MenuDialogHelper(this);
  private boolean mShownByMe;
  private boolean mShowsDialog = true;
  private int mStyle = 0;
  private int mTheme = 0;
  private boolean mViewDestroyed;
  
  public DialogFragment() {}
  
  public DialogFragment(int paramInt)
  {
    super(paramInt);
  }
  
  private void dismissInternal(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (mDismissed) {
      return;
    }
    mDismissed = true;
    mShownByMe = false;
    Object localObject = mDialog;
    if (localObject != null)
    {
      ((Dialog)localObject).setOnDismissListener(null);
      mDialog.dismiss();
      if (!paramBoolean2) {
        if (Looper.myLooper() == mHandler.getLooper()) {
          onDismiss(mDialog);
        } else {
          mHandler.post(mDismissRunnable);
        }
      }
    }
    mViewDestroyed = true;
    if (mBackStackId >= 0)
    {
      if (paramBoolean3) {
        getParentFragmentManager().add(mBackStackId, 1);
      } else {
        getParentFragmentManager().remove(mBackStackId, 1, paramBoolean1);
      }
      mBackStackId = -1;
      return;
    }
    localObject = getParentFragmentManager().beginTransaction();
    ((Item)localObject).a(true);
    ((Item)localObject).add(this);
    if (paramBoolean3)
    {
      ((Item)localObject).add();
      return;
    }
    if (paramBoolean1)
    {
      ((Item)localObject).commitAllowingStateLoss();
      return;
    }
    ((Item)localObject).commit();
  }
  
  private void prepareDialog(Bundle paramBundle)
  {
    if (!mShowsDialog) {
      return;
    }
    if (!mDialogCreated) {
      try
      {
        mCreatingDialog = true;
        paramBundle = onCreateDialog(paramBundle);
        mDialog = paramBundle;
        boolean bool = mShowsDialog;
        if (bool)
        {
          setupDialog(paramBundle, mStyle);
          paramBundle = getContext();
          bool = paramBundle instanceof Activity;
          if (bool) {
            mDialog.setOwnerActivity((Activity)paramBundle);
          }
          mDialog.setCancelable(mCancelable);
          mDialog.setOnCancelListener(mOnCancelListener);
          mDialog.setOnDismissListener(mOnDismissListener);
          mDialogCreated = true;
        }
        else
        {
          mDialog = null;
        }
        mCreatingDialog = false;
        return;
      }
      catch (Throwable paramBundle)
      {
        mCreatingDialog = false;
        throw paramBundle;
      }
    }
  }
  
  AppCompatDelegate createFragmentContainer()
  {
    return new Fragment.1(this, super.createFragmentContainer());
  }
  
  public void dismiss()
  {
    dismissInternal(false, false, false);
  }
  
  public void dismissAllowingStateLoss()
  {
    dismissInternal(true, false, false);
  }
  
  public void dismissNow()
  {
    dismissInternal(false, false, true);
  }
  
  public Dialog getDialog()
  {
    return mDialog;
  }
  
  public boolean getShowsDialog()
  {
    return mShowsDialog;
  }
  
  public int getTheme()
  {
    return mTheme;
  }
  
  public boolean isCancelable()
  {
    return mCancelable;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    getViewLifecycleOwnerLiveData().observeForever(mObserver);
    if (!mShownByMe) {
      mDismissed = false;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mHandler = new Handler();
    boolean bool;
    if (mContainerId == 0) {
      bool = true;
    } else {
      bool = false;
    }
    mShowsDialog = bool;
    if (paramBundle != null)
    {
      mStyle = paramBundle.getInt("android:style", 0);
      mTheme = paramBundle.getInt("android:theme", 0);
      mCancelable = paramBundle.getBoolean("android:cancelable", true);
      mShowsDialog = paramBundle.getBoolean("android:showsDialog", mShowsDialog);
      mBackStackId = paramBundle.getInt("android:backStackId", -1);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    if (FragmentManager.get(3))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreateDialog called for DialogFragment ");
      paramBundle.append(this);
      Log.d("FragmentManager", paramBundle.toString());
    }
    return new FragmentActivity(requireContext(), getTheme());
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Dialog localDialog = mDialog;
    if (localDialog != null)
    {
      mViewDestroyed = true;
      localDialog.setOnDismissListener(null);
      mDialog.dismiss();
      if (!mDismissed) {
        onDismiss(mDialog);
      }
      mDialog = null;
      mDialogCreated = false;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if ((!mShownByMe) && (!mDismissed)) {
      mDismissed = true;
    }
    getViewLifecycleOwnerLiveData().removeObserver(mObserver);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!mViewDestroyed)
    {
      if (FragmentManager.get(3))
      {
        paramDialogInterface = new StringBuilder();
        paramDialogInterface.append("onDismiss called for DialogFragment ");
        paramDialogInterface.append(this);
        Log.d("FragmentManager", paramDialogInterface.toString());
      }
      dismissInternal(true, true, false);
    }
  }
  
  View onFindViewById(int paramInt)
  {
    Dialog localDialog = mDialog;
    if (localDialog != null) {
      return localDialog.findViewById(paramInt);
    }
    return null;
  }
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    LayoutInflater localLayoutInflater = super.onGetLayoutInflater(paramBundle);
    if ((mShowsDialog) && (!mCreatingDialog))
    {
      prepareDialog(paramBundle);
      if (FragmentManager.get(2))
      {
        paramBundle = new StringBuilder();
        paramBundle.append("get layout inflater for DialogFragment ");
        paramBundle.append(this);
        paramBundle.append(" from dialog context");
        Log.d("FragmentManager", paramBundle.toString());
      }
      paramBundle = mDialog;
      if (paramBundle != null) {
        return localLayoutInflater.cloneInContext(paramBundle.getContext());
      }
    }
    else if (FragmentManager.get(2))
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getting layout inflater for DialogFragment ");
      paramBundle.append(this);
      paramBundle = paramBundle.toString();
      if (!mShowsDialog)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mShowsDialog = false: ");
        localStringBuilder.append(paramBundle);
        Log.d("FragmentManager", localStringBuilder.toString());
        return localLayoutInflater;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mCreatingDialog = true: ");
      localStringBuilder.append(paramBundle);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    return localLayoutInflater;
  }
  
  boolean onHasView()
  {
    return mDialogCreated;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Object localObject = mDialog;
    if (localObject != null)
    {
      localObject = ((Dialog)localObject).onSaveInstanceState();
      ((BaseBundle)localObject).putBoolean("android:dialogShowing", false);
      paramBundle.putBundle("android:savedDialogState", (Bundle)localObject);
    }
    int i = mStyle;
    if (i != 0) {
      paramBundle.putInt("android:style", i);
    }
    i = mTheme;
    if (i != 0) {
      paramBundle.putInt("android:theme", i);
    }
    boolean bool = mCancelable;
    if (!bool) {
      paramBundle.putBoolean("android:cancelable", bool);
    }
    bool = mShowsDialog;
    if (!bool) {
      paramBundle.putBoolean("android:showsDialog", bool);
    }
    i = mBackStackId;
    if (i != -1) {
      paramBundle.putInt("android:backStackId", i);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = mDialog;
    if (localObject != null)
    {
      mViewDestroyed = false;
      ((Dialog)localObject).show();
      localObject = mDialog.getWindow().getDecorView();
      ExtensionData.b((View)localObject, this);
      HttpManager.init((View)localObject, this);
      Feedback.set((View)localObject, this);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Dialog localDialog = mDialog;
    if (localDialog != null) {
      localDialog.hide();
    }
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    if ((mDialog != null) && (paramBundle != null))
    {
      paramBundle = paramBundle.getBundle("android:savedDialogState");
      if (paramBundle != null) {
        mDialog.onRestoreInstanceState(paramBundle);
      }
    }
  }
  
  void performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.performCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((mView == null) && (mDialog != null) && (paramBundle != null))
    {
      paramLayoutInflater = paramBundle.getBundle("android:savedDialogState");
      if (paramLayoutInflater != null) {
        mDialog.onRestoreInstanceState(paramLayoutInflater);
      }
    }
  }
  
  public final Dialog requireDialog()
  {
    Object localObject = getDialog();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DialogFragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" does not have a Dialog.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    mCancelable = paramBoolean;
    Dialog localDialog = mDialog;
    if (localDialog != null) {
      localDialog.setCancelable(paramBoolean);
    }
  }
  
  public void setShowsDialog(boolean paramBoolean)
  {
    mShowsDialog = paramBoolean;
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    if (FragmentManager.get(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Setting style and theme for DialogFragment ");
      localStringBuilder.append(this);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt2);
      Log.d("FragmentManager", localStringBuilder.toString());
    }
    mStyle = paramInt1;
    if ((paramInt1 == 2) || (paramInt1 == 3)) {
      mTheme = 16973913;
    }
    if (paramInt2 != 0) {
      mTheme = paramInt2;
    }
  }
  
  public void setupDialog(Dialog paramDialog, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        return;
      }
      Window localWindow = paramDialog.getWindow();
      if (localWindow != null) {
        localWindow.addFlags(24);
      }
    }
    paramDialog.requestWindowFeature(1);
  }
  
  public int show(Item paramItem, String paramString)
  {
    mDismissed = false;
    mShownByMe = true;
    paramItem.add(this, paramString);
    mViewDestroyed = false;
    int i = paramItem.commit();
    mBackStackId = i;
    return i;
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    mDismissed = false;
    mShownByMe = true;
    paramFragmentManager = paramFragmentManager.beginTransaction();
    paramFragmentManager.a(true);
    paramFragmentManager.add(this, paramString);
    paramFragmentManager.commit();
  }
  
  public void showNow(FragmentManager paramFragmentManager, String paramString)
  {
    mDismissed = false;
    mShownByMe = true;
    paramFragmentManager = paramFragmentManager.beginTransaction();
    paramFragmentManager.a(true);
    paramFragmentManager.add(this, paramString);
    paramFragmentManager.add();
  }
}
