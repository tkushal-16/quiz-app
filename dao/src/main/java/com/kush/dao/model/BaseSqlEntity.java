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
package com.kush.dao.model;

import com.kush.dao.DaoUtil;
import com.kush.data.BaseData;
import com.kush.data.id.UUIDBased;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;
import java.util.function.Function;

@Data
@MappedSuperclass
public abstract class BaseSqlEntity<D> implements BaseEntity<D> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = ModelConstants.ID_PROPERTY, updatable = false, nullable = false)
    protected UUID id;

    @Column(name = ModelConstants.CREATED_TIME_PROPERTY, updatable = false)
    protected long createdTime;

    public BaseSqlEntity() {
    }

    public BaseSqlEntity(BaseData<?> domain) {
        this.id = domain.getUuidId();
        this.createdTime = domain.getCreatedTime();
    }

    public BaseSqlEntity(BaseSqlEntity<?> entity) {
        this.id = entity.id;
        this.createdTime = entity.createdTime;
    }

    @Override
    public UUID getUuid() {
        return id;
    }

    @Override
    public void setUuid(UUID id) {
        this.id = id;
    }

    @Override
    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        if (createdTime > 0) {
            this.createdTime = createdTime;
        }
    }

    protected static UUID getUuid(UUIDBased uuidBased) {
        if (uuidBased != null) {
            return uuidBased.getId();
        } else {
            return null;
        }
    }

    protected static <I> I getEntityId(UUID uuid, Function<UUID, I> creator) {
        return DaoUtil.toEntityId(uuid, creator);
    }

}
