// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.def;

import java.util.List;

public interface IItemJr extends IItem
{
    int getType();
    
    List<? extends IItemJr> getChildItems();
}
