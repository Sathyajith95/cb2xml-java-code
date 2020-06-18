// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AValueClauseClause extends PClause
{
    private PValueClause _valueClause_;
    
    public AValueClauseClause() {
    }
    
    public AValueClauseClause(final PValueClause valueClause) {
        this.setValueClause(valueClause);
    }
    
    @Override
    public Object clone() {
        return new AValueClauseClause(this.cloneNode(this._valueClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAValueClauseClause(this);
    }
    
    public PValueClause getValueClause() {
        return this._valueClause_;
    }
    
    public void setValueClause(final PValueClause valueClause_) {
        if (this._valueClause_ != null) {
            this._valueClause_.parent(null);
        }
        if (valueClause_ != null) {
            if (valueClause_.parent() != null) {
                valueClause_.parent().removeChild(valueClause_);
            }
            valueClause_.parent(this);
        }
        this._valueClause_ = valueClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._valueClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._valueClause_ == node) {
            this._valueClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._valueClause_ == node) {
            this.setValueClause((PValueClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
