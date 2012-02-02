
PARSER_NAME=Temp

default:javac

all:
	jflex Lexer.flex
	java java_cup.Main <  Parser.cup

javac:all
	javac Main.java

clean:
	test -e Lexer.java~ && rm *~ || true
	test -e sym.java && rm sym.java || true
	test -e parser.java && rm parser.java || true
	test -e Lexer.java && rm Lexer.java || true
	rm *.class || true

test:
	./test.sh