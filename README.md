# kotlin-coroutines


**To specify where the coroutines should run, Kotlin provides three dispatchers that you can use**
-----------------------------------------------------------------------------------------------
*1.Dispatchers.Main* 

	Use this dispatcher to run a coroutine on the main Android thread. 
	This should be used only for interacting with the UI and performing quick work. 
	Examples include calling suspend functions, running Android UI framework operations, and updating LiveData objects.
  
*2.Dispatchers.IO*

	This dispatcher is optimized to perform disk or network I/O outside of the main thread. 
	Examples include using the Room component, reading from or writing to files, and running any network operations.
  
*3.Dispatchers.Default*

	This dispatcher is optimized to perform CPU-intensive work outside of the main thread. 
	Example use cases include sorting a list and parsing JSON.

--------------------------------------------------------------------------------------------------
## Starting new coroutines 

	It’s important to note that you can’t just call a suspend function from anywhere. 
	The suspend and resume mechanism requires that you switch from normal functions to a coroutine.
	
	There are two ways to start coroutines, and they have different uses
  
		1. launch builder will start a new coroutine that is “fire and forget” — that means it won’t return the result to the caller.
		2. async builder will start a new coroutine, and it allows you to return a result with a suspend function called await.

    //	eg:-
    //	scope.launch {
    // This block starts a new coroutine 
    // "in" the scope.
    // 
    // It can call suspend functions
    //fetchDocs()
    //}

  
