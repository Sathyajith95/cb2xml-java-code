// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ABracketedNumberCharacterSubstring extends PCharacterSubstring
{
    private PBracketedNumber _bracketedNumber_;
    
    public ABracketedNumberCharacterSubstring() {
    }
    
    public ABracketedNumberCharacterSubstring(final PBracketedNumber bracketedNumber) {
        this.setBracketedNumber(bracketedNumber);
    }
    
    @Override
    public Object clone() {
        return new ABracketedNumberCharacterSubstring(this.cloneNode(this._bracketedNumber_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseABracketedNumberCharacterSubstring(this);
    }
    
    public PBracketedNumber getBracketedNumber() {
        return this._bracketedNumber_;
    }
    
    public void setBracketedNumber(final PBracketedNumber bracketedNumber_) {
        if (this._bracketedNumber_ != null) {
            this._bracketedNumber_.parent(null);
        }
        if (bracketedNumber_ != null) {
            if (bracketedNumber_.parent() != null) {
                bracketedNumber_.parent().removeChild(bracketedNumber_);
            }
            bracketedNumber_.parent(this);
        }
        this._bracketedNumber_ = bracketedNumber_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._bracketedNumber_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._bracketedNumber_ == node) {
            this._bracketedNumber_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._bracketedNumber_ == node) {
            this.setBracketedNumber((PBracketedNumber)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
