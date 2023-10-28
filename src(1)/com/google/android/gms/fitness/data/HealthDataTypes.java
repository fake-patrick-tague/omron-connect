package com.google.android.gms.fitness.data;

import androidx.annotation.RecentlyNonNull;

public final class HealthDataTypes
{
  @Deprecated
  @RecentlyNonNull
  public static final DataType AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY;
  @RecentlyNonNull
  public static final DataType AGGREGATE_BLOOD_GLUCOSE_SUMMARY;
  @RecentlyNonNull
  public static final DataType AGGREGATE_BLOOD_PRESSURE_SUMMARY;
  @RecentlyNonNull
  public static final DataType AGGREGATE_BODY_TEMPERATURE_SUMMARY;
  @RecentlyNonNull
  public static final DataType AGGREGATE_OXYGEN_SATURATION_SUMMARY;
  @Deprecated
  @RecentlyNonNull
  public static final DataType TYPE_BASAL_BODY_TEMPERATURE;
  @RecentlyNonNull
  public static final DataType TYPE_BLOOD_GLUCOSE;
  @RecentlyNonNull
  public static final DataType TYPE_BLOOD_PRESSURE;
  @RecentlyNonNull
  public static final DataType TYPE_BODY_TEMPERATURE;
  @RecentlyNonNull
  public static final DataType TYPE_CERVICAL_MUCUS;
  @RecentlyNonNull
  public static final DataType TYPE_CERVICAL_POSITION;
  @RecentlyNonNull
  public static final DataType TYPE_MENSTRUATION;
  @RecentlyNonNull
  public static final DataType TYPE_OVULATION_TEST;
  @RecentlyNonNull
  public static final DataType TYPE_OXYGEN_SATURATION;
  @RecentlyNonNull
  public static final DataType TYPE_VAGINAL_SPOTTING;
  
  static
  {
    Field localField1 = HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC;
    Field localField2 = HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC;
    Field localField5 = HealthFields.FIELD_BODY_POSITION;
    Field localField6 = HealthFields.FIELD_BLOOD_PRESSURE_MEASUREMENT_LOCATION;
    TYPE_BLOOD_PRESSURE = new DataType("com.google.blood_pressure", 1, "https://www.googleapis.com/auth/fitness.blood_pressure.read", "https://www.googleapis.com/auth/fitness.blood_pressure.write", new Field[] { localField1, localField2, localField5, localField6 });
    Field localField7 = HealthFields.FIELD_BLOOD_GLUCOSE_LEVEL;
    localField1 = HealthFields.FIELD_TEMPORAL_RELATION_TO_MEAL;
    localField2 = Field.FIELD_MEAL_TYPE;
    Field localField3 = HealthFields.FIELD_TEMPORAL_RELATION_TO_SLEEP;
    Field localField4 = HealthFields.FIELD_BLOOD_GLUCOSE_SPECIMEN_SOURCE;
    TYPE_BLOOD_GLUCOSE = new DataType("com.google.blood_glucose", 1, "https://www.googleapis.com/auth/fitness.blood_glucose.read", "https://www.googleapis.com/auth/fitness.blood_glucose.write", new Field[] { localField7, localField1, localField2, localField3, localField4 });
    Field localField10 = HealthFields.FIELD_OXYGEN_SATURATION;
    Field localField11 = HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE;
    localField7 = HealthFields.FIELD_OXYGEN_THERAPY_ADMINISTRATION_MODE;
    Field localField8 = HealthFields.FIELD_OXYGEN_SATURATION_SYSTEM;
    Field localField9 = HealthFields.FIELD_OXYGEN_SATURATION_MEASUREMENT_METHOD;
    TYPE_OXYGEN_SATURATION = new DataType("com.google.oxygen_saturation", 1, "https://www.googleapis.com/auth/fitness.oxygen_saturation.read", "https://www.googleapis.com/auth/fitness.oxygen_saturation.write", new Field[] { localField10, localField11, localField7, localField8, localField9 });
    localField11 = HealthFields.FIELD_BODY_TEMPERATURE;
    localField10 = HealthFields.FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION;
    TYPE_BODY_TEMPERATURE = new DataType("com.google.body.temperature", 1, "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", new Field[] { localField11, localField10 });
    TYPE_BASAL_BODY_TEMPERATURE = new DataType("com.google.body.temperature.basal", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { localField11, localField10 });
    TYPE_CERVICAL_MUCUS = new DataType("com.google.cervical_mucus", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { HealthFields.FIELD_CERVICAL_MUCUS_TEXTURE, HealthFields.FIELD_CERVICAL_MUCUS_AMOUNT });
    TYPE_CERVICAL_POSITION = new DataType("com.google.cervical_position", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { HealthFields.FIELD_CERVICAL_POSITION, HealthFields.FIELD_CERVICAL_DILATION, HealthFields.FIELD_CERVICAL_FIRMNESS });
    TYPE_MENSTRUATION = new DataType("com.google.menstruation", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { HealthFields.FIELD_MENSTRUAL_FLOW });
    TYPE_OVULATION_TEST = new DataType("com.google.ovulation_test", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { HealthFields.FIELD_OVULATION_TEST_RESULT });
    TYPE_VAGINAL_SPOTTING = new DataType("com.google.vaginal_spotting", 1, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { Field.FIELD_OCCURRENCES });
    AGGREGATE_BLOOD_PRESSURE_SUMMARY = new DataType("com.google.blood_pressure.summary", 2, "https://www.googleapis.com/auth/fitness.blood_pressure.read", "https://www.googleapis.com/auth/fitness.blood_pressure.write", new Field[] { HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_AVERAGE, HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MAX, HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MIN, HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_AVERAGE, HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MAX, HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MIN, localField5, localField6 });
    localField5 = Field.FIELD_AVERAGE;
    localField6 = Field.FIELD_MAX;
    localField11 = Field.FIELD_MIN;
    AGGREGATE_BLOOD_GLUCOSE_SUMMARY = new DataType("com.google.blood_glucose.summary", 2, "https://www.googleapis.com/auth/fitness.blood_glucose.read", "https://www.googleapis.com/auth/fitness.blood_glucose.write", new Field[] { localField5, localField6, localField11, localField1, localField2, localField3, localField4 });
    AGGREGATE_OXYGEN_SATURATION_SUMMARY = new DataType("com.google.oxygen_saturation.summary", 2, "https://www.googleapis.com/auth/fitness.oxygen_saturation.read", "https://www.googleapis.com/auth/fitness.oxygen_saturation.write", new Field[] { HealthFields.FIELD_OXYGEN_SATURATION_AVERAGE, HealthFields.FIELD_OXYGEN_SATURATION_MAX, HealthFields.FIELD_OXYGEN_SATURATION_MIN, HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_AVERAGE, HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MAX, HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MIN, localField7, localField8, localField9 });
    AGGREGATE_BODY_TEMPERATURE_SUMMARY = new DataType("com.google.body.temperature.summary", 2, "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", new Field[] { localField5, localField6, localField11, localField10 });
    AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY = new DataType("com.google.body.temperature.basal.summary", 2, "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { localField5, localField6, localField11, localField10 });
  }
  
  private HealthDataTypes() {}
}
