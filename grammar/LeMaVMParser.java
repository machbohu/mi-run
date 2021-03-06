// $ANTLR 3.2 Sep 23, 2009 12:02:23 LeMaVM.g 2012-11-27 18:53:47

package cz.cvut.fit.mirun.lemavm.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

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
public class LeMaVMParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "AND_ASSIGN", "ASSIGN", "AT", "BIT_SHIFT_RIGHT", "BIT_SHIFT_RIGHT_ASSIGN", "COLON", "COMMA", "DEC", "DIV", "DIV_ASSIGN", "DOT", "DOTSTAR", "ELLIPSIS", "EQUAL", "GREATER_OR_EQUAL", "GREATER_THAN", "INC", "LBRACK", "LCURLY", "LESS_OR_EQUAL", "LESS_THAN", "LOGICAL_AND", "LOGICAL_NOT", "LOGICAL_OR", "LPAREN", "MINUS", "MINUS_ASSIGN", "MOD", "MOD_ASSIGN", "NOT", "NOT_EQUAL", "OR", "OR_ASSIGN", "PLUS", "PLUS_ASSIGN", "QUESTION", "RBRACK", "RCURLY", "RPAREN", "SEMI", "SHIFT_LEFT", "SHIFT_LEFT_ASSIGN", "SHIFT_RIGHT", "SHIFT_RIGHT_ASSIGN", "STAR", "STAR_ASSIGN", "XOR", "XOR_ASSIGN", "BOOLEAN", "BREAK", "CASE", "CLASS", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "EXTENDS", "FALSE", "FINAL", "FOR", "IF", "INSTANCEOF", "IMPORT", "INT", "LONG", "NEW", "NULL", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", "STRING", "SUPER", "SWITCH", "THIS", "TRUE", "TRY", "VOID", "WHILE", "ARGUMENT_LIST", "ARRAY_DECLARATOR", "ARRAY_DECLARATOR_LIST", "ARRAY_ELEMENT_ACCESS", "ARRAY_INITIALIZER", "BLOCK_SCOPE", "CAST_EXPR", "CATCH_CLAUSE_LIST", "CLASS_CONSTRUCTOR_CALL", "CLASS_INSTANCE_INITIALIZER", "CLASS_STATIC_INITIALIZER", "CLASS_TOP_LEVEL_SCOPE", "CONSTRUCTOR_DECL", "ENUM_TOP_LEVEL_SCOPE", "EXPR", "EXTENDS_BOUND_LIST", "EXTENDS_CLAUSE", "FOR_CONDITION", "FOR_EACH", "FOR_INIT", "FOR_UPDATE", "FORMAL_PARAM_LIST", "FORMAL_PARAM_STD_DECL", "FUNCTION_METHOD_DECL", "LABELED_STATEMENT", "LOCAL_MODIFIER_LIST", "JAVA_SOURCE", "METHOD_CALL", "MODIFIER_LIST", "PARENTESIZED_EXPR", "POST_DEC", "POST_INC", "PRE_DEC", "PRE_INC", "QUALIFIED_TYPE_IDENT", "STATIC_ARRAY_CREATOR", "SUPER_CONSTRUCTOR_CALL", "SWITCH_BLOCK_LABEL_LIST", "THIS_CONSTRUCTOR_CALL", "TYPE", "UNARY_MINUS", "UNARY_PLUS", "VAR_DECLARATION", "VAR_DECLARATOR", "VAR_DECLARATOR_LIST", "VOID_METHOD_DECL", "IDENT", "HEX_LITERAL", "OCTAL_LITERAL", "DECIMAL_LITERAL", "FLOATING_POINT_LITERAL", "CHARACTER_LITERAL", "STRING_LITERAL", "HEX_DIGIT", "INTEGER_TYPE_SUFFIX", "EXPONENT", "FLOAT_TYPE_SUFFIX", "ESCAPE_SEQUENCE", "UNICODE_ESCAPE", "OCTAL_ESCAPE", "JAVA_ID_START", "JAVA_ID_PART", "WS", "COMMENT", "LINE_COMMENT"
    };
    public static final int PACKAGE=73;
    public static final int EXPONENT=143;
    public static final int STAR=49;
    public static final int WHILE=87;
    public static final int MOD=32;
    public static final int MOD_ASSIGN=33;
    public static final int CASE=55;
    public static final int NEW=71;
    public static final int DO=59;
    public static final int CLASS_INSTANCE_INITIALIZER=97;
    public static final int ARRAY_ELEMENT_ACCESS=91;
    public static final int FOR_CONDITION=105;
    public static final int NOT=34;
    public static final int VAR_DECLARATION=130;
    public static final int EOF=-1;
    public static final int DIV_ASSIGN=14;
    public static final int LOGICAL_AND=26;
    public static final int BREAK=54;
    public static final int UNARY_PLUS=129;
    public static final int BIT_SHIFT_RIGHT_ASSIGN=9;
    public static final int TYPE=127;
    public static final int RPAREN=43;
    public static final int INC=21;
    public static final int FINAL=64;
    public static final int IMPORT=68;
    public static final int STRING_LITERAL=140;
    public static final int FOR_UPDATE=108;
    public static final int FLOATING_POINT_LITERAL=138;
    public static final int CAST_EXPR=94;
    public static final int NOT_EQUAL=35;
    public static final int VOID_METHOD_DECL=133;
    public static final int RETURN=77;
    public static final int THIS=83;
    public static final int DOUBLE=60;
    public static final int ENUM_TOP_LEVEL_SCOPE=101;
    public static final int VOID=86;
    public static final int SUPER=81;
    public static final int COMMENT=151;
    public static final int JAVA_ID_START=148;
    public static final int FLOAT_TYPE_SUFFIX=144;
    public static final int PRE_DEC=120;
    public static final int RBRACK=41;
    public static final int SWITCH_BLOCK_LABEL_LIST=125;
    public static final int LINE_COMMENT=152;
    public static final int PRIVATE=74;
    public static final int STATIC=79;
    public static final int BLOCK_SCOPE=93;
    public static final int SWITCH=82;
    public static final int NULL=72;
    public static final int VAR_DECLARATOR=131;
    public static final int MINUS_ASSIGN=31;
    public static final int ELSE=61;
    public static final int CHARACTER_LITERAL=139;
    public static final int PRE_INC=121;
    public static final int ELLIPSIS=17;
    public static final int OCTAL_ESCAPE=147;
    public static final int UNARY_MINUS=128;
    public static final int LCURLY=23;
    public static final int INT=69;
    public static final int METHOD_CALL=115;
    public static final int TRY=85;
    public static final int SHIFT_LEFT=45;
    public static final int WS=150;
    public static final int SHIFT_RIGHT=47;
    public static final int FORMAL_PARAM_STD_DECL=110;
    public static final int LOCAL_MODIFIER_LIST=113;
    public static final int OR=36;
    public static final int LESS_THAN=25;
    public static final int SHIFT_RIGHT_ASSIGN=48;
    public static final int EXTENDS_BOUND_LIST=103;
    public static final int JAVA_SOURCE=114;
    public static final int FALSE=63;
    public static final int INTEGER_TYPE_SUFFIX=142;
    public static final int DECIMAL_LITERAL=137;
    public static final int FOR_INIT=107;
    public static final int DEC=12;
    public static final int PROTECTED=75;
    public static final int CLASS=56;
    public static final int LBRACK=22;
    public static final int BIT_SHIFT_RIGHT=8;
    public static final int GREATER_OR_EQUAL=19;
    public static final int FOR=65;
    public static final int THIS_CONSTRUCTOR_CALL=126;
    public static final int LOGICAL_NOT=27;
    public static final int AND=4;
    public static final int POST_DEC=118;
    public static final int AND_ASSIGN=5;
    public static final int STATIC_ARRAY_CREATOR=123;
    public static final int MODIFIER_LIST=116;
    public static final int LPAREN=29;
    public static final int IF=66;
    public static final int AT=7;
    public static final int ESCAPE_SEQUENCE=145;
    public static final int CONSTRUCTOR_DECL=100;
    public static final int LABELED_STATEMENT=112;
    public static final int UNICODE_ESCAPE=146;
    public static final int EXPR=102;
    public static final int BOOLEAN=53;
    public static final int CLASS_TOP_LEVEL_SCOPE=99;
    public static final int CONTINUE=57;
    public static final int COMMA=11;
    public static final int EQUAL=18;
    public static final int XOR_ASSIGN=52;
    public static final int LOGICAL_OR=28;
    public static final int IDENT=134;
    public static final int QUALIFIED_TYPE_IDENT=122;
    public static final int ARGUMENT_LIST=88;
    public static final int PLUS=38;
    public static final int HEX_LITERAL=135;
    public static final int DOT=15;
    public static final int SHIFT_LEFT_ASSIGN=46;
    public static final int FORMAL_PARAM_LIST=109;
    public static final int DOTSTAR=16;
    public static final int XOR=51;
    public static final int JAVA_ID_PART=149;
    public static final int GREATER_THAN=20;
    public static final int PARENTESIZED_EXPR=117;
    public static final int CLASS_STATIC_INITIALIZER=98;
    public static final int LESS_OR_EQUAL=24;
    public static final int ARRAY_DECLARATOR_LIST=90;
    public static final int DEFAULT=58;
    public static final int OCTAL_LITERAL=136;
    public static final int HEX_DIGIT=141;
    public static final int SHORT=78;
    public static final int INSTANCEOF=67;
    public static final int MINUS=30;
    public static final int EXTENDS_CLAUSE=104;
    public static final int SEMI=44;
    public static final int TRUE=84;
    public static final int STAR_ASSIGN=50;
    public static final int VAR_DECLARATOR_LIST=132;
    public static final int COLON=10;
    public static final int ARRAY_DECLARATOR=89;
    public static final int OR_ASSIGN=37;
    public static final int QUESTION=40;
    public static final int RCURLY=42;
    public static final int PLUS_ASSIGN=39;
    public static final int ASSIGN=6;
    public static final int FUNCTION_METHOD_DECL=111;
    public static final int POST_INC=119;
    public static final int DIV=13;
    public static final int CLASS_CONSTRUCTOR_CALL=96;
    public static final int LONG=70;
    public static final int FOR_EACH=106;
    public static final int EXTENDS=62;
    public static final int PUBLIC=76;
    public static final int ARRAY_INITIALIZER=92;
    public static final int CATCH_CLAUSE_LIST=95;
    public static final int SUPER_CONSTRUCTOR_CALL=124;
    public static final int STRING=80;

    // delegates
    // delegators


        public LeMaVMParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LeMaVMParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[238+1];
             
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return LeMaVMParser.tokenNames; }
    public String getGrammarFileName() { return "LeMaVM.g"; }


        
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


    public static class javaSource_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "javaSource"
    // LeMaVM.g:294:1: javaSource : compilationUnit -> ^( JAVA_SOURCE compilationUnit ) ;
    public final LeMaVMParser.javaSource_return javaSource() throws RecognitionException {
        LeMaVMParser.javaSource_return retval = new LeMaVMParser.javaSource_return();
        retval.start = input.LT(1);
        int javaSource_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.compilationUnit_return compilationUnit1 = null;


        RewriteRuleSubtreeStream stream_compilationUnit=new RewriteRuleSubtreeStream(adaptor,"rule compilationUnit");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // LeMaVM.g:295:5: ( compilationUnit -> ^( JAVA_SOURCE compilationUnit ) )
            // LeMaVM.g:295:9: compilationUnit
            {
            pushFollow(FOLLOW_compilationUnit_in_javaSource3808);
            compilationUnit1=compilationUnit();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_compilationUnit.add(compilationUnit1.getTree());


            // AST REWRITE
            // elements: compilationUnit
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 296:9: -> ^( JAVA_SOURCE compilationUnit )
            {
                // LeMaVM.g:296:13: ^( JAVA_SOURCE compilationUnit )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(JAVA_SOURCE, "JAVA_SOURCE"), root_1);

                adaptor.addChild(root_1, stream_compilationUnit.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, javaSource_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "javaSource"

    public static class compilationUnit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compilationUnit"
    // LeMaVM.g:299:1: compilationUnit : ( packageDeclaration )? ( importDeclaration )* ( typeDecls )* ;
    public final LeMaVMParser.compilationUnit_return compilationUnit() throws RecognitionException {
        LeMaVMParser.compilationUnit_return retval = new LeMaVMParser.compilationUnit_return();
        retval.start = input.LT(1);
        int compilationUnit_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.packageDeclaration_return packageDeclaration2 = null;

        LeMaVMParser.importDeclaration_return importDeclaration3 = null;

        LeMaVMParser.typeDecls_return typeDecls4 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // LeMaVM.g:300:5: ( ( packageDeclaration )? ( importDeclaration )* ( typeDecls )* )
            // LeMaVM.g:300:9: ( packageDeclaration )? ( importDeclaration )* ( typeDecls )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // LeMaVM.g:300:9: ( packageDeclaration )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==PACKAGE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // LeMaVM.g:0:0: packageDeclaration
                    {
                    pushFollow(FOLLOW_packageDeclaration_in_compilationUnit3844);
                    packageDeclaration2=packageDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, packageDeclaration2.getTree());

                    }
                    break;

            }

            // LeMaVM.g:301:9: ( importDeclaration )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IMPORT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // LeMaVM.g:0:0: importDeclaration
            	    {
            	    pushFollow(FOLLOW_importDeclaration_in_compilationUnit3856);
            	    importDeclaration3=importDeclaration();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, importDeclaration3.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // LeMaVM.g:302:9: ( typeDecls )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==SEMI||LA3_0==BOOLEAN||LA3_0==CLASS||LA3_0==DOUBLE||LA3_0==FINAL||(LA3_0>=INT && LA3_0<=LONG)||(LA3_0>=PRIVATE && LA3_0<=PUBLIC)||(LA3_0>=SHORT && LA3_0<=STRING)||LA3_0==VOID||LA3_0==IDENT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // LeMaVM.g:0:0: typeDecls
            	    {
            	    pushFollow(FOLLOW_typeDecls_in_compilationUnit3868);
            	    typeDecls4=typeDecls();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDecls4.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, compilationUnit_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "compilationUnit"

    public static class typeDecls_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeDecls"
    // LeMaVM.g:305:1: typeDecls : ( typeDeclaration | SEMI );
    public final LeMaVMParser.typeDecls_return typeDecls() throws RecognitionException {
        LeMaVMParser.typeDecls_return retval = new LeMaVMParser.typeDecls_return();
        retval.start = input.LT(1);
        int typeDecls_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SEMI6=null;
        LeMaVMParser.typeDeclaration_return typeDeclaration5 = null;


        CommonTree SEMI6_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // LeMaVM.g:306:5: ( typeDeclaration | SEMI )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==BOOLEAN||LA4_0==CLASS||LA4_0==DOUBLE||LA4_0==FINAL||(LA4_0>=INT && LA4_0<=LONG)||(LA4_0>=PRIVATE && LA4_0<=PUBLIC)||(LA4_0>=SHORT && LA4_0<=STRING)||LA4_0==VOID||LA4_0==IDENT) ) {
                alt4=1;
            }
            else if ( (LA4_0==SEMI) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // LeMaVM.g:306:9: typeDeclaration
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_typeDeclaration_in_typeDecls3888);
                    typeDeclaration5=typeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDeclaration5.getTree());

                    }
                    break;
                case 2 :
                    // LeMaVM.g:307:9: SEMI
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SEMI6=(Token)match(input,SEMI,FOLLOW_SEMI_in_typeDecls3898); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, typeDecls_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeDecls"

    public static class packageDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "packageDeclaration"
    // LeMaVM.g:310:1: packageDeclaration : PACKAGE qualifiedIdentifier SEMI ;
    public final LeMaVMParser.packageDeclaration_return packageDeclaration() throws RecognitionException {
        LeMaVMParser.packageDeclaration_return retval = new LeMaVMParser.packageDeclaration_return();
        retval.start = input.LT(1);
        int packageDeclaration_StartIndex = input.index();
        CommonTree root_0 = null;

        Token PACKAGE7=null;
        Token SEMI9=null;
        LeMaVMParser.qualifiedIdentifier_return qualifiedIdentifier8 = null;


        CommonTree PACKAGE7_tree=null;
        CommonTree SEMI9_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // LeMaVM.g:311:5: ( PACKAGE qualifiedIdentifier SEMI )
            // LeMaVM.g:311:9: PACKAGE qualifiedIdentifier SEMI
            {
            root_0 = (CommonTree)adaptor.nil();

            PACKAGE7=(Token)match(input,PACKAGE,FOLLOW_PACKAGE_in_packageDeclaration3918); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PACKAGE7_tree = (CommonTree)adaptor.create(PACKAGE7);
            root_0 = (CommonTree)adaptor.becomeRoot(PACKAGE7_tree, root_0);
            }
            pushFollow(FOLLOW_qualifiedIdentifier_in_packageDeclaration3921);
            qualifiedIdentifier8=qualifiedIdentifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, qualifiedIdentifier8.getTree());
            SEMI9=(Token)match(input,SEMI,FOLLOW_SEMI_in_packageDeclaration3923); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, packageDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "packageDeclaration"

    public static class importDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "importDeclaration"
    // LeMaVM.g:314:1: importDeclaration : IMPORT ( STATIC )? qualifiedIdentifier ( DOTSTAR )? SEMI ;
    public final LeMaVMParser.importDeclaration_return importDeclaration() throws RecognitionException {
        LeMaVMParser.importDeclaration_return retval = new LeMaVMParser.importDeclaration_return();
        retval.start = input.LT(1);
        int importDeclaration_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IMPORT10=null;
        Token STATIC11=null;
        Token DOTSTAR13=null;
        Token SEMI14=null;
        LeMaVMParser.qualifiedIdentifier_return qualifiedIdentifier12 = null;


        CommonTree IMPORT10_tree=null;
        CommonTree STATIC11_tree=null;
        CommonTree DOTSTAR13_tree=null;
        CommonTree SEMI14_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // LeMaVM.g:315:5: ( IMPORT ( STATIC )? qualifiedIdentifier ( DOTSTAR )? SEMI )
            // LeMaVM.g:315:9: IMPORT ( STATIC )? qualifiedIdentifier ( DOTSTAR )? SEMI
            {
            root_0 = (CommonTree)adaptor.nil();

            IMPORT10=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_importDeclaration3949); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IMPORT10_tree = (CommonTree)adaptor.create(IMPORT10);
            root_0 = (CommonTree)adaptor.becomeRoot(IMPORT10_tree, root_0);
            }
            // LeMaVM.g:315:17: ( STATIC )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==STATIC) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // LeMaVM.g:0:0: STATIC
                    {
                    STATIC11=(Token)match(input,STATIC,FOLLOW_STATIC_in_importDeclaration3952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STATIC11_tree = (CommonTree)adaptor.create(STATIC11);
                    adaptor.addChild(root_0, STATIC11_tree);
                    }

                    }
                    break;

            }

            pushFollow(FOLLOW_qualifiedIdentifier_in_importDeclaration3955);
            qualifiedIdentifier12=qualifiedIdentifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, qualifiedIdentifier12.getTree());
            // LeMaVM.g:315:45: ( DOTSTAR )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DOTSTAR) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // LeMaVM.g:0:0: DOTSTAR
                    {
                    DOTSTAR13=(Token)match(input,DOTSTAR,FOLLOW_DOTSTAR_in_importDeclaration3957); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOTSTAR13_tree = (CommonTree)adaptor.create(DOTSTAR13);
                    adaptor.addChild(root_0, DOTSTAR13_tree);
                    }

                    }
                    break;

            }

            SEMI14=(Token)match(input,SEMI,FOLLOW_SEMI_in_importDeclaration3960); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, importDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "importDeclaration"

    public static class typeDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeDeclaration"
    // LeMaVM.g:318:1: typeDeclaration : modifierList ( classTypeDeclaration[$modifierList.tree] ) ;
    public final LeMaVMParser.typeDeclaration_return typeDeclaration() throws RecognitionException {
        LeMaVMParser.typeDeclaration_return retval = new LeMaVMParser.typeDeclaration_return();
        retval.start = input.LT(1);
        int typeDeclaration_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.modifierList_return modifierList15 = null;

        LeMaVMParser.classTypeDeclaration_return classTypeDeclaration16 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // LeMaVM.g:319:5: ( modifierList ( classTypeDeclaration[$modifierList.tree] ) )
            // LeMaVM.g:319:9: modifierList ( classTypeDeclaration[$modifierList.tree] )
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_modifierList_in_typeDeclaration3984);
            modifierList15=modifierList();

            state._fsp--;
            if (state.failed) return retval;
            // LeMaVM.g:320:9: ( classTypeDeclaration[$modifierList.tree] )
            // LeMaVM.g:320:13: classTypeDeclaration[$modifierList.tree]
            {
            pushFollow(FOLLOW_classTypeDeclaration_in_typeDeclaration3999);
            classTypeDeclaration16=classTypeDeclaration((modifierList15!=null?((CommonTree)modifierList15.tree):null));

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, classTypeDeclaration16.getTree());

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, typeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeDeclaration"

    public static class classTypeDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classTypeDeclaration"
    // LeMaVM.g:324:1: classTypeDeclaration[CommonTree modifiers] : CLASS IDENT ( classExtendsClause )? classBody -> ^( CLASS IDENT ( classExtendsClause )? classBody ) ;
    public final LeMaVMParser.classTypeDeclaration_return classTypeDeclaration(CommonTree modifiers) throws RecognitionException {
        LeMaVMParser.classTypeDeclaration_return retval = new LeMaVMParser.classTypeDeclaration_return();
        retval.start = input.LT(1);
        int classTypeDeclaration_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CLASS17=null;
        Token IDENT18=null;
        LeMaVMParser.classExtendsClause_return classExtendsClause19 = null;

        LeMaVMParser.classBody_return classBody20 = null;


        CommonTree CLASS17_tree=null;
        CommonTree IDENT18_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");
        RewriteRuleSubtreeStream stream_classExtendsClause=new RewriteRuleSubtreeStream(adaptor,"rule classExtendsClause");
        RewriteRuleSubtreeStream stream_classBody=new RewriteRuleSubtreeStream(adaptor,"rule classBody");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // LeMaVM.g:325:5: ( CLASS IDENT ( classExtendsClause )? classBody -> ^( CLASS IDENT ( classExtendsClause )? classBody ) )
            // LeMaVM.g:325:9: CLASS IDENT ( classExtendsClause )? classBody
            {
            CLASS17=(Token)match(input,CLASS,FOLLOW_CLASS_in_classTypeDeclaration4034); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLASS.add(CLASS17);

            IDENT18=(Token)match(input,IDENT,FOLLOW_IDENT_in_classTypeDeclaration4036); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT18);

            // LeMaVM.g:325:21: ( classExtendsClause )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==EXTENDS) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // LeMaVM.g:0:0: classExtendsClause
                    {
                    pushFollow(FOLLOW_classExtendsClause_in_classTypeDeclaration4038);
                    classExtendsClause19=classExtendsClause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_classExtendsClause.add(classExtendsClause19.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_classBody_in_classTypeDeclaration4041);
            classBody20=classBody();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_classBody.add(classBody20.getTree());


            // AST REWRITE
            // elements: classBody, CLASS, classExtendsClause, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 326:9: -> ^( CLASS IDENT ( classExtendsClause )? classBody )
            {
                // LeMaVM.g:326:13: ^( CLASS IDENT ( classExtendsClause )? classBody )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_CLASS.nextNode(), root_1);

                adaptor.addChild(root_1, modifiers);
                adaptor.addChild(root_1, stream_IDENT.nextNode());
                // LeMaVM.g:326:40: ( classExtendsClause )?
                if ( stream_classExtendsClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_classExtendsClause.nextTree());

                }
                stream_classExtendsClause.reset();
                adaptor.addChild(root_1, stream_classBody.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, classTypeDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "classTypeDeclaration"

    public static class classExtendsClause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classExtendsClause"
    // LeMaVM.g:329:1: classExtendsClause : EXTENDS type -> ^( EXTENDS_CLAUSE[$EXTENDS, \"EXTENDS_CLAUSE\"] type ) ;
    public final LeMaVMParser.classExtendsClause_return classExtendsClause() throws RecognitionException {
        LeMaVMParser.classExtendsClause_return retval = new LeMaVMParser.classExtendsClause_return();
        retval.start = input.LT(1);
        int classExtendsClause_StartIndex = input.index();
        CommonTree root_0 = null;

        Token EXTENDS21=null;
        LeMaVMParser.type_return type22 = null;


        CommonTree EXTENDS21_tree=null;
        RewriteRuleTokenStream stream_EXTENDS=new RewriteRuleTokenStream(adaptor,"token EXTENDS");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // LeMaVM.g:330:5: ( EXTENDS type -> ^( EXTENDS_CLAUSE[$EXTENDS, \"EXTENDS_CLAUSE\"] type ) )
            // LeMaVM.g:330:9: EXTENDS type
            {
            EXTENDS21=(Token)match(input,EXTENDS,FOLLOW_EXTENDS_in_classExtendsClause4088); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EXTENDS.add(EXTENDS21);

            pushFollow(FOLLOW_type_in_classExtendsClause4090);
            type22=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type22.getTree());


            // AST REWRITE
            // elements: type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 331:9: -> ^( EXTENDS_CLAUSE[$EXTENDS, \"EXTENDS_CLAUSE\"] type )
            {
                // LeMaVM.g:331:13: ^( EXTENDS_CLAUSE[$EXTENDS, \"EXTENDS_CLAUSE\"] type )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXTENDS_CLAUSE, EXTENDS21, "EXTENDS_CLAUSE"), root_1);

                adaptor.addChild(root_1, stream_type.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, classExtendsClause_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "classExtendsClause"

    public static class bound_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bound"
    // LeMaVM.g:334:1: bound : EXTENDS type ( AND type )* -> ^( EXTENDS_BOUND_LIST[$EXTENDS, \"EXTENDS_BOUND_LIST\"] ( type )+ ) ;
    public final LeMaVMParser.bound_return bound() throws RecognitionException {
        LeMaVMParser.bound_return retval = new LeMaVMParser.bound_return();
        retval.start = input.LT(1);
        int bound_StartIndex = input.index();
        CommonTree root_0 = null;

        Token EXTENDS23=null;
        Token AND25=null;
        LeMaVMParser.type_return type24 = null;

        LeMaVMParser.type_return type26 = null;


        CommonTree EXTENDS23_tree=null;
        CommonTree AND25_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_EXTENDS=new RewriteRuleTokenStream(adaptor,"token EXTENDS");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // LeMaVM.g:335:5: ( EXTENDS type ( AND type )* -> ^( EXTENDS_BOUND_LIST[$EXTENDS, \"EXTENDS_BOUND_LIST\"] ( type )+ ) )
            // LeMaVM.g:335:9: EXTENDS type ( AND type )*
            {
            EXTENDS23=(Token)match(input,EXTENDS,FOLLOW_EXTENDS_in_bound4138); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EXTENDS.add(EXTENDS23);

            pushFollow(FOLLOW_type_in_bound4140);
            type24=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type24.getTree());
            // LeMaVM.g:335:22: ( AND type )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==AND) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // LeMaVM.g:335:23: AND type
            	    {
            	    AND25=(Token)match(input,AND,FOLLOW_AND_in_bound4143); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AND.add(AND25);

            	    pushFollow(FOLLOW_type_in_bound4145);
            	    type26=type();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_type.add(type26.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);



            // AST REWRITE
            // elements: type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 336:9: -> ^( EXTENDS_BOUND_LIST[$EXTENDS, \"EXTENDS_BOUND_LIST\"] ( type )+ )
            {
                // LeMaVM.g:336:13: ^( EXTENDS_BOUND_LIST[$EXTENDS, \"EXTENDS_BOUND_LIST\"] ( type )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXTENDS_BOUND_LIST, EXTENDS23, "EXTENDS_BOUND_LIST"), root_1);

                if ( !(stream_type.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_type.hasNext() ) {
                    adaptor.addChild(root_1, stream_type.nextTree());

                }
                stream_type.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, bound_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "bound"

    public static class typeList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeList"
    // LeMaVM.g:339:1: typeList : type ( COMMA type )* ;
    public final LeMaVMParser.typeList_return typeList() throws RecognitionException {
        LeMaVMParser.typeList_return retval = new LeMaVMParser.typeList_return();
        retval.start = input.LT(1);
        int typeList_StartIndex = input.index();
        CommonTree root_0 = null;

        Token COMMA28=null;
        LeMaVMParser.type_return type27 = null;

        LeMaVMParser.type_return type29 = null;


        CommonTree COMMA28_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // LeMaVM.g:340:5: ( type ( COMMA type )* )
            // LeMaVM.g:340:9: type ( COMMA type )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_in_typeList4189);
            type27=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, type27.getTree());
            // LeMaVM.g:340:14: ( COMMA type )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMMA) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // LeMaVM.g:340:15: COMMA type
            	    {
            	    COMMA28=(Token)match(input,COMMA,FOLLOW_COMMA_in_typeList4192); if (state.failed) return retval;
            	    pushFollow(FOLLOW_type_in_typeList4195);
            	    type29=type();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, type29.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, typeList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeList"

    public static class classBody_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classBody"
    // LeMaVM.g:343:1: classBody : LCURLY ( classScopeDeclarations )* RCURLY -> ^( CLASS_TOP_LEVEL_SCOPE[$LCURLY, \"CLASS_TOP_LEVEL_SCOPE\"] ( classScopeDeclarations )* ) ;
    public final LeMaVMParser.classBody_return classBody() throws RecognitionException {
        LeMaVMParser.classBody_return retval = new LeMaVMParser.classBody_return();
        retval.start = input.LT(1);
        int classBody_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LCURLY30=null;
        Token RCURLY32=null;
        LeMaVMParser.classScopeDeclarations_return classScopeDeclarations31 = null;


        CommonTree LCURLY30_tree=null;
        CommonTree RCURLY32_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_classScopeDeclarations=new RewriteRuleSubtreeStream(adaptor,"rule classScopeDeclarations");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // LeMaVM.g:344:5: ( LCURLY ( classScopeDeclarations )* RCURLY -> ^( CLASS_TOP_LEVEL_SCOPE[$LCURLY, \"CLASS_TOP_LEVEL_SCOPE\"] ( classScopeDeclarations )* ) )
            // LeMaVM.g:344:9: LCURLY ( classScopeDeclarations )* RCURLY
            {
            LCURLY30=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_classBody4220); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY30);

            // LeMaVM.g:344:16: ( classScopeDeclarations )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==LCURLY||LA10_0==SEMI||LA10_0==BOOLEAN||LA10_0==CLASS||LA10_0==DOUBLE||LA10_0==FINAL||(LA10_0>=INT && LA10_0<=LONG)||(LA10_0>=PRIVATE && LA10_0<=PUBLIC)||(LA10_0>=SHORT && LA10_0<=STRING)||LA10_0==VOID||LA10_0==IDENT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // LeMaVM.g:0:0: classScopeDeclarations
            	    {
            	    pushFollow(FOLLOW_classScopeDeclarations_in_classBody4222);
            	    classScopeDeclarations31=classScopeDeclarations();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_classScopeDeclarations.add(classScopeDeclarations31.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            RCURLY32=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_classBody4225); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY32);



            // AST REWRITE
            // elements: classScopeDeclarations
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 345:9: -> ^( CLASS_TOP_LEVEL_SCOPE[$LCURLY, \"CLASS_TOP_LEVEL_SCOPE\"] ( classScopeDeclarations )* )
            {
                // LeMaVM.g:345:13: ^( CLASS_TOP_LEVEL_SCOPE[$LCURLY, \"CLASS_TOP_LEVEL_SCOPE\"] ( classScopeDeclarations )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CLASS_TOP_LEVEL_SCOPE, LCURLY30, "CLASS_TOP_LEVEL_SCOPE"), root_1);

                // LeMaVM.g:345:71: ( classScopeDeclarations )*
                while ( stream_classScopeDeclarations.hasNext() ) {
                    adaptor.addChild(root_1, stream_classScopeDeclarations.nextTree());

                }
                stream_classScopeDeclarations.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, classBody_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "classBody"

    public static class classScopeDeclarations_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classScopeDeclarations"
    // LeMaVM.g:348:1: classScopeDeclarations : ( block -> ^( CLASS_INSTANCE_INITIALIZER block ) | STATIC block -> ^( CLASS_STATIC_INITIALIZER[$STATIC, \"CLASS_STATIC_INITIALIZER\"] block ) | modifierList ( ( type IDENT formalParameterList ( arrayDeclaratorList )? ( block | SEMI ) -> ^( FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList ( arrayDeclaratorList )? ( block )? ) | VOID IDENT formalParameterList ( block | SEMI ) -> ^( VOID_METHOD_DECL modifierList IDENT formalParameterList ( block )? ) | ident= IDENT formalParameterList block -> ^( CONSTRUCTOR_DECL[$ident, \"CONSTRUCTOR_DECL\"] modifierList formalParameterList block ) ) | type classFieldDeclaratorList SEMI -> ^( VAR_DECLARATION modifierList type classFieldDeclaratorList ) ) | typeDeclaration | SEMI );
    public final LeMaVMParser.classScopeDeclarations_return classScopeDeclarations() throws RecognitionException {
        LeMaVMParser.classScopeDeclarations_return retval = new LeMaVMParser.classScopeDeclarations_return();
        retval.start = input.LT(1);
        int classScopeDeclarations_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ident=null;
        Token STATIC34=null;
        Token IDENT38=null;
        Token SEMI42=null;
        Token VOID43=null;
        Token IDENT44=null;
        Token SEMI47=null;
        Token SEMI52=null;
        Token SEMI54=null;
        LeMaVMParser.block_return block33 = null;

        LeMaVMParser.block_return block35 = null;

        LeMaVMParser.modifierList_return modifierList36 = null;

        LeMaVMParser.type_return type37 = null;

        LeMaVMParser.formalParameterList_return formalParameterList39 = null;

        LeMaVMParser.arrayDeclaratorList_return arrayDeclaratorList40 = null;

        LeMaVMParser.block_return block41 = null;

        LeMaVMParser.formalParameterList_return formalParameterList45 = null;

        LeMaVMParser.block_return block46 = null;

        LeMaVMParser.formalParameterList_return formalParameterList48 = null;

        LeMaVMParser.block_return block49 = null;

        LeMaVMParser.type_return type50 = null;

        LeMaVMParser.classFieldDeclaratorList_return classFieldDeclaratorList51 = null;

        LeMaVMParser.typeDeclaration_return typeDeclaration53 = null;


        CommonTree ident_tree=null;
        CommonTree STATIC34_tree=null;
        CommonTree IDENT38_tree=null;
        CommonTree SEMI42_tree=null;
        CommonTree VOID43_tree=null;
        CommonTree IDENT44_tree=null;
        CommonTree SEMI47_tree=null;
        CommonTree SEMI52_tree=null;
        CommonTree SEMI54_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_VOID=new RewriteRuleTokenStream(adaptor,"token VOID");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_STATIC=new RewriteRuleTokenStream(adaptor,"token STATIC");
        RewriteRuleSubtreeStream stream_arrayDeclaratorList=new RewriteRuleSubtreeStream(adaptor,"rule arrayDeclaratorList");
        RewriteRuleSubtreeStream stream_modifierList=new RewriteRuleSubtreeStream(adaptor,"rule modifierList");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        RewriteRuleSubtreeStream stream_classFieldDeclaratorList=new RewriteRuleSubtreeStream(adaptor,"rule classFieldDeclaratorList");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // LeMaVM.g:349:5: ( block -> ^( CLASS_INSTANCE_INITIALIZER block ) | STATIC block -> ^( CLASS_STATIC_INITIALIZER[$STATIC, \"CLASS_STATIC_INITIALIZER\"] block ) | modifierList ( ( type IDENT formalParameterList ( arrayDeclaratorList )? ( block | SEMI ) -> ^( FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList ( arrayDeclaratorList )? ( block )? ) | VOID IDENT formalParameterList ( block | SEMI ) -> ^( VOID_METHOD_DECL modifierList IDENT formalParameterList ( block )? ) | ident= IDENT formalParameterList block -> ^( CONSTRUCTOR_DECL[$ident, \"CONSTRUCTOR_DECL\"] modifierList formalParameterList block ) ) | type classFieldDeclaratorList SEMI -> ^( VAR_DECLARATION modifierList type classFieldDeclaratorList ) ) | typeDeclaration | SEMI )
            int alt16=5;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // LeMaVM.g:349:9: block
                    {
                    pushFollow(FOLLOW_block_in_classScopeDeclarations4263);
                    block33=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block.add(block33.getTree());


                    // AST REWRITE
                    // elements: block
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 349:25: -> ^( CLASS_INSTANCE_INITIALIZER block )
                    {
                        // LeMaVM.g:349:29: ^( CLASS_INSTANCE_INITIALIZER block )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CLASS_INSTANCE_INITIALIZER, "CLASS_INSTANCE_INITIALIZER"), root_1);

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // LeMaVM.g:350:9: STATIC block
                    {
                    STATIC34=(Token)match(input,STATIC,FOLLOW_STATIC_in_classScopeDeclarations4292); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STATIC.add(STATIC34);

                    pushFollow(FOLLOW_block_in_classScopeDeclarations4294);
                    block35=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_block.add(block35.getTree());


                    // AST REWRITE
                    // elements: block
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 350:25: -> ^( CLASS_STATIC_INITIALIZER[$STATIC, \"CLASS_STATIC_INITIALIZER\"] block )
                    {
                        // LeMaVM.g:350:29: ^( CLASS_STATIC_INITIALIZER[$STATIC, \"CLASS_STATIC_INITIALIZER\"] block )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CLASS_STATIC_INITIALIZER, STATIC34, "CLASS_STATIC_INITIALIZER"), root_1);

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // LeMaVM.g:351:9: modifierList ( ( type IDENT formalParameterList ( arrayDeclaratorList )? ( block | SEMI ) -> ^( FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList ( arrayDeclaratorList )? ( block )? ) | VOID IDENT formalParameterList ( block | SEMI ) -> ^( VOID_METHOD_DECL modifierList IDENT formalParameterList ( block )? ) | ident= IDENT formalParameterList block -> ^( CONSTRUCTOR_DECL[$ident, \"CONSTRUCTOR_DECL\"] modifierList formalParameterList block ) ) | type classFieldDeclaratorList SEMI -> ^( VAR_DECLARATION modifierList type classFieldDeclaratorList ) )
                    {
                    pushFollow(FOLLOW_modifierList_in_classScopeDeclarations4317);
                    modifierList36=modifierList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_modifierList.add(modifierList36.getTree());
                    // LeMaVM.g:352:9: ( ( type IDENT formalParameterList ( arrayDeclaratorList )? ( block | SEMI ) -> ^( FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList ( arrayDeclaratorList )? ( block )? ) | VOID IDENT formalParameterList ( block | SEMI ) -> ^( VOID_METHOD_DECL modifierList IDENT formalParameterList ( block )? ) | ident= IDENT formalParameterList block -> ^( CONSTRUCTOR_DECL[$ident, \"CONSTRUCTOR_DECL\"] modifierList formalParameterList block ) ) | type classFieldDeclaratorList SEMI -> ^( VAR_DECLARATION modifierList type classFieldDeclaratorList ) )
                    int alt15=2;
                    alt15 = dfa15.predict(input);
                    switch (alt15) {
                        case 1 :
                            // LeMaVM.g:352:13: ( type IDENT formalParameterList ( arrayDeclaratorList )? ( block | SEMI ) -> ^( FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList ( arrayDeclaratorList )? ( block )? ) | VOID IDENT formalParameterList ( block | SEMI ) -> ^( VOID_METHOD_DECL modifierList IDENT formalParameterList ( block )? ) | ident= IDENT formalParameterList block -> ^( CONSTRUCTOR_DECL[$ident, \"CONSTRUCTOR_DECL\"] modifierList formalParameterList block ) )
                            {
                            // LeMaVM.g:352:13: ( type IDENT formalParameterList ( arrayDeclaratorList )? ( block | SEMI ) -> ^( FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList ( arrayDeclaratorList )? ( block )? ) | VOID IDENT formalParameterList ( block | SEMI ) -> ^( VOID_METHOD_DECL modifierList IDENT formalParameterList ( block )? ) | ident= IDENT formalParameterList block -> ^( CONSTRUCTOR_DECL[$ident, \"CONSTRUCTOR_DECL\"] modifierList formalParameterList block ) )
                            int alt14=3;
                            switch ( input.LA(1) ) {
                            case BOOLEAN:
                            case DOUBLE:
                            case INT:
                            case LONG:
                            case SHORT:
                            case STRING:
                                {
                                alt14=1;
                                }
                                break;
                            case IDENT:
                                {
                                int LA14_2 = input.LA(2);

                                if ( (LA14_2==DOT||LA14_2==LBRACK||LA14_2==IDENT) ) {
                                    alt14=1;
                                }
                                else if ( (LA14_2==LPAREN) ) {
                                    alt14=3;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 2, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case VOID:
                                {
                                alt14=2;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 0, input);

                                throw nvae;
                            }

                            switch (alt14) {
                                case 1 :
                                    // LeMaVM.g:352:17: type IDENT formalParameterList ( arrayDeclaratorList )? ( block | SEMI )
                                    {
                                    pushFollow(FOLLOW_type_in_classScopeDeclarations4335);
                                    type37=type();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_type.add(type37.getTree());
                                    IDENT38=(Token)match(input,IDENT,FOLLOW_IDENT_in_classScopeDeclarations4337); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT38);

                                    pushFollow(FOLLOW_formalParameterList_in_classScopeDeclarations4339);
                                    formalParameterList39=formalParameterList();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_formalParameterList.add(formalParameterList39.getTree());
                                    // LeMaVM.g:352:48: ( arrayDeclaratorList )?
                                    int alt11=2;
                                    int LA11_0 = input.LA(1);

                                    if ( (LA11_0==LBRACK) ) {
                                        alt11=1;
                                    }
                                    switch (alt11) {
                                        case 1 :
                                            // LeMaVM.g:0:0: arrayDeclaratorList
                                            {
                                            pushFollow(FOLLOW_arrayDeclaratorList_in_classScopeDeclarations4341);
                                            arrayDeclaratorList40=arrayDeclaratorList();

                                            state._fsp--;
                                            if (state.failed) return retval;
                                            if ( state.backtracking==0 ) stream_arrayDeclaratorList.add(arrayDeclaratorList40.getTree());

                                            }
                                            break;

                                    }

                                    // LeMaVM.g:352:69: ( block | SEMI )
                                    int alt12=2;
                                    int LA12_0 = input.LA(1);

                                    if ( (LA12_0==LCURLY) ) {
                                        alt12=1;
                                    }
                                    else if ( (LA12_0==SEMI) ) {
                                        alt12=2;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return retval;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 12, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt12) {
                                        case 1 :
                                            // LeMaVM.g:352:70: block
                                            {
                                            pushFollow(FOLLOW_block_in_classScopeDeclarations4345);
                                            block41=block();

                                            state._fsp--;
                                            if (state.failed) return retval;
                                            if ( state.backtracking==0 ) stream_block.add(block41.getTree());

                                            }
                                            break;
                                        case 2 :
                                            // LeMaVM.g:352:78: SEMI
                                            {
                                            SEMI42=(Token)match(input,SEMI,FOLLOW_SEMI_in_classScopeDeclarations4349); if (state.failed) return retval; 
                                            if ( state.backtracking==0 ) stream_SEMI.add(SEMI42);


                                            }
                                            break;

                                    }



                                    // AST REWRITE
                                    // elements: type, IDENT, formalParameterList, modifierList, arrayDeclaratorList, block
                                    // token labels: 
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    if ( state.backtracking==0 ) {
                                    retval.tree = root_0;
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (CommonTree)adaptor.nil();
                                    // 353:17: -> ^( FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList ( arrayDeclaratorList )? ( block )? )
                                    {
                                        // LeMaVM.g:353:21: ^( FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList ( arrayDeclaratorList )? ( block )? )
                                        {
                                        CommonTree root_1 = (CommonTree)adaptor.nil();
                                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION_METHOD_DECL, "FUNCTION_METHOD_DECL"), root_1);

                                        adaptor.addChild(root_1, stream_modifierList.nextTree());
                                        adaptor.addChild(root_1, stream_type.nextTree());
                                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                                        adaptor.addChild(root_1, stream_formalParameterList.nextTree());
                                        // LeMaVM.g:353:88: ( arrayDeclaratorList )?
                                        if ( stream_arrayDeclaratorList.hasNext() ) {
                                            adaptor.addChild(root_1, stream_arrayDeclaratorList.nextTree());

                                        }
                                        stream_arrayDeclaratorList.reset();
                                        // LeMaVM.g:353:109: ( block )?
                                        if ( stream_block.hasNext() ) {
                                            adaptor.addChild(root_1, stream_block.nextTree());

                                        }
                                        stream_block.reset();

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }

                                    retval.tree = root_0;}
                                    }
                                    break;
                                case 2 :
                                    // LeMaVM.g:354:17: VOID IDENT formalParameterList ( block | SEMI )
                                    {
                                    VOID43=(Token)match(input,VOID,FOLLOW_VOID_in_classScopeDeclarations4405); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_VOID.add(VOID43);

                                    IDENT44=(Token)match(input,IDENT,FOLLOW_IDENT_in_classScopeDeclarations4407); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT44);

                                    pushFollow(FOLLOW_formalParameterList_in_classScopeDeclarations4409);
                                    formalParameterList45=formalParameterList();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_formalParameterList.add(formalParameterList45.getTree());
                                    // LeMaVM.g:354:48: ( block | SEMI )
                                    int alt13=2;
                                    int LA13_0 = input.LA(1);

                                    if ( (LA13_0==LCURLY) ) {
                                        alt13=1;
                                    }
                                    else if ( (LA13_0==SEMI) ) {
                                        alt13=2;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return retval;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 13, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt13) {
                                        case 1 :
                                            // LeMaVM.g:354:49: block
                                            {
                                            pushFollow(FOLLOW_block_in_classScopeDeclarations4412);
                                            block46=block();

                                            state._fsp--;
                                            if (state.failed) return retval;
                                            if ( state.backtracking==0 ) stream_block.add(block46.getTree());

                                            }
                                            break;
                                        case 2 :
                                            // LeMaVM.g:354:57: SEMI
                                            {
                                            SEMI47=(Token)match(input,SEMI,FOLLOW_SEMI_in_classScopeDeclarations4416); if (state.failed) return retval; 
                                            if ( state.backtracking==0 ) stream_SEMI.add(SEMI47);


                                            }
                                            break;

                                    }



                                    // AST REWRITE
                                    // elements: IDENT, block, modifierList, formalParameterList
                                    // token labels: 
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    if ( state.backtracking==0 ) {
                                    retval.tree = root_0;
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (CommonTree)adaptor.nil();
                                    // 355:17: -> ^( VOID_METHOD_DECL modifierList IDENT formalParameterList ( block )? )
                                    {
                                        // LeMaVM.g:355:21: ^( VOID_METHOD_DECL modifierList IDENT formalParameterList ( block )? )
                                        {
                                        CommonTree root_1 = (CommonTree)adaptor.nil();
                                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VOID_METHOD_DECL, "VOID_METHOD_DECL"), root_1);

                                        adaptor.addChild(root_1, stream_modifierList.nextTree());
                                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                                        adaptor.addChild(root_1, stream_formalParameterList.nextTree());
                                        // LeMaVM.g:355:79: ( block )?
                                        if ( stream_block.hasNext() ) {
                                            adaptor.addChild(root_1, stream_block.nextTree());

                                        }
                                        stream_block.reset();

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }

                                    retval.tree = root_0;}
                                    }
                                    break;
                                case 3 :
                                    // LeMaVM.g:356:17: ident= IDENT formalParameterList block
                                    {
                                    ident=(Token)match(input,IDENT,FOLLOW_IDENT_in_classScopeDeclarations4469); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_IDENT.add(ident);

                                    pushFollow(FOLLOW_formalParameterList_in_classScopeDeclarations4471);
                                    formalParameterList48=formalParameterList();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_formalParameterList.add(formalParameterList48.getTree());
                                    pushFollow(FOLLOW_block_in_classScopeDeclarations4473);
                                    block49=block();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_block.add(block49.getTree());


                                    // AST REWRITE
                                    // elements: block, formalParameterList, modifierList
                                    // token labels: 
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    if ( state.backtracking==0 ) {
                                    retval.tree = root_0;
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (CommonTree)adaptor.nil();
                                    // 357:17: -> ^( CONSTRUCTOR_DECL[$ident, \"CONSTRUCTOR_DECL\"] modifierList formalParameterList block )
                                    {
                                        // LeMaVM.g:357:21: ^( CONSTRUCTOR_DECL[$ident, \"CONSTRUCTOR_DECL\"] modifierList formalParameterList block )
                                        {
                                        CommonTree root_1 = (CommonTree)adaptor.nil();
                                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONSTRUCTOR_DECL, ident, "CONSTRUCTOR_DECL"), root_1);

                                        adaptor.addChild(root_1, stream_modifierList.nextTree());
                                        adaptor.addChild(root_1, stream_formalParameterList.nextTree());
                                        adaptor.addChild(root_1, stream_block.nextTree());

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }

                                    retval.tree = root_0;}
                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // LeMaVM.g:359:13: type classFieldDeclaratorList SEMI
                            {
                            pushFollow(FOLLOW_type_in_classScopeDeclarations4531);
                            type50=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_type.add(type50.getTree());
                            pushFollow(FOLLOW_classFieldDeclaratorList_in_classScopeDeclarations4533);
                            classFieldDeclaratorList51=classFieldDeclaratorList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_classFieldDeclaratorList.add(classFieldDeclaratorList51.getTree());
                            SEMI52=(Token)match(input,SEMI,FOLLOW_SEMI_in_classScopeDeclarations4535); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SEMI.add(SEMI52);



                            // AST REWRITE
                            // elements: type, classFieldDeclaratorList, modifierList
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 360:13: -> ^( VAR_DECLARATION modifierList type classFieldDeclaratorList )
                            {
                                // LeMaVM.g:360:17: ^( VAR_DECLARATION modifierList type classFieldDeclaratorList )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_DECLARATION, "VAR_DECLARATION"), root_1);

                                adaptor.addChild(root_1, stream_modifierList.nextTree());
                                adaptor.addChild(root_1, stream_type.nextTree());
                                adaptor.addChild(root_1, stream_classFieldDeclaratorList.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // LeMaVM.g:362:9: typeDeclaration
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_typeDeclaration_in_classScopeDeclarations4580);
                    typeDeclaration53=typeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDeclaration53.getTree());

                    }
                    break;
                case 5 :
                    // LeMaVM.g:363:9: SEMI
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SEMI54=(Token)match(input,SEMI,FOLLOW_SEMI_in_classScopeDeclarations4590); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, classScopeDeclarations_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "classScopeDeclarations"

    public static class classFieldDeclaratorList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classFieldDeclaratorList"
    // LeMaVM.g:366:1: classFieldDeclaratorList : classFieldDeclarator ( COMMA classFieldDeclarator )* -> ^( VAR_DECLARATOR_LIST ( classFieldDeclarator )+ ) ;
    public final LeMaVMParser.classFieldDeclaratorList_return classFieldDeclaratorList() throws RecognitionException {
        LeMaVMParser.classFieldDeclaratorList_return retval = new LeMaVMParser.classFieldDeclaratorList_return();
        retval.start = input.LT(1);
        int classFieldDeclaratorList_StartIndex = input.index();
        CommonTree root_0 = null;

        Token COMMA56=null;
        LeMaVMParser.classFieldDeclarator_return classFieldDeclarator55 = null;

        LeMaVMParser.classFieldDeclarator_return classFieldDeclarator57 = null;


        CommonTree COMMA56_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_classFieldDeclarator=new RewriteRuleSubtreeStream(adaptor,"rule classFieldDeclarator");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // LeMaVM.g:367:5: ( classFieldDeclarator ( COMMA classFieldDeclarator )* -> ^( VAR_DECLARATOR_LIST ( classFieldDeclarator )+ ) )
            // LeMaVM.g:367:9: classFieldDeclarator ( COMMA classFieldDeclarator )*
            {
            pushFollow(FOLLOW_classFieldDeclarator_in_classFieldDeclaratorList4610);
            classFieldDeclarator55=classFieldDeclarator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_classFieldDeclarator.add(classFieldDeclarator55.getTree());
            // LeMaVM.g:367:30: ( COMMA classFieldDeclarator )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==COMMA) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // LeMaVM.g:367:31: COMMA classFieldDeclarator
            	    {
            	    COMMA56=(Token)match(input,COMMA,FOLLOW_COMMA_in_classFieldDeclaratorList4613); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA56);

            	    pushFollow(FOLLOW_classFieldDeclarator_in_classFieldDeclaratorList4615);
            	    classFieldDeclarator57=classFieldDeclarator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_classFieldDeclarator.add(classFieldDeclarator57.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);



            // AST REWRITE
            // elements: classFieldDeclarator
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 368:9: -> ^( VAR_DECLARATOR_LIST ( classFieldDeclarator )+ )
            {
                // LeMaVM.g:368:13: ^( VAR_DECLARATOR_LIST ( classFieldDeclarator )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_DECLARATOR_LIST, "VAR_DECLARATOR_LIST"), root_1);

                if ( !(stream_classFieldDeclarator.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_classFieldDeclarator.hasNext() ) {
                    adaptor.addChild(root_1, stream_classFieldDeclarator.nextTree());

                }
                stream_classFieldDeclarator.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, classFieldDeclaratorList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "classFieldDeclaratorList"

    public static class classFieldDeclarator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classFieldDeclarator"
    // LeMaVM.g:371:1: classFieldDeclarator : variableDeclaratorId ( ASSIGN variableInitializer )? -> ^( VAR_DECLARATOR variableDeclaratorId ( variableInitializer )? ) ;
    public final LeMaVMParser.classFieldDeclarator_return classFieldDeclarator() throws RecognitionException {
        LeMaVMParser.classFieldDeclarator_return retval = new LeMaVMParser.classFieldDeclarator_return();
        retval.start = input.LT(1);
        int classFieldDeclarator_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ASSIGN59=null;
        LeMaVMParser.variableDeclaratorId_return variableDeclaratorId58 = null;

        LeMaVMParser.variableInitializer_return variableInitializer60 = null;


        CommonTree ASSIGN59_tree=null;
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_variableDeclaratorId=new RewriteRuleSubtreeStream(adaptor,"rule variableDeclaratorId");
        RewriteRuleSubtreeStream stream_variableInitializer=new RewriteRuleSubtreeStream(adaptor,"rule variableInitializer");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // LeMaVM.g:372:5: ( variableDeclaratorId ( ASSIGN variableInitializer )? -> ^( VAR_DECLARATOR variableDeclaratorId ( variableInitializer )? ) )
            // LeMaVM.g:372:9: variableDeclaratorId ( ASSIGN variableInitializer )?
            {
            pushFollow(FOLLOW_variableDeclaratorId_in_classFieldDeclarator4654);
            variableDeclaratorId58=variableDeclaratorId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variableDeclaratorId.add(variableDeclaratorId58.getTree());
            // LeMaVM.g:372:30: ( ASSIGN variableInitializer )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ASSIGN) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // LeMaVM.g:372:31: ASSIGN variableInitializer
                    {
                    ASSIGN59=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_classFieldDeclarator4657); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN59);

                    pushFollow(FOLLOW_variableInitializer_in_classFieldDeclarator4659);
                    variableInitializer60=variableInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_variableInitializer.add(variableInitializer60.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: variableDeclaratorId, variableInitializer
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 373:9: -> ^( VAR_DECLARATOR variableDeclaratorId ( variableInitializer )? )
            {
                // LeMaVM.g:373:13: ^( VAR_DECLARATOR variableDeclaratorId ( variableInitializer )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_DECLARATOR, "VAR_DECLARATOR"), root_1);

                adaptor.addChild(root_1, stream_variableDeclaratorId.nextTree());
                // LeMaVM.g:373:51: ( variableInitializer )?
                if ( stream_variableInitializer.hasNext() ) {
                    adaptor.addChild(root_1, stream_variableInitializer.nextTree());

                }
                stream_variableInitializer.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, classFieldDeclarator_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "classFieldDeclarator"

    public static class variableDeclaratorId_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableDeclaratorId"
    // LeMaVM.g:376:1: variableDeclaratorId : IDENT ( arrayDeclaratorList )? ;
    public final LeMaVMParser.variableDeclaratorId_return variableDeclaratorId() throws RecognitionException {
        LeMaVMParser.variableDeclaratorId_return retval = new LeMaVMParser.variableDeclaratorId_return();
        retval.start = input.LT(1);
        int variableDeclaratorId_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IDENT61=null;
        LeMaVMParser.arrayDeclaratorList_return arrayDeclaratorList62 = null;


        CommonTree IDENT61_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // LeMaVM.g:377:5: ( IDENT ( arrayDeclaratorList )? )
            // LeMaVM.g:377:9: IDENT ( arrayDeclaratorList )?
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT61=(Token)match(input,IDENT,FOLLOW_IDENT_in_variableDeclaratorId4704); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENT61_tree = (CommonTree)adaptor.create(IDENT61);
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT61_tree, root_0);
            }
            // LeMaVM.g:377:16: ( arrayDeclaratorList )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LBRACK) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // LeMaVM.g:0:0: arrayDeclaratorList
                    {
                    pushFollow(FOLLOW_arrayDeclaratorList_in_variableDeclaratorId4707);
                    arrayDeclaratorList62=arrayDeclaratorList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayDeclaratorList62.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, variableDeclaratorId_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "variableDeclaratorId"

    public static class variableInitializer_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableInitializer"
    // LeMaVM.g:380:1: variableInitializer : ( arrayInitializer | expression );
    public final LeMaVMParser.variableInitializer_return variableInitializer() throws RecognitionException {
        LeMaVMParser.variableInitializer_return retval = new LeMaVMParser.variableInitializer_return();
        retval.start = input.LT(1);
        int variableInitializer_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.arrayInitializer_return arrayInitializer63 = null;

        LeMaVMParser.expression_return expression64 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // LeMaVM.g:381:5: ( arrayInitializer | expression )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LCURLY) ) {
                alt20=1;
            }
            else if ( (LA20_0==DEC||LA20_0==INC||LA20_0==LOGICAL_NOT||(LA20_0>=LPAREN && LA20_0<=MINUS)||LA20_0==NOT||LA20_0==PLUS||LA20_0==BOOLEAN||LA20_0==DOUBLE||LA20_0==FALSE||(LA20_0>=INT && LA20_0<=NULL)||LA20_0==SHORT||(LA20_0>=STRING && LA20_0<=SUPER)||(LA20_0>=THIS && LA20_0<=TRUE)||LA20_0==VOID||(LA20_0>=IDENT && LA20_0<=STRING_LITERAL)) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // LeMaVM.g:381:9: arrayInitializer
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayInitializer_in_variableInitializer4727);
                    arrayInitializer63=arrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayInitializer63.getTree());

                    }
                    break;
                case 2 :
                    // LeMaVM.g:382:9: expression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_variableInitializer4737);
                    expression64=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression64.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, variableInitializer_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "variableInitializer"

    public static class arrayDeclarator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayDeclarator"
    // LeMaVM.g:385:1: arrayDeclarator : LBRACK RBRACK -> ^( ARRAY_DECLARATOR ) ;
    public final LeMaVMParser.arrayDeclarator_return arrayDeclarator() throws RecognitionException {
        LeMaVMParser.arrayDeclarator_return retval = new LeMaVMParser.arrayDeclarator_return();
        retval.start = input.LT(1);
        int arrayDeclarator_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LBRACK65=null;
        Token RBRACK66=null;

        CommonTree LBRACK65_tree=null;
        CommonTree RBRACK66_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // LeMaVM.g:386:5: ( LBRACK RBRACK -> ^( ARRAY_DECLARATOR ) )
            // LeMaVM.g:386:9: LBRACK RBRACK
            {
            LBRACK65=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayDeclarator4756); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK65);

            RBRACK66=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayDeclarator4758); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK66);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 387:9: -> ^( ARRAY_DECLARATOR )
            {
                // LeMaVM.g:387:13: ^( ARRAY_DECLARATOR )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_DECLARATOR, "ARRAY_DECLARATOR"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, arrayDeclarator_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "arrayDeclarator"

    public static class arrayDeclaratorList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayDeclaratorList"
    // LeMaVM.g:390:1: arrayDeclaratorList : ( arrayDeclarator )+ -> ^( ARRAY_DECLARATOR_LIST ( arrayDeclarator )+ ) ;
    public final LeMaVMParser.arrayDeclaratorList_return arrayDeclaratorList() throws RecognitionException {
        LeMaVMParser.arrayDeclaratorList_return retval = new LeMaVMParser.arrayDeclaratorList_return();
        retval.start = input.LT(1);
        int arrayDeclaratorList_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.arrayDeclarator_return arrayDeclarator67 = null;


        RewriteRuleSubtreeStream stream_arrayDeclarator=new RewriteRuleSubtreeStream(adaptor,"rule arrayDeclarator");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // LeMaVM.g:391:5: ( ( arrayDeclarator )+ -> ^( ARRAY_DECLARATOR_LIST ( arrayDeclarator )+ ) )
            // LeMaVM.g:391:9: ( arrayDeclarator )+
            {
            // LeMaVM.g:391:9: ( arrayDeclarator )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==LBRACK) ) {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2==RBRACK) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // LeMaVM.g:0:0: arrayDeclarator
            	    {
            	    pushFollow(FOLLOW_arrayDeclarator_in_arrayDeclaratorList4792);
            	    arrayDeclarator67=arrayDeclarator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_arrayDeclarator.add(arrayDeclarator67.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);



            // AST REWRITE
            // elements: arrayDeclarator
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 392:9: -> ^( ARRAY_DECLARATOR_LIST ( arrayDeclarator )+ )
            {
                // LeMaVM.g:392:13: ^( ARRAY_DECLARATOR_LIST ( arrayDeclarator )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_DECLARATOR_LIST, "ARRAY_DECLARATOR_LIST"), root_1);

                if ( !(stream_arrayDeclarator.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_arrayDeclarator.hasNext() ) {
                    adaptor.addChild(root_1, stream_arrayDeclarator.nextTree());

                }
                stream_arrayDeclarator.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, arrayDeclaratorList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "arrayDeclaratorList"

    public static class arrayInitializer_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayInitializer"
    // LeMaVM.g:395:1: arrayInitializer : LCURLY ( variableInitializer ( COMMA variableInitializer )* ( COMMA )? )? RCURLY -> ^( ARRAY_INITIALIZER[$LCURLY, \"ARRAY_INITIALIZER\"] ( variableInitializer )* ) ;
    public final LeMaVMParser.arrayInitializer_return arrayInitializer() throws RecognitionException {
        LeMaVMParser.arrayInitializer_return retval = new LeMaVMParser.arrayInitializer_return();
        retval.start = input.LT(1);
        int arrayInitializer_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LCURLY68=null;
        Token COMMA70=null;
        Token COMMA72=null;
        Token RCURLY73=null;
        LeMaVMParser.variableInitializer_return variableInitializer69 = null;

        LeMaVMParser.variableInitializer_return variableInitializer71 = null;


        CommonTree LCURLY68_tree=null;
        CommonTree COMMA70_tree=null;
        CommonTree COMMA72_tree=null;
        CommonTree RCURLY73_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_variableInitializer=new RewriteRuleSubtreeStream(adaptor,"rule variableInitializer");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // LeMaVM.g:396:5: ( LCURLY ( variableInitializer ( COMMA variableInitializer )* ( COMMA )? )? RCURLY -> ^( ARRAY_INITIALIZER[$LCURLY, \"ARRAY_INITIALIZER\"] ( variableInitializer )* ) )
            // LeMaVM.g:396:9: LCURLY ( variableInitializer ( COMMA variableInitializer )* ( COMMA )? )? RCURLY
            {
            LCURLY68=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_arrayInitializer4837); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY68);

            // LeMaVM.g:396:16: ( variableInitializer ( COMMA variableInitializer )* ( COMMA )? )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==DEC||LA24_0==INC||LA24_0==LCURLY||LA24_0==LOGICAL_NOT||(LA24_0>=LPAREN && LA24_0<=MINUS)||LA24_0==NOT||LA24_0==PLUS||LA24_0==BOOLEAN||LA24_0==DOUBLE||LA24_0==FALSE||(LA24_0>=INT && LA24_0<=NULL)||LA24_0==SHORT||(LA24_0>=STRING && LA24_0<=SUPER)||(LA24_0>=THIS && LA24_0<=TRUE)||LA24_0==VOID||(LA24_0>=IDENT && LA24_0<=STRING_LITERAL)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // LeMaVM.g:396:17: variableInitializer ( COMMA variableInitializer )* ( COMMA )?
                    {
                    pushFollow(FOLLOW_variableInitializer_in_arrayInitializer4840);
                    variableInitializer69=variableInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_variableInitializer.add(variableInitializer69.getTree());
                    // LeMaVM.g:396:37: ( COMMA variableInitializer )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==COMMA) ) {
                            int LA22_1 = input.LA(2);

                            if ( (LA22_1==DEC||LA22_1==INC||LA22_1==LCURLY||LA22_1==LOGICAL_NOT||(LA22_1>=LPAREN && LA22_1<=MINUS)||LA22_1==NOT||LA22_1==PLUS||LA22_1==BOOLEAN||LA22_1==DOUBLE||LA22_1==FALSE||(LA22_1>=INT && LA22_1<=NULL)||LA22_1==SHORT||(LA22_1>=STRING && LA22_1<=SUPER)||(LA22_1>=THIS && LA22_1<=TRUE)||LA22_1==VOID||(LA22_1>=IDENT && LA22_1<=STRING_LITERAL)) ) {
                                alt22=1;
                            }


                        }


                        switch (alt22) {
                    	case 1 :
                    	    // LeMaVM.g:396:38: COMMA variableInitializer
                    	    {
                    	    COMMA70=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayInitializer4843); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA70);

                    	    pushFollow(FOLLOW_variableInitializer_in_arrayInitializer4845);
                    	    variableInitializer71=variableInitializer();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_variableInitializer.add(variableInitializer71.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    // LeMaVM.g:396:66: ( COMMA )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==COMMA) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // LeMaVM.g:0:0: COMMA
                            {
                            COMMA72=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayInitializer4849); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA72);


                            }
                            break;

                    }


                    }
                    break;

            }

            RCURLY73=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_arrayInitializer4854); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY73);



            // AST REWRITE
            // elements: variableInitializer
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 397:9: -> ^( ARRAY_INITIALIZER[$LCURLY, \"ARRAY_INITIALIZER\"] ( variableInitializer )* )
            {
                // LeMaVM.g:397:13: ^( ARRAY_INITIALIZER[$LCURLY, \"ARRAY_INITIALIZER\"] ( variableInitializer )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_INITIALIZER, LCURLY68, "ARRAY_INITIALIZER"), root_1);

                // LeMaVM.g:397:63: ( variableInitializer )*
                while ( stream_variableInitializer.hasNext() ) {
                    adaptor.addChild(root_1, stream_variableInitializer.nextTree());

                }
                stream_variableInitializer.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, arrayInitializer_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "arrayInitializer"

    public static class modifierList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modifierList"
    // LeMaVM.g:400:1: modifierList : ( modifier )* -> ^( MODIFIER_LIST ( modifier )* ) ;
    public final LeMaVMParser.modifierList_return modifierList() throws RecognitionException {
        LeMaVMParser.modifierList_return retval = new LeMaVMParser.modifierList_return();
        retval.start = input.LT(1);
        int modifierList_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.modifier_return modifier74 = null;


        RewriteRuleSubtreeStream stream_modifier=new RewriteRuleSubtreeStream(adaptor,"rule modifier");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // LeMaVM.g:401:5: ( ( modifier )* -> ^( MODIFIER_LIST ( modifier )* ) )
            // LeMaVM.g:401:9: ( modifier )*
            {
            // LeMaVM.g:401:9: ( modifier )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==FINAL||(LA25_0>=PRIVATE && LA25_0<=PUBLIC)||LA25_0==STATIC) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // LeMaVM.g:0:0: modifier
            	    {
            	    pushFollow(FOLLOW_modifier_in_modifierList4892);
            	    modifier74=modifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_modifier.add(modifier74.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);



            // AST REWRITE
            // elements: modifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 402:9: -> ^( MODIFIER_LIST ( modifier )* )
            {
                // LeMaVM.g:402:13: ^( MODIFIER_LIST ( modifier )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MODIFIER_LIST, "MODIFIER_LIST"), root_1);

                // LeMaVM.g:402:29: ( modifier )*
                while ( stream_modifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_modifier.nextTree());

                }
                stream_modifier.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, modifierList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "modifierList"

    public static class modifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "modifier"
    // LeMaVM.g:405:1: modifier : ( PUBLIC | PROTECTED | PRIVATE | STATIC | localModifier );
    public final LeMaVMParser.modifier_return modifier() throws RecognitionException {
        LeMaVMParser.modifier_return retval = new LeMaVMParser.modifier_return();
        retval.start = input.LT(1);
        int modifier_StartIndex = input.index();
        CommonTree root_0 = null;

        Token PUBLIC75=null;
        Token PROTECTED76=null;
        Token PRIVATE77=null;
        Token STATIC78=null;
        LeMaVMParser.localModifier_return localModifier79 = null;


        CommonTree PUBLIC75_tree=null;
        CommonTree PROTECTED76_tree=null;
        CommonTree PRIVATE77_tree=null;
        CommonTree STATIC78_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // LeMaVM.g:406:5: ( PUBLIC | PROTECTED | PRIVATE | STATIC | localModifier )
            int alt26=5;
            switch ( input.LA(1) ) {
            case PUBLIC:
                {
                alt26=1;
                }
                break;
            case PROTECTED:
                {
                alt26=2;
                }
                break;
            case PRIVATE:
                {
                alt26=3;
                }
                break;
            case STATIC:
                {
                alt26=4;
                }
                break;
            case FINAL:
                {
                alt26=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // LeMaVM.g:406:9: PUBLIC
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PUBLIC75=(Token)match(input,PUBLIC,FOLLOW_PUBLIC_in_modifier4933); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PUBLIC75_tree = (CommonTree)adaptor.create(PUBLIC75);
                    adaptor.addChild(root_0, PUBLIC75_tree);
                    }

                    }
                    break;
                case 2 :
                    // LeMaVM.g:407:9: PROTECTED
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PROTECTED76=(Token)match(input,PROTECTED,FOLLOW_PROTECTED_in_modifier4943); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PROTECTED76_tree = (CommonTree)adaptor.create(PROTECTED76);
                    adaptor.addChild(root_0, PROTECTED76_tree);
                    }

                    }
                    break;
                case 3 :
                    // LeMaVM.g:408:9: PRIVATE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PRIVATE77=(Token)match(input,PRIVATE,FOLLOW_PRIVATE_in_modifier4953); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PRIVATE77_tree = (CommonTree)adaptor.create(PRIVATE77);
                    adaptor.addChild(root_0, PRIVATE77_tree);
                    }

                    }
                    break;
                case 4 :
                    // LeMaVM.g:409:9: STATIC
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    STATIC78=(Token)match(input,STATIC,FOLLOW_STATIC_in_modifier4963); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STATIC78_tree = (CommonTree)adaptor.create(STATIC78);
                    adaptor.addChild(root_0, STATIC78_tree);
                    }

                    }
                    break;
                case 5 :
                    // LeMaVM.g:410:9: localModifier
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_localModifier_in_modifier4973);
                    localModifier79=localModifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, localModifier79.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, modifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "modifier"

    public static class localModifierList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "localModifierList"
    // LeMaVM.g:413:1: localModifierList : ( localModifier )* -> ^( LOCAL_MODIFIER_LIST ( localModifier )* ) ;
    public final LeMaVMParser.localModifierList_return localModifierList() throws RecognitionException {
        LeMaVMParser.localModifierList_return retval = new LeMaVMParser.localModifierList_return();
        retval.start = input.LT(1);
        int localModifierList_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.localModifier_return localModifier80 = null;


        RewriteRuleSubtreeStream stream_localModifier=new RewriteRuleSubtreeStream(adaptor,"rule localModifier");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // LeMaVM.g:414:5: ( ( localModifier )* -> ^( LOCAL_MODIFIER_LIST ( localModifier )* ) )
            // LeMaVM.g:414:9: ( localModifier )*
            {
            // LeMaVM.g:414:9: ( localModifier )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==FINAL) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // LeMaVM.g:0:0: localModifier
            	    {
            	    pushFollow(FOLLOW_localModifier_in_localModifierList4992);
            	    localModifier80=localModifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_localModifier.add(localModifier80.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);



            // AST REWRITE
            // elements: localModifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 415:9: -> ^( LOCAL_MODIFIER_LIST ( localModifier )* )
            {
                // LeMaVM.g:415:12: ^( LOCAL_MODIFIER_LIST ( localModifier )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LOCAL_MODIFIER_LIST, "LOCAL_MODIFIER_LIST"), root_1);

                // LeMaVM.g:415:34: ( localModifier )*
                while ( stream_localModifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_localModifier.nextTree());

                }
                stream_localModifier.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, localModifierList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "localModifierList"

    public static class localModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "localModifier"
    // LeMaVM.g:418:1: localModifier : FINAL ;
    public final LeMaVMParser.localModifier_return localModifier() throws RecognitionException {
        LeMaVMParser.localModifier_return retval = new LeMaVMParser.localModifier_return();
        retval.start = input.LT(1);
        int localModifier_StartIndex = input.index();
        CommonTree root_0 = null;

        Token FINAL81=null;

        CommonTree FINAL81_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // LeMaVM.g:419:5: ( FINAL )
            // LeMaVM.g:419:9: FINAL
            {
            root_0 = (CommonTree)adaptor.nil();

            FINAL81=(Token)match(input,FINAL,FOLLOW_FINAL_in_localModifier5033); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FINAL81_tree = (CommonTree)adaptor.create(FINAL81);
            adaptor.addChild(root_0, FINAL81_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, localModifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "localModifier"

    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // LeMaVM.g:422:1: type : ( simpleType | objectType );
    public final LeMaVMParser.type_return type() throws RecognitionException {
        LeMaVMParser.type_return retval = new LeMaVMParser.type_return();
        retval.start = input.LT(1);
        int type_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.simpleType_return simpleType82 = null;

        LeMaVMParser.objectType_return objectType83 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // LeMaVM.g:423:5: ( simpleType | objectType )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==BOOLEAN||LA28_0==DOUBLE||(LA28_0>=INT && LA28_0<=LONG)||LA28_0==SHORT||LA28_0==STRING) ) {
                alt28=1;
            }
            else if ( (LA28_0==IDENT) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // LeMaVM.g:423:9: simpleType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_simpleType_in_type5052);
                    simpleType82=simpleType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleType82.getTree());

                    }
                    break;
                case 2 :
                    // LeMaVM.g:424:9: objectType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_objectType_in_type5062);
                    objectType83=objectType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, objectType83.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, type_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class simpleType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simpleType"
    // LeMaVM.g:427:1: simpleType : primitiveType ( arrayDeclaratorList )? -> ^( TYPE primitiveType ( arrayDeclaratorList )? ) ;
    public final LeMaVMParser.simpleType_return simpleType() throws RecognitionException {
        LeMaVMParser.simpleType_return retval = new LeMaVMParser.simpleType_return();
        retval.start = input.LT(1);
        int simpleType_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.primitiveType_return primitiveType84 = null;

        LeMaVMParser.arrayDeclaratorList_return arrayDeclaratorList85 = null;


        RewriteRuleSubtreeStream stream_arrayDeclaratorList=new RewriteRuleSubtreeStream(adaptor,"rule arrayDeclaratorList");
        RewriteRuleSubtreeStream stream_primitiveType=new RewriteRuleSubtreeStream(adaptor,"rule primitiveType");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // LeMaVM.g:428:5: ( primitiveType ( arrayDeclaratorList )? -> ^( TYPE primitiveType ( arrayDeclaratorList )? ) )
            // LeMaVM.g:428:9: primitiveType ( arrayDeclaratorList )?
            {
            pushFollow(FOLLOW_primitiveType_in_simpleType5082);
            primitiveType84=primitiveType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_primitiveType.add(primitiveType84.getTree());
            // LeMaVM.g:428:23: ( arrayDeclaratorList )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==LBRACK) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // LeMaVM.g:0:0: arrayDeclaratorList
                    {
                    pushFollow(FOLLOW_arrayDeclaratorList_in_simpleType5084);
                    arrayDeclaratorList85=arrayDeclaratorList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_arrayDeclaratorList.add(arrayDeclaratorList85.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: primitiveType, arrayDeclaratorList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 429:9: -> ^( TYPE primitiveType ( arrayDeclaratorList )? )
            {
                // LeMaVM.g:429:13: ^( TYPE primitiveType ( arrayDeclaratorList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

                adaptor.addChild(root_1, stream_primitiveType.nextTree());
                // LeMaVM.g:429:34: ( arrayDeclaratorList )?
                if ( stream_arrayDeclaratorList.hasNext() ) {
                    adaptor.addChild(root_1, stream_arrayDeclaratorList.nextTree());

                }
                stream_arrayDeclaratorList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, simpleType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "simpleType"

    public static class objectType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objectType"
    // LeMaVM.g:432:1: objectType : qualifiedTypeIdent ( arrayDeclaratorList )? -> ^( TYPE qualifiedTypeIdent ( arrayDeclaratorList )? ) ;
    public final LeMaVMParser.objectType_return objectType() throws RecognitionException {
        LeMaVMParser.objectType_return retval = new LeMaVMParser.objectType_return();
        retval.start = input.LT(1);
        int objectType_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.qualifiedTypeIdent_return qualifiedTypeIdent86 = null;

        LeMaVMParser.arrayDeclaratorList_return arrayDeclaratorList87 = null;


        RewriteRuleSubtreeStream stream_arrayDeclaratorList=new RewriteRuleSubtreeStream(adaptor,"rule arrayDeclaratorList");
        RewriteRuleSubtreeStream stream_qualifiedTypeIdent=new RewriteRuleSubtreeStream(adaptor,"rule qualifiedTypeIdent");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // LeMaVM.g:433:5: ( qualifiedTypeIdent ( arrayDeclaratorList )? -> ^( TYPE qualifiedTypeIdent ( arrayDeclaratorList )? ) )
            // LeMaVM.g:433:9: qualifiedTypeIdent ( arrayDeclaratorList )?
            {
            pushFollow(FOLLOW_qualifiedTypeIdent_in_objectType5131);
            qualifiedTypeIdent86=qualifiedTypeIdent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_qualifiedTypeIdent.add(qualifiedTypeIdent86.getTree());
            // LeMaVM.g:433:28: ( arrayDeclaratorList )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==LBRACK) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // LeMaVM.g:0:0: arrayDeclaratorList
                    {
                    pushFollow(FOLLOW_arrayDeclaratorList_in_objectType5133);
                    arrayDeclaratorList87=arrayDeclaratorList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_arrayDeclaratorList.add(arrayDeclaratorList87.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: arrayDeclaratorList, qualifiedTypeIdent
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 434:9: -> ^( TYPE qualifiedTypeIdent ( arrayDeclaratorList )? )
            {
                // LeMaVM.g:434:13: ^( TYPE qualifiedTypeIdent ( arrayDeclaratorList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

                adaptor.addChild(root_1, stream_qualifiedTypeIdent.nextTree());
                // LeMaVM.g:434:39: ( arrayDeclaratorList )?
                if ( stream_arrayDeclaratorList.hasNext() ) {
                    adaptor.addChild(root_1, stream_arrayDeclaratorList.nextTree());

                }
                stream_arrayDeclaratorList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, objectType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "objectType"

    public static class objectTypeSimplified_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objectTypeSimplified"
    // LeMaVM.g:437:1: objectTypeSimplified : qualifiedTypeIdentSimplified ( arrayDeclaratorList )? -> ^( TYPE qualifiedTypeIdentSimplified ( arrayDeclaratorList )? ) ;
    public final LeMaVMParser.objectTypeSimplified_return objectTypeSimplified() throws RecognitionException {
        LeMaVMParser.objectTypeSimplified_return retval = new LeMaVMParser.objectTypeSimplified_return();
        retval.start = input.LT(1);
        int objectTypeSimplified_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.qualifiedTypeIdentSimplified_return qualifiedTypeIdentSimplified88 = null;

        LeMaVMParser.arrayDeclaratorList_return arrayDeclaratorList89 = null;


        RewriteRuleSubtreeStream stream_arrayDeclaratorList=new RewriteRuleSubtreeStream(adaptor,"rule arrayDeclaratorList");
        RewriteRuleSubtreeStream stream_qualifiedTypeIdentSimplified=new RewriteRuleSubtreeStream(adaptor,"rule qualifiedTypeIdentSimplified");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // LeMaVM.g:438:5: ( qualifiedTypeIdentSimplified ( arrayDeclaratorList )? -> ^( TYPE qualifiedTypeIdentSimplified ( arrayDeclaratorList )? ) )
            // LeMaVM.g:438:9: qualifiedTypeIdentSimplified ( arrayDeclaratorList )?
            {
            pushFollow(FOLLOW_qualifiedTypeIdentSimplified_in_objectTypeSimplified5173);
            qualifiedTypeIdentSimplified88=qualifiedTypeIdentSimplified();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_qualifiedTypeIdentSimplified.add(qualifiedTypeIdentSimplified88.getTree());
            // LeMaVM.g:438:38: ( arrayDeclaratorList )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==LBRACK) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // LeMaVM.g:0:0: arrayDeclaratorList
                    {
                    pushFollow(FOLLOW_arrayDeclaratorList_in_objectTypeSimplified5175);
                    arrayDeclaratorList89=arrayDeclaratorList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_arrayDeclaratorList.add(arrayDeclaratorList89.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: qualifiedTypeIdentSimplified, arrayDeclaratorList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 439:9: -> ^( TYPE qualifiedTypeIdentSimplified ( arrayDeclaratorList )? )
            {
                // LeMaVM.g:439:13: ^( TYPE qualifiedTypeIdentSimplified ( arrayDeclaratorList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

                adaptor.addChild(root_1, stream_qualifiedTypeIdentSimplified.nextTree());
                // LeMaVM.g:439:49: ( arrayDeclaratorList )?
                if ( stream_arrayDeclaratorList.hasNext() ) {
                    adaptor.addChild(root_1, stream_arrayDeclaratorList.nextTree());

                }
                stream_arrayDeclaratorList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, objectTypeSimplified_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "objectTypeSimplified"

    public static class qualifiedTypeIdent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifiedTypeIdent"
    // LeMaVM.g:442:1: qualifiedTypeIdent : typeIdent ( DOT typeIdent )* -> ^( QUALIFIED_TYPE_IDENT ( typeIdent )+ ) ;
    public final LeMaVMParser.qualifiedTypeIdent_return qualifiedTypeIdent() throws RecognitionException {
        LeMaVMParser.qualifiedTypeIdent_return retval = new LeMaVMParser.qualifiedTypeIdent_return();
        retval.start = input.LT(1);
        int qualifiedTypeIdent_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DOT91=null;
        LeMaVMParser.typeIdent_return typeIdent90 = null;

        LeMaVMParser.typeIdent_return typeIdent92 = null;


        CommonTree DOT91_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_typeIdent=new RewriteRuleSubtreeStream(adaptor,"rule typeIdent");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // LeMaVM.g:443:5: ( typeIdent ( DOT typeIdent )* -> ^( QUALIFIED_TYPE_IDENT ( typeIdent )+ ) )
            // LeMaVM.g:443:9: typeIdent ( DOT typeIdent )*
            {
            pushFollow(FOLLOW_typeIdent_in_qualifiedTypeIdent5215);
            typeIdent90=typeIdent();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_typeIdent.add(typeIdent90.getTree());
            // LeMaVM.g:443:19: ( DOT typeIdent )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==DOT) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // LeMaVM.g:443:20: DOT typeIdent
            	    {
            	    DOT91=(Token)match(input,DOT,FOLLOW_DOT_in_qualifiedTypeIdent5218); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_DOT.add(DOT91);

            	    pushFollow(FOLLOW_typeIdent_in_qualifiedTypeIdent5220);
            	    typeIdent92=typeIdent();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_typeIdent.add(typeIdent92.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);



            // AST REWRITE
            // elements: typeIdent
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 444:9: -> ^( QUALIFIED_TYPE_IDENT ( typeIdent )+ )
            {
                // LeMaVM.g:444:13: ^( QUALIFIED_TYPE_IDENT ( typeIdent )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUALIFIED_TYPE_IDENT, "QUALIFIED_TYPE_IDENT"), root_1);

                if ( !(stream_typeIdent.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_typeIdent.hasNext() ) {
                    adaptor.addChild(root_1, stream_typeIdent.nextTree());

                }
                stream_typeIdent.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, qualifiedTypeIdent_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "qualifiedTypeIdent"

    public static class qualifiedTypeIdentSimplified_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifiedTypeIdentSimplified"
    // LeMaVM.g:447:1: qualifiedTypeIdentSimplified : typeIdentSimplified ( DOT typeIdentSimplified )* -> ^( QUALIFIED_TYPE_IDENT ( typeIdentSimplified )+ ) ;
    public final LeMaVMParser.qualifiedTypeIdentSimplified_return qualifiedTypeIdentSimplified() throws RecognitionException {
        LeMaVMParser.qualifiedTypeIdentSimplified_return retval = new LeMaVMParser.qualifiedTypeIdentSimplified_return();
        retval.start = input.LT(1);
        int qualifiedTypeIdentSimplified_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DOT94=null;
        LeMaVMParser.typeIdentSimplified_return typeIdentSimplified93 = null;

        LeMaVMParser.typeIdentSimplified_return typeIdentSimplified95 = null;


        CommonTree DOT94_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_typeIdentSimplified=new RewriteRuleSubtreeStream(adaptor,"rule typeIdentSimplified");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // LeMaVM.g:448:5: ( typeIdentSimplified ( DOT typeIdentSimplified )* -> ^( QUALIFIED_TYPE_IDENT ( typeIdentSimplified )+ ) )
            // LeMaVM.g:448:9: typeIdentSimplified ( DOT typeIdentSimplified )*
            {
            pushFollow(FOLLOW_typeIdentSimplified_in_qualifiedTypeIdentSimplified5260);
            typeIdentSimplified93=typeIdentSimplified();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_typeIdentSimplified.add(typeIdentSimplified93.getTree());
            // LeMaVM.g:448:29: ( DOT typeIdentSimplified )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==DOT) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // LeMaVM.g:448:30: DOT typeIdentSimplified
            	    {
            	    DOT94=(Token)match(input,DOT,FOLLOW_DOT_in_qualifiedTypeIdentSimplified5263); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_DOT.add(DOT94);

            	    pushFollow(FOLLOW_typeIdentSimplified_in_qualifiedTypeIdentSimplified5265);
            	    typeIdentSimplified95=typeIdentSimplified();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_typeIdentSimplified.add(typeIdentSimplified95.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);



            // AST REWRITE
            // elements: typeIdentSimplified
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 449:9: -> ^( QUALIFIED_TYPE_IDENT ( typeIdentSimplified )+ )
            {
                // LeMaVM.g:449:13: ^( QUALIFIED_TYPE_IDENT ( typeIdentSimplified )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUALIFIED_TYPE_IDENT, "QUALIFIED_TYPE_IDENT"), root_1);

                if ( !(stream_typeIdentSimplified.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_typeIdentSimplified.hasNext() ) {
                    adaptor.addChild(root_1, stream_typeIdentSimplified.nextTree());

                }
                stream_typeIdentSimplified.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, qualifiedTypeIdentSimplified_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "qualifiedTypeIdentSimplified"

    public static class typeIdent_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeIdent"
    // LeMaVM.g:452:1: typeIdent : IDENT ;
    public final LeMaVMParser.typeIdent_return typeIdent() throws RecognitionException {
        LeMaVMParser.typeIdent_return retval = new LeMaVMParser.typeIdent_return();
        retval.start = input.LT(1);
        int typeIdent_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IDENT96=null;

        CommonTree IDENT96_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // LeMaVM.g:453:5: ( IDENT )
            // LeMaVM.g:453:9: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT96=(Token)match(input,IDENT,FOLLOW_IDENT_in_typeIdent5305); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENT96_tree = (CommonTree)adaptor.create(IDENT96);
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT96_tree, root_0);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, typeIdent_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeIdent"

    public static class typeIdentSimplified_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeIdentSimplified"
    // LeMaVM.g:456:1: typeIdentSimplified : IDENT ;
    public final LeMaVMParser.typeIdentSimplified_return typeIdentSimplified() throws RecognitionException {
        LeMaVMParser.typeIdentSimplified_return retval = new LeMaVMParser.typeIdentSimplified_return();
        retval.start = input.LT(1);
        int typeIdentSimplified_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IDENT97=null;

        CommonTree IDENT97_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // LeMaVM.g:457:5: ( IDENT )
            // LeMaVM.g:457:9: IDENT
            {
            root_0 = (CommonTree)adaptor.nil();

            IDENT97=(Token)match(input,IDENT,FOLLOW_IDENT_in_typeIdentSimplified5325); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENT97_tree = (CommonTree)adaptor.create(IDENT97);
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT97_tree, root_0);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, typeIdentSimplified_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "typeIdentSimplified"

    public static class primitiveType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primitiveType"
    // LeMaVM.g:460:1: primitiveType : ( BOOLEAN | SHORT | INT | LONG | DOUBLE | STRING );
    public final LeMaVMParser.primitiveType_return primitiveType() throws RecognitionException {
        LeMaVMParser.primitiveType_return retval = new LeMaVMParser.primitiveType_return();
        retval.start = input.LT(1);
        int primitiveType_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set98=null;

        CommonTree set98_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // LeMaVM.g:461:5: ( BOOLEAN | SHORT | INT | LONG | DOUBLE | STRING )
            // LeMaVM.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set98=(Token)input.LT(1);
            if ( input.LA(1)==BOOLEAN||input.LA(1)==DOUBLE||(input.LA(1)>=INT && input.LA(1)<=LONG)||input.LA(1)==SHORT||input.LA(1)==STRING ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set98));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, primitiveType_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primitiveType"

    public static class qualifiedIdentList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifiedIdentList"
    // LeMaVM.g:469:1: qualifiedIdentList : qualifiedIdentifier ( COMMA qualifiedIdentifier )* ;
    public final LeMaVMParser.qualifiedIdentList_return qualifiedIdentList() throws RecognitionException {
        LeMaVMParser.qualifiedIdentList_return retval = new LeMaVMParser.qualifiedIdentList_return();
        retval.start = input.LT(1);
        int qualifiedIdentList_StartIndex = input.index();
        CommonTree root_0 = null;

        Token COMMA100=null;
        LeMaVMParser.qualifiedIdentifier_return qualifiedIdentifier99 = null;

        LeMaVMParser.qualifiedIdentifier_return qualifiedIdentifier101 = null;


        CommonTree COMMA100_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // LeMaVM.g:470:5: ( qualifiedIdentifier ( COMMA qualifiedIdentifier )* )
            // LeMaVM.g:470:9: qualifiedIdentifier ( COMMA qualifiedIdentifier )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_qualifiedIdentifier_in_qualifiedIdentList5414);
            qualifiedIdentifier99=qualifiedIdentifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, qualifiedIdentifier99.getTree());
            // LeMaVM.g:470:29: ( COMMA qualifiedIdentifier )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==COMMA) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // LeMaVM.g:470:30: COMMA qualifiedIdentifier
            	    {
            	    COMMA100=(Token)match(input,COMMA,FOLLOW_COMMA_in_qualifiedIdentList5417); if (state.failed) return retval;
            	    pushFollow(FOLLOW_qualifiedIdentifier_in_qualifiedIdentList5420);
            	    qualifiedIdentifier101=qualifiedIdentifier();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, qualifiedIdentifier101.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, qualifiedIdentList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "qualifiedIdentList"

    public static class formalParameterList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formalParameterList"
    // LeMaVM.g:473:1: formalParameterList : LPAREN ( formalParameterStandardDecl ( COMMA formalParameterStandardDecl )* -> ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] ( formalParameterStandardDecl )+ ) | -> ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] ) ) RPAREN ;
    public final LeMaVMParser.formalParameterList_return formalParameterList() throws RecognitionException {
        LeMaVMParser.formalParameterList_return retval = new LeMaVMParser.formalParameterList_return();
        retval.start = input.LT(1);
        int formalParameterList_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LPAREN102=null;
        Token COMMA104=null;
        Token RPAREN106=null;
        LeMaVMParser.formalParameterStandardDecl_return formalParameterStandardDecl103 = null;

        LeMaVMParser.formalParameterStandardDecl_return formalParameterStandardDecl105 = null;


        CommonTree LPAREN102_tree=null;
        CommonTree COMMA104_tree=null;
        CommonTree RPAREN106_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_formalParameterStandardDecl=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterStandardDecl");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // LeMaVM.g:474:5: ( LPAREN ( formalParameterStandardDecl ( COMMA formalParameterStandardDecl )* -> ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] ( formalParameterStandardDecl )+ ) | -> ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] ) ) RPAREN )
            // LeMaVM.g:474:9: LPAREN ( formalParameterStandardDecl ( COMMA formalParameterStandardDecl )* -> ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] ( formalParameterStandardDecl )+ ) | -> ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] ) ) RPAREN
            {
            LPAREN102=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_formalParameterList5445); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN102);

            // LeMaVM.g:475:9: ( formalParameterStandardDecl ( COMMA formalParameterStandardDecl )* -> ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] ( formalParameterStandardDecl )+ ) | -> ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==BOOLEAN||LA36_0==DOUBLE||LA36_0==FINAL||(LA36_0>=INT && LA36_0<=LONG)||LA36_0==SHORT||LA36_0==STRING||LA36_0==IDENT) ) {
                alt36=1;
            }
            else if ( (LA36_0==RPAREN) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // LeMaVM.g:476:13: formalParameterStandardDecl ( COMMA formalParameterStandardDecl )*
                    {
                    pushFollow(FOLLOW_formalParameterStandardDecl_in_formalParameterList5473);
                    formalParameterStandardDecl103=formalParameterStandardDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_formalParameterStandardDecl.add(formalParameterStandardDecl103.getTree());
                    // LeMaVM.g:476:41: ( COMMA formalParameterStandardDecl )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==COMMA) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // LeMaVM.g:476:42: COMMA formalParameterStandardDecl
                    	    {
                    	    COMMA104=(Token)match(input,COMMA,FOLLOW_COMMA_in_formalParameterList5476); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA104);

                    	    pushFollow(FOLLOW_formalParameterStandardDecl_in_formalParameterList5478);
                    	    formalParameterStandardDecl105=formalParameterStandardDecl();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_formalParameterStandardDecl.add(formalParameterStandardDecl105.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: formalParameterStandardDecl
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 477:13: -> ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] ( formalParameterStandardDecl )+ )
                    {
                        // LeMaVM.g:477:17: ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] ( formalParameterStandardDecl )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMAL_PARAM_LIST, LPAREN102, "FORMAL_PARAM_LIST"), root_1);

                        if ( !(stream_formalParameterStandardDecl.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_formalParameterStandardDecl.hasNext() ) {
                            adaptor.addChild(root_1, stream_formalParameterStandardDecl.nextTree());

                        }
                        stream_formalParameterStandardDecl.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // LeMaVM.g:479:13: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 479:13: -> ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] )
                    {
                        // LeMaVM.g:479:17: ^( FORMAL_PARAM_LIST[$LPAREN, \"FORMAL_PARAM_LIST\"] )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMAL_PARAM_LIST, LPAREN102, "FORMAL_PARAM_LIST"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }

            RPAREN106=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_formalParameterList5558); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN106);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, formalParameterList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "formalParameterList"

    public static class formalParameterStandardDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formalParameterStandardDecl"
    // LeMaVM.g:484:1: formalParameterStandardDecl : localModifierList type variableDeclaratorId -> ^( FORMAL_PARAM_STD_DECL localModifierList type variableDeclaratorId ) ;
    public final LeMaVMParser.formalParameterStandardDecl_return formalParameterStandardDecl() throws RecognitionException {
        LeMaVMParser.formalParameterStandardDecl_return retval = new LeMaVMParser.formalParameterStandardDecl_return();
        retval.start = input.LT(1);
        int formalParameterStandardDecl_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.localModifierList_return localModifierList107 = null;

        LeMaVMParser.type_return type108 = null;

        LeMaVMParser.variableDeclaratorId_return variableDeclaratorId109 = null;


        RewriteRuleSubtreeStream stream_variableDeclaratorId=new RewriteRuleSubtreeStream(adaptor,"rule variableDeclaratorId");
        RewriteRuleSubtreeStream stream_localModifierList=new RewriteRuleSubtreeStream(adaptor,"rule localModifierList");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // LeMaVM.g:485:5: ( localModifierList type variableDeclaratorId -> ^( FORMAL_PARAM_STD_DECL localModifierList type variableDeclaratorId ) )
            // LeMaVM.g:485:9: localModifierList type variableDeclaratorId
            {
            pushFollow(FOLLOW_localModifierList_in_formalParameterStandardDecl5581);
            localModifierList107=localModifierList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_localModifierList.add(localModifierList107.getTree());
            pushFollow(FOLLOW_type_in_formalParameterStandardDecl5583);
            type108=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type108.getTree());
            pushFollow(FOLLOW_variableDeclaratorId_in_formalParameterStandardDecl5585);
            variableDeclaratorId109=variableDeclaratorId();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_variableDeclaratorId.add(variableDeclaratorId109.getTree());


            // AST REWRITE
            // elements: localModifierList, variableDeclaratorId, type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 486:9: -> ^( FORMAL_PARAM_STD_DECL localModifierList type variableDeclaratorId )
            {
                // LeMaVM.g:486:13: ^( FORMAL_PARAM_STD_DECL localModifierList type variableDeclaratorId )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMAL_PARAM_STD_DECL, "FORMAL_PARAM_STD_DECL"), root_1);

                adaptor.addChild(root_1, stream_localModifierList.nextTree());
                adaptor.addChild(root_1, stream_type.nextTree());
                adaptor.addChild(root_1, stream_variableDeclaratorId.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, formalParameterStandardDecl_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "formalParameterStandardDecl"

    public static class qualifiedIdentifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifiedIdentifier"
    // LeMaVM.g:489:1: qualifiedIdentifier : ( IDENT -> IDENT ) ( DOT ident= IDENT -> ^( DOT $qualifiedIdentifier $ident) )* ;
    public final LeMaVMParser.qualifiedIdentifier_return qualifiedIdentifier() throws RecognitionException {
        LeMaVMParser.qualifiedIdentifier_return retval = new LeMaVMParser.qualifiedIdentifier_return();
        retval.start = input.LT(1);
        int qualifiedIdentifier_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ident=null;
        Token IDENT110=null;
        Token DOT111=null;

        CommonTree ident_tree=null;
        CommonTree IDENT110_tree=null;
        CommonTree DOT111_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // LeMaVM.g:490:5: ( ( IDENT -> IDENT ) ( DOT ident= IDENT -> ^( DOT $qualifiedIdentifier $ident) )* )
            // LeMaVM.g:490:9: ( IDENT -> IDENT ) ( DOT ident= IDENT -> ^( DOT $qualifiedIdentifier $ident) )*
            {
            // LeMaVM.g:490:9: ( IDENT -> IDENT )
            // LeMaVM.g:490:13: IDENT
            {
            IDENT110=(Token)match(input,IDENT,FOLLOW_IDENT_in_qualifiedIdentifier5633); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT110);



            // AST REWRITE
            // elements: IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 490:33: -> IDENT
            {
                adaptor.addChild(root_0, stream_IDENT.nextNode());

            }

            retval.tree = root_0;}
            }

            // LeMaVM.g:492:9: ( DOT ident= IDENT -> ^( DOT $qualifiedIdentifier $ident) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==DOT) ) {
                    int LA37_2 = input.LA(2);

                    if ( (LA37_2==IDENT) ) {
                        int LA37_3 = input.LA(3);

                        if ( (synpred49_LeMaVM()) ) {
                            alt37=1;
                        }


                    }


                }


                switch (alt37) {
            	case 1 :
            	    // LeMaVM.g:492:13: DOT ident= IDENT
            	    {
            	    DOT111=(Token)match(input,DOT,FOLLOW_DOT_in_qualifiedIdentifier5676); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_DOT.add(DOT111);

            	    ident=(Token)match(input,IDENT,FOLLOW_IDENT_in_qualifiedIdentifier5680); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_IDENT.add(ident);



            	    // AST REWRITE
            	    // elements: DOT, ident, qualifiedIdentifier
            	    // token labels: ident
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_ident=new RewriteRuleTokenStream(adaptor,"token ident",ident);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 492:33: -> ^( DOT $qualifiedIdentifier $ident)
            	    {
            	        // LeMaVM.g:492:37: ^( DOT $qualifiedIdentifier $ident)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_ident.nextNode());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, qualifiedIdentifier_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "qualifiedIdentifier"

    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // LeMaVM.g:498:1: block : LCURLY ( blockStatement )* RCURLY -> ^( BLOCK_SCOPE[$LCURLY, \"BLOCK_SCOPE\"] ( blockStatement )* ) ;
    public final LeMaVMParser.block_return block() throws RecognitionException {
        LeMaVMParser.block_return retval = new LeMaVMParser.block_return();
        retval.start = input.LT(1);
        int block_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LCURLY112=null;
        Token RCURLY114=null;
        LeMaVMParser.blockStatement_return blockStatement113 = null;


        CommonTree LCURLY112_tree=null;
        CommonTree RCURLY114_tree=null;
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleSubtreeStream stream_blockStatement=new RewriteRuleSubtreeStream(adaptor,"rule blockStatement");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // LeMaVM.g:499:5: ( LCURLY ( blockStatement )* RCURLY -> ^( BLOCK_SCOPE[$LCURLY, \"BLOCK_SCOPE\"] ( blockStatement )* ) )
            // LeMaVM.g:499:9: LCURLY ( blockStatement )* RCURLY
            {
            LCURLY112=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_block5729); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY112);

            // LeMaVM.g:499:16: ( blockStatement )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==DEC||LA38_0==INC||LA38_0==LCURLY||LA38_0==LOGICAL_NOT||(LA38_0>=LPAREN && LA38_0<=MINUS)||LA38_0==NOT||LA38_0==PLUS||LA38_0==SEMI||(LA38_0>=BOOLEAN && LA38_0<=BREAK)||(LA38_0>=CLASS && LA38_0<=CONTINUE)||(LA38_0>=DO && LA38_0<=DOUBLE)||(LA38_0>=FALSE && LA38_0<=IF)||(LA38_0>=INT && LA38_0<=NULL)||(LA38_0>=PRIVATE && LA38_0<=TRUE)||(LA38_0>=VOID && LA38_0<=WHILE)||(LA38_0>=IDENT && LA38_0<=STRING_LITERAL)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // LeMaVM.g:0:0: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_block5731);
            	    blockStatement113=blockStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_blockStatement.add(blockStatement113.getTree());

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            RCURLY114=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_block5734); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY114);



            // AST REWRITE
            // elements: blockStatement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 500:9: -> ^( BLOCK_SCOPE[$LCURLY, \"BLOCK_SCOPE\"] ( blockStatement )* )
            {
                // LeMaVM.g:500:13: ^( BLOCK_SCOPE[$LCURLY, \"BLOCK_SCOPE\"] ( blockStatement )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK_SCOPE, LCURLY112, "BLOCK_SCOPE"), root_1);

                // LeMaVM.g:500:51: ( blockStatement )*
                while ( stream_blockStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_blockStatement.nextTree());

                }
                stream_blockStatement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, block_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class blockStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "blockStatement"
    // LeMaVM.g:503:1: blockStatement : ( localVariableDeclaration SEMI | typeDeclaration | statement );
    public final LeMaVMParser.blockStatement_return blockStatement() throws RecognitionException {
        LeMaVMParser.blockStatement_return retval = new LeMaVMParser.blockStatement_return();
        retval.start = input.LT(1);
        int blockStatement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SEMI116=null;
        LeMaVMParser.localVariableDeclaration_return localVariableDeclaration115 = null;

        LeMaVMParser.typeDeclaration_return typeDeclaration117 = null;

        LeMaVMParser.statement_return statement118 = null;


        CommonTree SEMI116_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // LeMaVM.g:504:5: ( localVariableDeclaration SEMI | typeDeclaration | statement )
            int alt39=3;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // LeMaVM.g:504:9: localVariableDeclaration SEMI
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_localVariableDeclaration_in_blockStatement5772);
                    localVariableDeclaration115=localVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, localVariableDeclaration115.getTree());
                    SEMI116=(Token)match(input,SEMI,FOLLOW_SEMI_in_blockStatement5774); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // LeMaVM.g:505:9: typeDeclaration
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_typeDeclaration_in_blockStatement5785);
                    typeDeclaration117=typeDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, typeDeclaration117.getTree());

                    }
                    break;
                case 3 :
                    // LeMaVM.g:506:9: statement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_blockStatement5795);
                    statement118=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement118.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, blockStatement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "blockStatement"

    public static class localVariableDeclaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "localVariableDeclaration"
    // LeMaVM.g:509:1: localVariableDeclaration : localModifierList type classFieldDeclaratorList -> ^( VAR_DECLARATION localModifierList type classFieldDeclaratorList ) ;
    public final LeMaVMParser.localVariableDeclaration_return localVariableDeclaration() throws RecognitionException {
        LeMaVMParser.localVariableDeclaration_return retval = new LeMaVMParser.localVariableDeclaration_return();
        retval.start = input.LT(1);
        int localVariableDeclaration_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.localModifierList_return localModifierList119 = null;

        LeMaVMParser.type_return type120 = null;

        LeMaVMParser.classFieldDeclaratorList_return classFieldDeclaratorList121 = null;


        RewriteRuleSubtreeStream stream_localModifierList=new RewriteRuleSubtreeStream(adaptor,"rule localModifierList");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        RewriteRuleSubtreeStream stream_classFieldDeclaratorList=new RewriteRuleSubtreeStream(adaptor,"rule classFieldDeclaratorList");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // LeMaVM.g:510:5: ( localModifierList type classFieldDeclaratorList -> ^( VAR_DECLARATION localModifierList type classFieldDeclaratorList ) )
            // LeMaVM.g:510:9: localModifierList type classFieldDeclaratorList
            {
            pushFollow(FOLLOW_localModifierList_in_localVariableDeclaration5818);
            localModifierList119=localModifierList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_localModifierList.add(localModifierList119.getTree());
            pushFollow(FOLLOW_type_in_localVariableDeclaration5820);
            type120=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type120.getTree());
            pushFollow(FOLLOW_classFieldDeclaratorList_in_localVariableDeclaration5822);
            classFieldDeclaratorList121=classFieldDeclaratorList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_classFieldDeclaratorList.add(classFieldDeclaratorList121.getTree());


            // AST REWRITE
            // elements: type, classFieldDeclaratorList, localModifierList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 511:9: -> ^( VAR_DECLARATION localModifierList type classFieldDeclaratorList )
            {
                // LeMaVM.g:511:13: ^( VAR_DECLARATION localModifierList type classFieldDeclaratorList )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_DECLARATION, "VAR_DECLARATION"), root_1);

                adaptor.addChild(root_1, stream_localModifierList.nextTree());
                adaptor.addChild(root_1, stream_type.nextTree());
                adaptor.addChild(root_1, stream_classFieldDeclaratorList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, localVariableDeclaration_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "localVariableDeclaration"

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // LeMaVM.g:515:1: statement : ( block | IF parenthesizedExpression ifStat= statement ( ELSE elseStat= statement -> ^( IF parenthesizedExpression $ifStat $elseStat) | -> ^( IF parenthesizedExpression $ifStat) ) | FOR LPAREN ( forInit SEMI forCondition SEMI forUpdater RPAREN statement -> ^( FOR forInit forCondition forUpdater statement ) | localModifierList type IDENT COLON expression RPAREN statement -> ^( FOR_EACH[$FOR, \"FOR_EACH\"] localModifierList type IDENT expression statement ) ) | WHILE parenthesizedExpression statement -> ^( WHILE parenthesizedExpression statement ) | DO statement WHILE parenthesizedExpression SEMI -> ^( DO statement parenthesizedExpression ) | SWITCH parenthesizedExpression LCURLY switchBlockLabels RCURLY -> ^( SWITCH parenthesizedExpression switchBlockLabels ) | RETURN ( expression )? SEMI -> ^( RETURN ( expression )? ) | BREAK ( IDENT )? SEMI -> ^( BREAK ( IDENT )? ) | CONTINUE ( IDENT )? SEMI -> ^( CONTINUE ( IDENT )? ) | IDENT COLON statement -> ^( LABELED_STATEMENT IDENT statement ) | expression SEMI | SEMI );
    public final LeMaVMParser.statement_return statement() throws RecognitionException {
        LeMaVMParser.statement_return retval = new LeMaVMParser.statement_return();
        retval.start = input.LT(1);
        int statement_StartIndex = input.index();
        CommonTree root_0 = null;

        Token IF123=null;
        Token ELSE125=null;
        Token FOR126=null;
        Token LPAREN127=null;
        Token SEMI129=null;
        Token SEMI131=null;
        Token RPAREN133=null;
        Token IDENT137=null;
        Token COLON138=null;
        Token RPAREN140=null;
        Token WHILE142=null;
        Token DO145=null;
        Token WHILE147=null;
        Token SEMI149=null;
        Token SWITCH150=null;
        Token LCURLY152=null;
        Token RCURLY154=null;
        Token RETURN155=null;
        Token SEMI157=null;
        Token BREAK158=null;
        Token IDENT159=null;
        Token SEMI160=null;
        Token CONTINUE161=null;
        Token IDENT162=null;
        Token SEMI163=null;
        Token IDENT164=null;
        Token COLON165=null;
        Token SEMI168=null;
        Token SEMI169=null;
        LeMaVMParser.statement_return ifStat = null;

        LeMaVMParser.statement_return elseStat = null;

        LeMaVMParser.block_return block122 = null;

        LeMaVMParser.parenthesizedExpression_return parenthesizedExpression124 = null;

        LeMaVMParser.forInit_return forInit128 = null;

        LeMaVMParser.forCondition_return forCondition130 = null;

        LeMaVMParser.forUpdater_return forUpdater132 = null;

        LeMaVMParser.statement_return statement134 = null;

        LeMaVMParser.localModifierList_return localModifierList135 = null;

        LeMaVMParser.type_return type136 = null;

        LeMaVMParser.expression_return expression139 = null;

        LeMaVMParser.statement_return statement141 = null;

        LeMaVMParser.parenthesizedExpression_return parenthesizedExpression143 = null;

        LeMaVMParser.statement_return statement144 = null;

        LeMaVMParser.statement_return statement146 = null;

        LeMaVMParser.parenthesizedExpression_return parenthesizedExpression148 = null;

        LeMaVMParser.parenthesizedExpression_return parenthesizedExpression151 = null;

        LeMaVMParser.switchBlockLabels_return switchBlockLabels153 = null;

        LeMaVMParser.expression_return expression156 = null;

        LeMaVMParser.statement_return statement166 = null;

        LeMaVMParser.expression_return expression167 = null;


        CommonTree IF123_tree=null;
        CommonTree ELSE125_tree=null;
        CommonTree FOR126_tree=null;
        CommonTree LPAREN127_tree=null;
        CommonTree SEMI129_tree=null;
        CommonTree SEMI131_tree=null;
        CommonTree RPAREN133_tree=null;
        CommonTree IDENT137_tree=null;
        CommonTree COLON138_tree=null;
        CommonTree RPAREN140_tree=null;
        CommonTree WHILE142_tree=null;
        CommonTree DO145_tree=null;
        CommonTree WHILE147_tree=null;
        CommonTree SEMI149_tree=null;
        CommonTree SWITCH150_tree=null;
        CommonTree LCURLY152_tree=null;
        CommonTree RCURLY154_tree=null;
        CommonTree RETURN155_tree=null;
        CommonTree SEMI157_tree=null;
        CommonTree BREAK158_tree=null;
        CommonTree IDENT159_tree=null;
        CommonTree SEMI160_tree=null;
        CommonTree CONTINUE161_tree=null;
        CommonTree IDENT162_tree=null;
        CommonTree SEMI163_tree=null;
        CommonTree IDENT164_tree=null;
        CommonTree COLON165_tree=null;
        CommonTree SEMI168_tree=null;
        CommonTree SEMI169_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleTokenStream stream_CONTINUE=new RewriteRuleTokenStream(adaptor,"token CONTINUE");
        RewriteRuleTokenStream stream_SWITCH=new RewriteRuleTokenStream(adaptor,"token SWITCH");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleTokenStream stream_RETURN=new RewriteRuleTokenStream(adaptor,"token RETURN");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_FOR=new RewriteRuleTokenStream(adaptor,"token FOR");
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_BREAK=new RewriteRuleTokenStream(adaptor,"token BREAK");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_forUpdater=new RewriteRuleSubtreeStream(adaptor,"rule forUpdater");
        RewriteRuleSubtreeStream stream_forCondition=new RewriteRuleSubtreeStream(adaptor,"rule forCondition");
        RewriteRuleSubtreeStream stream_localModifierList=new RewriteRuleSubtreeStream(adaptor,"rule localModifierList");
        RewriteRuleSubtreeStream stream_forInit=new RewriteRuleSubtreeStream(adaptor,"rule forInit");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        RewriteRuleSubtreeStream stream_switchBlockLabels=new RewriteRuleSubtreeStream(adaptor,"rule switchBlockLabels");
        RewriteRuleSubtreeStream stream_parenthesizedExpression=new RewriteRuleSubtreeStream(adaptor,"rule parenthesizedExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // LeMaVM.g:516:5: ( block | IF parenthesizedExpression ifStat= statement ( ELSE elseStat= statement -> ^( IF parenthesizedExpression $ifStat $elseStat) | -> ^( IF parenthesizedExpression $ifStat) ) | FOR LPAREN ( forInit SEMI forCondition SEMI forUpdater RPAREN statement -> ^( FOR forInit forCondition forUpdater statement ) | localModifierList type IDENT COLON expression RPAREN statement -> ^( FOR_EACH[$FOR, \"FOR_EACH\"] localModifierList type IDENT expression statement ) ) | WHILE parenthesizedExpression statement -> ^( WHILE parenthesizedExpression statement ) | DO statement WHILE parenthesizedExpression SEMI -> ^( DO statement parenthesizedExpression ) | SWITCH parenthesizedExpression LCURLY switchBlockLabels RCURLY -> ^( SWITCH parenthesizedExpression switchBlockLabels ) | RETURN ( expression )? SEMI -> ^( RETURN ( expression )? ) | BREAK ( IDENT )? SEMI -> ^( BREAK ( IDENT )? ) | CONTINUE ( IDENT )? SEMI -> ^( CONTINUE ( IDENT )? ) | IDENT COLON statement -> ^( LABELED_STATEMENT IDENT statement ) | expression SEMI | SEMI )
            int alt45=12;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // LeMaVM.g:516:9: block
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_block_in_statement5875);
                    block122=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block122.getTree());

                    }
                    break;
                case 2 :
                    // LeMaVM.g:517:9: IF parenthesizedExpression ifStat= statement ( ELSE elseStat= statement -> ^( IF parenthesizedExpression $ifStat $elseStat) | -> ^( IF parenthesizedExpression $ifStat) )
                    {
                    IF123=(Token)match(input,IF,FOLLOW_IF_in_statement5885); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IF.add(IF123);

                    pushFollow(FOLLOW_parenthesizedExpression_in_statement5887);
                    parenthesizedExpression124=parenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_parenthesizedExpression.add(parenthesizedExpression124.getTree());
                    pushFollow(FOLLOW_statement_in_statement5891);
                    ifStat=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(ifStat.getTree());
                    // LeMaVM.g:518:9: ( ELSE elseStat= statement -> ^( IF parenthesizedExpression $ifStat $elseStat) | -> ^( IF parenthesizedExpression $ifStat) )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==ELSE) ) {
                        int LA40_1 = input.LA(2);

                        if ( (synpred54_LeMaVM()) ) {
                            alt40=1;
                        }
                        else if ( (true) ) {
                            alt40=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 40, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA40_0==EOF||LA40_0==DEC||LA40_0==INC||LA40_0==LCURLY||LA40_0==LOGICAL_NOT||(LA40_0>=LPAREN && LA40_0<=MINUS)||LA40_0==NOT||LA40_0==PLUS||LA40_0==RCURLY||LA40_0==SEMI||(LA40_0>=BOOLEAN && LA40_0<=DOUBLE)||(LA40_0>=FALSE && LA40_0<=IF)||(LA40_0>=INT && LA40_0<=NULL)||(LA40_0>=PRIVATE && LA40_0<=TRUE)||(LA40_0>=VOID && LA40_0<=WHILE)||(LA40_0>=IDENT && LA40_0<=STRING_LITERAL)) ) {
                        alt40=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }
                    switch (alt40) {
                        case 1 :
                            // LeMaVM.g:518:13: ELSE elseStat= statement
                            {
                            ELSE125=(Token)match(input,ELSE,FOLLOW_ELSE_in_statement5906); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ELSE.add(ELSE125);

                            pushFollow(FOLLOW_statement_in_statement5910);
                            elseStat=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_statement.add(elseStat.getTree());


                            // AST REWRITE
                            // elements: parenthesizedExpression, IF, elseStat, ifStat
                            // token labels: 
                            // rule labels: retval, ifStat, elseStat
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_ifStat=new RewriteRuleSubtreeStream(adaptor,"rule ifStat",ifStat!=null?ifStat.tree:null);
                            RewriteRuleSubtreeStream stream_elseStat=new RewriteRuleSubtreeStream(adaptor,"rule elseStat",elseStat!=null?elseStat.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 518:77: -> ^( IF parenthesizedExpression $ifStat $elseStat)
                            {
                                // LeMaVM.g:518:81: ^( IF parenthesizedExpression $ifStat $elseStat)
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_parenthesizedExpression.nextTree());
                                adaptor.addChild(root_1, stream_ifStat.nextTree());
                                adaptor.addChild(root_1, stream_elseStat.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // LeMaVM.g:519:77: 
                            {

                            // AST REWRITE
                            // elements: ifStat, parenthesizedExpression, IF
                            // token labels: 
                            // rule labels: retval, ifStat
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                            RewriteRuleSubtreeStream stream_ifStat=new RewriteRuleSubtreeStream(adaptor,"rule ifStat",ifStat!=null?ifStat.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 519:77: -> ^( IF parenthesizedExpression $ifStat)
                            {
                                // LeMaVM.g:519:81: ^( IF parenthesizedExpression $ifStat)
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_parenthesizedExpression.nextTree());
                                adaptor.addChild(root_1, stream_ifStat.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // LeMaVM.g:521:9: FOR LPAREN ( forInit SEMI forCondition SEMI forUpdater RPAREN statement -> ^( FOR forInit forCondition forUpdater statement ) | localModifierList type IDENT COLON expression RPAREN statement -> ^( FOR_EACH[$FOR, \"FOR_EACH\"] localModifierList type IDENT expression statement ) )
                    {
                    FOR126=(Token)match(input,FOR,FOLLOW_FOR_in_statement6076); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FOR.add(FOR126);

                    LPAREN127=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_statement6078); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN127);

                    // LeMaVM.g:522:9: ( forInit SEMI forCondition SEMI forUpdater RPAREN statement -> ^( FOR forInit forCondition forUpdater statement ) | localModifierList type IDENT COLON expression RPAREN statement -> ^( FOR_EACH[$FOR, \"FOR_EACH\"] localModifierList type IDENT expression statement ) )
                    int alt41=2;
                    alt41 = dfa41.predict(input);
                    switch (alt41) {
                        case 1 :
                            // LeMaVM.g:522:13: forInit SEMI forCondition SEMI forUpdater RPAREN statement
                            {
                            pushFollow(FOLLOW_forInit_in_statement6093);
                            forInit128=forInit();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_forInit.add(forInit128.getTree());
                            SEMI129=(Token)match(input,SEMI,FOLLOW_SEMI_in_statement6095); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SEMI.add(SEMI129);

                            pushFollow(FOLLOW_forCondition_in_statement6097);
                            forCondition130=forCondition();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_forCondition.add(forCondition130.getTree());
                            SEMI131=(Token)match(input,SEMI,FOLLOW_SEMI_in_statement6099); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SEMI.add(SEMI131);

                            pushFollow(FOLLOW_forUpdater_in_statement6101);
                            forUpdater132=forUpdater();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_forUpdater.add(forUpdater132.getTree());
                            RPAREN133=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_statement6103); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN133);

                            pushFollow(FOLLOW_statement_in_statement6105);
                            statement134=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_statement.add(statement134.getTree());


                            // AST REWRITE
                            // elements: FOR, forCondition, forInit, statement, forUpdater
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 522:77: -> ^( FOR forInit forCondition forUpdater statement )
                            {
                                // LeMaVM.g:522:81: ^( FOR forInit forCondition forUpdater statement )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(stream_FOR.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_forInit.nextTree());
                                adaptor.addChild(root_1, stream_forCondition.nextTree());
                                adaptor.addChild(root_1, stream_forUpdater.nextTree());
                                adaptor.addChild(root_1, stream_statement.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // LeMaVM.g:523:13: localModifierList type IDENT COLON expression RPAREN statement
                            {
                            pushFollow(FOLLOW_localModifierList_in_statement6140);
                            localModifierList135=localModifierList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_localModifierList.add(localModifierList135.getTree());
                            pushFollow(FOLLOW_type_in_statement6142);
                            type136=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_type.add(type136.getTree());
                            IDENT137=(Token)match(input,IDENT,FOLLOW_IDENT_in_statement6144); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENT.add(IDENT137);

                            COLON138=(Token)match(input,COLON,FOLLOW_COLON_in_statement6146); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON.add(COLON138);

                            pushFollow(FOLLOW_expression_in_statement6148);
                            expression139=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expression.add(expression139.getTree());
                            RPAREN140=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_statement6150); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN140);

                            pushFollow(FOLLOW_statement_in_statement6152);
                            statement141=statement();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_statement.add(statement141.getTree());


                            // AST REWRITE
                            // elements: localModifierList, statement, IDENT, expression, type
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 524:77: -> ^( FOR_EACH[$FOR, \"FOR_EACH\"] localModifierList type IDENT expression statement )
                            {
                                // LeMaVM.g:524:81: ^( FOR_EACH[$FOR, \"FOR_EACH\"] localModifierList type IDENT expression statement )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOR_EACH, FOR126, "FOR_EACH"), root_1);

                                adaptor.addChild(root_1, stream_localModifierList.nextTree());
                                adaptor.addChild(root_1, stream_type.nextTree());
                                adaptor.addChild(root_1, stream_IDENT.nextNode());
                                adaptor.addChild(root_1, stream_expression.nextTree());
                                adaptor.addChild(root_1, stream_statement.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // LeMaVM.g:526:9: WHILE parenthesizedExpression statement
                    {
                    WHILE142=(Token)match(input,WHILE,FOLLOW_WHILE_in_statement6267); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WHILE.add(WHILE142);

                    pushFollow(FOLLOW_parenthesizedExpression_in_statement6269);
                    parenthesizedExpression143=parenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_parenthesizedExpression.add(parenthesizedExpression143.getTree());
                    pushFollow(FOLLOW_statement_in_statement6271);
                    statement144=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement144.getTree());


                    // AST REWRITE
                    // elements: parenthesizedExpression, statement, WHILE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 526:77: -> ^( WHILE parenthesizedExpression statement )
                    {
                        // LeMaVM.g:526:81: ^( WHILE parenthesizedExpression statement )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_WHILE.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_parenthesizedExpression.nextTree());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // LeMaVM.g:527:9: DO statement WHILE parenthesizedExpression SEMI
                    {
                    DO145=(Token)match(input,DO,FOLLOW_DO_in_statement6320); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DO.add(DO145);

                    pushFollow(FOLLOW_statement_in_statement6322);
                    statement146=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement146.getTree());
                    WHILE147=(Token)match(input,WHILE,FOLLOW_WHILE_in_statement6324); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WHILE.add(WHILE147);

                    pushFollow(FOLLOW_parenthesizedExpression_in_statement6326);
                    parenthesizedExpression148=parenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_parenthesizedExpression.add(parenthesizedExpression148.getTree());
                    SEMI149=(Token)match(input,SEMI,FOLLOW_SEMI_in_statement6328); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI149);



                    // AST REWRITE
                    // elements: parenthesizedExpression, DO, statement
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 527:77: -> ^( DO statement parenthesizedExpression )
                    {
                        // LeMaVM.g:527:81: ^( DO statement parenthesizedExpression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_DO.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_statement.nextTree());
                        adaptor.addChild(root_1, stream_parenthesizedExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // LeMaVM.g:528:9: SWITCH parenthesizedExpression LCURLY switchBlockLabels RCURLY
                    {
                    SWITCH150=(Token)match(input,SWITCH,FOLLOW_SWITCH_in_statement6369); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SWITCH.add(SWITCH150);

                    pushFollow(FOLLOW_parenthesizedExpression_in_statement6371);
                    parenthesizedExpression151=parenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_parenthesizedExpression.add(parenthesizedExpression151.getTree());
                    LCURLY152=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_statement6373); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY152);

                    pushFollow(FOLLOW_switchBlockLabels_in_statement6375);
                    switchBlockLabels153=switchBlockLabels();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_switchBlockLabels.add(switchBlockLabels153.getTree());
                    RCURLY154=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_statement6377); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY154);



                    // AST REWRITE
                    // elements: switchBlockLabels, parenthesizedExpression, SWITCH
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 528:77: -> ^( SWITCH parenthesizedExpression switchBlockLabels )
                    {
                        // LeMaVM.g:528:81: ^( SWITCH parenthesizedExpression switchBlockLabels )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_SWITCH.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_parenthesizedExpression.nextTree());
                        adaptor.addChild(root_1, stream_switchBlockLabels.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // LeMaVM.g:529:9: RETURN ( expression )? SEMI
                    {
                    RETURN155=(Token)match(input,RETURN,FOLLOW_RETURN_in_statement6403); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RETURN.add(RETURN155);

                    // LeMaVM.g:529:16: ( expression )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==DEC||LA42_0==INC||LA42_0==LOGICAL_NOT||(LA42_0>=LPAREN && LA42_0<=MINUS)||LA42_0==NOT||LA42_0==PLUS||LA42_0==BOOLEAN||LA42_0==DOUBLE||LA42_0==FALSE||(LA42_0>=INT && LA42_0<=NULL)||LA42_0==SHORT||(LA42_0>=STRING && LA42_0<=SUPER)||(LA42_0>=THIS && LA42_0<=TRUE)||LA42_0==VOID||(LA42_0>=IDENT && LA42_0<=STRING_LITERAL)) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // LeMaVM.g:0:0: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement6405);
                            expression156=expression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_expression.add(expression156.getTree());

                            }
                            break;

                    }

                    SEMI157=(Token)match(input,SEMI,FOLLOW_SEMI_in_statement6408); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI157);



                    // AST REWRITE
                    // elements: RETURN, expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 529:77: -> ^( RETURN ( expression )? )
                    {
                        // LeMaVM.g:529:81: ^( RETURN ( expression )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_RETURN.nextNode(), root_1);

                        // LeMaVM.g:529:90: ( expression )?
                        if ( stream_expression.hasNext() ) {
                            adaptor.addChild(root_1, stream_expression.nextTree());

                        }
                        stream_expression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // LeMaVM.g:530:9: BREAK ( IDENT )? SEMI
                    {
                    BREAK158=(Token)match(input,BREAK,FOLLOW_BREAK_in_statement6472); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BREAK.add(BREAK158);

                    // LeMaVM.g:530:15: ( IDENT )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==IDENT) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // LeMaVM.g:0:0: IDENT
                            {
                            IDENT159=(Token)match(input,IDENT,FOLLOW_IDENT_in_statement6474); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENT.add(IDENT159);


                            }
                            break;

                    }

                    SEMI160=(Token)match(input,SEMI,FOLLOW_SEMI_in_statement6477); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI160);



                    // AST REWRITE
                    // elements: IDENT, BREAK
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 530:77: -> ^( BREAK ( IDENT )? )
                    {
                        // LeMaVM.g:530:81: ^( BREAK ( IDENT )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_BREAK.nextNode(), root_1);

                        // LeMaVM.g:530:89: ( IDENT )?
                        if ( stream_IDENT.hasNext() ) {
                            adaptor.addChild(root_1, stream_IDENT.nextNode());

                        }
                        stream_IDENT.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // LeMaVM.g:531:9: CONTINUE ( IDENT )? SEMI
                    {
                    CONTINUE161=(Token)match(input,CONTINUE,FOLLOW_CONTINUE_in_statement6547); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONTINUE.add(CONTINUE161);

                    // LeMaVM.g:531:18: ( IDENT )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==IDENT) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // LeMaVM.g:0:0: IDENT
                            {
                            IDENT162=(Token)match(input,IDENT,FOLLOW_IDENT_in_statement6549); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENT.add(IDENT162);


                            }
                            break;

                    }

                    SEMI163=(Token)match(input,SEMI,FOLLOW_SEMI_in_statement6552); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI163);



                    // AST REWRITE
                    // elements: IDENT, CONTINUE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 531:77: -> ^( CONTINUE ( IDENT )? )
                    {
                        // LeMaVM.g:531:81: ^( CONTINUE ( IDENT )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_CONTINUE.nextNode(), root_1);

                        // LeMaVM.g:531:92: ( IDENT )?
                        if ( stream_IDENT.hasNext() ) {
                            adaptor.addChild(root_1, stream_IDENT.nextNode());

                        }
                        stream_IDENT.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // LeMaVM.g:532:9: IDENT COLON statement
                    {
                    IDENT164=(Token)match(input,IDENT,FOLLOW_IDENT_in_statement6619); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT164);

                    COLON165=(Token)match(input,COLON,FOLLOW_COLON_in_statement6621); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON165);

                    pushFollow(FOLLOW_statement_in_statement6623);
                    statement166=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement166.getTree());


                    // AST REWRITE
                    // elements: statement, IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 532:77: -> ^( LABELED_STATEMENT IDENT statement )
                    {
                        // LeMaVM.g:532:81: ^( LABELED_STATEMENT IDENT statement )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LABELED_STATEMENT, "LABELED_STATEMENT"), root_1);

                        adaptor.addChild(root_1, stream_IDENT.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // LeMaVM.g:533:9: expression SEMI
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_expression_in_statement6690);
                    expression167=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression167.getTree());
                    SEMI168=(Token)match(input,SEMI,FOLLOW_SEMI_in_statement6692); if (state.failed) return retval;

                    }
                    break;
                case 12 :
                    // LeMaVM.g:534:9: SEMI
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SEMI169=(Token)match(input,SEMI,FOLLOW_SEMI_in_statement6703); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMI169_tree = (CommonTree)adaptor.create(SEMI169);
                    adaptor.addChild(root_0, SEMI169_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class switchBlockLabels_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "switchBlockLabels"
    // LeMaVM.g:537:1: switchBlockLabels : switchCaseLabels ( switchDefaultLabel )? switchCaseLabels -> ^( SWITCH_BLOCK_LABEL_LIST switchCaseLabels ( switchDefaultLabel )? switchCaseLabels ) ;
    public final LeMaVMParser.switchBlockLabels_return switchBlockLabels() throws RecognitionException {
        LeMaVMParser.switchBlockLabels_return retval = new LeMaVMParser.switchBlockLabels_return();
        retval.start = input.LT(1);
        int switchBlockLabels_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.switchCaseLabels_return switchCaseLabels170 = null;

        LeMaVMParser.switchDefaultLabel_return switchDefaultLabel171 = null;

        LeMaVMParser.switchCaseLabels_return switchCaseLabels172 = null;


        RewriteRuleSubtreeStream stream_switchDefaultLabel=new RewriteRuleSubtreeStream(adaptor,"rule switchDefaultLabel");
        RewriteRuleSubtreeStream stream_switchCaseLabels=new RewriteRuleSubtreeStream(adaptor,"rule switchCaseLabels");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // LeMaVM.g:538:5: ( switchCaseLabels ( switchDefaultLabel )? switchCaseLabels -> ^( SWITCH_BLOCK_LABEL_LIST switchCaseLabels ( switchDefaultLabel )? switchCaseLabels ) )
            // LeMaVM.g:538:9: switchCaseLabels ( switchDefaultLabel )? switchCaseLabels
            {
            pushFollow(FOLLOW_switchCaseLabels_in_switchBlockLabels6734);
            switchCaseLabels170=switchCaseLabels();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_switchCaseLabels.add(switchCaseLabels170.getTree());
            // LeMaVM.g:538:26: ( switchDefaultLabel )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==DEFAULT) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // LeMaVM.g:0:0: switchDefaultLabel
                    {
                    pushFollow(FOLLOW_switchDefaultLabel_in_switchBlockLabels6736);
                    switchDefaultLabel171=switchDefaultLabel();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_switchDefaultLabel.add(switchDefaultLabel171.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_switchCaseLabels_in_switchBlockLabels6739);
            switchCaseLabels172=switchCaseLabels();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_switchCaseLabels.add(switchCaseLabels172.getTree());


            // AST REWRITE
            // elements: switchCaseLabels, switchCaseLabels, switchDefaultLabel
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 539:9: -> ^( SWITCH_BLOCK_LABEL_LIST switchCaseLabels ( switchDefaultLabel )? switchCaseLabels )
            {
                // LeMaVM.g:539:13: ^( SWITCH_BLOCK_LABEL_LIST switchCaseLabels ( switchDefaultLabel )? switchCaseLabels )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SWITCH_BLOCK_LABEL_LIST, "SWITCH_BLOCK_LABEL_LIST"), root_1);

                adaptor.addChild(root_1, stream_switchCaseLabels.nextTree());
                // LeMaVM.g:539:56: ( switchDefaultLabel )?
                if ( stream_switchDefaultLabel.hasNext() ) {
                    adaptor.addChild(root_1, stream_switchDefaultLabel.nextTree());

                }
                stream_switchDefaultLabel.reset();
                adaptor.addChild(root_1, stream_switchCaseLabels.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, switchBlockLabels_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "switchBlockLabels"

    public static class switchCaseLabels_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "switchCaseLabels"
    // LeMaVM.g:542:1: switchCaseLabels : ( switchCaseLabel )* ;
    public final LeMaVMParser.switchCaseLabels_return switchCaseLabels() throws RecognitionException {
        LeMaVMParser.switchCaseLabels_return retval = new LeMaVMParser.switchCaseLabels_return();
        retval.start = input.LT(1);
        int switchCaseLabels_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.switchCaseLabel_return switchCaseLabel173 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }
            // LeMaVM.g:543:5: ( ( switchCaseLabel )* )
            // LeMaVM.g:543:9: ( switchCaseLabel )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // LeMaVM.g:543:9: ( switchCaseLabel )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==CASE) ) {
                    int LA47_2 = input.LA(2);

                    if ( (synpred70_LeMaVM()) ) {
                        alt47=1;
                    }


                }


                switch (alt47) {
            	case 1 :
            	    // LeMaVM.g:0:0: switchCaseLabel
            	    {
            	    pushFollow(FOLLOW_switchCaseLabel_in_switchCaseLabels6784);
            	    switchCaseLabel173=switchCaseLabel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, switchCaseLabel173.getTree());

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 42, switchCaseLabels_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "switchCaseLabels"

    public static class switchCaseLabel_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "switchCaseLabel"
    // LeMaVM.g:546:1: switchCaseLabel : CASE expression COLON ( blockStatement )* ;
    public final LeMaVMParser.switchCaseLabel_return switchCaseLabel() throws RecognitionException {
        LeMaVMParser.switchCaseLabel_return retval = new LeMaVMParser.switchCaseLabel_return();
        retval.start = input.LT(1);
        int switchCaseLabel_StartIndex = input.index();
        CommonTree root_0 = null;

        Token CASE174=null;
        Token COLON176=null;
        LeMaVMParser.expression_return expression175 = null;

        LeMaVMParser.blockStatement_return blockStatement177 = null;


        CommonTree CASE174_tree=null;
        CommonTree COLON176_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }
            // LeMaVM.g:547:5: ( CASE expression COLON ( blockStatement )* )
            // LeMaVM.g:547:9: CASE expression COLON ( blockStatement )*
            {
            root_0 = (CommonTree)adaptor.nil();

            CASE174=(Token)match(input,CASE,FOLLOW_CASE_in_switchCaseLabel6812); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE174_tree = (CommonTree)adaptor.create(CASE174);
            root_0 = (CommonTree)adaptor.becomeRoot(CASE174_tree, root_0);
            }
            pushFollow(FOLLOW_expression_in_switchCaseLabel6815);
            expression175=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression175.getTree());
            COLON176=(Token)match(input,COLON,FOLLOW_COLON_in_switchCaseLabel6817); if (state.failed) return retval;
            // LeMaVM.g:547:33: ( blockStatement )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==DEC||LA48_0==INC||LA48_0==LCURLY||LA48_0==LOGICAL_NOT||(LA48_0>=LPAREN && LA48_0<=MINUS)||LA48_0==NOT||LA48_0==PLUS||LA48_0==SEMI||(LA48_0>=BOOLEAN && LA48_0<=BREAK)||(LA48_0>=CLASS && LA48_0<=CONTINUE)||(LA48_0>=DO && LA48_0<=DOUBLE)||(LA48_0>=FALSE && LA48_0<=IF)||(LA48_0>=INT && LA48_0<=NULL)||(LA48_0>=PRIVATE && LA48_0<=TRUE)||(LA48_0>=VOID && LA48_0<=WHILE)||(LA48_0>=IDENT && LA48_0<=STRING_LITERAL)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // LeMaVM.g:0:0: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_switchCaseLabel6820);
            	    blockStatement177=blockStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, blockStatement177.getTree());

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, switchCaseLabel_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "switchCaseLabel"

    public static class switchDefaultLabel_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "switchDefaultLabel"
    // LeMaVM.g:550:1: switchDefaultLabel : DEFAULT COLON ( blockStatement )* ;
    public final LeMaVMParser.switchDefaultLabel_return switchDefaultLabel() throws RecognitionException {
        LeMaVMParser.switchDefaultLabel_return retval = new LeMaVMParser.switchDefaultLabel_return();
        retval.start = input.LT(1);
        int switchDefaultLabel_StartIndex = input.index();
        CommonTree root_0 = null;

        Token DEFAULT178=null;
        Token COLON179=null;
        LeMaVMParser.blockStatement_return blockStatement180 = null;


        CommonTree DEFAULT178_tree=null;
        CommonTree COLON179_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }
            // LeMaVM.g:551:5: ( DEFAULT COLON ( blockStatement )* )
            // LeMaVM.g:551:9: DEFAULT COLON ( blockStatement )*
            {
            root_0 = (CommonTree)adaptor.nil();

            DEFAULT178=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_switchDefaultLabel6844); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFAULT178_tree = (CommonTree)adaptor.create(DEFAULT178);
            root_0 = (CommonTree)adaptor.becomeRoot(DEFAULT178_tree, root_0);
            }
            COLON179=(Token)match(input,COLON,FOLLOW_COLON_in_switchDefaultLabel6847); if (state.failed) return retval;
            // LeMaVM.g:551:25: ( blockStatement )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==DEC||LA49_0==INC||LA49_0==LCURLY||LA49_0==LOGICAL_NOT||(LA49_0>=LPAREN && LA49_0<=MINUS)||LA49_0==NOT||LA49_0==PLUS||LA49_0==SEMI||(LA49_0>=BOOLEAN && LA49_0<=BREAK)||(LA49_0>=CLASS && LA49_0<=CONTINUE)||(LA49_0>=DO && LA49_0<=DOUBLE)||(LA49_0>=FALSE && LA49_0<=IF)||(LA49_0>=INT && LA49_0<=NULL)||(LA49_0>=PRIVATE && LA49_0<=TRUE)||(LA49_0>=VOID && LA49_0<=WHILE)||(LA49_0>=IDENT && LA49_0<=STRING_LITERAL)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // LeMaVM.g:0:0: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_switchDefaultLabel6850);
            	    blockStatement180=blockStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, blockStatement180.getTree());

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, switchDefaultLabel_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "switchDefaultLabel"

    public static class forInit_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forInit"
    // LeMaVM.g:554:1: forInit : ( localVariableDeclaration -> ^( FOR_INIT localVariableDeclaration ) | expressionList -> ^( FOR_INIT expressionList ) | -> ^( FOR_INIT ) );
    public final LeMaVMParser.forInit_return forInit() throws RecognitionException {
        LeMaVMParser.forInit_return retval = new LeMaVMParser.forInit_return();
        retval.start = input.LT(1);
        int forInit_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.localVariableDeclaration_return localVariableDeclaration181 = null;

        LeMaVMParser.expressionList_return expressionList182 = null;


        RewriteRuleSubtreeStream stream_expressionList=new RewriteRuleSubtreeStream(adaptor,"rule expressionList");
        RewriteRuleSubtreeStream stream_localVariableDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule localVariableDeclaration");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }
            // LeMaVM.g:555:5: ( localVariableDeclaration -> ^( FOR_INIT localVariableDeclaration ) | expressionList -> ^( FOR_INIT expressionList ) | -> ^( FOR_INIT ) )
            int alt50=3;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // LeMaVM.g:555:9: localVariableDeclaration
                    {
                    pushFollow(FOLLOW_localVariableDeclaration_in_forInit6874);
                    localVariableDeclaration181=localVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_localVariableDeclaration.add(localVariableDeclaration181.getTree());


                    // AST REWRITE
                    // elements: localVariableDeclaration
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 555:37: -> ^( FOR_INIT localVariableDeclaration )
                    {
                        // LeMaVM.g:555:41: ^( FOR_INIT localVariableDeclaration )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOR_INIT, "FOR_INIT"), root_1);

                        adaptor.addChild(root_1, stream_localVariableDeclaration.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // LeMaVM.g:556:9: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_forInit6896);
                    expressionList182=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expressionList.add(expressionList182.getTree());


                    // AST REWRITE
                    // elements: expressionList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 556:37: -> ^( FOR_INIT expressionList )
                    {
                        // LeMaVM.g:556:41: ^( FOR_INIT expressionList )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOR_INIT, "FOR_INIT"), root_1);

                        adaptor.addChild(root_1, stream_expressionList.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // LeMaVM.g:557:37: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 557:37: -> ^( FOR_INIT )
                    {
                        // LeMaVM.g:557:41: ^( FOR_INIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOR_INIT, "FOR_INIT"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, forInit_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "forInit"

    public static class forCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forCondition"
    // LeMaVM.g:560:1: forCondition : ( expression )? -> ^( FOR_CONDITION ( expression )? ) ;
    public final LeMaVMParser.forCondition_return forCondition() throws RecognitionException {
        LeMaVMParser.forCondition_return retval = new LeMaVMParser.forCondition_return();
        retval.start = input.LT(1);
        int forCondition_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.expression_return expression183 = null;


        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }
            // LeMaVM.g:561:5: ( ( expression )? -> ^( FOR_CONDITION ( expression )? ) )
            // LeMaVM.g:561:9: ( expression )?
            {
            // LeMaVM.g:561:9: ( expression )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==DEC||LA51_0==INC||LA51_0==LOGICAL_NOT||(LA51_0>=LPAREN && LA51_0<=MINUS)||LA51_0==NOT||LA51_0==PLUS||LA51_0==BOOLEAN||LA51_0==DOUBLE||LA51_0==FALSE||(LA51_0>=INT && LA51_0<=NULL)||LA51_0==SHORT||(LA51_0>=STRING && LA51_0<=SUPER)||(LA51_0>=THIS && LA51_0<=TRUE)||LA51_0==VOID||(LA51_0>=IDENT && LA51_0<=STRING_LITERAL)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // LeMaVM.g:0:0: expression
                    {
                    pushFollow(FOLLOW_expression_in_forCondition6984);
                    expression183=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expression.add(expression183.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 562:9: -> ^( FOR_CONDITION ( expression )? )
            {
                // LeMaVM.g:562:13: ^( FOR_CONDITION ( expression )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOR_CONDITION, "FOR_CONDITION"), root_1);

                // LeMaVM.g:562:29: ( expression )?
                if ( stream_expression.hasNext() ) {
                    adaptor.addChild(root_1, stream_expression.nextTree());

                }
                stream_expression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 46, forCondition_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "forCondition"

    public static class forUpdater_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forUpdater"
    // LeMaVM.g:565:1: forUpdater : ( expressionList )? -> ^( FOR_UPDATE ( expressionList )? ) ;
    public final LeMaVMParser.forUpdater_return forUpdater() throws RecognitionException {
        LeMaVMParser.forUpdater_return retval = new LeMaVMParser.forUpdater_return();
        retval.start = input.LT(1);
        int forUpdater_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.expressionList_return expressionList184 = null;


        RewriteRuleSubtreeStream stream_expressionList=new RewriteRuleSubtreeStream(adaptor,"rule expressionList");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }
            // LeMaVM.g:566:5: ( ( expressionList )? -> ^( FOR_UPDATE ( expressionList )? ) )
            // LeMaVM.g:566:9: ( expressionList )?
            {
            // LeMaVM.g:566:9: ( expressionList )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==DEC||LA52_0==INC||LA52_0==LOGICAL_NOT||(LA52_0>=LPAREN && LA52_0<=MINUS)||LA52_0==NOT||LA52_0==PLUS||LA52_0==BOOLEAN||LA52_0==DOUBLE||LA52_0==FALSE||(LA52_0>=INT && LA52_0<=NULL)||LA52_0==SHORT||(LA52_0>=STRING && LA52_0<=SUPER)||(LA52_0>=THIS && LA52_0<=TRUE)||LA52_0==VOID||(LA52_0>=IDENT && LA52_0<=STRING_LITERAL)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // LeMaVM.g:0:0: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_forUpdater7026);
                    expressionList184=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expressionList.add(expressionList184.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: expressionList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 567:9: -> ^( FOR_UPDATE ( expressionList )? )
            {
                // LeMaVM.g:567:13: ^( FOR_UPDATE ( expressionList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FOR_UPDATE, "FOR_UPDATE"), root_1);

                // LeMaVM.g:567:26: ( expressionList )?
                if ( stream_expressionList.hasNext() ) {
                    adaptor.addChild(root_1, stream_expressionList.nextTree());

                }
                stream_expressionList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, forUpdater_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "forUpdater"

    public static class parenthesizedExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parenthesizedExpression"
    // LeMaVM.g:572:1: parenthesizedExpression : LPAREN expression RPAREN -> ^( PARENTESIZED_EXPR[$LPAREN, \"PARENTESIZED_EXPR\"] expression ) ;
    public final LeMaVMParser.parenthesizedExpression_return parenthesizedExpression() throws RecognitionException {
        LeMaVMParser.parenthesizedExpression_return retval = new LeMaVMParser.parenthesizedExpression_return();
        retval.start = input.LT(1);
        int parenthesizedExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LPAREN185=null;
        Token RPAREN187=null;
        LeMaVMParser.expression_return expression186 = null;


        CommonTree LPAREN185_tree=null;
        CommonTree RPAREN187_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }
            // LeMaVM.g:573:5: ( LPAREN expression RPAREN -> ^( PARENTESIZED_EXPR[$LPAREN, \"PARENTESIZED_EXPR\"] expression ) )
            // LeMaVM.g:573:9: LPAREN expression RPAREN
            {
            LPAREN185=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_parenthesizedExpression7066); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN185);

            pushFollow(FOLLOW_expression_in_parenthesizedExpression7068);
            expression186=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression186.getTree());
            RPAREN187=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_parenthesizedExpression7070); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN187);



            // AST REWRITE
            // elements: expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 574:9: -> ^( PARENTESIZED_EXPR[$LPAREN, \"PARENTESIZED_EXPR\"] expression )
            {
                // LeMaVM.g:574:13: ^( PARENTESIZED_EXPR[$LPAREN, \"PARENTESIZED_EXPR\"] expression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARENTESIZED_EXPR, LPAREN185, "PARENTESIZED_EXPR"), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 48, parenthesizedExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "parenthesizedExpression"

    public static class expressionList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expressionList"
    // LeMaVM.g:577:1: expressionList : expression ( COMMA expression )* ;
    public final LeMaVMParser.expressionList_return expressionList() throws RecognitionException {
        LeMaVMParser.expressionList_return retval = new LeMaVMParser.expressionList_return();
        retval.start = input.LT(1);
        int expressionList_StartIndex = input.index();
        CommonTree root_0 = null;

        Token COMMA189=null;
        LeMaVMParser.expression_return expression188 = null;

        LeMaVMParser.expression_return expression190 = null;


        CommonTree COMMA189_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }
            // LeMaVM.g:578:5: ( expression ( COMMA expression )* )
            // LeMaVM.g:578:9: expression ( COMMA expression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_expression_in_expressionList7111);
            expression188=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression188.getTree());
            // LeMaVM.g:578:20: ( COMMA expression )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==COMMA) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // LeMaVM.g:578:21: COMMA expression
            	    {
            	    COMMA189=(Token)match(input,COMMA,FOLLOW_COMMA_in_expressionList7114); if (state.failed) return retval;
            	    pushFollow(FOLLOW_expression_in_expressionList7117);
            	    expression190=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression190.getTree());

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, expressionList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expressionList"

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // LeMaVM.g:581:1: expression : assignmentExpression -> ^( EXPR assignmentExpression ) ;
    public final LeMaVMParser.expression_return expression() throws RecognitionException {
        LeMaVMParser.expression_return retval = new LeMaVMParser.expression_return();
        retval.start = input.LT(1);
        int expression_StartIndex = input.index();
        CommonTree root_0 = null;

        LeMaVMParser.assignmentExpression_return assignmentExpression191 = null;


        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }
            // LeMaVM.g:582:5: ( assignmentExpression -> ^( EXPR assignmentExpression ) )
            // LeMaVM.g:582:9: assignmentExpression
            {
            pushFollow(FOLLOW_assignmentExpression_in_expression7138);
            assignmentExpression191=assignmentExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_assignmentExpression.add(assignmentExpression191.getTree());


            // AST REWRITE
            // elements: assignmentExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 583:9: -> ^( EXPR assignmentExpression )
            {
                // LeMaVM.g:583:13: ^( EXPR assignmentExpression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR, "EXPR"), root_1);

                adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, expression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class assignmentExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentExpression"
    // LeMaVM.g:586:1: assignmentExpression : conditionalExpression ( ( ASSIGN | PLUS_ASSIGN | MINUS_ASSIGN | STAR_ASSIGN | DIV_ASSIGN | AND_ASSIGN | OR_ASSIGN | XOR_ASSIGN | MOD_ASSIGN ) assignmentExpression )? ;
    public final LeMaVMParser.assignmentExpression_return assignmentExpression() throws RecognitionException {
        LeMaVMParser.assignmentExpression_return retval = new LeMaVMParser.assignmentExpression_return();
        retval.start = input.LT(1);
        int assignmentExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token ASSIGN193=null;
        Token PLUS_ASSIGN194=null;
        Token MINUS_ASSIGN195=null;
        Token STAR_ASSIGN196=null;
        Token DIV_ASSIGN197=null;
        Token AND_ASSIGN198=null;
        Token OR_ASSIGN199=null;
        Token XOR_ASSIGN200=null;
        Token MOD_ASSIGN201=null;
        LeMaVMParser.conditionalExpression_return conditionalExpression192 = null;

        LeMaVMParser.assignmentExpression_return assignmentExpression202 = null;


        CommonTree ASSIGN193_tree=null;
        CommonTree PLUS_ASSIGN194_tree=null;
        CommonTree MINUS_ASSIGN195_tree=null;
        CommonTree STAR_ASSIGN196_tree=null;
        CommonTree DIV_ASSIGN197_tree=null;
        CommonTree AND_ASSIGN198_tree=null;
        CommonTree OR_ASSIGN199_tree=null;
        CommonTree XOR_ASSIGN200_tree=null;
        CommonTree MOD_ASSIGN201_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }
            // LeMaVM.g:587:5: ( conditionalExpression ( ( ASSIGN | PLUS_ASSIGN | MINUS_ASSIGN | STAR_ASSIGN | DIV_ASSIGN | AND_ASSIGN | OR_ASSIGN | XOR_ASSIGN | MOD_ASSIGN ) assignmentExpression )? )
            // LeMaVM.g:587:9: conditionalExpression ( ( ASSIGN | PLUS_ASSIGN | MINUS_ASSIGN | STAR_ASSIGN | DIV_ASSIGN | AND_ASSIGN | OR_ASSIGN | XOR_ASSIGN | MOD_ASSIGN ) assignmentExpression )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_conditionalExpression_in_assignmentExpression7174);
            conditionalExpression192=conditionalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, conditionalExpression192.getTree());
            // LeMaVM.g:588:9: ( ( ASSIGN | PLUS_ASSIGN | MINUS_ASSIGN | STAR_ASSIGN | DIV_ASSIGN | AND_ASSIGN | OR_ASSIGN | XOR_ASSIGN | MOD_ASSIGN ) assignmentExpression )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=AND_ASSIGN && LA55_0<=ASSIGN)||LA55_0==DIV_ASSIGN||LA55_0==MINUS_ASSIGN||LA55_0==MOD_ASSIGN||LA55_0==OR_ASSIGN||LA55_0==PLUS_ASSIGN||LA55_0==STAR_ASSIGN||LA55_0==XOR_ASSIGN) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // LeMaVM.g:588:13: ( ASSIGN | PLUS_ASSIGN | MINUS_ASSIGN | STAR_ASSIGN | DIV_ASSIGN | AND_ASSIGN | OR_ASSIGN | XOR_ASSIGN | MOD_ASSIGN ) assignmentExpression
                    {
                    // LeMaVM.g:588:13: ( ASSIGN | PLUS_ASSIGN | MINUS_ASSIGN | STAR_ASSIGN | DIV_ASSIGN | AND_ASSIGN | OR_ASSIGN | XOR_ASSIGN | MOD_ASSIGN )
                    int alt54=9;
                    switch ( input.LA(1) ) {
                    case ASSIGN:
                        {
                        alt54=1;
                        }
                        break;
                    case PLUS_ASSIGN:
                        {
                        alt54=2;
                        }
                        break;
                    case MINUS_ASSIGN:
                        {
                        alt54=3;
                        }
                        break;
                    case STAR_ASSIGN:
                        {
                        alt54=4;
                        }
                        break;
                    case DIV_ASSIGN:
                        {
                        alt54=5;
                        }
                        break;
                    case AND_ASSIGN:
                        {
                        alt54=6;
                        }
                        break;
                    case OR_ASSIGN:
                        {
                        alt54=7;
                        }
                        break;
                    case XOR_ASSIGN:
                        {
                        alt54=8;
                        }
                        break;
                    case MOD_ASSIGN:
                        {
                        alt54=9;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 0, input);

                        throw nvae;
                    }

                    switch (alt54) {
                        case 1 :
                            // LeMaVM.g:588:17: ASSIGN
                            {
                            ASSIGN193=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignmentExpression7193); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASSIGN193_tree = (CommonTree)adaptor.create(ASSIGN193);
                            root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN193_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // LeMaVM.g:589:17: PLUS_ASSIGN
                            {
                            PLUS_ASSIGN194=(Token)match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_assignmentExpression7212); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            PLUS_ASSIGN194_tree = (CommonTree)adaptor.create(PLUS_ASSIGN194);
                            root_0 = (CommonTree)adaptor.becomeRoot(PLUS_ASSIGN194_tree, root_0);
                            }

                            }
                            break;
                        case 3 :
                            // LeMaVM.g:590:17: MINUS_ASSIGN
                            {
                            MINUS_ASSIGN195=(Token)match(input,MINUS_ASSIGN,FOLLOW_MINUS_ASSIGN_in_assignmentExpression7231); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            MINUS_ASSIGN195_tree = (CommonTree)adaptor.create(MINUS_ASSIGN195);
                            root_0 = (CommonTree)adaptor.becomeRoot(MINUS_ASSIGN195_tree, root_0);
                            }

                            }
                            break;
                        case 4 :
                            // LeMaVM.g:591:17: STAR_ASSIGN
                            {
                            STAR_ASSIGN196=(Token)match(input,STAR_ASSIGN,FOLLOW_STAR_ASSIGN_in_assignmentExpression7250); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            STAR_ASSIGN196_tree = (CommonTree)adaptor.create(STAR_ASSIGN196);
                            root_0 = (CommonTree)adaptor.becomeRoot(STAR_ASSIGN196_tree, root_0);
                            }

                            }
                            break;
                        case 5 :
                            // LeMaVM.g:592:17: DIV_ASSIGN
                            {
                            DIV_ASSIGN197=(Token)match(input,DIV_ASSIGN,FOLLOW_DIV_ASSIGN_in_assignmentExpression7269); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DIV_ASSIGN197_tree = (CommonTree)adaptor.create(DIV_ASSIGN197);
                            root_0 = (CommonTree)adaptor.becomeRoot(DIV_ASSIGN197_tree, root_0);
                            }

                            }
                            break;
                        case 6 :
                            // LeMaVM.g:593:17: AND_ASSIGN
                            {
                            AND_ASSIGN198=(Token)match(input,AND_ASSIGN,FOLLOW_AND_ASSIGN_in_assignmentExpression7288); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            AND_ASSIGN198_tree = (CommonTree)adaptor.create(AND_ASSIGN198);
                            root_0 = (CommonTree)adaptor.becomeRoot(AND_ASSIGN198_tree, root_0);
                            }

                            }
                            break;
                        case 7 :
                            // LeMaVM.g:594:17: OR_ASSIGN
                            {
                            OR_ASSIGN199=(Token)match(input,OR_ASSIGN,FOLLOW_OR_ASSIGN_in_assignmentExpression7307); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OR_ASSIGN199_tree = (CommonTree)adaptor.create(OR_ASSIGN199);
                            root_0 = (CommonTree)adaptor.becomeRoot(OR_ASSIGN199_tree, root_0);
                            }

                            }
                            break;
                        case 8 :
                            // LeMaVM.g:595:17: XOR_ASSIGN
                            {
                            XOR_ASSIGN200=(Token)match(input,XOR_ASSIGN,FOLLOW_XOR_ASSIGN_in_assignmentExpression7326); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            XOR_ASSIGN200_tree = (CommonTree)adaptor.create(XOR_ASSIGN200);
                            root_0 = (CommonTree)adaptor.becomeRoot(XOR_ASSIGN200_tree, root_0);
                            }

                            }
                            break;
                        case 9 :
                            // LeMaVM.g:596:17: MOD_ASSIGN
                            {
                            MOD_ASSIGN201=(Token)match(input,MOD_ASSIGN,FOLLOW_MOD_ASSIGN_in_assignmentExpression7345); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            MOD_ASSIGN201_tree = (CommonTree)adaptor.create(MOD_ASSIGN201);
                            root_0 = (CommonTree)adaptor.becomeRoot(MOD_ASSIGN201_tree, root_0);
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_assignmentExpression_in_assignmentExpression7367);
                    assignmentExpression202=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentExpression202.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, assignmentExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "assignmentExpression"

    public static class conditionalExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditionalExpression"
    // LeMaVM.g:601:1: conditionalExpression : logicalOrExpression ( QUESTION assignmentExpression COLON conditionalExpression )? ;
    public final LeMaVMParser.conditionalExpression_return conditionalExpression() throws RecognitionException {
        LeMaVMParser.conditionalExpression_return retval = new LeMaVMParser.conditionalExpression_return();
        retval.start = input.LT(1);
        int conditionalExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token QUESTION204=null;
        Token COLON206=null;
        LeMaVMParser.logicalOrExpression_return logicalOrExpression203 = null;

        LeMaVMParser.assignmentExpression_return assignmentExpression205 = null;

        LeMaVMParser.conditionalExpression_return conditionalExpression207 = null;


        CommonTree QUESTION204_tree=null;
        CommonTree COLON206_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }
            // LeMaVM.g:602:5: ( logicalOrExpression ( QUESTION assignmentExpression COLON conditionalExpression )? )
            // LeMaVM.g:602:9: logicalOrExpression ( QUESTION assignmentExpression COLON conditionalExpression )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalOrExpression_in_conditionalExpression7392);
            logicalOrExpression203=logicalOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalOrExpression203.getTree());
            // LeMaVM.g:602:29: ( QUESTION assignmentExpression COLON conditionalExpression )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==QUESTION) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // LeMaVM.g:602:30: QUESTION assignmentExpression COLON conditionalExpression
                    {
                    QUESTION204=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_conditionalExpression7395); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUESTION204_tree = (CommonTree)adaptor.create(QUESTION204);
                    root_0 = (CommonTree)adaptor.becomeRoot(QUESTION204_tree, root_0);
                    }
                    pushFollow(FOLLOW_assignmentExpression_in_conditionalExpression7398);
                    assignmentExpression205=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentExpression205.getTree());
                    COLON206=(Token)match(input,COLON,FOLLOW_COLON_in_conditionalExpression7400); if (state.failed) return retval;
                    pushFollow(FOLLOW_conditionalExpression_in_conditionalExpression7403);
                    conditionalExpression207=conditionalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conditionalExpression207.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, conditionalExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "conditionalExpression"

    public static class logicalOrExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalOrExpression"
    // LeMaVM.g:605:1: logicalOrExpression : logicalAndExpression ( LOGICAL_OR logicalAndExpression )* ;
    public final LeMaVMParser.logicalOrExpression_return logicalOrExpression() throws RecognitionException {
        LeMaVMParser.logicalOrExpression_return retval = new LeMaVMParser.logicalOrExpression_return();
        retval.start = input.LT(1);
        int logicalOrExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LOGICAL_OR209=null;
        LeMaVMParser.logicalAndExpression_return logicalAndExpression208 = null;

        LeMaVMParser.logicalAndExpression_return logicalAndExpression210 = null;


        CommonTree LOGICAL_OR209_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }
            // LeMaVM.g:606:5: ( logicalAndExpression ( LOGICAL_OR logicalAndExpression )* )
            // LeMaVM.g:606:9: logicalAndExpression ( LOGICAL_OR logicalAndExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_logicalAndExpression_in_logicalOrExpression7424);
            logicalAndExpression208=logicalAndExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalAndExpression208.getTree());
            // LeMaVM.g:606:30: ( LOGICAL_OR logicalAndExpression )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==LOGICAL_OR) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // LeMaVM.g:606:31: LOGICAL_OR logicalAndExpression
            	    {
            	    LOGICAL_OR209=(Token)match(input,LOGICAL_OR,FOLLOW_LOGICAL_OR_in_logicalOrExpression7427); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    LOGICAL_OR209_tree = (CommonTree)adaptor.create(LOGICAL_OR209);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LOGICAL_OR209_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_logicalAndExpression_in_logicalOrExpression7430);
            	    logicalAndExpression210=logicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalAndExpression210.getTree());

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, logicalOrExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "logicalOrExpression"

    public static class logicalAndExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalAndExpression"
    // LeMaVM.g:609:1: logicalAndExpression : inclusiveOrExpression ( LOGICAL_AND inclusiveOrExpression )* ;
    public final LeMaVMParser.logicalAndExpression_return logicalAndExpression() throws RecognitionException {
        LeMaVMParser.logicalAndExpression_return retval = new LeMaVMParser.logicalAndExpression_return();
        retval.start = input.LT(1);
        int logicalAndExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LOGICAL_AND212=null;
        LeMaVMParser.inclusiveOrExpression_return inclusiveOrExpression211 = null;

        LeMaVMParser.inclusiveOrExpression_return inclusiveOrExpression213 = null;


        CommonTree LOGICAL_AND212_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }
            // LeMaVM.g:610:5: ( inclusiveOrExpression ( LOGICAL_AND inclusiveOrExpression )* )
            // LeMaVM.g:610:9: inclusiveOrExpression ( LOGICAL_AND inclusiveOrExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_inclusiveOrExpression_in_logicalAndExpression7451);
            inclusiveOrExpression211=inclusiveOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, inclusiveOrExpression211.getTree());
            // LeMaVM.g:610:31: ( LOGICAL_AND inclusiveOrExpression )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==LOGICAL_AND) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // LeMaVM.g:610:32: LOGICAL_AND inclusiveOrExpression
            	    {
            	    LOGICAL_AND212=(Token)match(input,LOGICAL_AND,FOLLOW_LOGICAL_AND_in_logicalAndExpression7454); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    LOGICAL_AND212_tree = (CommonTree)adaptor.create(LOGICAL_AND212);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LOGICAL_AND212_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_inclusiveOrExpression_in_logicalAndExpression7457);
            	    inclusiveOrExpression213=inclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, inclusiveOrExpression213.getTree());

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 54, logicalAndExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "logicalAndExpression"

    public static class inclusiveOrExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inclusiveOrExpression"
    // LeMaVM.g:613:1: inclusiveOrExpression : exclusiveOrExpression ( OR exclusiveOrExpression )* ;
    public final LeMaVMParser.inclusiveOrExpression_return inclusiveOrExpression() throws RecognitionException {
        LeMaVMParser.inclusiveOrExpression_return retval = new LeMaVMParser.inclusiveOrExpression_return();
        retval.start = input.LT(1);
        int inclusiveOrExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token OR215=null;
        LeMaVMParser.exclusiveOrExpression_return exclusiveOrExpression214 = null;

        LeMaVMParser.exclusiveOrExpression_return exclusiveOrExpression216 = null;


        CommonTree OR215_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }
            // LeMaVM.g:614:5: ( exclusiveOrExpression ( OR exclusiveOrExpression )* )
            // LeMaVM.g:614:9: exclusiveOrExpression ( OR exclusiveOrExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression7478);
            exclusiveOrExpression214=exclusiveOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exclusiveOrExpression214.getTree());
            // LeMaVM.g:614:31: ( OR exclusiveOrExpression )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==OR) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // LeMaVM.g:614:32: OR exclusiveOrExpression
            	    {
            	    OR215=(Token)match(input,OR,FOLLOW_OR_in_inclusiveOrExpression7481); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR215_tree = (CommonTree)adaptor.create(OR215);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR215_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression7484);
            	    exclusiveOrExpression216=exclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exclusiveOrExpression216.getTree());

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, inclusiveOrExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "inclusiveOrExpression"

    public static class exclusiveOrExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exclusiveOrExpression"
    // LeMaVM.g:617:1: exclusiveOrExpression : andExpression ( XOR andExpression )* ;
    public final LeMaVMParser.exclusiveOrExpression_return exclusiveOrExpression() throws RecognitionException {
        LeMaVMParser.exclusiveOrExpression_return retval = new LeMaVMParser.exclusiveOrExpression_return();
        retval.start = input.LT(1);
        int exclusiveOrExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token XOR218=null;
        LeMaVMParser.andExpression_return andExpression217 = null;

        LeMaVMParser.andExpression_return andExpression219 = null;


        CommonTree XOR218_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }
            // LeMaVM.g:618:5: ( andExpression ( XOR andExpression )* )
            // LeMaVM.g:618:9: andExpression ( XOR andExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression7505);
            andExpression217=andExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpression217.getTree());
            // LeMaVM.g:618:23: ( XOR andExpression )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==XOR) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // LeMaVM.g:618:24: XOR andExpression
            	    {
            	    XOR218=(Token)match(input,XOR,FOLLOW_XOR_in_exclusiveOrExpression7508); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    XOR218_tree = (CommonTree)adaptor.create(XOR218);
            	    root_0 = (CommonTree)adaptor.becomeRoot(XOR218_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression7511);
            	    andExpression219=andExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpression219.getTree());

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 56, exclusiveOrExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "exclusiveOrExpression"

    public static class andExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpression"
    // LeMaVM.g:621:1: andExpression : equalityExpression ( AND equalityExpression )* ;
    public final LeMaVMParser.andExpression_return andExpression() throws RecognitionException {
        LeMaVMParser.andExpression_return retval = new LeMaVMParser.andExpression_return();
        retval.start = input.LT(1);
        int andExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token AND221=null;
        LeMaVMParser.equalityExpression_return equalityExpression220 = null;

        LeMaVMParser.equalityExpression_return equalityExpression222 = null;


        CommonTree AND221_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }
            // LeMaVM.g:622:5: ( equalityExpression ( AND equalityExpression )* )
            // LeMaVM.g:622:9: equalityExpression ( AND equalityExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_equalityExpression_in_andExpression7532);
            equalityExpression220=equalityExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, equalityExpression220.getTree());
            // LeMaVM.g:622:28: ( AND equalityExpression )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==AND) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // LeMaVM.g:622:29: AND equalityExpression
            	    {
            	    AND221=(Token)match(input,AND,FOLLOW_AND_in_andExpression7535); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND221_tree = (CommonTree)adaptor.create(AND221);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND221_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_equalityExpression_in_andExpression7538);
            	    equalityExpression222=equalityExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, equalityExpression222.getTree());

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, andExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "andExpression"

    public static class equalityExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equalityExpression"
    // LeMaVM.g:625:1: equalityExpression : instanceOfExpression ( ( EQUAL | NOT_EQUAL ) instanceOfExpression )* ;
    public final LeMaVMParser.equalityExpression_return equalityExpression() throws RecognitionException {
        LeMaVMParser.equalityExpression_return retval = new LeMaVMParser.equalityExpression_return();
        retval.start = input.LT(1);
        int equalityExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token EQUAL224=null;
        Token NOT_EQUAL225=null;
        LeMaVMParser.instanceOfExpression_return instanceOfExpression223 = null;

        LeMaVMParser.instanceOfExpression_return instanceOfExpression226 = null;


        CommonTree EQUAL224_tree=null;
        CommonTree NOT_EQUAL225_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }
            // LeMaVM.g:626:5: ( instanceOfExpression ( ( EQUAL | NOT_EQUAL ) instanceOfExpression )* )
            // LeMaVM.g:626:9: instanceOfExpression ( ( EQUAL | NOT_EQUAL ) instanceOfExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_instanceOfExpression_in_equalityExpression7559);
            instanceOfExpression223=instanceOfExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, instanceOfExpression223.getTree());
            // LeMaVM.g:627:9: ( ( EQUAL | NOT_EQUAL ) instanceOfExpression )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==EQUAL||LA63_0==NOT_EQUAL) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // LeMaVM.g:627:13: ( EQUAL | NOT_EQUAL ) instanceOfExpression
            	    {
            	    // LeMaVM.g:627:13: ( EQUAL | NOT_EQUAL )
            	    int alt62=2;
            	    int LA62_0 = input.LA(1);

            	    if ( (LA62_0==EQUAL) ) {
            	        alt62=1;
            	    }
            	    else if ( (LA62_0==NOT_EQUAL) ) {
            	        alt62=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 62, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt62) {
            	        case 1 :
            	            // LeMaVM.g:627:17: EQUAL
            	            {
            	            EQUAL224=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_equalityExpression7578); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            EQUAL224_tree = (CommonTree)adaptor.create(EQUAL224);
            	            root_0 = (CommonTree)adaptor.becomeRoot(EQUAL224_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // LeMaVM.g:628:17: NOT_EQUAL
            	            {
            	            NOT_EQUAL225=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_equalityExpression7597); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            NOT_EQUAL225_tree = (CommonTree)adaptor.create(NOT_EQUAL225);
            	            root_0 = (CommonTree)adaptor.becomeRoot(NOT_EQUAL225_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_instanceOfExpression_in_equalityExpression7627);
            	    instanceOfExpression226=instanceOfExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, instanceOfExpression226.getTree());

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 58, equalityExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "equalityExpression"

    public static class instanceOfExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instanceOfExpression"
    // LeMaVM.g:634:1: instanceOfExpression : relationalExpression ( INSTANCEOF type )? ;
    public final LeMaVMParser.instanceOfExpression_return instanceOfExpression() throws RecognitionException {
        LeMaVMParser.instanceOfExpression_return retval = new LeMaVMParser.instanceOfExpression_return();
        retval.start = input.LT(1);
        int instanceOfExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token INSTANCEOF228=null;
        LeMaVMParser.relationalExpression_return relationalExpression227 = null;

        LeMaVMParser.type_return type229 = null;


        CommonTree INSTANCEOF228_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }
            // LeMaVM.g:635:5: ( relationalExpression ( INSTANCEOF type )? )
            // LeMaVM.g:635:9: relationalExpression ( INSTANCEOF type )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_instanceOfExpression7657);
            relationalExpression227=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression227.getTree());
            // LeMaVM.g:635:30: ( INSTANCEOF type )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==INSTANCEOF) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // LeMaVM.g:635:31: INSTANCEOF type
                    {
                    INSTANCEOF228=(Token)match(input,INSTANCEOF,FOLLOW_INSTANCEOF_in_instanceOfExpression7660); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INSTANCEOF228_tree = (CommonTree)adaptor.create(INSTANCEOF228);
                    root_0 = (CommonTree)adaptor.becomeRoot(INSTANCEOF228_tree, root_0);
                    }
                    pushFollow(FOLLOW_type_in_instanceOfExpression7663);
                    type229=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type229.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, instanceOfExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "instanceOfExpression"

    public static class relationalExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationalExpression"
    // LeMaVM.g:638:1: relationalExpression : shiftExpression ( ( LESS_OR_EQUAL | GREATER_OR_EQUAL | LESS_THAN | GREATER_THAN ) shiftExpression )* ;
    public final LeMaVMParser.relationalExpression_return relationalExpression() throws RecognitionException {
        LeMaVMParser.relationalExpression_return retval = new LeMaVMParser.relationalExpression_return();
        retval.start = input.LT(1);
        int relationalExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LESS_OR_EQUAL231=null;
        Token GREATER_OR_EQUAL232=null;
        Token LESS_THAN233=null;
        Token GREATER_THAN234=null;
        LeMaVMParser.shiftExpression_return shiftExpression230 = null;

        LeMaVMParser.shiftExpression_return shiftExpression235 = null;


        CommonTree LESS_OR_EQUAL231_tree=null;
        CommonTree GREATER_OR_EQUAL232_tree=null;
        CommonTree LESS_THAN233_tree=null;
        CommonTree GREATER_THAN234_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }
            // LeMaVM.g:639:5: ( shiftExpression ( ( LESS_OR_EQUAL | GREATER_OR_EQUAL | LESS_THAN | GREATER_THAN ) shiftExpression )* )
            // LeMaVM.g:639:9: shiftExpression ( ( LESS_OR_EQUAL | GREATER_OR_EQUAL | LESS_THAN | GREATER_THAN ) shiftExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_shiftExpression_in_relationalExpression7684);
            shiftExpression230=shiftExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, shiftExpression230.getTree());
            // LeMaVM.g:640:9: ( ( LESS_OR_EQUAL | GREATER_OR_EQUAL | LESS_THAN | GREATER_THAN ) shiftExpression )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( ((LA66_0>=GREATER_OR_EQUAL && LA66_0<=GREATER_THAN)||(LA66_0>=LESS_OR_EQUAL && LA66_0<=LESS_THAN)) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // LeMaVM.g:640:13: ( LESS_OR_EQUAL | GREATER_OR_EQUAL | LESS_THAN | GREATER_THAN ) shiftExpression
            	    {
            	    // LeMaVM.g:640:13: ( LESS_OR_EQUAL | GREATER_OR_EQUAL | LESS_THAN | GREATER_THAN )
            	    int alt65=4;
            	    switch ( input.LA(1) ) {
            	    case LESS_OR_EQUAL:
            	        {
            	        alt65=1;
            	        }
            	        break;
            	    case GREATER_OR_EQUAL:
            	        {
            	        alt65=2;
            	        }
            	        break;
            	    case LESS_THAN:
            	        {
            	        alt65=3;
            	        }
            	        break;
            	    case GREATER_THAN:
            	        {
            	        alt65=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 65, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt65) {
            	        case 1 :
            	            // LeMaVM.g:640:17: LESS_OR_EQUAL
            	            {
            	            LESS_OR_EQUAL231=(Token)match(input,LESS_OR_EQUAL,FOLLOW_LESS_OR_EQUAL_in_relationalExpression7703); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            LESS_OR_EQUAL231_tree = (CommonTree)adaptor.create(LESS_OR_EQUAL231);
            	            root_0 = (CommonTree)adaptor.becomeRoot(LESS_OR_EQUAL231_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // LeMaVM.g:641:17: GREATER_OR_EQUAL
            	            {
            	            GREATER_OR_EQUAL232=(Token)match(input,GREATER_OR_EQUAL,FOLLOW_GREATER_OR_EQUAL_in_relationalExpression7722); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            GREATER_OR_EQUAL232_tree = (CommonTree)adaptor.create(GREATER_OR_EQUAL232);
            	            root_0 = (CommonTree)adaptor.becomeRoot(GREATER_OR_EQUAL232_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // LeMaVM.g:642:17: LESS_THAN
            	            {
            	            LESS_THAN233=(Token)match(input,LESS_THAN,FOLLOW_LESS_THAN_in_relationalExpression7741); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            LESS_THAN233_tree = (CommonTree)adaptor.create(LESS_THAN233);
            	            root_0 = (CommonTree)adaptor.becomeRoot(LESS_THAN233_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // LeMaVM.g:643:17: GREATER_THAN
            	            {
            	            GREATER_THAN234=(Token)match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_relationalExpression7760); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            GREATER_THAN234_tree = (CommonTree)adaptor.create(GREATER_THAN234);
            	            root_0 = (CommonTree)adaptor.becomeRoot(GREATER_THAN234_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression7789);
            	    shiftExpression235=shiftExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, shiftExpression235.getTree());

            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 60, relationalExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "relationalExpression"

    public static class shiftExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shiftExpression"
    // LeMaVM.g:649:1: shiftExpression : additiveExpression ( ( BIT_SHIFT_RIGHT | SHIFT_RIGHT | SHIFT_LEFT ) additiveExpression )* ;
    public final LeMaVMParser.shiftExpression_return shiftExpression() throws RecognitionException {
        LeMaVMParser.shiftExpression_return retval = new LeMaVMParser.shiftExpression_return();
        retval.start = input.LT(1);
        int shiftExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token BIT_SHIFT_RIGHT237=null;
        Token SHIFT_RIGHT238=null;
        Token SHIFT_LEFT239=null;
        LeMaVMParser.additiveExpression_return additiveExpression236 = null;

        LeMaVMParser.additiveExpression_return additiveExpression240 = null;


        CommonTree BIT_SHIFT_RIGHT237_tree=null;
        CommonTree SHIFT_RIGHT238_tree=null;
        CommonTree SHIFT_LEFT239_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }
            // LeMaVM.g:650:5: ( additiveExpression ( ( BIT_SHIFT_RIGHT | SHIFT_RIGHT | SHIFT_LEFT ) additiveExpression )* )
            // LeMaVM.g:650:9: additiveExpression ( ( BIT_SHIFT_RIGHT | SHIFT_RIGHT | SHIFT_LEFT ) additiveExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_shiftExpression7823);
            additiveExpression236=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression236.getTree());
            // LeMaVM.g:651:9: ( ( BIT_SHIFT_RIGHT | SHIFT_RIGHT | SHIFT_LEFT ) additiveExpression )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==BIT_SHIFT_RIGHT||LA68_0==SHIFT_LEFT||LA68_0==SHIFT_RIGHT) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // LeMaVM.g:651:13: ( BIT_SHIFT_RIGHT | SHIFT_RIGHT | SHIFT_LEFT ) additiveExpression
            	    {
            	    // LeMaVM.g:651:13: ( BIT_SHIFT_RIGHT | SHIFT_RIGHT | SHIFT_LEFT )
            	    int alt67=3;
            	    switch ( input.LA(1) ) {
            	    case BIT_SHIFT_RIGHT:
            	        {
            	        alt67=1;
            	        }
            	        break;
            	    case SHIFT_RIGHT:
            	        {
            	        alt67=2;
            	        }
            	        break;
            	    case SHIFT_LEFT:
            	        {
            	        alt67=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 67, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt67) {
            	        case 1 :
            	            // LeMaVM.g:651:17: BIT_SHIFT_RIGHT
            	            {
            	            BIT_SHIFT_RIGHT237=(Token)match(input,BIT_SHIFT_RIGHT,FOLLOW_BIT_SHIFT_RIGHT_in_shiftExpression7841); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            BIT_SHIFT_RIGHT237_tree = (CommonTree)adaptor.create(BIT_SHIFT_RIGHT237);
            	            root_0 = (CommonTree)adaptor.becomeRoot(BIT_SHIFT_RIGHT237_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // LeMaVM.g:652:17: SHIFT_RIGHT
            	            {
            	            SHIFT_RIGHT238=(Token)match(input,SHIFT_RIGHT,FOLLOW_SHIFT_RIGHT_in_shiftExpression7860); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SHIFT_RIGHT238_tree = (CommonTree)adaptor.create(SHIFT_RIGHT238);
            	            root_0 = (CommonTree)adaptor.becomeRoot(SHIFT_RIGHT238_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // LeMaVM.g:653:17: SHIFT_LEFT
            	            {
            	            SHIFT_LEFT239=(Token)match(input,SHIFT_LEFT,FOLLOW_SHIFT_LEFT_in_shiftExpression7879); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SHIFT_LEFT239_tree = (CommonTree)adaptor.create(SHIFT_LEFT239);
            	            root_0 = (CommonTree)adaptor.becomeRoot(SHIFT_LEFT239_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression7908);
            	    additiveExpression240=additiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression240.getTree());

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, shiftExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "shiftExpression"

    public static class additiveExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "additiveExpression"
    // LeMaVM.g:659:1: additiveExpression : multiplicativeExpression ( ( PLUS | MINUS ) multiplicativeExpression )* ;
    public final LeMaVMParser.additiveExpression_return additiveExpression() throws RecognitionException {
        LeMaVMParser.additiveExpression_return retval = new LeMaVMParser.additiveExpression_return();
        retval.start = input.LT(1);
        int additiveExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token PLUS242=null;
        Token MINUS243=null;
        LeMaVMParser.multiplicativeExpression_return multiplicativeExpression241 = null;

        LeMaVMParser.multiplicativeExpression_return multiplicativeExpression244 = null;


        CommonTree PLUS242_tree=null;
        CommonTree MINUS243_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }
            // LeMaVM.g:660:5: ( multiplicativeExpression ( ( PLUS | MINUS ) multiplicativeExpression )* )
            // LeMaVM.g:660:9: multiplicativeExpression ( ( PLUS | MINUS ) multiplicativeExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression7938);
            multiplicativeExpression241=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression241.getTree());
            // LeMaVM.g:661:9: ( ( PLUS | MINUS ) multiplicativeExpression )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==MINUS||LA70_0==PLUS) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // LeMaVM.g:661:13: ( PLUS | MINUS ) multiplicativeExpression
            	    {
            	    // LeMaVM.g:661:13: ( PLUS | MINUS )
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( (LA69_0==PLUS) ) {
            	        alt69=1;
            	    }
            	    else if ( (LA69_0==MINUS) ) {
            	        alt69=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 69, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // LeMaVM.g:661:17: PLUS
            	            {
            	            PLUS242=(Token)match(input,PLUS,FOLLOW_PLUS_in_additiveExpression7956); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS242_tree = (CommonTree)adaptor.create(PLUS242);
            	            root_0 = (CommonTree)adaptor.becomeRoot(PLUS242_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // LeMaVM.g:662:17: MINUS
            	            {
            	            MINUS243=(Token)match(input,MINUS,FOLLOW_MINUS_in_additiveExpression7975); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS243_tree = (CommonTree)adaptor.create(MINUS243);
            	            root_0 = (CommonTree)adaptor.becomeRoot(MINUS243_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression8004);
            	    multiplicativeExpression244=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression244.getTree());

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 62, additiveExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "additiveExpression"

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiplicativeExpression"
    // LeMaVM.g:668:1: multiplicativeExpression : unaryExpression ( ( STAR | DIV | MOD ) unaryExpression )* ;
    public final LeMaVMParser.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        LeMaVMParser.multiplicativeExpression_return retval = new LeMaVMParser.multiplicativeExpression_return();
        retval.start = input.LT(1);
        int multiplicativeExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token STAR246=null;
        Token DIV247=null;
        Token MOD248=null;
        LeMaVMParser.unaryExpression_return unaryExpression245 = null;

        LeMaVMParser.unaryExpression_return unaryExpression249 = null;


        CommonTree STAR246_tree=null;
        CommonTree DIV247_tree=null;
        CommonTree MOD248_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }
            // LeMaVM.g:669:5: ( unaryExpression ( ( STAR | DIV | MOD ) unaryExpression )* )
            // LeMaVM.g:669:9: unaryExpression ( ( STAR | DIV | MOD ) unaryExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression8034);
            unaryExpression245=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression245.getTree());
            // LeMaVM.g:670:9: ( ( STAR | DIV | MOD ) unaryExpression )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==DIV||LA72_0==MOD||LA72_0==STAR) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // LeMaVM.g:670:13: ( STAR | DIV | MOD ) unaryExpression
            	    {
            	    // LeMaVM.g:670:13: ( STAR | DIV | MOD )
            	    int alt71=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt71=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt71=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt71=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 71, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt71) {
            	        case 1 :
            	            // LeMaVM.g:670:17: STAR
            	            {
            	            STAR246=(Token)match(input,STAR,FOLLOW_STAR_in_multiplicativeExpression8053); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            STAR246_tree = (CommonTree)adaptor.create(STAR246);
            	            root_0 = (CommonTree)adaptor.becomeRoot(STAR246_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // LeMaVM.g:671:17: DIV
            	            {
            	            DIV247=(Token)match(input,DIV,FOLLOW_DIV_in_multiplicativeExpression8072); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DIV247_tree = (CommonTree)adaptor.create(DIV247);
            	            root_0 = (CommonTree)adaptor.becomeRoot(DIV247_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // LeMaVM.g:672:17: MOD
            	            {
            	            MOD248=(Token)match(input,MOD,FOLLOW_MOD_in_multiplicativeExpression8091); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MOD248_tree = (CommonTree)adaptor.create(MOD248);
            	            root_0 = (CommonTree)adaptor.becomeRoot(MOD248_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression8120);
            	    unaryExpression249=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression249.getTree());

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, multiplicativeExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "multiplicativeExpression"

    public static class unaryExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpression"
    // LeMaVM.g:678:1: unaryExpression : ( PLUS unaryExpression -> ^( UNARY_PLUS[$PLUS, \"UNARY_PLUS\"] unaryExpression ) | MINUS unaryExpression -> ^( UNARY_MINUS[$MINUS, \"UNARY_MINUS\"] unaryExpression ) | INC postfixedExpression -> ^( PRE_INC[$INC, \"PRE_INC\"] postfixedExpression ) | DEC postfixedExpression -> ^( PRE_DEC[$DEC, \"PRE_DEC\"] postfixedExpression ) | unaryExpressionNotPlusMinus );
    public final LeMaVMParser.unaryExpression_return unaryExpression() throws RecognitionException {
        LeMaVMParser.unaryExpression_return retval = new LeMaVMParser.unaryExpression_return();
        retval.start = input.LT(1);
        int unaryExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token PLUS250=null;
        Token MINUS252=null;
        Token INC254=null;
        Token DEC256=null;
        LeMaVMParser.unaryExpression_return unaryExpression251 = null;

        LeMaVMParser.unaryExpression_return unaryExpression253 = null;

        LeMaVMParser.postfixedExpression_return postfixedExpression255 = null;

        LeMaVMParser.postfixedExpression_return postfixedExpression257 = null;

        LeMaVMParser.unaryExpressionNotPlusMinus_return unaryExpressionNotPlusMinus258 = null;


        CommonTree PLUS250_tree=null;
        CommonTree MINUS252_tree=null;
        CommonTree INC254_tree=null;
        CommonTree DEC256_tree=null;
        RewriteRuleTokenStream stream_DEC=new RewriteRuleTokenStream(adaptor,"token DEC");
        RewriteRuleTokenStream stream_INC=new RewriteRuleTokenStream(adaptor,"token INC");
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_postfixedExpression=new RewriteRuleSubtreeStream(adaptor,"rule postfixedExpression");
        RewriteRuleSubtreeStream stream_unaryExpression=new RewriteRuleSubtreeStream(adaptor,"rule unaryExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }
            // LeMaVM.g:679:5: ( PLUS unaryExpression -> ^( UNARY_PLUS[$PLUS, \"UNARY_PLUS\"] unaryExpression ) | MINUS unaryExpression -> ^( UNARY_MINUS[$MINUS, \"UNARY_MINUS\"] unaryExpression ) | INC postfixedExpression -> ^( PRE_INC[$INC, \"PRE_INC\"] postfixedExpression ) | DEC postfixedExpression -> ^( PRE_DEC[$DEC, \"PRE_DEC\"] postfixedExpression ) | unaryExpressionNotPlusMinus )
            int alt73=5;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt73=1;
                }
                break;
            case MINUS:
                {
                alt73=2;
                }
                break;
            case INC:
                {
                alt73=3;
                }
                break;
            case DEC:
                {
                alt73=4;
                }
                break;
            case LOGICAL_NOT:
            case LPAREN:
            case NOT:
            case BOOLEAN:
            case DOUBLE:
            case FALSE:
            case INT:
            case LONG:
            case NEW:
            case NULL:
            case SHORT:
            case STRING:
            case SUPER:
            case THIS:
            case TRUE:
            case VOID:
            case IDENT:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
                {
                alt73=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // LeMaVM.g:679:9: PLUS unaryExpression
                    {
                    PLUS250=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpression8154); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS250);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression8156);
                    unaryExpression251=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression251.getTree());


                    // AST REWRITE
                    // elements: unaryExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 679:37: -> ^( UNARY_PLUS[$PLUS, \"UNARY_PLUS\"] unaryExpression )
                    {
                        // LeMaVM.g:679:41: ^( UNARY_PLUS[$PLUS, \"UNARY_PLUS\"] unaryExpression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY_PLUS, PLUS250, "UNARY_PLUS"), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // LeMaVM.g:680:9: MINUS unaryExpression
                    {
                    MINUS252=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpression8183); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS252);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression8185);
                    unaryExpression253=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression253.getTree());


                    // AST REWRITE
                    // elements: unaryExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 680:37: -> ^( UNARY_MINUS[$MINUS, \"UNARY_MINUS\"] unaryExpression )
                    {
                        // LeMaVM.g:680:41: ^( UNARY_MINUS[$MINUS, \"UNARY_MINUS\"] unaryExpression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY_MINUS, MINUS252, "UNARY_MINUS"), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // LeMaVM.g:681:9: INC postfixedExpression
                    {
                    INC254=(Token)match(input,INC,FOLLOW_INC_in_unaryExpression8211); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INC.add(INC254);

                    pushFollow(FOLLOW_postfixedExpression_in_unaryExpression8213);
                    postfixedExpression255=postfixedExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_postfixedExpression.add(postfixedExpression255.getTree());


                    // AST REWRITE
                    // elements: postfixedExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 681:37: -> ^( PRE_INC[$INC, \"PRE_INC\"] postfixedExpression )
                    {
                        // LeMaVM.g:681:41: ^( PRE_INC[$INC, \"PRE_INC\"] postfixedExpression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PRE_INC, INC254, "PRE_INC"), root_1);

                        adaptor.addChild(root_1, stream_postfixedExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // LeMaVM.g:682:9: DEC postfixedExpression
                    {
                    DEC256=(Token)match(input,DEC,FOLLOW_DEC_in_unaryExpression8237); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEC.add(DEC256);

                    pushFollow(FOLLOW_postfixedExpression_in_unaryExpression8239);
                    postfixedExpression257=postfixedExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_postfixedExpression.add(postfixedExpression257.getTree());


                    // AST REWRITE
                    // elements: postfixedExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 682:37: -> ^( PRE_DEC[$DEC, \"PRE_DEC\"] postfixedExpression )
                    {
                        // LeMaVM.g:682:41: ^( PRE_DEC[$DEC, \"PRE_DEC\"] postfixedExpression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PRE_DEC, DEC256, "PRE_DEC"), root_1);

                        adaptor.addChild(root_1, stream_postfixedExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // LeMaVM.g:683:9: unaryExpressionNotPlusMinus
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression8263);
                    unaryExpressionNotPlusMinus258=unaryExpressionNotPlusMinus();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpressionNotPlusMinus258.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 64, unaryExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "unaryExpression"

    public static class unaryExpressionNotPlusMinus_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpressionNotPlusMinus"
    // LeMaVM.g:686:1: unaryExpressionNotPlusMinus : ( NOT unaryExpression -> ^( NOT unaryExpression ) | LOGICAL_NOT unaryExpression -> ^( LOGICAL_NOT unaryExpression ) | LPAREN type RPAREN unaryExpression -> ^( CAST_EXPR[$LPAREN, \"CAST_EXPR\"] type unaryExpression ) | postfixedExpression );
    public final LeMaVMParser.unaryExpressionNotPlusMinus_return unaryExpressionNotPlusMinus() throws RecognitionException {
        LeMaVMParser.unaryExpressionNotPlusMinus_return retval = new LeMaVMParser.unaryExpressionNotPlusMinus_return();
        retval.start = input.LT(1);
        int unaryExpressionNotPlusMinus_StartIndex = input.index();
        CommonTree root_0 = null;

        Token NOT259=null;
        Token LOGICAL_NOT261=null;
        Token LPAREN263=null;
        Token RPAREN265=null;
        LeMaVMParser.unaryExpression_return unaryExpression260 = null;

        LeMaVMParser.unaryExpression_return unaryExpression262 = null;

        LeMaVMParser.type_return type264 = null;

        LeMaVMParser.unaryExpression_return unaryExpression266 = null;

        LeMaVMParser.postfixedExpression_return postfixedExpression267 = null;


        CommonTree NOT259_tree=null;
        CommonTree LOGICAL_NOT261_tree=null;
        CommonTree LPAREN263_tree=null;
        CommonTree RPAREN265_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LOGICAL_NOT=new RewriteRuleTokenStream(adaptor,"token LOGICAL_NOT");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_unaryExpression=new RewriteRuleSubtreeStream(adaptor,"rule unaryExpression");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }
            // LeMaVM.g:687:5: ( NOT unaryExpression -> ^( NOT unaryExpression ) | LOGICAL_NOT unaryExpression -> ^( LOGICAL_NOT unaryExpression ) | LPAREN type RPAREN unaryExpression -> ^( CAST_EXPR[$LPAREN, \"CAST_EXPR\"] type unaryExpression ) | postfixedExpression )
            int alt74=4;
            alt74 = dfa74.predict(input);
            switch (alt74) {
                case 1 :
                    // LeMaVM.g:687:9: NOT unaryExpression
                    {
                    NOT259=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpressionNotPlusMinus8282); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT259);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus8284);
                    unaryExpression260=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression260.getTree());


                    // AST REWRITE
                    // elements: unaryExpression, NOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 687:57: -> ^( NOT unaryExpression )
                    {
                        // LeMaVM.g:687:61: ^( NOT unaryExpression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_NOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // LeMaVM.g:688:9: LOGICAL_NOT unaryExpression
                    {
                    LOGICAL_NOT261=(Token)match(input,LOGICAL_NOT,FOLLOW_LOGICAL_NOT_in_unaryExpressionNotPlusMinus8331); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LOGICAL_NOT.add(LOGICAL_NOT261);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus8333);
                    unaryExpression262=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression262.getTree());


                    // AST REWRITE
                    // elements: unaryExpression, LOGICAL_NOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 688:57: -> ^( LOGICAL_NOT unaryExpression )
                    {
                        // LeMaVM.g:688:61: ^( LOGICAL_NOT unaryExpression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_LOGICAL_NOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // LeMaVM.g:689:9: LPAREN type RPAREN unaryExpression
                    {
                    LPAREN263=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_unaryExpressionNotPlusMinus8372); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN263);

                    pushFollow(FOLLOW_type_in_unaryExpressionNotPlusMinus8374);
                    type264=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type264.getTree());
                    RPAREN265=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_unaryExpressionNotPlusMinus8376); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN265);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus8378);
                    unaryExpression266=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression266.getTree());


                    // AST REWRITE
                    // elements: unaryExpression, type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 689:57: -> ^( CAST_EXPR[$LPAREN, \"CAST_EXPR\"] type unaryExpression )
                    {
                        // LeMaVM.g:689:61: ^( CAST_EXPR[$LPAREN, \"CAST_EXPR\"] type unaryExpression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CAST_EXPR, LPAREN263, "CAST_EXPR"), root_1);

                        adaptor.addChild(root_1, stream_type.nextTree());
                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // LeMaVM.g:690:9: postfixedExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_postfixedExpression_in_unaryExpressionNotPlusMinus8413);
                    postfixedExpression267=postfixedExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixedExpression267.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, unaryExpressionNotPlusMinus_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "unaryExpressionNotPlusMinus"

    public static class postfixedExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "postfixedExpression"
    // LeMaVM.g:693:1: postfixedExpression : ( primaryExpression -> primaryExpression ) (outerDot= DOT ( ( IDENT -> ^( DOT $postfixedExpression IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | THIS -> ^( DOT $postfixedExpression THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] $postfixedExpression arguments ) | ( SUPER innerDot= DOT IDENT -> ^( $innerDot ^( $outerDot $postfixedExpression SUPER ) IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | innerNewExpression -> ^( DOT $postfixedExpression innerNewExpression ) ) | LBRACK expression RBRACK -> ^( ARRAY_ELEMENT_ACCESS $postfixedExpression expression ) )* ( INC -> ^( POST_INC[$INC, \"POST_INC\"] $postfixedExpression) | DEC -> ^( POST_DEC[$DEC, \"POST_DEC\"] $postfixedExpression) )? ;
    public final LeMaVMParser.postfixedExpression_return postfixedExpression() throws RecognitionException {
        LeMaVMParser.postfixedExpression_return retval = new LeMaVMParser.postfixedExpression_return();
        retval.start = input.LT(1);
        int postfixedExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token outerDot=null;
        Token Super=null;
        Token innerDot=null;
        Token IDENT269=null;
        Token THIS271=null;
        Token SUPER273=null;
        Token IDENT274=null;
        Token LBRACK277=null;
        Token RBRACK279=null;
        Token INC280=null;
        Token DEC281=null;
        LeMaVMParser.primaryExpression_return primaryExpression268 = null;

        LeMaVMParser.arguments_return arguments270 = null;

        LeMaVMParser.arguments_return arguments272 = null;

        LeMaVMParser.arguments_return arguments275 = null;

        LeMaVMParser.innerNewExpression_return innerNewExpression276 = null;

        LeMaVMParser.expression_return expression278 = null;


        CommonTree outerDot_tree=null;
        CommonTree Super_tree=null;
        CommonTree innerDot_tree=null;
        CommonTree IDENT269_tree=null;
        CommonTree THIS271_tree=null;
        CommonTree SUPER273_tree=null;
        CommonTree IDENT274_tree=null;
        CommonTree LBRACK277_tree=null;
        CommonTree RBRACK279_tree=null;
        CommonTree INC280_tree=null;
        CommonTree DEC281_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_INC=new RewriteRuleTokenStream(adaptor,"token INC");
        RewriteRuleTokenStream stream_DEC=new RewriteRuleTokenStream(adaptor,"token DEC");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_SUPER=new RewriteRuleTokenStream(adaptor,"token SUPER");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_THIS=new RewriteRuleTokenStream(adaptor,"token THIS");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_primaryExpression=new RewriteRuleSubtreeStream(adaptor,"rule primaryExpression");
        RewriteRuleSubtreeStream stream_innerNewExpression=new RewriteRuleSubtreeStream(adaptor,"rule innerNewExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }
            // LeMaVM.g:695:5: ( ( primaryExpression -> primaryExpression ) (outerDot= DOT ( ( IDENT -> ^( DOT $postfixedExpression IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | THIS -> ^( DOT $postfixedExpression THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] $postfixedExpression arguments ) | ( SUPER innerDot= DOT IDENT -> ^( $innerDot ^( $outerDot $postfixedExpression SUPER ) IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | innerNewExpression -> ^( DOT $postfixedExpression innerNewExpression ) ) | LBRACK expression RBRACK -> ^( ARRAY_ELEMENT_ACCESS $postfixedExpression expression ) )* ( INC -> ^( POST_INC[$INC, \"POST_INC\"] $postfixedExpression) | DEC -> ^( POST_DEC[$DEC, \"POST_DEC\"] $postfixedExpression) )? )
            // LeMaVM.g:695:9: ( primaryExpression -> primaryExpression ) (outerDot= DOT ( ( IDENT -> ^( DOT $postfixedExpression IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | THIS -> ^( DOT $postfixedExpression THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] $postfixedExpression arguments ) | ( SUPER innerDot= DOT IDENT -> ^( $innerDot ^( $outerDot $postfixedExpression SUPER ) IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | innerNewExpression -> ^( DOT $postfixedExpression innerNewExpression ) ) | LBRACK expression RBRACK -> ^( ARRAY_ELEMENT_ACCESS $postfixedExpression expression ) )* ( INC -> ^( POST_INC[$INC, \"POST_INC\"] $postfixedExpression) | DEC -> ^( POST_DEC[$DEC, \"POST_DEC\"] $postfixedExpression) )?
            {
            // LeMaVM.g:695:9: ( primaryExpression -> primaryExpression )
            // LeMaVM.g:695:13: primaryExpression
            {
            pushFollow(FOLLOW_primaryExpression_in_postfixedExpression8449);
            primaryExpression268=primaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_primaryExpression.add(primaryExpression268.getTree());


            // AST REWRITE
            // elements: primaryExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 695:53: -> primaryExpression
            {
                adaptor.addChild(root_0, stream_primaryExpression.nextTree());

            }

            retval.tree = root_0;}
            }

            // LeMaVM.g:698:9: (outerDot= DOT ( ( IDENT -> ^( DOT $postfixedExpression IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | THIS -> ^( DOT $postfixedExpression THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] $postfixedExpression arguments ) | ( SUPER innerDot= DOT IDENT -> ^( $innerDot ^( $outerDot $postfixedExpression SUPER ) IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | innerNewExpression -> ^( DOT $postfixedExpression innerNewExpression ) ) | LBRACK expression RBRACK -> ^( ARRAY_ELEMENT_ACCESS $postfixedExpression expression ) )*
            loop78:
            do {
                int alt78=3;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==DOT) ) {
                    alt78=1;
                }
                else if ( (LA78_0==LBRACK) ) {
                    alt78=2;
                }


                switch (alt78) {
            	case 1 :
            	    // LeMaVM.g:698:13: outerDot= DOT ( ( IDENT -> ^( DOT $postfixedExpression IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | THIS -> ^( DOT $postfixedExpression THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] $postfixedExpression arguments ) | ( SUPER innerDot= DOT IDENT -> ^( $innerDot ^( $outerDot $postfixedExpression SUPER ) IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | innerNewExpression -> ^( DOT $postfixedExpression innerNewExpression ) )
            	    {
            	    outerDot=(Token)match(input,DOT,FOLLOW_DOT_in_postfixedExpression8511); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_DOT.add(outerDot);

            	    // LeMaVM.g:699:13: ( ( IDENT -> ^( DOT $postfixedExpression IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | THIS -> ^( DOT $postfixedExpression THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] $postfixedExpression arguments ) | ( SUPER innerDot= DOT IDENT -> ^( $innerDot ^( $outerDot $postfixedExpression SUPER ) IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )? | innerNewExpression -> ^( DOT $postfixedExpression innerNewExpression ) )
            	    int alt77=5;
            	    switch ( input.LA(1) ) {
            	    case IDENT:
            	        {
            	        alt77=1;
            	        }
            	        break;
            	    case THIS:
            	        {
            	        alt77=2;
            	        }
            	        break;
            	    case SUPER:
            	        {
            	        int LA77_3 = input.LA(2);

            	        if ( (LA77_3==DOT) ) {
            	            alt77=4;
            	        }
            	        else if ( (LA77_3==LPAREN) ) {
            	            alt77=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return retval;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 77, 3, input);

            	            throw nvae;
            	        }
            	        }
            	        break;
            	    case NEW:
            	        {
            	        alt77=5;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 77, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt77) {
            	        case 1 :
            	            // LeMaVM.g:699:17: ( IDENT -> ^( DOT $postfixedExpression IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )?
            	            {
            	            // LeMaVM.g:699:17: ( IDENT -> ^( DOT $postfixedExpression IDENT ) )
            	            // LeMaVM.g:699:21: IDENT
            	            {
            	            IDENT269=(Token)match(input,IDENT,FOLLOW_IDENT_in_postfixedExpression8561); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_IDENT.add(IDENT269);



            	            // AST REWRITE
            	            // elements: postfixedExpression, DOT, IDENT
            	            // token labels: 
            	            // rule labels: retval
            	            // token list labels: 
            	            // rule list labels: 
            	            // wildcard labels: 
            	            if ( state.backtracking==0 ) {
            	            retval.tree = root_0;
            	            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	            root_0 = (CommonTree)adaptor.nil();
            	            // 699:53: -> ^( DOT $postfixedExpression IDENT )
            	            {
            	                // LeMaVM.g:699:57: ^( DOT $postfixedExpression IDENT )
            	                {
            	                CommonTree root_1 = (CommonTree)adaptor.nil();
            	                root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

            	                adaptor.addChild(root_1, stream_retval.nextTree());
            	                adaptor.addChild(root_1, stream_IDENT.nextNode());

            	                adaptor.addChild(root_0, root_1);
            	                }

            	            }

            	            retval.tree = root_0;}
            	            }

            	            // LeMaVM.g:701:17: ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )?
            	            int alt75=2;
            	            int LA75_0 = input.LA(1);

            	            if ( (LA75_0==LPAREN) ) {
            	                alt75=1;
            	            }
            	            switch (alt75) {
            	                case 1 :
            	                    // LeMaVM.g:701:21: arguments
            	                    {
            	                    pushFollow(FOLLOW_arguments_in_postfixedExpression8640);
            	                    arguments270=arguments();

            	                    state._fsp--;
            	                    if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) stream_arguments.add(arguments270.getTree());


            	                    // AST REWRITE
            	                    // elements: postfixedExpression, arguments
            	                    // token labels: 
            	                    // rule labels: retval
            	                    // token list labels: 
            	                    // rule list labels: 
            	                    // wildcard labels: 
            	                    if ( state.backtracking==0 ) {
            	                    retval.tree = root_0;
            	                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	                    root_0 = (CommonTree)adaptor.nil();
            	                    // 701:53: -> ^( METHOD_CALL $postfixedExpression arguments )
            	                    {
            	                        // LeMaVM.g:701:57: ^( METHOD_CALL $postfixedExpression arguments )
            	                        {
            	                        CommonTree root_1 = (CommonTree)adaptor.nil();
            	                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL"), root_1);

            	                        adaptor.addChild(root_1, stream_retval.nextTree());
            	                        adaptor.addChild(root_1, stream_arguments.nextTree());

            	                        adaptor.addChild(root_0, root_1);
            	                        }

            	                    }

            	                    retval.tree = root_0;}
            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // LeMaVM.g:703:17: THIS
            	            {
            	            THIS271=(Token)match(input,THIS,FOLLOW_THIS_in_postfixedExpression8711); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_THIS.add(THIS271);



            	            // AST REWRITE
            	            // elements: THIS, DOT, postfixedExpression
            	            // token labels: 
            	            // rule labels: retval
            	            // token list labels: 
            	            // rule list labels: 
            	            // wildcard labels: 
            	            if ( state.backtracking==0 ) {
            	            retval.tree = root_0;
            	            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	            root_0 = (CommonTree)adaptor.nil();
            	            // 703:53: -> ^( DOT $postfixedExpression THIS )
            	            {
            	                // LeMaVM.g:703:57: ^( DOT $postfixedExpression THIS )
            	                {
            	                CommonTree root_1 = (CommonTree)adaptor.nil();
            	                root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

            	                adaptor.addChild(root_1, stream_retval.nextTree());
            	                adaptor.addChild(root_1, stream_THIS.nextNode());

            	                adaptor.addChild(root_0, root_1);
            	                }

            	            }

            	            retval.tree = root_0;}
            	            }
            	            break;
            	        case 3 :
            	            // LeMaVM.g:704:17: Super= SUPER arguments
            	            {
            	            Super=(Token)match(input,SUPER,FOLLOW_SUPER_in_postfixedExpression8774); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_SUPER.add(Super);

            	            pushFollow(FOLLOW_arguments_in_postfixedExpression8776);
            	            arguments272=arguments();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_arguments.add(arguments272.getTree());


            	            // AST REWRITE
            	            // elements: postfixedExpression, arguments
            	            // token labels: 
            	            // rule labels: retval
            	            // token list labels: 
            	            // rule list labels: 
            	            // wildcard labels: 
            	            if ( state.backtracking==0 ) {
            	            retval.tree = root_0;
            	            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	            root_0 = (CommonTree)adaptor.nil();
            	            // 704:57: -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] $postfixedExpression arguments )
            	            {
            	                // LeMaVM.g:704:61: ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] $postfixedExpression arguments )
            	                {
            	                CommonTree root_1 = (CommonTree)adaptor.nil();
            	                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUPER_CONSTRUCTOR_CALL, Super, "SUPER_CONSTRUCTOR_CALL"), root_1);

            	                adaptor.addChild(root_1, stream_retval.nextTree());
            	                adaptor.addChild(root_1, stream_arguments.nextTree());

            	                adaptor.addChild(root_0, root_1);
            	                }

            	            }

            	            retval.tree = root_0;}
            	            }
            	            break;
            	        case 4 :
            	            // LeMaVM.g:705:17: ( SUPER innerDot= DOT IDENT -> ^( $innerDot ^( $outerDot $postfixedExpression SUPER ) IDENT ) ) ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )?
            	            {
            	            // LeMaVM.g:705:17: ( SUPER innerDot= DOT IDENT -> ^( $innerDot ^( $outerDot $postfixedExpression SUPER ) IDENT ) )
            	            // LeMaVM.g:705:21: SUPER innerDot= DOT IDENT
            	            {
            	            SUPER273=(Token)match(input,SUPER,FOLLOW_SUPER_in_postfixedExpression8829); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_SUPER.add(SUPER273);

            	            innerDot=(Token)match(input,DOT,FOLLOW_DOT_in_postfixedExpression8833); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_DOT.add(innerDot);

            	            IDENT274=(Token)match(input,IDENT,FOLLOW_IDENT_in_postfixedExpression8835); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_IDENT.add(IDENT274);



            	            // AST REWRITE
            	            // elements: IDENT, SUPER, innerDot, postfixedExpression, outerDot
            	            // token labels: outerDot, innerDot
            	            // rule labels: retval
            	            // token list labels: 
            	            // rule list labels: 
            	            // wildcard labels: 
            	            if ( state.backtracking==0 ) {
            	            retval.tree = root_0;
            	            RewriteRuleTokenStream stream_outerDot=new RewriteRuleTokenStream(adaptor,"token outerDot",outerDot);
            	            RewriteRuleTokenStream stream_innerDot=new RewriteRuleTokenStream(adaptor,"token innerDot",innerDot);
            	            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	            root_0 = (CommonTree)adaptor.nil();
            	            // 705:53: -> ^( $innerDot ^( $outerDot $postfixedExpression SUPER ) IDENT )
            	            {
            	                // LeMaVM.g:705:57: ^( $innerDot ^( $outerDot $postfixedExpression SUPER ) IDENT )
            	                {
            	                CommonTree root_1 = (CommonTree)adaptor.nil();
            	                root_1 = (CommonTree)adaptor.becomeRoot(stream_innerDot.nextNode(), root_1);

            	                // LeMaVM.g:705:69: ^( $outerDot $postfixedExpression SUPER )
            	                {
            	                CommonTree root_2 = (CommonTree)adaptor.nil();
            	                root_2 = (CommonTree)adaptor.becomeRoot(stream_outerDot.nextNode(), root_2);

            	                adaptor.addChild(root_2, stream_retval.nextTree());
            	                adaptor.addChild(root_2, stream_SUPER.nextNode());

            	                adaptor.addChild(root_1, root_2);
            	                }
            	                adaptor.addChild(root_1, stream_IDENT.nextNode());

            	                adaptor.addChild(root_0, root_1);
            	                }

            	            }

            	            retval.tree = root_0;}
            	            }

            	            // LeMaVM.g:707:17: ( arguments -> ^( METHOD_CALL $postfixedExpression arguments ) )?
            	            int alt76=2;
            	            int LA76_0 = input.LA(1);

            	            if ( (LA76_0==LPAREN) ) {
            	                alt76=1;
            	            }
            	            switch (alt76) {
            	                case 1 :
            	                    // LeMaVM.g:707:21: arguments
            	                    {
            	                    pushFollow(FOLLOW_arguments_in_postfixedExpression8902);
            	                    arguments275=arguments();

            	                    state._fsp--;
            	                    if (state.failed) return retval;
            	                    if ( state.backtracking==0 ) stream_arguments.add(arguments275.getTree());


            	                    // AST REWRITE
            	                    // elements: arguments, postfixedExpression
            	                    // token labels: 
            	                    // rule labels: retval
            	                    // token list labels: 
            	                    // rule list labels: 
            	                    // wildcard labels: 
            	                    if ( state.backtracking==0 ) {
            	                    retval.tree = root_0;
            	                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	                    root_0 = (CommonTree)adaptor.nil();
            	                    // 707:53: -> ^( METHOD_CALL $postfixedExpression arguments )
            	                    {
            	                        // LeMaVM.g:707:57: ^( METHOD_CALL $postfixedExpression arguments )
            	                        {
            	                        CommonTree root_1 = (CommonTree)adaptor.nil();
            	                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL"), root_1);

            	                        adaptor.addChild(root_1, stream_retval.nextTree());
            	                        adaptor.addChild(root_1, stream_arguments.nextTree());

            	                        adaptor.addChild(root_0, root_1);
            	                        }

            	                    }

            	                    retval.tree = root_0;}
            	                    }
            	                    break;

            	            }


            	            }
            	            break;
            	        case 5 :
            	            // LeMaVM.g:709:17: innerNewExpression
            	            {
            	            pushFollow(FOLLOW_innerNewExpression_in_postfixedExpression8973);
            	            innerNewExpression276=innerNewExpression();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_innerNewExpression.add(innerNewExpression276.getTree());


            	            // AST REWRITE
            	            // elements: innerNewExpression, postfixedExpression, DOT
            	            // token labels: 
            	            // rule labels: retval
            	            // token list labels: 
            	            // rule list labels: 
            	            // wildcard labels: 
            	            if ( state.backtracking==0 ) {
            	            retval.tree = root_0;
            	            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	            root_0 = (CommonTree)adaptor.nil();
            	            // 709:53: -> ^( DOT $postfixedExpression innerNewExpression )
            	            {
            	                // LeMaVM.g:709:57: ^( DOT $postfixedExpression innerNewExpression )
            	                {
            	                CommonTree root_1 = (CommonTree)adaptor.nil();
            	                root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

            	                adaptor.addChild(root_1, stream_retval.nextTree());
            	                adaptor.addChild(root_1, stream_innerNewExpression.nextTree());

            	                adaptor.addChild(root_0, root_1);
            	                }

            	            }

            	            retval.tree = root_0;}
            	            }
            	            break;

            	    }


            	    }
            	    break;
            	case 2 :
            	    // LeMaVM.g:711:13: LBRACK expression RBRACK
            	    {
            	    LBRACK277=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_postfixedExpression9030); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK277);

            	    pushFollow(FOLLOW_expression_in_postfixedExpression9032);
            	    expression278=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expression.add(expression278.getTree());
            	    RBRACK279=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_postfixedExpression9034); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK279);



            	    // AST REWRITE
            	    // elements: expression, postfixedExpression
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 711:53: -> ^( ARRAY_ELEMENT_ACCESS $postfixedExpression expression )
            	    {
            	        // LeMaVM.g:711:57: ^( ARRAY_ELEMENT_ACCESS $postfixedExpression expression )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY_ELEMENT_ACCESS, "ARRAY_ELEMENT_ACCESS"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_expression.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            // LeMaVM.g:714:9: ( INC -> ^( POST_INC[$INC, \"POST_INC\"] $postfixedExpression) | DEC -> ^( POST_DEC[$DEC, \"POST_DEC\"] $postfixedExpression) )?
            int alt79=3;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==INC) ) {
                alt79=1;
            }
            else if ( (LA79_0==DEC) ) {
                alt79=2;
            }
            switch (alt79) {
                case 1 :
                    // LeMaVM.g:714:13: INC
                    {
                    INC280=(Token)match(input,INC,FOLLOW_INC_in_postfixedExpression9095); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INC.add(INC280);



                    // AST REWRITE
                    // elements: postfixedExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 714:17: -> ^( POST_INC[$INC, \"POST_INC\"] $postfixedExpression)
                    {
                        // LeMaVM.g:714:20: ^( POST_INC[$INC, \"POST_INC\"] $postfixedExpression)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(POST_INC, INC280, "POST_INC"), root_1);

                        adaptor.addChild(root_1, stream_retval.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // LeMaVM.g:715:13: DEC
                    {
                    DEC281=(Token)match(input,DEC,FOLLOW_DEC_in_postfixedExpression9119); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEC.add(DEC281);



                    // AST REWRITE
                    // elements: postfixedExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 715:17: -> ^( POST_DEC[$DEC, \"POST_DEC\"] $postfixedExpression)
                    {
                        // LeMaVM.g:715:20: ^( POST_DEC[$DEC, \"POST_DEC\"] $postfixedExpression)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(POST_DEC, DEC281, "POST_DEC"), root_1);

                        adaptor.addChild(root_1, stream_retval.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 66, postfixedExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "postfixedExpression"

    public static class primaryExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primaryExpression"
    // LeMaVM.g:719:1: primaryExpression : ( parenthesizedExpression | literal | newExpression | qualifiedIdentExpression | ( SUPER ( arguments -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments ) | DOT IDENT arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) ) | IDENT arguments -> ^( METHOD_CALL IDENT arguments ) | THIS arguments -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments ) ) | ( THIS -> THIS ) ( arguments -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments ) )? | SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments ) | ( SUPER DOT IDENT ) ( arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) | -> ^( DOT SUPER IDENT ) ) | ( primitiveType -> primitiveType ) ( arrayDeclarator -> ^( arrayDeclarator $primaryExpression) )* DOT CLASS -> ^( DOT $primaryExpression CLASS ) | VOID DOT CLASS -> ^( DOT VOID CLASS ) );
    public final LeMaVMParser.primaryExpression_return primaryExpression() throws RecognitionException {
        LeMaVMParser.primaryExpression_return retval = new LeMaVMParser.primaryExpression_return();
        retval.start = input.LT(1);
        int primaryExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token SUPER286=null;
        Token DOT288=null;
        Token IDENT289=null;
        Token IDENT291=null;
        Token THIS293=null;
        Token THIS295=null;
        Token SUPER297=null;
        Token SUPER299=null;
        Token DOT300=null;
        Token IDENT301=null;
        Token DOT305=null;
        Token CLASS306=null;
        Token VOID307=null;
        Token DOT308=null;
        Token CLASS309=null;
        LeMaVMParser.parenthesizedExpression_return parenthesizedExpression282 = null;

        LeMaVMParser.literal_return literal283 = null;

        LeMaVMParser.newExpression_return newExpression284 = null;

        LeMaVMParser.qualifiedIdentExpression_return qualifiedIdentExpression285 = null;

        LeMaVMParser.arguments_return arguments287 = null;

        LeMaVMParser.arguments_return arguments290 = null;

        LeMaVMParser.arguments_return arguments292 = null;

        LeMaVMParser.arguments_return arguments294 = null;

        LeMaVMParser.arguments_return arguments296 = null;

        LeMaVMParser.arguments_return arguments298 = null;

        LeMaVMParser.arguments_return arguments302 = null;

        LeMaVMParser.primitiveType_return primitiveType303 = null;

        LeMaVMParser.arrayDeclarator_return arrayDeclarator304 = null;


        CommonTree SUPER286_tree=null;
        CommonTree DOT288_tree=null;
        CommonTree IDENT289_tree=null;
        CommonTree IDENT291_tree=null;
        CommonTree THIS293_tree=null;
        CommonTree THIS295_tree=null;
        CommonTree SUPER297_tree=null;
        CommonTree SUPER299_tree=null;
        CommonTree DOT300_tree=null;
        CommonTree IDENT301_tree=null;
        CommonTree DOT305_tree=null;
        CommonTree CLASS306_tree=null;
        CommonTree VOID307_tree=null;
        CommonTree DOT308_tree=null;
        CommonTree CLASS309_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");
        RewriteRuleTokenStream stream_VOID=new RewriteRuleTokenStream(adaptor,"token VOID");
        RewriteRuleTokenStream stream_SUPER=new RewriteRuleTokenStream(adaptor,"token SUPER");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_THIS=new RewriteRuleTokenStream(adaptor,"token THIS");
        RewriteRuleSubtreeStream stream_arrayDeclarator=new RewriteRuleSubtreeStream(adaptor,"rule arrayDeclarator");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_primitiveType=new RewriteRuleSubtreeStream(adaptor,"rule primitiveType");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return retval; }
            // LeMaVM.g:720:5: ( parenthesizedExpression | literal | newExpression | qualifiedIdentExpression | ( SUPER ( arguments -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments ) | DOT IDENT arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) ) | IDENT arguments -> ^( METHOD_CALL IDENT arguments ) | THIS arguments -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments ) ) | ( THIS -> THIS ) ( arguments -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments ) )? | SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments ) | ( SUPER DOT IDENT ) ( arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) | -> ^( DOT SUPER IDENT ) ) | ( primitiveType -> primitiveType ) ( arrayDeclarator -> ^( arrayDeclarator $primaryExpression) )* DOT CLASS -> ^( DOT $primaryExpression CLASS ) | VOID DOT CLASS -> ^( DOT VOID CLASS ) )
            int alt85=10;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // LeMaVM.g:720:9: parenthesizedExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_parenthesizedExpression_in_primaryExpression9167);
                    parenthesizedExpression282=parenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, parenthesizedExpression282.getTree());

                    }
                    break;
                case 2 :
                    // LeMaVM.g:721:9: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primaryExpression9177);
                    literal283=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal283.getTree());

                    }
                    break;
                case 3 :
                    // LeMaVM.g:722:9: newExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_primaryExpression9187);
                    newExpression284=newExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, newExpression284.getTree());

                    }
                    break;
                case 4 :
                    // LeMaVM.g:723:9: qualifiedIdentExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_qualifiedIdentExpression_in_primaryExpression9197);
                    qualifiedIdentExpression285=qualifiedIdentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, qualifiedIdentExpression285.getTree());

                    }
                    break;
                case 5 :
                    // LeMaVM.g:724:9: ( SUPER ( arguments -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments ) | DOT IDENT arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) ) | IDENT arguments -> ^( METHOD_CALL IDENT arguments ) | THIS arguments -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments ) )
                    {
                    // LeMaVM.g:724:9: ( SUPER ( arguments -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments ) | DOT IDENT arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) ) | IDENT arguments -> ^( METHOD_CALL IDENT arguments ) | THIS arguments -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments ) )
                    int alt81=3;
                    switch ( input.LA(1) ) {
                    case SUPER:
                        {
                        alt81=1;
                        }
                        break;
                    case IDENT:
                        {
                        alt81=2;
                        }
                        break;
                    case THIS:
                        {
                        alt81=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 81, 0, input);

                        throw nvae;
                    }

                    switch (alt81) {
                        case 1 :
                            // LeMaVM.g:724:13: SUPER ( arguments -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments ) | DOT IDENT arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) )
                            {
                            SUPER286=(Token)match(input,SUPER,FOLLOW_SUPER_in_primaryExpression9211); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SUPER.add(SUPER286);

                            // LeMaVM.g:725:13: ( arguments -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments ) | DOT IDENT arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) )
                            int alt80=2;
                            int LA80_0 = input.LA(1);

                            if ( (LA80_0==LPAREN) ) {
                                alt80=1;
                            }
                            else if ( (LA80_0==DOT) ) {
                                alt80=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 80, 0, input);

                                throw nvae;
                            }
                            switch (alt80) {
                                case 1 :
                                    // LeMaVM.g:725:17: arguments
                                    {
                                    pushFollow(FOLLOW_arguments_in_primaryExpression9229);
                                    arguments287=arguments();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_arguments.add(arguments287.getTree());


                                    // AST REWRITE
                                    // elements: arguments
                                    // token labels: 
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    if ( state.backtracking==0 ) {
                                    retval.tree = root_0;
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (CommonTree)adaptor.nil();
                                    // 725:57: -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments )
                                    {
                                        // LeMaVM.g:725:61: ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments )
                                        {
                                        CommonTree root_1 = (CommonTree)adaptor.nil();
                                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUPER_CONSTRUCTOR_CALL, SUPER286, "SUPER_CONSTRUCTOR_CALL"), root_1);

                                        adaptor.addChild(root_1, stream_arguments.nextTree());

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }

                                    retval.tree = root_0;}
                                    }
                                    break;
                                case 2 :
                                    // LeMaVM.g:726:17: DOT IDENT arguments
                                    {
                                    DOT288=(Token)match(input,DOT,FOLLOW_DOT_in_primaryExpression9287); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_DOT.add(DOT288);

                                    IDENT289=(Token)match(input,IDENT,FOLLOW_IDENT_in_primaryExpression9289); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT289);

                                    pushFollow(FOLLOW_arguments_in_primaryExpression9291);
                                    arguments290=arguments();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_arguments.add(arguments290.getTree());


                                    // AST REWRITE
                                    // elements: IDENT, DOT, SUPER, arguments
                                    // token labels: 
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    if ( state.backtracking==0 ) {
                                    retval.tree = root_0;
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (CommonTree)adaptor.nil();
                                    // 726:57: -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments )
                                    {
                                        // LeMaVM.g:726:61: ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments )
                                        {
                                        CommonTree root_1 = (CommonTree)adaptor.nil();
                                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL"), root_1);

                                        // LeMaVM.g:726:75: ^( DOT SUPER IDENT )
                                        {
                                        CommonTree root_2 = (CommonTree)adaptor.nil();
                                        root_2 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_2);

                                        adaptor.addChild(root_2, stream_SUPER.nextNode());
                                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                                        adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_1, stream_arguments.nextTree());

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }

                                    retval.tree = root_0;}
                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // LeMaVM.g:728:13: IDENT arguments
                            {
                            IDENT291=(Token)match(input,IDENT,FOLLOW_IDENT_in_primaryExpression9356); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IDENT.add(IDENT291);

                            pushFollow(FOLLOW_arguments_in_primaryExpression9358);
                            arguments292=arguments();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_arguments.add(arguments292.getTree());


                            // AST REWRITE
                            // elements: IDENT, arguments
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 728:57: -> ^( METHOD_CALL IDENT arguments )
                            {
                                // LeMaVM.g:728:61: ^( METHOD_CALL IDENT arguments )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL"), root_1);

                                adaptor.addChild(root_1, stream_IDENT.nextNode());
                                adaptor.addChild(root_1, stream_arguments.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 3 :
                            // LeMaVM.g:729:13: THIS arguments
                            {
                            THIS293=(Token)match(input,THIS,FOLLOW_THIS_in_primaryExpression9411); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_THIS.add(THIS293);

                            pushFollow(FOLLOW_arguments_in_primaryExpression9413);
                            arguments294=arguments();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_arguments.add(arguments294.getTree());


                            // AST REWRITE
                            // elements: arguments
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 729:57: -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments )
                            {
                                // LeMaVM.g:729:61: ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(THIS_CONSTRUCTOR_CALL, THIS293, "THIS_CONSTRUCTOR_CALL"), root_1);

                                adaptor.addChild(root_1, stream_arguments.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // LeMaVM.g:731:9: ( THIS -> THIS ) ( arguments -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments ) )?
                    {
                    // LeMaVM.g:731:9: ( THIS -> THIS )
                    // LeMaVM.g:731:13: THIS
                    {
                    THIS295=(Token)match(input,THIS,FOLLOW_THIS_in_primaryExpression9476); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_THIS.add(THIS295);



                    // AST REWRITE
                    // elements: THIS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 731:57: -> THIS
                    {
                        adaptor.addChild(root_0, stream_THIS.nextNode());

                    }

                    retval.tree = root_0;}
                    }

                    // LeMaVM.g:733:9: ( arguments -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments ) )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==LPAREN) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // LeMaVM.g:733:13: arguments
                            {
                            pushFollow(FOLLOW_arguments_in_primaryExpression9544);
                            arguments296=arguments();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_arguments.add(arguments296.getTree());


                            // AST REWRITE
                            // elements: arguments
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 733:57: -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments )
                            {
                                // LeMaVM.g:733:61: ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(THIS_CONSTRUCTOR_CALL, THIS295, "THIS_CONSTRUCTOR_CALL"), root_1);

                                adaptor.addChild(root_1, stream_arguments.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;
                case 7 :
                    // LeMaVM.g:735:9: SUPER arguments
                    {
                    SUPER297=(Token)match(input,SUPER,FOLLOW_SUPER_in_primaryExpression9609); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUPER.add(SUPER297);

                    pushFollow(FOLLOW_arguments_in_primaryExpression9611);
                    arguments298=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_arguments.add(arguments298.getTree());


                    // AST REWRITE
                    // elements: arguments
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 735:57: -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments )
                    {
                        // LeMaVM.g:735:61: ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUPER_CONSTRUCTOR_CALL, SUPER297, "SUPER_CONSTRUCTOR_CALL"), root_1);

                        adaptor.addChild(root_1, stream_arguments.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // LeMaVM.g:736:9: ( SUPER DOT IDENT ) ( arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) | -> ^( DOT SUPER IDENT ) )
                    {
                    // LeMaVM.g:736:9: ( SUPER DOT IDENT )
                    // LeMaVM.g:736:13: SUPER DOT IDENT
                    {
                    SUPER299=(Token)match(input,SUPER,FOLLOW_SUPER_in_primaryExpression9667); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUPER.add(SUPER299);

                    DOT300=(Token)match(input,DOT,FOLLOW_DOT_in_primaryExpression9669); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT300);

                    IDENT301=(Token)match(input,IDENT,FOLLOW_IDENT_in_primaryExpression9671); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT301);


                    }

                    // LeMaVM.g:738:9: ( arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) | -> ^( DOT SUPER IDENT ) )
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==LPAREN) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==EOF||(LA83_0>=AND && LA83_0<=ASSIGN)||LA83_0==BIT_SHIFT_RIGHT||(LA83_0>=COLON && LA83_0<=DOT)||(LA83_0>=EQUAL && LA83_0<=LBRACK)||(LA83_0>=LESS_OR_EQUAL && LA83_0<=LOGICAL_AND)||LA83_0==LOGICAL_OR||(LA83_0>=MINUS && LA83_0<=MOD_ASSIGN)||(LA83_0>=NOT_EQUAL && LA83_0<=SHIFT_LEFT)||LA83_0==SHIFT_RIGHT||(LA83_0>=STAR && LA83_0<=XOR_ASSIGN)||LA83_0==INSTANCEOF) ) {
                        alt83=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 0, input);

                        throw nvae;
                    }
                    switch (alt83) {
                        case 1 :
                            // LeMaVM.g:738:13: arguments
                            {
                            pushFollow(FOLLOW_arguments_in_primaryExpression9695);
                            arguments302=arguments();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_arguments.add(arguments302.getTree());


                            // AST REWRITE
                            // elements: IDENT, arguments, SUPER, DOT
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 738:57: -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments )
                            {
                                // LeMaVM.g:738:61: ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL"), root_1);

                                // LeMaVM.g:738:75: ^( DOT SUPER IDENT )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_2);

                                adaptor.addChild(root_2, stream_SUPER.nextNode());
                                adaptor.addChild(root_2, stream_IDENT.nextNode());

                                adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_1, stream_arguments.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // LeMaVM.g:739:57: 
                            {

                            // AST REWRITE
                            // elements: DOT, IDENT, SUPER
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 739:57: -> ^( DOT SUPER IDENT )
                            {
                                // LeMaVM.g:739:61: ^( DOT SUPER IDENT )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_SUPER.nextNode());
                                adaptor.addChild(root_1, stream_IDENT.nextNode());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;
                case 9 :
                    // LeMaVM.g:741:9: ( primitiveType -> primitiveType ) ( arrayDeclarator -> ^( arrayDeclarator $primaryExpression) )* DOT CLASS
                    {
                    // LeMaVM.g:741:9: ( primitiveType -> primitiveType )
                    // LeMaVM.g:741:13: primitiveType
                    {
                    pushFollow(FOLLOW_primitiveType_in_primaryExpression9837);
                    primitiveType303=primitiveType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_primitiveType.add(primitiveType303.getTree());


                    // AST REWRITE
                    // elements: primitiveType
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 741:57: -> primitiveType
                    {
                        adaptor.addChild(root_0, stream_primitiveType.nextTree());

                    }

                    retval.tree = root_0;}
                    }

                    // LeMaVM.g:743:9: ( arrayDeclarator -> ^( arrayDeclarator $primaryExpression) )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==LBRACK) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // LeMaVM.g:743:13: arrayDeclarator
                    	    {
                    	    pushFollow(FOLLOW_arrayDeclarator_in_primaryExpression9896);
                    	    arrayDeclarator304=arrayDeclarator();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_arrayDeclarator.add(arrayDeclarator304.getTree());


                    	    // AST REWRITE
                    	    // elements: primaryExpression, arrayDeclarator
                    	    // token labels: 
                    	    // rule labels: retval
                    	    // token list labels: 
                    	    // rule list labels: 
                    	    // wildcard labels: 
                    	    if ( state.backtracking==0 ) {
                    	    retval.tree = root_0;
                    	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    	    root_0 = (CommonTree)adaptor.nil();
                    	    // 743:57: -> ^( arrayDeclarator $primaryExpression)
                    	    {
                    	        // LeMaVM.g:743:61: ^( arrayDeclarator $primaryExpression)
                    	        {
                    	        CommonTree root_1 = (CommonTree)adaptor.nil();
                    	        root_1 = (CommonTree)adaptor.becomeRoot(stream_arrayDeclarator.nextNode(), root_1);

                    	        adaptor.addChild(root_1, stream_retval.nextTree());

                    	        adaptor.addChild(root_0, root_1);
                    	        }

                    	    }

                    	    retval.tree = root_0;}
                    	    }
                    	    break;

                    	default :
                    	    break loop84;
                        }
                    } while (true);

                    DOT305=(Token)match(input,DOT,FOLLOW_DOT_in_primaryExpression9959); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT305);

                    CLASS306=(Token)match(input,CLASS,FOLLOW_CLASS_in_primaryExpression9961); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLASS.add(CLASS306);



                    // AST REWRITE
                    // elements: DOT, primaryExpression, CLASS
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 745:57: -> ^( DOT $primaryExpression CLASS )
                    {
                        // LeMaVM.g:745:61: ^( DOT $primaryExpression CLASS )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_retval.nextTree());
                        adaptor.addChild(root_1, stream_CLASS.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // LeMaVM.g:746:9: VOID DOT CLASS
                    {
                    VOID307=(Token)match(input,VOID,FOLLOW_VOID_in_primaryExpression10021); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_VOID.add(VOID307);

                    DOT308=(Token)match(input,DOT,FOLLOW_DOT_in_primaryExpression10023); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT308);

                    CLASS309=(Token)match(input,CLASS,FOLLOW_CLASS_in_primaryExpression10025); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLASS.add(CLASS309);



                    // AST REWRITE
                    // elements: DOT, CLASS, VOID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 746:57: -> ^( DOT VOID CLASS )
                    {
                        // LeMaVM.g:746:61: ^( DOT VOID CLASS )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_VOID.nextNode());
                        adaptor.addChild(root_1, stream_CLASS.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, primaryExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primaryExpression"

    public static class qualifiedIdentExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifiedIdentExpression"
    // LeMaVM.g:749:1: qualifiedIdentExpression : ( qualifiedIdentifier -> qualifiedIdentifier ) ( ( arrayDeclarator -> ^( arrayDeclarator $qualifiedIdentExpression) )+ ( DOT CLASS -> ^( DOT $qualifiedIdentExpression CLASS ) ) | arguments -> ^( METHOD_CALL qualifiedIdentifier arguments ) | outerDot= DOT ( CLASS -> ^( DOT qualifiedIdentifier CLASS ) | (Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | SUPER innerDot= DOT IDENT arguments -> ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments ) | IDENT arguments -> ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments ) ) | THIS -> ^( DOT qualifiedIdentifier THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | innerNewExpression -> ^( DOT qualifiedIdentifier innerNewExpression ) ) )? ;
    public final LeMaVMParser.qualifiedIdentExpression_return qualifiedIdentExpression() throws RecognitionException {
        LeMaVMParser.qualifiedIdentExpression_return retval = new LeMaVMParser.qualifiedIdentExpression_return();
        retval.start = input.LT(1);
        int qualifiedIdentExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token outerDot=null;
        Token Super=null;
        Token innerDot=null;
        Token DOT312=null;
        Token CLASS313=null;
        Token CLASS315=null;
        Token SUPER317=null;
        Token IDENT318=null;
        Token IDENT320=null;
        Token THIS322=null;
        LeMaVMParser.qualifiedIdentifier_return qualifiedIdentifier310 = null;

        LeMaVMParser.arrayDeclarator_return arrayDeclarator311 = null;

        LeMaVMParser.arguments_return arguments314 = null;

        LeMaVMParser.arguments_return arguments316 = null;

        LeMaVMParser.arguments_return arguments319 = null;

        LeMaVMParser.arguments_return arguments321 = null;

        LeMaVMParser.arguments_return arguments323 = null;

        LeMaVMParser.innerNewExpression_return innerNewExpression324 = null;


        CommonTree outerDot_tree=null;
        CommonTree Super_tree=null;
        CommonTree innerDot_tree=null;
        CommonTree DOT312_tree=null;
        CommonTree CLASS313_tree=null;
        CommonTree CLASS315_tree=null;
        CommonTree SUPER317_tree=null;
        CommonTree IDENT318_tree=null;
        CommonTree IDENT320_tree=null;
        CommonTree THIS322_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");
        RewriteRuleTokenStream stream_SUPER=new RewriteRuleTokenStream(adaptor,"token SUPER");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_THIS=new RewriteRuleTokenStream(adaptor,"token THIS");
        RewriteRuleSubtreeStream stream_arrayDeclarator=new RewriteRuleSubtreeStream(adaptor,"rule arrayDeclarator");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_qualifiedIdentifier=new RewriteRuleSubtreeStream(adaptor,"rule qualifiedIdentifier");
        RewriteRuleSubtreeStream stream_innerNewExpression=new RewriteRuleSubtreeStream(adaptor,"rule innerNewExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return retval; }
            // LeMaVM.g:751:5: ( ( qualifiedIdentifier -> qualifiedIdentifier ) ( ( arrayDeclarator -> ^( arrayDeclarator $qualifiedIdentExpression) )+ ( DOT CLASS -> ^( DOT $qualifiedIdentExpression CLASS ) ) | arguments -> ^( METHOD_CALL qualifiedIdentifier arguments ) | outerDot= DOT ( CLASS -> ^( DOT qualifiedIdentifier CLASS ) | (Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | SUPER innerDot= DOT IDENT arguments -> ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments ) | IDENT arguments -> ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments ) ) | THIS -> ^( DOT qualifiedIdentifier THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | innerNewExpression -> ^( DOT qualifiedIdentifier innerNewExpression ) ) )? )
            // LeMaVM.g:751:9: ( qualifiedIdentifier -> qualifiedIdentifier ) ( ( arrayDeclarator -> ^( arrayDeclarator $qualifiedIdentExpression) )+ ( DOT CLASS -> ^( DOT $qualifiedIdentExpression CLASS ) ) | arguments -> ^( METHOD_CALL qualifiedIdentifier arguments ) | outerDot= DOT ( CLASS -> ^( DOT qualifiedIdentifier CLASS ) | (Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | SUPER innerDot= DOT IDENT arguments -> ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments ) | IDENT arguments -> ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments ) ) | THIS -> ^( DOT qualifiedIdentifier THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | innerNewExpression -> ^( DOT qualifiedIdentifier innerNewExpression ) ) )?
            {
            // LeMaVM.g:751:9: ( qualifiedIdentifier -> qualifiedIdentifier )
            // LeMaVM.g:751:13: qualifiedIdentifier
            {
            pushFollow(FOLLOW_qualifiedIdentifier_in_qualifiedIdentExpression10105);
            qualifiedIdentifier310=qualifiedIdentifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_qualifiedIdentifier.add(qualifiedIdentifier310.getTree());


            // AST REWRITE
            // elements: qualifiedIdentifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 751:61: -> qualifiedIdentifier
            {
                adaptor.addChild(root_0, stream_qualifiedIdentifier.nextTree());

            }

            retval.tree = root_0;}
            }

            // LeMaVM.g:754:9: ( ( arrayDeclarator -> ^( arrayDeclarator $qualifiedIdentExpression) )+ ( DOT CLASS -> ^( DOT $qualifiedIdentExpression CLASS ) ) | arguments -> ^( METHOD_CALL qualifiedIdentifier arguments ) | outerDot= DOT ( CLASS -> ^( DOT qualifiedIdentifier CLASS ) | (Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | SUPER innerDot= DOT IDENT arguments -> ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments ) | IDENT arguments -> ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments ) ) | THIS -> ^( DOT qualifiedIdentifier THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | innerNewExpression -> ^( DOT qualifiedIdentifier innerNewExpression ) ) )?
            int alt89=4;
            alt89 = dfa89.predict(input);
            switch (alt89) {
                case 1 :
                    // LeMaVM.g:754:13: ( arrayDeclarator -> ^( arrayDeclarator $qualifiedIdentExpression) )+ ( DOT CLASS -> ^( DOT $qualifiedIdentExpression CLASS ) )
                    {
                    // LeMaVM.g:754:13: ( arrayDeclarator -> ^( arrayDeclarator $qualifiedIdentExpression) )+
                    int cnt86=0;
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==LBRACK) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // LeMaVM.g:754:17: arrayDeclarator
                    	    {
                    	    pushFollow(FOLLOW_arrayDeclarator_in_qualifiedIdentExpression10175);
                    	    arrayDeclarator311=arrayDeclarator();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_arrayDeclarator.add(arrayDeclarator311.getTree());


                    	    // AST REWRITE
                    	    // elements: arrayDeclarator, qualifiedIdentExpression
                    	    // token labels: 
                    	    // rule labels: retval
                    	    // token list labels: 
                    	    // rule list labels: 
                    	    // wildcard labels: 
                    	    if ( state.backtracking==0 ) {
                    	    retval.tree = root_0;
                    	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    	    root_0 = (CommonTree)adaptor.nil();
                    	    // 754:57: -> ^( arrayDeclarator $qualifiedIdentExpression)
                    	    {
                    	        // LeMaVM.g:754:61: ^( arrayDeclarator $qualifiedIdentExpression)
                    	        {
                    	        CommonTree root_1 = (CommonTree)adaptor.nil();
                    	        root_1 = (CommonTree)adaptor.becomeRoot(stream_arrayDeclarator.nextNode(), root_1);

                    	        adaptor.addChild(root_1, stream_retval.nextTree());

                    	        adaptor.addChild(root_0, root_1);
                    	        }

                    	    }

                    	    retval.tree = root_0;}
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt86 >= 1 ) break loop86;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(86, input);
                                throw eee;
                        }
                        cnt86++;
                    } while (true);

                    // LeMaVM.g:756:13: ( DOT CLASS -> ^( DOT $qualifiedIdentExpression CLASS ) )
                    // LeMaVM.g:756:17: DOT CLASS
                    {
                    DOT312=(Token)match(input,DOT,FOLLOW_DOT_in_qualifiedIdentExpression10243); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT312);

                    CLASS313=(Token)match(input,CLASS,FOLLOW_CLASS_in_qualifiedIdentExpression10245); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CLASS.add(CLASS313);



                    // AST REWRITE
                    // elements: DOT, CLASS, qualifiedIdentExpression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 756:57: -> ^( DOT $qualifiedIdentExpression CLASS )
                    {
                        // LeMaVM.g:756:61: ^( DOT $qualifiedIdentExpression CLASS )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_retval.nextTree());
                        adaptor.addChild(root_1, stream_CLASS.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 2 :
                    // LeMaVM.g:758:13: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_qualifiedIdentExpression10315);
                    arguments314=arguments();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_arguments.add(arguments314.getTree());


                    // AST REWRITE
                    // elements: arguments, qualifiedIdentifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 758:57: -> ^( METHOD_CALL qualifiedIdentifier arguments )
                    {
                        // LeMaVM.g:758:61: ^( METHOD_CALL qualifiedIdentifier arguments )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL"), root_1);

                        adaptor.addChild(root_1, stream_qualifiedIdentifier.nextTree());
                        adaptor.addChild(root_1, stream_arguments.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // LeMaVM.g:759:13: outerDot= DOT ( CLASS -> ^( DOT qualifiedIdentifier CLASS ) | (Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | SUPER innerDot= DOT IDENT arguments -> ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments ) | IDENT arguments -> ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments ) ) | THIS -> ^( DOT qualifiedIdentifier THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | innerNewExpression -> ^( DOT qualifiedIdentifier innerNewExpression ) )
                    {
                    outerDot=(Token)match(input,DOT,FOLLOW_DOT_in_qualifiedIdentExpression10376); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(outerDot);

                    // LeMaVM.g:760:13: ( CLASS -> ^( DOT qualifiedIdentifier CLASS ) | (Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | SUPER innerDot= DOT IDENT arguments -> ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments ) | IDENT arguments -> ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments ) ) | THIS -> ^( DOT qualifiedIdentifier THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | innerNewExpression -> ^( DOT qualifiedIdentifier innerNewExpression ) )
                    int alt88=5;
                    switch ( input.LA(1) ) {
                    case CLASS:
                        {
                        alt88=1;
                        }
                        break;
                    case SUPER:
                        {
                        int LA88_2 = input.LA(2);

                        if ( (synpred146_LeMaVM()) ) {
                            alt88=2;
                        }
                        else if ( (synpred148_LeMaVM()) ) {
                            alt88=4;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 88, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case IDENT:
                        {
                        alt88=2;
                        }
                        break;
                    case THIS:
                        {
                        alt88=3;
                        }
                        break;
                    case NEW:
                        {
                        alt88=5;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 88, 0, input);

                        throw nvae;
                    }

                    switch (alt88) {
                        case 1 :
                            // LeMaVM.g:760:17: CLASS
                            {
                            CLASS315=(Token)match(input,CLASS,FOLLOW_CLASS_in_qualifiedIdentExpression10394); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_CLASS.add(CLASS315);



                            // AST REWRITE
                            // elements: DOT, CLASS, qualifiedIdentifier
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 760:57: -> ^( DOT qualifiedIdentifier CLASS )
                            {
                                // LeMaVM.g:760:61: ^( DOT qualifiedIdentifier CLASS )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_qualifiedIdentifier.nextTree());
                                adaptor.addChild(root_1, stream_CLASS.nextNode());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // LeMaVM.g:761:17: (Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | SUPER innerDot= DOT IDENT arguments -> ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments ) | IDENT arguments -> ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments ) )
                            {
                            // LeMaVM.g:761:17: (Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | SUPER innerDot= DOT IDENT arguments -> ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments ) | IDENT arguments -> ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments ) )
                            int alt87=3;
                            int LA87_0 = input.LA(1);

                            if ( (LA87_0==SUPER) ) {
                                int LA87_1 = input.LA(2);

                                if ( (LA87_1==DOT) ) {
                                    alt87=2;
                                }
                                else if ( (LA87_1==LPAREN) ) {
                                    alt87=1;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 87, 1, input);

                                    throw nvae;
                                }
                            }
                            else if ( (LA87_0==IDENT) ) {
                                alt87=3;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 87, 0, input);

                                throw nvae;
                            }
                            switch (alt87) {
                                case 1 :
                                    // LeMaVM.g:761:21: Super= SUPER arguments
                                    {
                                    Super=(Token)match(input,SUPER,FOLLOW_SUPER_in_qualifiedIdentExpression10463); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_SUPER.add(Super);

                                    pushFollow(FOLLOW_arguments_in_qualifiedIdentExpression10465);
                                    arguments316=arguments();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_arguments.add(arguments316.getTree());


                                    // AST REWRITE
                                    // elements: arguments, qualifiedIdentifier
                                    // token labels: 
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    if ( state.backtracking==0 ) {
                                    retval.tree = root_0;
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (CommonTree)adaptor.nil();
                                    // 761:57: -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments )
                                    {
                                        // LeMaVM.g:761:61: ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments )
                                        {
                                        CommonTree root_1 = (CommonTree)adaptor.nil();
                                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUPER_CONSTRUCTOR_CALL, Super, "SUPER_CONSTRUCTOR_CALL"), root_1);

                                        adaptor.addChild(root_1, stream_qualifiedIdentifier.nextTree());
                                        adaptor.addChild(root_1, stream_arguments.nextTree());

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }

                                    retval.tree = root_0;}
                                    }
                                    break;
                                case 2 :
                                    // LeMaVM.g:762:21: SUPER innerDot= DOT IDENT arguments
                                    {
                                    SUPER317=(Token)match(input,SUPER,FOLLOW_SUPER_in_qualifiedIdentExpression10513); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_SUPER.add(SUPER317);

                                    innerDot=(Token)match(input,DOT,FOLLOW_DOT_in_qualifiedIdentExpression10517); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_DOT.add(innerDot);

                                    IDENT318=(Token)match(input,IDENT,FOLLOW_IDENT_in_qualifiedIdentExpression10519); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT318);

                                    pushFollow(FOLLOW_arguments_in_qualifiedIdentExpression10521);
                                    arguments319=arguments();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_arguments.add(arguments319.getTree());


                                    // AST REWRITE
                                    // elements: innerDot, arguments, SUPER, qualifiedIdentifier, IDENT, outerDot
                                    // token labels: outerDot, innerDot
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    if ( state.backtracking==0 ) {
                                    retval.tree = root_0;
                                    RewriteRuleTokenStream stream_outerDot=new RewriteRuleTokenStream(adaptor,"token outerDot",outerDot);
                                    RewriteRuleTokenStream stream_innerDot=new RewriteRuleTokenStream(adaptor,"token innerDot",innerDot);
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (CommonTree)adaptor.nil();
                                    // 762:57: -> ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments )
                                    {
                                        // LeMaVM.g:762:61: ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments )
                                        {
                                        CommonTree root_1 = (CommonTree)adaptor.nil();
                                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL"), root_1);

                                        // LeMaVM.g:762:75: ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT )
                                        {
                                        CommonTree root_2 = (CommonTree)adaptor.nil();
                                        root_2 = (CommonTree)adaptor.becomeRoot(stream_innerDot.nextNode(), root_2);

                                        // LeMaVM.g:762:87: ^( $outerDot qualifiedIdentifier SUPER )
                                        {
                                        CommonTree root_3 = (CommonTree)adaptor.nil();
                                        root_3 = (CommonTree)adaptor.becomeRoot(stream_outerDot.nextNode(), root_3);

                                        adaptor.addChild(root_3, stream_qualifiedIdentifier.nextTree());
                                        adaptor.addChild(root_3, stream_SUPER.nextNode());

                                        adaptor.addChild(root_2, root_3);
                                        }
                                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                                        adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_1, stream_arguments.nextTree());

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }

                                    retval.tree = root_0;}
                                    }
                                    break;
                                case 3 :
                                    // LeMaVM.g:763:21: IDENT arguments
                                    {
                                    IDENT320=(Token)match(input,IDENT,FOLLOW_IDENT_in_qualifiedIdentExpression10569); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT320);

                                    pushFollow(FOLLOW_arguments_in_qualifiedIdentExpression10571);
                                    arguments321=arguments();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_arguments.add(arguments321.getTree());


                                    // AST REWRITE
                                    // elements: arguments, qualifiedIdentifier, IDENT, DOT
                                    // token labels: 
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    if ( state.backtracking==0 ) {
                                    retval.tree = root_0;
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (CommonTree)adaptor.nil();
                                    // 763:57: -> ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments )
                                    {
                                        // LeMaVM.g:763:61: ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments )
                                        {
                                        CommonTree root_1 = (CommonTree)adaptor.nil();
                                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(METHOD_CALL, "METHOD_CALL"), root_1);

                                        // LeMaVM.g:763:75: ^( DOT qualifiedIdentifier IDENT )
                                        {
                                        CommonTree root_2 = (CommonTree)adaptor.nil();
                                        root_2 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_2);

                                        adaptor.addChild(root_2, stream_qualifiedIdentifier.nextTree());
                                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                                        adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_1, stream_arguments.nextTree());

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }

                                    retval.tree = root_0;}
                                    }
                                    break;

                            }


                            }
                            break;
                        case 3 :
                            // LeMaVM.g:765:17: THIS
                            {
                            THIS322=(Token)match(input,THIS,FOLLOW_THIS_in_qualifiedIdentExpression10644); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_THIS.add(THIS322);



                            // AST REWRITE
                            // elements: DOT, qualifiedIdentifier, THIS
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 765:57: -> ^( DOT qualifiedIdentifier THIS )
                            {
                                // LeMaVM.g:765:61: ^( DOT qualifiedIdentifier THIS )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_qualifiedIdentifier.nextTree());
                                adaptor.addChild(root_1, stream_THIS.nextNode());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 4 :
                            // LeMaVM.g:766:17: Super= SUPER arguments
                            {
                            Super=(Token)match(input,SUPER,FOLLOW_SUPER_in_qualifiedIdentExpression10710); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SUPER.add(Super);

                            pushFollow(FOLLOW_arguments_in_qualifiedIdentExpression10712);
                            arguments323=arguments();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_arguments.add(arguments323.getTree());


                            // AST REWRITE
                            // elements: qualifiedIdentifier, arguments
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 766:57: -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments )
                            {
                                // LeMaVM.g:766:61: ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUPER_CONSTRUCTOR_CALL, Super, "SUPER_CONSTRUCTOR_CALL"), root_1);

                                adaptor.addChild(root_1, stream_qualifiedIdentifier.nextTree());
                                adaptor.addChild(root_1, stream_arguments.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 5 :
                            // LeMaVM.g:767:17: innerNewExpression
                            {
                            pushFollow(FOLLOW_innerNewExpression_in_qualifiedIdentExpression10760);
                            innerNewExpression324=innerNewExpression();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_innerNewExpression.add(innerNewExpression324.getTree());


                            // AST REWRITE
                            // elements: qualifiedIdentifier, DOT, innerNewExpression
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 767:57: -> ^( DOT qualifiedIdentifier innerNewExpression )
                            {
                                // LeMaVM.g:767:61: ^( DOT qualifiedIdentifier innerNewExpression )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(stream_DOT.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_qualifiedIdentifier.nextTree());
                                adaptor.addChild(root_1, stream_innerNewExpression.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, qualifiedIdentExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "qualifiedIdentExpression"

    public static class newExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "newExpression"
    // LeMaVM.g:772:1: newExpression : NEW ( primitiveType newArrayConstruction -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] primitiveType newArrayConstruction ) | qualifiedTypeIdentSimplified ( newArrayConstruction -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified newArrayConstruction ) | arguments ( classBody )? -> ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified arguments ( classBody )? ) ) ) ;
    public final LeMaVMParser.newExpression_return newExpression() throws RecognitionException {
        LeMaVMParser.newExpression_return retval = new LeMaVMParser.newExpression_return();
        retval.start = input.LT(1);
        int newExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token NEW325=null;
        LeMaVMParser.primitiveType_return primitiveType326 = null;

        LeMaVMParser.newArrayConstruction_return newArrayConstruction327 = null;

        LeMaVMParser.qualifiedTypeIdentSimplified_return qualifiedTypeIdentSimplified328 = null;

        LeMaVMParser.newArrayConstruction_return newArrayConstruction329 = null;

        LeMaVMParser.arguments_return arguments330 = null;

        LeMaVMParser.classBody_return classBody331 = null;


        CommonTree NEW325_tree=null;
        RewriteRuleTokenStream stream_NEW=new RewriteRuleTokenStream(adaptor,"token NEW");
        RewriteRuleSubtreeStream stream_newArrayConstruction=new RewriteRuleSubtreeStream(adaptor,"rule newArrayConstruction");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_qualifiedTypeIdentSimplified=new RewriteRuleSubtreeStream(adaptor,"rule qualifiedTypeIdentSimplified");
        RewriteRuleSubtreeStream stream_primitiveType=new RewriteRuleSubtreeStream(adaptor,"rule primitiveType");
        RewriteRuleSubtreeStream stream_classBody=new RewriteRuleSubtreeStream(adaptor,"rule classBody");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return retval; }
            // LeMaVM.g:773:5: ( NEW ( primitiveType newArrayConstruction -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] primitiveType newArrayConstruction ) | qualifiedTypeIdentSimplified ( newArrayConstruction -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified newArrayConstruction ) | arguments ( classBody )? -> ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified arguments ( classBody )? ) ) ) )
            // LeMaVM.g:773:9: NEW ( primitiveType newArrayConstruction -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] primitiveType newArrayConstruction ) | qualifiedTypeIdentSimplified ( newArrayConstruction -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified newArrayConstruction ) | arguments ( classBody )? -> ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified arguments ( classBody )? ) ) )
            {
            NEW325=(Token)match(input,NEW,FOLLOW_NEW_in_newExpression10836); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEW.add(NEW325);

            // LeMaVM.g:774:9: ( primitiveType newArrayConstruction -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] primitiveType newArrayConstruction ) | qualifiedTypeIdentSimplified ( newArrayConstruction -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified newArrayConstruction ) | arguments ( classBody )? -> ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified arguments ( classBody )? ) ) )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==BOOLEAN||LA92_0==DOUBLE||(LA92_0>=INT && LA92_0<=LONG)||LA92_0==SHORT||LA92_0==STRING) ) {
                alt92=1;
            }
            else if ( (LA92_0==IDENT) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // LeMaVM.g:774:13: primitiveType newArrayConstruction
                    {
                    pushFollow(FOLLOW_primitiveType_in_newExpression10852);
                    primitiveType326=primitiveType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_primitiveType.add(primitiveType326.getTree());
                    pushFollow(FOLLOW_newArrayConstruction_in_newExpression10854);
                    newArrayConstruction327=newArrayConstruction();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_newArrayConstruction.add(newArrayConstruction327.getTree());


                    // AST REWRITE
                    // elements: primitiveType, newArrayConstruction
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 775:13: -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] primitiveType newArrayConstruction )
                    {
                        // LeMaVM.g:775:17: ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] primitiveType newArrayConstruction )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STATIC_ARRAY_CREATOR, NEW325, "STATIC_ARRAY_CREATOR"), root_1);

                        adaptor.addChild(root_1, stream_primitiveType.nextTree());
                        adaptor.addChild(root_1, stream_newArrayConstruction.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // LeMaVM.g:776:13: qualifiedTypeIdentSimplified ( newArrayConstruction -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified newArrayConstruction ) | arguments ( classBody )? -> ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified arguments ( classBody )? ) )
                    {
                    pushFollow(FOLLOW_qualifiedTypeIdentSimplified_in_newExpression10898);
                    qualifiedTypeIdentSimplified328=qualifiedTypeIdentSimplified();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_qualifiedTypeIdentSimplified.add(qualifiedTypeIdentSimplified328.getTree());
                    // LeMaVM.g:777:13: ( newArrayConstruction -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified newArrayConstruction ) | arguments ( classBody )? -> ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified arguments ( classBody )? ) )
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==LBRACK) ) {
                        alt91=1;
                    }
                    else if ( (LA91_0==LPAREN) ) {
                        alt91=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 91, 0, input);

                        throw nvae;
                    }
                    switch (alt91) {
                        case 1 :
                            // LeMaVM.g:777:17: newArrayConstruction
                            {
                            pushFollow(FOLLOW_newArrayConstruction_in_newExpression10916);
                            newArrayConstruction329=newArrayConstruction();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_newArrayConstruction.add(newArrayConstruction329.getTree());


                            // AST REWRITE
                            // elements: qualifiedTypeIdentSimplified, newArrayConstruction
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 778:17: -> ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified newArrayConstruction )
                            {
                                // LeMaVM.g:778:21: ^( STATIC_ARRAY_CREATOR[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified newArrayConstruction )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STATIC_ARRAY_CREATOR, NEW325, "STATIC_ARRAY_CREATOR"), root_1);

                                adaptor.addChild(root_1, stream_qualifiedTypeIdentSimplified.nextTree());
                                adaptor.addChild(root_1, stream_newArrayConstruction.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // LeMaVM.g:779:17: arguments ( classBody )?
                            {
                            pushFollow(FOLLOW_arguments_in_newExpression10978);
                            arguments330=arguments();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_arguments.add(arguments330.getTree());
                            // LeMaVM.g:779:27: ( classBody )?
                            int alt90=2;
                            int LA90_0 = input.LA(1);

                            if ( (LA90_0==LCURLY) ) {
                                alt90=1;
                            }
                            switch (alt90) {
                                case 1 :
                                    // LeMaVM.g:0:0: classBody
                                    {
                                    pushFollow(FOLLOW_classBody_in_newExpression10980);
                                    classBody331=classBody();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_classBody.add(classBody331.getTree());

                                    }
                                    break;

                            }



                            // AST REWRITE
                            // elements: arguments, classBody, qualifiedTypeIdentSimplified
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 780:17: -> ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified arguments ( classBody )? )
                            {
                                // LeMaVM.g:780:21: ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] qualifiedTypeIdentSimplified arguments ( classBody )? )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CLASS_CONSTRUCTOR_CALL, NEW325, "STATIC_ARRAY_CREATOR"), root_1);

                                adaptor.addChild(root_1, stream_qualifiedTypeIdentSimplified.nextTree());
                                adaptor.addChild(root_1, stream_arguments.nextTree());
                                // LeMaVM.g:780:115: ( classBody )?
                                if ( stream_classBody.hasNext() ) {
                                    adaptor.addChild(root_1, stream_classBody.nextTree());

                                }
                                stream_classBody.reset();

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, newExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "newExpression"

    public static class innerNewExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "innerNewExpression"
    // LeMaVM.g:785:1: innerNewExpression : NEW IDENT arguments ( classBody )? -> ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] IDENT arguments ( classBody )? ) ;
    public final LeMaVMParser.innerNewExpression_return innerNewExpression() throws RecognitionException {
        LeMaVMParser.innerNewExpression_return retval = new LeMaVMParser.innerNewExpression_return();
        retval.start = input.LT(1);
        int innerNewExpression_StartIndex = input.index();
        CommonTree root_0 = null;

        Token NEW332=null;
        Token IDENT333=null;
        LeMaVMParser.arguments_return arguments334 = null;

        LeMaVMParser.classBody_return classBody335 = null;


        CommonTree NEW332_tree=null;
        CommonTree IDENT333_tree=null;
        RewriteRuleTokenStream stream_NEW=new RewriteRuleTokenStream(adaptor,"token NEW");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        RewriteRuleSubtreeStream stream_classBody=new RewriteRuleSubtreeStream(adaptor,"rule classBody");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return retval; }
            // LeMaVM.g:786:5: ( NEW IDENT arguments ( classBody )? -> ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] IDENT arguments ( classBody )? ) )
            // LeMaVM.g:786:9: NEW IDENT arguments ( classBody )?
            {
            NEW332=(Token)match(input,NEW,FOLLOW_NEW_in_innerNewExpression11076); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEW.add(NEW332);

            IDENT333=(Token)match(input,IDENT,FOLLOW_IDENT_in_innerNewExpression11078); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT333);

            pushFollow(FOLLOW_arguments_in_innerNewExpression11080);
            arguments334=arguments();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_arguments.add(arguments334.getTree());
            // LeMaVM.g:786:29: ( classBody )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==LCURLY) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // LeMaVM.g:0:0: classBody
                    {
                    pushFollow(FOLLOW_classBody_in_innerNewExpression11082);
                    classBody335=classBody();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_classBody.add(classBody335.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: arguments, classBody, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 787:9: -> ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] IDENT arguments ( classBody )? )
            {
                // LeMaVM.g:787:13: ^( CLASS_CONSTRUCTOR_CALL[$NEW, \"STATIC_ARRAY_CREATOR\"] IDENT arguments ( classBody )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CLASS_CONSTRUCTOR_CALL, NEW332, "STATIC_ARRAY_CREATOR"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());
                adaptor.addChild(root_1, stream_arguments.nextTree());
                // LeMaVM.g:787:84: ( classBody )?
                if ( stream_classBody.hasNext() ) {
                    adaptor.addChild(root_1, stream_classBody.nextTree());

                }
                stream_classBody.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, innerNewExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "innerNewExpression"

    public static class newArrayConstruction_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "newArrayConstruction"
    // LeMaVM.g:790:1: newArrayConstruction : ( arrayDeclaratorList arrayInitializer | LBRACK expression RBRACK ( LBRACK expression RBRACK )* ( arrayDeclaratorList )? );
    public final LeMaVMParser.newArrayConstruction_return newArrayConstruction() throws RecognitionException {
        LeMaVMParser.newArrayConstruction_return retval = new LeMaVMParser.newArrayConstruction_return();
        retval.start = input.LT(1);
        int newArrayConstruction_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LBRACK338=null;
        Token RBRACK340=null;
        Token LBRACK341=null;
        Token RBRACK343=null;
        LeMaVMParser.arrayDeclaratorList_return arrayDeclaratorList336 = null;

        LeMaVMParser.arrayInitializer_return arrayInitializer337 = null;

        LeMaVMParser.expression_return expression339 = null;

        LeMaVMParser.expression_return expression342 = null;

        LeMaVMParser.arrayDeclaratorList_return arrayDeclaratorList344 = null;


        CommonTree LBRACK338_tree=null;
        CommonTree RBRACK340_tree=null;
        CommonTree LBRACK341_tree=null;
        CommonTree RBRACK343_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return retval; }
            // LeMaVM.g:791:5: ( arrayDeclaratorList arrayInitializer | LBRACK expression RBRACK ( LBRACK expression RBRACK )* ( arrayDeclaratorList )? )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==LBRACK) ) {
                int LA96_1 = input.LA(2);

                if ( (LA96_1==RBRACK) ) {
                    alt96=1;
                }
                else if ( (LA96_1==DEC||LA96_1==INC||LA96_1==LOGICAL_NOT||(LA96_1>=LPAREN && LA96_1<=MINUS)||LA96_1==NOT||LA96_1==PLUS||LA96_1==BOOLEAN||LA96_1==DOUBLE||LA96_1==FALSE||(LA96_1>=INT && LA96_1<=NULL)||LA96_1==SHORT||(LA96_1>=STRING && LA96_1<=SUPER)||(LA96_1>=THIS && LA96_1<=TRUE)||LA96_1==VOID||(LA96_1>=IDENT && LA96_1<=STRING_LITERAL)) ) {
                    alt96=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 96, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // LeMaVM.g:791:9: arrayDeclaratorList arrayInitializer
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayDeclaratorList_in_newArrayConstruction11125);
                    arrayDeclaratorList336=arrayDeclaratorList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayDeclaratorList336.getTree());
                    pushFollow(FOLLOW_arrayInitializer_in_newArrayConstruction11127);
                    arrayInitializer337=arrayInitializer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayInitializer337.getTree());

                    }
                    break;
                case 2 :
                    // LeMaVM.g:792:9: LBRACK expression RBRACK ( LBRACK expression RBRACK )* ( arrayDeclaratorList )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LBRACK338=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_newArrayConstruction11137); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_newArrayConstruction11140);
                    expression339=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression339.getTree());
                    RBRACK340=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_newArrayConstruction11142); if (state.failed) return retval;
                    // LeMaVM.g:792:36: ( LBRACK expression RBRACK )*
                    loop94:
                    do {
                        int alt94=2;
                        alt94 = dfa94.predict(input);
                        switch (alt94) {
                    	case 1 :
                    	    // LeMaVM.g:792:37: LBRACK expression RBRACK
                    	    {
                    	    LBRACK341=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_newArrayConstruction11146); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_expression_in_newArrayConstruction11149);
                    	    expression342=expression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression342.getTree());
                    	    RBRACK343=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_newArrayConstruction11151); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop94;
                        }
                    } while (true);

                    // LeMaVM.g:792:66: ( arrayDeclaratorList )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==LBRACK) ) {
                        int LA95_1 = input.LA(2);

                        if ( (LA95_1==RBRACK) ) {
                            alt95=1;
                        }
                    }
                    switch (alt95) {
                        case 1 :
                            // LeMaVM.g:0:0: arrayDeclaratorList
                            {
                            pushFollow(FOLLOW_arrayDeclaratorList_in_newArrayConstruction11156);
                            arrayDeclaratorList344=arrayDeclaratorList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayDeclaratorList344.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, newArrayConstruction_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "newArrayConstruction"

    public static class arguments_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // LeMaVM.g:795:1: arguments : LPAREN ( expressionList )? RPAREN -> ^( ARGUMENT_LIST[$LPAREN, \"ARGUMENT_LIST\"] ( expressionList )? ) ;
    public final LeMaVMParser.arguments_return arguments() throws RecognitionException {
        LeMaVMParser.arguments_return retval = new LeMaVMParser.arguments_return();
        retval.start = input.LT(1);
        int arguments_StartIndex = input.index();
        CommonTree root_0 = null;

        Token LPAREN345=null;
        Token RPAREN347=null;
        LeMaVMParser.expressionList_return expressionList346 = null;


        CommonTree LPAREN345_tree=null;
        CommonTree RPAREN347_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expressionList=new RewriteRuleSubtreeStream(adaptor,"rule expressionList");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return retval; }
            // LeMaVM.g:796:5: ( LPAREN ( expressionList )? RPAREN -> ^( ARGUMENT_LIST[$LPAREN, \"ARGUMENT_LIST\"] ( expressionList )? ) )
            // LeMaVM.g:796:9: LPAREN ( expressionList )? RPAREN
            {
            LPAREN345=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_arguments11176); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN345);

            // LeMaVM.g:796:16: ( expressionList )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==DEC||LA97_0==INC||LA97_0==LOGICAL_NOT||(LA97_0>=LPAREN && LA97_0<=MINUS)||LA97_0==NOT||LA97_0==PLUS||LA97_0==BOOLEAN||LA97_0==DOUBLE||LA97_0==FALSE||(LA97_0>=INT && LA97_0<=NULL)||LA97_0==SHORT||(LA97_0>=STRING && LA97_0<=SUPER)||(LA97_0>=THIS && LA97_0<=TRUE)||LA97_0==VOID||(LA97_0>=IDENT && LA97_0<=STRING_LITERAL)) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // LeMaVM.g:0:0: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_arguments11178);
                    expressionList346=expressionList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expressionList.add(expressionList346.getTree());

                    }
                    break;

            }

            RPAREN347=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_arguments11181); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN347);



            // AST REWRITE
            // elements: expressionList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 797:9: -> ^( ARGUMENT_LIST[$LPAREN, \"ARGUMENT_LIST\"] ( expressionList )? )
            {
                // LeMaVM.g:797:13: ^( ARGUMENT_LIST[$LPAREN, \"ARGUMENT_LIST\"] ( expressionList )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGUMENT_LIST, LPAREN345, "ARGUMENT_LIST"), root_1);

                // LeMaVM.g:797:55: ( expressionList )?
                if ( stream_expressionList.hasNext() ) {
                    adaptor.addChild(root_1, stream_expressionList.nextTree());

                }
                stream_expressionList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, arguments_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "arguments"

    public static class literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // LeMaVM.g:800:1: literal : ( HEX_LITERAL | OCTAL_LITERAL | DECIMAL_LITERAL | FLOATING_POINT_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | TRUE | FALSE | NULL );
    public final LeMaVMParser.literal_return literal() throws RecognitionException {
        LeMaVMParser.literal_return retval = new LeMaVMParser.literal_return();
        retval.start = input.LT(1);
        int literal_StartIndex = input.index();
        CommonTree root_0 = null;

        Token set348=null;

        CommonTree set348_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return retval; }
            // LeMaVM.g:801:5: ( HEX_LITERAL | OCTAL_LITERAL | DECIMAL_LITERAL | FLOATING_POINT_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | TRUE | FALSE | NULL )
            // LeMaVM.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set348=(Token)input.LT(1);
            if ( input.LA(1)==FALSE||input.LA(1)==NULL||input.LA(1)==TRUE||(input.LA(1)>=HEX_LITERAL && input.LA(1)<=STRING_LITERAL) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set348));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, literal_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "literal"

    // $ANTLR start synpred49_LeMaVM
    public final void synpred49_LeMaVM_fragment() throws RecognitionException {   
        Token ident=null;

        // LeMaVM.g:492:13: ( DOT ident= IDENT )
        // LeMaVM.g:492:13: DOT ident= IDENT
        {
        match(input,DOT,FOLLOW_DOT_in_synpred49_LeMaVM5676); if (state.failed) return ;
        ident=(Token)match(input,IDENT,FOLLOW_IDENT_in_synpred49_LeMaVM5680); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_LeMaVM

    // $ANTLR start synpred54_LeMaVM
    public final void synpred54_LeMaVM_fragment() throws RecognitionException {   
        LeMaVMParser.statement_return elseStat = null;


        // LeMaVM.g:518:13: ( ELSE elseStat= statement )
        // LeMaVM.g:518:13: ELSE elseStat= statement
        {
        match(input,ELSE,FOLLOW_ELSE_in_synpred54_LeMaVM5906); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred54_LeMaVM5910);
        elseStat=statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_LeMaVM

    // $ANTLR start synpred70_LeMaVM
    public final void synpred70_LeMaVM_fragment() throws RecognitionException {   
        // LeMaVM.g:543:9: ( switchCaseLabel )
        // LeMaVM.g:543:9: switchCaseLabel
        {
        pushFollow(FOLLOW_switchCaseLabel_in_synpred70_LeMaVM6784);
        switchCaseLabel();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred70_LeMaVM

    // $ANTLR start synpred114_LeMaVM
    public final void synpred114_LeMaVM_fragment() throws RecognitionException {   
        // LeMaVM.g:689:9: ( LPAREN type RPAREN unaryExpression )
        // LeMaVM.g:689:9: LPAREN type RPAREN unaryExpression
        {
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred114_LeMaVM8372); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred114_LeMaVM8374);
        type();

        state._fsp--;
        if (state.failed) return ;
        match(input,RPAREN,FOLLOW_RPAREN_in_synpred114_LeMaVM8376); if (state.failed) return ;
        pushFollow(FOLLOW_unaryExpression_in_synpred114_LeMaVM8378);
        unaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred114_LeMaVM

    // $ANTLR start synpred128_LeMaVM
    public final void synpred128_LeMaVM_fragment() throws RecognitionException {   
        // LeMaVM.g:723:9: ( qualifiedIdentExpression )
        // LeMaVM.g:723:9: qualifiedIdentExpression
        {
        pushFollow(FOLLOW_qualifiedIdentExpression_in_synpred128_LeMaVM9197);
        qualifiedIdentExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred128_LeMaVM

    // $ANTLR start synpred132_LeMaVM
    public final void synpred132_LeMaVM_fragment() throws RecognitionException {   
        // LeMaVM.g:724:9: ( ( SUPER ( arguments | DOT IDENT arguments ) | IDENT arguments | THIS arguments ) )
        // LeMaVM.g:724:9: ( SUPER ( arguments | DOT IDENT arguments ) | IDENT arguments | THIS arguments )
        {
        // LeMaVM.g:724:9: ( SUPER ( arguments | DOT IDENT arguments ) | IDENT arguments | THIS arguments )
        int alt125=3;
        switch ( input.LA(1) ) {
        case SUPER:
            {
            alt125=1;
            }
            break;
        case IDENT:
            {
            alt125=2;
            }
            break;
        case THIS:
            {
            alt125=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 125, 0, input);

            throw nvae;
        }

        switch (alt125) {
            case 1 :
                // LeMaVM.g:724:13: SUPER ( arguments | DOT IDENT arguments )
                {
                match(input,SUPER,FOLLOW_SUPER_in_synpred132_LeMaVM9211); if (state.failed) return ;
                // LeMaVM.g:725:13: ( arguments | DOT IDENT arguments )
                int alt124=2;
                int LA124_0 = input.LA(1);

                if ( (LA124_0==LPAREN) ) {
                    alt124=1;
                }
                else if ( (LA124_0==DOT) ) {
                    alt124=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 124, 0, input);

                    throw nvae;
                }
                switch (alt124) {
                    case 1 :
                        // LeMaVM.g:725:17: arguments
                        {
                        pushFollow(FOLLOW_arguments_in_synpred132_LeMaVM9229);
                        arguments();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 2 :
                        // LeMaVM.g:726:17: DOT IDENT arguments
                        {
                        match(input,DOT,FOLLOW_DOT_in_synpred132_LeMaVM9287); if (state.failed) return ;
                        match(input,IDENT,FOLLOW_IDENT_in_synpred132_LeMaVM9289); if (state.failed) return ;
                        pushFollow(FOLLOW_arguments_in_synpred132_LeMaVM9291);
                        arguments();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }


                }
                break;
            case 2 :
                // LeMaVM.g:728:13: IDENT arguments
                {
                match(input,IDENT,FOLLOW_IDENT_in_synpred132_LeMaVM9356); if (state.failed) return ;
                pushFollow(FOLLOW_arguments_in_synpred132_LeMaVM9358);
                arguments();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // LeMaVM.g:729:13: THIS arguments
                {
                match(input,THIS,FOLLOW_THIS_in_synpred132_LeMaVM9411); if (state.failed) return ;
                pushFollow(FOLLOW_arguments_in_synpred132_LeMaVM9413);
                arguments();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred132_LeMaVM

    // $ANTLR start synpred134_LeMaVM
    public final void synpred134_LeMaVM_fragment() throws RecognitionException {   
        // LeMaVM.g:731:9: ( ( THIS ) ( arguments )? )
        // LeMaVM.g:731:9: ( THIS ) ( arguments )?
        {
        // LeMaVM.g:731:9: ( THIS )
        // LeMaVM.g:731:13: THIS
        {
        match(input,THIS,FOLLOW_THIS_in_synpred134_LeMaVM9476); if (state.failed) return ;

        }

        // LeMaVM.g:733:9: ( arguments )?
        int alt126=2;
        int LA126_0 = input.LA(1);

        if ( (LA126_0==LPAREN) ) {
            alt126=1;
        }
        switch (alt126) {
            case 1 :
                // LeMaVM.g:733:13: arguments
                {
                pushFollow(FOLLOW_arguments_in_synpred134_LeMaVM9544);
                arguments();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred134_LeMaVM

    // $ANTLR start synpred135_LeMaVM
    public final void synpred135_LeMaVM_fragment() throws RecognitionException {   
        // LeMaVM.g:735:9: ( SUPER arguments )
        // LeMaVM.g:735:9: SUPER arguments
        {
        match(input,SUPER,FOLLOW_SUPER_in_synpred135_LeMaVM9609); if (state.failed) return ;
        pushFollow(FOLLOW_arguments_in_synpred135_LeMaVM9611);
        arguments();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred135_LeMaVM

    // $ANTLR start synpred137_LeMaVM
    public final void synpred137_LeMaVM_fragment() throws RecognitionException {   
        // LeMaVM.g:736:9: ( ( SUPER DOT IDENT ) ( arguments | ) )
        // LeMaVM.g:736:9: ( SUPER DOT IDENT ) ( arguments | )
        {
        // LeMaVM.g:736:9: ( SUPER DOT IDENT )
        // LeMaVM.g:736:13: SUPER DOT IDENT
        {
        match(input,SUPER,FOLLOW_SUPER_in_synpred137_LeMaVM9667); if (state.failed) return ;
        match(input,DOT,FOLLOW_DOT_in_synpred137_LeMaVM9669); if (state.failed) return ;
        match(input,IDENT,FOLLOW_IDENT_in_synpred137_LeMaVM9671); if (state.failed) return ;

        }

        // LeMaVM.g:738:9: ( arguments | )
        int alt127=2;
        int LA127_0 = input.LA(1);

        if ( (LA127_0==LPAREN) ) {
            alt127=1;
        }
        else if ( (LA127_0==EOF) ) {
            alt127=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 127, 0, input);

            throw nvae;
        }
        switch (alt127) {
            case 1 :
                // LeMaVM.g:738:13: arguments
                {
                pushFollow(FOLLOW_arguments_in_synpred137_LeMaVM9695);
                arguments();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // LeMaVM.g:739:57: 
                {
                }
                break;

        }


        }
    }
    // $ANTLR end synpred137_LeMaVM

    // $ANTLR start synpred141_LeMaVM
    public final void synpred141_LeMaVM_fragment() throws RecognitionException {   
        // LeMaVM.g:754:13: ( ( arrayDeclarator )+ ( DOT CLASS ) )
        // LeMaVM.g:754:13: ( arrayDeclarator )+ ( DOT CLASS )
        {
        // LeMaVM.g:754:13: ( arrayDeclarator )+
        int cnt129=0;
        loop129:
        do {
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==LBRACK) ) {
                alt129=1;
            }


            switch (alt129) {
        	case 1 :
        	    // LeMaVM.g:754:17: arrayDeclarator
        	    {
        	    pushFollow(FOLLOW_arrayDeclarator_in_synpred141_LeMaVM10175);
        	    arrayDeclarator();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt129 >= 1 ) break loop129;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(129, input);
                    throw eee;
            }
            cnt129++;
        } while (true);

        // LeMaVM.g:756:13: ( DOT CLASS )
        // LeMaVM.g:756:17: DOT CLASS
        {
        match(input,DOT,FOLLOW_DOT_in_synpred141_LeMaVM10243); if (state.failed) return ;
        match(input,CLASS,FOLLOW_CLASS_in_synpred141_LeMaVM10245); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred141_LeMaVM

    // $ANTLR start synpred146_LeMaVM
    public final void synpred146_LeMaVM_fragment() throws RecognitionException {   
        Token Super=null;
        Token innerDot=null;

        // LeMaVM.g:761:17: ( (Super= SUPER arguments | SUPER innerDot= DOT IDENT arguments | IDENT arguments ) )
        // LeMaVM.g:761:17: (Super= SUPER arguments | SUPER innerDot= DOT IDENT arguments | IDENT arguments )
        {
        // LeMaVM.g:761:17: (Super= SUPER arguments | SUPER innerDot= DOT IDENT arguments | IDENT arguments )
        int alt130=3;
        int LA130_0 = input.LA(1);

        if ( (LA130_0==SUPER) ) {
            int LA130_1 = input.LA(2);

            if ( (LA130_1==DOT) ) {
                alt130=2;
            }
            else if ( (LA130_1==LPAREN) ) {
                alt130=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 1, input);

                throw nvae;
            }
        }
        else if ( (LA130_0==IDENT) ) {
            alt130=3;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 130, 0, input);

            throw nvae;
        }
        switch (alt130) {
            case 1 :
                // LeMaVM.g:761:21: Super= SUPER arguments
                {
                Super=(Token)match(input,SUPER,FOLLOW_SUPER_in_synpred146_LeMaVM10463); if (state.failed) return ;
                pushFollow(FOLLOW_arguments_in_synpred146_LeMaVM10465);
                arguments();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // LeMaVM.g:762:21: SUPER innerDot= DOT IDENT arguments
                {
                match(input,SUPER,FOLLOW_SUPER_in_synpred146_LeMaVM10513); if (state.failed) return ;
                innerDot=(Token)match(input,DOT,FOLLOW_DOT_in_synpred146_LeMaVM10517); if (state.failed) return ;
                match(input,IDENT,FOLLOW_IDENT_in_synpred146_LeMaVM10519); if (state.failed) return ;
                pushFollow(FOLLOW_arguments_in_synpred146_LeMaVM10521);
                arguments();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 3 :
                // LeMaVM.g:763:21: IDENT arguments
                {
                match(input,IDENT,FOLLOW_IDENT_in_synpred146_LeMaVM10569); if (state.failed) return ;
                pushFollow(FOLLOW_arguments_in_synpred146_LeMaVM10571);
                arguments();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred146_LeMaVM

    // $ANTLR start synpred148_LeMaVM
    public final void synpred148_LeMaVM_fragment() throws RecognitionException {   
        Token Super=null;

        // LeMaVM.g:766:17: (Super= SUPER arguments )
        // LeMaVM.g:766:17: Super= SUPER arguments
        {
        Super=(Token)match(input,SUPER,FOLLOW_SUPER_in_synpred148_LeMaVM10710); if (state.failed) return ;
        pushFollow(FOLLOW_arguments_in_synpred148_LeMaVM10712);
        arguments();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred148_LeMaVM

    // $ANTLR start synpred149_LeMaVM
    public final void synpred149_LeMaVM_fragment() throws RecognitionException {   
        Token outerDot=null;
        Token Super=null;
        Token innerDot=null;

        // LeMaVM.g:759:13: (outerDot= DOT ( CLASS | (Super= SUPER arguments | SUPER innerDot= DOT IDENT arguments | IDENT arguments ) | THIS | Super= SUPER arguments | innerNewExpression ) )
        // LeMaVM.g:759:13: outerDot= DOT ( CLASS | (Super= SUPER arguments | SUPER innerDot= DOT IDENT arguments | IDENT arguments ) | THIS | Super= SUPER arguments | innerNewExpression )
        {
        outerDot=(Token)match(input,DOT,FOLLOW_DOT_in_synpred149_LeMaVM10376); if (state.failed) return ;
        // LeMaVM.g:760:13: ( CLASS | (Super= SUPER arguments | SUPER innerDot= DOT IDENT arguments | IDENT arguments ) | THIS | Super= SUPER arguments | innerNewExpression )
        int alt132=5;
        switch ( input.LA(1) ) {
        case CLASS:
            {
            alt132=1;
            }
            break;
        case SUPER:
            {
            int LA132_2 = input.LA(2);

            if ( (synpred146_LeMaVM()) ) {
                alt132=2;
            }
            else if ( (synpred148_LeMaVM()) ) {
                alt132=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 2, input);

                throw nvae;
            }
            }
            break;
        case IDENT:
            {
            alt132=2;
            }
            break;
        case THIS:
            {
            alt132=3;
            }
            break;
        case NEW:
            {
            alt132=5;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 132, 0, input);

            throw nvae;
        }

        switch (alt132) {
            case 1 :
                // LeMaVM.g:760:17: CLASS
                {
                match(input,CLASS,FOLLOW_CLASS_in_synpred149_LeMaVM10394); if (state.failed) return ;

                }
                break;
            case 2 :
                // LeMaVM.g:761:17: (Super= SUPER arguments | SUPER innerDot= DOT IDENT arguments | IDENT arguments )
                {
                // LeMaVM.g:761:17: (Super= SUPER arguments | SUPER innerDot= DOT IDENT arguments | IDENT arguments )
                int alt131=3;
                int LA131_0 = input.LA(1);

                if ( (LA131_0==SUPER) ) {
                    int LA131_1 = input.LA(2);

                    if ( (LA131_1==DOT) ) {
                        alt131=2;
                    }
                    else if ( (LA131_1==LPAREN) ) {
                        alt131=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 131, 1, input);

                        throw nvae;
                    }
                }
                else if ( (LA131_0==IDENT) ) {
                    alt131=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 131, 0, input);

                    throw nvae;
                }
                switch (alt131) {
                    case 1 :
                        // LeMaVM.g:761:21: Super= SUPER arguments
                        {
                        Super=(Token)match(input,SUPER,FOLLOW_SUPER_in_synpred149_LeMaVM10463); if (state.failed) return ;
                        pushFollow(FOLLOW_arguments_in_synpred149_LeMaVM10465);
                        arguments();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 2 :
                        // LeMaVM.g:762:21: SUPER innerDot= DOT IDENT arguments
                        {
                        match(input,SUPER,FOLLOW_SUPER_in_synpred149_LeMaVM10513); if (state.failed) return ;
                        innerDot=(Token)match(input,DOT,FOLLOW_DOT_in_synpred149_LeMaVM10517); if (state.failed) return ;
                        match(input,IDENT,FOLLOW_IDENT_in_synpred149_LeMaVM10519); if (state.failed) return ;
                        pushFollow(FOLLOW_arguments_in_synpred149_LeMaVM10521);
                        arguments();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;
                    case 3 :
                        // LeMaVM.g:763:21: IDENT arguments
                        {
                        match(input,IDENT,FOLLOW_IDENT_in_synpred149_LeMaVM10569); if (state.failed) return ;
                        pushFollow(FOLLOW_arguments_in_synpred149_LeMaVM10571);
                        arguments();

                        state._fsp--;
                        if (state.failed) return ;

                        }
                        break;

                }


                }
                break;
            case 3 :
                // LeMaVM.g:765:17: THIS
                {
                match(input,THIS,FOLLOW_THIS_in_synpred149_LeMaVM10644); if (state.failed) return ;

                }
                break;
            case 4 :
                // LeMaVM.g:766:17: Super= SUPER arguments
                {
                Super=(Token)match(input,SUPER,FOLLOW_SUPER_in_synpred149_LeMaVM10710); if (state.failed) return ;
                pushFollow(FOLLOW_arguments_in_synpred149_LeMaVM10712);
                arguments();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 5 :
                // LeMaVM.g:767:17: innerNewExpression
                {
                pushFollow(FOLLOW_innerNewExpression_in_synpred149_LeMaVM10760);
                innerNewExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred149_LeMaVM

    // $ANTLR start synpred155_LeMaVM
    public final void synpred155_LeMaVM_fragment() throws RecognitionException {   
        // LeMaVM.g:792:37: ( LBRACK expression RBRACK )
        // LeMaVM.g:792:37: LBRACK expression RBRACK
        {
        match(input,LBRACK,FOLLOW_LBRACK_in_synpred155_LeMaVM11146); if (state.failed) return ;
        pushFollow(FOLLOW_expression_in_synpred155_LeMaVM11149);
        expression();

        state._fsp--;
        if (state.failed) return ;
        match(input,RBRACK,FOLLOW_RBRACK_in_synpred155_LeMaVM11151); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred155_LeMaVM

    // Delegated rules

    public final boolean synpred134_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred132_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred148_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred148_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred141_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred141_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred149_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred149_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred155_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred155_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred146_LeMaVM() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred146_LeMaVM_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA50 dfa50 = new DFA50(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA89 dfa89 = new DFA89(this);
    protected DFA94 dfa94 = new DFA94(this);
    static final String DFA16_eotS =
        "\14\uffff";
    static final String DFA16_eofS =
        "\14\uffff";
    static final String DFA16_minS =
        "\1\27\1\uffff\1\27\4\65\3\uffff\1\65\1\uffff";
    static final String DFA16_maxS =
        "\1\u0086\1\uffff\5\u0086\3\uffff\1\u0086\1\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\5\uffff\1\3\1\4\1\5\1\uffff\1\2";
    static final String DFA16_specialS =
        "\14\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\1\24\uffff\1\11\10\uffff\1\7\2\uffff\1\10\3\uffff\1\7\3\uffff"+
            "\1\6\4\uffff\2\7\3\uffff\1\5\1\4\1\3\1\uffff\1\7\1\2\1\7\5\uffff"+
            "\1\7\57\uffff\1\7",
            "",
            "\1\13\35\uffff\1\7\2\uffff\1\10\3\uffff\1\7\3\uffff\1\6\4\uffff"+
            "\2\7\3\uffff\1\5\1\4\1\3\1\uffff\1\7\1\12\1\7\5\uffff\1\7\57"+
            "\uffff\1\7",
            "\1\7\2\uffff\1\10\3\uffff\1\7\3\uffff\1\6\4\uffff\2\7\3\uffff"+
            "\1\5\1\4\1\3\1\uffff\1\7\1\12\1\7\5\uffff\1\7\57\uffff\1\7",
            "\1\7\2\uffff\1\10\3\uffff\1\7\3\uffff\1\6\4\uffff\2\7\3\uffff"+
            "\1\5\1\4\1\3\1\uffff\1\7\1\12\1\7\5\uffff\1\7\57\uffff\1\7",
            "\1\7\2\uffff\1\10\3\uffff\1\7\3\uffff\1\6\4\uffff\2\7\3\uffff"+
            "\1\5\1\4\1\3\1\uffff\1\7\1\12\1\7\5\uffff\1\7\57\uffff\1\7",
            "\1\7\2\uffff\1\10\3\uffff\1\7\3\uffff\1\6\4\uffff\2\7\3\uffff"+
            "\1\5\1\4\1\3\1\uffff\1\7\1\12\1\7\5\uffff\1\7\57\uffff\1\7",
            "",
            "",
            "",
            "\1\7\2\uffff\1\10\3\uffff\1\7\3\uffff\1\6\4\uffff\2\7\3\uffff"+
            "\1\5\1\4\1\3\1\uffff\1\7\1\12\1\7\5\uffff\1\7\57\uffff\1\7",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "348:1: classScopeDeclarations : ( block -> ^( CLASS_INSTANCE_INITIALIZER block ) | STATIC block -> ^( CLASS_STATIC_INITIALIZER[$STATIC, \"CLASS_STATIC_INITIALIZER\"] block ) | modifierList ( ( type IDENT formalParameterList ( arrayDeclaratorList )? ( block | SEMI ) -> ^( FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList ( arrayDeclaratorList )? ( block )? ) | VOID IDENT formalParameterList ( block | SEMI ) -> ^( VOID_METHOD_DECL modifierList IDENT formalParameterList ( block )? ) | ident= IDENT formalParameterList block -> ^( CONSTRUCTOR_DECL[$ident, \"CONSTRUCTOR_DECL\"] modifierList formalParameterList block ) ) | type classFieldDeclaratorList SEMI -> ^( VAR_DECLARATION modifierList type classFieldDeclaratorList ) ) | typeDeclaration | SEMI );";
        }
    }
    static final String DFA15_eotS =
        "\14\uffff";
    static final String DFA15_eofS =
        "\14\uffff";
    static final String DFA15_minS =
        "\1\65\1\26\1\17\1\uffff\1\51\1\6\1\u0086\1\51\1\26\1\uffff\1\17"+
        "\1\26";
    static final String DFA15_maxS =
        "\3\u0086\1\uffff\1\51\1\54\1\u0086\1\51\1\u0086\1\uffff\2\u0086";
    static final String DFA15_acceptS =
        "\3\uffff\1\1\5\uffff\1\2\2\uffff";
    static final String DFA15_specialS =
        "\14\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\6\uffff\1\1\10\uffff\2\1\7\uffff\1\1\1\uffff\1\1\5\uffff"+
            "\1\3\57\uffff\1\2",
            "\1\4\157\uffff\1\5",
            "\1\6\6\uffff\1\7\6\uffff\1\3\150\uffff\1\5",
            "",
            "\1\10",
            "\1\11\4\uffff\1\11\12\uffff\1\11\6\uffff\1\3\16\uffff\1\11",
            "\1\12",
            "\1\13",
            "\1\4\157\uffff\1\5",
            "",
            "\1\6\6\uffff\1\7\157\uffff\1\5",
            "\1\7\157\uffff\1\5"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "352:9: ( ( type IDENT formalParameterList ( arrayDeclaratorList )? ( block | SEMI ) -> ^( FUNCTION_METHOD_DECL modifierList type IDENT formalParameterList ( arrayDeclaratorList )? ( block )? ) | VOID IDENT formalParameterList ( block | SEMI ) -> ^( VOID_METHOD_DECL modifierList IDENT formalParameterList ( block )? ) | ident= IDENT formalParameterList block -> ^( CONSTRUCTOR_DECL[$ident, \"CONSTRUCTOR_DECL\"] modifierList formalParameterList block ) ) | type classFieldDeclaratorList SEMI -> ^( VAR_DECLARATION modifierList type classFieldDeclaratorList ) )";
        }
    }
    static final String DFA39_eotS =
        "\16\uffff";
    static final String DFA39_eofS =
        "\16\uffff";
    static final String DFA39_minS =
        "\1\14\1\65\1\17\1\4\3\uffff\1\51\1\70\1\14\1\17\1\4\1\17\1\51";
    static final String DFA39_maxS =
        "\1\u008c\3\u0086\3\uffff\1\51\1\u0086\1\u008c\3\u0086\1\51";
    static final String DFA39_acceptS =
        "\4\uffff\1\2\1\3\1\1\7\uffff";
    static final String DFA39_specialS =
        "\16\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\5\10\uffff\1\5\1\uffff\1\5\3\uffff\1\5\1\uffff\2\5\3\uffff"+
            "\1\5\3\uffff\1\5\5\uffff\1\5\10\uffff\1\2\1\5\1\uffff\1\4\1"+
            "\5\1\uffff\1\5\1\2\2\uffff\1\5\1\1\2\5\2\uffff\2\2\2\5\1\uffff"+
            "\3\4\1\5\1\2\1\4\1\2\4\5\1\uffff\2\5\56\uffff\1\3\6\5",
            "\1\6\2\uffff\1\4\3\uffff\1\6\3\uffff\1\1\4\uffff\2\6\3\uffff"+
            "\3\4\1\uffff\1\6\1\4\1\6\65\uffff\1\6",
            "\1\5\6\uffff\1\7\157\uffff\1\6",
            "\3\5\1\uffff\1\5\1\uffff\1\5\1\uffff\3\5\1\10\2\uffff\4\5\1"+
            "\11\1\uffff\3\5\1\uffff\6\5\1\uffff\6\5\3\uffff\2\5\1\uffff"+
            "\1\5\1\uffff\4\5\16\uffff\1\5\102\uffff\1\6",
            "",
            "",
            "",
            "\1\12",
            "\1\5\16\uffff\1\5\11\uffff\1\5\1\uffff\1\5\62\uffff\1\13",
            "\1\5\10\uffff\1\5\5\uffff\1\5\1\uffff\2\5\3\uffff\1\5\3\uffff"+
            "\1\5\2\uffff\1\14\13\uffff\1\5\6\uffff\1\5\2\uffff\1\5\5\uffff"+
            "\4\5\5\uffff\1\5\1\uffff\2\5\1\uffff\2\5\1\uffff\1\5\57\uffff"+
            "\7\5",
            "\1\5\6\uffff\1\7\157\uffff\1\6",
            "\3\5\1\uffff\1\5\3\uffff\3\5\1\10\2\uffff\4\5\1\11\1\uffff"+
            "\3\5\1\uffff\6\5\1\uffff\6\5\3\uffff\2\5\1\uffff\1\5\1\uffff"+
            "\4\5\16\uffff\1\5\102\uffff\1\6",
            "\1\5\6\uffff\1\15\157\uffff\1\6",
            "\1\14"
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "503:1: blockStatement : ( localVariableDeclaration SEMI | typeDeclaration | statement );";
        }
    }
    static final String DFA45_eotS =
        "\16\uffff";
    static final String DFA45_eofS =
        "\16\uffff";
    static final String DFA45_minS =
        "\1\14\11\uffff\1\4\3\uffff";
    static final String DFA45_maxS =
        "\1\u008c\11\uffff\1\103\3\uffff";
    static final String DFA45_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\13\1\14"+
        "\1\12";
    static final String DFA45_specialS =
        "\16\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\13\10\uffff\1\13\1\uffff\1\1\3\uffff\1\13\1\uffff\2\13\3"+
            "\uffff\1\13\3\uffff\1\13\5\uffff\1\14\10\uffff\1\13\1\10\2\uffff"+
            "\1\11\1\uffff\1\5\1\13\2\uffff\1\13\1\uffff\1\3\1\2\2\uffff"+
            "\4\13\4\uffff\1\7\1\13\1\uffff\2\13\1\6\2\13\1\uffff\1\13\1"+
            "\4\56\uffff\1\12\6\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\3\13\1\uffff\1\13\1\uffff\1\15\1\uffff\4\13\2\uffff\5\13\1"+
            "\uffff\3\13\1\uffff\6\13\1\uffff\6\13\3\uffff\2\13\1\uffff\1"+
            "\13\1\uffff\4\13\16\uffff\1\13",
            "",
            "",
            ""
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "515:1: statement : ( block | IF parenthesizedExpression ifStat= statement ( ELSE elseStat= statement -> ^( IF parenthesizedExpression $ifStat $elseStat) | -> ^( IF parenthesizedExpression $ifStat) ) | FOR LPAREN ( forInit SEMI forCondition SEMI forUpdater RPAREN statement -> ^( FOR forInit forCondition forUpdater statement ) | localModifierList type IDENT COLON expression RPAREN statement -> ^( FOR_EACH[$FOR, \"FOR_EACH\"] localModifierList type IDENT expression statement ) ) | WHILE parenthesizedExpression statement -> ^( WHILE parenthesizedExpression statement ) | DO statement WHILE parenthesizedExpression SEMI -> ^( DO statement parenthesizedExpression ) | SWITCH parenthesizedExpression LCURLY switchBlockLabels RCURLY -> ^( SWITCH parenthesizedExpression switchBlockLabels ) | RETURN ( expression )? SEMI -> ^( RETURN ( expression )? ) | BREAK ( IDENT )? SEMI -> ^( BREAK ( IDENT )? ) | CONTINUE ( IDENT )? SEMI -> ^( CONTINUE ( IDENT )? ) | IDENT COLON statement -> ^( LABELED_STATEMENT IDENT statement ) | expression SEMI | SEMI );";
        }
    }
    static final String DFA41_eotS =
        "\26\uffff";
    static final String DFA41_eofS =
        "\26\uffff";
    static final String DFA41_minS =
        "\1\14\1\65\1\17\1\4\1\uffff\1\26\1\17\1\51\1\6\1\70\1\14\1\51\1"+
        "\u0086\1\51\1\17\1\uffff\1\4\1\17\1\26\1\17\1\26\1\51";
    static final String DFA41_maxS =
        "\1\u008c\3\u0086\1\uffff\2\u0086\1\51\1\54\1\u0086\1\u008c\1\51"+
        "\1\u0086\1\51\1\u0086\1\uffff\5\u0086\1\51";
    static final String DFA41_acceptS =
        "\4\uffff\1\1\12\uffff\1\2\6\uffff";
    static final String DFA41_specialS =
        "\26\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\4\10\uffff\1\4\5\uffff\1\4\1\uffff\2\4\3\uffff\1\4\3\uffff"+
            "\1\4\5\uffff\1\4\10\uffff\1\2\6\uffff\1\2\2\uffff\1\4\1\1\4"+
            "\uffff\2\2\2\4\5\uffff\1\2\1\uffff\1\2\1\4\1\uffff\2\4\1\uffff"+
            "\1\4\57\uffff\1\3\6\4",
            "\1\5\6\uffff\1\5\3\uffff\1\1\4\uffff\2\5\7\uffff\1\5\1\uffff"+
            "\1\5\65\uffff\1\6",
            "\1\4\6\uffff\1\7\157\uffff\1\10",
            "\3\4\1\uffff\1\4\2\uffff\4\4\1\11\2\uffff\4\4\1\12\1\uffff"+
            "\3\4\1\uffff\6\4\1\uffff\6\4\3\uffff\2\4\1\uffff\1\4\1\uffff"+
            "\4\4\16\uffff\1\4\102\uffff\1\10",
            "",
            "\1\13\157\uffff\1\10",
            "\1\14\6\uffff\1\15\157\uffff\1\10",
            "\1\16",
            "\1\4\3\uffff\1\17\1\4\12\uffff\1\4\25\uffff\1\4",
            "\1\4\16\uffff\1\4\11\uffff\1\4\1\uffff\1\4\62\uffff\1\20",
            "\1\4\10\uffff\1\4\5\uffff\1\4\1\uffff\2\4\3\uffff\1\4\3\uffff"+
            "\1\4\2\uffff\1\21\13\uffff\1\4\6\uffff\1\4\2\uffff\1\4\5\uffff"+
            "\4\4\5\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\57\uffff"+
            "\7\4",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\4\6\uffff\1\7\157\uffff\1\10",
            "",
            "\3\4\1\uffff\1\4\2\uffff\4\4\1\11\2\uffff\4\4\1\12\1\uffff"+
            "\3\4\1\uffff\6\4\1\uffff\6\4\3\uffff\2\4\1\uffff\1\4\1\uffff"+
            "\4\4\16\uffff\1\4\102\uffff\1\10",
            "\1\4\6\uffff\1\25\157\uffff\1\10",
            "\1\13\157\uffff\1\10",
            "\1\14\6\uffff\1\15\157\uffff\1\10",
            "\1\15\157\uffff\1\10",
            "\1\21"
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "522:9: ( forInit SEMI forCondition SEMI forUpdater RPAREN statement -> ^( FOR forInit forCondition forUpdater statement ) | localModifierList type IDENT COLON expression RPAREN statement -> ^( FOR_EACH[$FOR, \"FOR_EACH\"] localModifierList type IDENT expression statement ) )";
        }
    }
    static final String DFA50_eotS =
        "\15\uffff";
    static final String DFA50_eofS =
        "\15\uffff";
    static final String DFA50_minS =
        "\1\14\1\uffff\1\17\1\4\2\uffff\1\51\1\70\1\14\1\17\1\4\1\17\1\51";
    static final String DFA50_maxS =
        "\1\u008c\1\uffff\2\u0086\2\uffff\1\51\1\u0086\1\u008c\3\u0086\1"+
        "\51";
    static final String DFA50_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\3\7\uffff";
    static final String DFA50_specialS =
        "\15\uffff}>";
    static final String[] DFA50_transitionS = {
            "\1\4\10\uffff\1\4\5\uffff\1\4\1\uffff\2\4\3\uffff\1\4\3\uffff"+
            "\1\4\5\uffff\1\5\10\uffff\1\2\6\uffff\1\2\2\uffff\1\4\1\1\4"+
            "\uffff\2\2\2\4\5\uffff\1\2\1\uffff\1\2\1\4\1\uffff\2\4\1\uffff"+
            "\1\4\57\uffff\1\3\6\4",
            "",
            "\1\4\6\uffff\1\6\157\uffff\1\1",
            "\3\4\1\uffff\1\4\2\uffff\4\4\1\7\2\uffff\4\4\1\10\1\uffff\3"+
            "\4\1\uffff\6\4\1\uffff\6\4\3\uffff\2\4\1\uffff\1\4\1\uffff\4"+
            "\4\16\uffff\1\4\102\uffff\1\1",
            "",
            "",
            "\1\11",
            "\1\4\16\uffff\1\4\11\uffff\1\4\1\uffff\1\4\62\uffff\1\12",
            "\1\4\10\uffff\1\4\5\uffff\1\4\1\uffff\2\4\3\uffff\1\4\3\uffff"+
            "\1\4\2\uffff\1\13\13\uffff\1\4\6\uffff\1\4\2\uffff\1\4\5\uffff"+
            "\4\4\5\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\57\uffff"+
            "\7\4",
            "\1\4\6\uffff\1\6\157\uffff\1\1",
            "\3\4\1\uffff\1\4\2\uffff\4\4\1\7\2\uffff\4\4\1\10\1\uffff\3"+
            "\4\1\uffff\6\4\1\uffff\6\4\3\uffff\2\4\1\uffff\1\4\1\uffff\4"+
            "\4\16\uffff\1\4\102\uffff\1\1",
            "\1\4\6\uffff\1\14\157\uffff\1\1",
            "\1\13"
    };

    static final short[] DFA50_eot = DFA.unpackEncodedString(DFA50_eotS);
    static final short[] DFA50_eof = DFA.unpackEncodedString(DFA50_eofS);
    static final char[] DFA50_min = DFA.unpackEncodedStringToUnsignedChars(DFA50_minS);
    static final char[] DFA50_max = DFA.unpackEncodedStringToUnsignedChars(DFA50_maxS);
    static final short[] DFA50_accept = DFA.unpackEncodedString(DFA50_acceptS);
    static final short[] DFA50_special = DFA.unpackEncodedString(DFA50_specialS);
    static final short[][] DFA50_transition;

    static {
        int numStates = DFA50_transitionS.length;
        DFA50_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA50_transition[i] = DFA.unpackEncodedString(DFA50_transitionS[i]);
        }
    }

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = DFA50_eot;
            this.eof = DFA50_eof;
            this.min = DFA50_min;
            this.max = DFA50_max;
            this.accept = DFA50_accept;
            this.special = DFA50_special;
            this.transition = DFA50_transition;
        }
        public String getDescription() {
            return "554:1: forInit : ( localVariableDeclaration -> ^( FOR_INIT localVariableDeclaration ) | expressionList -> ^( FOR_INIT expressionList ) | -> ^( FOR_INIT ) );";
        }
    }
    static final String DFA74_eotS =
        "\14\uffff";
    static final String DFA74_eofS =
        "\14\uffff";
    static final String DFA74_minS =
        "\1\33\2\uffff\1\0\10\uffff";
    static final String DFA74_maxS =
        "\1\u008c\2\uffff\1\0\10\uffff";
    static final String DFA74_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\6\uffff\1\3";
    static final String DFA74_specialS =
        "\3\uffff\1\0\10\uffff}>";
    static final String[] DFA74_transitionS = {
            "\1\2\1\uffff\1\3\4\uffff\1\1\22\uffff\1\4\6\uffff\1\4\2\uffff"+
            "\1\4\5\uffff\4\4\5\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff"+
            "\1\4\57\uffff\7\4",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA74_eot = DFA.unpackEncodedString(DFA74_eotS);
    static final short[] DFA74_eof = DFA.unpackEncodedString(DFA74_eofS);
    static final char[] DFA74_min = DFA.unpackEncodedStringToUnsignedChars(DFA74_minS);
    static final char[] DFA74_max = DFA.unpackEncodedStringToUnsignedChars(DFA74_maxS);
    static final short[] DFA74_accept = DFA.unpackEncodedString(DFA74_acceptS);
    static final short[] DFA74_special = DFA.unpackEncodedString(DFA74_specialS);
    static final short[][] DFA74_transition;

    static {
        int numStates = DFA74_transitionS.length;
        DFA74_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA74_transition[i] = DFA.unpackEncodedString(DFA74_transitionS[i]);
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = DFA74_eot;
            this.eof = DFA74_eof;
            this.min = DFA74_min;
            this.max = DFA74_max;
            this.accept = DFA74_accept;
            this.special = DFA74_special;
            this.transition = DFA74_transition;
        }
        public String getDescription() {
            return "686:1: unaryExpressionNotPlusMinus : ( NOT unaryExpression -> ^( NOT unaryExpression ) | LOGICAL_NOT unaryExpression -> ^( LOGICAL_NOT unaryExpression ) | LPAREN type RPAREN unaryExpression -> ^( CAST_EXPR[$LPAREN, \"CAST_EXPR\"] type unaryExpression ) | postfixedExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA74_3 = input.LA(1);

                         
                        int index74_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_LeMaVM()) ) {s = 11;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index74_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 74, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA85_eotS =
        "\16\uffff";
    static final String DFA85_eofS =
        "\16\uffff";
    static final String DFA85_minS =
        "\1\35\3\uffff\3\0\7\uffff";
    static final String DFA85_maxS =
        "\1\u008c\3\uffff\3\0\7\uffff";
    static final String DFA85_acceptS =
        "\1\uffff\1\1\1\2\1\3\3\uffff\1\11\1\12\1\4\1\5\1\7\1\10\1\6";
    static final String DFA85_specialS =
        "\4\uffff\1\0\1\1\1\2\7\uffff}>";
    static final String[] DFA85_transitionS = {
            "\1\1\27\uffff\1\7\6\uffff\1\7\2\uffff\1\2\5\uffff\2\7\1\3\1"+
            "\2\5\uffff\1\7\1\uffff\1\7\1\5\1\uffff\1\6\1\2\1\uffff\1\10"+
            "\57\uffff\1\4\6\2",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA85_eot = DFA.unpackEncodedString(DFA85_eotS);
    static final short[] DFA85_eof = DFA.unpackEncodedString(DFA85_eofS);
    static final char[] DFA85_min = DFA.unpackEncodedStringToUnsignedChars(DFA85_minS);
    static final char[] DFA85_max = DFA.unpackEncodedStringToUnsignedChars(DFA85_maxS);
    static final short[] DFA85_accept = DFA.unpackEncodedString(DFA85_acceptS);
    static final short[] DFA85_special = DFA.unpackEncodedString(DFA85_specialS);
    static final short[][] DFA85_transition;

    static {
        int numStates = DFA85_transitionS.length;
        DFA85_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA85_transition[i] = DFA.unpackEncodedString(DFA85_transitionS[i]);
        }
    }

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = DFA85_eot;
            this.eof = DFA85_eof;
            this.min = DFA85_min;
            this.max = DFA85_max;
            this.accept = DFA85_accept;
            this.special = DFA85_special;
            this.transition = DFA85_transition;
        }
        public String getDescription() {
            return "719:1: primaryExpression : ( parenthesizedExpression | literal | newExpression | qualifiedIdentExpression | ( SUPER ( arguments -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments ) | DOT IDENT arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) ) | IDENT arguments -> ^( METHOD_CALL IDENT arguments ) | THIS arguments -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments ) ) | ( THIS -> THIS ) ( arguments -> ^( THIS_CONSTRUCTOR_CALL[$THIS, \"THIS_CONSTRUCTOR_CALL\"] arguments ) )? | SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$SUPER, \"SUPER_CONSTRUCTOR_CALL\"] arguments ) | ( SUPER DOT IDENT ) ( arguments -> ^( METHOD_CALL ^( DOT SUPER IDENT ) arguments ) | -> ^( DOT SUPER IDENT ) ) | ( primitiveType -> primitiveType ) ( arrayDeclarator -> ^( arrayDeclarator $primaryExpression) )* DOT CLASS -> ^( DOT $primaryExpression CLASS ) | VOID DOT CLASS -> ^( DOT VOID CLASS ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA85_4 = input.LA(1);

                         
                        int index85_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred128_LeMaVM()) ) {s = 9;}

                        else if ( (synpred132_LeMaVM()) ) {s = 10;}

                         
                        input.seek(index85_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA85_5 = input.LA(1);

                         
                        int index85_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred132_LeMaVM()) ) {s = 10;}

                        else if ( (synpred135_LeMaVM()) ) {s = 11;}

                        else if ( (synpred137_LeMaVM()) ) {s = 12;}

                         
                        input.seek(index85_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA85_6 = input.LA(1);

                         
                        int index85_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred132_LeMaVM()) ) {s = 10;}

                        else if ( (synpred134_LeMaVM()) ) {s = 13;}

                         
                        input.seek(index85_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 85, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA89_eotS =
        "\55\uffff";
    static final String DFA89_eofS =
        "\1\4\54\uffff";
    static final String DFA89_minS =
        "\1\4\1\0\1\uffff\1\0\51\uffff";
    static final String DFA89_maxS =
        "\1\103\1\0\1\uffff\1\0\51\uffff";
    static final String DFA89_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\46\uffff\1\1\1\3";
    static final String DFA89_specialS =
        "\1\uffff\1\0\1\uffff\1\1\51\uffff}>";
    static final String[] DFA89_transitionS = {
            "\3\4\1\uffff\1\4\1\uffff\5\4\1\3\2\uffff\4\4\1\1\1\uffff\3\4"+
            "\1\uffff\1\4\1\2\4\4\1\uffff\13\4\1\uffff\1\4\1\uffff\4\4\16"+
            "\uffff\1\4",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA89_eot = DFA.unpackEncodedString(DFA89_eotS);
    static final short[] DFA89_eof = DFA.unpackEncodedString(DFA89_eofS);
    static final char[] DFA89_min = DFA.unpackEncodedStringToUnsignedChars(DFA89_minS);
    static final char[] DFA89_max = DFA.unpackEncodedStringToUnsignedChars(DFA89_maxS);
    static final short[] DFA89_accept = DFA.unpackEncodedString(DFA89_acceptS);
    static final short[] DFA89_special = DFA.unpackEncodedString(DFA89_specialS);
    static final short[][] DFA89_transition;

    static {
        int numStates = DFA89_transitionS.length;
        DFA89_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA89_transition[i] = DFA.unpackEncodedString(DFA89_transitionS[i]);
        }
    }

    class DFA89 extends DFA {

        public DFA89(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 89;
            this.eot = DFA89_eot;
            this.eof = DFA89_eof;
            this.min = DFA89_min;
            this.max = DFA89_max;
            this.accept = DFA89_accept;
            this.special = DFA89_special;
            this.transition = DFA89_transition;
        }
        public String getDescription() {
            return "754:9: ( ( arrayDeclarator -> ^( arrayDeclarator $qualifiedIdentExpression) )+ ( DOT CLASS -> ^( DOT $qualifiedIdentExpression CLASS ) ) | arguments -> ^( METHOD_CALL qualifiedIdentifier arguments ) | outerDot= DOT ( CLASS -> ^( DOT qualifiedIdentifier CLASS ) | (Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | SUPER innerDot= DOT IDENT arguments -> ^( METHOD_CALL ^( $innerDot ^( $outerDot qualifiedIdentifier SUPER ) IDENT ) arguments ) | IDENT arguments -> ^( METHOD_CALL ^( DOT qualifiedIdentifier IDENT ) arguments ) ) | THIS -> ^( DOT qualifiedIdentifier THIS ) | Super= SUPER arguments -> ^( SUPER_CONSTRUCTOR_CALL[$Super, \"SUPER_CONSTRUCTOR_CALL\"] qualifiedIdentifier arguments ) | innerNewExpression -> ^( DOT qualifiedIdentifier innerNewExpression ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA89_1 = input.LA(1);

                         
                        int index89_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred141_LeMaVM()) ) {s = 43;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index89_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA89_3 = input.LA(1);

                         
                        int index89_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_LeMaVM()) ) {s = 44;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index89_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 89, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA94_eotS =
        "\53\uffff";
    static final String DFA94_eofS =
        "\1\2\52\uffff";
    static final String DFA94_minS =
        "\1\4\1\0\51\uffff";
    static final String DFA94_maxS =
        "\1\103\1\0\51\uffff";
    static final String DFA94_acceptS =
        "\2\uffff\1\2\47\uffff\1\1";
    static final String DFA94_specialS =
        "\1\uffff\1\0\51\uffff}>";
    static final String[] DFA94_transitionS = {
            "\3\2\1\uffff\1\2\1\uffff\6\2\2\uffff\4\2\1\1\1\uffff\3\2\1\uffff"+
            "\1\2\1\uffff\4\2\1\uffff\13\2\1\uffff\1\2\1\uffff\4\2\16\uffff"+
            "\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA94_eot = DFA.unpackEncodedString(DFA94_eotS);
    static final short[] DFA94_eof = DFA.unpackEncodedString(DFA94_eofS);
    static final char[] DFA94_min = DFA.unpackEncodedStringToUnsignedChars(DFA94_minS);
    static final char[] DFA94_max = DFA.unpackEncodedStringToUnsignedChars(DFA94_maxS);
    static final short[] DFA94_accept = DFA.unpackEncodedString(DFA94_acceptS);
    static final short[] DFA94_special = DFA.unpackEncodedString(DFA94_specialS);
    static final short[][] DFA94_transition;

    static {
        int numStates = DFA94_transitionS.length;
        DFA94_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA94_transition[i] = DFA.unpackEncodedString(DFA94_transitionS[i]);
        }
    }

    class DFA94 extends DFA {

        public DFA94(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 94;
            this.eot = DFA94_eot;
            this.eof = DFA94_eof;
            this.min = DFA94_min;
            this.max = DFA94_max;
            this.accept = DFA94_accept;
            this.special = DFA94_special;
            this.transition = DFA94_transition;
        }
        public String getDescription() {
            return "()* loopback of 792:36: ( LBRACK expression RBRACK )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA94_1 = input.LA(1);

                         
                        int index94_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_LeMaVM()) ) {s = 42;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index94_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 94, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_compilationUnit_in_javaSource3808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_packageDeclaration_in_compilationUnit3844 = new BitSet(new long[]{0x0100100000000002L,0x0000000000009C11L});
    public static final BitSet FOLLOW_importDeclaration_in_compilationUnit3856 = new BitSet(new long[]{0x0100100000000002L,0x0000000000009C11L});
    public static final BitSet FOLLOW_typeDecls_in_compilationUnit3868 = new BitSet(new long[]{0x0100100000000002L,0x0000000000009C01L});
    public static final BitSet FOLLOW_typeDeclaration_in_typeDecls3888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_typeDecls3898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACKAGE_in_packageDeclaration3918 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_packageDeclaration3921 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_packageDeclaration3923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDeclaration3949 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L,0x0000000000000040L});
    public static final BitSet FOLLOW_STATIC_in_importDeclaration3952 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_importDeclaration3955 = new BitSet(new long[]{0x0000100000010000L});
    public static final BitSet FOLLOW_DOTSTAR_in_importDeclaration3957 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_importDeclaration3960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifierList_in_typeDeclaration3984 = new BitSet(new long[]{0x0100000000000000L,0x0000000000009C01L});
    public static final BitSet FOLLOW_classTypeDeclaration_in_typeDeclaration3999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_in_classTypeDeclaration4034 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_classTypeDeclaration4036 = new BitSet(new long[]{0x4000000000800000L});
    public static final BitSet FOLLOW_classExtendsClause_in_classTypeDeclaration4038 = new BitSet(new long[]{0x4000000000800000L});
    public static final BitSet FOLLOW_classBody_in_classTypeDeclaration4041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_classExtendsClause4088 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_classExtendsClause4090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_bound4138 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_bound4140 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_bound4143 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_bound4145 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_type_in_typeList4189 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_typeList4192 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_typeList4195 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_LCURLY_in_classBody4220 = new BitSet(new long[]{0x1120140000800000L,0x000000000041DC61L,0x0000000000000040L});
    public static final BitSet FOLLOW_classScopeDeclarations_in_classBody4222 = new BitSet(new long[]{0x1120140000800000L,0x000000000041DC61L,0x0000000000000040L});
    public static final BitSet FOLLOW_RCURLY_in_classBody4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_classScopeDeclarations4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATIC_in_classScopeDeclarations4292 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_block_in_classScopeDeclarations4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifierList_in_classScopeDeclarations4317 = new BitSet(new long[]{0x1020000000000000L,0x0000000000414060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_classScopeDeclarations4335 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_classScopeDeclarations4337 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameterList_in_classScopeDeclarations4339 = new BitSet(new long[]{0x0000100000C00000L});
    public static final BitSet FOLLOW_arrayDeclaratorList_in_classScopeDeclarations4341 = new BitSet(new long[]{0x0000100000800000L});
    public static final BitSet FOLLOW_block_in_classScopeDeclarations4345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_classScopeDeclarations4349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_classScopeDeclarations4405 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_classScopeDeclarations4407 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameterList_in_classScopeDeclarations4409 = new BitSet(new long[]{0x0000100000800000L});
    public static final BitSet FOLLOW_block_in_classScopeDeclarations4412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_classScopeDeclarations4416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_classScopeDeclarations4469 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameterList_in_classScopeDeclarations4471 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_block_in_classScopeDeclarations4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_classScopeDeclarations4531 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classFieldDeclaratorList_in_classScopeDeclarations4533 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_classScopeDeclarations4535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDeclaration_in_classScopeDeclarations4580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_classScopeDeclarations4590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classFieldDeclarator_in_classFieldDeclaratorList4610 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_classFieldDeclaratorList4613 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classFieldDeclarator_in_classFieldDeclaratorList4615 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_variableDeclaratorId_in_classFieldDeclarator4654 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ASSIGN_in_classFieldDeclarator4657 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_variableInitializer_in_classFieldDeclarator4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_variableDeclaratorId4704 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_arrayDeclaratorList_in_variableDeclaratorId4707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayInitializer_in_variableInitializer4727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_variableInitializer4737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayDeclarator4756 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayDeclarator4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayDeclarator_in_arrayDeclaratorList4792 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_LCURLY_in_arrayInitializer4837 = new BitSet(new long[]{0x9020044468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_variableInitializer_in_arrayInitializer4840 = new BitSet(new long[]{0x0000040000000800L});
    public static final BitSet FOLLOW_COMMA_in_arrayInitializer4843 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_variableInitializer_in_arrayInitializer4845 = new BitSet(new long[]{0x0000040000000800L});
    public static final BitSet FOLLOW_COMMA_in_arrayInitializer4849 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RCURLY_in_arrayInitializer4854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_modifierList4892 = new BitSet(new long[]{0x0000000000000002L,0x0000000000009C01L});
    public static final BitSet FOLLOW_PUBLIC_in_modifier4933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROTECTED_in_modifier4943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIVATE_in_modifier4953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATIC_in_modifier4963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localModifier_in_modifier4973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localModifier_in_localModifierList4992 = new BitSet(new long[]{0x0000000000000002L,0x0000000000009C01L});
    public static final BitSet FOLLOW_FINAL_in_localModifier5033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleType_in_type5052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectType_in_type5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_simpleType5082 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_arrayDeclaratorList_in_simpleType5084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedTypeIdent_in_objectType5131 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_arrayDeclaratorList_in_objectType5133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedTypeIdentSimplified_in_objectTypeSimplified5173 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_arrayDeclaratorList_in_objectTypeSimplified5175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeIdent_in_qualifiedTypeIdent5215 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedTypeIdent5218 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_typeIdent_in_qualifiedTypeIdent5220 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_typeIdentSimplified_in_qualifiedTypeIdentSimplified5260 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedTypeIdentSimplified5263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_typeIdentSimplified_in_qualifiedTypeIdentSimplified5265 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_IDENT_in_typeIdent5305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_typeIdentSimplified5325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_primitiveType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_qualifiedIdentList5414 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_qualifiedIdentList5417 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_qualifiedIdentList5420 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameterList5445 = new BitSet(new long[]{0x1020080000000000L,0x000000000001DC61L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameterStandardDecl_in_formalParameterList5473 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_formalParameterList5476 = new BitSet(new long[]{0x1020000000000000L,0x000000000001DC61L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameterStandardDecl_in_formalParameterList5478 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameterList5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localModifierList_in_formalParameterStandardDecl5581 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_formalParameterStandardDecl5583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_variableDeclaratorId_in_formalParameterStandardDecl5585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_qualifiedIdentifier5633 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedIdentifier5676 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_qualifiedIdentifier5680 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_LCURLY_in_block5729 = new BitSet(new long[]{0x9B60144468A01000L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_blockStatement_in_block5731 = new BitSet(new long[]{0x9B60144468A01000L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_RCURLY_in_block5734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_blockStatement5772 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_blockStatement5774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDeclaration_in_blockStatement5785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_blockStatement5795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localModifierList_in_localVariableDeclaration5818 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_localVariableDeclaration5820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classFieldDeclaratorList_in_localVariableDeclaration5822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement5875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_statement5885 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_parenthesizedExpression_in_statement5887 = new BitSet(new long[]{0x9B60104468A01000L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_statement_in_statement5891 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_statement5906 = new BitSet(new long[]{0x9B60104468A01000L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_statement_in_statement5910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_statement6076 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_statement6078 = new BitSet(new long[]{0x9020104468A01000L,0x00000000005BDDE1L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_forInit_in_statement6093 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6095 = new BitSet(new long[]{0x9020104468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_forCondition_in_statement6097 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6099 = new BitSet(new long[]{0x9020084468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_forUpdater_in_statement6101 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_statement6103 = new BitSet(new long[]{0x9B60104468A01000L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_statement_in_statement6105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localModifierList_in_statement6140 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_statement6142 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_statement6144 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_statement6146 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_expression_in_statement6148 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_statement6150 = new BitSet(new long[]{0x9B60104468A01000L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_statement_in_statement6152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_statement6267 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_parenthesizedExpression_in_statement6269 = new BitSet(new long[]{0x9B60104468A01000L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_statement_in_statement6271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_statement6320 = new BitSet(new long[]{0x9B60104468A01000L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_statement_in_statement6322 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_WHILE_in_statement6324 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_parenthesizedExpression_in_statement6326 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_statement6369 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_parenthesizedExpression_in_statement6371 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LCURLY_in_statement6373 = new BitSet(new long[]{0x0480000000000000L});
    public static final BitSet FOLLOW_switchBlockLabels_in_statement6375 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RCURLY_in_statement6377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_statement6403 = new BitSet(new long[]{0x9020104468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_expression_in_statement6405 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_statement6472 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_statement6474 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_statement6547 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_statement6549 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_statement6619 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_statement6621 = new BitSet(new long[]{0x9B60104468A01000L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_statement_in_statement6623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement6690 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_statement6703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchCaseLabels_in_switchBlockLabels6734 = new BitSet(new long[]{0x0480000000000000L});
    public static final BitSet FOLLOW_switchDefaultLabel_in_switchBlockLabels6736 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_switchCaseLabels_in_switchBlockLabels6739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchCaseLabel_in_switchCaseLabels6784 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_CASE_in_switchCaseLabel6812 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_expression_in_switchCaseLabel6815 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_switchCaseLabel6817 = new BitSet(new long[]{0x9B60104468A01002L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_blockStatement_in_switchCaseLabel6820 = new BitSet(new long[]{0x9B60104468A01002L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_DEFAULT_in_switchDefaultLabel6844 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_switchDefaultLabel6847 = new BitSet(new long[]{0x9B60104468A01002L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_blockStatement_in_switchDefaultLabel6850 = new BitSet(new long[]{0x9B60104468A01002L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_forInit6874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_forInit6896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_forCondition6984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_forUpdater7026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_parenthesizedExpression7066 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_expression_in_parenthesizedExpression7068 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_parenthesizedExpression7070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionList7111 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_expressionList7114 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_expression_in_expressionList7117 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_assignmentExpression_in_expression7138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_assignmentExpression7174 = new BitSet(new long[]{0x001400A280004062L});
    public static final BitSet FOLLOW_ASSIGN_in_assignmentExpression7193 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_assignmentExpression7212 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_MINUS_ASSIGN_in_assignmentExpression7231 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_STAR_ASSIGN_in_assignmentExpression7250 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_DIV_ASSIGN_in_assignmentExpression7269 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_AND_ASSIGN_in_assignmentExpression7288 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_OR_ASSIGN_in_assignmentExpression7307 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_XOR_ASSIGN_in_assignmentExpression7326 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_MOD_ASSIGN_in_assignmentExpression7345 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_assignmentExpression_in_assignmentExpression7367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalOrExpression_in_conditionalExpression7392 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_QUESTION_in_conditionalExpression7395 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_assignmentExpression_in_conditionalExpression7398 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpression7400 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_conditionalExpression_in_conditionalExpression7403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalAndExpression_in_logicalOrExpression7424 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_LOGICAL_OR_in_logicalOrExpression7427 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_logicalAndExpression_in_logicalOrExpression7430 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_logicalAndExpression7451 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_LOGICAL_AND_in_logicalAndExpression7454 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_logicalAndExpression7457 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression7478 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_OR_in_inclusiveOrExpression7481 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression7484 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression7505 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_XOR_in_exclusiveOrExpression7508 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression7511 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression7532 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_andExpression7535 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression7538 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_instanceOfExpression_in_equalityExpression7559 = new BitSet(new long[]{0x0000000800040002L});
    public static final BitSet FOLLOW_EQUAL_in_equalityExpression7578 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_equalityExpression7597 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_instanceOfExpression_in_equalityExpression7627 = new BitSet(new long[]{0x0000000800040002L});
    public static final BitSet FOLLOW_relationalExpression_in_instanceOfExpression7657 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_INSTANCEOF_in_instanceOfExpression7660 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_instanceOfExpression7663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression7684 = new BitSet(new long[]{0x0000000003180002L});
    public static final BitSet FOLLOW_LESS_OR_EQUAL_in_relationalExpression7703 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_GREATER_OR_EQUAL_in_relationalExpression7722 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_LESS_THAN_in_relationalExpression7741 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_GREATER_THAN_in_relationalExpression7760 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression7789 = new BitSet(new long[]{0x0000000003180002L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression7823 = new BitSet(new long[]{0x0000A00000000102L});
    public static final BitSet FOLLOW_BIT_SHIFT_RIGHT_in_shiftExpression7841 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_SHIFT_RIGHT_in_shiftExpression7860 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_SHIFT_LEFT_in_shiftExpression7879 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression7908 = new BitSet(new long[]{0x0000A00000000102L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression7938 = new BitSet(new long[]{0x0000004040000002L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpression7956 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_MINUS_in_additiveExpression7975 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression8004 = new BitSet(new long[]{0x0000004040000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression8034 = new BitSet(new long[]{0x0002000100002002L});
    public static final BitSet FOLLOW_STAR_in_multiplicativeExpression8053 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_DIV_in_multiplicativeExpression8072 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_MOD_in_multiplicativeExpression8091 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression8120 = new BitSet(new long[]{0x0002000100002002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpression8154 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression8156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpression8183 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression8185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_unaryExpression8211 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_postfixedExpression_in_unaryExpression8213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_unaryExpression8237 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_postfixedExpression_in_unaryExpression8239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression8263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpressionNotPlusMinus8282 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus8284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOGICAL_NOT_in_unaryExpressionNotPlusMinus8331 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus8333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_unaryExpressionNotPlusMinus8372 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_unaryExpressionNotPlusMinus8374 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_unaryExpressionNotPlusMinus8376 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus8378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixedExpression_in_unaryExpressionNotPlusMinus8413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_postfixedExpression8449 = new BitSet(new long[]{0x0000000000609002L});
    public static final BitSet FOLLOW_DOT_in_postfixedExpression8511 = new BitSet(new long[]{0x0000000000000000L,0x00000000000A0080L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_postfixedExpression8561 = new BitSet(new long[]{0x0000000020609002L});
    public static final BitSet FOLLOW_arguments_in_postfixedExpression8640 = new BitSet(new long[]{0x0000000000609002L});
    public static final BitSet FOLLOW_THIS_in_postfixedExpression8711 = new BitSet(new long[]{0x0000000000609002L});
    public static final BitSet FOLLOW_SUPER_in_postfixedExpression8774 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_postfixedExpression8776 = new BitSet(new long[]{0x0000000000609002L});
    public static final BitSet FOLLOW_SUPER_in_postfixedExpression8829 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_postfixedExpression8833 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_postfixedExpression8835 = new BitSet(new long[]{0x0000000020609002L});
    public static final BitSet FOLLOW_arguments_in_postfixedExpression8902 = new BitSet(new long[]{0x0000000000609002L});
    public static final BitSet FOLLOW_innerNewExpression_in_postfixedExpression8973 = new BitSet(new long[]{0x0000000000609002L});
    public static final BitSet FOLLOW_LBRACK_in_postfixedExpression9030 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_expression_in_postfixedExpression9032 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_postfixedExpression9034 = new BitSet(new long[]{0x0000000000609002L});
    public static final BitSet FOLLOW_INC_in_postfixedExpression9095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_postfixedExpression9119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parenthesizedExpression_in_primaryExpression9167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primaryExpression9177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_primaryExpression9187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentExpression_in_primaryExpression9197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_primaryExpression9211 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_arguments_in_primaryExpression9229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_primaryExpression9287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_primaryExpression9289 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_primaryExpression9291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_primaryExpression9356 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_primaryExpression9358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_primaryExpression9411 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_primaryExpression9413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_primaryExpression9476 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_arguments_in_primaryExpression9544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_primaryExpression9609 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_primaryExpression9611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_primaryExpression9667 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_primaryExpression9669 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_primaryExpression9671 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_arguments_in_primaryExpression9695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_primaryExpression9837 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_arrayDeclarator_in_primaryExpression9896 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_DOT_in_primaryExpression9959 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_CLASS_in_primaryExpression9961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_primaryExpression10021 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_primaryExpression10023 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_CLASS_in_primaryExpression10025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentifier_in_qualifiedIdentExpression10105 = new BitSet(new long[]{0x0000000020408002L});
    public static final BitSet FOLLOW_arrayDeclarator_in_qualifiedIdentExpression10175 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_DOT_in_qualifiedIdentExpression10243 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_CLASS_in_qualifiedIdentExpression10245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_qualifiedIdentExpression10315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedIdentExpression10376 = new BitSet(new long[]{0x0100000000000000L,0x00000000000A0080L,0x0000000000000040L});
    public static final BitSet FOLLOW_CLASS_in_qualifiedIdentExpression10394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_qualifiedIdentExpression10463 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_qualifiedIdentExpression10465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_qualifiedIdentExpression10513 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_qualifiedIdentExpression10517 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_qualifiedIdentExpression10519 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_qualifiedIdentExpression10521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_qualifiedIdentExpression10569 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_qualifiedIdentExpression10571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_qualifiedIdentExpression10644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_qualifiedIdentExpression10710 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_qualifiedIdentExpression10712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_innerNewExpression_in_qualifiedIdentExpression10760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_newExpression10836 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_primitiveType_in_newExpression10852 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_newArrayConstruction_in_newExpression10854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedTypeIdentSimplified_in_newExpression10898 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_newArrayConstruction_in_newExpression10916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_newExpression10978 = new BitSet(new long[]{0x4000000000800002L});
    public static final BitSet FOLLOW_classBody_in_newExpression10980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_innerNewExpression11076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_innerNewExpression11078 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_innerNewExpression11080 = new BitSet(new long[]{0x4000000000800002L});
    public static final BitSet FOLLOW_classBody_in_innerNewExpression11082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayDeclaratorList_in_newArrayConstruction11125 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_arrayInitializer_in_newArrayConstruction11127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_newArrayConstruction11137 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_expression_in_newArrayConstruction11140 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_newArrayConstruction11142 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_LBRACK_in_newArrayConstruction11146 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_expression_in_newArrayConstruction11149 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_newArrayConstruction11151 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_arrayDeclaratorList_in_newArrayConstruction11156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments11176 = new BitSet(new long[]{0x9020084468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_expressionList_in_arguments11178 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_arguments11181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred49_LeMaVM5676 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_synpred49_LeMaVM5680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_synpred54_LeMaVM5906 = new BitSet(new long[]{0x9B60104468A01000L,0x0000000000DFFDE7L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_statement_in_synpred54_LeMaVM5910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchCaseLabel_in_synpred70_LeMaVM6784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_synpred114_LeMaVM8372 = new BitSet(new long[]{0x1020000000000000L,0x0000000000014060L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_synpred114_LeMaVM8374 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred114_LeMaVM8376 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_unaryExpression_in_synpred114_LeMaVM8378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedIdentExpression_in_synpred128_LeMaVM9197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_synpred132_LeMaVM9211 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_arguments_in_synpred132_LeMaVM9229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred132_LeMaVM9287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_synpred132_LeMaVM9289 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred132_LeMaVM9291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_synpred132_LeMaVM9356 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred132_LeMaVM9358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_synpred132_LeMaVM9411 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred132_LeMaVM9413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_synpred134_LeMaVM9476 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_arguments_in_synpred134_LeMaVM9544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_synpred135_LeMaVM9609 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred135_LeMaVM9611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_synpred137_LeMaVM9667 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_synpred137_LeMaVM9669 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_synpred137_LeMaVM9671 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_arguments_in_synpred137_LeMaVM9695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayDeclarator_in_synpred141_LeMaVM10175 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_DOT_in_synpred141_LeMaVM10243 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_CLASS_in_synpred141_LeMaVM10245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_synpred146_LeMaVM10463 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred146_LeMaVM10465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_synpred146_LeMaVM10513 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_synpred146_LeMaVM10517 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_synpred146_LeMaVM10519 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred146_LeMaVM10521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_synpred146_LeMaVM10569 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred146_LeMaVM10571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_synpred148_LeMaVM10710 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred148_LeMaVM10712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred149_LeMaVM10376 = new BitSet(new long[]{0x0100000000000000L,0x00000000000A0080L,0x0000000000000040L});
    public static final BitSet FOLLOW_CLASS_in_synpred149_LeMaVM10394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_synpred149_LeMaVM10463 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred149_LeMaVM10465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_synpred149_LeMaVM10513 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DOT_in_synpred149_LeMaVM10517 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_synpred149_LeMaVM10519 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred149_LeMaVM10521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_synpred149_LeMaVM10569 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred149_LeMaVM10571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_synpred149_LeMaVM10644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_synpred149_LeMaVM10710 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_arguments_in_synpred149_LeMaVM10712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_innerNewExpression_in_synpred149_LeMaVM10760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_synpred155_LeMaVM11146 = new BitSet(new long[]{0x9020004468A01000L,0x00000000005B41E0L,0x0000000000001FC0L});
    public static final BitSet FOLLOW_expression_in_synpred155_LeMaVM11149 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred155_LeMaVM11151 = new BitSet(new long[]{0x0000000000000002L});

}