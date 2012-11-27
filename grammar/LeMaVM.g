/**
 * An ANTLRv3 capable Java 1.5 grammar for building ASTs.
 *
 * Note that there's also the tree grammar 'JavaTreeParser.g' that can be fed
 * with this grammer's output.
 *
 *
 * Please report any detected errors or even suggestions regarding this grammar
 * to
 *
 *          dieter [D O T] habelitz [A T] habelitz [D O T] com
 *
 *      with the subject
 *
 *          jsom grammar: [your subject note]
 *
 * To generate a parser based on this grammar you'll need ANTLRv3, which you can
 * get from 'http://www.antlr.org'.
 *
 *
 * This grammar is published under the ...
 *
 * BSD licence
 * 
 * Copyright (c) 2007-2008 by HABELITZ Software Developments
 *
 * All rights reserved.
 * 
 * http://www.habelitz.com
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY HABELITZ SOFTWARE DEVELOPMENTS ('HSD') ``AS IS'' 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL 'HSD' BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
 
grammar LeMaVM;

options {
    backtrack = true; 
    memoize = true;
    output = AST;
    ASTLabelType = CommonTree;
}

tokens {

    // operators and other special chars
    
    AND                     = '&'               ;
    AND_ASSIGN              = '&='              ;
    ASSIGN                  = '='               ;
    AT                      = '@'               ;
    BIT_SHIFT_RIGHT         = '>>>'             ;
    BIT_SHIFT_RIGHT_ASSIGN  = '>>>='            ;
    COLON                   = ':'               ;
    COMMA                   = ','               ;
    DEC                     = '--'              ;
    DIV                     = '/'               ;
    DIV_ASSIGN              = '/='              ;
    DOT                     = '.'               ;
    DOTSTAR                 = '.*'              ;
    ELLIPSIS                = '...'             ;
    EQUAL                   = '=='              ;
    GREATER_OR_EQUAL        = '>='              ;
    GREATER_THAN            = '>'               ;
    INC                     = '++'              ;
    LBRACK                  = '['               ;
    LCURLY                  = '{'               ;
    LESS_OR_EQUAL           = '<='              ;
    LESS_THAN               = '<'               ;
    LOGICAL_AND             = '&&'              ;
    LOGICAL_NOT             = '!'               ;
    LOGICAL_OR              = '||'              ;
    LPAREN                  = '('               ;
    MINUS                   = '-'               ;
    MINUS_ASSIGN            = '-='              ;
    MOD                     = '%'               ;
    MOD_ASSIGN              = '%='              ;
    NOT                     = '~'               ;
    NOT_EQUAL               = '!='              ;
    OR                      = '|'               ;
    OR_ASSIGN               = '|='              ;
    PLUS                    = '+'               ;
    PLUS_ASSIGN             = '+='              ;
    QUESTION                = '?'               ;
    RBRACK                  = ']'               ;
    RCURLY                  = '}'               ;
    RPAREN                  = ')'               ;
    SEMI                    = ';'               ;
    SHIFT_LEFT              = '<<'              ;
    SHIFT_LEFT_ASSIGN       = '<<='             ;
    SHIFT_RIGHT             = '>>'              ;
    SHIFT_RIGHT_ASSIGN      = '>>='             ;
    STAR                    = '*'               ;
    STAR_ASSIGN             = '*='              ;
    XOR                     = '^'               ;
    XOR_ASSIGN              = '^='              ;

    // keywords
    
    BOOLEAN                 = 'boolean'         ;
    BREAK                   = 'break'           ;
    CASE                    = 'case'            ;
    CLASS                   = 'class'           ;
    CONTINUE                = 'continue'        ;
    DEFAULT                 = 'default'         ;
    DO                      = 'do'              ;
    DOUBLE                  = 'double'          ;
    ELSE                    = 'else'            ;
    EXTENDS                 = 'extends'         ;
    FALSE                   = 'false'           ;
    FINAL                   = 'final'           ;
    FOR                     = 'for'             ;
    IF                      = 'if'              ;
    INSTANCEOF              = 'instanceof'      ;
    IMPORT                  = 'import'          ;
    INT                     = 'int'             ;
    LONG                    = 'long'            ;
    NEW                     = 'new'             ;
    NULL                    = 'null'            ;
    PACKAGE                 = 'package'         ;
    PRIVATE                 = 'private'         ;
    PROTECTED               = 'protected'       ;
    PUBLIC                  = 'public'          ;
    RETURN                  = 'return'          ;
    SHORT                   = 'short'           ;
    STATIC                  = 'static'          ;
    SUPER                   = 'super'           ;
    SWITCH                  = 'switch'          ;
    THIS                    = 'this'            ;
    TRUE                    = 'true'            ;
    TRY                     = 'try'             ;
    VOID                    = 'void'            ;
    WHILE                   = 'while'           ;
    
    // tokens for imaginary nodes
    
    ARGUMENT_LIST;
    ARRAY_DECLARATOR;
    ARRAY_DECLARATOR_LIST;
    ARRAY_ELEMENT_ACCESS;
    ARRAY_INITIALIZER;
    BLOCK_SCOPE;
    CAST_EXPR;
    CATCH_CLAUSE_LIST;
    CLASS_CONSTRUCTOR_CALL;
    CLASS_INSTANCE_INITIALIZER;
    CLASS_STATIC_INITIALIZER;
    CLASS_TOP_LEVEL_SCOPE;
    CONSTRUCTOR_DECL;
    ENUM_TOP_LEVEL_SCOPE;
    EXPR;
    EXTENDS_BOUND_LIST;
    EXTENDS_CLAUSE;
    FOR_CONDITION;
    FOR_EACH;
    FOR_INIT;
    FOR_UPDATE;
    FORMAL_PARAM_LIST;
    FORMAL_PARAM_STD_DECL;
    FUNCTION_METHOD_DECL;
    LABELED_STATEMENT;
    LOCAL_MODIFIER_LIST;
    JAVA_SOURCE;
    METHOD_CALL;
    MODIFIER_LIST;
    PARENTESIZED_EXPR;
    POST_DEC;
    POST_INC;
    PRE_DEC;
    PRE_INC;
    QUALIFIED_TYPE_IDENT;
    STATIC_ARRAY_CREATOR;
    SUPER_CONSTRUCTOR_CALL;
    SWITCH_BLOCK_LABEL_LIST;
    THIS_CONSTRUCTOR_CALL;
    TYPE;
    UNARY_MINUS;
    UNARY_PLUS;
    VAR_DECLARATION;
    VAR_DECLARATOR;
    VAR_DECLARATOR_LIST;
    VOID_METHOD_DECL;
}

@header {
package cz.cvut.fit.mirun.lemavm.antlr;
}

@members {
    
    private boolean mMessageCollectionEnabled = false;
    private boolean mHasErrors = false;
    private List<String> mMessages;

    /**
     *  Switches error message collection on or of.
     *
     *  The standard destination for parser error messages is <code>System.err</code>.
     *  However, if <code>true</code> gets passed to this method this default
     *  behaviour will be switched off and all error messages will be collected
     *  instead of written to anywhere.
     *
     *  The default value is <code>false</code>.
     *
     *  @param pNewState  <code>true</code> if error messages should be collected.
     */
    public void enableErrorMessageCollection(boolean pNewState) {
        mMessageCollectionEnabled = pNewState;
        if (mMessages == null && mMessageCollectionEnabled) {
            mMessages = new ArrayList<String>();
        }
    }
    
    /**
     *  Collects an error message or passes the error message to <code>
     *  super.emitErrorMessage(...)</code>.
     *
     *  The actual behaviour depends on whether collecting error messages
     *  has been enabled or not.
     *
     *  @param pMessage  The error message.
     */
     @Override
    public void emitErrorMessage(String pMessage) {
        if (mMessageCollectionEnabled) {
            mMessages.add(pMessage);
        } else {
            super.emitErrorMessage(pMessage);
        }
    }
    
    /**
     *  Returns collected error messages.
     *
     *  @return  A list holding collected error messages or <code>null</code> if
     *           collecting error messages hasn't been enabled. Of course, this
     *           list may be empty if no error message has been emited.
     */
    public List<String> getMessages() {
        return mMessages;
    }
    
    /**
     *  Tells if parsing a Java source has caused any error messages.
     *
     *  @return  <code>true</code> if parsing a Java source has caused at least one error message.
     */
    public boolean hasErrors() {
        return mHasErrors;
    }
}

