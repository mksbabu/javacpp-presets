// Targeted by JavaCPP version 1.1-SNAPSHOT

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_videoio.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_flann.*;
import static org.bytedeco.javacpp.opencv_ml.*;
import static org.bytedeco.javacpp.opencv_features2d.*;
import static org.bytedeco.javacpp.opencv_calib3d.*;
import static org.bytedeco.javacpp.opencv_photo.*;
import static org.bytedeco.javacpp.opencv_video.*;

public class opencv_videostab extends org.bytedeco.javacpp.presets.opencv_videostab {
    static { Loader.load(); }

// Parsed from <opencv2/videostab/frame_source.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_FRAME_SOURCE_HPP__
// #define __OPENCV_VIDEOSTAB_FRAME_SOURCE_HPP__

// #include <vector>
// #include "opencv2/core.hpp"

/** @addtogroup videostab
 *  @{ */

@Namespace("cv::videostab") public static class IFrameSource extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public IFrameSource() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IFrameSource(Pointer p) { super(p); }

    public native void reset();
    public native @ByVal Mat nextFrame();
}

@Namespace("cv::videostab") public static class NullFrameSource extends IFrameSource {
    static { Loader.load(); }
    /** Default native constructor. */
    public NullFrameSource() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public NullFrameSource(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NullFrameSource(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public NullFrameSource position(int position) {
        return (NullFrameSource)super.position(position);
    }

    public native void reset();
    public native @ByVal Mat nextFrame();
}

@Namespace("cv::videostab") @NoOffset public static class VideoFileSource extends IFrameSource {
    static { Loader.load(); }
    /** Empty constructor. */
    public VideoFileSource() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public VideoFileSource(Pointer p) { super(p); }

    public VideoFileSource(@Str BytePointer path, @Cast("bool") boolean volatileFrame/*=false*/) { allocate(path, volatileFrame); }
    private native void allocate(@Str BytePointer path, @Cast("bool") boolean volatileFrame/*=false*/);
    public VideoFileSource(@Str BytePointer path) { allocate(path); }
    private native void allocate(@Str BytePointer path);
    public VideoFileSource(@Str String path, @Cast("bool") boolean volatileFrame/*=false*/) { allocate(path, volatileFrame); }
    private native void allocate(@Str String path, @Cast("bool") boolean volatileFrame/*=false*/);
    public VideoFileSource(@Str String path) { allocate(path); }
    private native void allocate(@Str String path);

    public native void reset();
    public native @ByVal Mat nextFrame();

    public native int width();
    public native int height();
    public native int count();
    public native double fps();
}

/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab/log.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_LOG_HPP__
// #define __OPENCV_VIDEOSTAB_LOG_HPP__

// #include "opencv2/core.hpp"

/** @addtogroup videostab
 *  @{ */

@Namespace("cv::videostab") public static class ILog extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public ILog() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ILog(Pointer p) { super(p); }

    public native void print(@Cast("const char*") BytePointer format);
    public native void print(String format);
}

@Namespace("cv::videostab") public static class NullLog extends ILog {
    static { Loader.load(); }
    /** Default native constructor. */
    public NullLog() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public NullLog(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NullLog(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public NullLog position(int position) {
        return (NullLog)super.position(position);
    }

    public native void print(@Cast("const char*") BytePointer arg0);
    public native void print(String arg0);
}

@Namespace("cv::videostab") public static class LogToStdout extends ILog {
    static { Loader.load(); }
    /** Default native constructor. */
    public LogToStdout() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public LogToStdout(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LogToStdout(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public LogToStdout position(int position) {
        return (LogToStdout)super.position(position);
    }

    public native void print(@Cast("const char*") BytePointer format);
    public native void print(String format);
}

/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab/fast_marching.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_FAST_MARCHING_HPP__
// #define __OPENCV_VIDEOSTAB_FAST_MARCHING_HPP__

// #include <cmath>
// #include <queue>
// #include <algorithm>
// #include "opencv2/core.hpp"

/** @addtogroup videostab_marching
 *  @{

/** @brief Describes the Fast Marching Method implementation.

  See http://iwi.eldoc.ub.rug.nl/FILES/root/2004/JGraphToolsTelea/2004JGraphToolsTelea.pdf
 */
@Namespace("cv::videostab") @NoOffset public static class FastMarchingMethod extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FastMarchingMethod(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public FastMarchingMethod(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public FastMarchingMethod position(int position) {
        return (FastMarchingMethod)super.position(position);
    }

    public FastMarchingMethod() { allocate(); }
    private native void allocate();

    /** @brief Template method that runs the Fast Marching Method.

    @param mask Image mask. 0 value indicates that the pixel value must be inpainted, 255 indicates
    that the pixel value is known, other values aren't acceptable.
    @param inpaint Inpainting functor that overloads void operator ()(int x, int y).
    @return Inpainting functor.
     */

    /**
    @return Distance map that's created during working of the method.
    */
    public native @ByVal Mat distanceMap();
}

/** @} */

 // namespace videostab
 // namespace cv

// #include "fast_marching_inl.hpp"

// #endif


// Parsed from <opencv2/videostab/optical_flow.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_OPTICAL_FLOW_HPP__
// #define __OPENCV_VIDEOSTAB_OPTICAL_FLOW_HPP__

// #include "opencv2/core.hpp"
// #include "opencv2/opencv_modules.hpp"

// #ifdef HAVE_OPENCV_CUDAOPTFLOW
// #endif

/** @addtogroup videostab
 *  @{ */

@Namespace("cv::videostab") public static class ISparseOptFlowEstimator extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public ISparseOptFlowEstimator() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ISparseOptFlowEstimator(Pointer p) { super(p); }

    public native void run(
                @ByVal Mat frame0, @ByVal Mat frame1, @ByVal Mat points0, @ByVal Mat points1,
                @ByVal Mat status, @ByVal Mat errors);
}

@Namespace("cv::videostab") public static class IDenseOptFlowEstimator extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public IDenseOptFlowEstimator() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IDenseOptFlowEstimator(Pointer p) { super(p); }

    public native void run(
                @ByVal Mat frame0, @ByVal Mat frame1, @ByVal Mat flowX, @ByVal Mat flowY,
                @ByVal Mat errors);
}

@Namespace("cv::videostab") @NoOffset public static class PyrLkOptFlowEstimatorBase extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PyrLkOptFlowEstimatorBase(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public PyrLkOptFlowEstimatorBase(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public PyrLkOptFlowEstimatorBase position(int position) {
        return (PyrLkOptFlowEstimatorBase)super.position(position);
    }

    public PyrLkOptFlowEstimatorBase() { allocate(); }
    private native void allocate();

    public native void setWinSize(@ByVal Size val);
    public native @ByVal Size winSize();

    public native void setMaxLevel(int val);
    public native int maxLevel();
}

@Namespace("cv::videostab") public static class SparsePyrLkOptFlowEstimator extends PyrLkOptFlowEstimatorBase {
    static { Loader.load(); }
    /** Default native constructor. */
    public SparsePyrLkOptFlowEstimator() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public SparsePyrLkOptFlowEstimator(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SparsePyrLkOptFlowEstimator(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public SparsePyrLkOptFlowEstimator position(int position) {
        return (SparsePyrLkOptFlowEstimator)super.position(position);
    }
    public ISparseOptFlowEstimator asISparseOptFlowEstimator() { return asISparseOptFlowEstimator(this); }
    @Namespace public static native @Name("static_cast<cv::videostab::ISparseOptFlowEstimator*>") ISparseOptFlowEstimator asISparseOptFlowEstimator(SparsePyrLkOptFlowEstimator pointer);

    public native void run(
                @ByVal Mat frame0, @ByVal Mat frame1, @ByVal Mat points0, @ByVal Mat points1,
                @ByVal Mat status, @ByVal Mat errors);
}

// #ifdef HAVE_OPENCV_CUDAOPTFLOW

// #endif

/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab/motion_core.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_MOTION_CORE_HPP__
// #define __OPENCV_VIDEOSTAB_MOTION_CORE_HPP__

// #include <cmath>
// #include "opencv2/core.hpp"

/** @addtogroup videostab_motion
 *  @{

/** @brief Describes motion model between two point clouds.
 */
/** enum cv::videostab::MotionModel */
public static final int
    MM_TRANSLATION = 0,
    MM_TRANSLATION_AND_SCALE = 1,
    MM_ROTATION = 2,
    MM_RIGID = 3,
    MM_SIMILARITY = 4,
    MM_AFFINE = 5,
    MM_HOMOGRAPHY = 6,
    MM_UNKNOWN = 7;

/** @brief Describes RANSAC method parameters.
 */
@Namespace("cv::videostab") @NoOffset public static class RansacParams extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RansacParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public RansacParams(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public RansacParams position(int position) {
        return (RansacParams)super.position(position);
    }

    /** subset size */
    public native int size(); public native RansacParams size(int size);
    /** max error to classify as inlier */
    public native float thresh(); public native RansacParams thresh(float thresh);
    /** max outliers ratio */
    public native float eps(); public native RansacParams eps(float eps);
    /** probability of success */
    public native float prob(); public native RansacParams prob(float prob);

    public RansacParams() { allocate(); }
    private native void allocate();
    /** @brief Constructor
    @param size Subset size.
    @param thresh Maximum re-projection error value to classify as inlier.
    @param eps Maximum ratio of incorrect correspondences.
    @param prob Required success probability.
     */
    public RansacParams(int size, float thresh, float eps, float prob) { allocate(size, thresh, eps, prob); }
    private native void allocate(int size, float thresh, float eps, float prob);

    /**
    @return Number of iterations that'll be performed by RANSAC method.
    */
    public native int niters();

    /**
    @param model Motion model. See cv::videostab::MotionModel.
    @return Default RANSAC method parameters for the given motion model.
    */
    public static native @ByVal RansacParams default2dMotion(@Cast("cv::videostab::MotionModel") int model);
}



/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab/outlier_rejection.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_OUTLIER_REJECTION_HPP__
// #define __OPENCV_VIDEOSTAB_OUTLIER_REJECTION_HPP__

// #include <vector>
// #include "opencv2/core.hpp"
// #include "opencv2/videostab/motion_core.hpp"

/** @addtogroup videostab
 *  @{ */

@Namespace("cv::videostab") public static class IOutlierRejector extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public IOutlierRejector() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IOutlierRejector(Pointer p) { super(p); }


    public native void process(
                @ByVal Size frameSize, @ByVal Mat points0, @ByVal Mat points1, @ByVal Mat mask);
}

@Namespace("cv::videostab") public static class NullOutlierRejector extends IOutlierRejector {
    static { Loader.load(); }
    /** Default native constructor. */
    public NullOutlierRejector() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public NullOutlierRejector(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NullOutlierRejector(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public NullOutlierRejector position(int position) {
        return (NullOutlierRejector)super.position(position);
    }

    public native void process(
                @ByVal Size frameSize, @ByVal Mat points0, @ByVal Mat points1, @ByVal Mat mask);
}

@Namespace("cv::videostab") @NoOffset public static class TranslationBasedLocalOutlierRejector extends IOutlierRejector {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TranslationBasedLocalOutlierRejector(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public TranslationBasedLocalOutlierRejector(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public TranslationBasedLocalOutlierRejector position(int position) {
        return (TranslationBasedLocalOutlierRejector)super.position(position);
    }

    public TranslationBasedLocalOutlierRejector() { allocate(); }
    private native void allocate();

    public native void setCellSize(@ByVal Size val);
    public native @ByVal Size cellSize();

    public native void setRansacParams(@ByVal RansacParams val);
    public native @ByVal RansacParams ransacParams();

    public native void process(
                @ByVal Size frameSize, @ByVal Mat points0, @ByVal Mat points1, @ByVal Mat mask);
}

/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab/global_motion.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_GLOBAL_MOTION_HPP__
// #define __OPENCV_VIDEOSTAB_GLOBAL_MOTION_HPP__

// #include <vector>
// #include <fstream>
// #include "opencv2/core.hpp"
// #include "opencv2/features2d.hpp"
// #include "opencv2/opencv_modules.hpp"
// #include "opencv2/videostab/optical_flow.hpp"
// #include "opencv2/videostab/motion_core.hpp"
// #include "opencv2/videostab/outlier_rejection.hpp"

// #ifdef HAVE_OPENCV_CUDAIMGPROC
// #endif

/** @addtogroup videostab_motion
 *  @{

/** @brief Estimates best global motion between two 2D point clouds in the least-squares sense.

@note Works in-place and changes input point arrays.

@param points0 Source set of 2D points (32F).
@param points1 Destination set of 2D points (32F).
@param model Motion model (up to MM_AFFINE).
@param rmse Final root-mean-square error.
@return 3x3 2D transformation matrix (32F).
 */
@Namespace("cv::videostab") public static native @ByVal Mat estimateGlobalMotionLeastSquares(
        @ByVal Mat points0, @ByVal Mat points1, int model/*=cv::videostab::MM_AFFINE*/,
        FloatPointer rmse/*=0*/);
@Namespace("cv::videostab") public static native @ByVal Mat estimateGlobalMotionLeastSquares(
        @ByVal Mat points0, @ByVal Mat points1);
@Namespace("cv::videostab") public static native @ByVal Mat estimateGlobalMotionLeastSquares(
        @ByVal Mat points0, @ByVal Mat points1, int model/*=cv::videostab::MM_AFFINE*/,
        FloatBuffer rmse/*=0*/);
@Namespace("cv::videostab") public static native @ByVal Mat estimateGlobalMotionLeastSquares(
        @ByVal Mat points0, @ByVal Mat points1, int model/*=cv::videostab::MM_AFFINE*/,
        float[] rmse/*=0*/);

/** @brief Estimates best global motion between two 2D point clouds robustly (using RANSAC method).

@param points0 Source set of 2D points (32F).
@param points1 Destination set of 2D points (32F).
@param model Motion model. See cv::videostab::MotionModel.
@param params RANSAC method parameters. See videostab::RansacParams.
@param rmse Final root-mean-square error.
@param ninliers Final number of inliers.
 */
@Namespace("cv::videostab") public static native @ByVal Mat estimateGlobalMotionRansac(
        @ByVal Mat points0, @ByVal Mat points1, int model/*=cv::videostab::MM_AFFINE*/,
        @Const @ByRef(nullValue = "cv::videostab::RansacParams::default2dMotion(cv::videostab::MM_AFFINE)") RansacParams params/*=cv::videostab::RansacParams::default2dMotion(cv::videostab::MM_AFFINE)*/,
        FloatPointer rmse/*=0*/, IntPointer ninliers/*=0*/);
@Namespace("cv::videostab") public static native @ByVal Mat estimateGlobalMotionRansac(
        @ByVal Mat points0, @ByVal Mat points1);
@Namespace("cv::videostab") public static native @ByVal Mat estimateGlobalMotionRansac(
        @ByVal Mat points0, @ByVal Mat points1, int model/*=cv::videostab::MM_AFFINE*/,
        @Const @ByRef(nullValue = "cv::videostab::RansacParams::default2dMotion(cv::videostab::MM_AFFINE)") RansacParams params/*=cv::videostab::RansacParams::default2dMotion(cv::videostab::MM_AFFINE)*/,
        FloatBuffer rmse/*=0*/, IntBuffer ninliers/*=0*/);
@Namespace("cv::videostab") public static native @ByVal Mat estimateGlobalMotionRansac(
        @ByVal Mat points0, @ByVal Mat points1, int model/*=cv::videostab::MM_AFFINE*/,
        @Const @ByRef(nullValue = "cv::videostab::RansacParams::default2dMotion(cv::videostab::MM_AFFINE)") RansacParams params/*=cv::videostab::RansacParams::default2dMotion(cv::videostab::MM_AFFINE)*/,
        float[] rmse/*=0*/, int[] ninliers/*=0*/);

/** @brief Base class for all global motion estimation methods.
 */
@Namespace("cv::videostab") @NoOffset public static class MotionEstimatorBase extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public MotionEstimatorBase() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MotionEstimatorBase(Pointer p) { super(p); }


    /** @brief Sets motion model.

    @param val Motion model. See cv::videostab::MotionModel.
     */
    public native void setMotionModel(@Cast("cv::videostab::MotionModel") int val);

    /**
    @return Motion model. See cv::videostab::MotionModel.
    */
    public native @Cast("cv::videostab::MotionModel") int motionModel();

    /** @brief Estimates global motion between two 2D point clouds.

    @param points0 Source set of 2D points (32F).
    @param points1 Destination set of 2D points (32F).
    @param ok Indicates whether motion was estimated successfully.
    @return 3x3 2D transformation matrix (32F).
     */
    public native @ByVal Mat estimate(@ByVal Mat points0, @ByVal Mat points1, @Cast("bool*") BoolPointer ok/*=0*/);
    public native @ByVal Mat estimate(@ByVal Mat points0, @ByVal Mat points1);
}

/** @brief Describes a robust RANSAC-based global 2D motion estimation method which minimizes L2 error.
 */
@Namespace("cv::videostab") @NoOffset public static class MotionEstimatorRansacL2 extends MotionEstimatorBase {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MotionEstimatorRansacL2(Pointer p) { super(p); }

    public MotionEstimatorRansacL2(@Cast("cv::videostab::MotionModel") int model/*=cv::videostab::MM_AFFINE*/) { allocate(model); }
    private native void allocate(@Cast("cv::videostab::MotionModel") int model/*=cv::videostab::MM_AFFINE*/);
    public MotionEstimatorRansacL2() { allocate(); }
    private native void allocate();

    public native void setRansacParams(@Const @ByRef RansacParams val);
    public native @ByVal RansacParams ransacParams();

    public native void setMinInlierRatio(float val);
    public native float minInlierRatio();

    public native @ByVal Mat estimate(@ByVal Mat points0, @ByVal Mat points1, @Cast("bool*") BoolPointer ok/*=0*/);
    public native @ByVal Mat estimate(@ByVal Mat points0, @ByVal Mat points1);
}

/** @brief Describes a global 2D motion estimation method which minimizes L1 error.

@note To be able to use this method you must build OpenCV with CLP library support. :
 */
@Namespace("cv::videostab") @NoOffset public static class MotionEstimatorL1 extends MotionEstimatorBase {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MotionEstimatorL1(Pointer p) { super(p); }

    public MotionEstimatorL1(@Cast("cv::videostab::MotionModel") int model/*=cv::videostab::MM_AFFINE*/) { allocate(model); }
    private native void allocate(@Cast("cv::videostab::MotionModel") int model/*=cv::videostab::MM_AFFINE*/);
    public MotionEstimatorL1() { allocate(); }
    private native void allocate();

    public native @ByVal Mat estimate(@ByVal Mat points0, @ByVal Mat points1, @Cast("bool*") BoolPointer ok/*=0*/);
    public native @ByVal Mat estimate(@ByVal Mat points0, @ByVal Mat points1);
}

/** @brief Base class for global 2D motion estimation methods which take frames as input.
 */
@Namespace("cv::videostab") @NoOffset public static class ImageMotionEstimatorBase extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public ImageMotionEstimatorBase() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ImageMotionEstimatorBase(Pointer p) { super(p); }


    public native void setMotionModel(@Cast("cv::videostab::MotionModel") int val);
    public native @Cast("cv::videostab::MotionModel") int motionModel();

    public native @ByVal Mat estimate(@Const @ByRef Mat frame0, @Const @ByRef Mat frame1, @Cast("bool*") BoolPointer ok/*=0*/);
    public native @ByVal Mat estimate(@Const @ByRef Mat frame0, @Const @ByRef Mat frame1);
}

@Namespace("cv::videostab") @NoOffset public static class FromFileMotionReader extends ImageMotionEstimatorBase {
    static { Loader.load(); }
    /** Empty constructor. */
    public FromFileMotionReader() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FromFileMotionReader(Pointer p) { super(p); }

    public FromFileMotionReader(@Str BytePointer path) { allocate(path); }
    private native void allocate(@Str BytePointer path);
    public FromFileMotionReader(@Str String path) { allocate(path); }
    private native void allocate(@Str String path);

    public native @ByVal Mat estimate(@Const @ByRef Mat frame0, @Const @ByRef Mat frame1, @Cast("bool*") BoolPointer ok/*=0*/);
    public native @ByVal Mat estimate(@Const @ByRef Mat frame0, @Const @ByRef Mat frame1);
}

@Namespace("cv::videostab") @NoOffset public static class ToFileMotionWriter extends ImageMotionEstimatorBase {
    static { Loader.load(); }
    /** Empty constructor. */
    public ToFileMotionWriter() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ToFileMotionWriter(Pointer p) { super(p); }

    public ToFileMotionWriter(@Str BytePointer path, @Ptr ImageMotionEstimatorBase estimator) { allocate(path, estimator); }
    private native void allocate(@Str BytePointer path, @Ptr ImageMotionEstimatorBase estimator);
    public ToFileMotionWriter(@Str String path, @Ptr ImageMotionEstimatorBase estimator) { allocate(path, estimator); }
    private native void allocate(@Str String path, @Ptr ImageMotionEstimatorBase estimator);

    public native void setMotionModel(@Cast("cv::videostab::MotionModel") int val);
    public native @Cast("cv::videostab::MotionModel") int motionModel();

    public native @ByVal Mat estimate(@Const @ByRef Mat frame0, @Const @ByRef Mat frame1, @Cast("bool*") BoolPointer ok/*=0*/);
    public native @ByVal Mat estimate(@Const @ByRef Mat frame0, @Const @ByRef Mat frame1);
}

/** @brief Describes a global 2D motion estimation method which uses keypoints detection and optical flow for
matching.
 */
@Namespace("cv::videostab") @NoOffset public static class KeypointBasedMotionEstimator extends ImageMotionEstimatorBase {
    static { Loader.load(); }
    /** Empty constructor. */
    public KeypointBasedMotionEstimator() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public KeypointBasedMotionEstimator(Pointer p) { super(p); }

    public KeypointBasedMotionEstimator(@Ptr MotionEstimatorBase estimator) { allocate(estimator); }
    private native void allocate(@Ptr MotionEstimatorBase estimator);

    public native void setMotionModel(@Cast("cv::videostab::MotionModel") int val);
    public native @Cast("cv::videostab::MotionModel") int motionModel();

    public native void setDetector(@Cast("cv::FeatureDetector*") @Ptr Feature2D val);
    public native @Cast("cv::FeatureDetector*") @Ptr Feature2D detector();

    public native void setOpticalFlowEstimator(@Ptr ISparseOptFlowEstimator val);
    public native @Ptr ISparseOptFlowEstimator opticalFlowEstimator();

    public native void setOutlierRejector(@Ptr IOutlierRejector val);
    public native @Ptr IOutlierRejector outlierRejector();

    public native @ByVal Mat estimate(@Const @ByRef Mat frame0, @Const @ByRef Mat frame1, @Cast("bool*") BoolPointer ok/*=0*/);
    public native @ByVal Mat estimate(@Const @ByRef Mat frame0, @Const @ByRef Mat frame1);
}

// #if defined(HAVE_OPENCV_CUDAIMGPROC) && defined(HAVE_OPENCV_CUDAOPTFLOW)

// #endif // defined(HAVE_OPENCV_CUDAIMGPROC) && defined(HAVE_OPENCV_CUDAOPTFLOW)

/** @brief Computes motion between two frames assuming that all the intermediate motions are known.

@param from Source frame index.
@param to Destination frame index.
@param motions Pair-wise motions. motions[i] denotes motion from the frame i to the frame i+1
@return Motion from the frame from to the frame to.
 */
@Namespace("cv::videostab") public static native @ByVal Mat getMotion(int from, int to, @Const @ByRef MatVector motions);

/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab/motion_stabilizing.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_MOTION_STABILIZING_HPP__
// #define __OPENCV_VIDEOSTAB_MOTION_STABILIZING_HPP__

// #include <vector>
// #include <utility>
// #include "opencv2/core.hpp"
// #include "opencv2/videostab/global_motion.hpp"

/** @addtogroup videostab_motion
 *  @{ */

@Namespace("cv::videostab") public static class IMotionStabilizer extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public IMotionStabilizer() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IMotionStabilizer(Pointer p) { super(p); }


    /** assumes that [0, size-1) is in or equals to [range.first, range.second) */
    public native void stabilize(
                int size, @Const @ByRef MatVector motions, @ByVal IntIntPair range,
                Mat stabilizationMotions);
}

@Namespace("cv::videostab") public static class MotionStabilizationPipeline extends IMotionStabilizer {
    static { Loader.load(); }
    /** Default native constructor. */
    public MotionStabilizationPipeline() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public MotionStabilizationPipeline(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MotionStabilizationPipeline(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public MotionStabilizationPipeline position(int position) {
        return (MotionStabilizationPipeline)super.position(position);
    }

    public native void pushBack(@Ptr IMotionStabilizer stabilizer);
    public native @Cast("bool") boolean empty();

    public native void stabilize(
                int size, @Const @ByRef MatVector motions, @ByVal IntIntPair range,
                Mat stabilizationMotions);
}

@Namespace("cv::videostab") public static class MotionFilterBase extends IMotionStabilizer {
    static { Loader.load(); }
    /** Empty constructor. */
    public MotionFilterBase() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MotionFilterBase(Pointer p) { super(p); }


    public native @ByVal Mat stabilize(
                int idx, @Const @ByRef MatVector motions, @ByVal IntIntPair range);

    public native void stabilize(
                int size, @Const @ByRef MatVector motions, @ByVal IntIntPair range,
                Mat stabilizationMotions);
}

@Namespace("cv::videostab") @NoOffset public static class GaussianMotionFilter extends MotionFilterBase {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public GaussianMotionFilter(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public GaussianMotionFilter(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public GaussianMotionFilter position(int position) {
        return (GaussianMotionFilter)super.position(position);
    }

    public GaussianMotionFilter(int radius/*=15*/, float stdev/*=-1.f*/) { allocate(radius, stdev); }
    private native void allocate(int radius/*=15*/, float stdev/*=-1.f*/);
    public GaussianMotionFilter() { allocate(); }
    private native void allocate();

    public native void setParams(int radius, float stdev/*=-1.f*/);
    public native void setParams(int radius);
    public native int radius();
    public native float stdev();

    public native @ByVal Mat stabilize(
                int idx, @Const @ByRef MatVector motions, @ByVal IntIntPair range);
}



@Namespace("cv::videostab") @NoOffset public static class LpMotionStabilizer extends IMotionStabilizer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LpMotionStabilizer(Pointer p) { super(p); }

    public LpMotionStabilizer(@Cast("cv::videostab::MotionModel") int model/*=cv::videostab::MM_SIMILARITY*/) { allocate(model); }
    private native void allocate(@Cast("cv::videostab::MotionModel") int model/*=cv::videostab::MM_SIMILARITY*/);
    public LpMotionStabilizer() { allocate(); }
    private native void allocate();

    public native void setMotionModel(@Cast("cv::videostab::MotionModel") int val);
    public native @Cast("cv::videostab::MotionModel") int motionModel();

    public native void setFrameSize(@ByVal Size val);
    public native @ByVal Size frameSize();

    public native void setTrimRatio(float val);
    public native float trimRatio();

    public native void setWeight1(float val);
    public native float weight1();

    public native void setWeight2(float val);
    public native float weight2();

    public native void setWeight3(float val);
    public native float weight3();

    public native void setWeight4(float val);
    public native float weight4();

    public native void stabilize(
                int size, @Const @ByRef MatVector motions, @ByVal IntIntPair range,
                Mat stabilizationMotions);
}

@Namespace("cv::videostab") public static native @ByVal Mat ensureInclusionConstraint(@Const @ByRef Mat M, @ByVal Size size, float trimRatio);

@Namespace("cv::videostab") public static native float estimateOptimalTrimRatio(@Const @ByRef Mat M, @ByVal Size size);

/** @} */

 // namespace videostab
 // namespace

// #endif


// Parsed from <opencv2/videostab/inpainting.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_INPAINTINT_HPP__
// #define __OPENCV_VIDEOSTAB_INPAINTINT_HPP__

// #include <vector>
// #include "opencv2/core.hpp"
// #include "opencv2/videostab/optical_flow.hpp"
// #include "opencv2/videostab/fast_marching.hpp"
// #include "opencv2/videostab/global_motion.hpp"
// #include "opencv2/photo.hpp"

/** @addtogroup videostab
 *  @{ */

@Namespace("cv::videostab") @NoOffset public static class InpainterBase extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public InpainterBase() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public InpainterBase(Pointer p) { super(p); }


    public native void setRadius(int val);
    public native int radius();

    public native void setMotionModel(@Cast("cv::videostab::MotionModel") int val);
    public native @Cast("cv::videostab::MotionModel") int motionModel();

    public native void inpaint(int idx, @ByRef Mat frame, @ByRef Mat mask);


    // data from stabilizer

    public native void setFrames(@Const @ByRef MatVector val);
    public native @Const @ByRef MatVector frames();

    public native void setMotions(@Const @ByRef MatVector val);
    public native @Const @ByRef MatVector motions();

    public native void setStabilizedFrames(@Const @ByRef MatVector val);
    public native @Const @ByRef MatVector stabilizedFrames();

    public native void setStabilizationMotions(@Const @ByRef MatVector val);
    public native @Const @ByRef MatVector stabilizationMotions();
}

@Namespace("cv::videostab") public static class NullInpainter extends InpainterBase {
    static { Loader.load(); }
    /** Default native constructor. */
    public NullInpainter() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public NullInpainter(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NullInpainter(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public NullInpainter position(int position) {
        return (NullInpainter)super.position(position);
    }

    public native void inpaint(int arg0, @ByRef Mat arg1, @ByRef Mat arg2);
}

@Namespace("cv::videostab") public static class InpaintingPipeline extends InpainterBase {
    static { Loader.load(); }
    /** Default native constructor. */
    public InpaintingPipeline() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public InpaintingPipeline(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public InpaintingPipeline(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public InpaintingPipeline position(int position) {
        return (InpaintingPipeline)super.position(position);
    }

    public native void pushBack(@Ptr InpainterBase inpainter);
    public native @Cast("bool") boolean empty();

    public native void setRadius(int val);
    public native void setMotionModel(@Cast("cv::videostab::MotionModel") int val);
    public native void setFrames(@Const @ByRef MatVector val);
    public native void setMotions(@Const @ByRef MatVector val);
    public native void setStabilizedFrames(@Const @ByRef MatVector val);
    public native void setStabilizationMotions(@Const @ByRef MatVector val);

    public native void inpaint(int idx, @ByRef Mat frame, @ByRef Mat mask);
}

@Namespace("cv::videostab") @NoOffset public static class ConsistentMosaicInpainter extends InpainterBase {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ConsistentMosaicInpainter(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public ConsistentMosaicInpainter(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public ConsistentMosaicInpainter position(int position) {
        return (ConsistentMosaicInpainter)super.position(position);
    }

    public ConsistentMosaicInpainter() { allocate(); }
    private native void allocate();

    public native void setStdevThresh(float val);
    public native float stdevThresh();

    public native void inpaint(int idx, @ByRef Mat frame, @ByRef Mat mask);
}

@Namespace("cv::videostab") @NoOffset public static class MotionInpainter extends InpainterBase {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MotionInpainter(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public MotionInpainter(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public MotionInpainter position(int position) {
        return (MotionInpainter)super.position(position);
    }

    public MotionInpainter() { allocate(); }
    private native void allocate();

    public native void setOptFlowEstimator(@Ptr IDenseOptFlowEstimator val);
    public native @Ptr IDenseOptFlowEstimator optFlowEstimator();

    public native void setFlowErrorThreshold(float val);
    public native float flowErrorThreshold();

    public native void setDistThreshold(float val);
    public native float distThresh();

    public native void setBorderMode(int val);
    public native int borderMode();

    public native void inpaint(int idx, @ByRef Mat frame, @ByRef Mat mask);
}

@Namespace("cv::videostab") @NoOffset public static class ColorAverageInpainter extends InpainterBase {
    static { Loader.load(); }
    /** Default native constructor. */
    public ColorAverageInpainter() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public ColorAverageInpainter(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ColorAverageInpainter(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public ColorAverageInpainter position(int position) {
        return (ColorAverageInpainter)super.position(position);
    }

    public native void inpaint(int idx, @ByRef Mat frame, @ByRef Mat mask);
}

@Namespace("cv::videostab") @NoOffset public static class ColorInpainter extends InpainterBase {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ColorInpainter(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public ColorInpainter(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public ColorInpainter position(int position) {
        return (ColorInpainter)super.position(position);
    }

    public ColorInpainter(int method/*=cv::INPAINT_TELEA*/, double radius/*=2.*/) { allocate(method, radius); }
    private native void allocate(int method/*=cv::INPAINT_TELEA*/, double radius/*=2.*/);
    public ColorInpainter() { allocate(); }
    private native void allocate();

    public native void inpaint(int idx, @ByRef Mat frame, @ByRef Mat mask);
}



@Namespace("cv::videostab") public static native void calcFlowMask(
        @Const @ByRef Mat flowX, @Const @ByRef Mat flowY, @Const @ByRef Mat errors, float maxError,
        @Const @ByRef Mat mask0, @Const @ByRef Mat mask1, @ByRef Mat flowMask);

@Namespace("cv::videostab") public static native void completeFrameAccordingToFlow(
        @Const @ByRef Mat flowMask, @Const @ByRef Mat flowX, @Const @ByRef Mat flowY, @Const @ByRef Mat frame1, @Const @ByRef Mat mask1,
        float distThresh, @ByRef Mat frame0, @ByRef Mat mask0);

/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab/deblurring.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_DEBLURRING_HPP__
// #define __OPENCV_VIDEOSTAB_DEBLURRING_HPP__

// #include <vector>
// #include "opencv2/core.hpp"

/** @addtogroup videostab
 *  @{ */

@Namespace("cv::videostab") public static native float calcBlurriness(@Const @ByRef Mat frame);

@Namespace("cv::videostab") @NoOffset public static class DeblurerBase extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public DeblurerBase() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DeblurerBase(Pointer p) { super(p); }


    public native void setRadius(int val);
    public native int radius();

    public native void deblur(int idx, @ByRef Mat frame);


    // data from stabilizer

    public native void setFrames(@Const @ByRef MatVector val);
    public native @Const @ByRef MatVector frames();

    public native void setMotions(@Const @ByRef MatVector val);
    public native @Const @ByRef MatVector motions();

    public native void setBlurrinessRates(@StdVector FloatPointer val);
    public native void setBlurrinessRates(@StdVector FloatBuffer val);
    public native void setBlurrinessRates(@StdVector float[] val);
    public native @StdVector FloatPointer blurrinessRates();
}

@Namespace("cv::videostab") public static class NullDeblurer extends DeblurerBase {
    static { Loader.load(); }
    /** Default native constructor. */
    public NullDeblurer() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public NullDeblurer(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NullDeblurer(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public NullDeblurer position(int position) {
        return (NullDeblurer)super.position(position);
    }

    public native void deblur(int arg0, @ByRef Mat arg1);
}

@Namespace("cv::videostab") @NoOffset public static class WeightingDeblurer extends DeblurerBase {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public WeightingDeblurer(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public WeightingDeblurer(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public WeightingDeblurer position(int position) {
        return (WeightingDeblurer)super.position(position);
    }

    public WeightingDeblurer() { allocate(); }
    private native void allocate();

    public native void setSensitivity(float val);
    public native float sensitivity();

    public native void deblur(int idx, @ByRef Mat frame);
}

/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab/wobble_suppression.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_WOBBLE_SUPPRESSION_HPP__
// #define __OPENCV_VIDEOSTAB_WOBBLE_SUPPRESSION_HPP__

// #include <vector>
// #include "opencv2/core.hpp"
// #include "opencv2/core/cuda.hpp"
// #include "opencv2/videostab/global_motion.hpp"
// #include "opencv2/videostab/log.hpp"

/** @addtogroup videostab
 *  @{ */

@Namespace("cv::videostab") @NoOffset public static class WobbleSuppressorBase extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public WobbleSuppressorBase() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public WobbleSuppressorBase(Pointer p) { super(p); }


    public native void setMotionEstimator(@Ptr ImageMotionEstimatorBase val);
    public native @Ptr ImageMotionEstimatorBase motionEstimator();

    public native void suppress(int idx, @Const @ByRef Mat frame, @ByRef Mat result);


    // data from stabilizer

    public native void setFrameCount(int val);
    public native int frameCount();

    public native void setMotions(@Const @ByRef MatVector val);
    public native @Const @ByRef MatVector motions();

    public native void setMotions2(@Const @ByRef MatVector val);
    public native @Const @ByRef MatVector motions2();

    public native void setStabilizationMotions(@Const @ByRef MatVector val);
    public native @Const @ByRef MatVector stabilizationMotions();
}

@Namespace("cv::videostab") public static class NullWobbleSuppressor extends WobbleSuppressorBase {
    static { Loader.load(); }
    /** Default native constructor. */
    public NullWobbleSuppressor() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public NullWobbleSuppressor(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NullWobbleSuppressor(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public NullWobbleSuppressor position(int position) {
        return (NullWobbleSuppressor)super.position(position);
    }

    public native void suppress(int idx, @Const @ByRef Mat frame, @ByRef Mat result);
}

@Namespace("cv::videostab") @NoOffset public static class MoreAccurateMotionWobbleSuppressorBase extends WobbleSuppressorBase {
    static { Loader.load(); }
    /** Empty constructor. */
    public MoreAccurateMotionWobbleSuppressorBase() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MoreAccurateMotionWobbleSuppressorBase(Pointer p) { super(p); }

    public native void setPeriod(int val);
    public native int period();
}

@Namespace("cv::videostab") public static class MoreAccurateMotionWobbleSuppressor extends MoreAccurateMotionWobbleSuppressorBase {
    static { Loader.load(); }
    /** Default native constructor. */
    public MoreAccurateMotionWobbleSuppressor() { allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public MoreAccurateMotionWobbleSuppressor(int size) { allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MoreAccurateMotionWobbleSuppressor(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public MoreAccurateMotionWobbleSuppressor position(int position) {
        return (MoreAccurateMotionWobbleSuppressor)super.position(position);
    }

    public native void suppress(int idx, @Const @ByRef Mat frame, @ByRef Mat result);
}

// #if defined(HAVE_OPENCV_CUDAWARPING)
// #endif

/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab/stabilizer.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_STABILIZER_HPP__
// #define __OPENCV_VIDEOSTAB_STABILIZER_HPP__

// #include <vector>
// #include <ctime>
// #include "opencv2/core.hpp"
// #include "opencv2/imgproc.hpp"
// #include "opencv2/videostab/global_motion.hpp"
// #include "opencv2/videostab/motion_stabilizing.hpp"
// #include "opencv2/videostab/frame_source.hpp"
// #include "opencv2/videostab/log.hpp"
// #include "opencv2/videostab/inpainting.hpp"
// #include "opencv2/videostab/deblurring.hpp"
// #include "opencv2/videostab/wobble_suppression.hpp"

/** @addtogroup videostab
 *  @{ */

@Namespace("cv::videostab") @NoOffset public static class StabilizerBase extends Pointer {
    static { Loader.load(); }
    /** Empty constructor. */
    public StabilizerBase() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StabilizerBase(Pointer p) { super(p); }


    public native void setLog(@Ptr ILog ilog);
    public native @Ptr ILog log();

    public native void setRadius(int val);
    public native int radius();

    public native void setFrameSource(@Ptr IFrameSource val);
    public native @Ptr IFrameSource frameSource();

    public native void setMotionEstimator(@Ptr ImageMotionEstimatorBase val);
    public native @Ptr ImageMotionEstimatorBase motionEstimator();

    public native void setDeblurer(@Ptr DeblurerBase val);
    public native @Ptr DeblurerBase deblurrer();

    public native void setTrimRatio(float val);
    public native float trimRatio();

    public native void setCorrectionForInclusion(@Cast("bool") boolean val);
    public native @Cast("bool") boolean doCorrectionForInclusion();

    public native void setBorderMode(int val);
    public native int borderMode();

    public native void setInpainter(@Ptr InpainterBase val);
    public native @Ptr InpainterBase inpainter();
}

@Namespace("cv::videostab") @NoOffset public static class OnePassStabilizer extends StabilizerBase {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public OnePassStabilizer(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public OnePassStabilizer(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public OnePassStabilizer position(int position) {
        return (OnePassStabilizer)super.position(position);
    }
    public IFrameSource asIFrameSource() { return asIFrameSource(this); }
    @Namespace public static native @Name("static_cast<cv::videostab::IFrameSource*>") IFrameSource asIFrameSource(OnePassStabilizer pointer);

    public OnePassStabilizer() { allocate(); }
    private native void allocate();

    public native void setMotionFilter(@Ptr MotionFilterBase val);
    public native @Ptr MotionFilterBase motionFilter();

    public native void reset();
    public native @ByVal Mat nextFrame();
}

@Namespace("cv::videostab") @NoOffset public static class TwoPassStabilizer extends StabilizerBase {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TwoPassStabilizer(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(int)}. */
    public TwoPassStabilizer(int size) { allocateArray(size); }
    private native void allocateArray(int size);
    @Override public TwoPassStabilizer position(int position) {
        return (TwoPassStabilizer)super.position(position);
    }
    public IFrameSource asIFrameSource() { return asIFrameSource(this); }
    @Namespace public static native @Name("static_cast<cv::videostab::IFrameSource*>") IFrameSource asIFrameSource(TwoPassStabilizer pointer);

    public TwoPassStabilizer() { allocate(); }
    private native void allocate();

    public native void setMotionStabilizer(@Ptr IMotionStabilizer val);
    public native @Ptr IMotionStabilizer motionStabilizer();

    public native void setWobbleSuppressor(@Ptr WobbleSuppressorBase val);
    public native @Ptr WobbleSuppressorBase wobbleSuppressor();

    public native void setEstimateTrimRatio(@Cast("bool") boolean val);
    public native @Cast("bool") boolean mustEstimateTrimaRatio();

    public native void reset();
    public native @ByVal Mat nextFrame();
}

/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab/ring_buffer.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_RING_BUFFER_HPP__
// #define __OPENCV_VIDEOSTAB_RING_BUFFER_HPP__

// #include <vector>
// #include "opencv2/imgproc.hpp"

/** @addtogroup videostab
 *  @{ */

/** @} */

 // namespace videostab
 // namespace cv

// #endif


// Parsed from <opencv2/videostab.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009-2011, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_VIDEOSTAB_HPP__
// #define __OPENCV_VIDEOSTAB_HPP__

/**
  @defgroup videostab Video Stabilization

The video stabilization module contains a set of functions and classes that can be used to solve the
problem of video stabilization. There are a few methods implemented, most of them are descibed in
the papers @cite OF06 and @cite G11 . However, there are some extensions and deviations from the orginal
paper methods.

### References

 1. "Full-Frame Video Stabilization with Motion Inpainting"
     Yasuyuki Matsushita, Eyal Ofek, Weina Ge, Xiaoou Tang, Senior Member, and Heung-Yeung Shum
 2. "Auto-Directed Video Stabilization with Robust L1 Optimal Camera Paths"
     Matthias Grundmann, Vivek Kwatra, Irfan Essa

     @{
         @defgroup videostab_motion Global Motion Estimation

The video stabilization module contains a set of functions and classes for global motion estimation
between point clouds or between images. In the last case features are extracted and matched
internally. For the sake of convenience the motion estimation functions are wrapped into classes.
Both the functions and the classes are available.

         @defgroup videostab_marching Fast Marching Method

The Fast Marching Method @cite Telea04 is used in of the video stabilization routines to do motion and
color inpainting. The method is implemented is a flexible way and it's made public for other users.

     @}

*/

// #include "opencv2/videostab/stabilizer.hpp"
// #include "opencv2/videostab/ring_buffer.hpp"

// #endif


}