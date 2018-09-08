# CBC_StoryFeed
## Challenge App implemented!!
### In this application I have implemented **RSSFeed-Parsing.** 
### Android Architecture componentes used:
* LiveData
* ViewModel
* LifeCycleObserver
### Third party SDK's and libraries used : 
* Butterknife
* Retrofit2
* SimpleXML
## Explanation, How it works:
As application starts,it will check the status of **WiFi** network, if it's not active it will show the 
**Alert-Dialog** to open **settings** to get activate **wifi** settings.
* App includes 2 activiteis
   * Main (here it shows the list of stories in **RecycleViewAdapter** )
   * WebView (**RecycleViewAdapter's** onitemClick will open this activity, here **webview** will open the detailes story)
## BroadcastReceiver implemented for getting the **network state change** using **Context.registerReceiver**

### All the developer's guidelines followed to make a better and efficient App.

## Screenshots go here:
 
  

