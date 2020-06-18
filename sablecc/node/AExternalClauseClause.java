// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AExternalClauseClause extends PClause
{
    private PExternalClause _externalClause_;
    
    public AExternalClauseClause() {
    }
    
    public AExternalClauseClause(final PExternalClause externalClause) {
        this.setExternalClause(externalClause);
    }
    
    @Override
    public Object clone() {
        return new AExternalClauseClause(this.cloneNode(this._externalClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAExternalClauseClause(this);
    }
    
    public PExternalClause getExternalClause() {
        return this._externalClause_;
    }
    
    public void setExternalClause(final PExternalClause externalClause_) {
        if (this._externalClause_ != null) {
            this._externalClause_.parent(null);
        }
        if (externalClause_ != null) {
            if (externalClause_.parent() != null) {
                externalClause_.parent().removeChild(externalClause_);
            }
            externalClause_.parent(this);
        }
        this._externalClause_ = externalClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._externalClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._externalClause_ == node) {
            this._externalClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._externalClause_ == node) {
            this.setExternalClause((PExternalClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
