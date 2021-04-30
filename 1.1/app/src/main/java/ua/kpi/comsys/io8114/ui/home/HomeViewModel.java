package ua.kpi.comsys.io8114.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Кобук Назар\nГрупа ІО-81\nЗК ІО-8114");
    }

    public LiveData<String> getText() {
        return mText;
    }
}