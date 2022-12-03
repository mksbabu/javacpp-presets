// Targeted by JavaCPP version 1.5.9-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;


@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class _PyDateTime_BaseTime extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public _PyDateTime_BaseTime() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public _PyDateTime_BaseTime(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public _PyDateTime_BaseTime(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public _PyDateTime_BaseTime position(long position) {
        return (_PyDateTime_BaseTime)super.position(position);
    }
    @Override public _PyDateTime_BaseTime getPointer(long i) {
        return new _PyDateTime_BaseTime((Pointer)this).offsetAddress(i);
    }

    public native @ByRef PyObject ob_base(); public native _PyDateTime_BaseTime ob_base(PyObject setter);
    public native @Cast("Py_hash_t") long hashcode(); public native _PyDateTime_BaseTime hashcode(long setter);
    public native @Cast("char") byte hastzinfo(); public native _PyDateTime_BaseTime hastzinfo(byte setter);             /* boolean flag */
    public native @Cast("unsigned char") byte data(int i); public native _PyDateTime_BaseTime data(int i, byte setter);
    @MemberGetter public native @Cast("unsigned char*") BytePointer data();
}
