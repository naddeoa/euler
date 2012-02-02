import java.util.ArrayList;


public class Path {
	
	
	private ArrayList<Step> path;
	
	public Path(){
		path = new ArrayList<Step>();
	}
	
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
