# Compiler Spec

## Classes

### Compiler
- Creates ParseTree from System.in, using ANTLR's generated classes
- Creates ProgramVisitor object, which will visit the parseTree, and generate
  the ProgramAST.
- The ProgramAST will be used to do semantic checking.

### Visitors
Visitors will be written for most of the parser rules.
Separate visitors should be written for each rule, as much as possible. This
allows modularising of code.
Each Visitor should extend WaccParserBaseVisitor<_ast_>, where _ast_ is the type
of whichever AST corresponds to the rule the Visitor is written for.
The Visitor should override the visit method corresponding to the rule they are
written for. This visit method will return the type _ast_.
e.g. ProgramVisitor extends WaccParserBaseVisitor<ProgramAST>, and overrides the
visitProgram method, which will return a ProgramAST upon completion.
Since multiple Visitors are being used here, if your Visitor has children nodes
to visit, remember to use the correct one. If you use ProgramVisitor to visit an
expression, for example, a silent error will probably happen!

### AST (Intermediate data structure for representing program)
ASTs for each rule need to be written to extend AST.
Any compound ASTs (ASTs which have other ASTs nested in them) should have fields
of the nested ASTs in them.
Their constructors will be called by the Visitors. The Visitors will be able to
fetch any nested ASTs, so the constructors should provide arguments which allow
the Visitor to pass in these ASTs.
ASTs all have a check() method which checks that the abstract syntax tree is
correct.
Compound ASTs should call the check() method of nested ASTs.
Throws SemanticErrorException if syntax is incorrect.
e.g. ProgramAST has a constructor which allows passing in of a function table,
which maps function identifiers to FunctionASTs, and a StatementAST. It stores
these references in internal fields.

### SemanticErrorException (Class)
Exits program, with an exit code of 200
