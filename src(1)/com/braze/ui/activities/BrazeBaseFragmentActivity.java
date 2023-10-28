package com.braze.ui.activities;

import androidx.fragment.package_11.FragmentActivity;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.BrazeInAppMessageManager.Companion;

public class BrazeBaseFragmentActivity
  extends FragmentActivity
{
  public BrazeBaseFragmentActivity() {}
  
  public void onPause()
  {
    super.onPause();
    BrazeInAppMessageManager.Companion.getInstance().unregisterInAppMessageManager(this);
  }
  
  public void onResume()
  {
    super.onResume();
    BrazeInAppMessageManager.Companion.getInstance().registerInAppMessageManager(this);
  }
  
  public void onStart()
  {
    super.onStart();
    Braze.Companion.getInstance(this).openSession(this);
  }
  
  public void onStop()
  {
    super.onStop();
    Braze.Companion.getInstance(this).closeSession(this);
  }
}
