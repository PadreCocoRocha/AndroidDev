package com.example.android.sunshine.sync;
//  COMPLETE (1) Create a class called SunshineSyncTask
//  COMPLETE (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
//      COMPLETE (3) Within syncWeather, fetch new weather data
//      COMPLETE (4) If we have valid results, delete the old data and insert the new

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

public class SunshineSyncTask {
    synchronized public static void syncWeather(Context context){
        URL url = NetworkUtils.getUrl(context);

        try {
            String strData = NetworkUtils.getResponseFromHttpUrl(url);
            ContentValues[] weatherData =
                    OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context, strData);

            ContentResolver contentResolver = context.getContentResolver();
            if (weatherData != null && weatherData.length != 0){
                contentResolver.delete(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        null,null);
                contentResolver.bulkInsert(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        weatherData);
            }
        } catch (JSONException e1){
            e1.printStackTrace();
        } catch (IOException e2){
            e2.printStackTrace();
        }
    }
}