package org.taldaf.commerce.core.item.service;

import org.taldaf.commerce.core.item.model.ItemDto;

public interface ItemQueryService {

    ItemDto getItem(Long itemId);
}
