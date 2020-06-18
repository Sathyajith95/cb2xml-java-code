// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import java.util.ListIterator;
import java.util.Iterator;
import net.sf.cb2xml.sablecc.analysis.Analysis;
import java.util.List;
import java.util.LinkedList;

public final class AAscendingOrDescendingKeyPhrase extends PAscendingOrDescendingKeyPhrase
{
    private PAscendingOrDescending _ascendingOrDescending_;
    private TKey _key_;
    private TIs _is_;
    private final LinkedList<TDataName> _dataName_;
    
    public AAscendingOrDescendingKeyPhrase() {
        this._dataName_ = new LinkedList<TDataName>();
    }
    
    public AAscendingOrDescendingKeyPhrase(final PAscendingOrDescending ascendingOrDescending, final TKey key, final TIs is, final List<?> dataName) {
        this._dataName_ = new LinkedList<TDataName>();
        this.setAscendingOrDescending(ascendingOrDescending);
        this.setKey(key);
        this.setIs(is);
        this.setDataName(dataName);
    }
    
    @Override
    public Object clone() {
        return new AAscendingOrDescendingKeyPhrase(this.cloneNode(this._ascendingOrDescending_), this.cloneNode(this._key_), this.cloneNode(this._is_), this.cloneList(this._dataName_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAAscendingOrDescendingKeyPhrase(this);
    }
    
    public PAscendingOrDescending getAscendingOrDescending() {
        return this._ascendingOrDescending_;
    }
    
    public void setAscendingOrDescending(final PAscendingOrDescending ascendingOrDescending_) {
        if (this._ascendingOrDescending_ != null) {
            this._ascendingOrDescending_.parent(null);
        }
        if (ascendingOrDescending_ != null) {
            if (ascendingOrDescending_.parent() != null) {
                ascendingOrDescending_.parent().removeChild(ascendingOrDescending_);
            }
            ascendingOrDescending_.parent(this);
        }
        this._ascendingOrDescending_ = ascendingOrDescending_;
    }
    
    public TKey getKey() {
        return this._key_;
    }
    
    public void setKey(final TKey key_) {
        if (this._key_ != null) {
            this._key_.parent(null);
        }
        if (key_ != null) {
            if (key_.parent() != null) {
                key_.parent().removeChild(key_);
            }
            key_.parent(this);
        }
        this._key_ = key_;
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
    
    public LinkedList<TDataName> getDataName() {
        return this._dataName_;
    }
    
    public void setDataName(final List<?> list) {
        final Iterator<TDataName> iterator = this._dataName_.iterator();
        while (iterator.hasNext()) {
            iterator.next().parent(null);
        }
        this._dataName_.clear();
        for (final TDataName e : list) {
            if (e.parent() != null) {
                e.parent().removeChild(e);
            }
            e.parent(this);
            this._dataName_.add(e);
        }
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._ascendingOrDescending_) + this.toString(this._key_) + this.toString(this._is_) + this.toString(this._dataName_);
    }
    
    @Override
    void removeChild(final Node o) {
        if (this._ascendingOrDescending_ == o) {
            this._ascendingOrDescending_ = null;
            return;
        }
        if (this._key_ == o) {
            this._key_ = null;
            return;
        }
        if (this._is_ == o) {
            this._is_ = null;
            return;
        }
        if (this._dataName_.remove(o)) {
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._ascendingOrDescending_ == node) {
            this.setAscendingOrDescending((PAscendingOrDescending)node2);
            return;
        }
        if (this._key_ == node) {
            this.setKey((TKey)node2);
            return;
        }
        if (this._is_ == node) {
            this.setIs((TIs)node2);
            return;
        }
        final ListIterator<TDataName> listIterator = (ListIterator<TDataName>)this._dataName_.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next() == node) {
                if (node2 != null) {
                    listIterator.set((TDataName)node2);
                    node2.parent(this);
                    node.parent(null);
                    return;
                }
                listIterator.remove();
                node.parent(null);
                return;
            }
        }
        throw new RuntimeException("Not a child.");
    }
}
