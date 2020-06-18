// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AGlobalClause extends PGlobalClause
{
    private TGlobal _global_;
    
    public AGlobalClause() {
    }
    
    public AGlobalClause(final TGlobal global) {
        this.setGlobal(global);
    }
    
    @Override
    public Object clone() {
        return new AGlobalClause(this.cloneNode(this._global_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAGlobalClause(this);
    }
    
    public TGlobal getGlobal() {
        return this._global_;
    }
    
    public void setGlobal(final TGlobal global_) {
        if (this._global_ != null) {
            this._global_.parent(null);
        }
        if (global_ != null) {
            if (global_.parent() != null) {
                global_.parent().removeChild(global_);
            }
            global_.parent(this);
        }
        this._global_ = global_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._global_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._global_ == node) {
            this._global_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._global_ == node) {
            this.setGlobal((TGlobal)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
