package com.arc_gis_base_map;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;

import com.arc_gis_base_map.databinding.CustomMapViewBinding;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
import androidx.appcompat.app.AppCompatActivity;
import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.BasemapStyle;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.view.MapView;
public class MapModule extends ReactContextBaseJavaModule {
    private MapView mMapView;
    MapModule(ReactApplicationContext context) {
        super(context);

    }
    @ReactMethod
    public void init(String apiKey) {
        Log.d("CalendarModule: ", apiKey);
        new Handler(Looper.getMainLooper()).post(new Runnable(){
            @Override
            public void run() {
                String Key = "AAPK826e423914a24784bbb3bfd1496e868fUmXLpopWskapkLf2GZ70skyAXsTdzr4A8Ac1HAI35Z7Al61Qw9I3mTbC7LtIMX00";
                if(apiKey.length() > 10){
                    Key = apiKey;
                }
                getCurrentActivity().setContentView(R.layout.custom_map_view);
                ArcGISRuntimeEnvironment.setApiKey(Key);
                mMapView =   getCurrentActivity().findViewById(R.id.mapView);
                ArcGISMap map = new ArcGISMap(BasemapStyle.ARCGIS_TOPOGRAPHIC);
                // set the map to be displayed in this view
                mMapView.setMap(map);
//                mMapView.setViewpoint(new Viewpoint(34.056295, -117.195800, 10000));
            }
        });

    }
    @NonNull
    @Override
    public String getName() {
        return "MapModule";
    }
}
