// Generated from Lgn.g4 by ANTLR 4.7.2
// jshint ignore: start
var antlr4 = require('antlr4/index');

// This class defines a complete generic visitor for a parse tree produced by LgnParser.

function LgnVisitor() {
	antlr4.tree.ParseTreeVisitor.call(this);
	return this;
}

LgnVisitor.prototype = Object.create(antlr4.tree.ParseTreeVisitor.prototype);
LgnVisitor.prototype.constructor = LgnVisitor;

// Visit a parse tree produced by LgnParser#classdecl.
LgnVisitor.prototype.visitClassdecl = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#classelement.
LgnVisitor.prototype.visitClasselement = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#patterndecl.
LgnVisitor.prototype.visitPatterndecl = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#pattern.
LgnVisitor.prototype.visitPattern = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#sequence.
LgnVisitor.prototype.visitSequence = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#sequenceelement.
LgnVisitor.prototype.visitSequenceelement = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#optional.
LgnVisitor.prototype.visitOptional = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#list.
LgnVisitor.prototype.visitList = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#simple.
LgnVisitor.prototype.visitSimple = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#classref.
LgnVisitor.prototype.visitClassref = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#name.
LgnVisitor.prototype.visitName = function(ctx) {
  return this.visitChildren(ctx);
};


// Visit a parse tree produced by LgnParser#text.
LgnVisitor.prototype.visitText = function(ctx) {
  return this.visitChildren(ctx);
};



exports.LgnVisitor = LgnVisitor;