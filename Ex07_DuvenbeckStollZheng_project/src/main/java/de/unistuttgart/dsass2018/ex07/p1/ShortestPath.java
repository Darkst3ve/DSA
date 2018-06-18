package de.unistuttgart.dsass2018.ex07.p1;

import java.util.Iterator;
import java.util.Stack;


/**
 * Class for Uebungsblatt 7 - Aufgabe 3.
 * 
 * @author Lennart Duvenbeck | 2836913
 * @author Timo Stoll | 2976666
 * @author David Zheng | 3334362
 * 
 */
public class ShortestPath implements IShortestPath {

	private final IWeightedGraph graph;
	private final int startVertex;


	/**
	 * Initializes the shortest path for weighted graph <tt>graph</tt> from
	 * starting vertex <tt>startVertex</tt>. Calls the bellmanFord(graph,
	 * startVertex) method to execute the Bellman Ford algorithm.
	 * 
	 * @param graph
	 *            the weighted graph
	 * @param startVertex
	 *            the starting vertex
	 */
	public ShortestPath(IWeightedGraph graph, int startVertex) {
		this.graph = graph;
		this.startVertex = startVertex;
		bellmanFord(this.graph, this.startVertex);
	}


	@Override
	public void bellmanFord(IWeightedGraph graph, int startVertex) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean hasNegativeCycle() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public double distanceTo(int destination) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean existsPathTo(int destination) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterator<IEdge> pathTo(int destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
