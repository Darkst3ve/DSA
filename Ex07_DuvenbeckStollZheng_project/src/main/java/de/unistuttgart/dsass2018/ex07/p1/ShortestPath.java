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
	private double[] distance;
	private IEdge[] previousEdge;

	/**
	 * Initializes the shortest path for weighted graph <tt>graph</tt> from starting
	 * vertex <tt>startVertex</tt>. Calls the bellmanFord(graph, startVertex) method
	 * to execute the Bellman Ford algorithm.
	 * 
	 * @param graph
	 *            the weighted graph
	 * @param startVertex
	 *            the starting vertex
	 */
	public ShortestPath(IWeightedGraph graph, int startVertex) {
		this.graph = graph;
		this.startVertex = startVertex;
		distance = new double[graph.numberOfVertices()];
		previousEdge = new IEdge[graph.numberOfVertices()];
		bellmanFord(this.graph, this.startVertex);
	}

	@Override
	public void bellmanFord(IWeightedGraph graph, int startVertex) {
		for (int i = 0; i <= graph.numberOfVertices(); i++) {
			distance[i] = Double.POSITIVE_INFINITY;
		}
		distance[startVertex] = 0;

		for (int j = 0; j <= graph.numberOfVertices(); j++) {
			while (graph.edgeIterator().hasNext()) {
				IEdge x = graph.edgeIterator().next();
				if (distance[x.getSource()] + x.getWeight() < distance[x.getDestination()]) {
					distance[x.getDestination()] = distance[x.getSource()] + x.getWeight();
					previousEdge[x.getDestination()] = x;
				}
			}
		}
	}

	@Override
	public boolean hasNegativeCycle() {
		while (graph.edgeIterator().hasNext()) {
			IEdge x = graph.edgeIterator().next();
			if (distance[x.getSource()] + x.getWeight() < distance[x.getDestination()]) {
				return true;
			}
		}
		return false;
	}

	@Override
	public double distanceTo(int destination) {
		if (this.hasNegativeCycle()) {
			throw new IllegalStateException();
		}
		return distance[destination];
	}

	@Override
	public boolean existsPathTo(int destination) {
		return distance[destination] != Double.POSITIVE_INFINITY;
	}
	
	private class pathIterator implements Iterator<IEdge>{
		private int currentElement;
		
		public pathIterator(int n) {
			currentElement = n;
		}

		@Override
		public boolean hasNext() {
			return previousEdge[currentElement].getSource() != startVertex;
		}

		@Override
		public IEdge next() {
			if (this.hasNext()) {
				IEdge prev = previousEdge[currentElement];
				currentElement = previousEdge[currentElement].getSource();
				return prev;
			}
			return null;
		}

		
	}

	@Override
	public Iterator<IEdge> pathTo(int destination) {
		if (this.hasNegativeCycle()) {
			throw new IllegalStateException();
		}
		
		return new pathIterator(destination);
	}

}
