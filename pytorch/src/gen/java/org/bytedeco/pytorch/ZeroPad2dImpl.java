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


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ZeroPad2d ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/** Applies ZeroPad over a 2-D input.
 *  See https://pytorch.org/docs/master/nn.html#torch.nn.ZeroPad2d to learn
 *  about the exact behavior of this module.
 * 
 *  See the documentation for {@code torch::nn::ZeroPad2dOptions} class to learn what
 *  constructor arguments are supported for this module.
 * 
 *  Example:
 *  <pre>{@code
 *  ZeroPad2d model(ZeroPad2dOptions({1, 1, 2, 0}));
 *  }</pre> */
@Namespace("torch::nn") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class ZeroPad2dImpl extends ZeroPad2dImplCloneable {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ZeroPad2dImpl(Pointer p) { super(p); }
    /** Downcast constructor. */
    public ZeroPad2dImpl(Module pointer) { super((Pointer)null); allocate(pointer); }
    @Namespace private native @SharedPtr @Name("SHARED_PTR_NAMESPACE::dynamic_pointer_cast<torch::nn::ZeroPad2dImpl, torch::nn::Module>") void allocate(@SharedPtr Module pointer);

  public ZeroPad2dImpl(@ByVal @Cast("torch::ExpandingArray<4>*") LongPointer padding) { super((Pointer)null); allocate(padding); }
  @SharedPtr @Name("std::make_shared<torch::nn::ZeroPad2dImpl>") private native void allocate(@ByVal @Cast("torch::ExpandingArray<4>*") LongPointer padding);
  public ZeroPad2dImpl(@Const @ByRef ZeroPad2dOptions options_) { super((Pointer)null); allocate(options_); }
  @SharedPtr @Name("std::make_shared<torch::nn::ZeroPad2dImpl>") private native void allocate(@Const @ByRef ZeroPad2dOptions options_);

  public native void reset();

  /** Pretty prints the {@code ZeroPad2d} module into the given {@code stream}. */
  public native void pretty_print(@Cast("std::ostream*") @ByRef Pointer stream);

  public native @ByVal Tensor forward(@Const @ByRef Tensor input);

  /** The options with which this {@code Module} was constructed. */
  public native @ByRef ZeroPad2dOptions options(); public native ZeroPad2dImpl options(ZeroPad2dOptions setter);
}