@lexer::header {
package cz.cvut.fit.mirun.lemavm.antlr;
}

@lexer::members {
/** 
 *  Determines if whitespaces and comments should be preserved or thrown away.
 *
 *  If <code>true</code> whitespaces and comments will be preserved within the
 *  hidden channel, otherwise the appropriate tokens will be skiped. This is
 *  a 'little bit' expensive, of course. If only one of the two behaviours is
 *  needed forever the lexer part of the grammar should be changed by replacing 
 *  the 'if-else' stuff within the approprate lexer grammar actions.
 */
public boolean preserveWhitespacesAndComments = false;
}

// Starting point for parsing a Java file.
javaSource
    :   compilationUnit
        ->  ^(JAVA_SOURCE compilationUnit)
    ;

compilationUnit
    :   packageDeclaration? 
        importDeclaration* 
        typeDecls*
    ;

typeDecls
    :   typeDeclaration
    |   SEMI!
    ;

packageDeclaration
    :   PACKAGE^ qualifiedIdentifier SEMI!  
    ;
    
importDeclaration
    :   IMPORT^ STATIC? qualifiedIdentifier DOTSTAR? SEMI!
    ;
    
typeDeclaration
    :   modifierList!
        (   classTypeDeclaration[$modifierList.tree]
        )
    ;
    
