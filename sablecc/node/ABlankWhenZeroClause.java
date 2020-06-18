// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ABlankWhenZeroClause extends PBlankWhenZeroClause
{
    private TBlank _blank_;
    private TWhen _when_;
    private TZeros _zeros_;
    
    public ABlankWhenZeroClause() {
    }
    
    public ABlankWhenZeroClause(final TBlank blank, final TWhen when, final TZeros zeros) {
        this.setBlank(blank);
        this.setWhen(when);
        this.setZeros(zeros);
    }
    
    @Override
    public Object clone() {
        return new ABlankWhenZeroClause(this.cloneNode(this._blank_), this.cloneNode(this._when_), this.cloneNode(this._zeros_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseABlankWhenZeroClause(this);
    }
    
    public TBlank getBlank() {
        return this._blank_;
    }
    
    public void setBlank(final TBlank blank_) {
        if (this._blank_ != null) {
            this._blank_.parent(null);
        }
        if (blank_ != null) {
            if (blank_.parent() != null) {
                blank_.parent().removeChild(blank_);
            }
            blank_.parent(this);
        }
        this._blank_ = blank_;
    }
    
    public TWhen getWhen() {
        return this._when_;
    }
    
    public void setWhen(final TWhen when_) {
        if (this._when_ != null) {
            this._when_.parent(null);
        }
        if (when_ != null) {
            if (when_.parent() != null) {
                when_.parent().removeChild(when_);
            }
            when_.parent(this);
        }
        this._when_ = when_;
    }
    
    public TZeros getZeros() {
        return this._zeros_;
    }
    
    public void setZeros(final TZeros zeros_) {
        if (this._zeros_ != null) {
            this._zeros_.parent(null);
        }
        if (zeros_ != null) {
            if (zeros_.parent() != null) {
                zeros_.parent().removeChild(zeros_);
            }
            zeros_.parent(this);
        }
        this._zeros_ = zeros_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._blank_) + this.toString(this._when_) + this.toString(this._zeros_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._blank_ == node) {
            this._blank_ = null;
            return;
        }
        if (this._when_ == node) {
            this._when_ = null;
            return;
        }
        if (this._zeros_ == node) {
            this._zeros_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._blank_ == node) {
            this.setBlank((TBlank)node2);
            return;
        }
        if (this._when_ == node) {
            this.setWhen((TWhen)node2);
            return;
        }
        if (this._zeros_ == node) {
            this.setZeros((TZeros)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
