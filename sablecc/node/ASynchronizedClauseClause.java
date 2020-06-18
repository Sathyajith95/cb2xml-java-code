// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASynchronizedClauseClause extends PClause
{
    private PSynchronizedClause _synchronizedClause_;
    
    public ASynchronizedClauseClause() {
    }
    
    public ASynchronizedClauseClause(final PSynchronizedClause synchronizedClause) {
        this.setSynchronizedClause(synchronizedClause);
    }
    
    @Override
    public Object clone() {
        return new ASynchronizedClauseClause(this.cloneNode(this._synchronizedClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASynchronizedClauseClause(this);
    }
    
    public PSynchronizedClause getSynchronizedClause() {
        return this._synchronizedClause_;
    }
    
    public void setSynchronizedClause(final PSynchronizedClause synchronizedClause_) {
        if (this._synchronizedClause_ != null) {
            this._synchronizedClause_.parent(null);
        }
        if (synchronizedClause_ != null) {
            if (synchronizedClause_.parent() != null) {
                synchronizedClause_.parent().removeChild(synchronizedClause_);
            }
            synchronizedClause_.parent(this);
        }
        this._synchronizedClause_ = synchronizedClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._synchronizedClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._synchronizedClause_ == node) {
            this._synchronizedClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._synchronizedClause_ == node) {
            this.setSynchronizedClause((PSynchronizedClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
