// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ARenamesItemElementaryItem extends PElementaryItem
{
    private PRenamesItem _renamesItem_;
    
    public ARenamesItemElementaryItem() {
    }
    
    public ARenamesItemElementaryItem(final PRenamesItem renamesItem) {
        this.setRenamesItem(renamesItem);
    }
    
    @Override
    public Object clone() {
        return new ARenamesItemElementaryItem(this.cloneNode(this._renamesItem_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseARenamesItemElementaryItem(this);
    }
    
    public PRenamesItem getRenamesItem() {
        return this._renamesItem_;
    }
    
    public void setRenamesItem(final PRenamesItem renamesItem_) {
        if (this._renamesItem_ != null) {
            this._renamesItem_.parent(null);
        }
        if (renamesItem_ != null) {
            if (renamesItem_.parent() != null) {
                renamesItem_.parent().removeChild(renamesItem_);
            }
            renamesItem_.parent(this);
        }
        this._renamesItem_ = renamesItem_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._renamesItem_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._renamesItem_ == node) {
            this._renamesItem_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._renamesItem_ == node) {
            this.setRenamesItem((PRenamesItem)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
