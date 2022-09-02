//package com.cg.service;
//
//
//import com.cg.exception.DataInputException;
//import com.cg.model.ProductDemo;
//import com.cg.model.ProductMediaDemo;
//import com.cg.model.dto.IProductDTO;
//import com.cg.model.dto.ProductDTO;
//import com.cg.model.enums.FileType;
//import com.cg.repository.ProductMediaRepository;
//import com.cg.repository.ProductRepository;
//import com.cg.utils.UploadUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.IOException;
//import java.util.Map;
//import java.util.Optional;
//
//
//@Service
//@Transactional
//public class ProductServiceImpl implements ProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private ProductMediaRepository productMediaRepository;
//
//    @Autowired
//    private UploadService uploadService;
//
//    @Autowired
//    private UploadUtils uploadUtils;
//
//
//    @Override
//    public Iterable<ProductDemo> findAll() {
//        return productRepository.findAll();
//    }
//
//    @Override
//    public Iterable<IProductDTO> findAllIProductDTO() {
//        return productRepository.findAllIProductDTO();
//    }
//
//    @Override
//    public Optional<ProductDemo> findById(String id) {
//        return productRepository.findById(id);
//    }
//
//    @Override
//    public ProductDemo create(ProductDTO productDTO) {
//
//        String fileType = productDTO.getFile().getContentType();
//
//        assert fileType != null;
//
//        fileType = fileType.substring(0, 5);
//
//        productDTO.setFileType(fileType);
//
//        ProductDemo productDemo = productRepository.save(productDTO.toProduct());
//
//        ProductMediaDemo productMediaDemo = productMediaRepository.save(productDTO.toProductMedia());
//
//        if (fileType.equals(FileType.IMAGE.getValue())) {
//            uploadAndSaveProductImage(productDTO, productDemo, productMediaDemo);
//        }
//
//        if (fileType.equals(FileType.VIDEO.getValue())) {
//            uploadAndSaveProductVideo(productDTO, productDemo, productMediaDemo);
//        }
//
//        return productDemo;
//    }
//
//
//    @Override
//    public IProductDTO findIProductDTOById(String id) {
//        return productRepository.findIProductDTOById(id);
//    }
//
//    private void uploadAndSaveProductImage(ProductDTO productDTO, ProductDemo productDemo, ProductMediaDemo productMediaDemo) {
//        try {
//            Map uploadResult = uploadService.uploadImage(productDTO.getFile(), uploadUtils.buildImageUploadParams(productMediaDemo));
//            String fileUrl = (String) uploadResult.get("secure_url");
//            String fileFormat = (String) uploadResult.get("format");
//
//            productMediaDemo.setFileName(productMediaDemo.getId() + "." + fileFormat);
//            productMediaDemo.setFileUrl(fileUrl);
//            productMediaDemo.setFileFolder(UploadUtils.IMAGE_UPLOAD_FOLDER);
//            productMediaDemo.setCloudId(productMediaDemo.getFileFolder() + "/" + productMediaDemo.getId());
//            productMediaDemo.setProductDemo(productDemo);
//            productMediaRepository.save(productMediaDemo);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new DataInputException("Upload hình ảnh thất bại");
//        }
//    }
//
//    private void uploadAndSaveProductVideo(ProductDTO productDTO, ProductDemo productDemo, ProductMediaDemo productMediaDemo) {
//        try {
//            Map uploadResult = uploadService.uploadVideo(productDTO.getFile(), uploadUtils.buildVideoUploadParams(productMediaDemo));
//            String fileUrl = (String) uploadResult.get("secure_url");
//            String fileFormat = (String) uploadResult.get("format");
//
//            productMediaDemo.setFileName(productMediaDemo.getId() + "." + fileFormat);
//            productMediaDemo.setFileUrl(fileUrl);
//            productMediaDemo.setFileFolder(UploadUtils.VIDEO_UPLOAD_FOLDER);
//            productMediaDemo.setCloudId(productMediaDemo.getFileFolder() + "/" + productMediaDemo.getId());
//            productMediaDemo.setProductDemo(productDemo);
//            productMediaRepository.save(productMediaDemo);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new DataInputException("Upload video thất bại");
//        }
//    }
//
//    @Override
//    public void delete(ProductDemo productDemo) throws IOException {
//
//        Optional<ProductMediaDemo> productImageVideo = productMediaRepository.findByProduct(productDemo);
//
//        if (productImageVideo.isPresent()) {
//            String publicId = productImageVideo.get().getCloudId();
//
//            if (productImageVideo.get().getFileType().equals(FileType.IMAGE.getValue())) {
//                uploadService.destroyImage(publicId, uploadUtils.buildImageDestroyParams(productDemo, publicId));
//            }
//
//            if (productImageVideo.get().getFileType().equals(FileType.VIDEO.getValue())) {
//                uploadService.destroyVideo(publicId, uploadUtils.buildVideoDestroyParams(productDemo, publicId));
//            }
//
//            productMediaRepository.delete(productImageVideo.get());
//        }
//
//        productRepository.delete(productDemo);
//
//    }
//}
