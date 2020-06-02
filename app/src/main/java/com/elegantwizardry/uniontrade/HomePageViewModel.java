package com.elegantwizardry.uniontrade;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.androidnetworking.error.ANError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HomePageViewModel extends ViewModel {

    private HomePageService homePageService = new HomePageService();
    private Gson gson = new Gson();

    private MutableLiveData<HomePage> homePageMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorResponse = new MutableLiveData<>();

    public void homePageReport() {
        homePageService.homePage((response, error) -> {
            if (response != null) {
                HomePage homePage = gson.fromJson(response.toString(), HomePage.class);
                homePageMutableLiveData.setValue(homePage);

            } else if (error != null) {
                if (error.getErrorCode() != 0) {
                    try {
                        JSONObject jsonObject = new JSONObject(error.getErrorBody());
                        errorResponse.setValue(jsonObject.getJSONObject("error").getString("message"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    errorResponse.setValue(error.getErrorDetail());
                }
            }
        });
    }


    public MutableLiveData<HomePage> getHomePageMutableLiveData() {
        return homePageMutableLiveData;
    }

    public MutableLiveData<String> getErrorResponse() {
        return errorResponse;
    }
}
