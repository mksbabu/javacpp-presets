// Targeted by JavaCPP version 1.5.10-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.pytorch;

import org.bytedeco.pytorch.Allocator;
import org.bytedeco.pytorch.Function;
import org.bytedeco.pytorch.functions.*;
import org.bytedeco.pytorch.Module;
import org.bytedeco.javacpp.annotation.Cast;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.pytorch.global.torch.*;


// ============================================================================

/** Base class for all (dimension-specialized) maxpool modules. */
@Name("torch::nn::MaxPoolImpl<1,torch::nn::MaxPool1dImpl>") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class MaxPool1dImplBase extends MaxPool1dImplCloneable {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MaxPool1dImplBase(Pointer p) { super(p); }
    /** Downcast constructor. */
    public MaxPool1dImplBase(Module pointer) { super((Pointer)null); allocate(pointer); }
    @Namespace private native @SharedPtr @Name("SHARED_PTR_NAMESPACE::dynamic_pointer_cast<torch::nn::MaxPoolImpl<1,torch::nn::MaxPool1dImpl>, torch::nn::Module>") void allocate(@SharedPtr Module pointer);

  public MaxPool1dImplBase(@ByVal @Cast("torch::ExpandingArray<1>*") LongPointer kernel_size) { super((Pointer)null); allocate(kernel_size); }
  private native void allocate(@ByVal @Cast("torch::ExpandingArray<1>*") LongPointer kernel_size);
  public MaxPool1dImplBase(@Const @ByRef MaxPool1dOptions options_) { super((Pointer)null); allocate(options_); }
  private native void allocate(@Const @ByRef MaxPool1dOptions options_);

  public native void reset();

  /** Pretty prints the {@code MaxPool{1,2,3}d} module into the given {@code stream}. */
  public native void pretty_print(@Cast("std::ostream*") @ByRef Pointer stream);

  /** The options with which this {@code Module} was constructed. */
  public native @ByRef MaxPool1dOptions options(); public native MaxPool1dImplBase options(MaxPool1dOptions setter);
}
