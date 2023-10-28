package androidx.media;

import android.util.SparseIntArray;
import androidx.versionedparcelable.Message;

public class AudioAttributesCompat
  implements Message
{
  private static final int[] context = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16 };
  private static final SparseIntArray mapping;
  AudioAttributesImpl b;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    mapping = localSparseIntArray;
    localSparseIntArray.put(5, 1);
    localSparseIntArray.put(6, 2);
    localSparseIntArray.put(7, 2);
    localSparseIntArray.put(8, 1);
    localSparseIntArray.put(9, 1);
    localSparseIntArray.put(10, 1);
  }
  
  AudioAttributesCompat() {}
  
  static String getResultString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 15: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown usage ");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    case 16: 
      return "USAGE_ASSISTANT";
    case 14: 
      return "USAGE_GAME";
    case 13: 
      return "USAGE_ASSISTANCE_SONIFICATION";
    case 12: 
      return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
    case 11: 
      return "USAGE_ASSISTANCE_ACCESSIBILITY";
    case 10: 
      return "USAGE_NOTIFICATION_EVENT";
    case 9: 
      return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
    case 8: 
      return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
    case 7: 
      return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
    case 6: 
      return "USAGE_NOTIFICATION_RINGTONE";
    case 5: 
      return "USAGE_NOTIFICATION";
    case 4: 
      return "USAGE_ALARM";
    case 3: 
      return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
    case 2: 
      return "USAGE_VOICE_COMMUNICATION";
    case 1: 
      return "USAGE_MEDIA";
    }
    return "USAGE_UNKNOWN";
  }
  
  static int write(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 1)
    {
      if (paramBoolean) {
        return 1;
      }
      return 7;
    }
    int i = 0;
    if ((paramInt1 & 0x4) == 4)
    {
      if (paramBoolean) {
        return 0;
      }
      return 6;
    }
    paramInt1 = i;
    switch (paramInt2)
    {
    default: 
      break;
    case 15: 
      if (paramBoolean) {
        break label224;
      }
      return 3;
    case 13: 
      return 1;
    case 11: 
      return 10;
    case 6: 
      return 2;
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      return 5;
    case 4: 
      return 4;
    case 3: 
      if (paramBoolean) {
        return 0;
      }
      paramInt1 = 8;
    case 2: 
      return paramInt1;
    case 1: 
    case 12: 
    case 14: 
    case 16: 
      return 3;
    }
    if (paramBoolean)
    {
      return Integer.MIN_VALUE;
      label224:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown usage value ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" in audio attributes");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return 3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesCompat)) {
      return false;
    }
    paramObject = (AudioAttributesCompat)paramObject;
    AudioAttributesImpl localAudioAttributesImpl = b;
    if (localAudioAttributesImpl == null)
    {
      if (b == null) {
        return true;
      }
    }
    else {
      return localAudioAttributesImpl.equals(b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return b.hashCode();
  }
  
  public String toString()
  {
    return b.toString();
  }
}
