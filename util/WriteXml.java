// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.util;

import net.sf.cb2xml.def.Cb2xmlConstants;
import net.sf.cb2xml.def.ICondition;
import net.sf.cb2xml.analysis.Item;
import java.util.Iterator;
import net.sf.cb2xml.def.IItem;
import java.util.List;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLOutputFactory;
import net.sf.cb2xml.analysis.Copybook;
import java.io.Writer;

public class WriteXml
{
    private final boolean newFormat;
    private final boolean writeEmptyElements;
    private final String encoding;
    
    public WriteXml(final boolean newFormat, final boolean writeEmptyElements, final String encoding) {
        this.newFormat = newFormat;
        this.writeEmptyElements = writeEmptyElements;
        this.encoding = encoding;
    }
    
    public final void writeCopybook(final Writer writer, final Copybook copybook, final boolean b) throws XMLStreamException, IOException {
        this.writeCopybook(XMLOutputFactory.newInstance().createXMLStreamWriter(writer), copybook, b);
        writer.close();
    }
    
    public final void writeCopybook(final Result result, final Copybook copybook) throws XMLStreamException, IOException {
        this.writeCopybook(XMLOutputFactory.newInstance().createXMLStreamWriter(result), copybook, false);
    }
    
    public final void writeCopybook(XMLStreamWriter xmlStreamWriter, final Copybook copybook, final boolean b) throws XMLStreamException {
        if (b) {
            xmlStreamWriter = new IndentXmlWriter(xmlStreamWriter);
        }
        if (this.encoding == null || this.encoding.length() == 0) {
            xmlStreamWriter.writeStartDocument("1.0");
        }
        else {
            xmlStreamWriter.writeStartDocument(this.encoding, "1.0");
        }
        xmlStreamWriter.writeStartElement("copybook");
        this.writeAttr(xmlStreamWriter, "filename", copybook.getFilename());
        this.writeAttr(xmlStreamWriter, "dialect", copybook.getDialect());
        if (this.newFormat) {
            this.writeAttr(xmlStreamWriter, "cb2xml-format", "2017");
        }
        this.writeChildren(xmlStreamWriter, copybook.getAllElements());
        xmlStreamWriter.writeEndElement();
        xmlStreamWriter.writeEndDocument();
        xmlStreamWriter.close();
    }
    
