/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, { useEffect, useState } from 'react';
import type {PropsWithChildren} from 'react';
import {
  Button,
  NativeModules,
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  TextInput,
  useColorScheme,
  View,
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import WebView from 'react-native-webview';

type SectionProps = PropsWithChildren<{
  title: string;
}>;


function App(): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark';
  const {MapModule} = NativeModules;
  const [key, setkey] = useState("");
  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
    flex:1
  };
  // const runFirst = `
  // document.getElementsByClassName('navTable')[0].style.display = 'none';
  // true; // note: this is required, or you'll sometimes get silent failures
  // `;
  // document.getElementsByClassName('viewDiv')[0].style.height = '100%';

  // useEffect(() => {
  //   MapModule.init();
  //   return () => {
  //   }
  // }, [])
  

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar
        barStyle={isDarkMode ? 'light-content' : 'dark-content'}
        backgroundColor={backgroundStyle.backgroundColor}
      />

    <TextInput 
    placeholder='Input Api Key or just press the init button to use default key' 
    onChangeText={v=>{setkey(v)}} 
    />

    <Button title='init' onPress={()=>{
      MapModule.init(key);
    }} />
    

      {/* <WebView
      style={{height:'100%'}}
        source={{ uri: "https://services.gisqatar.org.qa/server/rest/services/Vector/Qatar_StreetMap_Hybrid_E/MapServer?f=jsapi" }}
        injectedJavaScript={runFirst}
        // setBuiltInZoomControls
      /> */}
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
});

export default App;
