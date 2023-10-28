package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.package_11.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class SupportFragmentWrapper
  extends IFragmentWrapper.Stub
{
  private Fragment this$0;
  
  private SupportFragmentWrapper(Fragment paramFragment)
  {
    this$0 = paramFragment;
  }
  
  public static SupportFragmentWrapper wrap(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new SupportFragmentWrapper(paramFragment);
    }
    return null;
  }
  
  public final IFragmentWrapper call()
  {
    return wrap(this$0.getParentFragment());
  }
  
  public final IObjectWrapper exec()
  {
    return ObjectWrapper.wrap(this$0.getActivity());
  }
  
  public final IFragmentWrapper get()
  {
    return wrap(this$0.getTargetFragment());
  }
  
  public final Bundle getArguments()
  {
    return this$0.getArguments();
  }
  
  public final boolean getBoolean()
  {
    return this$0.isHidden();
  }
  
  public final int getId()
  {
    return this$0.getId();
  }
  
  public final String getTag()
  {
    return this$0.getTag();
  }
  
  public final int getType()
  {
    return this$0.getTargetRequestCode();
  }
  
  public final boolean goTo()
  {
    return this$0.isResumed();
  }
  
  public final void init(boolean paramBoolean)
  {
    this$0.setHasOptionsMenu(paramBoolean);
  }
  
  public final IObjectWrapper invoke()
  {
    return ObjectWrapper.wrap(this$0.getView());
  }
  
  public final void invoke(Intent paramIntent)
  {
    this$0.startActivity(paramIntent);
  }
  
  public final void invoke(Intent paramIntent, int paramInt)
  {
    this$0.startActivityForResult(paramIntent, paramInt);
  }
  
  public final void invoke(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    Fragment localFragment = this$0;
    Preconditions.checkNotNull(paramIObjectWrapper);
    localFragment.unregisterForContextMenu(paramIObjectWrapper);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    this$0.setRetainInstance(paramBoolean);
  }
  
  public final boolean isAdded()
  {
    return this$0.isAdded();
  }
  
  public final boolean isAlive()
  {
    return this$0.isDetached();
  }
  
  public final boolean isEnabled()
  {
    return this$0.isInLayout();
  }
  
  public final boolean isVisible()
  {
    return this$0.isVisible();
  }
  
  public final IObjectWrapper loadData()
  {
    return ObjectWrapper.wrap(this$0.getResources());
  }
  
  public final void register(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    Fragment localFragment = this$0;
    Preconditions.checkNotNull(paramIObjectWrapper);
    localFragment.registerForContextMenu(paramIObjectWrapper);
  }
  
  public final void setFragment(boolean paramBoolean)
  {
    this$0.setMenuVisibility(paramBoolean);
  }
  
  public final void setTitle(boolean paramBoolean)
  {
    this$0.setUserVisibleHint(paramBoolean);
  }
  
  public final boolean setTitle()
  {
    return this$0.getRetainInstance();
  }
  
  public final boolean showLoadingDialog()
  {
    return this$0.isRemoving();
  }
  
  public final boolean update()
  {
    return this$0.getUserVisibleHint();
  }
}
