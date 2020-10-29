// Generated from Lsc.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');
var LscVisitor = require('./LscVisitor').LscVisitor;

var grammarFileName = "Lsc.g4";


var serializedATN = ["\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964",
    "\u0003\'\u0201\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t",
    "\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004",
    "\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004\f\t\f\u0004",
    "\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010\t\u0010\u0004",
    "\u0011\t\u0011\u0004\u0012\t\u0012\u0004\u0013\t\u0013\u0004\u0014\t",
    "\u0014\u0004\u0015\t\u0015\u0004\u0016\t\u0016\u0004\u0017\t\u0017\u0004",
    "\u0018\t\u0018\u0004\u0019\t\u0019\u0004\u001a\t\u001a\u0004\u001b\t",
    "\u001b\u0004\u001c\t\u001c\u0004\u001d\t\u001d\u0004\u001e\t\u001e\u0004",
    "\u001f\t\u001f\u0004 \t \u0004!\t!\u0004\"\t\"\u0004#\t#\u0004$\t$\u0004",
    "%\t%\u0004&\t&\u0004\'\t\'\u0004(\t(\u0004)\t)\u0004*\t*\u0004+\t+\u0004",
    ",\t,\u0004-\t-\u0004.\t.\u0004/\t/\u00040\t0\u00041\t1\u00042\t2\u0003",
    "\u0002\u0003\u0002\u0006\u0002g\n\u0002\r\u0002\u000e\u0002h\u0007\u0002",
    "k\n\u0002\f\u0002\u000e\u0002n\u000b\u0002\u0003\u0002\u0003\u0002\u0006",
    "\u0002r\n\u0002\r\u0002\u000e\u0002s\u0007\u0002v\n\u0002\f\u0002\u000e",
    "\u0002y\u000b\u0002\u0003\u0002\u0003\u0002\u0006\u0002}\n\u0002\r\u0002",
    "\u000e\u0002~\u0007\u0002\u0081\n\u0002\f\u0002\u000e\u0002\u0084\u000b",
    "\u0002\u0003\u0002\u0003\u0002\u0006\u0002\u0088\n\u0002\r\u0002\u000e",
    "\u0002\u0089\u0007\u0002\u008c\n\u0002\f\u0002\u000e\u0002\u008f\u000b",
    "\u0002\u0003\u0002\u0003\u0002\u0006\u0002\u0093\n\u0002\r\u0002\u000e",
    "\u0002\u0094\u0005\u0002\u0097\n\u0002\u0003\u0002\u0005\u0002\u009a",
    "\n\u0002\u0003\u0002\u0006\u0002\u009d\n\u0002\r\u0002\u000e\u0002\u009e",
    "\u0003\u0002\u0003\u0002\u0005\u0002\u00a3\n\u0002\u0007\u0002\u00a5",
    "\n\u0002\f\u0002\u000e\u0002\u00a8\u000b\u0002\u0003\u0002\u0006\u0002",
    "\u00ab\n\u0002\r\u0002\u000e\u0002\u00ac\u0003\u0002\u0005\u0002\u00b0",
    "\n\u0002\u0003\u0002\u0006\u0002\u00b3\n\u0002\r\u0002\u000e\u0002\u00b4",
    "\u0003\u0002\u0005\u0002\u00b8\n\u0002\u0003\u0002\u0007\u0002\u00bb",
    "\n\u0002\f\u0002\u000e\u0002\u00be\u000b\u0002\u0003\u0002\u0003\u0002",
    "\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003",
    "\u0003\u0003\u0003\u0003\u0007\u0003\u00ca\n\u0003\f\u0003\u000e\u0003",
    "\u00cd\u000b\u0003\u0003\u0003\u0003\u0003\u0003\u0004\u0003\u0004\u0005",
    "\u0004\u00d3\n\u0004\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005",
    "\u0003\u0005\u0003\u0005\u0003\u0005\u0005\u0005\u00dc\n\u0005\u0003",
    "\u0005\u0003\u0005\u0003\u0005\u0007\u0005\u00e1\n\u0005\f\u0005\u000e",
    "\u0005\u00e4\u000b\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0005\u0005",
    "\u00e9\n\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0007\u0003",
    "\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0005\u0007\u00f4",
    "\n\u0007\u0003\u0007\u0003\u0007\u0005\u0007\u00f8\n\u0007\u0003\u0007",
    "\u0003\u0007\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0007\b\u0101\n",
    "\b\f\b\u000e\b\u0104\u000b\b\u0003\b\u0003\b\u0005\b\u0108\n\b\u0003",
    "\t\u0003\t\u0003\n\u0003\n\u0003\n\u0003\n\u0003\n\u0003\u000b\u0003",
    "\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\f\u0003\f\u0003\f\u0003",
    "\f\u0003\f\u0003\f\u0003\f\u0003\r\u0003\r\u0003\r\u0005\r\u0120\n\r",
    "\u0003\r\u0003\r\u0005\r\u0124\n\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003",
    "\u000e\u0003\u000e\u0005\u000e\u012c\n\u000e\u0003\u000f\u0003\u000f",
    "\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u000f\u0007\u000f\u0134\n",
    "\u000f\f\u000f\u000e\u000f\u0137\u000b\u000f\u0003\u0010\u0003\u0010",
    "\u0003\u0010\u0007\u0010\u013c\n\u0010\f\u0010\u000e\u0010\u013f\u000b",
    "\u0010\u0003\u0011\u0003\u0011\u0003\u0011\u0007\u0011\u0144\n\u0011",
    "\f\u0011\u000e\u0011\u0147\u000b\u0011\u0003\u0012\u0003\u0012\u0003",
    "\u0012\u0003\u0012\u0003\u0012\u0005\u0012\u014e\n\u0012\u0003\u0012",
    "\u0003\u0012\u0005\u0012\u0152\n\u0012\u0003\u0013\u0003\u0013\u0005",
    "\u0013\u0156\n\u0013\u0003\u0014\u0003\u0014\u0005\u0014\u015a\n\u0014",
    "\u0003\u0015\u0003\u0015\u0003\u0016\u0003\u0016\u0003\u0017\u0003\u0017",
    "\u0003\u0017\u0003\u0017\u0007\u0017\u0164\n\u0017\f\u0017\u000e\u0017",
    "\u0167\u000b\u0017\u0003\u0017\u0003\u0017\u0003\u0018\u0003\u0018\u0003",
    "\u0018\u0005\u0018\u016e\n\u0018\u0003\u0018\u0003\u0018\u0003\u0018",
    "\u0005\u0018\u0173\n\u0018\u0003\u0018\u0003\u0018\u0003\u0018\u0005",
    "\u0018\u0178\n\u0018\u0003\u0018\u0003\u0018\u0005\u0018\u017c\n\u0018",
    "\u0003\u0019\u0003\u0019\u0003\u001a\u0003\u001a\u0003\u001b\u0003\u001b",
    "\u0003\u001c\u0003\u001c\u0003\u001d\u0003\u001d\u0003\u001d\u0003\u001d",
    "\u0003\u001d\u0003\u001d\u0005\u001d\u018c\n\u001d\u0003\u001e\u0003",
    "\u001e\u0003\u001e\u0006\u001e\u0191\n\u001e\r\u001e\u000e\u001e\u0192",
    "\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0005\u001f",
    "\u019a\n\u001f\u0003 \u0003 \u0003 \u0003 \u0003 \u0005 \u01a1\n \u0003",
    " \u0003 \u0003!\u0003!\u0003!\u0005!\u01a8\n!\u0003!\u0003!\u0003\"",
    "\u0003\"\u0003\"\u0003\"\u0003#\u0003#\u0003#\u0003#\u0007#\u01b4\n",
    "#\f#\u000e#\u01b7\u000b#\u0003#\u0003#\u0003$\u0003$\u0003$\u0003$\u0003",
    "$\u0003$\u0005$\u01c1\n$\u0003%\u0003%\u0003%\u0003&\u0003&\u0003&\u0003",
    "\'\u0003\'\u0003\'\u0003(\u0003(\u0005(\u01ce\n(\u0003(\u0003(\u0007",
    "(\u01d2\n(\f(\u000e(\u01d5\u000b(\u0003(\u0003(\u0003)\u0003)\u0003",
    ")\u0003)\u0005)\u01dd\n)\u0003*\u0003*\u0003*\u0003+\u0003+\u0003+\u0003",
    ",\u0003,\u0003,\u0003-\u0003-\u0003.\u0003.\u0003/\u0003/\u0005/\u01ee",
    "\n/\u0003/\u0003/\u0007/\u01f2\n/\f/\u000e/\u01f5\u000b/\u0003/\u0003",
    "/\u00030\u00030\u00031\u00031\u00032\u00032\u00052\u01ff\n2\u00032\u0002",
    "\u00023\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018",
    "\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`b\u0002\u0005\u0003",
    "\u0002\t\n\u0004\u0002\r\r\u0012\u0013\u0004\u0002#$&\'\u0002\u0218",
    "\u0002l\u0003\u0002\u0002\u0002\u0004\u00c1\u0003\u0002\u0002\u0002",
    "\u0006\u00d2\u0003\u0002\u0002\u0002\b\u00d4\u0003\u0002\u0002\u0002",
    "\n\u00ea\u0003\u0002\u0002\u0002\f\u00ed\u0003\u0002\u0002\u0002\u000e",
    "\u00fb\u0003\u0002\u0002\u0002\u0010\u0109\u0003\u0002\u0002\u0002\u0012",
    "\u010b\u0003\u0002\u0002\u0002\u0014\u0110\u0003\u0002\u0002\u0002\u0016",
    "\u0115\u0003\u0002\u0002\u0002\u0018\u011c\u0003\u0002\u0002\u0002\u001a",
    "\u012b\u0003\u0002\u0002\u0002\u001c\u012d\u0003\u0002\u0002\u0002\u001e",
    "\u0138\u0003\u0002\u0002\u0002 \u0140\u0003\u0002\u0002\u0002\"\u0148",
    "\u0003\u0002\u0002\u0002$\u0155\u0003\u0002\u0002\u0002&\u0159\u0003",
    "\u0002\u0002\u0002(\u015b\u0003\u0002\u0002\u0002*\u015d\u0003\u0002",
    "\u0002\u0002,\u015f\u0003\u0002\u0002\u0002.\u016d\u0003\u0002\u0002",
    "\u00020\u017d\u0003\u0002\u0002\u00022\u017f\u0003\u0002\u0002\u0002",
    "4\u0181\u0003\u0002\u0002\u00026\u0183\u0003\u0002\u0002\u00028\u018b",
    "\u0003\u0002\u0002\u0002:\u018d\u0003\u0002\u0002\u0002<\u0199\u0003",
    "\u0002\u0002\u0002>\u01a0\u0003\u0002\u0002\u0002@\u01a7\u0003\u0002",
    "\u0002\u0002B\u01ab\u0003\u0002\u0002\u0002D\u01af\u0003\u0002\u0002",
    "\u0002F\u01c0\u0003\u0002\u0002\u0002H\u01c2\u0003\u0002\u0002\u0002",
    "J\u01c5\u0003\u0002\u0002\u0002L\u01c8\u0003\u0002\u0002\u0002N\u01cb",
    "\u0003\u0002\u0002\u0002P\u01dc\u0003\u0002\u0002\u0002R\u01de\u0003",
    "\u0002\u0002\u0002T\u01e1\u0003\u0002\u0002\u0002V\u01e4\u0003\u0002",
    "\u0002\u0002X\u01e7\u0003\u0002\u0002\u0002Z\u01e9\u0003\u0002\u0002",
    "\u0002\\\u01eb\u0003\u0002\u0002\u0002^\u01f8\u0003\u0002\u0002\u0002",
    "`\u01fa\u0003\u0002\u0002\u0002b\u01fc\u0003\u0002\u0002\u0002df\u0005",
    "\b\u0005\u0002eg\u0007\t\u0002\u0002fe\u0003\u0002\u0002\u0002gh\u0003",
    "\u0002\u0002\u0002hf\u0003\u0002\u0002\u0002hi\u0003\u0002\u0002\u0002",
    "ik\u0003\u0002\u0002\u0002jd\u0003\u0002\u0002\u0002kn\u0003\u0002\u0002",
    "\u0002lj\u0003\u0002\u0002\u0002lm\u0003\u0002\u0002\u0002mw\u0003\u0002",
    "\u0002\u0002nl\u0003\u0002\u0002\u0002oq\u0005\f\u0007\u0002pr\u0007",
    "\t\u0002\u0002qp\u0003\u0002\u0002\u0002rs\u0003\u0002\u0002\u0002s",
    "q\u0003\u0002\u0002\u0002st\u0003\u0002\u0002\u0002tv\u0003\u0002\u0002",
    "\u0002uo\u0003\u0002\u0002\u0002vy\u0003\u0002\u0002\u0002wu\u0003\u0002",
    "\u0002\u0002wx\u0003\u0002\u0002\u0002x\u0082\u0003\u0002\u0002\u0002",
    "yw\u0003\u0002\u0002\u0002z|\u0005\u000e\b\u0002{}\u0007\t\u0002\u0002",
    "|{\u0003\u0002\u0002\u0002}~\u0003\u0002\u0002\u0002~|\u0003\u0002\u0002",
    "\u0002~\u007f\u0003\u0002\u0002\u0002\u007f\u0081\u0003\u0002\u0002",
    "\u0002\u0080z\u0003\u0002\u0002\u0002\u0081\u0084\u0003\u0002\u0002",
    "\u0002\u0082\u0080\u0003\u0002\u0002\u0002\u0082\u0083\u0003\u0002\u0002",
    "\u0002\u0083\u008d\u0003\u0002\u0002\u0002\u0084\u0082\u0003\u0002\u0002",
    "\u0002\u0085\u0087\u0005\u0004\u0003\u0002\u0086\u0088\u0007\t\u0002",
    "\u0002\u0087\u0086\u0003\u0002\u0002\u0002\u0088\u0089\u0003\u0002\u0002",
    "\u0002\u0089\u0087\u0003\u0002\u0002\u0002\u0089\u008a\u0003\u0002\u0002",
    "\u0002\u008a\u008c\u0003\u0002\u0002\u0002\u008b\u0085\u0003\u0002\u0002",
    "\u0002\u008c\u008f\u0003\u0002\u0002\u0002\u008d\u008b\u0003\u0002\u0002",
    "\u0002\u008d\u008e\u0003\u0002\u0002\u0002\u008e\u0096\u0003\u0002\u0002",
    "\u0002\u008f\u008d\u0003\u0002\u0002\u0002\u0090\u0092\u0005\u0012\n",
    "\u0002\u0091\u0093\u0007\t\u0002\u0002\u0092\u0091\u0003\u0002\u0002",
    "\u0002\u0093\u0094\u0003\u0002\u0002\u0002\u0094\u0092\u0003\u0002\u0002",
    "\u0002\u0094\u0095\u0003\u0002\u0002\u0002\u0095\u0097\u0003\u0002\u0002",
    "\u0002\u0096\u0090\u0003\u0002\u0002\u0002\u0096\u0097\u0003\u0002\u0002",
    "\u0002\u0097\u0099\u0003\u0002\u0002\u0002\u0098\u009a\u0005\u0018\r",
    "\u0002\u0099\u0098\u0003\u0002\u0002\u0002\u0099\u009a\u0003\u0002\u0002",
    "\u0002\u009a\u00af\u0003\u0002\u0002\u0002\u009b\u009d\u0007\t\u0002",
    "\u0002\u009c\u009b\u0003\u0002\u0002\u0002\u009d\u009e\u0003\u0002\u0002",
    "\u0002\u009e\u009c\u0003\u0002\u0002\u0002\u009e\u009f\u0003\u0002\u0002",
    "\u0002\u009f\u00a2\u0003\u0002\u0002\u0002\u00a0\u00a3\u0005\u0018\r",
    "\u0002\u00a1\u00a3\u0005\u0016\f\u0002\u00a2\u00a0\u0003\u0002\u0002",
    "\u0002\u00a2\u00a1\u0003\u0002\u0002\u0002\u00a3\u00a5\u0003\u0002\u0002",
    "\u0002\u00a4\u009c\u0003\u0002\u0002\u0002\u00a5\u00a8\u0003\u0002\u0002",
    "\u0002\u00a6\u00a4\u0003\u0002\u0002\u0002\u00a6\u00a7\u0003\u0002\u0002",
    "\u0002\u00a7\u00aa\u0003\u0002\u0002\u0002\u00a8\u00a6\u0003\u0002\u0002",
    "\u0002\u00a9\u00ab\u0007\t\u0002\u0002\u00aa\u00a9\u0003\u0002\u0002",
    "\u0002\u00ab\u00ac\u0003\u0002\u0002\u0002\u00ac\u00aa\u0003\u0002\u0002",
    "\u0002\u00ac\u00ad\u0003\u0002\u0002\u0002\u00ad\u00ae\u0003\u0002\u0002",
    "\u0002\u00ae\u00b0\u0005\u0018\r\u0002\u00af\u00a6\u0003\u0002\u0002",
    "\u0002\u00af\u00b0\u0003\u0002\u0002\u0002\u00b0\u00b7\u0003\u0002\u0002",
    "\u0002\u00b1\u00b3\u0007\t\u0002\u0002\u00b2\u00b1\u0003\u0002\u0002",
    "\u0002\u00b3\u00b4\u0003\u0002\u0002\u0002\u00b4\u00b2\u0003\u0002\u0002",
    "\u0002\u00b4\u00b5\u0003\u0002\u0002\u0002\u00b5\u00b6\u0003\u0002\u0002",
    "\u0002\u00b6\u00b8\u0005\u0014\u000b\u0002\u00b7\u00b2\u0003\u0002\u0002",
    "\u0002\u00b7\u00b8\u0003\u0002\u0002\u0002\u00b8\u00bc\u0003\u0002\u0002",
    "\u0002\u00b9\u00bb\u0007\t\u0002\u0002\u00ba\u00b9\u0003\u0002\u0002",
    "\u0002\u00bb\u00be\u0003\u0002\u0002\u0002\u00bc\u00ba\u0003\u0002\u0002",
    "\u0002\u00bc\u00bd\u0003\u0002\u0002\u0002\u00bd\u00bf\u0003\u0002\u0002",
    "\u0002\u00be\u00bc\u0003\u0002\u0002\u0002\u00bf\u00c0\u0007\u0002\u0002",
    "\u0003\u00c0\u0003\u0003\u0002\u0002\u0002\u00c1\u00c2\u0007\u0019\u0002",
    "\u0002\u00c2\u00c3\u0007\n\u0002\u0002\u00c3\u00c4\u0005`1\u0002\u00c4",
    "\u00c5\u0007\n\u0002\u0002\u00c5\u00c6\u0007\u0010\u0002\u0002\u00c6",
    "\u00cb\u0005\u0006\u0004\u0002\u00c7\u00c8\u0007\u0004\u0002\u0002\u00c8",
    "\u00ca\u0005\u0006\u0004\u0002\u00c9\u00c7\u0003\u0002\u0002\u0002\u00ca",
    "\u00cd\u0003\u0002\u0002\u0002\u00cb\u00c9\u0003\u0002\u0002\u0002\u00cb",
    "\u00cc\u0003\u0002\u0002\u0002\u00cc\u00ce\u0003\u0002\u0002\u0002\u00cd",
    "\u00cb\u0003\u0002\u0002\u0002\u00ce\u00cf\u0007\u0011\u0002\u0002\u00cf",
    "\u0005\u0003\u0002\u0002\u0002\u00d0\u00d3\u0005J&\u0002\u00d1\u00d3",
    "\u0005b2\u0002\u00d2\u00d0\u0003\u0002\u0002\u0002\u00d2\u00d1\u0003",
    "\u0002\u0002\u0002\u00d3\u0007\u0003\u0002\u0002\u0002\u00d4\u00d5\u0007",
    "\u001a\u0002\u0002\u00d5\u00d6\u0007\n\u0002\u0002\u00d6\u00d7\u0005",
    "^0\u0002\u00d7\u00db\u0007\u000b\u0002\u0002\u00d8\u00d9\u0005\n\u0006",
    "\u0002\u00d9\u00da\u0007\u0004\u0002\u0002\u00da\u00dc\u0003\u0002\u0002",
    "\u0002\u00db\u00d8\u0003\u0002\u0002\u0002\u00db\u00dc\u0003\u0002\u0002",
    "\u0002\u00dc\u00dd\u0003\u0002\u0002\u0002\u00dd\u00e2\u0005`1\u0002",
    "\u00de\u00df\u0007\u0004\u0002\u0002\u00df\u00e1\u0005`1\u0002\u00e0",
    "\u00de\u0003\u0002\u0002\u0002\u00e1\u00e4\u0003\u0002\u0002\u0002\u00e2",
    "\u00e0\u0003\u0002\u0002\u0002\u00e2\u00e3\u0003\u0002\u0002\u0002\u00e3",
    "\u00e5\u0003\u0002\u0002\u0002\u00e4\u00e2\u0003\u0002\u0002\u0002\u00e5",
    "\u00e8\u0007\f\u0002\u0002\u00e6\u00e7\u0007\u0005\u0002\u0002\u00e7",
    "\u00e9\u0005\\/\u0002\u00e8\u00e6\u0003\u0002\u0002\u0002\u00e8\u00e9",
    "\u0003\u0002\u0002\u0002\u00e9\t\u0003\u0002\u0002\u0002\u00ea\u00eb",
    "\u0007\r\u0002\u0002\u00eb\u00ec\u0005`1\u0002\u00ec\u000b\u0003\u0002",
    "\u0002\u0002\u00ed\u00ee\u0007\u001b\u0002\u0002\u00ee\u00ef\u0007\n",
    "\u0002\u0002\u00ef\u00f0\u0007&\u0002\u0002\u00f0\u00f3\u0007\n\u0002",
    "\u0002\u00f1\u00f2\u0007\u001c\u0002\u0002\u00f2\u00f4\u0007\n\u0002",
    "\u0002\u00f3\u00f1\u0003\u0002\u0002\u0002\u00f3\u00f4\u0003\u0002\u0002",
    "\u0002\u00f4\u00f7\u0003\u0002\u0002\u0002\u00f5\u00f6\u0007\u001d\u0002",
    "\u0002\u00f6\u00f8\u0007\n\u0002\u0002\u00f7\u00f5\u0003\u0002\u0002",
    "\u0002\u00f7\u00f8\u0003\u0002\u0002\u0002\u00f8\u00f9\u0003\u0002\u0002",
    "\u0002\u00f9\u00fa\u0005\\/\u0002\u00fa\r\u0003\u0002\u0002\u0002\u00fb",
    "\u00fc\u0007\u001e\u0002\u0002\u00fc\u00fd\u0007\n\u0002\u0002\u00fd",
    "\u0107\u0005\u0010\t\u0002\u00fe\u00ff\u0007\u0004\u0002\u0002\u00ff",
    "\u0101\u0005\u0010\t\u0002\u0100\u00fe\u0003\u0002\u0002\u0002\u0101",
    "\u0104\u0003\u0002\u0002\u0002\u0102\u0100\u0003\u0002\u0002\u0002\u0102",
    "\u0103\u0003\u0002\u0002\u0002\u0103\u0108\u0003\u0002\u0002\u0002\u0104",
    "\u0102\u0003\u0002\u0002\u0002\u0105\u0106\u0007\n\u0002\u0002\u0106",
    "\u0108\u0005\\/\u0002\u0107\u0102\u0003\u0002\u0002\u0002\u0107\u0105",
    "\u0003\u0002\u0002\u0002\u0108\u000f\u0003\u0002\u0002\u0002\u0109\u010a",
    "\u0005b2\u0002\u010a\u0011\u0003\u0002\u0002\u0002\u010b\u010c\u0007",
    "\u001f\u0002\u0002\u010c\u010d\u0007\u0015\u0002\u0002\u010d\u010e\u0007",
    "\t\u0002\u0002\u010e\u010f\u0005\u001c\u000f\u0002\u010f\u0013\u0003",
    "\u0002\u0002\u0002\u0110\u0111\u0007 \u0002\u0002\u0111\u0112\u0007",
    "\u0015\u0002\u0002\u0112\u0113\u0007\t\u0002\u0002\u0113\u0114\u0005",
    "\u001c\u000f\u0002\u0114\u0015\u0003\u0002\u0002\u0002\u0115\u0116\u0007",
    " \u0002\u0002\u0116\u0117\u0007\u0014\u0002\u0002\u0117\u0118\u0005",
    " \u0011\u0002\u0118\u0119\u0007\u0015\u0002\u0002\u0119\u011a\u0007",
    "\t\u0002\u0002\u011a\u011b\u0005\u001c\u000f\u0002\u011b\u0017\u0003",
    "\u0002\u0002\u0002\u011c\u011f\u0005 \u0011\u0002\u011d\u011e\u0007",
    "\n\u0002\u0002\u011e\u0120\u0005\u001a\u000e\u0002\u011f\u011d\u0003",
    "\u0002\u0002\u0002\u011f\u0120\u0003\u0002\u0002\u0002\u0120\u0123\u0003",
    "\u0002\u0002\u0002\u0121\u0122\u0007\n\u0002\u0002\u0122\u0124\u0007",
    "\"\u0002\u0002\u0123\u0121\u0003\u0002\u0002\u0002\u0123\u0124\u0003",
    "\u0002\u0002\u0002\u0124\u0125\u0003\u0002\u0002\u0002\u0125\u0126\u0007",
    "\u0015\u0002\u0002\u0126\u0127\u0007\t\u0002\u0002\u0127\u0128\u0005",
    "\u001c\u000f\u0002\u0128\u0019\u0003\u0002\u0002\u0002\u0129\u012c\u0005",
    "J&\u0002\u012a\u012c\u0005\\/\u0002\u012b\u0129\u0003\u0002\u0002\u0002",
    "\u012b\u012a\u0003\u0002\u0002\u0002\u012c\u001b\u0003\u0002\u0002\u0002",
    "\u012d\u0135\u0005\u001e\u0010\u0002\u012e\u012f\u0007\t\u0002\u0002",
    "\u012f\u0130\u0007!\u0002\u0002\u0130\u0131\u0007\u0015\u0002\u0002",
    "\u0131\u0132\t\u0002\u0002\u0002\u0132\u0134\u0005\u001e\u0010\u0002",
    "\u0133\u012e\u0003\u0002\u0002\u0002\u0134\u0137\u0003\u0002\u0002\u0002",
    "\u0135\u0133\u0003\u0002\u0002\u0002\u0135\u0136\u0003\u0002\u0002\u0002",
    "\u0136\u001d\u0003\u0002\u0002\u0002\u0137\u0135\u0003\u0002\u0002\u0002",
    "\u0138\u013d\u0005\"\u0012\u0002\u0139\u013a\u0007\t\u0002\u0002\u013a",
    "\u013c\u0005\"\u0012\u0002\u013b\u0139\u0003\u0002\u0002\u0002\u013c",
    "\u013f\u0003\u0002\u0002\u0002\u013d\u013b\u0003\u0002\u0002\u0002\u013d",
    "\u013e\u0003\u0002\u0002\u0002\u013e\u001f\u0003\u0002\u0002\u0002\u013f",
    "\u013d\u0003\u0002\u0002\u0002\u0140\u0145\u0007$\u0002\u0002\u0141",
    "\u0142\u0007\u0014\u0002\u0002\u0142\u0144\u0007$\u0002\u0002\u0143",
    "\u0141\u0003\u0002\u0002\u0002\u0144\u0147\u0003\u0002\u0002\u0002\u0145",
    "\u0143\u0003\u0002\u0002\u0002\u0145\u0146\u0003\u0002\u0002\u0002\u0146",
    "!\u0003\u0002\u0002\u0002\u0147\u0145\u0003\u0002\u0002\u0002\u0148",
    "\u0149\u0005(\u0015\u0002\u0149\u014a\u0007\u0005\u0002\u0002\u014a",
    "\u014d\u0005*\u0016\u0002\u014b\u014c\u0007\u0006\u0002\u0002\u014c",
    "\u014e\u0005$\u0013\u0002\u014d\u014b\u0003\u0002\u0002\u0002\u014d",
    "\u014e\u0003\u0002\u0002\u0002\u014e\u0151\u0003\u0002\u0002\u0002\u014f",
    "\u0150\u0007\u0007\u0002\u0002\u0150\u0152\u0005&\u0014\u0002\u0151",
    "\u014f\u0003\u0002\u0002\u0002\u0151\u0152\u0003\u0002\u0002\u0002\u0152",
    "#\u0003\u0002\u0002\u0002\u0153\u0156\u0005.\u0018\u0002\u0154\u0156",
    "\u0005,\u0017\u0002\u0155\u0153\u0003\u0002\u0002\u0002\u0155\u0154",
    "\u0003\u0002\u0002\u0002\u0156%\u0003\u0002\u0002\u0002\u0157\u015a",
    "\u0005.\u0018\u0002\u0158\u015a\u0005,\u0017\u0002\u0159\u0157\u0003",
    "\u0002\u0002\u0002\u0159\u0158\u0003\u0002\u0002\u0002\u015a\'\u0003",
    "\u0002\u0002\u0002\u015b\u015c\u00058\u001d\u0002\u015c)\u0003\u0002",
    "\u0002\u0002\u015d\u015e\u00058\u001d\u0002\u015e+\u0003\u0002\u0002",
    "\u0002\u015f\u0160\u0007\u0010\u0002\u0002\u0160\u0165\u0005.\u0018",
    "\u0002\u0161\u0162\u0007\u0004\u0002\u0002\u0162\u0164\u0005.\u0018",
    "\u0002\u0163\u0161\u0003\u0002\u0002\u0002\u0164\u0167\u0003\u0002\u0002",
    "\u0002\u0165\u0163\u0003\u0002\u0002\u0002\u0165\u0166\u0003\u0002\u0002",
    "\u0002\u0166\u0168\u0003\u0002\u0002\u0002\u0167\u0165\u0003\u0002\u0002",
    "\u0002\u0168\u0169\u0007\u0011\u0002\u0002\u0169-\u0003\u0002\u0002",
    "\u0002\u016a\u016b\u00050\u0019\u0002\u016b\u016c\u0007\n\u0002\u0002",
    "\u016c\u016e\u0003\u0002\u0002\u0002\u016d\u016a\u0003\u0002\u0002\u0002",
    "\u016d\u016e\u0003\u0002\u0002\u0002\u016e\u0172\u0003\u0002\u0002\u0002",
    "\u016f\u0170\u00054\u001b\u0002\u0170\u0171\u0007\n\u0002\u0002\u0171",
    "\u0173\u0003\u0002\u0002\u0002\u0172\u016f\u0003\u0002\u0002\u0002\u0172",
    "\u0173\u0003\u0002\u0002\u0002\u0173\u0174\u0003\u0002\u0002\u0002\u0174",
    "\u0177\u0007\b\u0002\u0002\u0175\u0176\u0007\n\u0002\u0002\u0176\u0178",
    "\u00056\u001c\u0002\u0177\u0175\u0003\u0002\u0002\u0002\u0177\u0178",
    "\u0003\u0002\u0002\u0002\u0178\u017b\u0003\u0002\u0002\u0002\u0179\u017a",
    "\u0007\n\u0002\u0002\u017a\u017c\u00052\u001a\u0002\u017b\u0179\u0003",
    "\u0002\u0002\u0002\u017b\u017c\u0003\u0002\u0002\u0002\u017c/\u0003",
    "\u0002\u0002\u0002\u017d\u017e\u0007\u0017\u0002\u0002\u017e1\u0003",
    "\u0002\u0002\u0002\u017f\u0180\u0007\u0017\u0002\u0002\u01803\u0003",
    "\u0002\u0002\u0002\u0181\u0182\u00058\u001d\u0002\u01825\u0003\u0002",
    "\u0002\u0002\u0183\u0184\u00058\u001d\u0002\u01847\u0003\u0002\u0002",
    "\u0002\u0185\u018c\u0005> \u0002\u0186\u018c\u0005@!\u0002\u0187\u018c",
    "\u0005B\"\u0002\u0188\u018c\u0005D#\u0002\u0189\u018c\u0005F$\u0002",
    "\u018a\u018c\u0005:\u001e\u0002\u018b\u0185\u0003\u0002\u0002\u0002",
    "\u018b\u0186\u0003\u0002\u0002\u0002\u018b\u0187\u0003\u0002\u0002\u0002",
    "\u018b\u0188\u0003\u0002\u0002\u0002\u018b\u0189\u0003\u0002\u0002\u0002",
    "\u018b\u018a\u0003\u0002\u0002\u0002\u018c9\u0003\u0002\u0002\u0002",
    "\u018d\u0190\u0005<\u001f\u0002\u018e\u018f\u0007\n\u0002\u0002\u018f",
    "\u0191\u0005<\u001f\u0002\u0190\u018e\u0003\u0002\u0002\u0002\u0191",
    "\u0192\u0003\u0002\u0002\u0002\u0192\u0190\u0003\u0002\u0002\u0002\u0192",
    "\u0193\u0003\u0002\u0002\u0002\u0193;\u0003\u0002\u0002\u0002\u0194",
    "\u019a\u0005> \u0002\u0195\u019a\u0005@!\u0002\u0196\u019a\u0005B\"",
    "\u0002\u0197\u019a\u0005D#\u0002\u0198\u019a\u0005F$\u0002\u0199\u0194",
    "\u0003\u0002\u0002\u0002\u0199\u0195\u0003\u0002\u0002\u0002\u0199\u0196",
    "\u0003\u0002\u0002\u0002\u0199\u0197\u0003\u0002\u0002\u0002\u0199\u0198",
    "\u0003\u0002\u0002\u0002\u019a=\u0003\u0002\u0002\u0002\u019b\u01a1",
    "\u0005B\"\u0002\u019c\u01a1\u0005D#\u0002\u019d\u01a1\u0005H%\u0002",
    "\u019e\u01a1\u0005J&\u0002\u019f\u01a1\u0005N(\u0002\u01a0\u019b\u0003",
    "\u0002\u0002\u0002\u01a0\u019c\u0003\u0002\u0002\u0002\u01a0\u019d\u0003",
    "\u0002\u0002\u0002\u01a0\u019e\u0003\u0002\u0002\u0002\u01a0\u019f\u0003",
    "\u0002\u0002\u0002\u01a1\u01a2\u0003\u0002\u0002\u0002\u01a2\u01a3\u0005",
    "L\'\u0002\u01a3?\u0003\u0002\u0002\u0002\u01a4\u01a8\u0005B\"\u0002",
    "\u01a5\u01a8\u0005D#\u0002\u01a6\u01a8\u0005F$\u0002\u01a7\u01a4\u0003",
    "\u0002\u0002\u0002\u01a7\u01a5\u0003\u0002\u0002\u0002\u01a7\u01a6\u0003",
    "\u0002\u0002\u0002\u01a8\u01a9\u0003\u0002\u0002\u0002\u01a9\u01aa\u0005",
    "Z.\u0002\u01aaA\u0003\u0002\u0002\u0002\u01ab\u01ac\u0007\u000b\u0002",
    "\u0002\u01ac\u01ad\u00058\u001d\u0002\u01ad\u01ae\u0007\f\u0002\u0002",
    "\u01aeC\u0003\u0002\u0002\u0002\u01af\u01b0\u0007\u0010\u0002\u0002",
    "\u01b0\u01b5\u00058\u001d\u0002\u01b1\u01b2\u0007\u0004\u0002\u0002",
    "\u01b2\u01b4\u00058\u001d\u0002\u01b3\u01b1\u0003\u0002\u0002\u0002",
    "\u01b4\u01b7\u0003\u0002\u0002\u0002\u01b5\u01b3\u0003\u0002\u0002\u0002",
    "\u01b5\u01b6\u0003\u0002\u0002\u0002\u01b6\u01b8\u0003\u0002\u0002\u0002",
    "\u01b7\u01b5\u0003\u0002\u0002\u0002\u01b8\u01b9\u0007\u0011\u0002\u0002",
    "\u01b9E\u0003\u0002\u0002\u0002\u01ba\u01c1\u0005H%\u0002\u01bb\u01c1",
    "\u0005J&\u0002\u01bc\u01c1\u0005L\'\u0002\u01bd\u01c1\u0005N(\u0002",
    "\u01be\u01c1\u0005X-\u0002\u01bf\u01c1\u0005b2\u0002\u01c0\u01ba\u0003",
    "\u0002\u0002\u0002\u01c0\u01bb\u0003\u0002\u0002\u0002\u01c0\u01bc\u0003",
    "\u0002\u0002\u0002\u01c0\u01bd\u0003\u0002\u0002\u0002\u01c0\u01be\u0003",
    "\u0002\u0002\u0002\u01c0\u01bf\u0003\u0002\u0002\u0002\u01c1G\u0003",
    "\u0002\u0002\u0002\u01c2\u01c3\u0007\u0016\u0002\u0002\u01c3\u01c4\u0005",
    "J&\u0002\u01c4I\u0003\u0002\u0002\u0002\u01c5\u01c6\u0007\u0018\u0002",
    "\u0002\u01c6\u01c7\u0005`1\u0002\u01c7K\u0003\u0002\u0002\u0002\u01c8",
    "\u01c9\u0007\u0017\u0002\u0002\u01c9\u01ca\u0007%\u0002\u0002\u01ca",
    "M\u0003\u0002\u0002\u0002\u01cb\u01cd\u0007\u000e\u0002\u0002\u01cc",
    "\u01ce\u0005P)\u0002\u01cd\u01cc\u0003\u0002\u0002\u0002\u01cd\u01ce",
    "\u0003\u0002\u0002\u0002\u01ce\u01d3\u0003\u0002\u0002\u0002\u01cf\u01d0",
    "\u0007\n\u0002\u0002\u01d0\u01d2\u0005P)\u0002\u01d1\u01cf\u0003\u0002",
    "\u0002\u0002\u01d2\u01d5\u0003\u0002\u0002\u0002\u01d3\u01d1\u0003\u0002",
    "\u0002\u0002\u01d3\u01d4\u0003\u0002\u0002\u0002\u01d4\u01d6\u0003\u0002",
    "\u0002\u0002\u01d5\u01d3\u0003\u0002\u0002\u0002\u01d6\u01d7\u0007\u000f",
    "\u0002\u0002\u01d7O\u0003\u0002\u0002\u0002\u01d8\u01dd\u0005`1\u0002",
    "\u01d9\u01dd\u0005R*\u0002\u01da\u01dd\u0005T+\u0002\u01db\u01dd\u0005",
    "V,\u0002\u01dc\u01d8\u0003\u0002\u0002\u0002\u01dc\u01d9\u0003\u0002",
    "\u0002\u0002\u01dc\u01da\u0003\u0002\u0002\u0002\u01dc\u01db\u0003\u0002",
    "\u0002\u0002\u01ddQ\u0003\u0002\u0002\u0002\u01de\u01df\u0007\u0016",
    "\u0002\u0002\u01df\u01e0\u0005`1\u0002\u01e0S\u0003\u0002\u0002\u0002",
    "\u01e1\u01e2\u0007\r\u0002\u0002\u01e2\u01e3\u0005^0\u0002\u01e3U\u0003",
    "\u0002\u0002\u0002\u01e4\u01e5\u0007\u0017\u0002\u0002\u01e5\u01e6\u0005",
    "^0\u0002\u01e6W\u0003\u0002\u0002\u0002\u01e7\u01e8\u0007\r\u0002\u0002",
    "\u01e8Y\u0003\u0002\u0002\u0002\u01e9\u01ea\t\u0003\u0002\u0002\u01ea",
    "[\u0003\u0002\u0002\u0002\u01eb\u01ed\u0007\u000e\u0002\u0002\u01ec",
    "\u01ee\u0005`1\u0002\u01ed\u01ec\u0003\u0002\u0002\u0002\u01ed\u01ee",
    "\u0003\u0002\u0002\u0002\u01ee\u01f3\u0003\u0002\u0002\u0002\u01ef\u01f0",
    "\u0007\n\u0002\u0002\u01f0\u01f2\u0005`1\u0002\u01f1\u01ef\u0003\u0002",
    "\u0002\u0002\u01f2\u01f5\u0003\u0002\u0002\u0002\u01f3\u01f1\u0003\u0002",
    "\u0002\u0002\u01f3\u01f4\u0003\u0002\u0002\u0002\u01f4\u01f6\u0003\u0002",
    "\u0002\u0002\u01f5\u01f3\u0003\u0002\u0002\u0002\u01f6\u01f7\u0007\u000f",
    "\u0002\u0002\u01f7]\u0003\u0002\u0002\u0002\u01f8\u01f9\u0007#\u0002",
    "\u0002\u01f9_\u0003\u0002\u0002\u0002\u01fa\u01fb\u0007$\u0002\u0002",
    "\u01fba\u0003\u0002\u0002\u0002\u01fc\u01fe\t\u0004\u0002\u0002\u01fd",
    "\u01ff\u0007\u0016\u0002\u0002\u01fe\u01fd\u0003\u0002\u0002\u0002\u01fe",
    "\u01ff\u0003\u0002\u0002\u0002\u01ffc\u0003\u0002\u0002\u0002:hlsw~",
    "\u0082\u0089\u008d\u0094\u0096\u0099\u009e\u00a2\u00a6\u00ac\u00af\u00b4",
    "\u00b7\u00bc\u00cb\u00d2\u00db\u00e2\u00e8\u00f3\u00f7\u0102\u0107\u011f",
    "\u0123\u012b\u0135\u013d\u0145\u014d\u0151\u0155\u0159\u0165\u016d\u0172",
    "\u0177\u017b\u018b\u0192\u0199\u01a0\u01a7\u01b5\u01c0\u01cd\u01d3\u01dc",
    "\u01ed\u01f3\u01fe"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

var sharedContextCache = new antlr4.PredictionContextCache();

var literalNames = [ null, null, null, null, null, null, "'_'", null, null, 
                     "'('", "')'", "'*'", "'['", "']'", "'{'", "'}'", "'+'", 
                     "'?'", "'-'", "':'", "'!'", "'$'", "'@'", "'Class'", 
                     "'Feature'", "'Diacritic'", "'(before)'", "'(floating)'", 
                     "'Symbol'", "'Deromanizer'", "'Romanizer'", "'Then'", 
                     "'propagate'" ];

var symbolicNames = [ null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", 
                      "ANCHOR", "NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", 
                      "NULL", "MATRIX_START", "MATRIX_END", "LIST_START", 
                      "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
                      "RULE_START", "NEGATION", "WORD_BOUNDARY", "CLASSREF", 
                      "CLASS_DECL", "FEATURE_DECL", "DIACRITIC", "DIA_BEFORE", 
                      "DIA_FLOATING", "SYMBOL", "DEROMANIZER", "ROMANIZER", 
                      "SUBRULE", "PROPAGATE", "FEATURE", "VALUE", "NUMBER", 
                      "STR1", "STR" ];

var ruleNames =  [ "lscFile", "classDecl", "classElement", "featureDecl", 
                   "nullAlias", "diacriticDecl", "symbolDecl", "symbolName", 
                   "deromanizer", "romanizer", "interRomanizer", "changeRule", 
                   "filter", "subrules", "subrule", "ruleName", "expression", 
                   "condition", "exclusion", "from", "to", "environmentList", 
                   "environment", "boundaryBefore", "boundaryAfter", "environmentBefore", 
                   "environmentAfter", "ruleElement", "sequence", "sequenceElement", 
                   "capture", "repeater", "group", "list", "simple", "negated", 
                   "classRef", "captureRef", "fancyMatrix", "fancyValue", 
                   "negatedValue", "absentFeature", "featureVariable", "empty", 
                   "repeaterType", "matrix", "feature", "value", "text" ];

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
LscParser.COMMENT = 1;
LscParser.SEP = 2;
LscParser.CHANGE = 3;
LscParser.CONDITION = 4;
LscParser.EXCLUSION = 5;
LscParser.ANCHOR = 6;
LscParser.NEWLINE = 7;
LscParser.WHITESPACE = 8;
LscParser.O_PAREN = 9;
LscParser.C_PAREN = 10;
LscParser.NULL = 11;
LscParser.MATRIX_START = 12;
LscParser.MATRIX_END = 13;
LscParser.LIST_START = 14;
LscParser.LIST_END = 15;
LscParser.AT_LEAST_ONE = 16;
LscParser.OPTIONAL = 17;
LscParser.HYPHEN = 18;
LscParser.RULE_START = 19;
LscParser.NEGATION = 20;
LscParser.WORD_BOUNDARY = 21;
LscParser.CLASSREF = 22;
LscParser.CLASS_DECL = 23;
LscParser.FEATURE_DECL = 24;
LscParser.DIACRITIC = 25;
LscParser.DIA_BEFORE = 26;
LscParser.DIA_FLOATING = 27;
LscParser.SYMBOL = 28;
LscParser.DEROMANIZER = 29;
LscParser.ROMANIZER = 30;
LscParser.SUBRULE = 31;
LscParser.PROPAGATE = 32;
LscParser.FEATURE = 33;
LscParser.VALUE = 34;
LscParser.NUMBER = 35;
LscParser.STR1 = 36;
LscParser.STR = 37;

LscParser.RULE_lscFile = 0;
LscParser.RULE_classDecl = 1;
LscParser.RULE_classElement = 2;
LscParser.RULE_featureDecl = 3;
LscParser.RULE_nullAlias = 4;
LscParser.RULE_diacriticDecl = 5;
LscParser.RULE_symbolDecl = 6;
LscParser.RULE_symbolName = 7;
LscParser.RULE_deromanizer = 8;
LscParser.RULE_romanizer = 9;
LscParser.RULE_interRomanizer = 10;
LscParser.RULE_changeRule = 11;
LscParser.RULE_filter = 12;
LscParser.RULE_subrules = 13;
LscParser.RULE_subrule = 14;
LscParser.RULE_ruleName = 15;
LscParser.RULE_expression = 16;
LscParser.RULE_condition = 17;
LscParser.RULE_exclusion = 18;
LscParser.RULE_from = 19;
LscParser.RULE_to = 20;
LscParser.RULE_environmentList = 21;
LscParser.RULE_environment = 22;
LscParser.RULE_boundaryBefore = 23;
LscParser.RULE_boundaryAfter = 24;
LscParser.RULE_environmentBefore = 25;
LscParser.RULE_environmentAfter = 26;
LscParser.RULE_ruleElement = 27;
LscParser.RULE_sequence = 28;
LscParser.RULE_sequenceElement = 29;
LscParser.RULE_capture = 30;
LscParser.RULE_repeater = 31;
LscParser.RULE_group = 32;
LscParser.RULE_list = 33;
LscParser.RULE_simple = 34;
LscParser.RULE_negated = 35;
LscParser.RULE_classRef = 36;
LscParser.RULE_captureRef = 37;
LscParser.RULE_fancyMatrix = 38;
LscParser.RULE_fancyValue = 39;
LscParser.RULE_negatedValue = 40;
LscParser.RULE_absentFeature = 41;
LscParser.RULE_featureVariable = 42;
LscParser.RULE_empty = 43;
LscParser.RULE_repeaterType = 44;
LscParser.RULE_matrix = 45;
LscParser.RULE_feature = 46;
LscParser.RULE_value = 47;
LscParser.RULE_text = 48;


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

LscFileContext.prototype.EOF = function() {
    return this.getToken(LscParser.EOF, 0);
};

LscFileContext.prototype.featureDecl = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(FeatureDeclContext);
    } else {
        return this.getTypedRuleContext(FeatureDeclContext,i);
    }
};

