package com.bank.history.converter;

import com.bank.history.mapper.HistoryMapper;
import com.bank.history.model.HistoryDto;
import com.bank.history.repository.HistoryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Data
public class HistoryConverter {
    private final HistoryRepository historyRepository;

    private HistoryMapper historyMapper;

    public List<HistoryDto> convertAll(List<Long> ids, String exception) {

        return ids.stream()
                .map(id -> historyRepository.findById(id)
                        .orElseThrow(
                                () -> new EntityNotFoundException(exception + id)))
                .map(historyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Autowired
    public void setHistoryMapper(HistoryMapper historyMapper) {
        this.historyMapper = historyMapper;
    }
}
