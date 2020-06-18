// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AJustifiedClauseClause extends PClause
{
    private PJustifiedClause _justifiedClause_;
    
    public AJustifiedClauseClause() {
    }
    
    public AJustifiedClauseClause(final PJustifiedClause justifiedClause) {
        this.setJustifiedClause(justifiedClause);
    }
    
    @Override
    public Object clone() {
        return new AJustifiedClauseClause(this.cloneNode(this._justifiedClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAJustifiedClauseClause(this);
    }
    
    public PJustifiedClause getJustifiedClause() {
        return this._justifiedClause_;
    }
    
    public void setJustifiedClause(final PJustifiedClause justifiedClause_) {
        if (this._justifiedClause_ != null) {
            this._justifiedClause_.parent(null);
        }
        if (justifiedClause_ != null) {
            if (justifiedClause_.parent() != null) {
                justifiedClause_.parent().removeChild(justifiedClause_);
            }
            justifiedClause_.parent(this);
        }
        this._justifiedClause_ = justifiedClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._justifiedClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._justifiedClause_ == node) {
            this._justifiedClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._justifiedClause_ == node) {
            this.setJustifiedClause((PJustifiedClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
