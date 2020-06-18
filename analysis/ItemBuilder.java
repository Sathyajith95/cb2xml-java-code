// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.analysis;

import net.sf.cb2xml.def.IItem;
import net.sf.cb2xml.def.Cb2xmlConstants;

public class ItemBuilder
{
    private Item item;
    private String fieldName;
    private String levelString;
    
    public ItemBuilder() {
        this.item = new Item(null, 1, "01", "");
    }
    
    public static ItemBuilder newBuilder() {
        return new ItemBuilder();
    }
    
    public void setJustified(final Cb2xmlConstants.Justified justified) {
        this.item.justified = justified;
    }
    
    public void setDependingOn(final String dependingOn) {
        this.item.dependingOn = dependingOn;
    }
    
    public void setDisplayLength(final int displayLength) {
        this.item.displayLength = displayLength;
    }
    
    public void setLevelString(final String levelString) {
        this.levelString = levelString;
    }
    
    public void setInheritedUsage(final boolean inheritedUsage) {
        this.item.inheritedUsage = inheritedUsage;
    }
    
    public void setInsertDecimal(final boolean insertDecimal) {
        this.item.insertDecimal = insertDecimal;
    }
    
    public void setBlankWhenZero(final boolean blankWhenZero) {
        this.item.blankWhenZero = blankWhenZero;
    }
    
    public void setSigned(final boolean signed) {
        this.item.signed = signed;
    }
    
    public void setFieldRedefined(final boolean fieldRedefined) {
        this.item.fieldRedefined = fieldRedefined;
    }
    
    public void setSync(final boolean sync) {
        this.item.sync = sync;
    }
    
    public void setOccurs(final int occurs) {
        this.item.occurs = occurs;
    }
    
    public void setOccursMin(final int occursMin) {
        this.item.occursMin = occursMin;
    }
    
    public void setPicture(final String picture) {
        this.item.picture = picture;
    }
    
    public void setPosition(final int position) {
        this.item.position = position;
    }
    
    public void setRedefines(final String redefines) {
        this.item.redefines = redefines;
    }
    
    public void setScale(final int scale) {
        this.item.scale = scale;
    }
    
    public void setStorageLength(final int storageLength) {
        this.item.storageLength = storageLength;
    }
    
    public void setNumericClass(final Cb2xmlConstants.NumericClass numericClass) {
        this.item.numericClass = numericClass;
    }
    
    public void setSignClause(final Cb2xmlConstants.SignClause signClause) {
        this.item.signClause = signClause;
    }
    
    public void setUsage(final Cb2xmlConstants.Usage usage) {
        this.item.usage = usage;
    }
    
    public void setValue(final String value) {
        this.item.value = value;
    }
    
    public void setFieldName(final String fieldName) {
        this.fieldName = fieldName;
    }
    
    protected Item getItem() {
        return this.item;
    }
    
    public Item build(final BaseItem baseItem) {
        final Item item = new Item(baseItem, Integer.parseInt(this.levelString), this.levelString, this.fieldName);
        item.set(this.item);
        return item;
    }
}
