package com.alivecor.universal_monitor.bluetooth.configurations;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import com.alivecor.universal_monitor.bluetooth.BluetoothDeviceProperties;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.objectweb.asm.MethodWriter;
import org.objectweb.asm.d;
import org.objectweb.asm.i;

public class EcgBleManager
{
  private static final int CMD_RESULT_FAILED = 2;
  private static final int CMD_RESULT_INVALID_PARAMETER = 4;
  private static final int CMD_RESULT_INVALID_STATE = 5;
  private static final int CMD_RESULT_NOTSUPPORTED = 3;
  private static final int CMD_RESULT_SUCCESS = 1;
  private static final int CONNECT_RETRY_LIMIT = 3;
  private BluetoothGattCharacteristic batteryLevelCharacteristic;
  private final BluetoothGattCallback bleGattCallback = new BluetoothGattCallback()
  {
    public void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a8 = a7\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
    }
    
    public final void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a13 = a12\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
    }
    
    public final void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt)
    {
      paramAnonymousBluetoothGatt = new StringBuilder();
      paramAnonymousBluetoothGatt.append("onCharacteristicWrite() uuid: ");
      paramAnonymousBluetoothGatt.append(paramAnonymousBluetoothGattCharacteristic.getUuid());
      paramAnonymousBluetoothGatt.append(", status: ");
      paramAnonymousBluetoothGatt.append(GattError.gattStatusToString(paramAnonymousInt));
      paramAnonymousBluetoothGatt = paramAnonymousBluetoothGatt.toString();
      paramAnonymousBluetoothGattCharacteristic = new Object[0];
      if (paramAnonymousInt == 0)
      {
        MethodWriter.debug(paramAnonymousBluetoothGatt, paramAnonymousBluetoothGattCharacteristic);
        return;
      }
      MethodWriter.error(paramAnonymousBluetoothGatt, paramAnonymousBluetoothGattCharacteristic);
    }
    
    public void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConnectionStateChange() device: ");
      ((StringBuilder)localObject).append(paramAnonymousBluetoothGatt.getDevice());
      ((StringBuilder)localObject).append(", status: ");
      ((StringBuilder)localObject).append(GattError.connectionErrorToString(paramAnonymousInt1));
      ((StringBuilder)localObject).append(", state: ");
      ((StringBuilder)localObject).append(EcgBleManager.this.bluetoothStateToString(paramAnonymousInt2));
      localObject = ((StringBuilder)localObject).toString();
      Object[] arrayOfObject = new Object[0];
      if (paramAnonymousInt1 == 0) {
        MethodWriter.debug((String)localObject, arrayOfObject);
      } else {
        MethodWriter.error((String)localObject, arrayOfObject);
      }
      if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 2) && (EcgBleManager.this.getState() == 2))
      {
        MethodWriter.debug("Connected", new Object[0]);
        EcgBleManager.access$1902(EcgBleManager.this, 0L);
        EcgBleManager.access$2002(EcgBleManager.this, 0L);
        if (btEcgDevice.getBondState() == 12)
        {
          MethodWriter.debug("Bonded.  Discovering Services", new Object[0]);
          EcgBleManager.this.setState(4);
          callbackHandler.onDeviceConnected(paramAnonymousBluetoothGatt.getDevice());
          handler.postDelayed(new AllInOneActivity.3(paramAnonymousBluetoothGatt), 300L);
          return;
        }
        MethodWriter.debug("Not Bonded. Creating bond", new Object[0]);
        EcgBleManager.this.setState(3);
        callbackHandler.onDeviceConnected(paramAnonymousBluetoothGatt.getDevice());
        MethodWriter.debug("createBond()", new Object[0]);
        btEcgDevice.createBond();
        return;
      }
      if (paramAnonymousInt2 == 0)
      {
        int i = 1;
        if ((paramAnonymousInt1 != 0) && (EcgBleManager.this.getState() != 5) && (EcgBleManager.this.getState() != 1) && (EcgBleManager.this.getState() != 0)) {
          paramAnonymousInt2 = 1;
        } else {
          paramAnonymousInt2 = 0;
        }
        if ((EcgBleManager.this.getState() != 4) || (!taskQueue.isEmpty())) {
          i = 0;
        }
        taskQueue.clear();
        handler.removeCallbacksAndMessages(null);
        EcgBleManager.this.closeGatt();
        if ((paramAnonymousInt2 != 0) && (i == 0) && (connectRetryCount < 3))
        {
          EcgBleManager.access$2408(EcgBleManager.this);
          EcgBleManager.this.setState(6);
          handler.postDelayed(new SelectSyncedCalendarsMultiAccountAdapter.2(this), 100L);
          return;
        }
        EcgBleManager.this.setState(0);
        callbackHandler.onDeviceDisconnected(paramAnonymousBluetoothGatt.getDevice());
        callbackHandler.onError(btEcgDevice, "Device GATT error", paramAnonymousInt1);
        return;
      }
      MethodWriter.error("onConnectionStateChange() Unexpected", new Object[0]);
      if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 2))
      {
        MethodWriter.debug("disconnect()", new Object[0]);
        paramAnonymousBluetoothGatt.disconnect();
      }
    }
    
    public final void onConnectionUpdated(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      paramAnonymousBluetoothGatt = new StringBuilder();
      paramAnonymousBluetoothGatt.append("onConnectionUpdated() interval: ");
      paramAnonymousBluetoothGatt.append(paramAnonymousInt1);
      paramAnonymousBluetoothGatt.append(", latency: ");
      paramAnonymousBluetoothGatt.append(paramAnonymousInt2);
      paramAnonymousBluetoothGatt.append(", timeout: ");
      paramAnonymousBluetoothGatt.append(paramAnonymousInt3);
      paramAnonymousBluetoothGatt.append(", status: ");
      paramAnonymousBluetoothGatt.append(GattError.gattStatusToString(paramAnonymousInt4));
      MethodWriter.debug(paramAnonymousBluetoothGatt.toString(), new Object[0]);
    }
    
    public void onDescriptorRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
    {
      paramAnonymousBluetoothGatt = new StringBuilder();
      paramAnonymousBluetoothGatt.append("onDescriptorRead() uuid: ");
      paramAnonymousBluetoothGatt.append(paramAnonymousBluetoothGattDescriptor.getCharacteristic().getUuid());
      paramAnonymousBluetoothGatt.append(", status: ");
      paramAnonymousBluetoothGatt.append(GattError.gattStatusToString(paramAnonymousInt));
      paramAnonymousBluetoothGatt = paramAnonymousBluetoothGatt.toString();
      paramAnonymousBluetoothGattDescriptor = new Object[0];
      if (paramAnonymousInt == 0)
      {
        MethodWriter.debug(paramAnonymousBluetoothGatt, paramAnonymousBluetoothGattDescriptor);
        return;
      }
      MethodWriter.error(paramAnonymousBluetoothGatt, paramAnonymousBluetoothGattDescriptor);
    }
    
    public final void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt)
    {
      paramAnonymousBluetoothGatt = new StringBuilder();
      paramAnonymousBluetoothGatt.append("onDescriptorWrite() uuid: ");
      paramAnonymousBluetoothGatt.append(paramAnonymousBluetoothGattDescriptor.getCharacteristic().getUuid());
      paramAnonymousBluetoothGatt.append(", status: ");
      paramAnonymousBluetoothGatt.append(GattError.gattStatusToString(paramAnonymousInt));
      paramAnonymousBluetoothGatt = paramAnonymousBluetoothGatt.toString();
      Object[] arrayOfObject = new Object[0];
      if (paramAnonymousInt == 0) {
        MethodWriter.debug(paramAnonymousBluetoothGatt, arrayOfObject);
      } else {
        MethodWriter.error(paramAnonymousBluetoothGatt, arrayOfObject);
      }
      if (paramAnonymousInt == 0)
      {
        paramAnonymousBluetoothGatt = paramAnonymousBluetoothGattDescriptor.getCharacteristic();
        EcgBleManager.this.runOnMainThread(new Action(this, paramAnonymousBluetoothGatt));
      }
    }
    
    public void onMtuChanged(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      paramAnonymousBluetoothGatt = new StringBuilder();
      paramAnonymousBluetoothGatt.append("onMtuChanged() mut: ");
      paramAnonymousBluetoothGatt.append(paramAnonymousInt1);
      paramAnonymousBluetoothGatt.append(", status: ");
      paramAnonymousBluetoothGatt.append(GattError.gattStatusToString(paramAnonymousInt2));
      MethodWriter.debug(paramAnonymousBluetoothGatt.toString(), new Object[0]);
    }
    
    public void onReliableWriteCompleted(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
    {
      paramAnonymousBluetoothGatt = new StringBuilder();
      paramAnonymousBluetoothGatt.append("onReliableWriteCompleted() status: ");
      paramAnonymousBluetoothGatt.append(GattError.gattStatusToString(paramAnonymousInt));
      MethodWriter.debug(paramAnonymousBluetoothGatt.toString(), new Object[0]);
    }
    
    public void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onServicesDiscovered()  status: ");
      ((StringBuilder)localObject).append(GattError.gattStatusToString(paramAnonymousInt));
      localObject = ((StringBuilder)localObject).toString();
      Object[] arrayOfObject = new Object[0];
      if (paramAnonymousInt == 0) {
        MethodWriter.debug((String)localObject, arrayOfObject);
      } else {
        MethodWriter.error((String)localObject, arrayOfObject);
      }
      if (paramAnonymousInt == 0)
      {
        if (bluetoothGatt.getServices() == null) {
          return;
        }
        localObject = bluetoothGatt.getService(TriangleConstants.ECG_6LEAD_SERVICE_UUID);
        if (localObject != null)
        {
          EcgBleManager.access$1602(EcgBleManager.this, ((BluetoothGattService)localObject).getCharacteristic(TriangleConstants.ECG_6LEAD_ECG_CHARACTERISTIC_UUID));
          EcgBleManager.access$1102(EcgBleManager.this, ((BluetoothGattService)localObject).getCharacteristic(TriangleConstants.ECG_6LEAD_CMD_CHARACTERISTIC_UUID));
        }
        localObject = bluetoothGatt.getService(TriangleConstants.BATTERY_SERVICE_UUID);
        if (localObject != null) {
          EcgBleManager.access$602(EcgBleManager.this, ((BluetoothGattService)localObject).getCharacteristic(TriangleConstants.BATTERY_LEVEL_CHARACTERISTIC_UUID));
        }
        localObject = bluetoothGatt.getService(TriangleConstants.DEVICE_INFO_SERVICE_UUID);
        if (localObject != null)
        {
          EcgBleManager.access$802(EcgBleManager.this, ((BluetoothGattService)localObject).getCharacteristic(TriangleConstants.DEVICE_INFO_FIRMWARE_REVISION_CHARACTERISTIC_UUID));
          EcgBleManager.access$1002(EcgBleManager.this, ((BluetoothGattService)localObject).getCharacteristic(TriangleConstants.DEVICE_INFO_HARDWARE_REVISION_CHARACTERISTIC_UUID));
          EcgBleManager.access$902(EcgBleManager.this, ((BluetoothGattService)localObject).getCharacteristic(TriangleConstants.DEVICE_INFO_SERIAL_NUMBER_CHARACTERISTIC_UUID));
        }
        if (EcgBleManager.this.canEnqueueStreamingTasks()) {
          callbackHandler.onDeviceReadyToStream(paramAnonymousBluetoothGatt.getDevice());
        }
      }
    }
  };
  private final ScanCallback bleScanCallback = new ScanCallback()
  {
    public void onScanFailed(int paramAnonymousInt)
    {
      MethodWriter.debug("onScanFailed", new Object[0]);
      callbackHandler.onError(null, "Scan failed to start for unknown reason", paramAnonymousInt);
    }
    
    public void onScanResult(int paramAnonymousInt, ScanResult paramAnonymousScanResult)
    {
      Object localObject1 = lock;
      try
      {
        paramAnonymousInt = EcgBleManager.this.getState();
        if (paramAnonymousInt != 1)
        {
          MethodWriter.debug("onScanResult() Not scanning, Result ignored.", new Object[0]);
          return;
        }
        ScanRecord localScanRecord = paramAnonymousScanResult.getScanRecord();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onScanResult() device: ");
        ((StringBuilder)localObject2).append(paramAnonymousScanResult.getDevice().getName());
        ((StringBuilder)localObject2).append(", bt_address: ");
        ((StringBuilder)localObject2).append(paramAnonymousScanResult.getDevice().getAddress());
        ((StringBuilder)localObject2).append(", rssi: ");
        ((StringBuilder)localObject2).append(paramAnonymousScanResult.getRssi());
        MethodWriter.debug(((StringBuilder)localObject2).toString(), new Object[0]);
        if (localScanRecord != null)
        {
          localObject2 = localScanRecord.getServiceUuids();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              if (((ParcelUuid)((Iterator)localObject2).next()).getUuid().equals(TriangleConstants.ECG_6LEAD_SERVICE_UUID))
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("onScanResult() scanRecord hex: ");
                localStringBuilder.append(HexString.bytesToHex(localScanRecord.getBytes()));
                MethodWriter.d(localStringBuilder.toString(), new Object[0]);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("onScanResult() scanRecord device: ");
                localStringBuilder.append(localScanRecord.getDeviceName());
                localStringBuilder.append(" TxPowerLevel: ");
                localStringBuilder.append(localScanRecord.getTxPowerLevel());
                localStringBuilder.append(" Flags: ");
                localStringBuilder.append(localScanRecord.getAdvertiseFlags());
                MethodWriter.d(localStringBuilder.toString(), new Object[0]);
                callbackHandler.onDeviceDiscovered(paramAnonymousScanResult.getDevice());
              }
            }
          }
        }
        return;
      }
      catch (Throwable paramAnonymousScanResult)
      {
        throw paramAnonymousScanResult;
      }
    }
  };
  private BluetoothGatt bluetoothGatt;
  private BluetoothDevice btEcgDevice;
  private final EcgBleManagerCallback callbackHandler;
  private BluetoothGattCharacteristic cmdCharacteristic;
  private int connectRetryCount;
  private final Context context;
  private BluetoothDeviceProperties deviceProperties = new BluetoothDeviceProperties();
  private BluetoothGattCharacteristic ecgCharacteristic;
  private final Handler handler = new Handler(Looper.getMainLooper());
  private BluetoothGattCharacteristic infoFirmwareRevisionCharacteristic;
  private BluetoothGattCharacteristic infoHardwareRevisionCharacteristic;
  private BluetoothGattCharacteristic infoSerialNumberCharacteristic;
  private final Object lock = new Object();
  private final BroadcastReceiver mBluetoothStateBroadcastReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
      paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
      paramAnonymousContext = new StringBuilder();
      paramAnonymousContext.append("[Broadcast] Action received: android.bluetooth.adapter.action.STATE_CHANGED, state changed to ");
      paramAnonymousContext.append(BleUtil.btAdapterStateToString(i));
      MethodWriter.d(paramAnonymousContext.toString(), new Object[0]);
      if ((i != 10) && (i != 13)) {
        return;
      }
      if (EcgBleManager.this.getState() == 1)
      {
        handler.removeCallbacksAndMessages(null);
        EcgBleManager.this.stopScanning();
      }
    }
  };
  private final BroadcastReceiver mBondingBroadcastReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      int i = paramAnonymousIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
      int j = paramAnonymousIntent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
      paramAnonymousIntent = new StringBuilder();
      paramAnonymousIntent.append("[Broadcast] Action received: android.bluetooth.device.action.BOND_STATE_CHANGED, bond state changed to: ");
      paramAnonymousIntent.append(BleUtil.bondStateToString(i));
      paramAnonymousIntent.append(" (");
      paramAnonymousIntent.append(i);
      paramAnonymousIntent.append(")");
      MethodWriter.d(paramAnonymousIntent.toString(), new Object[0]);
      paramAnonymousIntent = new StringBuilder();
      paramAnonymousIntent.append("Bond state changed for: ");
      paramAnonymousIntent.append(paramAnonymousContext.getName());
      paramAnonymousIntent.append(" from: ");
      paramAnonymousIntent.append(BleUtil.bondStateToString(j));
      paramAnonymousIntent.append(" to: ");
      paramAnonymousIntent.append(BleUtil.bondStateToString(i));
      MethodWriter.debug(paramAnonymousIntent.toString(), new Object[0]);
      if (btEcgDevice != null)
      {
        if (!paramAnonymousContext.getAddress().equals(btEcgDevice.getAddress())) {
          return;
        }
        if (i == 12)
        {
          if (EcgBleManager.this.getState() == 3)
          {
            EcgBleManager.this.setState(4);
            handler.postDelayed(new AlarmReceiver.1(this), 300L);
          }
        }
        else if ((i == 10) && (EcgBleManager.this.getState() == 2))
        {
          MethodWriter.debug("bond was removed for workaround.  creating new bond", new Object[0]);
          connectDevice(paramAnonymousContext);
        }
      }
    }
  };
  private final BroadcastReceiver mPairingRequestBroadcastReceiver = new BroadcastReceiver()
  {
    private static final int PAIRING_VARIANT_CONSENT = 3;
    private static final int PAIRING_VARIANT_DISPLAY_PASSKEY = 4;
    private static final int PAIRING_VARIANT_DISPLAY_PIN = 5;
    private static final int PAIRING_VARIANT_OOB_CONSENT = 6;
    private static final int PAIRING_VARIANT_PASSKEY = 1;
    private static final int PAIRING_VARIANT_PASSKEY_CONFIRMATION = 2;
    private static final int PAIRING_VARIANT_PIN = 0;
    
    private String pairingVariantToString(int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      default: 
        return "UNKNOWN";
      case 6: 
        return "PAIRING_VARIANT_OOB_CONSENT";
      case 5: 
        return "PAIRING_VARIANT_DISPLAY_PIN";
      case 4: 
        return "PAIRING_VARIANT_DISPLAY_PASSKEY";
      case 3: 
        return "PAIRING_VARIANT_CONSENT";
      case 2: 
        return "PAIRING_VARIANT_PASSKEY_CONFIRMATION";
      case 1: 
        return "PAIRING_VARIANT_PASSKEY";
      }
      return "PAIRING_VARIANT_PIN";
    }
    
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      int i = paramAnonymousIntent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 0);
      paramAnonymousContext = new StringBuilder();
      paramAnonymousContext.append("[Broadcast] Action received: android.bluetooth.device.action.PAIRING_REQUEST, pairing variant: ");
      paramAnonymousContext.append(pairingVariantToString(i));
      paramAnonymousContext.append(" (");
      paramAnonymousContext.append(i);
      paramAnonymousContext.append(")");
      MethodWriter.d(paramAnonymousContext.toString(), new Object[0]);
    }
  };
  private long scanStartTime;
  private int state = 0;
  private final GattTaskQueue taskQueue = new GattTaskQueue(new GattTaskQueue.Callback()
  {
    public void onGattError(GattTaskQueue.TaskType paramAnonymousTaskType, int paramAnonymousInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGattError(): ");
      localStringBuilder.append(paramAnonymousTaskType.toString());
      localStringBuilder.append(" Failed with code: ");
      localStringBuilder.append(paramAnonymousInt);
      MethodWriter.debug(localStringBuilder.toString(), new Object[0]);
    }
    
    public boolean onGattTask(GattTaskQueue.TaskType paramAnonymousTaskType)
    {
      switch (EcgBleManager.7.$SwitchMap$com$alivecor$universal_monitor$bluetooth$ble$GattTaskQueue$TaskType[paramAnonymousTaskType.ordinal()])
      {
      default: 
        return false;
      case 8: 
        paramAnonymousTaskType = EcgBleManager.this;
        localObject = batteryLevelCharacteristic;
        break;
      case 7: 
        paramAnonymousTaskType = EcgBleManager.this;
        localObject = ecgCharacteristic;
        return paramAnonymousTaskType.internalEnableNotifications((BluetoothGattCharacteristic)localObject);
      case 6: 
        paramAnonymousTaskType = EcgBleManager.this;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Triangle");
        ((StringBuilder)localObject).append(bluetoothGatt.getDevice().getName());
        paramAnonymousTaskType = paramAnonymousTaskType.Sha256Hash(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("K");
        ((StringBuilder)localObject).append(paramAnonymousTaskType.substring(0, Math.min(paramAnonymousTaskType.length(), 16)));
        paramAnonymousTaskType = ((StringBuilder)localObject).toString();
        localObject = triangleMode.settingString();
        BluetoothGattCharacteristic localBluetoothGattCharacteristic = cmdCharacteristic;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramAnonymousTaskType);
        localBluetoothGattCharacteristic.setValue(localStringBuilder.toString());
        paramAnonymousTaskType = EcgBleManager.this;
        return paramAnonymousTaskType.internalWriteCharacteristic(cmdCharacteristic);
      case 5: 
        paramAnonymousTaskType = EcgBleManager.this;
        return paramAnonymousTaskType.internalEnableIndications(cmdCharacteristic);
      case 4: 
        paramAnonymousTaskType = EcgBleManager.this;
        localObject = infoHardwareRevisionCharacteristic;
        break;
      case 3: 
        paramAnonymousTaskType = EcgBleManager.this;
        localObject = infoSerialNumberCharacteristic;
        break;
      case 2: 
        paramAnonymousTaskType = EcgBleManager.this;
        localObject = infoFirmwareRevisionCharacteristic;
        break;
      }
      paramAnonymousTaskType = EcgBleManager.this;
      Object localObject = batteryLevelCharacteristic;
      return paramAnonymousTaskType.internalReadCharacteristic((BluetoothGattCharacteristic)localObject);
    }
  });
  private long totalBytes;
  private long totalPackets;
  private TriangleMode triangleMode;
  
  public EcgBleManager(Context paramContext, EcgBleManagerCallback paramEcgBleManagerCallback)
  {
    context = paramContext.getApplicationContext();
    callbackHandler = paramEcgBleManagerCallback;
    MethodWriter.a(new d(paramContext).a(new i()).a("EcgBleManager").a(0).a());
    MethodWriter.d(true);
  }
  
  private String Sha256Hash(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes());
      paramString = bytesToHex(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      MethodWriter.d(paramString);
    }
    return "";
  }
  
  private String bluetoothStateToString(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("UNKNOWN (");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
          }
          return "DISCONNECTING";
        }
        return "CONNECTED";
      }
      return "CONNECTING";
    }
    return "DISCONNECTED";
  }
  
  private String bytesToHex(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private boolean canEnqueueStreamingTasks()
  {
    return (cmdCharacteristic != null) && (ecgCharacteristic != null) && (batteryLevelCharacteristic != null) && (infoFirmwareRevisionCharacteristic != null) && (infoHardwareRevisionCharacteristic != null) && (infoSerialNumberCharacteristic != null);
  }
  
  private void closeGatt()
  {
    Object localObject = lock;
    try
    {
      BluetoothGatt localBluetoothGatt = bluetoothGatt;
      if (localBluetoothGatt != null)
      {
        MethodWriter.d("gatt.close()", new Object[0]);
        bluetoothGatt.close();
        bluetoothGatt = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void disconnect()
  {
    Object localObject = lock;
    try
    {
      BluetoothGatt localBluetoothGatt = bluetoothGatt;
      if (localBluetoothGatt != null)
      {
        MethodWriter.debug("disconnectDevice()", new Object[0]);
        handler.removeCallbacksAndMessages(null);
        setState(5);
        bluetoothGatt.disconnect();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private boolean ensureServiceChangedEnabled()
  {
    Object localObject = bluetoothGatt;
    if (localObject == null) {
      return false;
    }
    if (((BluetoothGatt)localObject).getDevice().getBondState() != 12) {
      return false;
    }
    localObject = ((BluetoothGatt)localObject).getService(TriangleConstants.GENERIC_ATTRIBUTE_SERVICE_UUID);
    if (localObject == null) {
      return false;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(TriangleConstants.SERVICE_CHANGED_CHARACTERISTIC_UUID);
    if (localObject == null) {
      return false;
    }
    MethodWriter.debug("Service Changed characteristic found on a bonded device", new Object[0]);
    return internalEnableIndications((BluetoothGattCharacteristic)localObject);
  }
  
  private BluetoothLeScanner getBluetoothLeScanner()
  {
    BluetoothManager localBluetoothManager = (BluetoothManager)context.getSystemService("bluetooth");
    if (localBluetoothManager != null) {
      return localBluetoothManager.getAdapter().getBluetoothLeScanner();
    }
    return null;
  }
  
  private int getState()
  {
    return state;
  }
  
  private boolean internalEnableIndications(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Object localObject = bluetoothGatt;
    if (localObject == null)
    {
      MethodWriter.error("internalEnableIndications() gatt: null", new Object[0]);
      return false;
    }
    if (paramBluetoothGattCharacteristic == null)
    {
      MethodWriter.error("internalEnableIndications() characteristic: null", new Object[0]);
      return false;
    }
    if ((paramBluetoothGattCharacteristic.getProperties() & 0x20) == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalEnableIndications() uuid: ");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      ((StringBuilder)localObject).append(", PROPERTY_INDICATE missing");
      MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    if (!((BluetoothGatt)localObject).setCharacteristicNotification(paramBluetoothGattCharacteristic, true))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalEnableIndications - uuid: ");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      ((StringBuilder)localObject).append(", setCharacteristicNotification(): false");
      MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    localObject = paramBluetoothGattCharacteristic.getDescriptor(TriangleConstants.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalEnableIndications() uuid: ");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      ((StringBuilder)localObject).append(", getDescriptor(TriangleConstants.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID): null");
      MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    ((BluetoothGattDescriptor)localObject).setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
    return internalWriteDescriptorWorkaround((BluetoothGattDescriptor)localObject);
  }
  
  private boolean internalEnableNotifications(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Object localObject = bluetoothGatt;
    if (localObject == null)
    {
      MethodWriter.error("internalEnableNotifications() gatt: null", new Object[0]);
      return false;
    }
    if (paramBluetoothGattCharacteristic == null)
    {
      MethodWriter.error("internalEnableNotifications() characteristic: null", new Object[0]);
      return false;
    }
    if ((paramBluetoothGattCharacteristic.getProperties() & 0x10) == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalEnableNotifications() uuid: ");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      ((StringBuilder)localObject).append(", PROPERTY_NOTIFY missing");
      MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    if (!((BluetoothGatt)localObject).setCharacteristicNotification(paramBluetoothGattCharacteristic, true))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalEnableNotifications() uuid: ");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      ((StringBuilder)localObject).append(",  setCharacteristicNotification(): false");
      MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    localObject = paramBluetoothGattCharacteristic.getDescriptor(TriangleConstants.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalEnableNotifications() uuid: ");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      ((StringBuilder)localObject).append(", getDescriptor(TriangleConstants.CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID): null");
      MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    ((BluetoothGattDescriptor)localObject).setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
    return internalWriteDescriptorWorkaround((BluetoothGattDescriptor)localObject);
  }
  
  private boolean internalReadCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Object localObject = bluetoothGatt;
    if (localObject == null)
    {
      MethodWriter.error("internalReadCharacteristic() gatt: null", new Object[0]);
      return false;
    }
    if (paramBluetoothGattCharacteristic == null)
    {
      MethodWriter.error("internalReadCharacteristic() characteristic: null", new Object[0]);
      return false;
    }
    if ((paramBluetoothGattCharacteristic.getProperties() & 0x2) == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalReadCharacteristic() uuid: ");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      ((StringBuilder)localObject).append(", PROPERTY_READ missing");
      MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    if (!((BluetoothGatt)localObject).readCharacteristic(paramBluetoothGattCharacteristic))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalReadCharacteristic() uuid: ");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      ((StringBuilder)localObject).append(", readCharacteristic(): false");
      MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    return true;
  }
  
  private void internalStartScanning()
  {
    Object localObject = lock;
    try
    {
      MethodWriter.debug("internalStartScanning()", new Object[0]);
      BluetoothLeScanner localBluetoothLeScanner = getBluetoothLeScanner();
      if (localBluetoothLeScanner == null) {
        return;
      }
      deviceProperties = new BluetoothDeviceProperties();
      setState(1);
      scanStartTime = System.currentTimeMillis();
      handler.postDelayed(new FileBrowser.11(this), 30000L);
      localBluetoothLeScanner.startScan(null, new ScanSettings.Builder().setScanMode(2).setReportDelay(0L).build(), bleScanCallback);
      callbackHandler.onDeviceScanning();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private boolean internalWriteCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Object localObject = bluetoothGatt;
    if (localObject == null)
    {
      MethodWriter.error("internalWriteCharacteristic() gatt: null", new Object[0]);
      return false;
    }
    if (paramBluetoothGattCharacteristic == null)
    {
      MethodWriter.error("internalWriteCharacteristic() characteristic: null", new Object[0]);
      return false;
    }
    if ((paramBluetoothGattCharacteristic.getProperties() & 0xC) == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalWriteCharacteristic() uuid: ");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      ((StringBuilder)localObject).append(", PROPERTY_WRITE or PROPERTY_WRITE_NO_RESPONSE missing");
      MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    if (!((BluetoothGatt)localObject).writeCharacteristic(paramBluetoothGattCharacteristic))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalWriteCharacteristic() uuid: ");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      ((StringBuilder)localObject).append(", writeCharacteristic(): false");
      MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      return false;
    }
    return true;
  }
  
  private boolean internalWriteDescriptorWorkaround(BluetoothGattDescriptor paramBluetoothGattDescriptor)
  {
    BluetoothGatt localBluetoothGatt = bluetoothGatt;
    if (localBluetoothGatt == null)
    {
      MethodWriter.error("internalWriteDescriptorWorkaround() gatt: null", new Object[0]);
      return false;
    }
    if (paramBluetoothGattDescriptor == null)
    {
      MethodWriter.error("internalWriteDescriptorWorkaround() descriptor: null", new Object[0]);
      return false;
    }
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = paramBluetoothGattDescriptor.getCharacteristic();
    int i = localBluetoothGattCharacteristic.getWriteType();
    localBluetoothGattCharacteristic.setWriteType(2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("internalWriteDescriptorWorkaround() writing descriptor with UUID: ");
    localStringBuilder.append(paramBluetoothGattDescriptor.getUuid());
    MethodWriter.error(localStringBuilder.toString(), new Object[0]);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("internalWriteDescriptorWorkaround() ... of characteristic with UUID: ");
    localStringBuilder.append(localBluetoothGattCharacteristic.getUuid());
    MethodWriter.error(localStringBuilder.toString(), new Object[0]);
    boolean bool = localBluetoothGatt.writeDescriptor(paramBluetoothGattDescriptor);
    localBluetoothGattCharacteristic.setWriteType(i);
    if (!bool)
    {
      paramBluetoothGattDescriptor = new StringBuilder();
      paramBluetoothGattDescriptor.append("internalWriteDescriptorWorkaround() uuid: ");
      paramBluetoothGattDescriptor.append(localBluetoothGattCharacteristic.getUuid());
      paramBluetoothGattDescriptor.append(", writeDescriptor(): false");
      MethodWriter.error(paramBluetoothGattDescriptor.toString(), new Object[0]);
    }
    return bool;
  }
  
  private void maybeEnqueueStreamingTasks()
  {
    if ((canEnqueueStreamingTasks()) && (triangleMode != null))
    {
      MethodWriter.getSize("maybeEnqueueStreamingTasks() Had enough data to continue.  Enqueuing tasks", new Object[0]);
      handler.postDelayed(new FileBrowser.10(this), 700L);
      return;
    }
    MethodWriter.a("maybeEnqueueStreamingTasks() Missing mode or GATT ids.  Not enqueueing", new Object[0]);
  }
  
  private void onScanTimeout()
  {
    MethodWriter.a("Scan timed out.  Stopping scan", new Object[0]);
    stopScanning();
  }
  
  private void runOnMainThread(Runnable paramRunnable)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      handler.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  private void setState(int paramInt)
  {
    state = paramInt;
  }
  
  private void stopScanning()
  {
    Object localObject1 = lock;
    try
    {
      MethodWriter.debug("stopScanning()", new Object[0]);
      handler.removeCallbacksAndMessages(null);
      if (getState() == 1)
      {
        Object localObject2 = getBluetoothLeScanner();
        if (localObject2 != null)
        {
          ScanCallback localScanCallback = bleScanCallback;
          try
          {
            ((BluetoothLeScanner)localObject2).stopScan(localScanCallback);
            setState(0);
            localObject2 = callbackHandler;
            ((EcgBleManagerCallback)localObject2).onDeviceScanningStopped();
          }
          catch (IllegalStateException localIllegalStateException)
          {
            MethodWriter.d(localIllegalStateException);
          }
        }
        else
        {
          MethodWriter.d("BluetoothLeScanner is null", new Object[0]);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private void updatedDeviceProperties()
  {
    BluetoothDeviceProperties localBluetoothDeviceProperties = deviceProperties;
    if ((serialNumber != null) && (firmwareRevision != null) && (hardwareRevision != null)) {
      callbackHandler.onDeviceProperties(btEcgDevice, localBluetoothDeviceProperties);
    }
  }
  
  public void connectDevice(BluetoothDevice paramBluetoothDevice)
  {
    btEcgDevice = paramBluetoothDevice;
    handler.removeCallbacksAndMessages(null);
    BluetoothLeScanner localBluetoothLeScanner = getBluetoothLeScanner();
    if (localBluetoothLeScanner != null)
    {
      ScanCallback localScanCallback = bleScanCallback;
      try
      {
        localBluetoothLeScanner.stopScan(localScanCallback);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        MethodWriter.d(localIllegalStateException);
      }
    }
    setState(2);
    callbackHandler.onDeviceConnecting(paramBluetoothDevice);
    handler.post(new EventInfoFragment.2(this, paramBluetoothDevice));
  }
  
  public void enableCapture(TriangleMode paramTriangleMode)
  {
    triangleMode = paramTriangleMode;
  }
  
  public void start()
  {
    if (getState() == 0)
    {
      MethodWriter.debug("start()", new Object[0]);
      connectRetryCount = 0;
      context.registerReceiver(mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
      context.registerReceiver(mBondingBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
      context.registerReceiver(mPairingRequestBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.PAIRING_REQUEST"));
      internalStartScanning();
    }
  }
  
  public void startCapture()
  {
    MethodWriter.debug("startCapture()", new Object[0]);
    maybeEnqueueStreamingTasks();
  }
  
  public void stop()
  {
    Object localObject;
    BroadcastReceiver localBroadcastReceiver;
    if (getState() != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stop() state: ");
      ((StringBuilder)localObject).append(getState());
      MethodWriter.debug(((StringBuilder)localObject).toString(), new Object[0]);
      handler.removeCallbacksAndMessages(null);
      localObject = context;
      localBroadcastReceiver = mBluetoothStateBroadcastReceiver;
    }
    try
    {
      ((Context)localObject).unregisterReceiver(localBroadcastReceiver);
      localObject = context;
      localBroadcastReceiver = mBondingBroadcastReceiver;
      ((Context)localObject).unregisterReceiver(localBroadcastReceiver);
      localObject = context;
      localBroadcastReceiver = mPairingRequestBroadcastReceiver;
      ((Context)localObject).unregisterReceiver(localBroadcastReceiver);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    MethodWriter.d("receiver already unregistered", new Object[0]);
    if (getState() == 1)
    {
      stopScanning();
      return;
    }
    if (getState() == 6) {}
    for (;;)
    {
      setState(0);
      callbackHandler.onStopped();
      return;
      int i = getState();
      disconnect();
      if (i != 2) {
        break;
      }
      closeGatt();
    }
    return;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @interface State
  {
    public static final int CONNECTED_BONDED = 4;
    public static final int CONNECTED_BONDING = 3;
    public static final int CONNECTING = 2;
    public static final int CONNECT_RETRY = 6;
    public static final int DISCONNECTING = 5;
    public static final int IDLE = 0;
    public static final int SCANNING = 1;
  }
}
