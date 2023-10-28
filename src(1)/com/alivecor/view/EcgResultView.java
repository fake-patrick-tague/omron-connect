package com.alivecor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alivecor.alivecorkitlite.R.id;
import com.alivecor.alivecorkitlite.R.layout;
import com.alivecor.mapsforge.record.Util;
import com.alivecor.upgrade.AliveCorDevice;
import com.alivecor.upgrade.AliveCorEcg;
import com.alivecor.upgrade.EcgEvaluation;
import com.alivecor.upgrade.LeadConfiguration;
import com.alivecor.upgrade.RecordingConfiguration;
import com.alivecor.upgrade.RecordingDeviceInfo;

public class EcgResultView
  extends FrameLayout
{
  private TextView bpmTxt;
  private View cpomInfo;
  private CpomInfoListener cpomInfoListener;
  private TextView findingTxt;
  private InversionStateListener inversionStateListener;
  private View invertBtn;
  private TextView invertTxt;
  private boolean inverted;
  private View resultBand;
  private RhythmStripView rhythmStripView;
  
  public EcgResultView(Context paramContext)
  {
    super(paramContext);
    initWithAttributes(paramContext, null, 0, 0);
  }
  
  public EcgResultView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initWithAttributes(paramContext, paramAttributeSet, 0, 0);
  }
  
  public EcgResultView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initWithAttributes(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public EcgResultView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    initWithAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void configureEcgView(AliveCorEcg paramAliveCorEcg)
  {
    if (paramAliveCorEcg.getDeviceInfo().getDevice() != AliveCorDevice.TRIANGLE) {
      rhythmStripView.setInverted(paramAliveCorEcg.getEcgEvaluation().isInverted());
    }
    resultBand.setBackgroundResource(paramAliveCorEcg.getEcgEvaluation().getResultColor());
    findingTxt.setText(paramAliveCorEcg.getEcgEvaluation().getAlgorithmResultText());
    TextView localTextView;
    String str;
    if ((paramAliveCorEcg.getEcgEvaluation().getAverageHeartRate() != null) && (paramAliveCorEcg.getEcgEvaluation().getAverageHeartRate().floatValue() > 0.0F))
    {
      localTextView = bpmTxt;
      str = Util.formatHeartRateString(paramAliveCorEcg.getEcgEvaluation().getAverageHeartRate().floatValue());
    }
    else
    {
      localTextView = bpmTxt;
      str = "---";
    }
    localTextView.setText(str);
    cpomInfo.setOnClickListener(new NoteEditor.4(this));
    setViewPerLeadConfig(paramAliveCorEcg);
  }
  
  private void initWithAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.ecg_result_view, this, true);
    rhythmStripView = ((RhythmStripView)paramContext.findViewById(R.id.frag_ecg_result_ecgview));
    resultBand = paramContext.findViewById(R.id.result_view_result_band_with_description);
    findingTxt = ((TextView)paramContext.findViewById(R.id.frag_ecg_result_title));
    cpomInfo = paramContext.findViewById(R.id.frag_ecg_result_determination_info);
    bpmTxt = ((TextView)paramContext.findViewById(R.id.frag_ecg_result_bpm));
    invertBtn = paramContext.findViewById(R.id.frag_ecg_results_invert_container);
    invertTxt = ((TextView)paramContext.findViewById(R.id.frag_ecg_results_invert));
    invertBtn.setOnClickListener(new Switch(this));
  }
  
  private void setViewPerLeadConfig(AliveCorEcg paramAliveCorEcg)
  {
    if (paramAliveCorEcg.getRecordingConfiguration().getLeads() == LeadConfiguration.SINGLE)
    {
      rhythmStripView.getLayoutParams().height = rhythmStripView.getMinimumHeight();
      invertBtn.setVisibility(0);
      boolean bool = paramAliveCorEcg.getEcgEvaluation().isInverted();
      inverted = bool;
      rhythmStripView.setInverted(bool);
      return;
    }
    rhythmStripView.getLayoutParams().height = -1;
    invertBtn.setVisibility(8);
  }
  
  public void setCpomInfoListener(CpomInfoListener paramCpomInfoListener)
  {
    cpomInfoListener = paramCpomInfoListener;
  }
  
  public void setEcgRecord(AliveCorEcg paramAliveCorEcg)
  {
    rhythmStripView.setEcgRecord(paramAliveCorEcg);
    configureEcgView(paramAliveCorEcg);
  }
  
  public void setInversionStateListener(InversionStateListener paramInversionStateListener)
  {
    inversionStateListener = paramInversionStateListener;
  }
  
  public static abstract interface CpomInfoListener
  {
    public abstract void cpomInfoClicked();
  }
  
  public static abstract interface InversionStateListener
  {
    public abstract void inversionChanged(boolean paramBoolean);
  }
}
