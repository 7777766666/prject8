package com.bank.history.service;

import com.bank.history.model.HistoryDto;
import com.bank.history.model.HistoryEntity;

import java.util.List;

/**
 * сервис для {@link HistoryEntity} и {@link HistoryDto}.
 */
public interface HistoryService {

    /**
     * @param history лист технических идентификаторов {@link HistoryEntity}.
     * @return {@link HistoryDto}.
     */
    HistoryDto save(HistoryDto history);

    /**
     * @param id технический идентификатор принимаем {@link HistoryEntity}.
     * @return {@link HistoryDto}.
     */
    HistoryDto findById(Long id);

    /**
     * @param id технический идентификатор принимаем {@link HistoryEntity}.
     * @param history {@link HistoryDto}.
     * @return {@link HistoryDto}.
     */
    HistoryDto update(Long id, HistoryDto history);

    /**
     * @param ids принимаем лист технических идентификаторов {@link HistoryEntity}.
     * @return лист {@link HistoryDto}.
     */
    List<HistoryDto> findAllById(List<Long> ids);
}
