package com.github.treborrude.prayerminder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockListFragment;

class PrayerListFragment extends SherlockListFragment
{
  @Override
  public View onCreateView(LayoutInflater inflater,
                           ViewGroup container, 
                           Bundle savedInstanceState) 
  {
    return inflater.inflate(R.layout.prayer_list_fragment, container, false);
  }
}
