// Generated from Lsc.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');



var serializedATN = ["\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964",
    "\u00020\u01f4\b\u0001\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004",
    "\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t",
    "\u0007\u0004\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b\t\u000b\u0004",
    "\f\t\f\u0004\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010",
    "\t\u0010\u0004\u0011\t\u0011\u0004\u0012\t\u0012\u0004\u0013\t\u0013",
    "\u0004\u0014\t\u0014\u0004\u0015\t\u0015\u0004\u0016\t\u0016\u0004\u0017",
    "\t\u0017\u0004\u0018\t\u0018\u0004\u0019\t\u0019\u0004\u001a\t\u001a",
    "\u0004\u001b\t\u001b\u0004\u001c\t\u001c\u0004\u001d\t\u001d\u0004\u001e",
    "\t\u001e\u0004\u001f\t\u001f\u0004 \t \u0004!\t!\u0004\"\t\"\u0004#",
    "\t#\u0004$\t$\u0004%\t%\u0004&\t&\u0004\'\t\'\u0004(\t(\u0004)\t)\u0004",
    "*\t*\u0004+\t+\u0004,\t,\u0004-\t-\u0004.\t.\u0004/\t/\u00040\t0\u0004",
    "1\t1\u00042\t2\u00043\t3\u0003\u0002\u0005\u0002i\n\u0002\u0003\u0002",
    "\u0003\u0002\u0007\u0002m\n\u0002\f\u0002\u000e\u0002p\u000b\u0002\u0003",
    "\u0002\u0003\u0002\u0003\u0003\u0003\u0003\u0005\u0003v\n\u0003\u0003",
    "\u0004\u0005\u0004y\n\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003",
    "\u0004\u0005\u0004\u007f\n\u0004\u0003\u0005\u0005\u0005\u0082\n\u0005",
    "\u0003\u0005\u0003\u0005\u0005\u0005\u0086\n\u0005\u0003\u0006\u0005",
    "\u0006\u0089\n\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006",
    "\u0005\u0006\u008f\n\u0006\u0003\u0007\u0003\u0007\u0003\b\u0005\b\u0094",
    "\n\b\u0003\b\u0003\b\u0003\b\u0005\b\u0099\n\b\u0003\b\u0005\b\u009c",
    "\n\b\u0003\t\u0006\t\u009f\n\t\r\t\u000e\t\u00a0\u0003\n\u0003\n\u0003",
    "\u000b\u0003\u000b\u0003\f\u0003\f\u0003\r\u0003\r\u0003\u000e\u0003",
    "\u000e\u0003\u000f\u0003\u000f\u0003\u0010\u0003\u0010\u0003\u0011\u0003",
    "\u0011\u0003\u0012\u0003\u0012\u0003\u0013\u0003\u0013\u0003\u0014\u0003",
    "\u0014\u0003\u0015\u0003\u0015\u0003\u0016\u0003\u0016\u0003\u0017\u0003",
    "\u0017\u0003\u0018\u0003\u0018\u0003\u0018\u0003\u0019\u0003\u0019\u0003",
    "\u001a\u0003\u001a\u0003\u001b\u0003\u001b\u0003\u001b\u0003\u001b\u0003",
    "\u001b\u0003\u001b\u0003\u001b\u0003\u001b\u0003\u001b\u0003\u001b\u0005",
    "\u001b\u00d0\n\u001b\u0003\u001c\u0003\u001c\u0003\u001c\u0003\u001c",
    "\u0003\u001c\u0003\u001c\u0003\u001c\u0003\u001c\u0003\u001c\u0003\u001c",
    "\u0003\u001c\u0003\u001c\u0003\u001c\u0003\u001c\u0005\u001c\u00e0\n",
    "\u001c\u0003\u001d\u0003\u001d\u0003\u001d\u0003\u001d\u0003\u001d\u0003",
    "\u001d\u0003\u001d\u0003\u001d\u0003\u001d\u0003\u001d\u0003\u001d\u0003",
    "\u001d\u0003\u001d\u0003\u001d\u0003\u001d\u0003\u001d\u0003\u001d\u0003",
    "\u001d\u0003\u001d\u0003\u001d\u0005\u001d\u00f6\n\u001d\u0003\u001e",
    "\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001e",
    "\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001e",
    "\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001e\u0003\u001e\u0005\u001e",
    "\u010a\n\u001e\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003",
    "\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003",
    "\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0003\u001f\u0005",
    "\u001f\u011c\n\u001f\u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0003",
    " \u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0003 \u0003",
    " \u0003 \u0003 \u0003 \u0005 \u0132\n \u0003!\u0003!\u0003!\u0003!\u0003",
    "!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0003!\u0005!\u0140\n!\u0003",
    "\"\u0003\"\u0003\"\u0003\"\u0003\"\u0003\"\u0003\"\u0003\"\u0003\"\u0003",
    "\"\u0003#\u0003#\u0003#\u0003#\u0003#\u0003#\u0003#\u0003#\u0003#\u0003",
    "$\u0003$\u0003$\u0003$\u0003$\u0003$\u0003$\u0003$\u0003$\u0003$\u0005",
    "$\u015f\n$\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003",
    "%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003",
    "%\u0003%\u0003%\u0003%\u0005%\u0177\n%\u0003&\u0003&\u0003&\u0003&\u0003",
    "&\u0003&\u0003&\u0003&\u0003&\u0003&\u0003&\u0003&\u0003&\u0003&\u0003",
    "&\u0003&\u0003&\u0003&\u0005&\u018b\n&\u0003\'\u0003\'\u0003\'\u0003",
    "\'\u0003\'\u0003\'\u0003\'\u0003\'\u0005\'\u0195\n\'\u0003(\u0003(\u0003",
    "(\u0003(\u0003(\u0003(\u0003(\u0003(\u0005(\u019f\n(\u0003)\u0003)\u0003",
    ")\u0003)\u0003)\u0003)\u0003)\u0003)\u0003)\u0003)\u0003)\u0003)\u0003",
    ")\u0003)\u0003)\u0003)\u0003)\u0003)\u0005)\u01b3\n)\u0003*\u0003*\u0003",
    "*\u0003*\u0003*\u0003*\u0003*\u0003*\u0003*\u0003*\u0003*\u0003*\u0003",
    "*\u0003*\u0005*\u01c3\n*\u0003+\u0003+\u0003+\u0003+\u0003+\u0003+\u0003",
    "+\u0003+\u0003+\u0003+\u0003+\u0003+\u0003+\u0003+\u0003+\u0003+\u0003",
    "+\u0003+\u0005+\u01d7\n+\u0003,\u0006,\u01da\n,\r,\u000e,\u01db\u0003",
    "-\u0006-\u01df\n-\r-\u000e-\u01e0\u0003.\u0003.\u0003/\u0006/\u01e6",
    "\n/\r/\u000e/\u01e7\u00030\u00030\u00031\u00031\u00032\u00032\u0003",
    "2\u00052\u01f1\n2\u00033\u00033\u0002\u00024\u0003\u0003\u0005\u0004",
    "\u0007\u0005\t\u0006\u000b\u0007\r\b\u000f\t\u0011\n\u0013\u000b\u0015",
    "\f\u0017\r\u0019\u000e\u001b\u000f\u001d\u0010\u001f\u0011!\u0012#\u0013",
    "%\u0014\'\u0015)\u0016+\u0017-\u0018/\u00191\u001a3\u001b5\u001c7\u001d",
    "9\u001e;\u001f= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]0_\u0002a\u0002c\u0002",
    "e\u0002\u0003\u0002\u0007\u0004\u0002\f\f\u000f\u000f\f\u0002\u000b",
    "\u000f\"\"\u0087\u0087\u00a2\u00a2\u1682\u1682\u2002\u200c\u202a\u202b",
    "\u2031\u2031\u2061\u2061\u3002\u3002\u0005\u00022;C\\c|\u0003\u0002",
    "2;\u000e\u0002\f\f\u000f\u000f\"#%&((*1<<?B]_aa}}\u007f\u007f\u0002",
    "\u020f\u0002\u0003\u0003\u0002\u0002\u0002\u0002\u0005\u0003\u0002\u0002",
    "\u0002\u0002\u0007\u0003\u0002\u0002\u0002\u0002\t\u0003\u0002\u0002",
    "\u0002\u0002\u000b\u0003\u0002\u0002\u0002\u0002\r\u0003\u0002\u0002",
    "\u0002\u0002\u000f\u0003\u0002\u0002\u0002\u0002\u0011\u0003\u0002\u0002",
    "\u0002\u0002\u0013\u0003\u0002\u0002\u0002\u0002\u0015\u0003\u0002\u0002",
    "\u0002\u0002\u0017\u0003\u0002\u0002\u0002\u0002\u0019\u0003\u0002\u0002",
    "\u0002\u0002\u001b\u0003\u0002\u0002\u0002\u0002\u001d\u0003\u0002\u0002",
    "\u0002\u0002\u001f\u0003\u0002\u0002\u0002\u0002!\u0003\u0002\u0002",
    "\u0002\u0002#\u0003\u0002\u0002\u0002\u0002%\u0003\u0002\u0002\u0002",
    "\u0002\'\u0003\u0002\u0002\u0002\u0002)\u0003\u0002\u0002\u0002\u0002",
    "+\u0003\u0002\u0002\u0002\u0002-\u0003\u0002\u0002\u0002\u0002/\u0003",
    "\u0002\u0002\u0002\u00021\u0003\u0002\u0002\u0002\u00023\u0003\u0002",
    "\u0002\u0002\u00025\u0003\u0002\u0002\u0002\u00027\u0003\u0002\u0002",
    "\u0002\u00029\u0003\u0002\u0002\u0002\u0002;\u0003\u0002\u0002\u0002",
    "\u0002=\u0003\u0002\u0002\u0002\u0002?\u0003\u0002\u0002\u0002\u0002",
    "A\u0003\u0002\u0002\u0002\u0002C\u0003\u0002\u0002\u0002\u0002E\u0003",
    "\u0002\u0002\u0002\u0002G\u0003\u0002\u0002\u0002\u0002I\u0003\u0002",
    "\u0002\u0002\u0002K\u0003\u0002\u0002\u0002\u0002M\u0003\u0002\u0002",
    "\u0002\u0002O\u0003\u0002\u0002\u0002\u0002Q\u0003\u0002\u0002\u0002",
    "\u0002S\u0003\u0002\u0002\u0002\u0002U\u0003\u0002\u0002\u0002\u0002",
    "W\u0003\u0002\u0002\u0002\u0002Y\u0003\u0002\u0002\u0002\u0002[\u0003",
    "\u0002\u0002\u0002\u0002]\u0003\u0002\u0002\u0002\u0003h\u0003\u0002",
    "\u0002\u0002\u0005s\u0003\u0002\u0002\u0002\u0007x\u0003\u0002\u0002",
    "\u0002\t\u0081\u0003\u0002\u0002\u0002\u000b\u0088\u0003\u0002\u0002",
    "\u0002\r\u0090\u0003\u0002\u0002\u0002\u000f\u0093\u0003\u0002\u0002",
    "\u0002\u0011\u009e\u0003\u0002\u0002\u0002\u0013\u00a2\u0003\u0002\u0002",
    "\u0002\u0015\u00a4\u0003\u0002\u0002\u0002\u0017\u00a6\u0003\u0002\u0002",
    "\u0002\u0019\u00a8\u0003\u0002\u0002\u0002\u001b\u00aa\u0003\u0002\u0002",
    "\u0002\u001d\u00ac\u0003\u0002\u0002\u0002\u001f\u00ae\u0003\u0002\u0002",
    "\u0002!\u00b0\u0003\u0002\u0002\u0002#\u00b2\u0003\u0002\u0002\u0002",
    "%\u00b4\u0003\u0002\u0002\u0002\'\u00b6\u0003\u0002\u0002\u0002)\u00b8",
    "\u0003\u0002\u0002\u0002+\u00ba\u0003\u0002\u0002\u0002-\u00bc\u0003",
    "\u0002\u0002\u0002/\u00be\u0003\u0002\u0002\u00021\u00c1\u0003\u0002",
    "\u0002\u00023\u00c3\u0003\u0002\u0002\u00025\u00cf\u0003\u0002\u0002",
    "\u00027\u00df\u0003\u0002\u0002\u00029\u00f5\u0003\u0002\u0002\u0002",
    ";\u0109\u0003\u0002\u0002\u0002=\u011b\u0003\u0002\u0002\u0002?\u0131",
    "\u0003\u0002\u0002\u0002A\u013f\u0003\u0002\u0002\u0002C\u0141\u0003",
    "\u0002\u0002\u0002E\u014b\u0003\u0002\u0002\u0002G\u015e\u0003\u0002",
    "\u0002\u0002I\u0176\u0003\u0002\u0002\u0002K\u018a\u0003\u0002\u0002",
    "\u0002M\u0194\u0003\u0002\u0002\u0002O\u019e\u0003\u0002\u0002\u0002",
    "Q\u01b2\u0003\u0002\u0002\u0002S\u01c2\u0003\u0002\u0002\u0002U\u01d6",
    "\u0003\u0002\u0002\u0002W\u01d9\u0003\u0002\u0002\u0002Y\u01de\u0003",
    "\u0002\u0002\u0002[\u01e2\u0003\u0002\u0002\u0002]\u01e5\u0003\u0002",
    "\u0002\u0002_\u01e9\u0003\u0002\u0002\u0002a\u01eb\u0003\u0002\u0002",
    "\u0002c\u01f0\u0003\u0002\u0002\u0002e\u01f2\u0003\u0002\u0002\u0002",
    "gi\u0005\u0011\t\u0002hg\u0003\u0002\u0002\u0002hi\u0003\u0002\u0002",
    "\u0002ij\u0003\u0002\u0002\u0002jn\u0005e3\u0002km\n\u0002\u0002\u0002",
    "lk\u0003\u0002\u0002\u0002mp\u0003\u0002\u0002\u0002nl\u0003\u0002\u0002",
    "\u0002no\u0003\u0002\u0002\u0002oq\u0003\u0002\u0002\u0002pn\u0003\u0002",
    "\u0002\u0002qr\b\u0002\u0002\u0002r\u0004\u0003\u0002\u0002\u0002su",
    "\u0007.\u0002\u0002tv\u0005\u0011\t\u0002ut\u0003\u0002\u0002\u0002",
    "uv\u0003\u0002\u0002\u0002v\u0006\u0003\u0002\u0002\u0002wy\u0005\u0011",
    "\t\u0002xw\u0003\u0002\u0002\u0002xy\u0003\u0002\u0002\u0002yz\u0003",
    "\u0002\u0002\u0002z{\u0007?\u0002\u0002{|\u0007@\u0002\u0002|~\u0003",
    "\u0002\u0002\u0002}\u007f\u0005\u0011\t\u0002~}\u0003\u0002\u0002\u0002",
    "~\u007f\u0003\u0002\u0002\u0002\u007f\b\u0003\u0002\u0002\u0002\u0080",
    "\u0082\u0005\u0011\t\u0002\u0081\u0080\u0003\u0002\u0002\u0002\u0081",
    "\u0082\u0003\u0002\u0002\u0002\u0082\u0083\u0003\u0002\u0002\u0002\u0083",
    "\u0085\u00071\u0002\u0002\u0084\u0086\u0005\u0011\t\u0002\u0085\u0084",
    "\u0003\u0002\u0002\u0002\u0085\u0086\u0003\u0002\u0002\u0002\u0086\n",
    "\u0003\u0002\u0002\u0002\u0087\u0089\u0005\u0011\t\u0002\u0088\u0087",
    "\u0003\u0002\u0002\u0002\u0088\u0089\u0003\u0002\u0002\u0002\u0089\u008a",
    "\u0003\u0002\u0002\u0002\u008a\u008b\u00071\u0002\u0002\u008b\u008c",
    "\u00071\u0002\u0002\u008c\u008e\u0003\u0002\u0002\u0002\u008d\u008f",
    "\u0005\u0011\t\u0002\u008e\u008d\u0003\u0002\u0002\u0002\u008e\u008f",
    "\u0003\u0002\u0002\u0002\u008f\f\u0003\u0002\u0002\u0002\u0090\u0091",
    "\u0007a\u0002\u0002\u0091\u000e\u0003\u0002\u0002\u0002\u0092\u0094",
    "\u0005\u0011\t\u0002\u0093\u0092\u0003\u0002\u0002\u0002\u0093\u0094",
    "\u0003\u0002\u0002\u0002\u0094\u0098\u0003\u0002\u0002\u0002\u0095\u0096",
    "\u0007\u000f\u0002\u0002\u0096\u0099\u0007\f\u0002\u0002\u0097\u0099",
    "\u0007\f\u0002\u0002\u0098\u0095\u0003\u0002\u0002\u0002\u0098\u0097",
    "\u0003\u0002\u0002\u0002\u0099\u009b\u0003\u0002\u0002\u0002\u009a\u009c",
    "\u0005\u0011\t\u0002\u009b\u009a\u0003\u0002\u0002\u0002\u009b\u009c",
    "\u0003\u0002\u0002\u0002\u009c\u0010\u0003\u0002\u0002\u0002\u009d\u009f",
    "\t\u0003\u0002\u0002\u009e\u009d\u0003\u0002\u0002\u0002\u009f\u00a0",
    "\u0003\u0002\u0002\u0002\u00a0\u009e\u0003\u0002\u0002\u0002\u00a0\u00a1",
    "\u0003\u0002\u0002\u0002\u00a1\u0012\u0003\u0002\u0002\u0002\u00a2\u00a3",
    "\u0007*\u0002\u0002\u00a3\u0014\u0003\u0002\u0002\u0002\u00a4\u00a5",
    "\u0007+\u0002\u0002\u00a5\u0016\u0003\u0002\u0002\u0002\u00a6\u00a7",
    "\u0007,\u0002\u0002\u00a7\u0018\u0003\u0002\u0002\u0002\u00a8\u00a9",
    "\u0007]\u0002\u0002\u00a9\u001a\u0003\u0002\u0002\u0002\u00aa\u00ab",
    "\u0007_\u0002\u0002\u00ab\u001c\u0003\u0002\u0002\u0002\u00ac\u00ad",
    "\u0007}\u0002\u0002\u00ad\u001e\u0003\u0002\u0002\u0002\u00ae\u00af",
    "\u0007\u007f\u0002\u0002\u00af \u0003\u0002\u0002\u0002\u00b0\u00b1",
    "\u0007-\u0002\u0002\u00b1\"\u0003\u0002\u0002\u0002\u00b2\u00b3\u0007",
    "A\u0002\u0002\u00b3$\u0003\u0002\u0002\u0002\u00b4\u00b5\u0007/\u0002",
    "\u0002\u00b5&\u0003\u0002\u0002\u0002\u00b6\u00b7\u0007<\u0002\u0002",
    "\u00b7(\u0003\u0002\u0002\u0002\u00b8\u00b9\u0007#\u0002\u0002\u00b9",
    "*\u0003\u0002\u0002\u0002\u00ba\u00bb\u00070\u0002\u0002\u00bb,\u0003",
    "\u0002\u0002\u0002\u00bc\u00bd\u0007&\u0002\u0002\u00bd.\u0003\u0002",
    "\u0002\u0002\u00be\u00bf\u0007&\u0002\u0002\u00bf\u00c0\u0007&\u0002",
    "\u0002\u00c00\u0003\u0002\u0002\u0002\u00c1\u00c2\u0007B\u0002\u0002",
    "\u00c22\u0003\u0002\u0002\u0002\u00c3\u00c4\u0007(\u0002\u0002\u00c4",
    "4\u0003\u0002\u0002\u0002\u00c5\u00c6\u0007E\u0002\u0002\u00c6\u00c7",
    "\u0007n\u0002\u0002\u00c7\u00c8\u0007c\u0002\u0002\u00c8\u00c9\u0007",
    "u\u0002\u0002\u00c9\u00d0\u0007u\u0002\u0002\u00ca\u00cb\u0007e\u0002",
    "\u0002\u00cb\u00cc\u0007n\u0002\u0002\u00cc\u00cd\u0007c\u0002\u0002",
    "\u00cd\u00ce\u0007u\u0002\u0002\u00ce\u00d0\u0007u\u0002\u0002\u00cf",
    "\u00c5\u0003\u0002\u0002\u0002\u00cf\u00ca\u0003\u0002\u0002\u0002\u00d0",
    "6\u0003\u0002\u0002\u0002\u00d1\u00d2\u0007H\u0002\u0002\u00d2\u00d3",
    "\u0007g\u0002\u0002\u00d3\u00d4\u0007c\u0002\u0002\u00d4\u00d5\u0007",
    "v\u0002\u0002\u00d5\u00d6\u0007w\u0002\u0002\u00d6\u00d7\u0007t\u0002",
    "\u0002\u00d7\u00e0\u0007g\u0002\u0002\u00d8\u00d9\u0007h\u0002\u0002",
    "\u00d9\u00da\u0007g\u0002\u0002\u00da\u00db\u0007c\u0002\u0002\u00db",
    "\u00dc\u0007v\u0002\u0002\u00dc\u00dd\u0007w\u0002\u0002\u00dd\u00de",
    "\u0007t\u0002\u0002\u00de\u00e0\u0007g\u0002\u0002\u00df\u00d1\u0003",
    "\u0002\u0002\u0002\u00df\u00d8\u0003\u0002\u0002\u0002\u00e08\u0003",
    "\u0002\u0002\u0002\u00e1\u00e2\u0007*\u0002\u0002\u00e2\u00e3\u0007",
    "U\u0002\u0002\u00e3\u00e4\u0007{\u0002\u0002\u00e4\u00e5\u0007n\u0002",
    "\u0002\u00e5\u00e6\u0007n\u0002\u0002\u00e6\u00e7\u0007c\u0002\u0002",
    "\u00e7\u00e8\u0007d\u0002\u0002\u00e8\u00e9\u0007n\u0002\u0002\u00e9",
    "\u00ea\u0007g\u0002\u0002\u00ea\u00f6\u0007+\u0002\u0002\u00eb\u00ec",
    "\u0007*\u0002\u0002\u00ec\u00ed\u0007u\u0002\u0002\u00ed\u00ee\u0007",
    "{\u0002\u0002\u00ee\u00ef\u0007n\u0002\u0002\u00ef\u00f0\u0007n\u0002",
    "\u0002\u00f0\u00f1\u0007c\u0002\u0002\u00f1\u00f2\u0007d\u0002\u0002",
    "\u00f2\u00f3\u0007n\u0002\u0002\u00f3\u00f4\u0007g\u0002\u0002\u00f4",
    "\u00f6\u0007+\u0002\u0002\u00f5\u00e1\u0003\u0002\u0002\u0002\u00f5",
    "\u00eb\u0003\u0002\u0002\u0002\u00f6:\u0003\u0002\u0002\u0002\u00f7",
    "\u00f8\u0007F\u0002\u0002\u00f8\u00f9\u0007k\u0002\u0002\u00f9\u00fa",
    "\u0007c\u0002\u0002\u00fa\u00fb\u0007e\u0002\u0002\u00fb\u00fc\u0007",
    "t\u0002\u0002\u00fc\u00fd\u0007k\u0002\u0002\u00fd\u00fe\u0007v\u0002",
    "\u0002\u00fe\u00ff\u0007k\u0002\u0002\u00ff\u010a\u0007e\u0002\u0002",
    "\u0100\u0101\u0007f\u0002\u0002\u0101\u0102\u0007k\u0002\u0002\u0102",
    "\u0103\u0007c\u0002\u0002\u0103\u0104\u0007e\u0002\u0002\u0104\u0105",
    "\u0007t\u0002\u0002\u0105\u0106\u0007k\u0002\u0002\u0106\u0107\u0007",
    "v\u0002\u0002\u0107\u0108\u0007k\u0002\u0002\u0108\u010a\u0007e\u0002",
    "\u0002\u0109\u00f7\u0003\u0002\u0002\u0002\u0109\u0100\u0003\u0002\u0002",
    "\u0002\u010a<\u0003\u0002\u0002\u0002\u010b\u010c\u0007*\u0002\u0002",
    "\u010c\u010d\u0007D\u0002\u0002\u010d\u010e\u0007g\u0002\u0002\u010e",
    "\u010f\u0007h\u0002\u0002\u010f\u0110\u0007q\u0002\u0002\u0110\u0111",
    "\u0007t\u0002\u0002\u0111\u0112\u0007g\u0002\u0002\u0112\u011c\u0007",
    "+\u0002\u0002\u0113\u0114\u0007*\u0002\u0002\u0114\u0115\u0007d\u0002",
    "\u0002\u0115\u0116\u0007g\u0002\u0002\u0116\u0117\u0007h\u0002\u0002",
    "\u0117\u0118\u0007q\u0002\u0002\u0118\u0119\u0007t\u0002\u0002\u0119",
    "\u011a\u0007g\u0002\u0002\u011a\u011c\u0007+\u0002\u0002\u011b\u010b",
    "\u0003\u0002\u0002\u0002\u011b\u0113\u0003\u0002\u0002\u0002\u011c>",
    "\u0003\u0002\u0002\u0002\u011d\u011e\u0007*\u0002\u0002\u011e\u011f",
    "\u0007H\u0002\u0002\u011f\u0120\u0007n\u0002\u0002\u0120\u0121\u0007",
    "q\u0002\u0002\u0121\u0122\u0007c\u0002\u0002\u0122\u0123\u0007v\u0002",
    "\u0002\u0123\u0124\u0007k\u0002\u0002\u0124\u0125\u0007p\u0002\u0002",
    "\u0125\u0126\u0007i\u0002\u0002\u0126\u0132\u0007+\u0002\u0002\u0127",
    "\u0128\u0007*\u0002\u0002\u0128\u0129\u0007h\u0002\u0002\u0129\u012a",
    "\u0007n\u0002\u0002\u012a\u012b\u0007q\u0002\u0002\u012b\u012c\u0007",
    "c\u0002\u0002\u012c\u012d\u0007v\u0002\u0002\u012d\u012e\u0007k\u0002",
    "\u0002\u012e\u012f\u0007p\u0002\u0002\u012f\u0130\u0007i\u0002\u0002",
    "\u0130\u0132\u0007+\u0002\u0002\u0131\u011d\u0003\u0002\u0002\u0002",
    "\u0131\u0127\u0003\u0002\u0002\u0002\u0132@\u0003\u0002\u0002\u0002",
    "\u0133\u0134\u0007U\u0002\u0002\u0134\u0135\u0007{\u0002\u0002\u0135",
    "\u0136\u0007o\u0002\u0002\u0136\u0137\u0007d\u0002\u0002\u0137\u0138",
    "\u0007q\u0002\u0002\u0138\u0140\u0007n\u0002\u0002\u0139\u013a\u0007",
    "u\u0002\u0002\u013a\u013b\u0007{\u0002\u0002\u013b\u013c\u0007o\u0002",
    "\u0002\u013c\u013d\u0007d\u0002\u0002\u013d\u013e\u0007q\u0002\u0002",
    "\u013e\u0140\u0007n\u0002\u0002\u013f\u0133\u0003\u0002\u0002\u0002",
    "\u013f\u0139\u0003\u0002\u0002\u0002\u0140B\u0003\u0002\u0002\u0002",
    "\u0141\u0142\u0007U\u0002\u0002\u0142\u0143\u0007{\u0002\u0002\u0143",
    "\u0144\u0007n\u0002\u0002\u0144\u0145\u0007n\u0002\u0002\u0145\u0146",
    "\u0007c\u0002\u0002\u0146\u0147\u0007d\u0002\u0002\u0147\u0148\u0007",
    "n\u0002\u0002\u0148\u0149\u0007g\u0002\u0002\u0149\u014a\u0007u\u0002",
    "\u0002\u014aD\u0003\u0002\u0002\u0002\u014b\u014c\u0007g\u0002\u0002",
    "\u014c\u014d\u0007z\u0002\u0002\u014d\u014e\u0007r\u0002\u0002\u014e",
    "\u014f\u0007n\u0002\u0002\u014f\u0150\u0007k\u0002\u0002\u0150\u0151",
    "\u0007e\u0002\u0002\u0151\u0152\u0007k\u0002\u0002\u0152\u0153\u0007",
    "v\u0002\u0002\u0153F\u0003\u0002\u0002\u0002\u0154\u0155\u0007>\u0002",
    "\u0002\u0155\u0156\u0007U\u0002\u0002\u0156\u0157\u0007{\u0002\u0002",
    "\u0157\u0158\u0007n\u0002\u0002\u0158\u015f\u0007@\u0002\u0002\u0159",
    "\u015a\u0007>\u0002\u0002\u015a\u015b\u0007u\u0002\u0002\u015b\u015c",
    "\u0007{\u0002\u0002\u015c\u015d\u0007n\u0002\u0002\u015d\u015f\u0007",
    "@\u0002\u0002\u015e\u0154\u0003\u0002\u0002\u0002\u015e\u0159\u0003",
    "\u0002\u0002\u0002\u015fH\u0003\u0002\u0002\u0002\u0160\u0161\u0007",
    "F\u0002\u0002\u0161\u0162\u0007g\u0002\u0002\u0162\u0163\u0007t\u0002",
    "\u0002\u0163\u0164\u0007q\u0002\u0002\u0164\u0165\u0007o\u0002\u0002",
    "\u0165\u0166\u0007c\u0002\u0002\u0166\u0167\u0007p\u0002\u0002\u0167",
    "\u0168\u0007k\u0002\u0002\u0168\u0169\u0007|\u0002\u0002\u0169\u016a",
    "\u0007g\u0002\u0002\u016a\u0177\u0007t\u0002\u0002\u016b\u016c\u0007",
    "f\u0002\u0002\u016c\u016d\u0007g\u0002\u0002\u016d\u016e\u0007t\u0002",
    "\u0002\u016e\u016f\u0007q\u0002\u0002\u016f\u0170\u0007o\u0002\u0002",
    "\u0170\u0171\u0007c\u0002\u0002\u0171\u0172\u0007p\u0002\u0002\u0172",
    "\u0173\u0007k\u0002\u0002\u0173\u0174\u0007|\u0002\u0002\u0174\u0175",
    "\u0007g\u0002\u0002\u0175\u0177\u0007t\u0002\u0002\u0176\u0160\u0003",
    "\u0002\u0002\u0002\u0176\u016b\u0003\u0002\u0002\u0002\u0177J\u0003",
    "\u0002\u0002\u0002\u0178\u0179\u0007T\u0002\u0002\u0179\u017a\u0007",
    "q\u0002\u0002\u017a\u017b\u0007o\u0002\u0002\u017b\u017c\u0007c\u0002",
    "\u0002\u017c\u017d\u0007p\u0002\u0002\u017d\u017e\u0007k\u0002\u0002",
    "\u017e\u017f\u0007|\u0002\u0002\u017f\u0180\u0007g\u0002\u0002\u0180",
    "\u018b\u0007t\u0002\u0002\u0181\u0182\u0007t\u0002\u0002\u0182\u0183",
    "\u0007q\u0002\u0002\u0183\u0184\u0007o\u0002\u0002\u0184\u0185\u0007",
    "c\u0002\u0002\u0185\u0186\u0007p\u0002\u0002\u0186\u0187\u0007k\u0002",
    "\u0002\u0187\u0188\u0007|\u0002\u0002\u0188\u0189\u0007g\u0002\u0002",
    "\u0189\u018b\u0007t\u0002\u0002\u018a\u0178\u0003\u0002\u0002\u0002",
    "\u018a\u0181\u0003\u0002\u0002\u0002\u018bL\u0003\u0002\u0002\u0002",
    "\u018c\u018d\u0007V\u0002\u0002\u018d\u018e\u0007j\u0002\u0002\u018e",
    "\u018f\u0007g\u0002\u0002\u018f\u0195\u0007p\u0002\u0002\u0190\u0191",
    "\u0007v\u0002\u0002\u0191\u0192\u0007j\u0002\u0002\u0192\u0193\u0007",
    "g\u0002\u0002\u0193\u0195\u0007p\u0002\u0002\u0194\u018c\u0003\u0002",
    "\u0002\u0002\u0194\u0190\u0003\u0002\u0002\u0002\u0195N\u0003\u0002",
    "\u0002\u0002\u0196\u0197\u0007G\u0002\u0002\u0197\u0198\u0007n\u0002",
    "\u0002\u0198\u0199\u0007u\u0002\u0002\u0199\u019f\u0007g\u0002\u0002",
    "\u019a\u019b\u0007g\u0002\u0002\u019b\u019c\u0007n\u0002\u0002\u019c",
    "\u019d\u0007u\u0002\u0002\u019d\u019f\u0007g\u0002\u0002\u019e\u0196",
    "\u0003\u0002\u0002\u0002\u019e\u019a\u0003\u0002\u0002\u0002\u019fP",
    "\u0003\u0002\u0002\u0002\u01a0\u01a1\u0007R\u0002\u0002\u01a1\u01a2",
    "\u0007t\u0002\u0002\u01a2\u01a3\u0007q\u0002\u0002\u01a3\u01a4\u0007",
    "r\u0002\u0002\u01a4\u01a5\u0007c\u0002\u0002\u01a5\u01a6\u0007i\u0002",
    "\u0002\u01a6\u01a7\u0007c\u0002\u0002\u01a7\u01a8\u0007v\u0002\u0002",
    "\u01a8\u01b3\u0007g\u0002\u0002\u01a9\u01aa\u0007r\u0002\u0002\u01aa",
    "\u01ab\u0007t\u0002\u0002\u01ab\u01ac\u0007q\u0002\u0002\u01ac\u01ad",
    "\u0007r\u0002\u0002\u01ad\u01ae\u0007c\u0002\u0002\u01ae\u01af\u0007",
    "i\u0002\u0002\u01af\u01b0\u0007c\u0002\u0002\u01b0\u01b1\u0007v\u0002",
    "\u0002\u01b1\u01b3\u0007g\u0002\u0002\u01b2\u01a0\u0003\u0002\u0002",
    "\u0002\u01b2\u01a9\u0003\u0002\u0002\u0002\u01b3R\u0003\u0002\u0002",
    "\u0002\u01b4\u01b5\u0007N\u0002\u0002\u01b5\u01b6\u0007k\u0002\u0002",
    "\u01b6\u01b7\u0007v\u0002\u0002\u01b7\u01b8\u0007g\u0002\u0002\u01b8",
    "\u01b9\u0007t\u0002\u0002\u01b9\u01ba\u0007c\u0002\u0002\u01ba\u01c3",
    "\u0007n\u0002\u0002\u01bb\u01bc\u0007n\u0002\u0002\u01bc\u01bd\u0007",
    "k\u0002\u0002\u01bd\u01be\u0007v\u0002\u0002\u01be\u01bf\u0007g\u0002",
    "\u0002\u01bf\u01c0\u0007t\u0002\u0002\u01c0\u01c1\u0007c\u0002\u0002",
    "\u01c1\u01c3\u0007n\u0002\u0002\u01c2\u01b4\u0003\u0002\u0002\u0002",
    "\u01c2\u01bb\u0003\u0002\u0002\u0002\u01c3T\u0003\u0002\u0002\u0002",
    "\u01c4\u01c5\u0007W\u0002\u0002\u01c5\u01c6\u0007p\u0002\u0002\u01c6",
    "\u01c7\u0007e\u0002\u0002\u01c7\u01c8\u0007j\u0002\u0002\u01c8\u01c9",
    "\u0007c\u0002\u0002\u01c9\u01ca\u0007p\u0002\u0002\u01ca\u01cb\u0007",
    "i\u0002\u0002\u01cb\u01cc\u0007g\u0002\u0002\u01cc\u01d7\u0007f\u0002",
    "\u0002\u01cd\u01ce\u0007w\u0002\u0002\u01ce\u01cf\u0007p\u0002\u0002",
    "\u01cf\u01d0\u0007e\u0002\u0002\u01d0\u01d1\u0007j\u0002\u0002\u01d1",
    "\u01d2\u0007c\u0002\u0002\u01d2\u01d3\u0007p\u0002\u0002\u01d3\u01d4",
    "\u0007i\u0002\u0002\u01d4\u01d5\u0007g\u0002\u0002\u01d5\u01d7\u0007",
    "f\u0002\u0002\u01d6\u01c4\u0003\u0002\u0002\u0002\u01d6\u01cd\u0003",
    "\u0002\u0002\u0002\u01d7V\u0003\u0002\u0002\u0002\u01d8\u01da\u0005",
    "a1\u0002\u01d9\u01d8\u0003\u0002\u0002\u0002\u01da\u01db\u0003\u0002",
    "\u0002\u0002\u01db\u01d9\u0003\u0002\u0002\u0002\u01db\u01dc\u0003\u0002",
    "\u0002\u0002\u01dcX\u0003\u0002\u0002\u0002\u01dd\u01df\u0005_0\u0002",
    "\u01de\u01dd\u0003\u0002\u0002\u0002\u01df\u01e0\u0003\u0002\u0002\u0002",
    "\u01e0\u01de\u0003\u0002\u0002\u0002\u01e0\u01e1\u0003\u0002\u0002\u0002",
    "\u01e1Z\u0003\u0002\u0002\u0002\u01e2\u01e3\u0005c2\u0002\u01e3\\\u0003",
    "\u0002\u0002\u0002\u01e4\u01e6\u0005c2\u0002\u01e5\u01e4\u0003\u0002",
    "\u0002\u0002\u01e6\u01e7\u0003\u0002\u0002\u0002\u01e7\u01e5\u0003\u0002",
    "\u0002\u0002\u01e7\u01e8\u0003\u0002\u0002\u0002\u01e8^\u0003\u0002",
    "\u0002\u0002\u01e9\u01ea\t\u0004\u0002\u0002\u01ea`\u0003\u0002\u0002",
    "\u0002\u01eb\u01ec\t\u0005\u0002\u0002\u01ecb\u0003\u0002\u0002\u0002",
    "\u01ed\u01ee\u0007^\u0002\u0002\u01ee\u01f1\u000b\u0002\u0002\u0002",
    "\u01ef\u01f1\n\u0006\u0002\u0002\u01f0\u01ed\u0003\u0002\u0002\u0002",
    "\u01f0\u01ef\u0003\u0002\u0002\u0002\u01f1d\u0003\u0002\u0002\u0002",
    "\u01f2\u01f3\u0007%\u0002\u0002\u01f3f\u0003\u0002\u0002\u0002#\u0002",
    "hnux~\u0081\u0085\u0088\u008e\u0093\u0098\u009b\u00a0\u00cf\u00df\u00f5",
    "\u0109\u011b\u0131\u013f\u015e\u0176\u018a\u0194\u019e\u01b2\u01c2\u01d6",
    "\u01db\u01e0\u01e7\u01f0\u0003\b\u0002\u0002"].join("");


