package com.elegantwizardry.uniontrade;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

public class HomePageService {

    public void homePage(final JSONObjectHandler complete) {
        AndroidNetworking.get("http://unionint.net/api/home_page.php")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        complete.onComplete(response, null);

                    }

                    @Override
                    public void onError(ANError anError) {
                        complete.onComplete(null, anError);
                    }
                });
    }
}
