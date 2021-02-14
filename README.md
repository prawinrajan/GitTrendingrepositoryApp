# GitTrendingrepositoryApp

## Git Trending Repository app architecture (MVVM)

<img src="https://developer.android.com/topic/libraries/architecture/images/final-architecture.png" width="200px" height="200px">


### Dependencies used in this app
1. image - glide:4.7.1
2. Network (JSON request/response) - retrofit2
3. recyclerview,cardview - v7.27

## Architecture Components

 1. Entity (<a href="https://github.com/prawinrajan/GitTrendingrepositoryApp/blob/master/app/src/main/java/com/prawin/gitTrendrepo/api/Hero.java">Hero.java</a>)
 
 <img src="https://developer.android.com/codelabs/android-training-livedata-viewmodel/img/bf136c84e7fc51f2.png"  width="200px" height="200px">
 
 Here, a entity contains author, name, describtion, avatar, language, languageColor, star count, fork count, url, currenperoidfork count.
 
 2. Dao
 
 <img src="https://developer.android.com/codelabs/android-training-livedata-viewmodel/img/d33a92bbd6b0c0cd.png" width="200px" height="200px">
 
<a href="https://github.com/prawinrajan/GitTrendingrepositoryApp/blob/master/app/src/main/java/com/prawin/gitTrendrepo/local/DatabaseHandler.java"> DatabaseHandler.java </a> file pays two role. such as DAO, SQLite connector. This file involkes these two work.

3. Room DataBase (DAO (DatabaseHandler) + Entity (Hero))

the combined environment is called RoomDatabase, which is helpfull to view data <b>offline</b> in mode.

4. Local environment

It is also known as Room database

5. Remote Data source

a. <a href="https://github.com/prawinrajan/GitTrendingrepositoryApp/blob/master/app/src/main/java/com/prawin/gitTrendrepo/api/Api.java">APiInterface</a> - holds basedURL
b. <a href="https://github.com/prawinrajan/GitTrendingrepositoryApp/blob/master/app/src/main/java/com/prawin/gitTrendrepo/api/ApiClient.java"> ApiClient</a> - used to get data from remote

6. View model
 It has the Adapter class to represent data in understandable format.
 
 7. Activity / Fragment 
Here, item, recycleView were included.

a. <a href="https://github.com/prawinrajan/GitTrendingrepositoryApp/blob/master/app/src/main/res/layout/item.xml"> item </a> - a single component which will be used infinite number of times
b. <a href="https://github.com/prawinrajan/GitTrendingrepositoryApp/blob/master/app/src/main/res/layout/activity_main.xml">recycleview </a> - which used to represent data only on viewpoint surface. so it consume less memory space

### Other 
Handle error/ without network situation by this <a href="https://github.com/prawinrajan/GitTrendingrepositoryApp/blob/master/app/src/main/res/layout/error.xml">layout </a>. 


 
 





