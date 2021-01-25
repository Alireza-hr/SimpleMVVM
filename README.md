# [Model-View-ViewModel (ie MVVM)](https://github.com/Alireza-hr/SimpleMVVM)

![MVVM3](https://user-images.githubusercontent.com/1812129/68319232-446cf900-00be-11ea-92cf-cad817b2af2c.png)

**Model-View-ViewModel (MVVM)** is a structural design pattern that separates objects into three distinct groups: Models hold application data. They're usually structs or simple classes. Views display visual elements and controls on the screen. They're usually classes, so they can be passed around as references.
**MVVM** is enough for small projects, but when your codebase becomes huge, your ViewModels start bloating. Separating responsibilities becomes hard. **MVVM** with **Clean Architecture** is pretty good in such cases.

**The main players in the MVVM pattern are:**
- The View — that informs the ViewModel about the user's actions.
- The ViewModel — exposes streams of data relevant to the View.
- The DataModel — abstracts the data source. The ViewModel works with the DataModel to get and save the data.

**In this project you will know:**
- How to avoid references to Views in ViewModels.
- Instead of pushing data to the UI, you will let to the UI observe changes to it.
- How to handle UI state in viewModel when data is Loading , Failing or Loaded.
- How to create generic class for base usefull classes like BaseAdapter , BaseConnection , ect.
- How to use BindingAdapter for send object Model to bind views.
- How to cache data from api and set data to database.
