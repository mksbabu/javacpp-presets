// Targeted by JavaCPP version 1.5.8-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.opencl.global.OpenCL.*;


@Properties(inherit = org.bytedeco.opencl.presets.OpenCL.class)
public class cl_long16 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public cl_long16() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public cl_long16(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public cl_long16(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public cl_long16 position(long position) {
        return (cl_long16)super.position(position);
    }
    @Override public cl_long16 getPointer(long i) {
        return new cl_long16((Pointer)this).offsetAddress(i);
    }

    public native @Cast("cl_long") long s(int i); public native cl_long16 s(int i, long setter);
    @MemberGetter public native @Cast("cl_long*") LongPointer s();
// #if __CL_HAS_ANON_STRUCT__
// #endif
// #if defined( __CL_LONG2__)
// #endif
// #if defined( __CL_LONG4__)
// #endif
// #if defined( __CL_LONG8__ )
// #endif
// #if defined( __CL_LONG16__ )
// #endif
}
