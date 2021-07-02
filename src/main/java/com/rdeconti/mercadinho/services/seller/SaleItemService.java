package com.rdeconti.mercadinho.services.seller;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.seller.SaleItemModel;
import com.rdeconti.mercadinho.repositories.seller.SaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleItemService {

    @Autowired
    private SaleItemRepository saleItemRepository;

    private boolean existsById(Long id) {
        return saleItemRepository.existsById(id);
    }

    public SaleItemModel findById(Long id) throws ResourceNotFoundException {

        SaleItemModel saleItem = saleItemRepository.findById(id).orElse(null);

        if (saleItem==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return saleItem;
    }

    public List<SaleItemModel> findAll(int pageNumber, int rowPerPage) {

        List<SaleItemModel> saleItems = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        saleItemRepository.findAll(sortedByIdAsc).forEach(saleItems::add);

        return saleItems;
    }

    public SaleItemModel save(SaleItemModel saleItem) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(saleItem.getId())) {

            if (saleItem.getId() != null && existsById(saleItem.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + saleItem.getId() +
                        " já existe");
            }

            return saleItemRepository.save(saleItem);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(SaleItemModel saleItem)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(saleItem.getId())) {

            if (!existsById(saleItem.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + saleItem.getId());
            }

            saleItemRepository.save(saleItem);
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
            saleItemRepository.deleteById(id);
        }
    }

    public Long count() {
        return saleItemRepository.count();
    }
}
