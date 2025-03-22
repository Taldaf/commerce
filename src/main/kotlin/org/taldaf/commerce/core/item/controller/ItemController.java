package org.taldaf.commerce.core.item.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.taldaf.commerce.core.item.model.ItemDto;
import org.taldaf.commerce.core.item.service.ItemQueryService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemQueryService itemQueryService;

    @GetMapping("/item/{itemId}")
    public ItemDto getItem(@PathVariable Long itemId) {
        return itemQueryService.getItem(itemId);
    }
}
