import java_cup.runtime.*;


%%

%class Lexer


%unicode
%cup
%line
%column

%{
	
	private Symbol symbol(int type){
		return symbol(type, yytext());
	}

	private Symbol symbol(int type, Object value){
		return new Symbol(type, yyline, yycolumn, value);
	}


%}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
vertex			= [a-zA-Z][a-zA-Z0-9]*

%%

<YYINITIAL> {
	
	"--"			{ return symbol(sym.EDGE);}
	{vertex}		{ return symbol(sym.VERTEX, yytext());}
	
	{WhiteSpace}    {}  
	[^]				{}
}
