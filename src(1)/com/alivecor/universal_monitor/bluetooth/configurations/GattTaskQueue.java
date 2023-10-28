package com.alivecor.universal_monitor.bluetooth.configurations;

import android.os.Handler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import org.objectweb.asm.MethodWriter;

class GattTaskQueue
{
  private GattTask currentTask;
  private final Handler handler = new Handler();
  private final Callback mCallback;
  private long startTime = 0L;
  private final Queue<com.alivecor.universal_monitor.bluetooth.ble.GattTaskQueue.GattTask> taskQueue;
  
  GattTaskQueue(Callback paramCallback)
  {
    mCallback = paramCallback;
    taskQueue = new LinkedList();
  }
  
  void clear()
  {
    try
    {
      taskQueue.clear();
      handler.removeCallbacksAndMessages(null);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  boolean isEmpty()
  {
    return taskQueue.isEmpty();
  }
  
  void moveItem(TaskType paramTaskType, int paramInt1, int paramInt2)
  {
    startTime = 0L;
    taskQueue.add(new GattTask(paramTaskType, paramInt1, paramInt2));
  }
  
  void process()
  {
    try
    {
      Object localObject = (GattTask)taskQueue.peek();
      currentTask = ((GattTask)localObject);
      if (localObject == null) {
        return;
      }
      handler.removeCallbacksAndMessages(null);
      if (startTime == 0L) {
        startTime = System.currentTimeMillis();
      }
      localObject = currentTask;
      if (retryCount == 0)
      {
        startTime = System.currentTimeMillis();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(currentTask.toString());
        ((StringBuilder)localObject).append(" Start");
        MethodWriter.debug(((StringBuilder)localObject).toString(), new Object[0]);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(currentTask.toString());
        ((StringBuilder)localObject).append(" Retry: ");
        ((StringBuilder)localObject).append(currentTask.retryCount);
        MethodWriter.error(((StringBuilder)localObject).toString(), new Object[0]);
      }
      mCallback.onGattTask(currentTask.type);
      handler.postDelayed(new ExecuteAction(this), currentTask.retryTimeout);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  boolean removeAndProcessNext(TaskType paramTaskType)
  {
    try
    {
      Iterator localIterator = taskQueue.iterator();
      while (localIterator.hasNext())
      {
        GattTask localGattTask = (GattTask)localIterator.next();
        if (type == paramTaskType)
        {
          paramTaskType = new StringBuilder();
          paramTaskType.append(type.toString());
          paramTaskType.append(" End. Duration=");
          paramTaskType.append(System.currentTimeMillis() - startTime);
          paramTaskType.append("ms");
          MethodWriter.debug(paramTaskType.toString(), new Object[0]);
          taskQueue.remove(localGattTask);
          if (taskQueue.isEmpty())
          {
            paramTaskType = new StringBuilder();
            paramTaskType.append("ALL TASKS FINISHED. Total Duration=");
            paramTaskType.append(System.currentTimeMillis() - startTime);
            paramTaskType.append("ms");
            MethodWriter.debug(paramTaskType.toString(), new Object[0]);
          }
          handler.removeCallbacksAndMessages(null);
          handler.postDelayed(new InitiationListener.1(this), 50L);
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramTaskType)
    {
      throw paramTaskType;
    }
  }
  
  abstract class Callback
  {
    Callback() {}
    
    public abstract void onGattError(GattTaskQueue.TaskType paramTaskType, int paramInt);
    
    public abstract boolean onGattTask(GattTaskQueue.TaskType paramTaskType);
  }
  
  class GattTask
  {
    final int maxRetries;
    int retryCount;
    final int retryTimeout;
    long startTime;
    final GattTaskQueue.TaskType type;
    
    GattTask(GattTaskQueue.TaskType paramTaskType, int paramInt1, int paramInt2)
    {
      type = paramTaskType;
      maxRetries = paramInt1;
      retryTimeout = paramInt2;
      retryCount = 0;
      startTime = System.currentTimeMillis();
    }
    
    public String toString()
    {
      return type.toString();
    }
  }
  
  enum TaskType
  {
    static
    {
      TaskType localTaskType1 = new TaskType("TASK_INFO_READ_FIRMWARE_REVISION", 0);
      TASK_INFO_READ_FIRMWARE_REVISION = localTaskType1;
      TaskType localTaskType2 = new TaskType("TASK_INFO_READ_HARDWARE_REVISION", 1);
      TASK_INFO_READ_HARDWARE_REVISION = localTaskType2;
      TaskType localTaskType3 = new TaskType("TASK_INFO_READ_SERIAL_NUMBER", 2);
      TASK_INFO_READ_SERIAL_NUMBER = localTaskType3;
      TaskType localTaskType4 = new TaskType("TASK_BATTERY_READ_PERCENT", 3);
      TASK_BATTERY_READ_PERCENT = localTaskType4;
      TaskType localTaskType5 = new TaskType("TASK_BATTERY_ENABLE_NOTIFICATIONS", 4);
      TASK_BATTERY_ENABLE_NOTIFICATIONS = localTaskType5;
      TaskType localTaskType6 = new TaskType("TASK_CMD_ENABLE_INDICATIONS", 5);
      TASK_CMD_ENABLE_INDICATIONS = localTaskType6;
      TaskType localTaskType7 = new TaskType("TASK_CMD_WRITE_UNLOCK_CODE", 6);
      TASK_CMD_WRITE_UNLOCK_CODE = localTaskType7;
      TaskType localTaskType8 = new TaskType("TASK_ECG_ENABLE_NOTIFICATIONS", 7);
      TASK_ECG_ENABLE_NOTIFICATIONS = localTaskType8;
      $VALUES = new TaskType[] { localTaskType1, localTaskType2, localTaskType3, localTaskType4, localTaskType5, localTaskType6, localTaskType7, localTaskType8 };
    }
  }
}
