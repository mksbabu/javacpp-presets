// Targeted by JavaCPP version 1.5.9-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;

import static org.bytedeco.dnnl.global.dnnl.*;


/** GRU forward propagation primitive. */
@Namespace("dnnl") @Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class gru_forward extends primitive {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public gru_forward(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public gru_forward(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public gru_forward position(long position) {
        return (gru_forward)super.position(position);
    }
    @Override public gru_forward getPointer(long i) {
        return new gru_forward((Pointer)this).offsetAddress(i);
    }

    /** Primitive descriptor for a GRU forward propagation primitive. */
    public static class primitive_desc extends rnn_primitive_desc_base {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public primitive_desc(Pointer p) { super(p); }
        /** Native array allocator. Access with {@link Pointer#position(long)}. */
        public primitive_desc(long size) { super((Pointer)null); allocateArray(size); }
        private native void allocateArray(long size);
        @Override public primitive_desc position(long position) {
            return (primitive_desc)super.position(position);
        }
        @Override public primitive_desc getPointer(long i) {
            return new primitive_desc((Pointer)this).offsetAddress(i);
        }
    
        /** Default constructor. Produces an empty object. */
        
        ///
        ///
        ///
        ///
        public primitive_desc() { super((Pointer)null); allocate(); }
        private native void allocate();

        /** Constructs a primitive descriptor for a GRU forward propagation
         *      primitive.
         * 
         *  The following arguments may point to a zero memory descriptor:
         *  - \p src_iter_desc,
         *  - \p bias_desc,
         *  - \p dst_iter_desc.
         * 
         *  This would then indicate that the GRU forward propagation primitive
         *  should not use them and should default to zero values instead.
         * 
         *  \note
         *      All memory descriptors except \p src_iter_desc may be
         *      initialized with an #dnnl::memory::format_tag::any value of \p
         *      format_tag.
         * 
         *  @param aengine Engine to use.
         *  @param aprop_kind Propagation kind. Possible values are
         *      #dnnl::prop_kind::forward_training, and
         *      #dnnl::prop_kind::forward_inference.
         *  @param direction RNN direction. See \ref dnnl::rnn_direction for
         *      more info.
         *  @param src_layer_desc Memory descriptor for the input vector.
         *  @param src_iter_desc Memory descriptor for the input recurrent
         *      hidden state vector.
         *  @param weights_layer_desc Memory descriptor for the weights
         *      applied to the layer input.
         *  @param weights_iter_desc Memory descriptor for the weights applied
         *      to the recurrent input.
         *  @param bias_desc Bias memory descriptor.
         *  @param dst_layer_desc Memory descriptor for the output vector.
         *  @param dst_iter_desc Memory descriptor for the output recurrent
         *      hidden state vector.
         *  @param attr Primitive attributes to use. Attributes are optional
         *      and default to empty attributes.
         *  @param allow_empty A flag signifying whether construction is
         *      allowed to fail without throwing an exception. In this case an
         *      empty object will be produced. This flag is optional and
         *      defaults to false. */
        
        ///
        public primitive_desc(@Const @ByRef engine aengine, prop_kind aprop_kind,
                        rnn_direction direction, @Const @ByRef org.bytedeco.dnnl.memory.desc src_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc src_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc bias_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_iter_desc,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr,
                        @Cast("bool") boolean allow_empty/*=false*/) { super((Pointer)null); allocate(aengine, aprop_kind, direction, src_layer_desc, src_iter_desc, weights_layer_desc, weights_iter_desc, bias_desc, dst_layer_desc, dst_iter_desc, attr, allow_empty); }
        private native void allocate(@Const @ByRef engine aengine, prop_kind aprop_kind,
                        rnn_direction direction, @Const @ByRef org.bytedeco.dnnl.memory.desc src_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc src_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc bias_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_iter_desc,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr,
                        @Cast("bool") boolean allow_empty/*=false*/);
        public primitive_desc(@Const @ByRef engine aengine, prop_kind aprop_kind,
                        rnn_direction direction, @Const @ByRef org.bytedeco.dnnl.memory.desc src_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc src_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc bias_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_iter_desc) { super((Pointer)null); allocate(aengine, aprop_kind, direction, src_layer_desc, src_iter_desc, weights_layer_desc, weights_iter_desc, bias_desc, dst_layer_desc, dst_iter_desc); }
        private native void allocate(@Const @ByRef engine aengine, prop_kind aprop_kind,
                        rnn_direction direction, @Const @ByRef org.bytedeco.dnnl.memory.desc src_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc src_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc bias_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_iter_desc);
        public primitive_desc(@Const @ByRef engine aengine, @Cast("dnnl::prop_kind") int aprop_kind,
                        @Cast("dnnl::rnn_direction") int direction, @Const @ByRef org.bytedeco.dnnl.memory.desc src_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc src_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc bias_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_iter_desc,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr,
                        @Cast("bool") boolean allow_empty/*=false*/) { super((Pointer)null); allocate(aengine, aprop_kind, direction, src_layer_desc, src_iter_desc, weights_layer_desc, weights_iter_desc, bias_desc, dst_layer_desc, dst_iter_desc, attr, allow_empty); }
        private native void allocate(@Const @ByRef engine aengine, @Cast("dnnl::prop_kind") int aprop_kind,
                        @Cast("dnnl::rnn_direction") int direction, @Const @ByRef org.bytedeco.dnnl.memory.desc src_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc src_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc bias_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_iter_desc,
                        @Const @ByRef(nullValue = "dnnl::primitive_attr()") primitive_attr attr,
                        @Cast("bool") boolean allow_empty/*=false*/);
        public primitive_desc(@Const @ByRef engine aengine, @Cast("dnnl::prop_kind") int aprop_kind,
                        @Cast("dnnl::rnn_direction") int direction, @Const @ByRef org.bytedeco.dnnl.memory.desc src_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc src_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc bias_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_iter_desc) { super((Pointer)null); allocate(aengine, aprop_kind, direction, src_layer_desc, src_iter_desc, weights_layer_desc, weights_iter_desc, bias_desc, dst_layer_desc, dst_iter_desc); }
        private native void allocate(@Const @ByRef engine aengine, @Cast("dnnl::prop_kind") int aprop_kind,
                        @Cast("dnnl::rnn_direction") int direction, @Const @ByRef org.bytedeco.dnnl.memory.desc src_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc src_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc weights_iter_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc bias_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_layer_desc,
                        @Const @ByRef org.bytedeco.dnnl.memory.desc dst_iter_desc);

        /** Constructs a primitive descriptor for a GRU forward propagation
         *  primitive from a C API primitive descriptor that must have a
         *  matching kind.
         * 
         *  @param pd C API primitive descriptor for a GRU forward
         *      propagation primitive. */
        public primitive_desc(dnnl_primitive_desc pd) { super((Pointer)null); allocate(pd); }
        private native void allocate(dnnl_primitive_desc pd);

        /** \copydoc dnnl::rnn_primitive_desc_base::src_layer_desc()const */
        public native @ByVal org.bytedeco.dnnl.memory.desc src_layer_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::src_iter_desc()const */
        public native @ByVal org.bytedeco.dnnl.memory.desc src_iter_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::weights_layer_desc()const */
        public native @ByVal org.bytedeco.dnnl.memory.desc weights_layer_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::weights_iter_desc()const */
        public native @ByVal org.bytedeco.dnnl.memory.desc weights_iter_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::bias_desc()const */
        public native @ByVal org.bytedeco.dnnl.memory.desc bias_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::dst_layer_desc()const */
        public native @ByVal org.bytedeco.dnnl.memory.desc dst_layer_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::dst_iter_desc()const */
        public native @ByVal org.bytedeco.dnnl.memory.desc dst_iter_desc();

        /** \copydoc dnnl::rnn_primitive_desc_base::workspace_desc()const */
        public native @ByVal org.bytedeco.dnnl.memory.desc workspace_desc();

        /** \copydoc dnnl::primitive_desc_base::get_cell_kind()const */
        public native algorithm get_cell_kind();

        /** \copydoc dnnl::primitive_desc_base::get_prop_kind()const */
        public native prop_kind get_prop_kind();

        /** \copydoc dnnl::primitive_desc_base::get_direction()const */
        public native rnn_direction get_direction();
    }

    /** Default constructor. Produces an empty object. */
    public gru_forward() { super((Pointer)null); allocate(); }
    private native void allocate();

    /** Constructs a GRU forward propagation primitive.
     *  @param pd Primitive descriptor for a GRU forward propagation
     *      primitive. */
    public gru_forward(@Const @ByRef primitive_desc pd) { super((Pointer)null); allocate(pd); }
    private native void allocate(@Const @ByRef primitive_desc pd);

    /** Constructs a GRU forward propagation primitive from a cache blob.
     *  @param pd Primitive descriptor for a GRU forward propagation
     *      primitive.
     *  @param cache_blob Cache blob. */
    public gru_forward(
                @Const @ByRef primitive_desc pd, @Cast("uint8_t*") @StdVector BytePointer cache_blob) { super((Pointer)null); allocate(pd, cache_blob); }
    private native void allocate(
                @Const @ByRef primitive_desc pd, @Cast("uint8_t*") @StdVector BytePointer cache_blob);
    public gru_forward(
                @Const @ByRef primitive_desc pd, @Cast("uint8_t*") @StdVector ByteBuffer cache_blob) { super((Pointer)null); allocate(pd, cache_blob); }
    private native void allocate(
                @Const @ByRef primitive_desc pd, @Cast("uint8_t*") @StdVector ByteBuffer cache_blob);
    public gru_forward(
                @Const @ByRef primitive_desc pd, @Cast("uint8_t*") @StdVector byte[] cache_blob) { super((Pointer)null); allocate(pd, cache_blob); }
    private native void allocate(
                @Const @ByRef primitive_desc pd, @Cast("uint8_t*") @StdVector byte[] cache_blob);
}
