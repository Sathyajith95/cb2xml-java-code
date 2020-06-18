// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AValueItemElementaryItem extends PElementaryItem
{
    private PValueItem _valueItem_;
    
    public AValueItemElementaryItem() {
    }
    
    public AValueItemElementaryItem(final PValueItem valueItem) {
        this.setValueItem(valueItem);
    }
    
    @Override
    public Object clone() {
        return new AValueItemElementaryItem(this.cloneNode(this._valueItem_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAValueItemElementaryItem(this);
    }
    
    public PValueItem getValueItem() {
        return this._valueItem_;
    }
    
    public void setValueItem(final PValueItem valueItem_) {
        if (this._valueItem_ != null) {
            this._valueItem_.parent(null);
        }
        if (valueItem_ != null) {
            if (valueItem_.parent() != null) {
                valueItem_.parent().removeChild(valueItem_);
            }
            valueItem_.parent(this);
        }
        this._valueItem_ = valueItem_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._valueItem_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._valueItem_ == node) {
            this._valueItem_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._valueItem_ == node) {
            this.setValueItem((PValueItem)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
