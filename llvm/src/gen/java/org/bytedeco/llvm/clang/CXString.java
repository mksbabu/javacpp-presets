// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.llvm.clang;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

import static org.bytedeco.llvm.global.clang.*;


/**
 * \defgroup CINDEX_STRING String manipulation routines
 * \ingroup CINDEX
 *
 * \{
 */

/**
 * A character string.
 *
 * The \c CXString type is used to return strings from the interface when
 * the ownership of that string might differ from one call to the next.
 * Use \c clang_getCString() to retrieve the string data and, once finished
 * with the string data, call \c clang_disposeString() to free the string.
 */
@Properties(inherit = org.bytedeco.llvm.presets.clang.class)
public class CXString extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CXString() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CXString(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CXString(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CXString position(long position) {
        return (CXString)super.position(position);
    }
    @Override public CXString getPointer(long i) {
        return new CXString((Pointer)this).offsetAddress(i);
    }

  public String getString() {
      String s = clang_getCString(this).getString();
      clang_disposeString(this);
      return s;
  }
  public native @Const Pointer data(); public native CXString data(Pointer data);
  public native @Cast("unsigned") int private_flags(); public native CXString private_flags(int setter);
}
