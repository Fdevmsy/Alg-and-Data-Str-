

Question1

goodness = 0:
chance = 0.065999985

goodness = 0.3:
chance = 0.07399998

goodness = 0.5:
chance = 0.08799997

goodness = 1:
chance = 1.0

goodness = 0.9:
chance = 0.50200003



Question2
* time unit is nanosecond
// test1 
a = 10  b = 20
average_time = 34447.09

//test2
a = 100  b = 1000
average_time = 234392.86

//test3
a = 50  b = 200
average_time = 95280.78

// If there are k lists, we can just add items in those lists to the map and count only the ones with value=1;  I think the running time would be the same. 


Question3

1. running time: O(1)
2. created another stack to store the max number
3. yes, it improves the running time from O(n) to O(1);
4. yes, we can use a variable instead of a stack to store the Difference between the new item and currently the max value. And we store Sn - Max(Sn-1, Sn-2... S1, S0) in the stack. If the max value are popped, we can get the new max value by (Old-Max - popped value). 