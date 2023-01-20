package com.arc_gis_base_map;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.BasemapStyle;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;

public class MainActivity extends ReactActivity {
private MapView m;
 public void setMapView(MapView mMapView){

   m = mMapView;
   mMapView = findViewById(R.id.mapView);
   // create a map with the a topographic basemap
   ArcGISMap map = new ArcGISMap(BasemapStyle.ARCGIS_TOPOGRAPHIC);
   // set the map to be displayed in this view
   mMapView.setMap(map);
   mMapView.setViewpoint(new Viewpoint(34.056295, -117.195800, 10000));
 }
  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "ARC_GIS_Base_Map";
  }
//  @Override
//  protected void onPause() {
//      if(m.isActivated()){
//          m.pause();
//      }
//
//    super.onPause();
//  }
//
//  @Override
//  protected void onResume() {
//    super.onResume();
//    if(m.isActivated()){
//        m.resume();
//    }
//
//  }
//
//  @Override
//  protected void onDestroy() {
//      if(m.isActivated()) {
//          m.dispose();
//      }
//    super.onDestroy();
//  }
  /**
   * Returns the instance of the {@link ReactActivityDelegate}. Here we use a util class {@link
   * DefaultReactActivityDelegate} which allows you to easily enable Fabric and Concurrent React
   * (aka React 18) with two boolean flags.
   */
  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    return new DefaultReactActivityDelegate(
        this,
        getMainComponentName(),
        // If you opted-in for the New Architecture, we enable the Fabric Renderer.
        DefaultNewArchitectureEntryPoint.getFabricEnabled(), // fabricEnabled
        // If you opted-in for the New Architecture, we enable Concurrent React (i.e. React 18).
        DefaultNewArchitectureEntryPoint.getConcurrentReactEnabled() // concurrentRootEnabled
        );
  }
}
