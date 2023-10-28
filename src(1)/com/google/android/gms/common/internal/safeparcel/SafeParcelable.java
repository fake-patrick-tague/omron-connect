package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;
import java.lang.annotation.Annotation;

public abstract interface SafeParcelable
  extends Parcelable
{
  public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";
  
  public static @interface Class
  {
    String creator();
    
    boolean doNotParcelTypeDefaultValues();
    
    boolean validate();
  }
  
  public static @interface Constructor {}
  
  public static @interface Field
  {
    int access$getMMinValue();
    
    String defaultValue();
    
    String defaultValueUnchecked();
    
    String getter();
    
    String type();
  }
  
  public static @interface Indicator
  {
    String getter();
  }
  
  public static @interface Param
  {
    int access$getMMinValue();
  }
  
  public static @interface RemovedParam
  {
    int access$getMMinValue();
    
    String defaultValue();
    
    String defaultValueUnchecked();
  }
  
  public static @interface Reserved
  {
    int[] value();
  }
  
  public static @interface VersionField
  {
    int access$getMMinValue();
    
    String getter();
    
    String type();
  }
}