classTypeDeclaration[CommonTree modifiers]
    :   CLASS IDENT classExtendsClause? classBody
        ->  ^(CLASS {$modifiers} IDENT classExtendsClause? classBody)
    ;
    
classExtendsClause
    :   EXTENDS type
        ->  ^(EXTENDS_CLAUSE[$EXTENDS, "EXTENDS_CLAUSE"] type)
    ;   
        
bound
    :   EXTENDS type (AND type)*
        ->  ^(EXTENDS_BOUND_LIST[$EXTENDS, "EXTENDS_BOUND_LIST"] type+)
    ;
    
typeList
    :   type (COMMA! type)*
    ;
    
classBody
    :   LCURLY classScopeDeclarations* RCURLY
        ->  ^(CLASS_TOP_LEVEL_SCOPE[$LCURLY, "CLASS_TOP_LEVEL_SCOPE"] classScopeDeclarations*)
    ;

classScopeDeclarations
    :   block           ->  ^(CLASS_INSTANCE_INITIALIZER block)
    |   STATIC block    ->  ^(CLASS_STATIC_INITIALIZER[$STATIC, "CLASS_STATIC_INITIALIZER"] block)
    |   modifierList
        (   (   type IDENT formalParameterList arrayDeclaratorList? (block | SEMI)
                ->  ^(FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList arrayDeclaratorList? block?)
            |   VOID IDENT formalParameterList (block | SEMI)
                ->  ^(VOID_METHOD_DECL modifierList IDENT formalParameterList block?)
            |   ident=IDENT formalParameterList block
                ->  ^(CONSTRUCTOR_DECL[$ident, "CONSTRUCTOR_DECL"] modifierList formalParameterList block)
            )
        |   type classFieldDeclaratorList SEMI
            ->  ^(VAR_DECLARATION modifierList type classFieldDeclaratorList)
        )
    |   typeDeclaration
    |   SEMI!
    ;

