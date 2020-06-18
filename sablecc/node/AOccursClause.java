// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import java.util.ListIterator;
import java.util.Iterator;
import net.sf.cb2xml.sablecc.analysis.Analysis;
import java.util.List;
import java.util.LinkedList;

public final class AOccursClause extends POccursClause
{
    private POccursFixedOrVariable _occursFixedOrVariable_;
    private final LinkedList<PAscendingOrDescendingKeyPhrase> _ascendingOrDescendingKeyPhrase_;
    private final LinkedList<PIndexedByPhrase> _indexedByPhrase_;
    
    public AOccursClause() {
        this._ascendingOrDescendingKeyPhrase_ = new LinkedList<PAscendingOrDescendingKeyPhrase>();
        this._indexedByPhrase_ = new LinkedList<PIndexedByPhrase>();
    }
    
    public AOccursClause(final POccursFixedOrVariable occursFixedOrVariable, final List<?> ascendingOrDescendingKeyPhrase, final List<?> indexedByPhrase) {
        this._ascendingOrDescendingKeyPhrase_ = new LinkedList<PAscendingOrDescendingKeyPhrase>();
        this._indexedByPhrase_ = new LinkedList<PIndexedByPhrase>();
        this.setOccursFixedOrVariable(occursFixedOrVariable);
        this.setAscendingOrDescendingKeyPhrase(ascendingOrDescendingKeyPhrase);
        this.setIndexedByPhrase(indexedByPhrase);
    }
    
    @Override
    public Object clone() {
        return new AOccursClause(this.cloneNode(this._occursFixedOrVariable_), this.cloneList(this._ascendingOrDescendingKeyPhrase_), this.cloneList(this._indexedByPhrase_));
    }
    
    @Override
    public void apply(final Switch switch1) {
        ((Analysis)switch1).caseAOccursClause(this);
    }
    
    public POccursFixedOrVariable getOccursFixedOrVariable() {
        return this._occursFixedOrVariable_;
    }
    
    public void setOccursFixedOrVariable(final POccursFixedOrVariable occursFixedOrVariable_) {
        if (this._occursFixedOrVariable_ != null) {
            this._occursFixedOrVariable_.parent(null);
        }
        if (occursFixedOrVariable_ != null) {
            if (occursFixedOrVariable_.parent() != null) {
                occursFixedOrVariable_.parent().removeChild(occursFixedOrVariable_);
            }
            occursFixedOrVariable_.parent(this);
        }
        this._occursFixedOrVariable_ = occursFixedOrVariable_;
    }
    
    public LinkedList<PAscendingOrDescendingKeyPhrase> getAscendingOrDescendingKeyPhrase() {
        return this._ascendingOrDescendingKeyPhrase_;
    }
    
    public void setAscendingOrDescendingKeyPhrase(final List<?> list) {
        final Iterator<PAscendingOrDescendingKeyPhrase> iterator = this._ascendingOrDescendingKeyPhrase_.iterator();
        while (iterator.hasNext()) {
            iterator.next().parent(null);
        }
        this._ascendingOrDescendingKeyPhrase_.clear();
        for (final PAscendingOrDescendingKeyPhrase e : list) {
            if (e.parent() != null) {
                e.parent().removeChild(e);
            }
            e.parent(this);
            this._ascendingOrDescendingKeyPhrase_.add(e);
        }
    }
    
    public LinkedList<PIndexedByPhrase> getIndexedByPhrase() {
        return this._indexedByPhrase_;
    }
    
    public void setIndexedByPhrase(final List<?> list) {
        final Iterator<PIndexedByPhrase> iterator = this._indexedByPhrase_.iterator();
        while (iterator.hasNext()) {
            iterator.next().parent(null);
        }
        this._indexedByPhrase_.clear();
        for (final PIndexedByPhrase e : list) {
            if (e.parent() != null) {
                e.parent().removeChild(e);
            }
            e.parent(this);
            this._indexedByPhrase_.add(e);
        }
    }
    
    @Override
    public String toString() {
        return "" + this.toString(this._occursFixedOrVariable_) + this.toString(this._ascendingOrDescendingKeyPhrase_) + this.toString(this._indexedByPhrase_);
    }
    
    @Override
    void removeChild(final Node node) {
        if (this._occursFixedOrVariable_ == node) {
            this._occursFixedOrVariable_ = null;
            return;
        }
        if (this._ascendingOrDescendingKeyPhrase_.remove(node)) {
            return;
        }
        if (this._indexedByPhrase_.remove(node)) {
            return;
        }
        throw new RuntimeException("Not a child.");
    }
    
    @Override
    void replaceChild(final Node node, final Node node2) {
        if (this._occursFixedOrVariable_ == node) {
            this.setOccursFixedOrVariable((POccursFixedOrVariable)node2);
            return;
        }
        final ListIterator<PAscendingOrDescendingKeyPhrase> listIterator = (ListIterator<PAscendingOrDescendingKeyPhrase>)this._ascendingOrDescendingKeyPhrase_.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next() == node) {
                if (node2 != null) {
                    listIterator.set((PAscendingOrDescendingKeyPhrase)node2);
                    node2.parent(this);
                    node.parent(null);
                    return;
                }
                listIterator.remove();
                node.parent(null);
                return;
            }
        }
        final ListIterator<PIndexedByPhrase> listIterator2 = (ListIterator<PIndexedByPhrase>)this._indexedByPhrase_.listIterator();
        while (listIterator2.hasNext()) {
            if (listIterator2.next() == node) {
                if (node2 != null) {
                    listIterator2.set((PIndexedByPhrase)node2);
                    node2.parent(this);
                    node.parent(null);
                    return;
                }
                listIterator2.remove();
                node.parent(null);
                return;
            }
        }
        throw new RuntimeException("Not a child.");
    }
}
