package com.alivecor.mapsforge.record;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.package_11.Fragment;
import androidx.fragment.package_11.FragmentActivity;
import androidx.fragment.package_11.FragmentManager;
import androidx.fragment.package_11.Item;
import com.alivecor.alivecorkitlite.R.layout;
import com.alivecor.mapsforge.core.model.YAxisScaleTypes;
import com.alivecor.upgrade.AliveCorDevice;
import com.alivecor.upgrade.AliveCorEcg;
import com.alivecor.upgrade.FilterType;
import com.alivecor.upgrade.LeadConfiguration;
import com.alivecor.upgrade.RecordingConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l.a.a;

abstract class BaseSdkRecordActivity
  extends AppCompatActivity
{
  private static final int DEFAULT_MAX_REC_DURATION = 30;
  private static final int DEFAULT_MIN_REC_DURATION = 10;
  private static final int OPTION_MAINSFREQ_DEFAULT = 50;
  private static final String STATE_ERRORS = "com.alivecor.record.errors";
  private List<com.alivecor.ecg.record.RecordingError> nonfatalErrors;
  RecordEkgFragment recordEKGFragment;
  private RecordEkgListener recordEkgCallback = new RecordEkgListener()
  {
    public void onBPMUpdated(String paramAnonymousString)
    {
      a.a("BPM updated %s", new Object[] { paramAnonymousString });
      BaseSdkRecordActivity.this.onBPMUpdated(paramAnonymousString);
    }
    
    public void onChangeDevice()
    {
      a.a("Inside BaseAliveCorDefaultActivity User clicked change device", new Object[0]);
      recordEKGFragment.removeListener(this);
      BaseSdkRecordActivity.this.onChangeDevice();
      BaseSdkRecordActivity localBaseSdkRecordActivity = BaseSdkRecordActivity.this;
      localBaseSdkRecordActivity.setResult(3, localBaseSdkRecordActivity.createResult(null));
      finish();
    }
    
    public void onLeadConfigUpdated(LeadConfiguration paramAnonymousLeadConfiguration)
    {
      onLeadConfigUpdated();
    }
    
    public void onRecordCompleted(AliveCorEcg paramAnonymousAliveCorEcg)
    {
      Object localObject3 = recordEKGFragment.getArguments();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (recordEKGFragment.getArguments().getSerializable("com.alivecor.ecg.record.HELP_URLS") != null)
        {
          localObject1 = recordEKGFragment;
          try
          {
            localObject1 = ((Fragment)localObject1).getArguments().getSerializable("com.alivecor.ecg.record.HELP_URLS");
            localObject1 = (RecordingHelpUrls)localObject1;
            try
            {
              a.a("onRecordCompleted RecordingHelpUrls %s", new Object[] { localObject1 });
            }
            catch (Exception localException1) {}
          }
          catch (Exception localException2)
          {
            localObject1 = null;
          }
          tmp93_90[0] = localException2.getMessage();
          a.b("IllegalArgumentException for RecordingHelpUrls %s", tmp93_90);
        }
      }
      recordEKGFragment.removeListener(this);
      Iterator localIterator = getSupportFragmentManager().getFragment().iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (Fragment)localIterator.next();
        getSupportFragmentManager().beginTransaction().add((Fragment)localObject3).commit();
      }
      a.a("onRecordComplete: %s", new Object[] { paramAnonymousAliveCorEcg.toString() });
      BaseSdkRecordActivity.this.startResultFragment(paramAnonymousAliveCorEcg, (RecordingHelpUrls)localObject1);
      localObject1 = BaseSdkRecordActivity.this;
      ((Activity)localObject1).setResult(-1, ((BaseSdkRecordActivity)localObject1).createResult(paramAnonymousAliveCorEcg));
      BaseSdkRecordActivity.this.onRecordCompleted(paramAnonymousAliveCorEcg);
    }
    
    public void onRecordError(RecordingError paramAnonymousRecordingError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error in recording for EKG is : ");
      localStringBuilder.append(paramAnonymousRecordingError.toString());
      a.h(localStringBuilder.toString(), new Object[0]);
      nonfatalErrors.add(paramAnonymousRecordingError);
      setResult(0, null);
      BaseSdkRecordActivity.this.onRecordError(paramAnonymousRecordingError);
    }
    
    public void onRecordSettings()
    {
      BaseSdkRecordActivity.this.onRecordSettings();
    }
    
    public void onUserCancel()
    {
      recordEKGFragment.removeListener(this);
      onUserCanceled();
      BaseSdkRecordActivity localBaseSdkRecordActivity = BaseSdkRecordActivity.this;
      localBaseSdkRecordActivity.setResult(0, localBaseSdkRecordActivity.createResult(null));
      finish();
    }
  };
  private ResultEkgListener resultEKGCallback = new ResultEkgListener()
  {
    public void onFailure(ResultError paramAnonymousResultError)
    {
      a.b("Result Component ended with a failure", new Object[0]);
      onResultFail();
    }
    
    public void onSuccess()
    {
      a.a("Result Component ended with a success", new Object[0]);
      Iterator localIterator = getSupportFragmentManager().getFragment().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        getSupportFragmentManager().beginTransaction().add(localFragment).commit();
      }
      onResultComplete();
      finish();
    }
  };
  ResultEkgFragment resultEKGFragment;
  
  BaseSdkRecordActivity() {}
  
  private Intent createResult(AliveCorEcg paramAliveCorEcg)
  {
    paramAliveCorEcg = new RecordActivityResult(paramAliveCorEcg, nonfatalErrors);
    Intent localIntent = new Intent();
    localIntent.putExtra("com.alivecor.ecg.record.result", paramAliveCorEcg);
    return localIntent;
  }
  
  private void showRecordFragmentIfNotShown()
  {
    try
    {
      Object localObject1 = getSupportFragmentManager().findFragmentById(16908290);
      if ((localObject1 instanceof RecordEkgFragment))
      {
        a.d("showRecordFragmentIfNotShown: Already shown", new Object[0]);
        localObject1 = getSupportFragmentManager().findFragmentById(16908290);
        recordEKGFragment = ((RecordEkgFragment)localObject1);
      }
      else
      {
        localObject1 = getIntent().getSerializableExtra("com.alivecor.ecg.record.EXTRA_RECORDING_FILTER_TYPE");
        if (localObject1 != null)
        {
          localObject1 = getIntent().getSerializableExtra("com.alivecor.ecg.record.EXTRA_RECORDING_FILTER_TYPE");
          localObject1 = (FilterType)localObject1;
        }
        else
        {
          localObject1 = FilterType.ORIGINAL;
        }
        localObject2 = getIntent().getSerializableExtra("com.alivecor.ecg.record.EXTRA_PDF_REPORT_RAW");
        if (localObject2 != null)
        {
          localObject2 = getIntent().getSerializableExtra("com.alivecor.ecg.record.EXTRA_PDF_REPORT_RAW");
          localObject2 = (ReportRawPDFType)localObject2;
        }
        else
        {
          localObject2 = ReportRawPDFType.ORIGINAL;
        }
        Object localObject3 = getIntent().getSerializableExtra("com.alivecor.ecg.record.EXTRA_Y_AXIS_SCALE");
        if (localObject3 != null)
        {
          localObject3 = getIntent().getSerializableExtra("com.alivecor.ecg.record.EXTRA_Y_AXIS_SCALE");
          localObject3 = (YAxisScaleTypes)localObject3;
        }
        else
        {
          localObject3 = YAxisScaleTypes.Y_AXIS_SCALE_10;
        }
        Object localObject4 = null;
        Object localObject5 = getIntent().getStringExtra("com.alivecor.ecg.record.EXTRA_LEADS_CONFIG");
        if (localObject5 != null) {
          localObject4 = LeadConfiguration.valueOf(getIntent().getStringExtra("com.alivecor.ecg.record.EXTRA_LEADS_CONFIG"));
        }
        localObject5 = AliveCorDevice.valueOf(getIntent().getStringExtra("com.alivecor.ecg.record.device"));
        a.a("device", new Object[0]);
        localObject4 = new RecordingConfiguration((AliveCorDevice)localObject5, (LeadConfiguration)localObject4);
        ((RecordingConfiguration)localObject4).setMainsFrequency(getIntent().getIntExtra("com.alivecor.ecg.record.EXTRA_RECORDING_FREQUENCY", 50));
        ((RecordingConfiguration)localObject4).setResetDurationSeconds(getIntent().getIntExtra("com.alivecor.ecg.record.EXTRA_RECORDING_MIN_DURATIONS", 10));
        ((RecordingConfiguration)localObject4).setMaxDurationSeconds(getIntent().getIntExtra("com.alivecor.ecg.record.EXTRA_RECORDING_MAX_DURATIONS", 30));
        ((RecordingConfiguration)localObject4).setFilterType((FilterType)localObject1);
        ((RecordingConfiguration)localObject4).setReportRawPDF((ReportRawPDFType)localObject2);
        ((RecordingConfiguration)localObject4).setyAxisScaleTypes((YAxisScaleTypes)localObject3);
        localObject1 = RecordEkgFragment.newInstance((RecordingConfiguration)localObject4);
        recordEKGFragment = ((RecordEkgFragment)localObject1);
        localObject1 = getSupportFragmentManager().beginTransaction();
        localObject2 = recordEKGFragment;
        ((Item)localObject1).add(16908290, (Fragment)localObject2).commit();
      }
      localObject1 = recordEKGFragment;
      Object localObject2 = recordEkgCallback;
      ((RecordEkgFragment)localObject1).addListener((RecordEkgListener)localObject2);
      return;
    }
    catch (InvalidArgumentException localInvalidArgumentException)
    {
      a.c(localInvalidArgumentException, "Recording could not be started!", new Object[0]);
      finish();
    }
  }
  
  private void startResultFragment(AliveCorEcg paramAliveCorEcg, RecordingHelpUrls paramRecordingHelpUrls)
  {
    try
    {
      Fragment localFragment = getSupportFragmentManager().findFragmentById(16908290);
      if ((localFragment instanceof ResultEkgFragment))
      {
        a.d("startResultFragment: Already started", new Object[0]);
        paramAliveCorEcg = getSupportFragmentManager().findFragmentById(16908290);
        resultEKGFragment = ((ResultEkgFragment)paramAliveCorEcg);
      }
      else
      {
        paramAliveCorEcg = ResultEkgFragment.newInstance(paramAliveCorEcg, paramRecordingHelpUrls);
        resultEKGFragment = paramAliveCorEcg;
        paramAliveCorEcg = getSupportFragmentManager().beginTransaction();
        paramRecordingHelpUrls = resultEKGFragment;
        paramAliveCorEcg.add(16908290, paramRecordingHelpUrls).commit();
      }
      paramAliveCorEcg = resultEKGFragment;
      paramRecordingHelpUrls = resultEKGCallback;
      paramAliveCorEcg.addListener(paramRecordingHelpUrls);
      return;
    }
    catch (InvalidArgumentException paramAliveCorEcg)
    {
      a.c(paramAliveCorEcg, "Result Fragment could not be started!", new Object[0]);
      finish();
    }
  }
  
  protected void onBPMUpdated(String paramString) {}
  
  protected void onChangeDevice() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_record_ekg);
    if (getIntent().hasExtra("com.alivecor.ecg.record.device"))
    {
      if (paramBundle != null)
      {
        Object localObject;
        if ((getSupportFragmentManager().findFragmentById(16908290) instanceof RecordEkgFragment))
        {
          localObject = (RecordEkgFragment)getSupportFragmentManager().findFragmentById(16908290);
          recordEKGFragment = ((RecordEkgFragment)localObject);
          ((RecordEkgFragment)localObject).addListener(recordEkgCallback);
        }
        if ((getSupportFragmentManager().findFragmentById(16908290) instanceof ResultEkgFragment))
        {
          localObject = (ResultEkgFragment)getSupportFragmentManager().findFragmentById(16908290);
          resultEKGFragment = ((ResultEkgFragment)localObject);
          ((ResultEkgFragment)localObject).addListener(resultEKGCallback);
        }
        paramBundle = paramBundle.getStringArrayList("com.alivecor.record.errors");
        nonfatalErrors = new ArrayList();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            localObject = (String)paramBundle.next();
            nonfatalErrors.add(RecordingError.fromValue((String)localObject));
          }
        }
      }
      else
      {
        nonfatalErrors = new ArrayList();
        showRecordFragmentIfNotShown();
      }
    }
    else {
      throw new IllegalArgumentException(String.format("Missing required intent extra: %s", new Object[] { "com.alivecor.ecg.record.device" }));
    }
  }
  
  protected void onLeadConfigUpdated() {}
  
  protected void onRecordCompleted(AliveCorEcg paramAliveCorEcg) {}
  
  protected void onRecordError(RecordingError paramRecordingError) {}
  
  protected void onRecordSettings() {}
  
  protected void onResultComplete() {}
  
  protected void onResultFail() {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = nonfatalErrors.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((RecordingError)localIterator.next()).name());
    }
    paramBundle.putStringArrayList("com.alivecor.record.errors", localArrayList);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onUserCanceled() {}
}
