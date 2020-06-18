// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

public abstract class Token extends Node
{
    private String text;
    private int line;
    private int pos;
    
    public String getText() {
        return this.text;
    }
    
    public void setText(final String text) {
        this.text = text;
    }
    
    public int getLine() {
        return this.line;
    }
    
    public void setLine(final int line) {
        this.line = line;
    }
    
    public int getPos() {
        return this.pos;
    }
    
    public void setPos(final int pos) {
        this.pos = pos;
    }
    
    @Override
    public String toString() {
        return this.text + " ";
    }
    
    @Override
    void removeChild(final Node node) {
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        throw new RuntimeException("Not a child.");
    }
}
