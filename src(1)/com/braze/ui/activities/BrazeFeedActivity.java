package com.braze.ui.activities;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.fragment.package_11.FragmentActivity;
import com.braze.ui.R.layout;

public class BrazeFeedActivity
  extends BrazeBaseFragmentActivity
{
  public BrazeFeedActivity() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.com_braze_feed_activity);
  }
}
