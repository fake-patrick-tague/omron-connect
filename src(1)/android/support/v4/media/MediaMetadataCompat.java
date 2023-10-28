package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import c.e.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;
import v7.util.ArrayMap;
import v7.util.SimpleArrayMap;

public final class MediaMetadataCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new Parcelable.Creator()
  {
    public MediaMetadataCompat createFromParcel(Parcel paramAnonymousParcel)
    {
      return new MediaMetadataCompat(paramAnonymousParcel);
    }
    
    public MediaMetadataCompat[] newArray(int paramAnonymousInt)
    {
      return new MediaMetadataCompat[paramAnonymousInt];
    }
  };
  static final a<String, Integer> METADATA_KEYS_TYPE;
  public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
  public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
  public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
  public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
  public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
  public static final String METADATA_KEY_ART = "android.media.metadata.ART";
  public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
  public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
  public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
  public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
  public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
  public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
  public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
  public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
  public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
  public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
  public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
  public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
  public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
  public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
  public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
  public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
  public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
  public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
  public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
  public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
  public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
  public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
  public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
  public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
  public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
  static final int METADATA_TYPE_BITMAP = 2;
  static final int METADATA_TYPE_LONG = 0;
  static final int METADATA_TYPE_RATING = 3;
  static final int METADATA_TYPE_TEXT = 1;
  private static final String[] PREFERRED_BITMAP_ORDER;
  private static final String[] PREFERRED_DESCRIPTION_ORDER;
  private static final String[] PREFERRED_URI_ORDER;
  private static final String TAG = "MediaMetadata";
  final Bundle mBundle;
  private MediaDescriptionCompat mDescription;
  private Object mMetadataObj;
  
  static
  {
    ArrayMap localArrayMap = new ArrayMap();
    METADATA_KEYS_TYPE = localArrayMap;
    Integer localInteger1 = Integer.valueOf(1);
    localArrayMap.put("android.media.metadata.TITLE", localInteger1);
    localArrayMap.put("android.media.metadata.ARTIST", localInteger1);
    Integer localInteger2 = Integer.valueOf(0);
    localArrayMap.put("android.media.metadata.DURATION", localInteger2);
    localArrayMap.put("android.media.metadata.ALBUM", localInteger1);
    localArrayMap.put("android.media.metadata.AUTHOR", localInteger1);
    localArrayMap.put("android.media.metadata.WRITER", localInteger1);
    localArrayMap.put("android.media.metadata.COMPOSER", localInteger1);
    localArrayMap.put("android.media.metadata.COMPILATION", localInteger1);
    localArrayMap.put("android.media.metadata.DATE", localInteger1);
    localArrayMap.put("android.media.metadata.YEAR", localInteger2);
    localArrayMap.put("android.media.metadata.GENRE", localInteger1);
    localArrayMap.put("android.media.metadata.TRACK_NUMBER", localInteger2);
    localArrayMap.put("android.media.metadata.NUM_TRACKS", localInteger2);
    localArrayMap.put("android.media.metadata.DISC_NUMBER", localInteger2);
    localArrayMap.put("android.media.metadata.ALBUM_ARTIST", localInteger1);
    Integer localInteger3 = Integer.valueOf(2);
    localArrayMap.put("android.media.metadata.ART", localInteger3);
    localArrayMap.put("android.media.metadata.ART_URI", localInteger1);
    localArrayMap.put("android.media.metadata.ALBUM_ART", localInteger3);
    localArrayMap.put("android.media.metadata.ALBUM_ART_URI", localInteger1);
    Integer localInteger4 = Integer.valueOf(3);
    localArrayMap.put("android.media.metadata.USER_RATING", localInteger4);
    localArrayMap.put("android.media.metadata.RATING", localInteger4);
    localArrayMap.put("android.media.metadata.DISPLAY_TITLE", localInteger1);
    localArrayMap.put("android.media.metadata.DISPLAY_SUBTITLE", localInteger1);
    localArrayMap.put("android.media.metadata.DISPLAY_DESCRIPTION", localInteger1);
    localArrayMap.put("android.media.metadata.DISPLAY_ICON", localInteger3);
    localArrayMap.put("android.media.metadata.DISPLAY_ICON_URI", localInteger1);
    localArrayMap.put("android.media.metadata.MEDIA_ID", localInteger1);
    localArrayMap.put("android.media.metadata.BT_FOLDER_TYPE", localInteger2);
    localArrayMap.put("android.media.metadata.MEDIA_URI", localInteger1);
    localArrayMap.put("android.media.metadata.ADVERTISEMENT", localInteger2);
    localArrayMap.put("android.media.metadata.DOWNLOAD_STATUS", localInteger2);
    PREFERRED_DESCRIPTION_ORDER = new String[] { "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER" };
    PREFERRED_BITMAP_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART" };
    PREFERRED_URI_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI" };
  }
  
  MediaMetadataCompat(Bundle paramBundle)
  {
    paramBundle = new Bundle(paramBundle);
    mBundle = paramBundle;
    MediaSessionCompat.ensureClassLoader(paramBundle);
  }
  
  MediaMetadataCompat(Parcel paramParcel)
  {
    mBundle = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
  }
  
  public static MediaMetadataCompat fromMediaMetadata(Object paramObject)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      Parcel localParcel = Parcel.obtain();
      MediaMetadataCompatApi21.writeToParcel(paramObject, localParcel, 0);
      localParcel.setDataPosition(0);
      MediaMetadataCompat localMediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      mMetadataObj = paramObject;
      return localMediaMetadataCompat;
    }
    return null;
  }
  
  public boolean containsKey(String paramString)
  {
    return mBundle.containsKey(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getBitmap(String paramString)
  {
    Bundle localBundle = mBundle;
    try
    {
      paramString = localBundle.getParcelable(paramString);
      return (Bitmap)paramString;
    }
    catch (Exception paramString)
    {
      Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", paramString);
    }
    return null;
  }
  
  public Bundle getBundle()
  {
    return new Bundle(mBundle);
  }
  
  public MediaDescriptionCompat getDescription()
  {
    Object localObject1 = mDescription;
    if (localObject1 != null) {
      return localObject1;
    }
    String str = getString("android.media.metadata.MEDIA_ID");
    CharSequence[] arrayOfCharSequence = new CharSequence[3];
    localObject1 = getText("android.media.metadata.DISPLAY_TITLE");
    int j;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      arrayOfCharSequence[0] = localObject1;
      arrayOfCharSequence[1] = getText("android.media.metadata.DISPLAY_SUBTITLE");
      arrayOfCharSequence[2] = getText("android.media.metadata.DISPLAY_DESCRIPTION");
    }
    else
    {
      j = 0;
      i = 0;
      while (j < 3)
      {
        localObject1 = PREFERRED_DESCRIPTION_ORDER;
        if (i >= localObject1.length) {
          break;
        }
        localObject1 = getText(localObject1[i]);
        int k = j;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          arrayOfCharSequence[j] = localObject1;
          k = j + 1;
        }
        i += 1;
        j = k;
      }
    }
    int i = 0;
    Uri localUri;
    for (;;)
    {
      localObject1 = PREFERRED_BITMAP_ORDER;
      j = localObject1.length;
      localUri = null;
      if (i >= j) {
        break;
      }
      localObject2 = getBitmap(localObject1[i]);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label184;
      }
      i += 1;
    }
    localObject1 = null;
    label184:
    i = 0;
    for (;;)
    {
      localObject2 = PREFERRED_URI_ORDER;
      if (i >= localObject2.length) {
        break;
      }
      localObject2 = getString(localObject2[i]);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = Uri.parse((String)localObject2);
        break label236;
      }
      i += 1;
    }
    Object localObject2 = null;
    label236:
    Object localObject3 = getString("android.media.metadata.MEDIA_URI");
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      localUri = Uri.parse((String)localObject3);
    }
    localObject3 = new MediaDescriptionCompat.Builder();
    ((MediaDescriptionCompat.Builder)localObject3).setMediaId(str);
    ((MediaDescriptionCompat.Builder)localObject3).setTitle(arrayOfCharSequence[0]);
    ((MediaDescriptionCompat.Builder)localObject3).setSubtitle(arrayOfCharSequence[1]);
    ((MediaDescriptionCompat.Builder)localObject3).setDescription(arrayOfCharSequence[2]);
    ((MediaDescriptionCompat.Builder)localObject3).setIconBitmap((Bitmap)localObject1);
    ((MediaDescriptionCompat.Builder)localObject3).setIconUri((Uri)localObject2);
    ((MediaDescriptionCompat.Builder)localObject3).setMediaUri(localUri);
    localObject1 = new Bundle();
    if (mBundle.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
      ((BaseBundle)localObject1).putLong("android.media.extra.BT_FOLDER_TYPE", getLong("android.media.metadata.BT_FOLDER_TYPE"));
    }
    if (mBundle.containsKey("android.media.metadata.DOWNLOAD_STATUS")) {
      ((BaseBundle)localObject1).putLong("android.media.extra.DOWNLOAD_STATUS", getLong("android.media.metadata.DOWNLOAD_STATUS"));
    }
    if (!((BaseBundle)localObject1).isEmpty()) {
      ((MediaDescriptionCompat.Builder)localObject3).setExtras((Bundle)localObject1);
    }
    localObject1 = ((MediaDescriptionCompat.Builder)localObject3).build();
    mDescription = ((MediaDescriptionCompat)localObject1);
    return localObject1;
  }
  
  public long getLong(String paramString)
  {
    return mBundle.getLong(paramString, 0L);
  }
  
  public Object getMediaMetadata()
  {
    if ((mMetadataObj == null) && (Build.VERSION.SDK_INT >= 21))
    {
      Parcel localParcel = Parcel.obtain();
      writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      mMetadataObj = MediaMetadataCompatApi21.createFromParcel(localParcel);
      localParcel.recycle();
    }
    return mMetadataObj;
  }
  
  public RatingCompat getRating(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      localBundle = mBundle;
    }
    try
    {
      paramString = RatingCompat.fromRating(localBundle.getParcelable(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", paramString);
    }
    Bundle localBundle = mBundle;
    paramString = localBundle.getParcelable(paramString);
    return (RatingCompat)paramString;
    return null;
  }
  
  public String getString(String paramString)
  {
    paramString = mBundle.getCharSequence(paramString);
    if (paramString != null) {
      return paramString.toString();
    }
    return null;
  }
  
  public CharSequence getText(String paramString)
  {
    return mBundle.getCharSequence(paramString);
  }
  
  public Set keySet()
  {
    return mBundle.keySet();
  }
  
  public int size()
  {
    return mBundle.size();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(mBundle);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BitmapKey {}
  
  public static final class Builder
  {
    private final Bundle mBundle;
    
    public Builder()
    {
      mBundle = new Bundle();
    }
    
    public Builder(MediaMetadataCompat paramMediaMetadataCompat)
    {
      paramMediaMetadataCompat = new Bundle(mBundle);
      mBundle = paramMediaMetadataCompat;
      MediaSessionCompat.ensureClassLoader(paramMediaMetadataCompat);
    }
    
    public Builder(MediaMetadataCompat paramMediaMetadataCompat, int paramInt)
    {
      this(paramMediaMetadataCompat);
      paramMediaMetadataCompat = mBundle.keySet().iterator();
      while (paramMediaMetadataCompat.hasNext())
      {
        String str = (String)paramMediaMetadataCompat.next();
        Object localObject = mBundle.get(str);
        if ((localObject instanceof Bitmap))
        {
          localObject = (Bitmap)localObject;
          if ((((Bitmap)localObject).getHeight() > paramInt) || (((Bitmap)localObject).getWidth() > paramInt)) {
            putBitmap(str, scaleBitmap((Bitmap)localObject, paramInt));
          }
        }
      }
    }
    
    private Bitmap scaleBitmap(Bitmap paramBitmap, int paramInt)
    {
      float f = paramInt;
      f = Math.min(f / paramBitmap.getWidth(), f / paramBitmap.getHeight());
      paramInt = (int)(paramBitmap.getHeight() * f);
      return Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * f), paramInt, true);
    }
    
    public MediaMetadataCompat build()
    {
      return new MediaMetadataCompat(mBundle);
    }
    
    public Builder putBitmap(String paramString, Bitmap paramBitmap)
    {
      ArrayMap localArrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
      if ((localArrayMap.containsKey(paramString)) && (((Integer)localArrayMap.get(paramString)).intValue() != 2))
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("The ");
        paramBitmap.append(paramString);
        paramBitmap.append(" key cannot be used to put a Bitmap");
        throw new IllegalArgumentException(paramBitmap.toString());
      }
      mBundle.putParcelable(paramString, paramBitmap);
      return this;
    }
    
    public Builder putLong(String paramString, long paramLong)
    {
      Object localObject = MediaMetadataCompat.METADATA_KEYS_TYPE;
      if ((((SimpleArrayMap)localObject).containsKey(paramString)) && (((Integer)((SimpleArrayMap)localObject).get(paramString)).intValue() != 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("The ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" key cannot be used to put a long");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      mBundle.putLong(paramString, paramLong);
      return this;
    }
    
    public Builder putRating(String paramString, RatingCompat paramRatingCompat)
    {
      ArrayMap localArrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
      if ((localArrayMap.containsKey(paramString)) && (((Integer)localArrayMap.get(paramString)).intValue() != 3))
      {
        paramRatingCompat = new StringBuilder();
        paramRatingCompat.append("The ");
        paramRatingCompat.append(paramString);
        paramRatingCompat.append(" key cannot be used to put a Rating");
        throw new IllegalArgumentException(paramRatingCompat.toString());
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        mBundle.putParcelable(paramString, (Parcelable)paramRatingCompat.getRating());
        return this;
      }
      mBundle.putParcelable(paramString, paramRatingCompat);
      return this;
    }
    
    public Builder putString(String paramString1, String paramString2)
    {
      ArrayMap localArrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
      if ((localArrayMap.containsKey(paramString1)) && (((Integer)localArrayMap.get(paramString1)).intValue() != 1))
      {
        paramString2 = new StringBuilder();
        paramString2.append("The ");
        paramString2.append(paramString1);
        paramString2.append(" key cannot be used to put a String");
        throw new IllegalArgumentException(paramString2.toString());
      }
      mBundle.putCharSequence(paramString1, paramString2);
      return this;
    }
    
    public Builder putText(String paramString, CharSequence paramCharSequence)
    {
      ArrayMap localArrayMap = MediaMetadataCompat.METADATA_KEYS_TYPE;
      if ((localArrayMap.containsKey(paramString)) && (((Integer)localArrayMap.get(paramString)).intValue() != 1))
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("The ");
        paramCharSequence.append(paramString);
        paramCharSequence.append(" key cannot be used to put a CharSequence");
        throw new IllegalArgumentException(paramCharSequence.toString());
      }
      mBundle.putCharSequence(paramString, paramCharSequence);
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LongKey {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface RatingKey {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TextKey {}
}