var atn = new antlr4.atn.ATNDeserializer().deserialize(serializedATN);

var decisionsToDFA = atn.decisionToState.map( function(ds, index) { return new antlr4.dfa.DFA(ds, index); });

function LscLexer(input) {
	antlr4.Lexer.call(this, input);
    this._interp = new antlr4.atn.LexerATNSimulator(this, atn, decisionsToDFA, new antlr4.PredictionContextCache());
    return this;
}

LscLexer.prototype = Object.create(antlr4.Lexer.prototype);
LscLexer.prototype.constructor = LscLexer;

Object.defineProperty(LscLexer.prototype, "atn", {
        get : function() {
                return atn;
        }
});

LscLexer.EOF = antlr4.Token.EOF;
LscLexer.COMMENT = 1;
LscLexer.SEP = 2;
LscLexer.CHANGE = 3;
LscLexer.CONDITION = 4;
LscLexer.EXCLUSION = 5;
LscLexer.ANCHOR = 6;
LscLexer.NEWLINE = 7;
LscLexer.WHITESPACE = 8;
LscLexer.O_PAREN = 9;
LscLexer.C_PAREN = 10;
LscLexer.NULL = 11;
LscLexer.MATRIX_START = 12;
LscLexer.MATRIX_END = 13;
LscLexer.LIST_START = 14;
LscLexer.LIST_END = 15;
LscLexer.AT_LEAST_ONE = 16;
LscLexer.OPTIONAL = 17;
LscLexer.HYPHEN = 18;
LscLexer.RULE_START = 19;
LscLexer.NEGATION = 20;
LscLexer.SYLLABLE_BOUNDARY = 21;
LscLexer.WORD_BOUNDARY = 22;
LscLexer.BETWEEN_WORDS = 23;
LscLexer.CLASSREF = 24;
LscLexer.INTERSECTION = 25;
LscLexer.CLASS_DECL = 26;
LscLexer.FEATURE_DECL = 27;
LscLexer.SYLLABLE_FEATURE = 28;
LscLexer.DIACRITIC = 29;
LscLexer.DIA_BEFORE = 30;
LscLexer.DIA_FLOATING = 31;
LscLexer.SYMBOL = 32;
LscLexer.SYLLABLE_DECL = 33;
LscLexer.EXPLICIT_SYLLABLES = 34;
LscLexer.ANY_SYLLABLE = 35;
LscLexer.DEROMANIZER = 36;
LscLexer.ROMANIZER = 37;
LscLexer.ALL_MATCHING = 38;
LscLexer.FIRST_MATCHING = 39;
LscLexer.PROPAGATE = 40;
LscLexer.LITERAL = 41;
LscLexer.UNCHANGED = 42;
LscLexer.NUMBER = 43;
LscLexer.NAME = 44;
LscLexer.STR1 = 45;
LscLexer.STR = 46;

