// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class TExternal extends Token
{
    public TExternal(final String text) {
        this.setText(text);
    }
    
    public TExternal(final String text, final int line, final int pos) {
        this.setText(text);
        this.setLine(line);
        this.setPos(pos);
    }
    
    @Override
    public Object clone() {
        return new TExternal(this.getText(), this.getLine(), this.getPos());
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseTExternal(this);
    }
}