/*
 This file contains definition of antlr parser grammar for the LeMa programming language. Again, it is
 in essence reduced Java grammar.
 */

parser grammar LeMaVMParse;

options { tokenVocab=LeMaVMLex;
	output=AST;
    backtrack=true;
    memoize=true;
}


/********************************************************************************************
                          Parser section
*********************************************************************************************/

compilationUnit
    :   (   packageDeclaration
        )?
        (importDeclaration
        )*
        (typeDeclaration
        )*
    ;

packageDeclaration
    :   PACKAGE qualifiedName
        SEMI
    ;

importDeclaration
    :   IMPORT
        IDENTIFIER
        (DOT IDENTIFIER
        )+
        SEMI
    ;

qualifiedImportName
    :   IDENTIFIER
        (DOT IDENTIFIER
        )*
    ;

typeDeclaration
    :   classDeclaration
    |   SEMI
    ;

modifiers
    :
    (   PUBLIC
    |   PROTECTED
    |   PRIVATE
    |   STATIC
    |   FINAL
    )*
    ;


variableModifiers
    :   (   FINAL
        )*
    ;


classDeclaration
    :   normalClassDeclaration
    ;

normalClassDeclaration
    :   modifiers  CLASS IDENTIFIER
        (EXTENDS type
        )?
        classBody
    ;

classBody
    :   LBRACE
        (classBodyDeclaration
        )*
        RBRACE
    ;

classBodyDeclaration
    :   SEMI
    |   block
    |   memberDecl
    ;

memberDecl
    :    fieldDeclaration
    |    methodDeclaration
    |    classDeclaration
    ;


methodDeclaration
    :
        /* For constructor, return type is null, name is 'init' */
         modifiers
        IDENTIFIER
        formalParameters
        LBRACE
        (explicitConstructorInvocation
        )?
        (blockStatement
        )*
        RBRACE
    |   modifiers
        (type
        |   VOID
        )
        IDENTIFIER
        formalParameters
        (LBRACKET RBRACKET
        )*
        (
            block
        |   SEMI
        )
    ;


fieldDeclaration
    :   modifiers
        type
        variableDeclarator
        (COMMA variableDeclarator
        )*
        SEMI
    ;

variableDeclarator
    :   IDENTIFIER
        (LBRACKET RBRACKET
        )*
        (EQ variableInitializer
        )?
    ;

type
    :   classType
        (LBRACKET RBRACKET
        )*
    |   primitiveType
        (LBRACKET RBRACKET
        )*
    ;


classType
    :   IDENTIFIER
        (DOT IDENTIFIER
        )*
    ;

primitiveType
    :   BOOLEAN
    |   SHORT
    |   INT
    |   LONG
    |   DOUBLE
    ;

qualifiedNameList
    :   qualifiedName
        (COMMA qualifiedName
        )*
    ;

formalParameters
    :   LPAREN
        (formalParameterDecls
        )?
        RPAREN
    ;

formalParameterDecls
    :   normalParameterDecl
        (COMMA normalParameterDecl
        )*
    ;

normalParameterDecl
    :   variableModifiers type IDENTIFIER
        (LBRACKET RBRACKET
        )*
    ;

explicitConstructorInvocation
    :   (THIS
        |SUPER
        )
        arguments SEMI

    |   primary
        DOT
        SUPER
        arguments SEMI
    ;

qualifiedName
    :   IDENTIFIER
        (DOT IDENTIFIER
        )*
    ;

elementValuePairs
    :   elementValuePair
        (COMMA elementValuePair
        )*
    ;

elementValuePair
    :   IDENTIFIER EQ elementValue
    ;

elementValue
    :   conditionalExpression
    |   elementValueArrayInitializer
    ;

elementValueArrayInitializer
    :   LBRACE
        (elementValue
            (COMMA elementValue
            )*
        )? (COMMA)? RBRACE
    ;

block
    :   LBRACE
        (blockStatement
        )*
        RBRACE
    ;


blockStatement
    :   localVariableDeclarationStatement
    |   classDeclaration
    |   statement
    ;


localVariableDeclarationStatement
    :   localVariableDeclaration
        SEMI
    ;

localVariableDeclaration
    :   variableModifiers type
        variableDeclarator
        (COMMA variableDeclarator
        )*
    ;

statement
    :   block
    |   IF parExpression statement (ELSE statement)?
    |   forstatement
    |   WHILE parExpression statement
    |   DO statement WHILE parExpression SEMI
    |   SWITCH parExpression LBRACE switchBlockStatementGroups RBRACE
    |   RETURN (expression )? SEMI
    |   THROW expression SEMI
    |   BREAK
            (IDENTIFIER
            )? SEMI
    |   CONTINUE
            (IDENTIFIER
            )? SEMI
    |   expression  SEMI
    |   IDENTIFIER COLON statement
    |   SEMI

    ;

switchBlockStatementGroups
    :   (switchBlockStatementGroup )*
    ;

switchBlockStatementGroup
    :
        switchLabel
        (blockStatement
        )*
    ;
    
switchLabel
    :   CASE expression COLON
    |   DEFAULT COLON
    ;

formalParameter
    :   variableModifiers type IDENTIFIER
        (LBRACKET RBRACKET
        )*
    ;

forstatement
    :
        // enhanced for loop
        FOR LPAREN variableModifiers type IDENTIFIER COLON
        expression RPAREN statement

        // normal for loop
    |   FOR LPAREN
                (forInit
                )? SEMI
                (expression
                )? SEMI
                (expressionList
                )? RPAREN statement
    ;

forInit
    :   localVariableDeclaration
    |   expressionList
    ;

parExpression
    :   LPAREN expression RPAREN
    ;

