// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.util;

import net.sf.cb2xml.def.Cb2xmlConstants;
import java.util.ArrayList;
import net.sf.cb2xml.analysis.Condition;
import javax.xml.stream.XMLStreamException;
import net.sf.cb2xml.analysis.BaseItem;
import net.sf.cb2xml.analysis.Item;
import java.util.List;
import net.sf.cb2xml.analysis.ItemBuilder;
import javax.xml.stream.XMLStreamReader;

public class CobolItemReader
{
    public List<? extends Item> parseCobolItems(final XMLStreamReader xmlStreamReader, final ItemBuilder itemBuilder) throws XMLStreamException {
        return this.parseCobolItems(xmlStreamReader, itemBuilder, itemBuilder.build(null));
    }
    
    private List<? extends Item> parseCobolItems(final XMLStreamReader xmlStreamReader, final ItemBuilder itemBuilder, final BaseItem baseItem) throws XMLStreamException {
        int i = xmlStreamReader.getEventType();
        final ReaderBuilder readerBuilder = new ReaderBuilder(xmlStreamReader, itemBuilder, baseItem);
        while (i != 8) {
            Label_0382: {
                switch (i) {
                    case 1: {
                        final String lowerCase = xmlStreamReader.getName().toString().toLowerCase();
                        switch (lowerCase) {
                            case "condition": {
                                this.processCondition(readerBuilder);
                                break;
                            }
                            case "item": {
                                this.processItem(readerBuilder);
                                break;
                            }
                            default: {
                                if (readerBuilder.list.size() < 2) {
                                    return readerBuilder.topItem.getChildItems();
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        final String lowerCase2 = xmlStreamReader.getName().toString().toLowerCase();
                        switch (lowerCase2) {
                            case "copybook":
                            case "items": {
                                return readerBuilder.topItem.getChildItems();
                            }
                            case "condition":
                            case "item": {
                                readerBuilder.pop();
                                break Label_0382;
                            }
                        }
                        break;
                    }
                }
            }
            i = xmlStreamReader.next();
        }
        return readerBuilder.topItem.getChildItems();
    }
    
    private void processCondition(final ReaderBuilder readerBuilder) {
        readerBuilder.add(new Condition(readerBuilder.getAttr("name"), readerBuilder.getAttr("through"), readerBuilder.getAttr("value")));
    }
    
    private void processItem(final ReaderBuilder readerBuilder) {
        final ItemBuilder itmBldr = readerBuilder.itmBldr;
        itmBldr.setLevelString(readerBuilder.getAttr("level"));
        itmBldr.setFieldName(readerBuilder.getAttr("name"));
        itmBldr.setBlankWhenZero(readerBuilder.getBooleanAttr("blank-when-zero"));
        itmBldr.setDependingOn(readerBuilder.getAttr("depending-on"));
        itmBldr.setDisplayLength(readerBuilder.getIntAttr("display-length"));
        itmBldr.setFieldRedefined(readerBuilder.getBooleanAttr("redefined"));
        itmBldr.setInheritedUsage(readerBuilder.getBooleanAttr("inherited-usage"));
        itmBldr.setJustified(readerBuilder.getJustified());
        itmBldr.setNumericClass(readerBuilder.getNumericClass());
        itmBldr.setOccursMin(readerBuilder.getIntAttr("occurs-min"));
        itmBldr.setPicture(readerBuilder.getAttr("picture"));
        itmBldr.setPosition(readerBuilder.getIntAttr("position"));
        itmBldr.setRedefines(readerBuilder.getAttr("redefines"));
        itmBldr.setScale(readerBuilder.getIntAttr("scale"));
        itmBldr.setSignClause(readerBuilder.getSignClause());
        itmBldr.setSigned(readerBuilder.getBooleanAttr("signed"));
        itmBldr.setSync(readerBuilder.getBooleanAttr("sync"));
        itmBldr.setUsage(readerBuilder.getUsage());
        itmBldr.setValue(readerBuilder.getAttr("value"));
        readerBuilder.add(itmBldr.build(readerBuilder.baseItem));
    }
    
    private static class ReaderBuilder
    {
        final XMLStreamReader reader;
        final ItemBuilder itmBldr;
        public final BaseItem topItem;
        public BaseItem baseItem;
        public final ArrayList<ItemCondition> list;
        
        public ReaderBuilder(final XMLStreamReader reader, final ItemBuilder itmBldr, final BaseItem baseItem) {
            this.list = new ArrayList<ItemCondition>();
            this.reader = reader;
            this.itmBldr = itmBldr;
            this.topItem = baseItem;
            this.baseItem = baseItem;
            if (baseItem instanceof Item) {
                this.add((Item)baseItem);
            }
        }
        
        public String getAttr(final String s) {
            return this.reader.getAttributeValue(null, s);
        }
        
        public int getIntAttr(final String s) {
            final String attr = this.getAttr(s);
            if (attr != null && attr.length() > 0) {
                return Integer.parseInt(attr);
            }
            return Integer.MIN_VALUE;
        }
        
        public boolean getBooleanAttr(final String s) {
            return "true".equals(this.getAttr(s));
        }
        
        public Cb2xmlConstants.Justified getJustified() {
            return Cb2xmlConstants.toJustified(this.getAttr("justified"));
        }
        
        public Cb2xmlConstants.Usage getUsage() {
            return Cb2xmlConstants.toUsage(this.getAttr("usage"));
        }
        
        public Cb2xmlConstants.SignClause getSignClause() {
            return Cb2xmlConstants.toSignClause(this.getAttr("sign-clause"));
        }
        
        public Cb2xmlConstants.NumericClass getNumericClass() {
            return Cb2xmlConstants.toNumeric(this.getAttr("numeric"));
        }
        
        public void add(final Item baseItem) {
            this.list.add(new ItemCondition(baseItem));
            this.baseItem = baseItem;
        }
        
        public void add(final Condition condition) {
            if (this.list.size() > 0) {
                final ItemCondition itemCondition = this.list.get(this.list.size() - 1);
                if (itemCondition.itm != null) {
                    itemCondition.itm.addCondition(condition);
                }
                else {
                    itemCondition.condition.addCondition(condition);
                }
            }
            this.list.add(new ItemCondition(condition));
        }
        
        public void pop() {
            if (this.list.remove(this.list.size() - 1).itm != null) {
                this.baseItem = this.topItem;
                for (int i = this.list.size() - 1; i >= 0; ++i) {
                    if (this.list.get(i).itm != null) {
                        this.baseItem = this.list.get(i).itm;
                        return;
                    }
                }
            }
        }
    }
    
    private static class ItemCondition
    {
        final Item itm;
        final Condition condition;
        
        public ItemCondition(final Item itm) {
            this.itm = itm;
            this.condition = null;
        }
        
        public ItemCondition(final Condition condition) {
            this.itm = null;
            this.condition = condition;
        }
    }
}
