// Generated from Lsc.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');
var LscVisitor = require('./LscVisitor').LscVisitor;

var grammarFileName = "Lsc.g4";


var serializedATN = ["\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964",
    "\u0003-\u0265\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t",
    "\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004",
    "\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004\f\t\f\u0004",
    "\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010\t\u0010\u0004",
    "\u0011\t\u0011\u0004\u0012\t\u0012\u0004\u0013\t\u0013\u0004\u0014\t",
    "\u0014\u0004\u0015\t\u0015\u0004\u0016\t\u0016\u0004\u0017\t\u0017\u0004",
    "\u0018\t\u0018\u0004\u0019\t\u0019\u0004\u001a\t\u001a\u0004\u001b\t",
    "\u001b\u0004\u001c\t\u001c\u0004\u001d\t\u001d\u0004\u001e\t\u001e\u0004",
    "\u001f\t\u001f\u0004 \t \u0004!\t!\u0004\"\t\"\u0004#\t#\u0004$\t$\u0004",
    "%\t%\u0004&\t&\u0004\'\t\'\u0004(\t(\u0004)\t)\u0004*\t*\u0004+\t+\u0004",
    ",\t,\u0004-\t-\u0004.\t.\u0004/\t/\u00040\t0\u00041\t1\u00042\t2\u0004",
    "3\t3\u00044\t4\u00045\t5\u00046\t6\u00047\t7\u00048\t8\u00049\t9\u0004",
    ":\t:\u0004;\t;\u0004<\t<\u0004=\t=\u0003\u0002\u0003\u0002\u0007\u0002",
    "}\n\u0002\f\u0002\u000e\u0002\u0080\u000b\u0002\u0003\u0002\u0005\u0002",
    "\u0083\n\u0002\u0003\u0002\u0006\u0002\u0086\n\u0002\r\u0002\u000e\u0002",
    "\u0087\u0003\u0002\u0007\u0002\u008b\n\u0002\f\u0002\u000e\u0002\u008e",
    "\u000b\u0002\u0003\u0002\u0007\u0002\u0091\n\u0002\f\u0002\u000e\u0002",
    "\u0094\u000b\u0002\u0003\u0002\u0005\u0002\u0097\n\u0002\u0003\u0003",
    "\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003",
    "\u0003\u0003\u0003\u0003\u0005\u0003\u00a2\n\u0003\u0003\u0004\u0003",
    "\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003",
    "\u0004\u0007\u0004\u00ac\n\u0004\f\u0004\u000e\u0004\u00af\u000b\u0004",
    "\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005\u0005\u0005\u00b5\n",
    "\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0007",
    "\u0006\u00bc\n\u0006\f\u0006\u000e\u0006\u00bf\u000b\u0006\u0003\u0006",
    "\u0003\u0006\u0005\u0006\u00c3\n\u0006\u0003\u0006\u0003\u0006\u0003",
    "\u0006\u0003\u0006\u0005\u0006\u00c9\n\u0006\u0003\u0006\u0003\u0006",
    "\u0003\u0006\u0007\u0006\u00ce\n\u0006\f\u0006\u000e\u0006\u00d1\u000b",
    "\u0006\u0003\u0006\u0003\u0006\u0005\u0006\u00d5\n\u0006\u0003\u0007",
    "\u0005\u0007\u00d8\n\u0007\u0003\u0007\u0003\u0007\u0003\b\u0003\b\u0003",
    "\b\u0003\t\u0003\t\u0003\t\u0003\t\u0003\t\u0003\t\u0003\t\u0007\t\u00e6",
    "\n\t\f\t\u000e\t\u00e9\u000b\t\u0003\t\u0003\t\u0003\t\u0007\t\u00ee",
    "\n\t\f\t\u000e\t\u00f1\u000b\t\u0003\n\u0003\n\u0003\u000b\u0003\u000b",
    "\u0003\u000b\u0003\u000b\u0003\u000b\u0007\u000b\u00fa\n\u000b\f\u000b",
    "\u000e\u000b\u00fd\u000b\u000b\u0003\u000b\u0003\u000b\u0005\u000b\u0101",
    "\n\u000b\u0003\f\u0003\f\u0003\r\u0003\r\u0003\r\u0006\r\u0108\n\r\r",
    "\r\u000e\r\u0109\u0003\r\u0003\r\u0003\u000e\u0003\u000e\u0003\u000e",
    "\u0005\u000e\u0111\n\u000e\u0003\u000e\u0003\u000e\u0006\u000e\u0115",
    "\n\u000e\r\u000e\u000e\u000e\u0116\u0003\u000e\u0003\u000e\u0003\u000f",
    "\u0003\u000f\u0003\u000f\u0005\u000f\u011e\n\u000f\u0003\u000f\u0003",
    "\u000f\u0006\u000f\u0122\n\u000f\r\u000f\u000e\u000f\u0123\u0003\u000f",
    "\u0003\u000f\u0003\u0010\u0003\u0010\u0003\u0010\u0003\u0010\u0003\u0010",
    "\u0005\u0010\u012d\n\u0010\u0003\u0010\u0003\u0010\u0006\u0010\u0131",
    "\n\u0010\r\u0010\u000e\u0010\u0132\u0003\u0010\u0003\u0010\u0003\u0011",
    "\u0003\u0011\u0003\u0011\u0007\u0011\u013a\n\u0011\f\u0011\u000e\u0011",
    "\u013d\u000b\u0011\u0003\u0011\u0005\u0011\u0140\n\u0011\u0003\u0011",
    "\u0006\u0011\u0143\n\u0011\r\u0011\u000e\u0011\u0144\u0003\u0011\u0003",
    "\u0011\u0003\u0012\u0003\u0012\u0005\u0012\u014b\n\u0012\u0003\u0013",
    "\u0003\u0013\u0005\u0013\u014f\n\u0013\u0003\u0014\u0003\u0014\u0006",
    "\u0014\u0153\n\u0014\r\u0014\u000e\u0014\u0154\u0003\u0014\u0003\u0014",
    "\u0003\u0014\u0003\u0014\u0006\u0014\u015b\n\u0014\r\u0014\u000e\u0014",
    "\u015c\u0005\u0014\u015f\n\u0014\u0003\u0014\u0003\u0014\u0007\u0014",
    "\u0163\n\u0014\f\u0014\u000e\u0014\u0166\u000b\u0014\u0003\u0015\u0003",
    "\u0015\u0003\u0015\u0007\u0015\u016b\n\u0015\f\u0015\u000e\u0015\u016e",
    "\u000b\u0015\u0003\u0015\u0003\u0015\u0007\u0015\u0172\n\u0015\f\u0015",
    "\u000e\u0015\u0175\u000b\u0015\u0003\u0015\u0003\u0015\u0005\u0015\u0179",
    "\n\u0015\u0003\u0016\u0003\u0016\u0003\u0017\u0003\u0017\u0006\u0017",
    "\u017f\n\u0017\r\u0017\u000e\u0017\u0180\u0003\u0017\u0007\u0017\u0184",
    "\n\u0017\f\u0017\u000e\u0017\u0187\u000b\u0017\u0003\u0018\u0003\u0018",
    "\u0003\u0018\u0007\u0018\u018c\n\u0018\f\u0018\u000e\u0018\u018f\u000b",
    "\u0018\u0003\u0019\u0003\u0019\u0003\u0019\u0003\u0019\u0003\u0019\u0003",
    "\u0019\u0005\u0019\u0197\n\u0019\u0003\u0019\u0003\u0019\u0005\u0019",
    "\u019b\n\u0019\u0005\u0019\u019d\n\u0019\u0003\u001a\u0003\u001a\u0005",
    "\u001a\u01a1\n\u001a\u0003\u001b\u0003\u001b\u0005\u001b\u01a5\n\u001b",
    "\u0003\u001c\u0003\u001c\u0003\u001d\u0003\u001d\u0003\u001e\u0003\u001e",
    "\u0003\u001e\u0003\u001e\u0007\u001e\u01af\n\u001e\f\u001e\u000e\u001e",
    "\u01b2\u000b\u001e\u0003\u001e\u0003\u001e\u0003\u001f\u0003\u001f\u0003",
    "\u001f\u0005\u001f\u01b9\n\u001f\u0003\u001f\u0003\u001f\u0003\u001f",
    "\u0005\u001f\u01be\n\u001f\u0003\u001f\u0005\u001f\u01c1\n\u001f\u0005",
    "\u001f\u01c3\n\u001f\u0003 \u0003 \u0003!\u0003!\u0003\"\u0003\"\u0003",
    "\"\u0003\"\u0003\"\u0003\"\u0003\"\u0005\"\u01d0\n\"\u0003#\u0003#\u0003",
    "#\u0006#\u01d5\n#\r#\u000e#\u01d6\u0003$\u0003$\u0003$\u0003$\u0003",
    "$\u0003$\u0005$\u01df\n$\u0003%\u0003%\u0003%\u0003%\u0003%\u0005%\u01e6",
    "\n%\u0003%\u0003%\u0003&\u0003&\u0003&\u0005&\u01ed\n&\u0003&\u0003",
    "&\u0003\'\u0003\'\u0003\'\u0003\'\u0003(\u0003(\u0003(\u0003(\u0007",
    "(\u01f9\n(\f(\u000e(\u01fc\u000b(\u0003(\u0003(\u0003)\u0003)\u0003",
    ")\u0006)\u0203\n)\r)\u000e)\u0204\u0003*\u0003*\u0003*\u0003*\u0003",
    "*\u0005*\u020c\n*\u0003+\u0003+\u0003+\u0003+\u0003+\u0003+\u0003+\u0003",
    "+\u0005+\u0216\n+\u0003,\u0003,\u0003,\u0003,\u0005,\u021c\n,\u0003",
    "-\u0003-\u0003-\u0003.\u0003.\u0003.\u0003/\u0003/\u0005/\u0226\n/\u0003",
    "/\u0003/\u0007/\u022a\n/\f/\u000e/\u022d\u000b/\u0003/\u0003/\u0003",
    "0\u00030\u00030\u00030\u00030\u00050\u0236\n0\u00031\u00031\u00031\u0003",
    "2\u00032\u00032\u00033\u00033\u00033\u00034\u00034\u00035\u00035\u0003",
    "6\u00036\u00037\u00037\u00038\u00038\u00058\u024b\n8\u00038\u00038\u0007",
    "8\u024f\n8\f8\u000e8\u0252\u000b8\u00038\u00038\u00039\u00039\u0005",
    "9\u0258\n9\u0003:\u0003:\u0003:\u0003;\u0003;\u0003<\u0003<\u0003=\u0003",
    "=\u0005=\u0263\n=\u0003=\u0002\u0002>\u0002\u0004\u0006\b\n\f\u000e",
    "\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@B",
    "DFHJLNPRTVXZ\\^`bdfhjlnprtvx\u0002\b\u0003\u0002\u001f \u0003\u0002",
    "%&\u0003\u0002*+\u0004\u0002\u000e\u000e\u0013\u0014\u0004\u0002\u0013",
    "\u0013\u0015\u0015\u0003\u0002+-\u0002\u028d\u0002\u0096\u0003\u0002",
    "\u0002\u0002\u0004\u00a1\u0003\u0002\u0002\u0002\u0006\u00a3\u0003\u0002",
    "\u0002\u0002\b\u00b4\u0003\u0002\u0002\u0002\n\u00b6\u0003\u0002\u0002",
    "\u0002\f\u00d7\u0003\u0002\u0002\u0002\u000e\u00db\u0003\u0002\u0002",
    "\u0002\u0010\u00de\u0003\u0002\u0002\u0002\u0012\u00f2\u0003\u0002\u0002",
    "\u0002\u0014\u00f4\u0003\u0002\u0002\u0002\u0016\u0102\u0003\u0002\u0002",
    "\u0002\u0018\u0104\u0003\u0002\u0002\u0002\u001a\u010d\u0003\u0002\u0002",
    "\u0002\u001c\u011a\u0003\u0002\u0002\u0002\u001e\u0127\u0003\u0002\u0002",
    "\u0002 \u0136\u0003\u0002\u0002\u0002\"\u014a\u0003\u0002\u0002\u0002",
    "$\u014e\u0003\u0002\u0002\u0002&\u0150\u0003\u0002\u0002\u0002(\u0178",
    "\u0003\u0002\u0002\u0002*\u017a\u0003\u0002\u0002\u0002,\u017c\u0003",
    "\u0002\u0002\u0002.\u0188\u0003\u0002\u0002\u00020\u019c\u0003\u0002",
    "\u0002\u00022\u01a0\u0003\u0002\u0002\u00024\u01a4\u0003\u0002\u0002",
    "\u00026\u01a6\u0003\u0002\u0002\u00028\u01a8\u0003\u0002\u0002\u0002",
    ":\u01aa\u0003\u0002\u0002\u0002<\u01c2\u0003\u0002\u0002\u0002>\u01c4",
    "\u0003\u0002\u0002\u0002@\u01c6\u0003\u0002\u0002\u0002B\u01cf\u0003",
    "\u0002\u0002\u0002D\u01d1\u0003\u0002\u0002\u0002F\u01de\u0003\u0002",
    "\u0002\u0002H\u01e5\u0003\u0002\u0002\u0002J\u01ec\u0003\u0002\u0002",
    "\u0002L\u01f0\u0003\u0002\u0002\u0002N\u01f4\u0003\u0002\u0002\u0002",
    "P\u01ff\u0003\u0002\u0002\u0002R\u020b\u0003\u0002\u0002\u0002T\u0215",
    "\u0003\u0002\u0002\u0002V\u0217\u0003\u0002\u0002\u0002X\u021d\u0003",
    "\u0002\u0002\u0002Z\u0220\u0003\u0002\u0002\u0002\\\u0223\u0003\u0002",
    "\u0002\u0002^\u0235\u0003\u0002\u0002\u0002`\u0237\u0003\u0002\u0002",
    "\u0002b\u023a\u0003\u0002\u0002\u0002d\u023d\u0003\u0002\u0002\u0002",
    "f\u0240\u0003\u0002\u0002\u0002h\u0242\u0003\u0002\u0002\u0002j\u0244",
    "\u0003\u0002\u0002\u0002l\u0246\u0003\u0002\u0002\u0002n\u0248\u0003",
    "\u0002\u0002\u0002p\u0257\u0003\u0002\u0002\u0002r\u0259\u0003\u0002",
    "\u0002\u0002t\u025c\u0003\u0002\u0002\u0002v\u025e\u0003\u0002\u0002",
    "\u0002x\u0260\u0003\u0002\u0002\u0002z\u0097\u0007\u000b\u0002\u0002",
    "{}\u0007\n\u0002\u0002|{\u0003\u0002\u0002\u0002}\u0080\u0003\u0002",
    "\u0002\u0002~|\u0003\u0002\u0002\u0002~\u007f\u0003\u0002\u0002\u0002",
    "\u007f\u0082\u0003\u0002\u0002\u0002\u0080~\u0003\u0002\u0002\u0002",
    "\u0081\u0083\u0005\u0004\u0003\u0002\u0082\u0081\u0003\u0002\u0002\u0002",
    "\u0082\u0083\u0003\u0002\u0002\u0002\u0083\u008c\u0003\u0002\u0002\u0002",
    "\u0084\u0086\u0007\n\u0002\u0002\u0085\u0084\u0003\u0002\u0002\u0002",
    "\u0086\u0087\u0003\u0002\u0002\u0002\u0087\u0085\u0003\u0002\u0002\u0002",
    "\u0087\u0088\u0003\u0002\u0002\u0002\u0088\u0089\u0003\u0002\u0002\u0002",
    "\u0089\u008b\u0005\u0004\u0003\u0002\u008a\u0085\u0003\u0002\u0002\u0002",
    "\u008b\u008e\u0003\u0002\u0002\u0002\u008c\u008a\u0003\u0002\u0002\u0002",
    "\u008c\u008d\u0003\u0002\u0002\u0002\u008d\u0092\u0003\u0002\u0002\u0002",
    "\u008e\u008c\u0003\u0002\u0002\u0002\u008f\u0091\u0007\n\u0002\u0002",
    "\u0090\u008f\u0003\u0002\u0002\u0002\u0091\u0094\u0003\u0002\u0002\u0002",
    "\u0092\u0090\u0003\u0002\u0002\u0002\u0092\u0093\u0003\u0002\u0002\u0002",
    "\u0093\u0095\u0003\u0002\u0002\u0002\u0094\u0092\u0003\u0002\u0002\u0002",
    "\u0095\u0097\u0007\u0002\u0002\u0003\u0096z\u0003\u0002\u0002\u0002",
    "\u0096~\u0003\u0002\u0002\u0002\u0097\u0003\u0003\u0002\u0002\u0002",
    "\u0098\u00a2\u0005\n\u0006\u0002\u0099\u00a2\u0005\u0010\t\u0002\u009a",
    "\u00a2\u0005\u0014\u000b\u0002\u009b\u00a2\u0005\u0006\u0004\u0002\u009c",
    "\u00a2\u0005\u0018\r\u0002\u009d\u00a2\u0005\u001a\u000e\u0002\u009e",
    "\u00a2\u0005 \u0011\u0002\u009f\u00a2\u0005\u001e\u0010\u0002\u00a0",
    "\u00a2\u0005\u001c\u000f\u0002\u00a1\u0098\u0003\u0002\u0002\u0002\u00a1",
    "\u0099\u0003\u0002\u0002\u0002\u00a1\u009a\u0003\u0002\u0002\u0002\u00a1",
    "\u009b\u0003\u0002\u0002\u0002\u00a1\u009c\u0003\u0002\u0002\u0002\u00a1",
    "\u009d\u0003\u0002\u0002\u0002\u00a1\u009e\u0003\u0002\u0002\u0002\u00a1",
    "\u009f\u0003\u0002\u0002\u0002\u00a1\u00a0\u0003\u0002\u0002\u0002\u00a2",
    "\u0005\u0003\u0002\u0002\u0002\u00a3\u00a4\u0007\u001c\u0002\u0002\u00a4",
    "\u00a5\u0007\u000b\u0002\u0002\u00a5\u00a6\u0005v<\u0002\u00a6\u00a7",
    "\u0007\u000b\u0002\u0002\u00a7\u00a8\u0007\u0011\u0002\u0002\u00a8\u00ad",
    "\u0005\b\u0005\u0002\u00a9\u00aa\u0007\u0005\u0002\u0002\u00aa\u00ac",
    "\u0005\b\u0005\u0002\u00ab\u00a9\u0003\u0002\u0002\u0002\u00ac\u00af",
    "\u0003\u0002\u0002\u0002\u00ad\u00ab\u0003\u0002\u0002\u0002\u00ad\u00ae",
    "\u0003\u0002\u0002\u0002\u00ae\u00b0\u0003\u0002\u0002\u0002\u00af\u00ad",
    "\u0003\u0002\u0002\u0002\u00b0\u00b1\u0007\u0012\u0002\u0002\u00b1\u0007",
    "\u0003\u0002\u0002\u0002\u00b2\u00b5\u0005X-\u0002\u00b3\u00b5\u0005",
    "x=\u0002\u00b4\u00b2\u0003\u0002\u0002\u0002\u00b4\u00b3\u0003\u0002",
    "\u0002\u0002\u00b5\t\u0003\u0002\u0002\u0002\u00b6\u00b7\u0007\u001d",
    "\u0002\u0002\u00b7\u00d4\u0007\u000b\u0002\u0002\u00b8\u00bd\u0005\f",
    "\u0007\u0002\u00b9\u00ba\u0007\u0005\u0002\u0002\u00ba\u00bc\u0005\f",
    "\u0007\u0002\u00bb\u00b9\u0003\u0002\u0002\u0002\u00bc\u00bf\u0003\u0002",
    "\u0002\u0002\u00bd\u00bb\u0003\u0002\u0002\u0002\u00bd\u00be\u0003\u0002",
    "\u0002\u0002\u00be\u00d5\u0003\u0002\u0002\u0002\u00bf\u00bd\u0003\u0002",
    "\u0002\u0002\u00c0\u00c2\u0005v<\u0002\u00c1\u00c3\u0007\u000b\u0002",
    "\u0002\u00c2\u00c1\u0003\u0002\u0002\u0002\u00c2\u00c3\u0003\u0002\u0002",
    "\u0002\u00c3\u00c4\u0003\u0002\u0002\u0002\u00c4\u00c8\u0007\f\u0002",
    "\u0002\u00c5\u00c6\u0005\u000e\b\u0002\u00c6\u00c7\u0007\u0005\u0002",
    "\u0002\u00c7\u00c9\u0003\u0002\u0002\u0002\u00c8\u00c5\u0003\u0002\u0002",
    "\u0002\u00c8\u00c9\u0003\u0002\u0002\u0002\u00c9\u00ca\u0003\u0002\u0002",
    "\u0002\u00ca\u00cf\u0005t;\u0002\u00cb\u00cc\u0007\u0005\u0002\u0002",
    "\u00cc\u00ce\u0005t;\u0002\u00cd\u00cb\u0003\u0002\u0002\u0002\u00ce",
    "\u00d1\u0003\u0002\u0002\u0002\u00cf\u00cd\u0003\u0002\u0002\u0002\u00cf",
    "\u00d0\u0003\u0002\u0002\u0002\u00d0\u00d2\u0003\u0002\u0002\u0002\u00d1",
    "\u00cf\u0003\u0002\u0002\u0002\u00d2\u00d3\u0007\r\u0002\u0002\u00d3",
    "\u00d5\u0003\u0002\u0002\u0002\u00d4\u00b8\u0003\u0002\u0002\u0002\u00d4",
    "\u00c0\u0003\u0002\u0002\u0002\u00d5\u000b\u0003\u0002\u0002\u0002\u00d6",
    "\u00d8\u0007\u0013\u0002\u0002\u00d7\u00d6\u0003\u0002\u0002\u0002\u00d7",
    "\u00d8\u0003\u0002\u0002\u0002\u00d8\u00d9\u0003\u0002\u0002\u0002\u00d9",
    "\u00da\u0005v<\u0002\u00da\r\u0003\u0002\u0002\u0002\u00db\u00dc\u0007",
    "\u000e\u0002\u0002\u00dc\u00dd\u0005t;\u0002\u00dd\u000f\u0003\u0002",
    "\u0002\u0002\u00de\u00df\u0007\u001e\u0002\u0002\u00df\u00e0\u0007\u000b",
    "\u0002\u0002\u00e0\u00e1\u0005x=\u0002\u00e1\u00e7\u0007\u000b\u0002",
    "\u0002\u00e2\u00e3\u0005\u0012\n\u0002\u00e3\u00e4\u0007\u000b\u0002",
    "\u0002\u00e4\u00e6\u0003\u0002\u0002\u0002\u00e5\u00e2\u0003\u0002\u0002",
    "\u0002\u00e6\u00e9\u0003\u0002\u0002\u0002\u00e7\u00e5\u0003\u0002\u0002",
    "\u0002\u00e7\u00e8\u0003\u0002\u0002\u0002\u00e8\u00ea\u0003\u0002\u0002",
    "\u0002\u00e9\u00e7\u0003\u0002\u0002\u0002\u00ea\u00ef\u0005n8\u0002",
    "\u00eb\u00ec\u0007\u000b\u0002\u0002\u00ec\u00ee\u0005\u0012\n\u0002",
    "\u00ed\u00eb\u0003\u0002\u0002\u0002\u00ee\u00f1\u0003\u0002\u0002\u0002",
    "\u00ef\u00ed\u0003\u0002\u0002\u0002\u00ef\u00f0\u0003\u0002\u0002\u0002",
    "\u00f0\u0011\u0003\u0002\u0002\u0002\u00f1\u00ef\u0003\u0002\u0002\u0002",
    "\u00f2\u00f3\t\u0002\u0002\u0002\u00f3\u0013\u0003\u0002\u0002\u0002",
    "\u00f4\u00f5\u0007!\u0002\u0002\u00f5\u00f6\u0007\u000b\u0002\u0002",
    "\u00f6\u0100\u0005\u0016\f\u0002\u00f7\u00f8\u0007\u0005\u0002\u0002",
    "\u00f8\u00fa\u0005\u0016\f\u0002\u00f9\u00f7\u0003\u0002\u0002\u0002",
    "\u00fa\u00fd\u0003\u0002\u0002\u0002\u00fb\u00f9\u0003\u0002\u0002\u0002",
    "\u00fb\u00fc\u0003\u0002\u0002\u0002\u00fc\u0101\u0003\u0002\u0002\u0002",
    "\u00fd\u00fb\u0003\u0002\u0002\u0002\u00fe\u00ff\u0007\u000b\u0002\u0002",
    "\u00ff\u0101\u0005n8\u0002\u0100\u00fb\u0003\u0002\u0002\u0002\u0100",
    "\u00fe\u0003\u0002\u0002\u0002\u0101\u0015\u0003\u0002\u0002\u0002\u0102",
    "\u0103\u0005x=\u0002\u0103\u0017\u0003\u0002\u0002\u0002\u0104\u0105",
    "\u0007\"\u0002\u0002\u0105\u0107\u0007\u0016\u0002\u0002\u0106\u0108",
    "\u0007\n\u0002\u0002\u0107\u0106\u0003\u0002\u0002\u0002\u0108\u0109",
    "\u0003\u0002\u0002\u0002\u0109\u0107\u0003\u0002\u0002\u0002\u0109\u010a",
    "\u0003\u0002\u0002\u0002\u010a\u010b\u0003\u0002\u0002\u0002\u010b\u010c",
    "\u0007\u0003\u0002\u0002\u010c\u0019\u0003\u0002\u0002\u0002\u010d\u0110",
    "\u0007#\u0002\u0002\u010e\u010f\u0007\u000b\u0002\u0002\u010f\u0111",
    "\u0007(\u0002\u0002\u0110\u010e\u0003\u0002\u0002\u0002\u0110\u0111",
    "\u0003\u0002\u0002\u0002\u0111\u0112\u0003\u0002\u0002\u0002\u0112\u0114",
    "\u0007\u0016\u0002\u0002\u0113\u0115\u0007\n\u0002\u0002\u0114\u0113",
    "\u0003\u0002\u0002\u0002\u0115\u0116\u0003\u0002\u0002\u0002\u0116\u0114",
    "\u0003\u0002\u0002\u0002\u0116\u0117\u0003\u0002\u0002\u0002\u0117\u0118",
    "\u0003\u0002\u0002\u0002\u0118\u0119\u0005&\u0014\u0002\u0119\u001b",
    "\u0003\u0002\u0002\u0002\u011a\u011d\u0007$\u0002\u0002\u011b\u011c",
    "\u0007\u000b\u0002\u0002\u011c\u011e\u0007(\u0002\u0002\u011d\u011b",
    "\u0003\u0002\u0002\u0002\u011d\u011e\u0003\u0002\u0002\u0002\u011e\u011f",
    "\u0003\u0002\u0002\u0002\u011f\u0121\u0007\u0016\u0002\u0002\u0120\u0122",
    "\u0007\n\u0002\u0002\u0121\u0120\u0003\u0002\u0002\u0002\u0122\u0123",
    "\u0003\u0002\u0002\u0002\u0123\u0121\u0003\u0002\u0002\u0002\u0123\u0124",
    "\u0003\u0002\u0002\u0002\u0124\u0125\u0003\u0002\u0002\u0002\u0125\u0126",
    "\u0005&\u0014\u0002\u0126\u001d\u0003\u0002\u0002\u0002\u0127\u0128",
    "\u0007$\u0002\u0002\u0128\u0129\u0007\u0015\u0002\u0002\u0129\u012c",
    "\u0005.\u0018\u0002\u012a\u012b\u0007\u000b\u0002\u0002\u012b\u012d",
    "\u0007(\u0002\u0002\u012c\u012a\u0003\u0002\u0002\u0002\u012c\u012d",
    "\u0003\u0002\u0002\u0002\u012d\u012e\u0003\u0002\u0002\u0002\u012e\u0130",
    "\u0007\u0016\u0002\u0002\u012f\u0131\u0007\n\u0002\u0002\u0130\u012f",
    "\u0003\u0002\u0002\u0002\u0131\u0132\u0003\u0002\u0002\u0002\u0132\u0130",
    "\u0003\u0002\u0002\u0002\u0132\u0133\u0003\u0002\u0002\u0002\u0133\u0134",
    "\u0003\u0002\u0002\u0002\u0134\u0135\u0005&\u0014\u0002\u0135\u001f",
    "\u0003\u0002\u0002\u0002\u0136\u013b\u0005.\u0018\u0002\u0137\u0138",
    "\u0007\u000b\u0002\u0002\u0138\u013a\u0005\"\u0012\u0002\u0139\u0137",
    "\u0003\u0002\u0002\u0002\u013a\u013d\u0003\u0002\u0002\u0002\u013b\u0139",
    "\u0003\u0002\u0002\u0002\u013b\u013c\u0003\u0002\u0002\u0002\u013c\u013f",
    "\u0003\u0002\u0002\u0002\u013d\u013b\u0003\u0002\u0002\u0002\u013e\u0140",
    "\u0007\u0016\u0002\u0002\u013f\u013e\u0003\u0002\u0002\u0002\u013f\u0140",
    "\u0003\u0002\u0002\u0002\u0140\u0142\u0003\u0002\u0002\u0002\u0141\u0143",
    "\u0007\n\u0002\u0002\u0142\u0141\u0003\u0002\u0002\u0002\u0143\u0144",
    "\u0003\u0002\u0002\u0002\u0144\u0142\u0003\u0002\u0002\u0002\u0144\u0145",
    "\u0003\u0002\u0002\u0002\u0145\u0146\u0003\u0002\u0002\u0002\u0146\u0147",
    "\u0005&\u0014\u0002\u0147!\u0003\u0002\u0002\u0002\u0148\u014b\u0005",
    "$\u0013\u0002\u0149\u014b\u0007\'\u0002\u0002\u014a\u0148\u0003\u0002",
    "\u0002\u0002\u014a\u0149\u0003\u0002\u0002\u0002\u014b#\u0003\u0002",
    "\u0002\u0002\u014c\u014f\u0005X-\u0002\u014d\u014f\u0005\\/\u0002\u014e",
    "\u014c\u0003\u0002\u0002\u0002\u014e\u014d\u0003\u0002\u0002\u0002\u014f",
    "%\u0003\u0002\u0002\u0002\u0150\u0164\u0005(\u0015\u0002\u0151\u0153",
    "\u0007\n\u0002\u0002\u0152\u0151\u0003\u0002\u0002\u0002\u0153\u0154",
    "\u0003\u0002\u0002\u0002\u0154\u0152\u0003\u0002\u0002\u0002\u0154\u0155",
    "\u0003\u0002\u0002\u0002\u0155\u0156\u0003\u0002\u0002\u0002\u0156\u0157",
    "\u0005*\u0016\u0002\u0157\u015e\u0007\u0016\u0002\u0002\u0158\u015f",
    "\u0007\u000b\u0002\u0002\u0159\u015b\u0007\n\u0002\u0002\u015a\u0159",
    "\u0003\u0002\u0002\u0002\u015b\u015c\u0003\u0002\u0002\u0002\u015c\u015a",
    "\u0003\u0002\u0002\u0002\u015c\u015d\u0003\u0002\u0002\u0002\u015d\u015f",
    "\u0003\u0002\u0002\u0002\u015e\u0158\u0003\u0002\u0002\u0002\u015e\u015a",
    "\u0003\u0002\u0002\u0002\u015f\u0160\u0003\u0002\u0002\u0002\u0160\u0161",
    "\u0005(\u0015\u0002\u0161\u0163\u0003\u0002\u0002\u0002\u0162\u0152",
    "\u0003\u0002\u0002\u0002\u0163\u0166\u0003\u0002\u0002\u0002\u0164\u0162",
    "\u0003\u0002\u0002\u0002\u0164\u0165\u0003\u0002\u0002\u0002\u0165\'",
    "\u0003\u0002\u0002\u0002\u0166\u0164\u0003\u0002\u0002\u0002\u0167\u0179",
    "\u0005,\u0017\u0002\u0168\u016c\u0007\f\u0002\u0002\u0169\u016b\u0007",
    "\n\u0002\u0002\u016a\u0169\u0003\u0002\u0002\u0002\u016b\u016e\u0003",
    "\u0002\u0002\u0002\u016c\u016a\u0003\u0002\u0002\u0002\u016c\u016d\u0003",
    "\u0002\u0002\u0002\u016d\u016f\u0003\u0002\u0002\u0002\u016e\u016c\u0003",
    "\u0002\u0002\u0002\u016f\u0173\u0005&\u0014\u0002\u0170\u0172\u0007",
    "\n\u0002\u0002\u0171\u0170\u0003\u0002\u0002\u0002\u0172\u0175\u0003",
    "\u0002\u0002\u0002\u0173\u0171\u0003\u0002\u0002\u0002\u0173\u0174\u0003",
    "\u0002\u0002\u0002\u0174\u0176\u0003\u0002\u0002\u0002\u0175\u0173\u0003",
    "\u0002\u0002\u0002\u0176\u0177\u0007\r\u0002\u0002\u0177\u0179\u0003",
    "\u0002\u0002\u0002\u0178\u0167\u0003\u0002\u0002\u0002\u0178\u0168\u0003",
    "\u0002\u0002\u0002\u0179)\u0003\u0002\u0002\u0002\u017a\u017b\t\u0003",
    "\u0002\u0002\u017b+\u0003\u0002\u0002\u0002\u017c\u0185\u00050\u0019",
    "\u0002\u017d\u017f\u0007\n\u0002\u0002\u017e\u017d\u0003\u0002\u0002",
    "\u0002\u017f\u0180\u0003\u0002\u0002\u0002\u0180\u017e\u0003\u0002\u0002",
    "\u0002\u0180\u0181\u0003\u0002\u0002\u0002\u0181\u0182\u0003\u0002\u0002",
    "\u0002\u0182\u0184\u00050\u0019\u0002\u0183\u017e\u0003\u0002\u0002",
    "\u0002\u0184\u0187\u0003\u0002\u0002\u0002\u0185\u0183\u0003\u0002\u0002",
    "\u0002\u0185\u0186\u0003\u0002\u0002\u0002\u0186-\u0003\u0002\u0002",
    "\u0002\u0187\u0185\u0003\u0002\u0002\u0002\u0188\u018d\u0007+\u0002",
    "\u0002\u0189\u018a\u0007\u0015\u0002\u0002\u018a\u018c\t\u0004\u0002",
    "\u0002\u018b\u0189\u0003\u0002\u0002\u0002\u018c\u018f\u0003\u0002\u0002",
    "\u0002\u018d\u018b\u0003\u0002\u0002\u0002\u018d\u018e\u0003\u0002\u0002",
    "\u0002\u018e/\u0003\u0002\u0002\u0002\u018f\u018d\u0003\u0002\u0002",
    "\u0002\u0190\u019d\u0007)\u0002\u0002\u0191\u0192\u00056\u001c\u0002",
    "\u0192\u0193\u0007\u0006\u0002\u0002\u0193\u0196\u00058\u001d\u0002",
    "\u0194\u0195\u0007\u0007\u0002\u0002\u0195\u0197\u00052\u001a\u0002",
    "\u0196\u0194\u0003\u0002\u0002\u0002\u0196\u0197\u0003\u0002\u0002\u0002",
    "\u0197\u019a\u0003\u0002\u0002\u0002\u0198\u0199\u0007\b\u0002\u0002",
    "\u0199\u019b\u00054\u001b\u0002\u019a\u0198\u0003\u0002\u0002\u0002",
    "\u019a\u019b\u0003\u0002\u0002\u0002\u019b\u019d\u0003\u0002\u0002\u0002",
    "\u019c\u0190\u0003\u0002\u0002\u0002\u019c\u0191\u0003\u0002\u0002\u0002",
    "\u019d1\u0003\u0002\u0002\u0002\u019e\u01a1\u0005<\u001f\u0002\u019f",
    "\u01a1\u0005:\u001e\u0002\u01a0\u019e\u0003\u0002\u0002\u0002\u01a0",
    "\u019f\u0003\u0002\u0002\u0002\u01a13\u0003\u0002\u0002\u0002\u01a2",
    "\u01a5\u0005<\u001f\u0002\u01a3\u01a5\u0005:\u001e\u0002\u01a4\u01a2",
    "\u0003\u0002\u0002\u0002\u01a4\u01a3\u0003\u0002\u0002\u0002\u01a55",
    "\u0003\u0002\u0002\u0002\u01a6\u01a7\u0005B\"\u0002\u01a77\u0003\u0002",
    "\u0002\u0002\u01a8\u01a9\u0005B\"\u0002\u01a99\u0003\u0002\u0002\u0002",
    "\u01aa\u01ab\u0007\u0011\u0002\u0002\u01ab\u01b0\u0005<\u001f\u0002",
    "\u01ac\u01ad\u0007\u0005\u0002\u0002\u01ad\u01af\u0005<\u001f\u0002",
    "\u01ae\u01ac\u0003\u0002\u0002\u0002\u01af\u01b2\u0003\u0002\u0002\u0002",
    "\u01b0\u01ae\u0003\u0002\u0002\u0002\u01b0\u01b1\u0003\u0002\u0002\u0002",
    "\u01b1\u01b3\u0003\u0002\u0002\u0002\u01b2\u01b0\u0003\u0002\u0002\u0002",
    "\u01b3\u01b4\u0007\u0012\u0002\u0002\u01b4;\u0003\u0002\u0002\u0002",
    "\u01b5\u01b6\u0005> \u0002\u01b6\u01b7\u0007\u000b\u0002\u0002\u01b7",
    "\u01b9\u0003\u0002\u0002\u0002\u01b8\u01b5\u0003\u0002\u0002\u0002\u01b8",
    "\u01b9\u0003\u0002\u0002\u0002\u01b9\u01ba\u0003\u0002\u0002\u0002\u01ba",
    "\u01bd\u0007\t\u0002\u0002\u01bb\u01bc\u0007\u000b\u0002\u0002\u01bc",
    "\u01be\u0005@!\u0002\u01bd\u01bb\u0003\u0002\u0002\u0002\u01bd\u01be",
    "\u0003\u0002\u0002\u0002\u01be\u01c3\u0003\u0002\u0002\u0002\u01bf\u01c1",
    "\u0005> \u0002\u01c0\u01bf\u0003\u0002\u0002\u0002\u01c0\u01c1\u0003",
    "\u0002\u0002\u0002\u01c1\u01c3\u0003\u0002\u0002\u0002\u01c2\u01b8\u0003",
    "\u0002\u0002\u0002\u01c2\u01c0\u0003\u0002\u0002\u0002\u01c3=\u0003",
    "\u0002\u0002\u0002\u01c4\u01c5\u0005B\"\u0002\u01c5?\u0003\u0002\u0002",
    "\u0002\u01c6\u01c7\u0005B\"\u0002\u01c7A\u0003\u0002\u0002\u0002\u01c8",
    "\u01d0\u0005H%\u0002\u01c9\u01d0\u0005J&\u0002\u01ca\u01d0\u0005L\'",
    "\u0002\u01cb\u01d0\u0005N(\u0002\u01cc\u01d0\u0005P)\u0002\u01cd\u01d0",
    "\u0005T+\u0002\u01ce\u01d0\u0005D#\u0002\u01cf\u01c8\u0003\u0002\u0002",
    "\u0002\u01cf\u01c9\u0003\u0002\u0002\u0002\u01cf\u01ca\u0003\u0002\u0002",
    "\u0002\u01cf\u01cb\u0003\u0002\u0002\u0002\u01cf\u01cc\u0003\u0002\u0002",
    "\u0002\u01cf\u01cd\u0003\u0002\u0002\u0002\u01cf\u01ce\u0003\u0002\u0002",
    "\u0002\u01d0C\u0003\u0002\u0002\u0002\u01d1\u01d4\u0005F$\u0002\u01d2",
    "\u01d3\u0007\u000b\u0002\u0002\u01d3\u01d5\u0005F$\u0002\u01d4\u01d2",
    "\u0003\u0002\u0002\u0002\u01d5\u01d6\u0003\u0002\u0002\u0002\u01d6\u01d4",
    "\u0003\u0002\u0002\u0002\u01d6\u01d7\u0003\u0002\u0002\u0002\u01d7E",
    "\u0003\u0002\u0002\u0002\u01d8\u01df\u0005H%\u0002\u01d9\u01df\u0005",
    "J&\u0002\u01da\u01df\u0005L\'\u0002\u01db\u01df\u0005N(\u0002\u01dc",
    "\u01df\u0005P)\u0002\u01dd\u01df\u0005T+\u0002\u01de\u01d8\u0003\u0002",
    "\u0002\u0002\u01de\u01d9\u0003\u0002\u0002\u0002\u01de\u01da\u0003\u0002",
    "\u0002\u0002\u01de\u01db\u0003\u0002\u0002\u0002\u01de\u01dc\u0003\u0002",
    "\u0002\u0002\u01de\u01dd\u0003\u0002\u0002\u0002\u01dfG\u0003\u0002",
    "\u0002\u0002\u01e0\u01e6\u0005L\'\u0002\u01e1\u01e6\u0005N(\u0002\u01e2",
    "\u01e6\u0005V,\u0002\u01e3\u01e6\u0005X-\u0002\u01e4\u01e6\u0005\\/",
    "\u0002\u01e5\u01e0\u0003\u0002\u0002\u0002\u01e5\u01e1\u0003\u0002\u0002",
    "\u0002\u01e5\u01e2\u0003\u0002\u0002\u0002\u01e5\u01e3\u0003\u0002\u0002",
    "\u0002\u01e5\u01e4\u0003\u0002\u0002\u0002\u01e6\u01e7\u0003\u0002\u0002",
    "\u0002\u01e7\u01e8\u0005Z.\u0002\u01e8I\u0003\u0002\u0002\u0002\u01e9",
    "\u01ed\u0005L\'\u0002\u01ea\u01ed\u0005N(\u0002\u01eb\u01ed\u0005T+",
    "\u0002\u01ec\u01e9\u0003\u0002\u0002\u0002\u01ec\u01ea\u0003\u0002\u0002",
    "\u0002\u01ec\u01eb\u0003\u0002\u0002\u0002\u01ed\u01ee\u0003\u0002\u0002",
    "\u0002\u01ee\u01ef\u0005l7\u0002\u01efK\u0003\u0002\u0002\u0002\u01f0",
    "\u01f1\u0007\f\u0002\u0002\u01f1\u01f2\u0005B\"\u0002\u01f2\u01f3\u0007",
    "\r\u0002\u0002\u01f3M\u0003\u0002\u0002\u0002\u01f4\u01f5\u0007\u0011",
    "\u0002\u0002\u01f5\u01fa\u0005B\"\u0002\u01f6\u01f7\u0007\u0005\u0002",
    "\u0002\u01f7\u01f9\u0005B\"\u0002\u01f8\u01f6\u0003\u0002\u0002\u0002",
    "\u01f9\u01fc\u0003\u0002\u0002\u0002\u01fa\u01f8\u0003\u0002\u0002\u0002",
    "\u01fa\u01fb\u0003\u0002\u0002\u0002\u01fb\u01fd\u0003\u0002\u0002\u0002",
    "\u01fc\u01fa\u0003\u0002\u0002\u0002\u01fd\u01fe\u0007\u0012\u0002\u0002",
    "\u01feO\u0003\u0002\u0002\u0002\u01ff\u0202\u0005R*\u0002\u0200\u0201",
    "\u0007\u001b\u0002\u0002\u0201\u0203\u0005R*\u0002\u0202\u0200\u0003",
    "\u0002\u0002\u0002\u0203\u0204\u0003\u0002\u0002\u0002\u0204\u0202\u0003",
    "\u0002\u0002\u0002\u0204\u0205\u0003\u0002\u0002\u0002\u0205Q\u0003",
    "\u0002\u0002\u0002\u0206\u020c\u0005H%\u0002\u0207\u020c\u0005J&\u0002",
    "\u0208\u020c\u0005L\'\u0002\u0209\u020c\u0005N(\u0002\u020a\u020c\u0005",
    "T+\u0002\u020b\u0206\u0003\u0002\u0002\u0002\u020b\u0207\u0003\u0002",
    "\u0002\u0002\u020b\u0208\u0003\u0002\u0002\u0002\u020b\u0209\u0003\u0002",
    "\u0002\u0002\u020b\u020a\u0003\u0002\u0002\u0002\u020cS\u0003\u0002",
    "\u0002\u0002\u020d\u0216\u0005V,\u0002\u020e\u0216\u0005X-\u0002\u020f",
    "\u0216\u0005Z.\u0002\u0210\u0216\u0005\\/\u0002\u0211\u0216\u0005f4",
    "\u0002\u0212\u0216\u0005h5\u0002\u0213\u0216\u0005j6\u0002\u0214\u0216",
    "\u0005x=\u0002\u0215\u020d\u0003\u0002\u0002\u0002\u0215\u020e\u0003",
    "\u0002\u0002\u0002\u0215\u020f\u0003\u0002\u0002\u0002\u0215\u0210\u0003",
    "\u0002\u0002\u0002\u0215\u0211\u0003\u0002\u0002\u0002\u0215\u0212\u0003",
    "\u0002\u0002\u0002\u0215\u0213\u0003\u0002\u0002\u0002\u0215\u0214\u0003",
    "\u0002\u0002\u0002\u0216U\u0003\u0002\u0002\u0002\u0217\u021b\u0007",
    "\u0017\u0002\u0002\u0218\u021c\u0005X-\u0002\u0219\u021c\u0005Z.\u0002",
    "\u021a\u021c\u0005x=\u0002\u021b\u0218\u0003\u0002\u0002\u0002\u021b",
    "\u0219\u0003\u0002\u0002\u0002\u021b\u021a\u0003\u0002\u0002\u0002\u021c",
    "W\u0003\u0002\u0002\u0002\u021d\u021e\u0007\u001a\u0002\u0002\u021e",
    "\u021f\u0005v<\u0002\u021fY\u0003\u0002\u0002\u0002\u0220\u0221\u0007",
    "\u0018\u0002\u0002\u0221\u0222\u0007*\u0002\u0002\u0222[\u0003\u0002",
    "\u0002\u0002\u0223\u0225\u0007\u000f\u0002\u0002\u0224\u0226\u0005^",
    "0\u0002\u0225\u0224\u0003\u0002\u0002\u0002\u0225\u0226\u0003\u0002",
    "\u0002\u0002\u0226\u022b\u0003\u0002\u0002\u0002\u0227\u0228\u0007\u000b",
    "\u0002\u0002\u0228\u022a\u0005^0\u0002\u0229\u0227\u0003\u0002\u0002",
    "\u0002\u022a\u022d\u0003\u0002\u0002\u0002\u022b\u0229\u0003\u0002\u0002",
    "\u0002\u022b\u022c\u0003\u0002\u0002\u0002\u022c\u022e\u0003\u0002\u0002",
    "\u0002\u022d\u022b\u0003\u0002\u0002\u0002\u022e\u022f\u0007\u0010\u0002",
    "\u0002\u022f]\u0003\u0002\u0002\u0002\u0230\u0236\u0005r:\u0002\u0231",
    "\u0236\u0005t;\u0002\u0232\u0236\u0005`1\u0002\u0233\u0236\u0005b2\u0002",
    "\u0234\u0236\u0005d3\u0002\u0235\u0230\u0003\u0002\u0002\u0002\u0235",
    "\u0231\u0003\u0002\u0002\u0002\u0235\u0232\u0003\u0002\u0002\u0002\u0235",
    "\u0233\u0003\u0002\u0002\u0002\u0235\u0234\u0003\u0002\u0002\u0002\u0236",
    "_\u0003\u0002\u0002\u0002\u0237\u0238\u0007\u0017\u0002\u0002\u0238",
    "\u0239\u0005v<\u0002\u0239a\u0003\u0002\u0002\u0002\u023a\u023b\u0007",
    "\u000e\u0002\u0002\u023b\u023c\u0005v<\u0002\u023cc\u0003\u0002\u0002",
    "\u0002\u023d\u023e\u0007\u0018\u0002\u0002\u023e\u023f\u0005v<\u0002",
    "\u023fe\u0003\u0002\u0002\u0002\u0240\u0241\u0007\u000e\u0002\u0002",
    "\u0241g\u0003\u0002\u0002\u0002\u0242\u0243\u0007\u0018\u0002\u0002",
    "\u0243i\u0003\u0002\u0002\u0002\u0244\u0245\u0007\u0019\u0002\u0002",
    "\u0245k\u0003\u0002\u0002\u0002\u0246\u0247\t\u0005\u0002\u0002\u0247",
    "m\u0003\u0002\u0002\u0002\u0248\u024a\u0007\u000f\u0002\u0002\u0249",
    "\u024b\u0005p9\u0002\u024a\u0249\u0003\u0002\u0002\u0002\u024a\u024b",
    "\u0003\u0002\u0002\u0002\u024b\u0250\u0003\u0002\u0002\u0002\u024c\u024d",
    "\u0007\u000b\u0002\u0002\u024d\u024f\u0005p9\u0002\u024e\u024c\u0003",
    "\u0002\u0002\u0002\u024f\u0252\u0003\u0002\u0002\u0002\u0250\u024e\u0003",
    "\u0002\u0002\u0002\u0250\u0251\u0003\u0002\u0002\u0002\u0251\u0253\u0003",
    "\u0002\u0002\u0002\u0252\u0250\u0003\u0002\u0002\u0002\u0253\u0254\u0007",
    "\u0010\u0002\u0002\u0254o\u0003\u0002\u0002\u0002\u0255\u0258\u0005",
    "r:\u0002\u0256\u0258\u0005t;\u0002\u0257\u0255\u0003\u0002\u0002\u0002",
    "\u0257\u0256\u0003\u0002\u0002\u0002\u0258q\u0003\u0002\u0002\u0002",
    "\u0259\u025a\t\u0006\u0002\u0002\u025a\u025b\u0005v<\u0002\u025bs\u0003",
    "\u0002\u0002\u0002\u025c\u025d\u0005v<\u0002\u025du\u0003\u0002\u0002",
    "\u0002\u025e\u025f\u0007+\u0002\u0002\u025fw\u0003\u0002\u0002\u0002",
    "\u0260\u0262\t\u0007\u0002\u0002\u0261\u0263\u0007\u0017\u0002\u0002",
    "\u0262\u0261\u0003\u0002\u0002\u0002\u0262\u0263\u0003\u0002\u0002\u0002",
    "\u0263y\u0003\u0002\u0002\u0002F~\u0082\u0087\u008c\u0092\u0096\u00a1",
    "\u00ad\u00b4\u00bd\u00c2\u00c8\u00cf\u00d4\u00d7\u00e7\u00ef\u00fb\u0100",
    "\u0109\u0110\u0116\u011d\u0123\u012c\u0132\u013b\u013f\u0144\u014a\u014e",
    "\u0154\u015c\u015e\u0164\u016c\u0173\u0178\u0180\u0185\u018d\u0196\u019a",
    "\u019c\u01a0\u01a4\u01b0\u01b8\u01bd\u01c0\u01c2\u01cf\u01d6\u01de\u01e5",
    "\u01ec\u01fa\u0204\u020b\u0215\u021b\u0225\u022b\u0235\u024a\u0250\u0257",
    "\u0262"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

var sharedContextCache = new antlr4.PredictionContextCache();

var literalNames = [ null, "'default'", null, null, null, null, null, "'_'", 
                     null, null, "'('", "')'", "'*'", "'['", "']'", "'{'", 
                     "'}'", "'+'", "'?'", "'-'", "':'", "'!'", "'$'", "'$$'", 
                     "'@'", "'&'", null, null, null, null, null, null, "'Syllables'" ];

var symbolicNames = [ null, null, "COMMENT", "SEP", "CHANGE", "CONDITION", 
                      "EXCLUSION", "ANCHOR", "NEWLINE", "WHITESPACE", "O_PAREN", 
                      "C_PAREN", "NULL", "MATRIX_START", "MATRIX_END", "LIST_START", 
                      "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
                      "RULE_START", "NEGATION", "WORD_BOUNDARY", "BETWEEN_WORDS", 
                      "CLASSREF", "INTERSECTION", "CLASS_DECL", "FEATURE_DECL", 
                      "DIACRITIC", "DIA_BEFORE", "DIA_FLOATING", "SYMBOL", 
                      "SYLLABLE_DECL", "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", 
                      "FIRST_MATCHING", "PROPAGATE", "LITERAL", "UNCHANGED", 
                      "NUMBER", "NAME", "STR1", "STR" ];

var ruleNames =  [ "lscFile", "statement", "classDecl", "classElement", 
                   "featureDecl", "plusFeature", "nullAlias", "diacriticDecl", 
                   "diacriticModifier", "symbolDecl", "symbolName", "syllableDecl", 
                   "deromanizer", "romanizer", "interRomanizer", "changeRule", 
                   "changeRuleModifier", "filter", "block", "blockElement", 
                   "blockType", "expressionList", "ruleName", "expression", 
                   "condition", "exclusion", "from", "to", "environmentList", 
                   "environment", "environmentBefore", "environmentAfter", 
                   "ruleElement", "sequence", "sequenceElement", "capture", 
                   "repeater", "group", "list", "intersection", "intersectionElement", 
                   "simple", "negated", "classRef", "captureRef", "fancyMatrix", 
                   "fancyValue", "negatedValue", "absentFeature", "featureVariable", 
                   "empty", "boundary", "betweenWords", "repeaterType", 
                   "matrix", "matrixValue", "plusFeatureValue", "featureValue", 
                   "name", "text" ];

function LscParser (input) {
	antlr4.Parser.call(this, input);
    this._interp = new antlr4.atn.ParserATNSimulator(this, atn, decisionsToDFA, sharedContextCache);
    this.ruleNames = ruleNames;
    this.literalNames = literalNames;
    this.symbolicNames = symbolicNames;
    return this;
}

LscParser.prototype = Object.create(antlr4.Parser.prototype);
LscParser.prototype.constructor = LscParser;

Object.defineProperty(LscParser.prototype, "atn", {
	get : function() {
		return atn;
	}
});

LscParser.EOF = antlr4.Token.EOF;
LscParser.T__0 = 1;
LscParser.COMMENT = 2;
LscParser.SEP = 3;
LscParser.CHANGE = 4;
LscParser.CONDITION = 5;
LscParser.EXCLUSION = 6;
LscParser.ANCHOR = 7;
LscParser.NEWLINE = 8;
LscParser.WHITESPACE = 9;
LscParser.O_PAREN = 10;
LscParser.C_PAREN = 11;
LscParser.NULL = 12;
LscParser.MATRIX_START = 13;
LscParser.MATRIX_END = 14;
LscParser.LIST_START = 15;
LscParser.LIST_END = 16;
LscParser.AT_LEAST_ONE = 17;
LscParser.OPTIONAL = 18;
LscParser.HYPHEN = 19;
LscParser.RULE_START = 20;
LscParser.NEGATION = 21;
LscParser.WORD_BOUNDARY = 22;
LscParser.BETWEEN_WORDS = 23;
LscParser.CLASSREF = 24;
LscParser.INTERSECTION = 25;
LscParser.CLASS_DECL = 26;
LscParser.FEATURE_DECL = 27;
LscParser.DIACRITIC = 28;
LscParser.DIA_BEFORE = 29;
LscParser.DIA_FLOATING = 30;
LscParser.SYMBOL = 31;
LscParser.SYLLABLE_DECL = 32;
LscParser.DEROMANIZER = 33;
LscParser.ROMANIZER = 34;
LscParser.ALL_MATCHING = 35;
LscParser.FIRST_MATCHING = 36;
LscParser.PROPAGATE = 37;
LscParser.LITERAL = 38;
LscParser.UNCHANGED = 39;
LscParser.NUMBER = 40;
LscParser.NAME = 41;
LscParser.STR1 = 42;
LscParser.STR = 43;

LscParser.RULE_lscFile = 0;
LscParser.RULE_statement = 1;
LscParser.RULE_classDecl = 2;
LscParser.RULE_classElement = 3;
LscParser.RULE_featureDecl = 4;
LscParser.RULE_plusFeature = 5;
LscParser.RULE_nullAlias = 6;
LscParser.RULE_diacriticDecl = 7;
LscParser.RULE_diacriticModifier = 8;
LscParser.RULE_symbolDecl = 9;
LscParser.RULE_symbolName = 10;
LscParser.RULE_syllableDecl = 11;
LscParser.RULE_deromanizer = 12;
LscParser.RULE_romanizer = 13;
LscParser.RULE_interRomanizer = 14;
LscParser.RULE_changeRule = 15;
LscParser.RULE_changeRuleModifier = 16;
LscParser.RULE_filter = 17;
LscParser.RULE_block = 18;
LscParser.RULE_blockElement = 19;
LscParser.RULE_blockType = 20;
LscParser.RULE_expressionList = 21;
LscParser.RULE_ruleName = 22;
LscParser.RULE_expression = 23;
LscParser.RULE_condition = 24;
LscParser.RULE_exclusion = 25;
LscParser.RULE_from = 26;
LscParser.RULE_to = 27;
LscParser.RULE_environmentList = 28;
LscParser.RULE_environment = 29;
LscParser.RULE_environmentBefore = 30;
LscParser.RULE_environmentAfter = 31;
LscParser.RULE_ruleElement = 32;
LscParser.RULE_sequence = 33;
LscParser.RULE_sequenceElement = 34;
LscParser.RULE_capture = 35;
LscParser.RULE_repeater = 36;
LscParser.RULE_group = 37;
LscParser.RULE_list = 38;
LscParser.RULE_intersection = 39;
LscParser.RULE_intersectionElement = 40;
LscParser.RULE_simple = 41;
LscParser.RULE_negated = 42;
LscParser.RULE_classRef = 43;
LscParser.RULE_captureRef = 44;
LscParser.RULE_fancyMatrix = 45;
LscParser.RULE_fancyValue = 46;
LscParser.RULE_negatedValue = 47;
LscParser.RULE_absentFeature = 48;
LscParser.RULE_featureVariable = 49;
LscParser.RULE_empty = 50;
LscParser.RULE_boundary = 51;
LscParser.RULE_betweenWords = 52;
LscParser.RULE_repeaterType = 53;
LscParser.RULE_matrix = 54;
LscParser.RULE_matrixValue = 55;
LscParser.RULE_plusFeatureValue = 56;
LscParser.RULE_featureValue = 57;
LscParser.RULE_name = 58;
LscParser.RULE_text = 59;


function LscFileContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_lscFile;
    return this;
}

LscFileContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
LscFileContext.prototype.constructor = LscFileContext;

LscFileContext.prototype.WHITESPACE = function() {
    return this.getToken(LscParser.WHITESPACE, 0);
};

LscFileContext.prototype.EOF = function() {
    return this.getToken(LscParser.EOF, 0);
};

LscFileContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


LscFileContext.prototype.statement = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(StatementContext);
    } else {
        return this.getTypedRuleContext(StatementContext,i);
    }
};

LscFileContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitLscFile(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.LscFileContext = LscFileContext;

LscParser.prototype.lscFile = function() {

    var localctx = new LscFileContext(this, this._ctx, this.state);
    this.enterRule(localctx, 0, LscParser.RULE_lscFile);
    var _la = 0; // Token type
    try {
        this.state = 148;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.WHITESPACE:
            this.enterOuterAlt(localctx, 1);
            this.state = 120;
            this.match(LscParser.WHITESPACE);
            break;
        case LscParser.EOF:
        case LscParser.NEWLINE:
        case LscParser.CLASS_DECL:
        case LscParser.FEATURE_DECL:
        case LscParser.DIACRITIC:
        case LscParser.SYMBOL:
        case LscParser.SYLLABLE_DECL:
        case LscParser.DEROMANIZER:
        case LscParser.ROMANIZER:
        case LscParser.NAME:
            this.enterOuterAlt(localctx, 2);
            this.state = 124;
            this._errHandler.sync(this);
            var _alt = this._interp.adaptivePredict(this._input,0,this._ctx)
            while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
                if(_alt===1) {
                    this.state = 121;
                    this.match(LscParser.NEWLINE); 
                }
                this.state = 126;
                this._errHandler.sync(this);
                _alt = this._interp.adaptivePredict(this._input,0,this._ctx);
            }

            this.state = 128;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(((((_la - 26)) & ~0x1f) == 0 && ((1 << (_la - 26)) & ((1 << (LscParser.CLASS_DECL - 26)) | (1 << (LscParser.FEATURE_DECL - 26)) | (1 << (LscParser.DIACRITIC - 26)) | (1 << (LscParser.SYMBOL - 26)) | (1 << (LscParser.SYLLABLE_DECL - 26)) | (1 << (LscParser.DEROMANIZER - 26)) | (1 << (LscParser.ROMANIZER - 26)) | (1 << (LscParser.NAME - 26)))) !== 0)) {
                this.state = 127;
                this.statement();
            }

            this.state = 138;
            this._errHandler.sync(this);
            var _alt = this._interp.adaptivePredict(this._input,3,this._ctx)
            while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
                if(_alt===1) {
                    this.state = 131; 
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                    do {
                        this.state = 130;
                        this.match(LscParser.NEWLINE);
                        this.state = 133; 
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                    } while(_la===LscParser.NEWLINE);
                    this.state = 135;
                    this.statement(); 
                }
                this.state = 140;
                this._errHandler.sync(this);
                _alt = this._interp.adaptivePredict(this._input,3,this._ctx);
            }

            this.state = 144;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while(_la===LscParser.NEWLINE) {
                this.state = 141;
                this.match(LscParser.NEWLINE);
                this.state = 146;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            }
            this.state = 147;
            this.match(LscParser.EOF);
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function StatementContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_statement;
    return this;
}

StatementContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
StatementContext.prototype.constructor = StatementContext;

StatementContext.prototype.featureDecl = function() {
    return this.getTypedRuleContext(FeatureDeclContext,0);
};

StatementContext.prototype.diacriticDecl = function() {
    return this.getTypedRuleContext(DiacriticDeclContext,0);
};

StatementContext.prototype.symbolDecl = function() {
    return this.getTypedRuleContext(SymbolDeclContext,0);
};

StatementContext.prototype.classDecl = function() {
    return this.getTypedRuleContext(ClassDeclContext,0);
};

StatementContext.prototype.syllableDecl = function() {
    return this.getTypedRuleContext(SyllableDeclContext,0);
};

StatementContext.prototype.deromanizer = function() {
    return this.getTypedRuleContext(DeromanizerContext,0);
};

StatementContext.prototype.changeRule = function() {
    return this.getTypedRuleContext(ChangeRuleContext,0);
};

StatementContext.prototype.interRomanizer = function() {
    return this.getTypedRuleContext(InterRomanizerContext,0);
};

StatementContext.prototype.romanizer = function() {
    return this.getTypedRuleContext(RomanizerContext,0);
};

StatementContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitStatement(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.StatementContext = StatementContext;

LscParser.prototype.statement = function() {

    var localctx = new StatementContext(this, this._ctx, this.state);
    this.enterRule(localctx, 2, LscParser.RULE_statement);
    try {
        this.state = 159;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,6,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 150;
            this.featureDecl();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 151;
            this.diacriticDecl();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 152;
            this.symbolDecl();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 153;
            this.classDecl();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 154;
            this.syllableDecl();
            break;

        case 6:
            this.enterOuterAlt(localctx, 6);
            this.state = 155;
            this.deromanizer();
            break;

        case 7:
            this.enterOuterAlt(localctx, 7);
            this.state = 156;
            this.changeRule();
            break;

        case 8:
            this.enterOuterAlt(localctx, 8);
            this.state = 157;
            this.interRomanizer();
            break;

        case 9:
            this.enterOuterAlt(localctx, 9);
            this.state = 158;
            this.romanizer();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ClassDeclContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_classDecl;
    return this;
}

ClassDeclContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ClassDeclContext.prototype.constructor = ClassDeclContext;

ClassDeclContext.prototype.CLASS_DECL = function() {
    return this.getToken(LscParser.CLASS_DECL, 0);
};

ClassDeclContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


ClassDeclContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

ClassDeclContext.prototype.LIST_START = function() {
    return this.getToken(LscParser.LIST_START, 0);
};

ClassDeclContext.prototype.classElement = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ClassElementContext);
    } else {
        return this.getTypedRuleContext(ClassElementContext,i);
    }
};

