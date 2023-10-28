package com.braze.ui.actions.brazeactions;

import android.net.Uri;
import com.braze.models.cards.Card;
import com.braze.models.inappmessage.IInAppMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import org.json.JSONObject;

public final class BrazeActionUtils
{
  public static final boolean containsAnyPushPermissionBrazeActions(IInAppMessage paramIInAppMessage)
  {
    kotlin.x.d.i.e(paramIInAppMessage, "<this>");
    return doAnyTypesMatch(BrazeActionParser.ActionType.REQUEST_PUSH_PERMISSION, getAllUris(paramIInAppMessage));
  }
  
  public static final boolean containsInvalidBrazeAction(Card paramCard)
  {
    kotlin.x.d.i.e(paramCard, "<this>");
    if (paramCard.getUrl() != null) {
      return doAnyTypesMatch(BrazeActionParser.ActionType.INVALID, kotlin.collections.i.b(Uri.parse(paramCard.getUrl())));
    }
    return false;
  }
  
  public static final boolean containsInvalidBrazeAction(IInAppMessage paramIInAppMessage)
  {
    kotlin.x.d.i.e(paramIInAppMessage, "<this>");
    return doAnyTypesMatch(BrazeActionParser.ActionType.INVALID, getAllUris(paramIInAppMessage));
  }
  
  public static final boolean doAnyTypesMatch(BrazeActionParser.ActionType paramActionType, List paramList)
  {
    kotlin.x.d.i.e(paramActionType, "actionType");
    kotlin.x.d.i.e(paramList, "uriList");
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = paramList.next();
      localObject3 = (Uri)localObject2;
      if (BrazeActionParser.INSTANCE.isBrazeActionUri((Uri)localObject3)) {
        ((Collection)localObject1).add(localObject2);
      }
    }
    Object localObject2 = new ArrayList(kotlin.collections.i.i((Iterable)localObject1, 10));
    Object localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      paramList = (Uri)((Iterator)localObject3).next();
      paramList = BrazeActionParser.INSTANCE.getBrazeActionVersionAndJson$android_sdk_ui_release(paramList);
      if (paramList != null)
      {
        localObject1 = (JSONObject)paramList.d();
        paramList = (List)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramList = new JSONObject();
      }
      ((Collection)localObject2).add(paramList);
    }
    paramList = new ArrayList();
    localObject1 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      kotlin.collections.i.m(paramList, getAllBrazeActionStepTypes((JSONObject)((Iterator)localObject1).next()));
    }
    if (paramList.isEmpty()) {}
    int i;
    do
    {
      while (!paramList.hasNext())
      {
        return false;
        paramList = paramList.iterator();
      }
      if ((BrazeActionParser.ActionType)paramList.next() == paramActionType) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i == 0);
    return true;
  }
}
