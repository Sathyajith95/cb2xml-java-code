// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AUsageClause extends PUsageClause
{
    private PUsageIs _usageIs_;
    private PUsagePhrase _usagePhrase_;
    
    public AUsageClause() {
    }
    
    public AUsageClause(final PUsageIs usageIs, final PUsagePhrase usagePhrase) {
        this.setUsageIs(usageIs);
        this.setUsagePhrase(usagePhrase);
    }
    
    @Override
    public Object clone() {
        return new AUsageClause(this.cloneNode(this._usageIs_), this.cloneNode(this._usagePhrase_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAUsageClause(this);
    }
    
    public PUsageIs getUsageIs() {
        return this._usageIs_;
    }
    
    public void setUsageIs(final PUsageIs usageIs_) {
        if (this._usageIs_ != null) {
            this._usageIs_.parent(null);
        }
        if (usageIs_ != null) {
            if (usageIs_.parent() != null) {
                usageIs_.parent().removeChild(usageIs_);
            }
            usageIs_.parent(this);
        }
        this._usageIs_ = usageIs_;
    }
    
    public PUsagePhrase getUsagePhrase() {
        return this._usagePhrase_;
    }
    
    public void setUsagePhrase(final PUsagePhrase usagePhrase_) {
        if (this._usagePhrase_ != null) {
            this._usagePhrase_.parent(null);
        }
        if (usagePhrase_ != null) {
            if (usagePhrase_.parent() != null) {
                usagePhrase_.parent().removeChild(usagePhrase_);
            }
            usagePhrase_.parent(this);
        }
        this._usagePhrase_ = usagePhrase_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._usageIs_) + this.toString(this._usagePhrase_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._usageIs_ == node) {
            this._usageIs_ = null;
            return;
        }
        if (this._usagePhrase_ == node) {
            this._usagePhrase_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._usageIs_ == node) {
            this.setUsageIs((PUsageIs)node2);
            return;
        }
        if (this._usagePhrase_ == node) {
            this.setUsagePhrase((PUsagePhrase)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
