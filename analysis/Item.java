// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.analysis;

import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import net.sf.cb2xml.def.ICondition;
import net.sf.cb2xml.def.IItemBase;
import net.sf.cb2xml.def.IItemJr;
import net.sf.cb2xml.def.IItem;
import net.sf.cb2xml.def.Cb2xmlConstants;
import java.util.List;
import net.sf.cb2xml.def.IItemJrUpd;

public class Item extends BaseItem implements IItemJrUpd
{
    private static List<Condition> EMPTY_CONDITION;
    final BaseItem parentItem;
    int assumedDigits;
    int doubleByteChars;
    private List<Condition> conditions;
    final int levelNumber;
    Cb2xmlConstants.Justified justified;
    String dependingOn;
    int displayLength;
    private final String levelString;
    boolean inheritedUsage;
    boolean insertDecimal;
    boolean blankWhenZero;
    boolean signed;
    boolean fieldRedefined;
    boolean sync;
    int occurs;
    int occursMin;
    String picture;
    int position;
    int displayPosition;
    String redefines;
    int scale;
    int storageLength;
    Cb2xmlConstants.NumericClass numericClass;
    Cb2xmlConstants.SignClause signClause;
    Cb2xmlConstants.Usage usage;
    String value;
    private final String fieldName;
    int type;
    
    public Item(final BaseItem parentItem, final int levelNumber, final String levelString, final String fieldName) {
        this.assumedDigits = 0;
        this.doubleByteChars = 0;
        this.conditions = Item.EMPTY_CONDITION;
        this.justified = Cb2xmlConstants.Justified.NOT_JUSTIFIED;
        this.displayLength = Integer.MIN_VALUE;
        this.inheritedUsage = false;
        this.insertDecimal = false;
        this.blankWhenZero = false;
        this.sync = false;
        this.occurs = Integer.MIN_VALUE;
        this.occursMin = Integer.MIN_VALUE;
        this.numericClass = Cb2xmlConstants.NumericClass.NON_NUMERIC;
        this.signClause = Cb2xmlConstants.SignClause.NO_SIGN_CLAUSE;
        this.usage = Cb2xmlConstants.Usage.NONE;
        this.parentItem = parentItem;
        this.levelNumber = levelNumber;
        this.levelString = levelString;
        this.fieldName = fieldName;
        if (parentItem != null) {
            parentItem.addItem(this);
        }
    }
    
    public void set(final IItem item) {
        this.picture = item.getPicture();
        this.numericClass = item.getNumericClass();
        this.dependingOn = item.getDependingOn();
        this.displayLength = item.getDisplayLength();
        this.usage = item.getUsage();
        this.occurs = item.getOccurs();
        this.occursMin = item.getOccursMin();
        this.justified = item.getJustified();
        this.position = item.getPosition();
        this.redefines = item.getRedefinesFieldName();
        this.scale = item.getScale();
        this.storageLength = item.getStorageLength();
        this.sync = item.isSync();
        this.value = item.getValue();
        this.fieldRedefined = item.isFieldRedefined();
        this.signClause = item.getSignClause();
        if (item instanceof IItemJr) {
            this.type = ((IItemJr)item).getType();
        }
    }
    
    @Override
    public IItemBase getParent() {
        return this.parentItem;
    }
    
    @Override
    public List<? extends ICondition> getConditions() {
        return this.conditions;
    }
    
    public void addCondition(final Condition condition) {
        if (this.conditions == Item.EMPTY_CONDITION) {
            this.conditions = new ArrayList<Condition>(3);
        }
        this.conditions.add(condition);
        super.add(condition);
    }
    
    @Override
    public int getLevelNumber() {
        return this.levelNumber;
    }
    
    @Override
    public String getFieldName() {
        return this.fieldName;
    }
    
    @Override
    public String getPicture() {
        return this.picture;
    }
    
    @Override
    public Cb2xmlConstants.Usage getUsage() {
        return this.usage;
    }
    
    @Override
    public int getOccurs() {
        return this.occurs;
    }
    
    @Override
    public int getOccursMin() {
        return this.occursMin;
    }
    
    @Override
    public Cb2xmlConstants.NumericClass getNumericClass() {
        return this.numericClass;
    }
    
    @Override
    public Cb2xmlConstants.Justified getJustified() {
        return this.justified;
    }
    
    @Override
    public String getDependingOn() {
        return this.dependingOn;
    }
    
    @Override
    public final int getDisplayPosition() {
        return this.displayPosition;
    }
    
    @Override
    public int getDisplayLength() {
        return this.displayLength;
    }
    
    @Override
    public String getLevelString() {
        return this.levelString;
    }
    
    @Override
    public int getPosition() {
        return this.position;
    }
    
    @Override
    public String getRedefinesFieldName() {
        return this.redefines;
    }
    
    @Override
    public int getScale() {
        return this.scale;
    }
    
    @Override
    public final Cb2xmlConstants.SignClause getSignClause() {
        return this.signClause;
    }
    
    @Override
    public int getStorageLength() {
        return this.storageLength;
    }
    
    @Override
    public boolean isSync() {
        return this.sync;
    }
    
    @Override
    public String getValue() {
        return this.value;
    }
    
    @Override
    public boolean isFieldRedefined() {
        return this.fieldRedefined;
    }
    
    @Override
    public boolean isFieldRedefines() {
        return this.redefines != null && this.redefines.length() > 0;
    }
    
    @Override
    public final boolean isInheritedUsage() {
        return this.inheritedUsage;
    }
    
    @Override
    public final boolean isBlankWhenZero() {
        return this.blankWhenZero;
    }
    
    public boolean isSigned() {
        return this.signed;
    }
    
    @Override
    public void updatePosition(final int n) {
        this.position += n;
        final Iterator<? extends Item> iterator = this.getChildItems().iterator();
        while (iterator.hasNext()) {
            ((Item)iterator.next()).updatePosition(n);
        }
    }
    
    @Override
    public int getType() {
        return this.type;
    }
    
    @Override
    public void setType(final int type) {
        this.type = type;
    }
    
    static {
        Item.EMPTY_CONDITION = Collections.unmodifiableList((List<? extends Condition>)new ArrayList<Condition>(0));
    }
}
