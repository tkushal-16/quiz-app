package com.kush.dao;

import com.kush.dao.model.ToData;
import com.kush.data.id.UUIDBased;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class DaoUtil {

    private DaoUtil() {}

    public static <T> List<T> convertDataList(Collection<? extends ToData<T>> toConvert) {
        if (CollectionUtils.isEmpty(toConvert)) {
            return Collections.emptyList();
        }
        List<T> converted = new ArrayList<>(toConvert.size());
        for (ToData<T> object : toConvert) {
            if (object != null) {
                converted.add(object.toData());
            }
        }
        return converted;
    }

    public static <T> T getData(ToData<T> data) {
        T object = null;
        if (data != null) {
            object = data.toData();
        }
        return object;
    }

    public static <T> T getData(Optional<? extends ToData<T>> data) {
        T object = null;
        if (data.isPresent()) {
            object = data.get().toData();
        }
        return object;
    }

    public static UUID getId(UUIDBased idBased) {
        UUID id = null;
        if (idBased != null) {
            id = idBased.getId();
        }
        return id;
    }

    public static List<UUID> toUUIDs(List<? extends UUIDBased> idBasedIds) {
        List<UUID> ids = new ArrayList<>();
        for (UUIDBased idBased : idBasedIds) {
            ids.add(getId(idBased));
        }
        return ids;
    }

    public static <I> List<I> fromUUIDs(List<UUID> uuids, Function<UUID, I> mapper) {
        return uuids.stream().map(mapper).collect(Collectors.toList());
    }

    public static <I> I toEntityId(UUID uuid, Function<UUID, I> creator) {
        if (uuid != null) {
            return creator.apply(uuid);
        } else {
            return null;
        }
    }

//    public static <T> void processInBatches(Function<PageLink, PageData<T>> finder, int batchSize, Consumer<T> processor) {
//        processBatches(finder, batchSize, batch -> batch.getData().forEach(processor));
//    }
//
//    public static <T> void processBatches(Function<PageLink, PageData<T>> finder, int batchSize, Consumer<PageData<T>> processor) {
//        PageLink pageLink = new PageLink(batchSize);
//        PageData<T> batch;
//
//        boolean hasNextBatch;
//        do {
//            batch = finder.apply(pageLink);
//            processor.accept(batch);
//
//            hasNextBatch = batch.hasNext();
//            pageLink = pageLink.nextPageLink();
//        } while (hasNextBatch);
//    }

    public static String getStringId(UUIDBased id) {
        if (id != null) {
            return id.toString();
        } else {
            return null;
        }
    }

}
