package com.bank.history.mapper;

import com.bank.history.model.HistoryDto;
import com.bank.history.model.HistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

/**
 * Для конвертации {@link HistoryEntity} в {@link HistoryDto} и обратно.
 */
@Mapper(componentModel = "spring")
@Component
public interface HistoryMapper {

    /**
     * @param history принимаем {@link HistoryDto}.
     * @return {@link HistoryEntity}.
     */
    HistoryEntity toEntity(HistoryDto history);

    /**
     * @param historyEntity принимаем {@link HistoryEntity}.
     * @return {@link HistoryDto}.
     */
    HistoryDto toDto(HistoryEntity historyEntity);

    /**
     * игнорируем технический идентификатор при маппинге.
     * @param historyDto принимаем {@link HistoryDto}.
     * @param historyEntity принимаем {@link HistoryEntity}.
     * @return {@link HistoryEntity}.
     */
    @Mapping(target = "id", ignore = true)
    HistoryEntity convertWithoutId(HistoryDto historyDto, @MappingTarget HistoryEntity historyEntity);
}
