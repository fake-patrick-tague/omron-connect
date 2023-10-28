package com.braze.ui.contentcards.handlers;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.braze.ui.contentcards.view.ContentCardViewHolder;
import java.util.List;

public abstract interface IContentCardsViewBindingHandler
  extends Parcelable
{
  public abstract int getItemViewType(Context paramContext, List paramList, int paramInt);
  
  public abstract void onBindViewHolder(Context paramContext, List paramList, ContentCardViewHolder paramContentCardViewHolder, int paramInt);
  
  public abstract ContentCardViewHolder onCreateViewHolder(Context paramContext, List paramList, ViewGroup paramViewGroup, int paramInt);
}
