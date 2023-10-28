package com.alivecor.mapsforge.record;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.BaseBundle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.package_11.Fragment;
import androidx.lifecycle.ClassReader;
import com.alivecor.ai.o;
import com.alivecor.alivecorkitlite.R.color;
import com.alivecor.alivecorkitlite.R.id;
import com.alivecor.alivecorkitlite.R.layout;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.asm.Priority;
import com.alivecor.mapsforge.core.model.Direction;
import com.alivecor.mapsforge.core.model.c;
import io.reactivex.v.b;
import java.util.Collections;
import java.util.Map;
import l.a.a;

abstract class FragEcgResults
  extends Fragment
{
  protected static final String ARG_RESULT = "com.alivecor.ecg.result";
  protected static final String ARG_SHOW_TOP_BAR = "com.alivecor.ecg.showTopBar";
  private static final Map<o, Uri> LEARN_MORE_URIS = Collections.unmodifiableMap(Util.createMap(new Object[] { Priority.E, Uri.parse("https://alivecor.com/app-redirect/learnmore_normal"), Priority.W, Uri.parse("https://alivecor.com/app-redirect/learnmore_possafib"), Priority.PURCHASED, Uri.parse("https://alivecor.com/app-redirect/learnmore_unclassified"), Priority.CANCELLED, Uri.parse("https://alivecor.com/app-redirect/learnmore_bradycardia"), Priority.ERRORED, Uri.parse("https://alivecor.com/app-redirect/learnmore_tachycardia"), Priority.Low, Uri.parse("https://alivecor.com/app-redirect/learnmore_unreadable") }));
  private static final boolean debug = true;
  AppPreferences appPreferences;
  private View bottomViewLayout;
  private View btnDone;
  private View btnInvert;
  private View btnLearnMore;
  protected Context context;
  private boolean dialogCompleted;
  private EcgStripView ecgStripView;
  private View headerView;
  private ImageView imgViewDeterminationInfo;
  private View invertedDesc;
  private boolean invertedSetManually = false;
  private View moreOptionsDownLayout;
  private View moreOptionsUpLayout;
  RecordDependencyComponent recordDependencyComponent;
  private ResultDetail recordResult;
  private c recordingDevice;
  private boolean showDialogOnCreateRestore;
  private boolean showOveread;
  private boolean showTopBar;
  private TextView txtBPM;
  private TextView txtDesc;
  private TextView txtDisclaimer;
  private TextView txtInvert;
  private TextView txtInvertLabel;
  private TextView txtResult;
  private b uploadEventSubsctription;
  private ResultEKGViewModel viewModel;
  private View viewResultBand;
  
  FragEcgResults() {}
  
  private String getLearnMoreUrls(Priority paramPriority)
  {
    String str1;
    if ((viewModel.getRecordResultUrls() != null) && (viewModel.getRecordResultUrls().getRecordingResultHelpLinks() != null))
    {
      String str2 = viewModel.getRecordResultUrls().getRecordingResultHelpLinks().getMatchingRule(paramPriority);
      str1 = str2;
      if (str2 != null) {}
    }
    else
    {
      str1 = null;
    }
    a.a("learnMore %s", new Object[] { str1 });
    if (str1 == null)
    {
      paramPriority = (Uri)LEARN_MORE_URIS.get(paramPriority);
      if (paramPriority != null) {
        return paramPriority.toString();
      }
    }
    return str1;
  }
  
  private void getRecordingResult()
  {
    Object localObject;
    if (viewModel.getRecordResult() == null)
    {
      localObject = (ResultDetail)getArguments().getSerializable("com.alivecor.ecg.result");
      recordResult = ((ResultDetail)localObject);
      viewModel.setRecordResult((ResultDetail)localObject);
    }
    else
    {
      recordResult = viewModel.getRecordResult();
    }
    recordingDevice = viewModel.getRecordingDevice();
    if (getArguments() != null)
    {
      if (getArguments().getSerializable("com.alivecor.ecg.record.HELP_URLS") != null) {
        try
        {
          localObject = getArguments().getSerializable("com.alivecor.ecg.record.HELP_URLS");
          localObject = (RecordingHelpUrls)localObject;
          ResultEKGViewModel localResultEKGViewModel = viewModel;
          localResultEKGViewModel.setRecordResultUrls((RecordingHelpUrls)localObject);
          return;
        }
        catch (Exception localException)
        {
          a.b("Can not get RecordingHelpUrls. %s", new Object[] { localException.getMessage() });
          return;
        }
      }
      a.b("Can not get RecordingHelpUrls. EXTRA_HELP_URLS is null", new Object[0]);
    }
  }
  
  private void hideTopBarIfNesc()
  {
    boolean bool = requireArguments().getBoolean("com.alivecor.ecg.showTopBar", true);
    showTopBar = bool;
    if (!bool) {
      headerView.setVisibility(8);
    }
  }
  
  private void setEcgView()
  {
    if (recordingDevice != c.deviceList)
    {
      ecgStripView.setInvertedECG(recordResult.isInverted());
      bottomViewLayout.setVisibility(0);
      moreOptionsDownLayout.setVisibility(8);
    }
    setViewPerLeadConfig();
    ecgStripView.setEcgRecord(recordResult.getLocalRecordingID(), recordResult.isInverted(), AsyncTask.THREAD_POOL_EXECUTOR);
  }
  
  private void setViewPerLeadConfig()
  {
    if (recordResult.getLeadsConfig() == Direction.S)
    {
      ecgStripView.getLayoutParams().height = ecgStripView.getMinimumHeight();
      moreOptionsDownLayout.setVisibility(8);
      bottomViewLayout.setVisibility(0);
      moreOptionsUpLayout.setVisibility(8);
      return;
    }
    ecgStripView.getLayoutParams().height = -1;
    invertedDesc.setVisibility(8);
    moreOptionsDownLayout.setVisibility(8);
    bottomViewLayout.setVisibility(0);
  }
  
  private void showBpmAndDetermination()
  {
    if (recordResult.getKaiResult() == null)
    {
      a.h("showBpmAndDetermination: No Determination for ecg record: %s", new Object[] { recordResult });
      a.b("Unexpectedly arrived at ECG Results without a determination", new Object[0]);
      return;
    }
    Object localObject2 = recordResult.getKaiResult();
    Object localObject1 = getLearnMoreUrls((Priority)localObject2);
    if (localObject1 != null)
    {
      btnLearnMore.setOnClickListener(new Window.4(this, (String)localObject1));
      btnLearnMore.setVisibility(0);
    }
    else
    {
      btnLearnMore.setVisibility(8);
    }
    txtResult.setText(Util.getEcgAnalysisTag((Priority)localObject2));
    localObject1 = RecordEkgConfig.getDB().getAppName();
    if (localObject2 == Priority.Normal)
    {
      a.a("onCreateView() result: is short", new Object[0]);
      viewResultBand.setBackgroundColor(getResources().getColor(R.color.analysis_none));
      txtResult.setTextColor(getResources().getColor(R.color.text_color_dark));
      localObject1 = txtDesc;
    }
    for (int i = R.string.short_detected_short_text;; i = R.string.long_detected_result_text)
    {
      ((TextView)localObject1).setText(i);
      break label777;
      if (localObject2 != Priority.High) {
        break;
      }
      a.a("onCreateView() result: is long", new Object[0]);
      viewResultBand.setBackgroundColor(getResources().getColor(R.color.analysis_none));
      txtResult.setTextColor(getResources().getColor(R.color.text_color_dark));
      localObject1 = txtDesc;
    }
    if (localObject2 == Priority.Low)
    {
      a.a("onCreateView() result: noise", new Object[0]);
      viewResultBand.setBackgroundColor(getResources().getColor(R.color.analysis_none));
      txtResult.setTextColor(getResources().getColor(R.color.text_color_dark));
      txtDesc.setText(R.string.noise_detected_short_text);
      localObject2 = txtDisclaimer;
      localObject1 = getString(R.string.nsr_disclaimer, new Object[] { localObject1 });
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      break;
      if (localObject2 == Priority.W)
      {
        a.a("onCreateView() result: afib", new Object[0]);
        viewResultBand.setBackgroundColor(getResources().getColor(R.color.analysis_severe));
        txtDesc.setText(R.string.af_detected_text);
        localObject2 = txtDisclaimer;
        localObject1 = getString(R.string.nsr_disclaimer, new Object[] { localObject1 });
      }
      else if (localObject2 == Priority.E)
      {
        a.a("onCreateView() result: nsr", new Object[0]);
        viewResultBand.setBackgroundColor(getResources().getColor(R.color.analysis_normal));
        txtDesc.setText(R.string.nsr_detected_text);
        localObject2 = txtDisclaimer;
        localObject1 = getString(R.string.nsr_disclaimer, new Object[] { localObject1 });
      }
      else if (localObject2 == Priority.CANCELLED)
      {
        a.a("onCreateView() result: bradycaria", new Object[0]);
        viewResultBand.setBackgroundColor(getResources().getColor(R.color.analysis_warning));
        txtDesc.setText(R.string.bradycardia_detected_text);
        localObject2 = txtDisclaimer;
        localObject1 = getString(R.string.nsr_disclaimer, new Object[] { localObject1 });
      }
      else if (localObject2 == Priority.ERRORED)
      {
        a.a("onCreateView() result: tachycardia", new Object[0]);
        viewResultBand.setBackgroundColor(getResources().getColor(R.color.analysis_warning));
        txtDesc.setText(R.string.tachycardia_detected_text);
        localObject2 = txtDisclaimer;
        localObject1 = getString(R.string.nsr_disclaimer, new Object[] { localObject1 });
      }
      else
      {
        if (localObject2 == Priority.PURCHASED)
        {
          a.a("onCreateView() result: (unclassified)", new Object[0]);
          if ("AlgSuite".equals(appPreferences.getEKGClassifier()))
          {
            txtDesc.setText(R.string.undetermined_text);
          }
          else
          {
            txtDesc.setText(R.string.undetermined_text_kardia_ai);
            txtDisclaimer.setText(getString(R.string.nsr_disclaimer, new Object[] { localObject1 }));
          }
          viewResultBand.setBackgroundColor(getResources().getColor(R.color.analysis_warning));
          break;
        }
        a.h("Unrecognized determination: %s", new Object[] { localObject2 });
        txtDesc.setVisibility(8);
        btnLearnMore.setVisibility(8);
        viewResultBand.setBackgroundColor(getResources().getColor(R.color.analysis_none));
        txtResult.setTextColor(getResources().getColor(R.color.text_color_dark));
        localObject2 = txtDesc;
        localObject1 = null;
      }
    }
    label777:
    if (recordResult.getBpm() > 0.0F)
    {
      localObject2 = txtBPM;
      localObject1 = Util.formatHeartRateString(recordResult.getBpm());
    }
    else
    {
      a.h("HR was 0.  Showing the dashes.", new Object[0]);
      localObject2 = txtBPM;
      localObject1 = "---";
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
  }
  
  protected void finish() {}
  
  protected ResultEKGViewModel getResultViewModel()
  {
    return viewModel;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    viewModel = ((ResultEKGViewModel)new ClassReader(requireActivity()).a(com.alivecor.ecg.record.ResultEKGViewModel.class));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.frag_ecg_results, paramViewGroup, false);
    paramLayoutInflater.setOnTouchListener(Vector3.Zero);
    paramViewGroup = RecordEkgConfig.getDB().getRecordDependencyComponent();
    recordDependencyComponent = paramViewGroup;
    paramViewGroup.inject(this);
    viewResultBand = paramLayoutInflater.findViewById(R.id.result_screen_result_band_with_description);
    txtResult = ((TextView)paramLayoutInflater.findViewById(R.id.frag_ecg_result_title));
    imgViewDeterminationInfo = ((ImageView)paramLayoutInflater.findViewById(R.id.frag_ecg_result_determination_info));
    txtDesc = ((TextView)paramLayoutInflater.findViewById(R.id.frag_ecg_result_description));
    txtDisclaimer = ((TextView)paramLayoutInflater.findViewById(R.id.frag_ecg_result_disclaimer));
    txtBPM = ((TextView)paramLayoutInflater.findViewById(R.id.frag_ecg_result_bpm));
    txtInvert = ((TextView)paramLayoutInflater.findViewById(R.id.frag_ecg_results_invert));
    txtInvertLabel = ((TextView)paramLayoutInflater.findViewById(R.id.frag_ecg_results_invert_label));
    int i = R.id.frag_ecg_results_invert_container;
    btnInvert = paramLayoutInflater.findViewById(i);
    headerView = paramLayoutInflater.findViewById(R.id.frag_ecg_results_header_bar);
    btnLearnMore = paramLayoutInflater.findViewById(R.id.frag_ecg_result_learn_more);
    invertedDesc = paramLayoutInflater.findViewById(i);
    bottomViewLayout = paramLayoutInflater.findViewById(R.id.bottom_view_layout);
    moreOptionsUpLayout = paramLayoutInflater.findViewById(R.id.more_options_up_layout);
    paramViewGroup = paramLayoutInflater.findViewById(R.id.more_options_down_layout);
    moreOptionsDownLayout = paramViewGroup;
    paramViewGroup.setOnClickListener(new OCFileListFragment.1(this));
    moreOptionsUpLayout.setOnClickListener(new SslUntrustedCertDialog.OnCertificateNotTrusted(this));
    paramViewGroup = (EcgStripView)paramLayoutInflater.findViewById(R.id.frag_ecg_result_ecgview);
    ecgStripView = paramViewGroup;
    paramViewGroup.setDrawEdgeEffect(false);
    imgViewDeterminationInfo.setOnClickListener(new FragEcgResults.1(this));
    btnInvert.setOnClickListener(new e(this));
    paramViewGroup = paramLayoutInflater.findViewById(R.id.frag_ecg_result_done);
    btnDone = paramViewGroup;
    paramViewGroup.setOnClickListener(new OCFileListFragment.3(this));
    hideTopBarIfNesc();
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    refreshView();
    getView().setFocusableInTouchMode(true);
    getView().requestFocus();
    Util.setStatusBarColor(getActivity().getWindow(), getResources().getColor(R.color.gray_statusbar));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume() showDialogOnCreateRestore: ");
    localStringBuilder.append(showDialogOnCreateRestore);
    localStringBuilder.append(", dialogComplete: ");
    localStringBuilder.append(dialogCompleted);
    a.a(localStringBuilder.toString(), new Object[0]);
    showDialogOnCreateRestore = false;
  }
  
  public void onStart()
  {
    super.onStart();
    getRecordingResult();
    hideTopBarIfNesc();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  protected void refreshView()
  {
    showBpmAndDetermination();
    setEcgView();
    if (recordResult.getLeadsConfig() == Direction.W)
    {
      btnInvert.setVisibility(8);
      return;
    }
    TextView localTextView;
    int i;
    if ((recordResult.isInverted()) && (!invertedSetManually))
    {
      txtInvertLabel.setText(R.string.ecg_results_invert_auto);
      localTextView = txtInvert;
      i = R.string.ecg_results_invert_undo;
    }
    for (;;)
    {
      localTextView.setText(i);
      return;
      txtInvertLabel.setText(R.string.ecg_results_invert);
      localTextView = txtInvert;
      if (recordResult.isInverted()) {
        i = R.string.ecg_results_invert_on;
      } else {
        i = R.string.ecg_results_invert_off;
      }
    }
  }
}
