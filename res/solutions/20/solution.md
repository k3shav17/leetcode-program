#SOLUTION-EXPLANATION
The symbols mentioned in the question are mainly three -. '()','{}','[]'.

Here we use a stack to push these symbols into it.

With the help of a loop we push these symbols onto it.

After doing so we use 'peek()' method of stack to find out the top most element of stack.

For instance if we encounter a ')' we check to see if top most element is a '(' using 'peek()'
method, if found we pop it. 

In the end if stack is empty the string is valid else its not.
