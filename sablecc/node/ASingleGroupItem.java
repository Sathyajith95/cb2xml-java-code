// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASingleGroupItem extends PGroupItem
{
    private PElementaryItem _elementaryItem_;
    
    public ASingleGroupItem() {
    }
    
    public ASingleGroupItem(final PElementaryItem elementaryItem) {
        this.setElementaryItem(elementaryItem);
    }
    
    @Override
    public Object clone() {
        return new ASingleGroupItem(this.cloneNode(this._elementaryItem_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASingleGroupItem(this);
    }
    
    public PElementaryItem getElementaryItem() {
        return this._elementaryItem_;
    }
    
    public void setElementaryItem(final PElementaryItem elementaryItem_) {
        if (this._elementaryItem_ != null) {
            this._elementaryItem_.parent(null);
        }
        if (elementaryItem_ != null) {
            if (elementaryItem_.parent() != null) {
                elementaryItem_.parent().removeChild(elementaryItem_);
            }
            elementaryItem_.parent(this);
        }
        this._elementaryItem_ = elementaryItem_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._elementaryItem_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._elementaryItem_ == node) {
            this._elementaryItem_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._elementaryItem_ == node) {
            this.setElementaryItem((PElementaryItem)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
