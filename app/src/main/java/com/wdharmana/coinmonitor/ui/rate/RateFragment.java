package com.wdharmana.coinmonitor.ui.rate;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.wdharmana.coinmonitor.R;
import com.wdharmana.coinmonitor.model.RateResponse;

public class RateFragment extends Fragment {

    private RateViewModel mViewModel;
    private RecyclerView list;
    private ProgressBar progressBar;

    public static RateFragment newInstance() {
        return new RateFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rate, container, false);

        list = view.findViewById(R.id.list);
        progressBar = view.findViewById(R.id.progress);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(RateViewModel.class);

        Log.e("TAG", "OKE MASUK");

        mViewModel.getExchangeRate("BTC");

        observeViewModel();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void observeViewModel() {
        mViewModel.rateLiveData.observe(this, new Observer<RateResponse>() {
            @Override
            public void onChanged(RateResponse rateResponse) {
                if(rateResponse!=null) {
                    if(rateResponse.getRates()!=null) {

                        RateAdapter rateAdapter = new RateAdapter(getActivity(), rateResponse.getRates());
                        list.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
                        list.setAdapter(rateAdapter);

                    }
                }
            }
        });

        mViewModel.showLoader.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isShow) {

                if(isShow) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }

            }
        });

    }

}
