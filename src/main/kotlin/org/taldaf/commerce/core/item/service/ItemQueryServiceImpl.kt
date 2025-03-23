package org.taldaf.commerce.core.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.taldaf.commerce.core.item.model.ItemDto;
import org.taldaf.commerce.core.item.repository.ItemRepository;

@Service
@RequiredArgsConstructor
public class ItemQueryServiceImpl implements ItemQueryService {

    private final ItemRepository itemRepository;

    @Override
    @Transactional(readOnly = true)
    public ItemDto getItem(Long itemId) {
        return itemRepository.findById(itemId)
                .map(ItemDto.Companion::fromEntity)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }
}
