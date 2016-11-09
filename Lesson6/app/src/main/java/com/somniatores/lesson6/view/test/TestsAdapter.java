package com.somniatores.lesson6.view.test;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.somniatores.lesson6.R;
import com.somniatores.lesson6.databinding.TestRowBinding;

import java.util.List;

/**
 * Created by locisvv on 08.11.2016.
 */

public class TestsAdapter extends RecyclerView.Adapter<TestsAdapter.ViewHolder>  {

    private Context context;
    private List<Test> tests;

    public TestsAdapter(Context context, List<Test> tests) {
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

            binding.firstAnswer.setOnClickListener(checkAnswer(0));
            binding.secondAnswer.setOnClickListener(checkAnswer(1));
            binding.thirdAnswer.setOnClickListener(checkAnswer(2));
            binding.forthAnswer.setOnClickListener(checkAnswer(3));

        }

        public View.OnClickListener checkAnswer(final int answerNumber) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Test test = binding.getTest();
                    if (test.getExpectedAnswer().equals(test.getAnswers().get(answerNumber))) {
                        binding.cardHeader.setBackgroundColor(Color.parseColor("#64DD17"));
                    } else {
                        binding.cardHeader.setBackgroundColor(Color.parseColor("#D84315"));
                    }
                }
            };
        }

        public void bindTest(Test test){
            binding.setTest(test);
        }

    }


}