    public final void writeIItems(final XMLStreamWriter xmlStreamWriter, final List<? extends IItem> list) throws XMLStreamException {
        final Iterator<? extends IItem> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.writeIItem(xmlStreamWriter, (IItem)iterator.next());
        }
    }
    
    private void writeChildren(final XMLStreamWriter xmlStreamWriter, final List<Object> list) throws XMLStreamException {
        if (list != null) {
            for (final Item next : list) {
                if (next instanceof Item) {
                    this.writeItem(xmlStreamWriter, next);
                }
                else if (next instanceof ICondition) {
                    this.writeCondition(xmlStreamWriter, (ICondition)next);
                }
                else if (((ICondition)next).getClass() == String.class) {
                    xmlStreamWriter.writeComment(next.toString());
                }
                else {
                    if (!(next instanceof IItem)) {
                        continue;
                    }
                    this.writeIItem(xmlStreamWriter, next);
                }
            }
        }
    }
    
    private void writeCondition(final XMLStreamWriter xmlStreamWriter, final ICondition condition) throws XMLStreamException {
        final List<? extends ICondition> childConditions = condition.getChildConditions();
        if (this.writeEmptyElements && (childConditions == null || childConditions.size() == 0)) {
            xmlStreamWriter.writeEmptyElement("condition");
            this.writeAttr(xmlStreamWriter, "name", condition.getName());
            this.writeAttr(xmlStreamWriter, "value", condition.getValue());
            this.writeAttr(xmlStreamWriter, "through", condition.getThrough());
        }
        else {
            xmlStreamWriter.writeStartElement("condition");
            this.writeAttr(xmlStreamWriter, "name", condition.getName());
            this.writeAttr(xmlStreamWriter, "value", condition.getValue());
            this.writeAttr(xmlStreamWriter, "through", condition.getThrough());
            this.writeChildConditions(xmlStreamWriter, childConditions);
            xmlStreamWriter.writeEndElement();
        }
    }
    
    private void writeChildConditions(final XMLStreamWriter xmlStreamWriter, final List<? extends ICondition> list) throws XMLStreamException {
        final Iterator<? extends ICondition> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.writeCondition(xmlStreamWriter, (ICondition)iterator.next());
        }
    }
    
    private void writeItem(final XMLStreamWriter xmlStreamWriter, final Item item) throws XMLStreamException {
        final List<Object> allElements = item.getAllElements();
        if (this.writeEmptyElements && (allElements == null || allElements.size() == 0)) {
            xmlStreamWriter.writeEmptyElement("item");
            this.writeItemAttributes(xmlStreamWriter, item);
        }
        else {
            xmlStreamWriter.writeStartElement("item");
            this.writeItemAttributes(xmlStreamWriter, item);
            this.writeChildren(xmlStreamWriter, allElements);
            xmlStreamWriter.writeEndElement();
        }
    }
    
    private void writeItemAttributes(final XMLStreamWriter xmlStreamWriter, final Item item) throws XMLStreamException {
        this.writeIItemAttributes(xmlStreamWriter, item);
        if (item.isSigned() && !this.newFormat) {
            this.writeAttr(xmlStreamWriter, "signed", true);
        }
    }
    
    private void writeIItem(final XMLStreamWriter xmlStreamWriter, final IItem item) throws XMLStreamException {
        final List<? extends ICondition> conditions = item.getConditions();
        final List<? extends IItem> childItems = item.getChildItems();
        if (this.writeEmptyElements && conditions.size() == 0 && childItems.size() == 0) {
            xmlStreamWriter.writeEmptyElement("item");
            this.writeIItemAttributes(xmlStreamWriter, item);
        }
        else {
            xmlStreamWriter.writeStartElement("item");
            this.writeIItemAttributes(xmlStreamWriter, item);
            this.writeChildConditions(xmlStreamWriter, conditions);
            this.writeIItems(xmlStreamWriter, childItems);
            xmlStreamWriter.writeEndElement();
        }
    }
    
    private void writeIItemAttributes(final XMLStreamWriter xmlStreamWriter, final IItem item) throws XMLStreamException {
        this.writeAttr(xmlStreamWriter, "level", item.getLevelString());
        this.writeAttribute(xmlStreamWriter, "name", item.getFieldName());
        this.writeAttr(xmlStreamWriter, "occurs", item.getOccurs(), -1);
        this.writeAttr(xmlStreamWriter, "occurs-min", item.getOccursMin(), -1);
        this.writeAttr(xmlStreamWriter, "depending-on", item.getDependingOn());
        this.writeAttr(xmlStreamWriter, "picture", item.getPicture());
        this.writeAttr(xmlStreamWriter, "usage", item.getUsage());
        this.writeAttr(xmlStreamWriter, "justified", item.getJustified());
        this.writeAttr(xmlStreamWriter, "position", item.getPosition());
        this.writeAttr(xmlStreamWriter, "storage-length", item.getStorageLength(), -1);
        this.writeAttr(xmlStreamWriter, "display-length", item.getDisplayLength(), -1);
        if (item.getScale() != 0) {
            this.writeAttr(xmlStreamWriter, "scale", item.getScale(), Integer.MIN_VALUE);
        }
        if (this.newFormat) {
            this.writeAttr(xmlStreamWriter, "numeric", item.getNumericClass());
            this.writeAttr(xmlStreamWriter, "sign-clause", item.getSignClause());
            this.writeAttr(xmlStreamWriter, "display-position", item.getDisplayPosition());
        }
        else {
            this.writeAttr(xmlStreamWriter, "numeric", item.getNumericClass().numeric);
            this.writeAttr(xmlStreamWriter, "editted-numeric", item.getNumericClass().editNumeric);
            this.writeAttr(xmlStreamWriter, "sign-position", item.getSignClause().signPosition);
            this.writeAttr(xmlStreamWriter, "sign-separate", item.getSignClause().signSeparate);
        }
        this.writeAttr(xmlStreamWriter, "sync", item.isSync());
        this.writeAttr(xmlStreamWriter, "value", item.getValue());
        this.writeAttr(xmlStreamWriter, "redefined", item.isFieldRedefined());
        this.writeAttr(xmlStreamWriter, "redefines", item.getRedefinesFieldName());
        this.writeAttr(xmlStreamWriter, "inherited-usage", item.isInheritedUsage());
        this.writeAttr(xmlStreamWriter, "blank-when-zero", item.isBlankWhenZero());
    }
    
    private void writeAttr(final XMLStreamWriter xmlStreamWriter, final String s, final boolean b) throws XMLStreamException {
        if (b) {
            xmlStreamWriter.writeAttribute(s, "true");
        }
    }
    
    private void writeAttr(final XMLStreamWriter xmlStreamWriter, final String s, final Cb2xmlConstants.IGetName getName) throws XMLStreamException {
        if (getName != null && getName.getName() != null) {
            xmlStreamWriter.writeAttribute(s, getName.getName());
        }
    }
    
    private void writeAttribute(final XMLStreamWriter xmlStreamWriter, final String s, final String s2) throws XMLStreamException {
        if (s2 != null) {
            xmlStreamWriter.writeAttribute(s, s2);
        }
    }
    
    private void writeAttr(final XMLStreamWriter xmlStreamWriter, final String s, final String s2) throws XMLStreamException {
        if (s2 != null && s2.length() > 0) {
            xmlStreamWriter.writeAttribute(s, s2);
        }
    }
    
    private void writeAttr(final XMLStreamWriter xmlStreamWriter, final String s, final int n) throws XMLStreamException {
        this.writeAttr(xmlStreamWriter, s, n, 0);
    }
    
    private void writeAttr(final XMLStreamWriter xmlStreamWriter, final String s, final int i, final int n) throws XMLStreamException {
        if (i > n) {
            xmlStreamWriter.writeAttribute(s, Integer.toString(i));
        }
    }
}
