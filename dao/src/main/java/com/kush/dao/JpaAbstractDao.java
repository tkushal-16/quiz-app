/**
 * Copyright © 2016-2026 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kush.dao;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.google.common.util.concurrent.ListenableFuture;
import com.kush.dao.model.BaseEntity;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public abstract class JpaAbstractDao<E extends BaseEntity<D>, D> implements Dao<D> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;


    @Transactional
    @Override
    public D save(UUID id, D domain) {
        return save(id, domain, false);
    }

    private D save(UUID id, D domain, boolean flush) {
        E entity;
        try {
            entity = getEntityClass().getConstructor(domain.getClass()).newInstance(domain);
        } catch (Exception e) {
            log.error("Can't create entity for domain object {}", domain, e);
            throw new IllegalArgumentException("Can't create entity for domain object {" + domain + "}", e);
        }
        log.debug("Saving entity {}", entity);
        boolean isNew = entity.getUuid() == null;
        if (isNew) {
            entity.setCreatedTime(System.currentTimeMillis());
        } else {
            if (entity.getCreatedTime() == 0) {
                if (entity.getUuid().version() == 1) {
                    entity.setCreatedTime(Uuids.unixTimestamp(entity.getUuid()));
                } else {
                    entity.setCreatedTime(System.currentTimeMillis());
                }
            }
        }
        try {
            entity = doSave(entity, isNew, flush);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return DaoUtil.getData(entity);
    }

    protected E doSave(E entity, boolean isNew, boolean flush) {
        boolean flushed = false;
        return entity;
    }


    @Transactional
    @Override
    public D saveAndFlush(UUID id, D domain) {
        return save(id, domain, true);
    }

    @Override
    public D findById(UUID id, UUID key) {
        log.debug("Get entity by key {}", key);
        Optional<E> entity = getRepository().findById(key);
        return DaoUtil.getData(entity);
    }

//    @Override
//    public ListenableFuture<D> findByIdAsync(UUID id, UUID key) {
//        log.debug("Get entity by key async {}", key);
//        return service.submit(() -> DaoUtil.getData(getRepository().findById(key)));
//    }

    @Override
    public boolean existsById(UUID id, UUID key) {
        log.debug("Exists by key {}", key);
        return getRepository().existsById(key);
    }

//    @Override
//    public ListenableFuture<Boolean> existsByIdAsync(UUID id, UUID key) {
//        log.debug("Exists by key async {}", key);
//        return service.submit(() -> getRepository().existsById(key));
//    }

    @Transactional
    @Override
    public void removeById(UUID id) {
        JpaRepository<E, UUID> repository = getRepository();
        repository.deleteById(id);
        repository.flush();
        log.debug("Remove request: {}", id);
    }

    @Transactional
    @Override
    public void removeAllByIds(Collection<UUID> ids) {
        JpaRepository<E, UUID> repository = getRepository();
        ids.forEach(repository::deleteById);
        repository.flush();
    }

    @Override
    public List<D> find(UUID id) {
        List<E> entities = Lists.newArrayList(getRepository().findAll());
        return DaoUtil.convertDataList(entities);
    }



//    protected String getidColumn() {
//        return ModelConstants.TENANT_ID_COLUMN;
//    }

//    protected EntityManager getEntityManager() {
//        return entityManager;
//    }

    protected JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    protected abstract Class<E> getEntityClass();

    protected abstract JpaRepository<E, UUID> getRepository();

}
