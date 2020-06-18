// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASingleClauseSequence extends PClauseSequence
{
    private PClause _clause_;
    
    public ASingleClauseSequence() {
    }
    
    public ASingleClauseSequence(final PClause clause) {
        this.setClause(clause);
    }
    
    @Override
    public Object clone() {
        return new ASingleClauseSequence(this.cloneNode(this._clause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASingleClauseSequence(this);
    }
    
    public PClause getClause() {
        return this._clause_;
    }
    
    public void setClause(final PClause clause_) {
        if (this._clause_ != null) {
            this._clause_.parent(null);
        }
        if (clause_ != null) {
            if (clause_.parent() != null) {
                clause_.parent().removeChild(clause_);
            }
            clause_.parent(this);
        }
        this._clause_ = clause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._clause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._clause_ == node) {
            this._clause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._clause_ == node) {
            this.setClause((PClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
