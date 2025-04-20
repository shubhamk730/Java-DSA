# Graphs

### A graph is a non-linear data structure consisting of nodes that have data and are connected to other nodes through edges.

## Types of Graph
1. Undirected Graph -> Edges are bidirectional
2. Directed Graph -> Edges are directed from one vertex to another.


A graph does not necessarily mean to be an enclosed structure, it can be an open structure as well. A graph is said to have a cycle if it starts from a node and ends at the same node. There can be multiple cycles in a graph.

If there is at least one cycle present in the graph then it is called an Undirected Cyclic Graph.

### DAG -> Directed Acyclic Graph, no cycle present in directed graph.
### DCG -> Directed Cyclic Graph, ateast one cycle is present in directed graph.

### Path in a graph contains a lot of nodes and each of them is reachable. A node can't appear twice in a path.

### Degree of Graph :- 
    It is the number of edges that go inside or outside that node.

### Edge Weight :- 
    A graph may have weights assigned on its edges. It is often referred to as the cost of the edge.



## Graph Representation
Generally a graph consists of n node(vertices) and m edges these are the inputs provided and then we can have m lines containing 2 integers u and v which mark the edge between two nodes.

### In case of undirected graph, an edge between u and v means there is edge between v and u also.

## The two most commonly used representations for graphs are
1. Adjacency Matrix
2. Adjacency List

### Adjacency Matrix (int graph[n][n])
    An adjacency matrix of a graph is a two-dimensional array of size n x n, where n is the number of nodes in the graph, with the property that a[ i ][ j ] = 1 if the edge (vᵢ, vⱼ) is in the set of edges, and a[ i ][ j ] = 0 if there is no such edge.
 

### Adjacency List(ArrayList<ArrayList<Integer>> graph)
    Adjacency Lists
    In the previous storing method, we saw it was taking n² space to store the graph, this is where the adjacency list comes into the picture, it takes a very less amount of space.

    This is a node-based representation. In this representation, we associate with each node a list of nodes adjacent to it. Normally an array is used to store the nodes. The array provides random access to the adjacency list for any particular node.
    Consider the example of the following undirected graph,

### Connected Components

## Traversal Algorithms 
    1. Breadth First Search
    2. Depth First Search
    
# 🌲 Minimum Spanning Tree (MST) - Summary

## 📌 Definition
A **Minimum Spanning Tree (MST)** is a subset of edges in a **weighted, connected graph** that:
- Connects all vertices
- Has **no cycles**
- Has the **minimum total edge weight**

## 📌 Applications
- Network design (like LAN setup)
- Road construction
- Circuit design

## 📌 MST Algorithms

### 1. Prim’s Algorithm
- **Approach**: Greedy, expands from one node using the smallest edge
- **Data Structure**: Min Heap / Priority Queue
- **Time Complexity**: `O(E log V)`

### 2. Kruskal’s Algorithm
- **Approach**: Sort edges by weight and connect components using **Union-Find (Disjoint Set)**
- **Time Complexity**: `O(E log E)`

## 📌 MST vs. Shortest Path

| Feature            | MST                          | Shortest Path                  |
|--------------------|-------------------------------|--------------------------------|
| Connects           | All nodes                    | Source to specific node        |
| Cycle              | No cycles                    | Cycles allowed                 |
| Total Weight       | Minimized for entire tree    | Minimized for source-target    |
| Algorithms         | Prim’s, Kruskal’s            | Dijkstra, Bellman-Ford         |


    