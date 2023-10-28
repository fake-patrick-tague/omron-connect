package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="FieldCreator")
@SafeParcelable.Reserved({1000})
public final class Field
  extends AbstractSafeParcelable
{
  @RecentlyNonNull
  public static final Parcelable.Creator<Field> CREATOR = new DownloadProgressInfo.1();
  @RecentlyNonNull
  public static final Field FIELD_ACCURACY;
  @RecentlyNonNull
  public static final Field FIELD_ACTIVITY = field("activity");
  @RecentlyNonNull
  public static final Field FIELD_ALTITUDE;
  @RecentlyNonNull
  public static final Field FIELD_AVERAGE;
  @RecentlyNonNull
  public static final Field FIELD_BPM;
  @RecentlyNonNull
  public static final Field FIELD_CALORIES;
  @Deprecated
  @RecentlyNonNull
  public static final Field FIELD_CIRCUMFERENCE = addField("circumference");
  @RecentlyNonNull
  public static final Field FIELD_CONFIDENCE;
  @RecentlyNonNull
  public static final Field FIELD_DISTANCE;
  @RecentlyNonNull
  public static final Field FIELD_DURATION;
  @RecentlyNonNull
  public static final Field FIELD_EXERCISE;
  @RecentlyNonNull
  public static final Field FIELD_FOOD_ITEM;
  @RecentlyNonNull
  public static final Field FIELD_HEIGHT;
  @RecentlyNonNull
  public static final Field FIELD_HIGH_LATITUDE;
  @RecentlyNonNull
  public static final Field FIELD_HIGH_LONGITUDE;
  @RecentlyNonNull
  public static final Field FIELD_INTENSITY;
  @RecentlyNonNull
  public static final Field FIELD_LATITUDE;
  @RecentlyNonNull
  public static final Field FIELD_LONGITUDE;
  @RecentlyNonNull
  public static final Field FIELD_LOW_LATITUDE;
  @RecentlyNonNull
  public static final Field FIELD_LOW_LONGITUDE;
  @RecentlyNonNull
  public static final Field FIELD_MAX;
  @RecentlyNonNull
  public static final Field FIELD_MEAL_TYPE;
  @RecentlyNonNull
  public static final Field FIELD_MIN;
  @RecentlyNonNull
  public static final Field FIELD_NUM_SEGMENTS;
  @RecentlyNonNull
  public static final Field FIELD_NUTRIENTS;
  @RecentlyNonNull
  public static final Field FIELD_OCCURRENCES;
  @RecentlyNonNull
  public static final Field FIELD_PERCENTAGE;
  @RecentlyNonNull
  public static final Field FIELD_REPETITIONS;
  @RecentlyNonNull
  public static final Field FIELD_RESISTANCE;
  @RecentlyNonNull
  public static final Field FIELD_RESISTANCE_TYPE;
  @RecentlyNonNull
  public static final Field FIELD_REVOLUTIONS;
  @RecentlyNonNull
  public static final Field FIELD_RPM;
  @RecentlyNonNull
  public static final Field FIELD_SLEEP_SEGMENT_TYPE = field("sleep_segment_type");
  @RecentlyNonNull
  public static final Field FIELD_SPEED;
  @RecentlyNonNull
  public static final Field FIELD_STEPS;
  @Deprecated
  @RecentlyNonNull
  public static final Field FIELD_STEP_LENGTH;
  @RecentlyNonNull
  public static final Field FIELD_VOLUME;
  @RecentlyNonNull
  public static final Field FIELD_WATTS;
  @RecentlyNonNull
  public static final Field FIELD_WEIGHT;
  public static final int FORMAT_FLOAT = 2;
  public static final int FORMAT_INT32 = 1;
  public static final int FORMAT_MAP = 4;
  public static final int FORMAT_STRING = 3;
  public static final int MEAL_TYPE_BREAKFAST = 1;
  public static final int MEAL_TYPE_DINNER = 3;
  public static final int MEAL_TYPE_LUNCH = 2;
  public static final int MEAL_TYPE_SNACK = 4;
  public static final int MEAL_TYPE_UNKNOWN = 0;
  @RecentlyNonNull
  public static final String NUTRIENT_CALCIUM = "calcium";
  @RecentlyNonNull
  public static final String NUTRIENT_CALORIES = "calories";
  @RecentlyNonNull
  public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
  @RecentlyNonNull
  public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
  @RecentlyNonNull
  public static final String NUTRIENT_IRON = "iron";
  @RecentlyNonNull
  public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
  @RecentlyNonNull
  public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
  @RecentlyNonNull
  public static final String NUTRIENT_POTASSIUM = "potassium";
  @RecentlyNonNull
  public static final String NUTRIENT_PROTEIN = "protein";
  @RecentlyNonNull
  public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
  @RecentlyNonNull
  public static final String NUTRIENT_SODIUM = "sodium";
  @RecentlyNonNull
  public static final String NUTRIENT_SUGAR = "sugar";
  @RecentlyNonNull
  public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
  @RecentlyNonNull
  public static final String NUTRIENT_TOTAL_FAT = "fat.total";
  @RecentlyNonNull
  public static final String NUTRIENT_TRANS_FAT = "fat.trans";
  @RecentlyNonNull
  public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
  @RecentlyNonNull
  public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
  @RecentlyNonNull
  public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
  public static final int RESISTANCE_TYPE_BARBELL = 1;
  public static final int RESISTANCE_TYPE_BODY = 6;
  public static final int RESISTANCE_TYPE_CABLE = 2;
  public static final int RESISTANCE_TYPE_DUMBBELL = 3;
  public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
  public static final int RESISTANCE_TYPE_MACHINE = 5;
  public static final int RESISTANCE_TYPE_UNKNOWN = 0;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zzmz;
  @ShowFirstParty
  private static final Field zzna;
  @ShowFirstParty
  private static final Field zznb;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zznc;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zznd;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zzne;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zznf;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zzng;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zznh;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zzni;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zznj;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zznk;
  @RecentlyNonNull
  @ShowFirstParty
  public static final Field zznl;
  @SafeParcelable.Field(getter="getFormat", id=2)
  private final int format;
  @SafeParcelable.Field(getter="getName", id=1)
  private final String name;
  @SafeParcelable.Field(getter="isOptional", id=3)
  private final Boolean zzmy;
  
  static
  {
    FIELD_CONFIDENCE = addField("confidence");
    FIELD_STEPS = field("steps");
    FIELD_STEP_LENGTH = addField("step_length");
    FIELD_DURATION = field("duration");
    zzmz = find("duration");
    zzna = cast("activity_duration.ascending");
    zznb = cast("activity_duration.descending");
    FIELD_BPM = addField("bpm");
    zznc = addField("respiratory_rate");
    FIELD_LATITUDE = addField("latitude");
    FIELD_LONGITUDE = addField("longitude");
    FIELD_ACCURACY = addField("accuracy");
    FIELD_ALTITUDE = put("altitude");
    FIELD_DISTANCE = addField("distance");
    FIELD_HEIGHT = addField("height");
    FIELD_WEIGHT = addField("weight");
    FIELD_PERCENTAGE = addField("percentage");
    FIELD_SPEED = addField("speed");
    FIELD_RPM = addField("rpm");
    zznd = convert("google.android.fitness.GoalV2");
    zzne = convert("google.android.fitness.Device");
    FIELD_REVOLUTIONS = field("revolutions");
    FIELD_CALORIES = addField("calories");
    FIELD_WATTS = addField("watts");
    FIELD_VOLUME = addField("volume");
    FIELD_MEAL_TYPE = find("meal_type");
    FIELD_FOOD_ITEM = new Field("food_item", 3, Boolean.TRUE);
    FIELD_NUTRIENTS = cast("nutrients");
    FIELD_EXERCISE = new Field("exercise", 3);
    FIELD_REPETITIONS = find("repetitions");
    FIELD_RESISTANCE = put("resistance");
    FIELD_RESISTANCE_TYPE = find("resistance_type");
    FIELD_NUM_SEGMENTS = field("num_segments");
    FIELD_AVERAGE = addField("average");
    FIELD_MAX = addField("max");
    FIELD_MIN = addField("min");
    FIELD_LOW_LATITUDE = addField("low_latitude");
    FIELD_LOW_LONGITUDE = addField("low_longitude");
    FIELD_HIGH_LATITUDE = addField("high_latitude");
    FIELD_HIGH_LONGITUDE = addField("high_longitude");
    FIELD_OCCURRENCES = field("occurrences");
    zznf = field("sensor_type");
    zzng = new Field("timestamps", 5);
    zznh = new Field("sensor_values", 6);
    FIELD_INTENSITY = addField("intensity");
    zzni = cast("activity_confidence");
    zznj = addField("probability");
    zznk = convert("google.android.fitness.SleepAttributes");
    zznl = convert("google.android.fitness.SleepSchedule");
  }
  
  public Field(String paramString, int paramInt)
  {
    this(paramString, paramInt, null);
  }
  
  public Field(String paramString, int paramInt, Boolean paramBoolean)
  {
    name = ((String)Preconditions.checkNotNull(paramString));
    format = paramInt;
    zzmy = paramBoolean;
  }
  
  public static Field addField(String paramString)
  {
    return new Field(paramString, 2);
  }
  
  private static Field cast(String paramString)
  {
    return new Field(paramString, 4);
  }
  
  private static Field convert(String paramString)
  {
    return new Field(paramString, 7);
  }
  
  private static Field field(String paramString)
  {
    return new Field(paramString, 1);
  }
  
  public static Field find(String paramString)
  {
    return new Field(paramString, 1, Boolean.TRUE);
  }
  
  private static Field put(String paramString)
  {
    return new Field(paramString, 2, Boolean.TRUE);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Field)) {
      return false;
    }
    paramObject = (Field)paramObject;
    return (name.equals(name)) && (format == format);
  }
  
  public final int getFormat()
  {
    return format;
  }
  
  public final String getName()
  {
    return name;
  }
  
  public final int hashCode()
  {
    return name.hashCode();
  }
  
  public final Boolean isOptional()
  {
    return zzmy;
  }
  
  public final String toString()
  {
    String str2 = name;
    String str1;
    if (format == 1) {
      str1 = "i";
    } else {
      str1 = "f";
    }
    return String.format("%s(%s)", new Object[] { str2, str1 });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 2, getFormat());
    SafeParcelWriter.writeBooleanObject(paramParcel, 3, isOptional(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}
