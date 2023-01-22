package com.bank.history.controller;

import com.bank.history.model.HistoryDto;
import com.bank.history.model.HistoryEntity;
import com.bank.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * контроллер для {@link HistoryEntity}
 */
@RestController
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    /**
     * @param ids Принимаем лист технических идентификаторов {@link HistoryEntity}.
     * @return {@link ResponseEntity} с листом {@link HistoryDto}.
     */
    @GetMapping
    public ResponseEntity<List<HistoryDto>> findAllById(@RequestParam("ids") List<Long> ids) {
        return ResponseEntity.ok(historyService.findAllById(ids));
    }

    /**
     * @param id технический идентификатор {@link HistoryEntity}.
     * @return {@link ResponseEntity}.
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<HistoryDto> read(@PathVariable("id") Long id) {
        return ResponseEntity.ok(historyService.findById(id));
    }

    /**
     * @param history {@link HistoryDto}.
     * @return {@link ResponseEntity} {@link HistoryDto}.
     */

    @PostMapping(path = "/save")
    public ResponseEntity<HistoryDto> save(@RequestBody HistoryDto history) {
        return ResponseEntity.ok(historyService.save(history));
    }

    /**
     * @param id принимаем технический идентификатор {@link HistoryDto}.
     * @param history {@link HistoryDto}.
     * @return {@link ResponseEntity} с {@link HistoryDto}.
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<HistoryDto> update(@PathVariable("id") Long id, @RequestBody HistoryDto history) {
        return ResponseEntity.ok(historyService.update(id, history));
    }
}
