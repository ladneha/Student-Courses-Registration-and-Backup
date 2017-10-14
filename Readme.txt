
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------
-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)
1) Array - The data structure array is used for storing temporary values read from the files for performing the insertion, deletion, calculating sum etc.
           The time complexity of array for insertion ,deletion and search operation is O(n) and space complexity is also O(n).
2) ArrayList - The data structure array is used for storing the list of observers in the observer list. The time complexity of array list for traversal, remove, contains operation is O(n) and for add and get operation is O(1). 
3) Tree choice - The tree choosen is Binary Search Tree. Time complexity for binary search tree for worst case is O(n).

Description of Observer Pattern implementation
In this project I have used tree as the data structure.
I have created one original tree and two backup trees which act as observers of the original tree. 
Every node in the tree acts as both subject and observer. 
In the driver class three trees are instantiated. 
The input is read from the file that contains bnumber and course and inserted in the tree. 
As and when the new courses are added and deleted from the tree, the observers of the respective nodes are notifed by calling the notifyObservers method in the Node class. 
This Node class implements the  Subjective and Observer Interface.
The subjective class also has methods register() that adds the observers in the list and unregister that removes the observers from the list.  
-----------------------------------------------------------------------
