// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ANullsLiteral extends PLiteral
{
    private TNulls _nulls_;
    
    public ANullsLiteral() {
    }
    
    public ANullsLiteral(final TNulls nulls) {
        this.setNulls(nulls);
    }
    
    @Override
    public Object clone() {
        return new ANullsLiteral(this.cloneNode(this._nulls_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseANullsLiteral(this);
    }
    
    public TNulls getNulls() {
        return this._nulls_;
    }
    
    public void setNulls(final TNulls nulls_) {
        if (this._nulls_ != null) {
            this._nulls_.parent(null);
        }
        if (nulls_ != null) {
            if (nulls_.parent() != null) {
                nulls_.parent().removeChild(nulls_);
            }
            nulls_.parent(this);
        }
        this._nulls_ = nulls_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._nulls_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._nulls_ == node) {
            this._nulls_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._nulls_ == node) {
            this.setNulls((TNulls)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
