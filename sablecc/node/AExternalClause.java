// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AExternalClause extends PExternalClause
{
    private TExternal _external_;
    
    public AExternalClause() {
    }
    
    public AExternalClause(final TExternal external) {
        this.setExternal(external);
    }
    
    @Override
    public Object clone() {
        return new AExternalClause(this.cloneNode(this._external_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAExternalClause(this);
    }
    
    public TExternal getExternal() {
        return this._external_;
    }
    
    public void setExternal(final TExternal external_) {
        if (this._external_ != null) {
            this._external_.parent(null);
        }
        if (external_ != null) {
            if (external_.parent() != null) {
                external_.parent().removeChild(external_);
            }
            external_.parent(this);
        }
        this._external_ = external_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._external_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._external_ == node) {
            this._external_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._external_ == node) {
            this.setExternal((TExternal)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