expressionList
    :   expression
        (COMMA expression
        )*
    ;


expression
    :   conditionalExpression
        (assignmentOperator expression
        )?
    ;


assignmentOperator
    :   EQ
    |   PLUSEQ
    |   SUBEQ
    |   STAREQ
    |   SLASHEQ
    |   AMPEQ
    |   BAREQ
    |   CARETEQ
    |   PERCENTEQ
    |    LT LT EQ
    |    GT GT GT EQ
    |    GT GT EQ
    ;


conditionalExpression
    :   conditionalOrExpression
        (QUES expression COLON conditionalExpression
        )?
    ;

conditionalOrExpression
    :   conditionalAndExpression
        (BARBAR conditionalAndExpression
        )*
    ;

conditionalAndExpression
    :   inclusiveOrExpression
        (AMPAMP inclusiveOrExpression
        )*
    ;

inclusiveOrExpression
    :   exclusiveOrExpression
        (BAR exclusiveOrExpression
        )*
    ;

exclusiveOrExpression
    :   andExpression
        (CARET andExpression
        )*
    ;

andExpression
    :   equalityExpression
        (AMP equalityExpression
        )*
    ;

equalityExpression
    :   instanceOfExpression
        (
            (   EQEQ
            |   BANGEQ
            )
            instanceOfExpression
        )*
    ;

instanceOfExpression
    :   relationalExpression
        (INSTANCEOF type
        )?
    ;

relationalExpression
    :   shiftExpression
        (relationalOp shiftExpression
        )*
    ;
    
shiftExpression
    :   additiveExpression
    ;

relationalOp
    :    LT EQ
    |    GT EQ
    |   LT
    |   GT
    ;

additiveExpression
    :   multiplicativeExpression
        (
            (   PLUS
            |   SUB
            )
            multiplicativeExpression
         )*
    ;

multiplicativeExpression
    :
        unaryExpression
        (
            (   STAR
            |   SLASH
            |   PERCENT
            )
            unaryExpression
        )*
    ;

/**
 * NOTE: for '+' and '-', if the next token is int or long interal, then it's not a unary expression.
 *       it's a literal with signed value. INTLTERAL AND LONG LITERAL are added here for this.
 */
unaryExpression
    :   PLUS  unaryExpression
    |   SUB unaryExpression
    |   PLUSPLUS unaryExpression
    |   SUBSUB unaryExpression
    |   unaryExpressionNotPlusMinus
    ;

unaryExpressionNotPlusMinus
    :   TILDE unaryExpression
    |   BANG unaryExpression
    |   primary
        (selector
        )*
        (   PLUSPLUS
        |   SUBSUB
        )?
    ;

/**
 * have to use scope here, parameter passing isn't well supported in antlr.
 */
primary
    :   parExpression
    |   THIS
        (DOT IDENTIFIER
        )*
        (identifierSuffix
        )?
    |   IDENTIFIER
        (DOT IDENTIFIER
        )*
        (identifierSuffix
        )?
    |   SUPER
        superSuffix
    |   literal
    |   creator
    |   primitiveType
        (LBRACKET RBRACKET
        )*
        DOT CLASS
    |   VOID DOT CLASS
    ;


superSuffix
    :   arguments
    |   DOT IDENTIFIER
        (arguments
        )?
    ;


identifierSuffix
    :   (LBRACKET RBRACKET
        )+
        DOT CLASS
    |   (LBRACKET expression RBRACKET
        )+
    |   arguments
    |   DOT CLASS
    |   DOT THIS
    |   DOT SUPER arguments
    |   innerCreator
    ;


selector
    :   DOT IDENTIFIER
        (arguments
        )?
    |   DOT THIS
    |   DOT SUPER
        superSuffix
    |   innerCreator
    |   LBRACKET expression RBRACKET
    ;

creator
    :   NEW classType classCreatorRest
    |   arrayCreator
    ;

arrayCreator
    :   NEW createdName
        LBRACKET RBRACKET
        (LBRACKET RBRACKET
        )*
        arrayInitializer

    |   NEW createdName
        LBRACKET expression
        RBRACKET
        (   LBRACKET expression
            RBRACKET
        )*
        (LBRACKET RBRACKET
        )*
    ;

variableInitializer
    :   arrayInitializer
    |   expression
    ;

arrayInitializer
    :   LBRACE
            (variableInitializer
                (COMMA variableInitializer
                )*
            )?
            (COMMA)?
        RBRACE             //Yang's fix, position change.
    ;


createdName
    :   classType
    |   primitiveType
    ;

innerCreator
    :   DOT NEW
        IDENTIFIER
        classCreatorRest
    ;


classCreatorRest
    :   arguments
        (classBody
        )?
    ;

arguments
    :   LPAREN (expressionList
        )? RPAREN
    ;

literal
    :   INTLITERAL
    |   LONGLITERAL
    |   DOUBLELITERAL
    |   STRINGLITERAL
    |   TRUE
    |   FALSE
    |   NULL
    ;

/**
 * These are headers help to make syntatical predicates, not necessary but helps to make grammar faster.
 */

classHeader
    :   modifiers CLASS IDENTIFIER
    ;

interfaceHeader
    :   modifiers INTERFACE IDENTIFIER
    ;


typeHeader
    :   modifiers (CLASS) IDENTIFIER
    ;

methodHeader
    :   modifiers (type|VOID)? IDENTIFIER RPAREN
    ;

fieldHeader
    :   modifiers type IDENTIFIER (LBRACKET RBRACKET)* (EQ|COMMA|SEMI)
    ;

localVariableHeader
    :   variableModifiers type IDENTIFIER (LBRACKET RBRACKET)* (EQ|COMMA|SEMI)
    ;
