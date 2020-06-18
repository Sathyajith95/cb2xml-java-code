// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AItemElementaryItem extends PElementaryItem
{
    private PItem _item_;
    
    public AItemElementaryItem() {
    }
    
    public AItemElementaryItem(final PItem item) {
        this.setItem(item);
    }
    
    @Override
    public Object clone() {
        return new AItemElementaryItem(this.cloneNode(this._item_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAItemElementaryItem(this);
    }
    
    public PItem getItem() {
        return this._item_;
    }
    
    public void setItem(final PItem item_) {
        if (this._item_ != null) {
            this._item_.parent(null);
        }
        if (item_ != null) {
            if (item_.parent() != null) {
                item_.parent().removeChild(item_);
            }
            item_.parent(this);
        }
        this._item_ = item_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._item_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._item_ == node) {
            this._item_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._item_ == node) {
            this.setItem((PItem)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
