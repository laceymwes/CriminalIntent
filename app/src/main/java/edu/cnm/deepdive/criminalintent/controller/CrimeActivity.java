package edu.cnm.deepdive.criminalintent.controller;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.criminalintent.R;

public class CrimeActivity extends SingleFragmentActivity {


  @Override
  protected Fragment createFragment() {
    return new CrimeFragment();
  }
}
