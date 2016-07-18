package ling;

/**
 * Created by USER on 13.04.2016.
 */
 class Utils {
    static Number addNumbers(Number a, Number b) {
        if(a instanceof Double || b instanceof Double) {
            return  a==null?0:a.doubleValue()+b.doubleValue();
        } else if(a instanceof Float || b instanceof Float) {
            return a==null?0:a.floatValue()+ b.floatValue();
        } else if(a instanceof Long || b instanceof Long) {
            return  a==null?0:a.longValue()+b.longValue();
        } else if(a instanceof Integer || b instanceof Integer) {
            return  a==null?0:a.intValue()+ b.intValue();
        }else{
            throw new RuntimeException("addNumbers");
        }
    }

    static Number maxNumbers(Number a, Number b) {
        if(a instanceof Byte || b instanceof Byte) {
            return java.lang.Math.max(a==null?Byte.MIN_VALUE:a.byteValue(), b.byteValue());
        }else if(a instanceof Double || b instanceof Double) {
            return java.lang.Math.max(a==null?Double.MIN_VALUE:a.doubleValue(), b.doubleValue());
        } else if(a instanceof Float || b instanceof Float) {
            return java.lang.Math.max(a==null?Float.MIN_VALUE:a.floatValue() , b.floatValue());
        } else if(a instanceof Long || b instanceof Long) {
            return java.lang.Math.max(a==null?Long.MIN_VALUE:a.longValue() , b.longValue());
        } else if(a instanceof Integer || b instanceof Integer) {
            return java.lang.Math.max(a==null?Integer.MIN_VALUE:a.intValue(),b.intValue());
        }else{
            throw new RuntimeException("addNumbers");
        }

    }

    static Number minNumbers(Number a, Number b) {
        if(a instanceof Byte || b instanceof Byte) {

            return java.lang.Math.min(a==null?Byte.MAX_VALUE:a.byteValue(), b.byteValue());
        }else if(a instanceof Double || b instanceof Double) {
            return java.lang.Math.min(a==null?Double.MAX_VALUE:a.doubleValue(), b.doubleValue());
        } else if(a instanceof Float || b instanceof Float) {
            return java.lang.Math.min(a==null?Float.MAX_VALUE:a.floatValue() , b.floatValue());
        } else if(a instanceof Long || b instanceof Long) {
            return java.lang.Math.min(a==null?Long.MAX_VALUE:a.longValue() , b.longValue());
        } else if(a instanceof Integer || b instanceof Integer) {
            return java.lang.Math.min(a==null?Integer.MAX_VALUE:a.intValue(),b.intValue());
        }else{
            throw new RuntimeException("addNumbers");
        }

    }
}
