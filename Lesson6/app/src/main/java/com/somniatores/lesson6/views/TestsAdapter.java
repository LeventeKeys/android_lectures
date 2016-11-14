package com.somniatores.lesson6.views;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.somniatores.lesson6.R;
import com.somniatores.lesson6.databinding.TestRowBinding;
import com.somniatores.models.DictionaryTest;

import java.util.List;

/**
 * Created by locisvv on 08.11.2016.
 */

public class TestsAdapter extends RecyclerView.Adapter<TestsAdapter.ViewHolder> {
    private Context context;
    private List<DictionaryTest> tests;

    public TestsAdapter(Context context, List<DictionaryTest> tests) {
        this.context = context;
        this.tests = tests;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        TestRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.test_row, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindTest(tests.get(position));
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TestRowBinding binding;

        public ViewHolder(final TestRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTest(DictionaryTest test) {
            binding.setTest(test);
            binding.setPresenter(new DictionaryTestRowView(test));
        }
    }
}