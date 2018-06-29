package edu.cnm.deepdive.criminalintent.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import edu.cnm.deepdive.criminalintent.R;
import edu.cnm.deepdive.criminalintent.model.Crime;
import edu.cnm.deepdive.criminalintent.model.CrimeLab;
import java.util.List;

public class CrimeFragment extends Fragment {

  private Crime mCrime;
  private EditText mTitleField;
  private Button mDateButton;
  private CheckBox mSolvedCheckBox;
  private RecyclerView mCrimeRecyclerView;
  private CrimeAdapter mCrimeAdapter;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mCrime = new Crime();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

    mCrimeRecyclerView = (RecyclerView)  view.findViewById(R.id.crime_recycler_view);
    mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    updateUI();

    return view;
  }

  private void updateUI() {
    CrimeLab crimelab = CrimeLab.get(getActivity());
    List<Crime> crimes = crimelab.getCrimes();

    mCrimeAdapter = new CrimeAdapter(crimes);
    mCrimeRecyclerView.setAdapter(mCrimeAdapter);
  }

  private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView mTitleTextView;
    private TextView mDateTextView;
    private Crime mCrime;


    public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
      super(inflater.inflate(R.layout.list_item_crime, parent, false));

        mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
        mTitleTextView = (TextView) itemView.findViewById(R.id.crime_date);
    }

    public void bind(Crime crime) {
      mCrime = crime;
      mTitleTextView.setText(crime.getTitle());
      mDateTextView.setText(crime.getDate().toString());
    }

    @Override
    public void onClick(View v) {
      Toast.makeText(getActivity(), mTitleTextView.getText() + " clicked!", Toast.LENGTH_SHORT).show();
    }
  }

  private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

    private List<Crime> mCrimes;

    public CrimeAdapter(List<Crime> crimes) {
      mCrimes = crimes;
    }

    @Override
    public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

      return new CrimeHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(CrimeHolder holder, int position) {
      Crime crime = mCrimes.get(position);
      holder.bind(crime);
    }

    @Override
    public int getItemCount() {
      return mCrimes.size();
    }
  }




}
