
public class Main {

	public static void main(String[] args) {
	
		try{
			long parseTime = System.currentTimeMillis();
			
			parser p = new parser(new Lexer(System.in));
			Graph result = (Graph)p.parse().value;	
			
			long start = System.currentTimeMillis();
			System.out.println("Parsing took:         " + (start - parseTime)/1000.0 + " seconds");
			
			
			
			Path path = result.getEulerian();
			
			if( args.length > 0 && args[0].equals("-v"))
				System.out.println("\nThe following is an Eulerian circuit based on the graph\n" + path);
				
			long end = System.currentTimeMillis();
			System.out.println("Eulerian Path took:   " + (end - start)/1000.0 + " seconds");
		}catch (Exception e) {}

	}

}
