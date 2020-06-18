// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASequenceClauseSequence extends PClauseSequence
{
    private PClauseSequence _clauseSequence_;
    private PClause _clause_;
    
    public ASequenceClauseSequence() {
    }
    
    public ASequenceClauseSequence(final PClauseSequence clauseSequence, final PClause clause) {
        this.setClauseSequence(clauseSequence);
        this.setClause(clause);
    }
    
    @Override
    public Object clone() {
        return new ASequenceClauseSequence(this.cloneNode(this._clauseSequence_), this.cloneNode(this._clause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASequenceClauseSequence(this);
    }
    
    public PClauseSequence getClauseSequence() {
        return this._clauseSequence_;
    }
    
    public void setClauseSequence(final PClauseSequence clauseSequence_) {
        if (this._clauseSequence_ != null) {
            this._clauseSequence_.parent(null);
        }
        if (clauseSequence_ != null) {
            if (clauseSequence_.parent() != null) {
                clauseSequence_.parent().removeChild(clauseSequence_);
            }
            clauseSequence_.parent(this);
        }
        this._clauseSequence_ = clauseSequence_;
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
        return "" + this.toString(this._clauseSequence_) + this.toString(this._clause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._clauseSequence_ == node) {
            this._clauseSequence_ = null;
            return;
        }
        if (this._clause_ == node) {
            this._clause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._clauseSequence_ == node) {
            this.setClauseSequence((PClauseSequence)node2);
            return;
        }
        if (this._clause_ == node) {
            this.setClause((PClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
