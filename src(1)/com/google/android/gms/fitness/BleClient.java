package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.package_12.ApiException;
import com.google.android.gms.common.package_12.GoogleApi.Settings;
import com.google.android.gms.common.package_12.internal.ListenerHolders;
import com.google.android.gms.common.package_12.internal.RegistrationMethods;
import com.google.android.gms.common.package_12.internal.RegistrationMethods.Builder;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.internal.fitness.OutlineItem;
import com.google.android.gms.internal.fitness.zzen;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.List;

@Deprecated
public class BleClient
  extends com.google.android.gms.common.api.GoogleApi<com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions>
{
  private static final BleApi zzka;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a1 = a0\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  BleClient(Activity paramActivity, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramActivity, OutlineItem.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  protected BleClient(Context paramContext, com.google.android.gms.common.package_12.Api.ApiOptions.HasGoogleSignInAccountOptions paramHasGoogleSignInAccountOptions)
  {
    super(paramContext, OutlineItem.zzoz, paramHasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task claimBleDevice(BleDevice paramBleDevice)
  {
    return PendingResultUtil.toVoidTask(zzka.claimBleDevice(asGoogleApiClient(), paramBleDevice));
  }
  
  public Task claimBleDevice(String paramString)
  {
    return PendingResultUtil.toVoidTask(zzka.claimBleDevice(asGoogleApiClient(), paramString));
  }
  
  public Task listClaimedBleDevices()
  {
    return PendingResultUtil.toTask(zzka.listClaimedBleDevices(asGoogleApiClient()), Macro.zzjz);
  }
  
  public Task startBleScan(List paramList, int paramInt, BleScanCallback paramBleScanCallback)
  {
    if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
      return Tasks.forException(new ApiException(zzen.zzqh));
    }
    paramBleScanCallback = registerListener(paramBleScanCallback, BleScanCallback.class.getSimpleName());
    return doRegisterEventListener(RegistrationMethods.builder().withHolder(paramBleScanCallback).register(new IOUtils.2(this, paramBleScanCallback, paramList, paramInt)).unregister(new Tools.1(this, paramBleScanCallback)).build());
  }
  
  public Task stopBleScan(BleScanCallback paramBleScanCallback)
  {
    if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
      return Tasks.forException(new ApiException(zzen.zzqh));
    }
    return doUnregisterEventListener(ListenerHolders.createListenerKey(paramBleScanCallback, BleScanCallback.class.getSimpleName()));
  }
  
  public Task unclaimBleDevice(BleDevice paramBleDevice)
  {
    return PendingResultUtil.toVoidTask(zzka.unclaimBleDevice(asGoogleApiClient(), paramBleDevice));
  }
  
  public Task unclaimBleDevice(String paramString)
  {
    return PendingResultUtil.toVoidTask(zzka.unclaimBleDevice(asGoogleApiClient(), paramString));
  }
}
