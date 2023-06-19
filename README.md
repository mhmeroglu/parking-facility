﻿# parking-facility

In Esenboğa airport, there is a parking facility which is in the form of a graph having N
nodes and M edges. The graph does not have self-loops or multiple edges. Each node represents a
parking slot and has a capacity of vehicles it can hold. Each edge has a weight of w, which indicates
that it will cost w units to go from node u to node v. All parking slots have a parking fee F per
vehicle, which is same for all slots.
There are K identical vehicles entering the parking facility, each vehicle enumerated with
a distinct number from 1 to K. The vehicles enter in their natural order, that is, vehicle number 1
enters, then vehicle number 2, then 3 and so on till vehicle number K. For each vehicle, you have
to print the minimum total cost that is incurred on the vehicle owner. Here, total cost includes cost
of the path taken to reach the parking slot and parking fee of the slot. It is guaranteed that you
can reach any slot from any other slot. All vehicles entering the parking facility enter from the
parking slot 1.
