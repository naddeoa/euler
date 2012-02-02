import java.util.ArrayList;

/*
 * This class is a textual representation of a path on a graph. It 
 * consists of parts called Steps (an inner class) that are pairs of
 * vertex names.
 */
public class Path {
	
	private ArrayList<Step> path;
	
	public Path(){
		path = new ArrayList<Step>();
	}
	
	/*
	 * Adds a step to the Path.
	 * @param v1 Name of the start vertex
	 * @param v2 Name of the end vertex
	 */
	public void addStep(String v1, String v2){
		Step s = new Step(v1, v2);
		path.add(s);
	}
	

	public String toString(){
		
		String str = new String();
		
		for(int i = 0; i < path.size(); i++){
			str += path.get(i).toString() + "\n";
		}
		
		return str;
	}

	/*
	 * Inner component of a Path. Each Step consists of a pair of
	 * vertex names, representing a step in the overall path.
	 */
	public class Step{
		
		private String v1;
		private String v2;
		
		public Step(String v1, String v2){
			this.v1 = v1;
			this.v2 = v2;
		}
		
		public String toString(){
			return v1 + "--" + v2;
		}
	}
	
	
	

}
