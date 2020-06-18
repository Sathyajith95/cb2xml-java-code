// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.def;

import java.util.List;

public interface IItem extends IItemBase
{
    public static final int NULL_INT_VALUE = Integer.MIN_VALUE;
    
    List<? extends ICondition> getConditions();
    
    String getLevelString();
    
    int getLevelNumber();
    
    String getFieldName();
    
    String getPicture();
    
    Cb2xmlConstants.NumericClass getNumericClass();
    
    String getDependingOn();
    
    int getDisplayLength();
    
    int getDisplayPosition();
    
    Cb2xmlConstants.Usage getUsage();
    
    int getOccurs();
    
    int getOccursMin();
    
    Cb2xmlConstants.Justified getJustified();
    
    int getPosition();
    
    String getRedefinesFieldName();
    
    int getScale();
    
    Cb2xmlConstants.SignClause getSignClause();
    
    int getStorageLength();
    
    boolean isSync();
    
    String getValue();
    
    boolean isFieldRedefined();
    
    boolean isFieldRedefines();
    
    boolean isInheritedUsage();
    
    boolean isBlankWhenZero();
}
