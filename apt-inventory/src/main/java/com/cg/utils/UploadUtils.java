//package com.cg.utils;
//
//import com.cg.exception.DataInputException;
//import com.cg.model.ProductDemo;
//import com.cg.model.ProductMediaDemo;
//import com.cloudinary.utils.ObjectUtils;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//public class UploadUtils {
//    public static final String IMAGE_UPLOAD_FOLDER = "product_images";
//    public static final String VIDEO_UPLOAD_FOLDER = "product_videos";
//
//    public Map buildImageUploadParams(ProductMediaDemo productMediaDemo) {
//        if (productMediaDemo == null || productMediaDemo.getId() == null)
//            throw new DataInputException("Không thể upload hình ảnh của sản phẩm chưa được lưu");
//
//        String publicId = String.format("%s/%s", IMAGE_UPLOAD_FOLDER, productMediaDemo.getId());
//
//        return ObjectUtils.asMap(
//                "public_id", publicId,
//                "overwrite", true,
//                "resource_type", "image"
//        );
//    }
//
//    public Map buildImageDestroyParams(ProductDemo productDemo, String publicId) {
//        if (productDemo == null || productDemo.getId() == null)
//            throw new DataInputException("Không thể destroy hình ảnh của sản phẩm không xác định");
//
//        return ObjectUtils.asMap(
//                "public_id", publicId,
//                "overwrite", true,
//                "resource_type", "image"
//        );
//    }
//
//    public Map buildVideoUploadParams(ProductMediaDemo productMediaDemo) {
//        if (productMediaDemo == null || productMediaDemo.getId() == null)
//            throw new DataInputException("Không thể upload video của sản phẩm chưa được lưu");
//
//        String publicId = String.format("%s/%s", VIDEO_UPLOAD_FOLDER, productMediaDemo.getId());
//
//        return ObjectUtils.asMap(
//                "public_id", publicId,
//                "overwrite", true,
//                "resource_type", "video"
//        );
//    }
//
//    public Map buildVideoDestroyParams(ProductDemo productDemo, String publicId) {
//        if (productDemo == null || productDemo.getId() == null)
//            throw new DataInputException("Không thể destroy video của sản phẩm không xác định");
//
//        return ObjectUtils.asMap(
//                "public_id", publicId,
//                "overwrite", true,
//                "resource_type", "video"
//        );
//    }
//}