LscFileContext.prototype.diacriticDecl = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(DiacriticDeclContext);
    } else {
        return this.getTypedRuleContext(DiacriticDeclContext,i);
    }
};

LscFileContext.prototype.symbolDecl = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(SymbolDeclContext);
    } else {
        return this.getTypedRuleContext(SymbolDeclContext,i);
    }
};

LscFileContext.prototype.classDecl = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ClassDeclContext);
    } else {
        return this.getTypedRuleContext(ClassDeclContext,i);
    }
};

LscFileContext.prototype.deromanizer = function() {
    return this.getTypedRuleContext(DeromanizerContext,0);
};

LscFileContext.prototype.changeRule = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ChangeRuleContext);
    } else {
        return this.getTypedRuleContext(ChangeRuleContext,i);
    }
};

LscFileContext.prototype.romanizer = function() {
    return this.getTypedRuleContext(RomanizerContext,0);
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


LscFileContext.prototype.interRomanizer = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(InterRomanizerContext);
    } else {
        return this.getTypedRuleContext(InterRomanizerContext,i);
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
        this.enterOuterAlt(localctx, 1);
        this.state = 106;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.FEATURE_DECL) {
            this.state = 98;
            this.featureDecl();
            this.state = 100; 
            this._errHandler.sync(this);
            var _alt = 1;
            do {
            	switch (_alt) {
            	case 1:
            		this.state = 99;
            		this.match(LscParser.NEWLINE);
            		break;
            	default:
            		throw new antlr4.error.NoViableAltException(this);
            	}
            	this.state = 102; 
            	this._errHandler.sync(this);
            	_alt = this._interp.adaptivePredict(this._input,0, this._ctx);
            } while ( _alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER );
            this.state = 108;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 117;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.DIACRITIC) {
            this.state = 109;
            this.diacriticDecl();
            this.state = 111; 
            this._errHandler.sync(this);
            var _alt = 1;
            do {
            	switch (_alt) {
            	case 1:
            		this.state = 110;
            		this.match(LscParser.NEWLINE);
            		break;
            	default:
            		throw new antlr4.error.NoViableAltException(this);
            	}
            	this.state = 113; 
            	this._errHandler.sync(this);
            	_alt = this._interp.adaptivePredict(this._input,2, this._ctx);
            } while ( _alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER );
            this.state = 119;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 128;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SYMBOL) {
            this.state = 120;
            this.symbolDecl();
            this.state = 122; 
            this._errHandler.sync(this);
            var _alt = 1;
            do {
            	switch (_alt) {
            	case 1:
            		this.state = 121;
            		this.match(LscParser.NEWLINE);
            		break;
            	default:
            		throw new antlr4.error.NoViableAltException(this);
            	}
            	this.state = 124; 
            	this._errHandler.sync(this);
            	_alt = this._interp.adaptivePredict(this._input,4, this._ctx);
            } while ( _alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER );
            this.state = 130;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 139;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.CLASS_DECL) {
            this.state = 131;
            this.classDecl();
            this.state = 133; 
            this._errHandler.sync(this);
            var _alt = 1;
            do {
            	switch (_alt) {
            	case 1:
            		this.state = 132;
            		this.match(LscParser.NEWLINE);
            		break;
            	default:
            		throw new antlr4.error.NoViableAltException(this);
            	}
            	this.state = 135; 
            	this._errHandler.sync(this);
            	_alt = this._interp.adaptivePredict(this._input,6, this._ctx);
            } while ( _alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER );
            this.state = 141;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 148;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.DEROMANIZER) {
            this.state = 142;
            this.deromanizer();
            this.state = 144; 
            this._errHandler.sync(this);
            var _alt = 1;
            do {
            	switch (_alt) {
            	case 1:
            		this.state = 143;
            		this.match(LscParser.NEWLINE);
            		break;
            	default:
            		throw new antlr4.error.NoViableAltException(this);
            	}
            	this.state = 146; 
            	this._errHandler.sync(this);
            	_alt = this._interp.adaptivePredict(this._input,8, this._ctx);
            } while ( _alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER );
        }

        this.state = 151;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.VALUE) {
            this.state = 150;
            this.changeRule();
        }

        this.state = 173;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,15,this._ctx);
        if(la_===1) {
            this.state = 164;
            this._errHandler.sync(this);
            var _alt = this._interp.adaptivePredict(this._input,13,this._ctx)
            while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
                if(_alt===1) {
                    this.state = 154; 
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                    do {
                        this.state = 153;
                        this.match(LscParser.NEWLINE);
                        this.state = 156; 
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                    } while(_la===LscParser.NEWLINE);
                    this.state = 160;
                    this._errHandler.sync(this);
                    switch(this._input.LA(1)) {
                    case LscParser.VALUE:
                        this.state = 158;
                        this.changeRule();
                        break;
                    case LscParser.ROMANIZER:
                        this.state = 159;
                        this.interRomanizer();
                        break;
                    default:
                        throw new antlr4.error.NoViableAltException(this);
                    } 
                }
                this.state = 166;
                this._errHandler.sync(this);
                _alt = this._interp.adaptivePredict(this._input,13,this._ctx);
            }

            this.state = 168; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            do {
                this.state = 167;
                this.match(LscParser.NEWLINE);
                this.state = 170; 
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            } while(_la===LscParser.NEWLINE);
            this.state = 172;
            this.changeRule();

        }
        this.state = 181;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,17,this._ctx);
        if(la_===1) {
            this.state = 176; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            do {
                this.state = 175;
                this.match(LscParser.NEWLINE);
                this.state = 178; 
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            } while(_la===LscParser.NEWLINE);
            this.state = 180;
            this.romanizer();

        }
        this.state = 186;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.NEWLINE) {
            this.state = 183;
            this.match(LscParser.NEWLINE);
            this.state = 188;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 189;
        this.match(LscParser.EOF);
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


ClassDeclContext.prototype.value = function() {
    return this.getTypedRuleContext(ValueContext,0);
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
    this.enterRule(localctx, 2, LscParser.RULE_classDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 191;
        this.match(LscParser.CLASS_DECL);
        this.state = 192;
        this.match(LscParser.WHITESPACE);
        this.state = 193;
        this.value();
        this.state = 194;
        this.match(LscParser.WHITESPACE);
        this.state = 195;
        this.match(LscParser.LIST_START);
        this.state = 196;
        this.classElement();
        this.state = 201;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 197;
            this.match(LscParser.SEP);
            this.state = 198;
            this.classElement();
            this.state = 203;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 204;
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
    this.enterRule(localctx, 4, LscParser.RULE_classElement);
    try {
        this.state = 208;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.CLASSREF:
            this.enterOuterAlt(localctx, 1);
            this.state = 206;
            this.classRef();
            break;
        case LscParser.FEATURE:
        case LscParser.VALUE:
        case LscParser.STR1:
        case LscParser.STR:
            this.enterOuterAlt(localctx, 2);
            this.state = 207;
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

FeatureDeclContext.prototype.WHITESPACE = function() {
    return this.getToken(LscParser.WHITESPACE, 0);
};

FeatureDeclContext.prototype.feature = function() {
    return this.getTypedRuleContext(FeatureContext,0);
};

FeatureDeclContext.prototype.O_PAREN = function() {
    return this.getToken(LscParser.O_PAREN, 0);
};

FeatureDeclContext.prototype.value = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ValueContext);
    } else {
        return this.getTypedRuleContext(ValueContext,i);
    }
};

FeatureDeclContext.prototype.C_PAREN = function() {
    return this.getToken(LscParser.C_PAREN, 0);
};

FeatureDeclContext.prototype.nullAlias = function() {
    return this.getTypedRuleContext(NullAliasContext,0);
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


FeatureDeclContext.prototype.CHANGE = function() {
    return this.getToken(LscParser.CHANGE, 0);
};

FeatureDeclContext.prototype.matrix = function() {
    return this.getTypedRuleContext(MatrixContext,0);
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
    this.enterRule(localctx, 6, LscParser.RULE_featureDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 210;
        this.match(LscParser.FEATURE_DECL);
        this.state = 211;
        this.match(LscParser.WHITESPACE);
        this.state = 212;
        this.feature();
        this.state = 213;
        this.match(LscParser.O_PAREN);
        this.state = 217;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.NULL) {
            this.state = 214;
            this.nullAlias();
            this.state = 215;
            this.match(LscParser.SEP);
        }

        this.state = 219;
        this.value();
        this.state = 224;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 220;
            this.match(LscParser.SEP);
            this.state = 221;
            this.value();
            this.state = 226;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 227;
        this.match(LscParser.C_PAREN);
        this.state = 230;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.CHANGE) {
            this.state = 228;
            this.match(LscParser.CHANGE);
            this.state = 229;
            this.matrix();
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

NullAliasContext.prototype.value = function() {
    return this.getTypedRuleContext(ValueContext,0);
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
    this.enterRule(localctx, 8, LscParser.RULE_nullAlias);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 232;
        this.match(LscParser.NULL);
        this.state = 233;
        this.value();
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


DiacriticDeclContext.prototype.STR1 = function() {
    return this.getToken(LscParser.STR1, 0);
};

DiacriticDeclContext.prototype.matrix = function() {
    return this.getTypedRuleContext(MatrixContext,0);
};

DiacriticDeclContext.prototype.DIA_BEFORE = function() {
    return this.getToken(LscParser.DIA_BEFORE, 0);
};

DiacriticDeclContext.prototype.DIA_FLOATING = function() {
    return this.getToken(LscParser.DIA_FLOATING, 0);
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
    this.enterRule(localctx, 10, LscParser.RULE_diacriticDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 235;
        this.match(LscParser.DIACRITIC);
        this.state = 236;
        this.match(LscParser.WHITESPACE);
        this.state = 237;
        this.match(LscParser.STR1);
        this.state = 238;
        this.match(LscParser.WHITESPACE);
        this.state = 241;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.DIA_BEFORE) {
            this.state = 239;
            this.match(LscParser.DIA_BEFORE);
            this.state = 240;
            this.match(LscParser.WHITESPACE);
        }

        this.state = 245;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.DIA_FLOATING) {
            this.state = 243;
            this.match(LscParser.DIA_FLOATING);
            this.state = 244;
            this.match(LscParser.WHITESPACE);
        }

        this.state = 247;
        this.matrix();
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
    this.enterRule(localctx, 12, LscParser.RULE_symbolDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 249;
        this.match(LscParser.SYMBOL);
        this.state = 250;
        this.match(LscParser.WHITESPACE);
        this.state = 251;
        this.symbolName();
        this.state = 261;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.SEP:
        case LscParser.NEWLINE:
            this.state = 256;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while(_la===LscParser.SEP) {
                this.state = 252;
                this.match(LscParser.SEP);
                this.state = 253;
                this.symbolName();
                this.state = 258;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            }
            break;
        case LscParser.WHITESPACE:
            this.state = 259;
            this.match(LscParser.WHITESPACE);
            this.state = 260;
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
    this.enterRule(localctx, 14, LscParser.RULE_symbolName);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 263;
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

DeromanizerContext.prototype.NEWLINE = function() {
    return this.getToken(LscParser.NEWLINE, 0);
};

DeromanizerContext.prototype.subrules = function() {
    return this.getTypedRuleContext(SubrulesContext,0);
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
    this.enterRule(localctx, 16, LscParser.RULE_deromanizer);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 265;
        this.match(LscParser.DEROMANIZER);
        this.state = 266;
        this.match(LscParser.RULE_START);
        this.state = 267;
        this.match(LscParser.NEWLINE);
        this.state = 268;
        this.subrules();
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

RomanizerContext.prototype.NEWLINE = function() {
    return this.getToken(LscParser.NEWLINE, 0);
};

RomanizerContext.prototype.subrules = function() {
    return this.getTypedRuleContext(SubrulesContext,0);
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
    this.enterRule(localctx, 18, LscParser.RULE_romanizer);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 270;
        this.match(LscParser.ROMANIZER);
        this.state = 271;
        this.match(LscParser.RULE_START);
        this.state = 272;
        this.match(LscParser.NEWLINE);
        this.state = 273;
        this.subrules();
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

InterRomanizerContext.prototype.NEWLINE = function() {
    return this.getToken(LscParser.NEWLINE, 0);
};

InterRomanizerContext.prototype.subrules = function() {
    return this.getTypedRuleContext(SubrulesContext,0);
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
    this.enterRule(localctx, 20, LscParser.RULE_interRomanizer);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 275;
        this.match(LscParser.ROMANIZER);
        this.state = 276;
        this.match(LscParser.HYPHEN);
        this.state = 277;
        this.ruleName();
        this.state = 278;
        this.match(LscParser.RULE_START);
        this.state = 279;
        this.match(LscParser.NEWLINE);
        this.state = 280;
        this.subrules();
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

ChangeRuleContext.prototype.RULE_START = function() {
    return this.getToken(LscParser.RULE_START, 0);
};

ChangeRuleContext.prototype.NEWLINE = function() {
    return this.getToken(LscParser.NEWLINE, 0);
};

ChangeRuleContext.prototype.subrules = function() {
    return this.getTypedRuleContext(SubrulesContext,0);
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


ChangeRuleContext.prototype.filter = function() {
    return this.getTypedRuleContext(FilterContext,0);
};

ChangeRuleContext.prototype.PROPAGATE = function() {
    return this.getToken(LscParser.PROPAGATE, 0);
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
    this.enterRule(localctx, 22, LscParser.RULE_changeRule);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 282;
        this.ruleName();
        this.state = 285;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,28,this._ctx);
        if(la_===1) {
            this.state = 283;
            this.match(LscParser.WHITESPACE);
            this.state = 284;
            this.filter();

        }
        this.state = 289;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.WHITESPACE) {
            this.state = 287;
            this.match(LscParser.WHITESPACE);
            this.state = 288;
            this.match(LscParser.PROPAGATE);
        }

        this.state = 291;
        this.match(LscParser.RULE_START);
        this.state = 292;
        this.match(LscParser.NEWLINE);
        this.state = 293;
        this.subrules();
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

FilterContext.prototype.matrix = function() {
    return this.getTypedRuleContext(MatrixContext,0);
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
    this.enterRule(localctx, 24, LscParser.RULE_filter);
    try {
        this.state = 297;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.CLASSREF:
            this.enterOuterAlt(localctx, 1);
            this.state = 295;
            this.classRef();
            break;
        case LscParser.MATRIX_START:
            this.enterOuterAlt(localctx, 2);
            this.state = 296;
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


function SubrulesContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_subrules;
    return this;
}

SubrulesContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SubrulesContext.prototype.constructor = SubrulesContext;

SubrulesContext.prototype.subrule = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(SubruleContext);
    } else {
        return this.getTypedRuleContext(SubruleContext,i);
    }
};

SubrulesContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


SubrulesContext.prototype.SUBRULE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.SUBRULE);
    } else {
        return this.getToken(LscParser.SUBRULE, i);
    }
};


SubrulesContext.prototype.RULE_START = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.RULE_START);
    } else {
        return this.getToken(LscParser.RULE_START, i);
    }
};


SubrulesContext.prototype.WHITESPACE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.WHITESPACE);
    } else {
        return this.getToken(LscParser.WHITESPACE, i);
    }
};


SubrulesContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitSubrules(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.SubrulesContext = SubrulesContext;

LscParser.prototype.subrules = function() {

    var localctx = new SubrulesContext(this, this._ctx, this.state);
    this.enterRule(localctx, 26, LscParser.RULE_subrules);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 299;
        this.subrule();
        this.state = 307;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,31,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                this.state = 300;
                this.match(LscParser.NEWLINE);
                this.state = 301;
                this.match(LscParser.SUBRULE);
                this.state = 302;
                this.match(LscParser.RULE_START);
                this.state = 303;
                _la = this._input.LA(1);
                if(!(_la===LscParser.NEWLINE || _la===LscParser.WHITESPACE)) {
                this._errHandler.recoverInline(this);
                }
                else {
                	this._errHandler.reportMatch(this);
                    this.consume();
                }
                this.state = 304;
                this.subrule(); 
            }
            this.state = 309;
            this._errHandler.sync(this);
            _alt = this._interp.adaptivePredict(this._input,31,this._ctx);
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


function SubruleContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_subrule;
    return this;
}

SubruleContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
SubruleContext.prototype.constructor = SubruleContext;

SubruleContext.prototype.expression = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ExpressionContext);
    } else {
        return this.getTypedRuleContext(ExpressionContext,i);
    }
};

