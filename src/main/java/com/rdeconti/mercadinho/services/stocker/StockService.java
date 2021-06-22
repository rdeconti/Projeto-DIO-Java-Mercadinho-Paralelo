package com.rdeconti.mercadinho.services.stocker;

import com.rdeconti.mercadinho.exception.BadResourceException;
import com.rdeconti.mercadinho.exception.ResourceAlreadyExistsException;
import com.rdeconti.mercadinho.exception.ResourceNotFoundException;
import com.rdeconti.mercadinho.models.stocker.StockModel;
import com.rdeconti.mercadinho.repositories.stocker.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    private boolean existsById(Long id) {
        return stockRepository.existsById(id);
    }

    public StockModel findById(Long id) throws ResourceNotFoundException {

        StockModel stock = stockRepository.findById(id).orElse(null);

        if (stock==null) {
            throw new ResourceNotFoundException("Registro não encontrado com este ID " + id);
        }

        else return stock;
    }

    public List<StockModel> findAll(int pageNumber, int rowPerPage) {

        List<StockModel> stocks = new ArrayList<>();

        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, rowPerPage,
                Sort.by("id").ascending());

        stockRepository.findAll(sortedByIdAsc).forEach(stocks::add);

        return stocks;
    }

    public StockModel save(StockModel stock) throws BadResourceException, ResourceAlreadyExistsException {

        if (!ObjectUtils.isEmpty(stock.getId())) {

            if (stock.getId() != null && existsById(stock.getId())) {

                throw new ResourceAlreadyExistsException("Registro com este ID: " + stock.getId() +
                        " já existe");
            }

            return stockRepository.save(stock);
        }

        else {

            BadResourceException badResourceException = new BadResourceException("Falhou ao salvar registro");
            badResourceException.addErrorMessage("Registro não está vazia ou nula");
            throw badResourceException;
        }
    }

    public void update(StockModel stock)
            throws BadResourceException, ResourceNotFoundException {

        if (!ObjectUtils.isEmpty(stock.getId())) {

            if (!existsById(stock.getId())) {
                throw new ResourceNotFoundException("Registro não encontrado com este ID " + stock.getId());
            }

            stockRepository.save(stock);
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
            stockRepository.deleteById(id);
        }
    }

    public Long count() {
        return stockRepository.count();
    }
}