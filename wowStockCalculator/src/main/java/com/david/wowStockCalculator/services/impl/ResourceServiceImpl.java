package com.david.wowStockCalculator.services.impl;

import com.david.wowStockCalculator.domain.entities.Resource;
import com.david.wowStockCalculator.domain.entities.Sale;
import com.david.wowStockCalculator.repositories.ResourceRepository;
import com.david.wowStockCalculator.repositories.SaleRepository;
import com.david.wowStockCalculator.services.ResourceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private ResourceRepository resourceRepository;
    private SaleRepository saleRepository;

    @Override
    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public List<Resource> findAll() {
        return StreamSupport.stream(resourceRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Resource> findById(Long resourceId) {
        return resourceRepository.findById(resourceId);
    }

    @Override
    public boolean isExists(Long id) {
        return resourceRepository.existsById(id);
    }

    @Override
    public Resource partialUpdate(Long id, Resource resourceEntity) {
        resourceEntity.setId(id);

        return resourceRepository.findById(id).map(existingResource -> {
            Optional.ofNullable(resourceEntity.getName()).ifPresent(existingResource::setName);
            Optional.ofNullable(resourceEntity.getOnStock()).ifPresent(existingResource::setOnStock);
            return resourceRepository.save(existingResource);
        }).orElseThrow(() -> new RuntimeException("Resource does not exists"));
    }

    @Override
    public void delete(Long id) {
        Resource resource = resourceRepository.findById(id).get();
        Iterable<Sale> sales = saleRepository.findAllByResourceId(resource.getId());
        sales.forEach(saleRepository::delete);
        resourceRepository.delete(resource);
    }


}
