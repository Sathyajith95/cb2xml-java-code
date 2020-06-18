// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AGlobalClauseClause extends PClause
{
    private PGlobalClause _globalClause_;
    
    public AGlobalClauseClause() {
    }
    
    public AGlobalClauseClause(final PGlobalClause globalClause) {
        this.setGlobalClause(globalClause);
    }
    
    @Override
    public Object clone() {
        return new AGlobalClauseClause(this.cloneNode(this._globalClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAGlobalClauseClause(this);
    }
    
    public PGlobalClause getGlobalClause() {
        return this._globalClause_;
    }
    
    public void setGlobalClause(final PGlobalClause globalClause_) {
        if (this._globalClause_ != null) {
            this._globalClause_.parent(null);
        }
        if (globalClause_ != null) {
            if (globalClause_.parent() != null) {
                globalClause_.parent().removeChild(globalClause_);
            }
            globalClause_.parent(this);
        }
        this._globalClause_ = globalClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._globalClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._globalClause_ == node) {
            this._globalClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._globalClause_ == node) {
            this.setGlobalClause((PGlobalClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
