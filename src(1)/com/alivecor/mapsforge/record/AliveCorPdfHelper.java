package com.alivecor.mapsforge.record;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog.Builder;
import com.alivecor.alivecorkitlite.R.dimen;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.asm.Priority;
import com.alivecor.mapsforge.core.model.YAxisScaleTypes;
import com.alivecor.upgrade.AliveCorEcg;
import com.alivecor.upgrade.EcgEvaluation;
import com.alivecor.upgrade.FilterType;
import com.alivecor.upgrade.RecordingConfiguration;
import java.io.File;
import java.util.Locale;
import k.a.a.b;
import k.a.a.f;
import l.a.a;

public class AliveCorPdfHelper
{
  private static final int MAXIMUM_POSSIBLE_TIMEZONE_OFFSET_SEC = 50400;
  private Context appContext;
  private final RecordSdkHelper mapper;
  private ReportRawPDFType reportRawPDFType = ReportRawPDFType.ORIGINAL;
  private boolean withConfig = false;
  private YAxisScaleTypes yAxisScaleTypes = YAxisScaleTypes.Y_AXIS_SCALE_10;
  
  protected AliveCorPdfHelper(Context paramContext)
  {
    appContext = paramContext.getApplicationContext();
    mapper = new RecordSdkHelper(RecordEkgConfig.getDB());
  }
  
  private PdfData createPdfData(AliveCorEcg paramAliveCorEcg, Size paramSize, File paramFile, String paramString1, PatientInfo paramPatientInfo, String paramString2, String paramString3)
  {
    Object localObject1 = paramAliveCorEcg.getRecordingConfiguration();
    EcgEvaluation localEcgEvaluation = paramAliveCorEcg.getEcgEvaluation();
    Object localObject2 = null;
    if (paramPatientInfo != null)
    {
      paramFile = patientDobMillis;
      if (paramFile != null) {
        l = paramFile.longValue();
      } else {
        l = Long.MIN_VALUE;
      }
      paramFile = new PdfData.PatientData(firstName, lastName, l);
    }
    else
    {
      paramFile = null;
    }
    ReportRawPDFType localReportRawPDFType;
    if (withConfig) {
      localReportRawPDFType = reportRawPDFType;
    } else {
      localReportRawPDFType = ((RecordingConfiguration)localObject1).isReportRawPDF();
    }
    boolean bool;
    if (((!withConfig) || (localReportRawPDFType != ReportRawPDFType.FULL)) && (((RecordingConfiguration)localObject1).getFilterType() == FilterType.ENHANCED)) {
      bool = true;
    } else {
      bool = false;
    }
    if (withConfig) {
      localObject1 = yAxisScaleTypes;
    } else {
      localObject1 = ((RecordingConfiguration)localObject1).getyAxisScaleTypes();
    }
    String str1 = RecordEkgConfig.getDB().getAppName();
    String str2 = paramAliveCorEcg.getUuid();
    b localB = fromRawData(paramAliveCorEcg.getRecordedAtMs(), f.s().A(paramAliveCorEcg.getRecordedAtMs()));
    if (paramSize == Size.LETTER) {
      paramSize = PdfData.PaperSize.LETTER;
    } else {
      paramSize = PdfData.PaperSize.LEGAL;
    }
    float f;
    if (localEcgEvaluation.getAverageHeartRate() != null) {
      f = localEcgEvaluation.getAverageHeartRate().floatValue();
    } else {
      f = 0.0F;
    }
    Priority localPriority = mapper.internalDetermination(localEcgEvaluation.getDetermination());
    long l = paramAliveCorEcg.getDurationMs();
    paramAliveCorEcg = localObject2;
    if (paramPatientInfo != null) {
      paramAliveCorEcg = patientId;
    }
    return new PdfData(str1, str2, bool, localB, paramFile, paramSize, paramString1, f, localPriority, l, paramString2, paramString3, paramAliveCorEcg, localEcgEvaluation.isInverted(), localReportRawPDFType, (YAxisScaleTypes)localObject1);
  }
  
  private static b fromRawData(long paramLong, int paramInt)
  {
    int i = paramInt;
    if (Math.abs(paramInt) <= 50400) {
      i = paramInt * 1000;
    }
    return new b(paramLong).Q(f.i(i));
  }
  
