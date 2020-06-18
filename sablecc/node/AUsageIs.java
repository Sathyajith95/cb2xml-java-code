// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AUsageIs extends PUsageIs
{
    private TUsage _usage_;
    private TIs _is_;
    
    public AUsageIs() {
    }
    
    public AUsageIs(final TUsage usage, final TIs is) {
        this.setUsage(usage);
        this.setIs(is);
    }
    
    @Override
    public Object clone() {
        return new AUsageIs(this.cloneNode(this._usage_), this.cloneNode(this._is_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAUsageIs(this);
    }
    
    public TUsage getUsage() {
        return this._usage_;
    }
    
    public void setUsage(final TUsage usage_) {
        if (this._usage_ != null) {
            this._usage_.parent(null);
        }
        if (usage_ != null) {
            if (usage_.parent() != null) {
                usage_.parent().removeChild(usage_);
            }
            usage_.parent(this);
        }
        this._usage_ = usage_;
    }
    
    public TIs getIs() {
        return this._is_;
    }
    
    public void setIs(final TIs is_) {
        if (this._is_ != null) {
            this._is_.parent(null);
        }
        if (is_ != null) {
            if (is_.parent() != null) {
                is_.parent().removeChild(is_);
            }
            is_.parent(this);
        }
        this._is_ = is_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._usage_) + this.toString(this._is_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._usage_ == node) {
            this._usage_ = null;
            return;
        }
        if (this._is_ == node) {
            this._is_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._usage_ == node) {
            this.setUsage((TUsage)node2);
            return;
        }
        if (this._is_ == node) {
            this.setIs((TIs)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
