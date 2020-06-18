// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class ASequenceGroupItem extends PGroupItem
{
    private PGroupItem _groupItem_;
    private TDot _dot_;
    private PElementaryItem _elementaryItem_;
    
    public ASequenceGroupItem() {
    }
    
    public ASequenceGroupItem(final PGroupItem groupItem, final TDot dot, final PElementaryItem elementaryItem) {
        this.setGroupItem(groupItem);
        this.setDot(dot);
        this.setElementaryItem(elementaryItem);
    }
    
    @Override
    public Object clone() {
        return new ASequenceGroupItem(this.cloneNode(this._groupItem_), this.cloneNode(this._dot_), this.cloneNode(this._elementaryItem_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseASequenceGroupItem(this);
    }
    
    public PGroupItem getGroupItem() {
        return this._groupItem_;
    }
    
    public void setGroupItem(final PGroupItem groupItem_) {
        if (this._groupItem_ != null) {
            this._groupItem_.parent(null);
        }
        if (groupItem_ != null) {
            if (groupItem_.parent() != null) {
                groupItem_.parent().removeChild(groupItem_);
            }
            groupItem_.parent(this);
        }
        this._groupItem_ = groupItem_;
    }
    
    public TDot getDot() {
        return this._dot_;
    }
    
    public void setDot(final TDot dot_) {
        if (this._dot_ != null) {
            this._dot_.parent(null);
        }
        if (dot_ != null) {
            if (dot_.parent() != null) {
                dot_.parent().removeChild(dot_);
            }
            dot_.parent(this);
        }
        this._dot_ = dot_;
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
        return "" + this.toString(this._groupItem_) + this.toString(this._dot_) + this.toString(this._elementaryItem_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._groupItem_ == node) {
            this._groupItem_ = null;
            return;
        }
        if (this._dot_ == node) {
            this._dot_ = null;
            return;
        }
        if (this._elementaryItem_ == node) {
            this._elementaryItem_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._groupItem_ == node) {
            this.setGroupItem((PGroupItem)node2);
            return;
        }
        if (this._dot_ == node) {
            this.setDot((TDot)node2);
            return;
        }
        if (this._elementaryItem_ == node) {
            this.setElementaryItem((PElementaryItem)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
