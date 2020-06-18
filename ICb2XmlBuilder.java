// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml;

import javax.xml.transform.Result;
import java.io.Writer;
import java.io.OutputStream;
import net.sf.cb2xml.sablecc.parser.ParserException;
import java.io.IOException;
import net.sf.cb2xml.sablecc.lexer.LexerException;
import javax.xml.stream.XMLStreamException;
import net.sf.cb2xml.def.ICopybook;
import net.sf.cb2xml.def.IBasicDialect;
import net.sf.cb2xml.def.Cb2xmlConstants;

public interface ICb2XmlBuilder
{
    ICb2XmlBuilder setDebug(final boolean p0);
    
    ICb2XmlBuilder setCobolLineFormat(final int p0);
    
    ICb2XmlBuilder setCobolColumns(final int p0, final int p1);
    
    ICb2XmlBuilder setIndent(final boolean p0);
    
    ICb2XmlBuilder setXmlEncoding(final String p0);
    
    ICb2XmlBuilder setStackSize(final long p0);
    
    ICb2XmlBuilder setXmlFormat(final Cb2xmlConstants.Cb2xmlXmlFormat p0);
    
    ICb2XmlBuilder setDialect(final IBasicDialect p0);
    
    ICb2XmlBuilder setLoadComments(final boolean p0);
    
    ICopybook asCobolItemTree();
    
    String asXmlString() throws XMLStreamException, LexerException, IOException, ParserException;
    
    void writeXml(final String p0) throws XMLStreamException, LexerException, IOException, ParserException;
    
    void writeXml(final OutputStream p0) throws XMLStreamException, LexerException, IOException, ParserException;
    
    void writeXml(final Writer p0) throws XMLStreamException, LexerException, IOException, ParserException;
    
    void writeXml(final Result p0) throws XMLStreamException, LexerException, IOException, ParserException;
}
