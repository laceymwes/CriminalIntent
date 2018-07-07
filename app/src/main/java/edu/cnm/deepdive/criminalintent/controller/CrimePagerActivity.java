package edu.cnm.deepdive.criminalintent.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import edu.cnm.deepdive.criminalintent.R;
import edu.cnm.deepdive.criminalintent.model.Crime;
import edu.cnm.deepdive.criminalintent.model.CrimeLab;
import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {
  private static final String EXTRA_CRIME_ID =
      "edu.cnm.deepdive.criminalintent.crime_id";

  private ViewPager mViewPager;
  private List<Crime> mCrimes;

  public static Intent newIntent(Context packageContext, UUID crimeId) {
    Intent intent = new Intent(packageContext, CrimePagerActivity.class);
    intent.putExtra(EXTRA_CRIME_ID, crimeId);
    return intent;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_crime_pager);

    UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

    mViewPager = findViewById(R.id.crime_view_pager);

    mCrimes = CrimeLab.get(this).getCrimes();
    FragmentManager fragmentManager = getSupportFragmentManager();
    mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

      @Override
      public Fragment getItem(int position) {
        return CrimeFragment.newInstance(mCrimes.get(position).getId());
      }

      @Override
      public int getCount() {
        return mCrimes.size();
      }
    });

    // Set current item to item matching passed UUID
    // Current Item position is passed to FragmentStatePagerAdapter.getItem()
    for (int i = 0; i < mCrimes.size(); i++) {
      if (mCrimes.get(i).getId().equals(crimeId)) {
        mViewPager.setCurrentItem(i);
        break;
      }
    }
  }


}
