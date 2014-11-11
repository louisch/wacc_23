# Compiler Spec

## Classes

### Compiler (replaces SemanticChecker)
Someone rename SemanticChecker to Compiler please.
- Creates ParseTree from System.in, using ANTLR's generated classes
- Creates ASTAssembler object, passing the ParseTree to its constructor.

### ASTAssembler (Class)
- ASTAssembler(ParseTree)
  Constructor takes given ParseTree and internally constructs
  AST.

### AST (Abstract class)
Base AST class will extend BasicParserBaseVisitor<AST>. This way, ANTLR's
methods can be used.
ASTs for Statements, Expressions etc. need to be written to extend AST.
Any compound ASTs (ASTs which have other ASTs nested in them) should have fields
of the nested ASTs in them.
- Check()
  Check method checks that the abstract syntax tree is correct.
  Compound ASTs should call the Check method of nested ASTs.
  Throws SemanticErrorException if syntax is incorrect.

### SemanticErrorException (Class)
Exits program, with an exit code of 200
