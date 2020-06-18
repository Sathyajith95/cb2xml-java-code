// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class TJustified extends Token
{
    public TJustified(final String text) {
        this.setText(text);
    }
    
    public TJustified(final String text, final int line, final int pos) {
        this.setText(text);
        this.setLine(line);
        this.setPos(pos);
    }
    
    @Override
    public Object clone() {
        return new TJustified(this.getText(), this.getLine(), this.getPos());
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseTJustified(this);
    }
}