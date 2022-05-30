// Targeted by JavaCPP version 1.5.8-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.libffi;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.libffi.global.ffi.*;

// #endif
@Properties(inherit = org.bytedeco.libffi.presets.ffi.class)
public class ffi_raw_closure extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public ffi_raw_closure() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ffi_raw_closure(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ffi_raw_closure(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public ffi_raw_closure position(long position) {
        return (ffi_raw_closure)super.position(position);
    }
    @Override public ffi_raw_closure getPointer(long i) {
        return new ffi_raw_closure((Pointer)this).offsetAddress(i);
    }

// #if 0
// #else
  public native @Cast("char") byte tramp(int i); public native ffi_raw_closure tramp(int i, byte setter);
  @MemberGetter public native @Cast("char*") BytePointer tramp();
// #endif
  public native ffi_cif cif(); public native ffi_raw_closure cif(ffi_cif setter);

// #if !FFI_NATIVE_RAW_API

// #endif

  public static class Fun_ffi_cif_Pointer_ffi_raw_Pointer extends FunctionPointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public    Fun_ffi_cif_Pointer_ffi_raw_Pointer(Pointer p) { super(p); }
      protected Fun_ffi_cif_Pointer_ffi_raw_Pointer() { allocate(); }
      private native void allocate();
      public native void call(ffi_cif arg0,Pointer arg1,ffi_raw arg2,Pointer arg3);
  }
  public native Fun_ffi_cif_Pointer_ffi_raw_Pointer fun(); public native ffi_raw_closure fun(Fun_ffi_cif_Pointer_ffi_raw_Pointer setter);
  public native Pointer user_data(); public native ffi_raw_closure user_data(Pointer setter);

}
