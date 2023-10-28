package com.alivecor.neuralsuite;

import android.util.Log;

public class NeuralSuite
{
  public static final int STATUS_FAILED_READ_GRAPH = -2;
  public static final int STATUS_FAILED_RUN = -3;
  public static final int STATUS_FAILED_SESSION = -1;
  public static final int STATUS_INVALID_INPUT = -4;
  public static final int STATUS_SUCCESS = 0;
  private static final boolean debug = true;
  private static final String logTag = "NeuralSuite";
  
  static
  {
    System.loadLibrary("tensorflow_inference");
  }
  
  public NeuralSuite() {}
  
  public static IdentityResult checkIdentity(float[] paramArrayOfFloat, String paramString)
  {
    String str = logTag;
    Log.w(str, "checkIdentity() calling jniCheck() ");
    jniCheck();
    Log.w(str, "checkIdentity()         jniCheck() done");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkIdentity() samples: ");
    ((StringBuilder)localObject).append(paramArrayOfFloat.length);
    ((StringBuilder)localObject).append(", model: ");
    ((StringBuilder)localObject).append(paramString);
    Log.w(str, ((StringBuilder)localObject).toString());
    localObject = new IdentityResult();
    int i = runIdentityCheck(paramArrayOfFloat, 0.5F, paramString, (IdentityResult)localObject);
    status = i;
    if (i != 0)
    {
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("checkIdentity() identity check failed: ");
      paramArrayOfFloat.append(i);
      Log.w(str, paramArrayOfFloat.toString());
    }
    return localObject;
  }
  
  public static InversionResult checkInverted(float[] paramArrayOfFloat, String paramString)
  {
    String str = logTag;
    Log.e(str, "checkInverted() calling jniCheck() ");
    jniCheck();
    Log.w(str, "checkInverted()         jniCheck() done");
    InversionResult localInversionResult = new InversionResult();
    int i = runInversionCheck(paramArrayOfFloat, 0.5F, paramString, localInversionResult);
    status = i;
    if (i != 0)
    {
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("checkInverted() inversion check failed: ");
      paramArrayOfFloat.append(i);
      Log.w(str, paramArrayOfFloat.toString());
    }
    return localInversionResult;
  }
  
  private static native void jniCheck();
  
  public static void main(String[] paramArrayOfString)
  {
    String str = logTag;
    Log.w(str, "main() started");
    Log.w(str, "main() checkInverted: ");
    Object localObject1 = checkInverted(new float['?'], "inversion_model.tf");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("main() checkInverted results: ");
    ((StringBuilder)localObject2).append(localObject1);
    Log.w(str, ((StringBuilder)localObject2).toString());
    if (paramArrayOfString.length > 0)
    {
      if (paramArrayOfString.length > 0) {
        localObject1 = paramArrayOfString[0];
      } else {
        localObject1 = "default.atc";
      }
      if (paramArrayOfString.length > 1) {
        localObject2 = paramArrayOfString[1];
      } else {
        localObject2 = "default_nsr_model.dat";
      }
      if (paramArrayOfString.length > 2) {
        paramArrayOfString = paramArrayOfString[2];
      }
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("main() running algs atcPath: ");
      paramArrayOfString.append((String)localObject1);
      paramArrayOfString.append(", nsrModel: ");
      paramArrayOfString.append((String)localObject2);
      paramArrayOfString.append(", noiseModel: ");
      paramArrayOfString.append((String)localObject2);
      Log.w(str, paramArrayOfString.toString());
    }
    Log.w(str, "main() finished");
  }
  
  private static native int runIdentityCheck(float[] paramArrayOfFloat, float paramFloat, String paramString, IdentityResult paramIdentityResult);
  
  private static native int runInversionCheck(float[] paramArrayOfFloat, float paramFloat, String paramString, InversionResult paramInversionResult);
  
  public static class IdentityResult
  {
    public String errorMsg;
    public boolean identityMatched;
    public float probability;
    public int status;
    
    public IdentityResult() {}
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Identity matched: ");
      localStringBuilder.append(identityMatched);
      localStringBuilder.append(", probability: ");
      localStringBuilder.append(probability);
      localStringBuilder.append(", status: ");
      localStringBuilder.append(status);
      localStringBuilder.append(", errorMsg: ");
      localStringBuilder.append(errorMsg);
      return localStringBuilder.toString();
    }
  }
  
  public static class InversionResult
  {
    public String errorMsg;
    public boolean inverted;
    public float probability;
    public int status;
    
    public InversionResult() {}
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Inversion: ");
      localStringBuilder.append(inverted);
      localStringBuilder.append(", probability: ");
      localStringBuilder.append(probability);
      localStringBuilder.append(", status: ");
      localStringBuilder.append(status);
      localStringBuilder.append(", errorMsg: ");
      localStringBuilder.append(errorMsg);
      return localStringBuilder.toString();
    }
  }
}
