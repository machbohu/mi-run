// $ANTLR 3.4 LeMaVM.g 2012-11-26 20:36:41

package cz.cvut.fit.mirun.lemavm.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class LeMaVMLexer extends Lexer {
    public static final int EOF=-1;
    public static final int AND=4;
    public static final int AND_ASSIGN=5;
    public static final int ARGUMENT_LIST=6;
    public static final int ARRAY_DECLARATOR=7;
    public static final int ARRAY_DECLARATOR_LIST=8;
    public static final int ARRAY_ELEMENT_ACCESS=9;
    public static final int ARRAY_INITIALIZER=10;
    public static final int ASSIGN=11;
    public static final int AT=12;
    public static final int BLOCK_SCOPE=13;
    public static final int BOOLEAN=14;
    public static final int BREAK=15;
    public static final int CASE=16;
    public static final int CAST_EXPR=17;
    public static final int CHARACTER_LITERAL=18;
    public static final int CLASS=19;
    public static final int CLASS_CONSTRUCTOR_CALL=20;
    public static final int CLASS_INSTANCE_INITIALIZER=21;
    public static final int CLASS_STATIC_INITIALIZER=22;
    public static final int CLASS_TOP_LEVEL_SCOPE=23;
    public static final int COLON=24;
    public static final int COMMA=25;
    public static final int COMMENT=26;
    public static final int CONSTRUCTOR_DECL=27;
    public static final int CONTINUE=28;
    public static final int DEC=29;
    public static final int DECIMAL_LITERAL=30;
    public static final int DEFAULT=31;
    public static final int DIV=32;
    public static final int DIV_ASSIGN=33;
    public static final int DO=34;
    public static final int DOT=35;
    public static final int DOTSTAR=36;
    public static final int DOUBLE=37;
    public static final int ELSE=38;
    public static final int ENUM_TOP_LEVEL_SCOPE=39;
    public static final int EQUAL=40;
    public static final int ESCAPE_SEQUENCE=41;
    public static final int EXPONENT=42;
    public static final int EXPR=43;
    public static final int EXTENDS=44;
    public static final int EXTENDS_BOUND_LIST=45;
    public static final int EXTENDS_CLAUSE=46;
    public static final int FALSE=47;
    public static final int FINAL=48;
    public static final int FLOATING_POINT_LITERAL=49;
    public static final int FLOAT_TYPE_SUFFIX=50;
    public static final int FOR=51;
    public static final int FORMAL_PARAM_LIST=52;
    public static final int FORMAL_PARAM_STD_DECL=53;
    public static final int FORMAL_PARAM_VARARG_DECL=54;
    public static final int FOR_CONDITION=55;
    public static final int FOR_EACH=56;
    public static final int FOR_INIT=57;
    public static final int FOR_UPDATE=58;
    public static final int FUNCTION_METHOD_DECL=59;
    public static final int GREATER_OR_EQUAL=60;
    public static final int GREATER_THAN=61;
    public static final int HEX_DIGIT=62;
    public static final int HEX_LITERAL=63;
    public static final int IDENT=64;
    public static final int IF=65;
    public static final int IMPORT=66;
    public static final int INC=67;
    public static final int INT=68;
    public static final int INTEGER_TYPE_SUFFIX=69;
    public static final int JAVA_ID_PART=70;
    public static final int JAVA_ID_START=71;
    public static final int JAVA_SOURCE=72;
    public static final int LABELED_STATEMENT=73;
    public static final int LBRACK=74;
    public static final int LCURLY=75;
    public static final int LESS_OR_EQUAL=76;
    public static final int LESS_THAN=77;
    public static final int LINE_COMMENT=78;
    public static final int LOCAL_MODIFIER_LIST=79;
    public static final int LOGICAL_AND=80;
    public static final int LOGICAL_NOT=81;
    public static final int LOGICAL_OR=82;
    public static final int LONG=83;
    public static final int LPAREN=84;
    public static final int METHOD_CALL=85;
    public static final int MINUS=86;
    public static final int MINUS_ASSIGN=87;
    public static final int MOD=88;
    public static final int MODIFIER_LIST=89;
    public static final int MOD_ASSIGN=90;
    public static final int NEW=91;
    public static final int NOT=92;
    public static final int NOT_EQUAL=93;
    public static final int NULL=94;
    public static final int OCTAL_ESCAPE=95;
    public static final int OCTAL_LITERAL=96;
    public static final int OR=97;
    public static final int OR_ASSIGN=98;
    public static final int PACKAGE=99;
    public static final int PARENTESIZED_EXPR=100;
    public static final int PLUS=101;
    public static final int PLUS_ASSIGN=102;
    public static final int POST_DEC=103;
    public static final int POST_INC=104;
    public static final int PRE_DEC=105;
    public static final int PRE_INC=106;
    public static final int PRIVATE=107;
    public static final int PROTECTED=108;
    public static final int PUBLIC=109;
    public static final int QUALIFIED_TYPE_IDENT=110;
    public static final int QUESTION=111;
    public static final int RBRACK=112;
    public static final int RCURLY=113;
    public static final int RETURN=114;
    public static final int RPAREN=115;
    public static final int SEMI=116;
    public static final int SHORT=117;
    public static final int STAR=118;
    public static final int STAR_ASSIGN=119;
    public static final int STATIC=120;
    public static final int STATIC_ARRAY_CREATOR=121;
    public static final int STRING_LITERAL=122;
    public static final int SUPER=123;
    public static final int SUPER_CONSTRUCTOR_CALL=124;
    public static final int SWITCH=125;
    public static final int SWITCH_BLOCK_LABEL_LIST=126;
    public static final int THIS=127;
    public static final int THIS_CONSTRUCTOR_CALL=128;
    public static final int TRUE=129;
    public static final int TYPE=130;
    public static final int UNARY_MINUS=131;
    public static final int UNARY_PLUS=132;
    public static final int UNICODE_ESCAPE=133;
    public static final int VAR_DECLARATION=134;
    public static final int VAR_DECLARATOR=135;
    public static final int VAR_DECLARATOR_LIST=136;
    public static final int VOID=137;
    public static final int VOID_METHOD_DECL=138;
    public static final int WHILE=139;
    public static final int WS=140;
    public static final int XOR=141;
    public static final int XOR_ASSIGN=142;

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


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public LeMaVMLexer() {} 
    public LeMaVMLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LeMaVMLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "LeMaVM.g"; }

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:18:5: ( '&' )
            // LeMaVM.g:18:7: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "AND_ASSIGN"
    public final void mAND_ASSIGN() throws RecognitionException {
        try {
            int _type = AND_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:19:12: ( '&=' )
            // LeMaVM.g:19:14: '&='
            {
            match("&="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND_ASSIGN"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:20:8: ( '=' )
            // LeMaVM.g:20:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:21:4: ( '@' )
            // LeMaVM.g:21:6: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AT"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:22:9: ( 'boolean' )
            // LeMaVM.g:22:11: 'boolean'
            {
            match("boolean"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "BREAK"
    public final void mBREAK() throws RecognitionException {
        try {
            int _type = BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:23:7: ( 'break' )
            // LeMaVM.g:23:9: 'break'
            {
            match("break"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BREAK"

    // $ANTLR start "CASE"
    public final void mCASE() throws RecognitionException {
        try {
            int _type = CASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:24:6: ( 'case' )
            // LeMaVM.g:24:8: 'case'
            {
            match("case"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CASE"

    // $ANTLR start "CLASS"
    public final void mCLASS() throws RecognitionException {
        try {
            int _type = CLASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:25:7: ( 'class' )
            // LeMaVM.g:25:9: 'class'
            {
            match("class"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CLASS"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:26:7: ( ':' )
            // LeMaVM.g:26:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:27:7: ( ',' )
            // LeMaVM.g:27:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "CONTINUE"
    public final void mCONTINUE() throws RecognitionException {
        try {
            int _type = CONTINUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:28:10: ( 'continue' )
            // LeMaVM.g:28:12: 'continue'
            {
            match("continue"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONTINUE"

    // $ANTLR start "DEC"
    public final void mDEC() throws RecognitionException {
        try {
            int _type = DEC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:29:5: ( '--' )
            // LeMaVM.g:29:7: '--'
            {
            match("--"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEC"

    // $ANTLR start "DEFAULT"
    public final void mDEFAULT() throws RecognitionException {
        try {
            int _type = DEFAULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:30:9: ( 'default' )
            // LeMaVM.g:30:11: 'default'
            {
            match("default"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEFAULT"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:31:5: ( '/' )
            // LeMaVM.g:31:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "DIV_ASSIGN"
    public final void mDIV_ASSIGN() throws RecognitionException {
        try {
            int _type = DIV_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:32:12: ( '/=' )
            // LeMaVM.g:32:14: '/='
            {
            match("/="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV_ASSIGN"

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:33:4: ( 'do' )
            // LeMaVM.g:33:6: 'do'
            {
            match("do"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:34:5: ( '.' )
            // LeMaVM.g:34:7: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "DOTSTAR"
    public final void mDOTSTAR() throws RecognitionException {
        try {
            int _type = DOTSTAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:35:9: ( '.*' )
            // LeMaVM.g:35:11: '.*'
            {
            match(".*"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOTSTAR"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:36:8: ( 'double' )
            // LeMaVM.g:36:10: 'double'
            {
            match("double"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:37:6: ( 'else' )
            // LeMaVM.g:37:8: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:38:7: ( '==' )
            // LeMaVM.g:38:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "EXTENDS"
    public final void mEXTENDS() throws RecognitionException {
        try {
            int _type = EXTENDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:39:9: ( 'extends' )
            // LeMaVM.g:39:11: 'extends'
            {
            match("extends"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXTENDS"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:40:7: ( 'false' )
            // LeMaVM.g:40:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "FINAL"
    public final void mFINAL() throws RecognitionException {
        try {
            int _type = FINAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:41:7: ( 'final' )
            // LeMaVM.g:41:9: 'final'
            {
            match("final"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FINAL"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:42:5: ( 'for' )
            // LeMaVM.g:42:7: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "GREATER_OR_EQUAL"
    public final void mGREATER_OR_EQUAL() throws RecognitionException {
        try {
            int _type = GREATER_OR_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:43:18: ( '>=' )
            // LeMaVM.g:43:20: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GREATER_OR_EQUAL"

    // $ANTLR start "GREATER_THAN"
    public final void mGREATER_THAN() throws RecognitionException {
        try {
            int _type = GREATER_THAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:44:14: ( '>' )
            // LeMaVM.g:44:16: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GREATER_THAN"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:45:4: ( 'if' )
            // LeMaVM.g:45:6: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "IMPORT"
    public final void mIMPORT() throws RecognitionException {
        try {
            int _type = IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:46:8: ( 'import' )
            // LeMaVM.g:46:10: 'import'
            {
            match("import"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMPORT"

    // $ANTLR start "INC"
    public final void mINC() throws RecognitionException {
        try {
            int _type = INC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:47:5: ( '++' )
            // LeMaVM.g:47:7: '++'
            {
            match("++"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INC"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:48:5: ( 'int' )
            // LeMaVM.g:48:7: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:49:8: ( '[' )
            // LeMaVM.g:49:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:50:8: ( '{' )
            // LeMaVM.g:50:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "LESS_OR_EQUAL"
    public final void mLESS_OR_EQUAL() throws RecognitionException {
        try {
            int _type = LESS_OR_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:51:15: ( '<=' )
            // LeMaVM.g:51:17: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESS_OR_EQUAL"

    // $ANTLR start "LESS_THAN"
    public final void mLESS_THAN() throws RecognitionException {
        try {
            int _type = LESS_THAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:52:11: ( '<' )
            // LeMaVM.g:52:13: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESS_THAN"

    // $ANTLR start "LOGICAL_AND"
    public final void mLOGICAL_AND() throws RecognitionException {
        try {
            int _type = LOGICAL_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:53:13: ( '&&' )
            // LeMaVM.g:53:15: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOGICAL_AND"

    // $ANTLR start "LOGICAL_NOT"
    public final void mLOGICAL_NOT() throws RecognitionException {
        try {
            int _type = LOGICAL_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:54:13: ( '!' )
            // LeMaVM.g:54:15: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOGICAL_NOT"

    // $ANTLR start "LOGICAL_OR"
    public final void mLOGICAL_OR() throws RecognitionException {
        try {
            int _type = LOGICAL_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:55:12: ( '||' )
            // LeMaVM.g:55:14: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOGICAL_OR"

    // $ANTLR start "LONG"
    public final void mLONG() throws RecognitionException {
        try {
            int _type = LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:56:6: ( 'long' )
            // LeMaVM.g:56:8: 'long'
            {
            match("long"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LONG"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:57:8: ( '(' )
            // LeMaVM.g:57:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:58:7: ( '-' )
            // LeMaVM.g:58:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MINUS_ASSIGN"
    public final void mMINUS_ASSIGN() throws RecognitionException {
        try {
            int _type = MINUS_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:59:14: ( '-=' )
            // LeMaVM.g:59:16: '-='
            {
            match("-="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS_ASSIGN"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:60:5: ( '%' )
            // LeMaVM.g:60:7: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "MOD_ASSIGN"
    public final void mMOD_ASSIGN() throws RecognitionException {
        try {
            int _type = MOD_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:61:12: ( '%=' )
            // LeMaVM.g:61:14: '%='
            {
            match("%="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOD_ASSIGN"

    // $ANTLR start "NEW"
    public final void mNEW() throws RecognitionException {
        try {
            int _type = NEW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:62:5: ( 'new' )
            // LeMaVM.g:62:7: 'new'
            {
            match("new"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEW"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:63:5: ( '~' )
            // LeMaVM.g:63:7: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "NOT_EQUAL"
    public final void mNOT_EQUAL() throws RecognitionException {
        try {
            int _type = NOT_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:64:11: ( '!=' )
            // LeMaVM.g:64:13: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT_EQUAL"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:65:6: ( 'null' )
            // LeMaVM.g:65:8: 'null'
            {
            match("null"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:66:4: ( '|' )
            // LeMaVM.g:66:6: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "OR_ASSIGN"
    public final void mOR_ASSIGN() throws RecognitionException {
        try {
            int _type = OR_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:67:11: ( '|=' )
            // LeMaVM.g:67:13: '|='
            {
            match("|="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR_ASSIGN"

    // $ANTLR start "PACKAGE"
    public final void mPACKAGE() throws RecognitionException {
        try {
            int _type = PACKAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:68:9: ( 'package' )
            // LeMaVM.g:68:11: 'package'
            {
            match("package"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PACKAGE"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:69:6: ( '+' )
            // LeMaVM.g:69:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "PLUS_ASSIGN"
    public final void mPLUS_ASSIGN() throws RecognitionException {
        try {
            int _type = PLUS_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:70:13: ( '+=' )
            // LeMaVM.g:70:15: '+='
            {
            match("+="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS_ASSIGN"

    // $ANTLR start "PRIVATE"
    public final void mPRIVATE() throws RecognitionException {
        try {
            int _type = PRIVATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:71:9: ( 'private' )
            // LeMaVM.g:71:11: 'private'
            {
            match("private"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PRIVATE"

    // $ANTLR start "PROTECTED"
    public final void mPROTECTED() throws RecognitionException {
        try {
            int _type = PROTECTED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:72:11: ( 'protected' )
            // LeMaVM.g:72:13: 'protected'
            {
            match("protected"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROTECTED"

    // $ANTLR start "PUBLIC"
    public final void mPUBLIC() throws RecognitionException {
        try {
            int _type = PUBLIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:73:8: ( 'public' )
            // LeMaVM.g:73:10: 'public'
            {
            match("public"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PUBLIC"

    // $ANTLR start "QUESTION"
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:74:10: ( '?' )
            // LeMaVM.g:74:12: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUESTION"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:75:8: ( ']' )
            // LeMaVM.g:75:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:76:8: ( '}' )
            // LeMaVM.g:76:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:77:8: ( 'return' )
            // LeMaVM.g:77:10: 'return'
            {
            match("return"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RETURN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:78:8: ( ')' )
            // LeMaVM.g:78:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:79:6: ( ';' )
            // LeMaVM.g:79:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "SHORT"
    public final void mSHORT() throws RecognitionException {
        try {
            int _type = SHORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:80:7: ( 'short' )
            // LeMaVM.g:80:9: 'short'
            {
            match("short"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHORT"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:81:6: ( '*' )
            // LeMaVM.g:81:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "STAR_ASSIGN"
    public final void mSTAR_ASSIGN() throws RecognitionException {
        try {
            int _type = STAR_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:82:13: ( '*=' )
            // LeMaVM.g:82:15: '*='
            {
            match("*="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STAR_ASSIGN"

    // $ANTLR start "STATIC"
    public final void mSTATIC() throws RecognitionException {
        try {
            int _type = STATIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:83:8: ( 'static' )
            // LeMaVM.g:83:10: 'static'
            {
            match("static"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STATIC"

    // $ANTLR start "SUPER"
    public final void mSUPER() throws RecognitionException {
        try {
            int _type = SUPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:84:7: ( 'super' )
            // LeMaVM.g:84:9: 'super'
            {
            match("super"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUPER"

    // $ANTLR start "SWITCH"
    public final void mSWITCH() throws RecognitionException {
        try {
            int _type = SWITCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:85:8: ( 'switch' )
            // LeMaVM.g:85:10: 'switch'
            {
            match("switch"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SWITCH"

    // $ANTLR start "THIS"
    public final void mTHIS() throws RecognitionException {
        try {
            int _type = THIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:86:6: ( 'this' )
            // LeMaVM.g:86:8: 'this'
            {
            match("this"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THIS"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:87:6: ( 'true' )
            // LeMaVM.g:87:8: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "VOID"
    public final void mVOID() throws RecognitionException {
        try {
            int _type = VOID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:88:6: ( 'void' )
            // LeMaVM.g:88:8: 'void'
            {
            match("void"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VOID"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:89:7: ( 'while' )
            // LeMaVM.g:89:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "XOR"
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:90:5: ( '^' )
            // LeMaVM.g:90:7: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "XOR"

    // $ANTLR start "XOR_ASSIGN"
    public final void mXOR_ASSIGN() throws RecognitionException {
        try {
            int _type = XOR_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:91:12: ( '^=' )
            // LeMaVM.g:91:14: '^='
            {
            match("^="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "XOR_ASSIGN"

    // $ANTLR start "HEX_LITERAL"
    public final void mHEX_LITERAL() throws RecognitionException {
        try {
            int _type = HEX_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:770:13: ( '0' ( 'x' | 'X' ) ( HEX_DIGIT )+ ( INTEGER_TYPE_SUFFIX )? )
            // LeMaVM.g:770:15: '0' ( 'x' | 'X' ) ( HEX_DIGIT )+ ( INTEGER_TYPE_SUFFIX )?
            {
            match('0'); 

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // LeMaVM.g:770:29: ( HEX_DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'F')||(LA1_0 >= 'a' && LA1_0 <= 'f')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // LeMaVM.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            // LeMaVM.g:770:40: ( INTEGER_TYPE_SUFFIX )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='L'||LA2_0=='l') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // LeMaVM.g:
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_LITERAL"

    // $ANTLR start "DECIMAL_LITERAL"
    public final void mDECIMAL_LITERAL() throws RecognitionException {
        try {
            int _type = DECIMAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:772:17: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( INTEGER_TYPE_SUFFIX )? )
            // LeMaVM.g:772:19: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( INTEGER_TYPE_SUFFIX )?
            {
            // LeMaVM.g:772:19: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='0') ) {
                alt4=1;
            }
            else if ( ((LA4_0 >= '1' && LA4_0 <= '9')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // LeMaVM.g:772:20: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // LeMaVM.g:772:26: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 

                    // LeMaVM.g:772:35: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // LeMaVM.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }


            // LeMaVM.g:772:46: ( INTEGER_TYPE_SUFFIX )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='L'||LA5_0=='l') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // LeMaVM.g:
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DECIMAL_LITERAL"

    // $ANTLR start "OCTAL_LITERAL"
    public final void mOCTAL_LITERAL() throws RecognitionException {
        try {
            int _type = OCTAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:774:15: ( '0' ( '0' .. '7' )+ ( INTEGER_TYPE_SUFFIX )? )
            // LeMaVM.g:774:17: '0' ( '0' .. '7' )+ ( INTEGER_TYPE_SUFFIX )?
            {
            match('0'); 

            // LeMaVM.g:774:21: ( '0' .. '7' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '7')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // LeMaVM.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            // LeMaVM.g:774:33: ( INTEGER_TYPE_SUFFIX )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='L'||LA7_0=='l') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // LeMaVM.g:
                    {
                    if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_LITERAL"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // LeMaVM.g:778:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // LeMaVM.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "INTEGER_TYPE_SUFFIX"
    public final void mINTEGER_TYPE_SUFFIX() throws RecognitionException {
        try {
            // LeMaVM.g:781:21: ( ( 'l' | 'L' ) )
            // LeMaVM.g:
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER_TYPE_SUFFIX"

    // $ANTLR start "FLOATING_POINT_LITERAL"
    public final void mFLOATING_POINT_LITERAL() throws RecognitionException {
        try {
            int _type = FLOATING_POINT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:783:5: ( ( '0' .. '9' )+ ( DOT ( '0' .. '9' )* ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )? | EXPONENT ( FLOAT_TYPE_SUFFIX )? | FLOAT_TYPE_SUFFIX ) | DOT ( '0' .. '9' )+ ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0 >= '0' && LA17_0 <= '9')) ) {
                alt17=1;
            }
            else if ( (LA17_0=='.') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // LeMaVM.g:783:9: ( '0' .. '9' )+ ( DOT ( '0' .. '9' )* ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )? | EXPONENT ( FLOAT_TYPE_SUFFIX )? | FLOAT_TYPE_SUFFIX )
                    {
                    // LeMaVM.g:783:9: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // LeMaVM.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    // LeMaVM.g:784:9: ( DOT ( '0' .. '9' )* ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )? | EXPONENT ( FLOAT_TYPE_SUFFIX )? | FLOAT_TYPE_SUFFIX )
                    int alt13=3;
                    switch ( input.LA(1) ) {
                    case '.':
                        {
                        alt13=1;
                        }
                        break;
                    case 'E':
                    case 'e':
                        {
                        alt13=2;
                        }
                        break;
                    case 'D':
                    case 'F':
                    case 'd':
                    case 'f':
                        {
                        alt13=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;

                    }

                    switch (alt13) {
                        case 1 :
                            // LeMaVM.g:785:13: DOT ( '0' .. '9' )* ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )?
                            {
                            mDOT(); 


                            // LeMaVM.g:785:17: ( '0' .. '9' )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // LeMaVM.g:
                            	    {
                            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop9;
                                }
                            } while (true);


                            // LeMaVM.g:785:29: ( EXPONENT )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0=='E'||LA10_0=='e') ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // LeMaVM.g:785:29: EXPONENT
                                    {
                                    mEXPONENT(); 


                                    }
                                    break;

                            }


                            // LeMaVM.g:785:39: ( FLOAT_TYPE_SUFFIX )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0=='D'||LA11_0=='F'||LA11_0=='d'||LA11_0=='f') ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // LeMaVM.g:
                                    {
                                    if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                        input.consume();
                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;
                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // LeMaVM.g:786:13: EXPONENT ( FLOAT_TYPE_SUFFIX )?
                            {
                            mEXPONENT(); 


                            // LeMaVM.g:786:22: ( FLOAT_TYPE_SUFFIX )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0=='D'||LA12_0=='F'||LA12_0=='d'||LA12_0=='f') ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // LeMaVM.g:
                                    {
                                    if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                        input.consume();
                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;
                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 3 :
                            // LeMaVM.g:787:13: FLOAT_TYPE_SUFFIX
                            {
                            mFLOAT_TYPE_SUFFIX(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // LeMaVM.g:789:9: DOT ( '0' .. '9' )+ ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )?
                    {
                    mDOT(); 


                    // LeMaVM.g:789:13: ( '0' .. '9' )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // LeMaVM.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    // LeMaVM.g:789:25: ( EXPONENT )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='E'||LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // LeMaVM.g:789:25: EXPONENT
                            {
                            mEXPONENT(); 


                            }
                            break;

                    }


                    // LeMaVM.g:789:35: ( FLOAT_TYPE_SUFFIX )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='D'||LA16_0=='F'||LA16_0=='d'||LA16_0=='f') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // LeMaVM.g:
                            {
                            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOATING_POINT_LITERAL"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // LeMaVM.g:794:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // LeMaVM.g:794:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // LeMaVM.g:794:22: ( '+' | '-' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='+'||LA18_0=='-') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // LeMaVM.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // LeMaVM.g:794:33: ( '0' .. '9' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0 >= '0' && LA19_0 <= '9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // LeMaVM.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "FLOAT_TYPE_SUFFIX"
    public final void mFLOAT_TYPE_SUFFIX() throws RecognitionException {
        try {
            // LeMaVM.g:797:19: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // LeMaVM.g:
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT_TYPE_SUFFIX"

    // $ANTLR start "CHARACTER_LITERAL"
    public final void mCHARACTER_LITERAL() throws RecognitionException {
        try {
            int _type = CHARACTER_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:799:5: ( '\\'' ( ESCAPE_SEQUENCE |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // LeMaVM.g:799:9: '\\'' ( ESCAPE_SEQUENCE |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // LeMaVM.g:799:14: ( ESCAPE_SEQUENCE |~ ( '\\'' | '\\\\' ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\\') ) {
                alt20=1;
            }
            else if ( ((LA20_0 >= '\u0000' && LA20_0 <= '&')||(LA20_0 >= '(' && LA20_0 <= '[')||(LA20_0 >= ']' && LA20_0 <= '\uFFFF')) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // LeMaVM.g:799:16: ESCAPE_SEQUENCE
                    {
                    mESCAPE_SEQUENCE(); 


                    }
                    break;
                case 2 :
                    // LeMaVM.g:799:34: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARACTER_LITERAL"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:803:5: ( '\"' ( ESCAPE_SEQUENCE |~ ( '\\\\' | '\"' ) )* '\"' )
            // LeMaVM.g:803:8: '\"' ( ESCAPE_SEQUENCE |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // LeMaVM.g:803:12: ( ESCAPE_SEQUENCE |~ ( '\\\\' | '\"' ) )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\\') ) {
                    alt21=1;
                }
                else if ( ((LA21_0 >= '\u0000' && LA21_0 <= '!')||(LA21_0 >= '#' && LA21_0 <= '[')||(LA21_0 >= ']' && LA21_0 <= '\uFFFF')) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // LeMaVM.g:803:14: ESCAPE_SEQUENCE
            	    {
            	    mESCAPE_SEQUENCE(); 


            	    }
            	    break;
            	case 2 :
            	    // LeMaVM.g:803:32: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "ESCAPE_SEQUENCE"
    public final void mESCAPE_SEQUENCE() throws RecognitionException {
        try {
            // LeMaVM.g:809:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESCAPE | OCTAL_ESCAPE )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt22=1;
                    }
                    break;
                case 'u':
                    {
                    alt22=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt22=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // LeMaVM.g:809:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // LeMaVM.g:810:9: UNICODE_ESCAPE
                    {
                    mUNICODE_ESCAPE(); 


                    }
                    break;
                case 3 :
                    // LeMaVM.g:811:9: OCTAL_ESCAPE
                    {
                    mOCTAL_ESCAPE(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESCAPE_SEQUENCE"

    // $ANTLR start "OCTAL_ESCAPE"
    public final void mOCTAL_ESCAPE() throws RecognitionException {
        try {
            // LeMaVM.g:816:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='\\') ) {
                int LA23_1 = input.LA(2);

                if ( ((LA23_1 >= '0' && LA23_1 <= '3')) ) {
                    int LA23_2 = input.LA(3);

                    if ( ((LA23_2 >= '0' && LA23_2 <= '7')) ) {
                        int LA23_4 = input.LA(4);

                        if ( ((LA23_4 >= '0' && LA23_4 <= '7')) ) {
                            alt23=1;
                        }
                        else {
                            alt23=2;
                        }
                    }
                    else {
                        alt23=3;
                    }
                }
                else if ( ((LA23_1 >= '4' && LA23_1 <= '7')) ) {
                    int LA23_3 = input.LA(3);

                    if ( ((LA23_3 >= '0' && LA23_3 <= '7')) ) {
                        alt23=2;
                    }
                    else {
                        alt23=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // LeMaVM.g:816:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // LeMaVM.g:817:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // LeMaVM.g:818:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESCAPE"

    // $ANTLR start "UNICODE_ESCAPE"
    public final void mUNICODE_ESCAPE() throws RecognitionException {
        try {
            // LeMaVM.g:823:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // LeMaVM.g:823:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESCAPE"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:826:5: ( JAVA_ID_START ( JAVA_ID_PART )* )
            // LeMaVM.g:826:9: JAVA_ID_START ( JAVA_ID_PART )*
            {
            mJAVA_ID_START(); 


            // LeMaVM.g:826:23: ( JAVA_ID_PART )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0=='$'||(LA24_0 >= '0' && LA24_0 <= '9')||(LA24_0 >= 'A' && LA24_0 <= 'Z')||LA24_0=='_'||(LA24_0 >= 'a' && LA24_0 <= 'z')||(LA24_0 >= '\u00C0' && LA24_0 <= '\u00D6')||(LA24_0 >= '\u00D8' && LA24_0 <= '\u00F6')||(LA24_0 >= '\u00F8' && LA24_0 <= '\u1FFF')||(LA24_0 >= '\u3040' && LA24_0 <= '\u318F')||(LA24_0 >= '\u3300' && LA24_0 <= '\u337F')||(LA24_0 >= '\u3400' && LA24_0 <= '\u3D2D')||(LA24_0 >= '\u4E00' && LA24_0 <= '\u9FFF')||(LA24_0 >= '\uF900' && LA24_0 <= '\uFAFF')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // LeMaVM.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\u1FFF')||(input.LA(1) >= '\u3040' && input.LA(1) <= '\u318F')||(input.LA(1) >= '\u3300' && input.LA(1) <= '\u337F')||(input.LA(1) >= '\u3400' && input.LA(1) <= '\u3D2D')||(input.LA(1) >= '\u4E00' && input.LA(1) <= '\u9FFF')||(input.LA(1) >= '\uF900' && input.LA(1) <= '\uFAFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "JAVA_ID_START"
    public final void mJAVA_ID_START() throws RecognitionException {
        try {
            // LeMaVM.g:832:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // LeMaVM.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\u1FFF')||(input.LA(1) >= '\u3040' && input.LA(1) <= '\u318F')||(input.LA(1) >= '\u3300' && input.LA(1) <= '\u337F')||(input.LA(1) >= '\u3400' && input.LA(1) <= '\u3D2D')||(input.LA(1) >= '\u4E00' && input.LA(1) <= '\u9FFF')||(input.LA(1) >= '\uF900' && input.LA(1) <= '\uFAFF') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "JAVA_ID_START"

    // $ANTLR start "JAVA_ID_PART"
    public final void mJAVA_ID_PART() throws RecognitionException {
        try {
            // LeMaVM.g:849:5: ( JAVA_ID_START | '\\u0030' .. '\\u0039' )
            // LeMaVM.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\u1FFF')||(input.LA(1) >= '\u3040' && input.LA(1) <= '\u318F')||(input.LA(1) >= '\u3300' && input.LA(1) <= '\u337F')||(input.LA(1) >= '\u3400' && input.LA(1) <= '\u3D2D')||(input.LA(1) >= '\u4E00' && input.LA(1) <= '\u9FFF')||(input.LA(1) >= '\uF900' && input.LA(1) <= '\uFAFF') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "JAVA_ID_PART"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:852:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // LeMaVM.g:852:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


               
                    if (!preserveWhitespacesAndComments) {
                        skip();
                    } else {
                        _channel = HIDDEN;
                    }
                

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:863:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // LeMaVM.g:863:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // LeMaVM.g:863:14: ( options {greedy=false; } : . )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0=='*') ) {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1=='/') ) {
                        alt25=2;
                    }
                    else if ( ((LA25_1 >= '\u0000' && LA25_1 <= '.')||(LA25_1 >= '0' && LA25_1 <= '\uFFFF')) ) {
                        alt25=1;
                    }


                }
                else if ( ((LA25_0 >= '\u0000' && LA25_0 <= ')')||(LA25_0 >= '+' && LA25_0 <= '\uFFFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // LeMaVM.g:863:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            match("*/"); 



               
                    if (!preserveWhitespacesAndComments) {
                        skip();
                    } else {
                        _channel = HIDDEN;
                    }
                

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:874:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // LeMaVM.g:874:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 



            // LeMaVM.g:874:12: (~ ( '\\n' | '\\r' ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0 >= '\u0000' && LA26_0 <= '\t')||(LA26_0 >= '\u000B' && LA26_0 <= '\f')||(LA26_0 >= '\u000E' && LA26_0 <= '\uFFFF')) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // LeMaVM.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            // LeMaVM.g:874:26: ( '\\r' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='\r') ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // LeMaVM.g:874:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

               
                    if (!preserveWhitespacesAndComments) {
                        skip();
                    } else {
                        _channel = HIDDEN;
                    }
                

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // LeMaVM.g:1:8: ( AND | AND_ASSIGN | ASSIGN | AT | BOOLEAN | BREAK | CASE | CLASS | COLON | COMMA | CONTINUE | DEC | DEFAULT | DIV | DIV_ASSIGN | DO | DOT | DOTSTAR | DOUBLE | ELSE | EQUAL | EXTENDS | FALSE | FINAL | FOR | GREATER_OR_EQUAL | GREATER_THAN | IF | IMPORT | INC | INT | LBRACK | LCURLY | LESS_OR_EQUAL | LESS_THAN | LOGICAL_AND | LOGICAL_NOT | LOGICAL_OR | LONG | LPAREN | MINUS | MINUS_ASSIGN | MOD | MOD_ASSIGN | NEW | NOT | NOT_EQUAL | NULL | OR | OR_ASSIGN | PACKAGE | PLUS | PLUS_ASSIGN | PRIVATE | PROTECTED | PUBLIC | QUESTION | RBRACK | RCURLY | RETURN | RPAREN | SEMI | SHORT | STAR | STAR_ASSIGN | STATIC | SUPER | SWITCH | THIS | TRUE | VOID | WHILE | XOR | XOR_ASSIGN | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | FLOATING_POINT_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | IDENT | WS | COMMENT | LINE_COMMENT )
        int alt28=84;
        alt28 = dfa28.predict(input);
        switch (alt28) {
            case 1 :
                // LeMaVM.g:1:10: AND
                {
                mAND(); 


                }
                break;
            case 2 :
                // LeMaVM.g:1:14: AND_ASSIGN
                {
                mAND_ASSIGN(); 


                }
                break;
            case 3 :
                // LeMaVM.g:1:25: ASSIGN
                {
                mASSIGN(); 


                }
                break;
            case 4 :
                // LeMaVM.g:1:32: AT
                {
                mAT(); 


                }
                break;
            case 5 :
                // LeMaVM.g:1:35: BOOLEAN
                {
                mBOOLEAN(); 


                }
                break;
            case 6 :
                // LeMaVM.g:1:43: BREAK
                {
                mBREAK(); 


                }
                break;
            case 7 :
                // LeMaVM.g:1:49: CASE
                {
                mCASE(); 


                }
                break;
            case 8 :
                // LeMaVM.g:1:54: CLASS
                {
                mCLASS(); 


                }
                break;
            case 9 :
                // LeMaVM.g:1:60: COLON
                {
                mCOLON(); 


                }
                break;
            case 10 :
                // LeMaVM.g:1:66: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 11 :
                // LeMaVM.g:1:72: CONTINUE
                {
                mCONTINUE(); 


                }
                break;
            case 12 :
                // LeMaVM.g:1:81: DEC
                {
                mDEC(); 


                }
                break;
            case 13 :
                // LeMaVM.g:1:85: DEFAULT
                {
                mDEFAULT(); 


                }
                break;
            case 14 :
                // LeMaVM.g:1:93: DIV
                {
                mDIV(); 


                }
                break;
            case 15 :
                // LeMaVM.g:1:97: DIV_ASSIGN
                {
                mDIV_ASSIGN(); 


                }
                break;
            case 16 :
                // LeMaVM.g:1:108: DO
                {
                mDO(); 


                }
                break;
            case 17 :
                // LeMaVM.g:1:111: DOT
                {
                mDOT(); 


                }
                break;
            case 18 :
                // LeMaVM.g:1:115: DOTSTAR
                {
                mDOTSTAR(); 


                }
                break;
            case 19 :
                // LeMaVM.g:1:123: DOUBLE
                {
                mDOUBLE(); 


                }
                break;
            case 20 :
                // LeMaVM.g:1:130: ELSE
                {
                mELSE(); 


                }
                break;
            case 21 :
                // LeMaVM.g:1:135: EQUAL
                {
                mEQUAL(); 


                }
                break;
            case 22 :
                // LeMaVM.g:1:141: EXTENDS
                {
                mEXTENDS(); 


                }
                break;
            case 23 :
                // LeMaVM.g:1:149: FALSE
                {
                mFALSE(); 


                }
                break;
            case 24 :
                // LeMaVM.g:1:155: FINAL
                {
                mFINAL(); 


                }
                break;
            case 25 :
                // LeMaVM.g:1:161: FOR
                {
                mFOR(); 


                }
                break;
            case 26 :
                // LeMaVM.g:1:165: GREATER_OR_EQUAL
                {
                mGREATER_OR_EQUAL(); 


                }
                break;
            case 27 :
                // LeMaVM.g:1:182: GREATER_THAN
                {
                mGREATER_THAN(); 


                }
                break;
            case 28 :
                // LeMaVM.g:1:195: IF
                {
                mIF(); 


                }
                break;
            case 29 :
                // LeMaVM.g:1:198: IMPORT
                {
                mIMPORT(); 


                }
                break;
            case 30 :
                // LeMaVM.g:1:205: INC
                {
                mINC(); 


                }
                break;
            case 31 :
                // LeMaVM.g:1:209: INT
                {
                mINT(); 


                }
                break;
            case 32 :
                // LeMaVM.g:1:213: LBRACK
                {
                mLBRACK(); 


                }
                break;
            case 33 :
                // LeMaVM.g:1:220: LCURLY
                {
                mLCURLY(); 


                }
                break;
            case 34 :
                // LeMaVM.g:1:227: LESS_OR_EQUAL
                {
                mLESS_OR_EQUAL(); 


                }
                break;
            case 35 :
                // LeMaVM.g:1:241: LESS_THAN
                {
                mLESS_THAN(); 


                }
                break;
            case 36 :
                // LeMaVM.g:1:251: LOGICAL_AND
                {
                mLOGICAL_AND(); 


                }
                break;
            case 37 :
                // LeMaVM.g:1:263: LOGICAL_NOT
                {
                mLOGICAL_NOT(); 


                }
                break;
            case 38 :
                // LeMaVM.g:1:275: LOGICAL_OR
                {
                mLOGICAL_OR(); 


                }
                break;
            case 39 :
                // LeMaVM.g:1:286: LONG
                {
                mLONG(); 


                }
                break;
            case 40 :
                // LeMaVM.g:1:291: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 41 :
                // LeMaVM.g:1:298: MINUS
                {
                mMINUS(); 


                }
                break;
            case 42 :
                // LeMaVM.g:1:304: MINUS_ASSIGN
                {
                mMINUS_ASSIGN(); 


                }
                break;
            case 43 :
                // LeMaVM.g:1:317: MOD
                {
                mMOD(); 


                }
                break;
            case 44 :
                // LeMaVM.g:1:321: MOD_ASSIGN
                {
                mMOD_ASSIGN(); 


                }
                break;
            case 45 :
                // LeMaVM.g:1:332: NEW
                {
                mNEW(); 


                }
                break;
            case 46 :
                // LeMaVM.g:1:336: NOT
                {
                mNOT(); 


                }
                break;
            case 47 :
                // LeMaVM.g:1:340: NOT_EQUAL
                {
                mNOT_EQUAL(); 


                }
                break;
            case 48 :
                // LeMaVM.g:1:350: NULL
                {
                mNULL(); 


                }
                break;
            case 49 :
                // LeMaVM.g:1:355: OR
                {
                mOR(); 


                }
                break;
            case 50 :
                // LeMaVM.g:1:358: OR_ASSIGN
                {
                mOR_ASSIGN(); 


                }
                break;
            case 51 :
                // LeMaVM.g:1:368: PACKAGE
                {
                mPACKAGE(); 


                }
                break;
            case 52 :
                // LeMaVM.g:1:376: PLUS
                {
                mPLUS(); 


                }
                break;
            case 53 :
                // LeMaVM.g:1:381: PLUS_ASSIGN
                {
                mPLUS_ASSIGN(); 


                }
                break;
            case 54 :
                // LeMaVM.g:1:393: PRIVATE
                {
                mPRIVATE(); 


                }
                break;
            case 55 :
                // LeMaVM.g:1:401: PROTECTED
                {
                mPROTECTED(); 


                }
                break;
            case 56 :
                // LeMaVM.g:1:411: PUBLIC
                {
                mPUBLIC(); 


                }
                break;
            case 57 :
                // LeMaVM.g:1:418: QUESTION
                {
                mQUESTION(); 


                }
                break;
            case 58 :
                // LeMaVM.g:1:427: RBRACK
                {
                mRBRACK(); 


                }
                break;
            case 59 :
                // LeMaVM.g:1:434: RCURLY
                {
                mRCURLY(); 


                }
                break;
            case 60 :
                // LeMaVM.g:1:441: RETURN
                {
                mRETURN(); 


                }
                break;
            case 61 :
                // LeMaVM.g:1:448: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 62 :
                // LeMaVM.g:1:455: SEMI
                {
                mSEMI(); 


                }
                break;
            case 63 :
                // LeMaVM.g:1:460: SHORT
                {
                mSHORT(); 


                }
                break;
            case 64 :
                // LeMaVM.g:1:466: STAR
                {
                mSTAR(); 


                }
                break;
            case 65 :
                // LeMaVM.g:1:471: STAR_ASSIGN
                {
                mSTAR_ASSIGN(); 


                }
                break;
            case 66 :
                // LeMaVM.g:1:483: STATIC
                {
                mSTATIC(); 


                }
                break;
            case 67 :
                // LeMaVM.g:1:490: SUPER
                {
                mSUPER(); 


                }
                break;
            case 68 :
                // LeMaVM.g:1:496: SWITCH
                {
                mSWITCH(); 


                }
                break;
            case 69 :
                // LeMaVM.g:1:503: THIS
                {
                mTHIS(); 


                }
                break;
            case 70 :
                // LeMaVM.g:1:508: TRUE
                {
                mTRUE(); 


                }
                break;
            case 71 :
                // LeMaVM.g:1:513: VOID
                {
                mVOID(); 


                }
                break;
            case 72 :
                // LeMaVM.g:1:518: WHILE
                {
                mWHILE(); 


                }
                break;
            case 73 :
                // LeMaVM.g:1:524: XOR
                {
                mXOR(); 


                }
                break;
            case 74 :
                // LeMaVM.g:1:528: XOR_ASSIGN
                {
                mXOR_ASSIGN(); 


                }
                break;
            case 75 :
                // LeMaVM.g:1:539: HEX_LITERAL
                {
                mHEX_LITERAL(); 


                }
                break;
            case 76 :
                // LeMaVM.g:1:551: DECIMAL_LITERAL
                {
                mDECIMAL_LITERAL(); 


                }
                break;
            case 77 :
                // LeMaVM.g:1:567: OCTAL_LITERAL
                {
                mOCTAL_LITERAL(); 


                }
                break;
            case 78 :
                // LeMaVM.g:1:581: FLOATING_POINT_LITERAL
                {
                mFLOATING_POINT_LITERAL(); 


                }
                break;
            case 79 :
                // LeMaVM.g:1:604: CHARACTER_LITERAL
                {
                mCHARACTER_LITERAL(); 


                }
                break;
            case 80 :
                // LeMaVM.g:1:622: STRING_LITERAL
                {
                mSTRING_LITERAL(); 


                }
                break;
            case 81 :
                // LeMaVM.g:1:637: IDENT
                {
                mIDENT(); 


                }
                break;
            case 82 :
                // LeMaVM.g:1:643: WS
                {
                mWS(); 


                }
                break;
            case 83 :
                // LeMaVM.g:1:646: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 84 :
                // LeMaVM.g:1:654: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;

        }

    }


    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA28_eotS =
        "\1\uffff\1\60\1\62\1\uffff\2\54\2\uffff\1\72\1\54\1\100\1\102\2"+
        "\54\1\112\1\54\1\120\2\uffff\1\122\1\124\1\127\1\54\1\uffff\1\132"+
        "\1\54\1\uffff\1\54\3\uffff\1\54\2\uffff\1\54\1\146\3\54\1\154\2"+
        "\156\11\uffff\5\54\3\uffff\1\54\1\170\7\uffff\5\54\2\uffff\1\176"+
        "\2\54\12\uffff\1\54\2\uffff\12\54\2\uffff\4\54\4\uffff\1\u0091\1"+
        "\156\7\54\1\uffff\4\54\1\u009d\1\uffff\1\54\1\u009f\1\54\1\u00a1"+
        "\16\54\1\uffff\2\54\1\u00b2\4\54\1\u00b7\3\54\1\uffff\1\54\1\uffff"+
        "\1\u00bc\1\uffff\1\u00bd\11\54\1\u00c7\1\u00c8\1\u00c9\2\54\1\u00cc"+
        "\1\uffff\1\u00cd\3\54\1\uffff\1\54\1\u00d2\1\u00d3\1\54\2\uffff"+
        "\5\54\1\u00da\1\54\1\u00dc\1\54\3\uffff\1\u00de\1\54\2\uffff\2\54"+
        "\1\u00e2\1\54\2\uffff\1\u00e4\3\54\1\u00e8\1\u00e9\1\uffff\1\u00ea"+
        "\1\uffff\1\u00eb\1\uffff\1\u00ec\1\54\1\u00ee\1\uffff\1\u00ef\1"+
        "\uffff\1\u00f0\1\u00f1\1\54\5\uffff\1\u00f3\4\uffff\1\54\1\uffff"+
        "\1\u00f5\1\uffff";
    static final String DFA28_eofS =
        "\u00f6\uffff";
    static final String DFA28_minS =
        "\1\11\1\46\1\75\1\uffff\1\157\1\141\2\uffff\1\55\1\145\2\52\1\154"+
        "\1\141\1\75\1\146\1\53\2\uffff\3\75\1\157\1\uffff\1\75\1\145\1\uffff"+
        "\1\141\3\uffff\1\145\2\uffff\1\150\1\75\1\150\1\157\1\150\1\75\2"+
        "\56\11\uffff\1\157\1\145\1\163\1\141\1\156\3\uffff\1\146\1\44\7"+
        "\uffff\1\163\1\164\1\154\1\156\1\162\2\uffff\1\44\1\160\1\164\12"+
        "\uffff\1\156\2\uffff\1\167\1\154\1\143\1\151\1\142\1\164\1\157\1"+
        "\141\1\160\1\151\2\uffff\1\151\1\165\2\151\4\uffff\2\56\1\154\1"+
        "\141\1\145\1\163\1\164\1\141\1\142\1\uffff\2\145\1\163\1\141\1\44"+
        "\1\uffff\1\157\1\44\1\147\1\44\1\154\1\153\1\166\1\164\1\154\1\165"+
        "\1\162\1\164\1\145\1\164\1\163\1\145\1\144\1\154\1\uffff\1\145\1"+
        "\153\1\44\1\163\1\151\1\165\1\154\1\44\1\156\1\145\1\154\1\uffff"+
        "\1\162\1\uffff\1\44\1\uffff\1\44\2\141\1\145\1\151\1\162\1\164\1"+
        "\151\1\162\1\143\3\44\1\145\1\141\1\44\1\uffff\1\44\1\156\1\154"+
        "\1\145\1\uffff\1\144\2\44\1\164\2\uffff\1\147\1\164\2\143\1\156"+
        "\1\44\1\143\1\44\1\150\3\uffff\1\44\1\156\2\uffff\1\165\1\164\1"+
        "\44\1\163\2\uffff\1\44\2\145\1\164\2\44\1\uffff\1\44\1\uffff\1\44"+
        "\1\uffff\1\44\1\145\1\44\1\uffff\1\44\1\uffff\2\44\1\145\5\uffff"+
        "\1\44\4\uffff\1\144\1\uffff\1\44\1\uffff";
    static final String DFA28_maxS =
        "\1\ufaff\2\75\1\uffff\1\162\1\157\2\uffff\1\75\1\157\1\75\1\71\1"+
        "\170\1\157\1\75\1\156\1\75\2\uffff\2\75\1\174\1\157\1\uffff\1\75"+
        "\1\165\1\uffff\1\165\3\uffff\1\145\2\uffff\1\167\1\75\1\162\1\157"+
        "\1\150\1\75\1\170\1\146\11\uffff\1\157\1\145\1\163\1\141\1\156\3"+
        "\uffff\1\146\1\ufaff\7\uffff\1\163\1\164\1\154\1\156\1\162\2\uffff"+
        "\1\ufaff\1\160\1\164\12\uffff\1\156\2\uffff\1\167\1\154\1\143\1"+
        "\157\1\142\1\164\1\157\1\141\1\160\1\151\2\uffff\1\151\1\165\2\151"+
        "\4\uffff\2\146\1\154\1\141\1\145\1\163\1\164\1\141\1\142\1\uffff"+
        "\2\145\1\163\1\141\1\ufaff\1\uffff\1\157\1\ufaff\1\147\1\ufaff\1"+
        "\154\1\153\1\166\1\164\1\154\1\165\1\162\1\164\1\145\1\164\1\163"+
        "\1\145\1\144\1\154\1\uffff\1\145\1\153\1\ufaff\1\163\1\151\1\165"+
        "\1\154\1\ufaff\1\156\1\145\1\154\1\uffff\1\162\1\uffff\1\ufaff\1"+
        "\uffff\1\ufaff\2\141\1\145\1\151\1\162\1\164\1\151\1\162\1\143\3"+
        "\ufaff\1\145\1\141\1\ufaff\1\uffff\1\ufaff\1\156\1\154\1\145\1\uffff"+
        "\1\144\2\ufaff\1\164\2\uffff\1\147\1\164\2\143\1\156\1\ufaff\1\143"+
        "\1\ufaff\1\150\3\uffff\1\ufaff\1\156\2\uffff\1\165\1\164\1\ufaff"+
        "\1\163\2\uffff\1\ufaff\2\145\1\164\2\ufaff\1\uffff\1\ufaff\1\uffff"+
        "\1\ufaff\1\uffff\1\ufaff\1\145\1\ufaff\1\uffff\1\ufaff\1\uffff\2"+
        "\ufaff\1\145\5\uffff\1\ufaff\4\uffff\1\144\1\uffff\1\ufaff\1\uffff";
    static final String DFA28_acceptS =
        "\3\uffff\1\4\2\uffff\1\11\1\12\11\uffff\1\40\1\41\4\uffff\1\50\2"+
        "\uffff\1\56\1\uffff\1\71\1\72\1\73\1\uffff\1\75\1\76\10\uffff\1"+
        "\117\1\120\1\121\1\122\1\2\1\44\1\1\1\25\1\3\5\uffff\1\14\1\52\1"+
        "\51\2\uffff\1\17\1\123\1\124\1\16\1\22\1\21\1\116\5\uffff\1\32\1"+
        "\33\3\uffff\1\36\1\65\1\64\1\42\1\43\1\57\1\45\1\46\1\62\1\61\1"+
        "\uffff\1\54\1\53\12\uffff\1\101\1\100\4\uffff\1\112\1\111\1\113"+
        "\1\114\11\uffff\1\20\5\uffff\1\34\22\uffff\1\115\13\uffff\1\31\1"+
        "\uffff\1\37\1\uffff\1\55\20\uffff\1\7\4\uffff\1\24\4\uffff\1\47"+
        "\1\60\11\uffff\1\105\1\106\1\107\2\uffff\1\6\1\10\4\uffff\1\27\1"+
        "\30\6\uffff\1\77\1\uffff\1\103\1\uffff\1\110\3\uffff\1\23\1\uffff"+
        "\1\35\3\uffff\1\70\1\74\1\102\1\104\1\5\1\uffff\1\15\1\26\1\63\1"+
        "\66\1\uffff\1\13\1\uffff\1\67";
    static final String DFA28_specialS =
        "\u00f6\uffff}>";
    static final String[] DFA28_transitionS = {
            "\2\55\1\uffff\2\55\22\uffff\1\55\1\24\1\53\1\uffff\1\54\1\30"+
            "\1\1\1\52\1\27\1\40\1\43\1\20\1\7\1\10\1\13\1\12\1\50\11\51"+
            "\1\6\1\41\1\23\1\2\1\16\1\34\1\3\32\54\1\21\1\uffff\1\35\1\47"+
            "\1\54\1\uffff\1\54\1\4\1\5\1\11\1\14\1\15\2\54\1\17\2\54\1\26"+
            "\1\54\1\31\1\54\1\33\1\54\1\37\1\42\1\44\1\54\1\45\1\46\3\54"+
            "\1\22\1\25\1\36\1\32\101\uffff\27\54\1\uffff\37\54\1\uffff\u1f08"+
            "\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e"+
            "\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\57\26\uffff\1\56",
            "\1\61",
            "",
            "\1\63\2\uffff\1\64",
            "\1\65\12\uffff\1\66\2\uffff\1\67",
            "",
            "",
            "\1\70\17\uffff\1\71",
            "\1\73\11\uffff\1\74",
            "\1\76\4\uffff\1\77\15\uffff\1\75",
            "\1\101\5\uffff\12\103",
            "\1\104\13\uffff\1\105",
            "\1\106\7\uffff\1\107\5\uffff\1\110",
            "\1\111",
            "\1\113\6\uffff\1\114\1\115",
            "\1\116\21\uffff\1\117",
            "",
            "",
            "\1\121",
            "\1\123",
            "\1\126\76\uffff\1\125",
            "\1\130",
            "",
            "\1\131",
            "\1\133\17\uffff\1\134",
            "",
            "\1\135\20\uffff\1\136\2\uffff\1\137",
            "",
            "",
            "",
            "\1\140",
            "",
            "",
            "\1\141\13\uffff\1\142\1\143\1\uffff\1\144",
            "\1\145",
            "\1\147\11\uffff\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\103\1\uffff\10\157\2\103\12\uffff\3\103\21\uffff\1\155\13"+
            "\uffff\3\103\21\uffff\1\155",
            "\1\103\1\uffff\12\160\12\uffff\3\103\35\uffff\3\103",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "",
            "",
            "",
            "\1\166",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\24"+
            "\54\1\167\5\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54"+
            "\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e"+
            "\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\177",
            "\1\u0080",
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
            "\1\u0081",
            "",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085\5\uffff\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "",
            "",
            "",
            "",
            "\1\103\1\uffff\10\157\2\103\12\uffff\3\103\35\uffff\3\103",
            "\1\103\1\uffff\12\160\12\uffff\3\103\35\uffff\3\103",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u009e",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00a0",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "",
            "\1\u00bb",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00ca",
            "\1\u00cb",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "",
            "\1\u00d1",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00d4",
            "",
            "",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00db",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00dd",
            "",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00df",
            "",
            "",
            "\1\u00e0",
            "\1\u00e1",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00e3",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00ed",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00f2",
            "",
            "",
            "",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "",
            "",
            "",
            "\1\u00f4",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( AND | AND_ASSIGN | ASSIGN | AT | BOOLEAN | BREAK | CASE | CLASS | COLON | COMMA | CONTINUE | DEC | DEFAULT | DIV | DIV_ASSIGN | DO | DOT | DOTSTAR | DOUBLE | ELSE | EQUAL | EXTENDS | FALSE | FINAL | FOR | GREATER_OR_EQUAL | GREATER_THAN | IF | IMPORT | INC | INT | LBRACK | LCURLY | LESS_OR_EQUAL | LESS_THAN | LOGICAL_AND | LOGICAL_NOT | LOGICAL_OR | LONG | LPAREN | MINUS | MINUS_ASSIGN | MOD | MOD_ASSIGN | NEW | NOT | NOT_EQUAL | NULL | OR | OR_ASSIGN | PACKAGE | PLUS | PLUS_ASSIGN | PRIVATE | PROTECTED | PUBLIC | QUESTION | RBRACK | RCURLY | RETURN | RPAREN | SEMI | SHORT | STAR | STAR_ASSIGN | STATIC | SUPER | SWITCH | THIS | TRUE | VOID | WHILE | XOR | XOR_ASSIGN | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | FLOATING_POINT_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | IDENT | WS | COMMENT | LINE_COMMENT );";
        }
    }
 

}