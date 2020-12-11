package com.vartdalen.imagestoresql.service;
import com.vartdalen.imagestoresql.model.Image;
import com.vartdalen.imagestoresql.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getImages() {
        return imageRepository.findAll();
    }

    public Optional<Image> getImageById(long id) {
        return imageRepository.findById(id);
    }

    public Image saveImage(Image image) {
        return imageRepository.save(validate(image));
    }

    public void deleteImageById(long id) {
        imageRepository.deleteById(id);
    }

    private Image validate(Image newImage) {
        Optional<Image> existingImage = getImageById(newImage.getId());
        return existingImage.orElse(newImage);
    }
}