classFieldDeclaratorList
    :   classFieldDeclarator (COMMA classFieldDeclarator)*
        ->  ^(VAR_DECLARATOR_LIST classFieldDeclarator+)
    ;

classFieldDeclarator
    :   variableDeclaratorId (ASSIGN variableInitializer)?
        ->  ^(VAR_DECLARATOR variableDeclaratorId variableInitializer?)
    ;
    
variableDeclaratorId
    :   IDENT^ arrayDeclaratorList?
    ;

variableInitializer
    :   arrayInitializer
    |   expression
    ;

arrayDeclarator
    :   LBRACK RBRACK
        ->  ^(ARRAY_DECLARATOR)
    ;

arrayDeclaratorList
    :   arrayDeclarator+
        ->  ^(ARRAY_DECLARATOR_LIST arrayDeclarator+)   
    ;
    
arrayInitializer
    :   LCURLY (variableInitializer (COMMA variableInitializer)* COMMA?)? RCURLY
        ->  ^(ARRAY_INITIALIZER[$LCURLY, "ARRAY_INITIALIZER"] variableInitializer*)
    ;

modifierList
    :   modifier*   
        ->  ^(MODIFIER_LIST modifier*)
    ;

modifier
    :   PUBLIC
    |   PROTECTED
    |   PRIVATE
    |   STATIC
    |   localModifier
    ;

localModifierList
    :   localModifier*
        -> ^(LOCAL_MODIFIER_LIST localModifier*)
    ;
    
localModifier
    :   FINAL
    ;

type
    :   simpleType
    |   objectType
    ;

simpleType // including static arrays of simple type elements
    :   primitiveType arrayDeclaratorList?
        ->  ^(TYPE primitiveType arrayDeclaratorList?)  
    ;
    
objectType // including static arrays of object type reference elements
    :   qualifiedTypeIdent arrayDeclaratorList?
        ->  ^(TYPE qualifiedTypeIdent arrayDeclaratorList?)
    ;

objectTypeSimplified
    :   qualifiedTypeIdentSimplified arrayDeclaratorList?
        ->  ^(TYPE qualifiedTypeIdentSimplified arrayDeclaratorList?)
    ;

qualifiedTypeIdent
    :   typeIdent (DOT typeIdent)*
        ->  ^(QUALIFIED_TYPE_IDENT typeIdent+) 
    ;

qualifiedTypeIdentSimplified
    :   typeIdentSimplified (DOT typeIdentSimplified)*
        ->  ^(QUALIFIED_TYPE_IDENT typeIdentSimplified+) 
    ;

typeIdent
    :   IDENT^
    ;

typeIdentSimplified
    :   IDENT^
    ;

primitiveType
    :   BOOLEAN
    |   SHORT
    |   INT
    |   LONG
    |   DOUBLE
    ;

qualifiedIdentList
    :   qualifiedIdentifier (COMMA! qualifiedIdentifier)*
    ;
    
formalParameterList
    :   LPAREN 
        (   // Contains at least one standard argument declaration and optionally a variable argument declaration.
            formalParameterStandardDecl (COMMA formalParameterStandardDecl)*
            ->  ^(FORMAL_PARAM_LIST[$LPAREN, "FORMAL_PARAM_LIST"] formalParameterStandardDecl+) 
            // Contains nothing.
        |   ->  ^(FORMAL_PARAM_LIST[$LPAREN, "FORMAL_PARAM_LIST"]) 
        )
        RPAREN
    ;
    
formalParameterStandardDecl
    :   localModifierList type variableDeclaratorId
        ->  ^(FORMAL_PARAM_STD_DECL localModifierList type variableDeclaratorId)
    ;
    
qualifiedIdentifier
    :   (   IDENT               ->  IDENT
        )
        (   DOT ident=IDENT     ->  ^(DOT $qualifiedIdentifier $ident)
        )*
    ;

// STATEMENTS / BLOCKS

block
    :   LCURLY blockStatement* RCURLY
        ->  ^(BLOCK_SCOPE[$LCURLY, "BLOCK_SCOPE"] blockStatement*)
    ;

