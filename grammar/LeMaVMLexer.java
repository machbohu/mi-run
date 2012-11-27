// $ANTLR 3.2 Sep 23, 2009 12:02:23 LeMaVM.g 2012-11-27 18:53:50

package cz.cvut.fit.mirun.lemavm.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class LeMaVMLexer extends Lexer {
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
    public static final int BREAK=54;
    public static final int LOGICAL_AND=26;
    public static final int BIT_SHIFT_RIGHT_ASSIGN=9;
    public static final int UNARY_PLUS=129;
    public static final int TYPE=127;
    public static final int FINAL=64;
    public static final int INC=21;
    public static final int RPAREN=43;
    public static final int IMPORT=68;
    public static final int STRING_LITERAL=140;
    public static final int FOR_UPDATE=108;
    public static final int FLOATING_POINT_LITERAL=138;
    public static final int CAST_EXPR=94;
    public static final int NOT_EQUAL=35;
    public static final int VOID_METHOD_DECL=133;
    public static final int THIS=83;
    public static final int RETURN=77;
    public static final int DOUBLE=60;
    public static final int VOID=86;
    public static final int ENUM_TOP_LEVEL_SCOPE=101;
    public static final int SUPER=81;
    public static final int COMMENT=151;
    public static final int FLOAT_TYPE_SUFFIX=144;
    public static final int JAVA_ID_START=148;
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
    public static final int CONSTRUCTOR_DECL=100;
    public static final int ESCAPE_SEQUENCE=145;
    public static final int LABELED_STATEMENT=112;
    public static final int UNICODE_ESCAPE=146;
    public static final int BOOLEAN=53;
    public static final int EXPR=102;
    public static final int CLASS_TOP_LEVEL_SCOPE=99;
    public static final int CONTINUE=57;
    public static final int COMMA=11;
    public static final int XOR_ASSIGN=52;
    public static final int EQUAL=18;
    public static final int LOGICAL_OR=28;
    public static final int ARGUMENT_LIST=88;
    public static final int QUALIFIED_TYPE_IDENT=122;
    public static final int IDENT=134;
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
    public static final int ARRAY_DECLARATOR_LIST=90;
    public static final int LESS_OR_EQUAL=24;
    public static final int CLASS_STATIC_INITIALIZER=98;
    public static final int DEFAULT=58;
    public static final int OCTAL_LITERAL=136;
    public static final int HEX_DIGIT=141;
    public static final int SHORT=78;
    public static final int INSTANCEOF=67;
    public static final int MINUS=30;
    public static final int TRUE=84;
    public static final int SEMI=44;
    public static final int EXTENDS_CLAUSE=104;
    public static final int STAR_ASSIGN=50;
    public static final int VAR_DECLARATOR_LIST=132;
    public static final int ARRAY_DECLARATOR=89;
    public static final int COLON=10;
    public static final int OR_ASSIGN=37;
    public static final int QUESTION=40;
    public static final int RCURLY=42;
    public static final int ASSIGN=6;
    public static final int PLUS_ASSIGN=39;
    public static final int FUNCTION_METHOD_DECL=111;
    public static final int DIV=13;
    public static final int POST_INC=119;
    public static final int LONG=70;
    public static final int CLASS_CONSTRUCTOR_CALL=96;
    public static final int PUBLIC=76;
    public static final int EXTENDS=62;
    public static final int FOR_EACH=106;
    public static final int ARRAY_INITIALIZER=92;
    public static final int CATCH_CLAUSE_LIST=95;
    public static final int STRING=80;
    public static final int SUPER_CONSTRUCTOR_CALL=124;

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

    public LeMaVMLexer() {;} 
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
            // LeMaVM.g:19:5: ( '&' )
            // LeMaVM.g:19:7: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "AND_ASSIGN"
    public final void mAND_ASSIGN() throws RecognitionException {
        try {
            int _type = AND_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:20:12: ( '&=' )
            // LeMaVM.g:20:14: '&='
            {
            match("&="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND_ASSIGN"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:21:8: ( '=' )
            // LeMaVM.g:21:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:22:4: ( '@' )
            // LeMaVM.g:22:6: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AT"

    // $ANTLR start "BIT_SHIFT_RIGHT"
    public final void mBIT_SHIFT_RIGHT() throws RecognitionException {
        try {
            int _type = BIT_SHIFT_RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:23:17: ( '>>>' )
            // LeMaVM.g:23:19: '>>>'
            {
            match(">>>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BIT_SHIFT_RIGHT"

    // $ANTLR start "BIT_SHIFT_RIGHT_ASSIGN"
    public final void mBIT_SHIFT_RIGHT_ASSIGN() throws RecognitionException {
        try {
            int _type = BIT_SHIFT_RIGHT_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:24:24: ( '>>>=' )
            // LeMaVM.g:24:26: '>>>='
            {
            match(">>>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BIT_SHIFT_RIGHT_ASSIGN"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:25:7: ( ':' )
            // LeMaVM.g:25:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:26:7: ( ',' )
            // LeMaVM.g:26:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "DEC"
    public final void mDEC() throws RecognitionException {
        try {
            int _type = DEC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:27:5: ( '--' )
            // LeMaVM.g:27:7: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEC"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:28:5: ( '/' )
            // LeMaVM.g:28:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "DIV_ASSIGN"
    public final void mDIV_ASSIGN() throws RecognitionException {
        try {
            int _type = DIV_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:29:12: ( '/=' )
            // LeMaVM.g:29:14: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV_ASSIGN"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:30:5: ( '.' )
            // LeMaVM.g:30:7: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "DOTSTAR"
    public final void mDOTSTAR() throws RecognitionException {
        try {
            int _type = DOTSTAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:31:9: ( '.*' )
            // LeMaVM.g:31:11: '.*'
            {
            match(".*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOTSTAR"

    // $ANTLR start "ELLIPSIS"
    public final void mELLIPSIS() throws RecognitionException {
        try {
            int _type = ELLIPSIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:32:10: ( '...' )
            // LeMaVM.g:32:12: '...'
            {
            match("..."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELLIPSIS"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:33:7: ( '==' )
            // LeMaVM.g:33:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "GREATER_OR_EQUAL"
    public final void mGREATER_OR_EQUAL() throws RecognitionException {
        try {
            int _type = GREATER_OR_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:34:18: ( '>=' )
            // LeMaVM.g:34:20: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER_OR_EQUAL"

    // $ANTLR start "GREATER_THAN"
    public final void mGREATER_THAN() throws RecognitionException {
        try {
            int _type = GREATER_THAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:35:14: ( '>' )
            // LeMaVM.g:35:16: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER_THAN"

    // $ANTLR start "INC"
    public final void mINC() throws RecognitionException {
        try {
            int _type = INC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:36:5: ( '++' )
            // LeMaVM.g:36:7: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INC"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:37:8: ( '[' )
            // LeMaVM.g:37:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:38:8: ( '{' )
            // LeMaVM.g:38:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "LESS_OR_EQUAL"
    public final void mLESS_OR_EQUAL() throws RecognitionException {
        try {
            int _type = LESS_OR_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:39:15: ( '<=' )
            // LeMaVM.g:39:17: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS_OR_EQUAL"

    // $ANTLR start "LESS_THAN"
    public final void mLESS_THAN() throws RecognitionException {
        try {
            int _type = LESS_THAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:40:11: ( '<' )
            // LeMaVM.g:40:13: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS_THAN"

    // $ANTLR start "LOGICAL_AND"
    public final void mLOGICAL_AND() throws RecognitionException {
        try {
            int _type = LOGICAL_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:41:13: ( '&&' )
            // LeMaVM.g:41:15: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOGICAL_AND"

    // $ANTLR start "LOGICAL_NOT"
    public final void mLOGICAL_NOT() throws RecognitionException {
        try {
            int _type = LOGICAL_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:42:13: ( '!' )
            // LeMaVM.g:42:15: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOGICAL_NOT"

    // $ANTLR start "LOGICAL_OR"
    public final void mLOGICAL_OR() throws RecognitionException {
        try {
            int _type = LOGICAL_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:43:12: ( '||' )
            // LeMaVM.g:43:14: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOGICAL_OR"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:44:8: ( '(' )
            // LeMaVM.g:44:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:45:7: ( '-' )
            // LeMaVM.g:45:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MINUS_ASSIGN"
    public final void mMINUS_ASSIGN() throws RecognitionException {
        try {
            int _type = MINUS_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:46:14: ( '-=' )
            // LeMaVM.g:46:16: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS_ASSIGN"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:47:5: ( '%' )
            // LeMaVM.g:47:7: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "MOD_ASSIGN"
    public final void mMOD_ASSIGN() throws RecognitionException {
        try {
            int _type = MOD_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:48:12: ( '%=' )
            // LeMaVM.g:48:14: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD_ASSIGN"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:49:5: ( '~' )
            // LeMaVM.g:49:7: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "NOT_EQUAL"
    public final void mNOT_EQUAL() throws RecognitionException {
        try {
            int _type = NOT_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:50:11: ( '!=' )
            // LeMaVM.g:50:13: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT_EQUAL"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:51:4: ( '|' )
            // LeMaVM.g:51:6: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "OR_ASSIGN"
    public final void mOR_ASSIGN() throws RecognitionException {
        try {
            int _type = OR_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:52:11: ( '|=' )
            // LeMaVM.g:52:13: '|='
            {
            match("|="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR_ASSIGN"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:53:6: ( '+' )
            // LeMaVM.g:53:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "PLUS_ASSIGN"
    public final void mPLUS_ASSIGN() throws RecognitionException {
        try {
            int _type = PLUS_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:54:13: ( '+=' )
            // LeMaVM.g:54:15: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS_ASSIGN"

    // $ANTLR start "QUESTION"
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:55:10: ( '?' )
            // LeMaVM.g:55:12: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUESTION"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:56:8: ( ']' )
            // LeMaVM.g:56:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:57:8: ( '}' )
            // LeMaVM.g:57:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:58:8: ( ')' )
            // LeMaVM.g:58:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:59:6: ( ';' )
            // LeMaVM.g:59:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "SHIFT_LEFT"
    public final void mSHIFT_LEFT() throws RecognitionException {
        try {
            int _type = SHIFT_LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:60:12: ( '<<' )
            // LeMaVM.g:60:14: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHIFT_LEFT"

    // $ANTLR start "SHIFT_LEFT_ASSIGN"
    public final void mSHIFT_LEFT_ASSIGN() throws RecognitionException {
        try {
            int _type = SHIFT_LEFT_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:61:19: ( '<<=' )
            // LeMaVM.g:61:21: '<<='
            {
            match("<<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHIFT_LEFT_ASSIGN"

    // $ANTLR start "SHIFT_RIGHT"
    public final void mSHIFT_RIGHT() throws RecognitionException {
        try {
            int _type = SHIFT_RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:62:13: ( '>>' )
            // LeMaVM.g:62:15: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHIFT_RIGHT"

    // $ANTLR start "SHIFT_RIGHT_ASSIGN"
    public final void mSHIFT_RIGHT_ASSIGN() throws RecognitionException {
        try {
            int _type = SHIFT_RIGHT_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:63:20: ( '>>=' )
            // LeMaVM.g:63:22: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHIFT_RIGHT_ASSIGN"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:64:6: ( '*' )
            // LeMaVM.g:64:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "STAR_ASSIGN"
    public final void mSTAR_ASSIGN() throws RecognitionException {
        try {
            int _type = STAR_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:65:13: ( '*=' )
            // LeMaVM.g:65:15: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR_ASSIGN"

    // $ANTLR start "XOR"
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:66:5: ( '^' )
            // LeMaVM.g:66:7: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "XOR"

    // $ANTLR start "XOR_ASSIGN"
    public final void mXOR_ASSIGN() throws RecognitionException {
        try {
            int _type = XOR_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:67:12: ( '^=' )
            // LeMaVM.g:67:14: '^='
            {
            match("^="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "XOR_ASSIGN"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:68:9: ( 'boolean' )
            // LeMaVM.g:68:11: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "BREAK"
    public final void mBREAK() throws RecognitionException {
        try {
            int _type = BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:69:7: ( 'break' )
            // LeMaVM.g:69:9: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BREAK"

    // $ANTLR start "CASE"
    public final void mCASE() throws RecognitionException {
        try {
            int _type = CASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:70:6: ( 'case' )
            // LeMaVM.g:70:8: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CASE"

    // $ANTLR start "CLASS"
    public final void mCLASS() throws RecognitionException {
        try {
            int _type = CLASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:71:7: ( 'class' )
            // LeMaVM.g:71:9: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLASS"

    // $ANTLR start "CONTINUE"
    public final void mCONTINUE() throws RecognitionException {
        try {
            int _type = CONTINUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:72:10: ( 'continue' )
            // LeMaVM.g:72:12: 'continue'
            {
            match("continue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONTINUE"

    // $ANTLR start "DEFAULT"
    public final void mDEFAULT() throws RecognitionException {
        try {
            int _type = DEFAULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:73:9: ( 'default' )
            // LeMaVM.g:73:11: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEFAULT"

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:74:4: ( 'do' )
            // LeMaVM.g:74:6: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:75:8: ( 'double' )
            // LeMaVM.g:75:10: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:76:6: ( 'else' )
            // LeMaVM.g:76:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "EXTENDS"
    public final void mEXTENDS() throws RecognitionException {
        try {
            int _type = EXTENDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:77:9: ( 'extends' )
            // LeMaVM.g:77:11: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTENDS"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:78:7: ( 'false' )
            // LeMaVM.g:78:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "FINAL"
    public final void mFINAL() throws RecognitionException {
        try {
            int _type = FINAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:79:7: ( 'final' )
            // LeMaVM.g:79:9: 'final'
            {
            match("final"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FINAL"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:80:5: ( 'for' )
            // LeMaVM.g:80:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:81:4: ( 'if' )
            // LeMaVM.g:81:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "INSTANCEOF"
    public final void mINSTANCEOF() throws RecognitionException {
        try {
            int _type = INSTANCEOF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:82:12: ( 'instanceof' )
            // LeMaVM.g:82:14: 'instanceof'
            {
            match("instanceof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INSTANCEOF"

    // $ANTLR start "IMPORT"
    public final void mIMPORT() throws RecognitionException {
        try {
            int _type = IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:83:8: ( 'import' )
            // LeMaVM.g:83:10: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPORT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:84:5: ( 'int' )
            // LeMaVM.g:84:7: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "LONG"
    public final void mLONG() throws RecognitionException {
        try {
            int _type = LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:85:6: ( 'long' )
            // LeMaVM.g:85:8: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LONG"

    // $ANTLR start "NEW"
    public final void mNEW() throws RecognitionException {
        try {
            int _type = NEW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:86:5: ( 'new' )
            // LeMaVM.g:86:7: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEW"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:87:6: ( 'null' )
            // LeMaVM.g:87:8: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "PACKAGE"
    public final void mPACKAGE() throws RecognitionException {
        try {
            int _type = PACKAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:88:9: ( 'package' )
            // LeMaVM.g:88:11: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PACKAGE"

    // $ANTLR start "PRIVATE"
    public final void mPRIVATE() throws RecognitionException {
        try {
            int _type = PRIVATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:89:9: ( 'private' )
            // LeMaVM.g:89:11: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRIVATE"

    // $ANTLR start "PROTECTED"
    public final void mPROTECTED() throws RecognitionException {
        try {
            int _type = PROTECTED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:90:11: ( 'protected' )
            // LeMaVM.g:90:13: 'protected'
            {
            match("protected"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROTECTED"

    // $ANTLR start "PUBLIC"
    public final void mPUBLIC() throws RecognitionException {
        try {
            int _type = PUBLIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:91:8: ( 'public' )
            // LeMaVM.g:91:10: 'public'
            {
            match("public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PUBLIC"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:92:8: ( 'return' )
            // LeMaVM.g:92:10: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RETURN"

    // $ANTLR start "SHORT"
    public final void mSHORT() throws RecognitionException {
        try {
            int _type = SHORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:93:7: ( 'short' )
            // LeMaVM.g:93:9: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SHORT"

    // $ANTLR start "STATIC"
    public final void mSTATIC() throws RecognitionException {
        try {
            int _type = STATIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:94:8: ( 'static' )
            // LeMaVM.g:94:10: 'static'
            {
            match("static"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STATIC"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:95:8: ( 'string' )
            // LeMaVM.g:95:10: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "SUPER"
    public final void mSUPER() throws RecognitionException {
        try {
            int _type = SUPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:96:7: ( 'super' )
            // LeMaVM.g:96:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUPER"

    // $ANTLR start "SWITCH"
    public final void mSWITCH() throws RecognitionException {
        try {
            int _type = SWITCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:97:8: ( 'switch' )
            // LeMaVM.g:97:10: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SWITCH"

    // $ANTLR start "THIS"
    public final void mTHIS() throws RecognitionException {
        try {
            int _type = THIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:98:6: ( 'this' )
            // LeMaVM.g:98:8: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THIS"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:99:6: ( 'true' )
            // LeMaVM.g:99:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "TRY"
    public final void mTRY() throws RecognitionException {
        try {
            int _type = TRY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:100:5: ( 'try' )
            // LeMaVM.g:100:7: 'try'
            {
            match("try"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRY"

    // $ANTLR start "VOID"
    public final void mVOID() throws RecognitionException {
        try {
            int _type = VOID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:101:6: ( 'void' )
            // LeMaVM.g:101:8: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VOID"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:102:7: ( 'while' )
            // LeMaVM.g:102:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "HEX_LITERAL"
    public final void mHEX_LITERAL() throws RecognitionException {
        try {
            int _type = HEX_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:814:13: ( '0' ( 'x' | 'X' ) ( HEX_DIGIT )+ ( INTEGER_TYPE_SUFFIX )? )
            // LeMaVM.g:814:15: '0' ( 'x' | 'X' ) ( HEX_DIGIT )+ ( INTEGER_TYPE_SUFFIX )?
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // LeMaVM.g:814:29: ( HEX_DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='F')||(LA1_0>='a' && LA1_0<='f')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // LeMaVM.g:814:29: HEX_DIGIT
            	    {
            	    mHEX_DIGIT(); 

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

            // LeMaVM.g:814:40: ( INTEGER_TYPE_SUFFIX )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='L'||LA2_0=='l') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // LeMaVM.g:814:40: INTEGER_TYPE_SUFFIX
                    {
                    mINTEGER_TYPE_SUFFIX(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HEX_LITERAL"

    // $ANTLR start "DECIMAL_LITERAL"
    public final void mDECIMAL_LITERAL() throws RecognitionException {
        try {
            int _type = DECIMAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:816:17: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( INTEGER_TYPE_SUFFIX )? )
            // LeMaVM.g:816:19: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( INTEGER_TYPE_SUFFIX )?
            {
            // LeMaVM.g:816:19: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='0') ) {
                alt4=1;
            }
            else if ( ((LA4_0>='1' && LA4_0<='9')) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // LeMaVM.g:816:20: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // LeMaVM.g:816:26: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // LeMaVM.g:816:35: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // LeMaVM.g:816:35: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // LeMaVM.g:816:46: ( INTEGER_TYPE_SUFFIX )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='L'||LA5_0=='l') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // LeMaVM.g:816:46: INTEGER_TYPE_SUFFIX
                    {
                    mINTEGER_TYPE_SUFFIX(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECIMAL_LITERAL"

    // $ANTLR start "OCTAL_LITERAL"
    public final void mOCTAL_LITERAL() throws RecognitionException {
        try {
            int _type = OCTAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:818:15: ( '0' ( '0' .. '7' )+ ( INTEGER_TYPE_SUFFIX )? )
            // LeMaVM.g:818:17: '0' ( '0' .. '7' )+ ( INTEGER_TYPE_SUFFIX )?
            {
            match('0'); 
            // LeMaVM.g:818:21: ( '0' .. '7' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='7')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // LeMaVM.g:818:22: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

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

            // LeMaVM.g:818:33: ( INTEGER_TYPE_SUFFIX )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='L'||LA7_0=='l') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // LeMaVM.g:818:33: INTEGER_TYPE_SUFFIX
                    {
                    mINTEGER_TYPE_SUFFIX(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OCTAL_LITERAL"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // LeMaVM.g:821:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // LeMaVM.g:821:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "INTEGER_TYPE_SUFFIX"
    public final void mINTEGER_TYPE_SUFFIX() throws RecognitionException {
        try {
            // LeMaVM.g:824:21: ( ( 'l' | 'L' ) )
            // LeMaVM.g:824:23: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "INTEGER_TYPE_SUFFIX"

    // $ANTLR start "FLOATING_POINT_LITERAL"
    public final void mFLOATING_POINT_LITERAL() throws RecognitionException {
        try {
            int _type = FLOATING_POINT_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:827:5: ( ( '0' .. '9' )+ ( DOT ( '0' .. '9' )* ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )? | EXPONENT ( FLOAT_TYPE_SUFFIX )? | FLOAT_TYPE_SUFFIX ) | DOT ( '0' .. '9' )+ ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>='0' && LA17_0<='9')) ) {
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
                    // LeMaVM.g:827:9: ( '0' .. '9' )+ ( DOT ( '0' .. '9' )* ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )? | EXPONENT ( FLOAT_TYPE_SUFFIX )? | FLOAT_TYPE_SUFFIX )
                    {
                    // LeMaVM.g:827:9: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // LeMaVM.g:827:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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

                    // LeMaVM.g:828:9: ( DOT ( '0' .. '9' )* ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )? | EXPONENT ( FLOAT_TYPE_SUFFIX )? | FLOAT_TYPE_SUFFIX )
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
                    case 'd':
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
                            // LeMaVM.g:829:13: DOT ( '0' .. '9' )* ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )?
                            {
                            mDOT(); 
                            // LeMaVM.g:829:17: ( '0' .. '9' )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // LeMaVM.g:829:18: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop9;
                                }
                            } while (true);

                            // LeMaVM.g:829:29: ( EXPONENT )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0=='E'||LA10_0=='e') ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // LeMaVM.g:829:29: EXPONENT
                                    {
                                    mEXPONENT(); 

                                    }
                                    break;

                            }

                            // LeMaVM.g:829:39: ( FLOAT_TYPE_SUFFIX )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0=='D'||LA11_0=='d') ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // LeMaVM.g:829:39: FLOAT_TYPE_SUFFIX
                                    {
                                    mFLOAT_TYPE_SUFFIX(); 

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // LeMaVM.g:830:13: EXPONENT ( FLOAT_TYPE_SUFFIX )?
                            {
                            mEXPONENT(); 
                            // LeMaVM.g:830:22: ( FLOAT_TYPE_SUFFIX )?
                            int alt12=2;
                            int LA12_0 = input.LA(1);

                            if ( (LA12_0=='D'||LA12_0=='d') ) {
                                alt12=1;
                            }
                            switch (alt12) {
                                case 1 :
                                    // LeMaVM.g:830:22: FLOAT_TYPE_SUFFIX
                                    {
                                    mFLOAT_TYPE_SUFFIX(); 

                                    }
                                    break;

                            }


                            }
                            break;
                        case 3 :
                            // LeMaVM.g:831:13: FLOAT_TYPE_SUFFIX
                            {
                            mFLOAT_TYPE_SUFFIX(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // LeMaVM.g:833:9: DOT ( '0' .. '9' )+ ( EXPONENT )? ( FLOAT_TYPE_SUFFIX )?
                    {
                    mDOT(); 
                    // LeMaVM.g:833:13: ( '0' .. '9' )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // LeMaVM.g:833:14: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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

                    // LeMaVM.g:833:25: ( EXPONENT )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='E'||LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // LeMaVM.g:833:25: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }

                    // LeMaVM.g:833:35: ( FLOAT_TYPE_SUFFIX )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='D'||LA16_0=='d') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // LeMaVM.g:833:35: FLOAT_TYPE_SUFFIX
                            {
                            mFLOAT_TYPE_SUFFIX(); 

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
        }
    }
    // $ANTLR end "FLOATING_POINT_LITERAL"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // LeMaVM.g:837:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // LeMaVM.g:837:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // LeMaVM.g:837:22: ( '+' | '-' )?
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
                        throw mse;}


                    }
                    break;

            }

            // LeMaVM.g:837:33: ( '0' .. '9' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // LeMaVM.g:837:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "FLOAT_TYPE_SUFFIX"
    public final void mFLOAT_TYPE_SUFFIX() throws RecognitionException {
        try {
            // LeMaVM.g:840:19: ( ( 'd' | 'D' ) )
            // LeMaVM.g:840:21: ( 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "FLOAT_TYPE_SUFFIX"

    // $ANTLR start "CHARACTER_LITERAL"
    public final void mCHARACTER_LITERAL() throws RecognitionException {
        try {
            int _type = CHARACTER_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:843:5: ( '\\'' ( ESCAPE_SEQUENCE | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // LeMaVM.g:843:9: '\\'' ( ESCAPE_SEQUENCE | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // LeMaVM.g:843:14: ( ESCAPE_SEQUENCE | ~ ( '\\'' | '\\\\' ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\\') ) {
                alt20=1;
            }
            else if ( ((LA20_0>='\u0000' && LA20_0<='&')||(LA20_0>='(' && LA20_0<='[')||(LA20_0>=']' && LA20_0<='\uFFFF')) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // LeMaVM.g:843:16: ESCAPE_SEQUENCE
                    {
                    mESCAPE_SEQUENCE(); 

                    }
                    break;
                case 2 :
                    // LeMaVM.g:843:34: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHARACTER_LITERAL"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:847:5: ( '\"' ( ESCAPE_SEQUENCE | ~ ( '\\\\' | '\"' ) )* '\"' )
            // LeMaVM.g:847:8: '\"' ( ESCAPE_SEQUENCE | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // LeMaVM.g:847:12: ( ESCAPE_SEQUENCE | ~ ( '\\\\' | '\"' ) )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\\') ) {
                    alt21=1;
                }
                else if ( ((LA21_0>='\u0000' && LA21_0<='!')||(LA21_0>='#' && LA21_0<='[')||(LA21_0>=']' && LA21_0<='\uFFFF')) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // LeMaVM.g:847:14: ESCAPE_SEQUENCE
            	    {
            	    mESCAPE_SEQUENCE(); 

            	    }
            	    break;
            	case 2 :
            	    // LeMaVM.g:847:32: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "ESCAPE_SEQUENCE"
    public final void mESCAPE_SEQUENCE() throws RecognitionException {
        try {
            // LeMaVM.g:852:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESCAPE | OCTAL_ESCAPE )
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
                    // LeMaVM.g:852:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // LeMaVM.g:853:9: UNICODE_ESCAPE
                    {
                    mUNICODE_ESCAPE(); 

                    }
                    break;
                case 3 :
                    // LeMaVM.g:854:9: OCTAL_ESCAPE
                    {
                    mOCTAL_ESCAPE(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESCAPE_SEQUENCE"

    // $ANTLR start "OCTAL_ESCAPE"
    public final void mOCTAL_ESCAPE() throws RecognitionException {
        try {
            // LeMaVM.g:859:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='\\') ) {
                int LA23_1 = input.LA(2);

                if ( ((LA23_1>='0' && LA23_1<='3')) ) {
                    int LA23_2 = input.LA(3);

                    if ( ((LA23_2>='0' && LA23_2<='7')) ) {
                        int LA23_4 = input.LA(4);

                        if ( ((LA23_4>='0' && LA23_4<='7')) ) {
                            alt23=1;
                        }
                        else {
                            alt23=2;}
                    }
                    else {
                        alt23=3;}
                }
                else if ( ((LA23_1>='4' && LA23_1<='7')) ) {
                    int LA23_3 = input.LA(3);

                    if ( ((LA23_3>='0' && LA23_3<='7')) ) {
                        alt23=2;
                    }
                    else {
                        alt23=3;}
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
                    // LeMaVM.g:859:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // LeMaVM.g:859:14: ( '0' .. '3' )
                    // LeMaVM.g:859:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // LeMaVM.g:859:25: ( '0' .. '7' )
                    // LeMaVM.g:859:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // LeMaVM.g:859:36: ( '0' .. '7' )
                    // LeMaVM.g:859:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // LeMaVM.g:860:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // LeMaVM.g:860:14: ( '0' .. '7' )
                    // LeMaVM.g:860:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // LeMaVM.g:860:25: ( '0' .. '7' )
                    // LeMaVM.g:860:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // LeMaVM.g:861:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // LeMaVM.g:861:14: ( '0' .. '7' )
                    // LeMaVM.g:861:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OCTAL_ESCAPE"

    // $ANTLR start "UNICODE_ESCAPE"
    public final void mUNICODE_ESCAPE() throws RecognitionException {
        try {
            // LeMaVM.g:866:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // LeMaVM.g:866:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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
        }
    }
    // $ANTLR end "UNICODE_ESCAPE"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:870:5: ( JAVA_ID_START ( JAVA_ID_PART )* )
            // LeMaVM.g:870:9: JAVA_ID_START ( JAVA_ID_PART )*
            {
            mJAVA_ID_START(); 
            // LeMaVM.g:870:23: ( JAVA_ID_PART )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0=='$'||(LA24_0>='0' && LA24_0<='9')||(LA24_0>='A' && LA24_0<='Z')||LA24_0=='_'||(LA24_0>='a' && LA24_0<='z')||(LA24_0>='\u00C0' && LA24_0<='\u00D6')||(LA24_0>='\u00D8' && LA24_0<='\u00F6')||(LA24_0>='\u00F8' && LA24_0<='\u1FFF')||(LA24_0>='\u3040' && LA24_0<='\u318F')||(LA24_0>='\u3300' && LA24_0<='\u337F')||(LA24_0>='\u3400' && LA24_0<='\u3D2D')||(LA24_0>='\u4E00' && LA24_0<='\u9FFF')||(LA24_0>='\uF900' && LA24_0<='\uFAFF')) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // LeMaVM.g:870:24: JAVA_ID_PART
            	    {
            	    mJAVA_ID_PART(); 

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
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "JAVA_ID_START"
    public final void mJAVA_ID_START() throws RecognitionException {
        try {
            // LeMaVM.g:875:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // LeMaVM.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "JAVA_ID_START"

    // $ANTLR start "JAVA_ID_PART"
    public final void mJAVA_ID_PART() throws RecognitionException {
        try {
            // LeMaVM.g:892:5: ( JAVA_ID_START | '\\u0030' .. '\\u0039' )
            // LeMaVM.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "JAVA_ID_PART"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:896:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // LeMaVM.g:896:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

               
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
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:907:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // LeMaVM.g:907:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // LeMaVM.g:907:14: ( options {greedy=false; } : . )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0=='*') ) {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1=='/') ) {
                        alt25=2;
                    }
                    else if ( ((LA25_1>='\u0000' && LA25_1<='.')||(LA25_1>='0' && LA25_1<='\uFFFF')) ) {
                        alt25=1;
                    }


                }
                else if ( ((LA25_0>='\u0000' && LA25_0<=')')||(LA25_0>='+' && LA25_0<='\uFFFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // LeMaVM.g:907:42: .
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
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // LeMaVM.g:918:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // LeMaVM.g:918:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // LeMaVM.g:918:12: (~ ( '\\n' | '\\r' ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>='\u0000' && LA26_0<='\t')||(LA26_0>='\u000B' && LA26_0<='\f')||(LA26_0>='\u000E' && LA26_0<='\uFFFF')) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // LeMaVM.g:918:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // LeMaVM.g:918:26: ( '\\r' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='\r') ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // LeMaVM.g:918:26: '\\r'
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
        }
    }
    // $ANTLR end "LINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // LeMaVM.g:1:8: ( AND | AND_ASSIGN | ASSIGN | AT | BIT_SHIFT_RIGHT | BIT_SHIFT_RIGHT_ASSIGN | COLON | COMMA | DEC | DIV | DIV_ASSIGN | DOT | DOTSTAR | ELLIPSIS | EQUAL | GREATER_OR_EQUAL | GREATER_THAN | INC | LBRACK | LCURLY | LESS_OR_EQUAL | LESS_THAN | LOGICAL_AND | LOGICAL_NOT | LOGICAL_OR | LPAREN | MINUS | MINUS_ASSIGN | MOD | MOD_ASSIGN | NOT | NOT_EQUAL | OR | OR_ASSIGN | PLUS | PLUS_ASSIGN | QUESTION | RBRACK | RCURLY | RPAREN | SEMI | SHIFT_LEFT | SHIFT_LEFT_ASSIGN | SHIFT_RIGHT | SHIFT_RIGHT_ASSIGN | STAR | STAR_ASSIGN | XOR | XOR_ASSIGN | BOOLEAN | BREAK | CASE | CLASS | CONTINUE | DEFAULT | DO | DOUBLE | ELSE | EXTENDS | FALSE | FINAL | FOR | IF | INSTANCEOF | IMPORT | INT | LONG | NEW | NULL | PACKAGE | PRIVATE | PROTECTED | PUBLIC | RETURN | SHORT | STATIC | STRING | SUPER | SWITCH | THIS | TRUE | TRY | VOID | WHILE | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | FLOATING_POINT_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | IDENT | WS | COMMENT | LINE_COMMENT )
        int alt28=94;
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
                // LeMaVM.g:1:35: BIT_SHIFT_RIGHT
                {
                mBIT_SHIFT_RIGHT(); 

                }
                break;
            case 6 :
                // LeMaVM.g:1:51: BIT_SHIFT_RIGHT_ASSIGN
                {
                mBIT_SHIFT_RIGHT_ASSIGN(); 

                }
                break;
            case 7 :
                // LeMaVM.g:1:74: COLON
                {
                mCOLON(); 

                }
                break;
            case 8 :
                // LeMaVM.g:1:80: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 9 :
                // LeMaVM.g:1:86: DEC
                {
                mDEC(); 

                }
                break;
            case 10 :
                // LeMaVM.g:1:90: DIV
                {
                mDIV(); 

                }
                break;
            case 11 :
                // LeMaVM.g:1:94: DIV_ASSIGN
                {
                mDIV_ASSIGN(); 

                }
                break;
            case 12 :
                // LeMaVM.g:1:105: DOT
                {
                mDOT(); 

                }
                break;
            case 13 :
                // LeMaVM.g:1:109: DOTSTAR
                {
                mDOTSTAR(); 

                }
                break;
            case 14 :
                // LeMaVM.g:1:117: ELLIPSIS
                {
                mELLIPSIS(); 

                }
                break;
            case 15 :
                // LeMaVM.g:1:126: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 16 :
                // LeMaVM.g:1:132: GREATER_OR_EQUAL
                {
                mGREATER_OR_EQUAL(); 

                }
                break;
            case 17 :
                // LeMaVM.g:1:149: GREATER_THAN
                {
                mGREATER_THAN(); 

                }
                break;
            case 18 :
                // LeMaVM.g:1:162: INC
                {
                mINC(); 

                }
                break;
            case 19 :
                // LeMaVM.g:1:166: LBRACK
                {
                mLBRACK(); 

                }
                break;
            case 20 :
                // LeMaVM.g:1:173: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 21 :
                // LeMaVM.g:1:180: LESS_OR_EQUAL
                {
                mLESS_OR_EQUAL(); 

                }
                break;
            case 22 :
                // LeMaVM.g:1:194: LESS_THAN
                {
                mLESS_THAN(); 

                }
                break;
            case 23 :
                // LeMaVM.g:1:204: LOGICAL_AND
                {
                mLOGICAL_AND(); 

                }
                break;
            case 24 :
                // LeMaVM.g:1:216: LOGICAL_NOT
                {
                mLOGICAL_NOT(); 

                }
                break;
            case 25 :
                // LeMaVM.g:1:228: LOGICAL_OR
                {
                mLOGICAL_OR(); 

                }
                break;
            case 26 :
                // LeMaVM.g:1:239: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 27 :
                // LeMaVM.g:1:246: MINUS
                {
                mMINUS(); 

                }
                break;
            case 28 :
                // LeMaVM.g:1:252: MINUS_ASSIGN
                {
                mMINUS_ASSIGN(); 

                }
                break;
            case 29 :
                // LeMaVM.g:1:265: MOD
                {
                mMOD(); 

                }
                break;
            case 30 :
                // LeMaVM.g:1:269: MOD_ASSIGN
                {
                mMOD_ASSIGN(); 

                }
                break;
            case 31 :
                // LeMaVM.g:1:280: NOT
                {
                mNOT(); 

                }
                break;
            case 32 :
                // LeMaVM.g:1:284: NOT_EQUAL
                {
                mNOT_EQUAL(); 

                }
                break;
            case 33 :
                // LeMaVM.g:1:294: OR
                {
                mOR(); 

                }
                break;
            case 34 :
                // LeMaVM.g:1:297: OR_ASSIGN
                {
                mOR_ASSIGN(); 

                }
                break;
            case 35 :
                // LeMaVM.g:1:307: PLUS
                {
                mPLUS(); 

                }
                break;
            case 36 :
                // LeMaVM.g:1:312: PLUS_ASSIGN
                {
                mPLUS_ASSIGN(); 

                }
                break;
            case 37 :
                // LeMaVM.g:1:324: QUESTION
                {
                mQUESTION(); 

                }
                break;
            case 38 :
                // LeMaVM.g:1:333: RBRACK
                {
                mRBRACK(); 

                }
                break;
            case 39 :
                // LeMaVM.g:1:340: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 40 :
                // LeMaVM.g:1:347: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 41 :
                // LeMaVM.g:1:354: SEMI
                {
                mSEMI(); 

                }
                break;
            case 42 :
                // LeMaVM.g:1:359: SHIFT_LEFT
                {
                mSHIFT_LEFT(); 

                }
                break;
            case 43 :
                // LeMaVM.g:1:370: SHIFT_LEFT_ASSIGN
                {
                mSHIFT_LEFT_ASSIGN(); 

                }
                break;
            case 44 :
                // LeMaVM.g:1:388: SHIFT_RIGHT
                {
                mSHIFT_RIGHT(); 

                }
                break;
            case 45 :
                // LeMaVM.g:1:400: SHIFT_RIGHT_ASSIGN
                {
                mSHIFT_RIGHT_ASSIGN(); 

                }
                break;
            case 46 :
                // LeMaVM.g:1:419: STAR
                {
                mSTAR(); 

                }
                break;
            case 47 :
                // LeMaVM.g:1:424: STAR_ASSIGN
                {
                mSTAR_ASSIGN(); 

                }
                break;
            case 48 :
                // LeMaVM.g:1:436: XOR
                {
                mXOR(); 

                }
                break;
            case 49 :
                // LeMaVM.g:1:440: XOR_ASSIGN
                {
                mXOR_ASSIGN(); 

                }
                break;
            case 50 :
                // LeMaVM.g:1:451: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 51 :
                // LeMaVM.g:1:459: BREAK
                {
                mBREAK(); 

                }
                break;
            case 52 :
                // LeMaVM.g:1:465: CASE
                {
                mCASE(); 

                }
                break;
            case 53 :
                // LeMaVM.g:1:470: CLASS
                {
                mCLASS(); 

                }
                break;
            case 54 :
                // LeMaVM.g:1:476: CONTINUE
                {
                mCONTINUE(); 

                }
                break;
            case 55 :
                // LeMaVM.g:1:485: DEFAULT
                {
                mDEFAULT(); 

                }
                break;
            case 56 :
                // LeMaVM.g:1:493: DO
                {
                mDO(); 

                }
                break;
            case 57 :
                // LeMaVM.g:1:496: DOUBLE
                {
                mDOUBLE(); 

                }
                break;
            case 58 :
                // LeMaVM.g:1:503: ELSE
                {
                mELSE(); 

                }
                break;
            case 59 :
                // LeMaVM.g:1:508: EXTENDS
                {
                mEXTENDS(); 

                }
                break;
            case 60 :
                // LeMaVM.g:1:516: FALSE
                {
                mFALSE(); 

                }
                break;
            case 61 :
                // LeMaVM.g:1:522: FINAL
                {
                mFINAL(); 

                }
                break;
            case 62 :
                // LeMaVM.g:1:528: FOR
                {
                mFOR(); 

                }
                break;
            case 63 :
                // LeMaVM.g:1:532: IF
                {
                mIF(); 

                }
                break;
            case 64 :
                // LeMaVM.g:1:535: INSTANCEOF
                {
                mINSTANCEOF(); 

                }
                break;
            case 65 :
                // LeMaVM.g:1:546: IMPORT
                {
                mIMPORT(); 

                }
                break;
            case 66 :
                // LeMaVM.g:1:553: INT
                {
                mINT(); 

                }
                break;
            case 67 :
                // LeMaVM.g:1:557: LONG
                {
                mLONG(); 

                }
                break;
            case 68 :
                // LeMaVM.g:1:562: NEW
                {
                mNEW(); 

                }
                break;
            case 69 :
                // LeMaVM.g:1:566: NULL
                {
                mNULL(); 

                }
                break;
            case 70 :
                // LeMaVM.g:1:571: PACKAGE
                {
                mPACKAGE(); 

                }
                break;
            case 71 :
                // LeMaVM.g:1:579: PRIVATE
                {
                mPRIVATE(); 

                }
                break;
            case 72 :
                // LeMaVM.g:1:587: PROTECTED
                {
                mPROTECTED(); 

                }
                break;
            case 73 :
                // LeMaVM.g:1:597: PUBLIC
                {
                mPUBLIC(); 

                }
                break;
            case 74 :
                // LeMaVM.g:1:604: RETURN
                {
                mRETURN(); 

                }
                break;
            case 75 :
                // LeMaVM.g:1:611: SHORT
                {
                mSHORT(); 

                }
                break;
            case 76 :
                // LeMaVM.g:1:617: STATIC
                {
                mSTATIC(); 

                }
                break;
            case 77 :
                // LeMaVM.g:1:624: STRING
                {
                mSTRING(); 

                }
                break;
            case 78 :
                // LeMaVM.g:1:631: SUPER
                {
                mSUPER(); 

                }
                break;
            case 79 :
                // LeMaVM.g:1:637: SWITCH
                {
                mSWITCH(); 

                }
                break;
            case 80 :
                // LeMaVM.g:1:644: THIS
                {
                mTHIS(); 

                }
                break;
            case 81 :
                // LeMaVM.g:1:649: TRUE
                {
                mTRUE(); 

                }
                break;
            case 82 :
                // LeMaVM.g:1:654: TRY
                {
                mTRY(); 

                }
                break;
            case 83 :
                // LeMaVM.g:1:658: VOID
                {
                mVOID(); 

                }
                break;
            case 84 :
                // LeMaVM.g:1:663: WHILE
                {
                mWHILE(); 

                }
                break;
            case 85 :
                // LeMaVM.g:1:669: HEX_LITERAL
                {
                mHEX_LITERAL(); 

                }
                break;
            case 86 :
                // LeMaVM.g:1:681: DECIMAL_LITERAL
                {
                mDECIMAL_LITERAL(); 

                }
                break;
            case 87 :
                // LeMaVM.g:1:697: OCTAL_LITERAL
                {
                mOCTAL_LITERAL(); 

                }
                break;
            case 88 :
                // LeMaVM.g:1:711: FLOATING_POINT_LITERAL
                {
                mFLOATING_POINT_LITERAL(); 

                }
                break;
            case 89 :
                // LeMaVM.g:1:734: CHARACTER_LITERAL
                {
                mCHARACTER_LITERAL(); 

                }
                break;
            case 90 :
                // LeMaVM.g:1:752: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 91 :
                // LeMaVM.g:1:767: IDENT
                {
                mIDENT(); 

                }
                break;
            case 92 :
                // LeMaVM.g:1:773: WS
                {
                mWS(); 

                }
                break;
            case 93 :
                // LeMaVM.g:1:776: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 94 :
                // LeMaVM.g:1:784: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA28_eotS =
        "\1\uffff\1\60\1\62\1\uffff\1\65\2\uffff\1\70\1\74\1\77\1\103\2\uffff"+
        "\1\106\1\110\1\113\1\uffff\1\115\6\uffff\1\117\1\121\16\54\2\162"+
        "\11\uffff\1\166\21\uffff\1\170\14\uffff\6\54\1\u0080\5\54\1\u0086"+
        "\21\54\1\uffff\1\u009c\1\uffff\1\162\1\u009e\4\uffff\7\54\1\uffff"+
        "\4\54\1\u00aa\1\uffff\1\54\1\u00ac\2\54\1\u00af\15\54\1\u00bd\2"+
        "\54\3\uffff\2\54\1\u00c2\4\54\1\u00c7\3\54\1\uffff\1\54\1\uffff"+
        "\1\54\1\u00cd\1\uffff\1\u00ce\12\54\1\u00d9\1\u00da\1\uffff\1\u00db"+
        "\2\54\1\u00de\1\uffff\1\u00df\3\54\1\uffff\1\54\1\u00e4\1\u00e5"+
        "\2\54\2\uffff\5\54\1\u00ed\2\54\1\u00f0\1\54\3\uffff\1\u00f2\1\54"+
        "\2\uffff\2\54\1\u00f6\1\54\2\uffff\1\54\1\u00f9\3\54\1\u00fd\1\u00fe"+
        "\1\uffff\1\u00ff\1\u0100\1\uffff\1\u0101\1\uffff\1\u0102\1\54\1"+
        "\u0104\1\uffff\1\u0105\1\54\1\uffff\1\u0107\1\u0108\1\54\6\uffff"+
        "\1\u010a\2\uffff\1\54\2\uffff\1\54\1\uffff\1\54\1\u010e\1\u010f"+
        "\2\uffff";
    static final String DFA28_eofS =
        "\u0110\uffff";
    static final String DFA28_minS =
        "\1\11\1\46\1\75\1\uffff\1\75\2\uffff\1\55\2\52\1\53\2\uffff\1\74"+
        "\2\75\1\uffff\1\75\6\uffff\2\75\1\157\1\141\1\145\1\154\1\141\1"+
        "\146\1\157\1\145\1\141\1\145\2\150\1\157\1\150\2\56\11\uffff\1\75"+
        "\21\uffff\1\75\14\uffff\1\157\1\145\1\163\1\141\1\156\1\146\1\44"+
        "\1\163\1\164\1\154\1\156\1\162\1\44\1\163\1\160\1\156\1\167\1\154"+
        "\1\143\1\151\1\142\1\164\1\157\1\141\1\160\2\151\1\165\2\151\1\uffff"+
        "\1\56\1\uffff\1\56\1\75\4\uffff\1\154\1\141\1\145\1\163\1\164\1"+
        "\141\1\142\1\uffff\2\145\1\163\1\141\1\44\1\uffff\1\164\1\44\1\157"+
        "\1\147\1\44\1\154\1\153\1\166\1\164\1\154\1\165\1\162\1\164\1\151"+
        "\1\145\1\164\1\163\1\145\1\44\1\144\1\154\3\uffff\1\145\1\153\1"+
        "\44\1\163\1\151\1\165\1\154\1\44\1\156\1\145\1\154\1\uffff\1\141"+
        "\1\uffff\1\162\1\44\1\uffff\1\44\2\141\1\145\1\151\1\162\1\164\1"+
        "\151\1\156\1\162\1\143\2\44\1\uffff\1\44\1\145\1\141\1\44\1\uffff"+
        "\1\44\1\156\1\154\1\145\1\uffff\1\144\2\44\1\156\1\164\2\uffff\1"+
        "\147\1\164\2\143\1\156\1\44\1\143\1\147\1\44\1\150\3\uffff\1\44"+
        "\1\156\2\uffff\1\165\1\164\1\44\1\163\2\uffff\1\143\1\44\2\145\1"+
        "\164\2\44\1\uffff\2\44\1\uffff\1\44\1\uffff\1\44\1\145\1\44\1\uffff"+
        "\1\44\1\145\1\uffff\2\44\1\145\6\uffff\1\44\2\uffff\1\157\2\uffff"+
        "\1\144\1\uffff\1\146\2\44\2\uffff";
    static final String DFA28_maxS =
        "\1\ufaff\2\75\1\uffff\1\76\2\uffff\2\75\1\71\1\75\2\uffff\2\75\1"+
        "\174\1\uffff\1\75\6\uffff\2\75\1\162\2\157\1\170\1\157\1\156\1\157"+
        "\2\165\1\145\1\167\1\162\1\157\1\150\1\170\1\145\11\uffff\1\76\21"+
        "\uffff\1\75\14\uffff\1\157\1\145\1\163\1\141\1\156\1\146\1\ufaff"+
        "\1\163\1\164\1\154\1\156\1\162\1\ufaff\1\164\1\160\1\156\1\167\1"+
        "\154\1\143\1\157\1\142\1\164\1\157\1\162\1\160\2\151\1\171\2\151"+
        "\1\uffff\1\145\1\uffff\1\145\1\75\4\uffff\1\154\1\141\1\145\1\163"+
        "\1\164\1\141\1\142\1\uffff\2\145\1\163\1\141\1\ufaff\1\uffff\1\164"+
        "\1\ufaff\1\157\1\147\1\ufaff\1\154\1\153\1\166\1\164\1\154\1\165"+
        "\1\162\1\164\1\151\1\145\1\164\1\163\1\145\1\ufaff\1\144\1\154\3"+
        "\uffff\1\145\1\153\1\ufaff\1\163\1\151\1\165\1\154\1\ufaff\1\156"+
        "\1\145\1\154\1\uffff\1\141\1\uffff\1\162\1\ufaff\1\uffff\1\ufaff"+
        "\2\141\1\145\1\151\1\162\1\164\1\151\1\156\1\162\1\143\2\ufaff\1"+
        "\uffff\1\ufaff\1\145\1\141\1\ufaff\1\uffff\1\ufaff\1\156\1\154\1"+
        "\145\1\uffff\1\144\2\ufaff\1\156\1\164\2\uffff\1\147\1\164\2\143"+
        "\1\156\1\ufaff\1\143\1\147\1\ufaff\1\150\3\uffff\1\ufaff\1\156\2"+
        "\uffff\1\165\1\164\1\ufaff\1\163\2\uffff\1\143\1\ufaff\2\145\1\164"+
        "\2\ufaff\1\uffff\2\ufaff\1\uffff\1\ufaff\1\uffff\1\ufaff\1\145\1"+
        "\ufaff\1\uffff\1\ufaff\1\145\1\uffff\2\ufaff\1\145\6\uffff\1\ufaff"+
        "\2\uffff\1\157\2\uffff\1\144\1\uffff\1\146\2\ufaff\2\uffff";
    static final String DFA28_acceptS =
        "\3\uffff\1\4\1\uffff\1\7\1\10\4\uffff\1\23\1\24\3\uffff\1\32\1\uffff"+
        "\1\37\1\45\1\46\1\47\1\50\1\51\22\uffff\1\131\1\132\1\133\1\134"+
        "\1\2\1\27\1\1\1\17\1\3\1\uffff\1\20\1\21\1\11\1\34\1\33\1\13\1\135"+
        "\1\136\1\12\1\15\1\16\1\14\1\130\1\22\1\44\1\43\1\25\1\uffff\1\26"+
        "\1\40\1\30\1\31\1\42\1\41\1\36\1\35\1\57\1\56\1\61\1\60\36\uffff"+
        "\1\125\1\uffff\1\126\2\uffff\1\55\1\54\1\53\1\52\7\uffff\1\70\5"+
        "\uffff\1\77\25\uffff\1\127\1\6\1\5\13\uffff\1\76\1\uffff\1\102\2"+
        "\uffff\1\104\15\uffff\1\122\4\uffff\1\64\4\uffff\1\72\5\uffff\1"+
        "\103\1\105\12\uffff\1\120\1\121\1\123\2\uffff\1\63\1\65\4\uffff"+
        "\1\74\1\75\7\uffff\1\113\2\uffff\1\116\1\uffff\1\124\3\uffff\1\71"+
        "\2\uffff\1\101\3\uffff\1\111\1\112\1\114\1\115\1\117\1\62\1\uffff"+
        "\1\67\1\73\1\uffff\1\106\1\107\1\uffff\1\66\3\uffff\1\110\1\100";
    static final String DFA28_specialS =
        "\u0110\uffff}>";
    static final String[] DFA28_transitionS = {
            "\2\55\1\uffff\2\55\22\uffff\1\55\1\16\1\53\1\uffff\1\54\1\21"+
            "\1\1\1\52\1\20\1\26\1\30\1\12\1\6\1\7\1\11\1\10\1\50\11\51\1"+
            "\5\1\27\1\15\1\2\1\4\1\23\1\3\32\54\1\13\1\uffff\1\24\1\31\1"+
            "\54\1\uffff\1\54\1\32\1\33\1\34\1\35\1\36\2\54\1\37\2\54\1\40"+
            "\1\54\1\41\1\54\1\42\1\54\1\43\1\44\1\45\1\54\1\46\1\47\3\54"+
            "\1\14\1\17\1\25\1\22\101\uffff\27\54\1\uffff\37\54\1\uffff\u1f08"+
            "\54\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e"+
            "\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\57\26\uffff\1\56",
            "\1\61",
            "",
            "\1\64\1\63",
            "",
            "",
            "\1\66\17\uffff\1\67",
            "\1\72\4\uffff\1\73\15\uffff\1\71",
            "\1\75\3\uffff\1\76\1\uffff\12\100",
            "\1\101\21\uffff\1\102",
            "",
            "",
            "\1\105\1\104",
            "\1\107",
            "\1\112\76\uffff\1\111",
            "",
            "\1\114",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\116",
            "\1\120",
            "\1\122\2\uffff\1\123",
            "\1\124\12\uffff\1\125\2\uffff\1\126",
            "\1\127\11\uffff\1\130",
            "\1\131\13\uffff\1\132",
            "\1\133\7\uffff\1\134\5\uffff\1\135",
            "\1\136\6\uffff\1\140\1\137",
            "\1\141",
            "\1\142\17\uffff\1\143",
            "\1\144\20\uffff\1\145\2\uffff\1\146",
            "\1\147",
            "\1\150\13\uffff\1\151\1\152\1\uffff\1\153",
            "\1\154\11\uffff\1\155",
            "\1\156",
            "\1\157",
            "\1\100\1\uffff\10\161\2\100\12\uffff\2\100\22\uffff\1\160\13"+
            "\uffff\2\100\22\uffff\1\160",
            "\1\100\1\uffff\12\163\12\uffff\2\100\36\uffff\2\100",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\165\1\164",
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
            "\1\167",
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
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\24"+
            "\54\1\177\5\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54"+
            "\u1040\uffff\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e"+
            "\54\u10d2\uffff\u5200\54\u5900\uffff\u0200\54",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0087\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e\5\uffff\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093\20\uffff\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098\3\uffff\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "",
            "\1\100\1\uffff\10\161\2\100\12\uffff\2\100\36\uffff\2\100",
            "",
            "\1\100\1\uffff\12\163\12\uffff\2\100\36\uffff\2\100",
            "\1\u009d",
            "",
            "",
            "",
            "",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\u00ab",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00ad",
            "\1\u00ae",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00be",
            "\1\u00bf",
            "",
            "",
            "",
            "\1\u00c0",
            "\1\u00c1",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "",
            "\1\u00cb",
            "",
            "\1\u00cc",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
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
            "\1\u00dc",
            "\1\u00dd",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00e6",
            "\1\u00e7",
            "",
            "",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00ee",
            "\1\u00ef",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00f1",
            "",
            "",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00f3",
            "",
            "",
            "\1\u00f4",
            "\1\u00f5",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00f7",
            "",
            "",
            "\1\u00f8",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
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
            "\1\u0103",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0106",
            "",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\u0109",
            "",
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
            "\1\u010b",
            "",
            "",
            "\1\u010c",
            "",
            "\1\u010d",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "\1\54\13\uffff\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32"+
            "\54\105\uffff\27\54\1\uffff\37\54\1\uffff\u1f08\54\u1040\uffff"+
            "\u0150\54\u0170\uffff\u0080\54\u0080\uffff\u092e\54\u10d2\uffff"+
            "\u5200\54\u5900\uffff\u0200\54",
            "",
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
            return "1:1: Tokens : ( AND | AND_ASSIGN | ASSIGN | AT | BIT_SHIFT_RIGHT | BIT_SHIFT_RIGHT_ASSIGN | COLON | COMMA | DEC | DIV | DIV_ASSIGN | DOT | DOTSTAR | ELLIPSIS | EQUAL | GREATER_OR_EQUAL | GREATER_THAN | INC | LBRACK | LCURLY | LESS_OR_EQUAL | LESS_THAN | LOGICAL_AND | LOGICAL_NOT | LOGICAL_OR | LPAREN | MINUS | MINUS_ASSIGN | MOD | MOD_ASSIGN | NOT | NOT_EQUAL | OR | OR_ASSIGN | PLUS | PLUS_ASSIGN | QUESTION | RBRACK | RCURLY | RPAREN | SEMI | SHIFT_LEFT | SHIFT_LEFT_ASSIGN | SHIFT_RIGHT | SHIFT_RIGHT_ASSIGN | STAR | STAR_ASSIGN | XOR | XOR_ASSIGN | BOOLEAN | BREAK | CASE | CLASS | CONTINUE | DEFAULT | DO | DOUBLE | ELSE | EXTENDS | FALSE | FINAL | FOR | IF | INSTANCEOF | IMPORT | INT | LONG | NEW | NULL | PACKAGE | PRIVATE | PROTECTED | PUBLIC | RETURN | SHORT | STATIC | STRING | SUPER | SWITCH | THIS | TRUE | TRY | VOID | WHILE | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | FLOATING_POINT_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | IDENT | WS | COMMENT | LINE_COMMENT );";
        }
    }
 

}