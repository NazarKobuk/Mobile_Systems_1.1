package ua.kpi.comsys.io8114.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import ua.kpi.comsys.io8114.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel studentViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        studentViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        // Перша частина

        Contents contents = new Contents();
        System.out.println("Task 1");
        HashMap<String, ArrayList<String>> groupedStudents =
                contents.groupStudents(Contents.studentStr);
        System.out.println();


        System.out.println("Task 2");
        int[] points = new int[] {12, 12, 12, 12, 12, 12, 12, 16};
        HashMap<String, HashMap<String, ArrayList<Integer>>> grades =
                contents.fillGrades(groupedStudents, points);
        System.out.println();


        System.out.println("Task 3");
        HashMap<String, HashMap<String, Integer>> gradesSum = contents.showGradesSum(grades);
        System.out.println();


        System.out.println("Task 4");
        HashMap<String, Float> middle = contents.showAvgGradesInGroups(gradesSum);
        System.out.println();


        System.out.println("Task 5");
        HashMap<String, ArrayList<String>> top = contents.showBestInGroups(gradesSum);
        System.out.println();


        // Друга частина
        TimeNK time1 = new TimeNK();
        TimeNK time2 = new TimeNK(new Date());
        TimeNK time3 = new TimeNK(6,12,24);
        System.out.println("First time " + time1.toString());
        System.out.println("Second time " + time2.toString());
        System.out.println("Third time " + time3.toString());
        System.out.println("Time sum method " + time3.sumTime(time2));
        System.out.println("Time sum function " + TimeNK.sumTwoTime(time3, time2));
        System.out.println("Time minus method " + time3.minusTime(time2));
        System.out.println("Time minus function " + TimeNK.minusTwoTime(time3, time2));

        return root;
    }
}