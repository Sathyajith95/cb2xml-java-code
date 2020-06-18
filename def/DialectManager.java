// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.def;

public class DialectManager
{
    private static final NumericDefinition MAINFRAME_NUMERIC_DEFINITION;
    private static final NumericDefinition GNU_COBOL_NUMERIC_DEFINITION;
    private static final NumericDefinition FUJITSU_COBOL_NUMERIC_DEFINITION;
    public static final IBasicDialect MAINFRAME_COBOL;
    public static final IBasicDialect GNU_COBOL;
    public static final IBasicDialect FUJITSU_COBOL;
    
    static {
        MAINFRAME_NUMERIC_DEFINITION = new BasicNumericDefinition("Mainframe", BasicNumericDefinition.MAINFRAME_SIZES, BasicNumericDefinition.MAINFRAME_SYNC, false, 4, 4);
        GNU_COBOL_NUMERIC_DEFINITION = new BasicNumericDefinition("GNU_Cobol", BasicNumericDefinition.GNU_COBOL_SIZES, BasicNumericDefinition.GNU_COBOL_SYNC, false, 4, 8);
        FUJITSU_COBOL_NUMERIC_DEFINITION = new BasicNumericDefinition("Fujitsu", BasicNumericDefinition.MAINFRAME_SIZES, BasicNumericDefinition.MAINFRAME_SYNC, false, 4, 8);
        MAINFRAME_COBOL = new DialectImp(DialectManager.MAINFRAME_NUMERIC_DEFINITION);
        GNU_COBOL = new DialectImp(DialectManager.GNU_COBOL_NUMERIC_DEFINITION);
        FUJITSU_COBOL = new DialectImp(DialectManager.FUJITSU_COBOL_NUMERIC_DEFINITION);
    }
    
    private static class DialectImp implements IBasicDialect
    {
        private final NumericDefinition numericDefinition;
        
        public DialectImp(final NumericDefinition numericDefinition) {
            this.numericDefinition = numericDefinition;
        }
        
        @Override
        public NumericDefinition getNumericDefinition() {
            return this.numericDefinition;
        }
        
        @Override
        public String toString() {
            return this.numericDefinition.getName() + "_" + super.toString();
        }
    }
}
