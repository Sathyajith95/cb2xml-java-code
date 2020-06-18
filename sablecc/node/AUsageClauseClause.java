// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AUsageClauseClause extends PClause
{
    private PUsageClause _usageClause_;
    
    public AUsageClauseClause() {
    }
    
    public AUsageClauseClause(final PUsageClause usageClause) {
        this.setUsageClause(usageClause);
    }
    
    @Override
    public Object clone() {
        return new AUsageClauseClause(this.cloneNode(this._usageClause_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAUsageClauseClause(this);
    }
    
    public PUsageClause getUsageClause() {
        return this._usageClause_;
    }
    
    public void setUsageClause(final PUsageClause usageClause_) {
        if (this._usageClause_ != null) {
            this._usageClause_.parent(null);
        }
        if (usageClause_ != null) {
            if (usageClause_.parent() != null) {
                usageClause_.parent().removeChild(usageClause_);
            }
            usageClause_.parent(this);
        }
        this._usageClause_ = usageClause_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._usageClause_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._usageClause_ == node) {
            this._usageClause_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._usageClause_ == node) {
            this.setUsageClause((PUsageClause)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
