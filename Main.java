
public class Main {

	public static void main(String[] args) {
	
		try{
			long parseTime = System.currentTimeMillis();
			
			parser p = new parser(new Lexer(System.in));
			Graph result = (Graph)p.parse().value;	
			
			long start = System.currentTimeMillis();
			System.out.println("Parsing took:         " + (start - parseTime)/1000.0 + " seconds");
			
			
//			System.out.println(result.getEulerian());
			result.getEulerian();
			
			long end = System.currentTimeMillis();
			System.out.println("Eulerian Path took:   " + (end - start)/1000.0 + " seconds");
		}catch (Exception e) {}

	}

}
