// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AIndexUsagePhrase extends PUsagePhrase
{
    private TIndex _index_;
    
    public AIndexUsagePhrase() {
    }
    
    public AIndexUsagePhrase(final TIndex index) {
        this.setIndex(index);
    }
    
    @Override
    public Object clone() {
        return new AIndexUsagePhrase(this.cloneNode(this._index_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAIndexUsagePhrase(this);
    }
    
    public TIndex getIndex() {
        return this._index_;
    }
    
    public void setIndex(final TIndex index_) {
        if (this._index_ != null) {
            this._index_.parent(null);
        }
        if (index_ != null) {
            if (index_.parent() != null) {
                index_.parent().removeChild(index_);
            }
            index_.parent(this);
        }
        this._index_ = index_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._index_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._index_ == node) {
            this._index_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._index_ == node) {
            this.setIndex((TIndex)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
