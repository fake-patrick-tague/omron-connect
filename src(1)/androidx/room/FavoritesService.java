package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

class FavoritesService
{
  private final RoomDatabase prefs;
  final Set<LiveData> requests = Collections.newSetFromMap(new IdentityHashMap());
  
  FavoritesService(RoomDatabase paramRoomDatabase)
  {
    prefs = paramRoomDatabase;
  }
}
