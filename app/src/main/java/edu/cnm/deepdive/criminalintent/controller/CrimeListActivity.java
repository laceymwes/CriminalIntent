package edu.cnm.deepdive.criminalintent.controller;

import android.support.v4.app.Fragment;
import edu.cnm.deepdive.criminalintent.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new CrimeListFragment();
  }
}
