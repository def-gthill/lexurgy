// Generated from Awkwords.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');

// This class defines a complete generic visitor for a parse tree produced by AwkwordsParser.

function AwkwordsVisitor() {
	antlr4.tree.ParseTreeVisitor.call(this);
	return this;
}

AwkwordsVisitor.prototype = Object.create(antlr4.tree.ParseTreeVisitor.prototype);
AwkwordsVisitor.prototype.constructor = AwkwordsVisitor;

// Visit a parse tree produced by AwkwordsParser#awkfile.
AwkwordsVisitor.prototype.visitAwkfile = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#numwords.
AwkwordsVisitor.prototype.visitNumwords = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#subpattern.
AwkwordsVisitor.prototype.visitSubpattern = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#pattern.
AwkwordsVisitor.prototype.visitPattern = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#alternative.
AwkwordsVisitor.prototype.visitAlternative = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#weightedchoice.
AwkwordsVisitor.prototype.visitWeightedchoice = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#altchoice.
AwkwordsVisitor.prototype.visitAltchoice = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#filtered.
AwkwordsVisitor.prototype.visitFiltered = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#filterstring.
AwkwordsVisitor.prototype.visitFilterstring = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#optional.
AwkwordsVisitor.prototype.visitOptional = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#sequence.
AwkwordsVisitor.prototype.visitSequence = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#group.
AwkwordsVisitor.prototype.visitGroup = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#escape.
AwkwordsVisitor.prototype.visitEscape = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#subref.
AwkwordsVisitor.prototype.visitSubref = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#anychar.
AwkwordsVisitor.prototype.visitAnychar = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#atom.
AwkwordsVisitor.prototype.visitAtom = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by AwkwordsParser#number.
AwkwordsVisitor.prototype.visitNumber = function(ctx) {
  return this.visitChildren(ctx);
};



exports.AwkwordsVisitor = AwkwordsVisitor;