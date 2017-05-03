Cs146 Hw 5
user: 011256557 (Chang, Chaz)
user: 011551358 (Shiyu, Mou)
user: 010219742(Thang, Ton)


Question 1: Maze, Cell.java and executable jar


Question 2: FlightScheduler, DijkstraSP, EdgeWeightedDigraph, DirectedEdge.java
The 2 extra credit questions for Question 2 were answered.
If the 2nd command line argument is given, the program will process the text file.
If the 2nd command line argument is not given, the program will set a default of 30 min for 
connection time for each airport.


Answered questions below:


Question 1---------------------------------------------------------------
Q: Write the intuition behind why this approach guarantees a perfect maze every time?
A: This is basically a depth-first-search problem. One important element of this perfect maze is 
using a stack to store all the cells visited, and removing cells that have no unvisited neighbors 
from the stack. We start from a unvisited cell and keep visiting unvisited neighbors. So a cell 
won’t be visited twice, which guaranteed there are no path loops and also there is always one 
unique path between any two cells.  We keep going until we have no unvisited neighbors, then 
we pop this cell from stack and continue from the previous cell. After doing this repeatedly, we 
can guarantee all the cells have no unvisited neighbors, which means there would be no 
unreachable areas.


Question 2---------------------------------------------------------------
Q: What is the running time of your algorithm? Explain.
A: Our code uses Dijkstra's algorithm with a binary heap, the constructor takes time proportional
to E log V in the worst case, where V is the number of airports and E is the number of flights. 
Afterwards, the distTo() and hasPathTo() methods take constant time and the pathTo() method 
takes time proportional to the number of edges in the shortest path returned.


Q: Is your implementation a DAG, explain why/why not.
A: Yes. Since this is a single-source shortest-paths problem and all the weights are 
nonnegative. So the short path from one vertex to itself would always be 0.