LscLexer.prototype.channelNames = [ "DEFAULT_TOKEN_CHANNEL", "HIDDEN" ];

LscLexer.prototype.modeNames = [ "DEFAULT_MODE" ];

LscLexer.prototype.literalNames = [ null, null, null, null, null, null, 
                                    "'_'", null, null, "'('", "')'", "'*'", 
                                    "'['", "']'", "'{'", "'}'", "'+'", "'?'", 
                                    "'-'", "':'", "'!'", "'.'", "'$'", "'$$'", 
                                    "'@'", "'&'", null, null, null, null, 
                                    null, null, null, "'Syllables'", "'explicit'" ];

LscLexer.prototype.symbolicNames = [ null, "COMMENT", "SEP", "CHANGE", "CONDITION", 
                                     "EXCLUSION", "ANCHOR", "NEWLINE", "WHITESPACE", 
                                     "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
                                     "MATRIX_END", "LIST_START", "LIST_END", 
                                     "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", 
                                     "RULE_START", "NEGATION", "SYLLABLE_BOUNDARY", 
                                     "WORD_BOUNDARY", "BETWEEN_WORDS", "CLASSREF", 
                                     "INTERSECTION", "CLASS_DECL", "FEATURE_DECL", 
                                     "SYLLABLE_FEATURE", "DIACRITIC", "DIA_BEFORE", 
                                     "DIA_FLOATING", "SYMBOL", "SYLLABLE_DECL", 
                                     "EXPLICIT_SYLLABLES", "ANY_SYLLABLE", 
                                     "DEROMANIZER", "ROMANIZER", "ALL_MATCHING", 
                                     "FIRST_MATCHING", "PROPAGATE", "LITERAL", 
                                     "UNCHANGED", "NUMBER", "NAME", "STR1", 
                                     "STR" ];

