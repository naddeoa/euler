import java.util.ArrayList;
import java.util.Collections;


public class Vertex implements Comparable<Vertex> {
	
	private String name;
	private ArrayList<Vertex> connectedVertices;
	
	/*
	 * Create a new Vertex object
	 * @param name The name of the vertex object
	 */
	public Vertex(String name){
		this.name = name;
		connectedVertices = new ArrayList<Vertex>();
	}
	
	@Override
	public int compareTo(Vertex v) {
		if(this.degree() > v.degree())
			return 1;
		else if(this.degree() == v.degree())
			return 0;
		else
			return -1;
	}
	
	@Override
	public boolean equals(Object obj){
				
		Vertex v = Vertex.class.cast(obj);
		
		if(v.name().equals(this.name()))
			return true;
		
		return false;
	}
	
	
	/*
	 * Connect two vertices, creating an edge between them. After the 
	 * connection, each vertex's list of connected nodes is sorted; maintaining
	 * an ordered edge list is vital when finding the Eulerian circuit.
	 * @param v1 The first vertex of the edge
	 * @param v2 The second vertex of the edge
	 */
	public static void connect(Vertex v1, Vertex v2){
		v1.addEdge(v2);
		v2.addEdge(v1);
		
		Collections.sort(v1.getEdges(), Collections.reverseOrder());
		Collections.sort(v2.getEdges(), Collections.reverseOrder());
	}
	
	/*
	 * Disconnect two vertices, deleting the edge between them. After the 
	 * disconnection, each vertex's list of connected nodes is sorted; maintaining
	 * an ordered edge list is vital when finding the Eulerian circuit.
	 * @param v1 The first vertex of the edge
	 * @param v2 The second vertex of the edge
	 */
	public static void disconnect(Vertex v1, Vertex v2){
		v1.removeEdge(v2);
		v2.removeEdge(v1);
		
		Collections.sort(v1.getEdges(), Collections.reverseOrder());
		Collections.sort(v2.getEdges(), Collections.reverseOrder());
	}
	
	/*
	 * Return the number of edges this node currently has.
	 * @return An int representing the number of edges this node has
	 */
	public int degree(){
		return connectedVertices.size();
	}
	
	/*
	 * Add an edge to a vertex.
	 * @param v The Vertex that this new edge connects to
	 */
	public void addEdge(Vertex v){
		connectedVertices.add(v);
	}
	
	/*
	 * Remove the edge leading to v
	 * @param v The Vertex who shares the target edge to remove
	 */
	public void removeEdge(Vertex v){
		if(connectedVertices.contains(v))
			connectedVertices.remove(v);
	}
	
	/*
	 * Get an ArrayList of all vertices that this vertex shares an 
	 * edge with.
	 * @return An ArrayList of vertices this vertex shares edges with
	 */
	public ArrayList<Vertex> getEdges(){
		return connectedVertices;
	}
	
	/*
	 * Get the string name of this vertex. This name is used in vertex
	 * comparison to test for equality with .equals().
	 * @return A String holding the name of this vertex
	 */
	public String name(){
		return name;
	}

}
