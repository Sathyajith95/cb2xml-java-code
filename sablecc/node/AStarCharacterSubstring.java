// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

public final class AStarCharacterSubstring extends PCharacterSubstring
{
    private TStar _star_;
    
    public AStarCharacterSubstring() {
    }
    
    public AStarCharacterSubstring(final TStar star) {
        this.setStar(star);
    }
    
    @Override
    public Object clone() {
        return new AStarCharacterSubstring(this.cloneNode(this._star_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAStarCharacterSubstring(this);
    }
    
    public TStar getStar() {
        return this._star_;
    }
    
    public void setStar(final TStar star_) {
        if (this._star_ != null) {
            this._star_.parent(null);
        }
        if (star_ != null) {
            if (star_.parent() != null) {
                star_.parent().removeChild(star_);
            }
            star_.parent(this);
        }
        this._star_ = star_;
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._star_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._star_ == node) {
            this._star_ = null;
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._star_ == node) {
            this.setStar((TStar)node2);
            return;
        }
        throw new RuntimeException("Not a child.");
    }
}
