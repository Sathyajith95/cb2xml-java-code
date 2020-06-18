// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.analysis;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import net.sf.cb2xml.def.ICondition;

public class Condition implements ICondition
{
    private static List<Condition> EMPTY;
    private List<Condition> childConditions;
    private final String name;
    private final String through;
    private final String value;
    boolean all;
    
    public Condition(final String name, final String through, final String value) {
        this.childConditions = Condition.EMPTY;
        this.all = false;
        this.name = name;
        this.through = through;
        this.value = value;
    }
    
    public Condition(final ICondition condition) {
        this.childConditions = Condition.EMPTY;
        this.all = false;
        this.name = condition.getName();
        this.through = condition.getValue();
        this.value = condition.getThrough();
    }
    
    public void addCondition(final Condition condition) {
        if (this.childConditions == Condition.EMPTY) {
            this.childConditions = new ArrayList<Condition>(5);
        }
        this.childConditions.add(condition);
    }
    
    @Override
    public final List<Condition> getChildConditions() {
        return this.childConditions;
    }
    
    @Override
    public final String getName() {
        return this.name;
    }
    
    @Override
    public final String getThrough() {
        return this.through;
    }
    
    @Override
    public final String getValue() {
        return this.value;
    }
    
    static {
        Condition.EMPTY = Collections.unmodifiableList((List<? extends Condition>)new ArrayList<Condition>(0));
    }
}
