// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.util;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import java.util.Arrays;
import java.util.ArrayList;
import javax.xml.stream.XMLStreamWriter;

public class IndentXmlWriter implements XMLStreamWriter
{
    private static final int INDENT_LEVELS = 15;
    private final XMLStreamWriter xmlWriter;
    private int indent;
    private char[] fill;
    private int indentChars;
    private Boolean doIndent;
    private ArrayList<Boolean> doIndentStack;
    
    public IndentXmlWriter(final XMLStreamWriter xmlWriter) {
        this.indent = 0;
        this.indentChars = 4;
        this.doIndent = Boolean.FALSE;
        this.doIndentStack = new ArrayList<Boolean>();
        this.xmlWriter = xmlWriter;
        Arrays.fill(this.fill = new char[60], ' ');
        this.doIndentStack.add(Boolean.FALSE);
    }
    
    private void start() throws XMLStreamException {
        this.doIndentStack.add(Boolean.TRUE);
        this.doIndent = Boolean.FALSE;
        if (this.indent > 0) {
            this.writeIndent();
        }
        ++this.indent;
    }
    
    private void end() throws XMLStreamException {
        --this.indent;
        if (this.doIndent) {
            this.writeIndent();
        }
        this.doIndent = this.doIndentStack.remove(this.doIndentStack.size() - 1);
    }
    
    private void empty() throws XMLStreamException {
        this.doIndent = Boolean.TRUE;
        if (this.indent > 0) {
            this.writeIndent();
        }
    }
    
    private void writeIndent() throws XMLStreamException {
        int i = this.indent;
        this.xmlWriter.writeCharacters("\n");
        while (i > 15) {
            this.xmlWriter.writeCharacters(this.fill, 0, this.fill.length);
            i -= 15;
        }
        if (i > 0) {
            this.xmlWriter.writeCharacters(this.fill, 0, i * this.indentChars);
        }
    }
    
    @Override
    public void writeStartElement(final String s) throws XMLStreamException {
        this.start();
        this.xmlWriter.writeStartElement(s);
    }
    
    @Override
    public void writeStartElement(final String s, final String s2) throws XMLStreamException {
        this.start();
        this.xmlWriter.writeStartElement(s, s2);
    }
    
    @Override
    public void writeStartElement(final String s, final String s2, final String s3) throws XMLStreamException {
        this.start();
        this.xmlWriter.writeStartElement(s, s2, s3);
    }
    
    @Override
    public void writeEmptyElement(final String s, final String s2) throws XMLStreamException {
        this.empty();
        this.xmlWriter.writeEmptyElement(s, s2);
    }
    
    @Override
    public void writeEmptyElement(final String s, final String s2, final String s3) throws XMLStreamException {
        this.empty();
        this.xmlWriter.writeEmptyElement(s, s2, s3);
    }
    
    @Override
    public void writeEmptyElement(final String s) throws XMLStreamException {
        this.empty();
        this.xmlWriter.writeEmptyElement(s);
    }
    
    @Override
    public void writeEndElement() throws XMLStreamException {
        this.end();
        this.xmlWriter.writeEndElement();
    }
    
    @Override
    public void writeEndDocument() throws XMLStreamException {
        this.empty();
        this.xmlWriter.writeEndDocument();
    }
    
    @Override
    public void close() throws XMLStreamException {
        this.xmlWriter.close();
    }
    
    @Override
    public void flush() throws XMLStreamException {
        this.xmlWriter.flush();
    }
    
    @Override
    public void writeAttribute(final String s, final String s2) throws XMLStreamException {
        this.xmlWriter.writeAttribute(s, s2);
    }
    
    @Override
    public void writeAttribute(final String s, final String s2, final String s3, final String s4) throws XMLStreamException {
        this.xmlWriter.writeAttribute(s, s2, s3, s4);
    }
    
    @Override
    public void writeAttribute(final String s, final String s2, final String s3) throws XMLStreamException {
        this.xmlWriter.writeAttribute(s, s2, s3);
    }
    
    @Override
    public void writeNamespace(final String s, final String s2) throws XMLStreamException {
        this.xmlWriter.writeNamespace(s, s2);
    }
    
    @Override
    public void writeDefaultNamespace(final String s) throws XMLStreamException {
        this.xmlWriter.writeDefaultNamespace(s);
    }
    
    @Override
    public void writeComment(final String s) throws XMLStreamException {
        this.writeIndent();
        this.xmlWriter.writeComment(s);
    }
    
    @Override
    public void writeProcessingInstruction(final String s) throws XMLStreamException {
        this.xmlWriter.writeProcessingInstruction(s);
    }
    
    @Override
    public void writeProcessingInstruction(final String s, final String s2) throws XMLStreamException {
        this.xmlWriter.writeProcessingInstruction(s, s2);
    }
    
    @Override
    public void writeCData(final String s) throws XMLStreamException {
        this.doIndent = Boolean.FALSE;
        this.xmlWriter.writeCData(s);
    }
    
    @Override
    public void writeDTD(final String s) throws XMLStreamException {
        this.xmlWriter.writeDTD(s);
    }
    
    @Override
    public void writeEntityRef(final String s) throws XMLStreamException {
        this.xmlWriter.writeEntityRef(s);
    }
    
    @Override
    public void writeStartDocument() throws XMLStreamException {
        this.xmlWriter.writeStartDocument();
        this.xmlWriter.writeCharacters("\n");
    }
    
    @Override
    public void writeStartDocument(final String s) throws XMLStreamException {
        this.xmlWriter.writeStartDocument(s);
        this.xmlWriter.writeCharacters("\n");
    }
    
    @Override
    public void writeStartDocument(final String s, final String s2) throws XMLStreamException {
        this.xmlWriter.writeStartDocument(s, s2);
        this.xmlWriter.writeCharacters("\n");
    }
    
    @Override
    public void writeCharacters(final String s) throws XMLStreamException {
        this.doIndent = Boolean.FALSE;
        this.xmlWriter.writeCharacters(s);
    }
    
    @Override
    public void writeCharacters(final char[] array, final int n, final int n2) throws XMLStreamException {
        this.doIndent = Boolean.FALSE;
        this.xmlWriter.writeCharacters(array, n, n2);
    }
    
    @Override
    public String getPrefix(final String s) throws XMLStreamException {
        return this.xmlWriter.getPrefix(s);
    }
    
    @Override
    public void setPrefix(final String s, final String s2) throws XMLStreamException {
        this.xmlWriter.setPrefix(s, s2);
    }
    
    @Override
    public void setDefaultNamespace(final String defaultNamespace) throws XMLStreamException {
        this.xmlWriter.setDefaultNamespace(defaultNamespace);
    }
    
    @Override
    public void setNamespaceContext(final NamespaceContext namespaceContext) throws XMLStreamException {
        this.xmlWriter.setNamespaceContext(namespaceContext);
    }
    
    @Override
    public NamespaceContext getNamespaceContext() {
        return this.xmlWriter.getNamespaceContext();
    }
    
    @Override
    public Object getProperty(final String s) throws IllegalArgumentException {
        return this.xmlWriter.getProperty(s);
    }
}