SubruleContext.prototype.NEWLINE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.NEWLINE);
    } else {
        return this.getToken(LscParser.NEWLINE, i);
    }
};


SubruleContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitSubrule(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.SubruleContext = SubruleContext;

LscParser.prototype.subrule = function() {

    var localctx = new SubruleContext(this, this._ctx, this.state);
    this.enterRule(localctx, 28, LscParser.RULE_subrule);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 310;
        this.expression();
        this.state = 315;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,32,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                this.state = 311;
                this.match(LscParser.NEWLINE);
                this.state = 312;
                this.expression(); 
            }
            this.state = 317;
            this._errHandler.sync(this);
            _alt = this._interp.adaptivePredict(this._input,32,this._ctx);
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

RuleNameContext.prototype.VALUE = function(i) {
	if(i===undefined) {
		i = null;
	}
    if(i===null) {
        return this.getTokens(LscParser.VALUE);
    } else {
        return this.getToken(LscParser.VALUE, i);
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
    this.enterRule(localctx, 30, LscParser.RULE_ruleName);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 318;
        this.match(LscParser.VALUE);
        this.state = 323;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.HYPHEN) {
            this.state = 319;
            this.match(LscParser.HYPHEN);
            this.state = 320;
            this.match(LscParser.VALUE);
            this.state = 325;
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
    this.enterRule(localctx, 32, LscParser.RULE_expression);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 326;
        this.from();
        this.state = 327;
        this.match(LscParser.CHANGE);
        this.state = 328;
        this.to();
        this.state = 331;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.CONDITION) {
            this.state = 329;
            this.match(LscParser.CONDITION);
            this.state = 330;
            this.condition();
        }

        this.state = 335;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.EXCLUSION) {
            this.state = 333;
            this.match(LscParser.EXCLUSION);
            this.state = 334;
            this.exclusion();
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
    this.enterRule(localctx, 34, LscParser.RULE_condition);
    try {
        this.state = 339;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,36,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 337;
            this.environment();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 338;
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
    this.enterRule(localctx, 36, LscParser.RULE_exclusion);
    try {
        this.state = 343;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,37,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 341;
            this.environment();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 342;
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
    this.enterRule(localctx, 38, LscParser.RULE_from);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 345;
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
    this.enterRule(localctx, 40, LscParser.RULE_to);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 347;
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
    this.enterRule(localctx, 42, LscParser.RULE_environmentList);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 349;
        this.match(LscParser.LIST_START);
        this.state = 350;
        this.environment();
        this.state = 355;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 351;
            this.match(LscParser.SEP);
            this.state = 352;
            this.environment();
            this.state = 357;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 358;
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

EnvironmentContext.prototype.boundaryBefore = function() {
    return this.getTypedRuleContext(BoundaryBeforeContext,0);
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


EnvironmentContext.prototype.environmentBefore = function() {
    return this.getTypedRuleContext(EnvironmentBeforeContext,0);
};

EnvironmentContext.prototype.environmentAfter = function() {
    return this.getTypedRuleContext(EnvironmentAfterContext,0);
};

EnvironmentContext.prototype.boundaryAfter = function() {
    return this.getTypedRuleContext(BoundaryAfterContext,0);
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
    this.enterRule(localctx, 44, LscParser.RULE_environment);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 363;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,39,this._ctx);
        if(la_===1) {
            this.state = 360;
            this.boundaryBefore();
            this.state = 361;
            this.match(LscParser.WHITESPACE);

        }
        this.state = 368;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(((((_la - 9)) & ~0x1f) == 0 && ((1 << (_la - 9)) & ((1 << (LscParser.O_PAREN - 9)) | (1 << (LscParser.NULL - 9)) | (1 << (LscParser.MATRIX_START - 9)) | (1 << (LscParser.LIST_START - 9)) | (1 << (LscParser.NEGATION - 9)) | (1 << (LscParser.WORD_BOUNDARY - 9)) | (1 << (LscParser.CLASSREF - 9)) | (1 << (LscParser.FEATURE - 9)) | (1 << (LscParser.VALUE - 9)) | (1 << (LscParser.STR1 - 9)) | (1 << (LscParser.STR - 9)))) !== 0)) {
            this.state = 365;
            this.environmentBefore();
            this.state = 366;
            this.match(LscParser.WHITESPACE);
        }

        this.state = 370;
        this.match(LscParser.ANCHOR);
        this.state = 373;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,41,this._ctx);
        if(la_===1) {
            this.state = 371;
            this.match(LscParser.WHITESPACE);
            this.state = 372;
            this.environmentAfter();

        }
        this.state = 377;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.WHITESPACE) {
            this.state = 375;
            this.match(LscParser.WHITESPACE);
            this.state = 376;
            this.boundaryAfter();
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


function BoundaryBeforeContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_boundaryBefore;
    return this;
}

BoundaryBeforeContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
BoundaryBeforeContext.prototype.constructor = BoundaryBeforeContext;

BoundaryBeforeContext.prototype.WORD_BOUNDARY = function() {
    return this.getToken(LscParser.WORD_BOUNDARY, 0);
};

BoundaryBeforeContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitBoundaryBefore(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.BoundaryBeforeContext = BoundaryBeforeContext;

LscParser.prototype.boundaryBefore = function() {

    var localctx = new BoundaryBeforeContext(this, this._ctx, this.state);
    this.enterRule(localctx, 46, LscParser.RULE_boundaryBefore);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 379;
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


function BoundaryAfterContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_boundaryAfter;
    return this;
}

BoundaryAfterContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
BoundaryAfterContext.prototype.constructor = BoundaryAfterContext;

BoundaryAfterContext.prototype.WORD_BOUNDARY = function() {
    return this.getToken(LscParser.WORD_BOUNDARY, 0);
};

BoundaryAfterContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitBoundaryAfter(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.BoundaryAfterContext = BoundaryAfterContext;

LscParser.prototype.boundaryAfter = function() {

    var localctx = new BoundaryAfterContext(this, this._ctx, this.state);
    this.enterRule(localctx, 48, LscParser.RULE_boundaryAfter);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 381;
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
    this.enterRule(localctx, 50, LscParser.RULE_environmentBefore);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 383;
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
    this.enterRule(localctx, 52, LscParser.RULE_environmentAfter);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 385;
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
    this.enterRule(localctx, 54, LscParser.RULE_ruleElement);
    try {
        this.state = 393;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,43,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 387;
            this.capture();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 388;
            this.repeater();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 389;
            this.group();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 390;
            this.list();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 391;
            this.simple();
            break;

        case 6:
            this.enterOuterAlt(localctx, 6);
            this.state = 392;
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
    this.enterRule(localctx, 56, LscParser.RULE_sequence);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 395;
        this.sequenceElement();
        this.state = 398; 
        this._errHandler.sync(this);
        var _alt = 1;
        do {
        	switch (_alt) {
        	case 1:
        		this.state = 396;
        		this.match(LscParser.WHITESPACE);
        		this.state = 397;
        		this.sequenceElement();
        		break;
        	default:
        		throw new antlr4.error.NoViableAltException(this);
        	}
        	this.state = 400; 
        	this._errHandler.sync(this);
        	_alt = this._interp.adaptivePredict(this._input,44, this._ctx);
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
    this.enterRule(localctx, 58, LscParser.RULE_sequenceElement);
    try {
        this.state = 407;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,45,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 402;
            this.capture();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 403;
            this.repeater();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 404;
            this.group();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 405;
            this.list();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 406;
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
    this.enterRule(localctx, 60, LscParser.RULE_capture);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 414;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.O_PAREN:
            this.state = 409;
            this.group();
            break;
        case LscParser.LIST_START:
            this.state = 410;
            this.list();
            break;
        case LscParser.NEGATION:
            this.state = 411;
            this.negated();
            break;
        case LscParser.CLASSREF:
            this.state = 412;
            this.classRef();
            break;
        case LscParser.MATRIX_START:
            this.state = 413;
            this.fancyMatrix();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
        this.state = 416;
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
    this.enterRule(localctx, 62, LscParser.RULE_repeater);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 421;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.O_PAREN:
            this.state = 418;
            this.group();
            break;
        case LscParser.LIST_START:
            this.state = 419;
            this.list();
            break;
        case LscParser.NULL:
        case LscParser.MATRIX_START:
        case LscParser.NEGATION:
        case LscParser.WORD_BOUNDARY:
        case LscParser.CLASSREF:
        case LscParser.FEATURE:
        case LscParser.VALUE:
        case LscParser.STR1:
        case LscParser.STR:
            this.state = 420;
            this.simple();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
        this.state = 423;
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
    this.enterRule(localctx, 64, LscParser.RULE_group);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 425;
        this.match(LscParser.O_PAREN);
        this.state = 426;
        this.ruleElement();
        this.state = 427;
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
    this.enterRule(localctx, 66, LscParser.RULE_list);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 429;
        this.match(LscParser.LIST_START);
        this.state = 430;
        this.ruleElement();
        this.state = 435;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 431;
            this.match(LscParser.SEP);
            this.state = 432;
            this.ruleElement();
            this.state = 437;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 438;
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
    this.enterRule(localctx, 68, LscParser.RULE_simple);
    try {
        this.state = 446;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.NEGATION:
            this.enterOuterAlt(localctx, 1);
            this.state = 440;
            this.negated();
            break;
        case LscParser.CLASSREF:
            this.enterOuterAlt(localctx, 2);
            this.state = 441;
            this.classRef();
            break;
        case LscParser.WORD_BOUNDARY:
            this.enterOuterAlt(localctx, 3);
            this.state = 442;
            this.captureRef();
            break;
        case LscParser.MATRIX_START:
            this.enterOuterAlt(localctx, 4);
            this.state = 443;
            this.fancyMatrix();
            break;
        case LscParser.NULL:
            this.enterOuterAlt(localctx, 5);
            this.state = 444;
            this.empty();
            break;
        case LscParser.FEATURE:
        case LscParser.VALUE:
        case LscParser.STR1:
        case LscParser.STR:
            this.enterOuterAlt(localctx, 6);
            this.state = 445;
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
    this.enterRule(localctx, 70, LscParser.RULE_negated);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 448;
        this.match(LscParser.NEGATION);
        this.state = 449;
        this.classRef();
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

ClassRefContext.prototype.value = function() {
    return this.getTypedRuleContext(ValueContext,0);
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
    this.enterRule(localctx, 72, LscParser.RULE_classRef);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 451;
        this.match(LscParser.CLASSREF);
        this.state = 452;
        this.value();
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
    this.enterRule(localctx, 74, LscParser.RULE_captureRef);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 454;
        this.match(LscParser.WORD_BOUNDARY);
        this.state = 455;
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
    this.enterRule(localctx, 76, LscParser.RULE_fancyMatrix);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 457;
        this.match(LscParser.MATRIX_START);
        this.state = 459;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(((((_la - 11)) & ~0x1f) == 0 && ((1 << (_la - 11)) & ((1 << (LscParser.NULL - 11)) | (1 << (LscParser.NEGATION - 11)) | (1 << (LscParser.WORD_BOUNDARY - 11)) | (1 << (LscParser.VALUE - 11)))) !== 0)) {
            this.state = 458;
            this.fancyValue();
        }

        this.state = 465;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.WHITESPACE) {
            this.state = 461;
            this.match(LscParser.WHITESPACE);
            this.state = 462;
            this.fancyValue();
            this.state = 467;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 468;
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

FancyValueContext.prototype.value = function() {
    return this.getTypedRuleContext(ValueContext,0);
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
    this.enterRule(localctx, 78, LscParser.RULE_fancyValue);
    try {
        this.state = 474;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.VALUE:
            this.enterOuterAlt(localctx, 1);
            this.state = 470;
            this.value();
            break;
        case LscParser.NEGATION:
            this.enterOuterAlt(localctx, 2);
            this.state = 471;
            this.negatedValue();
            break;
        case LscParser.NULL:
            this.enterOuterAlt(localctx, 3);
            this.state = 472;
            this.absentFeature();
            break;
        case LscParser.WORD_BOUNDARY:
            this.enterOuterAlt(localctx, 4);
            this.state = 473;
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

NegatedValueContext.prototype.value = function() {
    return this.getTypedRuleContext(ValueContext,0);
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
    this.enterRule(localctx, 80, LscParser.RULE_negatedValue);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 476;
        this.match(LscParser.NEGATION);
        this.state = 477;
        this.value();
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

AbsentFeatureContext.prototype.feature = function() {
    return this.getTypedRuleContext(FeatureContext,0);
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
    this.enterRule(localctx, 82, LscParser.RULE_absentFeature);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 479;
        this.match(LscParser.NULL);
        this.state = 480;
        this.feature();
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

FeatureVariableContext.prototype.feature = function() {
    return this.getTypedRuleContext(FeatureContext,0);
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
    this.enterRule(localctx, 84, LscParser.RULE_featureVariable);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 482;
        this.match(LscParser.WORD_BOUNDARY);
        this.state = 483;
        this.feature();
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
    this.enterRule(localctx, 86, LscParser.RULE_empty);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 485;
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
    this.enterRule(localctx, 88, LscParser.RULE_repeaterType);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 487;
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

MatrixContext.prototype.value = function(i) {
    if(i===undefined) {
        i = null;
    }
    if(i===null) {
        return this.getTypedRuleContexts(ValueContext);
    } else {
        return this.getTypedRuleContext(ValueContext,i);
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
    this.enterRule(localctx, 90, LscParser.RULE_matrix);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 489;
        this.match(LscParser.MATRIX_START);
        this.state = 491;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.VALUE) {
            this.state = 490;
            this.value();
        }

        this.state = 497;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.WHITESPACE) {
            this.state = 493;
            this.match(LscParser.WHITESPACE);
            this.state = 494;
            this.value();
            this.state = 499;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 500;
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


function FeatureContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_feature;
    return this;
}

FeatureContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
FeatureContext.prototype.constructor = FeatureContext;

FeatureContext.prototype.FEATURE = function() {
    return this.getToken(LscParser.FEATURE, 0);
};

FeatureContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitFeature(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.FeatureContext = FeatureContext;

LscParser.prototype.feature = function() {

    var localctx = new FeatureContext(this, this._ctx, this.state);
    this.enterRule(localctx, 92, LscParser.RULE_feature);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 502;
        this.match(LscParser.FEATURE);
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


function ValueContext(parser, parent, invokingState) {
	if(parent===undefined) {
	    parent = null;
	}
	if(invokingState===undefined || invokingState===null) {
		invokingState = -1;
	}
	antlr4.ParserRuleContext.call(this, parent, invokingState);
    this.parser = parser;
    this.ruleIndex = LscParser.RULE_value;
    return this;
}

ValueContext.prototype = Object.create(antlr4.ParserRuleContext.prototype);
ValueContext.prototype.constructor = ValueContext;

ValueContext.prototype.VALUE = function() {
    return this.getToken(LscParser.VALUE, 0);
};

ValueContext.prototype.accept = function(visitor) {
    if ( visitor instanceof LscVisitor ) {
        return visitor.visitValue(this);
    } else {
        return visitor.visitChildren(this);
    }
};




LscParser.ValueContext = ValueContext;

LscParser.prototype.value = function() {

    var localctx = new ValueContext(this, this._ctx, this.state);
    this.enterRule(localctx, 94, LscParser.RULE_value);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 504;
        this.match(LscParser.VALUE);
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

TextContext.prototype.FEATURE = function() {
    return this.getToken(LscParser.FEATURE, 0);
};

TextContext.prototype.VALUE = function() {
    return this.getToken(LscParser.VALUE, 0);
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
    this.enterRule(localctx, 96, LscParser.RULE_text);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 506;
        _la = this._input.LA(1);
        if(!(((((_la - 33)) & ~0x1f) == 0 && ((1 << (_la - 33)) & ((1 << (LscParser.FEATURE - 33)) | (1 << (LscParser.VALUE - 33)) | (1 << (LscParser.STR1 - 33)) | (1 << (LscParser.STR - 33)))) !== 0))) {
        this._errHandler.recoverInline(this);
        }
        else {
        	this._errHandler.reportMatch(this);
            this.consume();
        }
        this.state = 508;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.NEGATION) {
            this.state = 507;
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
