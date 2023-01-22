package com.bank.history.service;


import com.bank.history.converter.HistoryConverter;
import com.bank.history.mapper.HistoryMapper;
import com.bank.history.model.HistoryDto;
import com.bank.history.model.HistoryEntity;
import com.bank.history.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс сервисного слоя, реализующий {@link HistoryService}.
 */
@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;
    private final HistoryConverter historyConverter;
    private final static String EXCEPTION = "No history found with id: ";
    @Override
    public List<HistoryDto> findAllById(List<Long> ids) {
        return historyConverter.convertAll(ids, EXCEPTION);

    }



//        return ids.stream()
//                .map(id -> historyRepository.findById(id)
//                        .orElseThrow(
//                                () -> new EntityNotFoundException(EXCEPTION + id)))
//                .map(historyMapper::toDto)
//                .collect(Collectors.toList());
//    }
    /**
     * @param history {@link HistoryDto}.
     * @return historyDto {@link HistoryDto}.
     */
    @Override
    @Transactional
    public HistoryDto save(HistoryDto history) {
        HistoryEntity historyEntity = historyMapper.convertWithoutId(history, new HistoryEntity());
        return historyMapper.toDto(historyRepository.save(historyEntity));
    }

    /**
     * @param id технический идентификатор {@link HistoryDto}.
     * @return {@link HistoryDto}.
     */
    public HistoryDto findById(Long id) {
        return historyMapper.toDto(historyRepository
                .findById(id).orElseThrow(
                        () -> new EntityNotFoundException(EXCEPTION + id)));
    }

    /**
     * @param id принимаем лист технических идентификаторов {@link HistoryDto}.
     * @param history принимаем {@link HistoryDto}.
     * @return Возвращаем лист {@link HistoryDto}.
     */
    @Override
    @Transactional
    public HistoryDto update(Long id, HistoryDto history) {
        HistoryEntity historyEntity = historyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(EXCEPTION + id));
        return historyMapper.toDto(historyMapper.convertWithoutId(history, historyEntity));
    }

    /**
     * @param ids принимает лист технических идентификаторов {@link HistoryDto}.
     * @return возвращает лист {@link HistoryDto}.
     */
}
