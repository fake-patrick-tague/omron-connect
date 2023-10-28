package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class LogViewerFragment
  implements Object
{
  LogViewerFragment(DeferredLifecycleHelper paramDeferredLifecycleHelper, FrameLayout paramFrameLayout, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {}
  
  public final void onCreateView(LifecycleDelegate paramLifecycleDelegate)
  {
    mLayout.removeAllViews();
    mLayout.addView(DeferredLifecycleHelper.instantiate(mContext).onCreateView(mInflater, mRootView, mListView));
  }
  
  public final int type()
  {
    return 2;
  }
}
