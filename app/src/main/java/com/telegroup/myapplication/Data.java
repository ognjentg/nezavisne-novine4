package com.telegroup.myapplication;

import android.content.Context;
import android.os.ParcelUuid;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bojan on 3/27/18.
 */

public class Data {
    public static final String URL_KATEG= "https://dtp.nezavisne.com/app/meni";
    public static final String URL_VIJEST = "https://dtp.nezavisne.com/app/v2/vijesti/";
    public static final String URL_VIJESTI_SPECIFIC = "https://dtp.nezavisne.com/app/rubrika/";
    String TAG = "AAAA";
    MainFragment fragment;
//    List<Kategorije> list;
    int j = 0;
    HashMap<String, Kategorije> list;


    Context context;
    Data(Context context, MainFragment fragment){
        this.context = context;
        this.fragment = fragment;

    }
    public List<Kategorije> getKategorije(){

        RequestQueue queue = Volley.newRequestQueue(context);


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_KATEG,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, response);
                       parsKategorija(response);
                            popuniVijesti();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

        return null;

    }
    void parsKategorija(String a){


    list = new HashMap<>();

        try {
            JSONArray contacts = new JSONArray(a);
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject c = contacts.getJSONObject(i);
                Kategorije kat = new Kategorije(c.getInt("meniID"), c.getString("Naziv"),
                        c.getString("Boja"));

                list.put(""+ kat.getId(), kat);

                Log.i(TAG,list.toString());
            }

            fragment.popuniKategoriju((List<Kategorije>) list.values());

        }catch(Exception e){
            Log.i(TAG,e.getMessage());
        }

    }
    public void popuniVijesti()  {


        List<String> odgovro = new ArrayList<>();

        Log.i(TAG,"Velicina lise je: "+list.size());
        for (j = 0; j < list.size() - 1; j++) {


// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_VIJESTI_SPECIFIC + list.get(j).getId() + "/1" + "/1",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            parsVijesti(response);


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });


            //queue.add(stringRequest);


        }
    }

    public void parsVijesti(String a){

        try {
            JSONArray contacts = new JSONArray(a);
            Log.i(TAG, a);

            for (int i = 0; i < contacts.length(); i++) {
                JSONObject c = contacts.getJSONObject(i);

                Vijesti vijesti = new Vijesti(
                        c.getInt("vijestID"),
                        c.getString("Naslov"),
                        c.getString("Autor"),
                        c.getString("Datum"),
                        c.getString("Lid"),
                        c.getString("Lid"),
                        c.getString("Slika"),
                        c.getInt("meniRoditelj"));

                Kategorije kategorije = list.get(vijesti.getKatagerijaID());
                if (kategorije == null) return;
                kategorije.getAdapter().add(vijesti);

                Log.i(TAG,"Broj iteracija" + i);
            }


        }catch(Exception e){
            Log.i(TAG+"s",e.getMessage());
        }


    }

}
