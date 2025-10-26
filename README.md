# Destroy Connectivity
This Java program simulates the destruction and restoration of connectivity in a network of computers. It determines the overall connectivity of the network as certain connections (edges) are progressively destroyed and then restored in reverse order.

# Overview
The program reads data representing:
A set of computers (nodes),
Their network connections (edges), and
A list of connections that are destroyed in a specific order.
Using a Disjoint Set Union (DSU), also known as a Union-Find data structure, it efficiently tracks how many components exist and calculates a connectivity measure after each destruction step is reversed.
