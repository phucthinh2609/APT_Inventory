package com.cg.model.dto;

import com.cg.model.*;
import com.cg.model.enums.EBussinessStatus;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Data
public class ProductDTO implements Serializable {

    private String id;

//    @NotBlank(message = "Name is required")
    private String title;

    private BigDecimal purchaseOrderPrice;

    @NotBlank(message = "Description is required")
    private String description;

    private List<ComputerConfigurationParameter> computerConfigurationParameters;

    private String bussinessStatus;

    private String blogId;

    private String fileName;

    private String fileFolder;

    private String fileUrl;

    private String cloudId;

    private String fileProductId;

    private List<MultipartFile> files;

    private MultipartFile file;

    private String fileType;

    public Product toProduct() {
        return new Product()
                .setId(id)
                .setTitle(title)
                .setPurchaseOrderPrice(purchaseOrderPrice)
//                .setConfigurationDetail(JsonToMapConverter.convertToDatabaseColumn())
                .setDescription(description);
    }

    public ProductMedia toProductMedia() {
        return new ProductMedia()
                .setId(fileProductId)
                .setFileName(fileName)
                .setFileFolder(fileFolder)
                .setFileUrl(fileUrl)
                .setCloudId(cloudId)
                .setFileType(fileType);
    }
}