ClassDeclContext.prototype.LIST_END = function() {
    return this.getToken(LscParser.LIST_END, 0);
};

ClassDeclContext.prototype.SEP = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.SEP);
    } else {
        return this.getToken(LscParser.SEP, i);
    }
};


ClassDeclContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitClassDecl(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ClassDeclContext = ClassDeclContext;

LscParser.prototype.classDecl = function() {

    var localctx = new ClassDeclContext(this, this._ctx, this.state);
    this.enterRule(localctx, 4, LscParser.RULE_classDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 161;
        this.match(LscParser.CLASS_DECL);
        this.state = 162;
        this.match(LscParser.WHITESPACE);
        this.state = 163;
        this.name();
        this.state = 164;
        this.match(LscParser.WHITESPACE);
        this.state = 165;
        this.match(LscParser.LIST_START);
        this.state = 166;
        this.classElement();
        this.state = 171;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 167;
            this.match(LscParser.SEP);
            this.state = 168;
            this.classElement();
            this.state = 173;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 174;
        this.match(LscParser.LIST_END);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ClassElementContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_classElement;
    return this;
}

ClassElementContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ClassElementContext.prototype.constructor = ClassElementContext;

ClassElementContext.prototype.classRef = function() {
    return this.getTypedRuleContext(ClassRefContext,0);
};

ClassElementContext.prototype.text = function() {
    return this.getTypedRuleContext(TextContext,0);
};

ClassElementContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitClassElement(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ClassElementContext = ClassElementContext;

LscParser.prototype.classElement = function() {

    var localctx = new ClassElementContext(this, this._ctx, this.state);
    this.enterRule(localctx, 6, LscParser.RULE_classElement);
    try {
        this.state = 178;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.CLASSREF:
            this.enterOuterAlt(localctx, 1);
            this.state = 176;
            this.classRef();
            break;
        case LscParser.NAME:
        case LscParser.STR1:
        case LscParser.STR:
            this.enterOuterAlt(localctx, 2);
            this.state = 177;
            this.text();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function FeatureDeclContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_featureDecl;
    return this;
}

FeatureDeclContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FeatureDeclContext.prototype.constructor = FeatureDeclContext;

FeatureDeclContext.prototype.FEATURE_DECL = function() {
    return this.getToken(LscParser.FEATURE_DECL, 0);
};

FeatureDeclContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


FeatureDeclContext.prototype.plusFeature = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(PlusFeatureContext);
    } else {
        return this.getTypedRuleContext(PlusFeatureContext,i);
    }
};

FeatureDeclContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

FeatureDeclContext.prototype.O_PAREN = function() {
    return this.getToken(LscParser.O_PAREN, 0);
};

FeatureDeclContext.prototype.featureValue = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(FeatureValueContext);
    } else {
        return this.getTypedRuleContext(FeatureValueContext,i);
    }
};

