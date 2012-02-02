import java.io.*;

public class Main {

	public static void main(String[] args) {
	
		try{
		
			parser p = new parser(new Lexer(System.in));
			
			Graph result = (Graph)p.parse().value;
			
//			result.print();
			
			result.getEulerian();
			
		}catch (Exception e) {
			
		}

	}

}
