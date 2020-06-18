// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AOccursClauseClause extends PClause
{
    private POccursClause _occursClause_;
    
    public AOccursClauseClause() {
    }
    
    public AOccursClauseClause(final POccursClause occursClause) {
        this.setOccursClause(occursClause);
    }
    
    @Override
    public Object clone() {
        return new AOccursClauseClause(this.cloneNode(this._occursClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAOccursClauseClause(this);
    }
    
    public POccursClause getOccursClause() {
        return this._occursClause_;
    }
    
    public void setOccursClause(final POccursClause occursClause_) {
        if (this._occursClause_ != null) {
            this._occursClause_.parent(null);
        }
        if (occursClause_ != null) {
            if (occursClause_.parent() != null) {
                occursClause_.parent().removeChild(occursClause_);
            }
            occursClause_.parent(this);
        }
        this._occursClause_ = occursClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._occursClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._occursClause_ == node) {
            this._occursClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._occursClause_ == node) {
            this.setOccursClause((POccursClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
