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

/** Applies unfold over a 4-D input.
 *  See https://pytorch.org/docs/master/nn.html#torch.nn.Unfold to learn about
 *  the exact behavior of this module.
 * 
 *  See the documentation for {@code torch::nn::UnfoldOptions} class to learn what
 *  constructor arguments are supported for this module.
 * 
 *  Example:
 *  <pre>{@code
 *  Unfold model(UnfoldOptions({2, 4}).dilation(2).padding({2, 1}).stride(2));
 *  }</pre> */
@Namespace("torch::nn") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class UnfoldImpl extends UnfoldImplCloneable {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public UnfoldImpl(Pointer p) { super(p); }
    /** Downcast constructor. */
    public UnfoldImpl(Module pointer) { super((Pointer)null); allocate(pointer); }
    @Namespace private native @SharedPtr @Name("SHARED_PTR_NAMESPACE::dynamic_pointer_cast<torch::nn::UnfoldImpl, torch::nn::Module>") void allocate(@SharedPtr Module pointer);

  public UnfoldImpl(@ByVal @Cast("torch::ExpandingArray<2>*") LongPointer kernel_size) { super((Pointer)null); allocate(kernel_size); }
  @SharedPtr @Name("std::make_shared<torch::nn::UnfoldImpl>") private native void allocate(@ByVal @Cast("torch::ExpandingArray<2>*") LongPointer kernel_size);
  public UnfoldImpl(@Const @ByRef UnfoldOptions options_) { super((Pointer)null); allocate(options_); }
  @SharedPtr @Name("std::make_shared<torch::nn::UnfoldImpl>") private native void allocate(@Const @ByRef UnfoldOptions options_);

  public native void reset();

  /** Pretty prints the {@code Unfold} module into the given {@code stream}. */
  public native void pretty_print(@Cast("std::ostream*") @ByRef Pointer stream);

  public native @ByVal Tensor forward(@Const @ByRef Tensor input);

  /** The options with which this {@code Module} was constructed. */
  public native @ByRef UnfoldOptions options(); public native UnfoldImpl options(UnfoldOptions setter);
}
