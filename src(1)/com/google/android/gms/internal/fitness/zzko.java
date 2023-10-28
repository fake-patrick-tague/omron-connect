package com.google.android.gms.internal.fitness;

public final class zzko
{
  private static final String[] zzajb;
  
  static
  {
    String[] arrayOfString = new String[123];
    zzajb = arrayOfString;
    arrayOfString[9] = "aerobics";
    arrayOfString[119] = "archery";
    arrayOfString[10] = "badminton";
    arrayOfString[11] = "baseball";
    arrayOfString[12] = "basketball";
    arrayOfString[13] = "biathlon";
    arrayOfString[1] = "biking";
    arrayOfString[14] = "biking.hand";
    arrayOfString[15] = "biking.mountain";
    arrayOfString[16] = "biking.road";
    arrayOfString[17] = "biking.spinning";
    arrayOfString[18] = "biking.stationary";
    arrayOfString[19] = "biking.utility";
    arrayOfString[20] = "boxing";
    arrayOfString[21] = "calisthenics";
    arrayOfString[22] = "circuit_training";
    arrayOfString[23] = "cricket";
    arrayOfString[113] = "crossfit";
    arrayOfString[106] = "curling";
    arrayOfString[24] = "dancing";
    arrayOfString[102] = "diving";
    arrayOfString[117] = "elevator";
    arrayOfString[25] = "elliptical";
    arrayOfString[103] = "ergometer";
    arrayOfString[118] = "escalator";
    arrayOfString[6] = "exiting_vehicle";
    arrayOfString[26] = "fencing";
    arrayOfString[121] = "flossing";
    arrayOfString[27] = "football.american";
    arrayOfString[28] = "football.australian";
    arrayOfString[29] = "football.soccer";
    arrayOfString[30] = "frisbee_disc";
    arrayOfString[31] = "gardening";
    arrayOfString[32] = "golf";
    arrayOfString[122] = "guided_breathing";
    arrayOfString[33] = "gymnastics";
    arrayOfString[34] = "handball";
    arrayOfString[114] = "interval_training.high_intensity";
    arrayOfString[35] = "hiking";
    arrayOfString[36] = "hockey";
    arrayOfString[37] = "horseback_riding";
    arrayOfString[38] = "housework";
    arrayOfString[104] = "ice_skating";
    arrayOfString[115] = "interval_training";
    arrayOfString[0] = "in_vehicle";
    arrayOfString[39] = "jump_rope";
    arrayOfString[40] = "kayaking";
    arrayOfString[41] = "kettlebell_training";
    arrayOfString[42] = "kickboxing";
    arrayOfString[107] = "kick_scooter";
    arrayOfString[43] = "kitesurfing";
    arrayOfString[44] = "martial_arts";
    arrayOfString[45] = "meditation";
    arrayOfString[46] = "martial_arts.mixed";
    arrayOfString[2] = "on_foot";
    arrayOfString[108] = "other";
    arrayOfString[47] = "p90x";
    arrayOfString[48] = "paragliding";
    arrayOfString[49] = "pilates";
    arrayOfString[50] = "polo";
    arrayOfString[51] = "racquetball";
    arrayOfString[52] = "rock_climbing";
    arrayOfString[53] = "rowing";
    arrayOfString[54] = "rowing.machine";
    arrayOfString[55] = "rugby";
    arrayOfString[8] = "running";
    arrayOfString[56] = "running.jogging";
    arrayOfString[57] = "running.sand";
    arrayOfString[58] = "running.treadmill";
    arrayOfString[59] = "sailing";
    arrayOfString[60] = "scuba_diving";
    arrayOfString[61] = "skateboarding";
    arrayOfString[62] = "skating";
    arrayOfString[63] = "skating.cross";
    arrayOfString[105] = "skating.indoor";
    arrayOfString[64] = "skating.inline";
    arrayOfString[65] = "skiing";
    arrayOfString[66] = "skiing.back_country";
    arrayOfString[67] = "skiing.cross_country";
    arrayOfString[68] = "skiing.downhill";
    arrayOfString[69] = "skiing.kite";
    arrayOfString[70] = "skiing.roller";
    arrayOfString[71] = "sledding";
    arrayOfString[72] = "sleep";
    arrayOfString[112] = "sleep.awake";
    arrayOfString[110] = "sleep.deep";
    arrayOfString[109] = "sleep.light";
    arrayOfString[111] = "sleep.rem";
    arrayOfString[73] = "snowboarding";
    arrayOfString[74] = "snowmobile";
    arrayOfString[75] = "snowshoeing";
    arrayOfString[120] = "softball";
    arrayOfString[76] = "squash";
    arrayOfString[77] = "stair_climbing";
    arrayOfString[78] = "stair_climbing.machine";
    arrayOfString[79] = "standup_paddleboarding";
    arrayOfString[3] = "still";
    arrayOfString[80] = "strength_training";
    arrayOfString[81] = "surfing";
    arrayOfString[82] = "swimming";
    arrayOfString[84] = "swimming.open_water";
    arrayOfString[83] = "swimming.pool";
    arrayOfString[85] = "table_tennis";
    arrayOfString[86] = "team_sports";
    arrayOfString[87] = "tennis";
    arrayOfString[5] = "tilting";
    arrayOfString[88] = "treadmill";
    arrayOfString[4] = "unknown";
    arrayOfString[89] = "volleyball";
    arrayOfString[90] = "volleyball.beach";
    arrayOfString[91] = "volleyball.indoor";
    arrayOfString[92] = "wakeboarding";
    arrayOfString[7] = "walking";
    arrayOfString[93] = "walking.fitness";
    arrayOfString[94] = "walking.nordic";
    arrayOfString[116] = "walking.stroller";
    arrayOfString[95] = "walking.treadmill";
    arrayOfString[96] = "water_polo";
    arrayOfString[97] = "weightlifting";
    arrayOfString[98] = "wheelchair";
    arrayOfString[99] = "windsurfing";
    arrayOfString[100] = "yoga";
    arrayOfString[101] = "zumba";
  }
  
  public static int findPosition(String paramString)
  {
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = zzajb;
      if (i >= arrayOfString.length) {
        break;
      }
      if (arrayOfString[i].equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return 4;
  }
  
  public static String getMimeType(String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return "vnd.google.fitness.activity/".concat(paramString);
    }
    return new String("vnd.google.fitness.activity/");
  }
  
  public static String getName(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = zzajb;
      if (paramInt >= localObject.length) {
        return "unknown";
      }
      localObject = localObject[paramInt];
      if (localObject == null) {
        return "unknown";
      }
      return localObject;
    }
    return "unknown";
  }
}
