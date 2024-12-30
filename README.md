This repository demonstrates a few uncommon bugs that can occur in Java programming.  The `UncommonBug.java` file contains examples of these bugs, and `UncommonBugSolution.java` shows how to avoid them.

Bugs demonstrated:

* **ArrayIndexOutOfBoundsException:** A common error, but included for completeness.
* **ConcurrentModificationException:** Occurs when modifying a collection while iterating over it using an iterator that doesn't support concurrent modification.
* **Deadlock:** A situation where two or more threads are blocked indefinitely, waiting for each other to release the resources that they need.  This often happens with improperly synchronized code.

Solutions are presented in the `UncommonBugSolution.java` file.  This focuses on safe approaches to avoid these exceptional scenarios.