  private void showEncryptionPromptDialog(Activity paramActivity, AliveCorEcg paramAliveCorEcg, Size paramSize, File paramFile, String paramString1, PatientInfo paramPatientInfo, String paramString2, String paramString3, PdfListener paramPdfListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      EditText localEditText = new EditText(paramActivity);
      localEditText.setHint(R.string.lbl_password);
      localEditText.setInputType(129);
      FrameLayout localFrameLayout = new FrameLayout(paramActivity);
      int i = paramActivity.getResources().getDimensionPixelSize(R.dimen.password_dialog_side_padding);
      localFrameLayout.setPadding(i, 0, i, 0);
      localFrameLayout.addView(localEditText, new FrameLayout.LayoutParams(-1, -2, 17));
      paramActivity = new AlertDialog.Builder(paramActivity).setPositiveButton(R.string.encrypt_pdf_title).setNegativeButton(R.string.encrypt_pdf_msg).setView(localFrameLayout).setOnCancelListener(VolumeDialog.mManager).setPositiveButton(R.string.next, new l(this, localEditText, paramAliveCorEcg, paramSize, paramFile, paramString1, paramPatientInfo, paramString2, paramString3, paramPdfListener));
      if (paramBoolean2) {
        paramActivity.setNegativeButton(17039360, Action.cancel);
      } else {
        paramActivity.setNegativeButton(R.string.skip, new g(this, paramAliveCorEcg, paramSize, paramFile, paramString1, paramPatientInfo, paramString2, paramString3, paramPdfListener));
      }
      paramActivity = paramActivity.create();
      localEditText.addTextChangedListener(new AliveCorPdfHelper.1(this, paramActivity));
      paramActivity.setOnShowListener(new LicensesDialog.3(paramActivity));
      paramActivity.getWindow().setFlags(8192, 8192);
      paramActivity.show();
      return;
    }
    if (createPdfReport(paramAliveCorEcg, paramSize, paramFile, paramString1, paramPatientInfo, paramString2, paramString3))
    {
      paramPdfListener.onShowPdf(paramFile);
      return;
    }
    paramPdfListener.onError();
  }
  
  public void createPdfEncryptionPromptWithConfig(Activity paramActivity, AliveCorEcg paramAliveCorEcg, Size paramSize, File paramFile, String paramString1, PatientInfo paramPatientInfo, String paramString2, String paramString3, PdfListener paramPdfListener, boolean paramBoolean1, boolean paramBoolean2, ReportRawPDFType paramReportRawPDFType, YAxisScaleTypes paramYAxisScaleTypes)
  {
    reportRawPDFType = paramReportRawPDFType;
    yAxisScaleTypes = paramYAxisScaleTypes;
    withConfig = true;
    showEncryptionPromptDialog(paramActivity, paramAliveCorEcg, paramSize, paramFile, paramString1, paramPatientInfo, paramString2, paramString3, paramPdfListener, paramBoolean1, paramBoolean2);
  }
  
  public boolean createPdfReport(AliveCorEcg paramAliveCorEcg, Size paramSize, File paramFile, String paramString1, PatientInfo paramPatientInfo, String paramString2, String paramString3)
  {
    paramAliveCorEcg = createPdfData(paramAliveCorEcg, paramSize, paramFile, paramString1, paramPatientInfo, paramString2, paramString3);
    paramSize = Locale.getDefault().getLanguage();
    if ((!paramSize.equalsIgnoreCase(new Locale("ko").getLanguage())) && (!paramSize.equalsIgnoreCase(new Locale("zh").getLanguage())) && (!paramSize.equalsIgnoreCase(new Locale("ru").getLanguage())) && (!paramSize.equalsIgnoreCase(new Locale("ja").getLanguage()))) {
      paramAliveCorEcg = new PdfRender(appContext, paramFile, paramAliveCorEcg, true, false);
    } else {
      paramAliveCorEcg = new PdfRender(appContext, paramFile, paramAliveCorEcg, true, true);
    }
    try
    {
      paramAliveCorEcg.createReport();
      return true;
    }
    catch (Exception paramAliveCorEcg)
    {
      a.c(paramAliveCorEcg, "Error creating PDF Report", new Object[0]);
    }
    return false;
  }
  
  public void createPdfWithEncryptionPrompt(Activity paramActivity, AliveCorEcg paramAliveCorEcg, Size paramSize, File paramFile, String paramString1, PatientInfo paramPatientInfo, String paramString2, String paramString3, PdfListener paramPdfListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    yAxisScaleTypes = YAxisScaleTypes.Y_AXIS_SCALE_10;
    reportRawPDFType = ReportRawPDFType.ORIGINAL;
    withConfig = false;
    showEncryptionPromptDialog(paramActivity, paramAliveCorEcg, paramSize, paramFile, paramString1, paramPatientInfo, paramString2, paramString3, paramPdfListener, paramBoolean1, paramBoolean2);
  }
  
  public class PatientInfo
  {
    public final String lastName;
    public final Long patientDobMillis;
    public final String patientId;
    
    public PatientInfo(String paramString1, Long paramLong, String paramString2)
    {
      lastName = paramString1;
      patientDobMillis = paramLong;
      patientId = paramString2;
    }
  }
  
  public abstract interface PdfListener
  {
    public abstract void onEncryptPdf(File paramFile, String paramString);
    
    public abstract void onError();
    
    public abstract void onShowPdf(File paramFile);
  }
  
  public enum Size
  {
    static
    {
      Size localSize1 = new Size("LETTER", 0);
      LETTER = localSize1;
      Size localSize2 = new Size("A_4", 1);
      NOTE = localSize2;
      $VALUES = new Size[] { localSize1, localSize2 };
    }
  }
}
