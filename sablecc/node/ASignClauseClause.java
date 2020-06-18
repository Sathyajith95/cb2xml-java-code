// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASignClauseClause extends PClause
{
    private PSignClause _signClause_;
    
    public ASignClauseClause() {
    }
    
    public ASignClauseClause(final PSignClause signClause) {
        this.setSignClause(signClause);
    }
    
    @Override
    public Object clone() {
        return new ASignClauseClause(this.cloneNode(this._signClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASignClauseClause(this);
    }
    
    public PSignClause getSignClause() {
        return this._signClause_;
    }
    
    public void setSignClause(final PSignClause signClause_) {
        if (this._signClause_ != null) {
            this._signClause_.parent(null);
        }
        if (signClause_ != null) {
            if (signClause_.parent() != null) {
                signClause_.parent().removeChild(signClause_);
            }
            signClause_.parent(this);
        }
        this._signClause_ = signClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._signClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._signClause_ == node) {
            this._signClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._signClause_ == node) {
            this.setSignClause((PSignClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
