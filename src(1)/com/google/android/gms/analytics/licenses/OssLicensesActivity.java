package com.google.android.gms.analytics.licenses;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.package_11.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.package_12.GoogleApi;
import com.google.android.gms.internal.oss_licenses.Server;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;

@KeepForSdk
public final class OssLicensesActivity
  extends AppCompatActivity
{
  private int currentPos = 0;
  private Repository db;
  private String element = "";
  private TextView mEditor = null;
  private Task<String> mTitleView;
  private Server playlist;
  private ScrollView scrollView = null;
  Scope state;
  private Task<String> task;
  
  public OssLicensesActivity() {}
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.libraries_social_licenses_license_loading);
    db = Repository.create(this);
    playlist = ((Server)getIntent().getParcelableExtra("license"));
    if (getSupportActionBar() != null)
    {
      getSupportActionBar().setTitle(playlist.toString());
      getSupportActionBar().setDisplayShowHomeEnabled(true);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setLogo(null);
    }
    paramBundle = new ArrayList();
    Object localObject = db.close();
    localObject = ((GoogleApi)localObject).doRead(new InternalHttpClient((Connection)localObject, playlist));
    mTitleView = ((Task)localObject);
    paramBundle.add(localObject);
    localObject = db.close();
    localObject = ((GoogleApi)localObject).doRead(new Post((Connection)localObject, getPackageName()));
    task = ((Task)localObject);
    paramBundle.add(localObject);
    Tasks.whenAll(paramBundle).addOnCompleteListener(new MainActivity.2(this));
  }
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    currentPos = paramBundle.getInt("scroll_pos");
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    TextView localTextView = mEditor;
    if (localTextView != null)
    {
      if (scrollView == null) {
        return;
      }
      int i = localTextView.getLayout().getLineForVertical(scrollView.getScrollY());
      paramBundle.putInt("scroll_pos", mEditor.getLayout().getLineStart(i));
    }
  }
}