blockStatement
    :   localVariableDeclaration SEMI!
    |   typeDeclaration
    |   statement
    ;
    
localVariableDeclaration
    :   localModifierList type classFieldDeclaratorList
        ->  ^(VAR_DECLARATION localModifierList type classFieldDeclaratorList)
    ;
    
        
statement
    :   block
    |   IF parenthesizedExpression ifStat=statement 
        (   ELSE elseStat=statement                                         ->  ^(IF parenthesizedExpression $ifStat $elseStat)
        |                                                                   ->  ^(IF parenthesizedExpression $ifStat)
        )   
    |   FOR LPAREN 
        (   forInit SEMI forCondition SEMI forUpdater RPAREN statement      ->  ^(FOR forInit forCondition forUpdater statement) 
        |   localModifierList type IDENT COLON expression RPAREN statement
                                                                            ->  ^(FOR_EACH[$FOR, "FOR_EACH"] localModifierList type IDENT expression statement)
        ) 
    |   WHILE parenthesizedExpression statement                             ->  ^(WHILE parenthesizedExpression statement)
    |   DO statement WHILE parenthesizedExpression SEMI                     ->  ^(DO statement parenthesizedExpression)
    |   SWITCH parenthesizedExpression LCURLY switchBlockLabels RCURLY      ->  ^(SWITCH parenthesizedExpression switchBlockLabels)
    |   RETURN expression? SEMI                                             ->  ^(RETURN expression?)
    |   BREAK IDENT? SEMI                                                   ->  ^(BREAK IDENT?)
    |   CONTINUE IDENT? SEMI                                                ->  ^(CONTINUE IDENT?)
    |   IDENT COLON statement                                               ->  ^(LABELED_STATEMENT IDENT statement)
    |   expression SEMI!
    |   SEMI // Preserve empty statements.
    ;           

switchBlockLabels
    :   switchCaseLabels switchDefaultLabel? switchCaseLabels
        ->  ^(SWITCH_BLOCK_LABEL_LIST switchCaseLabels switchDefaultLabel? switchCaseLabels)
    ;
    
switchCaseLabels
    :   switchCaseLabel*
    ;
        
switchCaseLabel
    :   CASE^ expression COLON! blockStatement*
    ;
    
switchDefaultLabel
    :   DEFAULT^ COLON! blockStatement*
    ;
    
forInit
    :   localVariableDeclaration    ->  ^(FOR_INIT localVariableDeclaration)
    |   expressionList              ->  ^(FOR_INIT expressionList)
    |                               ->  ^(FOR_INIT)
    ;
    
forCondition
    :   expression?
        ->  ^(FOR_CONDITION expression?)
    ;
    
forUpdater
    :   expressionList?
        ->  ^(FOR_UPDATE expressionList?)
    ;

// EXPRESSIONS

parenthesizedExpression
    :   LPAREN expression RPAREN
        ->  ^(PARENTESIZED_EXPR[$LPAREN, "PARENTESIZED_EXPR"] expression)
    ;
    
expressionList
    :   expression (COMMA! expression)*
    ;

expression
    :   assignmentExpression
        ->  ^(EXPR assignmentExpression)
    ;

assignmentExpression
    :   conditionalExpression 
        (   (   ASSIGN^
            |   PLUS_ASSIGN^
            |   MINUS_ASSIGN^
            |   STAR_ASSIGN^
            |   DIV_ASSIGN^
            |   AND_ASSIGN^
            |   OR_ASSIGN^
            |   XOR_ASSIGN^
            |   MOD_ASSIGN^
        ) 
        assignmentExpression)?
    ;
    
conditionalExpression
    :   logicalOrExpression (QUESTION^ assignmentExpression COLON! conditionalExpression)?
    ;

logicalOrExpression
    :   logicalAndExpression (LOGICAL_OR^ logicalAndExpression)*
    ;

