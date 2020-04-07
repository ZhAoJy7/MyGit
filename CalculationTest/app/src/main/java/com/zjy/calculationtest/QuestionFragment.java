package com.zjy.calculationtest;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zjy.calculationtest.databinding.FragmentQuestionBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_question, container, false);
        final MyViewModel myViewModel;
        myViewModel= new ViewModelProvider(getActivity(),new SavedStateViewModelFactory(getActivity().getApplication(),this)).get(MyViewModel.class);
        myViewModel.generator();
        myViewModel.getCurrentScore().setValue(0);
        final FragmentQuestionBinding binding;
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_question,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());
        final StringBuilder builder=new StringBuilder();
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button_num0:
                        builder.append("0");
                        break;
                    case R.id.button_num1:
                        builder.append("1");
                        break;
                    case R.id.button_num2:
                        builder.append("2");
                        break;
                    case R.id.button_num3:
                        builder.append("3");
                        break;
                    case R.id.button_num4:
                        builder.append("4");
                        break;
                    case R.id.button_num5:
                        builder.append("5");
                        break;
                    case R.id.button_num6:
                        builder.append("6");
                        break;
                    case R.id.button_num7:
                        builder.append("7");
                        break;
                    case R.id.button_num8:
                        builder.append("8");
                        break;
                    case R.id.button_num9:
                        builder.append("9");
                        break;
                    case R.id.button12:
                        builder.setLength(0);
                        break;
                }
                binding.textView6.setText(builder.toString());
            }
        };
        binding.buttonNum0.setOnClickListener(listener);
        binding.buttonNum1.setOnClickListener(listener);
        binding.buttonNum2.setOnClickListener(listener);
        binding.buttonNum3.setOnClickListener(listener);
        binding.buttonNum4.setOnClickListener(listener);
        binding.buttonNum5.setOnClickListener(listener);
        binding.buttonNum6.setOnClickListener(listener);
        binding.buttonNum7.setOnClickListener(listener);
        binding.buttonNum8.setOnClickListener(listener);
        binding.buttonNum9.setOnClickListener(listener);
        binding.button12.setOnClickListener(listener);
        binding.button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(builder.toString())==myViewModel.getAnswer().getValue()){
                    myViewModel.answerCurrect();
                    builder.setLength(0);
                    binding.textView6.setText(builder.toString());
                }else {
                    NavController controller= Navigation.findNavController(v);
                    if(myViewModel.win_flag){
                        controller.navigate(R.id.action_questionFragment_to_winFragment);
                        myViewModel.win_flag=false;
                        myViewModel.save();
                    }else {
                        controller.navigate(R.id.action_questionFragment_to_loseFragment);
                    }
                }
            }
        });
        return binding.getRoot();
    }

}
