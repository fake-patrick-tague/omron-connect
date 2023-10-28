package com.google.android.gms.fitness.data;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ShowFirstParty
public final class Locations
{
  private static final Set<DataType> zzmo = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DataType[] { DataType.TYPE_MOVE_MINUTES, DataType.AGGREGATE_MOVE_MINUTES, DataType.TYPE_WORKOUT_EXERCISE, DataType.zzmj, DataType.TYPE_ACTIVITY_SEGMENT, DataType.AGGREGATE_ACTIVITY_SUMMARY, HealthDataTypes.TYPE_BLOOD_GLUCOSE, HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY, HealthDataTypes.TYPE_BLOOD_PRESSURE, HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY, DataType.TYPE_BODY_FAT_PERCENTAGE, DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY, HealthDataTypes.TYPE_BODY_TEMPERATURE, HealthDataTypes.TYPE_BASAL_BODY_TEMPERATURE, HealthDataTypes.AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY, HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY, DataType.TYPE_BASAL_METABOLIC_RATE, DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY, DataType.zzmk, DataType.zzml, DataType.TYPE_CALORIES_EXPENDED, DataType.AGGREGATE_CALORIES_EXPENDED, HealthDataTypes.TYPE_CERVICAL_MUCUS, HealthDataTypes.TYPE_CERVICAL_POSITION, DataType.TYPE_CYCLING_PEDALING_CADENCE, DataType.TYPE_CYCLING_PEDALING_CUMULATIVE, DataType.TYPE_CYCLING_WHEEL_REVOLUTION, DataType.TYPE_CYCLING_WHEEL_RPM, DataType.zzmh, DataType.zzmg, DataType.TYPE_DISTANCE_DELTA, DataType.AGGREGATE_DISTANCE_DELTA, DataType.TYPE_HEART_POINTS, DataType.AGGREGATE_HEART_POINTS, DataType.TYPE_HEART_RATE_BPM, DataType.AGGREGATE_HEART_RATE_SUMMARY, DataType.TYPE_HEIGHT, DataType.AGGREGATE_HEIGHT_SUMMARY, DataType.TYPE_HYDRATION, DataType.AGGREGATE_HYDRATION, DataType.zzmd, DataType.zzmi, DataType.zzmm, DataType.zzmn, DataType.AGGREGATE_LOCATION_BOUNDING_BOX, DataType.TYPE_LOCATION_SAMPLE, DataType.TYPE_LOCATION_TRACK, HealthDataTypes.TYPE_MENSTRUATION, DataType.TYPE_NUTRITION, DataType.AGGREGATE_NUTRITION_SUMMARY, HealthDataTypes.TYPE_OVULATION_TEST, HealthDataTypes.TYPE_OXYGEN_SATURATION, HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY, DataType.TYPE_POWER_SAMPLE, DataType.AGGREGATE_POWER_SUMMARY, DataType.zzmf, DataType.zzme, DataType.TYPE_SLEEP_SEGMENT, DataType.TYPE_SPEED, DataType.AGGREGATE_SPEED_SUMMARY, DataType.TYPE_STEP_COUNT_CADENCE, DataType.TYPE_STEP_COUNT_CUMULATIVE, DataType.TYPE_STEP_COUNT_DELTA, DataType.AGGREGATE_STEP_COUNT_DELTA, HealthDataTypes.TYPE_VAGINAL_SPOTTING, DataType.TYPE_WEIGHT, DataType.AGGREGATE_WEIGHT_SUMMARY })));
  
  public static DataType getInstalledApps(String paramString)
  {
    paramString.hashCode();
    int j = paramString.hashCode();
    int i = -1;
    switch (j)
    {
    default: 
      break;
    case 2131809416: 
      if (paramString.equals("com.google.body.temperature.summary")) {
        i = 60;
      }
      break;
    case 2053496735: 
      if (paramString.equals("com.google.speed")) {
        i = 59;
      }
      break;
    case 2051843553: 
      if (paramString.equals("com.google.oxygen_saturation.summary")) {
        i = 58;
      }
      break;
    case 1975902189: 
      if (paramString.equals("com.google.cervical_mucus")) {
        i = 57;
      }
      break;
    case 1925848149: 
      if (paramString.equals("com.google.cervical_position")) {
        i = 56;
      }
      break;
    case 1921738212: 
      if (paramString.equals("com.google.distance.cumulative")) {
        i = 55;
      }
      break;
    case 1633152752: 
      if (paramString.equals("com.google.nutrition")) {
        i = 54;
      }
      break;
    case 1532018766: 
      if (paramString.equals("com.google.active_minutes")) {
        i = 53;
      }
      break;
    case 1524007137: 
      if (paramString.equals("com.google.cycling.wheel_revolution.cumulative")) {
        i = 52;
      }
      break;
    case 1498973736: 
      if (paramString.equals("com.google.internal.sleep_attributes")) {
        i = 51;
      }
      break;
    case 1483133089: 
      if (paramString.equals("com.google.body.temperature.basal")) {
        i = 50;
      }
      break;
    case 1439932546: 
      if (paramString.equals("com.google.ovulation_test")) {
        i = 49;
      }
      break;
    case 1404118825: 
      if (paramString.equals("com.google.oxygen_saturation")) {
        i = 48;
      }
      break;
    case 1214093899: 
      if (paramString.equals("com.google.vaginal_spotting")) {
        i = 47;
      }
      break;
    case 1111714923: 
      if (paramString.equals("com.google.body.fat.percentage.summary")) {
        i = 46;
      }
      break;
    case 1029221057: 
      if (paramString.equals("com.google.device_on_body")) {
        i = 45;
      }
      break;
    case 946706510: 
      if (paramString.equals("com.google.hydration")) {
        i = 44;
      }
      break;
    case 936279698: 
      if (paramString.equals("com.google.blood_pressure")) {
        i = 43;
      }
      break;
    case 899666941: 
      if (paramString.equals("com.google.calories.expended")) {
        i = 42;
      }
      break;
    case 877955159: 
      if (paramString.equals("com.google.speed.summary")) {
        i = 41;
      }
      break;
    case 841663855: 
      if (paramString.equals("com.google.activity.summary")) {
        i = 40;
      }
      break;
    case 682891187: 
      if (paramString.equals("com.google.body.fat.percentage")) {
        i = 39;
      }
      break;
    case 657433501: 
      if (paramString.equals("com.google.step_count.cumulative")) {
        i = 38;
      }
      break;
    case 529727579: 
      if (paramString.equals("com.google.power.sample")) {
        i = 37;
      }
      break;
    case 378060028: 
      if (paramString.equals("com.google.activity.segment")) {
        i = 36;
      }
      break;
    case 324760871: 
      if (paramString.equals("com.google.step_count.cadence")) {
        i = 35;
      }
      break;
    case 296250623: 
      if (paramString.equals("com.google.calories.bmr.summary")) {
        i = 34;
      }
      break;
    case 295793957: 
      if (paramString.equals("com.google.sensor.events")) {
        i = 33;
      }
      break;
    case 269180370: 
      if (paramString.equals("com.google.activity.samples")) {
        i = 32;
      }
      break;
    case 53773386: 
      if (paramString.equals("com.google.blood_pressure.summary")) {
        i = 31;
      }
      break;
    case -56824761: 
      if (paramString.equals("com.google.calories.bmr")) {
        i = 30;
      }
      break;
    case -98150574: 
      if (paramString.equals("com.google.heart_rate.bpm")) {
        i = 29;
      }
      break;
    case -164586193: 
      if (paramString.equals("com.google.activity.exercise")) {
        i = 28;
      }
      break;
    case -177293656: 
      if (paramString.equals("com.google.nutrition.summary")) {
        i = 27;
      }
      break;
    case -185830635: 
      if (paramString.equals("com.google.power.summary")) {
        i = 26;
      }
      break;
    case -217611775: 
      if (paramString.equals("com.google.blood_glucose")) {
        i = 25;
      }
      break;
    case -316596620: 
      if (paramString.equals("com.google.sleep.segment")) {
        i = 24;
      }
      break;
    case -362418992: 
      if (paramString.equals("com.google.body.temperature")) {
        i = 23;
      }
      break;
    case -424876584: 
      if (paramString.equals("com.google.weight.summary")) {
        i = 22;
      }
      break;
    case -661631456: 
      if (paramString.equals("com.google.weight")) {
        i = 21;
      }
      break;
    case -700668164: 
      if (paramString.equals("com.google.internal.goal")) {
        i = 20;
      }
      break;
    case -777285735: 
      if (paramString.equals("com.google.heart_rate.summary")) {
        i = 19;
      }
      break;
    case -886569606: 
      if (paramString.equals("com.google.location.track")) {
        i = 18;
      }
      break;
    case -900592674: 
      if (paramString.equals("com.google.cycling.pedaling.cadence")) {
        i = 17;
      }
      break;
    case -922976890: 
      if (paramString.equals("com.google.cycling.pedaling.cumulative")) {
        i = 16;
      }
      break;
    case -1091068721: 
      if (paramString.equals("com.google.height")) {
        i = 15;
      }
      break;
    case -1102520626: 
      if (paramString.equals("com.google.step_count.delta")) {
        i = 14;
      }
      break;
    case -1103712522: 
      if (paramString.equals("com.google.heart_minutes.summary")) {
        i = 13;
      }
      break;
    case -1248818137: 
      if (paramString.equals("com.google.distance.delta")) {
        i = 12;
      }
      break;
    case -1416335448: 
      if (paramString.equals("com.google.internal.sleep_schedule")) {
        i = 11;
      }
      break;
    case -1431431801: 
      if (paramString.equals("com.google.height.summary")) {
        i = 10;
      }
      break;
    case -1465729060: 
      if (paramString.equals("com.google.internal.primary_device")) {
        i = 9;
      }
      break;
    case -1487055015: 
      if (paramString.equals("com.google.body.temperature.basal.summary")) {
        i = 8;
      }
      break;
    case -1659958877: 
      if (paramString.equals("com.google.menstruation")) {
        i = 7;
      }
      break;
    case -1757812901: 
      if (paramString.equals("com.google.location.sample")) {
        i = 6;
      }
      break;
    case -1939429191: 
      if (paramString.equals("com.google.blood_glucose.summary")) {
        i = 5;
      }
      break;
    case -1999891138: 
      if (paramString.equals("com.google.heart_minutes")) {
        i = 4;
      }
      break;
    case -2023954015: 
      if (paramString.equals("com.google.location.bounding_box")) {
        i = 3;
      }
      break;
    case -2027664088: 
      if (paramString.equals("com.google.calories.consumed")) {
        i = 2;
      }
      break;
    case -2032495331: 
      if (paramString.equals("com.google.respiratory_rate")) {
        i = 1;
      }
      break;
    case -2060095039: 
      if (paramString.equals("com.google.cycling.wheel_revolution.rpm")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return null;
    case 60: 
      return HealthDataTypes.AGGREGATE_BODY_TEMPERATURE_SUMMARY;
    case 59: 
      return DataType.TYPE_SPEED;
    case 58: 
      return HealthDataTypes.AGGREGATE_OXYGEN_SATURATION_SUMMARY;
    case 57: 
      return HealthDataTypes.TYPE_CERVICAL_MUCUS;
    case 56: 
      return HealthDataTypes.TYPE_CERVICAL_POSITION;
    case 55: 
      return DataType.zzmg;
    case 54: 
      return DataType.TYPE_NUTRITION;
    case 53: 
      return DataType.TYPE_MOVE_MINUTES;
    case 52: 
      return DataType.TYPE_CYCLING_WHEEL_REVOLUTION;
    case 51: 
      return DataType.zzmm;
    case 50: 
      return HealthDataTypes.TYPE_BASAL_BODY_TEMPERATURE;
    case 49: 
      return HealthDataTypes.TYPE_OVULATION_TEST;
    case 48: 
      return HealthDataTypes.TYPE_OXYGEN_SATURATION;
    case 47: 
      return HealthDataTypes.TYPE_VAGINAL_SPOTTING;
    case 46: 
      return DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY;
    case 45: 
      return DataType.zzmh;
    case 44: 
      return DataType.TYPE_HYDRATION;
    case 43: 
      return HealthDataTypes.TYPE_BLOOD_PRESSURE;
    case 42: 
      return DataType.TYPE_CALORIES_EXPENDED;
    case 41: 
      return DataType.AGGREGATE_SPEED_SUMMARY;
    case 40: 
      return DataType.AGGREGATE_ACTIVITY_SUMMARY;
    case 39: 
      return DataType.TYPE_BODY_FAT_PERCENTAGE;
    case 38: 
      return DataType.TYPE_STEP_COUNT_CUMULATIVE;
    case 37: 
      return DataType.TYPE_POWER_SAMPLE;
    case 36: 
      return DataType.TYPE_ACTIVITY_SEGMENT;
    case 35: 
      return DataType.TYPE_STEP_COUNT_CADENCE;
    case 34: 
      return DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY;
    case 33: 
      return DataType.zzme;
    case 32: 
      return DataType.zzmj;
    case 31: 
      return HealthDataTypes.AGGREGATE_BLOOD_PRESSURE_SUMMARY;
    case 30: 
      return DataType.TYPE_BASAL_METABOLIC_RATE;
    case 29: 
      return DataType.TYPE_HEART_RATE_BPM;
    case 28: 
      return DataType.TYPE_WORKOUT_EXERCISE;
    case 27: 
      return DataType.AGGREGATE_NUTRITION_SUMMARY;
    case 26: 
      return DataType.AGGREGATE_POWER_SUMMARY;
    case 25: 
      return HealthDataTypes.TYPE_BLOOD_GLUCOSE;
    case 24: 
      return DataType.TYPE_SLEEP_SEGMENT;
    case 23: 
      return HealthDataTypes.TYPE_BODY_TEMPERATURE;
    case 22: 
      return DataType.AGGREGATE_WEIGHT_SUMMARY;
    case 21: 
      return DataType.TYPE_WEIGHT;
    case 20: 
      return DataType.zzmd;
    case 19: 
      return DataType.AGGREGATE_HEART_RATE_SUMMARY;
    case 18: 
      return DataType.TYPE_LOCATION_TRACK;
    case 17: 
      return DataType.TYPE_CYCLING_PEDALING_CADENCE;
    case 16: 
      return DataType.TYPE_CYCLING_PEDALING_CUMULATIVE;
    case 15: 
      return DataType.TYPE_HEIGHT;
    case 14: 
      return DataType.TYPE_STEP_COUNT_DELTA;
    case 13: 
      return DataType.AGGREGATE_HEART_POINTS;
    case 12: 
      return DataType.TYPE_DISTANCE_DELTA;
    case 11: 
      return DataType.zzmn;
    case 10: 
      return DataType.AGGREGATE_HEIGHT_SUMMARY;
    case 9: 
      return DataType.zzmi;
    case 8: 
      return HealthDataTypes.AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY;
    case 7: 
      return HealthDataTypes.TYPE_MENSTRUATION;
    case 6: 
      return DataType.TYPE_LOCATION_SAMPLE;
    case 5: 
      return HealthDataTypes.AGGREGATE_BLOOD_GLUCOSE_SUMMARY;
    case 4: 
      return DataType.TYPE_HEART_POINTS;
    case 3: 
      return DataType.AGGREGATE_LOCATION_BOUNDING_BOX;
    case 2: 
      return DataType.zzmk;
    case 1: 
      return DataType.zzmf;
    }
    return DataType.TYPE_CYCLING_WHEEL_RPM;
  }
}
