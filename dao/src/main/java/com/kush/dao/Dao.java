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


import com.google.common.util.concurrent.ListenableFuture;
import com.kush.common.EntityType;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface Dao<T> {

    List<T> find(UUID id);

    T findById(UUID id);

    ListenableFuture<T> findByIdAsync(UUID id);

    boolean existsById(UUID id);

    ListenableFuture<Boolean> existsByIdAsync(UUID id);

    T save(UUID id, T t);

    T saveAndFlush(UUID id, T t);

    void removeById(UUID id);

    void removeAllByIds(Collection<UUID> ids);

    List<UUID> findIdsByUUIDAndIdOffset(UUID id, UUID idOffset, int limit);

    default EntityType getEntityType() { return null; }


}