logicalAndExpression
    :   inclusiveOrExpression (LOGICAL_AND^ inclusiveOrExpression)*
    ;

inclusiveOrExpression
    :   exclusiveOrExpression (OR^ exclusiveOrExpression)*
    ;

exclusiveOrExpression
    :   andExpression (XOR^ andExpression)*
    ;

andExpression
    :   equalityExpression (AND^ equalityExpression)*
    ;

equalityExpression
    :   instanceOfExpression 
        (   (   EQUAL^
            |   NOT_EQUAL^
            ) 
            instanceOfExpression
        )*
    ;

instanceOfExpression
    :   relationalExpression (INSTANCEOF^ type)?
    ;

relationalExpression
    :   shiftExpression 
        (   (   LESS_OR_EQUAL^
            |   GREATER_OR_EQUAL^
            |   LESS_THAN^
            |   GREATER_THAN^
            )
            shiftExpression
        )*
    ;
    
shiftExpression
    :   additiveExpression
        (   (   BIT_SHIFT_RIGHT^
            |   SHIFT_RIGHT^
            |   SHIFT_LEFT^
            )
            additiveExpression
        )*
    ;

additiveExpression
    :   multiplicativeExpression
        (   (   PLUS^
            |   MINUS^
            )
            multiplicativeExpression
        )*
    ;

multiplicativeExpression
    :   unaryExpression 
        (   (   STAR^
            |   DIV^
            |   MOD^
            )
            unaryExpression
        )*
    ;
    
unaryExpression
    :   PLUS unaryExpression        ->  ^(UNARY_PLUS[$PLUS, "UNARY_PLUS"] unaryExpression)
    |   MINUS unaryExpression       ->  ^(UNARY_MINUS[$MINUS, "UNARY_MINUS"] unaryExpression)
    |   INC postfixedExpression     ->  ^(PRE_INC[$INC, "PRE_INC"] postfixedExpression)
    |   DEC postfixedExpression     ->  ^(PRE_DEC[$DEC, "PRE_DEC"] postfixedExpression)
    |   unaryExpressionNotPlusMinus
    ;

unaryExpressionNotPlusMinus
    :   NOT unaryExpression                             ->  ^(NOT unaryExpression)
    |   LOGICAL_NOT unaryExpression                     ->  ^(LOGICAL_NOT unaryExpression)
    |   LPAREN type RPAREN unaryExpression              ->  ^(CAST_EXPR[$LPAREN, "CAST_EXPR"] type unaryExpression)
    |   postfixedExpression
    ;
    
postfixedExpression
        // At first resolve the primary expression ...
    :   (   primaryExpression                       ->  primaryExpression
        )
        // ... and than the optional things that may follow a primary expression 0 or more times.
        (   outerDot=DOT                            
            (   (   IDENT                           ->  ^(DOT $postfixedExpression IDENT)
                ) 
                (   arguments                       ->  ^(METHOD_CALL $postfixedExpression arguments)
                )?
            |   THIS                                ->  ^(DOT $postfixedExpression THIS)
            |   Super=SUPER arguments                   ->  ^(SUPER_CONSTRUCTOR_CALL[$Super, "SUPER_CONSTRUCTOR_CALL"] $postfixedExpression arguments)
            |   (   SUPER innerDot=DOT IDENT        ->  ^($innerDot ^($outerDot $postfixedExpression SUPER) IDENT)
                )
                (   arguments                       ->  ^(METHOD_CALL $postfixedExpression arguments)
                )?
            |   innerNewExpression                  ->  ^(DOT $postfixedExpression innerNewExpression)
            )
        |   LBRACK expression RBRACK                ->  ^(ARRAY_ELEMENT_ACCESS $postfixedExpression expression)
        )*
        // At the end there may follow a post increment/decrement.
        (   INC -> ^(POST_INC[$INC, "POST_INC"] $postfixedExpression)
        |   DEC -> ^(POST_DEC[$DEC, "POST_DEC"] $postfixedExpression)
        )?
    ;    
    