FeatureDeclContext.prototype.C_PAREN = function() {
    return this.getToken(LscParser.C_PAREN, 0);
};

FeatureDeclContext.prototype.SEP = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.SEP);
    } else {
        return this.getToken(LscParser.SEP, i);
    }
};


FeatureDeclContext.prototype.nullAlias = function() {
    return this.getTypedRuleContext(NullAliasContext,0);
};

FeatureDeclContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitFeatureDecl(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.FeatureDeclContext = FeatureDeclContext;

LscParser.prototype.featureDecl = function() {

    var localctx = new FeatureDeclContext(this, this._ctx, this.state);
    this.enterRule(localctx, 8, LscParser.RULE_featureDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 180;
        this.match(LscParser.FEATURE_DECL);
        this.state = 181;
        this.match(LscParser.WHITESPACE);
        this.state = 210;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,13,this._ctx);
        switch(la_) {
        case 1:
            this.state = 182;
            this.plusFeature();
            this.state = 187;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while(_la===LscParser.SEP) {
                this.state = 183;
                this.match(LscParser.SEP);
                this.state = 184;
                this.plusFeature();
                this.state = 189;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            }
            break;

        case 2:
            this.state = 190;
            this.name();
            this.state = 192;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(_la===LscParser.WHITESPACE) {
                this.state = 191;
                this.match(LscParser.WHITESPACE);
            }

            this.state = 194;
            this.match(LscParser.O_PAREN);
            this.state = 198;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(_la===LscParser.NULL) {
                this.state = 195;
                this.nullAlias();
                this.state = 196;
                this.match(LscParser.SEP);
            }

            this.state = 200;
            this.featureValue();
            this.state = 205;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while(_la===LscParser.SEP) {
                this.state = 201;
                this.match(LscParser.SEP);
                this.state = 202;
                this.featureValue();
                this.state = 207;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            }
            this.state = 208;
            this.match(LscParser.C_PAREN);
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function PlusFeatureContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_plusFeature;
    return this;
}

PlusFeatureContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
PlusFeatureContext.prototype.constructor = PlusFeatureContext;

PlusFeatureContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

PlusFeatureContext.prototype.AT_LEAST_ONE = function() {
    return this.getToken(LscParser.AT_LEAST_ONE, 0);
};

PlusFeatureContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitPlusFeature(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.PlusFeatureContext = PlusFeatureContext;

LscParser.prototype.plusFeature = function() {

    var localctx = new PlusFeatureContext(this, this._ctx, this.state);
    this.enterRule(localctx, 10, LscParser.RULE_plusFeature);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 213;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.AT_LEAST_ONE) {
            this.state = 212;
            this.match(LscParser.AT_LEAST_ONE);
        }

        this.state = 215;
        this.name();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function NullAliasContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_nullAlias;
    return this;
}

NullAliasContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
NullAliasContext.prototype.constructor = NullAliasContext;

NullAliasContext.prototype.NULL = function() {
    return this.getToken(LscParser.NULL, 0);
};

NullAliasContext.prototype.featureValue = function() {
    return this.getTypedRuleContext(FeatureValueContext,0);
};

NullAliasContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitNullAlias(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.NullAliasContext = NullAliasContext;

LscParser.prototype.nullAlias = function() {

    var localctx = new NullAliasContext(this, this._ctx, this.state);
    this.enterRule(localctx, 12, LscParser.RULE_nullAlias);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 217;
        this.match(LscParser.NULL);
        this.state = 218;
        this.featureValue();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function DiacriticDeclContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_diacriticDecl;
    return this;
}

DiacriticDeclContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
DiacriticDeclContext.prototype.constructor = DiacriticDeclContext;

DiacriticDeclContext.prototype.DIACRITIC = function() {
    return this.getToken(LscParser.DIACRITIC, 0);
};

DiacriticDeclContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


DiacriticDeclContext.prototype.text = function() {
    return this.getTypedRuleContext(TextContext,0);
};

DiacriticDeclContext.prototype.matrix = function() {
    return this.getTypedRuleContext(MatrixContext,0);
};

DiacriticDeclContext.prototype.diacriticModifier = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(DiacriticModifierContext);
    } else {
        return this.getTypedRuleContext(DiacriticModifierContext,i);
    }
};

DiacriticDeclContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitDiacriticDecl(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.DiacriticDeclContext = DiacriticDeclContext;

LscParser.prototype.diacriticDecl = function() {

    var localctx = new DiacriticDeclContext(this, this._ctx, this.state);
    this.enterRule(localctx, 14, LscParser.RULE_diacriticDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 220;
        this.match(LscParser.DIACRITIC);
        this.state = 221;
        this.match(LscParser.WHITESPACE);
        this.state = 222;
        this.text();
        this.state = 223;
        this.match(LscParser.WHITESPACE);
        this.state = 229;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.DIA_BEFORE || _la===LscParser.DIA_FLOATING) {
            this.state = 224;
            this.diacriticModifier();
            this.state = 225;
            this.match(LscParser.WHITESPACE);
            this.state = 231;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 232;
        this.matrix();
        this.state = 237;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.WHITESPACE) {
            this.state = 233;
            this.match(LscParser.WHITESPACE);
            this.state = 234;
            this.diacriticModifier();
            this.state = 239;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function DiacriticModifierContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_diacriticModifier;
    return this;
}

DiacriticModifierContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
DiacriticModifierContext.prototype.constructor = DiacriticModifierContext;

DiacriticModifierContext.prototype.DIA_BEFORE = function() {
    return this.getToken(LscParser.DIA_BEFORE, 0);
};

DiacriticModifierContext.prototype.DIA_FLOATING = function() {
    return this.getToken(LscParser.DIA_FLOATING, 0);
};

DiacriticModifierContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitDiacriticModifier(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.DiacriticModifierContext = DiacriticModifierContext;

LscParser.prototype.diacriticModifier = function() {

    var localctx = new DiacriticModifierContext(this, this._ctx, this.state);
    this.enterRule(localctx, 16, LscParser.RULE_diacriticModifier);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 240;
        _la = this._input.LA(1);
        if(!(_la===LscParser.DIA_BEFORE || _la===LscParser.DIA_FLOATING)) {
        this._errHandler.recoverInline(this);
        }
        else {
        	this._errHandler.reportMatch(this);
            this.consume();
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function SymbolDeclContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_symbolDecl;
    return this;
}

SymbolDeclContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SymbolDeclContext.prototype.constructor = SymbolDeclContext;

SymbolDeclContext.prototype.SYMBOL = function() {
    return this.getToken(LscParser.SYMBOL, 0);
};

SymbolDeclContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


SymbolDeclContext.prototype.symbolName = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(SymbolNameContext);
    } else {
        return this.getTypedRuleContext(SymbolNameContext,i);
    }
};

SymbolDeclContext.prototype.matrix = function() {
    return this.getTypedRuleContext(MatrixContext,0);
};

SymbolDeclContext.prototype.SEP = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.SEP);
    } else {
        return this.getToken(LscParser.SEP, i);
    }
};


SymbolDeclContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitSymbolDecl(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.SymbolDeclContext = SymbolDeclContext;

LscParser.prototype.symbolDecl = function() {

    var localctx = new SymbolDeclContext(this, this._ctx, this.state);
    this.enterRule(localctx, 18, LscParser.RULE_symbolDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 242;
        this.match(LscParser.SYMBOL);
        this.state = 243;
        this.match(LscParser.WHITESPACE);
        this.state = 244;
        this.symbolName();
        this.state = 254;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.EOF:
        case LscParser.SEP:
        case LscParser.NEWLINE:
            this.state = 249;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while(_la===LscParser.SEP) {
                this.state = 245;
                this.match(LscParser.SEP);
                this.state = 246;
                this.symbolName();
                this.state = 251;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            }
            break;
        case LscParser.WHITESPACE:
            this.state = 252;
            this.match(LscParser.WHITESPACE);
            this.state = 253;
            this.matrix();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function SymbolNameContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_symbolName;
    return this;
}

SymbolNameContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SymbolNameContext.prototype.constructor = SymbolNameContext;

SymbolNameContext.prototype.text = function() {
    return this.getTypedRuleContext(TextContext,0);
};

SymbolNameContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitSymbolName(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.SymbolNameContext = SymbolNameContext;

LscParser.prototype.symbolName = function() {

    var localctx = new SymbolNameContext(this, this._ctx, this.state);
    this.enterRule(localctx, 20, LscParser.RULE_symbolName);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 256;
        this.text();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function SyllableDeclContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_syllableDecl;
    return this;
}

SyllableDeclContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SyllableDeclContext.prototype.constructor = SyllableDeclContext;

SyllableDeclContext.prototype.SYLLABLE_DECL = function() {
    return this.getToken(LscParser.SYLLABLE_DECL, 0);
};

SyllableDeclContext.prototype.RULE_START = function() {
    return this.getToken(LscParser.RULE_START, 0);
};

SyllableDeclContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


SyllableDeclContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitSyllableDecl(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.SyllableDeclContext = SyllableDeclContext;

LscParser.prototype.syllableDecl = function() {

    var localctx = new SyllableDeclContext(this, this._ctx, this.state);
    this.enterRule(localctx, 22, LscParser.RULE_syllableDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 258;
        this.match(LscParser.SYLLABLE_DECL);
        this.state = 259;
        this.match(LscParser.RULE_START);
        this.state = 261; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 260;
            this.match(LscParser.NEWLINE);
            this.state = 263; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LscParser.NEWLINE);
        this.state = 265;
        this.match(LscParser.T__0);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function DeromanizerContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_deromanizer;
    return this;
}

DeromanizerContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
DeromanizerContext.prototype.constructor = DeromanizerContext;

DeromanizerContext.prototype.DEROMANIZER = function() {
    return this.getToken(LscParser.DEROMANIZER, 0);
};

DeromanizerContext.prototype.RULE_START = function() {
    return this.getToken(LscParser.RULE_START, 0);
};

DeromanizerContext.prototype.block = function() {
    return this.getTypedRuleContext(BlockContext,0);
};

DeromanizerContext.prototype.WHITESPACE = function() {
    return this.getToken(LscParser.WHITESPACE, 0);
};

DeromanizerContext.prototype.LITERAL = function() {
    return this.getToken(LscParser.LITERAL, 0);
};

DeromanizerContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


DeromanizerContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitDeromanizer(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.DeromanizerContext = DeromanizerContext;

LscParser.prototype.deromanizer = function() {

    var localctx = new DeromanizerContext(this, this._ctx, this.state);
    this.enterRule(localctx, 24, LscParser.RULE_deromanizer);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 267;
        this.match(LscParser.DEROMANIZER);
        this.state = 270;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.WHITESPACE) {
            this.state = 268;
            this.match(LscParser.WHITESPACE);
            this.state = 269;
            this.match(LscParser.LITERAL);
        }

        this.state = 272;
        this.match(LscParser.RULE_START);
        this.state = 274; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 273;
            this.match(LscParser.NEWLINE);
            this.state = 276; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LscParser.NEWLINE);
        this.state = 278;
        this.block();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function RomanizerContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_romanizer;
    return this;
}

RomanizerContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
RomanizerContext.prototype.constructor = RomanizerContext;

RomanizerContext.prototype.ROMANIZER = function() {
    return this.getToken(LscParser.ROMANIZER, 0);
};

RomanizerContext.prototype.RULE_START = function() {
    return this.getToken(LscParser.RULE_START, 0);
};

RomanizerContext.prototype.block = function() {
    return this.getTypedRuleContext(BlockContext,0);
};

RomanizerContext.prototype.WHITESPACE = function() {
    return this.getToken(LscParser.WHITESPACE, 0);
};

RomanizerContext.prototype.LITERAL = function() {
    return this.getToken(LscParser.LITERAL, 0);
};

RomanizerContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


RomanizerContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitRomanizer(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.RomanizerContext = RomanizerContext;

LscParser.prototype.romanizer = function() {

    var localctx = new RomanizerContext(this, this._ctx, this.state);
    this.enterRule(localctx, 26, LscParser.RULE_romanizer);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 280;
        this.match(LscParser.ROMANIZER);
        this.state = 283;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.WHITESPACE) {
            this.state = 281;
            this.match(LscParser.WHITESPACE);
            this.state = 282;
            this.match(LscParser.LITERAL);
        }

        this.state = 285;
        this.match(LscParser.RULE_START);
        this.state = 287; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 286;
            this.match(LscParser.NEWLINE);
            this.state = 289; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LscParser.NEWLINE);
        this.state = 291;
        this.block();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function InterRomanizerContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_interRomanizer;
    return this;
}

InterRomanizerContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
InterRomanizerContext.prototype.constructor = InterRomanizerContext;

InterRomanizerContext.prototype.ROMANIZER = function() {
    return this.getToken(LscParser.ROMANIZER, 0);
};

InterRomanizerContext.prototype.HYPHEN = function() {
    return this.getToken(LscParser.HYPHEN, 0);
};

InterRomanizerContext.prototype.ruleName = function() {
    return this.getTypedRuleContext(RuleNameContext,0);
};

InterRomanizerContext.prototype.RULE_START = function() {
    return this.getToken(LscParser.RULE_START, 0);
};

InterRomanizerContext.prototype.block = function() {
    return this.getTypedRuleContext(BlockContext,0);
};

InterRomanizerContext.prototype.WHITESPACE = function() {
    return this.getToken(LscParser.WHITESPACE, 0);
};

InterRomanizerContext.prototype.LITERAL = function() {
    return this.getToken(LscParser.LITERAL, 0);
};

InterRomanizerContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


InterRomanizerContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitInterRomanizer(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.InterRomanizerContext = InterRomanizerContext;

LscParser.prototype.interRomanizer = function() {

    var localctx = new InterRomanizerContext(this, this._ctx, this.state);
    this.enterRule(localctx, 28, LscParser.RULE_interRomanizer);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 293;
        this.match(LscParser.ROMANIZER);
        this.state = 294;
        this.match(LscParser.HYPHEN);
        this.state = 295;
        this.ruleName();
        this.state = 298;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.WHITESPACE) {
            this.state = 296;
            this.match(LscParser.WHITESPACE);
            this.state = 297;
            this.match(LscParser.LITERAL);
        }

        this.state = 300;
        this.match(LscParser.RULE_START);
        this.state = 302; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 301;
            this.match(LscParser.NEWLINE);
            this.state = 304; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LscParser.NEWLINE);
        this.state = 306;
        this.block();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ChangeRuleContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_changeRule;
    return this;
}

ChangeRuleContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ChangeRuleContext.prototype.constructor = ChangeRuleContext;

ChangeRuleContext.prototype.ruleName = function() {
    return this.getTypedRuleContext(RuleNameContext,0);
};

ChangeRuleContext.prototype.block = function() {
    return this.getTypedRuleContext(BlockContext,0);
};

ChangeRuleContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


ChangeRuleContext.prototype.changeRuleModifier = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ChangeRuleModifierContext);
    } else {
        return this.getTypedRuleContext(ChangeRuleModifierContext,i);
    }
};

ChangeRuleContext.prototype.RULE_START = function() {
    return this.getToken(LscParser.RULE_START, 0);
};

ChangeRuleContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


ChangeRuleContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitChangeRule(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ChangeRuleContext = ChangeRuleContext;

LscParser.prototype.changeRule = function() {

    var localctx = new ChangeRuleContext(this, this._ctx, this.state);
    this.enterRule(localctx, 30, LscParser.RULE_changeRule);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 308;
        this.ruleName();
        this.state = 313;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.WHITESPACE) {
            this.state = 309;
            this.match(LscParser.WHITESPACE);
            this.state = 310;
            this.changeRuleModifier();
            this.state = 315;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 317;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.RULE_START) {
            this.state = 316;
            this.match(LscParser.RULE_START);
        }

        this.state = 320; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 319;
            this.match(LscParser.NEWLINE);
            this.state = 322; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LscParser.NEWLINE);
        this.state = 324;
        this.block();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ChangeRuleModifierContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_changeRuleModifier;
    return this;
}

ChangeRuleModifierContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ChangeRuleModifierContext.prototype.constructor = ChangeRuleModifierContext;

ChangeRuleModifierContext.prototype.filter = function() {
    return this.getTypedRuleContext(FilterContext,0);
};

ChangeRuleModifierContext.prototype.PROPAGATE = function() {
    return this.getToken(LscParser.PROPAGATE, 0);
};

ChangeRuleModifierContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitChangeRuleModifier(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ChangeRuleModifierContext = ChangeRuleModifierContext;

LscParser.prototype.changeRuleModifier = function() {

    var localctx = new ChangeRuleModifierContext(this, this._ctx, this.state);
    this.enterRule(localctx, 32, LscParser.RULE_changeRuleModifier);
    try {
        this.state = 328;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.MATRIX_START:
        case LscParser.CLASSREF:
            this.enterOuterAlt(localctx, 1);
            this.state = 326;
            this.filter();
            break;
        case LscParser.PROPAGATE:
            this.enterOuterAlt(localctx, 2);
            this.state = 327;
            this.match(LscParser.PROPAGATE);
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function FilterContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_filter;
    return this;
}

FilterContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FilterContext.prototype.constructor = FilterContext;

FilterContext.prototype.classRef = function() {
    return this.getTypedRuleContext(ClassRefContext,0);
};

FilterContext.prototype.fancyMatrix = function() {
    return this.getTypedRuleContext(FancyMatrixContext,0);
};

FilterContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitFilter(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.FilterContext = FilterContext;

LscParser.prototype.filter = function() {

    var localctx = new FilterContext(this, this._ctx, this.state);
    this.enterRule(localctx, 34, LscParser.RULE_filter);
    try {
        this.state = 332;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.CLASSREF:
            this.enterOuterAlt(localctx, 1);
            this.state = 330;
            this.classRef();
            break;
        case LscParser.MATRIX_START:
            this.enterOuterAlt(localctx, 2);
            this.state = 331;
            this.fancyMatrix();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function BlockContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_block;
    return this;
}

BlockContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
BlockContext.prototype.constructor = BlockContext;

BlockContext.prototype.blockElement = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(BlockElementContext);
    } else {
        return this.getTypedRuleContext(BlockElementContext,i);
    }
};

BlockContext.prototype.blockType = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(BlockTypeContext);
    } else {
        return this.getTypedRuleContext(BlockTypeContext,i);
    }
};

BlockContext.prototype.RULE_START = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.RULE_START);
    } else {
        return this.getToken(LscParser.RULE_START, i);
    }
};


BlockContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


BlockContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


BlockContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitBlock(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.BlockContext = BlockContext;

LscParser.prototype.block = function() {

    var localctx = new BlockContext(this, this._ctx, this.state);
    this.enterRule(localctx, 36, LscParser.RULE_block);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 334;
        this.blockElement();
        this.state = 354;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,34,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                this.state = 336; 
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                do {
                    this.state = 335;
                    this.match(LscParser.NEWLINE);
                    this.state = 338; 
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                } while(_la===LscParser.NEWLINE);
                this.state = 340;
                this.blockType();
                this.state = 341;
                this.match(LscParser.RULE_START);
                this.state = 348;
                this._errHandler.sync(this);
                switch(this._input.LA(1)) {
                case LscParser.WHITESPACE:
                    this.state = 342;
                    this.match(LscParser.WHITESPACE);
                    break;
                case LscParser.NEWLINE:
                    this.state = 344; 
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                    do {
                        this.state = 343;
                        this.match(LscParser.NEWLINE);
                        this.state = 346; 
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                    } while(_la===LscParser.NEWLINE);
                    break;
                default:
                    throw new antlr4.error.NoViableAltException(this);
                }
                this.state = 350;
                this.blockElement(); 
            }
            this.state = 356;
            this._errHandler.sync(this);
            _alt = this._interp.adaptivePredict(this._input,34,this._ctx);
        }

    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function BlockElementContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_blockElement;
    return this;
}

BlockElementContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
BlockElementContext.prototype.constructor = BlockElementContext;

BlockElementContext.prototype.expressionList = function() {
    return this.getTypedRuleContext(ExpressionListContext,0);
};

BlockElementContext.prototype.O_PAREN = function() {
    return this.getToken(LscParser.O_PAREN, 0);
};

BlockElementContext.prototype.block = function() {
    return this.getTypedRuleContext(BlockContext,0);
};

BlockElementContext.prototype.C_PAREN = function() {
    return this.getToken(LscParser.C_PAREN, 0);
};

BlockElementContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


BlockElementContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitBlockElement(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.BlockElementContext = BlockElementContext;

LscParser.prototype.blockElement = function() {

    var localctx = new BlockElementContext(this, this._ctx, this.state);
    this.enterRule(localctx, 38, LscParser.RULE_blockElement);
    var _la = 0; // Token type
    try {
        this.state = 374;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,37,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 357;
            this.expressionList();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 358;
            this.match(LscParser.O_PAREN);
            this.state = 362;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while(_la===LscParser.NEWLINE) {
                this.state = 359;
                this.match(LscParser.NEWLINE);
                this.state = 364;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            }
            this.state = 365;
            this.block();
            this.state = 369;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while(_la===LscParser.NEWLINE) {
                this.state = 366;
                this.match(LscParser.NEWLINE);
                this.state = 371;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            }
            this.state = 372;
            this.match(LscParser.C_PAREN);
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function BlockTypeContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_blockType;
    return this;
}

BlockTypeContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
BlockTypeContext.prototype.constructor = BlockTypeContext;

BlockTypeContext.prototype.ALL_MATCHING = function() {
    return this.getToken(LscParser.ALL_MATCHING, 0);
};

BlockTypeContext.prototype.FIRST_MATCHING = function() {
    return this.getToken(LscParser.FIRST_MATCHING, 0);
};

BlockTypeContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitBlockType(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.BlockTypeContext = BlockTypeContext;

LscParser.prototype.blockType = function() {

    var localctx = new BlockTypeContext(this, this._ctx, this.state);
    this.enterRule(localctx, 40, LscParser.RULE_blockType);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 376;
        _la = this._input.LA(1);
        if(!(_la===LscParser.ALL_MATCHING || _la===LscParser.FIRST_MATCHING)) {
        this._errHandler.recoverInline(this);
        }
        else {
        	this._errHandler.reportMatch(this);
            this.consume();
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ExpressionListContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_expressionList;
    return this;
}

ExpressionListContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ExpressionListContext.prototype.constructor = ExpressionListContext;

ExpressionListContext.prototype.expression = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ExpressionContext);
    } else {
        return this.getTypedRuleContext(ExpressionContext,i);
    }
};

ExpressionListContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


ExpressionListContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitExpressionList(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ExpressionListContext = ExpressionListContext;

LscParser.prototype.expressionList = function() {

    var localctx = new ExpressionListContext(this, this._ctx, this.state);
    this.enterRule(localctx, 42, LscParser.RULE_expressionList);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 378;
        this.expression();
        this.state = 387;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,39,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                this.state = 380; 
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                do {
                    this.state = 379;
                    this.match(LscParser.NEWLINE);
                    this.state = 382; 
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                } while(_la===LscParser.NEWLINE);
                this.state = 384;
                this.expression(); 
            }
            this.state = 389;
            this._errHandler.sync(this);
            _alt = this._interp.adaptivePredict(this._input,39,this._ctx);
        }

    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function RuleNameContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_ruleName;
    return this;
}

RuleNameContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
RuleNameContext.prototype.constructor = RuleNameContext;

RuleNameContext.prototype.NAME = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NAME);
    } else {
        return this.getToken(LscParser.NAME, i);
    }
};


RuleNameContext.prototype.HYPHEN = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.HYPHEN);
    } else {
        return this.getToken(LscParser.HYPHEN, i);
    }
};


RuleNameContext.prototype.NUMBER = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NUMBER);
    } else {
        return this.getToken(LscParser.NUMBER, i);
    }
};


RuleNameContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitRuleName(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.RuleNameContext = RuleNameContext;

LscParser.prototype.ruleName = function() {

    var localctx = new RuleNameContext(this, this._ctx, this.state);
    this.enterRule(localctx, 44, LscParser.RULE_ruleName);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 390;
        this.match(LscParser.NAME);
        this.state = 395;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.HYPHEN) {
            this.state = 391;
            this.match(LscParser.HYPHEN);
            this.state = 392;
            _la = this._input.LA(1);
            if(!(_la===LscParser.NUMBER || _la===LscParser.NAME)) {
            this._errHandler.recoverInline(this);
            }
            else {
            	this._errHandler.reportMatch(this);
                this.consume();
            }
            this.state = 397;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ExpressionContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_expression;
    return this;
}

ExpressionContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ExpressionContext.prototype.constructor = ExpressionContext;

ExpressionContext.prototype.UNCHANGED = function() {
    return this.getToken(LscParser.UNCHANGED, 0);
};

ExpressionContext.prototype.from = function() {
    return this.getTypedRuleContext(FromContext,0);
};

ExpressionContext.prototype.CHANGE = function() {
    return this.getToken(LscParser.CHANGE, 0);
};

ExpressionContext.prototype.to = function() {
    return this.getTypedRuleContext(ToContext,0);
};

ExpressionContext.prototype.CONDITION = function() {
    return this.getToken(LscParser.CONDITION, 0);
};

ExpressionContext.prototype.condition = function() {
    return this.getTypedRuleContext(ConditionContext,0);
};

ExpressionContext.prototype.EXCLUSION = function() {
    return this.getToken(LscParser.EXCLUSION, 0);
};

ExpressionContext.prototype.exclusion = function() {
    return this.getTypedRuleContext(ExclusionContext,0);
};

ExpressionContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitExpression(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ExpressionContext = ExpressionContext;

LscParser.prototype.expression = function() {

    var localctx = new ExpressionContext(this, this._ctx, this.state);
    this.enterRule(localctx, 46, LscParser.RULE_expression);
    var _la = 0; // Token type
    try {
        this.state = 410;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.UNCHANGED:
            this.enterOuterAlt(localctx, 1);
            this.state = 398;
            this.match(LscParser.UNCHANGED);
            break;
        case LscParser.O_PAREN:
        case LscParser.NULL:
        case LscParser.MATRIX_START:
        case LscParser.LIST_START:
        case LscParser.NEGATION:
        case LscParser.WORD_BOUNDARY:
        case LscParser.BETWEEN_WORDS:
        case LscParser.CLASSREF:
        case LscParser.NAME:
        case LscParser.STR1:
        case LscParser.STR:
            this.enterOuterAlt(localctx, 2);
            this.state = 399;
            this.from();
            this.state = 400;
            this.match(LscParser.CHANGE);
            this.state = 401;
            this.to();
            this.state = 404;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(_la===LscParser.CONDITION) {
                this.state = 402;
                this.match(LscParser.CONDITION);
                this.state = 403;
                this.condition();
            }

            this.state = 408;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(_la===LscParser.EXCLUSION) {
                this.state = 406;
                this.match(LscParser.EXCLUSION);
                this.state = 407;
                this.exclusion();
            }

            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ConditionContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_condition;
    return this;
}

ConditionContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ConditionContext.prototype.constructor = ConditionContext;

ConditionContext.prototype.environment = function() {
    return this.getTypedRuleContext(EnvironmentContext,0);
};

ConditionContext.prototype.environmentList = function() {
    return this.getTypedRuleContext(EnvironmentListContext,0);
};

ConditionContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitCondition(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ConditionContext = ConditionContext;

LscParser.prototype.condition = function() {

    var localctx = new ConditionContext(this, this._ctx, this.state);
    this.enterRule(localctx, 48, LscParser.RULE_condition);
    try {
        this.state = 414;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,44,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 412;
            this.environment();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 413;
            this.environmentList();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ExclusionContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_exclusion;
    return this;
}

ExclusionContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ExclusionContext.prototype.constructor = ExclusionContext;

ExclusionContext.prototype.environment = function() {
    return this.getTypedRuleContext(EnvironmentContext,0);
};

ExclusionContext.prototype.environmentList = function() {
    return this.getTypedRuleContext(EnvironmentListContext,0);
};

ExclusionContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitExclusion(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ExclusionContext = ExclusionContext;

LscParser.prototype.exclusion = function() {

    var localctx = new ExclusionContext(this, this._ctx, this.state);
    this.enterRule(localctx, 50, LscParser.RULE_exclusion);
    try {
        this.state = 418;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,45,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 416;
            this.environment();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 417;
            this.environmentList();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function FromContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_from;
    return this;
}

FromContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FromContext.prototype.constructor = FromContext;

FromContext.prototype.ruleElement = function() {
    return this.getTypedRuleContext(RuleElementContext,0);
};

FromContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitFrom(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.FromContext = FromContext;

LscParser.prototype.from = function() {

    var localctx = new FromContext(this, this._ctx, this.state);
    this.enterRule(localctx, 52, LscParser.RULE_from);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 420;
        this.ruleElement();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ToContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_to;
    return this;
}

ToContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ToContext.prototype.constructor = ToContext;

ToContext.prototype.ruleElement = function() {
    return this.getTypedRuleContext(RuleElementContext,0);
};

ToContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitTo(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ToContext = ToContext;

LscParser.prototype.to = function() {

    var localctx = new ToContext(this, this._ctx, this.state);
    this.enterRule(localctx, 54, LscParser.RULE_to);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 422;
        this.ruleElement();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function EnvironmentListContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_environmentList;
    return this;
}

EnvironmentListContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
EnvironmentListContext.prototype.constructor = EnvironmentListContext;

EnvironmentListContext.prototype.LIST_START = function() {
    return this.getToken(LscParser.LIST_START, 0);
};

EnvironmentListContext.prototype.environment = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(EnvironmentContext);
    } else {
        return this.getTypedRuleContext(EnvironmentContext,i);
    }
};

EnvironmentListContext.prototype.LIST_END = function() {
    return this.getToken(LscParser.LIST_END, 0);
};

EnvironmentListContext.prototype.SEP = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.SEP);
    } else {
        return this.getToken(LscParser.SEP, i);
    }
};


EnvironmentListContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitEnvironmentList(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.EnvironmentListContext = EnvironmentListContext;

LscParser.prototype.environmentList = function() {

    var localctx = new EnvironmentListContext(this, this._ctx, this.state);
    this.enterRule(localctx, 56, LscParser.RULE_environmentList);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 424;
        this.match(LscParser.LIST_START);
        this.state = 425;
        this.environment();
        this.state = 430;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 426;
            this.match(LscParser.SEP);
            this.state = 427;
            this.environment();
            this.state = 432;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 433;
        this.match(LscParser.LIST_END);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function EnvironmentContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_environment;
    return this;
}

EnvironmentContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
EnvironmentContext.prototype.constructor = EnvironmentContext;

EnvironmentContext.prototype.ANCHOR = function() {
    return this.getToken(LscParser.ANCHOR, 0);
};

EnvironmentContext.prototype.environmentBefore = function() {
    return this.getTypedRuleContext(EnvironmentBeforeContext,0);
};

EnvironmentContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


EnvironmentContext.prototype.environmentAfter = function() {
    return this.getTypedRuleContext(EnvironmentAfterContext,0);
};

EnvironmentContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitEnvironment(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.EnvironmentContext = EnvironmentContext;

LscParser.prototype.environment = function() {

    var localctx = new EnvironmentContext(this, this._ctx, this.state);
    this.enterRule(localctx, 58, LscParser.RULE_environment);
    var _la = 0; // Token type
    try {
        this.state = 448;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,50,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 438;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << LscParser.O_PAREN) | (1 << LscParser.NULL) | (1 << LscParser.MATRIX_START) | (1 << LscParser.LIST_START) | (1 << LscParser.NEGATION) | (1 << LscParser.WORD_BOUNDARY) | (1 << LscParser.BETWEEN_WORDS) | (1 << LscParser.CLASSREF))) !== 0) || ((((_la - 41)) & ~0x1f) == 0 && ((1 << (_la - 41)) & ((1 << (LscParser.NAME - 41)) | (1 << (LscParser.STR1 - 41)) | (1 << (LscParser.STR - 41)))) !== 0)) {
                this.state = 435;
                this.environmentBefore();
                this.state = 436;
                this.match(LscParser.WHITESPACE);
            }

            this.state = 440;
            this.match(LscParser.ANCHOR);
            this.state = 443;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(_la===LscParser.WHITESPACE) {
                this.state = 441;
                this.match(LscParser.WHITESPACE);
                this.state = 442;
                this.environmentAfter();
            }

            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 446;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << LscParser.O_PAREN) | (1 << LscParser.NULL) | (1 << LscParser.MATRIX_START) | (1 << LscParser.LIST_START) | (1 << LscParser.NEGATION) | (1 << LscParser.WORD_BOUNDARY) | (1 << LscParser.BETWEEN_WORDS) | (1 << LscParser.CLASSREF))) !== 0) || ((((_la - 41)) & ~0x1f) == 0 && ((1 << (_la - 41)) & ((1 << (LscParser.NAME - 41)) | (1 << (LscParser.STR1 - 41)) | (1 << (LscParser.STR - 41)))) !== 0)) {
                this.state = 445;
                this.environmentBefore();
            }

            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function EnvironmentBeforeContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_environmentBefore;
    return this;
}

EnvironmentBeforeContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
EnvironmentBeforeContext.prototype.constructor = EnvironmentBeforeContext;

EnvironmentBeforeContext.prototype.ruleElement = function() {
    return this.getTypedRuleContext(RuleElementContext,0);
};

EnvironmentBeforeContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitEnvironmentBefore(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.EnvironmentBeforeContext = EnvironmentBeforeContext;

LscParser.prototype.environmentBefore = function() {

    var localctx = new EnvironmentBeforeContext(this, this._ctx, this.state);
    this.enterRule(localctx, 60, LscParser.RULE_environmentBefore);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 450;
        this.ruleElement();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function EnvironmentAfterContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_environmentAfter;
    return this;
}

EnvironmentAfterContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
EnvironmentAfterContext.prototype.constructor = EnvironmentAfterContext;

EnvironmentAfterContext.prototype.ruleElement = function() {
    return this.getTypedRuleContext(RuleElementContext,0);
};

EnvironmentAfterContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitEnvironmentAfter(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.EnvironmentAfterContext = EnvironmentAfterContext;

LscParser.prototype.environmentAfter = function() {

    var localctx = new EnvironmentAfterContext(this, this._ctx, this.state);
    this.enterRule(localctx, 62, LscParser.RULE_environmentAfter);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 452;
        this.ruleElement();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function RuleElementContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_ruleElement;
    return this;
}

RuleElementContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
RuleElementContext.prototype.constructor = RuleElementContext;

RuleElementContext.prototype.capture = function() {
    return this.getTypedRuleContext(CaptureContext,0);
};

RuleElementContext.prototype.repeater = function() {
    return this.getTypedRuleContext(RepeaterContext,0);
};

RuleElementContext.prototype.group = function() {
    return this.getTypedRuleContext(GroupContext,0);
};

RuleElementContext.prototype.list = function() {
    return this.getTypedRuleContext(ListContext,0);
};

RuleElementContext.prototype.intersection = function() {
    return this.getTypedRuleContext(IntersectionContext,0);
};

RuleElementContext.prototype.simple = function() {
    return this.getTypedRuleContext(SimpleContext,0);
};

RuleElementContext.prototype.sequence = function() {
    return this.getTypedRuleContext(SequenceContext,0);
};

RuleElementContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitRuleElement(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.RuleElementContext = RuleElementContext;

LscParser.prototype.ruleElement = function() {

    var localctx = new RuleElementContext(this, this._ctx, this.state);
    this.enterRule(localctx, 64, LscParser.RULE_ruleElement);
    try {
        this.state = 461;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,51,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 454;
            this.capture();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 455;
            this.repeater();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 456;
            this.group();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 457;
            this.list();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 458;
            this.intersection();
            break;

        case 6:
            this.enterOuterAlt(localctx, 6);
            this.state = 459;
            this.simple();
            break;

        case 7:
            this.enterOuterAlt(localctx, 7);
            this.state = 460;
            this.sequence();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function SequenceContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_sequence;
    return this;
}

SequenceContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SequenceContext.prototype.constructor = SequenceContext;

SequenceContext.prototype.sequenceElement = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(SequenceElementContext);
    } else {
        return this.getTypedRuleContext(SequenceElementContext,i);
    }
};

SequenceContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


SequenceContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitSequence(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.SequenceContext = SequenceContext;

LscParser.prototype.sequence = function() {

    var localctx = new SequenceContext(this, this._ctx, this.state);
    this.enterRule(localctx, 66, LscParser.RULE_sequence);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 463;
        this.sequenceElement();
        this.state = 466; 
        this._errHandler.sync(this);
        var _alt = 1;
        do {
        	switch (_alt) {
        	case 1:
        		this.state = 464;
        		this.match(LscParser.WHITESPACE);
        		this.state = 465;
        		this.sequenceElement();
        		break;
        	default:
        		throw new antlr4.error.NoViableAltException(this);
        	}
        	this.state = 468; 
        	this._errHandler.sync(this);
        	_alt = this._interp.adaptivePredict(this._input,52, this._ctx);
        } while ( _alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER );
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function SequenceElementContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_sequenceElement;
    return this;
}

SequenceElementContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SequenceElementContext.prototype.constructor = SequenceElementContext;

SequenceElementContext.prototype.capture = function() {
    return this.getTypedRuleContext(CaptureContext,0);
};

SequenceElementContext.prototype.repeater = function() {
    return this.getTypedRuleContext(RepeaterContext,0);
};

SequenceElementContext.prototype.group = function() {
    return this.getTypedRuleContext(GroupContext,0);
};

SequenceElementContext.prototype.list = function() {
    return this.getTypedRuleContext(ListContext,0);
};

SequenceElementContext.prototype.intersection = function() {
    return this.getTypedRuleContext(IntersectionContext,0);
};

SequenceElementContext.prototype.simple = function() {
    return this.getTypedRuleContext(SimpleContext,0);
};

SequenceElementContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitSequenceElement(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.SequenceElementContext = SequenceElementContext;

LscParser.prototype.sequenceElement = function() {

    var localctx = new SequenceElementContext(this, this._ctx, this.state);
    this.enterRule(localctx, 68, LscParser.RULE_sequenceElement);
    try {
        this.state = 476;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,53,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 470;
            this.capture();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 471;
            this.repeater();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 472;
            this.group();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 473;
            this.list();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 474;
            this.intersection();
            break;

        case 6:
            this.enterOuterAlt(localctx, 6);
            this.state = 475;
            this.simple();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function CaptureContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_capture;
    return this;
}

CaptureContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
CaptureContext.prototype.constructor = CaptureContext;

CaptureContext.prototype.captureRef = function() {
    return this.getTypedRuleContext(CaptureRefContext,0);
};

CaptureContext.prototype.group = function() {
    return this.getTypedRuleContext(GroupContext,0);
};

CaptureContext.prototype.list = function() {
    return this.getTypedRuleContext(ListContext,0);
};

CaptureContext.prototype.negated = function() {
    return this.getTypedRuleContext(NegatedContext,0);
};

CaptureContext.prototype.classRef = function() {
    return this.getTypedRuleContext(ClassRefContext,0);
};

CaptureContext.prototype.fancyMatrix = function() {
    return this.getTypedRuleContext(FancyMatrixContext,0);
};

CaptureContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitCapture(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.CaptureContext = CaptureContext;

LscParser.prototype.capture = function() {

    var localctx = new CaptureContext(this, this._ctx, this.state);
    this.enterRule(localctx, 70, LscParser.RULE_capture);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 483;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.O_PAREN:
            this.state = 478;
            this.group();
            break;
        case LscParser.LIST_START:
            this.state = 479;
            this.list();
            break;
        case LscParser.NEGATION:
            this.state = 480;
            this.negated();
            break;
        case LscParser.CLASSREF:
            this.state = 481;
            this.classRef();
            break;
        case LscParser.MATRIX_START:
            this.state = 482;
            this.fancyMatrix();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
        this.state = 485;
        this.captureRef();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function RepeaterContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_repeater;
    return this;
}

RepeaterContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
RepeaterContext.prototype.constructor = RepeaterContext;

RepeaterContext.prototype.repeaterType = function() {
    return this.getTypedRuleContext(RepeaterTypeContext,0);
};

RepeaterContext.prototype.group = function() {
    return this.getTypedRuleContext(GroupContext,0);
};

RepeaterContext.prototype.list = function() {
    return this.getTypedRuleContext(ListContext,0);
};

RepeaterContext.prototype.simple = function() {
    return this.getTypedRuleContext(SimpleContext,0);
};

RepeaterContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitRepeater(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.RepeaterContext = RepeaterContext;

LscParser.prototype.repeater = function() {

    var localctx = new RepeaterContext(this, this._ctx, this.state);
    this.enterRule(localctx, 72, LscParser.RULE_repeater);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 490;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.O_PAREN:
            this.state = 487;
            this.group();
            break;
        case LscParser.LIST_START:
            this.state = 488;
            this.list();
            break;
        case LscParser.NULL:
        case LscParser.MATRIX_START:
        case LscParser.NEGATION:
        case LscParser.WORD_BOUNDARY:
        case LscParser.BETWEEN_WORDS:
        case LscParser.CLASSREF:
        case LscParser.NAME:
        case LscParser.STR1:
        case LscParser.STR:
            this.state = 489;
            this.simple();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
        this.state = 492;
        this.repeaterType();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function GroupContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_group;
    return this;
}

GroupContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
GroupContext.prototype.constructor = GroupContext;

GroupContext.prototype.O_PAREN = function() {
    return this.getToken(LscParser.O_PAREN, 0);
};

GroupContext.prototype.ruleElement = function() {
    return this.getTypedRuleContext(RuleElementContext,0);
};

GroupContext.prototype.C_PAREN = function() {
    return this.getToken(LscParser.C_PAREN, 0);
};

GroupContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitGroup(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.GroupContext = GroupContext;

LscParser.prototype.group = function() {

    var localctx = new GroupContext(this, this._ctx, this.state);
    this.enterRule(localctx, 74, LscParser.RULE_group);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 494;
        this.match(LscParser.O_PAREN);
        this.state = 495;
        this.ruleElement();
        this.state = 496;
        this.match(LscParser.C_PAREN);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ListContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_list;
    return this;
}

ListContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ListContext.prototype.constructor = ListContext;

ListContext.prototype.LIST_START = function() {
    return this.getToken(LscParser.LIST_START, 0);
};

ListContext.prototype.ruleElement = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(RuleElementContext);
    } else {
        return this.getTypedRuleContext(RuleElementContext,i);
    }
};

ListContext.prototype.LIST_END = function() {
    return this.getToken(LscParser.LIST_END, 0);
};

ListContext.prototype.SEP = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.SEP);
    } else {
        return this.getToken(LscParser.SEP, i);
    }
};


ListContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitList(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ListContext = ListContext;

LscParser.prototype.list = function() {

    var localctx = new ListContext(this, this._ctx, this.state);
    this.enterRule(localctx, 76, LscParser.RULE_list);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 498;
        this.match(LscParser.LIST_START);
        this.state = 499;
        this.ruleElement();
        this.state = 504;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 500;
            this.match(LscParser.SEP);
            this.state = 501;
            this.ruleElement();
            this.state = 506;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 507;
        this.match(LscParser.LIST_END);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function IntersectionContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_intersection;
    return this;
}

IntersectionContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
IntersectionContext.prototype.constructor = IntersectionContext;

IntersectionContext.prototype.intersectionElement = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(IntersectionElementContext);
    } else {
        return this.getTypedRuleContext(IntersectionElementContext,i);
    }
};

IntersectionContext.prototype.INTERSECTION = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.INTERSECTION);
    } else {
        return this.getToken(LscParser.INTERSECTION, i);
    }
};


IntersectionContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitIntersection(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.IntersectionContext = IntersectionContext;

LscParser.prototype.intersection = function() {

    var localctx = new IntersectionContext(this, this._ctx, this.state);
    this.enterRule(localctx, 78, LscParser.RULE_intersection);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 509;
        this.intersectionElement();
        this.state = 512; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 510;
            this.match(LscParser.INTERSECTION);
            this.state = 511;
            this.intersectionElement();
            this.state = 514; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LscParser.INTERSECTION);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function IntersectionElementContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_intersectionElement;
    return this;
}

IntersectionElementContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
IntersectionElementContext.prototype.constructor = IntersectionElementContext;

IntersectionElementContext.prototype.capture = function() {
    return this.getTypedRuleContext(CaptureContext,0);
};

IntersectionElementContext.prototype.repeater = function() {
    return this.getTypedRuleContext(RepeaterContext,0);
};

IntersectionElementContext.prototype.group = function() {
    return this.getTypedRuleContext(GroupContext,0);
};

IntersectionElementContext.prototype.list = function() {
    return this.getTypedRuleContext(ListContext,0);
};

IntersectionElementContext.prototype.simple = function() {
    return this.getTypedRuleContext(SimpleContext,0);
};

IntersectionElementContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitIntersectionElement(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.IntersectionElementContext = IntersectionElementContext;

LscParser.prototype.intersectionElement = function() {

    var localctx = new IntersectionElementContext(this, this._ctx, this.state);
    this.enterRule(localctx, 80, LscParser.RULE_intersectionElement);
    try {
        this.state = 521;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,58,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 516;
            this.capture();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 517;
            this.repeater();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 518;
            this.group();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 519;
            this.list();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 520;
            this.simple();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function SimpleContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_simple;
    return this;
}

SimpleContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SimpleContext.prototype.constructor = SimpleContext;

SimpleContext.prototype.negated = function() {
    return this.getTypedRuleContext(NegatedContext,0);
};

SimpleContext.prototype.classRef = function() {
    return this.getTypedRuleContext(ClassRefContext,0);
};

SimpleContext.prototype.captureRef = function() {
    return this.getTypedRuleContext(CaptureRefContext,0);
};

SimpleContext.prototype.fancyMatrix = function() {
    return this.getTypedRuleContext(FancyMatrixContext,0);
};

SimpleContext.prototype.empty = function() {
    return this.getTypedRuleContext(EmptyContext,0);
};

SimpleContext.prototype.boundary = function() {
    return this.getTypedRuleContext(BoundaryContext,0);
};

SimpleContext.prototype.betweenWords = function() {
    return this.getTypedRuleContext(BetweenWordsContext,0);
};

SimpleContext.prototype.text = function() {
    return this.getTypedRuleContext(TextContext,0);
};

SimpleContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitSimple(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.SimpleContext = SimpleContext;

LscParser.prototype.simple = function() {

    var localctx = new SimpleContext(this, this._ctx, this.state);
    this.enterRule(localctx, 82, LscParser.RULE_simple);
    try {
        this.state = 531;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,59,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 523;
            this.negated();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 524;
            this.classRef();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 525;
            this.captureRef();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 526;
            this.fancyMatrix();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 527;
            this.empty();
            break;

        case 6:
            this.enterOuterAlt(localctx, 6);
            this.state = 528;
            this.boundary();
            break;

        case 7:
            this.enterOuterAlt(localctx, 7);
            this.state = 529;
            this.betweenWords();
            break;

        case 8:
            this.enterOuterAlt(localctx, 8);
            this.state = 530;
            this.text();
            break;

        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function NegatedContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_negated;
    return this;
}

NegatedContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
NegatedContext.prototype.constructor = NegatedContext;

NegatedContext.prototype.NEGATION = function() {
    return this.getToken(LscParser.NEGATION, 0);
};

NegatedContext.prototype.classRef = function() {
    return this.getTypedRuleContext(ClassRefContext,0);
};

NegatedContext.prototype.captureRef = function() {
    return this.getTypedRuleContext(CaptureRefContext,0);
};

NegatedContext.prototype.text = function() {
    return this.getTypedRuleContext(TextContext,0);
};

NegatedContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitNegated(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.NegatedContext = NegatedContext;

LscParser.prototype.negated = function() {

    var localctx = new NegatedContext(this, this._ctx, this.state);
    this.enterRule(localctx, 84, LscParser.RULE_negated);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 533;
        this.match(LscParser.NEGATION);
        this.state = 537;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.CLASSREF:
            this.state = 534;
            this.classRef();
            break;
        case LscParser.WORD_BOUNDARY:
            this.state = 535;
            this.captureRef();
            break;
        case LscParser.NAME:
        case LscParser.STR1:
        case LscParser.STR:
            this.state = 536;
            this.text();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function ClassRefContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_classRef;
    return this;
}

ClassRefContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ClassRefContext.prototype.constructor = ClassRefContext;

ClassRefContext.prototype.CLASSREF = function() {
    return this.getToken(LscParser.CLASSREF, 0);
};

ClassRefContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

ClassRefContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitClassRef(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ClassRefContext = ClassRefContext;

LscParser.prototype.classRef = function() {

    var localctx = new ClassRefContext(this, this._ctx, this.state);
    this.enterRule(localctx, 86, LscParser.RULE_classRef);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 539;
        this.match(LscParser.CLASSREF);
        this.state = 540;
        this.name();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function CaptureRefContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_captureRef;
    return this;
}

CaptureRefContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
CaptureRefContext.prototype.constructor = CaptureRefContext;

CaptureRefContext.prototype.WORD_BOUNDARY = function() {
    return this.getToken(LscParser.WORD_BOUNDARY, 0);
};

CaptureRefContext.prototype.NUMBER = function() {
    return this.getToken(LscParser.NUMBER, 0);
};

CaptureRefContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitCaptureRef(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.CaptureRefContext = CaptureRefContext;

LscParser.prototype.captureRef = function() {

    var localctx = new CaptureRefContext(this, this._ctx, this.state);
    this.enterRule(localctx, 88, LscParser.RULE_captureRef);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 542;
        this.match(LscParser.WORD_BOUNDARY);
        this.state = 543;
        this.match(LscParser.NUMBER);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function FancyMatrixContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_fancyMatrix;
    return this;
}

FancyMatrixContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FancyMatrixContext.prototype.constructor = FancyMatrixContext;

FancyMatrixContext.prototype.MATRIX_START = function() {
    return this.getToken(LscParser.MATRIX_START, 0);
};

FancyMatrixContext.prototype.MATRIX_END = function() {
    return this.getToken(LscParser.MATRIX_END, 0);
};

FancyMatrixContext.prototype.fancyValue = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(FancyValueContext);
    } else {
        return this.getTypedRuleContext(FancyValueContext,i);
    }
};

FancyMatrixContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


FancyMatrixContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitFancyMatrix(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.FancyMatrixContext = FancyMatrixContext;

LscParser.prototype.fancyMatrix = function() {

    var localctx = new FancyMatrixContext(this, this._ctx, this.state);
    this.enterRule(localctx, 90, LscParser.RULE_fancyMatrix);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 545;
        this.match(LscParser.MATRIX_START);
        this.state = 547;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(((((_la - 12)) & ~0x1f) == 0 && ((1 << (_la - 12)) & ((1 << (LscParser.NULL - 12)) | (1 << (LscParser.AT_LEAST_ONE - 12)) | (1 << (LscParser.HYPHEN - 12)) | (1 << (LscParser.NEGATION - 12)) | (1 << (LscParser.WORD_BOUNDARY - 12)) | (1 << (LscParser.NAME - 12)))) !== 0)) {
            this.state = 546;
            this.fancyValue();
        }

        this.state = 553;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.WHITESPACE) {
            this.state = 549;
            this.match(LscParser.WHITESPACE);
            this.state = 550;
            this.fancyValue();
            this.state = 555;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 556;
        this.match(LscParser.MATRIX_END);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function FancyValueContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_fancyValue;
    return this;
}

FancyValueContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FancyValueContext.prototype.constructor = FancyValueContext;

FancyValueContext.prototype.plusFeatureValue = function() {
    return this.getTypedRuleContext(PlusFeatureValueContext,0);
};

FancyValueContext.prototype.featureValue = function() {
    return this.getTypedRuleContext(FeatureValueContext,0);
};

FancyValueContext.prototype.negatedValue = function() {
    return this.getTypedRuleContext(NegatedValueContext,0);
};

FancyValueContext.prototype.absentFeature = function() {
    return this.getTypedRuleContext(AbsentFeatureContext,0);
};

FancyValueContext.prototype.featureVariable = function() {
    return this.getTypedRuleContext(FeatureVariableContext,0);
};

FancyValueContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitFancyValue(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.FancyValueContext = FancyValueContext;

LscParser.prototype.fancyValue = function() {

    var localctx = new FancyValueContext(this, this._ctx, this.state);
    this.enterRule(localctx, 92, LscParser.RULE_fancyValue);
    try {
        this.state = 563;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.AT_LEAST_ONE:
        case LscParser.HYPHEN:
            this.enterOuterAlt(localctx, 1);
            this.state = 558;
            this.plusFeatureValue();
            break;
        case LscParser.NAME:
            this.enterOuterAlt(localctx, 2);
            this.state = 559;
            this.featureValue();
            break;
        case LscParser.NEGATION:
            this.enterOuterAlt(localctx, 3);
            this.state = 560;
            this.negatedValue();
            break;
        case LscParser.NULL:
            this.enterOuterAlt(localctx, 4);
            this.state = 561;
            this.absentFeature();
            break;
        case LscParser.WORD_BOUNDARY:
            this.enterOuterAlt(localctx, 5);
            this.state = 562;
            this.featureVariable();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function NegatedValueContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_negatedValue;
    return this;
}

NegatedValueContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
NegatedValueContext.prototype.constructor = NegatedValueContext;

NegatedValueContext.prototype.NEGATION = function() {
    return this.getToken(LscParser.NEGATION, 0);
};

NegatedValueContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

NegatedValueContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitNegatedValue(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.NegatedValueContext = NegatedValueContext;

LscParser.prototype.negatedValue = function() {

    var localctx = new NegatedValueContext(this, this._ctx, this.state);
    this.enterRule(localctx, 94, LscParser.RULE_negatedValue);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 565;
        this.match(LscParser.NEGATION);
        this.state = 566;
        this.name();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function AbsentFeatureContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_absentFeature;
    return this;
}

AbsentFeatureContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
AbsentFeatureContext.prototype.constructor = AbsentFeatureContext;

AbsentFeatureContext.prototype.NULL = function() {
    return this.getToken(LscParser.NULL, 0);
};

AbsentFeatureContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

AbsentFeatureContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitAbsentFeature(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.AbsentFeatureContext = AbsentFeatureContext;

LscParser.prototype.absentFeature = function() {

    var localctx = new AbsentFeatureContext(this, this._ctx, this.state);
    this.enterRule(localctx, 96, LscParser.RULE_absentFeature);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 568;
        this.match(LscParser.NULL);
        this.state = 569;
        this.name();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function FeatureVariableContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_featureVariable;
    return this;
}

FeatureVariableContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FeatureVariableContext.prototype.constructor = FeatureVariableContext;

FeatureVariableContext.prototype.WORD_BOUNDARY = function() {
    return this.getToken(LscParser.WORD_BOUNDARY, 0);
};

FeatureVariableContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

FeatureVariableContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitFeatureVariable(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.FeatureVariableContext = FeatureVariableContext;

LscParser.prototype.featureVariable = function() {

    var localctx = new FeatureVariableContext(this, this._ctx, this.state);
    this.enterRule(localctx, 98, LscParser.RULE_featureVariable);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 571;
        this.match(LscParser.WORD_BOUNDARY);
        this.state = 572;
        this.name();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function EmptyContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_empty;
    return this;
}

EmptyContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
EmptyContext.prototype.constructor = EmptyContext;

EmptyContext.prototype.NULL = function() {
    return this.getToken(LscParser.NULL, 0);
};

EmptyContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitEmpty(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.EmptyContext = EmptyContext;

LscParser.prototype.empty = function() {

    var localctx = new EmptyContext(this, this._ctx, this.state);
    this.enterRule(localctx, 100, LscParser.RULE_empty);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 574;
        this.match(LscParser.NULL);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function BoundaryContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_boundary;
    return this;
}

BoundaryContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
BoundaryContext.prototype.constructor = BoundaryContext;

BoundaryContext.prototype.WORD_BOUNDARY = function() {
    return this.getToken(LscParser.WORD_BOUNDARY, 0);
};

BoundaryContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitBoundary(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.BoundaryContext = BoundaryContext;

LscParser.prototype.boundary = function() {

    var localctx = new BoundaryContext(this, this._ctx, this.state);
    this.enterRule(localctx, 102, LscParser.RULE_boundary);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 576;
        this.match(LscParser.WORD_BOUNDARY);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function BetweenWordsContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_betweenWords;
    return this;
}

BetweenWordsContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
BetweenWordsContext.prototype.constructor = BetweenWordsContext;

BetweenWordsContext.prototype.BETWEEN_WORDS = function() {
    return this.getToken(LscParser.BETWEEN_WORDS, 0);
};

BetweenWordsContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitBetweenWords(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.BetweenWordsContext = BetweenWordsContext;

LscParser.prototype.betweenWords = function() {

    var localctx = new BetweenWordsContext(this, this._ctx, this.state);
    this.enterRule(localctx, 104, LscParser.RULE_betweenWords);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 578;
        this.match(LscParser.BETWEEN_WORDS);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function RepeaterTypeContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_repeaterType;
    return this;
}

RepeaterTypeContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
RepeaterTypeContext.prototype.constructor = RepeaterTypeContext;

RepeaterTypeContext.prototype.AT_LEAST_ONE = function() {
    return this.getToken(LscParser.AT_LEAST_ONE, 0);
};

RepeaterTypeContext.prototype.NULL = function() {
    return this.getToken(LscParser.NULL, 0);
};

RepeaterTypeContext.prototype.OPTIONAL = function() {
    return this.getToken(LscParser.OPTIONAL, 0);
};

RepeaterTypeContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitRepeaterType(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.RepeaterTypeContext = RepeaterTypeContext;

LscParser.prototype.repeaterType = function() {

    var localctx = new RepeaterTypeContext(this, this._ctx, this.state);
    this.enterRule(localctx, 106, LscParser.RULE_repeaterType);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 580;
        _la = this._input.LA(1);
        if(!((((_la) & ~0x1f) == 0 && ((1 << _la) & ((1 << LscParser.NULL) | (1 << LscParser.AT_LEAST_ONE) | (1 << LscParser.OPTIONAL))) !== 0))) {
        this._errHandler.recoverInline(this);
        }
        else {
        	this._errHandler.reportMatch(this);
            this.consume();
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function MatrixContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_matrix;
    return this;
}

MatrixContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
MatrixContext.prototype.constructor = MatrixContext;

MatrixContext.prototype.MATRIX_START = function() {
    return this.getToken(LscParser.MATRIX_START, 0);
};

MatrixContext.prototype.MATRIX_END = function() {
    return this.getToken(LscParser.MATRIX_END, 0);
};

MatrixContext.prototype.matrixValue = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(MatrixValueContext);
    } else {
        return this.getTypedRuleContext(MatrixValueContext,i);
    }
};

MatrixContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


MatrixContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitMatrix(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.MatrixContext = MatrixContext;

LscParser.prototype.matrix = function() {

    var localctx = new MatrixContext(this, this._ctx, this.state);
    this.enterRule(localctx, 108, LscParser.RULE_matrix);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 582;
        this.match(LscParser.MATRIX_START);
        this.state = 584;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(((((_la - 17)) & ~0x1f) == 0 && ((1 << (_la - 17)) & ((1 << (LscParser.AT_LEAST_ONE - 17)) | (1 << (LscParser.HYPHEN - 17)) | (1 << (LscParser.NAME - 17)))) !== 0)) {
            this.state = 583;
            this.matrixValue();
        }

        this.state = 590;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.WHITESPACE) {
            this.state = 586;
            this.match(LscParser.WHITESPACE);
            this.state = 587;
            this.matrixValue();
            this.state = 592;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 593;
        this.match(LscParser.MATRIX_END);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function MatrixValueContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_matrixValue;
    return this;
}

MatrixValueContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
MatrixValueContext.prototype.constructor = MatrixValueContext;

MatrixValueContext.prototype.plusFeatureValue = function() {
    return this.getTypedRuleContext(PlusFeatureValueContext,0);
};

MatrixValueContext.prototype.featureValue = function() {
    return this.getTypedRuleContext(FeatureValueContext,0);
};

MatrixValueContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitMatrixValue(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.MatrixValueContext = MatrixValueContext;

LscParser.prototype.matrixValue = function() {

    var localctx = new MatrixValueContext(this, this._ctx, this.state);
    this.enterRule(localctx, 110, LscParser.RULE_matrixValue);
    try {
        this.state = 597;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.AT_LEAST_ONE:
        case LscParser.HYPHEN:
            this.enterOuterAlt(localctx, 1);
            this.state = 595;
            this.plusFeatureValue();
            break;
        case LscParser.NAME:
            this.enterOuterAlt(localctx, 2);
            this.state = 596;
            this.featureValue();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function PlusFeatureValueContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_plusFeatureValue;
    return this;
}

PlusFeatureValueContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
PlusFeatureValueContext.prototype.constructor = PlusFeatureValueContext;

PlusFeatureValueContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

PlusFeatureValueContext.prototype.AT_LEAST_ONE = function() {
    return this.getToken(LscParser.AT_LEAST_ONE, 0);
};

PlusFeatureValueContext.prototype.HYPHEN = function() {
    return this.getToken(LscParser.HYPHEN, 0);
};

PlusFeatureValueContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitPlusFeatureValue(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.PlusFeatureValueContext = PlusFeatureValueContext;

LscParser.prototype.plusFeatureValue = function() {

    var localctx = new PlusFeatureValueContext(this, this._ctx, this.state);
    this.enterRule(localctx, 112, LscParser.RULE_plusFeatureValue);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 599;
        _la = this._input.LA(1);
        if(!(_la===LscParser.AT_LEAST_ONE || _la===LscParser.HYPHEN)) {
        this._errHandler.recoverInline(this);
        }
        else {
        	this._errHandler.reportMatch(this);
            this.consume();
        }
        this.state = 600;
        this.name();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function FeatureValueContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_featureValue;
    return this;
}

FeatureValueContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FeatureValueContext.prototype.constructor = FeatureValueContext;

FeatureValueContext.prototype.name = function() {
    return this.getTypedRuleContext(NameContext,0);
};

FeatureValueContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitFeatureValue(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.FeatureValueContext = FeatureValueContext;

LscParser.prototype.featureValue = function() {

    var localctx = new FeatureValueContext(this, this._ctx, this.state);
    this.enterRule(localctx, 114, LscParser.RULE_featureValue);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 602;
        this.name();
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function NameContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_name;
    return this;
}

NameContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
NameContext.prototype.constructor = NameContext;

NameContext.prototype.NAME = function() {
    return this.getToken(LscParser.NAME, 0);
};

NameContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitName(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.NameContext = NameContext;

LscParser.prototype.name = function() {

    var localctx = new NameContext(this, this._ctx, this.state);
    this.enterRule(localctx, 116, LscParser.RULE_name);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 604;
        this.match(LscParser.NAME);
    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


function TextContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_text;
    return this;
}

TextContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
TextContext.prototype.constructor = TextContext;

TextContext.prototype.NAME = function() {
    return this.getToken(LscParser.NAME, 0);
};

TextContext.prototype.STR1 = function() {
    return this.getToken(LscParser.STR1, 0);
};

TextContext.prototype.STR = function() {
    return this.getToken(LscParser.STR, 0);
};

TextContext.prototype.NEGATION = function() {
    return this.getToken(LscParser.NEGATION, 0);
};

TextContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitText(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.TextContext = TextContext;

LscParser.prototype.text = function() {

    var localctx = new TextContext(this, this._ctx, this.state);
    this.enterRule(localctx, 118, LscParser.RULE_text);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 606;
        _la = this._input.LA(1);
        if(!(((((_la - 41)) & ~0x1f) == 0 && ((1 << (_la - 41)) & ((1 << (LscParser.NAME - 41)) | (1 << (LscParser.STR1 - 41)) | (1 << (LscParser.STR - 41)))) !== 0))) {
        this._errHandler.recoverInline(this);
        }
        else {
        	this._errHandler.reportMatch(this);
            this.consume();
        }
        this.state = 608;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.NEGATION) {
            this.state = 607;
            this.match(LscParser.NEGATION);
        }

    } catch (re) {
    	if(re instanceof antlr4.error.RecognitionException) {
	        localctx.exception = re;
	        this._errHandler.reportError(this, re);
	        this._errHandler.recover(this, re);
	    } else {
	    	throw re;
	    }
    } finally {
        this.exitRule();
    }
    return localctx;
};


exports.LscParser = LscParser;
