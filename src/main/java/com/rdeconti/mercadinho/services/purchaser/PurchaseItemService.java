package com.rdeconti.mercadinho.services.purchaser;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.purchaser.PurchaseItemModel;
import com.rdeconti.mercadinho.repositories.purchaser.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseItemService {

    // -----------------------------------------------------------------------------------------------------------------
    // Resolve and inject collaborating beans into our bean
    // -----------------------------------------------------------------------------------------------------------------
    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

    private boolean existsById(Long id) {
        return purchaseItemRepository.existsById(id);
    }

    public PurchaseItemModel findById(Long id) throws ResourceNotFoundException {

        PurchaseItemModel purchaseItem = purchaseItemRepository.findById(id).orElse(null);

        if (purchaseItem==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return purchaseItem;
    }

    public List<PurchaseItemModel> findAll(int pageNumber, int rowPerPage) {

        List<PurchaseItemModel> purchaseItems = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        purchaseItemRepository.findAll(sortedByIdAsc).forEach(purchaseItems::add);

        return purchaseItems;
    }

    public PurchaseItemModel save(PurchaseItemModel purchaseItem) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(purchaseItem.getId())) {

            if (purchaseItem.getId() != null && existsById(purchaseItem.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + purchaseItem.getId() +
                        " já existe");
            }

            return purchaseItemRepository.save(purchaseItem);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(PurchaseItemModel purchaseItem)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(purchaseItem.getId())) {

            if (!existsById(purchaseItem.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + purchaseItem.getId());
            }

            purchaseItemRepository.save(purchaseItem);
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
            purchaseItemRepository.deleteById(id);
        }
    }

    public Long count() {
        return purchaseItemRepository.count();
    }
}