LscLexer.prototype.ruleNames = [ "COMMENT", "SEP", "CHANGE", "CONDITION", 
                                 "EXCLUSION", "ANCHOR", "NEWLINE", "WHITESPACE", 
                                 "O_PAREN", "C_PAREN", "NULL", "MATRIX_START", 
                                 "MATRIX_END", "LIST_START", "LIST_END", 
                                 "AT_LEAST_ONE", "OPTIONAL", "HYPHEN", "RULE_START", 
                                 "NEGATION", "SYLLABLE_BOUNDARY", "WORD_BOUNDARY", 
                                 "BETWEEN_WORDS", "CLASSREF", "INTERSECTION", 
                                 "CLASS_DECL", "FEATURE_DECL", "SYLLABLE_FEATURE", 
                                 "DIACRITIC", "DIA_BEFORE", "DIA_FLOATING", 
                                 "SYMBOL", "SYLLABLE_DECL", "EXPLICIT_SYLLABLES", 
                                 "ANY_SYLLABLE", "DEROMANIZER", "ROMANIZER", 
                                 "ALL_MATCHING", "FIRST_MATCHING", "PROPAGATE", 
                                 "LITERAL", "UNCHANGED", "NUMBER", "NAME", 
                                 "STR1", "STR", "CHAR", "DIGIT", "ANY", 
                                 "COMMENT_START" ];

LscLexer.prototype.grammarFileName = "Lsc.g4";



exports.LscLexer = LscLexer;

