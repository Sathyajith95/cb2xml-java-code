// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class TMinus extends Token
{
    public TMinus() {
        super.setText("-");
    }
    
    public TMinus(final int line, final int pos) {
        super.setText("-");
        this.setLine(line);
        this.setPos(pos);
    }
    
    @Override
    public Object clone() {
        return new TMinus(this.getLine(), this.getPos());
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseTMinus(this);
    }
    
    @Override
    public void setText(final String s) {
        throw new RuntimeException("Cannot change TMinus text.");
    }
}
