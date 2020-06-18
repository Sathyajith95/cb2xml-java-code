// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import java.util.ListIterator;
import java.util.Iterator;
import net.sf.cb2xml.sablecc.analysis.Analysis;
import java.util.List;
import java.util.LinkedList;

public final class AIndexedByPhrase extends PIndexedByPhrase
{
    private TIndexed _indexed_;
    private TBy _by_;
    private final LinkedList<TDataName> _dataName_;
    
    public AIndexedByPhrase() {
        this._dataName_ = new LinkedList<TDataName>();
    }
    
    public AIndexedByPhrase(final TIndexed indexed, final TBy by, final List<?> dataName) {
        this._dataName_ = new LinkedList<TDataName>();
        this.setIndexed(indexed);
        this.setBy(by);
        this.setDataName(dataName);
    }
    
    @Override
    public Object clone() {
        return new AIndexedByPhrase(this.cloneNode(this._indexed_), this.cloneNode(this._by_), this.cloneList(this._dataName_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAIndexedByPhrase(this);
    }
    
    public TIndexed getIndexed() {
        return this._indexed_;
    }
    
    public void setIndexed(final TIndexed indexed_) {
        if (this._indexed_ != null) {
            this._indexed_.parent(null);
        }
        if (indexed_ != null) {
            if (indexed_.parent() != null) {
                indexed_.parent().removeChild(indexed_);
            }
            indexed_.parent(this);
        }
        this._indexed_ = indexed_;
    }
    
    public TBy getBy() {
        return this._by_;
    }
    
    public void setBy(final TBy by_) {
        if (this._by_ != null) {
            this._by_.parent(null);
        }
        if (by_ != null) {
            if (by_.parent() != null) {
                by_.parent().removeChild(by_);
            }
            by_.parent(this);
        }
        this._by_ = by_;
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
        return "" + this.toString(this._indexed_) + this.toString(this._by_) + this.toString(this._dataName_);
    }
    
    @Override
    void removeChild(final Node o) {
        if (this._indexed_ == o) {
            this._indexed_ = null;
            return;
        }
        if (this._by_ == o) {
            this._by_ = null;
            return;
        }
        if (this._dataName_.remove(o)) {
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._indexed_ == node) {
            this.setIndexed((TIndexed)node2);
            return;
        }
        if (this._by_ == node) {
            this.setBy((TBy)node2);
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
