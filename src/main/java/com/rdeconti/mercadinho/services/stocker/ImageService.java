package com.rdeconti.mercadinho.services.stocker;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.ImageModel;
import com.rdeconti.mercadinho.repositories.stocker.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private ImageRepository imageRepository;

    private boolean existsById(Long id) {
        return imageRepository.existsById(id);
    }

    public ImageModel findById(Long id) throws ResourceNotFoundException {

        ImageModel image = imageRepository.findById(id).orElse(null);

        if (image==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return image;
    }

    public List<ImageModel> findAll(int pageNumber, int rowPerPage) {

        List<ImageModel> images = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        imageRepository.findAll(sortedByIdAsc).forEach(images::add);

        return images;
    }

    public ImageModel save(ImageModel image) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(image.getId())) {

            if (image.getId() != null && existsById(image.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + image.getId() +
                        " já existe");
            }

            return imageRepository.save(image);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(ImageModel image)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(image.getId())) {

            if (!existsById(image.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + image.getId());
            }

            imageRepository.save(image);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar informação");
            badResourceException.addErrorMessage("Informação não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void deleteById(Long id) throws ResourceNotFoundException {

        if (!existsById(id)) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else {
            imageRepository.deleteById(id);
        }
    }

    public Long count() {
        return imageRepository.count();
    }
}
