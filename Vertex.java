import java.util.ArrayList;


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
	 * Connect two vertices, creating an edge between them.
	 * @param v1 The first vertex of the edge
	 * @param v2 The second vertex of the edge
	 */
	public static void connect(Vertex v1, Vertex v2){
		
		v1.addEdge(v2);
		v2.addEdge(v1);
		
	}
	
	public static void disconnect(Vertex v1, Vertex v2){
		v1.removeEdge(v2);
		v2.removeEdge(v1);
	}
	
	public int degree(){
		return connectedVertices.size();
	}
	
	public void addEdge(Vertex v){
		connectedVertices.add(v);
	}
	
	public void removeEdge(Vertex v){
		if(connectedVertices.contains(v))
			connectedVertices.remove(v);
	}
	
	public ArrayList<Vertex> getEdges(){
		return connectedVertices;
	}
	
	public String name(){
		return name;
	}

}
