package com.sjy.catalogservice.service;

import com.sjy.catalogservice.entity.Catalog;

public interface CatalogService {
    Iterable<Catalog> getAllCatalogs();
}