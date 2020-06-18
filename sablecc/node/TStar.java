// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class TStar extends Token
{
    public TStar() {
        super.setText("*");
    }
    
    public TStar(final int line, final int pos) {
        super.setText("*");
        this.setLine(line);
        this.setPos(pos);
    }
    
    @Override
    public Object clone() {
        return new TStar(this.getLine(), this.getPos());
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseTStar(this);
    }
    
    @Override
    public void setText(final String s) {
        throw new RuntimeException("Cannot change TStar text.");
    }
}
