/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.broadleafcommerce.core.catalog.dao;

import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository("blProductOptionDao")
public class ProductOptionDaoImpl implements ProductOptionDao {
    
    @PersistenceContext(unitName="blPU")
    protected EntityManager em;

    @Resource(name="blEntityConfiguration")
    protected EntityConfiguration entityConfiguration;
    
    @Override
    public List<ProductOption> readAllProductOptions() {
        TypedQuery<ProductOption> query = em.createNamedQuery("BC_READ_ALL_PRODUCT_OPTIONS", ProductOption.class);
        return query.getResultList();
    }

    @Override
    public ProductOption readProductOptionById(Long id) {
        return (ProductOption) em.find(ProductOptionImpl.class, id);
    }

    @Override
    public ProductOptionValue readProductOptionValueById(Long id) {
        return (ProductOptionValue) em.find(ProductOptionValueImpl.class, id);
    }

}
