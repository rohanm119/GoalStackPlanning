# BoloXtreme
Happy coding!!!

Total 5 operators used in which 3 are predicates(onTableX, onXY, clearX) and other 2 are actions(STACKXY, UNSTACKXY). 
We use these operators to identify the planning steps in simple Block world problem using a user defined stack

Total 4 classes:
  Block: to identify each block in the given world
  Stack: user defined stack using ArrayList to push single or multiple operators on stack
  Operators: functionality of each operator is defined
  GSP: main class which contains goal stack planning algorithm
  
Initialize start and end states in GSP class constructor as needed.
Each block has name, blockBelow, blockAbove and clear as attributes which are initialized when Block constructor is called
