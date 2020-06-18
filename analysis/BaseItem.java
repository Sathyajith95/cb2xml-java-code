// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.analysis;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import net.sf.cb2xml.def.IItemBase;

public abstract class BaseItem implements IItemBase
{
    private static List<Item> EMPTY_ITEM;
    private List<Item> childItems;
    private List<Object> allElements;
    
    protected BaseItem() {
        this.childItems = BaseItem.EMPTY_ITEM;
    }
    
    protected BaseItem(final int n) {
        this.childItems = BaseItem.EMPTY_ITEM;
        this.allElements = new ArrayList<Object>(n + 50);
    }
    
    @Override
    public List<? extends Item> getChildItems() {
        return this.childItems;
    }
    
    public void addItem(final Item item) {
        if (this.childItems == BaseItem.EMPTY_ITEM) {
            this.childItems = new ArrayList<Item>(5);
        }
        this.childItems.add(item);
        this.add(item);
    }
    
    public void addComment(final String s) {
        this.add(s);
    }
    
    protected void add(final Object o) {
        if (this.allElements == null) {
            this.allElements = new ArrayList<Object>();
        }
        this.allElements.add(o);
    }
    
    protected void addBefore(final Object o, final Object o2) {
        if (this.allElements == null) {
            this.add(o2);
        }
        final int index = this.allElements.indexOf(o);
        if (index >= 0) {
            this.allElements.add(index, o2);
        }
        else {
            this.allElements.add(o2);
        }
    }
    
    public final List<Object> getAllElements() {
        return this.allElements;
    }
    
    static {
        BaseItem.EMPTY_ITEM = Collections.unmodifiableList((List<? extends Item>)new ArrayList<Item>(0));
    }
}
