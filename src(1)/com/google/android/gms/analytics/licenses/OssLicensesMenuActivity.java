package com.google.android.gms.analytics.licenses;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.g;
import androidx.fragment.package_11.FragmentActivity;
import androidx.loader.content.Loader;
import c.p.a.a.a;
import com.google.android.gms.common.package_12.GoogleApi;
import com.google.android.gms.internal.oss_licenses.Server;
import com.google.android.gms.internal.oss_licenses.zzc;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.List;
import v7.v13.app.LoaderManager;

public final class OssLicensesMenuActivity
  extends g
  implements a.a<List<zzc>>
{
  private static String mPlaylistName;
  private Scope ONLY;
  private ArrayAdapter<zzc> arrayAdapter;
  private ListView mListView;
  private Repository post;
  private boolean zzaa;
  private Task<String> zzab;
  
  public OssLicensesMenuActivity() {}
  
  /* Error */
  static boolean fileExistsAndNotEmpty(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 9
    //   8: aconst_null
    //   9: astore 7
    //   11: aload 7
    //   13: astore 6
    //   15: aload 8
    //   17: astore 4
    //   19: aload 9
    //   21: astore 5
    //   23: aload_0
    //   24: invokevirtual 56	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   27: astore_0
    //   28: getstatic 62	com/google/android/gms/analytics/licenses/R$id:license_list	I
    //   31: istore_2
    //   32: aload 7
    //   34: astore 6
    //   36: aload 8
    //   38: astore 4
    //   40: aload 9
    //   42: astore 5
    //   44: aload_0
    //   45: aload_0
    //   46: aload_1
    //   47: ldc 64
    //   49: aload_0
    //   50: iload_2
    //   51: invokevirtual 70	android/content/res/Resources:getResourcePackageName	(I)Ljava/lang/String;
    //   54: invokevirtual 74	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   57: invokevirtual 78	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_0
    //   64: astore 6
    //   66: aload_0
    //   67: astore 4
    //   69: aload_0
    //   70: astore 5
    //   72: aload_1
    //   73: invokevirtual 84	java/io/InputStream:available	()I
    //   76: istore_2
    //   77: iload_2
    //   78: ifle +5 -> 83
    //   81: iconst_1
    //   82: istore_3
    //   83: aload_1
    //   84: invokevirtual 87	java/io/InputStream:close	()V
    //   87: iload_3
    //   88: ireturn
    //   89: astore_0
    //   90: aload 6
    //   92: ifnull +8 -> 100
    //   95: aload 6
    //   97: invokevirtual 87	java/io/InputStream:close	()V
    //   100: aload_0
    //   101: athrow
    //   102: aload 4
    //   104: ifnull +30 -> 134
    //   107: aload 4
    //   109: invokevirtual 87	java/io/InputStream:close	()V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_0
    //   115: goto -13 -> 102
    //   118: astore_0
    //   119: aload 5
    //   121: astore 4
    //   123: goto -21 -> 102
    //   126: astore_0
    //   127: iload_3
    //   128: ireturn
    //   129: astore_1
    //   130: goto -30 -> 100
    //   133: astore_0
    //   134: iconst_0
    //   135: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramContext	Context
    //   0	136	1	paramString	String
    //   31	47	2	i	int
    //   1	127	3	bool	boolean
    //   17	105	4	localObject1	Object
    //   21	99	5	localObject2	Object
    //   13	83	6	localObject3	Object
    //   9	24	7	localObject4	Object
    //   3	34	8	localObject5	Object
    //   6	35	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   23	28	89	java/lang/Throwable
    //   44	61	89	java/lang/Throwable
    //   72	77	89	java/lang/Throwable
    //   23	28	114	android/content/res/Resources$NotFoundException
    //   44	61	114	android/content/res/Resources$NotFoundException
    //   72	77	114	android/content/res/Resources$NotFoundException
    //   23	28	118	java/io/IOException
    //   44	61	118	java/io/IOException
    //   72	77	118	java/io/IOException
    //   83	87	126	java/io/IOException
    //   95	100	129	java/io/IOException
    //   107	112	133	java/io/IOException
  }
  
  public static void setActivityTitle(String paramString)
  {
    mPlaylistName = paramString;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    post = Repository.create(this);
    boolean bool;
    if ((fileExistsAndNotEmpty(this, "third_party_licenses")) && (fileExistsAndNotEmpty(this, "third_party_license_metadata"))) {
      bool = true;
    } else {
      bool = false;
    }
    zzaa = bool;
    if (mPlaylistName == null)
    {
      paramBundle = getIntent();
      if (paramBundle.hasExtra("title"))
      {
        mPlaylistName = paramBundle.getStringExtra("title");
        Log.w("OssLicensesMenuActivity", "The intent based title is deprecated. Use OssLicensesMenuActivity.setActivityTitle(title) instead.");
      }
    }
    paramBundle = mPlaylistName;
    if (paramBundle != null) {
      setTitle(paramBundle);
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    if (zzaa)
    {
      paramBundle = Repository.create(this).close();
      zzab = paramBundle.doRead(new MinimalHttpClient(paramBundle, getPackageName()));
      getSupportLoaderManager().initLoader(54321, null, this);
      zzab.addOnCompleteListener(new LoginActivity.1(this));
      return;
    }
    setContentView(R.layout.license_menu_activity_no_licenses);
  }
  
  public final Loader onCreateLoader(int paramInt, Bundle paramBundle)
  {
    if (zzaa) {
      return new CursorLoader(this, Repository.create(this));
    }
    return null;
  }
  
  public final void onDestroy()
  {
    getSupportLoaderManager().destroyLoader(54321);
    super.onDestroy();
  }
  
  public final void onLoadFinished(Loader paramLoader, List paramList)
  {
    arrayAdapter.clear();
    arrayAdapter.addAll(paramList);
    arrayAdapter.notifyDataSetChanged();
  }
  
  public final void onLoaderReset(Loader paramLoader)
  {
    arrayAdapter.clear();
    arrayAdapter.notifyDataSetChanged();
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
  
  final class zza
    extends ArrayAdapter<zzc>
  {
    zza(Context paramContext)
    {
      super(i, Repository.get(OssLicensesMenuActivity.valueOf(OssLicensesMenuActivity.this)), new ArrayList());
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject = paramView;
      if (paramView == null)
      {
        OssLicensesMenuActivity.isImportant(OssLicensesMenuActivity.this);
        paramView = getLayoutInflater();
        localObject = OssLicensesMenuActivity.valueOf(OssLicensesMenuActivity.this);
        localObject = paramView.inflate(this$0.getXml(Repository.getId((Scope)localObject)), paramViewGroup, false);
      }
      OssLicensesMenuActivity.isImportant(OssLicensesMenuActivity.this);
      ((TextView)((View)localObject).findViewById(Repository.get(OssLicensesMenuActivity.valueOf(OssLicensesMenuActivity.this)))).setText(((Server)getItem(paramInt)).toString());
      return localObject;
    }
  }
}
