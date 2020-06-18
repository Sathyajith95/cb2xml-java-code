// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.sablecc.node;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public abstract class Node implements Switchable, Cloneable
{
    private Node parent;
    
    public abstract Object clone();
    
    public Node parent() {
        return this.parent;
    }
    
    void parent(final Node parent) {
        this.parent = parent;
    }
    
    abstract void removeChild(final Node p0);
    
    abstract void replaceChild(final Node p0, final Node p1);
    
    public void replaceBy(final Node node) {
        this.parent.replaceChild(this, node);
    }
    
    protected String toString(final Node node) {
        if (node != null) {
            return node.toString();
        }
        return "";
    }
    
    protected String toString(final List<?> list) {
        final StringBuffer sb = new StringBuffer();
        final Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
    
    protected <T extends Node> T cloneNode(final T t) {
        if (t != null) {
            return (T)t.clone();
        }
        return null;
    }
    
    protected <T extends Node> List<T> cloneList(final List<T> list) {
        final LinkedList<Node> list2 = (LinkedList<Node>)new LinkedList<T>();
        final Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add((T)iterator.next().clone());
        }
        return (List<T>)list2;
    }
}
