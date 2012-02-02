import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Graph {

	private ArrayList<Vertex> vertices;
	
	public Graph(){
		vertices = new ArrayList<Vertex>();
	}
	
	public int size(){
		return vertices.size();
	}
	
	/*
	 * Adds a single, unconnected vertex to the graph.
	 * @param v The vertex to add
	 */
	public void addVertex(Vertex v){
		
		int index = vertices.indexOf(v);
		if(index == -1)
			vertices.add(v);
		
		Collections.sort(vertices, Collections.reverseOrder());
	}
	
	/*
	 * Adds two vertices connected by an edge to the graph.
	 * @param v1 The first vertex to add
	 * @param v2 The second vertex to add
	 */
	public void addVertex(Vertex v1, Vertex v2){
		
		/* Throw exception if the user attempts to connect a vertex to itself */
		if(v1.equals(v2)){
			throw new IllegalArgumentException("The graphs in this exercise do not allow loops. Make sure you v1 and v2 have different names when adding vertices");
		}
		
		/* see if this vertex already exists in the graph. The equals
		 * method has been overriden and the name of a vertex decides equality
		 */
		int index = vertices.indexOf(v1);
		if(index >= 0){
			v1 = vertices.get(index);
		}else
			vertices.add(v1);
		
		/* check for the second vertex as well and add it if it does not exist */
		index = vertices.indexOf(v2);
		if(index >= 0){
			v2 = vertices.get(index);
		}else
			vertices.add(v2);
		
		/* connect the two vertices */
		Vertex.connect(v1, v2);
		
		Collections.sort(vertices, Collections.reverseOrder());
	}
	
	/*
	 * Adds two vertices connected by an edge to the graph.
	 * This is a convenience function that allows you to implicitly
	 * create vertices by supplying names.
	 * @param v1 The name of the first vertex to add
	 * @param v2 The name of the second vertex to add
	 */
	public void addVertex(String v1, String v2) throws IllegalArgumentException{
				
		/* create vertices from the parsed string names */
		Vertex vert1 = new Vertex(v1);
		Vertex vert2 = new Vertex(v2);
		
		addVertex(vert1, vert2);
		
	}
	
	/*
	 * Get the ArrayList that contains all of the vertices in the graph.
	 * @return ArrayList of all vertices in graph
	 */
	public ArrayList<Vertex> getVertices(){
		return vertices;
	}
	
	
	
	
	public Path getEulerian(){
		
		/* there cannot be any odd degree vertices in an Eulerian circuit */
		for(int i = 0; i < vertices.size(); i++){
			if(vertices.get(i).degree() % 2 == 1)
				return null;
		}
		
		/* the algorithm is destructive at the moment. Recreate the graph
		 * as we go in 'backup' so we can still work with it afterwords */
//		Graph backup = new Graph();
		Path solution = new Path();
		
		/* the starting point will be the vertex with the highest degree */
		Vertex current = vertices.get(0);
		Vertex next;
		
		/* Find the Eulerian circuit */
		while(current.degree() > 0){
			next = current.getEdges().get(0);
			
			Vertex.disconnect(current, next);
//			backup.addVertex(current.name(), next.name()); //recreate as we go
			solution.addStep(current.name(), next.name());
			
			current = next;
		}
		
		/* restore the graph */
//		this.vertices = new ArrayList<Vertex>(backup.getVertices());
		
		return solution;
	}
	
	
	
	/*
	 * Print out the contents of this graph. Output similar to the following:
	 * 
	 * Vertex a is connected to b c 
	 * Vertex b is connected to a c 
	 * Vertex c is connected to b a
	 */
	public void print(){
		
		for(int i = 0; i < vertices.size(); i++){
			
			Vertex v = vertices.get(i);
			ArrayList<Vertex> edges = v.getEdges();
			System.out.print("Vertex " + v.name() + " is connected to ");
			
			for(int j = 0; j < edges.size(); j++){
				System.out.print(edges.get(j).name() + " ");
			}
			
			System.out.println();
		}
		
	}
	
}
