// Generated from Lsc.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');
var LscVisitor = require('./LscVisitor').LscVisitor;

var grammarFileName = "Lsc.g4";


var serializedATN = ["\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964",
    "\u0003)\u0209\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t",
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
    "3\t3\u00044\t4\u0003\u0002\u0003\u0002\u0007\u0002k\n\u0002\f\u0002",
    "\u000e\u0002n\u000b\u0002\u0003\u0002\u0005\u0002q\n\u0002\u0003\u0002",
    "\u0006\u0002t\n\u0002\r\u0002\u000e\u0002u\u0003\u0002\u0007\u0002y",
    "\n\u0002\f\u0002\u000e\u0002|\u000b\u0002\u0003\u0002\u0007\u0002\u007f",
    "\n\u0002\f\u0002\u000e\u0002\u0082\u000b\u0002\u0003\u0002\u0005\u0002",
    "\u0085\n\u0002\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003",
    "\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0005\u0003\u008f\n\u0003",
    "\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004",
    "\u0003\u0004\u0003\u0004\u0007\u0004\u0099\n\u0004\f\u0004\u000e\u0004",
    "\u009c\u000b\u0004\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005\u0005",
    "\u0005\u00a2\n\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006",
    "\u0005\u0006\u00a8\n\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003",
    "\u0006\u0005\u0006\u00ae\n\u0006\u0003\u0006\u0003\u0006\u0003\u0006",
    "\u0007\u0006\u00b3\n\u0006\f\u0006\u000e\u0006\u00b6\u000b\u0006\u0003",
    "\u0006\u0003\u0006\u0003\u0006\u0005\u0006\u00bb\n\u0006\u0003\u0007",
    "\u0003\u0007\u0003\u0007\u0003\b\u0003\b\u0003\b\u0003\b\u0003\b\u0003",
    "\b\u0003\b\u0007\b\u00c7\n\b\f\b\u000e\b\u00ca\u000b\b\u0003\b\u0003",
    "\b\u0003\b\u0007\b\u00cf\n\b\f\b\u000e\b\u00d2\u000b\b\u0003\t\u0003",
    "\t\u0003\n\u0003\n\u0003\n\u0003\n\u0003\n\u0007\n\u00db\n\n\f\n\u000e",
    "\n\u00de\u000b\n\u0003\n\u0003\n\u0005\n\u00e2\n\n\u0003\u000b\u0003",
    "\u000b\u0003\f\u0003\f\u0003\f\u0005\f\u00e9\n\f\u0003\f\u0003\f\u0006",
    "\f\u00ed\n\f\r\f\u000e\f\u00ee\u0003\f\u0003\f\u0003\r\u0003\r\u0003",
    "\r\u0005\r\u00f6\n\r\u0003\r\u0003\r\u0006\r\u00fa\n\r\r\r\u000e\r\u00fb",
    "\u0003\r\u0003\r\u0003\u000e\u0003\u000e\u0003\u000e\u0003\u000e\u0003",
    "\u000e\u0005\u000e\u0105\n\u000e\u0003\u000e\u0003\u000e\u0006\u000e",
    "\u0109\n\u000e\r\u000e\u000e\u000e\u010a\u0003\u000e\u0003\u000e\u0003",
    "\u000f\u0003\u000f\u0003\u000f\u0007\u000f\u0112\n\u000f\f\u000f\u000e",
    "\u000f\u0115\u000b\u000f\u0003\u000f\u0005\u000f\u0118\n\u000f\u0003",
    "\u000f\u0006\u000f\u011b\n\u000f\r\u000f\u000e\u000f\u011c\u0003\u000f",
    "\u0003\u000f\u0003\u0010\u0003\u0010\u0005\u0010\u0123\n\u0010\u0003",
    "\u0011\u0003\u0011\u0005\u0011\u0127\n\u0011\u0003\u0012\u0003\u0012",
    "\u0006\u0012\u012b\n\u0012\r\u0012\u000e\u0012\u012c\u0003\u0012\u0003",
    "\u0012\u0003\u0012\u0003\u0012\u0006\u0012\u0133\n\u0012\r\u0012\u000e",
    "\u0012\u0134\u0005\u0012\u0137\n\u0012\u0003\u0012\u0007\u0012\u013a",
    "\n\u0012\f\u0012\u000e\u0012\u013d\u000b\u0012\u0003\u0013\u0003\u0013",
    "\u0006\u0013\u0141\n\u0013\r\u0013\u000e\u0013\u0142\u0003\u0013\u0007",
    "\u0013\u0146\n\u0013\f\u0013\u000e\u0013\u0149\u000b\u0013\u0003\u0014",
    "\u0003\u0014\u0003\u0014\u0007\u0014\u014e\n\u0014\f\u0014\u000e\u0014",
    "\u0151\u000b\u0014\u0003\u0015\u0003\u0015\u0003\u0015\u0003\u0015\u0003",
    "\u0015\u0003\u0015\u0005\u0015\u0159\n\u0015\u0003\u0015\u0003\u0015",
    "\u0005\u0015\u015d\n\u0015\u0005\u0015\u015f\n\u0015\u0003\u0016\u0003",
    "\u0016\u0005\u0016\u0163\n\u0016\u0003\u0017\u0003\u0017\u0005\u0017",
    "\u0167\n\u0017\u0003\u0018\u0003\u0018\u0003\u0019\u0003\u0019\u0003",
    "\u001a\u0003\u001a\u0003\u001a\u0003\u001a\u0007\u001a\u0171\n\u001a",
    "\f\u001a\u000e\u001a\u0174\u000b\u001a\u0003\u001a\u0003\u001a\u0003",
    "\u001b\u0003\u001b\u0003\u001b\u0005\u001b\u017b\n\u001b\u0003\u001b",
    "\u0003\u001b\u0003\u001b\u0005\u001b\u0180\n\u001b\u0003\u001b\u0005",
    "\u001b\u0183\n\u001b\u0005\u001b\u0185\n\u001b\u0003\u001c\u0003\u001c",
    "\u0003\u001d\u0003\u001d\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001e",
    "\u0003\u001e\u0003\u001e\u0005\u001e\u0191\n\u001e\u0003\u001f\u0003",
    "\u001f\u0003\u001f\u0006\u001f\u0196\n\u001f\r\u001f\u000e\u001f\u0197",
    "\u0003 \u0003 \u0003 \u0003 \u0003 \u0005 \u019f\n \u0003!\u0003!\u0003",
    "!\u0003!\u0003!\u0005!\u01a6\n!\u0003!\u0003!\u0003\"\u0003\"\u0003",
    "\"\u0005\"\u01ad\n\"\u0003\"\u0003\"\u0003#\u0003#\u0003#\u0003#\u0003",
    "$\u0003$\u0003$\u0003$\u0007$\u01b9\n$\f$\u000e$\u01bc\u000b$\u0003",
    "$\u0003$\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0005%\u01c7",
    "\n%\u0003&\u0003&\u0003&\u0003\'\u0003\'\u0003\'\u0003(\u0003(\u0003",
    "(\u0003)\u0003)\u0005)\u01d4\n)\u0003)\u0003)\u0007)\u01d8\n)\f)\u000e",
    ")\u01db\u000b)\u0003)\u0003)\u0003*\u0003*\u0003*\u0003*\u0005*\u01e3",
    "\n*\u0003+\u0003+\u0003+\u0003,\u0003,\u0003,\u0003-\u0003-\u0003-\u0003",
    ".\u0003.\u0003/\u0003/\u00030\u00030\u00031\u00031\u00051\u01f6\n1\u0003",
    "1\u00031\u00071\u01fa\n1\f1\u000e1\u01fd\u000b1\u00031\u00031\u0003",
    "2\u00032\u00033\u00033\u00034\u00034\u00054\u0207\n4\u00034\u0002\u0002",
    "5\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a",
    "\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdf\u0002\u0005\u0003",
    "\u0002\u001c\u001d\u0004\u0002\r\r\u0012\u0013\u0004\u0002%&()\u0002",
    "\u0227\u0002\u0084\u0003\u0002\u0002\u0002\u0004\u008e\u0003\u0002\u0002",
    "\u0002\u0006\u0090\u0003\u0002\u0002\u0002\b\u00a1\u0003\u0002\u0002",
    "\u0002\n\u00a3\u0003\u0002\u0002\u0002\f\u00bc\u0003\u0002\u0002\u0002",
    "\u000e\u00bf\u0003\u0002\u0002\u0002\u0010\u00d3\u0003\u0002\u0002\u0002",
    "\u0012\u00d5\u0003\u0002\u0002\u0002\u0014\u00e3\u0003\u0002\u0002\u0002",
    "\u0016\u00e5\u0003\u0002\u0002\u0002\u0018\u00f2\u0003\u0002\u0002\u0002",
    "\u001a\u00ff\u0003\u0002\u0002\u0002\u001c\u010e\u0003\u0002\u0002\u0002",
    "\u001e\u0122\u0003\u0002\u0002\u0002 \u0126\u0003\u0002\u0002\u0002",
    "\"\u0128\u0003\u0002\u0002\u0002$\u013e\u0003\u0002\u0002\u0002&\u014a",
    "\u0003\u0002\u0002\u0002(\u015e\u0003\u0002\u0002\u0002*\u0162\u0003",
    "\u0002\u0002\u0002,\u0166\u0003\u0002\u0002\u0002.\u0168\u0003\u0002",
    "\u0002\u00020\u016a\u0003\u0002\u0002\u00022\u016c\u0003\u0002\u0002",
    "\u00024\u0184\u0003\u0002\u0002\u00026\u0186\u0003\u0002\u0002\u0002",
    "8\u0188\u0003\u0002\u0002\u0002:\u0190\u0003\u0002\u0002\u0002<\u0192",
    "\u0003\u0002\u0002\u0002>\u019e\u0003\u0002\u0002\u0002@\u01a5\u0003",
    "\u0002\u0002\u0002B\u01ac\u0003\u0002\u0002\u0002D\u01b0\u0003\u0002",
    "\u0002\u0002F\u01b4\u0003\u0002\u0002\u0002H\u01c6\u0003\u0002\u0002",
    "\u0002J\u01c8\u0003\u0002\u0002\u0002L\u01cb\u0003\u0002\u0002\u0002",
    "N\u01ce\u0003\u0002\u0002\u0002P\u01d1\u0003\u0002\u0002\u0002R\u01e2",
    "\u0003\u0002\u0002\u0002T\u01e4\u0003\u0002\u0002\u0002V\u01e7\u0003",
    "\u0002\u0002\u0002X\u01ea\u0003\u0002\u0002\u0002Z\u01ed\u0003\u0002",
    "\u0002\u0002\\\u01ef\u0003\u0002\u0002\u0002^\u01f1\u0003\u0002\u0002",
    "\u0002`\u01f3\u0003\u0002\u0002\u0002b\u0200\u0003\u0002\u0002\u0002",
    "d\u0202\u0003\u0002\u0002\u0002f\u0204\u0003\u0002\u0002\u0002h\u0085",
    "\u0007\n\u0002\u0002ik\u0007\t\u0002\u0002ji\u0003\u0002\u0002\u0002",
    "kn\u0003\u0002\u0002\u0002lj\u0003\u0002\u0002\u0002lm\u0003\u0002\u0002",
    "\u0002mp\u0003\u0002\u0002\u0002nl\u0003\u0002\u0002\u0002oq\u0005\u0004",
    "\u0003\u0002po\u0003\u0002\u0002\u0002pq\u0003\u0002\u0002\u0002qz\u0003",
    "\u0002\u0002\u0002rt\u0007\t\u0002\u0002sr\u0003\u0002\u0002\u0002t",
    "u\u0003\u0002\u0002\u0002us\u0003\u0002\u0002\u0002uv\u0003\u0002\u0002",
    "\u0002vw\u0003\u0002\u0002\u0002wy\u0005\u0004\u0003\u0002xs\u0003\u0002",
    "\u0002\u0002y|\u0003\u0002\u0002\u0002zx\u0003\u0002\u0002\u0002z{\u0003",
    "\u0002\u0002\u0002{\u0080\u0003\u0002\u0002\u0002|z\u0003\u0002\u0002",
    "\u0002}\u007f\u0007\t\u0002\u0002~}\u0003\u0002\u0002\u0002\u007f\u0082",
    "\u0003\u0002\u0002\u0002\u0080~\u0003\u0002\u0002\u0002\u0080\u0081",
    "\u0003\u0002\u0002\u0002\u0081\u0083\u0003\u0002\u0002\u0002\u0082\u0080",
    "\u0003\u0002\u0002\u0002\u0083\u0085\u0007\u0002\u0002\u0003\u0084h",
    "\u0003\u0002\u0002\u0002\u0084l\u0003\u0002\u0002\u0002\u0085\u0003",
    "\u0003\u0002\u0002\u0002\u0086\u008f\u0005\n\u0006\u0002\u0087\u008f",
    "\u0005\u000e\b\u0002\u0088\u008f\u0005\u0012\n\u0002\u0089\u008f\u0005",
    "\u0006\u0004\u0002\u008a\u008f\u0005\u0016\f\u0002\u008b\u008f\u0005",
    "\u001c\u000f\u0002\u008c\u008f\u0005\u001a\u000e\u0002\u008d\u008f\u0005",
    "\u0018\r\u0002\u008e\u0086\u0003\u0002\u0002\u0002\u008e\u0087\u0003",
    "\u0002\u0002\u0002\u008e\u0088\u0003\u0002\u0002\u0002\u008e\u0089\u0003",
    "\u0002\u0002\u0002\u008e\u008a\u0003\u0002\u0002\u0002\u008e\u008b\u0003",
    "\u0002\u0002\u0002\u008e\u008c\u0003\u0002\u0002\u0002\u008e\u008d\u0003",
    "\u0002\u0002\u0002\u008f\u0005\u0003\u0002\u0002\u0002\u0090\u0091\u0007",
    "\u0019\u0002\u0002\u0091\u0092\u0007\n\u0002\u0002\u0092\u0093\u0005",
    "d3\u0002\u0093\u0094\u0007\n\u0002\u0002\u0094\u0095\u0007\u0010\u0002",
    "\u0002\u0095\u009a\u0005\b\u0005\u0002\u0096\u0097\u0007\u0004\u0002",
    "\u0002\u0097\u0099\u0005\b\u0005\u0002\u0098\u0096\u0003\u0002\u0002",
    "\u0002\u0099\u009c\u0003\u0002\u0002\u0002\u009a\u0098\u0003\u0002\u0002",
    "\u0002\u009a\u009b\u0003\u0002\u0002\u0002\u009b\u009d\u0003\u0002\u0002",
    "\u0002\u009c\u009a\u0003\u0002\u0002\u0002\u009d\u009e\u0007\u0011\u0002",
    "\u0002\u009e\u0007\u0003\u0002\u0002\u0002\u009f\u00a2\u0005L\'\u0002",
    "\u00a0\u00a2\u0005f4\u0002\u00a1\u009f\u0003\u0002\u0002\u0002\u00a1",
    "\u00a0\u0003\u0002\u0002\u0002\u00a2\t\u0003\u0002\u0002\u0002\u00a3",
    "\u00a4\u0007\u001a\u0002\u0002\u00a4\u00a5\u0007\n\u0002\u0002\u00a5",
    "\u00a7\u0005b2\u0002\u00a6\u00a8\u0007\n\u0002\u0002\u00a7\u00a6\u0003",
    "\u0002\u0002\u0002\u00a7\u00a8\u0003\u0002\u0002\u0002\u00a8\u00a9\u0003",
    "\u0002\u0002\u0002\u00a9\u00ad\u0007\u000b\u0002\u0002\u00aa\u00ab\u0005",
    "\f\u0007\u0002\u00ab\u00ac\u0007\u0004\u0002\u0002\u00ac\u00ae\u0003",
    "\u0002\u0002\u0002\u00ad\u00aa\u0003\u0002\u0002\u0002\u00ad\u00ae\u0003",
    "\u0002\u0002\u0002\u00ae\u00af\u0003\u0002\u0002\u0002\u00af\u00b4\u0005",
    "d3\u0002\u00b0\u00b1\u0007\u0004\u0002\u0002\u00b1\u00b3\u0005d3\u0002",
    "\u00b2\u00b0\u0003\u0002\u0002\u0002\u00b3\u00b6\u0003\u0002\u0002\u0002",
    "\u00b4\u00b2\u0003\u0002\u0002\u0002\u00b4\u00b5\u0003\u0002\u0002\u0002",
    "\u00b5\u00b7\u0003\u0002\u0002\u0002\u00b6\u00b4\u0003\u0002\u0002\u0002",
    "\u00b7\u00ba\u0007\f\u0002\u0002\u00b8\u00b9\u0007\u0005\u0002\u0002",
    "\u00b9\u00bb\u0005`1\u0002\u00ba\u00b8\u0003\u0002\u0002\u0002\u00ba",
    "\u00bb\u0003\u0002\u0002\u0002\u00bb\u000b\u0003\u0002\u0002\u0002\u00bc",
    "\u00bd\u0007\r\u0002\u0002\u00bd\u00be\u0005d3\u0002\u00be\r\u0003\u0002",
    "\u0002\u0002\u00bf\u00c0\u0007\u001b\u0002\u0002\u00c0\u00c1\u0007\n",
    "\u0002\u0002\u00c1\u00c2\u0007(\u0002\u0002\u00c2\u00c8\u0007\n\u0002",
    "\u0002\u00c3\u00c4\u0005\u0010\t\u0002\u00c4\u00c5\u0007\n\u0002\u0002",
    "\u00c5\u00c7\u0003\u0002\u0002\u0002\u00c6\u00c3\u0003\u0002\u0002\u0002",
    "\u00c7\u00ca\u0003\u0002\u0002\u0002\u00c8\u00c6\u0003\u0002\u0002\u0002",
    "\u00c8\u00c9\u0003\u0002\u0002\u0002\u00c9\u00cb\u0003\u0002\u0002\u0002",
    "\u00ca\u00c8\u0003\u0002\u0002\u0002\u00cb\u00d0\u0005`1\u0002\u00cc",
    "\u00cd\u0007\n\u0002\u0002\u00cd\u00cf\u0005\u0010\t\u0002\u00ce\u00cc",
    "\u0003\u0002\u0002\u0002\u00cf\u00d2\u0003\u0002\u0002\u0002\u00d0\u00ce",
    "\u0003\u0002\u0002\u0002\u00d0\u00d1\u0003\u0002\u0002\u0002\u00d1\u000f",
    "\u0003\u0002\u0002\u0002\u00d2\u00d0\u0003\u0002\u0002\u0002\u00d3\u00d4",
    "\t\u0002\u0002\u0002\u00d4\u0011\u0003\u0002\u0002\u0002\u00d5\u00d6",
    "\u0007\u001e\u0002\u0002\u00d6\u00d7\u0007\n\u0002\u0002\u00d7\u00e1",
    "\u0005\u0014\u000b\u0002\u00d8\u00d9\u0007\u0004\u0002\u0002\u00d9\u00db",
    "\u0005\u0014\u000b\u0002\u00da\u00d8\u0003\u0002\u0002\u0002\u00db\u00de",
    "\u0003\u0002\u0002\u0002\u00dc\u00da\u0003\u0002\u0002\u0002\u00dc\u00dd",
    "\u0003\u0002\u0002\u0002\u00dd\u00e2\u0003\u0002\u0002\u0002\u00de\u00dc",
    "\u0003\u0002\u0002\u0002\u00df\u00e0\u0007\n\u0002\u0002\u00e0\u00e2",
    "\u0005`1\u0002\u00e1\u00dc\u0003\u0002\u0002\u0002\u00e1\u00df\u0003",
    "\u0002\u0002\u0002\u00e2\u0013\u0003\u0002\u0002\u0002\u00e3\u00e4\u0005",
    "f4\u0002\u00e4\u0015\u0003\u0002\u0002\u0002\u00e5\u00e8\u0007\u001f",
    "\u0002\u0002\u00e6\u00e7\u0007\n\u0002\u0002\u00e7\u00e9\u0007#\u0002",
    "\u0002\u00e8\u00e6\u0003\u0002\u0002\u0002\u00e8\u00e9\u0003\u0002\u0002",
    "\u0002\u00e9\u00ea\u0003\u0002\u0002\u0002\u00ea\u00ec\u0007\u0015\u0002",
    "\u0002\u00eb\u00ed\u0007\t\u0002\u0002\u00ec\u00eb\u0003\u0002\u0002",
    "\u0002\u00ed\u00ee\u0003\u0002\u0002\u0002\u00ee\u00ec\u0003\u0002\u0002",
    "\u0002\u00ee\u00ef\u0003\u0002\u0002\u0002\u00ef\u00f0\u0003\u0002\u0002",
    "\u0002\u00f0\u00f1\u0005\"\u0012\u0002\u00f1\u0017\u0003\u0002\u0002",
    "\u0002\u00f2\u00f5\u0007 \u0002\u0002\u00f3\u00f4\u0007\n\u0002\u0002",
    "\u00f4\u00f6\u0007#\u0002\u0002\u00f5\u00f3\u0003\u0002\u0002\u0002",
    "\u00f5\u00f6\u0003\u0002\u0002\u0002\u00f6\u00f7\u0003\u0002\u0002\u0002",
    "\u00f7\u00f9\u0007\u0015\u0002\u0002\u00f8\u00fa\u0007\t\u0002\u0002",
    "\u00f9\u00f8\u0003\u0002\u0002\u0002\u00fa\u00fb\u0003\u0002\u0002\u0002",
    "\u00fb\u00f9\u0003\u0002\u0002\u0002\u00fb\u00fc\u0003\u0002\u0002\u0002",
    "\u00fc\u00fd\u0003\u0002\u0002\u0002\u00fd\u00fe\u0005\"\u0012\u0002",
    "\u00fe\u0019\u0003\u0002\u0002\u0002\u00ff\u0100\u0007 \u0002\u0002",
    "\u0100\u0101\u0007\u0014\u0002\u0002\u0101\u0104\u0005&\u0014\u0002",
    "\u0102\u0103\u0007\n\u0002\u0002\u0103\u0105\u0007#\u0002\u0002\u0104",
    "\u0102\u0003\u0002\u0002\u0002\u0104\u0105\u0003\u0002\u0002\u0002\u0105",
    "\u0106\u0003\u0002\u0002\u0002\u0106\u0108\u0007\u0015\u0002\u0002\u0107",
    "\u0109\u0007\t\u0002\u0002\u0108\u0107\u0003\u0002\u0002\u0002\u0109",
    "\u010a\u0003\u0002\u0002\u0002\u010a\u0108\u0003\u0002\u0002\u0002\u010a",
    "\u010b\u0003\u0002\u0002\u0002\u010b\u010c\u0003\u0002\u0002\u0002\u010c",
    "\u010d\u0005\"\u0012\u0002\u010d\u001b\u0003\u0002\u0002\u0002\u010e",
    "\u0113\u0005&\u0014\u0002\u010f\u0110\u0007\n\u0002\u0002\u0110\u0112",
    "\u0005\u001e\u0010\u0002\u0111\u010f\u0003\u0002\u0002\u0002\u0112\u0115",
    "\u0003\u0002\u0002\u0002\u0113\u0111\u0003\u0002\u0002\u0002\u0113\u0114",
    "\u0003\u0002\u0002\u0002\u0114\u0117\u0003\u0002\u0002\u0002\u0115\u0113",
    "\u0003\u0002\u0002\u0002\u0116\u0118\u0007\u0015\u0002\u0002\u0117\u0116",
    "\u0003\u0002\u0002\u0002\u0117\u0118\u0003\u0002\u0002\u0002\u0118\u011a",
    "\u0003\u0002\u0002\u0002\u0119\u011b\u0007\t\u0002\u0002\u011a\u0119",
    "\u0003\u0002\u0002\u0002\u011b\u011c\u0003\u0002\u0002\u0002\u011c\u011a",
    "\u0003\u0002\u0002\u0002\u011c\u011d\u0003\u0002\u0002\u0002\u011d\u011e",
    "\u0003\u0002\u0002\u0002\u011e\u011f\u0005\"\u0012\u0002\u011f\u001d",
    "\u0003\u0002\u0002\u0002\u0120\u0123\u0005 \u0011\u0002\u0121\u0123",
    "\u0007\"\u0002\u0002\u0122\u0120\u0003\u0002\u0002\u0002\u0122\u0121",
    "\u0003\u0002\u0002\u0002\u0123\u001f\u0003\u0002\u0002\u0002\u0124\u0127",
    "\u0005L\'\u0002\u0125\u0127\u0005`1\u0002\u0126\u0124\u0003\u0002\u0002",
    "\u0002\u0126\u0125\u0003\u0002\u0002\u0002\u0127!\u0003\u0002\u0002",
    "\u0002\u0128\u013b\u0005$\u0013\u0002\u0129\u012b\u0007\t\u0002\u0002",
    "\u012a\u0129\u0003\u0002\u0002\u0002\u012b\u012c\u0003\u0002\u0002\u0002",
    "\u012c\u012a\u0003\u0002\u0002\u0002\u012c\u012d\u0003\u0002\u0002\u0002",
    "\u012d\u012e\u0003\u0002\u0002\u0002\u012e\u012f\u0007!\u0002\u0002",
    "\u012f\u0136\u0007\u0015\u0002\u0002\u0130\u0137\u0007\n\u0002\u0002",
    "\u0131\u0133\u0007\t\u0002\u0002\u0132\u0131\u0003\u0002\u0002\u0002",
    "\u0133\u0134\u0003\u0002\u0002\u0002\u0134\u0132\u0003\u0002\u0002\u0002",
    "\u0134\u0135\u0003\u0002\u0002\u0002\u0135\u0137\u0003\u0002\u0002\u0002",
    "\u0136\u0130\u0003\u0002\u0002\u0002\u0136\u0132\u0003\u0002\u0002\u0002",
    "\u0137\u0138\u0003\u0002\u0002\u0002\u0138\u013a\u0005$\u0013\u0002",
    "\u0139\u012a\u0003\u0002\u0002\u0002\u013a\u013d\u0003\u0002\u0002\u0002",
    "\u013b\u0139\u0003\u0002\u0002\u0002\u013b\u013c\u0003\u0002\u0002\u0002",
    "\u013c#\u0003\u0002\u0002\u0002\u013d\u013b\u0003\u0002\u0002\u0002",
    "\u013e\u0147\u0005(\u0015\u0002\u013f\u0141\u0007\t\u0002\u0002\u0140",
    "\u013f\u0003\u0002\u0002\u0002\u0141\u0142\u0003\u0002\u0002\u0002\u0142",
    "\u0140\u0003\u0002\u0002\u0002\u0142\u0143\u0003\u0002\u0002\u0002\u0143",
    "\u0144\u0003\u0002\u0002\u0002\u0144\u0146\u0005(\u0015\u0002\u0145",
    "\u0140\u0003\u0002\u0002\u0002\u0146\u0149\u0003\u0002\u0002\u0002\u0147",
    "\u0145\u0003\u0002\u0002\u0002\u0147\u0148\u0003\u0002\u0002\u0002\u0148",
    "%\u0003\u0002\u0002\u0002\u0149\u0147\u0003\u0002\u0002\u0002\u014a",
    "\u014f\u0007&\u0002\u0002\u014b\u014c\u0007\u0014\u0002\u0002\u014c",
    "\u014e\u0007&\u0002\u0002\u014d\u014b\u0003\u0002\u0002\u0002\u014e",
    "\u0151\u0003\u0002\u0002\u0002\u014f\u014d\u0003\u0002\u0002\u0002\u014f",
    "\u0150\u0003\u0002\u0002\u0002\u0150\'\u0003\u0002\u0002\u0002\u0151",
    "\u014f\u0003\u0002\u0002\u0002\u0152\u015f\u0007$\u0002\u0002\u0153",
    "\u0154\u0005.\u0018\u0002\u0154\u0155\u0007\u0005\u0002\u0002\u0155",
    "\u0158\u00050\u0019\u0002\u0156\u0157\u0007\u0006\u0002\u0002\u0157",
    "\u0159\u0005*\u0016\u0002\u0158\u0156\u0003\u0002\u0002\u0002\u0158",
    "\u0159\u0003\u0002\u0002\u0002\u0159\u015c\u0003\u0002\u0002\u0002\u015a",
    "\u015b\u0007\u0007\u0002\u0002\u015b\u015d\u0005,\u0017\u0002\u015c",
    "\u015a\u0003\u0002\u0002\u0002\u015c\u015d\u0003\u0002\u0002\u0002\u015d",
    "\u015f\u0003\u0002\u0002\u0002\u015e\u0152\u0003\u0002\u0002\u0002\u015e",
    "\u0153\u0003\u0002\u0002\u0002\u015f)\u0003\u0002\u0002\u0002\u0160",
    "\u0163\u00054\u001b\u0002\u0161\u0163\u00052\u001a\u0002\u0162\u0160",
    "\u0003\u0002\u0002\u0002\u0162\u0161\u0003\u0002\u0002\u0002\u0163+",
    "\u0003\u0002\u0002\u0002\u0164\u0167\u00054\u001b\u0002\u0165\u0167",
    "\u00052\u001a\u0002\u0166\u0164\u0003\u0002\u0002\u0002\u0166\u0165",
    "\u0003\u0002\u0002\u0002\u0167-\u0003\u0002\u0002\u0002\u0168\u0169",
    "\u0005:\u001e\u0002\u0169/\u0003\u0002\u0002\u0002\u016a\u016b\u0005",
    ":\u001e\u0002\u016b1\u0003\u0002\u0002\u0002\u016c\u016d\u0007\u0010",
    "\u0002\u0002\u016d\u0172\u00054\u001b\u0002\u016e\u016f\u0007\u0004",
    "\u0002\u0002\u016f\u0171\u00054\u001b\u0002\u0170\u016e\u0003\u0002",
    "\u0002\u0002\u0171\u0174\u0003\u0002\u0002\u0002\u0172\u0170\u0003\u0002",
    "\u0002\u0002\u0172\u0173\u0003\u0002\u0002\u0002\u0173\u0175\u0003\u0002",
    "\u0002\u0002\u0174\u0172\u0003\u0002\u0002\u0002\u0175\u0176\u0007\u0011",
    "\u0002\u0002\u01763\u0003\u0002\u0002\u0002\u0177\u0178\u00056\u001c",
    "\u0002\u0178\u0179\u0007\n\u0002\u0002\u0179\u017b\u0003\u0002\u0002",
    "\u0002\u017a\u0177\u0003\u0002\u0002\u0002\u017a\u017b\u0003\u0002\u0002",
    "\u0002\u017b\u017c\u0003\u0002\u0002\u0002\u017c\u017f\u0007\b\u0002",
    "\u0002\u017d\u017e\u0007\n\u0002\u0002\u017e\u0180\u00058\u001d\u0002",
    "\u017f\u017d\u0003\u0002\u0002\u0002\u017f\u0180\u0003\u0002\u0002\u0002",
    "\u0180\u0185\u0003\u0002\u0002\u0002\u0181\u0183\u00056\u001c\u0002",
    "\u0182\u0181\u0003\u0002\u0002\u0002\u0182\u0183\u0003\u0002\u0002\u0002",
    "\u0183\u0185\u0003\u0002\u0002\u0002\u0184\u017a\u0003\u0002\u0002\u0002",
    "\u0184\u0182\u0003\u0002\u0002\u0002\u01855\u0003\u0002\u0002\u0002",
    "\u0186\u0187\u0005:\u001e\u0002\u01877\u0003\u0002\u0002\u0002\u0188",
    "\u0189\u0005:\u001e\u0002\u01899\u0003\u0002\u0002\u0002\u018a\u0191",
    "\u0005@!\u0002\u018b\u0191\u0005B\"\u0002\u018c\u0191\u0005D#\u0002",
    "\u018d\u0191\u0005F$\u0002\u018e\u0191\u0005H%\u0002\u018f\u0191\u0005",
    "<\u001f\u0002\u0190\u018a\u0003\u0002\u0002\u0002\u0190\u018b\u0003",
    "\u0002\u0002\u0002\u0190\u018c\u0003\u0002\u0002\u0002\u0190\u018d\u0003",
    "\u0002\u0002\u0002\u0190\u018e\u0003\u0002\u0002\u0002\u0190\u018f\u0003",
    "\u0002\u0002\u0002\u0191;\u0003\u0002\u0002\u0002\u0192\u0195\u0005",
    "> \u0002\u0193\u0194\u0007\n\u0002\u0002\u0194\u0196\u0005> \u0002\u0195",
    "\u0193\u0003\u0002\u0002\u0002\u0196\u0197\u0003\u0002\u0002\u0002\u0197",
    "\u0195\u0003\u0002\u0002\u0002\u0197\u0198\u0003\u0002\u0002\u0002\u0198",
    "=\u0003\u0002\u0002\u0002\u0199\u019f\u0005@!\u0002\u019a\u019f\u0005",
    "B\"\u0002\u019b\u019f\u0005D#\u0002\u019c\u019f\u0005F$\u0002\u019d",
    "\u019f\u0005H%\u0002\u019e\u0199\u0003\u0002\u0002\u0002\u019e\u019a",
    "\u0003\u0002\u0002\u0002\u019e\u019b\u0003\u0002\u0002\u0002\u019e\u019c",
    "\u0003\u0002\u0002\u0002\u019e\u019d\u0003\u0002\u0002\u0002\u019f?",
    "\u0003\u0002\u0002\u0002\u01a0\u01a6\u0005D#\u0002\u01a1\u01a6\u0005",
    "F$\u0002\u01a2\u01a6\u0005J&\u0002\u01a3\u01a6\u0005L\'\u0002\u01a4",
    "\u01a6\u0005P)\u0002\u01a5\u01a0\u0003\u0002\u0002\u0002\u01a5\u01a1",
    "\u0003\u0002\u0002\u0002\u01a5\u01a2\u0003\u0002\u0002\u0002\u01a5\u01a3",
    "\u0003\u0002\u0002\u0002\u01a5\u01a4\u0003\u0002\u0002\u0002\u01a6\u01a7",
    "\u0003\u0002\u0002\u0002\u01a7\u01a8\u0005N(\u0002\u01a8A\u0003\u0002",
    "\u0002\u0002\u01a9\u01ad\u0005D#\u0002\u01aa\u01ad\u0005F$\u0002\u01ab",
    "\u01ad\u0005H%\u0002\u01ac\u01a9\u0003\u0002\u0002\u0002\u01ac\u01aa",
    "\u0003\u0002\u0002\u0002\u01ac\u01ab\u0003\u0002\u0002\u0002\u01ad\u01ae",
    "\u0003\u0002\u0002\u0002\u01ae\u01af\u0005^0\u0002\u01afC\u0003\u0002",
    "\u0002\u0002\u01b0\u01b1\u0007\u000b\u0002\u0002\u01b1\u01b2\u0005:",
    "\u001e\u0002\u01b2\u01b3\u0007\f\u0002\u0002\u01b3E\u0003\u0002\u0002",
    "\u0002\u01b4\u01b5\u0007\u0010\u0002\u0002\u01b5\u01ba\u0005:\u001e",
    "\u0002\u01b6\u01b7\u0007\u0004\u0002\u0002\u01b7\u01b9\u0005:\u001e",
    "\u0002\u01b8\u01b6\u0003\u0002\u0002\u0002\u01b9\u01bc\u0003\u0002\u0002",
    "\u0002\u01ba\u01b8\u0003\u0002\u0002\u0002\u01ba\u01bb\u0003\u0002\u0002",
    "\u0002\u01bb\u01bd\u0003\u0002\u0002\u0002\u01bc\u01ba\u0003\u0002\u0002",
    "\u0002\u01bd\u01be\u0007\u0011\u0002\u0002\u01beG\u0003\u0002\u0002",
    "\u0002\u01bf\u01c7\u0005J&\u0002\u01c0\u01c7\u0005L\'\u0002\u01c1\u01c7",
    "\u0005N(\u0002\u01c2\u01c7\u0005P)\u0002\u01c3\u01c7\u0005Z.\u0002\u01c4",
    "\u01c7\u0005\\/\u0002\u01c5\u01c7\u0005f4\u0002\u01c6\u01bf\u0003\u0002",
    "\u0002\u0002\u01c6\u01c0\u0003\u0002\u0002\u0002\u01c6\u01c1\u0003\u0002",
    "\u0002\u0002\u01c6\u01c2\u0003\u0002\u0002\u0002\u01c6\u01c3\u0003\u0002",
    "\u0002\u0002\u01c6\u01c4\u0003\u0002\u0002\u0002\u01c6\u01c5\u0003\u0002",
    "\u0002\u0002\u01c7I\u0003\u0002\u0002\u0002\u01c8\u01c9\u0007\u0016",
    "\u0002\u0002\u01c9\u01ca\u0005L\'\u0002\u01caK\u0003\u0002\u0002\u0002",
    "\u01cb\u01cc\u0007\u0018\u0002\u0002\u01cc\u01cd\u0005d3\u0002\u01cd",
    "M\u0003\u0002\u0002\u0002\u01ce\u01cf\u0007\u0017\u0002\u0002\u01cf",
    "\u01d0\u0007\'\u0002\u0002\u01d0O\u0003\u0002\u0002\u0002\u01d1\u01d3",
    "\u0007\u000e\u0002\u0002\u01d2\u01d4\u0005R*\u0002\u01d3\u01d2\u0003",
    "\u0002\u0002\u0002\u01d3\u01d4\u0003\u0002\u0002\u0002\u01d4\u01d9\u0003",
    "\u0002\u0002\u0002\u01d5\u01d6\u0007\n\u0002\u0002\u01d6\u01d8\u0005",
    "R*\u0002\u01d7\u01d5\u0003\u0002\u0002\u0002\u01d8\u01db\u0003\u0002",
    "\u0002\u0002\u01d9\u01d7\u0003\u0002\u0002\u0002\u01d9\u01da\u0003\u0002",
    "\u0002\u0002\u01da\u01dc\u0003\u0002\u0002\u0002\u01db\u01d9\u0003\u0002",
    "\u0002\u0002\u01dc\u01dd\u0007\u000f\u0002\u0002\u01ddQ\u0003\u0002",
    "\u0002\u0002\u01de\u01e3\u0005d3\u0002\u01df\u01e3\u0005T+\u0002\u01e0",
    "\u01e3\u0005V,\u0002\u01e1\u01e3\u0005X-\u0002\u01e2\u01de\u0003\u0002",
    "\u0002\u0002\u01e2\u01df\u0003\u0002\u0002\u0002\u01e2\u01e0\u0003\u0002",
    "\u0002\u0002\u01e2\u01e1\u0003\u0002\u0002\u0002\u01e3S\u0003\u0002",
    "\u0002\u0002\u01e4\u01e5\u0007\u0016\u0002\u0002\u01e5\u01e6\u0005d",
    "3\u0002\u01e6U\u0003\u0002\u0002\u0002\u01e7\u01e8\u0007\r\u0002\u0002",
    "\u01e8\u01e9\u0005b2\u0002\u01e9W\u0003\u0002\u0002\u0002\u01ea\u01eb",
    "\u0007\u0017\u0002\u0002\u01eb\u01ec\u0005b2\u0002\u01ecY\u0003\u0002",
    "\u0002\u0002\u01ed\u01ee\u0007\r\u0002\u0002\u01ee[\u0003\u0002\u0002",
    "\u0002\u01ef\u01f0\u0007\u0017\u0002\u0002\u01f0]\u0003\u0002\u0002",
    "\u0002\u01f1\u01f2\t\u0003\u0002\u0002\u01f2_\u0003\u0002\u0002\u0002",
    "\u01f3\u01f5\u0007\u000e\u0002\u0002\u01f4\u01f6\u0005d3\u0002\u01f5",
    "\u01f4\u0003\u0002\u0002\u0002\u01f5\u01f6\u0003\u0002\u0002\u0002\u01f6",
    "\u01fb\u0003\u0002\u0002\u0002\u01f7\u01f8\u0007\n\u0002\u0002\u01f8",
    "\u01fa\u0005d3\u0002\u01f9\u01f7\u0003\u0002\u0002\u0002\u01fa\u01fd",
    "\u0003\u0002\u0002\u0002\u01fb\u01f9\u0003\u0002\u0002\u0002\u01fb\u01fc",
    "\u0003\u0002\u0002\u0002\u01fc\u01fe\u0003\u0002\u0002\u0002\u01fd\u01fb",
    "\u0003\u0002\u0002\u0002\u01fe\u01ff\u0007\u000f\u0002\u0002\u01ffa",
    "\u0003\u0002\u0002\u0002\u0200\u0201\u0007%\u0002\u0002\u0201c\u0003",
    "\u0002\u0002\u0002\u0202\u0203\u0007&\u0002\u0002\u0203e\u0003\u0002",
    "\u0002\u0002\u0204\u0206\t\u0004\u0002\u0002\u0205\u0207\u0007\u0016",
    "\u0002\u0002\u0206\u0205\u0003\u0002\u0002\u0002\u0206\u0207\u0003\u0002",
    "\u0002\u0002\u0207g\u0003\u0002\u0002\u0002<lpuz\u0080\u0084\u008e\u009a",
    "\u00a1\u00a7\u00ad\u00b4\u00ba\u00c8\u00d0\u00dc\u00e1\u00e8\u00ee\u00f5",
    "\u00fb\u0104\u010a\u0113\u0117\u011c\u0122\u0126\u012c\u0134\u0136\u013b",
    "\u0142\u0147\u014f\u0158\u015c\u015e\u0162\u0166\u0172\u017a\u017f\u0182",
    "\u0184\u0190\u0197\u019e\u01a5\u01ac\u01ba\u01c6\u01d3\u01d9\u01e2\u01f5",
    "\u01fb\u0206"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

var sharedContextCache = new antlr4.PredictionContextCache();

var literalNames = [ null, null, null, null, null, null, "'_'", null, null, 
                     "'('", "')'", "'*'", "'['", "']'", "'{'", "'}'", "'+'", 
                     "'?'", "'-'", "':'", "'!'", "'$'", "'@'" ];

var symbolicNames = [ null, "COMMENT", "SEP", "CHANGE", "CONDITION", "EXCLUSION", 
                      "ANCHOR", "NEWLINE", "WHITESPACE", "O_PAREN", "C_PAREN", 
                      "NULL", "MATRIX_START", "MATRIX_END", "LIST_START", 
                      "LIST_END", "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
                      "RULE_START", "NEGATION", "WORD_BOUNDARY", "CLASSREF", 
                      "CLASS_DECL", "FEATURE_DECL", "DIACRITIC", "DIA_BEFORE", 
                      "DIA_FLOATING", "SYMBOL", "DEROMANIZER", "ROMANIZER", 
                      "SUBRULE", "PROPAGATE", "LITERAL", "UNCHANGED", "FEATURE", 
                      "VALUE", "NUMBER", "STR1", "STR" ];

var ruleNames =  [ "lscFile", "statement", "classDecl", "classElement", 
                   "featureDecl", "nullAlias", "diacriticDecl", "diacriticModifier", 
                   "symbolDecl", "symbolName", "deromanizer", "romanizer", 
                   "interRomanizer", "changeRule", "changeRuleModifier", 
                   "filter", "subrules", "subrule", "ruleName", "expression", 
                   "condition", "exclusion", "from", "to", "environmentList", 
                   "environment", "environmentBefore", "environmentAfter", 
                   "ruleElement", "sequence", "sequenceElement", "capture", 
                   "repeater", "group", "list", "simple", "negated", "classRef", 
                   "captureRef", "fancyMatrix", "fancyValue", "negatedValue", 
                   "absentFeature", "featureVariable", "empty", "boundary", 
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
LscParser.LITERAL = 33;
LscParser.UNCHANGED = 34;
LscParser.FEATURE = 35;
LscParser.VALUE = 36;
LscParser.NUMBER = 37;
LscParser.STR1 = 38;
LscParser.STR = 39;

LscParser.RULE_lscFile = 0;
LscParser.RULE_statement = 1;
LscParser.RULE_classDecl = 2;
LscParser.RULE_classElement = 3;
LscParser.RULE_featureDecl = 4;
LscParser.RULE_nullAlias = 5;
LscParser.RULE_diacriticDecl = 6;
LscParser.RULE_diacriticModifier = 7;
LscParser.RULE_symbolDecl = 8;
LscParser.RULE_symbolName = 9;
LscParser.RULE_deromanizer = 10;
LscParser.RULE_romanizer = 11;
LscParser.RULE_interRomanizer = 12;
LscParser.RULE_changeRule = 13;
LscParser.RULE_changeRuleModifier = 14;
LscParser.RULE_filter = 15;
LscParser.RULE_subrules = 16;
LscParser.RULE_subrule = 17;
LscParser.RULE_ruleName = 18;
LscParser.RULE_expression = 19;
LscParser.RULE_condition = 20;
LscParser.RULE_exclusion = 21;
LscParser.RULE_from = 22;
LscParser.RULE_to = 23;
LscParser.RULE_environmentList = 24;
LscParser.RULE_environment = 25;
LscParser.RULE_environmentBefore = 26;
LscParser.RULE_environmentAfter = 27;
LscParser.RULE_ruleElement = 28;
LscParser.RULE_sequence = 29;
LscParser.RULE_sequenceElement = 30;
LscParser.RULE_capture = 31;
LscParser.RULE_repeater = 32;
LscParser.RULE_group = 33;
LscParser.RULE_list = 34;
LscParser.RULE_simple = 35;
LscParser.RULE_negated = 36;
LscParser.RULE_classRef = 37;
LscParser.RULE_captureRef = 38;
LscParser.RULE_fancyMatrix = 39;
LscParser.RULE_fancyValue = 40;
LscParser.RULE_negatedValue = 41;
LscParser.RULE_absentFeature = 42;
LscParser.RULE_featureVariable = 43;
LscParser.RULE_empty = 44;
LscParser.RULE_boundary = 45;
LscParser.RULE_repeaterType = 46;
LscParser.RULE_matrix = 47;
LscParser.RULE_feature = 48;
LscParser.RULE_value = 49;
LscParser.RULE_text = 50;


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
        this.state = 130;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.WHITESPACE:
            this.enterOuterAlt(localctx, 1);
            this.state = 102;
            this.match(LscParser.WHITESPACE);
            break;
        case LscParser.EOF:
        case LscParser.NEWLINE:
        case LscParser.CLASS_DECL:
        case LscParser.FEATURE_DECL:
        case LscParser.DIACRITIC:
        case LscParser.SYMBOL:
        case LscParser.DEROMANIZER:
        case LscParser.ROMANIZER:
        case LscParser.VALUE:
            this.enterOuterAlt(localctx, 2);
            this.state = 106;
            this._errHandler.sync(this);
            var _alt = this._interp.adaptivePredict(this._input,0,this._ctx)
            while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
                if(_alt===1) {
                    this.state = 103;
                    this.match(LscParser.NEWLINE); 
                }
                this.state = 108;
                this._errHandler.sync(this);
                _alt = this._interp.adaptivePredict(this._input,0,this._ctx);
            }

            this.state = 110;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(((((_la - 23)) & ~0x1f) == 0 && ((1 << (_la - 23)) & ((1 << (LscParser.CLASS_DECL - 23)) | (1 << (LscParser.FEATURE_DECL - 23)) | (1 << (LscParser.DIACRITIC - 23)) | (1 << (LscParser.SYMBOL - 23)) | (1 << (LscParser.DEROMANIZER - 23)) | (1 << (LscParser.ROMANIZER - 23)) | (1 << (LscParser.VALUE - 23)))) !== 0)) {
                this.state = 109;
                this.statement();
            }

            this.state = 120;
            this._errHandler.sync(this);
            var _alt = this._interp.adaptivePredict(this._input,3,this._ctx)
            while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
                if(_alt===1) {
                    this.state = 113; 
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                    do {
                        this.state = 112;
                        this.match(LscParser.NEWLINE);
                        this.state = 115; 
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                    } while(_la===LscParser.NEWLINE);
                    this.state = 117;
                    this.statement(); 
                }
                this.state = 122;
                this._errHandler.sync(this);
                _alt = this._interp.adaptivePredict(this._input,3,this._ctx);
            }

            this.state = 126;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while(_la===LscParser.NEWLINE) {
                this.state = 123;
                this.match(LscParser.NEWLINE);
                this.state = 128;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            }
            this.state = 129;
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
        this.state = 140;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,6,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 132;
            this.featureDecl();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 133;
            this.diacriticDecl();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 134;
            this.symbolDecl();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 135;
            this.classDecl();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 136;
            this.deromanizer();
            break;

        case 6:
            this.enterOuterAlt(localctx, 6);
            this.state = 137;
            this.changeRule();
            break;

        case 7:
            this.enterOuterAlt(localctx, 7);
            this.state = 138;
            this.interRomanizer();
            break;

        case 8:
            this.enterOuterAlt(localctx, 8);
            this.state = 139;
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
    this.enterRule(localctx, 4, LscParser.RULE_classDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 142;
        this.match(LscParser.CLASS_DECL);
        this.state = 143;
        this.match(LscParser.WHITESPACE);
        this.state = 144;
        this.value();
        this.state = 145;
        this.match(LscParser.WHITESPACE);
        this.state = 146;
        this.match(LscParser.LIST_START);
        this.state = 147;
        this.classElement();
        this.state = 152;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 148;
            this.match(LscParser.SEP);
            this.state = 149;
            this.classElement();
            this.state = 154;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 155;
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
        this.state = 159;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.CLASSREF:
            this.enterOuterAlt(localctx, 1);
            this.state = 157;
            this.classRef();
            break;
        case LscParser.FEATURE:
        case LscParser.VALUE:
        case LscParser.STR1:
        case LscParser.STR:
            this.enterOuterAlt(localctx, 2);
            this.state = 158;
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
    this.enterRule(localctx, 8, LscParser.RULE_featureDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 161;
        this.match(LscParser.FEATURE_DECL);
        this.state = 162;
        this.match(LscParser.WHITESPACE);
        this.state = 163;
        this.feature();
        this.state = 165;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.WHITESPACE) {
            this.state = 164;
            this.match(LscParser.WHITESPACE);
        }

        this.state = 167;
        this.match(LscParser.O_PAREN);
        this.state = 171;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.NULL) {
            this.state = 168;
            this.nullAlias();
            this.state = 169;
            this.match(LscParser.SEP);
        }

        this.state = 173;
        this.value();
        this.state = 178;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 174;
            this.match(LscParser.SEP);
            this.state = 175;
            this.value();
            this.state = 180;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 181;
        this.match(LscParser.C_PAREN);
        this.state = 184;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.CHANGE) {
            this.state = 182;
            this.match(LscParser.CHANGE);
            this.state = 183;
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
    this.enterRule(localctx, 10, LscParser.RULE_nullAlias);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 186;
        this.match(LscParser.NULL);
        this.state = 187;
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
    this.enterRule(localctx, 12, LscParser.RULE_diacriticDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 189;
        this.match(LscParser.DIACRITIC);
        this.state = 190;
        this.match(LscParser.WHITESPACE);
        this.state = 191;
        this.match(LscParser.STR1);
        this.state = 192;
        this.match(LscParser.WHITESPACE);
        this.state = 198;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.DIA_BEFORE || _la===LscParser.DIA_FLOATING) {
            this.state = 193;
            this.diacriticModifier();
            this.state = 194;
            this.match(LscParser.WHITESPACE);
            this.state = 200;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 201;
        this.matrix();
        this.state = 206;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.WHITESPACE) {
            this.state = 202;
            this.match(LscParser.WHITESPACE);
            this.state = 203;
            this.diacriticModifier();
            this.state = 208;
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
    this.enterRule(localctx, 14, LscParser.RULE_diacriticModifier);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 209;
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
    this.enterRule(localctx, 16, LscParser.RULE_symbolDecl);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 211;
        this.match(LscParser.SYMBOL);
        this.state = 212;
        this.match(LscParser.WHITESPACE);
        this.state = 213;
        this.symbolName();
        this.state = 223;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.EOF:
        case LscParser.SEP:
        case LscParser.NEWLINE:
            this.state = 218;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            while(_la===LscParser.SEP) {
                this.state = 214;
                this.match(LscParser.SEP);
                this.state = 215;
                this.symbolName();
                this.state = 220;
                this._errHandler.sync(this);
                _la = this._input.LA(1);
            }
            break;
        case LscParser.WHITESPACE:
            this.state = 221;
            this.match(LscParser.WHITESPACE);
            this.state = 222;
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
    this.enterRule(localctx, 18, LscParser.RULE_symbolName);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 225;
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

DeromanizerContext.prototype.subrules = function() {
    return this.getTypedRuleContext(SubrulesContext,0);
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
    this.enterRule(localctx, 20, LscParser.RULE_deromanizer);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 227;
        this.match(LscParser.DEROMANIZER);
        this.state = 230;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.WHITESPACE) {
            this.state = 228;
            this.match(LscParser.WHITESPACE);
            this.state = 229;
            this.match(LscParser.LITERAL);
        }

        this.state = 232;
        this.match(LscParser.RULE_START);
        this.state = 234; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 233;
            this.match(LscParser.NEWLINE);
            this.state = 236; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LscParser.NEWLINE);
        this.state = 238;
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

RomanizerContext.prototype.subrules = function() {
    return this.getTypedRuleContext(SubrulesContext,0);
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
    this.enterRule(localctx, 22, LscParser.RULE_romanizer);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 240;
        this.match(LscParser.ROMANIZER);
        this.state = 243;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.WHITESPACE) {
            this.state = 241;
            this.match(LscParser.WHITESPACE);
            this.state = 242;
            this.match(LscParser.LITERAL);
        }

        this.state = 245;
        this.match(LscParser.RULE_START);
        this.state = 247; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 246;
            this.match(LscParser.NEWLINE);
            this.state = 249; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LscParser.NEWLINE);
        this.state = 251;
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

