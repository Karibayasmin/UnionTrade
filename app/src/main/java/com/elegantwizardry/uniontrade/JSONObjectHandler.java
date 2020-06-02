package com.elegantwizardry.uniontrade;

import com.androidnetworking.error.ANError;

import org.json.JSONObject;

public interface JSONObjectHandler {

    void onComplete(JSONObject response, ANError error);
}
