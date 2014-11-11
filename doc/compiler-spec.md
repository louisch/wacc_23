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

### AST (Interface)
ASTs for Statements, Expressions etc. need to be written. Should implement this
interface.
- Check()
  Check method checks that the abstract syntax tree is correct.
  Throws SemanticErrorException if syntax is incorrect.

### SemanticErrorException (Class)
Exits program, with an exit code of 200