InterRomanizerContext.prototype.subrules = function() {
    return this.getTypedRuleContext(SubrulesContext,0);
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
    this.enterRule(localctx, 24, LscParser.RULE_interRomanizer);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 253;
        this.match(LscParser.ROMANIZER);
        this.state = 254;
        this.match(LscParser.HYPHEN);
        this.state = 255;
        this.ruleName();
        this.state = 258;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.WHITESPACE) {
            this.state = 256;
            this.match(LscParser.WHITESPACE);
            this.state = 257;
            this.match(LscParser.LITERAL);
        }

        this.state = 260;
        this.match(LscParser.RULE_START);
        this.state = 262; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 261;
            this.match(LscParser.NEWLINE);
            this.state = 264; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LscParser.NEWLINE);
        this.state = 266;
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
    this.enterRule(localctx, 26, LscParser.RULE_changeRule);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 268;
        this.ruleName();
        this.state = 273;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.WHITESPACE) {
            this.state = 269;
            this.match(LscParser.WHITESPACE);
            this.state = 270;
            this.changeRuleModifier();
            this.state = 275;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 277;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.RULE_START) {
            this.state = 276;
            this.match(LscParser.RULE_START);
        }

        this.state = 280; 
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        do {
            this.state = 279;
            this.match(LscParser.NEWLINE);
            this.state = 282; 
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        } while(_la===LscParser.NEWLINE);
        this.state = 284;
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
    this.enterRule(localctx, 28, LscParser.RULE_changeRuleModifier);
    try {
        this.state = 288;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.MATRIX_START:
        case LscParser.CLASSREF:
            this.enterOuterAlt(localctx, 1);
            this.state = 286;
            this.filter();
            break;
        case LscParser.PROPAGATE:
            this.enterOuterAlt(localctx, 2);
            this.state = 287;
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
    this.enterRule(localctx, 30, LscParser.RULE_filter);
    try {
        this.state = 292;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.CLASSREF:
            this.enterOuterAlt(localctx, 1);
            this.state = 290;
            this.classRef();
            break;
        case LscParser.MATRIX_START:
            this.enterOuterAlt(localctx, 2);
            this.state = 291;
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
    this.enterRule(localctx, 32, LscParser.RULE_subrules);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 294;
        this.subrule();
        this.state = 313;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,31,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                this.state = 296; 
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                do {
                    this.state = 295;
                    this.match(LscParser.NEWLINE);
                    this.state = 298; 
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                } while(_la===LscParser.NEWLINE);
                this.state = 300;
                this.match(LscParser.SUBRULE);
                this.state = 301;
                this.match(LscParser.RULE_START);
                this.state = 308;
                this._errHandler.sync(this);
                switch(this._input.LA(1)) {
                case LscParser.WHITESPACE:
                    this.state = 302;
                    this.match(LscParser.WHITESPACE);
                    break;
                case LscParser.NEWLINE:
                    this.state = 304; 
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                    do {
                        this.state = 303;
                        this.match(LscParser.NEWLINE);
                        this.state = 306; 
                        this._errHandler.sync(this);
                        _la = this._input.LA(1);
                    } while(_la===LscParser.NEWLINE);
                    break;
                default:
                    throw new antlr4.error.NoViableAltException(this);
                }
                this.state = 310;
                this.subrule(); 
            }
            this.state = 315;
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
    this.enterRule(localctx, 34, LscParser.RULE_subrule);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 316;
        this.expression();
        this.state = 325;
        this._errHandler.sync(this);
        var _alt = this._interp.adaptivePredict(this._input,33,this._ctx)
        while(_alt!=2 && _alt!=antlr4.atn.ATN.INVALID_ALT_NUMBER) {
            if(_alt===1) {
                this.state = 318; 
                this._errHandler.sync(this);
                _la = this._input.LA(1);
                do {
                    this.state = 317;
                    this.match(LscParser.NEWLINE);
                    this.state = 320; 
                    this._errHandler.sync(this);
                    _la = this._input.LA(1);
                } while(_la===LscParser.NEWLINE);
                this.state = 322;
                this.expression(); 
            }
            this.state = 327;
            this._errHandler.sync(this);
            _alt = this._interp.adaptivePredict(this._input,33,this._ctx);
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
    this.enterRule(localctx, 36, LscParser.RULE_ruleName);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 328;
        this.match(LscParser.VALUE);
        this.state = 333;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.HYPHEN) {
            this.state = 329;
            this.match(LscParser.HYPHEN);
            this.state = 330;
            this.match(LscParser.VALUE);
            this.state = 335;
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
    this.enterRule(localctx, 38, LscParser.RULE_expression);
    var _la = 0; // Token type
    try {
        this.state = 348;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.UNCHANGED:
            this.enterOuterAlt(localctx, 1);
            this.state = 336;
            this.match(LscParser.UNCHANGED);
            break;
        case LscParser.O_PAREN:
        case LscParser.NULL:
        case LscParser.MATRIX_START:
        case LscParser.LIST_START:
        case LscParser.NEGATION:
        case LscParser.WORD_BOUNDARY:
        case LscParser.CLASSREF:
        case LscParser.FEATURE:
        case LscParser.VALUE:
        case LscParser.STR1:
        case LscParser.STR:
            this.enterOuterAlt(localctx, 2);
            this.state = 337;
            this.from();
            this.state = 338;
            this.match(LscParser.CHANGE);
            this.state = 339;
            this.to();
            this.state = 342;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(_la===LscParser.CONDITION) {
                this.state = 340;
                this.match(LscParser.CONDITION);
                this.state = 341;
                this.condition();
            }

            this.state = 346;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(_la===LscParser.EXCLUSION) {
                this.state = 344;
                this.match(LscParser.EXCLUSION);
                this.state = 345;
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
    this.enterRule(localctx, 40, LscParser.RULE_condition);
    try {
        this.state = 352;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,38,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 350;
            this.environment();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 351;
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
    this.enterRule(localctx, 42, LscParser.RULE_exclusion);
    try {
        this.state = 356;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,39,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 354;
            this.environment();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 355;
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
    this.enterRule(localctx, 44, LscParser.RULE_from);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 358;
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
    this.enterRule(localctx, 46, LscParser.RULE_to);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 360;
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
    this.enterRule(localctx, 48, LscParser.RULE_environmentList);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 362;
        this.match(LscParser.LIST_START);
        this.state = 363;
        this.environment();
        this.state = 368;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 364;
            this.match(LscParser.SEP);
            this.state = 365;
            this.environment();
            this.state = 370;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 371;
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
    this.enterRule(localctx, 50, LscParser.RULE_environment);
    var _la = 0; // Token type
    try {
        this.state = 386;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,44,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 376;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(((((_la - 9)) & ~0x1f) == 0 && ((1 << (_la - 9)) & ((1 << (LscParser.O_PAREN - 9)) | (1 << (LscParser.NULL - 9)) | (1 << (LscParser.MATRIX_START - 9)) | (1 << (LscParser.LIST_START - 9)) | (1 << (LscParser.NEGATION - 9)) | (1 << (LscParser.WORD_BOUNDARY - 9)) | (1 << (LscParser.CLASSREF - 9)) | (1 << (LscParser.FEATURE - 9)) | (1 << (LscParser.VALUE - 9)) | (1 << (LscParser.STR1 - 9)) | (1 << (LscParser.STR - 9)))) !== 0)) {
                this.state = 373;
                this.environmentBefore();
                this.state = 374;
                this.match(LscParser.WHITESPACE);
            }

            this.state = 378;
            this.match(LscParser.ANCHOR);
            this.state = 381;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(_la===LscParser.WHITESPACE) {
                this.state = 379;
                this.match(LscParser.WHITESPACE);
                this.state = 380;
                this.environmentAfter();
            }

            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 384;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
            if(((((_la - 9)) & ~0x1f) == 0 && ((1 << (_la - 9)) & ((1 << (LscParser.O_PAREN - 9)) | (1 << (LscParser.NULL - 9)) | (1 << (LscParser.MATRIX_START - 9)) | (1 << (LscParser.LIST_START - 9)) | (1 << (LscParser.NEGATION - 9)) | (1 << (LscParser.WORD_BOUNDARY - 9)) | (1 << (LscParser.CLASSREF - 9)) | (1 << (LscParser.FEATURE - 9)) | (1 << (LscParser.VALUE - 9)) | (1 << (LscParser.STR1 - 9)) | (1 << (LscParser.STR - 9)))) !== 0)) {
                this.state = 383;
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
    this.enterRule(localctx, 52, LscParser.RULE_environmentBefore);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 388;
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
    this.enterRule(localctx, 54, LscParser.RULE_environmentAfter);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 390;
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
    this.enterRule(localctx, 56, LscParser.RULE_ruleElement);
    try {
        this.state = 398;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,45,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 392;
            this.capture();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 393;
            this.repeater();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 394;
            this.group();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 395;
            this.list();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 396;
            this.simple();
            break;

        case 6:
            this.enterOuterAlt(localctx, 6);
            this.state = 397;
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
    this.enterRule(localctx, 58, LscParser.RULE_sequence);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 400;
        this.sequenceElement();
        this.state = 403; 
        this._errHandler.sync(this);
        var _alt = 1;
        do {
        	switch (_alt) {
        	case 1:
        		this.state = 401;
        		this.match(LscParser.WHITESPACE);
        		this.state = 402;
        		this.sequenceElement();
        		break;
        	default:
        		throw new antlr4.error.NoViableAltException(this);
        	}
        	this.state = 405; 
        	this._errHandler.sync(this);
        	_alt = this._interp.adaptivePredict(this._input,46, this._ctx);
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
    this.enterRule(localctx, 60, LscParser.RULE_sequenceElement);
    try {
        this.state = 412;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,47,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 407;
            this.capture();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 408;
            this.repeater();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 409;
            this.group();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 410;
            this.list();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 411;
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
    this.enterRule(localctx, 62, LscParser.RULE_capture);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 419;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.O_PAREN:
            this.state = 414;
            this.group();
            break;
        case LscParser.LIST_START:
            this.state = 415;
            this.list();
            break;
        case LscParser.NEGATION:
            this.state = 416;
            this.negated();
            break;
        case LscParser.CLASSREF:
            this.state = 417;
            this.classRef();
            break;
        case LscParser.MATRIX_START:
            this.state = 418;
            this.fancyMatrix();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
        this.state = 421;
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
    this.enterRule(localctx, 64, LscParser.RULE_repeater);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 426;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.O_PAREN:
            this.state = 423;
            this.group();
            break;
        case LscParser.LIST_START:
            this.state = 424;
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
            this.state = 425;
            this.simple();
            break;
        default:
            throw new antlr4.error.NoViableAltException(this);
        }
        this.state = 428;
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
    this.enterRule(localctx, 66, LscParser.RULE_group);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 430;
        this.match(LscParser.O_PAREN);
        this.state = 431;
        this.ruleElement();
        this.state = 432;
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
    this.enterRule(localctx, 68, LscParser.RULE_list);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 434;
        this.match(LscParser.LIST_START);
        this.state = 435;
        this.ruleElement();
        this.state = 440;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.SEP) {
            this.state = 436;
            this.match(LscParser.SEP);
            this.state = 437;
            this.ruleElement();
            this.state = 442;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 443;
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

SimpleContext.prototype.boundary = function() {
    return this.getTypedRuleContext(BoundaryContext,0);
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
    this.enterRule(localctx, 70, LscParser.RULE_simple);
    try {
        this.state = 452;
        this._errHandler.sync(this);
        var la_ = this._interp.adaptivePredict(this._input,51,this._ctx);
        switch(la_) {
        case 1:
            this.enterOuterAlt(localctx, 1);
            this.state = 445;
            this.negated();
            break;

        case 2:
            this.enterOuterAlt(localctx, 2);
            this.state = 446;
            this.classRef();
            break;

        case 3:
            this.enterOuterAlt(localctx, 3);
            this.state = 447;
            this.captureRef();
            break;

        case 4:
            this.enterOuterAlt(localctx, 4);
            this.state = 448;
            this.fancyMatrix();
            break;

        case 5:
            this.enterOuterAlt(localctx, 5);
            this.state = 449;
            this.empty();
            break;

        case 6:
            this.enterOuterAlt(localctx, 6);
            this.state = 450;
            this.boundary();
            break;

        case 7:
            this.enterOuterAlt(localctx, 7);
            this.state = 451;
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
    this.enterRule(localctx, 72, LscParser.RULE_negated);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 454;
        this.match(LscParser.NEGATION);
        this.state = 455;
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
    this.enterRule(localctx, 74, LscParser.RULE_classRef);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 457;
        this.match(LscParser.CLASSREF);
        this.state = 458;
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
    this.enterRule(localctx, 76, LscParser.RULE_captureRef);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 460;
        this.match(LscParser.WORD_BOUNDARY);
        this.state = 461;
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
    this.enterRule(localctx, 78, LscParser.RULE_fancyMatrix);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 463;
        this.match(LscParser.MATRIX_START);
        this.state = 465;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(((((_la - 11)) & ~0x1f) == 0 && ((1 << (_la - 11)) & ((1 << (LscParser.NULL - 11)) | (1 << (LscParser.NEGATION - 11)) | (1 << (LscParser.WORD_BOUNDARY - 11)) | (1 << (LscParser.VALUE - 11)))) !== 0)) {
            this.state = 464;
            this.fancyValue();
        }

        this.state = 471;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.WHITESPACE) {
            this.state = 467;
            this.match(LscParser.WHITESPACE);
            this.state = 468;
            this.fancyValue();
            this.state = 473;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 474;
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
    this.enterRule(localctx, 80, LscParser.RULE_fancyValue);
    try {
        this.state = 480;
        this._errHandler.sync(this);
        switch(this._input.LA(1)) {
        case LscParser.VALUE:
            this.enterOuterAlt(localctx, 1);
            this.state = 476;
            this.value();
            break;
        case LscParser.NEGATION:
            this.enterOuterAlt(localctx, 2);
            this.state = 477;
            this.negatedValue();
            break;
        case LscParser.NULL:
            this.enterOuterAlt(localctx, 3);
            this.state = 478;
            this.absentFeature();
            break;
        case LscParser.WORD_BOUNDARY:
            this.enterOuterAlt(localctx, 4);
            this.state = 479;
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
    this.enterRule(localctx, 82, LscParser.RULE_negatedValue);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 482;
        this.match(LscParser.NEGATION);
        this.state = 483;
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
    this.enterRule(localctx, 84, LscParser.RULE_absentFeature);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 485;
        this.match(LscParser.NULL);
        this.state = 486;
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
    this.enterRule(localctx, 86, LscParser.RULE_featureVariable);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 488;
        this.match(LscParser.WORD_BOUNDARY);
        this.state = 489;
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
    this.enterRule(localctx, 88, LscParser.RULE_empty);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 491;
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
    this.enterRule(localctx, 90, LscParser.RULE_boundary);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 493;
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
    this.enterRule(localctx, 92, LscParser.RULE_repeaterType);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 495;
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
    this.enterRule(localctx, 94, LscParser.RULE_matrix);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 497;
        this.match(LscParser.MATRIX_START);
        this.state = 499;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.VALUE) {
            this.state = 498;
            this.value();
        }

        this.state = 505;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        while(_la===LscParser.WHITESPACE) {
            this.state = 501;
            this.match(LscParser.WHITESPACE);
            this.state = 502;
            this.value();
            this.state = 507;
            this._errHandler.sync(this);
            _la = this._input.LA(1);
        }
        this.state = 508;
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
    this.enterRule(localctx, 96, LscParser.RULE_feature);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 510;
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
    this.enterRule(localctx, 98, LscParser.RULE_value);
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 512;
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
    this.enterRule(localctx, 100, LscParser.RULE_text);
    var _la = 0; // Token type
    try {
        this.enterOuterAlt(localctx, 1);
        this.state = 514;
        _la = this._input.LA(1);
        if(!(((((_la - 35)) & ~0x1f) == 0 && ((1 << (_la - 35)) & ((1 << (LscParser.FEATURE - 35)) | (1 << (LscParser.VALUE - 35)) | (1 << (LscParser.STR1 - 35)) | (1 << (LscParser.STR - 35)))) !== 0))) {
        this._errHandler.recoverInline(this);
        }
        else {
        	this._errHandler.reportMatch(this);
            this.consume();
        }
        this.state = 516;
        this._errHandler.sync(this);
        _la = this._input.LA(1);
        if(_la===LscParser.NEGATION) {
            this.state = 515;
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
