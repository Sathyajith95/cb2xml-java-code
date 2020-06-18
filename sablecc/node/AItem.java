// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AItem extends PItem
{
    private TNumberNot88 _numberNot88_;
    private PDataNameOrFiller _dataNameOrFiller_;
    private PRedefinesClause _redefinesClause_;
    private PClauseSequence _clauseSequence_;
    
    public AItem() {
    }
    
    public AItem(final TNumberNot88 numberNot88, final PDataNameOrFiller dataNameOrFiller, final PRedefinesClause redefinesClause, final PClauseSequence clauseSequence) {
        this.setNumberNot88(numberNot88);
        this.setDataNameOrFiller(dataNameOrFiller);
        this.setRedefinesClause(redefinesClause);
        this.setClauseSequence(clauseSequence);
    }
    
    @Override
    public Object clone() {
        return new AItem(this.cloneNode(this._numberNot88_), this.cloneNode(this._dataNameOrFiller_), this.cloneNode(this._redefinesClause_), this.cloneNode(this._clauseSequence_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAItem(this);
    }
    
    public TNumberNot88 getNumberNot88() {
        return this._numberNot88_;
    }
    
    public void setNumberNot88(final TNumberNot88 numberNot88_) {
        if (this._numberNot88_ != null) {
            this._numberNot88_.parent(null);
        }
        if (numberNot88_ != null) {
            if (numberNot88_.parent() != null) {
                numberNot88_.parent().removeChild(numberNot88_);
            }
            numberNot88_.parent(this);
        }
        this._numberNot88_ = numberNot88_;
    }
    
    public PDataNameOrFiller getDataNameOrFiller() {
        return this._dataNameOrFiller_;
    }
    
    public void setDataNameOrFiller(final PDataNameOrFiller dataNameOrFiller_) {
        if (this._dataNameOrFiller_ != null) {
            this._dataNameOrFiller_.parent(null);
        }
        if (dataNameOrFiller_ != null) {
            if (dataNameOrFiller_.parent() != null) {
                dataNameOrFiller_.parent().removeChild(dataNameOrFiller_);
            }
            dataNameOrFiller_.parent(this);
        }
        this._dataNameOrFiller_ = dataNameOrFiller_;
    }
    
    public PRedefinesClause getRedefinesClause() {
        return this._redefinesClause_;
    }
    
    public void setRedefinesClause(final PRedefinesClause redefinesClause_) {
        if (this._redefinesClause_ != null) {
            this._redefinesClause_.parent(null);
        }
        if (redefinesClause_ != null) {
            if (redefinesClause_.parent() != null) {
                redefinesClause_.parent().removeChild(redefinesClause_);
            }
            redefinesClause_.parent(this);
        }
        this._redefinesClause_ = redefinesClause_;
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
    
    @Override
    public String toString() {
        return "" + this.toString(this._numberNot88_) + this.toString(this._dataNameOrFiller_) + this.toString(this._redefinesClause_) + this.toString(this._clauseSequence_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._numberNot88_ == node) {
            this._numberNot88_ = null;
            return;
        }
        if (this._dataNameOrFiller_ == node) {
            this._dataNameOrFiller_ = null;
            return;
        }
        if (this._redefinesClause_ == node) {
            this._redefinesClause_ = null;
            return;
        }
        if (this._clauseSequence_ == node) {
            this._clauseSequence_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._numberNot88_ == node) {
            this.setNumberNot88((TNumberNot88)node2);
            return;
        }
        if (this._dataNameOrFiller_ == node) {
            this.setDataNameOrFiller((PDataNameOrFiller)node2);
            return;
        }
        if (this._redefinesClause_ == node) {
            this.setRedefinesClause((PRedefinesClause)node2);
            return;
        }
        if (this._clauseSequence_ == node) {
            this.setClauseSequence((PClauseSequence)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