primaryExpression
    :   parenthesizedExpression
    |   literal
    |   newExpression
    |   qualifiedIdentExpression
    |   (   SUPER
            (   arguments                               ->  ^(SUPER_CONSTRUCTOR_CALL[$SUPER, "SUPER_CONSTRUCTOR_CALL"] arguments)
            |   DOT IDENT arguments                     ->  ^(METHOD_CALL ^(DOT SUPER IDENT) arguments)
            )
        |   IDENT arguments                             ->  ^(METHOD_CALL IDENT arguments)
        |   THIS arguments                              ->  ^(THIS_CONSTRUCTOR_CALL[$THIS, "THIS_CONSTRUCTOR_CALL"] arguments)
        )
    |   (   THIS                                        ->  THIS
        )
        (   arguments                                   ->  ^(THIS_CONSTRUCTOR_CALL[$THIS, "THIS_CONSTRUCTOR_CALL"] arguments)
        )?
    |   SUPER arguments                                 ->  ^(SUPER_CONSTRUCTOR_CALL[$SUPER, "SUPER_CONSTRUCTOR_CALL"] arguments)
    |   (   SUPER DOT IDENT
        )
        (   arguments                                   ->  ^(METHOD_CALL ^(DOT SUPER IDENT) arguments)
        |                                               ->  ^(DOT SUPER IDENT)
        )
    |   (   primitiveType                               ->  primitiveType
        )
        (   arrayDeclarator                             ->  ^(arrayDeclarator $primaryExpression)   
        )* 
        DOT CLASS                                       ->  ^(DOT $primaryExpression CLASS)
    |   VOID DOT CLASS                                  ->  ^(DOT VOID CLASS)
    ;
    
qualifiedIdentExpression
        // The qualified identifier itself is the starting point for this rule.
    :   (   qualifiedIdentifier                             ->  qualifiedIdentifier
        )
        // And now comes the stuff that may follow the qualified identifier.
        (   (   arrayDeclarator                         ->  ^(arrayDeclarator $qualifiedIdentExpression)
            )+ 
            (   DOT CLASS                               ->  ^(DOT $qualifiedIdentExpression CLASS)
            )
        |   arguments                                   ->  ^(METHOD_CALL qualifiedIdentifier arguments)
        |   outerDot=DOT
            (   CLASS                                   ->  ^(DOT qualifiedIdentifier CLASS)
            |   (   Super=SUPER arguments               ->  ^(SUPER_CONSTRUCTOR_CALL[$Super, "SUPER_CONSTRUCTOR_CALL"] qualifiedIdentifier arguments)
                |   SUPER innerDot=DOT IDENT arguments  ->  ^(METHOD_CALL ^($innerDot ^($outerDot qualifiedIdentifier SUPER) IDENT) arguments)
                |   IDENT arguments                     ->  ^(METHOD_CALL ^(DOT qualifiedIdentifier IDENT) arguments)
                )
            |   THIS                                    ->  ^(DOT qualifiedIdentifier THIS)
            |   Super=SUPER arguments                   ->  ^(SUPER_CONSTRUCTOR_CALL[$Super, "SUPER_CONSTRUCTOR_CALL"] qualifiedIdentifier arguments)
            |   innerNewExpression                      ->  ^(DOT qualifiedIdentifier innerNewExpression)
            )
        )?
    ;

newExpression
    :   NEW  
        (   primitiveType newArrayConstruction      // new static array of primitive type elements
            ->  ^(STATIC_ARRAY_CREATOR[$NEW, "STATIC_ARRAY_CREATOR"] primitiveType newArrayConstruction)
        |   qualifiedTypeIdentSimplified
            (   newArrayConstruction                // new static array of object type reference elements
                ->  ^(STATIC_ARRAY_CREATOR[$NEW, "STATIC_ARRAY_CREATOR"] qualifiedTypeIdentSimplified newArrayConstruction)
            |   arguments classBody?                // new object type via constructor invocation
                ->  ^(CLASS_CONSTRUCTOR_CALL[$NEW, "STATIC_ARRAY_CREATOR"] qualifiedTypeIdentSimplified arguments classBody?)
            )
        )
    ;
    
innerNewExpression // something like 'InnerType innerType = outer.new InnerType();'
    :   NEW IDENT arguments classBody?
        ->  ^(CLASS_CONSTRUCTOR_CALL[$NEW, "STATIC_ARRAY_CREATOR"] IDENT arguments classBody?)
    ;

newArrayConstruction
    :   arrayDeclaratorList arrayInitializer
    |   LBRACK! expression RBRACK! (LBRACK! expression RBRACK!)* arrayDeclaratorList?
    ;

arguments
    :   LPAREN expressionList? RPAREN
        ->  ^(ARGUMENT_LIST[$LPAREN, "ARGUMENT_LIST"] expressionList?)
    ;

literal 
    :   HEX_LITERAL
    |   OCTAL_LITERAL
    |   DECIMAL_LITERAL
    |   FLOATING_POINT_LITERAL
    |   CHARACTER_LITERAL
    |   STRING_LITERAL
    |   TRUE
    |   FALSE
    |   NULL
    ;

// LEXER

HEX_LITERAL : '0' ('x'|'X') HEX_DIGIT+ INTEGER_TYPE_SUFFIX? ;

DECIMAL_LITERAL : ('0' | '1'..'9' '0'..'9'*) INTEGER_TYPE_SUFFIX? ;

OCTAL_LITERAL : '0' ('0'..'7')+ INTEGER_TYPE_SUFFIX? ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
INTEGER_TYPE_SUFFIX : ('l'|'L') ;

FLOATING_POINT_LITERAL
    :   ('0'..'9')+ 
        (
            DOT ('0'..'9')* EXPONENT? FLOAT_TYPE_SUFFIX?
        |   EXPONENT FLOAT_TYPE_SUFFIX?
        |   FLOAT_TYPE_SUFFIX
        )
    |   DOT ('0'..'9')+ EXPONENT? FLOAT_TYPE_SUFFIX?
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
FLOAT_TYPE_SUFFIX : ('d'|'D') ;

CHARACTER_LITERAL
    :   '\'' ( ESCAPE_SEQUENCE | ~('\''|'\\') ) '\''
    ;

STRING_LITERAL
    :  '"' ( ESCAPE_SEQUENCE | ~('\\'|'"') )* '"'
    ;

fragment
ESCAPE_SEQUENCE
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESCAPE
    |   OCTAL_ESCAPE
    ;

fragment
OCTAL_ESCAPE
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESCAPE
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

IDENT
    :   JAVA_ID_START (JAVA_ID_PART)*
    ;

fragment
JAVA_ID_START
    :  '\u0024'
    |  '\u0041'..'\u005a'
    |  '\u005f'
    |  '\u0061'..'\u007a'
    |  '\u00c0'..'\u00d6'
    |  '\u00d8'..'\u00f6'
    |  '\u00f8'..'\u00ff'
    |  '\u0100'..'\u1fff'
    |  '\u3040'..'\u318f'
    |  '\u3300'..'\u337f'
    |  '\u3400'..'\u3d2d'
    |  '\u4e00'..'\u9fff'
    |  '\uf900'..'\ufaff'
    ;

fragment
JAVA_ID_PART
    :  JAVA_ID_START
    |  '\u0030'..'\u0039'
    ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') 
    {   
        if (!preserveWhitespacesAndComments) {
            skip();
        } else {
            $channel = HIDDEN;
        }
    }
    ;

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/'
    {   
        if (!preserveWhitespacesAndComments) {
            skip();
        } else {
            $channel = HIDDEN;
        }
    }
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n'
    {   
        if (!preserveWhitespacesAndComments) {
            skip();
        } else {
            $channel = HIDDEN;
        }
    }
    ;
