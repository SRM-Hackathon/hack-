package com.example.rishi.herbscout.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.rishi.herbscout.Adapter.PlantListAdapter;
import com.example.rishi.herbscout.Models.Plant;
import com.example.rishi.herbscout.Models.PlantDetail;
import com.example.rishi.herbscout.Models.URLS;
import com.example.rishi.herbscout.R;
import com.example.rishi.herbscout.VolleySingleton.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PlantDetailActivity extends AppCompatActivity {

    RecyclerView rvProperties,rvPartsUsed,rvPlaces;
    List<Plant> propertiesList,partsUsedList,placesList;
    PlantListAdapter propertiesAdapter,partsUsedAdapter,placesAdapter;
    LinearLayoutManager linearLayoutManager;
    String plantName;
    PlantDetail plantDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);
        rvProperties= (RecyclerView) findViewById(R.id.rvProperties);
        rvPartsUsed= (RecyclerView) findViewById(R.id.rvPartsUsed);
        rvPlaces= (RecyclerView) findViewById(R.id.rvPlaces);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        plantName=getIntent().getExtras().getString("plantName");
        plantName="Azadirachta indica";
        plantDetail=new PlantDetail();
        getPlantName();

    }

    public void getPlantName() {
        StringRequest request=new StringRequest(Request.Method.GET, URLS.BASE_URL + URLS.getSpecificPlantURL + "?name=" + plantName,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DETAIL",response);
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            if(jsonObject.getString("success").contentEquals("true")){

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DETAIL",error.getMessage());
            }
        });
        AppController.getInstance().addToRequestQueue(request);
    }
}
