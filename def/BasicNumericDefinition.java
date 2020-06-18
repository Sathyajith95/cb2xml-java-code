// 
// Decompiled by Procyon v0.5.36
// 

package net.sf.cb2xml.def;

public class BasicNumericDefinition implements NumericDefinition
{
    public static final int[] DEFAULT_SYNC;
    public static final int[] MAINFRAME_SIZES;
    public static final int[] MAINFRAME_SYNC;
    private static final int[] MAINFRAME_DIGITS;
    public static final int[] FUJITSU_SIZES;
    public static final int[] FUJITSU_SYNC;
    public static final int[] GNU_COBOL_SIZES;
    public static final int[] GNU_COBOL_SYNC;
    public static final int[] BS2000_SIZES;
    public static final int[] BS2000_SYNC;
    public static final int[] GNU_COBOL_MVS_SIZES;
    public static final int[] GNU_COBOL_MVS_SYNC;
    public static final int[] MICROFOCUS_SIZES;
    public static final int[] MICROFOCUS_SIZES_SYNC;
    public static final int[] MAX_COMP_SIZE;
    public static final int[] MAX_POSITIVE_COMP_SIZE;
    private int[] compSizesUsed;
    private int[] digitsAvailable;
    private int[] positiveDigitsAvailable;
    private int[] syncSizes;
    private int floatSync;
    private int doubleSync;
    private String name;
    
    public BasicNumericDefinition(final String name, final int[] array, final int[] syncSizes, final boolean b, final int floatSync, final int doubleSync) {
        this.compSizesUsed = BasicNumericDefinition.MAINFRAME_SIZES;
        this.digitsAvailable = BasicNumericDefinition.MAINFRAME_DIGITS;
        this.positiveDigitsAvailable = this.digitsAvailable;
        this.syncSizes = BasicNumericDefinition.DEFAULT_SYNC;
        this.floatSync = 4;
        this.doubleSync = 8;
        final int[] positiveDigitsAvailable = new int[array.length];
        this.compSizesUsed = new int[array.length];
        this.name = name;
        this.syncSizes = BasicNumericDefinition.DEFAULT_SYNC;
        if (syncSizes != null) {
            this.syncSizes = syncSizes;
        }
        this.digitsAvailable = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            this.compSizesUsed[i] = array[i];
            final int n = Math.min(BasicNumericDefinition.MAX_COMP_SIZE.length, array[i]) - 1;
            this.digitsAvailable[i] = BasicNumericDefinition.MAX_COMP_SIZE[n];
            positiveDigitsAvailable[i] = BasicNumericDefinition.MAX_POSITIVE_COMP_SIZE[n];
        }
        this.positiveDigitsAvailable = this.digitsAvailable;
        if (b) {
            this.positiveDigitsAvailable = positiveDigitsAvailable;
        }
        this.floatSync = floatSync;
        this.doubleSync = doubleSync;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int getBinarySize(final String anotherString, final int n, final boolean b, final boolean b2) {
        int n2 = n;
        if ("computational-1".equalsIgnoreCase(anotherString)) {
            n2 = 4;
        }
        else if ("computational-2".equalsIgnoreCase(anotherString)) {
            n2 = 8;
        }
        else if ("computational-3".equalsIgnoreCase(anotherString) || "packed-decimal".equalsIgnoreCase(anotherString) || "computational-6".equalsIgnoreCase(anotherString)) {
            n2 = n / 2 + 1;
        }
        else if (this.isBinary(anotherString)) {
            n2 = this.compSizesUsed[this.compSizesUsed.length - 1];
            for (int i = 0; i < this.digitsAvailable.length - 1; ++i) {
                if (this.digitsAvailable[i] >= n || (b && this.positiveDigitsAvailable[i] >= n)) {
                    n2 = this.compSizesUsed[Math.max(0, i)];
                    break;
                }
            }
        }
        return n2;
    }
    
    @Override
    public int getSyncAt(final String s, final int n) {
        int n2 = 1;
        if (this.isBinary(s)) {
            switch (n) {
                case 1: {
                    n2 = this.syncSizes[0];
                    break;
                }
                case 2: {
                    n2 = this.syncSizes[1];
                    break;
                }
                case 3:
                case 4: {
                    n2 = this.syncSizes[2];
                    break;
                }
                default: {
                    n2 = this.syncSizes[3];
                    break;
                }
            }
        }
        else if ("computational-1".equals(s)) {
            n2 = this.floatSync;
        }
        else if ("computational-2".equals(s)) {
            n2 = this.doubleSync;
        }
        return n2;
    }
    
    @Override
    public int chkStorageLength(final int n, final String s) {
        int n2 = n;
        if (n == 0) {
            if ("computational-1".equalsIgnoreCase(s)) {
                n2 = 10;
            }
            else if ("computational-2".equalsIgnoreCase(s)) {
                n2 = 18;
            }
        }
        return n2;
    }
    
    private boolean isBinary(final String anotherString) {
        return "binary".equalsIgnoreCase(anotherString) || "computational".equalsIgnoreCase(anotherString) || "computational-4".equalsIgnoreCase(anotherString) || "computational-5".equalsIgnoreCase(anotherString) || "computational-6".equalsIgnoreCase(anotherString);
    }
    
    static {
        DEFAULT_SYNC = new int[] { 1, 1, 4, 8 };
        MAINFRAME_SIZES = new int[] { 2, 4, 8 };
        MAINFRAME_SYNC = new int[] { 2, 2, 4, 4 };
        MAINFRAME_DIGITS = new int[] { 4, 9, 18 };
        FUJITSU_SIZES = BasicNumericDefinition.MAINFRAME_SIZES;
        FUJITSU_SYNC = new int[] { 2, 2, 4, 4 };
        GNU_COBOL_SIZES = new int[] { 1, 2, 4, 8 };
        GNU_COBOL_SYNC = new int[] { 2, 2, 4, 4 };
        BS2000_SIZES = BasicNumericDefinition.MAINFRAME_SIZES;
        BS2000_SYNC = new int[] { 2, 2, 4, 8 };
        GNU_COBOL_MVS_SIZES = BasicNumericDefinition.MAINFRAME_SIZES;
        GNU_COBOL_MVS_SYNC = BasicNumericDefinition.BS2000_SYNC;
        MICROFOCUS_SIZES = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        MICROFOCUS_SIZES_SYNC = new int[] { 1, 1, 1, 1 };
        MAX_COMP_SIZE = new int[] { 2, 4, 6, 9, 11, 14, 16, 18 };
        MAX_POSITIVE_COMP_SIZE = new int[] { 2, 4, 7, 9, 12, 14, 16, 19 };
    }
}
