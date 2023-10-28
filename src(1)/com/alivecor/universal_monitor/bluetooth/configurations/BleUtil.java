package com.alivecor.universal_monitor.bluetooth.configurations;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import org.objectweb.asm.MethodWriter;
import v7.util.TLongArrayList;

public class BleUtil
{
  public BleUtil() {}
  
  public static String bondStateToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 12: 
      return "BOND_BONDED";
    case 11: 
      return "BOND_BONDING";
    }
    return "BOND_NONE";
  }
  
  public static String btAdapterStateToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UNKNOWN (");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    case 13: 
      return "TURNING OFF";
    case 12: 
      return "ON";
    case 11: 
      return "TURNING ON";
    }
    return "OFF";
  }
  
  public static Set getBondedDevices(Context paramContext, String paramString)
  {
    TLongArrayList localTLongArrayList = new TLongArrayList();
    paramContext = (BluetoothManager)paramContext.getApplicationContext().getSystemService("bluetooth");
    if (paramContext != null)
    {
      paramContext = paramContext.getAdapter().getBondedDevices();
      if (paramContext.size() > 0)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramContext.next();
          if ((localBluetoothDevice.getBondState() == 12) && ((paramString == null) || (localBluetoothDevice.getName().startsWith(paramString)))) {
            localTLongArrayList.add(localBluetoothDevice);
          }
        }
      }
    }
    return localTLongArrayList;
  }
  
  public static boolean isBleSupported(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
  }
  
  public static boolean isBluetoothEnabled(Context paramContext)
  {
    paramContext = (BluetoothManager)paramContext.getSystemService("bluetooth");
    if (paramContext != null) {
      paramContext = paramContext.getAdapter();
    } else {
      paramContext = null;
    }
    return (paramContext != null) && (paramContext.isEnabled());
  }
  
  public static boolean refreshDeviceCache(BluetoothGatt paramBluetoothGatt)
  {
    MethodWriter.d("Refreshing device cache...", new Object[0]);
    try
    {
      Object localObject = paramBluetoothGatt.getClass();
      localObject = ((Class)localObject).getMethod("refresh", new Class[0]);
      paramBluetoothGatt = ((Method)localObject).invoke(paramBluetoothGatt, new Object[0]);
      paramBluetoothGatt = (Boolean)paramBluetoothGatt;
      boolean bool = paramBluetoothGatt.booleanValue();
      return bool;
    }
    catch (Exception paramBluetoothGatt)
    {
      MethodWriter.d("An exception occurred while refreshing device", paramBluetoothGatt);
      MethodWriter.a("gatt.refresh() method not found", new Object[0]);
    }
    return false;
  }
  
  public static boolean removeBond(BluetoothDevice paramBluetoothDevice)
  {
    if (paramBluetoothDevice == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Removing bond information for device: ");
    ((StringBuilder)localObject).append(paramBluetoothDevice.getName());
    MethodWriter.debug(((StringBuilder)localObject).toString(), new Object[0]);
    if (paramBluetoothDevice.getBondState() == 10)
    {
      MethodWriter.a("Device is not bonded", new Object[0]);
      return true;
    }
    try
    {
      localObject = paramBluetoothDevice.getClass();
      localObject = ((Class)localObject).getMethod("removeBond", new Class[0]);
      paramBluetoothDevice = ((Method)localObject).invoke(paramBluetoothDevice, new Object[0]);
      paramBluetoothDevice = (Boolean)paramBluetoothDevice;
      boolean bool = paramBluetoothDevice.booleanValue();
      return bool;
    }
    catch (Exception paramBluetoothDevice)
    {
      MethodWriter.d("An exception occurred while removing bond", paramBluetoothDevice);
    }
    return false;
  }
  
  public static void removeBondedDevices(Set paramSet)
  {
    if (paramSet.size() > 0)
    {
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramSet.next();
        if (localBluetoothDevice.getBondState() == 12) {
          removeBond(localBluetoothDevice);
        }
      }
    }
  }
}
