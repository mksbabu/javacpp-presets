// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_cudaoptflow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.opencv.opencv_flann.*;
import static org.bytedeco.opencv.global.opencv_flann.*;
import org.bytedeco.opencv.opencv_features2d.*;
import static org.bytedeco.opencv.global.opencv_features2d.*;
import org.bytedeco.opencv.opencv_calib3d.*;
import static org.bytedeco.opencv.global.opencv_calib3d.*;
import org.bytedeco.opencv.opencv_objdetect.*;
import static org.bytedeco.opencv.global.opencv_objdetect.*;
import org.bytedeco.opencv.opencv_dnn.*;
import static org.bytedeco.opencv.global.opencv_dnn.*;
import org.bytedeco.opencv.opencv_video.*;
import static org.bytedeco.opencv.global.opencv_video.*;
import org.bytedeco.opencv.opencv_ximgproc.*;
import static org.bytedeco.opencv.global.opencv_ximgproc.*;
import org.bytedeco.opencv.opencv_optflow.*;
import static org.bytedeco.opencv.global.opencv_optflow.*;
import org.bytedeco.opencv.opencv_cudaarithm.*;
import static org.bytedeco.opencv.global.opencv_cudaarithm.*;
import org.bytedeco.opencv.opencv_cudafilters.*;
import static org.bytedeco.opencv.global.opencv_cudafilters.*;
import org.bytedeco.opencv.opencv_cudaimgproc.*;
import static org.bytedeco.opencv.global.opencv_cudaimgproc.*;
import static org.bytedeco.opencv.global.opencv_cudawarping.*;

import static org.bytedeco.opencv.global.opencv_cudaoptflow.*;


//
// PyrLKOpticalFlow
//

/** \brief Class used for calculating a sparse optical flow.
<p>
The class can calculate an optical flow for a sparse feature set using the
iterative Lucas-Kanade method with pyramids.
<p>
@see calcOpticalFlowPyrLK
<p>
\note
   -   An example of the Lucas Kanade optical flow algorithm can be found at
        opencv_source_code/samples/gpu/pyrlk_optical_flow.cpp
 */
@Namespace("cv::cuda") @Properties(inherit = org.bytedeco.opencv.presets.opencv_cudaoptflow.class)
public class SparsePyrLKOpticalFlow extends SparseOpticalFlow {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SparsePyrLKOpticalFlow(Pointer p) { super(p); }

    public native @ByVal Size getWinSize();
    public native void setWinSize(@ByVal Size winSize);

    public native int getMaxLevel();
    public native void setMaxLevel(int maxLevel);

    public native int getNumIters();
    public native void setNumIters(int iters);

    public native @Cast("bool") boolean getUseInitialFlow();
    public native void setUseInitialFlow(@Cast("bool") boolean useInitialFlow);

    public static native @Ptr SparsePyrLKOpticalFlow create(
                @ByVal(nullValue = "cv::Size(21, 21)") Size winSize,
                int maxLevel/*=3*/,
                int iters/*=30*/,
                @Cast("bool") boolean useInitialFlow/*=false*/);
    public static native @Ptr SparsePyrLKOpticalFlow create();
}
