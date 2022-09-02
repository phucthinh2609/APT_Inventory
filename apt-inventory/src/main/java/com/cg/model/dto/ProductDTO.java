//package com.cg.model.dto;
//
//import com.cg.model.*;
//import lombok.Data;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.validation.constraints.NotBlank;
//import java.io.Serializable;
//
//
//@Data
//public class ProductDTO implements Serializable {
//
//    private String id;
//
//    @NotBlank(message = "Name is required")
//    private String name;
//
//    @NotBlank(message = "Description is required")
//    private String description;
//
//    private String fileName;
//
//    private String fileFolder;
//
//    private String fileUrl;
//
//    private String cloudId;
//
//    private String fileProductId;
//
//    private MultipartFile file;
//
//    private String fileType;
//
//    public ProductDemo toProduct() {
//        return new ProductDemo()
//                .setId(id)
//                .setName(name)
//                .setDescription(description);
//    }
//
//    public ProductMediaDemo toProductMedia() {
//        return new ProductMediaDemo()
//                .setId(fileProductId)
//                .setFileName(fileName)
//                .setFileFolder(fileFolder)
//                .setFileUrl(fileUrl)
//                .setCloudId(cloudId)
//                .setFileType(fileType);
//    }
//}
