// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASlashCharacterSubstring extends PCharacterSubstring
{
    private TSlash _slash_;
    
    public ASlashCharacterSubstring() {
    }
    
    public ASlashCharacterSubstring(final TSlash slash) {
        this.setSlash(slash);
    }
    
    @Override
    public Object clone() {
        return new ASlashCharacterSubstring(this.cloneNode(this._slash_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASlashCharacterSubstring(this);
    }
    
    public TSlash getSlash() {
        return this._slash_;
    }
    
    public void setSlash(final TSlash slash_) {
        if (this._slash_ != null) {
            this._slash_.parent(null);
        }
        if (slash_ != null) {
            if (slash_.parent() != null) {
                slash_.parent().removeChild(slash_);
            }
            slash_.parent(this);
        }
        this._slash_ = slash_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._slash_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._slash_ == node) {
            this._slash_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._slash_ == node) {
            this.setSlash((TSlash)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
