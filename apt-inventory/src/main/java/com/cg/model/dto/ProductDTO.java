package com.cg.model.dto;

import com.cg.model.*;
import com.cg.model.enums.EBussinessStatus;
import com.cg.utils.JsonToMapConverter;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDTO implements Serializable {

    private String id;

//    @NotBlank(message = "Name is required")
    private String title;

    private BigDecimal purchaseOrderPrice;

    @NotBlank(message = "Description is required")
    private String description;

//    private List<ComputerConfigurationParameter> computerConfigurationParameters;

    private String configurationDetail;

    private String blogId;

    private String fileName;

    private String fileFolder;

    private String fileUrl;

    private String cloudId;

    private String fileProductId;

    private List<MultipartFile> files;

    private MultipartFile file;

    private String fileType;

    public ProductDTO(String id, String title, BigDecimal purchaseOrderPrice, String description) {
        this.id = id;
        this.title = title;
        this.purchaseOrderPrice = purchaseOrderPrice;
        this.description = description;
    }

    public Product toProduct() {
        return new Product()
                .setId(id)
                .setTitle(title)
                .setPurchaseOrderPrice(purchaseOrderPrice)
                .setConfigurationDetail(JsonToMapConverter.convertToDatabaseColumn(configurationDetail))
                .setDescription(description)
                .setBussinessStatus(EBussinessStatus.NEW_RELEASES);
    }

    public ProductMedia toProductMedia(Product product) {
        return new ProductMedia()
                .setId(fileProductId)
                .setFileName(fileName)
                .setFileFolder(fileFolder)
                .setFileUrl(fileUrl)
                .setCloudId(cloudId)
                .setFileType(fileType)
                .setProduct(product);
    }
}
