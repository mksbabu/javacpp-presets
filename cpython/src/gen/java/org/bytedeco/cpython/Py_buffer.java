// Targeted by JavaCPP version 1.5.9-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;

// #endif

// #if !defined(Py_LIMITED_API) || Py_LIMITED_API+0 >= 0x030b0000

/* === New Buffer API ============================================
 * Limited API and stable ABI since Python 3.11
 *
 * Py_buffer struct layout and size is now part of the stable abi3. The
 * struct layout and size must not be changed in any way, as it would
 * break the ABI.
 *
 */

@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class Py_buffer extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public Py_buffer() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Py_buffer(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Py_buffer(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public Py_buffer position(long position) {
        return (Py_buffer)super.position(position);
    }
    @Override public Py_buffer getPointer(long i) {
        return new Py_buffer((Pointer)this).offsetAddress(i);
    }

    public native Pointer buf(); public native Py_buffer buf(Pointer setter);
    public native PyObject obj(); public native Py_buffer obj(PyObject setter);        /* owned reference */
    public native @Cast("Py_ssize_t") long len(); public native Py_buffer len(long setter);
    public native @Cast("Py_ssize_t") long itemsize(); public native Py_buffer itemsize(long setter);  /* This is Py_ssize_t so it can be
                             pointed to by strides in simple case.*/
    public native int readonly(); public native Py_buffer readonly(int setter);
    public native int ndim(); public native Py_buffer ndim(int setter);
    public native @Cast("char*") BytePointer format(); public native Py_buffer format(BytePointer setter);
    public native @Cast("Py_ssize_t*") SizeTPointer shape(); public native Py_buffer shape(SizeTPointer setter);
    public native @Cast("Py_ssize_t*") SizeTPointer strides(); public native Py_buffer strides(SizeTPointer setter);
    public native @Cast("Py_ssize_t*") SizeTPointer suboffsets(); public native Py_buffer suboffsets(SizeTPointer setter);
    public native Pointer internal(); public native Py_buffer internal(Pointer setter);
}
