// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ABlankWhenZeroClauseClause extends PClause
{
    private PBlankWhenZeroClause _blankWhenZeroClause_;
    
    public ABlankWhenZeroClauseClause() {
    }
    
    public ABlankWhenZeroClauseClause(final PBlankWhenZeroClause blankWhenZeroClause) {
        this.setBlankWhenZeroClause(blankWhenZeroClause);
    }
    
    @Override
    public Object clone() {
        return new ABlankWhenZeroClauseClause(this.cloneNode(this._blankWhenZeroClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseABlankWhenZeroClauseClause(this);
    }
    
    public PBlankWhenZeroClause getBlankWhenZeroClause() {
        return this._blankWhenZeroClause_;
    }
    
    public void setBlankWhenZeroClause(final PBlankWhenZeroClause blankWhenZeroClause_) {
        if (this._blankWhenZeroClause_ != null) {
            this._blankWhenZeroClause_.parent(null);
        }
        if (blankWhenZeroClause_ != null) {
            if (blankWhenZeroClause_.parent() != null) {
                blankWhenZeroClause_.parent().removeChild(blankWhenZeroClause_);
            }
            blankWhenZeroClause_.parent(this);
        }
        this._blankWhenZeroClause_ = blankWhenZeroClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._blankWhenZeroClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._blankWhenZeroClause_ == node) {
            this._blankWhenZeroClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._blankWhenZeroClause_ == node) {
            this.setBlankWhenZeroClause((PBlankWhenZeroClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
