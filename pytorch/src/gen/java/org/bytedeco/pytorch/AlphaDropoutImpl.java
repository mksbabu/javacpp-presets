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


// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ AlphaDropout ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/** Applies Alpha Dropout over the input.
 *  See https://pytorch.org/docs/master/nn.html#torch.nn.AlphaDropout to learn
 *  about the exact behavior of this module.
 * 
 *  See the documentation for {@code torch::nn::AlphaDropoutOptions} class to learn
 *  what constructor arguments are supported for this module.
 * 
 *  Example:
 *  <pre>{@code
 *  AlphaDropout model(AlphaDropoutOptions(0.2).inplace(true));
 *  }</pre> */
@Namespace("torch::nn") @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class AlphaDropoutImpl extends AlphaDropoutImplBase {
    static { Loader.load(); }

  
    public AlphaDropoutImpl(double p) { super((Pointer)null); allocate(p); }
    private native void allocate(double p);
  
    public AlphaDropoutImpl(@Const @ByRef(nullValue = "torch::nn::DropoutOptions{}") DropoutOptions options_) { super((Pointer)null); allocate(options_); }
    private native void allocate(@Const @ByRef(nullValue = "torch::nn::DropoutOptions{}") DropoutOptions options_);
    public AlphaDropoutImpl() { super((Pointer)null); allocate(); }
    private native void allocate();
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AlphaDropoutImpl(Pointer p) { super(p); }
    /** Downcast constructor. */
    public AlphaDropoutImpl(Module pointer) { super((Pointer)null); allocate(pointer); }
    @Namespace private native @SharedPtr @Name("SHARED_PTR_NAMESPACE::dynamic_pointer_cast<torch::nn::AlphaDropoutImpl, torch::nn::Module>") void allocate(@SharedPtr Module pointer);


  public native @ByVal Tensor forward(@Const @ByRef Tensor input);

  /** Pretty prints the {@code AlphaDropout} module into the given {@code stream}. */
  public native void pretty_print(@Cast("std::ostream*") @ByRef Pointer stream);
}
