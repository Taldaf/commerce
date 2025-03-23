package org.taldaf.commerce.core.item.controller

import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.taldaf.commerce.core.item.model.ItemDto
import org.taldaf.commerce.core.item.service.ItemQueryService

@Slf4j
@RestController
@RequiredArgsConstructor
class ItemController(
    private val itemQueryService: ItemQueryService
) {
    @GetMapping("/item")
    fun getItemList(pageable: Pageable): List<ItemDto> {
        return itemQueryService.getItemList(pageable)
    }


    @GetMapping("/item/{itemId}")
    fun getItem(@PathVariable itemId: Long): ItemDto {
        return itemQueryService.getItem(itemId)
    }
}

