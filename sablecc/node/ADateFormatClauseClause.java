// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ADateFormatClauseClause extends PClause
{
    private PDateFormatClause _dateFormatClause_;
    
    public ADateFormatClauseClause() {
    }
    
    public ADateFormatClauseClause(final PDateFormatClause dateFormatClause) {
        this.setDateFormatClause(dateFormatClause);
    }
    
    @Override
    public Object clone() {
        return new ADateFormatClauseClause(this.cloneNode(this._dateFormatClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseADateFormatClauseClause(this);
    }
    
    public PDateFormatClause getDateFormatClause() {
        return this._dateFormatClause_;
    }
    
    public void setDateFormatClause(final PDateFormatClause dateFormatClause_) {
        if (this._dateFormatClause_ != null) {
            this._dateFormatClause_.parent(null);
        }
        if (dateFormatClause_ != null) {
            if (dateFormatClause_.parent() != null) {
                dateFormatClause_.parent().removeChild(dateFormatClause_);
            }
            dateFormatClause_.parent(this);
        }
        this._dateFormatClause_ = dateFormatClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._dateFormatClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._dateFormatClause_ == node) {
            this._dateFormatClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._dateFormatClause_ == node) {
            this.setDateFormatClause((PDateFormatClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
